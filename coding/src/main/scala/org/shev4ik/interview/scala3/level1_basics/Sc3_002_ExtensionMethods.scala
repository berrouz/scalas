package org.shev4ik.interview.scala3.level1_basics

/**
 * Scala 3: Extension Methods (modeled with Scala 2.13 implicit classes)
 *
 * In Scala 3, `extension (x: T) def method = ...` replaces implicit classes.
 * Here we model Scala 3 extension methods using Scala 2.13 implicit classes.
 */
object Sc3_002_ExtensionMethods {

  // Exercise 1: Basic extension method on Int
  // In Scala 3: extension (n: Int) def isEven: Boolean = n % 2 == 0
  // TODO: Create an implicit class `IntExtensions` that adds:
  //       - `isEven: Boolean` — true if the number is even
  //       - `isOdd: Boolean` — true if the number is odd
  //       - `times(f: => Unit): Unit` — executes f exactly n times
  //       Return (n.isEven, n.isOdd) for the test.
  implicit class IntExtensions(val n: Int) extends AnyVal {
    def isEven: Boolean = ???
    def isOdd: Boolean = ???
    def times(f: => Unit): Unit = ???
  }
  def exercise1_intExtensions(n: Int): (Boolean, Boolean) = ???

  // Exercise 2: Extension method on String
  // In Scala 3: extension (s: String) def words: List[String] = s.split("\\s+").toList
  // TODO: Create an implicit class `StringExtensions` that adds:
  //       - `words: List[String]` — split by whitespace
  //       - `isPalindrome: Boolean` — check if string reads the same forwards/backwards (case-insensitive)
  //       - `truncate(maxLen: Int): String` — truncate to maxLen, append "..." if truncated
  implicit class StringExtensions(val s: String) extends AnyVal {
    def words: List[String] = ???
    def isPalindrome: Boolean = ???
    def truncate(maxLen: Int): String = ???
  }
  def exercise2_stringWords(s: String): List[String] = ???
  def exercise2_stringPalindrome(s: String): Boolean = ???
  def exercise2_stringTruncate(s: String, maxLen: Int): String = ???

  // Exercise 3: Generic extension method
  // In Scala 3: extension [A](xs: List[A]) def second: Option[A] = xs.drop(1).headOption
  // TODO: Create an implicit class `ListExtensions` that adds:
  //       - `second: Option[A]` — the second element if it exists
  //       - `penultimate: Option[A]` — the second-to-last element if it exists
  implicit class ListExtensions[A](val xs: List[A]) extends AnyVal {
    def second: Option[A] = ???
    def penultimate: Option[A] = ???
  }
  def exercise3_second[A](xs: List[A]): Option[A] = ???
  def exercise3_penultimate[A](xs: List[A]): Option[A] = ???

  // Exercise 4: Extension method with type class constraint
  // In Scala 3: extension [A](xs: List[A])(using Numeric[A]) def average: Double
  // TODO: Create an implicit class `NumericListExtensions` that requires an implicit Numeric[A]
  //       and adds `average: Double` — compute the arithmetic mean.
  //       Note: Cannot use AnyVal with implicit params, so use regular implicit class.
  implicit class NumericListExtensions[A](val xs: List[A])(implicit num: Numeric[A]) {
    def average: Double = ???
  }
  def exercise4_average[A: Numeric](xs: List[A]): Double = ???

  // Exercise 5: Chained extension methods (builder pattern)
  // In Scala 3: extension methods allow fluent APIs naturally.
  // TODO: Create a case class `Query(table: String, conditions: List[String], limit: Option[Int])`.
  //       Create an implicit class `QueryExtensions` on Query that adds:
  //       - `where(condition: String): Query` — adds a condition
  //       - `limitTo(n: Int): Query` — sets the limit
  //       - `toSql: String` — produces "SELECT * FROM <table> WHERE <cond1> AND <cond2> LIMIT <n>"
  //         (omit WHERE if no conditions, omit LIMIT if no limit)
  case class Query(table: String, conditions: List[String], limit: Option[Int])
  implicit class QueryExtensions(val q: Query) extends AnyVal {
    def where(condition: String): Query = ???
    def limitTo(n: Int): Query = ???
    def toSql: String = ???
  }
  def exercise5_querySql: String = ???

  // Exercise 6: Extension on tuple types
  // In Scala 3: extension [(A, B)](pair: (A, B)) def swap: (B, A)
  // TODO: Create an implicit class `PairExtensions` on (A, B) that adds:
  //       - `swap: (B, A)` — swaps the elements
  //       - `mapFirst[C](f: A => C): (C, B)` — applies f to the first element
  //       - `mapSecond[C](f: B => C): (A, C)` — applies f to the second element
  implicit class PairExtensions[A, B](val pair: (A, B)) extends AnyVal {
    def swap: (B, A) = ???
    def mapFirst[C](f: A => C): (C, B) = ???
    def mapSecond[C](f: B => C): (A, C) = ???
  }
  def exercise6_swap[A, B](pair: (A, B)): (B, A) = ???
  def exercise6_mapFirst(pair: (Int, String)): (String, String) = ???

