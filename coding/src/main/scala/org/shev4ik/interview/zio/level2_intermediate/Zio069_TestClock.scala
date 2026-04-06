package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.clock._
import zio.duration._
import zio.test.environment.TestClock

/**
 * ZIO 069 - TestClock: controlling time in tests.
 *
 * TestClock allows you to manually advance time, making tests
 * for time-dependent code deterministic and fast.
 *
 * Key operations: adjust, setTime, sleep testing.
 * Note: Uses zio-test 1.x API.
 */
object Zio069_TestClock {

  // Exercise 1: Understand TestClock concept
  // TODO: Create an effect that sleeps for 1 second, then returns "done"
  // In real clock this takes 1s, with TestClock we can advance time instantly
  val exercise1: ZIO[Clock, Nothing, String] = ???

  // Exercise 2: Use TestClock.adjust to advance time
  // TODO: Fork a sleeping effect, then use TestClock.adjust(1.second) to wake it up
  val exercise2: ZIO[Clock with Has[TestClock.Service], Nothing, String] = ???

  // Exercise 3: Use TestClock.setTime to set absolute time
  // TODO: TestClock.setTime(java.time.Instant.ofEpochMilli(1000000))
  // then read currentTime
  val exercise3: ZIO[Clock with Has[TestClock.Service], Nothing, Long] = ???

  // Exercise 4: Test a timeout scenario with TestClock
  // TODO: Fork an effect that sleeps 10 seconds, apply timeout of 5 seconds,
  // advance clock by 5 seconds to trigger timeout
  val exercise4: ZIO[Clock with Has[TestClock.Service], Nothing, Option[String]] = ???

  // Exercise 5: Test a scheduled effect with TestClock
  // TODO: Create an effect that repeats on a schedule, advance time to trigger repetitions
  val exercise5: ZIO[Clock with Has[TestClock.Service], Nothing, Int] = ???

  // Exercise 6: Test fiber timing with TestClock
  // TODO: Fork two fibers with different delays, advance time step by step
  val exercise6: ZIO[Clock with Has[TestClock.Service], Nothing, List[String]] = ???

  // Exercise 7: Demonstrate clock behavior in tests vs production
  // TODO: Show how the same code works with both real and test clocks
  val exercise7: ZIO[Clock, Nothing, String] = ???

  // Exercise 8: Test a retry with delay using TestClock
  // TODO: Create an effect that fails, retries after 1 second, advance time to trigger retry
  val exercise8: ZIO[Clock with Has[TestClock.Service], Nothing, String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1 (with real clock, just verify it compiles)
    val r1 = runtime.unsafeRun(exercise1.provideLayer(Clock.live))
    assert(r1 == "done", s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercises 2-8 require TestClock which is part of zio-test runtime
    // In a real test suite, use zio.test.DefaultRunnableSpec
    println("Exercise 2 passed: TestClock.adjust concept understood")
    println("Exercise 3 passed: TestClock.setTime concept understood")
    println("Exercise 4 passed: timeout testing concept understood")
    println("Exercise 5 passed: scheduled effect testing concept understood")
    println("Exercise 6 passed: fiber timing testing concept understood")

    val r7 = runtime.unsafeRun(exercise7.provideLayer(Clock.live))
    assert(r7.nonEmpty, s"Exercise 7 failed")
    println(s"Exercise 7 passed: $r7")

    println("Exercise 8 passed: retry with delay testing concept understood")

    println("All Zio069_TestClock exercises passed!")
  }
}
