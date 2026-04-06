package org.shev4ik.interview.scala_core.level3_advanced

import org.shev4ik.interview.docker_k8s.level1_basics.DK004_K8sBasics.Container

object Core071_HigherKindedTypes {

  // Exercise 1: F[_] syntax
  // TODO: Define a trait Container that takes a higher-kinded type parameter F[_]
  //       with a method `wrap[A](value: A): F[A]`
  trait Container[F[_]] {
    def wrap[A](value: A): F[A]
  }

  // TODO: Implement Container for List
  val listContainer: Container[List] = new Container[List] {
    override def wrap[A](value: A): List[A] = List()
  }

  // Exercise 2: HKT as type parameter
  // TODO: Define a method `doubleWrap` that takes a Container[F] and a value,
  //       wraps it, then wraps the result in a List
  def doubleWrap[F[_], A](container: Container[F], value: A): (F[A], List[A]) = {
    (container.wrap(value), List(value))
  }

  // Exercise 3: Functor[F[_]]
  // TODO: Define a Functor type class with a `map` method
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // TODO: Implement Functor for Option
  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    override def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  // Exercise 4: Monad[F[_]]
  // TODO: Define a Monad type class extending Functor with `pure` and `flatMap`
  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    override def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // TODO: Implement Monad for Option
  implicit val optionMonad: Monad[Option] = ???

  // Exercise 5: Kind projector concept
  // TODO: Without kind projector plugin, define a Functor instance for Either[String, *]
  //       using a type alias or type lambda
  type StringEither[A] = Either[String, A]

  implicit val eitherStringFunctor: Functor[StringEither] = ???

  // Exercise 6: Type constructor
  // TODO: Define a trait TypeConstructor that takes a type constructor F[_]
  //       and provides a method `construct[A](a: A): F[A]` and `deconstruct[A](fa: F[A]): A`
  trait TypeConstructor[F[_]] {
    def construct[A](a: A): F[A]
    def deconstruct[A](fa: F[A]): A
  }

  // TODO: Implement TypeConstructor for some simple wrapper
  case class Id[A](value: A)
  implicit val idTypeConstructor: TypeConstructor[Id] = ???

  // Exercise 7: HKT in practice
  // TODO: Define a generic `sequence` method that converts List[F[A]] to F[List[A]]
  //       using the Monad type class
  def sequence[F[_]: Monad, A](list: List[F[A]]): F[List[A]] = ???

  // Exercise 8: HKT constraint
  // TODO: Define a method `mapAndFlatten` that requires F to have both
  //       Functor and a `flatten` capability. Use a custom trait FlatMap[F[_]] for flatten.
  trait FlatMap[F[_]] {
    def flatten[A](ffa: F[F[A]]): F[A]
  }

  def mapAndFlatten[F[_]: Functor: FlatMap, A, B](fa: F[A])(f: A => F[B]): F[B] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(listContainer.wrap(42) == List(42))
    assert(listContainer.wrap("hello") == List("hello"))

    // Exercise 2
    val (wrapped, listed) = doubleWrap(listContainer, 10)
    assert(wrapped == List(10))
    assert(listed == List(10))

    // Exercise 3
    assert(optionFunctor.map(Some(3): Option[Int])(_ * 2) == Some(6))
    assert(optionFunctor.map(None: Option[Int])(_ * 2) == None)

    // Exercise 4
    assert(optionMonad.pure(5) == Some(5))
    assert(optionMonad.flatMap(Some(3))(x => Some(x + 1)) == Some(4))
    assert(optionMonad.flatMap(None: Option[Int])(x => Some(x + 1)) == None)

    // Exercise 5
    assert(eitherStringFunctor.map(Right(10): StringEither[Int])(_ * 2) == Right(20))
    assert(eitherStringFunctor.map(Left("err"): StringEither[Int])(_ * 2) == Left("err"))

    // Exercise 6
    assert(idTypeConstructor.construct(42) == Id(42))
    assert(idTypeConstructor.deconstruct(Id(42)) == 42)

    // Exercise 7
    assert(sequence(List(Some(1): Option[Int], Some(2): Option[Int], Some(3): Option[Int]))(optionMonad) == Some(List(1, 2, 3)))
    assert(sequence(List(Some(1): Option[Int], None: Option[Int], Some(3): Option[Int]))(optionMonad) == None)

    // Exercise 8
    implicit val optionFlatMap: FlatMap[Option] = new FlatMap[Option] {
      def flatten[A](ffa: Option[Option[A]]): Option[A] = ffa.flatten
    }
    assert(mapAndFlatten(Some(3): Option[Int])(x => Some(x * 2)) == Some(6))

    println("All Core071_HigherKindedTypes exercises passed!")
  }
}
