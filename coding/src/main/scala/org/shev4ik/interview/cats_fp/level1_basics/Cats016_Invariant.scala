package org.shev4ik.interview.cats_fp.level1_basics

import cats._
import cats.implicits._

/**
 * Cats 016 - Invariant Functor
 *
 * Invariant[F[_]] provides `imap`, which requires both directions:
 *   imap(fa)(f: A => B)(g: B => A): F[B]
 *
 * This is useful when F[A] both produces AND consumes A (e.g., Codec, Semigroup, Monoid).
 *
 * Hierarchy:
 *   Functor      (covariant):      map(fa)(A => B): F[B]
 *   Contravariant:                  contramap(fa)(B => A): F[A]
 *   Invariant:                      imap(fa)(A => B)(B => A): F[B]
 *
 * Both Functor and Contravariant extend Invariant.
 */
object Cats016_Invariant {

  // A simple Codec that can encode and decode
  trait Codec[A] {
    def encode(a: A): String
    def decode(s: String): A
  }

  object Codec {
    def apply[A](implicit c: Codec[A]): Codec[A] = c
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Use imap on Semigroup to derive Semigroup[String] to Semigroup for a newtype.
  // TODO: Given Semigroup[Int] (addition), derive Semigroup for a case class Score(value: Int)
  // using Invariant[Semigroup].imap.
  // Hint: Invariant[Semigroup].imap(Semigroup[Int])(Score.apply)(_.value)
  // -------------------------------------------------------------------------
  case class Score(value: Int)

  implicit val scoreSemigroup: Semigroup[Score] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Use imap on Monoid to derive a Monoid for a newtype.
  // TODO: Given Monoid[String], derive Monoid[Name] using imap.
  // -------------------------------------------------------------------------
  case class Name(raw: String)

  implicit val nameMonoid: Monoid[Name] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create an Invariant instance for Codec.
  // TODO: Implement Invariant[Codec] using imap.
  // Given Codec[A], f: A => B, g: B => A, produce Codec[B].
  // -------------------------------------------------------------------------
  implicit val codecInvariant: Invariant[Codec] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use the Invariant[Codec] to derive Codec[Int] from Codec[String].
  // TODO: Given a Codec[String], derive Codec[Int] using imap.
  // -------------------------------------------------------------------------
  implicit val stringCodec: Codec[String] = new Codec[String] {
    def encode(a: String): String = a
    def decode(s: String): String = s
  }

  implicit val intCodec: Codec[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use imap on Monoid to create Monoid[(Int, Int)] -> Monoid[Point].
  // TODO: Map between (Int, Int) and Point using imap on Monoid[(Int, Int)].
  // -------------------------------------------------------------------------
  case class Point(x: Int, y: Int)

  implicit val pointMonoid: Monoid[Point] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Demonstrate that Functor is a special case of Invariant.
  // TODO: Use Invariant[Option].imap to map Option[Int] to Option[String].
  // Note: For Functor types, imap ignores the reverse function internally.
  // -------------------------------------------------------------------------
  def exercise6_functorAsInvariant(opt: Option[Int]): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use imap on Semigroup to work with a wrapper type.
  // TODO: Given Semigroup[Map[String, Int]], derive Semigroup[Inventory].
  // Inventory just wraps a Map[String, Int].
  // -------------------------------------------------------------------------
  case class Inventory(items: Map[String, Int])

  implicit val inventorySemigroup: Semigroup[Inventory] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Combine Invariant-derived instances.
  // TODO: Using the Score Semigroup from Exercise 1, combine a list of Scores
  // using combineAllOption.
  // -------------------------------------------------------------------------
  def exercise8_combineScores(scores: List[Score]): Option[Score] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert((Score(10) |+| Score(20)) == Score(30))
    println("Exercise 1 passed: imap on Semigroup for Score")

    // Exercise 2
    assert((Name("Hello") |+| Name(" World")) == Name("Hello World"))
    assert(Monoid[Name].empty == Name(""))
    println("Exercise 2 passed: imap on Monoid for Name")

    // Exercise 3 & 4
    assert(Codec[Int].encode(42) == "42")
    assert(Codec[Int].decode("42") == 42)
    println("Exercise 3 & 4 passed: Invariant[Codec] and derived Codec[Int]")

    // Exercise 5
    assert((Point(1, 2) |+| Point(3, 4)) == Point(4, 6))
    assert(Monoid[Point].empty == Point(0, 0))
    println("Exercise 5 passed: imap on Monoid for Point")

    // Exercise 6
    assert(exercise6_functorAsInvariant(Some(42)) == Some("42"))
    assert(exercise6_functorAsInvariant(None) == None)
    println("Exercise 6 passed: Functor as special case of Invariant")

    // Exercise 7
    val inv1 = Inventory(Map("apples" -> 5, "bananas" -> 3))
    val inv2 = Inventory(Map("bananas" -> 2, "oranges" -> 7))
    assert((inv1 |+| inv2) == Inventory(Map("apples" -> 5, "bananas" -> 5, "oranges" -> 7)))
    println("Exercise 7 passed: imap on Semigroup for Inventory")

    // Exercise 8
    assert(exercise8_combineScores(List(Score(10), Score(20), Score(30))) == Some(Score(60)))
    assert(exercise8_combineScores(List.empty[Score]) == None)
    println("Exercise 8 passed: combine list of Scores")

    println("\nAll Cats016_Invariant exercises passed!")
  }
}
