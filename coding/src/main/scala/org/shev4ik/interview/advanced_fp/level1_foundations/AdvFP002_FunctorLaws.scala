package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP002 - Functor Laws
 *
 * A Functor maps objects and morphisms between categories, preserving
 * identity and composition. In Scala, a Functor[F] provides map
 * and must satisfy: map(id) == id, map(f compose g) == map(f) compose map(g).
 */
object AdvFP002_FunctorLaws {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // ============================================================
  // Exercise 1: Verify the identity law for a Functor
  // map(fa)(identity) == fa
  // Return true if the law holds.
  // ============================================================
  // TODO: Check identity law: map(fa)(identity) == fa
  def checkIdentityLaw[F[_], A](fa: F[A])(implicit F: Functor[F]): Boolean = ???

  // ============================================================
  // Exercise 2: Verify the composition law for a Functor
  // map(fa)(f compose g) == map(map(fa)(g))(f)
  // Return true if the law holds for the given input.
  // ============================================================
  // TODO: Check composition law
  def checkCompositionLaw[F[_], A, B, C](fa: F[A], f: B => C, g: A => B)(implicit F: Functor[F]): Boolean = ???

  // ============================================================
  // Exercise 3: Implement a lawful Functor for Option
  // ============================================================
  // TODO: Implement Functor[Option]
  implicit val optionFunctor: Functor[Option] = ???

  // ============================================================
  // Exercise 4: Implement an UNLAWFUL functor to show what breaks.
  // This wrapper always appends an extra element when mapping.
  // This violates the identity law because map(fa)(identity) != fa.
  // ============================================================
  case class BrokenList[A](values: List[A])

  // TODO: Implement an unlawful Functor[BrokenList] that appends a default element
  // Hint: map should produce BrokenList(values.map(f) :+ f(values.head)) or similar
  // This breaks identity law since map(identity) adds an element
  implicit val brokenListFunctor: Functor[BrokenList] = ???

  // ============================================================
  // Exercise 5: Implement Functor for a custom Tree type
  // ============================================================
  sealed trait Tree[+A]
  case class Leaf[A](value: A) extends Tree[A]
  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  // TODO: Implement Functor[Tree]
  implicit val treeFunctor: Functor[Tree] = ???

  // ============================================================
  // Exercise 6: Implement a Bifunctor
  // A Bifunctor is a functor in two arguments: bimap maps over both.
  // ============================================================
  trait Bifunctor[F[_, _]] {
    def bimap[A, B, C, D](fab: F[A, B])(f: A => C, g: B => D): F[C, D]
  }

  // TODO: Implement Bifunctor for Either
  val eitherBifunctor: Bifunctor[Either] = ???

  // ============================================================
  // Exercise 7: Implement a Contravariant functor
  // Contravariant reverses the arrow: contramap[A, B](fa: F[A])(f: B => A): F[B]
  // ============================================================
  trait Contravariant[F[_]] {
    def contramap[A, B](fa: F[A])(f: B => A): F[B]
  }

  // Predicate is contravariant: if you can test A, and you can convert B to A,
  // then you can test B.
  case class Predicate[A](run: A => Boolean)

  // TODO: Implement Contravariant[Predicate]
  implicit val predicateContravariant: Contravariant[Predicate] = ???

  // ============================================================
  // Exercise 8: Implement Profunctor (contravariant in first arg, covariant in second)
  // dimap[A, B, C, D](fab: F[A, B])(f: C => A)(g: B => D): F[C, D]
  // ============================================================
  trait Profunctor[F[_, _]] {
    def dimap[A, B, C, D](fab: F[A, B])(f: C => A)(g: B => D): F[C, D]
  }

  // TODO: Implement Profunctor for Function1
  val function1Profunctor: Profunctor[Function1] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Identity law
    assert(checkIdentityLaw(Option(42)) == true, "Identity law should hold for Option")
    println("Exercise 1 passed: Identity law verified")

    // Exercise 2: Composition law
    val f: Int => String = _.toString
    val g: Int => Int = _ + 1
    assert(checkCompositionLaw(Option(5), f, g) == true, "Composition law should hold")
    println("Exercise 2 passed: Composition law verified")

    // Exercise 3: Option functor
    assert(optionFunctor.map(Some(3))(_ * 2) == Some(6))
    assert(optionFunctor.map(None: Option[Int])(_ * 2) == None)
    println("Exercise 3 passed: Option functor works")

    // Exercise 4: Unlawful functor
    val bl = BrokenList(List(1, 2, 3))
    val mapped = brokenListFunctor.map(bl)(identity)
    assert(mapped != bl, "Unlawful functor should break identity law")
    println("Exercise 4 passed: Unlawful functor demonstrated")

    // Exercise 5: Tree functor
    val tree: Tree[Int] = Branch(Leaf(1), Branch(Leaf(2), Leaf(3)))
    val mappedTree = treeFunctor.map(tree)(_ * 10)
    assert(mappedTree == Branch(Leaf(10), Branch(Leaf(20), Leaf(30))))
    println("Exercise 5 passed: Tree functor works")

    // Exercise 6: Bifunctor for Either
    val left: Either[Int, String] = Left(42)
    val right: Either[Int, String] = Right("hello")
    assert(eitherBifunctor.bimap(left)(_ * 2, _.toUpperCase) == Left(84))
    assert(eitherBifunctor.bimap(right)(_ * 2, _.toUpperCase) == Right("HELLO"))
    println("Exercise 6 passed: Bifunctor for Either works")

    // Exercise 7: Contravariant functor
    val isPositive = Predicate[Int](_ > 0)
    val isPositiveLength = predicateContravariant.contramap(isPositive)((s: String) => s.length)
    assert(isPositiveLength.run("hello") == true)
    assert(isPositiveLength.run("") == false)
    println("Exercise 7 passed: Contravariant functor works")

    // Exercise 8: Profunctor for Function1
    val intToString: Int => String = _.toString
    val dimapped = function1Profunctor.dimap(intToString)((s: String) => s.length)("Result: " + _)
    assert(dimapped("hello") == "Result: 5")
    println("Exercise 8 passed: Profunctor for Function1 works")

    println("\nAll exercises passed!")
  }
}
