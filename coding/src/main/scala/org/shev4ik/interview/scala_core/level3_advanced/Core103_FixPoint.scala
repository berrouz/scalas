package org.shev4ik.interview.scala_core.level3_advanced

object Core103_FixPoint {

  // Exercise 1: Fix type
  // TODO: Define the Fix point type that ties the recursive knot
  case class Fix[F[_]](unfix: F[Fix[F]])

  // Exercise 2: Define a functor for expressions (without recursion)
  // TODO: Define ExprF[A] - a non-recursive expression functor
  sealed trait ExprF[+A]
  case class NumF(n: Int) extends ExprF[Nothing]
  case class AddF[A](left: A, right: A) extends ExprF[A]
  case class MulF[A](left: A, right: A) extends ExprF[A]

  // Functor instance
  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  implicit val exprFFunctor: Functor[ExprF] = ???

  // Exercise 3: Building expressions with Fix
  // TODO: Create smart constructors for building Fix[ExprF] expressions
  def num(n: Int): Fix[ExprF] = ???
  def add(l: Fix[ExprF], r: Fix[ExprF]): Fix[ExprF] = ???
  def mul(l: Fix[ExprF], r: Fix[ExprF]): Fix[ExprF] = ???

  // Exercise 4: cata (catamorphism) - fold
  // TODO: Implement catamorphism: fold a Fix[F] structure bottom-up
  def cata[F[_]: Functor, A](fix: Fix[F])(algebra: F[A] => A): A = ???

  // Exercise 5: Evaluate expressions using cata
  // TODO: Define an algebra (ExprF[Int] => Int) and use cata to evaluate
  val evalAlgebra: ExprF[Int] => Int = ???

  def eval(expr: Fix[ExprF]): Int = ???

  // Exercise 6: Pretty print using cata
  // TODO: Define a pretty-print algebra (ExprF[String] => String)
  val showAlgebra: ExprF[String] => String = ???

  def show(expr: Fix[ExprF]): String = ???

  // Exercise 7: ana (anamorphism) - unfold
  // TODO: Implement anamorphism: unfold a value into a Fix[F] structure
  def ana[F[_]: Functor, A](a: A)(coalgebra: A => F[A]): Fix[F] = ???

  // TODO: Create a coalgebra that generates a countdown expression
  //       e.g., 3 => Add(Num(3), Add(Num(2), Add(Num(1), Num(0))))
  def countdownCoalgebra(n: Int): ExprF[Int] = ???

  // Exercise 8: Fix for expression trees - hylo (hylomorphism)
  // TODO: Implement hylomorphism = ana followed by cata (unfold then fold)
  //       This avoids building the intermediate Fix structure
  def hylo[F[_]: Functor, A, B](a: A)(coalgebra: A => F[A])(algebra: F[B] => B): B = ???

  def main(args: Array[String]): Unit = {
    // Exercise 3
    val expr1 = add(num(1), num(2))
    assert(expr1 != null)

    // Exercise 4 & 5
    // 1 + 2
    assert(eval(add(num(1), num(2))) == 3)
    // (1 + 2) * 3
    assert(eval(mul(add(num(1), num(2)), num(3))) == 9)
    // 2 * 3 + 4
    assert(eval(add(mul(num(2), num(3)), num(4))) == 10)

    // Exercise 6
    assert(show(num(42)) == "42")
    val s = show(add(num(1), num(2)))
    assert(s == "(1 + 2)")
    assert(show(mul(add(num(1), num(2)), num(3))) == "((1 + 2) * 3)")

    // Exercise 7
    val countdown = ana(3)(countdownCoalgebra)
    val countdownResult = eval(countdown)
    // 3 + 2 + 1 + 0 = 6
    assert(countdownResult == 6)

    // Exercise 8
    val hyloResult = hylo(3)(countdownCoalgebra)(evalAlgebra)
    assert(hyloResult == 6)

    println("All Core103_FixPoint exercises passed!")
  }
}
