package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 061 - Parallel Type Class
 *
 * Parallel[M] provides a way to convert between a Monad M and a related
 * Applicative F. This enables using the applicative (parallel) version
 * of operations like traverse, mapN, etc. on monadic types.
 * E.g., Either (Monad) <-> Validated (Applicative).
 */
object Cats061_Parallel {

  private implicit class StringOps(val s: String) extends AnyVal {
    def toIntOption: Option[Int] = scala.util.Try(s.toInt).toOption
  }

  // Exercise 1: parMapN - combine values using Parallel (applicative) semantics
  // TODO: Use parMapN to accumulate errors instead of short-circuiting.
  def exercise1_parMapN(): Either[String, Int] = {
    val a: Either[String, Int] = Right(1)
    val b: Either[String, Int] = Right(2)
    val c: Either[String, Int] = Right(3)

    // Use parMapN to combine (uses Validated under the hood for error accumulation)
    ???
  }

  // Exercise 2: parTraverse - traverse with parallel error accumulation
  // TODO: Use parTraverse instead of traverse for error accumulation.
  def exercise2_parTraverse(): Either[String, List[Int]] = {
    val inputs = List("1", "2", "3", "4", "5")

    def parse(s: String): Either[String, Int] =
      s.toIntOption.toRight(s"'$s' is not a number")

    // Use parTraverse to parse all strings, accumulating all errors
    ???
  }

  // Exercise 3: parSequence - sequence with parallel semantics
  // TODO: Use parSequence to convert List[F[A]] to F[List[A]] with accumulation.
  def exercise3_parSequence(): Either[String, List[Int]] = {
    val eithers: List[Either[String, Int]] = List(Right(1), Right(2), Right(3))

    // Use parSequence to combine
    ???
  }

  // Exercise 4: parTupled - combine a tuple of effects in parallel
  // TODO: Use parTupled to combine multiple effects into a tuple.
  def exercise4_parTupled(): Either[String, (Int, String, Boolean)] = {
    val a: Either[String, Int] = Right(42)
    val b: Either[String, String] = Right("hello")
    val c: Either[String, Boolean] = Right(true)

    // Use parTupled to combine into a tuple
    ???
  }

  // Exercise 5: Parallel for Either/Validated - demonstrate the conversion
  // TODO: Show how Parallel converts Either to Validated for error accumulation.
  def exercise5_eitherValidated(): Either[NonEmptyList[String], Int] = {
    type EitherNel[A] = Either[NonEmptyList[String], A]

    val a: EitherNel[Int] = Left(NonEmptyList.one("error1"))
    val b: EitherNel[Int] = Left(NonEmptyList.one("error2"))

    // parMapN on EitherNel uses ValidatedNel internally to accumulate errors
    ???
  }

  // Exercise 6: ~> between monadic and applicative
  // TODO: Demonstrate the natural transformation between M and its Parallel F.
  def exercise6_naturalTransformation(): (Validated[String, Int], Either[String, Int]) = {
    // Parallel provides: sequential (F ~> M) and parallel (M ~> F)
    // For Either/Validated:
    //   parallel:   Either[E, A] => Validated[E, A]
    //   sequential: Validated[E, A] => Either[E, A]

    val either: Either[String, Int] = Right(42)
    val validated: Validated[String, Int] = Validated.valid(42)

    // Convert Either to Validated (parallel)
    val toValidated: Validated[String, Int] = ???

    // Convert Validated to Either (sequential)
    val toEither: Either[String, Int] = ???

    (toValidated, toEither)
  }

  // Exercise 7: parMapN with error accumulation - practical example
  // TODO: Validate a form using parMapN for error accumulation.
  case class UserForm(name: String, email: String, age: Int)

  def exercise7_formValidation(
    name: String,
    email: String,
    age: String
  ): Either[NonEmptyList[String], UserForm] = {
    type Result[A] = Either[NonEmptyList[String], A]

    def validateName(n: String): Result[String] =
      if (n.nonEmpty) Right(n) else Left(NonEmptyList.one("name is required"))

    def validateEmail(e: String): Result[String] =
      if (e.contains("@")) Right(e) else Left(NonEmptyList.one("email must contain @"))

    def validateAge(a: String): Result[Int] =
      a.toIntOption
        .filter(_ >= 18)
        .toRight(NonEmptyList.one("age must be a number >= 18"))

    // Use parMapN to accumulate ALL validation errors
    ???
  }

  // Exercise 8: Custom Parallel-like pattern - demonstrate the concept
  // TODO: Show how Parallel works conceptually with a custom example.
  def exercise8_customParallel(): List[String] = {
    // Parallel for List doesn't accumulate errors but uses ZipList semantics
    // Regular mapN on List = cartesian product
    // parMapN on List = zip

    // Standard (non-parallel) mapN on List = cartesian product
    val cartesian: List[String] = (List("a", "b"), List("1", "2")).mapN(_ + _)
    // Result: List(a1, a2, b1, b2) - all combinations

    // For this exercise, manually create the "zipped" result
    // which would be the parallel version: List(a1, b2)
    val zipped: List[String] = ???

    zipped
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_parMapN()
    assert(r1 == Right(6), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: parMapN => $r1")

    // Exercise 2
    val r2 = exercise2_parTraverse()
    assert(r2 == Right(List(1, 2, 3, 4, 5)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: parTraverse => $r2")

    // Exercise 3
    val r3 = exercise3_parSequence()
    assert(r3 == Right(List(1, 2, 3)), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: parSequence => $r3")

    // Exercise 4
    val r4 = exercise4_parTupled()
    assert(r4 == Right((42, "hello", true)), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: parTupled => $r4")

    // Exercise 5
    val r5 = exercise5_eitherValidated()
    assert(r5.isLeft, s"Exercise 5 failed: $r5")
    r5.left.foreach(errs => assert(errs.size == 2, s"Exercise 5: expected 2 errors, got ${errs.size}"))
    println(s"Exercise 5 passed: Either/Validated => $r5")

    // Exercise 6
    val (r6a, r6b) = exercise6_naturalTransformation()
    assert(r6a == Validated.valid(42), s"Exercise 6 failed: validated=$r6a")
    assert(r6b == Right(42), s"Exercise 6 failed: either=$r6b")
    println(s"Exercise 6 passed: natural transformation => validated=$r6a, either=$r6b")

    // Exercise 7
    val r7a = exercise7_formValidation("Alice", "alice@example.com", "25")
    assert(r7a == Right(UserForm("Alice", "alice@example.com", 25)), s"Exercise 7 valid failed: $r7a")
    val r7b = exercise7_formValidation("", "bademail", "young")
    assert(r7b.isLeft, s"Exercise 7 invalid failed: $r7b")
    r7b.left.foreach(errs => assert(errs.size == 3, s"Exercise 7: expected 3 errors, got ${errs.size}: $errs"))
    println(s"Exercise 7 passed: form validation => valid=$r7a, invalid=$r7b")

    // Exercise 8
    val r8 = exercise8_customParallel()
    assert(r8 == List("a1", "b2"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: custom parallel => $r8")

    println("\nAll Cats061_Parallel exercises passed!")
  }
}
