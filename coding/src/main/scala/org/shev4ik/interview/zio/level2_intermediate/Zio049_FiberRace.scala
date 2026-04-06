package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.duration._

/**
 * ZIO 049 - Fiber Racing: running effects concurrently and taking the first result.
 *
 * race: first to complete wins, loser is interrupted
 * raceAll, raceWith, raceFirst, raceEither
 */
object Zio049_FiberRace {

  // Exercise 1: Race two effects — the faster one wins
  // TODO: ZIO.succeed(1).delay(100.millis).race(ZIO.succeed(2).delay(50.millis)) => 2
  val exercise1: ZIO[clock.Clock, Nothing, Int] = ???

  // Exercise 2: Race multiple effects with raceAll
  // TODO: ZIO.raceAll(ZIO.succeed(1).delay(100.millis), List(ZIO.succeed(2).delay(50.millis), ZIO.succeed(3).delay(200.millis)))
  val exercise2: ZIO[clock.Clock, Nothing, Int] = ???

  // Exercise 3: Use raceWith to handle both outcomes
  // TODO: left.raceWith(right)(leftDone => ..., rightDone => ...)
  val exercise3: ZIO[clock.Clock, Nothing, String] = ???

  // Exercise 4: Use raceFirst — like race but returns the Exit of the winner
  // TODO: ZIO.succeed("fast").raceFirst(ZIO.never)
  val exercise4: UIO[String] = ???

  // Exercise 5: Use raceEither to know which side won
  // TODO: fast.raceEither(slow) => Left(fastValue) or Right(slowValue)
  val exercise5: ZIO[clock.Clock, Nothing, Either[String, String]] = ???

  // Exercise 6: Implement timeout via race
  // TODO: Race an effect against ZIO.sleep(timeout) *> ZIO.fail("timeout")
  val exercise6: ZIO[clock.Clock, Nothing, Option[String]] = ???

  // Exercise 7: Race to find the first successful result
  // TODO: Race multiple effects where some fail; first success wins
  val exercise7: ZIO[clock.Clock, Nothing, Int] = ???

  // Exercise 8: Race with a fallback value
  // TODO: Race an effect against a delayed fallback, return winner
  val exercise8: ZIO[clock.Clock, Nothing, String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.provideLayer(clock.Clock.live))
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.provideLayer(clock.Clock.live))
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.provideLayer(clock.Clock.live))
    assert(r3.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "fast", s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5.provideLayer(clock.Clock.live))
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.provideLayer(clock.Clock.live))
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.provideLayer(clock.Clock.live))
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8.provideLayer(clock.Clock.live))
    assert(r8.nonEmpty, s"Exercise 8 failed")
    println(s"Exercise 8 passed: $r8")

    println("All Zio049_FiberRace exercises passed!")
  }
}
