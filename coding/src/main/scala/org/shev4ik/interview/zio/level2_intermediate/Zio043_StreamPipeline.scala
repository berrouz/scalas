package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 043 - Stream Pipelines: using ZTransducer to transform streams.
 *
 * ZTransducer[R, E, I, O] transforms chunks of I into chunks of O.
 * Use via (transduce) to apply a transducer to a stream.
 * Compose pipelines: stream >>> transducer >>> sink.
 */
object Zio043_StreamPipeline {

  // Exercise 1: Use via with ZTransducer.identity (pass-through)
  // TODO: ZStream(1, 2, 3).via(ZTransducer.identity) => 1, 2, 3
  val exercise1: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 2: Use ZTransducer.splitLines to split a byte stream into lines
  // TODO: ZStream("hello\nworld\n").via(ZTransducer.splitLines).runCollect
  val exercise2: ZIO[Any, Nothing, Chunk[String]] = ???

  // Exercise 3: Use transduce (via) with a mapping transducer
  // TODO: Create a stream and apply ZTransducer.fromFunction[Int, String](_.toString)
  val exercise3: ZIO[Any, Nothing, Chunk[String]] = ???

  // Exercise 4: Compose a transducer with a sink using >>>
  // TODO: ZStream(1, 2, 3).run(ZTransducer.fromFunction[Int, Int](_ * 2) >>> ZSink.collectAll)
  val exercise4: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 5: Use ZTransducer.collectAllN to batch elements
  // TODO: ZStream(1, 2, 3, 4, 5).via(ZTransducer.collectAllN(2)) groups into Lists of size 2
  val exercise5: ZIO[Any, Nothing, Chunk[List[Int]]] = ???

  // Exercise 6: Chain multiple transducers
  // TODO: Apply ZTransducer.fromFunction[Int, Int](_ + 1) then another that doubles
  val exercise6: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 7: Use stream >>> sink pattern
  // TODO: ZStream(1, 2, 3) >>> ZSink.sum => 6
  val exercise7: ZIO[Any, Nothing, Int] = ???

  // Exercise 8: Create a pipeline that filters, transforms, and collects
  // TODO: ZStream(1,2,3,4,5).filter(_ > 2).map(_ * 10).runCollect => Chunk(30,40,50)
  val exercise8: ZIO[Any, Nothing, Chunk[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == Chunk(1, 2, 3), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == Chunk("hello", "world"), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == Chunk("1", "2", "3"), s"Exercise 3 failed: got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4 == Chunk(2, 4, 6), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.length >= 2, s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.nonEmpty, s"Exercise 6 failed: got empty")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 6, s"Exercise 7 failed: expected 6, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Chunk(30, 40, 50), s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio043_StreamPipeline exercises passed!")
  }
}
