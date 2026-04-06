package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP020 - Paramorphism and Apomorphism
 *
 * A paramorphism (para) is like cata but the algebra also receives the
 * original substructure alongside the recursive result.
 * An apomorphism (apo) is the dual: the coalgebra can short-circuit.
 */
object AdvFP020_Paramorphism {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  case class Fix[F[_]](unfix: F[Fix[F]])

  type Algebra[F[_], A] = F[A] => A
  type RAlgebra[F[_], A] = F[(Fix[F], A)] => A

  // ============================================================
  // Exercise 1: Implement paramorphism (para)
  // para: (F[(Fix[F], A)] => A) => Fix[F] => A
  // The algebra receives both the original sub-tree and the recursive result.
  // ============================================================
  // TODO: Implement para
  def para[F[_]: Functor, A](alg: RAlgebra[F, A])(fix: Fix[F]): A = ???

  // ============================================================
  // Exercise 2: Implement factorial using para on natural numbers
  // The algebra needs access to the predecessor number (n) to multiply by n.
  // ============================================================
  sealed trait NatF[+R]
  case object ZeroF extends NatF[Nothing]
  case class SuccF[R](pred: R) extends NatF[R]

  implicit val natFFunctor: Functor[NatF] = new Functor[NatF] {
    def map[A, B](fa: NatF[A])(f: A => B): NatF[B] = fa match {
      case ZeroF => ZeroF
      case SuccF(p) => SuccF(f(p))
    }
  }

  def intToNat(n: Int): Fix[NatF] =
    if (n <= 0) Fix[NatF](ZeroF) else Fix[NatF](SuccF(intToNat(n - 1)))

  def natToInt(nat: Fix[NatF]): Int = nat.unfix match {
    case ZeroF => 0
    case SuccF(p) => 1 + natToInt(p)
  }

  // TODO: Implement factorial using para
  def factorial(n: Int): Int = ???

  // ============================================================
  // Exercise 3: Implement 'tails' using para on lists
  // tails([1,2,3]) = [[1,2,3], [2,3], [3], []]
  // Para gives access to the original tail substructure.
  // ============================================================
  sealed trait ListF[+A, +R]
  case object NilF extends ListF[Nothing, Nothing]
  case class ConsF[A, R](head: A, tail: R) extends ListF[A, R]

  implicit def listFFunctor[A]: Functor[({type L[R] = ListF[A, R]})#L] =
    new Functor[({type L[R] = ListF[A, R]})#L] {
      def map[B, C](fa: ListF[A, B])(f: B => C): ListF[A, C] = fa match {
        case NilF => NilF
        case ConsF(h, t) => ConsF(h, f(t))
      }
    }

  def listToFix[A](list: List[A]): Fix[({type L[R] = ListF[A, R]})#L] =
    list.foldRight(Fix[({type L[R] = ListF[A, R]})#L](NilF): Fix[({type L[R] = ListF[A, R]})#L]) {
      (a, acc) => Fix[({type L[R] = ListF[A, R]})#L](ConsF(a, acc))
    }

  def fixToList[A](fix: Fix[({type L[R] = ListF[A, R]})#L]): List[A] = fix.unfix match {
    case NilF => Nil
    case ConsF(h, t) => h :: fixToList(t)
  }

  // TODO: Implement tails using para
  def tails[A](list: List[A]): List[List[A]] = ???

  // ============================================================
  // Exercise 4: Implement sliding window using para
  // Take the first n elements using para. The algebra can look at
  // the original structure to decide when to stop.
  // ============================================================
  // TODO: Take first n elements using para
  def takeN[A](list: List[A], n: Int): List[A] = ???

  // ============================================================
  // Exercise 5: Implement apomorphism (apo) - dual of para
  // apo: (A => F[Either[Fix[F], A]]) => A => Fix[F]
  // The coalgebra can either provide a final sub-tree (Left) or continue (Right).
  // ============================================================
  type RCoalgebra[F[_], A] = A => F[Either[Fix[F], A]]

  // TODO: Implement apo
  def apo[F[_]: Functor, A](coalg: RCoalgebra[F, A])(seed: A): Fix[F] = ???

  // ============================================================
  // Exercise 6: Use apo to build a list that stops early
  // Build [n, n-1, ..., 1] but if n > 5, short-circuit by inserting
  // a pre-built suffix [99].
  // ============================================================
  // TODO: Build list with early termination using apo
  def buildWithShortCircuit(n: Int): List[Int] = ???

  // ============================================================
  // Exercise 7: Implement mutual recursion using even/odd check
  // This demonstrates the concept of mutual recursion schemes.
  // Implement isEven and isOdd that call each other.
  // ============================================================
  // TODO: Implement mutually recursive isEven/isOdd
  def isEven(n: Int): Boolean = ???
  def isOdd(n: Int): Boolean = ???

  // ============================================================
  // Exercise 8: Implement an Elgot algebra
  // An Elgot algebra combines aspects of cata and ana.
  // elgot: (F[B] => B, A => Either[B, F[A]]) => A => B
  // If the coalgebra returns Left(b), short-circuit with b.
  // If it returns Right(fa), continue recursing.
  // ============================================================
  // TODO: Implement Elgot algebra
  def elgot[F[_]: Functor, A, B](alg: Algebra[F, B], coalg: A => Either[B, F[A]])(seed: A): B = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2: Factorial via para
    assert(factorial(0) == 1)
    assert(factorial(5) == 120)
    println("Exercise 2 passed: Factorial via para")

    // Exercise 3: Tails via para
    assert(tails(List(1, 2, 3)) == List(List(1, 2, 3), List(2, 3), List(3), Nil))
    assert(tails(Nil: List[Int]) == List(Nil))
    println("Exercise 3 passed: Tails via para")

    // Exercise 4: TakeN via para
    assert(takeN(List(1, 2, 3, 4, 5), 3) == List(1, 2, 3))
    assert(takeN(List(1, 2), 5) == List(1, 2))
    assert(takeN(Nil: List[Int], 3) == Nil)
    println("Exercise 4 passed: TakeN via para")

    // Exercise 5 & 6: Apo with short-circuit
    assert(buildWithShortCircuit(3) == List(3, 2, 1))
    val result = buildWithShortCircuit(7)
    assert(result.head == 7)
    assert(result.last == 99)
    println("Exercise 5-6 passed: Apo with short-circuit")

    // Exercise 7: Mutual recursion
    assert(isEven(0) == true)
    assert(isEven(4) == true)
    assert(isOdd(3) == true)
    assert(isOdd(4) == false)
    println("Exercise 7 passed: Mutual recursion")

    // Exercise 8: Elgot algebra
    // Use Elgot to implement safe division that short-circuits on 0
    type IntListF[R] = ListF[Int, R]
    val sumAlg: Algebra[({type L[R] = ListF[Int, R]})#L, Int] = {
      case NilF => 0
      case ConsF(h, t) => h + t
    }
    // Coalgebra that builds [n, n-1, ...] but short-circuits at negative
    val coalg: Int => Either[Int, ListF[Int, Int]] = n =>
      if (n < 0) Left(0)
      else if (n == 0) Right(NilF)
      else Right(ConsF(n, n - 1))

    val result8 = elgot[({type L[R] = ListF[Int, R]})#L, Int, Int](sumAlg, coalg)(5)
    assert(result8 == 15) // 5 + 4 + 3 + 2 + 1
    println("Exercise 8 passed: Elgot algebra")

    println("\nAll exercises passed!")
  }
}
