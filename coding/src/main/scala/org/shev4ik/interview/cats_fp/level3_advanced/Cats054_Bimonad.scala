package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.data.NonEmptyList

/**
 * Cats 054 - Bimonad (Comonad + Monad)
 *
 * A Bimonad is both a Comonad and a Monad simultaneously.
 * Comonad provides: extract (dual of pure) and coflatMap (dual of flatMap).
 * NonEmptyList and Id are examples of bimonads in Cats.
 */
object Cats054_Bimonad {

  // Exercise 1: Comonad extract - extract the "focus" value from a comonadic structure
  // TODO: Use Comonad[NonEmptyList].extract to get the head element.
  def exercise1_extract(): Int = {
    val nel = NonEmptyList.of(1, 2, 3, 4, 5)
    // Extract the focused value (head) using Comonad
    ???
  }

  // Exercise 2: pure (Monad) + extract (Comonad) - show duality
  // TODO: Demonstrate that extract is the dual of pure.
  def exercise2_pureAndExtract(): (NonEmptyList[Int], Int) = {
    // pure: A => F[A] (wrap a value)
    val wrapped: NonEmptyList[Int] = ???  // Applicative[NonEmptyList].pure(42)

    // extract: F[A] => A (unwrap a value)
    val extracted: Int = ???  // Comonad[NonEmptyList].extract(wrapped)

    (wrapped, extracted)
  }

  // Exercise 3: coflatMap - the dual of flatMap
  // TODO: Use coflatMap to transform a NonEmptyList.
  def exercise3_coflatMap(): NonEmptyList[Int] = {
    val nel = NonEmptyList.of(1, 2, 3, 4, 5)

    // coflatMap takes F[A] => B and produces F[B]
    // For NonEmptyList, it creates a "sliding window" of tails
    // Apply a function that sums all elements of the sub-list (tail including head)
    ???
  }

  // Exercise 4: flatMap (Monad) + coflatMap (Comonad) - show both on NonEmptyList
  // TODO: Demonstrate both flatMap and coflatMap on the same structure.
  def exercise4_flatMapAndCoflatMap(): (NonEmptyList[Int], NonEmptyList[Int]) = {
    val nel = NonEmptyList.of(1, 2, 3)

    // flatMap: each element produces a list, results are concatenated
    val flatMapped: NonEmptyList[Int] = ???  // n => NonEmptyList.of(n, n * 10)

    // coflatMap: each position gets the "view from here"
    val coflatMapped: NonEmptyList[Int] = ???  // nel => nel.head (first element of sub-list)

    (flatMapped, coflatMapped)
  }

  // Exercise 5: Bimonad laws - demonstrate key laws
  // TODO: Verify key bimonad laws.
  def exercise5_bimonadLaws(): (Boolean, Boolean) = {
    val nel = NonEmptyList.of(1, 2, 3)
    val f: Int => NonEmptyList[Int] = n => NonEmptyList.of(n, n + 1)

    // Law 1: extract(pure(a)) == a
    val a = 42
    val law1: Boolean = ???  // Comonad[NonEmptyList].extract(Applicative[NonEmptyList].pure(a)) == a

    // Law 2: extract(nel) == nel.head (extract returns the focus)
    val law2: Boolean = ???  // Comonad[NonEmptyList].extract(nel) == nel.head

    (law1, law2)
  }

  // Exercise 6: Comonad duplicate - create nested structure (dual of join/flatten)
  // TODO: Use coflatten/duplicate to create F[F[A]] from F[A].
  def exercise6_duplicate(): NonEmptyList[NonEmptyList[Int]] = {
    val nel = NonEmptyList.of(1, 2, 3)
    // coflatten (or coflatMap(identity)) creates all suffixes
    // NonEmptyList(NEL(1,2,3), NEL(2,3), NEL(3))
    ???
  }

  // Exercise 7: Bimonad use cases - practical applications
  // TODO: Show a practical use of comonadic operations.
  def exercise7_useCases(): NonEmptyList[Double] = {
    val data = NonEmptyList.of(10.0, 20.0, 30.0, 40.0, 50.0)

    // Use coflatMap to compute a "moving average" (average of current position to end)
    // For position 0: avg(10,20,30,40,50) = 30.0
    // For position 1: avg(20,30,40,50) = 35.0
    // etc.
    ???
  }

  // Exercise 8: Id as Bimonad - demonstrate Id is trivially a bimonad
  // TODO: Show that Id[A] is both a Monad and a Comonad (trivially).
  def exercise8_idBimonad(): (Int, Int, Int) = {
    val idValue: Id[Int] = 42

    // extract: Id[A] => A (identity)
    val extracted: Int = ???  // Comonad[Id].extract(idValue)

    // pure: A => Id[A] (identity)
    val wrapped: Id[Int] = ???  // Monad[Id].pure(42)

    // coflatMap: (Id[A] => B) => Id[B]
    val coflatMapped: Id[Int] = ???  // Comonad[Id].coflatMap(idValue)(_ + 1)

    (extracted, wrapped, coflatMapped)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_extract()
    assert(r1 == 1, s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: extract => $r1")

    // Exercise 2
    val (r2a, r2b) = exercise2_pureAndExtract()
    assert(r2a == NonEmptyList.of(42) && r2b == 42, s"Exercise 2 failed: wrapped=$r2a, extracted=$r2b")
    println(s"Exercise 2 passed: pure=$r2a, extract=$r2b")

    // Exercise 3
    val r3 = exercise3_coflatMap()
    assert(r3.head == 15, s"Exercise 3 failed: head=${r3.head} (expected 15 = sum of 1+2+3+4+5)")
    println(s"Exercise 3 passed: coflatMap => $r3")

    // Exercise 4
    val (r4a, r4b) = exercise4_flatMapAndCoflatMap()
    assert(r4a == NonEmptyList.of(1, 10, 2, 20, 3, 30), s"Exercise 4 flatMap failed: $r4a")
    assert(r4b == NonEmptyList.of(1, 2, 3), s"Exercise 4 coflatMap failed: $r4b")
    println(s"Exercise 4 passed: flatMap=$r4a, coflatMap=$r4b")

    // Exercise 5
    val (r5a, r5b) = exercise5_bimonadLaws()
    assert(r5a && r5b, s"Exercise 5 failed: law1=$r5a, law2=$r5b")
    println(s"Exercise 5 passed: bimonad laws => law1=$r5a, law2=$r5b")

    // Exercise 6
    val r6 = exercise6_duplicate()
    assert(r6.head == NonEmptyList.of(1, 2, 3), s"Exercise 6 failed: ${r6.head}")
    assert(r6.size == 3, s"Exercise 6 failed: size=${r6.size}")
    println(s"Exercise 6 passed: duplicate => $r6")

    // Exercise 7
    val r7 = exercise7_useCases()
    assert(r7.head == 30.0, s"Exercise 7 failed: head=${r7.head}")
    println(s"Exercise 7 passed: moving average => $r7")

    // Exercise 8
    val (r8a, r8b, r8c) = exercise8_idBimonad()
    assert(r8a == 42 && r8b == 42 && r8c == 43, s"Exercise 8 failed: extract=$r8a, pure=$r8b, coflatMap=$r8c")
    println(s"Exercise 8 passed: Id bimonad => extract=$r8a, pure=$r8b, coflatMap=$r8c")

    println("\nAll Cats054_Bimonad exercises passed!")
  }
}
