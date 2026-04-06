package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 041 - Stream Chunks: working with Chunk for efficient batching.
 *
 * Chunk[A] is ZIO's immutable array-backed collection optimized for streaming.
 * Streams internally work with chunks for performance.
 */
object Zio041_StreamChunks {

  // Exercise 1: Create a Chunk from values
  // TODO: Use Chunk(1, 2, 3) to create a Chunk of integers
  val exercise1: Chunk[Int] = ???

  // Exercise 2: Create a stream from a Chunk
  // TODO: Use ZStream.fromChunk(Chunk("a", "b", "c"))
  val exercise2: ZStream[Any, Nothing, String] = ???

  // Exercise 3: Create a stream from multiple chunks
  // TODO: Use ZStream.fromChunks(Chunk(1, 2), Chunk(3, 4), Chunk(5))
  val exercise3: ZStream[Any, Nothing, Int] = ???

  // Exercise 4: Use mapChunks to transform entire chunks at once
  // TODO: ZStream(1, 2, 3, 4).mapChunks(chunk => chunk.map(_ * 10))
  val exercise4: ZStream[Any, Nothing, Int] = ???

  // Exercise 5: Use chunkN to re-chunk a stream into chunks of size N
  // TODO: ZStream(1, 2, 3, 4, 5, 6).chunkN(2) — each chunk will have 2 elements
  val exercise5: ZStream[Any, Nothing, Int] = ???

  // Exercise 6: Collect chunks from a stream using runCollect
  // TODO: ZStream.fromChunks(Chunk(1, 2), Chunk(3)).runCollect returns a single Chunk(1,2,3)
  val exercise6: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 7: Use Chunk operations — map, filter, flatMap
  // TODO: Chunk(1, 2, 3, 4, 5).filter(_ % 2 == 0).map(_ * 100)
  val exercise7: Chunk[Int] = ???

  // Exercise 8: Demonstrate Chunk performance — convert between Chunk and Array
  // TODO: Create a Chunk from an Array and convert back: Chunk.fromArray(Array(1,2,3)).toArray
  val exercise8: Array[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    assert(exercise1 == Chunk(1, 2, 3), s"Exercise 1 failed: got $exercise1")
    println(s"Exercise 1 passed: $exercise1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2.runCollect)
    assert(r2 == Chunk("a", "b", "c"), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3.runCollect)
    assert(r3 == Chunk(1, 2, 3, 4, 5), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4.runCollect)
    assert(r4 == Chunk(10, 20, 30, 40), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5.runCollect)
    assert(r5 == Chunk(1, 2, 3, 4, 5, 6), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == Chunk(1, 2, 3), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    assert(exercise7 == Chunk(200, 400), s"Exercise 7 failed: got $exercise7")
    println(s"Exercise 7 passed: $exercise7")

    // Exercise 8
    assert(exercise8.toList == List(1, 2, 3), s"Exercise 8 failed: got ${exercise8.toList}")
    println(s"Exercise 8 passed: ${exercise8.toList}")

    println("All Zio041_StreamChunks exercises passed!")
  }
}
