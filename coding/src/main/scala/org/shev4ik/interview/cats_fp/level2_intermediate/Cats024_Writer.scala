package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 024 - Writer Monad
 *
 * Writer[W, A] carries a log (of type W, a Monoid) alongside a computation result A.
 * Useful for accumulating logs, audit trails, or any side-channel output.
 */
object Cats024_Writer {

  // Exercise 1: Writer monad basics - create a Writer with a log and value
  // TODO: Create a Writer that carries a Vector[String] log and an Int value.
  def exercise1_writerBasics(): Writer[Vector[String], Int] = {
    // Create a Writer with log Vector("Started computation") and value 42
    ???
  }

  // Exercise 2: Writer.apply - explicit construction using WriterT.apply
  // TODO: Create a Writer using Writer.apply or Writer(log, value).
  def exercise2_writerApply(): Writer[Vector[String], Int] = {
    // Create Writer with log and value
    // Writer(Vector("log entry"), 100)
    ???
  }

  // Exercise 3: run - extract both the log and value as a tuple
  // TODO: Use .run to get (log, value) tuple from a Writer.
  def exercise3_run(): (Vector[String], Int) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("hello"), 42)

    // Use .run to extract (log, value)
    ???
  }

  // Exercise 4: value - extract only the value, discarding the log
  // TODO: Use .value to get just the computation result.
  def exercise4_value(): Int = {
    val w: Writer[Vector[String], Int] = Writer(Vector("log1", "log2"), 99)

    // Use .value to extract just the Int
    ???
  }

  // Exercise 5: written - extract only the log, discarding the value
  // TODO: Use .written to get just the accumulated log.
  def exercise5_written(): Vector[String] = {
    val w: Writer[Vector[String], Int] = Writer(Vector("step1", "step2", "step3"), 0)

    // Use .written to extract just the log
    ???
  }

  // Exercise 6: tell - append to the log without changing the value
  // TODO: Use tell to add log entries in a for-comprehension.
  def exercise6_tell(): (Vector[String], Int) = {
    val computation: Writer[Vector[String], Int] = for {
      _ <- Vector("Starting").tell
      a = 10
      _ <- Vector("Computed a = 10").tell
      b = a * 2
      _ <- Vector(s"Computed b = $b").tell
    } yield b

    // Run the computation to get (log, value)
    ???
  }

  // Exercise 7: mapWritten - transform the log
  // TODO: Use mapWritten to modify the accumulated log.
  def exercise7_mapWritten(): (Vector[String], Int) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("hello", "world"), 42)

    // Use mapWritten to uppercase all log entries
    val result: Writer[Vector[String], Int] = ???

    result.run
  }

  // Exercise 8: reset - clear the log, keeping the value
  // TODO: Use reset to discard the log.
  def exercise8_reset(): (Vector[String], Int) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("log1", "log2"), 42)

    // Use reset to clear the log (sets it to Monoid.empty)
    val result: Writer[Vector[String], Int] = ???

    result.run
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_writerBasics()
    val (log1, val1) = r1.run
    assert(log1 == Vector("Started computation") && val1 == 42, s"Exercise 1 failed: ($log1, $val1)")
    println(s"Exercise 1 passed: Writer basics => log=$log1, value=$val1")

    // Exercise 2
    val r2 = exercise2_writerApply()
    val (log2, val2) = r2.run
    assert(log2 == Vector("log entry") && val2 == 100, s"Exercise 2 failed: ($log2, $val2)")
    println(s"Exercise 2 passed: Writer.apply => log=$log2, value=$val2")

    // Exercise 3
    val (log3, val3) = exercise3_run()
    assert(log3 == Vector("hello") && val3 == 42, s"Exercise 3 failed")
    println(s"Exercise 3 passed: run => log=$log3, value=$val3")

    // Exercise 4
    val r4 = exercise4_value()
    assert(r4 == 99, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: value => $r4")

    // Exercise 5
    val r5 = exercise5_written()
    assert(r5 == Vector("step1", "step2", "step3"), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: written => $r5")

    // Exercise 6
    val (log6, val6) = exercise6_tell()
    assert(val6 == 20, s"Exercise 6 failed: value=$val6")
    assert(log6.size == 3, s"Exercise 6 failed: log=$log6")
    println(s"Exercise 6 passed: tell => log=$log6, value=$val6")

    // Exercise 7
    val (log7, val7) = exercise7_mapWritten()
    assert(log7 == Vector("HELLO", "WORLD") && val7 == 42, s"Exercise 7 failed")
    println(s"Exercise 7 passed: mapWritten => log=$log7, value=$val7")

    // Exercise 8
    val (log8, val8) = exercise8_reset()
    assert(log8.isEmpty && val8 == 42, s"Exercise 8 failed: ($log8, $val8)")
    println(s"Exercise 8 passed: reset => log=$log8, value=$val8")

    println("\nAll Cats024_Writer exercises passed!")
  }
}
