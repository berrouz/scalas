package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 032 - Ensuring and Bracket: resource safety patterns.
 *
 * ensuring runs a finalizer regardless of outcome.
 * bracket provides acquire-use-release semantics.
 * These guarantee cleanup even on failure or interruption.
 */
object Zio032_Ensuring {

  // Exercise 1: Use ensuring to run a finalizer on success
  // TODO: Create a Ref[Boolean](false).
  // ZIO.succeed(42).ensuring(ref.set(true))
  // Check ref is true after.
  val exercise1: UIO[Boolean] = ???

  // Exercise 2: Use ensuring to run a finalizer on failure
  // TODO: Create a Ref[Boolean](false).
  // ZIO.fail("error").ensuring(ref.set(true)).either
  // Check ref is true after.
  val exercise2: UIO[Boolean] = ???

  // Exercise 3: Use onExit to run a finalizer with the Exit value
  // TODO: Create a Ref[String]("").
  // ZIO.succeed(42).onExit {
  //   case Exit.Success(v) => ref.set(s"success:$v")
  //   case Exit.Failure(_) => ref.set("failure")
  // }
  // Check ref value.
  val exercise3: UIO[String] = ???

  // Exercise 4: Use onError to run cleanup only on error
  // TODO: Create a Ref[Boolean](false).
  // ZIO.fail("error").onError(_ => ref.set(true)).either
  // ref should be true.
  val exercise4: UIO[Boolean] = ???

  // Exercise 5: Use onInterrupt to run cleanup only on interruption
  // TODO: Create a Ref[Boolean](false).
  // Fork ZIO.never.onInterrupt(ref.set(true)), interrupt it, check ref.
  val exercise5: UIO[Boolean] = ???

  // Exercise 6: Use bracket for acquire-use-release
  // TODO: Create a Ref[List[String]].
  // ZIO.bracket(
  //   ref.update("acquire" :: _).as("resource")  // acquire
  // )(
  //   _ => ref.update("release" :: _).unit        // release
  // )(
  //   r => ref.update(s"use:$r" :: _).unit        // use
  // )
  // Check ref contains all three stages.
  val exercise6: UIO[List[String]] = ???

  // Exercise 7: Use bracketExit to get the Exit value in the release
  // TODO: Create a Ref[String]("").
  // ZIO.bracketExit(ZIO.succeed("resource"))(
  //   (_, exit: Exit[Any, Any]) => ref.set(if (exit.succeeded) "clean" else "dirty").unit
  // )(
  //   _ => ZIO.succeed(42)
  // )
  // Check ref is "clean".
  val exercise7: UIO[String] = ???

  // Exercise 8: Bracket with failure in the use phase
  // TODO: Create a Ref[Boolean](false).
  // ZIO.bracket(ZIO.unit)(
  //   _ => ref.set(true).unit  // release still runs on failure
  // )(
  //   _ => ZIO.fail("use failed")
  // ).either
  // Check ref is true (release ran despite failure).
  val exercise8: UIO[Boolean] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1, "Exercise 1 failed: ensuring should have run on success")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2, "Exercise 2 failed: ensuring should have run on failure")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "success:42", s"Exercise 3 failed: expected 'success:42', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4, "Exercise 4 failed: onError should have run")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5, "Exercise 5 failed: onInterrupt should have run")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.contains("acquire") && r6.contains("release"), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "clean", s"Exercise 7 failed: expected 'clean', got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8, "Exercise 8 failed: release should run even when use fails")
    println(s"Exercise 8 passed: $r8")

    println("All Zio032_Ensuring exercises passed!")
  }
}
