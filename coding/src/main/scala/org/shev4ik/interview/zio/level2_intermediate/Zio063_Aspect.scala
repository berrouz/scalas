package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 063 - Aspects: cross-cutting concerns as composable middleware.
 *
 * Aspects are functions that transform ZIO effects, adding behavior
 * like logging, timing, retrying, or authentication.
 * In ZIO 1.x, aspects are typically modeled as ZIO => ZIO functions.
 */
object Zio063_Aspect {

  // Exercise 1: Create a simple logging aspect
  // TODO: def loggingAspect[R, E, A](label: String)(zio: ZIO[R, E, A]): ZIO[R, E, A]
  // Prints "Starting: $label" before and "Completed: $label" after
  def exercise1[R, E, A](label: String)(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  // Exercise 2: Create a timing aspect that measures execution time
  // TODO: Wrap an effect to measure and print how long it takes
  def exercise2[R <: Clock, E, A](label: String)(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  // Exercise 3: Create a retry aspect
  // TODO: Wrap an effect to retry up to N times on failure
  def exercise3[R, A](n: Int)(zio: ZIO[R, Throwable, A]): ZIO[R, Throwable, A] = ???

  // Exercise 4: Create an authentication aspect
  // TODO: Check for a token in Has[String], fail if empty
  def exercise4[E, A](zio: ZIO[Has[String], E, A]): ZIO[Has[String], Any, A] = ???

  // Exercise 5: Compose two aspects
  // TODO: Combine logging and timing aspects
  def exercise5[R <: Clock, E, A](label: String)(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  // Exercise 6: Create a metric-counting aspect using Ref
  // TODO: Increment a counter each time the effect is run
  def exercise6[R, E, A](counter: Ref[Int])(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  // Exercise 7: Create an error-logging aspect
  // TODO: Log errors using tapError without changing behavior
  def exercise7[R, A](zio: ZIO[R, Throwable, A]): ZIO[R, Throwable, A] = ???

  // Exercise 8: Create a caching aspect using Ref
  // TODO: Cache the result of an effect, return cached value on subsequent calls
  def exercise8[R, E, A](cache: Ref[Option[A]])(zio: ZIO[R, E, A]): ZIO[R, E, A] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1("test")(ZIO.succeed(42)))
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2("timed")(ZIO.succeed("fast")).provideLayer(Clock.live))
    assert(r2 == "fast", s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3(3)(ZIO.succeed("ok")))
    assert(r3 == "ok", s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4(ZIO.succeed("protected")).provideLayer(ZLayer.succeed("valid-token")).either)
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5("composed")(ZIO.succeed(100)).provideLayer(Clock.live))
    assert(r5 == 100, s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(for {
      counter <- Ref.make(0)
      _ <- exercise6(counter)(ZIO.succeed("a"))
      _ <- exercise6(counter)(ZIO.succeed("b"))
      count <- counter.get
    } yield count)
    assert(r6 == 2, s"Exercise 6 failed: expected 2, got $r6")
    println(s"Exercise 6 passed: count=$r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7(ZIO.succeed("ok")))
    assert(r7 == "ok", s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(for {
      cache <- Ref.make(Option.empty[Int])
      v1 <- exercise8(cache)(ZIO.succeed(42))
      v2 <- exercise8(cache)(ZIO.succeed(99))
    } yield (v1, v2))
    assert(r8 == (42, 42), s"Exercise 8 failed: expected (42,42), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio063_Aspect exercises passed!")
  }
}
