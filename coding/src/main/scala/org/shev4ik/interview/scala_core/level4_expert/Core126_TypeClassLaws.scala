package org.shev4ik.interview.scala_core.level4_expert

/**
 * Core126 - Type Class Laws
 * Level: Expert
 *
 * Verify type class laws using property-based testing concepts.
 * Laws ensure that type class instances behave correctly and predictably.
 *
 * Key concepts:
 * - Identity, composition, associativity laws
 * - Property-based testing for laws
 * - Discipline-style law testing
 */
object Core126_TypeClassLaws {

  // === Type class definitions ===

  trait Eq[A] {
    def eqv(a: A, b: A): Boolean
  }

  trait Semigroup[A] {
    def combine(a: A, b: A): A
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    override def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // Exercise 1: Semigroup associativity law
  // TODO: Implement a function that checks the associativity law:
  // combine(combine(a, b), c) == combine(a, combine(b, c))
  def semigroupAssociativityLaw[A: Semigroup : Eq](a: A, b: A, c: A): Boolean = ???

  // Exercise 2: Monoid identity laws
  // TODO: Implement functions that check left and right identity laws:
  // combine(empty, a) == a (left identity)
  // combine(a, empty) == a (right identity)
  def monoidLeftIdentityLaw[A: Monoid : Eq](a: A): Boolean = ???
  def monoidRightIdentityLaw[A: Monoid : Eq](a: A): Boolean = ???

  // Exercise 3: Functor identity law
  // TODO: Check that map(fa)(identity) == fa
  def functorIdentityLaw[F[_]: Functor, A: Eq](fa: F[A])(implicit eqFA: Eq[F[A]]): Boolean = ???

  // Exercise 4: Functor composition law
  // TODO: Check that map(fa)(f andThen g) == map(map(fa)(f))(g)
  def functorCompositionLaw[F[_]: Functor, A, B, C](fa: F[A], f: A => B, g: B => C)(implicit eqFC: Eq[F[C]]): Boolean = ???

  // Exercise 5: Monad left identity law
  // TODO: Check that flatMap(pure(a))(f) == f(a)
  def monadLeftIdentityLaw[F[_]: Monad, A, B](a: A, f: A => F[B])(implicit eqFB: Eq[F[B]]): Boolean = ???

  // Exercise 6: Monad right identity law
  // TODO: Check that flatMap(fa)(pure) == fa
  def monadRightIdentityLaw[F[_]: Monad, A](fa: F[A])(implicit eqFA: Eq[F[A]]): Boolean = ???

  // Exercise 7: Property-based law testing framework
  // TODO: Implement a simple property-based testing helper that generates
  // random values and checks a property holds for all of them.
  def forAll[A](gen: () => A, numTests: Int = 100)(property: A => Boolean): Boolean = ???

  // Exercise 8: Eq laws (reflexivity, symmetry, transitivity)
  // TODO: Implement checks for all three Eq laws
  def eqReflexivityLaw[A: Eq](a: A): Boolean = ???
  def eqSymmetryLaw[A: Eq](a: A, b: A): Boolean = ???
  def eqTransitivityLaw[A: Eq](a: A, b: A, c: A): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Setup instances
    implicit val intEq: Eq[Int] = (a: Int, b: Int) => a == b
    implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
      def empty: Int = 0
      def combine(a: Int, b: Int): Int = a + b
    }

    // Exercise 1
    assert(semigroupAssociativityLaw(1, 2, 3))
    assert(semigroupAssociativityLaw(10, 20, 30))
    println("Exercise 1 passed: Semigroup associativity law")

    // Exercise 2
    assert(monoidLeftIdentityLaw(42))
    assert(monoidRightIdentityLaw(42))
    println("Exercise 2 passed: Monoid identity laws")

    // Exercise 5
    implicit val optionMonad: Monad[Option] = new Monad[Option] {
      def pure[A](a: A): Option[A] = Some(a)
      def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
    }
    implicit def optionEq[A: Eq]: Eq[Option[A]] = (a: Option[A], b: Option[A]) => (a, b) match {
      case (Some(x), Some(y)) => implicitly[Eq[A]].eqv(x, y)
      case (None, None) => true
      case _ => false
    }
    assert(monadLeftIdentityLaw[Option, Int, Int](5, x => Some(x * 2)))
    println("Exercise 5 passed: Monad left identity law")

    // Exercise 6
    assert(monadRightIdentityLaw[Option, Int](Some(42)))
    println("Exercise 6 passed: Monad right identity law")

    // Exercise 8
    assert(eqReflexivityLaw(42))
    assert(eqSymmetryLaw(1, 1))
    println("Exercise 8 passed: Eq laws")

    println("\nAll Core126 exercises passed!")
  }
}
