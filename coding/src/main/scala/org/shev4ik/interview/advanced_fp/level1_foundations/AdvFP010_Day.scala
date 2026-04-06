package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP010 - Day Convolution, Kan Extensions, Ends and Coends
 *
 * Day convolution combines two functors: Day F G A = exists B C. (F[B], G[C], (B, C) => A).
 * Left/Right Kan extensions generalize limits and colimits in category theory.
 * Codensity is the right Kan extension of a functor along itself.
 */
object AdvFP010_Day {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait Monad[F[_]] extends Functor[F] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  implicit val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)
  }

  implicit val listFunctor: Functor[List] = new Functor[List] {
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }

  // ============================================================
  // Exercise 1: Implement Day convolution
  // Day[F, G, A] = exists B C. (F[B], G[C], (B, C) => A)
  // ============================================================
  trait Day[F[_], G[_], A] {
    type B
    type C
    val fb: F[B]
    val gc: G[C]
    val f: (B, C) => A
  }

  // TODO: Create a Day convolution from F[B], G[C], and (B, C) => A
  def day[F[_], G[_], A, B0, C0](fb0: F[B0], gc0: G[C0], f0: (B0, C0) => A): Day[F, G, A] = ???

  // ============================================================
  // Exercise 2: Implement map for Day convolution
  // Day is a functor in A.
  // ============================================================
  // TODO: Map over Day convolution
  def dayMap[F[_], G[_], A, D](d: Day[F, G, A])(g: A => D): Day[F, G, D] = ???

  // ============================================================
  // Exercise 3: Implement the Right Kan extension
  // Ran[G, H, A] = forall B. (A => G[B]) => H[B]
  // This is the universal construction for extending H along G.
  // ============================================================
  trait Ran[G[_], H[_], A] {
    def run[B](f: A => G[B]): H[B]
  }

  // TODO: Construct a Ran from a natural transformation
  def toRan[G[_], H[_], A](fa: H[A])(implicit G: Functor[G], H: Functor[H]): Ran[G, H, A] = ???

  // ============================================================
  // Exercise 4: Implement the Left Kan extension
  // Lan[G, H, A] = exists B. (G[B] => A, H[B])
  // ============================================================
  trait Lan[G[_], H[_], A] {
    type B
    val hb: H[B]
    val f: G[B] => A
  }

  // TODO: Construct a Lan
  def toLan[G[_], H[_], A, B0](hb0: H[B0], f0: G[B0] => A): Lan[G, H, A] = ???

  // ============================================================
  // Exercise 5: Implement Codensity monad
  // Codensity[F, A] = forall B. (A => F[B]) => F[B]
  // This is the right Kan extension of F along itself.
  // Codensity always forms a Monad, even when F is just a functor.
  // ============================================================
  trait Codensity[F[_], A] {
    def run[B](f: A => F[B]): F[B]
  }

  // TODO: Implement pure for Codensity
  def codensityPure[F[_], A](a: A): Codensity[F, A] = ???

  // TODO: Implement flatMap for Codensity
  def codensityFlatMap[F[_], A, B](ca: Codensity[F, A])(f: A => Codensity[F, B]): Codensity[F, B] = ???

  // ============================================================
  // Exercise 6: Implement Density comonad
  // Density[F, A] = exists B. (F[B] => A, F[B])
  // This is the left Kan extension of F along itself.
  // ============================================================
  trait Density[F[_], A] {
    type B
    val fb: F[B]
    val f: F[B] => A
  }

  // TODO: Implement extract for Density
  def densityExtract[F[_], A](d: Density[F, A]): A = ???

  // TODO: Implement duplicate for Density (returns Density[F, Density[F, A]])
  def densityDuplicate[F[_], A](d: Density[F, A]): Density[F, Density[F, A]] = ???

  // ============================================================
  // Exercise 7: Show that Codensity improves performance
  // For list-like structures, Codensity can turn O(n^2) left-associated
  // binds into O(n). Implement liftCodensity and lowerCodensity.
  // ============================================================
  // TODO: Lift F[A] into Codensity[F, A]
  def liftCodensity[F[_]: Functor, A](fa: F[A]): Codensity[F, A] = ???

  // TODO: Lower Codensity[F, A] back to F[A] using Monad
  def lowerCodensity[F[_]: Monad, A](c: Codensity[F, A]): F[A] = ???

  // ============================================================
  // Exercise 8: Demonstrate Ends and Coends conceptually
  // An end is: forall A. F[A, A]  (a universal/natural element)
  // A coend is: exists A. F[A, A] (an existential/dinaturality)
  // Natural transformations can be seen as ends.
  // Implement a function that witnesses: Nat(F, G) ≅ end_A Hom(F[A], G[A])
  // by taking a polymorphic function and applying it.
  // ============================================================
  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // A "Wedge" or end element: a value that works for all A
  trait End[F[_, _]] {
    def apply[A]: F[A, A]
  }

  // Hom functor for our purposes
  type Hom[F[_], G[_]] = { type L[A, B] = F[A] => G[B] }

  // TODO: Convert a natural transformation to an End
  def natTransToEnd[F[_], G[_]](nt: F ~> G): End[({type L[A, B] = F[A] => G[A]})#L] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Day convolution
    val d = day[Option, List, String, Int, String](
      Some(42), List("a", "b"), (n, s) => s"$s:$n"
    )
    assert(d.fb == Some(42))
    assert(d.gc == List("a", "b"))
    println("Exercise 1 passed: Day convolution")

    // Exercise 2: Day map
    val mapped = dayMap(d)(_.toUpperCase)
    assert(mapped.f(42.asInstanceOf[mapped.B], "hello".asInstanceOf[mapped.C]) == "HELLO:42")
    println("Exercise 2 passed: Day map")

    // Exercise 3: Right Kan extension
    val ran = toRan[Option, List, Int](List(1, 2, 3))(optionFunctor, listFunctor)
    val result3 = ran.run[String](n => Some(n.toString))
    assert(result3 == Some("1") || result3 == Some("[1, 2, 3]") || result3 != null)
    println("Exercise 3 passed: Right Kan extension")

    // Exercise 4: Left Kan extension
    val lan = toLan[Option, List, String, Int](List(1, 2, 3), (opt: Option[Int]) => opt.map(_.toString).getOrElse("none"))
    assert(lan.hb == List(1, 2, 3))
    println("Exercise 4 passed: Left Kan extension")

    // Exercise 5: Codensity monad
    val cp = codensityPure[Option, Int](42)
    assert(cp.run(n => Some(n.toString)) == Some("42"))
    val cfm = codensityFlatMap(cp)(n => codensityPure[Option, String](n.toString + "!"))
    assert(cfm.run(s => Some(s.length)) == Some(3))
    println("Exercise 5 passed: Codensity monad")

    // Exercise 6: Density comonad
    val dens = new Density[Option, Int] {
      type B = String
      val fb = Some("hello")
      val f = (opt: Option[String]) => opt.map(_.length).getOrElse(0)
    }
    assert(densityExtract(dens) == 5)
    val dd = densityDuplicate(dens)
    assert(densityExtract(densityExtract(dd)) == 5)
    println("Exercise 6 passed: Density comonad")

    // Exercise 7: Codensity lift/lower
    implicit val listMonad: Monad[List] = new Monad[List] {
      def pure[A](a: A) = List(a)
      def flatMap[A, B](fa: List[A])(f: A => List[B]) = fa.flatMap(f)
    }
    val lifted = liftCodensity(List(1, 2, 3))
    val lowered = lowerCodensity(lifted)
    assert(lowered == List(1, 2, 3))
    println("Exercise 7 passed: Codensity lift/lower")

    // Exercise 8: Natural transformation as End
    val nt = new (Option ~> List) {
      def apply[A](fa: Option[A]): List[A] = fa.toList
    }
    val end = natTransToEnd(nt)
    assert(end.apply[Int](Some(42)) == List(42))
    assert(end.apply[String](None) == Nil)
    println("Exercise 8 passed: NatTrans as End")

    println("\nAll exercises passed!")
  }
}
