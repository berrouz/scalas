package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.blocking._

/**
 * ZIO 057 - Blocking: running blocking effects on the blocking thread pool.
 *
 * ZIO provides a separate thread pool for blocking operations.
 * Use effectBlocking, effectBlockingIO, effectBlockingCancelable,
 * effectBlockingInterrupt to safely run blocking code.
 */
object Zio057_Blocking {

  // Exercise 1: Use effectBlocking to run a blocking computation
  // TODO: effectBlocking(Thread.sleep(10); 42) — runs on blocking thread pool
  val exercise1: ZIO[Blocking, Throwable, Int] = ???

  // Exercise 2: Use effectBlockingIO to run blocking IO
  // TODO: effectBlockingIO { "result" } — wraps IOException errors
  val exercise2: ZIO[Blocking, java.io.IOException, String] = ???

  // Exercise 3: Use effectBlockingCancelable for cancellable blocking
  // TODO: effectBlockingCancelable(blocking)(cancel) — cancel is called on interruption
  val exercise3: ZIO[Blocking, Throwable, String] = ???

  // Exercise 4: Use effectBlockingInterrupt for thread-interrupt on cancel
  // TODO: effectBlockingInterrupt { Thread.sleep(10); "done" }
  val exercise4: ZIO[Blocking, Throwable, String] = ???

  // Exercise 5: Access the blocking executor
  // TODO: blocking.blockingExecutor.map(_.toString)
  val exercise5: ZIO[Blocking, Nothing, String] = ???

  // Exercise 6: Ensure a computation runs on the blocking pool
  // TODO: blocking.blocking(ZIO.effect(Thread.currentThread().getName))
  val exercise6: ZIO[Blocking, Throwable, String] = ???

  // Exercise 7: Use the Blocking service directly
  // TODO: ZIO.accessM[Blocking](_.get.effectBlocking("from-service"))
  val exercise7: ZIO[Blocking, Throwable, String] = ???

  // Exercise 8: Run multiple blocking operations in parallel
  // TODO: ZIO.foreachPar(List(1, 2, 3))(n => effectBlocking(n * 10))
  val exercise8: ZIO[Blocking, Throwable, List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.provideLayer(Blocking.live))
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.provideLayer(Blocking.live))
    assert(r2 == "result", s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.provideLayer(Blocking.live))
    assert(r3.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.provideLayer(Blocking.live))
    assert(r4 == "done", s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5.provideLayer(Blocking.live))
    assert(r5.nonEmpty, s"Exercise 5 failed")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.provideLayer(Blocking.live))
    assert(r6.nonEmpty, s"Exercise 6 failed")
    println(s"Exercise 6 passed: thread=$r6")

    val r7 = runtime.unsafeRun(exercise7.provideLayer(Blocking.live))
    assert(r7 == "from-service", s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8.provideLayer(Blocking.live))
    assert(r8.sorted == List(10, 20, 30), s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio057_Blocking exercises passed!")
  }
}
