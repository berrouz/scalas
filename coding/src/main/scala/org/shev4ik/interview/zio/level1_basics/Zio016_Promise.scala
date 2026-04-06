package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 016 - Promise: single-assignment concurrent variable.
 *
 * Promise[E, A] can be completed exactly once.
 * await blocks until the promise is completed.
 */
object Zio016_Promise {

  // Exercise 1: Create a Promise and complete it with succeed
  // TODO: for { p <- Promise.make[Nothing, Int]; _ <- p.succeed(42); v <- p.await } yield v
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a Promise and fail it
  // TODO: for { p <- Promise.make[String, Int]; _ <- p.fail("error"); v <- p.await.either } yield v
  val exercise2: UIO[Either[String, Int]] = ???

  // Exercise 3: Use complete to complete a Promise with a ZIO effect
  // TODO: for { p <- Promise.make[Nothing, Int]; _ <- p.complete(ZIO.succeed(42)); v <- p.await } yield v
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use isDone to check if a Promise is completed
  // TODO: for { p <- Promise.make[Nothing, Int]; before <- p.isDone; _ <- p.succeed(1); after <- p.isDone } yield (before, after)
  val exercise4: UIO[(Boolean, Boolean)] = ???

  // Exercise 5: Use completeWith to complete with an effect (does not execute the effect, stores it)
  // TODO: for { p <- Promise.make[Nothing, Int]; _ <- p.completeWith(ZIO.succeed(99)); v <- p.await } yield v
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use interrupt to complete a Promise with interruption
  // TODO: for { p <- Promise.make[Nothing, Int]; _ <- p.interrupt; v <- p.await.run } yield v.interrupted
  val exercise6: UIO[Boolean] = ???

  // Exercise 7: Use Promise to coordinate between two fibers
  // TODO: Create a promise. Fork a fiber that awaits the promise.
  // Complete the promise with 42, join the fiber.
  val exercise7: UIO[Int] = ???

  // Exercise 8: Demonstrate that succeed on an already-completed Promise returns false
  // TODO: for { p <- Promise.make[Nothing, Int]; r1 <- p.succeed(1); r2 <- p.succeed(2) } yield (r1, r2)
  // First succeed returns true, second returns false
  val exercise8: UIO[(Boolean, Boolean)] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == Left("error"), s"Exercise 2 failed: expected Left(error), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == (false, true), s"Exercise 4 failed: expected (false,true), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 99, s"Exercise 5 failed: expected 99, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6, s"Exercise 6 failed: expected true (interrupted)")
    println(s"Exercise 6 passed: interrupted=$r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 42, s"Exercise 7 failed: expected 42, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == (true, false), s"Exercise 8 failed: expected (true,false), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio016_Promise exercises passed!")
  }
}
