package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP030 - Kan Extensions
 *
 * Left and Right Kan extensions are universal constructions in category theory.
 * Ran[G, H, A] = forall B. (A => G[B]) => H[B]  (right Kan extension)
 * Lan[G, H, A] = exists B. (G[B] => A, H[B])     (left Kan extension)
 * Codensity[F, A] = Ran[F, F, A] is always a monad.
 */
object AdvFP030_KanExtension {

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
  // Exercise 1: Implement the Right Kan Extension (Ran)
  // Ran[G, H, A] = forall B. (A => G[B]) => H[B]
  // ============================================================
  trait Ran[G[_], H[_], A] {
    def run[B](f: A => G[B]): H[B]
  }

  // TODO: Implement Functor for Ran[G, H, *]
  def ranFunctor[G[_], H[_]]: Functor[({type L[A] = Ran[G, H, A]})#L] = ???

  // ============================================================
  // Exercise 2: Implement the Left Kan Extension (Lan)
  // Lan[G, H, A] = exists B. (G[B] => A, H[B])
  // ============================================================
  trait Lan[G[_], H[_], A] {
    type Pivot
    val hb: H[Pivot]
    val f: G[Pivot] => A
  }

  // TODO: Implement Functor for Lan[G, H, *]
  def lanFunctor[G[_], H[_]]: Functor[({type L[A] = Lan[G, H, A]})#L] = ???

  // ============================================================
  // Exercise 3: Implement Codensity (Ran[F, F, *])
  // Codensity always forms a Monad, even when F is not.
  // ============================================================
  trait Codensity[F[_], A] {
    def run[B](f: A => F[B]): F[B]
  }

  // TODO: Implement pure for Codensity
  def codensityPure[F[_], A](a: A): Codensity[F, A] = ???

  // TODO: Implement flatMap for Codensity
  def codensityFlatMap[F[_], A, B](ca: Codensity[F, A])(f: A => Codensity[F, B]): Codensity[F, B] = ???

  // ============================================================
  // Exercise 4: Implement Density (Lan[F, F, *])
  // Density always forms a Comonad.
  // ============================================================
  trait Density[F[_], A] {
    type Pivot
    val fb: F[Pivot]
    val f: F[Pivot] => A
  }

  // TODO: Implement extract for Density
  def densityExtract[F[_], A](d: Density[F, A]): A = ???

  // TODO: Implement coflatMap for Density
  def densityCoflatMap[F[_], A, B](d: Density[F, A])(g: Density[F, A] => B): Density[F, B] = ???

  // ============================================================
  // Exercise 5: Show colimit as Left Kan Extension
  // A colimit is the Left Kan Extension along the terminal functor.
  // For lists, the colimit over a diagram is just the concatenation.
  // Implement: given a list of functorial values, compute the "colimit."
  // ============================================================
  // TODO: Compute colimit (flatten/join) using Lan concept
  def colimit[A](diagrams: List[List[A]]): List[A] = ???

  // ============================================================
  // Exercise 6: Show limit as Right Kan Extension
  // A limit is the Right Kan Extension along the terminal functor.
  // For option, the limit is the intersection (all must be present).
  // ============================================================
  // TODO: Compute limit (all or nothing) using Ran concept
  def limit[A](values: List[Option[A]]): Option[List[A]] = ???

  // ============================================================
  // Exercise 7: Lift and lower Codensity
  // liftCodensity: F[A] => Codensity[F, A]
  // lowerCodensity: Codensity[F, A] => F[A] (needs Monad[F])
  // ============================================================
  // TODO: Lift into Codensity
  def liftCodensity[F[_]: Functor, A](fa: F[A]): Codensity[F, A] = ???

  // TODO: Lower from Codensity (needs Monad)
  def lowerCodensity[F[_]: Monad, A](c: Codensity[F, A]): F[A] = ???

  // ============================================================
  // Exercise 8: Demonstrate Codensity improving performance
  // Left-associated flatMap chains on List are O(n^2).
  // Codensity reassociates to the right, making it O(n).
  // Implement a function that builds a list using Codensity
  // to avoid the quadratic behavior.
  // ============================================================
  implicit val listMonad: Monad[List] = new Monad[List] {
    def pure[A](a: A) = List(a)
    def flatMap[A, B](fa: List[A])(f: A => List[B]) = fa.flatMap(f)
  }

  // TODO: Build [1..n] using Codensity to right-associate
  def buildListViaCodensity(n: Int): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Ran Functor
    val rf = ranFunctor[Option, List]
    val ran = new Ran[Option, List, Int] {
      def run[B](f: Int => Option[B]): List[B] = f(42).toList
    }
    val mapped = rf.map(ran)(_ + 1)
    assert(mapped.run(n => Some(n.toString)) == List("43"))
    println("Exercise 1 passed: Ran Functor")

    // Exercise 2: Lan Functor
    val lf = lanFunctor[Option, List]
    val lan = new Lan[Option, List, String] {
      type Pivot = Int
      val hb = List(1, 2, 3)
      val f = (opt: Option[Int]) => opt.map(_.toString).getOrElse("none")
    }
    val mappedLan = lf.map(lan)(_ + "!")
    assert(mappedLan.f(Some(42).asInstanceOf[Option[mappedLan.Pivot]]) == "42!")
    println("Exercise 2 passed: Lan Functor")

    // Exercise 3: Codensity Monad
    val cp = codensityPure[Option, Int](42)
    assert(cp.run(n => Some(n.toString)) == Some("42"))
    val cm = codensityFlatMap(cp)(n => codensityPure[Option, String](n.toString + "!"))
    assert(cm.run(s => Some(s.length)) == Some(3))
    println("Exercise 3 passed: Codensity Monad")

    // Exercise 4: Density Comonad
    val dens = new Density[List, Int] {
      type Pivot = String
      val fb = List("hello", "world")
      val f = (xs: List[String]) => xs.map(_.length).sum
    }
    assert(densityExtract(dens) == 10)
    val extended = densityCoflatMap(dens)(d => densityExtract(d).toString)
    assert(densityExtract(extended) == "10")
    println("Exercise 4 passed: Density Comonad")

    // Exercise 5: Colimit
    assert(colimit(List(List(1, 2), List(3), List(4, 5))) == List(1, 2, 3, 4, 5))
    println("Exercise 5 passed: Colimit")

    // Exercise 6: Limit
    assert(limit(List(Some(1), Some(2), Some(3))) == Some(List(1, 2, 3)))
    assert(limit(List(Some(1), None, Some(3))) == None)
    println("Exercise 6 passed: Limit")

    // Exercise 7: Lift and lower
    val lifted = liftCodensity(List(1, 2, 3))
    val lowered = lowerCodensity(lifted)
    assert(lowered == List(1, 2, 3))
    println("Exercise 7 passed: Codensity lift/lower")

    // Exercise 8: Performance via Codensity
    val result = buildListViaCodensity(100)
    assert(result == (1 to 100).toList)
    println("Exercise 8 passed: Codensity performance")

    println("\nAll exercises passed!")
  }
}
