package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 021 - Kleisli
 *
 * Kleisli[F, A, B] represents a function A => F[B].
 * It enables composition of effectful functions, similar to how
 * andThen composes pure functions A => B.
 */
object Cats021_Kleisli {

  // Exercise 1: Kleisli creation - wrap a function A => F[B]
  // TODO: Create a Kleisli that parses a String to an Int wrapped in Option.
  def exercise1_creation(): Kleisli[Option, String, Int] = {
    // Create a Kleisli from a function String => Option[Int]
    // Use Kleisli(f) or Kleisli.apply(f)
    ???
  }

  // Exercise 2: Kleisli.apply - same as creation, explicit apply
  // TODO: Create a Kleisli using Kleisli.apply that validates a number is positive.
  def exercise2_apply(): Kleisli[Option, Int, Int] = {
    // Kleisli[Option, Int, Int] that returns Some(n) if n > 0, else None
    ???
  }

  // Exercise 3: run - execute a Kleisli with an input
  // TODO: Create a Kleisli and run it with a specific input.
  def exercise3_run(): (Option[Int], Option[Int]) = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    // Run parse with "42" and "abc"
    val result1: Option[Int] = ???
    val result2: Option[Int] = ???
    (result1, result2)
  }

  // Exercise 4: map - transform the output of a Kleisli
  // TODO: Create a Kleisli that parses a string to Int, then map to double it.
  def exercise4_map(): Option[Int] = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    // Map over parse to double the result, then run with "21"
    ???
  }

  // Exercise 5: flatMap - chain Kleisli computations
  // TODO: Use flatMap to chain: parse string -> validate positive -> return result.
  def exercise5_flatMap(): (Option[Int], Option[Int]) = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    val validatePositive: Int => Kleisli[Option, String, Int] =
      n => Kleisli(_ => if (n > 0) Some(n) else None)

    // Use flatMap to chain parse and validatePositive
    val pipeline: Kleisli[Option, String, Int] = ???

    // Run with "42" and "-5"
    (pipeline.run("42"), pipeline.run("-5"))
  }

  // Exercise 6: compose (<<<) - compose Kleislis right-to-left
  // TODO: Compose two Kleislis using <<< (compose).
  //       g <<< f means: first apply f, then apply g.
  def exercise6_compose(): Option[Boolean] = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    val isPositive: Kleisli[Option, Int, Boolean] =
      Kleisli(n => Some(n > 0))

    // Compose: isPositive <<< parse (first parse, then check positive)
    val composed: Kleisli[Option, String, Boolean] = ???

    composed.run("42")
  }

  // Exercise 7: andThen (>>>) - compose Kleislis left-to-right
  // TODO: Compose two Kleislis using >>> (andThen).
  //       f >>> g means: first apply f, then apply g.
  def exercise7_andThen(): Option[String] = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    val classify: Kleisli[Option, Int, String] =
      Kleisli(n => Some(if (n > 0) "positive" else if (n < 0) "negative" else "zero"))

    // Compose: parse >>> classify (first parse, then classify)
    val pipeline: Kleisli[Option, String, String] = ???

    pipeline.run("42")
  }

  // Exercise 8: local - pre-process the input before running the Kleisli
  // TODO: Use local to adapt the input type of a Kleisli.
  //       local transforms the input before the Kleisli sees it.
  def exercise8_local(): Option[Int] = {
    val parseLength: Kleisli[Option, String, Int] =
      Kleisli(s => Some(s.length))

    // Use local to create a Kleisli[Option, Int, Int] that first converts
    // an Int to its string representation, then computes its length
    val digitCount: Kleisli[Option, Int, Int] = ???

    digitCount.run(12345)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_creation()
    assert(r1.run("42") == Some(42), s"Exercise 1 failed: ${r1.run("42")}")
    println(s"Exercise 1 passed: Kleisli creation => ${r1.run("42")}")

    // Exercise 2
    val r2 = exercise2_apply()
    assert(r2.run(5) == Some(5) && r2.run(-1) == None, s"Exercise 2 failed")
    println(s"Exercise 2 passed: Kleisli.apply => pos=${r2.run(5)}, neg=${r2.run(-1)}")

    // Exercise 3
    val (r3a, r3b) = exercise3_run()
    assert(r3a == Some(42) && r3b == None, s"Exercise 3 failed: ($r3a, $r3b)")
    println(s"Exercise 3 passed: run => valid=$r3a, invalid=$r3b")

    // Exercise 4
    val r4 = exercise4_map()
    assert(r4 == Some(42), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: map => $r4")

    // Exercise 5
    val (r5a, r5b) = exercise5_flatMap()
    assert(r5a == Some(42) && r5b == None, s"Exercise 5 failed: ($r5a, $r5b)")
    println(s"Exercise 5 passed: flatMap => pos=$r5a, neg=$r5b")

    // Exercise 6
    val r6 = exercise6_compose()
    assert(r6 == Some(true), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: compose (<<<) => $r6")

    // Exercise 7
    val r7 = exercise7_andThen()
    assert(r7 == Some("positive"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: andThen (>>>) => $r7")

    // Exercise 8
    val r8 = exercise8_local()
    assert(r8 == Some(5), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: local => $r8")

    println("\nAll Cats021_Kleisli exercises passed!")
  }
}
