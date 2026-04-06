package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 046 - Stream Merge: combining multiple streams.
 *
 * merge: interleave nondeterministically
 * interleave: alternate elements
 * concat (++): sequential
 * zip/zipWith: pair elements
 * cross: cartesian product
 */
object Zio046_StreamMerge {

  // Exercise 1: Merge two streams nondeterministically
  // TODO: ZStream(1, 2, 3).merge(ZStream(4, 5, 6)) — order may vary
  val exercise1: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 2: Use mergeAll to merge multiple streams
  // TODO: ZStream.mergeAll(2)(ZStream(1, 2), ZStream(3, 4), ZStream(5, 6))
  val exercise2: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 3: Interleave two streams (alternating elements)
  // TODO: ZStream(1, 3, 5).interleave(ZStream(2, 4, 6)) => 1, 2, 3, 4, 5, 6
  val exercise3: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 4: Use interleaveWith to control which stream to pull from
  // TODO: ZStream(1, 2, 3).interleaveWith(ZStream(10, 20, 30))(ZStream(true, false, true, false, true, false))
  val exercise4: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 5: Concatenate streams with ++
  // TODO: ZStream(1, 2) ++ ZStream(3, 4) ++ ZStream(5) => 1, 2, 3, 4, 5
  val exercise5: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 6: Zip two streams element-wise
  // TODO: ZStream(1, 2, 3).zip(ZStream("a", "b", "c")) => (1,"a"), (2,"b"), (3,"c")
  val exercise6: ZIO[Any, Nothing, Chunk[(Int, String)]] = ???

  // Exercise 7: Use zipWith to combine elements with a function
  // TODO: ZStream(1, 2, 3).zipWith(ZStream(10, 20, 30))(_ + _) => 11, 22, 33
  val exercise7: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 8: Use cross for cartesian product
  // TODO: ZStream(1, 2).cross(ZStream("a", "b")) => (1,"a"), (1,"b"), (2,"a"), (2,"b")
  val exercise8: ZIO[Any, Nothing, Chunk[(Int, String)]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1.toSet == Set(1, 2, 3, 4, 5, 6), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: ${r1.toSet}")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.toSet == Set(1, 2, 3, 4, 5, 6), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: ${r2.toSet}")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == Chunk(1, 2, 3, 4, 5, 6), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.length == 6, s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == Chunk(1, 2, 3, 4, 5), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == Chunk((1, "a"), (2, "b"), (3, "c")), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == Chunk(11, 22, 33), s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Chunk((1, "a"), (1, "b"), (2, "a"), (2, "b")), s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio046_StreamMerge exercises passed!")
  }
}
