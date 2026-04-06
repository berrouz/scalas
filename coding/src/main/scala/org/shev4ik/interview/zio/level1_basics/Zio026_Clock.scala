package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock._
import zio.duration._

/**
 * ZIO 026 - Clock service: time operations.
 *
 * The Clock service provides access to time-related operations.
 * In ZIO 1.x, use zio.clock._ functions.
 */
object Zio026_Clock {

  // Exercise 1: Get the current time in milliseconds
  // TODO: clock.currentTime(java.util.concurrent.TimeUnit.MILLISECONDS)
  def exercise1: URIO[Clock, Long] = ???

  // Exercise 2: Get the current nano time
  // TODO: clock.nanoTime
  def exercise2: URIO[Clock, Long] = ???

  // Exercise 3: Sleep for a duration
  // TODO: clock.sleep(50.millis) *> ZIO.succeed("awake")
  def exercise3: URIO[Clock, String] = ???

  // Exercise 4: Use ZIO.sleep (convenience for clock.sleep)
  // TODO: ZIO.sleep(50.millis) *> ZIO.succeed("done")
  def exercise4: URIO[Clock, String] = ???

  // Exercise 5: Get the current instant
  // TODO: clock.instant — returns java.time.Instant
  def exercise5: URIO[Clock, java.time.Instant] = ???

  // Exercise 6: Get the current local date-time
  // TODO: clock.localDateTime — returns java.time.OffsetDateTime
  def exercise6: URIO[Clock, java.time.OffsetDateTime] = ???

  // Exercise 7: Use timed to measure execution time
  // TODO: ZIO.sleep(100.millis).timed.map { case (duration, _) => duration.toMillis >= 100 }
  def exercise7: URIO[Clock, Boolean] = ???

  // Exercise 8: Combine clock with other operations
  // TODO: for {
  //   start <- clock.currentTime(java.util.concurrent.TimeUnit.MILLISECONDS)
  //   _ <- ZIO.sleep(50.millis)
  //   end <- clock.currentTime(java.util.concurrent.TimeUnit.MILLISECONDS)
  // } yield end - start >= 50
  def exercise8: URIO[Clock, Boolean] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 > 0, s"Exercise 1 failed: expected positive millis, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 > 0, s"Exercise 2 failed: expected positive nanos, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "awake", s"Exercise 3 failed: expected 'awake', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "done", s"Exercise 4 failed: expected 'done', got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 != null, "Exercise 5 failed: expected non-null instant")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 != null, "Exercise 6 failed: expected non-null datetime")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7, "Exercise 7 failed: expected duration >= 100ms")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8, "Exercise 8 failed: expected elapsed >= 50ms")
    println(s"Exercise 8 passed: $r8")

    println("All Zio026_Clock exercises passed!")
  }
}
