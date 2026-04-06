package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 001 - Eq Type Class
 *
 * Eq provides type-safe equality checking, unlike universal == which compiles
 * for any two types (even nonsensical comparisons like 1 == "hello").
 *
 * Key methods: eqv, neqv, === , =!=
 */
object Cats001_Eq {

  case class Person(name: String, age: Int)

  // -------------------------------------------------------------------------
  // Exercise 1: Use === (type-safe equality) to compare two integers.
  // TODO: Return true if a === b using Eq syntax, false otherwise.
  // Hint: cats.implicits._ provides === for standard types.
  // -------------------------------------------------------------------------
  def exercise1_typesSafeEquals(a: Int, b: Int): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use =!= (type-safe inequality) to compare two strings.
  // TODO: Return true if a =!= b, false otherwise.
  // -------------------------------------------------------------------------
  def exercise2_typesSafeNotEquals(a: String, b: String): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use Eq[Int].eqv to compare two integers.
  // TODO: Call Eq[Int].eqv(a, b) directly.
  // -------------------------------------------------------------------------
  def exercise3_eqvDirect(a: Int, b: Int): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use Eq[Int].neqv to check inequality.
  // TODO: Call Eq[Int].neqv(a, b) directly.
  // -------------------------------------------------------------------------
  def exercise4_neqvDirect(a: Int, b: Int): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Create an Eq instance for Person using Eq.instance.
  // TODO: Two persons are equal if both name and age match.
  // -------------------------------------------------------------------------
  implicit val personEq: Eq[Person] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Create an Eq instance using Eq.fromUniversalEquals.
  // TODO: This delegates to the universal == method but returns an Eq instance.
  // -------------------------------------------------------------------------
  def exercise6_fromUniversalEquals[A]: Eq[A] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use Eq for a case class with the implicit defined above.
  // TODO: Compare two Person values using ===.
  // -------------------------------------------------------------------------
  def exercise7_eqForCaseClass(p1: Person, p2: Person): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Use contramap on Eq to derive a new Eq instance.
  // TODO: Given Eq[Int], derive Eq[Person] that compares only by age.
  // Hint: Eq[Int].contramap[Person](_.age)
  // -------------------------------------------------------------------------
  def exercise8_contramapEq: Eq[Person] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_typesSafeEquals(42, 42) == true)
    assert(exercise1_typesSafeEquals(42, 43) == false)
    println("Exercise 1 passed: === works for Int")

    // Exercise 2
    assert(exercise2_typesSafeNotEquals("hello", "world") == true)
    assert(exercise2_typesSafeNotEquals("hello", "hello") == false)
    println("Exercise 2 passed: =!= works for String")

    // Exercise 3
    assert(exercise3_eqvDirect(10, 10) == true)
    assert(exercise3_eqvDirect(10, 20) == false)
    println("Exercise 3 passed: Eq[Int].eqv works")

    // Exercise 4
    assert(exercise4_neqvDirect(10, 20) == true)
    assert(exercise4_neqvDirect(10, 10) == false)
    println("Exercise 4 passed: Eq[Int].neqv works")

    // Exercise 5
    assert(Person("Alice", 30) === Person("Alice", 30))
    assert(Person("Alice", 30) =!= Person("Bob", 25))
    println("Exercise 5 passed: Eq.instance for Person works")

    // Exercise 6
    val eqStr = exercise6_fromUniversalEquals[String]
    assert(eqStr.eqv("a", "a") == true)
    assert(eqStr.eqv("a", "b") == false)
    println("Exercise 6 passed: Eq.fromUniversalEquals works")

    // Exercise 7
    assert(exercise7_eqForCaseClass(Person("Alice", 30), Person("Alice", 30)) == true)
    assert(exercise7_eqForCaseClass(Person("Alice", 30), Person("Bob", 25)) == false)
    println("Exercise 7 passed: Eq for case class with ===")

    // Exercise 8
    val ageEq = exercise8_contramapEq
    assert(ageEq.eqv(Person("Alice", 30), Person("Bob", 30)) == true)
    assert(ageEq.eqv(Person("Alice", 30), Person("Alice", 25)) == false)
    println("Exercise 8 passed: contramap on Eq works")

    println("\nAll Cats001_Eq exercises passed!")
  }
}
