package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 061 - Either to ZIO: converting between Either and ZIO.
 *
 * ZIO.fromEither, absolve, either, mapBoth, foldM, reject,
 * refineOrDie, tapError.
 */
object Zio061_EitherToZIO {

  // Exercise 1: Convert an Either to ZIO using ZIO.fromEither
  // TODO: ZIO.fromEither(Right(42)) => succeeds with 42
  val exercise1: IO[String, Int] = ???

  // Exercise 2: Use absolve to convert ZIO[R, E, Either[E, A]] to ZIO[R, E, A]
  // TODO: ZIO.succeed(Right(42): Either[String, Int]).absolve
  val exercise2: IO[String, Int] = ???

  // Exercise 3: Use .either to convert ZIO[R, E, A] to ZIO[R, Nothing, Either[E, A]]
  // TODO: ZIO.fail("err").either => UIO[Either[String, Nothing]]
  val exercise3: UIO[Either[String, Nothing]] = ???

  // Exercise 4: Use mapBoth to transform both error and success
  // TODO: ZIO.fail("err").mapBoth(_.length, identity) => IO[Int, Nothing]
  val exercise4: IO[Int, Nothing] = ???

  // Exercise 5: Use foldM to handle both success and failure with effects
  // TODO: ZIO.fail("err").foldM(e => ZIO.succeed(e.length), a => ZIO.succeed(a))
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use reject to conditionally fail
  // TODO: ZIO.succeed(42).reject { case n if n > 40 => "too big" }
  val exercise6: IO[String, Int] = ???

  // Exercise 7: Use refineOrDie to narrow error type
  // TODO: ZIO.effect(throw new RuntimeException("boom")).refineOrDie { case e: RuntimeException => e.getMessage }
  val exercise7: IO[String, Nothing] = ???

  // Exercise 8: Use tapError to perform a side effect on error without changing it
  // TODO: ZIO.fail("err").tapError(e => UIO(println(s"Error: $e"))).either
  val exercise8: UIO[Either[String, Nothing]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 42, s"Exercise 2 failed: expected 42, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == Left("err"), s"Exercise 3 failed: expected Left(err), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.either)
    assert(r4 == Left(3), s"Exercise 4 failed: expected Left(3), got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 3, s"Exercise 5 failed: expected 3, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6.either)
    assert(r6 == Left("too big"), s"Exercise 6 failed: expected Left(too big), got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.either)
    assert(r7 == Left("boom"), s"Exercise 7 failed: expected Left(boom), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Left("err"), s"Exercise 8 failed: expected Left(err), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio061_EitherToZIO exercises passed!")
  }
}
