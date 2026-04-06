package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 004 - Semigroup Type Class
 *
 * A Semigroup defines a binary associative operation `combine`.
 * The key law: combine(combine(a, b), c) == combine(a, combine(b, c))
 *
 * Syntax: |+| operator for combine.
 */
object Cats004_Semigroup {

  case class Speed(metersPerSecond: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Use the |+| operator to combine two integers (addition).
  // TODO: Return a |+| b.
  // -------------------------------------------------------------------------
  def exercise1_combineInts(a: Int, b: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use |+| to combine two strings (concatenation).
  // TODO: Return a |+| b.
  // -------------------------------------------------------------------------
  def exercise2_combineStrings(a: String, b: String): String = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use |+| to combine two Lists.
  // TODO: Return a |+| b.
  // -------------------------------------------------------------------------
  def exercise3_combineLists(a: List[Int], b: List[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a Semigroup instance using Semigroup.instance.
  // TODO: Define Semigroup[Speed] that adds metersPerSecond values.
  // -------------------------------------------------------------------------
  implicit val speedSemigroup: Semigroup[Speed] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use |+| to combine two Maps (values are combined by their Semigroup).
  // TODO: Combine two Map[String, Int] using |+|.
  // Hint: Matching keys have their values combined via Semigroup[Int] (addition).
  // -------------------------------------------------------------------------
  def exercise5_combineMaps(a: Map[String, Int], b: Map[String, Int]): Map[String, Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use combineN to combine a value with itself n times.
  // TODO: Return Semigroup[Int].combineN(value, n).
  // Hint: combineN(10, 3) = 10 |+| 10 |+| 10 = 30
  // -------------------------------------------------------------------------
  def exercise6_combineN(value: Int, n: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use combineAllOption to combine a list of values.
  // TODO: Return Semigroup[Int].combineAllOption(values).
  // Returns None for empty list, Some(combined) otherwise.
  // -------------------------------------------------------------------------
  def exercise7_combineAllOption(values: List[Int]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Demonstrate associativity law.
  // TODO: Return true if (a |+| b) |+| c == a |+| (b |+| c).
  // This must always hold for a valid Semigroup.
  // -------------------------------------------------------------------------
  def exercise8_associativityCheck(a: String, b: String, c: String): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_combineInts(3, 5) == 8)
    println("Exercise 1 passed: |+| for Int")

    // Exercise 2
    assert(exercise2_combineStrings("Hello, ", "World!") == "Hello, World!")
    println("Exercise 2 passed: |+| for String")

    // Exercise 3
    assert(exercise3_combineLists(List(1, 2), List(3, 4)) == List(1, 2, 3, 4))
    println("Exercise 3 passed: |+| for List")

    // Exercise 4
    assert((Speed(10.0) |+| Speed(5.0)) == Speed(15.0))
    println("Exercise 4 passed: Semigroup.instance for Speed")

    // Exercise 5
    val m1 = Map("a" -> 1, "b" -> 2)
    val m2 = Map("b" -> 3, "c" -> 4)
    assert(exercise5_combineMaps(m1, m2) == Map("a" -> 1, "b" -> 5, "c" -> 4))
    println("Exercise 5 passed: |+| for Map")

    // Exercise 6
    assert(exercise6_combineN(10, 3) == 30)
    println("Exercise 6 passed: combineN")

    // Exercise 7
    assert(exercise7_combineAllOption(List(1, 2, 3, 4)) == Some(10))
    assert(exercise7_combineAllOption(List.empty[Int]) == None)
    println("Exercise 7 passed: combineAllOption")

    // Exercise 8
    assert(exercise8_associativityCheck("a", "b", "c") == true)
    println("Exercise 8 passed: associativity law holds")

    println("\nAll Cats004_Semigroup exercises passed!")
  }
}
