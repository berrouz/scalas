package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP038 - Ends and Coends
 *
 * An end is a universal construction: forall A. F[A, A]  (a "natural element").
 * A coend is an existential construction: exists A. F[A, A] (a "dinatural element").
 * Natural transformations are ends: Nat(F, G) = end_A. Hom(F[A], G[A]).
 * The Yoneda lemma is a statement about ends/coends.
 */
object AdvFP038_EndCoend {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // ============================================================
  // Exercise 1: Model an End as a universal (forall) construction
  // End[P] = forall A. P[A, A]
  // A natural transformation is an end: forall A. F[A] => G[A]
  // ============================================================
  trait End[P[_, _]] {
    def apply[A]: P[A, A]
  }

  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // TODO: Show that a natural transformation is an End over Hom
  // Hom[F, G][A, B] = F[A] => G[B], so End[Hom[F,G]] = forall A. F[A] => G[A]
  def natTransAsEnd[F[_], G[_]](nt: F ~> G): End[({type P[A, B] = F[A] => G[A]})#P] = ???

  // ============================================================
  // Exercise 2: Model a Coend as an existential construction
  // Coend[P] = exists A. P[A, A]
  // ============================================================
  trait Coend[P[_, _]] {
    type Witness
    val value: P[Witness, Witness]
  }

  // TODO: Create a Coend value
  def mkCoend[P[_, _], A](pa: P[A, A]): Coend[P] = ???

  // ============================================================
  // Exercise 3: Ninja Yoneda lemma
  // The Yoneda lemma can be stated as:
  // Nat(Hom(A, -), F) ≅ F(A)
  // In terms of ends: end_B. (A => B) => F[B] ≅ F[A]
  // Implement both directions.
  // ============================================================
  // TODO: Forward: F[A] => (forall B. (A => B) => F[B])
  def yonedaForward[F[_]: Functor, A](fa: F[A]): End[({type P[B, C] = (A => B) => F[B]})#P] = ???

  // TODO: Backward: (forall B. (A => B) => F[B]) => F[A]
  def yonedaBackward[F[_], A](end: End[({type P[B, C] = (A => B) => F[B]})#P]): F[A] = ???

  // ============================================================
  // Exercise 4: Yoneda reduction as a coend
  // Coend version: exists B. ((B => A), F[B]) ≅ F[A] (Coyoneda lemma)
  // ============================================================
  trait CoyonedaCoend[F[_], A] {
    type Pivot
    val fb: F[Pivot]
    val k: Pivot => A
  }

  // TODO: Forward: F[A] => exists B. (B => A, F[B])
  def coyonedaForward[F[_], A](fa: F[A]): CoyonedaCoend[F, A] = ???

  // TODO: Backward: exists B. (B => A, F[B]) => F[A] (needs Functor)
  def coyonedaBackward[F[_]: Functor, A](cy: CoyonedaCoend[F, A]): F[A] = ???

  // ============================================================
  // Exercise 5: Parametricity as a free theorem
  // A polymorphic function forall A. A => A must be the identity.
  // Show this by implementing: given (forall A. A => A), it must be id.
  // ============================================================
  trait PolyId {
    def apply[A](a: A): A
  }

  // TODO: The only PolyId is identity. Verify by testing.
  val identityPoly: PolyId = ???

  // TODO: Show that any PolyId must be identity (test with multiple types)
  def verifyParametricity(f: PolyId): Boolean = ???

  // ============================================================
  // Exercise 6: Wedge condition
  // A wedge for a profunctor P[A, B] is a family of elements w[A]: P[A, A]
  // such that for any f: A => B, P.lmap(f)(w[B]) == P.rmap(f)(w[A]).
  // Show this for the Hom profunctor.
  // ============================================================
  trait Profunctor[P[_, _]] {
    def dimap[A, B, C, D](pab: P[A, B])(f: C => A)(g: B => D): P[C, D]
    def lmap[A, B, C](pab: P[A, B])(f: C => A): P[C, B] = dimap(pab)(f)(identity)
    def rmap[A, B, D](pab: P[A, B])(g: B => D): P[A, D] = dimap(pab)(identity[A])(g)
  }

  implicit val fnProfunctor: Profunctor[Function1] = new Profunctor[Function1] {
    def dimap[A, B, C, D](pab: A => B)(f: C => A)(g: B => D): C => D = c => g(pab(f(c)))
  }

  // TODO: Verify wedge condition for identity at type Int
  // For P = Function1, wedge at A is id[A].
  // lmap(f)(id[B]) should equal rmap(f)(id[A]) for f: A => B
  def verifyWedge[A, B](f: A => B, a: A): Boolean = ???

  // ============================================================
  // Exercise 7: Dinaturality
  // A dinatural transformation alpha: P ~> Q is a family alpha[A]: P[A,A] => Q[A,A]
  // satisfying the dinaturality hexagon condition.
  // For the special case P = Hom, Q = Hom, show identity is dinatural.
  // ============================================================
  // TODO: Implement a dinatural transformation from (A => A) to (A => A)
  val dinaturalId: End[({type P[A, B] = (A => A) => (A => A)})#P] = ???

  // ============================================================
  // Exercise 8: Profunctor composition via coend
  // Given profunctors P and Q, their composition is:
  // (P ⊗ Q)[A, C] = coend_B. P[A, B] × Q[B, C]
  // This is an existential: exists B. (P[A, B], Q[B, C])
  // ============================================================
  trait ProfCompose[P[_, _], Q[_, _], A, C] {
    type Mid
    val left: P[A, Mid]
    val right: Q[Mid, C]
  }

  // TODO: Create a profunctor composition
  def profCompose[P[_, _], Q[_, _], A, B, C](p: P[A, B], q: Q[B, C]): ProfCompose[P, Q, A, C] = ???

  // TODO: Compose two Function1 profunctors and extract the result
  def composeFunctions[A, B, C](f: A => B, g: B => C): A => C = ???

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: NatTrans as End
    val optToList = new (Option ~> List) {
      def apply[A](fa: Option[A]): List[A] = fa.toList
    }
    val end = natTransAsEnd(optToList)
    assert(end.apply[Int](Some(42)) == List(42))
    assert(end.apply[String](None) == Nil)
    println("Exercise 1 passed: Natural transformation as End")

    // Exercise 2: Coend
    type PairSelf[A, B] = (A, B)
    val coend = mkCoend[PairSelf, Int]((42, 42))
    assert(coend.value == (42, 42))
    println("Exercise 2 passed: Coend creation")

    // Exercise 3: Ninja Yoneda
    val fwd = yonedaForward[Option, Int](Some(42))
    assert(fwd.apply[String](_.toString) == Some("42"))
    val bwd = yonedaBackward[Option, Int](fwd)
    assert(bwd == Some(42))
    println("Exercise 3 passed: Ninja Yoneda lemma")

    // Exercise 4: Coyoneda as coend
    val cyFwd = coyonedaForward[List, Int](List(1, 2, 3))
    val cyBwd = coyonedaBackward[List, Int](cyFwd)
    assert(cyBwd == List(1, 2, 3))
    println("Exercise 4 passed: Coyoneda as coend")

    // Exercise 5: Parametricity
    assert(identityPoly.apply(42) == 42)
    assert(identityPoly.apply("hello") == "hello")
    assert(verifyParametricity(identityPoly))
    println("Exercise 5 passed: Parametricity")

    // Exercise 6: Wedge condition
    val f: Int => String = _.toString
    assert(verifyWedge(f, 42))
    println("Exercise 6 passed: Wedge condition")

    // Exercise 7: Dinaturality
    val di = dinaturalId
    val incInt: Int => Int = _ + 1
    assert(di.apply[Int](incInt)(5) == incInt(5))
    println("Exercise 7 passed: Dinatural transformation")

    // Exercise 8: Profunctor composition via coend
    val pc = profCompose[Function1, Function1, String, Int, Boolean](_.length, _ > 3)
    val composed = composeFunctions[String, Int, Boolean](_.length, _ > 3)
    assert(composed("hello") == true)
    assert(composed("hi") == false)
    println("Exercise 8 passed: Profunctor composition via coend")

    println("\nAll exercises passed!")
  }
}
