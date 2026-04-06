package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 045 - Stream Resources: resource-safe streaming with ZManaged.
 *
 * ZStream.managed, ZStream.bracket ensure resources are properly
 * acquired and released even in the presence of errors or interruption.
 */
object Zio045_StreamResource {

  // Exercise 1: Create a stream from a ZManaged resource
  // TODO: ZStream.managed(ZManaged.succeed("resource")) produces a single-element stream
  val exercise1: ZStream[Any, Nothing, String] = ???

  // Exercise 2: Use ZStream.bracket to acquire/release a resource
  // TODO: ZStream.bracket(UIO("acquired"))(_ => UIO(println("released")))
  val exercise2: ZStream[Any, Nothing, String] = ???

  // Exercise 3: Create a managed stream with finalization tracking
  // TODO: Use a Ref to track acquire/release, return the Ref for verification
  val exercise3: ZIO[Any, Nothing, (List[String], String)] = ???

  // Exercise 4: Ensure finalization runs even on error
  // TODO: Create a bracketed stream that fails after emitting, verify cleanup runs
  val exercise4: ZIO[Any, Nothing, List[String]] = ???

  // Exercise 5: Create a stream from a managed resource that produces multiple values
  // TODO: ZStream.managed(ZManaged.succeed(List(1,2,3))).flatMap(ZStream.fromIterable(_))
  val exercise5: ZStream[Any, Nothing, Int] = ???

  // Exercise 6: Chain managed streams — each resource is cleaned up properly
  // TODO: Create two bracketed streams and concatenate them with ++
  val exercise6: ZIO[Any, Nothing, List[String]] = ???

  // Exercise 7: Use ensuring on a stream for cleanup
  // TODO: ZStream(1, 2, 3).ensuring(UIO(println("stream done")))
  val exercise7: ZStream[Any, Nothing, Int] = ???

  // Exercise 8: Demonstrate resource safety with interleaved streams
  // TODO: Create a bracketed stream, map over it, verify resource cleanup
  val exercise8: ZIO[Any, Nothing, (Chunk[Int], Boolean)] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.runCollect)
    assert(r1 == Chunk("resource"), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.runCollect)
    assert(r2 == Chunk("acquired"), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3._2.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: events=${r3._1}, value=${r3._2}")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.contains("released"), s"Exercise 4 failed: cleanup didn't run: $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5.runCollect)
    assert(r5 == Chunk(1, 2, 3), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.nonEmpty, s"Exercise 6 failed: got empty")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.runCollect)
    assert(r7 == Chunk(1, 2, 3), s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8._2, s"Exercise 8 failed: resource not cleaned up")
    println(s"Exercise 8 passed: values=${r8._1}, cleaned=${r8._2}")

    println("All Zio045_StreamResource exercises passed!")
  }
}
