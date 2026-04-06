package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 008 - Monad Type Class
 *
 * Monad extends Applicative with `flatMap`, enabling sequential, dependent
 * computations. Where Applicative runs independent effects, Monad lets the
 * result of one computation determine the next.
 *
 * Key methods: pure, flatMap, flatten, ifM, iterateWhileM, whileM_
 */
object Cats008_Monad {

  // -------------------------------------------------------------------------
  // Exercise 1: Use Monad[Option].pure to lift a value into Option.
  // TODO: Return the value in Option context.
  // -------------------------------------------------------------------------
  def exercise1_pure(value: Int): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use flatMap to chain dependent Option computations.
  // TODO: Parse a string to Int (returning None on failure), then check if even.
  // Return Some(n) if parseable and even, None otherwise.
  // -------------------------------------------------------------------------
  def exercise2_flatMap(s: String): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use flatten to collapse nested Option[Option[A]] to Option[A].
  // TODO: Return Monad[Option].flatten(nested).
  // -------------------------------------------------------------------------
  def exercise3_flatten(nested: Option[Option[Int]]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use ifM to branch based on a Boolean in context.
  // TODO: If condOpt contains true, return Some("yes"), else Some("no").
  // If condOpt is None, return None.
  // Hint: condOpt.ifM(Some("yes"), Some("no"))
  // -------------------------------------------------------------------------
  def exercise4_ifM(condOpt: Option[Boolean]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use flatMap to implement a safe division (returns None if divisor is 0).
  // TODO: Chain two computations: first check divisor, then divide.
  // -------------------------------------------------------------------------
  def exercise5_safeDivision(a: Option[Int], b: Option[Int]): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use iterateWhileM to iterate until a condition is false.
  // TODO: Starting from `start`, keep adding 1 while the result is < limit.
  // Hint: start.iterateWhileM(n => Option(n + 1))(_ < limit)
  // -------------------------------------------------------------------------
  def exercise6_iterateWhileM(start: Int, limit: Int): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use for-comprehension (syntactic sugar for flatMap/map).
  // TODO: Given three Options, combine them: "name is age from city".
  // Return None if any input is None.
  // -------------------------------------------------------------------------
  def exercise7_forComprehension(name: Option[String], age: Option[Int], city: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use flatMap to implement a chain of lookups.
  // TODO: Given a Map[String, String] representing key -> nextKey,
  // follow the chain from startKey for `steps` steps.
  // Return None if any lookup fails.
  // -------------------------------------------------------------------------
  def exercise8_chainedLookup(map: Map[String, String], startKey: String, steps: Int): Option[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_pure(42) == Some(42))
    println("Exercise 1 passed: Monad[Option].pure")

    // Exercise 2
    assert(exercise2_flatMap("42") == Some(42))
    assert(exercise2_flatMap("41") == None) // odd
    assert(exercise2_flatMap("abc") == None) // not parseable
    println("Exercise 2 passed: flatMap chain")

    // Exercise 3
    assert(exercise3_flatten(Some(Some(42))) == Some(42))
    assert(exercise3_flatten(Some(None)) == None)
    assert(exercise3_flatten(None) == None)
    println("Exercise 3 passed: flatten nested Options")

    // Exercise 4
    assert(exercise4_ifM(Some(true)) == Some("yes"))
    assert(exercise4_ifM(Some(false)) == Some("no"))
    assert(exercise4_ifM(None) == None)
    println("Exercise 4 passed: ifM branching")

    // Exercise 5
    assert(exercise5_safeDivision(Some(10), Some(2)) == Some(5))
    assert(exercise5_safeDivision(Some(10), Some(0)) == None)
    assert(exercise5_safeDivision(None, Some(2)) == None)
    println("Exercise 5 passed: safe division with flatMap")

    // Exercise 6
    assert(exercise6_iterateWhileM(0, 10) == Some(10))
    assert(exercise6_iterateWhileM(5, 5) == Some(5))
    println("Exercise 6 passed: iterateWhileM")

    // Exercise 7
    assert(exercise7_forComprehension(Some("Alice"), Some(30), Some("NYC")) == Some("Alice is 30 from NYC"))
    assert(exercise7_forComprehension(None, Some(30), Some("NYC")) == None)
    println("Exercise 7 passed: for-comprehension")

    // Exercise 8
    val chain = Map("a" -> "b", "b" -> "c", "c" -> "d")
    assert(exercise8_chainedLookup(chain, "a", 0) == Some("a"))
    assert(exercise8_chainedLookup(chain, "a", 2) == Some("c"))
    assert(exercise8_chainedLookup(chain, "a", 5) == None)
    println("Exercise 8 passed: chained lookup with flatMap")

    println("\nAll Cats008_Monad exercises passed!")
  }
}
