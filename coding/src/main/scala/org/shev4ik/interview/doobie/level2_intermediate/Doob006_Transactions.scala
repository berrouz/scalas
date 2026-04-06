package org.shev4ik.interview.doobie.level2_intermediate

/**
 * Doobie 006 - Transactions (boundaries, rollback, savepoints)
 *
 * In doobie, everything within a single ConnectionIO is executed in one
 * transaction. The Transactor handles commit on success and rollback on failure.
 * Savepoints allow partial rollback within a transaction.
 *
 * Here we model transaction semantics with a simplified in-memory database
 * to understand how doobie manages transaction boundaries.
 */
object Doob006_Transactions {

  // Simplified mutable database state
  class Database {
    private var state: Map[String, List[Map[String, Any]]] = Map.empty
    private var savepoints: List[(String, Map[String, List[Map[String, Any]]])] = Nil
    private var committed: Map[String, List[Map[String, Any]]] = Map.empty

    def getTable(name: String): List[Map[String, Any]] = state.getOrElse(name, Nil)
    def setTable(name: String, rows: List[Map[String, Any]]): Unit = { state = state + (name -> rows) }

    def createSavepoint(name: String): Unit = { savepoints = (name, state) :: savepoints }
    def rollbackToSavepoint(name: String): Unit = {
      savepoints.find(_._1 == name).foreach { case (_, savedState) =>
        state = savedState
        savepoints = savepoints.dropWhile(_._1 != name).drop(1)
      }
    }

    def commit(): Unit = { committed = state }
    def rollback(): Unit = { state = committed }
    def committedState: Map[String, List[Map[String, Any]]] = committed
    def currentState: Map[String, List[Map[String, Any]]] = state

    def reset(): Unit = { state = Map.empty; committed = Map.empty; savepoints = Nil }
  }

  // Transaction monad
  case class TxnIO[A](run: Database => A)

  object TxnIO {
    def pure[A](a: A): TxnIO[A] = TxnIO(_ => a)

    def transact[A](db: Database)(program: TxnIO[A]): Either[Throwable, A] = {
      try {
        val result = program.run(db)
        db.commit()
        Right(result)
      } catch {
        case e: Throwable =>
          db.rollback()
          Left(e)
      }
    }
  }

