package org.shev4ik.interview.doobie.level1_basics

/**
 * Doobie 001 - ConnectionIO Monad
 *
 * ConnectionIO is the fundamental monad in doobie. It represents a program that,
 * when given a JDBC Connection, will produce a value (or fail). A Transactor lifts
 * ConnectionIO programs into an effect type (IO, Task, etc.) by managing connection
 * acquisition, commit/rollback, and release.
 *
 * How doobie works under the hood — the Free monad approach:
 *   Real doobie's ConnectionIO is actually Free[ConnectionOp, A] — a free monad over
 *   an algebra of JDBC operations (ConnectionOp). This means ConnectionIO programs are
 *   data structures (ASTs) that describe what to do, not how to do it. The interpreter
 *   (provided by the Transactor) walks the AST and executes each operation against a
 *   real JDBC Connection. This separation of description from execution is called
 *   "pure embedding" and is what makes doobie programs:
 *     - Testable: you can interpret the same program against a mock or in-memory DB
 *     - Composable: programs combine with flatMap/for-comprehensions like any monad
 *     - Inspectable: since programs are data, you can analyze them before running
 *
 * Key doobie interview questions:
 *   Q: How does doobie differ from Slick?
 *   A: Doobie is a pure JDBC wrapper — you write SQL strings and doobie handles
 *      connection management, result mapping, and composition. Slick is a Functional
 *      Relational Mapping (FRM) library that generates SQL from Scala expressions.
 *      Doobie is simpler and gives full SQL control but requires SQL knowledge.
 *      Slick provides type-safe queries but has a steeper learning curve and can
 *      generate surprising SQL. Doobie uses Cats Effect; Slick uses its own DBIO monad.
 *
 *   Q: What is a Transactor?
 *   A: A Transactor wraps a connection source (DataSource, DriverManager) and provides
 *      the transact method that: acquires a connection, runs the ConnectionIO program,
 *      commits on success / rolls back on failure, and releases the connection. It
 *      bridges the pure ConnectionIO world to effectful IO.
 *
 * In this exercise we model a simplified ConnectionIO from scratch to understand
 * the core abstraction: a computation that depends on a database connection.
 *
 * Key concepts: pure embedding, monadic composition, transactor pattern.
 */
object Doob001_ConnectionIO {

  // Simplified model of a JDBC connection
  case class Connection(url: String, tables: Map[String, List[Map[String, Any]]])

  // Simplified ConnectionIO: a program that requires a Connection to produce A
  case class ConnectionIO[A](run: Connection => A) {
    def map[B](f: A => B): ConnectionIO[B] = ConnectionIO(conn => f(run(conn)))
    def flatMap[B](f: A => ConnectionIO[B]): ConnectionIO[B] = ConnectionIO(conn => f(run(conn)).run(conn))
  }

  object ConnectionIO {
    def pure[A](a: A): ConnectionIO[A] = ConnectionIO(_ => a)
  }

  // Simplified Transactor: manages connection lifecycle
  case class Transactor(connection: Connection) {
    def transact[A](program: ConnectionIO[A]): Either[Throwable, A] =
      try Right(program.run(connection))
      catch { case e: Throwable => Left(e) }
  }

  // Sample data
  val sampleConnection: Connection = Connection(
    url = "jdbc:h2:mem:test",
    tables = Map(
      "users" -> List(
        Map("id" -> 1, "name" -> "Alice", "age" -> 30),
        Map("id" -> 2, "name" -> "Bob", "age" -> 25),
        Map("id" -> 3, "name" -> "Charlie", "age" -> 35)
      ),
      "orders" -> List(
        Map("id" -> 1, "user_id" -> 1, "amount" -> 100.0),
        Map("id" -> 2, "user_id" -> 2, "amount" -> 200.0)
      )
    )
  )

