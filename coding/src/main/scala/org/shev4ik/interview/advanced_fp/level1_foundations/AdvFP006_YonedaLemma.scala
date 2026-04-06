package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP006 - Yoneda Lemma
 *
 * The Yoneda lemma states: Nat(Hom(A, -), F) ≅ F(A).
 * In Scala: forall B. (A => B) => F[B]  ≅  F[A]
 * Coyoneda is the dual: exists B. (B => A, F[B])  ≅  F[A] (when F is a functor)
 */
object AdvFP006_YonedaLemma {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  // ============================================================
  // Exercise 1: Implement Yoneda for any functor F
  // Yoneda[F, A] wraps: forall B. (A => B) => F[B]
  // ============================================================
  trait Yoneda[F[_], A] {
    def run[B](f: A => B): F[B]
  }

  // TODO: Lift F[A] into Yoneda[F, A]
  def toYoneda[F[_]: Functor, A](fa: F[A]): Yoneda[F, A] = ???

  // ============================================================
  // Exercise 2: Lower Yoneda[F, A] back to F[A]
  // Apply the identity function to extract F[A].
  // ============================================================
  // TODO: Lower Yoneda[F, A] to F[A]
  def fromYoneda[F[_], A](y: Yoneda[F, A]): F[A] = ???

  // ============================================================
  // Exercise 3: Implement map for Yoneda WITHOUT using Functor
  // This is the key insight: Yoneda gives you map for free via function composition.
  // ============================================================
  // TODO: Map over Yoneda without Functor constraint
  def yonedaMap[F[_], A, B](ya: Yoneda[F, A])(f: A => B): Yoneda[F, B] = ???

  // ============================================================
  // Exercise 4: Implement Coyoneda
  // Coyoneda[F, A] = exists B. (B => A, F[B])
  // This gives a free functor for any type constructor F (even non-functors).
  // ============================================================
  trait Coyoneda[F[_], A] {
    type Pivot
    val fi: F[Pivot]
    val k: Pivot => A
  }

  // TODO: Lift F[A] into Coyoneda[F, A]
  def toCoyoneda[F[_], A](fa: F[A]): Coyoneda[F, A] = ???

  // ============================================================
  // Exercise 5: Lower Coyoneda[F, A] to F[A] using a Functor
  // Apply the stored function using the Functor instance.
  // ============================================================
  // TODO: Lower Coyoneda to F[A]
  def fromCoyoneda[F[_]: Functor, A](cy: Coyoneda[F, A]): F[A] = ???

  // ============================================================
  // Exercise 6: Implement map for Coyoneda WITHOUT Functor
  // This is the "free functor" property: just compose the stored function.
  // ============================================================
  // TODO: Map over Coyoneda without Functor
  def coyonedaMap[F[_], A, B](cy: Coyoneda[F, A])(f: A => B): Coyoneda[F, B] = ???

  // ============================================================
  // Exercise 7: Demonstrate the Yoneda optimization
  // Multiple maps on Yoneda fuse into a single map (function composition).
  // Implement a function that maps three functions over a Yoneda,
  // then lowers to F[A]. The result should only traverse the structure once.
  // ============================================================
  // TODO: Apply three maps via Yoneda (fused into one traversal)
  def yonedaOptimize[F[_]: Functor](fa: F[Int]): F[String] = ???

  // ============================================================
  // Exercise 8: Implement a Representable functor concept
  // A functor F is representable if F[A] ≅ (Rep => A) for some type Rep.
  // Implement tabulate and index for a pair (A, A) represented by Boolean.
  // ============================================================
  case class Pair[A](first: A, second: A)

  // TODO: tabulate: (Boolean => A) => Pair[A]
  def tabulate[A](f: Boolean => A): Pair[A] = ???

  // TODO: index: Pair[A] => Boolean => A
  def index[A](pair: Pair[A]): Boolean => A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: toYoneda
    val yList = toYoneda(List(1, 2, 3))
    assert(yList.run(_.toString) == List("1", "2", "3"))
    println("Exercise 1 passed: toYoneda")

    // Exercise 2: fromYoneda
    val backToList = fromYoneda(yList)
    assert(backToList == List(1, 2, 3))
    println("Exercise 2 passed: fromYoneda")

    // Exercise 3: yonedaMap without Functor
    val yMapped = yonedaMap(yList)(_ * 10)
    assert(fromYoneda(yMapped) == List(10, 20, 30))
    println("Exercise 3 passed: Yoneda map without Functor")

    // Exercise 4: toCoyoneda
    val cy = toCoyoneda(List(1, 2, 3))
    assert(cy.k(cy.fi.asInstanceOf[List[Any]].head.asInstanceOf[cy.Pivot]) == 1)
    println("Exercise 4 passed: toCoyoneda")

    // Exercise 5: fromCoyoneda
    val cyOpt = toCoyoneda(Option(42))
    assert(fromCoyoneda(cyOpt) == Some(42))
    println("Exercise 5 passed: fromCoyoneda")

    // Exercise 6: Coyoneda map without Functor
    val cyMapped = coyonedaMap(toCoyoneda(List(1, 2, 3)))(_ * 10)
    assert(fromCoyoneda(cyMapped) == List(10, 20, 30))
    println("Exercise 6 passed: Coyoneda map without Functor")

    // Exercise 7: Yoneda optimization
    val result = yonedaOptimize(List(1, 2, 3))
    assert(result == List("[2]", "[4]", "[6]"))
    println("Exercise 7 passed: Yoneda optimization")

    // Exercise 8: Representable functor
    val p = tabulate[String](b => if (b) "yes" else "no")
    assert(p == Pair("yes", "no") || p == Pair("no", "yes"))
    val idx = index(Pair(10, 20))
    assert(idx(true) == 10)
    assert(idx(false) == 20)
    println("Exercise 8 passed: Representable functor")

    println("\nAll exercises passed!")
  }
}
