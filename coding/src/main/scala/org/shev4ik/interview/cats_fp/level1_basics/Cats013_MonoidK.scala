package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 013 - MonoidK Type Class
 *
 * MonoidK[F[_]] extends SemigroupK with `empty`, providing an identity element
 * for combineK. Like Monoid extends Semigroup, MonoidK extends SemigroupK.
 *
 * MonoidK[F].empty gives F[Nothing] (the empty container), which works as
 * identity for <+>.
 *
 * Key methods: empty, combineK, algebra
 */
object Cats013_MonoidK {

  // -------------------------------------------------------------------------
  // Exercise 1: Get the empty element for MonoidK[List].
  // TODO: Return MonoidK[List].empty[Int].
  // -------------------------------------------------------------------------
  def exercise1_emptyList: List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Get the empty element for MonoidK[Option].
  // TODO: Return MonoidK[Option].empty[String].
  // -------------------------------------------------------------------------
  def exercise2_emptyOption: Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Verify the identity law: combineK(a, empty) == a.
  // TODO: Return true if (a <+> MonoidK[List].empty[Int]) == a.
  // -------------------------------------------------------------------------
  def exercise3_rightIdentity(a: List[Int]): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Verify the identity law: combineK(empty, a) == a.
  // TODO: Return true if (MonoidK[List].empty[Int] <+> a) == a.
  // -------------------------------------------------------------------------
  def exercise4_leftIdentity(a: List[Int]): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use .algebra to get a Monoid from MonoidK.
  // TODO: Get Monoid[Option[Int]] from MonoidK[Option].algebra[Int] and get its empty.
  // -------------------------------------------------------------------------
  def exercise5_algebraEmpty: Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Combine a list of Lists using MonoidK.
  // TODO: Use MonoidK[List].algebra[Int].combineAll to fold list of lists.
  // -------------------------------------------------------------------------
  def exercise6_combineAllLists(lists: List[List[Int]]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Show difference between MonoidK and Monoid for Option.
  // MonoidK[Option].empty[Int] == None
  // Monoid[Option[Int]].empty == None (same here, but combine differs!)
  // MonoidK: <+> picks first Some
  // Monoid:  |+|  combines inner values
  // TODO: Return a tuple (monoidK_combine, monoid_combine).
  // -------------------------------------------------------------------------
  def exercise7_monoidKVsMonoid(a: Option[Int], b: Option[Int]): (Option[Int], Option[Int]) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use MonoidK with a custom fold.
  // TODO: Given a list of Options, fold them using MonoidK[Option] to find
  // the first Some value. Use .foldLeft with MonoidK[Option].empty and <+>.
  // -------------------------------------------------------------------------
  def exercise8_foldWithMonoidK(options: List[Option[Int]]): Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_emptyList == List.empty[Int])
    println("Exercise 1 passed: MonoidK[List].empty")

    // Exercise 2
    assert(exercise2_emptyOption == None)
    println("Exercise 2 passed: MonoidK[Option].empty")

    // Exercise 3
    assert(exercise3_rightIdentity(List(1, 2, 3)) == true)
    println("Exercise 3 passed: right identity law")

    // Exercise 4
    assert(exercise4_leftIdentity(List(1, 2, 3)) == true)
    println("Exercise 4 passed: left identity law")

    // Exercise 5
    assert(exercise5_algebraEmpty == None)
    println("Exercise 5 passed: algebra gives Monoid from MonoidK")

    // Exercise 6
    assert(exercise6_combineAllLists(List(List(1, 2), List(3), List(4, 5))) == List(1, 2, 3, 4, 5))
    assert(exercise6_combineAllLists(List.empty) == List.empty[Int])
    println("Exercise 6 passed: combineAll with MonoidK algebra")

    // Exercise 7
    val (mk, m) = exercise7_monoidKVsMonoid(Some(1), Some(2))
    assert(mk == Some(1)) // MonoidK picks first
    assert(m == Some(3))  // Monoid combines inner
    println("Exercise 7 passed: MonoidK vs Monoid for Option")

    // Exercise 8
    assert(exercise8_foldWithMonoidK(List(None, None, Some(3), Some(4))) == Some(3))
    assert(exercise8_foldWithMonoidK(List(None, None)) == None)
    println("Exercise 8 passed: fold with MonoidK")

    println("\nAll Cats013_MonoidK exercises passed!")
  }
}
