package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 020 - Schedule composition: combining schedules.
 *
 * andThen runs one schedule then another.
 * zip / zipWith combine schedule outputs.
 * jittered adds randomness to delays.
 */
object Zio020_ScheduleCompose {

  // Exercise 1: Use andThen to sequence two schedules
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with:
  // Schedule.recurs(2) andThen Schedule.recurs(1)
  // First schedule allows 2 repeats, then second allows 1 more. Total = 4 runs.
  def exercise1: ZIO[Clock, Nothing, Int] = ???

  // Exercise 2: Use zip to combine two schedules (both must continue)
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with:
  // Schedule.recurs(3).zip(Schedule.recurs(5))
  // Intersection: runs min(3,5) = 3 repeats = 4 total runs
  def exercise2: ZIO[Clock, Nothing, Int] = ???

  // Exercise 3: Use zipWith to combine schedule outputs with a function
  // TODO: Create a schedule that combines recurs(2) output with identity output using zipWith
  // Schedule.recurs(2).zipWith(Schedule.identity[Int])((count, value) => s"$count:$value")
  // Repeat ZIO.succeed(42) with this schedule, return last output
  def exercise3: ZIO[Clock, Nothing, String] = ???

  // Exercise 4: Use jittered to add random jitter to a schedule
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with:
  // Schedule.spaced(10.millis).jittered && Schedule.recurs(2)
  def exercise4: ZIO[Clock with zio.random.Random, Nothing, Int] = ???

  // Exercise 5: Use modifyDelay to transform the delays of a schedule
  // TODO: Create a Ref[Int]. Repeat ref.update(_ + 1) with:
  // Schedule.spaced(100.millis).modifyDelay((_, d) => d / 10) && Schedule.recurs(2)
  // modifyDelay lets you change the delay for each step
  def exercise5: ZIO[Clock, Nothing, Int] = ???

  // Exercise 6: Use whileInput to continue schedule only while input satisfies predicate
  // TODO: Create a Ref[Int]. Repeat ref.updateAndGet(_ + 1) with:
  // Schedule.forever.whileInput[Int](_ < 5)
  // Stops when the input (effect output) reaches 5
  def exercise6: ZIO[Clock, Nothing, Int] = ???

  // Exercise 7: Use whileOutput to continue schedule only while output satisfies predicate
  // TODO: Create a Ref[Int]. Repeat ref.updateAndGet(_ + 1) with:
  // Schedule.identity[Int].whileOutput(_ < 5)
  // identity outputs the input, so whileOutput checks the effect result
  def exercise7: ZIO[Clock, Nothing, Int] = ???

  // Exercise 8: Use fold on a schedule to accumulate output
  // TODO: ZIO.succeed(1).repeat(Schedule.recurs(4).fold(0)(_ + _))
  // Schedule.recurs(4) outputs 0,1,2,3,4 (the repetition count)
  // fold accumulates: 0+0+1+2+3+4 = 10
  def exercise8: ZIO[Clock, Nothing, Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 4, s"Exercise 1 failed: expected 4, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 4, s"Exercise 2 failed: expected 4, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed: expected non-empty string, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 3, s"Exercise 4 failed: expected 3, got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 3, s"Exercise 5 failed: expected 3, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 >= 5, s"Exercise 6 failed: expected >= 5, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 >= 5, s"Exercise 7 failed: expected >= 5, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 10, s"Exercise 8 failed: expected 10, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio020_ScheduleCompose exercises passed!")
  }
}
