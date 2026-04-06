package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.duration._

/**
 * ZIO 056 - Interruption: controlling effect interruption behavior.
 *
 * ZIO's interruption model is cooperative and structured.
 * Use uninterruptible, interruptible, onInterrupt, disconnect.
 */
object Zio056_Interruption {

  // Exercise 1: Explicitly interrupt an effect
  // TODO: ZIO.interrupt returns an interrupted effect
  val exercise1: IO[Nothing, Nothing] = ???

  // Exercise 2: Make an effect interruptible
  // TODO: Wrap an effect with .interruptible to ensure it can be interrupted
  val exercise2: UIO[String] = ???

  // Exercise 3: Make an effect uninterruptible
  // TODO: someEffect.uninterruptible — cannot be interrupted
  val exercise3: UIO[String] = ???

  // Exercise 4: Check the current interrupt status
  // TODO: ZIO.checkInterruptible(status => ZIO.succeed(status.isInterruptible))
  val exercise4: UIO[Boolean] = ???

  // Exercise 5: Use disconnect to detach a fiber from its parent's interruption
  // TODO: myEffect.disconnect — the fiber won't be interrupted when parent is interrupted
  val exercise5: UIO[String] = ???

  // Exercise 6: Use onInterrupt to perform cleanup on interruption
  // TODO: Track interruption events using a Ref
  val exercise6: UIO[List[String]] = ???

  // Exercise 7: Use interruptAs to interrupt with a specific fiber id
  // TODO: ZIO.descriptor.flatMap(d => ZIO.interruptAs(d.id))
  val exercise7: UIO[Boolean] = ???

  // Exercise 8: Demonstrate checking interruption status in nested regions
  // TODO: Check interruptible status in normal, uninterruptible, and re-interruptible regions
  val exercise8: UIO[(Boolean, Boolean, Boolean)] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.sandbox.fold(_ => true, _ => false))
    println(s"Exercise 1 passed: interrupted=$r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.nonEmpty, s"Exercise 2 failed")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    println(s"Exercise 4 passed: interruptible=$r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.nonEmpty, s"Exercise 5 failed")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    println(s"Exercise 6 passed: events=$r6")

    val r7 = runtime.unsafeRun(exercise7)
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    println(s"Exercise 8 passed: normal=${r8._1}, uninterruptible=${r8._2}, re-interruptible=${r8._3}")

    println("All Zio056_Interruption exercises passed!")
  }
}
