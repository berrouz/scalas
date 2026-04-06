package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 011 - MonadError Type Class
 *
 * MonadError[F, E] extends Monad[F] with error handling capabilities.
 * F is the effect type, E is the error type.
 * For Either[E, A], E is the left type. For Option, E is Unit.
 *
 * Key methods: raiseError, handleError, handleErrorWith, attempt, ensure, adaptError, rethrow
 */
object Cats011_MonadError {

  type ErrorOr[A] = Either[String, A]

  // -------------------------------------------------------------------------
  // Exercise 1: Use raiseError to create an error value in Either context.
  // TODO: Return a Left with the given error message.
  // Hint: MonadError[ErrorOr, String].raiseError(msg) or msg.raiseError[ErrorOr, Int]
  // -------------------------------------------------------------------------
  def exercise1_raiseError(msg: String): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use handleError to recover from errors with a default value.
  // TODO: If the Either is Left, return 0. Otherwise keep the Right value.
  // Hint: result.handleError(_ => 0)
  // -------------------------------------------------------------------------
  def exercise2_handleError(result: ErrorOr[Int]): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use handleErrorWith to recover with another Either computation.
  // TODO: If the Either is Left, try an alternative computation.
  // Hint: result.handleErrorWith(err => if (err == "retry") Right(42) else Left(err))
  // -------------------------------------------------------------------------
  def exercise3_handleErrorWith(result: ErrorOr[Int]): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use attempt to convert F[A] to F[Either[E, A]].
  // TODO: Convert the Either into an Either[String, Either[String, Int]].
  // This always succeeds (wraps in Right), capturing the error in the inner Either.
  // Hint: result.attempt gives Either[String, Either[String, Int]] but for
  //       Either it essentially becomes Right(result).
  // -------------------------------------------------------------------------
  def exercise4_attempt(result: ErrorOr[Int]): ErrorOr[Either[String, Int]] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use ensure to validate a value, raising error if predicate fails.
  // TODO: Ensure the value is positive. If not, raise "must be positive".
  // Hint: result.ensure("must be positive")(_ > 0)
  // -------------------------------------------------------------------------
  def exercise5_ensure(result: ErrorOr[Int]): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use adaptError to transform the error type/message.
  // TODO: Prefix all error messages with "Error: ".
  // Hint: result.adaptError { case msg => s"Error: $msg" }
  // -------------------------------------------------------------------------
  def exercise6_adaptError(result: ErrorOr[Int]): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use rethrow to convert F[Either[E, A]] back to F[A].
  // TODO: Given Either[String, Either[String, Int]], flatten it via rethrow.
  // Hint: nested.rethrow
  // -------------------------------------------------------------------------
  def exercise7_rethrow(nested: ErrorOr[Either[String, Int]]): ErrorOr[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Combine multiple MonadError operations.
  // TODO: Parse a string to Int, ensure it's between 1 and 100,
  // and adapt any error to include the original input.
  // Use Either as the error context.
  // -------------------------------------------------------------------------
  def exercise8_combined(input: String): ErrorOr[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_raiseError("boom") == Left("boom"))
    println("Exercise 1 passed: raiseError")

    // Exercise 2
    assert(exercise2_handleError(Right(42)) == Right(42))
    assert(exercise2_handleError(Left("error")) == Right(0))
    println("Exercise 2 passed: handleError")

    // Exercise 3
    assert(exercise3_handleErrorWith(Right(10)) == Right(10))
    assert(exercise3_handleErrorWith(Left("retry")) == Right(42))
    assert(exercise3_handleErrorWith(Left("fatal")) == Left("fatal"))
    println("Exercise 3 passed: handleErrorWith")

    // Exercise 4
    assert(exercise4_attempt(Right(42)) == Right(Right(42)))
    assert(exercise4_attempt(Left("err")) == Right(Left("err")))
    println("Exercise 4 passed: attempt")

    // Exercise 5
    assert(exercise5_ensure(Right(5)) == Right(5))
    assert(exercise5_ensure(Right(-1)) == Left("must be positive"))
    assert(exercise5_ensure(Left("earlier error")) == Left("earlier error"))
    println("Exercise 5 passed: ensure")

    // Exercise 6
    assert(exercise6_adaptError(Right(42)) == Right(42))
    assert(exercise6_adaptError(Left("boom")) == Left("Error: boom"))
    println("Exercise 6 passed: adaptError")

    // Exercise 7
    assert(exercise7_rethrow(Right(Right(42))) == Right(42))
    assert(exercise7_rethrow(Right(Left("inner error"))) == Left("inner error"))
    assert(exercise7_rethrow(Left("outer error")) == Left("outer error"))
    println("Exercise 7 passed: rethrow")

    // Exercise 8
    assert(exercise8_combined("50") == Right(50))
    assert(exercise8_combined("abc").isLeft)
    assert(exercise8_combined("200").isLeft)
    assert(exercise8_combined("0").isLeft)
    println("Exercise 8 passed: combined MonadError operations")

    println("\nAll Cats011_MonadError exercises passed!")
  }
}
