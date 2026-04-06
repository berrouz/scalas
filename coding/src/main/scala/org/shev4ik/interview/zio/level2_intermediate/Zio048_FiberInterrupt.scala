package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.duration._

/**
 * ZIO 048 - Fiber Interruption: controlling fiber lifecycle.
 *
 * Interruption is cooperative in ZIO. Use uninterruptible to protect
 * critical sections, onInterrupt for cleanup, and disconnect for
 * background operations.
 */
object Zio048_FiberInterrupt {

  // Exercise 1: Interrupt a running fiber
  // TODO: Fork a long-running fiber, then interrupt it, verify it was interrupted
  val exercise1: UIO[Boolean] = ???

  // Exercise 2: Make an effect uninterruptible
  // TODO: Create an effect wrapped in .uninterruptible — it cannot be interrupted
  val exercise2: UIO[String] = ???

  // Exercise 3: Make a region interruptible within an uninterruptible block
  // TODO: ZIO.uninterruptible { ... ZIO.interruptible(myEffect) ... }
  val exercise3: UIO[String] = ???

  // Exercise 4: Use disconnect to let a fiber run independently
  // TODO: Fork a fiber, disconnect it so parent interruption doesn't affect it
  val exercise4: UIO[String] = ???

  // Exercise 5: Use onInterrupt to run cleanup when a fiber is interrupted
  // TODO: Create an effect with onInterrupt handler that records cleanup
  val exercise5: UIO[List[String]] = ???

  // Exercise 6: Use interruptAs to interrupt with a specific FiberId
  // TODO: Create a fiber, interrupt it using ZIO.interruptAs(fiberId)
  val exercise6: UIO[Boolean] = ???

  // Exercise 7: Check the current interrupt status
  // TODO: Use ZIO.checkInterruptible to determine if the current region is interruptible
  val exercise7: UIO[Boolean] = ???

  // Exercise 8: Combine interruptible and uninterruptible regions
  // TODO: Create a workflow where acquisition is uninterruptible but use is interruptible
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1, s"Exercise 1 failed: fiber should have been interrupted")
    println(s"Exercise 1 passed: interrupted=$r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.nonEmpty, s"Exercise 2 failed: got empty string")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed: got empty string")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.nonEmpty, s"Exercise 4 failed")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.nonEmpty, s"Exercise 5 failed: cleanup didn't run")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6, s"Exercise 6 failed")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    println(s"Exercise 7 passed: interruptible=$r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed")
    println(s"Exercise 8 passed: $r8")

    println("All Zio048_FiberInterrupt exercises passed!")
  }
}
