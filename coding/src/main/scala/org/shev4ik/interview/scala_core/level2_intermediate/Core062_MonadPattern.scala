package org.shev4ik.interview.scala_core.level2_intermediate

object Core062_MonadPattern {

  // Exercise 1: Monad trait by hand
  // TODO: Define a Monad type class with pure and flatMap
  //       Also derive map from flatMap + pure
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = ???
  }

  // Exercise 2: Monad for Option
  // TODO: Create a Monad instance for Option
  implicit val optionMonad: Monad[Option] = ???

  // Exercise 3: Monad for List
  // TODO: Create a Monad instance for List
  implicit val listMonad: Monad[List] = ???

  // Exercise 4: Monad for Either
  // TODO: Create a Monad instance for Either[String, *] (fixing the left type)
  //       Note: Either is right-biased in Scala 2.13
  type StringEither[A] = Either[String, A]
  implicit val eitherMonad: Monad[StringEither] = ???

  // Exercise 5: pure/flatMap/map
  // TODO: Implement generic functions using the Monad type class:
  //       - liftM: lift a function A => B into F[A] => F[B]
  //       - flatten: F[F[A]] => F[A]
  //       - ap: apply F[A => B] to F[A] to get F[B]
  def liftM[F[_]: Monad, A, B](f: A => B): F[A] => F[B] = ???
  def flatten[F[_]: Monad, A](ffa: F[F[A]]): F[A] = ???

  // Exercise 6: Monad laws (left identity, right identity, associativity)
  // TODO: Verify monad laws:
  //       1. Left identity:  pure(a).flatMap(f) == f(a)
  //       2. Right identity: fa.flatMap(pure) == fa
  //       3. Associativity:  fa.flatMap(f).flatMap(g) == fa.flatMap(a => f(a).flatMap(g))
  def leftIdentity[F[_]: Monad, A, B](a: A, f: A => F[B])(implicit eq: (F[B], F[B]) => Boolean): Boolean = ???
  def rightIdentity[F[_]: Monad, A](fa: F[A])(implicit eq: (F[A], F[A]) => Boolean): Boolean = ???
  def associativity[F[_]: Monad, A, B, C](fa: F[A], f: A => F[B], g: B => F[C])(
    implicit eq: (F[C], F[C]) => Boolean
  ): Boolean = ???

  // Exercise 7: Monad for custom type
  // TODO: Create a simple Id monad (Identity monad - wraps a value)
  //       and implement its Monad instance
  case class Id[A](value: A)

  implicit val idMonad: Monad[Id] = ???

  // Exercise 8: for-comprehension desugaring
  // TODO: Show what a for-comprehension desugars to
  //       The for-comprehension:
  //         for { x <- Some(1); y <- Some(2); z <- Some(3) } yield x + y + z
  //       Desugars to:
  //         Some(1).flatMap(x => Some(2).flatMap(y => Some(3).map(z => x + y + z)))
  //       Implement both versions and verify they produce the same result

  def forComprehensionVersion: Option[Int] = ???
  def desugaredVersion: Option[Int] = ???

  // Also implement a version using our Monad type class
  def monadVersion: Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 - Monad trait defined with map derived from flatMap

    // Exercise 2 assertions
    assert(optionMonad.pure(42) == Some(42), "Option pure")
    assert(optionMonad.flatMap(Some(42))(x => Some(x + 1)) == Some(43), "Option flatMap")
    assert(optionMonad.flatMap(None: Option[Int])(x => Some(x + 1)) == None, "Option flatMap None")
    assert(optionMonad.map(Some(42))(_ + 1) == Some(43), "Option map via flatMap")

    // Exercise 3 assertions
    assert(listMonad.pure(42) == List(42), "List pure")
    assert(listMonad.flatMap(List(1, 2, 3))(x => List(x, x * 10)) == List(1, 10, 2, 20, 3, 30), "List flatMap")

    // Exercise 4 assertions
    assert(eitherMonad.pure(42) == Right(42), "Either pure")
    assert(eitherMonad.flatMap(Right(42): StringEither[Int])(x => Right(x + 1)) == Right(43), "Either flatMap right")
    assert(eitherMonad.flatMap(Left("err"): StringEither[Int])(x => Right(x + 1)) == Left("err"), "Either flatMap left")

    // Exercise 5 assertions
    val doubleOpt = liftM[Option, Int, Int](_ * 2)
    assert(doubleOpt(Some(21)) == Some(42), "liftM Option")
    assert(flatten[Option, Int](Some(Some(42))) == Some(42), "flatten Option")
    assert(flatten[List, Int](List(List(1, 2), List(3))) == List(1, 2, 3), "flatten List")

    // Exercise 6 assertions
    implicit def optEq[A]: (Option[A], Option[A]) => Boolean = _ == _
    val f: Int => Option[Int] = x => Some(x + 1)
    val g: Int => Option[Int] = x => Some(x * 2)
    assert(leftIdentity[Option, Int, Int](42, f), "Left identity law")
    assert(rightIdentity[Option, Int](Some(42)), "Right identity law")
    assert(associativity[Option, Int, Int, Int](Some(42), f, g), "Associativity law")

    // Exercise 7 assertions
    assert(idMonad.pure(42) == Id(42), "Id pure")
    assert(idMonad.flatMap(Id(42))(x => Id(x + 1)) == Id(43), "Id flatMap")
    assert(idMonad.map(Id(42))(_ + 1) == Id(43), "Id map")

    // Exercise 8 assertions
    assert(forComprehensionVersion == Some(6), "for-comprehension version")
    assert(desugaredVersion == Some(6), "desugared version")
    assert(monadVersion == Some(6), "monad version")
    assert(forComprehensionVersion == desugaredVersion, "both versions should be equal")

    println("All Core062_MonadPattern exercises passed!")
  }
}
