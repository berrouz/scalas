package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 042 - Stream Sinks: consuming streams with ZSink.
 *
 * ZSink[R, E, I, L, Z] consumes a stream of I values and produces a Z.
 * Key sinks: collectAll, sum, count, head, foldLeft, foreach.
 */
object Zio042_StreamSink {

  // Exercise 1: Use ZSink.collectAll to collect all elements into a Chunk
  // TODO: ZStream(1, 2, 3).run(ZSink.collectAll) => Chunk(1, 2, 3)
  val exercise1: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 2: Use ZSink.sum to sum all elements
  // TODO: ZStream(1, 2, 3, 4, 5).run(ZSink.sum[Int]) => 15
  val exercise2: ZIO[Any, Nothing, Int] = ???

  // Exercise 3: Use ZSink.count to count elements
  // TODO: ZStream("a", "b", "c").run(ZSink.count) => 3L
  val exercise3: ZIO[Any, Nothing, Long] = ???

  // Exercise 4: Use ZSink.head to get the first element
  // TODO: ZStream(10, 20, 30).run(ZSink.head) => Some(10)
  val exercise4: ZIO[Any, Nothing, Option[Int]] = ???

  // Exercise 5: Use ZSink.foldLeft to accumulate a result
  // TODO: ZStream(1, 2, 3).run(ZSink.foldLeft(0)(_ + _)) => 6
  val exercise5: ZIO[Any, Nothing, Int] = ???

  // Exercise 6: Use ZSink.foreach to perform a side effect for each element
  // TODO: Create a Ref, then use ZSink.foreach to add each element to the Ref
  val exercise6: ZIO[Any, Nothing, List[Int]] = ???

  // Exercise 7: Use ZSink.foldLeft to build a string from stream elements
  // TODO: ZStream("a", "b", "c").run(ZSink.foldLeft("")(_ + _)) => "abc"
  val exercise7: ZIO[Any, Nothing, String] = ???

  // Exercise 8: Create a custom sink using ZSink.foldLeft that finds the maximum
  // TODO: ZStream(3, 1, 4, 1, 5, 9).run(ZSink.foldLeft(Int.MinValue)(math.max)) => 9
  val exercise8: ZIO[Any, Nothing, Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == Chunk(1, 2, 3), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 15, s"Exercise 2 failed: expected 15, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 3L, s"Exercise 3 failed: expected 3, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.contains(10), s"Exercise 4 failed: expected Some(10), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 6, s"Exercise 5 failed: expected 6, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.nonEmpty, s"Exercise 6 failed: got empty list")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == "abc", s"Exercise 7 failed: expected abc, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 9, s"Exercise 8 failed: expected 9, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio042_StreamSink exercises passed!")
  }
}
