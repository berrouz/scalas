package org.shev4ik.interview.scala_core.level2_intermediate

object Core061_FunctorPattern {

  // Exercise 1: Functor trait by hand
  // TODO: Define a Functor type class with a single method map[A, B](fa: F[A])(f: A => B): F[B]
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // Exercise 2: Functor for Option
  // TODO: Create a Functor instance for Option
  implicit val optionFunctor: Functor[Option] = ???

  // Exercise 3: Functor for List
  // TODO: Create a Functor instance for List
  implicit val listFunctor: Functor[List] = ???

  // Exercise 4: Functor for Tree
  // TODO: Define a simple binary Tree and create a Functor for it
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  implicit val treeFunctor: Functor[Tree] = ???

  // Exercise 5: Functor laws (identity, composition)
  // TODO: Verify functor laws:
  //       1. Identity: fa.map(identity) == fa
  //       2. Composition: fa.map(f).map(g) == fa.map(f andThen g)
  //       Implement verification methods that return true if laws hold
  def identityLaw[F[_]: Functor, A](fa: F[A])(implicit eq: (F[A], F[A]) => Boolean): Boolean = ???
  def compositionLaw[F[_]: Functor, A, B, C](fa: F[A], f: A => B, g: B => C)(
    implicit eq: (F[C], F[C]) => Boolean
  ): Boolean = ???

  // Exercise 6: map impl (generic usage)
  // TODO: Implement a generic function that uses Functor to double all values
  //       in any functor container
  def doubleAll[F[_]: Functor](fa: F[Int]): F[Int] = ???

  // TODO: Implement a generic stringify function
  def stringify[F[_]: Functor](fa: F[Int]): F[String] = ???

  // Exercise 7: Contravariant functor
  // TODO: Define a Contravariant functor (contramap instead of map)
  //       Useful for types that "consume" values rather than "produce" them
  trait Contravariant[F[_]] {
    def contramap[A, B](fa: F[A])(f: B => A): F[B]
  }

  // A predicate is contravariant: if you can test A, and you have B => A,
  // you can test B
  trait Predicate[A] {
    def test(a: A): Boolean
  }

  implicit val predicateContravariant: Contravariant[Predicate] = ???

  // TODO: Create a Predicate[Int] that tests if > 0, then contramap to Predicate[String] via _.length
  val positiveInt: Predicate[Int] = ???
  val nonEmptyString: Predicate[String] = ???

  // Exercise 8: Bifunctor
  // TODO: Define a Bifunctor for types with two type parameters
  //       bimap[A, B, C, D](fab: F[A, B])(f: A => C, g: B => D): F[C, D]
  trait Bifunctor[F[_, _]] {
    def bimap[A, B, C, D](fab: F[A, B])(f: A => C, g: B => D): F[C, D]
  }

  // TODO: Create a Bifunctor instance for Either
  implicit val eitherBifunctor: Bifunctor[Either] = ???

  // TODO: Create a Bifunctor instance for Tuple2
  implicit val tupleBifunctor: Bifunctor[Tuple2] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 - Functor trait defined

    // Exercise 2 assertions
    assert(optionFunctor.map(Some(42))(_ + 1) == Some(43), "Option functor map")
    assert(optionFunctor.map(None: Option[Int])(_ + 1) == None, "Option functor map None")

    // Exercise 3 assertions
    assert(listFunctor.map(List(1, 2, 3))(_ * 2) == List(2, 4, 6), "List functor map")

    // Exercise 4 assertions
    val tree: Tree[Int] = Node(Leaf(1), Node(Leaf(2), Leaf(3)))
    val doubled = treeFunctor.map(tree)(_ * 2)
    assert(doubled == Node(Leaf(2), Node(Leaf(4), Leaf(6))), "Tree functor map")

    // Exercise 5 assertions
    implicit def optEq[A]: (Option[A], Option[A]) => Boolean = _ == _
    assert(identityLaw[Option, Int](Some(42)), "Identity law for Option")
    implicit def optEqStr: (Option[String], Option[String]) => Boolean = _ == _
    assert(compositionLaw[Option, Int, String, String](
      Some(42), _.toString, _.toUpperCase
    ), "Composition law for Option")

    // Exercise 6 assertions
    assert(doubleAll(List(1, 2, 3)) == List(2, 4, 6), "doubleAll List")
    assert(doubleAll(Some(5): Option[Int]) == Some(10), "doubleAll Option")
    assert(stringify(List(1, 2, 3)) == List("1", "2", "3"), "stringify List")

    // Exercise 7 assertions
    assert(positiveInt.test(5), "5 is positive")
    assert(!positiveInt.test(-1), "-1 is not positive")
    assert(nonEmptyString.test("hello"), "'hello' is non-empty")
    assert(!nonEmptyString.test(""), "'' is empty")

    // Exercise 8 assertions
    assert(eitherBifunctor.bimap(Right(42): Either[String, Int])(_.toUpperCase, _ * 2) == Right(84), "Either bimap right")
    assert(eitherBifunctor.bimap(Left("error"): Either[String, Int])(_.toUpperCase, _ * 2) == Left("ERROR"), "Either bimap left")
    assert(tupleBifunctor.bimap((1, "hello"))(_ * 2, _.length) == (2, 5), "Tuple bimap")

    println("All Core061_FunctorPattern exercises passed!")
  }
}
