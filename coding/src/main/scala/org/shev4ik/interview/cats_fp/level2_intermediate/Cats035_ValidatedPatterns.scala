package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 035 - Validated Patterns
 *
 * Practical patterns: error accumulation with NonEmptyChain,
 * ValidatedNec, mapN for parallel validation, andThen for sequential,
 * and real-world form/config validation.
 */
object Cats035_ValidatedPatterns {

  // Exercise 1: Validated with NonEmptyChain - accumulate errors in a NonEmptyChain
  // TODO: Use ValidatedNec[E, A] (= Validated[NonEmptyChain[E], A]) for error accumulation.
  def exercise1_validatedNec(): ValidatedNec[String, Int] = {
    // Create a ValidatedNec with a single error
    val invalid: ValidatedNec[String, Int] = ???  // Validated.invalidNec("error1")

    invalid
  }

  // Exercise 2: ValidatedNec smart constructors
  // TODO: Use the .validNec and .invalidNec extension methods.
  def exercise2_smartConstructors(): (ValidatedNec[String, Int], ValidatedNec[String, Int]) = {
    // Use extension methods from cats.implicits
    val good: ValidatedNec[String, Int] = ???  // 42.validNec
    val bad: ValidatedNec[String, Int] = ???   // "error".invalidNec

    (good, bad)
  }

  // Exercise 3: mapN for error accumulation - the key feature of Validated
  // TODO: Use mapN (from Apply) to combine multiple Validated values.
  //       Unlike Either.flatMap, mapN accumulates ALL errors.
  case class User(name: String, age: Int, email: String)

  def exercise3_mapN(): ValidatedNec[String, User] = {
    def validateName(name: String): ValidatedNec[String, String] =
      if (name.nonEmpty) name.validNec else "Name is empty".invalidNec

    def validateAge(age: Int): ValidatedNec[String, Int] =
      if (age >= 0 && age < 150) age.validNec else s"Invalid age: $age".invalidNec

    def validateEmail(email: String): ValidatedNec[String, String] =
      if (email.contains("@")) email.validNec else "Invalid email".invalidNec

    // Use mapN to combine all three validations - errors accumulate!
    // Validate: name="", age=-1, email="bad"
    ???
  }

  // Exercise 4: andThen for short-circuit - sequential validation when needed
  // TODO: Use andThen when you need the result of one validation for the next.
  //       andThen short-circuits on first error (like flatMap).
  def exercise4_andThen(): ValidatedNec[String, Int] = {
    def parseInt(s: String): ValidatedNec[String, Int] =
      scala.util.Try(s.toInt).fold(_ => s"'$s' is not a number".invalidNec, _.validNec)

    def validatePositive(n: Int): ValidatedNec[String, Int] =
      if (n > 0) n.validNec else s"$n is not positive".invalidNec

    // First parse, then validate positive using andThen
    // andThen: Validated[E, A] => (A => Validated[E, B]) => Validated[E, B]
    val input = "42"
    ???
  }

  // Exercise 5: Validated vs Either - when to use which
  // TODO: Demonstrate the difference in error handling between Validated and Either.
  def exercise5_validatedVsEither(): (ValidatedNec[String, (Int, Int)], Either[String, (Int, Int)]) = {
    // Validated: accumulates ALL errors
    def vParse(s: String): ValidatedNec[String, Int] =
      scala.util.Try(s.toInt).fold(_ => s"bad: $s".invalidNec, _.validNec)

    val validatedResult: ValidatedNec[String, (Int, Int)] = ???
    // Use (vParse("abc"), vParse("xyz")).mapN((_, _))

    // Either: short-circuits on FIRST error
    def eParse(s: String): Either[String, Int] =
      scala.util.Try(s.toInt).fold(_ => Left(s"bad: $s"), Right(_))

    val eitherResult: Either[String, (Int, Int)] = ???
    // Use for-comprehension or (eParse("abc"), eParse("xyz")) with tupled

    (validatedResult, eitherResult)
  }

  // Exercise 6: Form validation - real-world pattern
  // TODO: Validate a registration form, accumulating all errors.
  case class Registration(username: String, password: String, age: Int)

