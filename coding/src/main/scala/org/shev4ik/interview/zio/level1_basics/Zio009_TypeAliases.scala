package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 009 - Type aliases and environment providing.
 *
 * Task[A]     = ZIO[Any, Throwable, A]
 * UIO[A]      = ZIO[Any, Nothing, A]
 * URIO[R, A]  = ZIO[R, Nothing, A]
 * IO[E, A]    = ZIO[Any, E, A]
 * RIO[R, A]   = ZIO[R, Throwable, A]
 */
object Zio009_TypeAliases {

  // Exercise 1: Create a Task[Int] that succeeds with 42
  // TODO: Task is ZIO[Any, Throwable, A]
  val exercise1: Task[Int] = ???

  // Exercise 2: Create a UIO[String] that succeeds with "infallible"
  // TODO: UIO is ZIO[Any, Nothing, A] — cannot fail
  val exercise2: UIO[String] = ???

  // Exercise 3: Create a URIO[Int, String] that accesses the environment
  // TODO: URIO[R, A] = ZIO[R, Nothing, A]. Use ZIO.access[Int](r => s"env: $r")
  val exercise3: URIO[Int, String] = ???

  // Exercise 4: Create an IO[String, Int] that fails with "oops"
  // TODO: IO[E, A] = ZIO[Any, E, A]
  val exercise4: IO[String, Int] = ???

  // Exercise 5: Create a RIO[Int, String] that accesses the environment
  // TODO: RIO[R, A] = ZIO[R, Throwable, A]. Access the Int environment.
  val exercise5: RIO[Int, String] = ???

  // Exercise 6: Narrow a ZIO type — convert ZIO[Any, String, Int] to IO[String, Int]
  // TODO: They are the same type! Just assign it.
  val exercise6: IO[String, Int] = ???

  // Exercise 7: Widen a UIO[Int] to a Task[Int]
  // TODO: UIO[Int] is ZIO[Any, Nothing, Int]. Task[Int] is ZIO[Any, Throwable, Int].
  // Nothing <: Throwable, so UIO is a subtype of Task.
  val exercise7: Task[Int] = ???

  // Exercise 8: Use provide to supply an environment to a URIO
  // TODO: ZIO.access[Int](_.toString).provide(42) — eliminates the R requirement
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "infallible", s"Exercise 2 failed: expected 'infallible', got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.provide(100))
    assert(r3 == "env: 100", s"Exercise 3 failed: expected 'env: 100', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.either)
    assert(r4 == Left("oops"), s"Exercise 4 failed: expected Left(oops), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5.provide(99))
    assert(r5 == "99", s"Exercise 5 failed: expected '99', got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.either)
    assert(r6.isLeft || r6.isRight, "Exercise 6 passed: it's an IO[String, Int]")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 42, s"Exercise 7 failed: expected 42, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == "42", s"Exercise 8 failed: expected '42', got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio009_TypeAliases exercises passed!")
  }
}
