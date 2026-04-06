package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 017 - Traverse
 *
 * Traverse allows you to turn F[G[A]] inside out to G[F[A]],
 * and to apply an effectful function to each element while collecting results.
 */
object Cats017_Traverse {

  // Exercise 1: Basic traverse - apply a function returning Option to a List
  // TODO: Use traverse to apply a parsing function across a list of strings.
  //       If all parse successfully, return Some(List[Int]); otherwise None.
  def exercise1_traverse(): Option[List[Int]] = {
    val strings = List("1", "2", "3")
    val parse: String => Option[Int] = s => scala.util.Try(s.toInt).toOption

    // Use List#traverse with parse
    ???
  }

  // Exercise 2: sequence - turn List[Option[A]] into Option[List[A]]
  // TODO: Use sequence to collapse a List of Options into an Option of List.
  //       Returns None if any element is None.
  def exercise2_sequence(): Option[List[Int]] = {
    val opts: List[Option[Int]] = List(Some(1), Some(2), Some(3))

    // Use .sequence on the list
    ???
  }

  // Exercise 3: traverse on List[Either] - accumulate with first error short-circuit
  // TODO: Use traverse with Either to validate a list of numbers (must be positive).
  //       Short-circuits on the first Left.
  def exercise3_traverseEither(): Either[String, List[Int]] = {
    val numbers = List(1, 2, 3, 4, 5)
    val validate: Int => Either[String, Int] =
      n => if (n > 0) Right(n) else Left(s"$n is not positive")

    // Use traverse with validate
    ???
  }

  // Exercise 4: traverse with Validated - accumulate ALL errors
  // TODO: Use traverse with ValidatedNec to validate a list of inputs,
  //       accumulating all errors instead of short-circuiting.
  def exercise4_traverseValidated(): ValidatedNec[String, List[Int]] = {
    val inputs = List(1, -2, 3, -4)
    val validate: Int => ValidatedNec[String, Int] =
      n => if (n > 0) Validated.validNec(n) else Validated.invalidNec(s"$n is not positive")

    // Use traverse with validate - errors accumulate!
    ???
  }

  // Exercise 5: traverseFilter - traverse and filter in one pass
  // TODO: Use traverseFilter to keep only even numbers, wrapped in Option.
  //       traverseFilter combines traverse with flatMap-like filtering.
  def exercise5_traverseFilter(): Option[List[Int]] = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    val keepEven: Int => Option[Option[Int]] =
      n => Some(if (n % 2 == 0) Some(n) else None)

    // Use traverseFilter
    ???
  }

  // Exercise 6: flatTraverse - traverse then flatten
  // TODO: Use flatTraverse when your function returns F[G[List[A]]]
  //       and you want F[List[A]] (flattened).
  def exercise6_flatTraverse(): Option[List[Int]] = {
    val numbers = List(1, 2, 3)
    val expand: Int => Option[List[Int]] = n => Some(List(n, n * 10))

    // Use flatTraverse to get Option[List[Int]] instead of Option[List[List[Int]]]
    ???
  }

  // Exercise 7: traverse_ - traverse for side effects, discarding results
  // TODO: Use traverse_ when you only care about the effect, not the collected values.
  //       Returns F[Unit] instead of F[List[B]].
  def exercise7_traverse_(): Option[Unit] = {
    val numbers = List(1, 2, 3)
    val check: Int => Option[Unit] =
      n => if (n > 0) Some(()) else None

    // Use traverse_ to check all elements, discarding results
    ???
  }

  // Exercise 8: sequence on nested structures - turn Vector[Either[E, A]] inside out
  // TODO: Use sequence on a Vector of Eithers.
  def exercise8_sequenceVector(): Either[String, Vector[Int]] = {
    val eithers: Vector[Either[String, Int]] = Vector(Right(10), Right(20), Right(30))

    // Use .sequence
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_traverse()
    assert(r1 == Some(List(1, 2, 3)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: traverse with Option => $r1")

    // Exercise 2
    val r2 = exercise2_sequence()
    assert(r2 == Some(List(1, 2, 3)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: sequence => $r2")

    // Exercise 3
    val r3 = exercise3_traverseEither()
    assert(r3 == Right(List(1, 2, 3, 4, 5)), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: traverse with Either => $r3")

    // Exercise 4
    val r4 = exercise4_traverseValidated()
    assert(r4.isInvalid, s"Exercise 4 failed: expected Invalid, got $r4")
    println(s"Exercise 4 passed: traverse with Validated => $r4")

    // Exercise 5
    val r5 = exercise5_traverseFilter()
    assert(r5 == Some(List(2, 4, 6)), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: traverseFilter => $r5")

    // Exercise 6
    val r6 = exercise6_flatTraverse()
    assert(r6 == Some(List(1, 10, 2, 20, 3, 30)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: flatTraverse => $r6")

    // Exercise 7
    val r7 = exercise7_traverse_()
    assert(r7 == Some(()), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: traverse_ => $r7")

    // Exercise 8
    val r8 = exercise8_sequenceVector()
    assert(r8 == Right(Vector(10, 20, 30)), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: sequence on Vector => $r8")

    println("\nAll Cats017_Traverse exercises passed!")
  }
}
