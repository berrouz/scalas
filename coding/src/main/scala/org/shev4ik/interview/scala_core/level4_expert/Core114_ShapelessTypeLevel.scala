package org.shev4ik.interview.scala_core.level4_expert

object Core114_ShapelessTypeLevel {

  // Exercise 1: Nat (Peano numbers at type level)
  // TODO: Define type-level natural numbers using Peano encoding
  sealed trait Nat
  class _0 extends Nat
  class Succ[N <: Nat] extends Nat

  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]
  type _5 = Succ[_4]

  // Exercise 2: ToInt conversion
  // TODO: Define a type class to convert Nat to runtime Int
  trait ToInt[N <: Nat] {
    def value: Int
  }

  implicit val zeroToInt: ToInt[_0] = ???
  implicit def succToInt[N <: Nat](implicit prev: ToInt[N]): ToInt[Succ[N]] = ???

  def toInt[N <: Nat](implicit ti: ToInt[N]): Int = ???

  // Exercise 3: Type-level addition
  // TODO: Implement type-level addition
  trait Sum[A <: Nat, B <: Nat] {
    type Out <: Nat
  }

  object Sum {
    type Aux[A <: Nat, B <: Nat, C <: Nat] = Sum[A, B] { type Out = C }

    // Base: 0 + B = B
    implicit def zeroSum[B <: Nat]: Sum.Aux[_0, B, B] = ???

    // Inductive: Succ[A] + B = Succ[A + B]
    implicit def succSum[A <: Nat, B <: Nat, C <: Nat](
      implicit s: Sum.Aux[A, B, C]
    ): Sum.Aux[Succ[A], B, Succ[C]] = ???
  }

  // TODO: Write a method that proves addition at the type level and returns the runtime result
  def add[A <: Nat, B <: Nat, C <: Nat](implicit s: Sum.Aux[A, B, C], ti: ToInt[C]): Int = ???

  // Exercise 4: Type-level comparison
  // TODO: Implement type-level less-than
  trait LessThan[A <: Nat, B <: Nat]

  object LessThan {
    // 0 < Succ[B] for any B
    implicit def zeroLt[B <: Nat]: LessThan[_0, Succ[B]] = new LessThan[_0, Succ[B]] {}

    // Succ[A] < Succ[B] if A < B
    implicit def succLt[A <: Nat, B <: Nat](
      implicit lt: LessThan[A, B]
    ): LessThan[Succ[A], Succ[B]] = new LessThan[Succ[A], Succ[B]] {}
  }

  // TODO: Write a method that checks at compile time that A < B
  def assertLessThan[A <: Nat, B <: Nat](implicit lt: LessThan[A, B]): Boolean = ???

  // Exercise 5: Sized collection
  // TODO: Define a collection that carries its size at the type level
  class Sized[A, N <: Nat] private (val underlying: List[A])

  object Sized {
    def empty[A]: Sized[A, _0] = ???
    def apply[A](a: A): Sized[A, _1] = ???

    // TODO: Prepend an element, incrementing the size type
    def prepend[A, N <: Nat](elem: A, sized: Sized[A, N]): Sized[A, Succ[N]] = ???
  }

  // Exercise 6: Type-level multiplication concept
  // TODO: Define type-level multiplication (simplified)
  trait Mult[A <: Nat, B <: Nat] {
    type Out <: Nat
  }

  object Mult {
    type Aux[A <: Nat, B <: Nat, C <: Nat] = Mult[A, B] { type Out = C }

    // 0 * B = 0
    implicit def zeroMult[B <: Nat]: Mult.Aux[_0, B, _0] = ???

    // Succ[A] * B = B + (A * B)
    implicit def succMult[A <: Nat, B <: Nat, AB <: Nat, R <: Nat](
      implicit m: Mult.Aux[A, B, AB], s: Sum.Aux[B, AB, R]
    ): Mult.Aux[Succ[A], B, R] = ???
  }

  // Exercise 7: Range-checked values
  // TODO: Create a value that is statically proven to be within a range
  class RangeChecked[Min <: Nat, Max <: Nat] private (val value: Int)

  object RangeChecked {
    // TODO: Create only if Min <= value <= Max (simplified: just check at runtime)
    def apply[Min <: Nat, Max <: Nat](v: Int)(
      implicit minI: ToInt[Min], maxI: ToInt[Max]
    ): Option[RangeChecked[Min, Max]] = ???
  }

  // Exercise 8: Type-level equality
  // TODO: Prove type-level equality for Nat
  trait NatEqual[A <: Nat, B <: Nat]

  object NatEqual {
    implicit val zeroEq: NatEqual[_0, _0] = new NatEqual[_0, _0] {}
    implicit def succEq[A <: Nat, B <: Nat](
      implicit eq: NatEqual[A, B]
    ): NatEqual[Succ[A], Succ[B]] = new NatEqual[Succ[A], Succ[B]] {}
  }

  def assertNatEqual[A <: Nat, B <: Nat](implicit eq: NatEqual[A, B]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2
    assert(toInt[_0] == 0)
    assert(toInt[_1] == 1)
    assert(toInt[_3] == 3)
    assert(toInt[_5] == 5)

    // Exercise 3 (compile-time proof, runtime check)
    // 2 + 3 = 5
    val sum23: Int = add[_2, _3, _5]
    assert(sum23 == 5)

    // Exercise 4
    assert(assertLessThan[_0, _1])
    assert(assertLessThan[_2, _5])

    // Exercise 5
    val s0 = Sized.empty[Int]
    assert(s0.underlying.isEmpty)
    val s1 = Sized(42)
    assert(s1.underlying == List(42))
    val s2 = Sized.prepend(1, s1)
    assert(s2.underlying == List(1, 42))

    // Exercise 7
    val inRange = RangeChecked[_1, _5](3)
    assert(inRange.isDefined)
    val outOfRange = RangeChecked[_1, _5](10)
    assert(outOfRange.isEmpty)

    // Exercise 8
    assert(assertNatEqual[_0, _0])
    assert(assertNatEqual[_3, _3])

    println("All Core114_ShapelessTypeLevel exercises passed!")
  }
}
