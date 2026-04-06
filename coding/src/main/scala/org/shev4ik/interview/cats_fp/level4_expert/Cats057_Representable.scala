package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._

/**
 * Cats 057 - Representable Functor
 *
 * A Representable functor F is isomorphic to the function type Rep => A
 * for some type Rep. It provides tabulate (Rep => A) => F[A] and
 * index F[A] => Rep => A. This means F[A] can be viewed as a lookup table.
 */
object Cats057_Representable {

  // Exercise 1: Representable concept - model a representable functor
  // TODO: Implement a simple representable functor for a pair (indexed by Boolean).
  case class Pair[A](first: A, second: A)

  // Pair is representable with Rep = Boolean
  // tabulate: (Boolean => A) => Pair[A]
  // index: Pair[A] => Boolean => A
  trait RepresentablePair {
    type Rep = Boolean

    def tabulate[A](f: Boolean => A): Pair[A]
    def index[A](pair: Pair[A])(rep: Boolean): A
  }

  def exercise1_representable(): RepresentablePair = {
    // Implement tabulate and index for Pair
    // false => first, true => second
    ???
  }

  // Exercise 2: tabulate - construct a functor value from a function
  // TODO: Use tabulate to create a Pair from a function.
  def exercise2_tabulate(): Pair[String] = {
    val repr = exercise1_representable()
    // tabulate: false => "hello", true => "world"
    ???
  }

  // Exercise 3: index - extract a value at a given position
  // TODO: Use index to look up values in a Pair.
  def exercise3_index(): (String, String) = {
    val repr = exercise1_representable()
    val pair = Pair("hello", "world")

    // Index: get first (false) and second (true)
    val first: String = ???
    val second: String = ???
    (first, second)
  }

  // Exercise 4: Rep type - demonstrate different Rep types
  // TODO: Create a representable functor for a triple (indexed by 0, 1, 2).
  case class Triple[A](a: A, b: A, c: A)

  trait RepresentableTriple {
    type Rep = Int // 0, 1, or 2

    def tabulate[A](f: Int => A): Triple[A]
    def index[A](triple: Triple[A])(rep: Int): A
  }

  def exercise4_repType(): RepresentableTriple = {
    // Implement tabulate and index for Triple
    // 0 => a, 1 => b, 2 => c
    ???
  }

  // Exercise 5: Representable for functions - Function1[R, A] is representable with Rep = R
  // TODO: Show that A => B is representable where Rep = A.
  def exercise5_functionRepresentable(): (Int => String, String) = {
    // For Function1[Int, A]:
    // tabulate: (Int => A) => (Int => A)  -- identity!
    // index: (Int => A) => Int => A       -- also identity!

    val f: Int => String = n => s"value_$n"

    // tabulate is just the function itself
    val tabulated: Int => String = ???  // identity

    // index is just function application
    val indexed: String = ???  // tabulated(42)

    (tabulated, indexed)
  }

  // Exercise 6: distributeRepresentable - distribute a functor through Representable
  // TODO: Demonstrate the distribute operation.
  def exercise6_distribute(): Pair[List[Int]] = {
    val repr = exercise1_representable()

    // Given a List[Pair[Int]], distribute to Pair[List[Int]]
    val pairs: List[Pair[Int]] = List(Pair(1, 2), Pair(3, 4), Pair(5, 6))

    // distribute: collect all firsts and all seconds
    ???
  }

  // Exercise 7: Representable and memoization - use Representable for memoization
  // TODO: Show how Representable enables memoization for finite domains.
  def exercise7_memoization(): (String, String, Int) = {
    val repr = exercise1_representable()
    var computeCount = 0

    // Create an expensive function
    val expensive: Boolean => String = { b =>
      computeCount += 1
      if (b) "true-result" else "false-result"
    }

    // Memoize by tabulating (evaluates the function once for each Rep value)
    val memoized: Pair[String] = ???

    // Access memoized values (no recomputation)
    val r1 = repr.index(memoized)(false)
    val r2 = repr.index(memoized)(true)

    // computeCount should be exactly 2 (once per boolean value)
    (r1, r2, computeCount)
  }

  // Exercise 8: Representable laws - verify the isomorphism laws
  // TODO: Verify tabulate . index = id and index . tabulate = id.
  def exercise8_laws(): (Boolean, Boolean) = {
    val repr = exercise1_representable()

    // Law 1: tabulate(index(fa)) == fa (round-trip through function)
    val pair = Pair(10, 20)
    val law1: Boolean = ???  // repr.tabulate(repr.index(pair)) == pair

    // Law 2: index(tabulate(f))(rep) == f(rep) (round-trip through functor)
    val f: Boolean => Int = if (_) 99 else 0
    val law2: Boolean = ???  // repr.index(repr.tabulate(f))(true) == f(true) && for false

    (law1, law2)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_representable()
    val testPair = r1.tabulate(b => if (b) "yes" else "no")
    assert(testPair == Pair("no", "yes"), s"Exercise 1 failed: $testPair")
    println(s"Exercise 1 passed: Representable Pair => $testPair")

    // Exercise 2
    val r2 = exercise2_tabulate()
    assert(r2 == Pair("hello", "world"), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: tabulate => $r2")

    // Exercise 3
    val (r3a, r3b) = exercise3_index()
    assert(r3a == "hello" && r3b == "world", s"Exercise 3 failed: first=$r3a, second=$r3b")
    println(s"Exercise 3 passed: index => first=$r3a, second=$r3b")

    // Exercise 4
    val r4 = exercise4_repType()
    val triple = r4.tabulate(i => s"val_$i")
    assert(triple == Triple("val_0", "val_1", "val_2"), s"Exercise 4 failed: $triple")
    println(s"Exercise 4 passed: Triple Rep => $triple")

    // Exercise 5
    val (r5f, r5v) = exercise5_functionRepresentable()
    assert(r5v == "value_42", s"Exercise 5 failed: $r5v")
    println(s"Exercise 5 passed: function representable => $r5v")

    // Exercise 6
    val r6 = exercise6_distribute()
    assert(r6 == Pair(List(1, 3, 5), List(2, 4, 6)), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: distribute => $r6")

    // Exercise 7
    val (r7a, r7b, r7c) = exercise7_memoization()
    assert(r7a == "false-result" && r7b == "true-result", s"Exercise 7 failed: $r7a, $r7b")
    assert(r7c == 2, s"Exercise 7 failed: computeCount=$r7c")
    println(s"Exercise 7 passed: memoization => $r7a, $r7b, computeCount=$r7c")

    // Exercise 8
    val (r8a, r8b) = exercise8_laws()
    assert(r8a && r8b, s"Exercise 8 failed: law1=$r8a, law2=$r8b")
    println(s"Exercise 8 passed: laws => law1=$r8a, law2=$r8b")

    println("\nAll Cats057_Representable exercises passed!")
  }
}
