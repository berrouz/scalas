package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 005 - Monoid Type Class
 *
 * Monoid extends Semigroup by adding an `empty` (identity) element.
 * Laws: combine(a, empty) == a, combine(empty, a) == a (identity)
 *       combine(combine(a, b), c) == combine(a, combine(b, c)) (associativity)
 *
 * Key methods: empty, combine, combineAll, foldMap
 */
object Cats005_Monoid {

  case class Stats(count: Int, total: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Get the empty (identity) element for Int Monoid.
  // TODO: Return Monoid[Int].empty.
  // -------------------------------------------------------------------------
  def exercise1_emptyInt: Int = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Get the empty element for String Monoid.
  // TODO: Return Monoid[String].empty.
  // -------------------------------------------------------------------------
  def exercise2_emptyString: String = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use combineAll to fold a list using the Monoid.
  // TODO: Return Monoid[Int].combineAll(values), or equivalently values.combineAll.
  // -------------------------------------------------------------------------
  def exercise3_combineAll(values: List[Int]): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a Monoid instance using Monoid.instance.
  // TODO: Define Monoid[Stats] with empty = Stats(0, 0.0) and combine adding fields.
  // -------------------------------------------------------------------------
  implicit val statsMonoid: Monoid[Stats] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Verify the identity law: combine(a, empty) == a.
  // TODO: Return true if (a |+| Monoid[Int].empty) == a.
  // -------------------------------------------------------------------------
  def exercise5_identityLaw(a: Int): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use combineAll on a Map Monoid.
  // TODO: Combine a list of Map[String, Int] into a single map.
  // -------------------------------------------------------------------------
  def exercise6_combineAllMaps(maps: List[Map[String, Int]]): Map[String, Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use foldMap to map and then combine.
  // TODO: Given a list of strings, use foldMap to get total length.
  // Hint: List("ab", "cde").foldMap(_.length) == 5
  // -------------------------------------------------------------------------
  def exercise7_foldMap(strings: List[String]): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use foldMap with a tuple Monoid to compute multiple aggregations.
  // TODO: Given a list of ints, compute (sum, count) in one pass using foldMap.
  // Hint: values.foldMap(x => (x, 1)) gives (sum, count).
  // -------------------------------------------------------------------------
  def exercise8_foldMapTuple(values: List[Int]): (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_emptyInt == 0)
    println("Exercise 1 passed: Monoid[Int].empty == 0")

    // Exercise 2
    assert(exercise2_emptyString == "")
    println("Exercise 2 passed: Monoid[String].empty == \"\"")

    // Exercise 3
    assert(exercise3_combineAll(List(1, 2, 3, 4)) == 10)
    assert(exercise3_combineAll(List.empty[Int]) == 0)
    println("Exercise 3 passed: combineAll")

    // Exercise 4
    val s1 = Stats(2, 10.0)
    val s2 = Stats(3, 15.0)
    assert((s1 |+| s2) == Stats(5, 25.0))
    assert((s1 |+| Monoid[Stats].empty) == s1)
    println("Exercise 4 passed: Monoid.instance for Stats")

    // Exercise 5
    assert(exercise5_identityLaw(42) == true)
    assert(exercise5_identityLaw(0) == true)
    println("Exercise 5 passed: identity law verified")

    // Exercise 6
    val maps = List(Map("a" -> 1, "b" -> 2), Map("b" -> 3, "c" -> 4), Map("a" -> 10))
    assert(exercise6_combineAllMaps(maps) == Map("a" -> 11, "b" -> 5, "c" -> 4))
    println("Exercise 6 passed: combineAll for Maps")

    // Exercise 7
    assert(exercise7_foldMap(List("ab", "cde", "f")) == 6)
    assert(exercise7_foldMap(List.empty[String]) == 0)
    println("Exercise 7 passed: foldMap for string lengths")

    // Exercise 8
    assert(exercise8_foldMapTuple(List(10, 20, 30)) == (60, 3))
    assert(exercise8_foldMapTuple(List.empty[Int]) == (0, 0))
    println("Exercise 8 passed: foldMap with tuple Monoid")

    println("\nAll Cats005_Monoid exercises passed!")
  }
}
