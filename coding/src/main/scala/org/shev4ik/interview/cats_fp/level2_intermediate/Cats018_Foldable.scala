package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 018 - Foldable
 *
 * Foldable abstracts the ability to fold (reduce) a structure into a single value.
 * Cats' Foldable adds powerful combinators like foldMap, foldM, combineAll, etc.
 */
object Cats018_Foldable {

  // Exercise 1: foldLeft - standard left fold
  // TODO: Use Foldable[List].foldLeft to sum a list of integers.
  def exercise1_foldLeft(): Int = {
    val numbers = List(1, 2, 3, 4, 5)

    // Use Foldable[List].foldLeft with initial value 0
    ???
  }

  // Exercise 2: foldRight - Eval-based lazy right fold
  // TODO: Use Foldable[List].foldRight which returns Eval for stack safety.
  //       Concatenate strings from right to left.
  def exercise2_foldRight(): String = {
    val words = List("a", "b", "c", "d")

    // Use Foldable[List].foldRight with Eval.now("") as initial
    // foldRight signature: (fa, lb)(f: (A, Eval[B]) => Eval[B]): Eval[B]
    ???
  }

  // Exercise 3: fold (combineAll) - combine all elements using Monoid
  // TODO: Use fold (also known as combineAll) to combine all elements.
  //       This requires a Monoid instance for the element type.
  def exercise3_fold(): Int = {
    val numbers = List(1, 2, 3, 4, 5)

    // Use Foldable[List].fold or numbers.combineAll
    ???
  }

  // Exercise 4: foldMap - map then fold in one step
  // TODO: Use foldMap to convert each string to its length, then sum.
  //       foldMap applies a function and combines results using Monoid.
  def exercise4_foldMap(): Int = {
    val words = List("hello", "world", "cats")

    // Use foldMap with _.length
    ???
  }

  // Exercise 5: find - find the first element matching a predicate
  // TODO: Use Foldable's find to locate the first even number.
  def exercise5_find(): Option[Int] = {
    val numbers = List(1, 3, 4, 6, 7)

    // Use Foldable[List].find
    ???
  }

  // Exercise 6: exists - check if any element matches
  // TODO: Use exists to check if any string in the list starts with "s".
  def exercise6_exists(): Boolean = {
    val words = List("hello", "scala", "world")

    // Use Foldable[List].exists
    ???
  }

  // Exercise 7: forall - check if all elements match
  // TODO: Use forall to check if all numbers are positive.
  def exercise7_forall(): Boolean = {
    val numbers = List(1, 2, 3, 4, 5)

    // Use Foldable[List].forall
    ???
  }

  // Exercise 8: foldM - monadic fold (fold with effects)
  // TODO: Use foldM to fold with Either, short-circuiting on error.
  //       Divide running total by each number; fail if dividing by zero.
  def exercise8_foldM(): Either[String, Double] = {
    val divisors = List(2.0, 4.0, 5.0)
    val initial = 100.0

    // Use Foldable[List].foldM with Either
    // f: (acc, elem) => if (elem == 0) Left("div by zero") else Right(acc / elem)
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_foldLeft()
    assert(r1 == 15, s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: foldLeft => $r1")

    // Exercise 2
    val r2 = exercise2_foldRight()
    assert(r2 == "abcd", s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: foldRight => $r2")

    // Exercise 3
    val r3 = exercise3_fold()
    assert(r3 == 15, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: fold (combineAll) => $r3")

    // Exercise 4
    val r4 = exercise4_foldMap()
    assert(r4 == 14, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: foldMap => $r4")

    // Exercise 5
    val r5 = exercise5_find()
    assert(r5 == Some(4), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: find => $r5")

    // Exercise 6
    val r6 = exercise6_exists()
    assert(r6 == true, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: exists => $r6")

    // Exercise 7
    val r7 = exercise7_forall()
    assert(r7 == true, s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: forall => $r7")

    // Exercise 8
    val r8 = exercise8_foldM()
    assert(r8 == Right(2.5), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: foldM => $r8")

    println("\nAll Cats018_Foldable exercises passed!")
  }
}
