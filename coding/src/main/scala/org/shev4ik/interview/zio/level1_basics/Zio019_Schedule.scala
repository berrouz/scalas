package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 019 - Schedule basics: defining repetition and retry policies.
 *
 * Schedule[R, A, B] takes input A and produces output B.
 * Used with .repeat, .retry, etc.
 */
object Zio019_Schedule {

  // Exercise 1: Use Schedule.recurs(n) to repeat an effect n times
  // TODO: Create a Ref[Int], repeat ref.update(_ + 1) with Schedule.recurs(3)
  // The effect runs 1 + 3 = 4 times total (initial + 3 repeats)
  def exercise1: ZIO[Clock, Nothing, Int] = ???

  // Exercise 2: Use Schedule.once to repeat exactly once
  // TODO: Create a Ref[Int], repeat ref.update(_ + 1) with Schedule.once
  // Total runs: 2 (initial + 1 repeat)
  def exercise2: ZIO[Clock, Nothing, Int] = ???

  // Exercise 3: Use Schedule.forever to repeat indefinitely (with a guard)
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with Schedule.forever.
  // Use .timeout(200.millis) or combine with whileInput to stop at 10.
  // Actually: use repeat(Schedule.recurWhile[Int](_ < 10)) to repeat while value < 10
  def exercise3: ZIO[Clock, Nothing, Int] = ???

  // Exercise 4: Use Schedule.fixed(duration) to repeat at fixed intervals
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with Schedule.fixed(10.millis) && Schedule.recurs(2).
  // Total runs: 3
  def exercise4: ZIO[Clock, Nothing, Int] = ???

  // Exercise 5: Use Schedule.spaced(duration) to add spacing between repetitions
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with Schedule.spaced(10.millis) && Schedule.recurs(2).
  def exercise5: ZIO[Clock, Nothing, Int] = ???

  // Exercise 6: Use Schedule.exponential for exponential backoff
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with Schedule.exponential(10.millis) && Schedule.recurs(3).
  def exercise6: ZIO[Clock, Nothing, Int] = ???

  // Exercise 7: Use Schedule.fibonacci for fibonacci-based delays
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with Schedule.fibonacci(10.millis) && Schedule.recurs(3).
  def exercise7: ZIO[Clock, Nothing, Int] = ???

  // Exercise 8: Use Schedule.identity to pass through the input unchanged
  // TODO: ZIO.succeed(42).repeat(Schedule.identity *> Schedule.once)
  // Schedule.identity outputs its input — the output of the effect being repeated
  def exercise8: ZIO[Clock, Nothing, Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 4, s"Exercise 1 failed: expected 4, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 2, s"Exercise 2 failed: expected 2, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 >= 10, s"Exercise 3 failed: expected >= 10, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 3, s"Exercise 4 failed: expected 3, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 3, s"Exercise 5 failed: expected 3, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 4, s"Exercise 6 failed: expected 4, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 4, s"Exercise 7 failed: expected 4, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 42, s"Exercise 8 failed: expected 42, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio019_Schedule exercises passed!")
  }
}
