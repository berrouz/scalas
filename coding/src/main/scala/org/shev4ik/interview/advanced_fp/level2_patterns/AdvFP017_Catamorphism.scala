package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP017 - Catamorphism (Fold)
 *
 * A catamorphism (cata) generalizes folds. Given an algebra F[A] => A,
 * cata recursively collapses Fix[F] to A. It is the "banana bracket" (| |).
 */
object AdvFP017_Catamorphism {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  case class Fix[F[_]](unfix: F[Fix[F]])

  // An Algebra maps one layer to a result
  type Algebra[F[_], A] = F[A] => A

  // ============================================================
  // Exercise 1: Implement catamorphism (cata)
  // cata: (F[A] => A) => Fix[F] => A
  // cata(alg)(fix) = alg(fmap(cata(alg))(fix.unfix))
  // ============================================================
  // TODO: Implement cata
  def cata[F[_]: Functor, A](alg: Algebra[F, A])(fix: Fix[F]): A = ???

  // ============================================================
  // Exercise 2: Use cata to sum a list
  // ListF[A, R] = NilF | ConsF(A, R)
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

  // TODO: Write an algebra that sums integers and use cata
  def sumList(list: List[Int]): Int = ???

  // ============================================================
  // Exercise 3: Use cata to compute the length of a list
  // ============================================================
  // TODO: Write a length algebra and use cata
  def lengthList[A](list: List[A]): Int = ???

  // ============================================================
  // Exercise 4: Evaluate an expression tree using cata
  // ============================================================
  sealed trait ExprF[+R]
  case class LitF(value: Int) extends ExprF[Nothing]
  case class AddF[R](left: R, right: R) extends ExprF[R]
  case class MulF[R](left: R, right: R) extends ExprF[R]

  implicit val exprFFunctor: Functor[ExprF] = new Functor[ExprF] {
    def map[A, B](fa: ExprF[A])(f: A => B): ExprF[B] = fa match {
      case LitF(v) => LitF(v)
      case AddF(l, r) => AddF(f(l), f(r))
      case MulF(l, r) => MulF(f(l), f(r))
    }
  }

  // TODO: Write an evaluation algebra and use cata to evaluate expressions
  def evalExpr(expr: Fix[ExprF]): Int = ???

  // ============================================================
  // Exercise 5: Use cata to pretty-print an expression tree
  // LitF(n) => n.toString, AddF => "(l + r)", MulF => "(l * r)"
  // ============================================================
  // TODO: Write a show algebra
  def showExpr(expr: Fix[ExprF]): String = ???

  // ============================================================
  // Exercise 6: Use cata on natural numbers
  // NatF[R] = ZeroF | SuccF(R)
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
    if (n <= 0) Fix[NatF](ZeroF)
    else Fix[NatF](SuccF(intToNat(n - 1)))

  // TODO: Use cata to convert Fix[NatF] to Int
  def natToInt(nat: Fix[NatF]): Int = ???

  // TODO: Use cata to compute factorial
  // Hint: The algebra returns (n, n!) pairs
  def factorial(nat: Fix[NatF]): Int = ???

  // ============================================================
  // Exercise 7: Use cata on a binary tree
  // TreeF[A, R] = LeafF(A) | BranchF(R, R)
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

  // TODO: Use cata to compute the depth of a binary tree
  def treeDepth[A](tree: Fix[({type L[R] = TreeF[A, R]})#L]): Int = ???

  // ============================================================
  // Exercise 8: Implement the "banana bracket" notation concept
  // In Meijer et al., cata is written (| alg |) (banana brackets).
  // Implement a helper that makes building catamorphisms ergonomic.
  // Build an algebra combinator: given two algebras for the same functor
  // but different result types, produce an algebra for the product type.
  // ============================================================
  // TODO: Product of two algebras: run both in parallel
  def productAlgebra[F[_]: Functor, A, B](
    algA: Algebra[F, A],
    algB: Algebra[F, B]
  ): Algebra[F, (A, B)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 is tested via exercises 2-7

    // Exercise 2: Sum list
    assert(sumList(List(1, 2, 3, 4)) == 10)
    assert(sumList(Nil) == 0)
    println("Exercise 2 passed: Sum list via cata")

    // Exercise 3: Length list
    assert(lengthList(List("a", "b", "c")) == 3)
    assert(lengthList(Nil) == 0)
    println("Exercise 3 passed: Length via cata")

    // Exercise 4: Eval expression
    // (2 + 3) * 4 = 20
    val expr = Fix[ExprF](MulF(
      Fix[ExprF](AddF(Fix[ExprF](LitF(2)), Fix[ExprF](LitF(3)))),
      Fix[ExprF](LitF(4))
    ))
    assert(evalExpr(expr) == 20)
    println("Exercise 4 passed: Eval expression via cata")

    // Exercise 5: Show expression
    assert(showExpr(expr) == "((2 + 3) * 4)")
    println("Exercise 5 passed: Show expression via cata")

    // Exercise 6: Nat operations
    assert(natToInt(intToNat(5)) == 5)
    assert(factorial(intToNat(5)) == 120)
    assert(factorial(intToNat(0)) == 1)
    println("Exercise 6 passed: Nat cata operations")

    // Exercise 7: Tree depth
    type IntTreeF[R] = TreeF[Int, R]
    val tree = Fix[IntTreeF](BranchF(
      Fix[IntTreeF](BranchF(
        Fix[IntTreeF](LeafF(1)),
        Fix[IntTreeF](LeafF(2))
      )),
      Fix[IntTreeF](LeafF(3))
    ))
    assert(treeDepth(tree) == 2)
    println("Exercise 7 passed: Tree depth via cata")

    // Exercise 8: Product algebra
    val sumAlg: Algebra[({type L[R] = ListF[Int, R]})#L, Int] = {
      case NilF => 0
      case ConsF(h, t) => h + t
    }
    val lenAlg: Algebra[({type L[R] = ListF[Int, R]})#L, Int] = {
      case NilF => 0
      case ConsF(_, t) => 1 + t
    }
    val prodAlg = productAlgebra[({type L[R] = ListF[Int, R]})#L, Int, Int](sumAlg, lenAlg)
    val fixList = listToFix(List(10, 20, 30))
    val (sum, len) = cata[({type L[R] = ListF[Int, R]})#L, (Int, Int)](prodAlg)(fixList)
    assert(sum == 60 && len == 3)
    println("Exercise 8 passed: Product algebra")

    println("\nAll exercises passed!")
  }
}
