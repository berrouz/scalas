package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 006 - Retry: retry with Schedule, retryN, retryOrElse, retryUntil, retryWhile.
 *
 * ZIO provides powerful retry combinators backed by Schedule.
 */
object Zio006_Retry {

  // Exercise 1: Use retry with Schedule.recurs to retry a failing effect up to 3 times
  // TODO: Create a Ref-based counter that fails until the 3rd attempt, then succeeds.
  // Use .retry(Schedule.recurs(3))
  def exercise1: ZIO[Clock,Nothing, Int] = ???

  // Exercise 2: Use retryN to retry exactly N times
  // TODO: Similar to exercise 1 but use .retryN(3)
  def exercise2: ZIO[Clock,Nothing, Int] = ???

  // Exercise 3: Use retryOrElse to retry and provide a fallback
  // TODO: Create an effect that always fails with "error".
  // Retry 2 times, then fall back to ZIO.succeed(-1) using retryOrElse
  // retryOrElse(schedule, (error, output) => fallback)
  def exercise3: ZIO[Clock,Nothing, Int] = ???

  // Exercise 4: Use retryOrElseEither to distinguish retry success vs fallback
  // TODO: Create an effect that always fails.
  // retryOrElseEither(Schedule.recurs(1), (e, _) => ZIO.succeed("fallback"))
  // Result should be Left("fallback") since we exhausted retries
  def exercise4: ZIO[Clock,Nothing, Either[String, Nothing]] = ???

  // Exercise 5: Use retryUntil to retry until a condition on the error is met
  // TODO: Create a Ref counter. Each call fails with the counter value.
  // Use retryUntil(_ >= 3) — retries until error >= 3, then fails with that error.
  // Catch the error to verify it's 3.
  def exercise5: ZIO[Clock,Nothing, Int] = ???

  // Exercise 6: Use retryWhile to retry as long as condition holds
  // TODO: Create a Ref counter. Each call fails with counter value.
  // Use retryWhile(_ < 3) — retries while error < 3.
  // Catch final error to verify it's 3.
  def exercise6: ZIO[Clock,Nothing, Int] = ???

  // Exercise 7: Use retry with Schedule.exponential for exponential backoff
  // TODO: Create a Ref counter that fails until 3rd attempt.
  // Use .retry(Schedule.exponential(10.millis) && Schedule.recurs(5))
  // The && composes schedules — both must continue for the retry to happen.
  def exercise7: ZIO[Clock,Nothing, Int] = ???

  // Exercise 8: Use retry with Schedule.jittered for randomized delays
  // TODO: Create a Ref counter that fails until 2nd attempt.
  // Use .retry(Schedule.recurs(3).jittered)
  // jittered adds random variation to the delay.
  def exercise8: ZIO[Clock with zio.random.Random, Nothing, Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 > 0, s"Exercise 1 failed: expected positive, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 > 0, s"Exercise 2 failed: expected positive, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == -1, s"Exercise 3 failed: expected -1, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == Left("fallback"), s"Exercise 4 failed: expected Left(fallback), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 >= 3, s"Exercise 5 failed: expected >= 3, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 >= 3, s"Exercise 6 failed: expected >= 3, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 > 0, s"Exercise 7 failed: expected positive, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 > 0, s"Exercise 8 failed: expected positive, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio006_Retry exercises passed!")
  }
}
