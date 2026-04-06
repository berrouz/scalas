package org.shev4ik.interview.scala_core.level4_expert

object Core116_TypeLevelProgramming {

  // Exercise 1: Type-level booleans
  // TODO: Define type-level booleans
  sealed trait Bool
  sealed trait True extends Bool
  sealed trait False extends Bool

  // TODO: Convert type-level booleans to runtime
  trait ToBool[B <: Bool] { def value: Boolean }
  implicit val trueVal: ToBool[True] = ???
  implicit val falseVal: ToBool[False] = ???

  def toBool[B <: Bool](implicit tb: ToBool[B]): Boolean = ???

  // Exercise 2: Type-level if
  // TODO: Implement type-level if-then-else
  trait If[Cond <: Bool, Then, Else] { type Out }

  object If {
    type Aux[C <: Bool, T, E, O] = If[C, T, E] { type Out = O }

    implicit def ifTrue[T, E]: If.Aux[True, T, E, T] = ???
    implicit def ifFalse[T, E]: If.Aux[False, T, E, E] = ???
  }

  // Exercise 3: Type-level natural numbers (using Bool)
  sealed trait Nat
  class _0 extends Nat
  class Succ[N <: Nat] extends Nat

  type _1 = Succ[_0]
  type _2 = Succ[_1]
  type _3 = Succ[_2]
  type _4 = Succ[_3]
  type _5 = Succ[_4]

  trait ToInt[N <: Nat] { def value: Int }
  implicit val zeroInt: ToInt[_0] = new ToInt[_0] { def value = 0 }
  implicit def succInt[N <: Nat](implicit p: ToInt[N]): ToInt[Succ[N]] =
    new ToInt[Succ[N]] { def value = p.value + 1 }

  // Exercise 4: Type-level list
  // TODO: Define a type-level list of types
  sealed trait TList
  sealed trait TNil extends TList
  sealed trait TCons[H, T <: TList] extends TList

  // TODO: Compute the length of a type-level list
  trait TLength[L <: TList] { type Out <: Nat }

  object TLength {
    type Aux[L <: TList, N <: Nat] = TLength[L] { type Out = N }

    implicit val nilLength: TLength.Aux[TNil, _0] = ???
    implicit def consLength[H, T <: TList, N <: Nat](
      implicit tl: TLength.Aux[T, N]
    ): TLength.Aux[TCons[H, T], Succ[N]] = ???
  }

  def tlistLength[L <: TList](implicit l: TLength[L]): Int = ???

  // Exercise 5: Type-level computation
  // TODO: Define type-level IsZero
  trait IsZero[N <: Nat] { type Out <: Bool }

  object IsZero {
    type Aux[N <: Nat, B <: Bool] = IsZero[N] { type Out = B }
    implicit val zero: IsZero.Aux[_0, True] = ???
    implicit def succ[N <: Nat]: IsZero.Aux[Succ[N], False] = ???
  }

  def isZero[N <: Nat](implicit iz: IsZero[N]): Boolean = ???

  // Exercise 6: Implicit proof search
  // TODO: Use implicit proof search for type-level assertions
  @annotation.implicitNotFound("Cannot prove that ${A} equals ${B}")
  trait NatEq[A <: Nat, B <: Nat]

  object NatEq {
    implicit val zeroEq: NatEq[_0, _0] = new NatEq[_0, _0] {}
    implicit def succEq[A <: Nat, B <: Nat](
      implicit eq: NatEq[A, B]
    ): NatEq[Succ[A], Succ[B]] = new NatEq[Succ[A], Succ[B]] {}
  }

  // TODO: Function that only compiles when two Nats are equal
  def assertEq[A <: Nat, B <: Nat](implicit eq: NatEq[A, B]): Boolean = ???

  // Exercise 7: Type-level Fibonacci concept
  // TODO: Define type-level Fibonacci (simplified - just show the pattern)
  trait Fib[N <: Nat] { type Out <: Nat }

  object Fib {
    type Aux[N <: Nat, R <: Nat] = Fib[N] { type Out = R }

    // fib(0) = 0
    implicit val fib0: Fib.Aux[_0, _0] = new Fib[_0] { type Out = _0 }.asInstanceOf[Fib.Aux[_0, _0]]

    // fib(1) = 1
    implicit val fib1: Fib.Aux[_1, _1] = new Fib[_1] { type Out = _1 }.asInstanceOf[Fib.Aux[_1, _1]]

    // For demonstration, manually define fib(2) = 1, fib(3) = 2
    implicit val fib2: Fib.Aux[_2, _1] = new Fib[_2] { type Out = _1 }.asInstanceOf[Fib.Aux[_2, _1]]
    implicit val fib3: Fib.Aux[_3, _2] = new Fib[_3] { type Out = _2 }.asInstanceOf[Fib.Aux[_3, _2]]
  }

  def fib[N <: Nat](implicit f: Fib[N]): Int = ???

  // Exercise 8: Type-level assertions
  // TODO: Create compile-time assertions using implicit evidence
  @annotation.implicitNotFound("${N} is not positive")
  trait IsPositive[N <: Nat]

  object IsPositive {
    implicit def positive[N <: Nat]: IsPositive[Succ[N]] = new IsPositive[Succ[N]] {}
  }

  def requirePositive[N <: Nat](implicit ev: IsPositive[N], ti: ToInt[N]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(toBool[True] == true)
    assert(toBool[False] == false)

    // Exercise 4
    type MyList = TCons[Int, TCons[String, TCons[Boolean, TNil]]]
    assert(tlistLength[MyList] == 3)
    assert(tlistLength[TNil] == 0)

    // Exercise 5
    assert(isZero[_0] == true)
    assert(isZero[_3] == false)

    // Exercise 6
    assert(assertEq[_0, _0])
    assert(assertEq[_3, _3])
    // assertEq[_2, _3] would not compile

    // Exercise 7
    assert(fib[_0] == 0)
    assert(fib[_1] == 1)
    assert(fib[_2] == 1)
    assert(fib[_3] == 2)

    // Exercise 8
    assert(requirePositive[_1] == 1)
    assert(requirePositive[_5] == 5)
    // requirePositive[_0] would not compile

    println("All Core116_TypeLevelProgramming exercises passed!")
  }
}
