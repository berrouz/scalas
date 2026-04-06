package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 029 - EitherT Monad Transformer
 *
 * EitherT[F, E, A] wraps F[Either[E, A]], combining the effect F
 * with error handling via Either. Eliminates nested pattern matching.
 */
object Cats029_EitherT {

  // Using Option as our outer effect for simplicity
  type Eff[A] = Option[A]

  // Exercise 1: EitherT creation - wrap an F[Either[E, A]]
  // TODO: Create an EitherT from an Option[Either[String, Int]].
  def exercise1_creation(): EitherT[Eff, String, Int] = {
    val wrapped: Eff[Either[String, Int]] = Some(Right(42))

    // Wrap it in EitherT
    ???
  }

  // Exercise 2: EitherT.liftF - lift an F[A] into EitherT
  // TODO: Lift an Option[Int] into EitherT (automatically becomes Right).
  def exercise2_liftF(): EitherT[Eff, String, Int] = {
    val opt: Eff[Int] = Some(42)

    // Lift into EitherT
    ???
  }

  // Exercise 3: EitherT.fromEither - lift an Either into EitherT with pure F
  // TODO: Lift an Either[String, Int] into EitherT[Option, String, Int].
  def exercise3_fromEither(): EitherT[Eff, String, Int] = {
    val either: Either[String, Int] = Right(42)

    // Lift Either into EitherT
    ???
  }

  // Exercise 4: value - unwrap EitherT to get F[Either[E, A]]
  // TODO: Extract the underlying F[Either[E, A]] from EitherT.
  def exercise4_value(): Eff[Either[String, Int]] = {
    val et: EitherT[Eff, String, Int] = EitherT.rightT[Eff, String](42)

    // Unwrap to get Option[Either[String, Int]]
    ???
  }

  // Exercise 5: getOrElse - unwrap Right or use a default
  // TODO: Use getOrElse to provide a fallback for Left values.
  def exercise5_getOrElse(): (Eff[Int], Eff[Int]) = {
    val right: EitherT[Eff, String, Int] = EitherT.rightT[Eff, String](42)
    val left: EitherT[Eff, String, Int] = EitherT.leftT[Eff, Int]("error")

    // Get value or default to -1
    val r1: Eff[Int] = ???
    val r2: Eff[Int] = ???
    (r1, r2)
  }

  // Exercise 6: leftMap - transform the error type
  // TODO: Use leftMap to transform the Left (error) side.
  def exercise6_leftMap(): Eff[Either[Int, String]] = {
    val et: EitherT[Eff, String, String] = EitherT.leftT[Eff, String]("not found")

    // Use leftMap to convert String error to its length (Int)
    val mapped: EitherT[Eff, Int, String] = ???

    mapped.value
  }

  // Exercise 7: subflatMap - flatMap on the Either inside F
  // TODO: Use subflatMap to apply a function A => Either[E, B] inside the transformer.
  def exercise7_subflatMap(): Eff[Either[String, Int]] = {
    val et: EitherT[Eff, String, String] = EitherT.rightT[Eff, String]("42")

    // subflatMap: parse the string to Int, returning Left on failure
    val parsed: EitherT[Eff, String, Int] = ???

    parsed.value
  }

  // Exercise 8: ensure - validate the value, converting to Left if predicate fails
  // TODO: Use ensure to add a validation check to an EitherT.
  def exercise8_ensure(): (Eff[Either[String, Int]], Eff[Either[String, Int]]) = {
    val positive: EitherT[Eff, String, Int] = EitherT.rightT[Eff, String](42)
    val negative: EitherT[Eff, String, Int] = EitherT.rightT[Eff, String](-5)

    // Use ensure to check value > 0, with error message "must be positive"
    val r1: EitherT[Eff, String, Int] = ???
    val r2: EitherT[Eff, String, Int] = ???

    (r1.value, r2.value)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_creation().value
    assert(r1 == Some(Right(42)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: EitherT creation => $r1")

    // Exercise 2
    val r2 = exercise2_liftF().value
    assert(r2 == Some(Right(42)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: liftF => $r2")

    // Exercise 3
    val r3 = exercise3_fromEither().value
    assert(r3 == Some(Right(42)), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: fromEither => $r3")

    // Exercise 4
    val r4 = exercise4_value()
    assert(r4 == Some(Right(42)), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: value => $r4")

    // Exercise 5
    val (r5a, r5b) = exercise5_getOrElse()
    assert(r5a == Some(42) && r5b == Some(-1), s"Exercise 5 failed: ($r5a, $r5b)")
    println(s"Exercise 5 passed: getOrElse => right=$r5a, left=$r5b")

    // Exercise 6
    val r6 = exercise6_leftMap()
    assert(r6 == Some(Left(9)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: leftMap => $r6")

    // Exercise 7
    val r7 = exercise7_subflatMap()
    assert(r7 == Some(Right(42)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: subflatMap => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_ensure()
    assert(r8a == Some(Right(42)), s"Exercise 8 failed: right=$r8a")
    assert(r8b == Some(Left("must be positive")), s"Exercise 8 failed: left=$r8b")
    println(s"Exercise 8 passed: ensure => pass=$r8a, fail=$r8b")

    println("\nAll Cats029_EitherT exercises passed!")
  }
}
