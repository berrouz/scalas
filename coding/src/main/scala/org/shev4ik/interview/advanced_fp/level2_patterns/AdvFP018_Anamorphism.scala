package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP018 - Anamorphism (Unfold)
 *
 * An anamorphism (ana) generalizes unfolds. Given a coalgebra A => F[A],
 * ana builds up a Fix[F] from a seed. It is the "lens bracket" [( )].
 */
object AdvFP018_Anamorphism {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  case class Fix[F[_]](unfix: F[Fix[F]])

  type Coalgebra[F[_], A] = A => F[A]

  // ============================================================
  // Exercise 1: Implement anamorphism (ana)
  // ana: (A => F[A]) => A => Fix[F]
  // ana(coalg)(seed) = Fix(fmap(ana(coalg))(coalg(seed)))
  // ============================================================
  // TODO: Implement ana
  def ana[F[_]: Functor, A](coalg: Coalgebra[F, A])(seed: A): Fix[F] = ???

  // ============================================================
  // Exercise 2: Use ana to build a list from a range
  // Build List(1, 2, ..., n) using anamorphism.
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

  // Helper to convert Fix list back to List
  def fixToList[A](fix: Fix[({type L[R] = ListF[A, R]})#L]): List[A] = fix.unfix match {
    case NilF => Nil
    case ConsF(h, t) => h :: fixToList(t)
  }

  // TODO: Build a list [1..n] using ana
  def buildRange(n: Int): List[Int] = ???

  // ============================================================
  // Exercise 3: Use ana to generate a stream-like structure
  // Generate the first n natural numbers using a coalgebra.
  // Seed is (current, remaining).
  // ============================================================
  // TODO: Generate first n naturals using ana
  def naturals(n: Int): List[Int] = ???

  // ============================================================
  // Exercise 4: Use ana to generate Fibonacci numbers
  // Build a list of first n Fibonacci numbers.
  // Seed: (a, b, remaining)
  // ============================================================
  // TODO: Generate first n Fibonacci numbers using ana
  def fibonacci(n: Int): List[Int] = ???

  // ============================================================
  // Exercise 5: Use ana to build a binary tree
  // Build a balanced binary tree from a range [lo, hi].
  // ============================================================
  sealed trait TreeF[+A, +R]
  case class LeafF[A](value: A) extends TreeF[A, Nothing]
  case class BranchF[R](left: R, right: R) extends TreeF[Nothing, R]

  implicit def treeFFunctor[A]: Functor[({type L[R] = TreeF[A, R]})#L] =
    new Functor[({type L[R] = TreeF[A, R]})#L] {
      def map[B, C](fa: TreeF[A, B])(f: B => C): TreeF[A, C] = fa match {
        case LeafF(v) => LeafF(v)
        case BranchF(l, r) => BranchF(f(l), f(r))
      }
    }

  // Helper to count leaves in a tree Fix
  def countLeaves[A](fix: Fix[({type L[R] = TreeF[A, R]})#L]): Int = fix.unfix match {
    case LeafF(_) => 1
    case BranchF(l, r) => countLeaves(l) + countLeaves(r)
  }

  // TODO: Build a balanced binary tree with values [lo..hi] at leaves
  def buildTree(lo: Int, hi: Int): Fix[({type L[R] = TreeF[Int, R]})#L] = ???

  // ============================================================
  // Exercise 6: Use ana to build natural numbers from Int
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

  // TODO: Build Fix[NatF] from Int using ana
  def intToNat(n: Int): Fix[NatF] = ???

  // Helper
  def natToInt(nat: Fix[NatF]): Int = nat.unfix match {
    case ZeroF => 0
    case SuccF(p) => 1 + natToInt(p)
  }

  // ============================================================
  // Exercise 7: Use ana to generate a tree from rules
  // Given a function that decides whether to split a node,
  // build a tree by repeated splitting.
  // Rule: if value > 1, split into (value/2, value - value/2); else leaf.
  // ============================================================
  // TODO: Generate tree from splitting rule using ana
  def splitTree(n: Int): Fix[({type L[R] = TreeF[Int, R]})#L] = ???

  // ============================================================
  // Exercise 8: Implement unfold for List (standard library style)
  // unfold: S => Option[(A, S)] => List[A]
  // This is the standard unfold but show its connection to ana.
  // ============================================================
  // TODO: Implement unfold for List
  def unfold[A, S](seed: S)(f: S => Option[(A, S)]): List[A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 is tested via exercises 2-7

    // Exercise 2: Build range
    assert(buildRange(5) == List(1, 2, 3, 4, 5))
    assert(buildRange(0) == Nil)
    println("Exercise 2 passed: Build range via ana")

    // Exercise 3: Naturals
    assert(naturals(5) == List(1, 2, 3, 4, 5))
    assert(naturals(0) == Nil)
    println("Exercise 3 passed: Naturals via ana")

    // Exercise 4: Fibonacci
    assert(fibonacci(7) == List(1, 1, 2, 3, 5, 8, 13))
    assert(fibonacci(1) == List(1))
    println("Exercise 4 passed: Fibonacci via ana")

    // Exercise 5: Build tree
    val tree = buildTree(1, 4)
    assert(countLeaves(tree) == 4)
    println("Exercise 5 passed: Build balanced tree via ana")

    // Exercise 6: Int to Nat
    assert(natToInt(intToNat(5)) == 5)
    assert(natToInt(intToNat(0)) == 0)
    println("Exercise 6 passed: Int to Nat via ana")

    // Exercise 7: Split tree
    val st = splitTree(4)
    assert(countLeaves(st) == 4)
    val st1 = splitTree(1)
    st1.unfix match {
      case LeafF(v) => assert(v == 1)
      case _ => assert(false, "Single node should be a leaf")
    }
    println("Exercise 7 passed: Split tree via ana")

    // Exercise 8: Unfold
    val countdown = unfold(5)(n => if (n > 0) Some((n, n - 1)) else None)
    assert(countdown == List(5, 4, 3, 2, 1))
    println("Exercise 8 passed: List unfold")

    println("\nAll exercises passed!")
  }
}
