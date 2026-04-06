package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 028 - OptionT Monad Transformer
 *
 * OptionT[F, A] wraps F[Option[A]], providing a monad instance that
 * combines the effects of F with the optionality of Option.
 * Eliminates nested flatMap/map on F[Option[A]].
 */
object Cats028_OptionT {

  // We'll use Either[String, ?] as our outer effect for testability
  type Result[A] = Either[String, A]

  // Exercise 1: OptionT creation - wrap an F[Option[A]]
  // TODO: Create an OptionT from an Either[String, Option[Int]].
  def exercise1_creation(): OptionT[Result, Int] = {
    val wrapped: Result[Option[Int]] = Right(Some(42))

    // Wrap it in OptionT
    ???
  }

  // Exercise 2: OptionT.liftF - lift an F[A] into OptionT[F, A]
  // TODO: Lift a Result[Int] (no Option involved) into OptionT.
  def exercise2_liftF(): OptionT[Result, Int] = {
    val result: Result[Int] = Right(42)

    // Lift into OptionT (wraps in Some automatically)
    ???
  }

  // Exercise 3: OptionT.fromOption - lift an Option[A] into OptionT[F, A]
  // TODO: Lift an Option[Int] into OptionT with a pure F.
  def exercise3_fromOption(): OptionT[Result, Int] = {
    val opt: Option[Int] = Some(42)

    // Lift Option into OptionT[Result, Int]
    ???
  }

  // Exercise 4: value - unwrap OptionT to get F[Option[A]]
  // TODO: Extract the underlying F[Option[A]] from an OptionT.
  def exercise4_value(): Result[Option[Int]] = {
    val ot: OptionT[Result, Int] = OptionT.pure[Result](42)

    // Get the underlying Either[String, Option[Int]]
    ???
  }

  // Exercise 5: getOrElse - unwrap with a default value
  // TODO: Use getOrElse to provide a fallback when the Option is None.
  def exercise5_getOrElse(): (Result[Int], Result[Int]) = {
    val some: OptionT[Result, Int] = OptionT.pure[Result](42)
    val none: OptionT[Result, Int] = OptionT.none[Result, Int]

    // Get value or default to 0
    val r1: Result[Int] = ???
    val r2: Result[Int] = ???
    (r1, r2)
  }

  // Exercise 6: map - transform the value inside OptionT
  // TODO: Use map to transform the inner value.
  def exercise6_map(): Result[Option[Int]] = {
    val ot: OptionT[Result, Int] = OptionT.pure[Result](21)

    // Map to double the value
    val doubled: OptionT[Result, Int] = ???

    doubled.value
  }

  // Exercise 7: flatMap - chain OptionT computations
  // TODO: Use flatMap (for-comprehension) to chain OptionT operations.
  //       If any step is None, the whole chain is None.
  def exercise7_flatMap(): Result[Option[String]] = {
    def findUser(id: Int): OptionT[Result, String] =
      if (id == 1) OptionT.some[Result]("Alice")
      else OptionT.none[Result, String]

    def findEmail(name: String): OptionT[Result, String] =
      if (name == "Alice") OptionT.some[Result]("alice@example.com")
      else OptionT.none[Result, String]

    // Chain: find user 1, then find their email
    val program: OptionT[Result, String] = ???

    program.value
  }

  // Exercise 8: semiflatMap - flatMap with a function returning F[B] instead of OptionT[F, B]
  // TODO: Use semiflatMap when your function returns F[B] directly (not wrapped in Option).
  def exercise8_semiflatMap(): Result[Option[String]] = {
    val ot: OptionT[Result, Int] = OptionT.some[Result](42)

    // semiflatMap: Int => F[String] (not OptionT[F, String])
    // Convert the Int to a formatted string in the Result effect
    val result: OptionT[Result, String] = ???

    result.value
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_creation().value
    assert(r1 == Right(Some(42)), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: OptionT creation => $r1")

    // Exercise 2
    val r2 = exercise2_liftF().value
    assert(r2 == Right(Some(42)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: liftF => $r2")

    // Exercise 3
    val r3 = exercise3_fromOption().value
    assert(r3 == Right(Some(42)), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: fromOption => $r3")

    // Exercise 4
    val r4 = exercise4_value()
    assert(r4 == Right(Some(42)), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: value => $r4")

    // Exercise 5
    val (r5a, r5b) = exercise5_getOrElse()
    assert(r5a == Right(42) && r5b == Right(0), s"Exercise 5 failed: ($r5a, $r5b)")
    println(s"Exercise 5 passed: getOrElse => some=$r5a, none=$r5b")

    // Exercise 6
    val r6 = exercise6_map()
    assert(r6 == Right(Some(42)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: map => $r6")

    // Exercise 7
    val r7 = exercise7_flatMap()
    assert(r7 == Right(Some("alice@example.com")), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: flatMap => $r7")

    // Exercise 8
    val r8 = exercise8_semiflatMap()
    assert(r8 == Right(Some("value: 42")), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: semiflatMap => $r8")

    println("\nAll Cats028_OptionT exercises passed!")
  }
}
