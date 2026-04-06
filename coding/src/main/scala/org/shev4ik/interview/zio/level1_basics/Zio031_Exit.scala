package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 031 - Exit: the result of running a ZIO effect.
 *
 * Exit[E, A] is either:
 * - Exit.Success(a): the effect succeeded with value A
 * - Exit.Failure(cause): the effect failed with Cause[E]
 */
object Zio031_Exit {

  // Exercise 1: Create an Exit.succeed
  // TODO: Exit.succeed(42)
  val exercise1: Exit[Nothing, Int] = ???

  // Exercise 2: Create an Exit.fail
  // TODO: Exit.fail("error")
  val exercise2: Exit[String, Nothing] = ???

  // Exercise 3: Use fold to handle both success and failure
  // TODO: Exit.succeed(42).fold(cause => s"failed: ${cause.failures}", a => s"success: $a")
  val exercise3: String = ???

  // Exercise 4: Use foldM to handle with effects
  // TODO: Exit.succeed(42).foldM(
  //   cause => ZIO.succeed(s"failed"),
  //   a => ZIO.succeed(s"success: $a")
  // )
  val exercise4: UIO[String] = ???

  // Exercise 5: Convert Exit to Either using toEither
  // TODO: Exit.succeed(42).toEither — Right(42)
  val exercise5: Either[Throwable, Int] = ???

  // Exercise 6: Check if an Exit succeeded
  // TODO: Exit.succeed(42).succeeded — true
  val exercise6: Boolean = ???

  // Exercise 7: Use getOrThrow on a successful Exit (ZIO 1.x: fold to extract)
  // TODO: Exit.succeed(42).fold(_ => throw new RuntimeException("failed"), identity)
  // Or simply pattern match: Exit.succeed(42) match { case Exit.Success(v) => v }
  val exercise7: Int = ???

  // Exercise 8: Use mapError to transform the error in an Exit
  // TODO: Exit.fail("error").mapError(_.length) — Exit.Failure with error 5
  val exercise8: Exit[Int, Nothing] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    assert(exercise1 == Exit.succeed(42), s"Exercise 1 failed: got $exercise1")
    println(s"Exercise 1 passed: $exercise1")

    // Exercise 2
    assert(!exercise2.succeeded, s"Exercise 2 failed: expected failure")
    println(s"Exercise 2 passed: failure detected")

    // Exercise 3
    assert(exercise3 == "success: 42", s"Exercise 3 failed: expected 'success: 42', got $exercise3")
    println(s"Exercise 3 passed: $exercise3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "success: 42", s"Exercise 4 failed: expected 'success: 42', got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    assert(exercise5 == Right(42), s"Exercise 5 failed: expected Right(42), got $exercise5")
    println(s"Exercise 5 passed: $exercise5")

    // Exercise 6
    assert(exercise6, "Exercise 6 failed: expected true")
    println(s"Exercise 6 passed: $exercise6")

    // Exercise 7
    assert(exercise7 == 42, s"Exercise 7 failed: expected 42, got $exercise7")
    println(s"Exercise 7 passed: $exercise7")

    // Exercise 8
    val r8Failures = exercise8 match {
      case Exit.Failure(cause) => cause.failures
      case _                   => List.empty
    }
    assert(r8Failures == List(5), s"Exercise 8 failed: expected List(5), got $r8Failures")
    println(s"Exercise 8 passed: mapped error = $r8Failures")

    println("All Zio031_Exit exercises passed!")
  }
}