  val xa: Transactor = Transactor(sampleConnection)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a ConnectionIO that returns a constant value.
  // TODO: Use ConnectionIO.pure to lift the integer 42 into ConnectionIO.
  // -------------------------------------------------------------------------
  def exercise1_pureValue: ConnectionIO[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a ConnectionIO that reads the connection URL.
  // TODO: Access the connection's url field inside ConnectionIO.
  // -------------------------------------------------------------------------
  def exercise2_readConnectionUrl: ConnectionIO[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Map over a ConnectionIO to transform its result.
  // TODO: Given a ConnectionIO[Int], use map to double the value.
  // -------------------------------------------------------------------------
  def exercise3_mapConnectionIO(program: ConnectionIO[Int]): ConnectionIO[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: FlatMap two ConnectionIO programs together.
  // TODO: First read the number of tables, then use that count in a message.
  // Return a ConnectionIO[String] that says "Found N tables".
  // Hint: conn.tables.size gives the count.
  // -------------------------------------------------------------------------
  def exercise4_flatMapCompose: ConnectionIO[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use a for-comprehension to compose ConnectionIO programs.
  // TODO: Read the URL and table count, return "URL has N tables".
  // -------------------------------------------------------------------------
  def exercise5_forComprehension: ConnectionIO[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use a Transactor to execute a ConnectionIO program.
  // TODO: Given a ConnectionIO[A] and a Transactor, execute the program
  // and return the result wrapped in Either[Throwable, A].
  // -------------------------------------------------------------------------
  def exercise6_transact[A](program: ConnectionIO[A], transactor: Transactor): Either[Throwable, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Demonstrate error handling within ConnectionIO.
  // TODO: Create a ConnectionIO that throws an exception if a table doesn't
  // exist. Look up tableName in conn.tables; if missing, throw
  // new NoSuchElementException(s"Table $tableName not found").
  // If present, return the row count.
  // -------------------------------------------------------------------------
  def exercise7_failOnMissingTable(tableName: String): ConnectionIO[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a helper that sequences a List of ConnectionIO
  // into a single ConnectionIO of List.
  // TODO: Given List[ConnectionIO[A]], return ConnectionIO[List[A]].
  // Hint: Use foldRight with ConnectionIO.pure(List.empty[A]).
  //
  // This is Traverse.sequence from Cats! In real doobie code, you would use:
  //   import cats.implicits._
  //   programs.sequence   // List[ConnectionIO[A]] => ConnectionIO[List[A]]
  // The Traverse type class generalizes this pattern to any F[G[A]] => G[F[A]]
  // where F is Traversable and G is Applicative. ConnectionIO is Applicative
  // (via its Monad instance), so sequence works out of the box.
  // -------------------------------------------------------------------------
  def exercise8_sequence[A](programs: List[ConnectionIO[A]]): ConnectionIO[List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_pureValue.run(sampleConnection) == 42)
    println("Exercise 1 passed: pure value in ConnectionIO")

    // Exercise 2
    assert(exercise2_readConnectionUrl.run(sampleConnection) == "jdbc:h2:mem:test")
    println("Exercise 2 passed: read connection URL")

    // Exercise 3
    val doubled = exercise3_mapConnectionIO(ConnectionIO.pure(21))
    assert(doubled.run(sampleConnection) == 42)
    println("Exercise 3 passed: map over ConnectionIO")

    // Exercise 4
    assert(exercise4_flatMapCompose.run(sampleConnection) == "Found 2 tables")
    println("Exercise 4 passed: flatMap composition")

    // Exercise 5
    assert(exercise5_forComprehension.run(sampleConnection) == "jdbc:h2:mem:test has 2 tables")
    println("Exercise 5 passed: for-comprehension composition")

    // Exercise 6
    assert(exercise6_transact(ConnectionIO.pure(99), xa) == Right(99))
    println("Exercise 6 passed: transact execution")

    // Exercise 7
    assert(exercise7_failOnMissingTable("users").run(sampleConnection) == 3)
    assert(xa.transact(exercise7_failOnMissingTable("nonexistent")).isLeft)
    println("Exercise 7 passed: error handling in ConnectionIO")

    // Exercise 8
    val programs = List(ConnectionIO.pure(1), ConnectionIO.pure(2), ConnectionIO.pure(3))
    assert(exercise8_sequence(programs).run(sampleConnection) == List(1, 2, 3))
    println("Exercise 8 passed: sequence ConnectionIO programs")

    println("\nAll Doob001_ConnectionIO exercises passed!")
  }
}
