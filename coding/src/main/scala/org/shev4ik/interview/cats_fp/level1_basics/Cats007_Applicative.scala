package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 007 - Applicative Type Class
 *
 * Applicative extends Apply (and Functor) by adding `pure`, which lifts a
 * value into the context F[_]. Combined with Apply's `ap`, it enables
 * independent effectful computations (unlike Monad which is sequential).
 *
 * Key methods: pure, ap, map2, map3, *>, <*, product
 */
object Cats007_Applicative {

  // -------------------------------------------------------------------------
  // Exercise 1: Use Applicative[Option].pure to lift a value into Option.
  // TODO: Return the value wrapped in Option using pure.
  // -------------------------------------------------------------------------
  def exercise1_pure[A](value: A): Option[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use Applicative[List].pure to lift a value into List.
  // TODO: Return a single-element list containing the value.
  // -------------------------------------------------------------------------
  def exercise2_pureList[A](value: A): List[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use ap to apply a function in a context to a value in a context.
  // TODO: Apply optF to optA using Applicative[Option].ap.
  // Hint: Applicative[Option].ap(optF)(optA)
  // -------------------------------------------------------------------------
  def exercise3_ap(optF: Option[Int => String], optA: Option[Int]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use map2 to combine two Option values with a function.
  // TODO: Combine optA and optB using Applicative[Option].map2.
  // -------------------------------------------------------------------------
  def exercise4_map2(optA: Option[Int], optB: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use map3 to combine three Option values.
  // TODO: Combine three options into a formatted string.
  // Format: "<name> is <age> years old from <city>"
  // -------------------------------------------------------------------------
  def exercise5_map3(name: Option[String], age: Option[Int], city: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use *> (productR) to sequence, keeping the right side.
  // TODO: Return optA *> optB (discards left value, keeps right).
  // -------------------------------------------------------------------------
  def exercise6_productR(optA: Option[Int], optB: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use <* (productL) to sequence, keeping the left side.
  // TODO: Return optA <* optB (keeps left value, discards right).
  // -------------------------------------------------------------------------
  def exercise7_productL(optA: Option[Int], optB: Option[String]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use product to combine two contexts into a tuple.
  // TODO: Return Applicative[Option].product(optA, optB).
  // -------------------------------------------------------------------------
  def exercise8_product(optA: Option[Int], optB: Option[String]): Option[(Int, String)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_pure(42) == Some(42))
    assert(exercise1_pure("hello") == Some("hello"))
    println("Exercise 1 passed: Applicative[Option].pure")

    // Exercise 2
    assert(exercise2_pureList(42) == List(42))
    println("Exercise 2 passed: Applicative[List].pure")

    // Exercise 3
    assert(exercise3_ap(Some((_: Int).toString), Some(42)) == Some("42"))
    assert(exercise3_ap(None, Some(42)) == None)
    assert(exercise3_ap(Some((_: Int).toString), None) == None)
    println("Exercise 3 passed: ap applies function in context")

    // Exercise 4
    assert(exercise4_map2(Some(42), Some("hello")) == Some("42hello"))
    assert(exercise4_map2(None, Some("hello")) == None)
    println("Exercise 4 passed: map2 combines two Options")

    // Exercise 5
    assert(exercise5_map3(Some("Alice"), Some(30), Some("NYC")) == Some("Alice is 30 years old from NYC"))
    assert(exercise5_map3(Some("Alice"), None, Some("NYC")) == None)
    println("Exercise 5 passed: map3 combines three Options")

    // Exercise 6
    assert(exercise6_productR(Some(1), Some("hello")) == Some("hello"))
    assert(exercise6_productR(None, Some("hello")) == None)
    assert(exercise6_productR(Some(1), None) == None)
    println("Exercise 6 passed: *> keeps right")

    // Exercise 7
    assert(exercise7_productL(Some(1), Some("hello")) == Some(1))
    assert(exercise7_productL(None, Some("hello")) == None)
    assert(exercise7_productL(Some(1), None) == None)
    println("Exercise 7 passed: <* keeps left")

    // Exercise 8
    assert(exercise8_product(Some(42), Some("hello")) == Some((42, "hello")))
    assert(exercise8_product(None, Some("hello")) == None)
    println("Exercise 8 passed: product creates tuple")

    println("\nAll Cats007_Applicative exercises passed!")
  }
}
