package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP016 - Recursion Schemes: Fix Point Types
 *
 * Recursion schemes separate the recursion pattern from the data.
 * Fix[F] ties the recursive knot: Fix[F] = F[Fix[F]].
 * We can then define generic fold/unfold operations.
 */
object AdvFP016_RecursionSchemes {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  // ============================================================
  // Exercise 1: Implement the Fix point type
  // Fix[F] = F[Fix[F]]  -- ties the recursive knot
  // ============================================================
  // TODO: Implement Fix with unfix
  case class Fix[F[_]](unfix: F[Fix[F]])

  // ============================================================
  // Exercise 2: Define a List-like pattern functor
  // ListF[A, R] = NilF | ConsF(A, R) where R is the recursive position
  // ============================================================
  sealed trait ListF[+A, +R]
  case object NilF extends ListF[Nothing, Nothing]
  case class ConsF[A, R](head: A, tail: R) extends ListF[A, R]

  // TODO: Implement Functor for ListF[A, *] (map over the recursive position R)
  def listFFunctor[A]: Functor[({type L[R] = ListF[A, R]})#L] = ???

  // ============================================================
  // Exercise 3: Convert a List[A] to Fix[ListF[A, *]]
  // ============================================================
  // TODO: Convert List to Fix
  def listToFix[A](list: List[A]): Fix[({type L[R] = ListF[A, R]})#L] = ???

  // ============================================================
  // Exercise 4: Convert Fix[ListF[A, *]] back to List[A]
  // ============================================================
  // TODO: Convert Fix back to List
  def fixToList[A](fix: Fix[({type L[R] = ListF[A, R]})#L]): List[A] = ???

  // ============================================================
  // Exercise 5: Define a Tree pattern functor
  // TreeF[A, R] = LeafF(A) | BranchF(R, R)
  // ============================================================
  sealed trait TreeF[+A, +R]
  case class LeafF[A](value: A) extends TreeF[A, Nothing]
  case class BranchF[R](left: R, right: R) extends TreeF[Nothing, R]

  // TODO: Implement Functor for TreeF[A, *]
  def treeFFunctor[A]: Functor[({type L[R] = TreeF[A, R]})#L] = ???

  // ============================================================
  // Exercise 6: Implement project (embed a recursive structure into Fix)
  // project takes a recursive structure and returns Fix
  // embed takes Fix and returns the recursive structure
  // Implement embed: Fix[F] => F[Fix[F]] (this is just unfix)
  // And project: F[Fix[F]] => Fix[F] (this is just Fix.apply)
  // ============================================================
  // TODO: Implement embed (unwrap one layer of Fix)
  def embed[F[_]](fix: Fix[F]): F[Fix[F]] = ???

  // TODO: Implement project (wrap one layer into Fix)
  def project[F[_]](ff: F[Fix[F]]): Fix[F] = ???

  // ============================================================
  // Exercise 7: Define a natural number pattern functor
  // NatF[R] = ZeroF | SuccF(R)
  // ============================================================
  sealed trait NatF[+R]
  case object ZeroF extends NatF[Nothing]
  case class SuccF[R](pred: R) extends NatF[R]

  // TODO: Implement Functor for NatF
  implicit val natFFunctor: Functor[NatF] = ???

  // TODO: Convert Int to Fix[NatF]
  def intToNat(n: Int): Fix[NatF] = ???

  // TODO: Convert Fix[NatF] to Int
  def natToInt(nat: Fix[NatF]): Int = ???

  // ============================================================
  // Exercise 8: Define an Expression pattern functor
  // ExprF[R] = LitF(Int) | AddF(R, R) | MulF(R, R)
  // This will be used in the catamorphism exercises.
  // ============================================================
  sealed trait ExprF[+R]
  case class LitF(value: Int) extends ExprF[Nothing]
  case class AddF[R](left: R, right: R) extends ExprF[R]
  case class MulF[R](left: R, right: R) extends ExprF[R]

  // TODO: Implement Functor for ExprF
  implicit val exprFFunctor: Functor[ExprF] = ???

  // TODO: Build the expression (2 + 3) * 4 as Fix[ExprF]
  def exampleExpr: Fix[ExprF] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Fix type exists (compile check)
    val fixNil: Fix[({type L[R] = ListF[Int, R]})#L] = Fix[({type L[R] = ListF[Int, R]})#L](NilF)
    println("Exercise 1 passed: Fix type defined")

    // Exercise 2: ListF functor
    val lf = listFFunctor[Int]
    val mapped = lf.map(ConsF(1, "tail"))((s: String) => s.length)
    assert(mapped == ConsF(1, 4))
    println("Exercise 2 passed: ListF functor")

    // Exercise 3: List to Fix
    type IntListF[R] = ListF[Int, R]
    val fixList = listToFix(List(1, 2, 3))
    println("Exercise 3 passed: List to Fix")

    // Exercise 4: Fix to List
    val backToList = fixToList(fixList)
    assert(backToList == List(1, 2, 3))
    println("Exercise 4 passed: Fix to List roundtrip")

    // Exercise 5: TreeF functor
    val tf = treeFFunctor[Int]
    val mappedTree = tf.map(BranchF("left", "right"))((s: String) => s.length)
    assert(mappedTree == BranchF(4, 5))
    println("Exercise 5 passed: TreeF functor")

    // Exercise 6: embed and project
    val fixed = project[NatF](SuccF(Fix[NatF](ZeroF)))
    val unfixed = embed(fixed)
    assert(unfixed.isInstanceOf[SuccF[_]])
    println("Exercise 6 passed: embed and project")

    // Exercise 7: Natural numbers
    val three = intToNat(3)
    assert(natToInt(three) == 3)
    assert(natToInt(intToNat(0)) == 0)
    println("Exercise 7 passed: Natural numbers")

    // Exercise 8: Expression
    val expr = exampleExpr
    // Verify structure: (2 + 3) * 4
    expr.unfix match {
      case MulF(l, r) =>
        assert(r.unfix == LitF(4))
        l.unfix match {
          case AddF(ll, lr) =>
            assert(ll.unfix == LitF(2))
            assert(lr.unfix == LitF(3))
          case _ => assert(false, "Expected AddF")
        }
      case _ => assert(false, "Expected MulF")
    }
    println("Exercise 8 passed: Expression tree")

    println("\nAll exercises passed!")
  }
}
