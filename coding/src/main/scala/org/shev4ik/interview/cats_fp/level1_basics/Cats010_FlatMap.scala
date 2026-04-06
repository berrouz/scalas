package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 010 - FlatMap Type Class
 *
 * FlatMap extends Apply with `flatMap`, allowing sequential dependent
 * computations. It is the parent of Monad (Monad = FlatMap + Applicative).
 *
 * Key methods: flatMap, flatten, mproduct, >>= , ifM, foreverM, iterateForeverM
 */
object Cats010_FlatMap {

  // -------------------------------------------------------------------------
  // Exercise 1: Use flatMap to chain Option computations.
  // TODO: Parse string to Int, then return Some if positive, None otherwise.
  // -------------------------------------------------------------------------
  def exercise1_flatMap(s: String): Option[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use flatten to unwrap nested Option[Option[A]].
  // TODO: Flatten the nested option using FlatMap[Option].flatten.
  // -------------------------------------------------------------------------
  def exercise2_flatten(nested: Option[Option[String]]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use mproduct to pair a value with the result of a function.
  // TODO: Given an Option[Int], use mproduct to pair it with f's result.
  // Hint: opt.mproduct(f) gives Option[(Int, B)] where f: Int => Option[B].
  // -------------------------------------------------------------------------
  def exercise3_mproduct(opt: Option[Int], f: Int => Option[String]): Option[(Int, String)] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use >>= (alias for flatMap) to chain computations.
  // TODO: Use opt >>= f.
  // -------------------------------------------------------------------------
  def exercise4_bindOperator(opt: Option[Int], f: Int => Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use >> (equivalent to *> but from FlatMap) to discard left result.
  // TODO: Return opt >> next (evaluates opt, discards its value, returns next).
  // -------------------------------------------------------------------------
  def exercise5_sequenceDiscard(opt: Option[Int], next: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Use ifM for conditional branching in monadic context.
  // TODO: If the option contains true return ifTrue, else return ifFalse.
  // Hint: cond.ifM(ifTrue, ifFalse)
  // -------------------------------------------------------------------------
  def exercise6_ifM(cond: Option[Boolean], ifTrue: Option[String], ifFalse: Option[String]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use flatMap with List for dependent list generation.
  // TODO: For each element n in the list, generate List(n, n*10).
  // Hint: list.flatMap(n => List(n, n * 10))
  // -------------------------------------------------------------------------
  def exercise7_flatMapList(list: List[Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use flatMap to implement a lookup chain.
  // TODO: Look up key1 in map1, then use the result to look up in map2.
  // -------------------------------------------------------------------------
  def exercise8_chainedFlatMap(
    map1: Map[String, String],
    map2: Map[String, Int],
    key1: String
  ): Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_flatMap("42") == Some(42))
    assert(exercise1_flatMap("-5") == None)
    assert(exercise1_flatMap("abc") == None)
    println("Exercise 1 passed: flatMap chain")

    // Exercise 2
    assert(exercise2_flatten(Some(Some("hello"))) == Some("hello"))
    assert(exercise2_flatten(Some(None)) == None)
    assert(exercise2_flatten(None) == None)
    println("Exercise 2 passed: flatten nested Option")

    // Exercise 3
    val f3: Int => Option[String] = n => if (n > 0) Some(s"pos:$n") else None
    assert(exercise3_mproduct(Some(5), f3) == Some((5, "pos:5")))
    assert(exercise3_mproduct(Some(-1), f3) == None)
    println("Exercise 3 passed: mproduct")

    // Exercise 4
    val f4: Int => Option[String] = n => Some(n.toString)
    assert(exercise4_bindOperator(Some(42), f4) == Some("42"))
    assert(exercise4_bindOperator(None, f4) == None)
    println("Exercise 4 passed: >>= operator")

    // Exercise 5
    assert(exercise5_sequenceDiscard(Some(1), Some("hello")) == Some("hello"))
    assert(exercise5_sequenceDiscard(None, Some("hello")) == None)
    println("Exercise 5 passed: >> sequence and discard")

    // Exercise 6
    assert(exercise6_ifM(Some(true), Some("yes"), Some("no")) == Some("yes"))
    assert(exercise6_ifM(Some(false), Some("yes"), Some("no")) == Some("no"))
    assert(exercise6_ifM(None, Some("yes"), Some("no")) == None)
    println("Exercise 6 passed: ifM")

    // Exercise 7
    assert(exercise7_flatMapList(List(1, 2, 3)) == List(1, 10, 2, 20, 3, 30))
    println("Exercise 7 passed: flatMap on List")

    // Exercise 8
    val m1 = Map("user" -> "alice")
    val m2 = Map("alice" -> 30)
    assert(exercise8_chainedFlatMap(m1, m2, "user") == Some(30))
    assert(exercise8_chainedFlatMap(m1, m2, "missing") == None)
    println("Exercise 8 passed: chained flatMap lookups")

    println("\nAll Cats010_FlatMap exercises passed!")
  }
}
