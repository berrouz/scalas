package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 040 - Stream Operations: transforming and filtering streams.
 *
 * Key operations: map, filter, mapM, flatMap, collect, mapConcat, tap, take/drop.
 */
object Zio040_StreamOps {

  // Exercise 1: Use map to double each element
  // TODO: ZStream(1, 2, 3).map(_ * 2) => 2, 4, 6
  val exercise1: ZStream[Any, Nothing, Int] = ???

  // Exercise 2: Use filter to keep only even numbers
  // TODO: ZStream(1, 2, 3, 4, 5, 6).filter(_ % 2 == 0) => 2, 4, 6
  val exercise2: ZStream[Any, Nothing, Int] = ???

  // Exercise 3: Use mapM to transform each element with an effect
  // TODO: ZStream(1, 2, 3).mapM(n => ZIO.succeed(n.toString)) => "1", "2", "3"
  val exercise3: ZStream[Any, Nothing, String] = ???

  // Exercise 4: Use flatMap to expand each element into a sub-stream
  // TODO: ZStream(1, 2, 3).flatMap(n => ZStream(n, n * 10)) => 1, 10, 2, 20, 3, 30
  val exercise4: ZStream[Any, Nothing, Int] = ???

  // Exercise 5: Use collect with a partial function
  // TODO: ZStream(1, 2, 3, 4, 5).collect { case n if n > 3 => n * 100 } => 400, 500
  val exercise5: ZStream[Any, Nothing, Int] = ???

  // Exercise 6: Use mapConcat to expand elements into iterables
  // TODO: ZStream("hello", "world").mapConcat(s => s.toList) => 'h','e','l','l','o','w','o','r','l','d'
  val exercise6: ZStream[Any, Nothing, Char] = ???

  // Exercise 7: Use tap to perform a side effect without changing the stream
  // TODO: ZStream(1, 2, 3).tap(n => UIO(println(s"seen: $n")))
  val exercise7: ZStream[Any, Nothing, Int] = ???

  // Exercise 8: Use take and drop to slice a stream
  // TODO: ZStream(1, 2, 3, 4, 5).drop(1).take(3) => 2, 3, 4
  val exercise8: ZStream[Any, Nothing, Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.runCollect)
    assert(r1 == Chunk(2, 4, 6), s"Exercise 1 failed: expected Chunk(2,4,6), got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.runCollect)
    assert(r2 == Chunk(2, 4, 6), s"Exercise 2 failed: expected Chunk(2,4,6), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.runCollect)
    assert(r3 == Chunk("1", "2", "3"), s"Exercise 3 failed: expected Chunk(1,2,3), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.runCollect)
    assert(r4 == Chunk(1, 10, 2, 20, 3, 30), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5.runCollect)
    assert(r5 == Chunk(400, 500), s"Exercise 5 failed: expected Chunk(400,500), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.runCollect)
    assert(r6.length == 10, s"Exercise 6 failed: expected 10 chars, got ${r6.length}")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.runCollect)
    assert(r7 == Chunk(1, 2, 3), s"Exercise 7 failed: expected Chunk(1,2,3), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8.runCollect)
    assert(r8 == Chunk(2, 3, 4), s"Exercise 8 failed: expected Chunk(2,3,4), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio040_StreamOps exercises passed!")
  }
}
