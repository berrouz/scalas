package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP033 - Type-Level Computation
 *
 * Scala's type system is Turing-complete. We can encode natural numbers,
 * booleans, and lists at the type level and perform computations using
 * implicit resolution as a proof search engine.
 */
object AdvFP033_TypeLevelComputation {

  // ============================================================
  // Exercise 1: Type-level natural numbers (Peano encoding)
  // ============================================================
  sealed trait Nat
  sealed trait Zero extends Nat
  sealed trait Succ[N <: Nat] extends Nat

  // Type aliases for convenience
  type _0 = Zero
  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]
  type _5 = Succ[_4]

  // TODO: Implement a typeclass that converts type-level Nat to value-level Int
  trait ToInt[N <: Nat] {
    def value: Int
  }

  implicit val zeroToInt: ToInt[Zero] = ???
  implicit def succToInt[N <: Nat](implicit n: ToInt[N]): ToInt[Succ[N]] = ???

  def toInt[N <: Nat](implicit ti: ToInt[N]): Int = ti.value

  // ============================================================
  // Exercise 2: Type-level addition
  // Sum[A, B] = { type Out <: Nat }
  // ============================================================
  trait Sum[A <: Nat, B <: Nat] {
    type Out <: Nat
  }

  // TODO: Implement type-level addition
  implicit def sumZero[B <: Nat]: Sum[Zero, B] { type Out = B } = ???
  implicit def sumSucc[A <: Nat, B <: Nat](implicit s: Sum[A, B]): Sum[Succ[A], B] { type Out = Succ[s.Out] } = ???

  // ============================================================
  // Exercise 3: Type-level booleans
  // ============================================================
  sealed trait Bool
  sealed trait True extends Bool
  sealed trait False extends Bool

  // TODO: Implement type-level If
  trait If[Cond <: Bool, Then, Else] {
    type Out
  }

  implicit def ifTrue[T, E]: If[True, T, E] { type Out = T } = ???
  implicit def ifFalse[T, E]: If[False, T, E] { type Out = E } = ???

  // ============================================================
  // Exercise 4: Type-level less-than comparison
  // LT[A, B] exists only when A < B
  // ============================================================
  trait LT[A <: Nat, B <: Nat]

  // TODO: Implement type-level less-than
  implicit def ltZero[B <: Nat]: LT[Zero, Succ[B]] = ???
  implicit def ltSucc[A <: Nat, B <: Nat](implicit ev: LT[A, B]): LT[Succ[A], Succ[B]] = ???

  // TODO: Write a function that only compiles when A < B
  def assertLT[A <: Nat, B <: Nat](implicit ev: LT[A, B]): Unit = ()

  // ============================================================
  // Exercise 5: Type-level HList (heterogeneous list)
  // ============================================================
  sealed trait HList
  case class HCons[H, T <: HList](head: H, tail: T) extends HList
  case object HNil extends HList {
    // Ensure HNil has the right type
  }
  type HNilType = HNil.type

  // Infix operator
  type ::[H, T <: HList] = HCons[H, T]

  // TODO: Implement a Length typeclass for HList
  trait Length[L <: HList] {
    type Out <: Nat
    def value: Int
  }

  implicit val hnilLength: Length[HNilType] { type Out = Zero } = ???
  implicit def hconsLength[H, T <: HList](implicit tl: Length[T]): Length[HCons[H, T]] { type Out = Succ[tl.Out] } = ???

  // ============================================================
  // Exercise 6: Aux pattern
  // The Aux pattern extracts associated types for use in implicit resolution.
  // ============================================================
  object Sum {
    type Aux[A <: Nat, B <: Nat, C <: Nat] = Sum[A, B] { type Out = C }
  }

  // TODO: Write a function that uses the Aux pattern to compute A + B
  //       and returns it as an Int at the value level.
  def addNats[A <: Nat, B <: Nat, C <: Nat](
    implicit sum: Sum.Aux[A, B, C],
    toIntC: ToInt[C]
  ): Int = ???

  // ============================================================
  // Exercise 7: Implicit resolution as proof search
  // Implement a typeclass that proves a Nat is even.
  // ============================================================
  trait IsEven[N <: Nat]

  // TODO: Zero is even. Succ(Succ(N)) is even if N is even.
  implicit val zeroIsEven: IsEven[Zero] = ???
  implicit def succSuccIsEven[N <: Nat](implicit ev: IsEven[N]): IsEven[Succ[Succ[N]]] = ???

  // TODO: This should compile for even numbers, not for odd
  def assertEven[N <: Nat](implicit ev: IsEven[N]): Unit = ()

  // ============================================================
  // Exercise 8: Shapeless-style Generic concept
  // A Generic converts between a case class and its HList representation.
  // Implement a simplified Generic for a specific case class.
  // ============================================================
  case class Person(name: String, age: Int)

  trait Generic[A] {
    type Repr <: HList
    def to(a: A): Repr
    def from(r: Repr): A
  }

  // TODO: Implement Generic[Person]
  implicit val personGeneric: Generic[Person] { type Repr = HCons[String, HCons[Int, HNilType]] } = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Nat to Int
    assert(toInt[_0] == 0)
    assert(toInt[_3] == 3)
    assert(toInt[_5] == 5)
    println("Exercise 1 passed: Type-level natural numbers")

    // Exercise 2: Type-level addition (compile-time check)
    // _2 + _3 = _5
    val sum23: Sum[_2, _3] = implicitly[Sum[_2, _3]]
    println("Exercise 2 passed: Type-level addition compiles")

    // Exercise 3: Type-level If (compile-time check)
    val ifTrue: If[True, Int, String] = implicitly[If[True, Int, String]]
    val ifFalse: If[False, Int, String] = implicitly[If[False, Int, String]]
    println("Exercise 3 passed: Type-level If")

    // Exercise 4: Less-than
    assertLT[_0, _1]
    assertLT[_2, _5]
    // assertLT[_3, _2] // This should NOT compile
    println("Exercise 4 passed: Type-level less-than")

    // Exercise 5: HList length
    val hlist = HCons(42, HCons("hello", HCons(true, HNil)))
    val len = implicitly[Length[HCons[Int, HCons[String, HCons[Boolean, HNilType]]]]]
    assert(len.value == 3)
    println("Exercise 5 passed: HList length")

    // Exercise 6: Aux pattern
    val result = addNats[_2, _3, _5]
    assert(result == 5)
    println("Exercise 6 passed: Aux pattern")

    // Exercise 7: IsEven
    assertEven[_0]
    assertEven[_2]
    assertEven[_4]
    // assertEven[_3] // Should NOT compile
    println("Exercise 7 passed: Type-level even check")

    // Exercise 8: Generic
    val p = Person("Alice", 30)
    val gen = personGeneric
    val repr = gen.to(p)
    assert(repr.head == "Alice")
    assert(repr.tail.head == 30)
    val back = gen.from(repr)
    assert(back == p)
    println("Exercise 8 passed: Shapeless-style Generic")

    println("\nAll exercises passed!")
  }
}
