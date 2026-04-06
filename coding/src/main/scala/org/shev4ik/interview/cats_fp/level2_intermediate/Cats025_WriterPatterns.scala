package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 025 - Writer Patterns
 *
 * Advanced patterns with Writer: logging, Chain-based accumulation,
 * listen, censor, swap, bimap, and WriterT transformer.
 */
object Cats025_WriterPatterns {

  // Exercise 1: Writer for logging - build a computation with log trail
  // TODO: Use Writer to create a factorial function that logs each step.
  def exercise1_logging(): (Vector[String], Int) = {
    def factorial(n: Int): Writer[Vector[String], Int] = {
      if (n <= 1)
        Writer(Vector(s"factorial($n) = 1"), 1)
      else for {
        prev <- factorial(n - 1)
        _ <- Vector(s"factorial($n) = ${n * prev}").tell
      } yield n * prev
    }

    // Compute factorial(5) and return (log, result)
    ???
  }

  // Exercise 2: Writer with Vector - Vector is a good log type (append-friendly)
  // TODO: Chain multiple logged operations using Vector as the log type.
  def exercise2_withVector(): (Vector[String], Int) = {
    def logged[A](msg: String, value: A): Writer[Vector[String], A] =
      Writer(Vector(msg), value)

    // Chain: start with 1, multiply by 2, add 10, multiply by 3
    val computation: Writer[Vector[String], Int] = for {
      a <- logged("start: 1", 1)
      b <- logged(s"multiply by 2: ${a * 2}", a * 2)
      c <- logged(s"add 10: ${b + 10}", b + 10)
      d <- logged(s"multiply by 3: ${c * 3}", c * 3)
    } yield d

    ???
  }

  // Exercise 3: Writer with Chain - Chain has O(1) append, better than Vector for large logs
  // TODO: Use Chain instead of Vector for the log type.
  def exercise3_withChain(): (Chain[String], Int) = {
    def logged[A](msg: String, value: A): Writer[Chain[String], A] =
      Writer(Chain.one(msg), value)

    val computation: Writer[Chain[String], Int] = for {
      a <- logged("init: 10", 10)
      b <- logged(s"doubled: ${a * 2}", a * 2)
    } yield b

    // Run the computation
    ???
  }

  // Exercise 4: listen - get both the value and the log produced by a sub-computation
  // TODO: Use listen to inspect the log produced so far.
  def exercise4_listen(): (Vector[String], (Int, Vector[String])) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("step1", "step2"), 42)

    // Use .listen to get Writer[W, (A, W)] - the value becomes a pair of (value, log)
    val listened: Writer[Vector[String], (Int, Vector[String])] = ???

    listened.run
  }

  // Exercise 5: censor - modify the log after computation
  // TODO: Use censor to filter or transform the log.
  def exercise5_censor(): (Vector[String], Int) = {
    val w: Writer[Vector[String], Int] =
      Writer(Vector("DEBUG: x=1", "INFO: started", "DEBUG: y=2", "INFO: done"), 42)

    // Use censor to keep only INFO messages
    val infoOnly: Writer[Vector[String], Int] = ???

    infoOnly.run
  }

  // Exercise 6: swap - swap the log and value positions
  // TODO: Use swap to exchange the log and value.
  def exercise6_swap(): (Int, Vector[String]) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("log"), 42)

    // Use swap to get Writer[Int, Vector[String]]
    val swapped: Writer[Int, Vector[String]] = ???

    swapped.run
  }

  // Exercise 7: bimap - transform both log and value simultaneously
  // TODO: Use bimap to transform both the log and value at once.
  def exercise7_bimap(): (List[String], String) = {
    val w: Writer[Vector[String], Int] = Writer(Vector("hello", "world"), 42)

    // Use bimap to convert log to List and value to String
    val result: Writer[List[String], String] = ???

    result.run
  }

  // Exercise 8: WriterT - Writer as a monad transformer
  // TODO: Use WriterT to combine Writer with another effect (Option).
  //       WriterT[F, W, A] is Writer inside F.
  def exercise8_writerT(): Option[(Vector[String], Int)] = {
    // WriterT[Option, Vector[String], Int] = Option[(Vector[String], Int)]

    val computation: WriterT[Option, Vector[String], Int] = for {
      a <- WriterT.liftF[Option, Vector[String], Int](Some(10))
      _ <- WriterT.tell[Option, Vector[String]](Vector("got a = 10"))
      b <- WriterT.liftF[Option, Vector[String], Int](Some(a * 2))
      _ <- WriterT.tell[Option, Vector[String]](Vector(s"computed b = $b"))
    } yield b

    // Run to get Option[(Vector[String], Int)]
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (log1, val1) = exercise1_logging()
    assert(val1 == 120, s"Exercise 1 failed: value=$val1")
    assert(log1.nonEmpty, s"Exercise 1 failed: log is empty")
    println(s"Exercise 1 passed: logging => value=$val1, log=$log1")

    // Exercise 2
    val (log2, val2) = exercise2_withVector()
    assert(val2 == 36, s"Exercise 2 failed: value=$val2") // ((1*2)+10)*3 = 36
    assert(log2.size == 4, s"Exercise 2 failed: log size=${log2.size}")
    println(s"Exercise 2 passed: Vector log => value=$val2, log=$log2")

    // Exercise 3
    val (log3, val3) = exercise3_withChain()
    assert(val3 == 20, s"Exercise 3 failed: value=$val3")
    assert(log3.toList.size == 2, s"Exercise 3 failed: log=$log3")
    println(s"Exercise 3 passed: Chain log => value=$val3, log=${log3.toList}")

    // Exercise 4
    val (log4, (val4, innerLog4)) = exercise4_listen()
    assert(val4 == 42 && innerLog4 == Vector("step1", "step2"), s"Exercise 4 failed")
    println(s"Exercise 4 passed: listen => value=$val4, innerLog=$innerLog4")

    // Exercise 5
    val (log5, val5) = exercise5_censor()
    assert(log5 == Vector("INFO: started", "INFO: done"), s"Exercise 5 failed: log=$log5")
    println(s"Exercise 5 passed: censor => log=$log5, value=$val5")

    // Exercise 6
    val (log6, val6) = exercise6_swap()
    assert(log6 == 42 && val6 == Vector("log"), s"Exercise 6 failed: ($log6, $val6)")
    println(s"Exercise 6 passed: swap => log=$log6, value=$val6")

    // Exercise 7
    val (log7, val7) = exercise7_bimap()
    assert(log7 == List("hello", "world") && val7 == "42", s"Exercise 7 failed")
    println(s"Exercise 7 passed: bimap => log=$log7, value=$val7")

    // Exercise 8
    val r8 = exercise8_writerT()
    assert(r8 == Some((Vector("got a = 10", "computed b = 20"), 20)), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: WriterT => $r8")

    println("\nAll Cats025_WriterPatterns exercises passed!")
  }
}
