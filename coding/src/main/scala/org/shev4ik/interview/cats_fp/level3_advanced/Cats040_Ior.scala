package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 040 - Ior (Inclusive Or)
 *
 * Ior[A, B] represents a value that is either A, B, or Both(A, B).
 * Unlike Either (exclusive or), Ior can hold both a "left" and a "right" value.
 * This is useful for computations that can produce warnings alongside results.
 */
object Cats040_Ior {

  // Exercise 1: Ior.both - create an Ior with both left and right values
  // TODO: Create an Ior.Both containing a warning and a result.
  def exercise1_both(): Ior[String, Int] = {
    // Create Ior.Both("warning: truncated", 42)
    ???
  }

  // Exercise 2: Ior.left - create an Ior with only a left value (like a failure)
  // TODO: Create an Ior.Left value.
  def exercise2_left(): Ior[String, Int] = {
    // Create Ior.Left("fatal error")
    ???
  }

  // Exercise 3: Ior.right - create an Ior with only a right value (like success)
  // TODO: Create an Ior.Right value.
  def exercise3_right(): Ior[String, Int] = {
    // Create Ior.Right(42)
    ???
  }

  // Exercise 4: IorNec - Ior with NonEmptyChain for warning/error accumulation
  // TODO: Create IorNec values using .rightIor, .leftIor, .bothIor extensions.
  def exercise4_iorNec(): (IorNec[String, Int], IorNec[String, Int], IorNec[String, Int]) = {
    // Create right, left, and both IorNec values
    val right: IorNec[String, Int] = ???  // 42 as right IorNec
    val left: IorNec[String, Int] = ???   // "warning" as left IorNec
    val both: IorNec[String, Int] = ???   // Both(NonEmptyChain("warning"), 42)
    (right, left, both)
  }

  // Exercise 5: mapN on Ior - combine Ior values, accumulating lefts with Semigroup
  // TODO: Use mapN to combine Ior values. Left values combine via Semigroup.
  def exercise5_mapN(): Ior[String, String] = {
    val name: Ior[String, String] = Ior.both("name was trimmed, ", "Alice")
    val age: Ior[String, Int] = Ior.both("age was rounded, ", 30)

    // Combine with mapN - left warnings should concatenate
    ???
  }

  // Exercise 6: Ior for warnings - accumulate warnings while still producing a result
  // TODO: Demonstrate how Ior can carry warnings alongside successful computation.
  def exercise6_warnings(): Ior[List[String], Int] = {
    def parseWithWarnings(s: String): Ior[List[String], Int] = {
      val trimmed = s.trim
      val warnings = List.empty[String] ++
        (if (s != trimmed) List("input was trimmed") else Nil) ++
        (if (trimmed.startsWith("0") && trimmed.length > 1) List("leading zeros removed") else Nil)

      val value = scala.util.Try(trimmed.toInt).toOption.getOrElse(0)
      if (warnings.isEmpty) Ior.right(value)
      else Ior.both(warnings, value)
    }

    // Parse " 042 " which should produce warnings about trimming and leading zeros
    ???
  }

  // Exercise 7: Ior vs Validated vs Either - demonstrate the differences
  // TODO: Show how the same computation behaves differently with each type.
  def exercise7_comparison(): (Either[String, Int], Validated[String, Int], Ior[String, Int]) = {
    // Either short-circuits on first error
    val either: Either[String, Int] = for {
      a <- Either.cond(false, 1, "error1")
      b <- Either.cond(false, 2, "error2")
    } yield a + b

    // Validated accumulates all errors
    val v1 = Validated.invalid[String, Int]("error1")
    val v2 = Validated.invalid[String, Int]("error2")
    val validated: Validated[String, Int] = {
      type VS[A] = Validated[String, A]
      Apply[VS].map2(v1, v2)(_ + _)
    }

    // Ior can have both warnings and results
    val ior: Ior[String, Int] = ???  // Create Ior.both("warning", 42)

    (either, validated, ior)
  }

  // Exercise 8: flatMap on Ior - Ior is a Monad (unlike Validated) but accumulates left
  // TODO: Use flatMap on Ior. When Both, left values accumulate through flatMap.
  def exercise8_flatMap(): Ior[String, Int] = {
    val initial: Ior[String, Int] = Ior.both("step1 warning, ", 10)

    // flatMap: add another warning and transform the value
    // The left (warning) values should combine via Semigroup[String]
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_both()
    assert(r1.isBoth, s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: Ior.both => $r1")

    // Exercise 2
    val r2 = exercise2_left()
    assert(r2.isLeft, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: Ior.left => $r2")

    // Exercise 3
    val r3 = exercise3_right()
    assert(r3.isRight, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: Ior.right => $r3")

    // Exercise 4
    val (r4a, r4b, r4c) = exercise4_iorNec()
    assert(r4a.isRight && r4b.isLeft && r4c.isBoth, s"Exercise 4 failed")
    println(s"Exercise 4 passed: IorNec => right=$r4a, left=$r4b, both=$r4c")

    // Exercise 5
    val r5 = exercise5_mapN()
    assert(r5.isBoth, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: mapN on Ior => $r5")

    // Exercise 6
    val r6 = exercise6_warnings()
    assert(r6.isBoth, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: warnings => $r6")

    // Exercise 7
    val (r7a, r7b, r7c) = exercise7_comparison()
    assert(r7a.isLeft && r7b.isInvalid && r7c.isBoth, s"Exercise 7 failed")
    println(s"Exercise 7 passed: comparison => either=$r7a, validated=$r7b, ior=$r7c")

    // Exercise 8
    val r8 = exercise8_flatMap()
    assert(r8.isBoth, s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: flatMap on Ior => $r8")

    println("\nAll Cats040_Ior exercises passed!")
  }
}
