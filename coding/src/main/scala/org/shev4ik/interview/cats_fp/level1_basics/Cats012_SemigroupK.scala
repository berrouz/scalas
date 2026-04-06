package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 012 - SemigroupK Type Class
 *
 * SemigroupK[F[_]] is like Semigroup but for type constructors (kinds * -> *).
 * While Semigroup[List[Int]] combines values, SemigroupK[List] combines
 * the container structure regardless of element type.
 *
 * Key difference from Semigroup: SemigroupK works on F[_] (one type parameter),
 * Semigroup works on concrete types.
 *
 * Key methods: combineK, <+>, algebra
 */
object Cats012_SemigroupK {

  // -------------------------------------------------------------------------
  // Exercise 1: Use combineK to combine two Lists.
  // TODO: Return SemigroupK[List].combineK(a, b).
  // -------------------------------------------------------------------------
  def exercise1_combineKList(a: List[Int], b: List[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use <+> operator (syntax for combineK) with Lists.
  // TODO: Return a <+> b.
  // -------------------------------------------------------------------------
  def exercise2_combineKSyntax(a: List[String], b: List[String]): List[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use combineK for Option (returns first Some, or None).
  // TODO: Return a <+> b.
  // Hint: For Option, combineK returns the first Some found (left-biased).
  // -------------------------------------------------------------------------
  def exercise3_combineKOption(a: Option[Int], b: Option[Int]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use SemigroupK to chain fallback Options.
  // TODO: Try a, then b, then c. Return first Some found.
  // Hint: a <+> b <+> c
  // -------------------------------------------------------------------------
  def exercise4_optionFallbackChain(a: Option[String], b: Option[String], c: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use .algebra to get a Semigroup from SemigroupK for a specific type.
  // TODO: Get Semigroup[List[Int]] from SemigroupK[List].algebra[Int], then combine.
  // -------------------------------------------------------------------------
  def exercise5_algebra(a: List[Int], b: List[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Show difference between Semigroup and SemigroupK for Option[Int].
  // Semigroup[Option[Int]] combines the inner values: Some(1) |+| Some(2) == Some(3)
  // SemigroupK[Option] picks the first: Some(1) <+> Some(2) == Some(1)
  // TODO: Return a tuple of (semigroup result, semigroupK result).
  // -------------------------------------------------------------------------
  def exercise6_semigroupVsSemigroupK(a: Option[Int], b: Option[Int]): (Option[Int], Option[Int]) = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use combineK with nested types (e.g., List of Options).
  // TODO: Combine two List[Option[Int]] using SemigroupK[List].
  // Note: This concatenates the lists (SemigroupK[List]), ignoring Option structure.
  // -------------------------------------------------------------------------
  def exercise7_combineKNested(a: List[Option[Int]], b: List[Option[Int]]): List[Option[Int]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use combineKEval for lazy combination.
  // TODO: Use SemigroupK[Option].combineKEval(a, Eval.later(b)) and extract value.
  // Hint: The second argument is lazy (Eval), so it won't be evaluated if not needed.
  // -------------------------------------------------------------------------
  def exercise8_combineKEval(a: Option[Int], b: => Option[Int]): Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_combineKList(List(1, 2), List(3, 4)) == List(1, 2, 3, 4))
    println("Exercise 1 passed: combineK for List")

    // Exercise 2
    assert(exercise2_combineKSyntax(List("a"), List("b")) == List("a", "b"))
    println("Exercise 2 passed: <+> syntax")

    // Exercise 3
    assert(exercise3_combineKOption(Some(1), Some(2)) == Some(1))
    assert(exercise3_combineKOption(None, Some(2)) == Some(2))
    assert(exercise3_combineKOption(None, None) == None)
    println("Exercise 3 passed: combineK for Option")

    // Exercise 4
    assert(exercise4_optionFallbackChain(None, None, Some("c")) == Some("c"))
    assert(exercise4_optionFallbackChain(None, Some("b"), Some("c")) == Some("b"))
    assert(exercise4_optionFallbackChain(Some("a"), None, None) == Some("a"))
    println("Exercise 4 passed: Option fallback chain")

    // Exercise 5
    assert(exercise5_algebra(List(1), List(2)) == List(1, 2))
    println("Exercise 5 passed: algebra gives Semigroup from SemigroupK")

    // Exercise 6
    val (sg, sgk) = exercise6_semigroupVsSemigroupK(Some(1), Some(2))
    assert(sg == Some(3))  // Semigroup combines inner values
    assert(sgk == Some(1)) // SemigroupK picks first
    println("Exercise 6 passed: Semigroup vs SemigroupK difference")

    // Exercise 7
    assert(exercise7_combineKNested(List(Some(1)), List(None, Some(3))) == List(Some(1), None, Some(3)))
    println("Exercise 7 passed: combineK for nested types")

    // Exercise 8
    assert(exercise8_combineKEval(Some(1), Some(2)) == Some(1))
    assert(exercise8_combineKEval(None, Some(2)) == Some(2))
    println("Exercise 8 passed: combineKEval (lazy)")

    println("\nAll Cats012_SemigroupK exercises passed!")
  }
}
