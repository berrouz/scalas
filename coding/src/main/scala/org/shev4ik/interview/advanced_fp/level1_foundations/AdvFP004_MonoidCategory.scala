package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP004 - Monoid in Category Theory
 *
 * "A monad is just a monoid in the category of endofunctors."
 * This file explores the categorical view of monoids, monoidal categories,
 * and the connection between Scala's Monoid and the category-theoretic concept.
 */
object AdvFP004_MonoidCategory {

  // === Standard Monoid typeclass ===
  trait Monoid[A] {
    def empty: A
    def combine(x: A, y: A): A
  }

  // === Functor and Monad for connecting to endofunctor monoid ===
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // ============================================================
  // Exercise 1: Implement a Monoid for Int (addition)
  // Verify identity: combine(a, empty) == a, combine(empty, a) == a
  // Verify associativity: combine(combine(a, b), c) == combine(a, combine(b, c))
  // ============================================================
  // TODO: Implement Monoid[Int] using addition
  val intAdditionMonoid: Monoid[Int] = ???

  // ============================================================
  // Exercise 2: Implement a Monoid for endomorphisms (A => A)
  // The "Endo" monoid: empty is identity, combine is composition.
  // ============================================================
  case class Endo[A](run: A => A)

  // TODO: Implement Monoid[Endo[A]] for any A
  def endoMonoid[A]: Monoid[Endo[A]] = ???

  // ============================================================
  // Exercise 3: Show that a Monad gives you a "monoid in endofunctors"
  // The monoidal product is composition of functors (F[F[A]] => F[A] via flatten).
  // The unit is pure (A => F[A]).
  // Implement flatten (join) in terms of flatMap.
  // ============================================================
  // TODO: Implement flatten using Monad's flatMap
  def flatten[F[_]: Monad, A](ffa: F[F[A]]): F[A] = ???

  // ============================================================
  // Exercise 4: Implement the "tensor product" of two monoids
  // Given Monoid[A] and Monoid[B], derive Monoid[(A, B)]
  // The monoidal structure is componentwise.
  // ============================================================
  // TODO: Implement product monoid
  def productMonoid[A, B](implicit ma: Monoid[A], mb: Monoid[B]): Monoid[(A, B)] = ???

  // ============================================================
  // Exercise 5: Implement a Monad for Option to illustrate
  // "monoid in the category of endofunctors"
  // pure = Some, flatMap = Option's flatMap
  // ============================================================
  // TODO: Implement Monad[Option]
  val optionMonad: Monad[Option] = ???

  // ============================================================
  // Exercise 6: Verify monoid laws for a given monoid and values
  // Check: left identity, right identity, and associativity.
  // Return a tuple of three booleans.
  // ============================================================
  // TODO: Verify monoid laws
  def verifyMonoidLaws[A](a: A, b: A, c: A)(implicit m: Monoid[A]): (Boolean, Boolean, Boolean) = ???

  // ============================================================
  // Exercise 7: Implement foldMap using Monoid
  // foldMap maps each element to a monoid value and combines them.
  // foldMap(List(1,2,3))(_.toString) == "123" (using string monoid)
  // ============================================================
  // TODO: Implement foldMap
  def foldMap[A, B](as: List[A])(f: A => B)(implicit m: Monoid[B]): B = ???

  // ============================================================
  // Exercise 8: Show the connection between Scala Monoid and Category Monoid
  // A categorical monoid in Set is (M, mu: M x M -> M, eta: 1 -> M).
  // Implement a wrapper that presents a Monoid as these categorical operations.
  // mu is the binary operation, eta is the unit element.
  // ============================================================
  trait CategoricalMonoid[M] {
    def mu(pair: (M, M)): M   // multiplication: M x M -> M
    def eta(unit: Unit): M     // unit: 1 -> M
  }

  // TODO: Convert a Monoid[M] into a CategoricalMonoid[M]
  def toCategorical[M](implicit m: Monoid[M]): CategoricalMonoid[M] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    implicit val intMon: Monoid[Int] = intAdditionMonoid
    assert(intMon.combine(3, intMon.empty) == 3)
    assert(intMon.combine(intMon.empty, 3) == 3)
    assert(intMon.combine(intMon.combine(1, 2), 3) == intMon.combine(1, intMon.combine(2, 3)))
    println("Exercise 1 passed: Int addition monoid")

    // Exercise 2
    val endo = endoMonoid[Int]
    val inc = Endo[Int](_ + 1)
    val dbl = Endo[Int](_ * 2)
    assert(endo.combine(inc, dbl).run(3) == 7) // inc(dbl(3)) = inc(6) = 7
    assert(endo.combine(inc, endo.empty).run(5) == 6)
    println("Exercise 2 passed: Endo monoid")

    // Exercise 3
    implicit val optMon: Monad[Option] = optionMonad
    assert(flatten[Option, Int](Some(Some(42))) == Some(42))
    assert(flatten[Option, Int](Some(None: Option[Int])) == None)
    assert(flatten[Option, Int](None: Option[Option[Int]]) == None)
    println("Exercise 3 passed: Flatten via Monad")

    // Exercise 4
    implicit val strMon: Monoid[String] = new Monoid[String] {
      def empty = ""
      def combine(x: String, y: String) = x + y
    }
    val pm = productMonoid[Int, String]
    assert(pm.combine((1, "a"), (2, "b")) == (3, "ab"))
    assert(pm.combine(pm.empty, (5, "x")) == (5, "x"))
    println("Exercise 4 passed: Product monoid")

    // Exercise 5
    assert(optionMonad.pure(42) == Some(42))
    assert(optionMonad.flatMap(Some(3))(x => Some(x * 2)) == Some(6))
    assert(optionMonad.flatMap(None: Option[Int])(x => Some(x * 2)) == None)
    println("Exercise 5 passed: Option monad")

    // Exercise 6
    val (li, ri, assoc) = verifyMonoidLaws(1, 2, 3)
    assert(li && ri && assoc, "All monoid laws should hold for Int addition")
    println("Exercise 6 passed: Monoid laws verified")

    // Exercise 7
    assert(foldMap(List(1, 2, 3))(_.toString) == "123")
    assert(foldMap(List.empty[Int])(_.toString) == "")
    println("Exercise 7 passed: foldMap works")

    // Exercise 8
    val catMon = toCategorical[Int]
    assert(catMon.mu((3, 4)) == 7)
    assert(catMon.eta(()) == 0)
    println("Exercise 8 passed: Categorical monoid")

    println("\nAll exercises passed!")
  }
}
