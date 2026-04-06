package org.shev4ik.interview.doobie.level2_intermediate

/**
 * Doobie 010 - Error Handling (SQL exceptions, constraint violations, retry)
 *
 * Database operations can fail in many ways: constraint violations, deadlocks,
 * connection timeouts, etc. Doobie provides mechanisms to handle these errors
 * gracefully within ConnectionIO using MonadError, attemptSql, and custom
 * error handlers.
 *
 * Here we model SQL error types and handling patterns to understand how
 * doobie manages database failures.
 */
object Doob010_ErrorHandling {

  // Simplified SQL error hierarchy (mirrors java.sql.SQLException subtypes)
  sealed trait SqlError extends Exception {
    def sqlState: String
    def message: String
    override def getMessage: String = message
  }
  case class UniqueViolation(column: String) extends SqlError {
    val sqlState = "23505"
    val message = s"Unique constraint violated on column: $column"
  }
  case class ForeignKeyViolation(column: String, referencedTable: String) extends SqlError {
    val sqlState = "23503"
    val message = s"Foreign key violation on $column referencing $referencedTable"
  }
  case class NotNullViolation(column: String) extends SqlError {
    val sqlState = "23502"
    val message = s"NOT NULL constraint violated on column: $column"
  }
  case class DeadlockDetected() extends SqlError {
    val sqlState = "40P01"
    val message = "Deadlock detected"
  }
  case class ConnectionTimeout() extends SqlError {
    val sqlState = "08001"
    val message = "Connection timeout"
  }

  // Simplified database operation result
  type DbResult[A] = Either[SqlError, A]

