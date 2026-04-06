package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP019 - Hylomorphism
 *
 * A hylomorphism (hylo) = ana followed by cata (unfold then fold).
 * hylo never actually builds the intermediate Fix structure - it fuses
 * the unfold and fold into a single pass: hylo(alg, coalg)(seed).
 */
object AdvFP019_Hylomorphism {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  type Algebra[F[_], A] = F[A] => A
  type Coalgebra[F[_], A] = A => F[A]

  // ============================================================
  // Exercise 1: Implement hylomorphism (hylo)
  // hylo(alg, coalg)(seed) = alg(fmap(hylo(alg, coalg))(coalg(seed)))
  // This is ana then cata but without building the intermediate Fix.
  // ============================================================
  // TODO: Implement hylo
  def hylo[F[_]: Functor, A, B](alg: Algebra[F, B], coalg: Coalgebra[F, A])(seed: A): B = ???

  // ============================================================
  // Exercise 2: Implement factorial as a hylomorphism
  // Coalgebra: n => if n==0 then ZeroF else SuccF(n-1)  (unfold to NatF)
  // Algebra: ZeroF => 1, SuccF((n, acc)) => n * acc  (fold with multiplication)
  // Hint: use a pair (Int, Int) carrier for the algebra side
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

  // We use a different approach: use ListF to track the values
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

  // TODO: Implement factorial using hylo
  def factorial(n: Int): Int = ???

  // ============================================================
  // Exercise 3: Implement mergesort as a hylomorphism
  // Coalgebra: split list into two halves (unfold into a tree)
  // Algebra: merge sorted halves (fold the tree)
  // ============================================================
  sealed trait TreeF[+A, +R]
  case class LeafF[A](value: A) extends TreeF[A, Nothing]
  case class BranchF[R](left: R, right: R) extends TreeF[Nothing, R]
  case class EmptyF() extends TreeF[Nothing, Nothing]

  implicit def treeFFunctor[A]: Functor[({type L[R] = TreeF[A, R]})#L] =
    new Functor[({type L[R] = TreeF[A, R]})#L] {
      def map[B, C](fa: TreeF[A, B])(f: B => C): TreeF[A, C] = fa match {
        case LeafF(v) => LeafF(v)
        case BranchF(l, r) => BranchF(f(l), f(r))
        case EmptyF() => EmptyF()
      }
    }

  // TODO: Implement mergesort using hylo
  def mergesort(list: List[Int]): List[Int] = ???

  // ============================================================
  // Exercise 4: Implement a "refold" that's equivalent to hylo
  // Show that refold(alg, coalg) == cata(alg) . ana(coalg)
  // by implementing both sides and verifying they agree.
  // ============================================================
  case class Fix[F[_]](unfix: F[Fix[F]])

  def cata[F[_]: Functor, A](alg: Algebra[F, A])(fix: Fix[F]): A = {
    alg(implicitly[Functor[F]].map(fix.unfix)(cata(alg)))
  }

  def ana[F[_]: Functor, A](coalg: Coalgebra[F, A])(seed: A): Fix[F] = {
    Fix(implicitly[Functor[F]].map(coalg(seed))(ana(coalg)))
  }

  // TODO: Implement refold and show it equals hylo
  def refold[F[_]: Functor, A, B](alg: Algebra[F, B], coalg: Coalgebra[F, A])(seed: A): B = ???

  // ============================================================
  // Exercise 5: Compute the sum of 1..n using hylo
  // Unfold n into a list [n, n-1, ..., 1], fold by summing.
  // ============================================================
  // TODO: Sum 1..n using hylo
  def sumRange(n: Int): Int = ???

  // ============================================================
  // Exercise 6: Implement Collatz sequence length using hylo
  // Coalgebra: if n==1 then NilF else ConsF(n, next(n))
  //   where next(n) = if even then n/2 else 3n+1
  // Algebra: count steps
  // ============================================================
  // TODO: Compute Collatz sequence length using hylo
  def collatzLength(n: Int): Int = ???

  // ============================================================
  // Exercise 7: Implement fibonacci using hylo
  // Unfold into a tree structure, fold to compute values.
  // ============================================================
  sealed trait FibF[+R]
  case class FibBase(n: Int) extends FibF[Nothing]
  case class FibRec[R](left: R, right: R) extends FibF[R]

  implicit val fibFFunctor: Functor[FibF] = new Functor[FibF] {
    def map[A, B](fa: FibF[A])(f: A => B): FibF[B] = fa match {
      case FibBase(n) => FibBase(n)
      case FibRec(l, r) => FibRec(f(l), f(r))
    }
  }

  // TODO: Compute nth Fibonacci number using hylo
  // WARNING: This is exponential without memoization - keep n small
  def fib(n: Int): Int = ???

  // ============================================================
  // Exercise 8: Implement tower of Hanoi move count using hylo
  // Unfold: n disks => move n-1 to temp, move 1, move n-1 from temp
  // Fold: count total moves
  // This should give 2^n - 1.
  // ============================================================
  sealed trait HanoiF[+R]
  case object OneMove extends HanoiF[Nothing]
  case class Recurse[R](first: R, second: R) extends HanoiF[R]

  implicit val hanoiFFunctor: Functor[HanoiF] = new Functor[HanoiF] {
    def map[A, B](fa: HanoiF[A])(f: A => B): HanoiF[B] = fa match {
      case OneMove => OneMove
      case Recurse(a, b) => Recurse(f(a), f(b))
    }
  }

  // TODO: Count Hanoi moves using hylo
  def hanoiMoves(n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 is tested through the other exercises

    // Exercise 2: Factorial
    assert(factorial(0) == 1)
    assert(factorial(5) == 120)
    assert(factorial(10) == 3628800)
    println("Exercise 2 passed: Factorial via hylo")

    // Exercise 3: Mergesort
    assert(mergesort(List(3, 1, 4, 1, 5, 9, 2, 6)) == List(1, 1, 2, 3, 4, 5, 6, 9))
    assert(mergesort(Nil) == Nil)
    assert(mergesort(List(1)) == List(1))
    println("Exercise 3 passed: Mergesort via hylo")

    // Exercise 4: Refold
    val coalg: Coalgebra[NatF, Int] = n => if (n <= 0) ZeroF else SuccF(n - 1)
    val alg: Algebra[NatF, Int] = { case ZeroF => 0; case SuccF(n) => n + 1 }
    assert(refold(alg, coalg)(5) == hylo(alg, coalg)(5))
    println("Exercise 4 passed: Refold equals hylo")

    // Exercise 5: Sum range
    assert(sumRange(10) == 55)
    assert(sumRange(0) == 0)
    println("Exercise 5 passed: Sum range via hylo")

    // Exercise 6: Collatz
    assert(collatzLength(1) == 0)
    assert(collatzLength(2) == 1)
    assert(collatzLength(6) == 8)
    println("Exercise 6 passed: Collatz length via hylo")

    // Exercise 7: Fibonacci
    assert(fib(0) == 0)
    assert(fib(1) == 1)
    assert(fib(10) == 55)
    println("Exercise 7 passed: Fibonacci via hylo")

    // Exercise 8: Hanoi
    assert(hanoiMoves(1) == 1)
    assert(hanoiMoves(3) == 7)
    assert(hanoiMoves(10) == 1023)
    println("Exercise 8 passed: Hanoi moves via hylo")

    println("\nAll exercises passed!")
  }
}
