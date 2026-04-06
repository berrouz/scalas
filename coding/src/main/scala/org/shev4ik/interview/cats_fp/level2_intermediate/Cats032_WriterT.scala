package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 032 - WriterT Monad Transformer
 *
 * WriterT[F, W, A] wraps F[(W, A)], combining an effect F
 * with log accumulation W. When F = Id, WriterT becomes Writer.
 */
object Cats032_WriterT {

  // Using Option as our outer effect
  type Eff[A] = Option[A]
  type Log = Vector[String]

  // Exercise 1: WriterT creation - wrap an F[(W, A)]
  // TODO: Create a WriterT from an Option[(Vector[String], Int)].
  def exercise1_creation(): WriterT[Eff, Log, Int] = {
    val wrapped: Eff[(Log, Int)] = Some((Vector("created"), 42))

    // Wrap in WriterT
    ???
  }

  // Exercise 2: run - extract F[(W, A)] from WriterT
  // TODO: Use .run to unwrap the WriterT and get the underlying F[(W, A)].
  def exercise2_run(): Eff[(Log, Int)] = {
    val wt: WriterT[Eff, Log, Int] =
      WriterT(Some((Vector("hello"), 42)))

    // Extract the underlying Option[(Vector[String], Int)]
    ???
  }

  // Exercise 3: value - extract only the value part F[A]
  // TODO: Use .value to get just the value, discarding the log.
  def exercise3_value(): Eff[Int] = {
    val wt: WriterT[Eff, Log, Int] =
      WriterT(Some((Vector("log1", "log2"), 99)))

    // Get just the value
    ???
  }

  // Exercise 4: written - extract only the log part F[W]
  // TODO: Use .written to get just the log, discarding the value.
  def exercise4_written(): Eff[Log] = {
    val wt: WriterT[Eff, Log, Int] =
      WriterT(Some((Vector("step1", "step2"), 0)))

    // Get just the log
    ???
  }

  // Exercise 5: tell - append to the log
  // TODO: Use WriterT.tell to add log entries in a for-comprehension.
  def exercise5_tell(): Eff[(Log, Int)] = {
    val program: WriterT[Eff, Log, Int] = for {
      _ <- WriterT.tell[Eff, Log](Vector("starting"))
      a <- WriterT.liftF[Eff, Log, Int](Some(10))
      _ <- WriterT.tell[Eff, Log](Vector(s"got a = $a"))
      b <- WriterT.liftF[Eff, Log, Int](Some(a * 2))
      _ <- WriterT.tell[Eff, Log](Vector(s"computed b = $b"))
    } yield b

    // Run the program
    ???
  }

  // Exercise 6: mapWritten - transform the log
  // TODO: Use mapWritten to modify the log type or contents.
  def exercise6_mapWritten(): Eff[(Log, Int)] = {
    val wt: WriterT[Eff, Log, Int] =
      WriterT(Some((Vector("hello", "world"), 42)))

    // Use mapWritten to uppercase all log entries
    val result: WriterT[Eff, Log, Int] = ???

    result.run
  }

  // Exercise 7: liftF - lift an F[A] into WriterT with empty log
  // TODO: Use WriterT.liftF to lift an Option value into WriterT.
  def exercise7_liftF(): Eff[(Log, Int)] = {
    val opt: Eff[Int] = Some(42)

    // Lift into WriterT (log should be empty/Monoid.empty)
    val wt: WriterT[Eff, Log, Int] = ???

    wt.run
  }

  // Exercise 8: Combining WriterT - build a multi-step logged computation
  // TODO: Build a program that combines multiple WriterT steps,
  //       where None in the outer Option short-circuits.
  def exercise8_combining(): (Eff[(Log, String)], Eff[(Log, String)]) = {
    def step(name: String, value: Option[Int]): WriterT[Eff, Log, Int] =
      for {
        v <- WriterT.liftF[Eff, Log, Int](value)
        _ <- WriterT.tell[Eff, Log](Vector(s"$name = $v"))
      } yield v

    val success: WriterT[Eff, Log, String] = for {
      a <- step("a", Some(10))
      b <- step("b", Some(20))
    } yield s"sum = ${a + b}"

    val failure: WriterT[Eff, Log, String] = for {
      a <- step("a", Some(10))
      b <- step("b", None)  // This will short-circuit!
    } yield s"sum = ${a + b}"

    // Run both
    val r1: Eff[(Log, String)] = ???
    val r2: Eff[(Log, String)] = ???
    (r1, r2)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_creation().run
    assert(r1 == Some((Vector("created"), 42)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: WriterT creation => $r1")

    // Exercise 2
    val r2 = exercise2_run()
    assert(r2 == Some((Vector("hello"), 42)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: run => $r2")

    // Exercise 3
    val r3 = exercise3_value()
    assert(r3 == Some(99), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: value => $r3")

    // Exercise 4
    val r4 = exercise4_written()
    assert(r4 == Some(Vector("step1", "step2")), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: written => $r4")

    // Exercise 5
    val r5 = exercise5_tell()
    assert(r5 == Some((Vector("starting", "got a = 10", "computed b = 20"), 20)),
      s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: tell => $r5")

    // Exercise 6
    val r6 = exercise6_mapWritten()
    assert(r6 == Some((Vector("HELLO", "WORLD"), 42)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: mapWritten => $r6")

    // Exercise 7
    val r7 = exercise7_liftF()
    assert(r7 == Some((Vector.empty[String], 42)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: liftF => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_combining()
    assert(r8a == Some((Vector("a = 10", "b = 20"), "sum = 30")), s"Exercise 8 failed: success=$r8a")
    assert(r8b == None, s"Exercise 8 failed: failure=$r8b")
    println(s"Exercise 8 passed: combining => success=$r8a, failure=$r8b")

    println("\nAll Cats032_WriterT exercises passed!")
  }
}
