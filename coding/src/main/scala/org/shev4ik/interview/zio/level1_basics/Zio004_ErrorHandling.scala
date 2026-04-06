package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 004 - Error Handling: Typed Errors, Defects, and Recovery Operators
 *
 * == Core Concept: The Error Channel (E parameter) ==
 * In `ZIO[R, E, A]`, the `E` type parameter represents **typed, expected, recoverable errors**.
 * Unlike Java exceptions or Scala's `Try[A]` (which always use `Throwable`), ZIO lets you define
 * a precise error type: `IO[DatabaseError, User]`, `IO[ValidationError, Order]`, etc. The compiler
 * then forces you to handle these errors explicitly — you cannot accidentally ignore them.
 *
 * == Typed Errors vs Defects ==
 * ZIO distinguishes two categories of failures:
 *
 *   - '''Typed errors (E):''' Expected, recoverable failures modeled in the error channel.
 *     Examples: validation errors, "not found", business rule violations, expected I/O errors.
 *     Created with `ZIO.fail(e)`. Recoverable with `catchAll`, `catchSome`, `fold`, `orElse`.
 *
 *   - '''Defects:''' Unexpected, unrecoverable failures that indicate programmer error or
 *     environmental issues. Examples: `NullPointerException`, `StackOverflowError`, division by zero.
 *     Created with `ZIO.die(throwable)` or when code wrapped in `ZIO.succeed`/`effectTotal` throws.
 *     Defects bypass the error channel entirely — they are stored in `Cause.Die` and propagate
 *     as fiber deaths. They can only be observed via `sandbox`/`catchAllCause`.
 *
 * {{{
 *   ZIO.fail("not found")                    // Typed error: E = String
 *   ZIO.die(new RuntimeException("bug"))     // Defect: not in E, stored in Cause
 * }}}
 *
 * == Recovery operators summary ==
 * | Operator       | Handles              | Transforms to                    | Error channel after       |
 * |----------------|----------------------|----------------------------------|---------------------------|
 * | `catchAll`     | All typed errors     | `E => ZIO[R, E2, A]`            | `E2` (can be `Nothing`)  |
 * | `catchSome`    | Matching errors only | `PartialFunction[E, ZIO[...]]`  | `E` (unchanged)           |
 * | `orElse`       | All typed errors     | Provides fallback ZIO            | Error type of fallback    |
 * | `orElseFail`   | All typed errors     | Replaces error value             | New error type            |
 * | `fold`         | Success + all errors | `(E => B, A => B) => UIO[B]`    | `Nothing` (infallible)    |
 * | `foldM`/`foldZIO` | Success + all errors | Effectful handlers           | Depends on handlers       |
 * | `either`       | All typed errors     | Surfaces error as `Either`       | `Nothing` (infallible)    |
 * | `absolve`      | n/a                  | Submerges `Either` back into E   | `E` from the Either       |
 *
 * == either / absolve duality ==
 * `either` and `absolve` are inverses of each other:
 * {{{
 *   val x: IO[String, Int] = ZIO.fail("err")
 *   val y: UIO[Either[String, Int]] = x.either       // error -> success channel
 *   val z: IO[String, Int] = y.absolve                // success channel -> error
 *   // z is equivalent to x
 * }}}
 *
 * == Interview Tip ==
 * '''Q: Explain the difference between ZIO typed errors and defects. When should each be used?'''
 *
 * Typed errors (`E`) represent expected failures that callers should handle: a user not found,
 * invalid input, a timeout. They appear in the type signature and the compiler enforces handling.
 * Use `ZIO.fail(e)` to create them.
 *
 * Defects represent bugs or truly unexpected conditions: null pointer, stack overflow, assertion
 * failures. They should NOT be modeled in `E` because callers cannot meaningfully recover from
 * them. Use `ZIO.die` or let them propagate naturally.
 *
 * '''Rule of thumb:''' If you would write a `case` branch to handle it in normal business logic,
 * it is a typed error. If it indicates a programming mistake, it is a defect.
 *
 * '''Follow-up:''' "How do you handle defects if needed?" Use `sandbox` to expose the full
 * `Cause[E]` (which includes both errors and defects) in the error channel, then `catchAllCause`
 * or pattern-match on `Cause.Die`, `Cause.Interrupt`, etc.
 *
 * == Real-World Context ==
 * In production microservices, typed errors are typically modeled as sealed trait hierarchies:
 * {{{
 *   sealed trait AppError
 *   case class NotFound(id: String) extends AppError
 *   case class Unauthorized(reason: String) extends AppError
 *   case class ValidationFailed(errors: List[String]) extends AppError
 * }}}
 * The service layer returns `ZIO[Any, AppError, Result]`, and the HTTP layer uses `fold` or
 * `catchAll` to map each error variant to the appropriate HTTP status code (404, 401, 400).
 * This eliminates the need for exception-based control flow and makes error handling explicit
 * and exhaustive (the compiler warns about unhandled cases in pattern matches).
 */
object Zio004_ErrorHandling {

  // Exercise 1: Use catchAll to recover from a failure
  // TODO: ZIO.fail("error").catchAll(e => ZIO.succeed(e.length))
  // Should succeed with 5 (length of "error")
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use catchSome to recover from specific errors
  // TODO: ZIO.fail("not found").catchSome { case "not found" => ZIO.succeed(-1) }
  val exercise2: IO[String, Int] = ???

  // Exercise 3: Use fold to handle both success and failure
  // TODO: ZIO.fail("error").fold(e => s"failed: $e", a => s"success: $a")
  val exercise3: UIO[String] = ???

  // Exercise 4: Use foldM to handle both channels with effects
  // TODO: ZIO.fail("boom").foldM(
  //   e => ZIO.succeed(s"recovered: $e"),
  //   a => ZIO.succeed(s"value: $a")
  // )
  val exercise4: UIO[String] = ???

  // Exercise 5: Use either to surface the error into the success channel
  // TODO: ZIO.fail("error").either — gives UIO[Either[String, Nothing]]
  val exercise5: UIO[Either[String, Nothing]] = ???

  // Exercise 6: Use absolve to submerge an Either back into ZIO error channel
  // TODO: ZIO.succeed(Right(42): Either[String, Int]) and then absolve it
  // absolve: ZIO[R, Nothing, Either[E, A]] => ZIO[R, E, A]
  val exercise6: IO[String, Int] = ???

  // Exercise 7: Use orElse to provide a fallback effect
  // TODO: ZIO.fail("primary failed").orElse(ZIO.succeed(99))
  val exercise7: UIO[Int] = ???

  // Exercise 8: Use orElseFail to replace the error
  // TODO: ZIO.fail("original").orElseFail("replaced") then use .either
  val exercise8: UIO[Either[String, Nothing]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 5, s"Exercise 1 failed: expected 5, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == -1, s"Exercise 2 failed: expected -1, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "failed: error", s"Exercise 3 failed: expected 'failed: error', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "recovered: boom", s"Exercise 4 failed: expected 'recovered: boom', got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == Left("error"), s"Exercise 5 failed: expected Left(error), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 99, s"Exercise 7 failed: expected 99, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Left("replaced"), s"Exercise 8 failed: expected Left(replaced), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio004_ErrorHandling exercises passed!")
  }
}
