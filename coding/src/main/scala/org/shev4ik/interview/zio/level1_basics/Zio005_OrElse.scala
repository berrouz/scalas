package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 005 - Advanced error recovery: orDie, option, some, none, optional, unsome.
 *
 * orDie converts typed errors into defects (unrecoverable).
 * option/some/none operate on ZIO[R, E, Option[A]] patterns.
 */
object Zio005_OrElse {

  // Exercise 1: Use orDie to convert a typed error into a defect
  // TODO: ZIO.fail(new RuntimeException("fatal")).orDie
  // orDie: ZIO[R, Throwable, A] => ZIO[R, Nothing, A] (dies on error)
  // For testing, catch the defect: use .catchAllCause to detect it
  val exercise1: UIO[String] = ???

  // Exercise 2: Use orDieWith to convert a custom error into a defect
  // TODO: ZIO.fail("error").orDieWith(e => new RuntimeException(e))
  // For testing, catch the cause and extract the message
  val exercise2: UIO[String] = ???

  // Exercise 3: Use .option to convert errors into None
  // TODO: ZIO.fail("error").option — gives UIO[Option[Nothing]]
  val exercise3: UIO[Option[Nothing]] = ???

  // Exercise 4: Use .option on a successful effect
  // TODO: ZIO.succeed(42).option — gives UIO[Option[Int]] => Some(42)
  val exercise4: UIO[Option[Int]] = ???

  // Exercise 5: Use .some to extract from ZIO[R, E, Option[A]] => ZIO[R, Option[E], A]
  // TODO: (ZIO.succeed(Some(42)): UIO[Option[Int]]).some
  val exercise5: IO[Option[Nothing], Int] = ???

  // Exercise 6: Use .none to assert the option is empty
  // TODO: Create a ZIO that succeeds with None, then use .none to get UIO[Unit] equivalent
  // .none on ZIO[R, E, Option[A]] succeeds with Unit if result is None
  val exercise6: IO[Option[Nothing], Unit] = ???

  // Exercise 7: Use .asSomeError to lift error into Option
  // TODO: ZIO.fail("error").asSomeError — transforms E to Option[E], so error becomes Some("error")
  // Then use .either to inspect
  val exercise7: UIO[Either[Option[String], Nothing]] = ???

  // Exercise 8: Use .optional to convert Option[E] errors back
  // TODO: ZIO.fail(Some("error"): Option[String]).optional — extracts Some to E, None to succeed with None
  // Then use .either to verify Left("error")
  val exercise8: UIO[Either[String, Option[Nothing]]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == "fatal", s"Exercise 1 failed: expected 'fatal', got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == "error", s"Exercise 2 failed: expected 'error', got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.isEmpty, s"Exercise 3 failed: expected None, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.contains(42), s"Exercise 4 failed: expected Some(42), got $r4")
    println(s"Exercise 4 passed: $r4")

    // Exercise 5
    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 42, s"Exercise 5 failed: expected 42, got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == (), s"Exercise 6 failed: expected (), got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == Left(Some("error")), s"Exercise 7 failed: expected Left(Some(error)), got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == Left("error"), s"Exercise 8 failed: expected Left(error), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio005_OrElse exercises passed!")
  }
}