  // -------------------------------------------------------------------------
  // Exercise 1: Classify a SQL state code into a SqlError type.
  // TODO: Given a sqlState string and context, return the appropriate SqlError.
  // "23505" -> UniqueViolation(context)
  // "23503" -> ForeignKeyViolation(context, "unknown")
  // "23502" -> NotNullViolation(context)
  // "40P01" -> DeadlockDetected()
  // "08001" -> ConnectionTimeout()
  // For unknown codes, return UniqueViolation("unknown") as fallback.
  // -------------------------------------------------------------------------
  def exercise1_classifyError(sqlState: String, context: String): SqlError = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement attemptSql that catches SqlErrors.
  // TODO: Given a function that may throw SqlError, return DbResult[A].
  // Catch only SqlError, let other exceptions propagate.
  // -------------------------------------------------------------------------
  def exercise2_attemptSql[A](f: => A): DbResult[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Handle unique constraint violation with a fallback.
  // TODO: Given a primary operation and a fallback, try the primary first.
  // If it fails with UniqueViolation, run the fallback. For other errors,
  // propagate the error.
  // -------------------------------------------------------------------------
  def exercise3_handleUnique[A](primary: => DbResult[A])(fallback: => DbResult[A]): DbResult[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement retry logic for transient errors.
  // TODO: Retry the operation up to maxRetries times if it fails with
  // DeadlockDetected or ConnectionTimeout. For other errors, fail immediately.
  // Return the first success or the last error.
  // -------------------------------------------------------------------------
  def exercise4_retryTransient[A](maxRetries: Int)(operation: => DbResult[A]): DbResult[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Map error types to user-friendly messages.
  // TODO: Given a DbResult, transform Left errors into human-readable strings.
  // UniqueViolation -> "A record with this value already exists"
  // ForeignKeyViolation -> "Referenced record does not exist"
  // NotNullViolation -> "Required field is missing: <column>"
  // DeadlockDetected -> "Please try again"
  // ConnectionTimeout -> "Service temporarily unavailable"
  // -------------------------------------------------------------------------
  def exercise5_friendlyError[A](result: DbResult[A]): Either[String, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement an "ensureConstraint" check before insertion.
  // TODO: Given a validation function that returns Option[SqlError],
  // run validation first. If it returns Some(error), return Left.
  // If None, execute the insert operation.
  // -------------------------------------------------------------------------
  def exercise6_ensureConstraint[A](
    validate: => Option[SqlError],
    insert: => DbResult[A]
  ): DbResult[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Compose multiple error-handling strategies.
  // TODO: Given an operation, apply these strategies in order:
  // 1. Retry up to 3 times on transient errors
  // 2. If it's a UniqueViolation, use the fallback
  // 3. Map remaining errors to friendly messages
  // -------------------------------------------------------------------------
  def exercise7_composedErrorHandling[A](
    operation: => DbResult[A],
    fallback: => DbResult[A]
  ): Either[String, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a "transaction guard" that validates preconditions.
  // TODO: Given a list of preconditions (each returning Option[SqlError]),
  // check all preconditions first. If any fail, return all errors combined
  // in a Left. If all pass, run the operation.
  // Combine errors into: "Multiple errors: msg1; msg2; ..."
  // -------------------------------------------------------------------------
  def exercise8_transactionGuard[A](
    preconditions: List[() => Option[SqlError]],
    operation: => DbResult[A]
  ): Either[String, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_classifyError("23505", "email").isInstanceOf[UniqueViolation])
    assert(exercise1_classifyError("40P01", "").isInstanceOf[DeadlockDetected])
    assert(exercise1_classifyError("08001", "").isInstanceOf[ConnectionTimeout])
    println("Exercise 1 passed: error classification")

    // Exercise 2
    assert(exercise2_attemptSql(42) == Right(42))
    assert(exercise2_attemptSql(throw UniqueViolation("id")).isLeft)
    println("Exercise 2 passed: attemptSql")

    // Exercise 3
    assert(exercise3_handleUnique(Left(UniqueViolation("id")))(Right("fallback")) == Right("fallback"))
    assert(exercise3_handleUnique(Right("primary"))(Right("fallback")) == Right("primary"))
    assert(exercise3_handleUnique(Left(NotNullViolation("name")))(Right("fallback")).isLeft)
    println("Exercise 3 passed: handle unique violation")

    // Exercise 4
    var attempts4 = 0
    val r4 = exercise4_retryTransient(3) {
      attempts4 += 1
      if (attempts4 < 3) Left(DeadlockDetected()) else Right("success")
    }
    assert(r4 == Right("success"))
    val r4b = exercise4_retryTransient(2)(Left(ConnectionTimeout()))
    assert(r4b.isLeft)
    val r4c = exercise4_retryTransient(5)(Left(UniqueViolation("id")))
    assert(r4c.isLeft) // should not retry
    println("Exercise 4 passed: retry transient errors")

    // Exercise 5
    assert(exercise5_friendlyError(Left(UniqueViolation("email"))) == Left("A record with this value already exists"))
    assert(exercise5_friendlyError(Left(NotNullViolation("name"))) == Left("Required field is missing: name"))
    assert(exercise5_friendlyError(Right(42)) == Right(42))
    println("Exercise 5 passed: friendly error messages")

    // Exercise 6
    assert(exercise6_ensureConstraint(None, Right(42)) == Right(42))
    assert(exercise6_ensureConstraint(Some(NotNullViolation("name")), Right(42)).isLeft)
    println("Exercise 6 passed: ensure constraint")

    // Exercise 7
    var att7 = 0
    val r7 = exercise7_composedErrorHandling(
      { att7 += 1; if (att7 < 2) Left(DeadlockDetected()) else Right("ok") },
      Right("fallback")
    )
    assert(r7 == Right("ok"))
    val r7b = exercise7_composedErrorHandling(
      Left(UniqueViolation("id")),
      Right("fallback")
    )
    assert(r7b == Right("fallback"))
    println("Exercise 7 passed: composed error handling")

    // Exercise 8
    val r8 = exercise8_transactionGuard(
      List(() => None, () => None),
      Right(42)
    )
    assert(r8 == Right(42))
    val r8b = exercise8_transactionGuard(
      List(() => Some(NotNullViolation("name")), () => Some(UniqueViolation("id"))),
      Right(42)
    )
    assert(r8b.isLeft)
    assert(r8b.left.exists(_.contains("Multiple errors")))
    println("Exercise 8 passed: transaction guard")

    println("\nAll Doob010_ErrorHandling exercises passed!")
  }
}
