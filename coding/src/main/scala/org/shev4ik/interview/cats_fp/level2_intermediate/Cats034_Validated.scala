package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 034 - Validated
 *
 * Validated[E, A] is similar to Either[E, A] but designed for error accumulation.
 * Unlike Either, Validated does NOT short-circuit - it collects ALL errors.
 * Validated is an Applicative, not a Monad (no flatMap for accumulation).
 */
object Cats034_Validated {

  // Exercise 1: Valid - create a successful Validated
  // TODO: Create a Valid value using Validated.valid or .valid syntax.
  def exercise1_valid(): Validated[String, Int] = {
    // Create a Valid(42)
    ???
  }

  // Exercise 2: Invalid - create a failed Validated
  // TODO: Create an Invalid value using Validated.invalid.
  def exercise2_invalid(): Validated[String, Int] = {
    // Create an Invalid("error message")
    ???
  }

  // Exercise 3: Validated.valid / Validated.invalid - smart constructors
  // TODO: Use the explicit smart constructors.
  def exercise3_smartConstructors(): (Validated[String, Int], Validated[String, Int]) = {
    // Use Validated.valid and Validated.invalid
    val good: Validated[String, Int] = ???
    val bad: Validated[String, Int] = ???
    (good, bad)
  }

  // Exercise 4: fromEither - convert Either to Validated
  // TODO: Convert an Either[String, Int] to Validated[String, Int].
  def exercise4_fromEither(): (Validated[String, Int], Validated[String, Int]) = {
    val right: Either[String, Int] = Right(42)
    val left: Either[String, Int] = Left("error")

    // Convert both to Validated
    val v1: Validated[String, Int] = ???
    val v2: Validated[String, Int] = ???
    (v1, v2)
  }

  // Exercise 5: fromOption - convert Option to Validated with error for None
  // TODO: Convert an Option to Validated, providing an error for None.
  def exercise5_fromOption(): (Validated[String, Int], Validated[String, Int]) = {
    val some: Option[Int] = Some(42)
    val none: Option[Int] = None

    // Convert with Validated.fromOption, providing "not found" as error
    val v1: Validated[String, Int] = ???
    val v2: Validated[String, Int] = ???
    (v1, v2)
  }

  // Exercise 6: toEither - convert Validated back to Either
  // TODO: Convert Validated to Either for sequential processing.
  def exercise6_toEither(): (Either[String, Int], Either[String, Int]) = {
    val valid: Validated[String, Int] = Validated.valid(42)
    val invalid: Validated[String, Int] = Validated.invalid("error")

    // Convert both to Either
    val e1: Either[String, Int] = ???
    val e2: Either[String, Int] = ???
    (e1, e2)
  }

  // Exercise 7: ensure - validate a condition, converting Valid to Invalid if predicate fails
  // TODO: Use ensure to add a validation check to a Validated value.
  def exercise7_ensure(): (Validated[String, Int], Validated[String, Int]) = {
    val v1: Validated[String, Int] = Validated.valid(42)
    val v2: Validated[String, Int] = Validated.valid(-5)

    // Use ensure to check > 0, with error "must be positive"
    val checked1: Validated[String, Int] = ???
    val checked2: Validated[String, Int] = ???
    (checked1, checked2)
  }

  // Exercise 8: Validated operations - map, leftMap, bimap, fold
  // TODO: Demonstrate various operations on Validated.
  def exercise8_operations(): (String, String, String, String) = {
    val valid: Validated[String, Int] = Validated.valid(42)
    val invalid: Validated[String, Int] = Validated.invalid("error")

    // map: transform the valid value
    val mapped: Validated[String, String] = ???  // valid.map(_.toString)

    // leftMap: transform the error
    val leftMapped: Validated[String, Int] = ???  // invalid.leftMap(_.toUpperCase)

    // bimap: transform both sides
    val bimapped: Validated[Int, String] = ???  // invalid.bimap(_.length, _.toString)

    // fold: extract value from either case
    val folded: String = ???  // valid.fold(e => s"Error: $e", v => s"Value: $v")

    (mapped.toString, leftMapped.toString, bimapped.toString, folded)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_valid()
    assert(r1 == Validated.valid(42), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: Valid => $r1")

    // Exercise 2
    val r2 = exercise2_invalid()
    assert(r2.isInvalid, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: Invalid => $r2")

    // Exercise 3
    val (r3a, r3b) = exercise3_smartConstructors()
    assert(r3a.isValid && r3b.isInvalid, s"Exercise 3 failed")
    println(s"Exercise 3 passed: smart constructors => valid=$r3a, invalid=$r3b")

    // Exercise 4
    val (r4a, r4b) = exercise4_fromEither()
    assert(r4a == Validated.valid(42) && r4b == Validated.invalid("error"), s"Exercise 4 failed")
    println(s"Exercise 4 passed: fromEither => right=$r4a, left=$r4b")

    // Exercise 5
    val (r5a, r5b) = exercise5_fromOption()
    assert(r5a == Validated.valid(42) && r5b == Validated.invalid("not found"), s"Exercise 5 failed")
    println(s"Exercise 5 passed: fromOption => some=$r5a, none=$r5b")

    // Exercise 6
    val (r6a, r6b) = exercise6_toEither()
    assert(r6a == Right(42) && r6b == Left("error"), s"Exercise 6 failed")
    println(s"Exercise 6 passed: toEither => valid=$r6a, invalid=$r6b")

    // Exercise 7
    val (r7a, r7b) = exercise7_ensure()
    assert(r7a == Validated.valid(42) && r7b.isInvalid, s"Exercise 7 failed: ($r7a, $r7b)")
    println(s"Exercise 7 passed: ensure => pass=$r7a, fail=$r7b")

    // Exercise 8
    val (mapped, leftMapped, bimapped, folded) = exercise8_operations()
    assert(folded == "Value: 42", s"Exercise 8 failed: folded=$folded")
    println(s"Exercise 8 passed: operations => mapped=$mapped, leftMapped=$leftMapped, bimapped=$bimapped, folded=$folded")

    println("\nAll Cats034_Validated exercises passed!")
  }
}
