package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.free.Cofree

/**
 * Cats 059 - Cofree
 *
 * Cofree[F, A] is the dual of Free. While Free builds up computations,
 * Cofree represents a comonadic structure: a head value paired with a
 * "tail" wrapped in F. It's useful for annotated trees, streams, etc.
 *
 * Cofree[F, A] = (A, F[Cofree[F, A]])
 */
object Cats059_Cofree {

  // Exercise 1: Cofree creation - create a Cofree value with head and tail
  // TODO: Create a Cofree[Option, Int] representing a finite stream.
  def exercise1_create(): Cofree[Option, Int] = {
    // Create: 1 -> Some(2 -> Some(3 -> None))
    // Cofree(1, Some(Cofree(2, Some(Cofree(3, None)))))
    ???
  }

  // Exercise 2: head - extract the head value from Cofree
  // TODO: Use .head to get the focus value.
  def exercise2_head(): Int = {
    val cofree = Cofree[Option, Int](42, Eval.now(Some(Cofree[Option, Int](43, Eval.now(None)))))
    // Extract the head
    ???
  }

  // Exercise 3: tail - extract the tail structure from Cofree
  // TODO: Use .tail to get the F[Cofree[F, A]] part.
  def exercise3_tail(): Option[Cofree[Option, Int]] = {
    val cofree = Cofree[Option, Int](1, Eval.now(Some(Cofree[Option, Int](2, Eval.now(None)))))
    // Extract the tail
    ???
  }

  // Exercise 4: Cofree from seed - unfold a Cofree from a seed value
  // TODO: Use Cofree to build a structure from a seed via unfolding.
  def exercise4_unfold(): Cofree[Option, Int] = {
    // Unfold: start from 1, produce next = n + 1, stop at 5
    // Result: Cofree stream 1 -> 2 -> 3 -> 4 -> 5
    def unfold(seed: Int): Cofree[Option, Int] = {
      Cofree[Option, Int](seed, Eval.now(
        if (seed >= 5) None
        else Some(unfold(seed + 1))
      ))
    }

    ???
  }

  // Exercise 5: Cofree as stream - use Cofree[Option, A] as a non-empty finite stream
  // TODO: Convert a list to a Cofree stream and back.
  def exercise5_stream(): List[Int] = {
    // Create a Cofree stream from a non-empty list
    def fromList(head: Int, tail: List[Int]): Cofree[Option, Int] = tail match {
      case Nil => Cofree[Option, Int](head, Eval.now(None))
      case h :: t => Cofree[Option, Int](head, Eval.now(Some(fromList(h, t))))
    }

    // Convert Cofree stream back to List
    def toList(cofree: Cofree[Option, Int]): List[Int] = {
      cofree.head :: cofree.tail.value.map(toList).getOrElse(Nil)
    }

    val stream = fromList(1, List(2, 3, 4, 5))
    // Convert back to list
    ???
  }

  // Exercise 6: Cofree as annotated tree - use Cofree[List, A] as a labeled tree
  // TODO: Build an annotated tree using Cofree with List functor.
  def exercise6_annotatedTree(): (String, Int) = {
    // Tree:      "root"
    //           /      \
    //       "left"   "right"
    val tree: Cofree[List, String] = Cofree[List, String]("root", Eval.now(List(
      Cofree[List, String]("left", Eval.now(Nil)),
      Cofree[List, String]("right", Eval.now(Nil))
    )))

    // Extract the root label and the number of children
    val rootLabel: String = ???
    val childCount: Int = ???

    (rootLabel, childCount)
  }

  // Exercise 7: Cofree map - map over the annotations
  // TODO: Use Functor to map over Cofree annotations.
  def exercise7_map(): Cofree[Option, String] = {
    val cofree = Cofree[Option, Int](1, Eval.now(Some(
      Cofree[Option, Int](2, Eval.now(Some(
        Cofree[Option, Int](3, Eval.now(None))
      )))
    )))

    // Map each annotation to "val_<n>"
    ???
  }

  // Exercise 8: Cofree comonad - use comonadic operations on Cofree
  // TODO: Demonstrate extract and coflatMap on Cofree.
  def exercise8_comonad(): (Int, Cofree[Option, Int]) = {
    val cofree = Cofree[Option, Int](10, Eval.now(Some(
      Cofree[Option, Int](20, Eval.now(Some(
        Cofree[Option, Int](30, Eval.now(None))
      )))
    )))

    // extract: get the head (focus)
    val extracted: Int = ???

    // coflatMap: at each position, compute the sum of remaining elements
    def sumAll(c: Cofree[Option, Int]): Int = {
      c.head + c.tail.value.map(sumAll).getOrElse(0)
    }

    val annotated: Cofree[Option, Int] = ???  // coflatMap with sumAll

    (extracted, annotated)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_create()
    assert(r1.head == 1, s"Exercise 1 failed: head=${r1.head}")
    println(s"Exercise 1 passed: Cofree created => head=${r1.head}")

    // Exercise 2
    val r2 = exercise2_head()
    assert(r2 == 42, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: head => $r2")

    // Exercise 3
    val r3 = exercise3_tail()
    assert(r3.isDefined, s"Exercise 3 failed: $r3")
    assert(r3.get.head == 2, s"Exercise 3 failed: next head=${r3.get.head}")
    println(s"Exercise 3 passed: tail => defined, next head=${r3.get.head}")

    // Exercise 4
    val r4 = exercise4_unfold()
    assert(r4.head == 1, s"Exercise 4 failed: head=${r4.head}")
    println(s"Exercise 4 passed: unfold => head=${r4.head}")

    // Exercise 5
    val r5 = exercise5_stream()
    assert(r5 == List(1, 2, 3, 4, 5), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: stream => $r5")

    // Exercise 6
    val (r6a, r6b) = exercise6_annotatedTree()
    assert(r6a == "root", s"Exercise 6 failed: label=$r6a")
    assert(r6b == 2, s"Exercise 6 failed: children=$r6b")
    println(s"Exercise 6 passed: annotated tree => label=$r6a, children=$r6b")

    // Exercise 7
    val r7 = exercise7_map()
    assert(r7.head == "val_1", s"Exercise 7 failed: head=${r7.head}")
    println(s"Exercise 7 passed: map => head=${r7.head}")

    // Exercise 8
    val (r8a, r8b) = exercise8_comonad()
    assert(r8a == 10, s"Exercise 8 failed: extract=$r8a")
    assert(r8b.head == 60, s"Exercise 8 failed: coflatMap head=${r8b.head} (expected 60=10+20+30)")
    println(s"Exercise 8 passed: comonad => extract=$r8a, coflatMap head=${r8b.head}")

    println("\nAll Cats059_Cofree exercises passed!")
  }
}
