package org.shev4ik.interview.zio.level3_advanced

import zio._
import zio.console._

/**
 * ZIO097 - Error Design Patterns
 *
 * Learn how to design error handling strategies with typed errors, ADTs, and accumulation.
 */
object Zio097_ErrorDesign extends App {

  // ============================================================
  // Exercise 1: Error ADT
  // TODO: Define a sealed trait AppError with subtypes:
  //       NotFound(id: String), Unauthorized(msg: String), ValidationError(field: String, msg: String)
  //       Write effects that fail with each type. Pattern match on the error.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Error hierarchy
  // TODO: Define a hierarchical error model:
  //       AppError -> ServiceError -> DatabaseError, NetworkError
  //                -> BusinessError -> InsufficientFunds, ItemNotAvailable
  //       Write effects demonstrating each level. Print error info.
  // ============================================================
  val exercise2: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Typed errors
  // TODO: Write a function that returns ZIO[Any, NotFound, User] and another
  //       that returns ZIO[Any, Unauthorized, Session].
  //       Compose them, showing how the error type becomes the union.
  //       Handle each error type separately.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Error accumulation
  // TODO: Validate 3 fields (name, email, age) where each can fail.
  //       Use ZIO.validate or ZIO.validatePar to accumulate ALL errors
  //       instead of failing fast. Print all validation errors.
  // ============================================================
  val exercise4: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Error channels
  // TODO: Demonstrate the difference between the error channel (E)
  //       and defects (Throwable that bypasses E).
  //       Use ZIO.fail for expected errors and ZIO.die for defects.
  //       Use .sandbox to catch both. Print the Cause.
  // ============================================================
  val exercise5: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Defect vs failure design
  // TODO: Design a service where:
  //       - Business rule violations are failures (E channel)
  //       - Programming errors are defects (die)
  //       - External errors are wrapped appropriately
  //       Demonstrate each case. Print error handling.
  // ============================================================
  val exercise6: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Error recovery strategy
  // TODO: Implement a layered error recovery:
  //       1. Try primary action
  //       2. On specific error, try fallback
  //       3. On any error, try default
  //       4. On all failures, log and return safe default
  //       Print which recovery path was taken.
  // ============================================================
  val exercise7: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Error reporting
  // TODO: Implement an error reporter that:
  //       - Collects error context (what operation, what input)
  //       - Adds stack-like context as errors propagate
  //       - Formats a human-readable error report
  //       Print the final error report.
  // ============================================================
  val exercise8: ZIO[Console, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
