package org.shev4ik.interview.zio.level2_intermediate

import zio._
import scala.concurrent.{Future, ExecutionContext}

/**
 * ZIO 062 - Future Interop: converting between ZIO and Scala Futures.
 *
 * ZIO.fromFuture, toFuture, effectAsync for callback-based APIs.
 * Bridge between ZIO and legacy Future-based code.
 */
object Zio062_FutureInterop {

  implicit val ec: ExecutionContext = ExecutionContext.global

  // Exercise 1: Convert a Scala Future to ZIO
  // TODO: ZIO.fromFuture(implicit ec => Future.successful(42))
  val exercise1: Task[Int] = ???

  // Exercise 2: Convert a failing Future to ZIO
  // TODO: ZIO.fromFuture(implicit ec => Future.failed(new RuntimeException("boom")))
  val exercise2: Task[Int] = ???

  // Exercise 3: Convert a ZIO to a Future
  // TODO: runtime.unsafeRunToFuture(ZIO.succeed(42))
  val exercise3: Task[Int] = ???

  // Exercise 4: Use ZIO.fromFuture with an ExecutionContext
  // TODO: ZIO.fromFuture { implicit ec => Future { Thread.sleep(10); "done" } }
  val exercise4: Task[String] = ???

  // Exercise 5: Bridge a callback-based API to ZIO using effectAsync
  // TODO: ZIO.effectAsync[Any, Nothing, Int] { cb =>
  //         cb(ZIO.succeed(42))
  //       }
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use effectAsyncM for effectful callback registration
  // TODO: ZIO.effectAsyncM[Any, Nothing, Int] { cb =>
  //         UIO(cb(ZIO.succeed(99)))
  //       }
  val exercise6: UIO[Int] = ???

  // Exercise 7: Convert a ZIO to Future using the runtime
  // TODO: Use Runtime.default to create a Future from a ZIO effect
  def exercise7(effect: Task[String]): Future[String] = ???

  // Exercise 8: Round-trip: Future -> ZIO -> Future
  // TODO: Take a Future, convert to ZIO, transform, convert back to Future
  def exercise8(future: Future[Int]): Task[String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.either)
    assert(r2.isLeft, s"Exercise 2 failed: expected failure")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 42, s"Exercise 3 failed: expected 42, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == "done", s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 42, s"Exercise 5 failed: expected 42, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 99, s"Exercise 6 failed: expected 99, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7future = exercise7(ZIO.succeed("hello"))
    assert(r7future != null, "Exercise 7 failed: got null future")
    println(s"Exercise 7 passed: future created")

    val r8 = runtime.unsafeRun(exercise8(Future.successful(10)))
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty string")
    println(s"Exercise 8 passed: $r8")

    println("All Zio062_FutureInterop exercises passed!")
  }
}
