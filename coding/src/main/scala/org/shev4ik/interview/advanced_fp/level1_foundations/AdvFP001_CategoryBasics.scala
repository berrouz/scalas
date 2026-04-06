package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP001 - Category Basics
 *
 * A category consists of objects and morphisms (arrows) between them,
 * with identity morphisms and associative composition.
 * Scala types form a category where types are objects and functions are morphisms.
 */
object AdvFP001_CategoryBasics {

  // === Modeling a Category ===

  /**
   * A Category is defined by:
   * - A collection of objects
   * - For each pair of objects A, B, a set of morphisms (arrows) from A to B
   * - An identity morphism for each object
   * - A composition operation that is associative
   */
  trait Category[Arrow[_, _]] {
    def id[A]: Arrow[A, A]
    def compose[A, B, C](f: Arrow[B, C], g: Arrow[A, B]): Arrow[A, C]
  }

  // ============================================================
  // Exercise 1: Implement a Category instance for plain Scala functions
  // The identity morphism is the identity function, composition is function composition.
  // ============================================================
  // TODO: Implement Category[Function1]
  val functionCategory: Category[Function1] = ???

  // ============================================================
  // Exercise 2: Verify the identity law
  // For any morphism f: A => B, compose(f, id) == f and compose(id, f) == f
  // Return true if both left and right identity laws hold for the given function.
  // ============================================================
  // TODO: Verify identity law for a given function
  def verifyIdentityLaw[A, B](f: A => B)(a: A)(implicit cat: Category[Function1]): Boolean = ???

  // ============================================================
  // Exercise 3: Verify the associativity law
  // For morphisms f, g, h: compose(f, compose(g, h)) == compose(compose(f, g), h)
  // Return true if associativity holds for the given input.
  // ============================================================
  // TODO: Verify associativity law
  def verifyAssociativity[A, B, C, D](
    f: C => D,
    g: B => C,
    h: A => B
  )(a: A)(implicit cat: Category[Function1]): Boolean = ???

  // ============================================================
  // Exercise 4: Implement a Category for Kleisli arrows (A => Option[B])
  // This forms the Kleisli category for Option.
  // ============================================================
  type Kleisli[A, B] = A => Option[B]

  // TODO: Implement Category for Kleisli arrows over Option
  val kleisliOptionCategory: Category[Kleisli] = ???

  // ============================================================
  // Exercise 5: Implement andThen-style composition (diagrammatic order)
  // Given Category, implement andThen which composes in the other direction:
  // andThen(f: A => B, g: B => C): A => C
  // ============================================================
  // TODO: Implement andThen using category composition
  def andThen[Arrow[_, _], A, B, C](f: Arrow[A, B], g: Arrow[B, C])(implicit cat: Category[Arrow]): Arrow[A, C] = ???

  // ============================================================
  // Exercise 6: Show that Scala types + functions form a category
  // Implement a function that demonstrates identity and composition
  // for Int => String morphisms. Return the result of composing
  // (_.toString) and ("Number: " + _) applied to the input n.
  // ============================================================
  // TODO: Demonstrate Scala as a category with concrete types
  def scalaCategory(n: Int): String = ???

  // ============================================================
  // Exercise 7: Implement a monoid as a single-object category
  // A monoid (M, empty, combine) can be viewed as a category with one object
  // and morphisms being elements of M. Composition is combine, identity is empty.
  // Model this as a Category where Arrow[Unit, Unit] represents monoid elements.
  // ============================================================
  trait MonoidAsCategory[M] {
    def empty: M
    def combine(a: M, b: M): M
  }

  // TODO: Implement MonoidAsCategory for String (concatenation monoid)
  val stringMonoidCategory: MonoidAsCategory[String] = ???

  // ============================================================
  // Exercise 8: Implement Kleisli composition for List
  // A => List[B] forms a Kleisli category over List.
  // Implement compose: (B => List[C]) => (A => List[B]) => (A => List[C])
  // using flatMap.
  // ============================================================
  type KleisliList[A, B] = A => List[B]

  // TODO: Implement Kleisli composition for List
  def kleisliListCompose[A, B, C](f: B => List[C], g: A => List[B]): A => List[C] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Function category
    val cat = functionCategory
    val inc: Int => Int = _ + 1
    val dbl: Int => Int = _ * 2
    val composed = cat.compose(dbl, inc)
    assert(composed(3) == 8, "compose(dbl, inc)(3) should be 8")
    assert(cat.id[Int](42) == 42, "id(42) should be 42")
    println("Exercise 1 passed: Function category works")

    // Exercise 2: Identity law
    implicit val implCat: Category[Function1] = functionCategory
    val f: Int => String = _.toString
    assert(verifyIdentityLaw(f)(42), "Identity law should hold")
    println("Exercise 2 passed: Identity law verified")

    // Exercise 3: Associativity law
    val h: Int => Int = _ + 1
    val g: Int => Int = _ * 2
    val fAssoc: Int => String = _.toString
    assert(verifyAssociativity(fAssoc, g, h)(3), "Associativity should hold")
    println("Exercise 3 passed: Associativity law verified")

    // Exercise 4: Kleisli Option category
    val kCat = kleisliOptionCategory
    val parse: String => Option[Int] = s => scala.util.Try(s.toInt).toOption
    val half: Int => Option[Int] = n => if (n % 2 == 0) Some(n / 2) else None
    val parseAndHalf = kCat.compose[String, Int, Int](half, parse)
    assert(parseAndHalf("10") == Some(5))
    assert(parseAndHalf("abc") == None)
    assert(parseAndHalf("3") == None)
    println("Exercise 4 passed: Kleisli Option category works")

    // Exercise 5: andThen
    val incThenDbl = andThen[Function1, Int, Int, Int](_ + 1, _ * 2)
    assert(incThenDbl(3) == 8)
    println("Exercise 5 passed: andThen works")

    // Exercise 6: Scala category demo
    assert(scalaCategory(42) == "Number: 42")
    println("Exercise 6 passed: Scala category demonstrated")

    // Exercise 7: String monoid as category
    assert(stringMonoidCategory.empty == "")
    assert(stringMonoidCategory.combine("Hello, ", "World") == "Hello, World")
    println("Exercise 7 passed: Monoid as category works")

    // Exercise 8: Kleisli List compose
    val expand: Int => List[String] = n => List(n.toString, (n * 10).toString)
    val duplicate: String => List[String] = s => List(s, s)
    val composed8 = kleisliListCompose(duplicate, expand)
    assert(composed8(3) == List("3", "3", "30", "30"))
    println("Exercise 8 passed: Kleisli List composition works")

    println("\nAll exercises passed!")
  }
}
