package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 009 - Apply Type Class
 *
 * Apply is the parent of Applicative (without `pure`). It provides `ap` and
 * derived combinators: map2, productL, productR, tupled, mapN, ap2.
 *
 * Apply enables combining independent computations in a context without
 * needing to lift values with `pure`.
 */
object Cats009_Apply {

  case class User(name: String, age: Int, email: String)

  // -------------------------------------------------------------------------
  // Exercise 1: Use Apply[Option].ap to apply a function inside Option.
  // TODO: Apply the function in optF to the value in optA.
  // -------------------------------------------------------------------------
  def exercise1_ap[A, B](optF: Option[A => B], optA: Option[A]): Option[B] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use Apply[Option].map2 to combine two Options.
  // TODO: Combine a and b with the function f.
  // -------------------------------------------------------------------------
  def exercise2_map2(a: Option[Int], b: Option[Int], f: (Int, Int) => Int): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use productL (<*) to keep only the left result.
  // TODO: Return a <* b (evaluates both, keeps a's value).
  // -------------------------------------------------------------------------
  def exercise3_productL(a: Option[Int], b: Option[String]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use productR (*>) to keep only the right result.
  // TODO: Return a *> b (evaluates both, keeps b's value).
  // -------------------------------------------------------------------------
  def exercise4_productR(a: Option[Int], b: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use tupled to combine multiple Options into a tuple.
  // TODO: Return (a, b, c).tupled which gives Option[(Int, String, Double)].
  // -------------------------------------------------------------------------
  def exercise5_tupled(a: Option[Int], b: Option[String], c: Option[Double]): Option[(Int, String, Double)] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use mapN to combine multiple Options and apply a function.
  // TODO: Use (name, age, email).mapN(User.apply) to construct a User.
  // -------------------------------------------------------------------------
  def exercise6_mapN(name: Option[String], age: Option[Int], email: Option[String]): Option[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use ap2 to apply a 2-argument function in context.
  // TODO: Apply a curried function to two Option values using Apply[Option].ap2.
  // Hint: Apply[Option].ap2(Some((a: Int, b: Int) => a + b))(Some(1), Some(2))
  // -------------------------------------------------------------------------
  def exercise7_ap2(f: Option[(Int, Int) => Int], a: Option[Int], b: Option[Int]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use mapN on List to apply a function across all combinations.
  // TODO: Given two lists, produce all combinations using mapN.
  // Hint: (listA, listB).mapN(_ + _) produces the cartesian product with +.
  // -------------------------------------------------------------------------
  def exercise8_mapNList(listA: List[Int], listB: List[Int]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_ap(Some((_: Int) * 2), Some(21)) == Some(42))
    assert(exercise1_ap(None, Some(21)) == None)
    println("Exercise 1 passed: Apply[Option].ap")

    // Exercise 2
    assert(exercise2_map2(Some(3), Some(4), _ + _) == Some(7))
    assert(exercise2_map2(None, Some(4), (_: Int) + (_: Int)) == None)
    println("Exercise 2 passed: Apply[Option].map2")

    // Exercise 3
    assert(exercise3_productL(Some(1), Some("hello")) == Some(1))
    assert(exercise3_productL(Some(1), None) == None)
    println("Exercise 3 passed: productL (<*)")

    // Exercise 4
    assert(exercise4_productR(Some(1), Some("hello")) == Some("hello"))
    assert(exercise4_productR(None, Some("hello")) == None)
    println("Exercise 4 passed: productR (*>)")

    // Exercise 5
    assert(exercise5_tupled(Some(1), Some("a"), Some(2.0)) == Some((1, "a", 2.0)))
    assert(exercise5_tupled(Some(1), None, Some(2.0)) == None)
    println("Exercise 5 passed: tupled")

    // Exercise 6
    assert(exercise6_mapN(Some("Alice"), Some(30), Some("alice@test.com")) == Some(User("Alice", 30, "alice@test.com")))
    assert(exercise6_mapN(Some("Alice"), None, Some("alice@test.com")) == None)
    println("Exercise 6 passed: mapN to construct case class")

    // Exercise 7
    assert(exercise7_ap2(Some((a: Int, b: Int) => a * b), Some(3), Some(4)) == Some(12))
    assert(exercise7_ap2(None, Some(3), Some(4)) == None)
    println("Exercise 7 passed: ap2")

    // Exercise 8
    assert(exercise8_mapNList(List(1, 2), List(10, 20)) == List(11, 21, 12, 22))
    println("Exercise 8 passed: mapN on List (cartesian product)")

    println("\nAll Cats009_Apply exercises passed!")
  }
}
