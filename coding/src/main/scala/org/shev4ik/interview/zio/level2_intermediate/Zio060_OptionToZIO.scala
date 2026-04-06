package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 060 - Option to ZIO: converting between Option and ZIO.
 *
 * ZIO.fromOption, ZIO.none, ZIO.some, asSomeError, optional,
 * someOrFail, someOrFailException, option.
 */
object Zio060_OptionToZIO {

  // Exercise 1: Convert an Option to a ZIO using ZIO.fromOption
  // TODO: ZIO.fromOption(Some(42)) => succeeds with 42
  // ZIO.fromOption(None) => fails with Option[Nothing] (unit error)
  val exercise1: IO[Option[Nothing], Int] = ???

  // Exercise 2: Create a ZIO that succeeds with None
  // TODO: ZIO.none => UIO[Option[Nothing]]
  val exercise2: UIO[Option[Nothing]] = ???

  // Exercise 3: Create a ZIO that succeeds with Some(42)
  // TODO: ZIO.some(42) => UIO[Option[Int]]
  val exercise3: UIO[Option[Int]] = ???

  // Exercise 4: Use asSomeError to convert error to Option[Error]
  // TODO: ZIO.fail("err").asSomeError => IO[Option[String], Nothing]
  val exercise4: IO[Option[String], Nothing] = ???

  // Exercise 5: Use optional to convert IO[Option[E], A] to IO[E, Option[A]]
  // TODO: ZIO.fromOption(Some(42)).optional => IO[Nothing, Option[Int]]
  val exercise5: UIO[Option[Int]] = ???

  // Exercise 6: Use someOrFail to convert ZIO[R, E, Option[A]] to ZIO[R, E, A]
  // TODO: ZIO.succeed(Some(42)).someOrFail("not found") => IO[String, Int]
  val exercise6: IO[String, Int] = ???

  // Exercise 7: Use someOrFailException to fail with NoSuchElementException on None
  // TODO: ZIO.succeed(Option.empty[Int]).someOrFailException => Task[Int]
  val exercise7: IO[Throwable, Int] = ???

  // Exercise 8: Use .option to convert any error to None
  // TODO: ZIO.fail("err").option => UIO[Option[Nothing]]
  val exercise8: UIO[Option[Nothing]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.isEmpty, s"Exercise 2 failed: expected None, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.contains(42), s"Exercise 3 failed: expected Some(42), got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.either)
    assert(r4 == Left(Some("err")), s"Exercise 4 failed: got $r4")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.contains(42), s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.either)
    assert(r7.isLeft, s"Exercise 7 failed: expected failure, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.isEmpty, s"Exercise 8 failed: expected None, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio060_OptionToZIO exercises passed!")
  }
}
