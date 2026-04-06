package org.shev4ik.interview.scala_core.level3_advanced

object Core072_TypeLambdas {

  // We'll reuse a simple Functor definition
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    override def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // Exercise 1: Type lambda syntax
  // TODO: Create a Functor instance for Either[String, *] using the type lambda syntax
  //       ({type L[A] = Either[String, A]})#L
  val eitherStringFunctor: Functor[({type L[A] = Either[String, A]})#L] = ???

  // Exercise 2: Kind projector style (manual)
  // TODO: Define a type alias that acts like kind projector's Either[Int, *]
  //       Then implement Functor for it
  type EitherInt[A] = Either[Int, A]
  val eitherIntFunctor: Functor[EitherInt] = ???

  // Exercise 3: Partially applied types
  // TODO: Define a type alias PartialMap[V] = Map[String, V]
  //       and implement Functor for PartialMap
  type PartialMap[V] = Map[String, V]
  implicit val partialMapFunctor: Functor[PartialMap] = ???

  // Exercise 4: Type lambda for Functor
  // TODO: Implement Functor for Function1[Int, *] using type lambda
  //       i.e. Functor for functions from Int
  type IntFunction[A] = Int => A
  val intFunctionFunctor: Functor[IntFunction] = ???

  // Exercise 5: Type lambda for Monad
  // TODO: Implement Monad for Either[String, *] using type lambda approach
  val eitherStringMonad: Monad[({type L[A] = Either[String, A]})#L] = ???

  // Exercise 6: Type lambda in context bounds
  // TODO: Write a method that uses a Functor for a partially applied Either
  //       Use a type alias to make it work with context bounds
  type StringOr[A] = Either[String, A]

  def mapRight[A, B](either: StringOr[A])(f: A => B)(implicit F: Functor[StringOr]): StringOr[B] = ???

  // Exercise 7: Type lambda alternatives
  // TODO: Show three different ways to express the same Functor for Tuple2[String, *]:
  //       (a) type alias, (b) type lambda, (c) abstract type member
  type StringTuple[A] = (String, A)

  // (a) Using type alias
  val stringTupleFunctorA: Functor[StringTuple] = ???

  // Exercise 8: Type lambda use cases
  // TODO: Create a method `collectRight` that takes a List[Either[E, A]]
  //       and returns an Either[E, List[A]] (sequence for Either)
  //       Use type lambda or type alias to work with Monad
  def collectRight[E, A](list: List[Either[E, A]]): Either[E, List[A]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(eitherStringFunctor.map(Right(10): Either[String, Int])(_ + 1) == Right(11))
    assert(eitherStringFunctor.map(Left("err"): Either[String, Int])(_ + 1) == Left("err"))

    // Exercise 2
    assert(eitherIntFunctor.map(Right("hello"): EitherInt[String])(_.length) == Right(5))

    // Exercise 3
    val m: PartialMap[Int] = Map("a" -> 1, "b" -> 2)
    assert(partialMapFunctor.map(m)(_ * 10) == Map("a" -> 10, "b" -> 20))

    // Exercise 4
    val f: IntFunction[String] = (i: Int) => s"num=$i"
    val g = intFunctionFunctor.map(f)(_.toUpperCase)
    assert(g(42) == "NUM=42")

    // Exercise 5
    assert(eitherStringMonad.pure(42) == Right(42))
    assert(eitherStringMonad.flatMap(Right(3): Either[String, Int])(x => Right(x * 2)) == Right(6))
    assert(eitherStringMonad.flatMap(Left("err"): Either[String, Int])(x => Right(x * 2)) == Left("err"))

    // Exercise 6
    implicit val sf: Functor[StringOr] = eitherStringFunctor.asInstanceOf[Functor[StringOr]]
    assert(mapRight(Right(5): StringOr[Int])(_ * 3) == Right(15))

    // Exercise 7
    assert(stringTupleFunctorA.map(("hello", 10))(_ + 1) == ("hello", 11))

    // Exercise 8
    assert(collectRight(List(Right(1), Right(2), Right(3))) == Right(List(1, 2, 3)))
    assert(collectRight(List(Right(1), Left("err"), Right(3))) == Left("err"))

    println("All Core072_TypeLambdas exercises passed!")
  }
}