  def exercise6_formValidation(
    username: String, password: String, ageStr: String
  ): ValidatedNec[String, Registration] = {
    def validateUsername(u: String): ValidatedNec[String, String] =
      if (u.length >= 3) u.validNec
      else "Username must be at least 3 characters".invalidNec

    def validatePassword(p: String): ValidatedNec[String, String] =
      if (p.length >= 8) p.validNec
      else "Password must be at least 8 characters".invalidNec

    def validateAge(s: String): ValidatedNec[String, Int] =
      scala.util.Try(s.toInt)
        .fold(_ => "Age must be a number".invalidNec, _.validNec)
        .andThen(age =>
          if (age >= 18) age.validNec
          else "Must be at least 18".invalidNec
        )

    // Combine all three validations using mapN
    ???
  }

  // Exercise 7: Config validation - validate a configuration map
  // TODO: Validate that a config map has all required keys with valid values.
  case class DbConfig(host: String, port: Int, name: String)

  def exercise7_configValidation(config: Map[String, String]): ValidatedNec[String, DbConfig] = {
    def required(key: String): ValidatedNec[String, String] =
      config.get(key).fold(s"Missing key: $key".invalidNec[String])(_.validNec)

    def requireInt(key: String): ValidatedNec[String, Int] =
      required(key).andThen { v =>
        scala.util.Try(v.toInt).fold(_ => s"$key must be an integer".invalidNec, _.validNec)
      }

    // Validate host (required), port (required int), name (required)
    ???
  }

  // Exercise 8: Combine validations - combine Validated values using Semigroup
  // TODO: Use combine (|+|) to merge Validated values.
  //       When both are Invalid, errors are accumulated via Semigroup.
  def exercise8_combine(): ValidatedNec[String, Int] = {
    val v1: ValidatedNec[String, Int] = "error1".invalidNec
    val v2: ValidatedNec[String, Int] = "error2".invalidNec

    // Combine v1 and v2 - both errors should be accumulated
    // Use combine (|+|) or <+> from SemigroupK
    // Note: Validated[E, A] has a Semigroup when both E and A have Semigroup
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_validatedNec()
    assert(r1.isInvalid, s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: ValidatedNec => $r1")

    // Exercise 2
    val (r2a, r2b) = exercise2_smartConstructors()
    assert(r2a.isValid && r2b.isInvalid, s"Exercise 2 failed")
    println(s"Exercise 2 passed: smart constructors => good=$r2a, bad=$r2b")

    // Exercise 3
    val r3 = exercise3_mapN()
    assert(r3.isInvalid, s"Exercise 3 failed: $r3")
    r3.toEither.left.foreach { errors =>
      assert(errors.length >= 3, s"Exercise 3: expected 3+ errors, got ${errors.length}")
    }
    println(s"Exercise 3 passed: mapN accumulates errors => $r3")

    // Exercise 4
    val r4 = exercise4_andThen()
    assert(r4 == Validated.validNec(42), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: andThen => $r4")

    // Exercise 5
    val (vr5, er5) = exercise5_validatedVsEither()
    assert(vr5.isInvalid, s"Exercise 5 failed: validated=$vr5")
    assert(er5.isLeft, s"Exercise 5 failed: either=$er5")
    println(s"Exercise 5 passed: Validated=$vr5, Either=$er5")

    // Exercise 6
    val r6ok = exercise6_formValidation("alice", "password123", "25")
    assert(r6ok.isValid, s"Exercise 6 valid case failed: $r6ok")
    val r6bad = exercise6_formValidation("ab", "short", "abc")
    assert(r6bad.isInvalid, s"Exercise 6 invalid case failed: $r6bad")
    println(s"Exercise 6 passed: form => valid=$r6ok, invalid=$r6bad")

    // Exercise 7
    val r7ok = exercise7_configValidation(Map("host" -> "localhost", "port" -> "5432", "name" -> "mydb"))
    assert(r7ok.isValid, s"Exercise 7 valid case failed: $r7ok")
    val r7bad = exercise7_configValidation(Map("host" -> "localhost"))
    assert(r7bad.isInvalid, s"Exercise 7 invalid case failed: $r7bad")
    println(s"Exercise 7 passed: config => valid=$r7ok, invalid=$r7bad")

    // Exercise 8
    val r8 = exercise8_combine()
    assert(r8.isInvalid, s"Exercise 8 failed: $r8")
    r8.toEither.left.foreach { errors =>
      assert(errors.length == 2, s"Exercise 8: expected 2 errors, got ${errors.length}")
    }
    println(s"Exercise 8 passed: combine => $r8")

    println("\nAll Cats035_ValidatedPatterns exercises passed!")
  }
}
