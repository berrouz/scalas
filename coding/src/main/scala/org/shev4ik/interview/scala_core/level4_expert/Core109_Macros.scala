package org.shev4ik.interview.scala_core.level4_expert

object Core109_Macros {

  // NOTE: Scala 2 macros require a separate compilation unit (macro definitions
  // must be compiled before the code that uses them). This file demonstrates
  // the concepts and patterns. In a real project, macro implementations would
  // be in a separate module.

  // Exercise 1: def macro concept
  // TODO: Show the structure of a def macro (without actual macro implementation)
  //       Define the "interface" that a debug macro would have
  //       In practice: def debug(param: Any): Unit = macro debugImpl
  def debug(param: Any): String = {
    // TODO: Simulate what a debug macro would do:
    //       return the expression as a string along with its value
    ???
  }

  // Exercise 2: Macro annotation concept
  // TODO: Show what a macro annotation would generate
  //       For example, @ToString generates a toString method
  //       Simulate the generated code
  trait GeneratedToString {
    def generatedToString: String
  }

  case class Point(x: Int, y: Int) extends GeneratedToString {
    // TODO: Implement what @ToString macro annotation would generate
    def generatedToString: String = ???
  }

  // Exercise 3: Quasiquotes concept
  // TODO: Show the concept of quasiquotes (q"...", tq"...", pq"...")
  //       Quasiquotes let you construct and deconstruct AST trees
  //       Simulate by showing what the macro would produce
  def showQuasiquoteExample(): String = {
    // q"val x: Int = 42" represents the AST for: val x: Int = 42
    // TODO: Return a string showing what the quasiquote would produce
    ???
  }

  // Exercise 4: Tree manipulation concept
  // TODO: Show the concept of AST tree manipulation
  //       Define structures that represent simplified AST nodes
  sealed trait SimpleAST
  case class ValDef(name: String, tpe: String, value: SimpleAST) extends SimpleAST
  case class Literal(value: Any) extends SimpleAST
  case class Apply(fun: String, args: List[SimpleAST]) extends SimpleAST
  case class Ident(name: String) extends SimpleAST

  // TODO: Write a simple AST printer
  def printAST(ast: SimpleAST): String = ???

  // Exercise 5: reify concept
  // TODO: Show what reify does - it takes Scala code and returns its AST representation
  //       Simulate by creating an AST for a simple expression
  def reifyExample(): SimpleAST = {
    // reify { 1 + 2 } would produce an AST tree
    // TODO: Create the AST for: 1 + 2
    ???
  }

  // Exercise 6: showCode concept
  // TODO: Show what showCode does - converts AST back to source code string
  def showCode(ast: SimpleAST): String = ???

  // Exercise 7: Macro for debugging
  // TODO: Simulate a debug macro that shows variable name + value
  def debugVar(name: String, value: Any): String = ???

  // Exercise 8: Macro for logging
  // TODO: Simulate a logging macro that includes source location
  def logWithLocation(message: String, file: String = "unknown", line: Int = 0): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(debug(42).contains("42"))

    // Exercise 2
    val p = Point(3, 4)
    assert(p.generatedToString == "Point(x=3, y=4)")

    // Exercise 3
    assert(showQuasiquoteExample().contains("val"))

    // Exercise 4
    val ast = Apply("+", List(Literal(1), Literal(2)))
    assert(printAST(ast).contains("+"))

    // Exercise 5
    val reified = reifyExample()
    assert(reified.isInstanceOf[Apply])

    // Exercise 6
    assert(showCode(Literal(42)) == "42")
    assert(showCode(Apply("+", List(Literal(1), Literal(2)))) == "(1 + 2)")

    // Exercise 7
    val x = 42
    assert(debugVar("x", x) == "x = 42")

    // Exercise 8
    val log = logWithLocation("test", "Core109.scala", 100)
    assert(log.contains("test") && log.contains("Core109"))

    println("All Core109_Macros exercises passed!")
  }
}