  // Exercise 7: Extension with operator syntax
  // In Scala 3: extension (x: Vec2) def +(y: Vec2): Vec2
  // TODO: Create a case class `Vec2(x: Double, y: Double)`.
  //       Create an implicit class that adds:
  //       - `+(other: Vec2): Vec2` — vector addition
  //       - `*(scalar: Double): Vec2` — scalar multiplication
  //       - `magnitude: Double` — sqrt(x*x + y*y)
  case class Vec2(x: Double, y: Double)
  implicit class Vec2Extensions(val v: Vec2) extends AnyVal {
    def +(other: Vec2): Vec2 = ???
    def *(scalar: Double): Vec2 = ???
    def magnitude: Double = ???
  }
  def exercise7_vecAdd(a: Vec2, b: Vec2): Vec2 = ???
  def exercise7_vecMag(v: Vec2): Double = ???

  // Exercise 8: Collective extension (Scala 3 groups multiple extensions)
  // In Scala 3: extension [A](xs: List[A]) { def head2 = ...; def tail2 = ... }
  // TODO: Create an implicit class `MapExtensions` on Map[K, V] that adds:
  //       - `mergeWith(other: Map[K, V])(f: (V, V) => V): Map[K, V]` — merge maps, using f for conflicts
  //       - `invert: Map[V, List[K]]` — invert the map (values become keys, keys become list of values)
  //       Note: Cannot use AnyVal with multiple type params, so use regular implicit class.
  implicit class MapExtensions[K, V](val m: Map[K, V]) {
    def mergeWith(other: Map[K, V])(f: (V, V) => V): Map[K, V] = ???
    def invert: Map[V, List[K]] = ???
  }
  def exercise8_mergeWith(a: Map[String, Int], b: Map[String, Int]): Map[String, Int] = ???
  def exercise8_invert(m: Map[String, Int]): Map[Int, List[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_intExtensions(4) == (true, false), "Exercise 1 failed: 4 should be even")
    assert(exercise1_intExtensions(7) == (false, true), "Exercise 1 failed: 7 should be odd")
    var count = 0; 3.times { count += 1 }
    assert(count == 3, "Exercise 1 failed: times")

    // Exercise 2
    assert(exercise2_stringWords("hello world foo") == List("hello", "world", "foo"), "Exercise 2 words failed")
    assert(exercise2_stringPalindrome("Racecar"), "Exercise 2 palindrome failed")
    assert(!exercise2_stringPalindrome("hello"), "Exercise 2 palindrome failed")
    assert(exercise2_stringTruncate("Hello, World!", 5) == "Hello...", "Exercise 2 truncate failed")
    assert(exercise2_stringTruncate("Hi", 5) == "Hi", "Exercise 2 truncate failed")

    // Exercise 3
    assert(exercise3_second(List(1, 2, 3)) == Some(2), "Exercise 3 second failed")
    assert(exercise3_second(List(1)) == None, "Exercise 3 second failed")
    assert(exercise3_penultimate(List(1, 2, 3)) == Some(2), "Exercise 3 penultimate failed")
    assert(exercise3_penultimate(List(1)) == None, "Exercise 3 penultimate failed")

    // Exercise 4
    assert(exercise4_average(List(1, 2, 3, 4)) == 2.5, "Exercise 4 failed")
    assert(exercise4_average(List(10.0, 20.0)) == 15.0, "Exercise 4 failed")

    // Exercise 5
    val sql = Query("users", Nil, None).where("age > 18").where("active = true").limitTo(10).toSql
    assert(sql == "SELECT * FROM users WHERE age > 18 AND active = true LIMIT 10", "Exercise 5 failed")
    val sql2 = Query("orders", Nil, None).toSql
    assert(sql2 == "SELECT * FROM orders", "Exercise 5 failed: no conditions")

    // Exercise 6
    assert(exercise6_swap((1, "hello")) == ("hello", 1), "Exercise 6 swap failed")
    assert(exercise6_mapFirst((42, "hello")) == ("42", "hello"), "Exercise 6 mapFirst failed")

    // Exercise 7
    assert(exercise7_vecAdd(Vec2(1, 2), Vec2(3, 4)) == Vec2(4, 6), "Exercise 7 add failed")
    assert(Math.abs(exercise7_vecMag(Vec2(3, 4)) - 5.0) < 0.001, "Exercise 7 magnitude failed")

    // Exercise 8
    val merged = exercise8_mergeWith(Map("a" -> 1, "b" -> 2), Map("b" -> 3, "c" -> 4))
    assert(merged == Map("a" -> 1, "b" -> 5, "c" -> 4), "Exercise 8 merge failed")
    val inverted = exercise8_invert(Map("a" -> 1, "b" -> 1, "c" -> 2))
    assert(inverted(1).sorted == List("a", "b"), "Exercise 8 invert failed")
    assert(inverted(2) == List("c"), "Exercise 8 invert failed")

    println("All Sc3_002_ExtensionMethods exercises passed!")
  }
}
