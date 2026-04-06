package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 007 - Timeouts, racing, and time-related operations.
 *
 * timeout returns None if the effect doesn't complete in time.
 * race runs two effects and returns the winner.
 */
object Zio007_Timeout {

  // Exercise 1: Use timeout to limit an effect's execution time — succeeds in time
  // TODO: ZIO.succeed(42).timeout(1.second) — should return Some(42)
  def exercise1: ZIO[Clock,Nothing, Option[Int]] = ???

  // Exercise 2: Use timeout on an effect that takes too long
  // TODO: ZIO.never.timeout(100.millis) — should return None
  def exercise2: ZIO[Clock,Nothing, Option[Nothing]] = ???

  // Exercise 3: Use disconnect to allow an effect to continue in background after timeout
  // TODO: ZIO.never.disconnect.timeout(100.millis) — returns None, but effect continues
  def exercise3: ZIO[Clock,Nothing, Option[Nothing]] = ???

  // Exercise 4: Use timeoutFail to fail with a custom error on timeout
  // TODO: ZIO.never.timeoutFail("timed out")(100.millis)
  // Then use .either to get Left("timed out")
  def exercise4: ZIO[Clock,Nothing, Either[String, Nothing]] = ???

  // Exercise 5: Use timeoutTo to provide a fallback value on timeout
  // TODO: ZIO.never.timeoutTo(-1)(identity)(100.millis) — returns -1 on timeout
  def exercise5: ZIO[Clock,Nothing, Int] = ???

  // Exercise 6: Use race to race two effects — the faster one wins
  // TODO: ZIO.succeed(1).race(ZIO.never) — should return 1
  def exercise6: ZIO[Clock,Nothing, Int] = ???

  // Exercise 7: Use timed to measure how long an effect takes
  // TODO: ZIO.sleep(100.millis).timed — returns (Duration, Unit)
  // Check that the duration is >= 100 millis
  def exercise7: ZIO[Clock,Nothing, Boolean] = ???

  // Exercise 8: Use ZIO.sleep to delay then return a value
  // TODO: ZIO.sleep(50.millis) *> ZIO.succeed("delayed")
  def exercise8: ZIO[Clock,Nothing, String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1.contains(42), s"Exercise 1 failed: expected Some(42), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.isEmpty, s"Exercise 2 failed: expected None, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.isEmpty, s"Exercise 3 failed: expected None, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == Left("timed out"), s"Exercise 4 failed: expected Left(timed out), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == -1, s"Exercise 5 failed: expected -1, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 1, s"Exercise 6 failed: expected 1, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7, "Exercise 7 failed: expected duration >= 100ms")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == "delayed", s"Exercise 8 failed: expected 'delayed', got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio007_Timeout exercises passed!")
  }
}
