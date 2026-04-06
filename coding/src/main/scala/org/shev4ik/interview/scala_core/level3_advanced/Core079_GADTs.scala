package org.shev4ik.interview.scala_core.level3_advanced

object Core079_GADTs {

  // Exercise 1: GADT encoding in Scala 2
  // TODO: Define a GADT Expr[T] for typed expressions:
  //       - IntLit(value: Int) extends Expr[Int]
  //       - BoolLit(value: Boolean) extends Expr[Boolean]
  //       - Add(a: Expr[Int], b: Expr[Int]) extends Expr[Int]
  //       - IfThenElse[T](cond: Expr[Boolean], t: Expr[T], f: Expr[T]) extends Expr[T]
  sealed trait Expr[T]
  case class IntLit(value: Int) extends Expr[Int]
  case class BoolLit(value: Boolean) extends Expr[Boolean]
  case class Add(a: Expr[Int], b: Expr[Int]) extends Expr[Int]
  case class IfThenElse[T](cond: Expr[Boolean], t: Expr[T], f: Expr[T]) extends Expr[T]

  // Exercise 2: Typed expressions - Equals
  // TODO: Add an Equals case that takes two Expr[Int] and produces Expr[Boolean]
  case class Equals(a: Expr[Int], b: Expr[Int]) extends Expr[Boolean]

  // Exercise 3: Type-safe interpreter
  // TODO: Write an eval function that evaluates Expr[T] to T
  //       The return type is guaranteed by the GADT structure
  def eval[T](expr: Expr[T]): T = ???

  // Exercise 4: GADT pattern matching
  // TODO: Write a `show` function that pretty-prints an Expr[T]
  def show[T](expr: Expr[T]): String = ???

  // Exercise 5: Existential recovery
  // TODO: Define a wrapper that hides the type parameter (existential)
  //       and a method to process it
  trait AnyExpr {
    type A
    val expr: Expr[A]
    def evalToString: String
  }

  // TODO: Implement a factory method that wraps any Expr[T] into AnyExpr
  def wrapExpr[T](e: Expr[T]): AnyExpr = ???

  // Exercise 6: GADT and type inference
  // TODO: Write a method `optimize` that simplifies expressions
  //       e.g., Add(IntLit(0), x) => x, IfThenElse(BoolLit(true), t, f) => t
  def optimize[T](expr: Expr[T]): Expr[T] = ???

  // Exercise 7: Typed DSL with GADT
  // TODO: Define a small typed DSL for string operations using GADT
  sealed trait StrExpr[T]
  case class StrLit(s: String) extends StrExpr[String]
  case class StrLen(s: StrExpr[String]) extends StrExpr[Int]
  case class StrConcat(a: StrExpr[String], b: StrExpr[String]) extends StrExpr[String]
  case class StrToUpper(s: StrExpr[String]) extends StrExpr[String]

  // TODO: Write an eval function for StrExpr
  def evalStr[T](expr: StrExpr[T]): T = ???

  // Exercise 8: GADT limitations in Scala 2
  // TODO: Demonstrate a workaround for GADT inference issues in Scala 2.
  //       Write a helper method that uses explicit type ascription to help inference.
  def buildAndEval(): (Int, Boolean) = {
    // TODO: Build an expression: if (3 == 3) then 10 else 20
    //       and evaluate it. Also evaluate the condition separately.
    val condition: Expr[Boolean] = ???
    val fullExpr: Expr[Int] = ???
    (???, ???)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 & 2 (type structure)
    val expr1: Expr[Int] = Add(IntLit(3), IntLit(4))
    val expr2: Expr[Boolean] = Equals(IntLit(5), IntLit(5))

    // Exercise 3
    assert(eval(IntLit(42)) == 42)
    assert(eval(BoolLit(true)) == true)
    assert(eval(Add(IntLit(3), IntLit(4))) == 7)
    assert(eval(Equals(IntLit(5), IntLit(5))) == true)
    assert(eval(Equals(IntLit(5), IntLit(3))) == false)
    assert(eval(IfThenElse(BoolLit(true), IntLit(1), IntLit(2))) == 1)
    assert(eval(IfThenElse(BoolLit(false), IntLit(1), IntLit(2))) == 2)

    // Exercise 4
    assert(show(IntLit(5)) == "5")
    assert(show(Add(IntLit(1), IntLit(2))).contains("+") || show(Add(IntLit(1), IntLit(2))).contains("Add"))

    // Exercise 5
    val wrapped = wrapExpr(Add(IntLit(1), IntLit(2)))
    assert(wrapped.evalToString == "3")

    // Exercise 6
    assert(eval(optimize(Add(IntLit(0), IntLit(5)))) == 5)
    assert(eval(optimize(IfThenElse(BoolLit(true), IntLit(10), IntLit(20)))) == 10)

    // Exercise 7
    assert(evalStr(StrLit("hello")) == "hello")
    assert(evalStr(StrLen(StrLit("hello"))) == 5)
    assert(evalStr(StrConcat(StrLit("hello"), StrLit(" world"))) == "hello world")
    assert(evalStr(StrToUpper(StrLit("hello"))) == "HELLO")

    // Exercise 8
    val (result, condResult) = buildAndEval()
    assert(result == 10)
    assert(condResult == true)

    println("All Core079_GADTs exercises passed!")
  }
}
