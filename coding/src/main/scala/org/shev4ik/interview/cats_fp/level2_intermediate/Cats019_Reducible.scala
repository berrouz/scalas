package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 019 - Reducible
 *
 * Reducible extends Foldable for non-empty structures.
 * It guarantees at least one element exists, so operations don't need a default/zero.
 */
object Cats019_Reducible {

  // Exercise 1: reduceLeft - reduce from the left without an initial value
  // TODO: Use Reducible[NonEmptyList].reduceLeft to concatenate strings.
  def exercise1_reduceLeft(): String = {
    val nel = NonEmptyList.of("a", "b", "c", "d")

    // Use reduceLeft with string concatenation
    ???
  }

  // Exercise 2: reduceRight - Eval-based lazy right reduce
  // TODO: Use reduceRight on a NonEmptyList. Returns Eval for stack safety.
  def exercise2_reduceRight(): String = {
    val nel = NonEmptyList.of("a", "b", "c")

    // Use Reducible[NonEmptyList].reduceRight
    // f: (A, Eval[A]) => Eval[A]
    ???
  }

  // Exercise 3: reduce - combine all elements using Semigroup (no Monoid needed!)
  // TODO: Use reduce to combine all elements. Unlike fold, no empty/zero is needed.
  def exercise3_reduce(): Int = {
    val nel = NonEmptyList.of(1, 2, 3, 4, 5)

    // Use .reduce on the NonEmptyList (uses Semigroup[Int])
    ???
  }

  // Exercise 4: reduceMap - map then reduce using Semigroup
  // TODO: Use reduceMap to convert each string to its length, then combine.
  def exercise4_reduceMap(): Int = {
    val nel = NonEmptyList.of("hello", "world", "cats")

    // Use reduceMap with _.length
    ???
  }

  // Exercise 5: reduceK - reduce using SemigroupK (for type constructors)
  // TODO: Use reduceK to combine NonEmptyList of Options using SemigroupK[Option].
  //       SemigroupK[Option] picks the first Some.
  def exercise5_reduceK(): Option[Int] = {
    val nel = NonEmptyList.of(Option.empty[Int], Some(2), Some(3))

    // Use Reducible[NonEmptyList].reduceK
    ???
  }

  // Exercise 6: NonEmptyList.of - create from varargs
  // TODO: Create a NonEmptyList using the of constructor.
  def exercise6_nelOf(): NonEmptyList[String] = {
    // Use NonEmptyList.of("scala", "cats", "fp")
    ???
  }

  // Exercise 7: NonEmptyList from head + tail
  // TODO: Create a NonEmptyList from a head element and a regular List tail.
  def exercise7_nelFromHeadTail(): NonEmptyList[Int] = {
    val head = 1
    val tail = List(2, 3, 4)

    // Use NonEmptyList(head, tail) or NonEmptyList.ofInitLast
    ???
  }

  // Exercise 8: toNel - convert a List to NonEmptyList safely
  // TODO: Convert a non-empty List to Option[NonEmptyList] using .toNel.
  //       Returns None for empty lists.
  def exercise8_toNel(): (Option[NonEmptyList[Int]], Option[NonEmptyList[Int]]) = {
    val nonEmpty = List(1, 2, 3)
    val empty = List.empty[Int]

    // Convert both to Option[NonEmptyList[Int]] using .toNel
    val result1: Option[NonEmptyList[Int]] = ???
    val result2: Option[NonEmptyList[Int]] = ???
    (result1, result2)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_reduceLeft()
    assert(r1 == "abcd", s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: reduceLeft => $r1")

    // Exercise 2
    val r2 = exercise2_reduceRight()
    assert(r2 == "abc", s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: reduceRight => $r2")

    // Exercise 3
    val r3 = exercise3_reduce()
    assert(r3 == 15, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: reduce => $r3")

    // Exercise 4
    val r4 = exercise4_reduceMap()
    assert(r4 == 14, s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: reduceMap => $r4")

    // Exercise 5
    val r5 = exercise5_reduceK()
    assert(r5 == Some(2), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: reduceK => $r5")

    // Exercise 6
    val r6 = exercise6_nelOf()
    assert(r6 == NonEmptyList.of("scala", "cats", "fp"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: NonEmptyList.of => $r6")

    // Exercise 7
    val r7 = exercise7_nelFromHeadTail()
    assert(r7 == NonEmptyList.of(1, 2, 3, 4), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: NonEmptyList from head+tail => $r7")

    // Exercise 8
    val (r8a, r8b) = exercise8_toNel()
    assert(r8a.isDefined, s"Exercise 8 failed: expected Some, got $r8a")
    assert(r8b.isEmpty, s"Exercise 8 failed: expected None, got $r8b")
    println(s"Exercise 8 passed: toNel => nonEmpty=$r8a, empty=$r8b")

    println("\nAll Cats019_Reducible exercises passed!")
  }
}
