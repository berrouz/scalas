package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.stream._

/**
 * ZIO 044 - Stream Error Handling: dealing with errors in streams.
 *
 * Streams can fail with errors. Use catchAll, orElse, mapError,
 * refineOrDie to handle and transform stream errors.
 */
object Zio044_StreamError {

  // Exercise 1: Use catchAll to recover from a stream error
  // TODO: ZStream.fail("error").catchAll(_ => ZStream(1, 2, 3))
  val exercise1: ZStream[Any, Nothing, Int] = ???

  // Exercise 2: Use orElse to provide a fallback stream
  // TODO: ZStream.fail("boom").orElse(ZStream("fallback"))
  val exercise2: ZStream[Any, Nothing, String] = ???

  // Exercise 3: Use mapError to transform error types
  // TODO: ZStream.fail("string-error").mapError(e => new RuntimeException(e))
  val exercise3: ZStream[Any, RuntimeException, Nothing] = ???

  // Exercise 4: Use refineOrDie to narrow error types
  // TODO: Create a stream that fails with Throwable, refine to only handle RuntimeException
  val exercise4: ZStream[Any, RuntimeException, Int] = ???

  // Exercise 5: Create a stream that partially fails
  // TODO: ZStream(1, 2, 3) ++ ZStream.fail("mid-error") — then recover with catchAll
  val exercise5: ZStream[Any, Nothing, Int] = ???

  // Exercise 6: Use Stream[E, A] type alias (ZStream[Any, E, A])
  // TODO: Create a Stream[String, Int] that succeeds with values 1, 2, 3
  val exercise6: Stream[String, Int] = ???

  // Exercise 7: Recover from errors and provide default values
  // TODO: Create a stream that fails, catchAll to provide Chunk(0) as default
  val exercise7: ZIO[Any, Nothing, Chunk[Int]] = ???

  // Exercise 8: Log errors while recovering
  // TODO: Create a stream that fails, use catchAll to log the error and continue with defaults
  val exercise8: ZIO[Any, Nothing, Chunk[String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.runCollect)
    assert(r1 == Chunk(1, 2, 3), s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.runCollect)
    assert(r2 == Chunk("fallback"), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3result = runtime.unsafeRun(exercise3.either.runCollect)
    assert(r3result.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: error mapped to RuntimeException")

    val r4result = runtime.unsafeRun(exercise4.either.runCollect)
    println(s"Exercise 4 passed: refined error type")

    val r5 = runtime.unsafeRun(exercise5.runCollect)
    assert(r5.nonEmpty, s"Exercise 5 failed: got empty")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.runCollect)
    assert(r6 == Chunk(1, 2, 3), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == Chunk(0), s"Exercise 7 failed: expected Chunk(0), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed: got empty")
    println(s"Exercise 8 passed: $r8")

    println("All Zio044_StreamError exercises passed!")
  }
}
