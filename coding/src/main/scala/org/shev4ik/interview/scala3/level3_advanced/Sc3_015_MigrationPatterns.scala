package org.shev4ik.interview.scala3.level3_advanced

/**
 * Scala 2 to Scala 3 Migration Patterns and Cross-Compilation
 *
 * This file covers the key migration patterns from Scala 2.13 to Scala 3,
 * implemented in Scala 2.13 code with explanations of the Scala 3 equivalents.
 * Each exercise shows a Scala 2 pattern and asks for the Scala 3 equivalent.
 */
object Sc3_015_MigrationPatterns {

  // Exercise 1: Implicits to given/using migration
  // Show the Scala 2 pattern and describe the Scala 3 equivalent.
  // TODO: Implement the Scala 2 version of each pattern.
  //       Then return the Scala 3 syntax as a string.

  // Scala 2 pattern:
  trait JsonEncoder[A] {
    def encode(a: A): String
  }
  implicit val intEncoder: JsonEncoder[Int] = new JsonEncoder[Int] {
    def encode(a: Int): String = a.toString
  }
  def toJson[A](a: A)(implicit enc: JsonEncoder[A]): String = ???
  // TODO: Implement toJson using the implicit encoder

  def exercise1_scala3Equivalent: String = ???
  // TODO: Return multi-line Scala 3 syntax:
  // "given intEncoder: JsonEncoder[Int] with { def encode(a: Int) = a.toString }\ndef toJson[A](a: A)(using enc: JsonEncoder[A]): String = enc.encode(a)"

  // Exercise 2: Implicit class to extension method migration
  // Scala 2: implicit class RichString(s: String) { def greet: String = s"Hello, $s!" }
  // TODO: Implement the Scala 2 implicit class pattern.
  //       Return the Scala 3 extension method syntax as a string.
  implicit class RichString(val s: String) extends AnyVal {
    def greet: String = ???  // TODO: Return s"Hello, $s!"
    def shout: String = ???  // TODO: Return s.toUpperCase + "!"
  }
  def exercise2_testGreet(name: String): String = ???  // TODO: Use the extension method
  def exercise2_scala3Equivalent: String = ???
  // TODO: "extension (s: String)\n  def greet: String = s\"Hello, $s!\"\n  def shout: String = s.toUpperCase + \"!\""

  // Exercise 3: Sealed trait ADT to enum migration
  // Scala 2 pattern:
  sealed trait Result[+A]
  case class Success[A](value: A) extends Result[A]
  case class Failure(error: String) extends Result[Nothing]
  def exercise3_process(r: Result[Int]): String = ???
  // TODO: Pattern match on Result: Success => "ok: <value>", Failure => "err: <error>"
  def exercise3_scala3Equivalent: String = ???
  // TODO: "enum Result[+A] {\n  case Success(value: A)\n  case Failure(error: String) extends Result[Nothing]\n}"

  // Exercise 4: Procedure syntax removal
  // Scala 2 allowed: def foo() { println("hello") } (procedure syntax, deprecated)
  // Scala 3 requires: def foo(): Unit = { println("hello") }
  // TODO: Implement functions with proper `: Unit =` syntax (already required in good Scala 2 style).
  //       Return a description of what changed.
  def exercise4_sideEffect(): Unit = ???  // TODO: just return ()
  def exercise4_whatChanged: String = ???
  // TODO: "Scala 3 removes procedure syntax (def f() { ... }); must use def f(): Unit = { ... }"

  // Exercise 5: Wildcard and vararg syntax changes
  // Scala 2: _ for wildcards, _* for varargs, t: _* for type application
  // Scala 3: ? for type wildcards, * for varargs
  // TODO: Show the Scala 2 patterns working, then describe Scala 3 changes.
  def exercise5_wildcardType: List[_] = ???  // TODO: Return List(1, "hello", true) — uses existential wildcard
  def exercise5_varargs(xs: Int*): Int = ???  // TODO: Return sum of xs
  def exercise5_scala3Wildcards: Map[String, String] = ???
  // Expected:
  // "existential_wildcard" -> "Scala 2: List[_] becomes Scala 3: List[?]"
  // "vararg_splat" -> "Scala 2: f(xs: _*) becomes Scala 3: f(xs*)"
  // "import_wildcard" -> "Scala 2: import foo._ becomes Scala 3: import foo.*"
  // "import_rename" -> "Scala 2: import foo.{Bar => Baz} becomes Scala 3: import foo.{Bar as Baz}"

  // Exercise 6: New control syntax (optional braces, significant indentation)
  // Scala 3 allows: if x > 0 then ... else ...  (no parens/braces needed)
  // TODO: Implement Scala 2 versions. Return the Scala 3 syntax equivalents as strings.
  def exercise6_ifElse(x: Int): String = ???
  // TODO: Return "positive", "negative", or "zero"
  def exercise6_forYield(xs: List[Int]): List[Int] = ???
  // TODO: Filter even numbers, double them using for/yield
  def exercise6_scala3ControlSyntax: Map[String, String] = ???
  // Expected:
  // "if_then_else" -> "if x > 0 then \"positive\" else if x < 0 then \"negative\" else \"zero\""
  // "for_yield" -> "for x <- xs if x % 2 == 0 yield x * 2"
  // "match" -> "x match\\n  case 1 => \"one\"\\n  case _ => \"other\""
  // "while" -> "while x > 0 do x -= 1"

