package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 039 - ValidatedNec (Validated with NonEmptyChain)
 *
 * ValidatedNec[E, A] is an alias for Validated[NonEmptyChain[E], A].
 * NonEmptyChain is preferred over NonEmptyList for error accumulation
 * because it has O(1) append, making error collection more efficient.
 */
object Cats039_ValidatedNec {

  // Exercise 1: validNec - create a valid value with NEC error type
  // TODO: Create a ValidatedNec using .validNec syntax extension.
  def exercise1_validNec(): ValidatedNec[String, Int] = {
    // Create a valid value 42 with ValidatedNec
    ???
  }

  // Exercise 2: invalidNec - create an invalid value with NEC error type
  // TODO: Create an InvalidNec using .invalidNec syntax extension.
  def exercise2_invalidNec(): ValidatedNec[String, Int] = {
    // Create an invalid value with error "field is required"
    ???
  }

  // Exercise 3: mapN accumulation - combine multiple ValidatedNec and accumulate errors
  // TODO: Use mapN to combine validated values, accumulating all errors.
  def exercise3_mapNAccumulation(): ValidatedNec[String, String] = {
    val name: ValidatedNec[String, String] = "name is empty".invalidNec
    val age: ValidatedNec[String, Int] = "age is negative".invalidNec
    val email: ValidatedNec[String, String] = "email is invalid".invalidNec

    // Combine all three using mapN - all errors should accumulate
    ???
  }

  // Exercise 4: toValidatedNec - convert Either to ValidatedNec
  // TODO: Convert an Either to ValidatedNec for error accumulation.
  def exercise4_toValidatedNec(): (ValidatedNec[String, Int], ValidatedNec[String, Int]) = {
    val right: Either[String, Int] = Right(42)
    val left: Either[String, Int] = Left("something went wrong")

    // Convert both to ValidatedNec
    val v1: ValidatedNec[String, Int] = ???
    val v2: ValidatedNec[String, Int] = ???
    (v1, v2)
  }

  // Exercise 5: Field validation - create reusable field validators returning ValidatedNec
  // TODO: Write validators that return ValidatedNec for individual fields.
  def exercise5_fieldValidation(): ValidatedNec[String, String] = {
    def validateNonEmpty(field: String, value: String): ValidatedNec[String, String] = {
      // Return invalidNec with "$field must not be empty" if empty, else validNec
      ???
    }

    def validateMinLength(field: String, min: Int, value: String): ValidatedNec[String, String] = {
      // Return invalidNec with "$field must be at least $min chars" if too short, else validNec
      ???
    }

    // Validate "Jo" with both validators using andThen or productR
    val value = "Jo"
    validateNonEmpty("name", value).andThen(_ => validateMinLength("name", 3, value))
  }

  // Exercise 6: Form validation - validate an entire form with NEC accumulation
  // TODO: Combine multiple field validations to validate a full form.
  case class RegistrationForm(username: String, email: String, age: Int)

  def exercise6_formValidation(
    username: String,
    email: String,
    age: Int
  ): ValidatedNec[String, RegistrationForm] = {
    def validateUsername(u: String): ValidatedNec[String, String] =
      if (u.nonEmpty) u.validNec else "username is required".invalidNec

    def validateEmail(e: String): ValidatedNec[String, String] =
      if (e.contains("@")) e.validNec else "email must contain @".invalidNec

    def validateAge(a: Int): ValidatedNec[String, Int] =
      if (a >= 18) a.validNec else "must be 18 or older".invalidNec

    // Combine all validations using mapN to construct RegistrationForm
    ???
  }

  // Exercise 7: Combining with NEC - use combine on NonEmptyChain errors
  // TODO: Show how NEC errors get combined with efficient append.
  def exercise7_necCombining(): ValidatedNec[String, Int] = {
    val v1: ValidatedNec[String, Int] = "error1".invalidNec
    val v2: ValidatedNec[String, Int] = "error2".invalidNec
    val v3: ValidatedNec[String, Int] = "error3".invalidNec

    // Combine all three using mapN - the NEC errors should all accumulate
    ???
  }

  // Exercise 8: andThen for sequential validation - use andThen for dependent validations
  // TODO: Use andThen to chain validations where the second depends on the first.
  def exercise8_andThen(): ValidatedNec[String, Int] = {
    def validateString(s: String): ValidatedNec[String, String] =
      if (s.nonEmpty) s.validNec else "string is empty".invalidNec

    def validateParsesAsInt(s: String): ValidatedNec[String, Int] =
      scala.util.Try(s.toInt).fold(
        _ => s"'$s' is not a number".invalidNec,
        _.validNec
      )

    def validatePositive(n: Int): ValidatedNec[String, Int] =
      if (n > 0) n.validNec else "must be positive".invalidNec

    // Chain: validateString -> validateParsesAsInt -> validatePositive using andThen
    val input = "42"
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_validNec()
    assert(r1 == Validated.valid(42), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: validNec => $r1")

    // Exercise 2
    val r2 = exercise2_invalidNec()
    assert(r2.isInvalid, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: invalidNec => $r2")

    // Exercise 3
    val r3 = exercise3_mapNAccumulation()
    assert(r3.isInvalid, s"Exercise 3 failed: $r3")
    r3.leftMap(errs => assert(errs.length == 3L, s"Exercise 3 should have 3 errors, got ${errs.length}"))
    println(s"Exercise 3 passed: mapN accumulation => $r3")

    // Exercise 4
    val (r4a, r4b) = exercise4_toValidatedNec()
    assert(r4a.isValid && r4b.isInvalid, s"Exercise 4 failed")
    println(s"Exercise 4 passed: toValidatedNec => right=$r4a, left=$r4b")

    // Exercise 5
    val r5 = exercise5_fieldValidation()
    assert(r5.isInvalid, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: field validation => $r5")

    // Exercise 6
    val r6a = exercise6_formValidation("alice", "alice@example.com", 25)
    assert(r6a.isValid, s"Exercise 6 failed: $r6a")
    val r6b = exercise6_formValidation("", "bademail", 10)
    assert(r6b.isInvalid, s"Exercise 6 failed: $r6b")
    r6b.leftMap(errs => assert(errs.length == 3L, s"Exercise 6 should have 3 errors, got ${errs.length}"))
    println(s"Exercise 6 passed: form valid=$r6a, invalid=$r6b")

    // Exercise 7
    val r7 = exercise7_necCombining()
    assert(r7.isInvalid, s"Exercise 7 failed: $r7")
    r7.leftMap(errs => assert(errs.length == 3L, s"Exercise 7 should have 3 errors"))
    println(s"Exercise 7 passed: NEC combining => $r7")

    // Exercise 8
    val r8 = exercise8_andThen()
    assert(r8 == Validated.valid(42), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: andThen => $r8")

    println("\nAll Cats039_ValidatedNec exercises passed!")
  }
}
