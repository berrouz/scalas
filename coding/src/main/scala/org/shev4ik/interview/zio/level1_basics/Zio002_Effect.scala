package org.shev4ik.interview.zio.level1_basics

import zio._

import scala.util.Try

/**
 * ZIO 002 - Wrapping Side Effects and Converting from Standard Scala Types
 *
 * == Core Concept: Referential Transparency ==
 * ZIO captures side effects as values, restoring referential transparency. Instead of executing
 * a side effect immediately, ZIO wraps it in a data structure (a "blueprint") that describes
 * the effect. The effect only runs when the ZIO runtime interprets it. This is the fundamental
 * difference between `val x = println("hi")` (eager, impure) and `val x = ZIO.effect(println("hi"))`
 * (lazy, pure description).
 *
 * == ZIO.effect (ZIO 1.x) / ZIO.attempt (ZIO 2.x) ==
 * Wraps a block of code that may throw exceptions. The code is captured lazily (by-name parameter)
 * and only evaluated when the ZIO runtime runs it. Any thrown exception is caught and placed
 * into the error channel as a `Throwable`, yielding `Task[A]` (alias for `ZIO[Any, Throwable, A]`).
 *
 * {{{
 *   val parsed: Task[Int] = ZIO.effect("42".toInt)  // safe — exception caught if format is wrong
 * }}}
 *
 * == ZIO.effectTotal (ZIO 1.x) / ZIO.succeed (ZIO 2.x for total effects) ==
 * Wraps code that is guaranteed to never throw. The error type is `Nothing`, yielding `UIO[A]`.
 * If the code actually throws, the exception becomes a **defect** (untyped, uncaught) — so only
 * use this when you are truly certain no exceptions can occur (e.g., `println`, pure arithmetic).
 *
 * == ZIO.effectBlocking / ZIO.attemptBlocking ==
 * Wraps blocking I/O (e.g., `Thread.sleep`, JDBC calls, file reads). The effect is shifted to
 * the blocking thread pool so it does not starve the main ZIO fiber executor. This is critical
 * for maintaining throughput in high-concurrency applications.
 *
 * == Conversions from Scala standard types ==
 * | Method             | Input type                        | Error channel          |
 * |--------------------|-----------------------------------|------------------------|
 * | `ZIO.fromOption`   | `Option[A]`                       | `Option[Nothing]`      |
 * | `ZIO.fromEither`   | `Either[E, A]`                    | `E`                    |
 * | `ZIO.fromTry`      | `scala.util.Try[A]`               | `Throwable`            |
 * | `ZIO.fromFuture`   | `ExecutionContext => Future[A]`    | `Throwable`            |
 *
 * == Interview Tip ==
 * '''Q: When should you use ZIO.succeed vs ZIO.attempt vs ZIO.fromTry?'''
 *
 * - Use `ZIO.succeed` (or `ZIO.effectTotal`) for pure values or code guaranteed not to throw.
 *   Example: `ZIO.succeed(42)`, `ZIO.succeed(println("debug"))`.
 * - Use `ZIO.attempt` (or `ZIO.effect`) for any code that might throw an exception. This is the
 *   safe default when wrapping legacy/Java code. Example: `ZIO.attempt(Source.fromFile("data.csv"))`.
 * - Use `ZIO.fromTry` when you already have a `Try[A]` value (e.g., from a library that returns Try).
 *   It is equivalent to `ZIO.attempt` but operates on an already-evaluated Try rather than a by-name block.
 *
 * '''Follow-up:''' "What happens if you accidentally use `ZIO.succeed` with code that throws?"
 * The exception becomes a **defect** — it is not captured in the typed error channel and will
 * crash the fiber. This is why `ZIO.attempt` is the safer default for anything that might fail.
 *
 * == Real-World Context ==
 * In production services, `ZIO.attempt`/`ZIO.effect` is the primary bridge between the impure
 * Java/Scala ecosystem (JDBC, HTTP clients, file I/O) and the pure ZIO world. Teams typically
 * wrap third-party library calls with `ZIO.attempt` at the boundary layer (repository, client modules)
 * and keep the core business logic as pure ZIO compositions.
 */
object Zio002_Effect {

  // Exercise 1: Wrap a side-effecting computation that might throw
  // TODO: Use ZIO.effect to wrap: "42".toInt
  val exercise1: Task[Int] = ???

  // Exercise 2: Wrap a total (non-throwing) side effect
  // TODO: Use ZIO.effectTotal to wrap: println("hello") — returns Unit
  val exercise2: UIO[Unit] = ???

  // Exercise 3: Wrap a blocking call
  // TODO: Use ZIO.effectBlocking to wrap: Thread.sleep(10) then return "done"
  val exercise3: Task[String] = ???

  // Exercise 4: Convert an Option to a ZIO — Some case
  // TODO: Use ZIO.fromOption to convert Some(42) into a ZIO
  // Note: fromOption gives IO[Option[Nothing], A] — the error is None when the Option is empty
  val exercise4: IO[Option[Nothing], Int] = ???

  // Exercise 5: Convert an Either to a ZIO
  // TODO: Use ZIO.fromEither to convert Right(42): Either[String, Int]
  val exercise5: IO[String, Int] = ???

  // Exercise 6: Convert a Try to a ZIO
  // TODO: Use ZIO.fromTry to convert Try("42".toInt)
  val exercise6: Task[Int] = ???

  // Exercise 7: Convert a Future to a ZIO
  // TODO: Use ZIO.fromFuture to convert a Future that succeeds with 42
  // Hint: ZIO.fromFuture(implicit ec => scala.concurrent.Future.successful(42))
  val exercise7: Task[Int] = ???

  // Exercise 8: Wrap a side effect that throws an exception
  // TODO: Use ZIO.effect to wrap: throw new RuntimeException("oops")
  // Then recover the error into a string using .catchAll(e => ZIO.succeed(e.getMessage))
  val exercise8: UIO[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == (), s"Exercise 2 failed: expected (), got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "done", s"Exercise 3 failed: expected done, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == 42, s"Exercise 4 failed: expected 42, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 42, s"Exercise 5 failed: expected 42, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 42, s"Exercise 7 failed: expected 42, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == "oops", s"Exercise 8 failed: expected oops, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio002_Effect exercises passed!")
  }
}
