package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 039 - ZStream Basics: creating streams in ZIO 1.x.
 *
 * ZStream[R, E, A] is a lazy, concurrent, resource-safe stream.
 * Key constructors: apply, fromIterable, fromEffect, repeat, unfold,
 * fromQueue, range, empty.
 */
object Zio039_StreamBasics {

  // Exercise 1: Create a stream from specific values
  // TODO: Use ZStream(1, 2, 3) to create a stream of integers
  val exercise1: ZStream[Any, Nothing, Int] = ???

  // Exercise 2: Create a stream from an iterable
  // TODO: Use ZStream.fromIterable(List("a", "b", "c"))
  val exercise2: ZStream[Any, Nothing, String] = ???

  // Exercise 3: Create a stream from a single effect
  // TODO: Use ZStream.fromEffect(ZIO.succeed(42)) to create a single-element stream
  val exercise3: ZStream[Any, Nothing, Int] = ???

  // Exercise 4: Create a stream that repeats a value using ZStream.repeat
  // TODO: Use ZStream.repeat(1) — note this is infinite, so take(5) when running
  val exercise4: ZStream[Any, Nothing, Int] = ???

  // Exercise 5: Create a stream using unfold
  // TODO: Use ZStream.unfold(0)(n => if (n < 5) Some((n, n + 1)) else None)
  // This produces 0, 1, 2, 3, 4
  val exercise5: ZStream[Any, Nothing, Int] = ???

  // Exercise 6: Create a stream from a Queue
  // TODO: Create a program that makes a Queue, offers values, then creates a stream from it
  // Use ZStream.fromQueue and take the expected number of elements
  val exercise6: ZIO[Any, Nothing, List[Int]] = ???

  // Exercise 7: Create a stream using ZStream.range
  // TODO: Use ZStream.range(1, 6) to create a stream of 1, 2, 3, 4, 5
  val exercise7: ZStream[Any, Nothing, Int] = ???

  // Exercise 8: Create an empty stream
  // TODO: Use ZStream.empty to create a stream with no elements
  val exercise8: ZStream[Any, Nothing, Nothing] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1.runCollect)
    assert(r1 == Chunk(1, 2, 3), s"Exercise 1 failed: expected Chunk(1,2,3), got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2.runCollect)
    assert(r2 == Chunk("a", "b", "c"), s"Exercise 2 failed: expected Chunk(a,b,c), got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3.runCollect)
    assert(r3 == Chunk(42), s"Exercise 3 failed: expected Chunk(42), got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4.take(5).runCollect)
    assert(r4 == Chunk(1, 1, 1, 1, 1), s"Exercise 4 failed: expected five 1s, got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5.runCollect)
    assert(r5 == Chunk(0, 1, 2, 3, 4), s"Exercise 5 failed: expected 0..4, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.nonEmpty, s"Exercise 6 failed: got empty list")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7.runCollect)
    assert(r7 == Chunk(1, 2, 3, 4, 5), s"Exercise 7 failed: expected 1..5, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8.runCollect)
    assert(r8.isEmpty, s"Exercise 8 failed: expected empty, got $r8")
    println(s"Exercise 8 passed: empty stream")

    println("All Zio039_StreamBasics exercises passed!")
  }
}