  // Exercise 7: Key dropped/changed features
  // TODO: For each dropped or changed feature, describe the migration path.
  def exercise7_droppedFeatures: Map[String, String] = ???
  // Expected:
  // "DelayedInit" -> "Removed; use explicit main method or @main annotation"
  // "scala.App" -> "Deprecated; use @main def run(): Unit = { ... }"
  // "do-while" -> "Removed; use while with explicit condition variable"
  // "XML literals" -> "Removed; use xml string interpolator or library"
  // "symbol literals" -> "Removed; use string literals or Symbol(\"name\")"
  // "auto-tupling" -> "Changed; parameter untupling added instead"
  // "implicit conversions" -> "Require Conversion[A, B] given instance in Scala 3"
  // "type projection T#Inner" -> "Removed for arbitrary types; only path-dependent types remain"

  // Exercise 8: Cross-compilation strategies
  // TODO: Describe strategies for maintaining code that compiles on both Scala 2.13 and Scala 3.
  def exercise8_strategies: Map[String, String] = ???
  // Expected:
  // "compiler_flags" -> "-Xsource:3 flag in Scala 2.13 enables some Scala 3 syntax"
  // "migration_mode" -> "Scala 3 -source:3.0-migration flag for gradual migration"
  // "tasty_reader" -> "Scala 2.13.x can read Scala 3 TASTy files with -Ytasty-reader"
  // "cross_building" -> "Use sbt crossScalaVersions to build for both versions"
  // "syntax_rewrites" -> "Scala 3 compiler can auto-rewrite Scala 2 syntax with -rewrite"
  // "conditional_compilation" -> "Use sbt sourceDirectories to have scala-2/scala-3 specific sources"
  // "migration_tools" -> "Scalafix rules for automated migration (e.g., ExplicitResultTypes)"
  // "library_compat" -> "scala-collection-compat and other cross-version libraries"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(toJson(42) == "42", "Exercise 1 toJson failed")
    assert(exercise1_scala3Equivalent.contains("given"), "Exercise 1 should mention given")
    assert(exercise1_scala3Equivalent.contains("using"), "Exercise 1 should mention using")

    // Exercise 2
    assert(exercise2_testGreet("World") == "Hello, World!", "Exercise 2 greet failed")
    assert("test".shout == "TEST!", "Exercise 2 shout failed")
    assert(exercise2_scala3Equivalent.contains("extension"), "Exercise 2 should mention extension")

    // Exercise 3
    assert(exercise3_process(Success(42)) == "ok: 42", "Exercise 3 success failed")
    assert(exercise3_process(Failure("boom")) == "err: boom", "Exercise 3 failure failed")
    assert(exercise3_scala3Equivalent.contains("enum"), "Exercise 3 should mention enum")

    // Exercise 4
    exercise4_sideEffect()  // should not throw
    assert(exercise4_whatChanged.contains("procedure syntax"), "Exercise 4 failed")

    // Exercise 5
    assert(exercise5_wildcardType.length == 3, "Exercise 5 wildcard failed")
    assert(exercise5_varargs(1, 2, 3) == 6, "Exercise 5 varargs failed")
    val wildcards = exercise5_scala3Wildcards
    assert(wildcards.size == 4, "Exercise 5 should have 4 entries")
    assert(wildcards("import_wildcard").contains("*"), "Exercise 5 import wildcard failed")

    // Exercise 6
    assert(exercise6_ifElse(5) == "positive", "Exercise 6 positive failed")
    assert(exercise6_ifElse(-3) == "negative", "Exercise 6 negative failed")
    assert(exercise6_ifElse(0) == "zero", "Exercise 6 zero failed")
    assert(exercise6_forYield(List(1, 2, 3, 4, 5, 6)) == List(4, 8, 12), "Exercise 6 for/yield failed")
    val controlSyntax = exercise6_scala3ControlSyntax
    assert(controlSyntax.size == 4, "Exercise 6 should have 4 entries")

    // Exercise 7
    val dropped = exercise7_droppedFeatures
    assert(dropped.size == 8, "Exercise 7 should have 8 entries")
    assert(dropped("scala.App").contains("@main"), "Exercise 7 scala.App failed")
    assert(dropped("implicit conversions").contains("Conversion"), "Exercise 7 implicit conversions failed")

    // Exercise 8
    val strategies = exercise8_strategies
    assert(strategies.size == 8, "Exercise 8 should have 8 entries")
    assert(strategies("compiler_flags").contains("-Xsource:3"), "Exercise 8 compiler flags failed")
    assert(strategies("tasty_reader").contains("TASTy"), "Exercise 8 tasty reader failed")

    println("All Sc3_015_MigrationPatterns exercises passed!")
  }
}
