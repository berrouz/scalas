package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 041 - Nested
 *
 * Nested[F, G, A] wraps an F[G[A]] and provides composed Functor/Applicative
 * instances. This lets you map through two layers without manual nesting.
 * Nested works with Functor and Applicative but NOT Monad (monads don't compose in general).
 */
object Cats041_Nested {

  // Exercise 1: Nested creation - wrap an F[G[A]] in Nested
  // TODO: Create a Nested value from a List[Option[Int]].
  def exercise1_createNested(): Nested[List, Option, Int] = {
    val listOfOptions: List[Option[Int]] = List(Some(1), Some(2), None, Some(3))
    // Wrap in Nested
    ???
  }

  // Exercise 2: map through two layers - use Nested to map through F[G[_]]
  // TODO: Use Nested.map to transform the inner value without manual nesting.
  def exercise2_mapThroughLayers(): List[Option[Int]] = {
    val nested = Nested(List(Some(1), Some(2), None, Some(3)))
    // Map (* 10) through both layers, then call .value to unwrap
    ???
  }

  // Exercise 3: Nested Applicative - use mapN on Nested values
  // TODO: Combine two Nested values using Applicative (mapN).
  def exercise3_nestedApplicative(): List[Option[Int]] = {
    val n1 = Nested(List(Some(1), Some(2)))
    val n2 = Nested(List(Some(10), Some(20)))
    // Combine using mapN to add inner values, then .value
    ???
  }

  // Exercise 4: Nested traverse - traverse through nested structure
  // TODO: Use Nested with Traverse to traverse through two layers.
  def exercise4_nestedTraverse(): Option[List[Option[Int]]] = {
    val nested = Nested(List(Some(1), Some(2), Some(3)))
    // Traverse the outer List through Option, keeping the Nested structure
    // Hint: Use .traverse on the inner values
    val result: Option[List[Int]] = (List(Some(1), Some(2), Some(3)): List[Option[Int]]).sequence
    // Convert back to the expected type
    ???
  }

  // Exercise 5: unnest - extract the wrapped F[G[A]] from Nested
  // TODO: Use .value to extract the underlying F[G[A]].
  def exercise5_unnest(): List[Option[String]] = {
    val nested = Nested(List(Some(1), Some(2), None))
    // Map to transform Int to String, then unwrap with .value
    ???
  }

  // Exercise 6: Nested for composed functors - compose Functor instances
  // TODO: Use Nested to compose functors that wouldn't easily compose otherwise.
  def exercise6_composedFunctors(): Either[String, Option[Int]] = {
    val value: Either[String, Option[Int]] = Right(Some(5))
    type EitherS[A] = Either[String, A]
    val nested = Nested[EitherS, Option, Int](value)
    // Map (* 2) through both Either and Option layers
    ???
  }

  // Exercise 7: Nested limitations - demonstrate that Nested doesn't provide Monad
  // TODO: Show that Nested provides Applicative but not Monad (no flatMap).
  def exercise7_limitations(): List[Option[Int]] = {
    // Nested gives us Applicative but not Monad
    // We can use map and mapN but NOT flatMap
    val n1 = Nested(List(Some(1), Some(2)))

    // Use map (which works) to double the value
    val mapped: Nested[List, Option, Int] = ???

    mapped.value
  }

  // Exercise 8: Nested vs monad transformers - compare approaches
  // TODO: Compare Nested approach vs OptionT for the same problem.
  def exercise8_nestedVsTransformer(): (List[Option[Int]], List[Option[Int]]) = {
    // Approach 1: Using Nested (Applicative only)
    val nested = Nested(List(Some(1), Some(2), None))
    val nestedResult: List[Option[Int]] = ???  // map (* 10), then .value

    // Approach 2: Using OptionT (full Monad)
    val optionT = OptionT(List(Some(1), Some(2), None))
    val optionTResult: List[Option[Int]] = ???  // map (* 10), then .value

    (nestedResult, optionTResult)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_createNested()
    assert(r1.value == List(Some(1), Some(2), None, Some(3)), s"Exercise 1 failed: ${r1.value}")
    println(s"Exercise 1 passed: Nested => ${r1.value}")

    // Exercise 2
    val r2 = exercise2_mapThroughLayers()
    assert(r2 == List(Some(10), Some(20), None, Some(30)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: map through layers => $r2")

    // Exercise 3
    val r3 = exercise3_nestedApplicative()
    println(s"Exercise 3 passed: Nested Applicative => $r3")

    // Exercise 4
    val r4 = exercise4_nestedTraverse()
    assert(r4 == Some(List(Some(1), Some(2), Some(3))), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: Nested traverse => $r4")

    // Exercise 5
    val r5 = exercise5_unnest()
    assert(r5 == List(Some("1"), Some("2"), None), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: unnest => $r5")

    // Exercise 6
    val r6 = exercise6_composedFunctors()
    assert(r6 == Right(Some(10)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: composed functors => $r6")

    // Exercise 7
    val r7 = exercise7_limitations()
    assert(r7 == List(Some(2), Some(4)), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: Nested limitations => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_nestedVsTransformer()
    assert(r8a == r8b, s"Exercise 8 failed: nested=$r8a, optionT=$r8b")
    println(s"Exercise 8 passed: Nested vs transformer => nested=$r8a, optionT=$r8b")

    println("\nAll Cats041_Nested exercises passed!")
  }
}
