package org.shev4ik.interview.scala_core.level4_expert

object Core121_MetaProgramming {

  // NOTE: Scalameta requires the scalameta library. This file demonstrates concepts
  // by simulating tree structures and transformations.

  // Exercise 1: Scalameta trees (simplified)
  // TODO: Define a simplified tree representation
  sealed trait STree
  case class SLit(value: Any) extends STree
  case class SName(value: String) extends STree
  case class SApply(fun: STree, args: List[STree]) extends STree
  case class SValDef(name: String, tpe: Option[String], rhs: STree) extends STree
  case class SDefDef(name: String, params: List[(String, String)], retType: String, body: STree) extends STree
  case class SClassDef(name: String, params: List[(String, String)], body: List[STree]) extends STree
  case class SBlock(stmts: List[STree]) extends STree

  // TODO: Create a tree for: val x: Int = 42
  def exampleValDef(): STree = ???

  // Exercise 2: Scalameta parsing (simplified)
  // TODO: Write a simple parser for basic Scala expressions
  def parseSimple(code: String): STree = ???

  // Exercise 3: Scalameta transformation
  // TODO: Write a tree transformer that renames all identifiers
  def renameAll(tree: STree, from: String, to: String): STree = ???

  // Exercise 4: Semantic API concept
  // TODO: Show the concept of semantic analysis - resolving types and symbols
  case class Symbol(name: String, tpe: String, owner: String)

  class SemanticDB(symbols: Map[String, Symbol]) {
    def resolve(name: String): Option[Symbol] = ???
    def typeOf(name: String): Option[String] = ???
  }

  // Exercise 5: Scalafix rules concept
  // TODO: Simulate a Scalafix rule that transforms code
  trait ScalafixRule {
    def name: String
    def fix(tree: STree): STree
  }

  // TODO: Create a rule that replaces deprecated method calls
  val deprecationRule: ScalafixRule = ???

  // Exercise 6: Scalameta for code generation
  // TODO: Generate code from a description
  case class FieldSpec(name: String, tpe: String)

  def generateCaseClass(name: String, fields: List[FieldSpec]): String = ???

  // Exercise 7: Scalameta vs reflect comparison
  // TODO: Show the conceptual difference between Scalameta (syntactic) and reflect (semantic)
  def syntacticAnalysis(tree: STree): Map[String, Int] = {
    // TODO: Count occurrences of each identifier (purely syntactic)
    ???
  }

  // Exercise 8: Scalameta best practices
  // TODO: Show idiomatic patterns for working with trees
  def collectNames(tree: STree): List[String] = ???

  def collectLiterals(tree: STree): List[Any] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val valDef = exampleValDef()
    assert(valDef.isInstanceOf[SValDef])

    // Exercise 2
    val parsed = parseSimple("42")
    assert(parsed == SLit(42) || parsed == SLit("42"))

    // Exercise 3
    val tree = SApply(SName("foo"), List(SName("x"), SLit(1)))
    val renamed = renameAll(tree, "foo", "bar")
    assert(renamed == SApply(SName("bar"), List(SName("x"), SLit(1))))

    // Exercise 4
    val sdb = new SemanticDB(Map(
      "x" -> Symbol("x", "Int", "Main"),
      "name" -> Symbol("name", "String", "Person")
    ))
    assert(sdb.resolve("x").map(_.tpe) == Some("Int"))
    assert(sdb.typeOf("name") == Some("String"))

    // Exercise 5
    val oldTree = SApply(SName("deprecated_method"), List(SLit(42)))
    val fixed = deprecationRule.fix(oldTree)
    assert(fixed != oldTree || deprecationRule.name.nonEmpty)

    // Exercise 6
    val generated = generateCaseClass("User", List(
      FieldSpec("name", "String"),
      FieldSpec("age", "Int")
    ))
    assert(generated.contains("case class User"))
    assert(generated.contains("name: String"))
    assert(generated.contains("age: Int"))

    // Exercise 7
    val complexTree = SBlock(List(
      SValDef("x", Some("Int"), SLit(1)),
      SApply(SName("println"), List(SName("x")))
    ))
    val counts = syntacticAnalysis(complexTree)
    assert(counts.getOrElse("x", 0) >= 1)

    // Exercise 8
    val names = collectNames(complexTree)
    assert(names.contains("x"))
    assert(names.contains("println"))

    val literals = collectLiterals(complexTree)
    assert(literals.contains(1))

    println("All Core121_MetaProgramming exercises passed!")
  }
}
