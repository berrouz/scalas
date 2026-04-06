package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP031 - Finally Tagless / Initial vs Final Encoding
 *
 * Initial encoding: programs as data (ADTs) - extensible in interpreters
 * Final encoding: programs as functions (typeclasses) - extensible in operations
 * Church/Boehm-Berarducci encoding bridges the two.
 */
object AdvFP031_FinallyTagless {

  // ============================================================
  // Exercise 1: Initial encoding of a simple expression language
  // Define an ADT for Lit, Add, Mul and an eval function.
  // ============================================================
  sealed trait ExprI
  case class LitI(value: Int) extends ExprI
  case class AddI(left: ExprI, right: ExprI) extends ExprI
  case class MulI(left: ExprI, right: ExprI) extends ExprI

  // TODO: Implement eval for initial encoding
  def evalI(expr: ExprI): Int = ???

  // ============================================================
  // Exercise 2: Final encoding of the same expression language
  // Expressions are represented as methods in a typeclass.
  // ============================================================
  trait ExprF[A] {
    def lit(value: Int): A
    def add(left: A, right: A): A
    def mul(left: A, right: A): A
  }

  // TODO: Implement the evaluator interpretation
  val evalInterp: ExprF[Int] = ???

  // TODO: Implement the pretty-printer interpretation
  val showInterp: ExprF[String] = ???

  // ============================================================
  // Exercise 3: Write an expression in final style
  // Write (2 + 3) * 4 using the ExprF typeclass.
  // ============================================================
  // TODO: Write the expression polymorphically
  def expr1[A](implicit E: ExprF[A]): A = ???

  // ============================================================
  // Exercise 4: Church encoding (Boehm-Berarducci)
  // Church encoding of an ADT: forall A. (constructors => A) => A
  // Church-encode the Expr type.
  // ============================================================
  // ChurchExpr = forall A. ExprF[A] => A
  trait ChurchExpr {
    def run[A](implicit E: ExprF[A]): A
  }

  // TODO: Convert initial encoding to Church encoding
  def toChurch(expr: ExprI): ChurchExpr = ???

  // TODO: Convert Church encoding back to initial
  def fromChurch(ce: ChurchExpr): ExprI = ???

  // ============================================================
  // Exercise 5: Scott encoding
  // Scott encoding gives pattern matching: each case directly returns.
  // For Nat: forall A. A => (Nat => A) => A
  // ============================================================
  trait ScottNat {
    def fold[A](zero: A)(succ: ScottNat => A): A
  }

  // TODO: Implement zero and successor in Scott encoding
  val scottZero: ScottNat = ???

  def scottSucc(n: ScottNat): ScottNat = ???

  // TODO: Convert ScottNat to Int
  def scottToInt(n: ScottNat): Int = ???

  // ============================================================
  // Exercise 6: Show extensibility in final encoding
  // Add a new operation (Neg for negation) without modifying ExprF.
  // ============================================================
  trait ExprNeg[A] {
    def neg(a: A): A
  }

  // TODO: Write an expression using both ExprF and ExprNeg
  def exprWithNeg[A](implicit E: ExprF[A], N: ExprNeg[A]): A = ???

  // TODO: Implement ExprNeg for Int
  val negEvalInterp: ExprNeg[Int] = ???

  // ============================================================
  // Exercise 7: Expression Problem
  // Initial: easy to add interpreters, hard to add new operations
  // Final: easy to add new operations, hard to add new interpreters (sort of)
  // Demonstrate by adding a new interpreter for the final encoding.
  // ============================================================
  // TODO: Implement a "size" interpreter (counts nodes)
  val sizeInterp: ExprF[Int] = ???

  // TODO: Implement an "optimize" interpreter that simplifies
  // (e.g., Mul(x, Lit(0)) => Lit(0), Add(x, Lit(0)) => x)
  // Output is ExprI for simplicity.
  val optimizeInterp: ExprF[ExprI] = ???

  // ============================================================
  // Exercise 8: Object Algebras
  // Object algebras are the OOP equivalent of finally tagless.
  // Define an "algebra" as an interface with factory methods.
  // ============================================================
  trait ExprAlgebra[E] {
    def lit(value: Int): E
    def add(left: E, right: E): E
  }

  trait ExprMulAlgebra[E] extends ExprAlgebra[E] {
    def mul(left: E, right: E): E
  }

  // TODO: Implement an object algebra for evaluation
  val evalAlgebra: ExprMulAlgebra[Int] = ???

  // TODO: Write a program using the object algebra
  def algebraProgram[E](alg: ExprMulAlgebra[E]): E = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Initial encoding
    val initial = MulI(AddI(LitI(2), LitI(3)), LitI(4))
    assert(evalI(initial) == 20)
    println("Exercise 1 passed: Initial encoding eval")

    // Exercise 2: Final encoding interpreters
    assert(evalInterp.add(evalInterp.lit(2), evalInterp.lit(3)) == 5)
    assert(showInterp.mul(showInterp.add(showInterp.lit(2), showInterp.lit(3)), showInterp.lit(4)) == "((2 + 3) * 4)")
    println("Exercise 2 passed: Final encoding interpreters")

    // Exercise 3: Polymorphic expression
    assert(expr1(evalInterp) == 20)
    assert(expr1(showInterp) == "((2 + 3) * 4)")
    println("Exercise 3 passed: Polymorphic expression")

    // Exercise 4: Church encoding
    val church = toChurch(initial)
    assert(church.run(evalInterp) == 20)
    assert(church.run(showInterp) == "((2 + 3) * 4)")
    val backToInitial = fromChurch(church)
    assert(evalI(backToInitial) == 20)
    println("Exercise 4 passed: Church encoding roundtrip")

    // Exercise 5: Scott encoding
    assert(scottToInt(scottZero) == 0)
    assert(scottToInt(scottSucc(scottSucc(scottZero))) == 2)
    println("Exercise 5 passed: Scott encoding")

    // Exercise 6: Extensibility
    implicit val ee: ExprF[Int] = evalInterp
    implicit val ne: ExprNeg[Int] = negEvalInterp
    val negResult = exprWithNeg[Int]
    assert(negResult < 0 || negResult >= 0) // just check it compiles and runs
    println("Exercise 6 passed: Extensible final encoding")

    // Exercise 7: Expression problem
    assert(expr1(sizeInterp) > 0)
    val optimized = expr1(optimizeInterp)
    assert(evalI(optimized) == 20)
    println("Exercise 7 passed: New interpreters")

    // Exercise 8: Object algebras
    assert(algebraProgram(evalAlgebra) == 20)
    println("Exercise 8 passed: Object algebras")

    println("\nAll exercises passed!")
  }
}
