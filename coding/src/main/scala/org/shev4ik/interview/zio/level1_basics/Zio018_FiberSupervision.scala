package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 018 - Fiber supervision: daemon fibers, forkDaemon, ensuring, onInterrupt.
 *
 * By default, child fibers are supervised — they are interrupted when the parent completes.
 * Daemon fibers run independently of their parent.
 */
object Zio018_FiberSupervision {

  // Exercise 1: Use daemon to create a daemon fiber (not interrupted when parent ends)
  // TODO: ZIO.never.daemon.fork — creates a daemon fiber
  // Interrupt it manually and return "ok"
  val exercise1: UIO[String] = ???

  // Exercise 2: Use forkDaemon to fork an effect as a daemon fiber directly
  // TODO: for { fiber <- ZIO.never.forkDaemon; _ <- fiber.interrupt } yield "daemon interrupted"
  val exercise2: UIO[String] = ???

  // Exercise 3: Use interruptFork to interrupt a fiber without waiting
  // TODO: for { fiber <- ZIO.never.fork; _ <- fiber.interruptFork } yield "fire and forget"
  val exercise3: UIO[String] = ???

  // Exercise 4: Use forkManaged to get a managed fiber that is interrupted on release
  // TODO: ZIO.never.forkManaged.use(fiber => fiber.interrupt.as("managed"))
  val exercise4: UIO[String] = ???

  // Exercise 5: Use interruptAllChildren to interrupt all child fibers
  // TODO: (for {
  //   _ <- ZIO.never.fork
  //   _ <- ZIO.never.fork
  // } yield ()).interruptAllChildren *> ZIO.succeed("children interrupted")
  val exercise5: UIO[String] = ???

  // Exercise 6: Use ensuring to run a finalizer regardless of outcome
  // TODO: Create a Ref[Boolean], run an effect with .ensuring(ref.set(true)), check ref
  val exercise6: UIO[Boolean] = ???

  // Exercise 7: Use ensuring on a failing effect
  // TODO: Create a Ref[Boolean], run ZIO.fail("err").ensuring(ref.set(true)).either, check ref
  val exercise7: UIO[Boolean] = ???

  // Exercise 8: Use onInterrupt to run cleanup only on interruption
  // TODO: Create a Ref[Boolean].
  // Fork ZIO.never.onInterrupt(ref.set(true)), interrupt it, check ref is true.
  val exercise8: UIO[Boolean] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == "ok", s"Exercise 1 failed: expected 'ok', got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "daemon interrupted", s"Exercise 2 failed")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "fire and forget", s"Exercise 3 failed")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "managed", s"Exercise 4 failed")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == "children interrupted", s"Exercise 5 failed")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6, "Exercise 6 failed: ensuring should have run")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7, "Exercise 7 failed: ensuring should have run on failure")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8, "Exercise 8 failed: onInterrupt should have run")
    println(s"Exercise 8 passed: $r8")

    println("All Zio018_FiberSupervision exercises passed!")
  }
}
