package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 014 - Alternative Type Class
 *
 * Alternative[F[_]] combines Applicative and MonoidK, giving you both `pure`
 * and `empty`/`combineK`. This enables patterns like guard, unite, and separate.
 *
 * Alternative = Applicative + MonoidK
 *
 * Key methods: pure, combineK, guard, unite, separate
 */
object Cats014_Alternative {

  // -------------------------------------------------------------------------
  // Exercise 1: Use Alternative to combine pure and combineK.
  // TODO: Create Some(42) using Alternative[Option].pure, then <+> with None.
  // -------------------------------------------------------------------------
  def exercise1_pureAndCombineK: Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use guard to conditionally produce a value.
  // TODO: If cond is true, return Some(()), else return None.
  // Hint: Alternative[Option].guard(cond)
  // -------------------------------------------------------------------------
  def exercise2_guard(cond: Boolean): Option[Unit] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use guard with map to produce a conditional value.
  // TODO: If n is even, return Some(n), else None.
  // Hint: Alternative[Option].guard(n % 2 == 0).as(n)
  // -------------------------------------------------------------------------
  def exercise3_guardWithValue(n: Int): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use unite to flatten F[G[A]] to F[A] (where G is Foldable).
  // TODO: Given a List[Option[Int]], flatten it removing Nones.
  // Hint: Alternative[List].unite(list) flattens Option values within List.
  // -------------------------------------------------------------------------
  def exercise4_unite(list: List[Option[Int]]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use separate to split F[Either[A, B]] into (F[A], F[B]).
  // TODO: Separate a list of Eithers into (lefts, rights).
  // Hint: Alternative[List].separate(list)
  // -------------------------------------------------------------------------
  def exercise5_separate(list: List[Either[String, Int]]): (List[String], List[Int]) = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use Alternative for List to combine multiple lists.
  // TODO: Combine three lists using <+>.
  // -------------------------------------------------------------------------
  def exercise6_alternativeList(a: List[Int], b: List[Int], c: List[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use guard to filter within a for-comprehension.
  // TODO: Generate all pairs (x, y) where x is from 1..n, y is from 1..n,
  // and x + y == target. Use Alternative[List].guard.
  // -------------------------------------------------------------------------
  def exercise7_guardInForComprehension(n: Int, target: Int): List[(Int, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use separate with Option[Either].
  // TODO: Separate a List[Option[Either[String, Int]]] - first unite to remove
  // None, then separate the Eithers.
  // -------------------------------------------------------------------------
  def exercise8_uniteAndSeparate(list: List[Option[Either[String, Int]]]): (List[String], List[Int]) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_pureAndCombineK == Some(42))
    println("Exercise 1 passed: pure and combineK")

    // Exercise 2
    assert(exercise2_guard(true) == Some(()))
    assert(exercise2_guard(false) == None)
    println("Exercise 2 passed: guard")

    // Exercise 3
    assert(exercise3_guardWithValue(4) == Some(4))
    assert(exercise3_guardWithValue(3) == None)
    println("Exercise 3 passed: guard with value")

    // Exercise 4
    assert(exercise4_unite(List(Some(1), None, Some(3), None, Some(5))) == List(1, 3, 5))
    println("Exercise 4 passed: unite flattens Options in List")

    // Exercise 5
    val (lefts, rights) = exercise5_separate(List(Right(1), Left("err"), Right(2), Left("bad")))
    assert(lefts == List("err", "bad"))
    assert(rights == List(1, 2))
    println("Exercise 5 passed: separate splits Eithers")

    // Exercise 6
    assert(exercise6_alternativeList(List(1), List(2, 3), List(4)) == List(1, 2, 3, 4))
    println("Exercise 6 passed: Alternative for List")

    // Exercise 7
    assert(exercise7_guardInForComprehension(5, 6) == List((1, 5), (2, 4), (3, 3), (4, 2), (5, 1)))
    println("Exercise 7 passed: guard in for-comprehension")

    // Exercise 8
    val input = List(Some(Right(1)), None, Some(Left("err")), Some(Right(3)), None)
    val (l, r) = exercise8_uniteAndSeparate(input)
    assert(l == List("err"))
    assert(r == List(1, 3))
    println("Exercise 8 passed: unite then separate")

    println("\nAll Cats014_Alternative exercises passed!")
  }
}