  implicit class TxnIOOps[A](val self: TxnIO[A]) extends AnyVal {
    def map[B](f: A => B): TxnIO[B] = TxnIO(db => f(self.run(db)))
    def flatMap[B](f: A => TxnIO[B]): TxnIO[B] = TxnIO(db => f(self.run(db)).run(db))
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a TxnIO that inserts a row and returns success.
  // TODO: Insert a row into "accounts" table, return the row count.
  // -------------------------------------------------------------------------
  def exercise1_insertInTransaction(id: Int, name: String, balance: Double): TxnIO[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Demonstrate atomic transaction - both inserts succeed or both fail.
  // TODO: Insert two rows into "accounts". If the second insert's balance
  // is negative, throw IllegalArgumentException("Negative balance").
  // Both inserts should be in the same TxnIO.
  // -------------------------------------------------------------------------
  def exercise2_atomicInserts(name1: String, bal1: Double, name2: String, bal2: Double): TxnIO[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement a transfer between two accounts.
  // TODO: Debit from account1 and credit to account2. If source balance
  // would go negative, throw IllegalStateException("Insufficient funds").
  // Return the new balance of the source account.
  // -------------------------------------------------------------------------
  def exercise3_transfer(fromName: String, toName: String, amount: Double): TxnIO[Double] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use savepoints for partial rollback.
  // TODO: Insert row A, create savepoint "sp1", insert row B,
  // rollback to "sp1" (undoing B), insert row C.
  // Return the final list of account names.
  // -------------------------------------------------------------------------
  def exercise4_savepointRollback: TxnIO[List[String]] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement "attempt" that catches exceptions within a transaction.
  // TODO: Given a TxnIO[A], return TxnIO[Either[Throwable, A]] that
  // catches any exception and wraps it in Left, without aborting the txn.
  // -------------------------------------------------------------------------
  def exercise5_attempt[A](program: TxnIO[A]): TxnIO[Either[Throwable, A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Chain multiple operations with error recovery.
  // TODO: Try to insert a row; if it fails (e.g. duplicate), catch the
  // error and insert a fallback row instead. Return the name inserted.
  // -------------------------------------------------------------------------
  def exercise6_withRecovery(db: Database): TxnIO[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a "bracket" pattern for transactions.
  // TODO: acquire -> use -> release, ensuring release runs even on failure.
  // Acquire creates a savepoint, use runs the program, release either
  // keeps the result or rolls back to savepoint on failure.
  // -------------------------------------------------------------------------
  def exercise7_bracket[A](savepointName: String)(program: TxnIO[A]): TxnIO[Either[Throwable, A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a retry mechanism that attempts a transaction N times.
  // TODO: Given a TxnIO[A] and max retries, attempt execution.
  // On failure, retry up to maxRetries times. Return the result or last error.
  // -------------------------------------------------------------------------
  def exercise8_retry[A](program: TxnIO[A], maxRetries: Int): Database => Either[Throwable, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val db1 = new Database
    db1.setTable("accounts", Nil)
    db1.commit()
    val r1 = TxnIO.transact(db1)(exercise1_insertInTransaction(1, "Alice", 100.0))
    assert(r1 == Right(1))
    assert(db1.getTable("accounts").size == 1)
    println("Exercise 1 passed: insert in transaction")

    // Exercise 2
    val db2 = new Database
    db2.setTable("accounts", Nil)
    db2.commit()
    val r2 = TxnIO.transact(db2)(exercise2_atomicInserts("Alice", 100.0, "Bob", -50.0))
    assert(r2.isLeft) // should fail
    assert(db2.getTable("accounts").isEmpty) // rolled back
    val r2b = TxnIO.transact(db2)(exercise2_atomicInserts("Alice", 100.0, "Bob", 50.0))
    assert(r2b == Right(2))
    println("Exercise 2 passed: atomic inserts")

    // Exercise 3
    val db3 = new Database
    db3.setTable("accounts", List(
      Map("name" -> "Alice", "balance" -> 100.0),
      Map("name" -> "Bob", "balance" -> 50.0)
    ))
    db3.commit()
    val r3 = TxnIO.transact(db3)(exercise3_transfer("Alice", "Bob", 30.0))
    assert(r3 == Right(70.0))
    val r3b = TxnIO.transact(db3)(exercise3_transfer("Bob", "Alice", 1000.0))
    assert(r3b.isLeft) // insufficient funds
    println("Exercise 3 passed: transfer with balance check")

    // Exercise 4
    val db4 = new Database
    db4.setTable("accounts", Nil)
    db4.commit()
    val r4 = TxnIO.transact(db4)(exercise4_savepointRollback)
    assert(r4.isRight)
    val names4 = r4.getOrElse(Nil)
    assert(names4.contains("A"))
    assert(!names4.contains("B"))
    assert(names4.contains("C"))
    println("Exercise 4 passed: savepoint rollback")

    // Exercise 5
    val failingProgram = TxnIO[Int](_ => throw new RuntimeException("boom"))
    val db5 = new Database
    val r5 = exercise5_attempt(failingProgram).run(db5)
    assert(r5.isLeft)
    assert(r5.left.exists(_.getMessage == "boom"))
    val r5b = exercise5_attempt(TxnIO.pure(42)).run(db5)
    assert(r5b == Right(42))
    println("Exercise 5 passed: attempt error handling")

    // Exercise 6
    val db6 = new Database
    db6.setTable("accounts", List(Map("name" -> "Existing")))
    db6.commit()
    val r6 = TxnIO.transact(db6)(exercise6_withRecovery(db6))
    assert(r6.isRight)
    println("Exercise 6 passed: error recovery")

    // Exercise 7
    val db7 = new Database
    db7.setTable("accounts", List(Map("name" -> "Initial")))
    db7.commit()
    val failProg = TxnIO[String] { db =>
      db.setTable("accounts", db.getTable("accounts") :+ Map("name" -> "Bad"))
      throw new RuntimeException("fail")
    }
    val r7 = TxnIO.transact(db7)(exercise7_bracket("sp_test")(failProg))
    assert(r7.isRight) // bracket catches the error
    assert(r7.exists(_.isLeft)) // inner result is Left
    assert(db7.getTable("accounts").size == 1) // rolled back to savepoint
    println("Exercise 7 passed: bracket pattern")

    // Exercise 8
    var attempt8Count = 0
    val flakyProgram = TxnIO[String] { _ =>
      attempt8Count += 1
      if (attempt8Count < 3) throw new RuntimeException(s"Attempt $attempt8Count failed")
      "success"
    }
    val db8 = new Database
    val r8 = exercise8_retry(flakyProgram, 5)(db8)
    assert(r8 == Right("success"))
    println("Exercise 8 passed: retry mechanism")

    println("\nAll Doob006_Transactions exercises passed!")
  }
}
