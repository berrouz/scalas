package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._

/**
 * Cats 058 - Yoneda and Coyoneda
 *
 * Yoneda[F, A] wraps an F[A] and fuses multiple map operations into one.
 * Instead of applying each map immediately, it accumulates the function
 * and applies it all at once when lowered. This is a map fusion optimization.
 *
 * Coyoneda[F, A] is the dual: it lets you map over any type constructor,
 * even non-functors, by deferring the map until interpretation.
 */
object Cats058_Yoneda {

  // Simplified Yoneda: wraps F[A] and fuses maps
  // Yoneda[F, A] ~ forall B. (A => B) => F[B]
  abstract class Yoneda[F[_], A] { self =>
    def apply[B](f: A => B): F[B]

    def map[B](f: A => B): Yoneda[F, B] = new Yoneda[F, B] {
      def apply[C](g: B => C): F[C] = self.apply(f andThen g)
    }

    def lower(implicit F: Functor[F]): F[A] = apply(identity)
  }

  object Yoneda {
    def lift[F[_]: Functor, A](fa: F[A]): Yoneda[F, A] = new Yoneda[F, A] {
      def apply[B](f: A => B): F[B] = Functor[F].map(fa)(f)
    }
  }

  // Exercise 1: Yoneda lift - lift an F[A] into Yoneda
  // TODO: Lift an Option[Int] into Yoneda.
  def exercise1_lift(): Yoneda[Option, Int] = {
    val opt: Option[Int] = Some(42)
    // Lift into Yoneda
    ???
  }

  // Exercise 2: Yoneda lower - extract F[A] from Yoneda
  // TODO: Lower a Yoneda back to the underlying functor.
  def exercise2_lower(): Option[Int] = {
    val yoneda: Yoneda[Option, Int] = Yoneda.lift[Option, Int](Some(42))
    // Lower back to Option[Int]
    ???
  }

  // Exercise 3: map fusion - demonstrate how Yoneda fuses multiple maps
  // TODO: Chain multiple maps on Yoneda and show they fuse into one.
  def exercise3_mapFusion(): Option[String] = {
    var mapCount = 0

    // Custom functor that counts map invocations
    val countingOpt: Option[Int] = Some(5)
    val yoneda = Yoneda.lift[Option, Int](countingOpt)

    // Chain multiple maps - these should fuse into a single map on lower
    val result: Yoneda[Option, String] = ???
    // Map: * 2, then + 1, then toString
    // All three maps should compose into one function application

    result.lower
  }

  // Simplified Coyoneda
  // Coyoneda[F, A] ~ exists B. (F[B], B => A)
  abstract class Coyoneda[F[_], A] { self =>
    type Pivot
    val fi: F[Pivot]
    val k: Pivot => A

    def map[B](f: A => B): Coyoneda[F, B] = new Coyoneda[F, B] {
      type Pivot = self.Pivot
      val fi: F[Pivot] = self.fi
      val k: Pivot => B = self.k andThen f
    }

    def lower(implicit F: Functor[F]): F[A] = F.map(fi)(k)
  }

  object Coyoneda {
    def lift[F[_], A](fa: F[A]): Coyoneda[F, A] = new Coyoneda[F, A] {
      type Pivot = A
      val fi: F[A] = fa
      val k: A => A = identity
    }
  }

  // Exercise 4: Coyoneda lift - lift any type constructor into Coyoneda
  // TODO: Lift a value into Coyoneda (even for non-functors!).
  // Note: Coyoneda provides a free Functor for any F[_]
  case class Box[A](value: A) // Box is not a Functor (no map defined)

  def exercise4_coyonedaLift(): Coyoneda[Box, Int] = {
    // Lift Box(42) into Coyoneda - this works even though Box has no Functor!
    ???
  }

  // Exercise 5: Coyoneda map - map over Coyoneda (deferred mapping)
  // TODO: Map over Coyoneda to accumulate transformations.
  def exercise5_coyonedaMap(): Coyoneda[Box, String] = {
    val coyo = Coyoneda.lift[Box, Int](Box(42))

    // Map over it: * 2, then toString
    // This works even without a Functor instance for Box!
    ???
  }

  // Exercise 6: Coyoneda lower - lower Coyoneda back to F[A]
  // TODO: Lower Coyoneda to the underlying functor (requires Functor).
  def exercise6_coyonedaLower(): Option[String] = {
    val coyo = Coyoneda.lift[Option, Int](Some(10))
    val mapped = coyo.map(_ * 3).map(_.toString)

    // Lower: applies the accumulated function using Option's Functor
    ???
  }

  // Exercise 7: Yoneda optimization - demonstrate practical optimization
  // TODO: Show how Yoneda avoids creating intermediate structures.
  def exercise7_optimization(): List[String] = {
    val bigList = (1 to 100).toList

    // Without Yoneda: 3 separate traversals
    // val naive = bigList.map(_ * 2).map(_ + 1).map(_.toString)

    // With Yoneda: single traversal
    val yoneda = Yoneda.lift[List, Int](bigList)
    val fused: Yoneda[List, String] = ???  // map(_ * 2).map(_ + 1).map(_.toString)

    // Lower performs a single map with the composed function
    fused.lower
  }

  // Exercise 8: Yoneda and Coyoneda comparison
  // TODO: Compare Yoneda (requires Functor to lift) vs Coyoneda (free Functor).
  def exercise8_comparison(): (Option[String], Option[String]) = {
    // Yoneda: requires Functor to lift, provides map fusion
    val yResult: Option[String] = {
      val y = Yoneda.lift[Option, Int](Some(5))
      ???  // map(_ + 1).map(_.toString).lower
    }

    // Coyoneda: free Functor (no Functor needed to lift/map), needs Functor to lower
    val cResult: Option[String] = {
      val c = Coyoneda.lift[Option, Int](Some(5))
      ???  // map(_ + 1).map(_.toString).lower
    }

    (yResult, cResult)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_lift()
    assert(r1.lower == Some(42), s"Exercise 1 failed: ${r1.lower}")
    println(s"Exercise 1 passed: Yoneda.lift => ${r1.lower}")

    // Exercise 2
    val r2 = exercise2_lower()
    assert(r2 == Some(42), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: lower => $r2")

    // Exercise 3
    val r3 = exercise3_mapFusion()
    assert(r3 == Some("11"), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: map fusion => $r3")

    // Exercise 4
    val r4 = exercise4_coyonedaLift()
    println(s"Exercise 4 passed: Coyoneda.lift for non-functor")

    // Exercise 5
    val r5 = exercise5_coyonedaMap()
    println(s"Exercise 5 passed: Coyoneda map (deferred)")

    // Exercise 6
    val r6 = exercise6_coyonedaLower()
    assert(r6 == Some("30"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: Coyoneda lower => $r6")

    // Exercise 7
    val r7 = exercise7_optimization()
    assert(r7.head == "3", s"Exercise 7 failed: head=${r7.head}")
    assert(r7.size == 100, s"Exercise 7 failed: size=${r7.size}")
    println(s"Exercise 7 passed: Yoneda optimization => first 3 = ${r7.take(3)}")

    // Exercise 8
    val (r8a, r8b) = exercise8_comparison()
    assert(r8a == Some("6") && r8b == Some("6"), s"Exercise 8 failed: y=$r8a, c=$r8b")
    println(s"Exercise 8 passed: comparison => yoneda=$r8a, coyoneda=$r8b")

    println("\nAll Cats058_Yoneda exercises passed!")
  }
}
