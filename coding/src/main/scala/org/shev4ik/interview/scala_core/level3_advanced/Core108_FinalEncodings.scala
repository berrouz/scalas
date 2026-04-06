package org.shev4ik.interview.scala_core.level3_advanced

object Core108_FinalEncodings {

  // Exercise 1: Initial encoding
  // TODO: Define expressions using initial encoding (ADT / data constructors)
  sealed trait InitialExpr
  case class INum(n: Int) extends InitialExpr
  case class IAdd(left: InitialExpr, right: InitialExpr) extends InitialExpr
  case class IMul(left: InitialExpr, right: InitialExpr) extends InitialExpr

  // TODO: Write an evaluator for InitialExpr
  def evalInitial(expr: InitialExpr): Int = ???

  // TODO: Write a pretty printer for InitialExpr
  def showInitial(expr: InitialExpr): String = ???

  // Exercise 2: Final encoding
  // TODO: Define the same expressions using final encoding (functions / type class)
  //       In final encoding, expressions are represented as their interpretation
  trait FinalExpr[A] {
    def num(n: Int): A
    def add(left: A, right: A): A
    def mul(left: A, right: A): A
  }

  // TODO: Write an expression using final encoding (polymorphic over interpretation)
  def expr1[A](implicit E: FinalExpr[A]): A = ???
  // Should represent: (1 + 2) * 3

  // TODO: Implement FinalExpr[Int] for evaluation
  implicit val evalFinal: FinalExpr[Int] = ???

  // TODO: Implement FinalExpr[String] for pretty printing
  implicit val showFinal: FinalExpr[String] = ???

  // Exercise 3: Church encoding
  // TODO: Implement Church-encoded booleans
  //       A boolean is a function that chooses between two values
  // Church-encoded booleans (In Scala 2, we use a trait instead of Scala 3 type lambdas):
  trait ChurchBoolean {
    def apply[A](ifTrue: => A, ifFalse: => A): A
  }

  val churchTrue: ChurchBoolean = ???
  val churchFalse: ChurchBoolean = ???

  // TODO: Implement Church AND
  def churchAnd(a: ChurchBoolean, b: ChurchBoolean): ChurchBoolean = ???

  // TODO: Implement Church OR
  def churchOr(a: ChurchBoolean, b: ChurchBoolean): ChurchBoolean = ???

  // Exercise 4: Church-encoded natural numbers
  // TODO: Implement Church numerals
  trait ChurchNat {
    def apply[A](zero: A)(succ: A => A): A
  }

  val churchZero: ChurchNat = ???
  val churchOne: ChurchNat = ???

  // TODO: Implement successor
  def churchSucc(n: ChurchNat): ChurchNat = ???

  // TODO: Convert Church numeral to Int
  def churchToInt(n: ChurchNat): Int = ???

  // Exercise 5: Scott encoding
  // TODO: Implement Scott-encoded lists
  //       A Scott-encoded list is a function that pattern matches on head/tail vs nil
  trait ScottList[A] {
    def apply[B](nil: => B)(cons: (A, ScottList[A]) => B): B
  }

  def scottNil[A]: ScottList[A] = ???
  def scottCons[A](head: A, tail: ScottList[A]): ScottList[A] = ???

  // TODO: Convert Scott list to Scala List
  def scottToList[A](sl: ScottList[A]): List[A] = ???

  // Exercise 6: Expression problem - initial encoding limitation
  // TODO: Show that adding a new operation to initial encoding is easy,
  //       but adding a new data variant requires changing existing code
  //       Add a Neg variant (requires modifying InitialExpr - but we'll use extension)
  def negateInitial(expr: InitialExpr): InitialExpr = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val ie = IMul(IAdd(INum(1), INum(2)), INum(3))
    assert(evalInitial(ie) == 9)
    assert(showInitial(ie).contains("1") && showInitial(ie).contains("3"))

    // Exercise 2
    assert(expr1[Int] == 9) // (1 + 2) * 3
    val shown = expr1[String]
    assert(shown.contains("1") && shown.contains("*"))

    // Exercise 3
    assert(churchTrue(true, false) == true)
    assert(churchFalse(true, false) == false)
    assert(churchAnd(churchTrue, churchTrue)(true, false) == true)
    assert(churchAnd(churchTrue, churchFalse)(true, false) == false)
    assert(churchOr(churchFalse, churchTrue)(true, false) == true)
    assert(churchOr(churchFalse, churchFalse)(true, false) == false)

    // Exercise 4
    assert(churchToInt(churchZero) == 0)
    assert(churchToInt(churchOne) == 1)
    assert(churchToInt(churchSucc(churchSucc(churchOne))) == 3)

    // Exercise 5
    val sl = scottCons(1, scottCons(2, scottCons(3, scottNil[Int])))
    assert(scottToList(sl) == List(1, 2, 3))
    assert(scottToList(scottNil[Int]) == Nil)

    // Exercise 6
    assert(evalInitial(negateInitial(INum(5))) == -5)
    assert(evalInitial(negateInitial(IAdd(INum(3), INum(4)))) == -7)

    println("All Core108_FinalEncodings exercises passed!")
  }
}
