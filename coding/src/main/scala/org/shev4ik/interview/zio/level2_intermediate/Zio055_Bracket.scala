package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 055 - Bracket: safe resource acquisition and release.
 *
 * bracket(acquire)(release)(use) ensures release always runs.
 * bracketExit gives access to the Exit value in the release function.
 * ensuring and onExit provide simpler finalization.
 */
object Zio055_Bracket {

  // Exercise 1: Use bracket for acquire/use/release
  // TODO: ZIO.bracket(acquire)(release)(use)
  // acquire: UIO("resource"), release: _ => UIO(println("released")), use: r => UIO(r.length)
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use bracketExit to access Exit in release
  // TODO: ZIO.bracketExit(acquire)((r, exit) => UIO(println(s"exit: $exit")))(use)
  val exercise2: UIO[String] = ???

  // Exercise 3: Use bracket_ (bracket with no resource value in release)
  // TODO: ZIO.bracket_(acquire)(release)(use) — release doesn't receive the resource
  val exercise3: UIO[String] = ???

  // Exercise 4: Demonstrate that release runs even when use fails
  // TODO: bracket(acquire)(release)(failingUse) — track that release ran via Ref
  val exercise4: UIO[Boolean] = ???

  // Exercise 5: Use ensuring to run a finalizer after any effect
  // TODO: ZIO.succeed(42).ensuring(UIO(println("done"))) => 42
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use onExit to run a handler based on Exit
  // TODO: ZIO.succeed("ok").onExit(exit => UIO(println(s"exited with: $exit")))
  val exercise6: UIO[String] = ???

  // Exercise 7: Use onError to run a handler only on failure
  // TODO: ZIO.fail("err").onError(cause => UIO(println(s"error: $cause"))).either
  val exercise7: UIO[Either[String, Nothing]] = ???

  // Exercise 8: Nested brackets — inner and outer resources both get released
  // TODO: bracket(outerAcquire)(outerRelease) { outer =>
  //         bracket(innerAcquire)(innerRelease) { inner => use(outer, inner) }
  //       }
  val exercise8: UIO[List[String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 > 0, s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.nonEmpty, s"Exercise 2 failed: got empty")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed: got empty")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4, s"Exercise 4 failed: release didn't run")
    println(s"Exercise 4 passed: release ran on failure")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 42, s"Exercise 5 failed: expected 42, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == "ok", s"Exercise 6 failed: expected ok, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == Left("err"), s"Exercise 7 failed: expected Left(err), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.length >= 2, s"Exercise 8 failed: expected at least 2 release events, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio055_Bracket exercises passed!")
  }
}
