package org.shev4ik.interview.scala3.level3_advanced

/**
 * Scala 3: Metaprogramming — macros, quotes/splices, staging
 * (modeled conceptually in Scala 2.13)
 *
 * Scala 3 replaces Scala 2 macros with a new system:
 *   - Quotes and splices: '{ expr } and ${ expr }
 *   - Inline + macros for compile-time code generation
 *   - Multi-stage programming (staging)
 * In Scala 2.13, we model these concepts at the value level.
 */
object Sc3_011_Metaprogramming {

  // Exercise 1: Quote/splice concept (Scala 3: '{ ... } and ${ ... })
  // In Scala 3: '{ expr } captures code as an AST (Expr[T])
  //             ${ expr } splices an Expr[T] into surrounding code
  // TODO: Model "quoted expressions" as a simple AST.
  //       sealed trait QExpr[A] with cases: Literal(value: A), Plus(l: QExpr[Int], r: QExpr[Int]),
  //       Times(l: QExpr[Int], r: QExpr[Int]), Ref(name: String, value: A).
  //       Implement `eval[A](expr: QExpr[A]): A` to evaluate the AST.
  //       Answer: What do '{ } and ${ } do in Scala 3?
  sealed trait QExpr[A]
  // TODO: Define case classes Literal, Plus, Times, Ref extending QExpr
  def exercise1_eval[A](expr: QExpr[A]): A = ???
  def exercise1_quoteSpliceAnswer: String = ???
  // TODO: "'{ } quotes code into an AST (Expr[T]); ${ } splices an Expr[T] back into code"

  // Exercise 2: Compile-time string operations (Scala 3: compiletime.constValue for strings)
  // TODO: Implement a `StringMacroSim` that simulates compile-time string operations:
  //       - `interpolate(template: String, vars: Map[String, String]): String` — replaces ${key} with value
  //       - `validateFormat(format: String): Either[String, List[String]]` — validates printf-like format,
  //         returns Right(list of format specifiers) or Left(error message).
  //       These simulate what Scala 3 macros can do at compile time.
  def exercise2_interpolate(template: String, vars: Map[String, String]): String = ???
  def exercise2_validateFormat(format: String): Either[String, List[String]] = ???

  // Exercise 3: Type-safe SQL (conceptual macro use case)
  // Scala 3 macros can validate SQL at compile time.
  // TODO: Implement a runtime SQL validator/builder:
  //       - `sql(query: String): Either[String, ParsedQuery]` that validates basic SQL structure
  //       - ParsedQuery should extract: operation (SELECT/INSERT/UPDATE/DELETE), table name, conditions
  //       Validate that the query starts with a known keyword.
  case class ParsedQuery(operation: String, table: String, conditions: List[String])
  def exercise3_sql(query: String): Either[String, ParsedQuery] = ???

  // Exercise 4: Derivation via reflection simulation (modeling Scala 3 Mirror at runtime)
  // Scala 3 macros use Mirror to inspect case classes at compile time.
  // TODO: Implement `fieldNames` and `fieldValues` using runtime reflection (productIterator).
  //       - `fieldNames[A <: Product](a: A): List[String]` — returns field names
  //       - `fieldValues[A <: Product](a: A): List[Any]` — returns field values
  //       - `toMap[A <: Product](a: A): Map[String, Any]` — combines names and values
  def exercise4_fieldNames[A <: Product](a: A): List[String] = ???
  def exercise4_fieldValues[A <: Product](a: A): List[Any] = ???
  def exercise4_toMap[A <: Product](a: A): Map[String, Any] = ???

  // Exercise 5: Code generation simulation (modeling macro-generated code)
  // Scala 3 macros can generate code at compile time.
  // TODO: Implement a "code generator" that produces source code strings:
  //       - `generateEquals(className: String, fields: List[(String, String)]): String`
  //         produces a string of a Scala equals method
  //       - `generateToString(className: String, fields: List[String]): String`
  //         produces a string of a toString method
  //       This models what derives generates.
  def exercise5_generateEquals(className: String, fields: List[(String, String)]): String = ???
  def exercise5_generateToString(className: String, fields: List[String]): String = ???

  // Exercise 6: Staging concept (Scala 3 multi-stage programming)
  // Staging separates "now" (compile time) from "later" (runtime).
  // TODO: Model staging with a `Staged[A]` type that represents deferred computation.
  //       sealed trait Staged[A] with:
  //       - Now(value: A) — available immediately
  //       - Later(compute: () => A) — deferred
  //       - Mapped(source: Staged[B], f: B => A) — transformed
  //       Implement `run[A](s: Staged[A]): A` that forces evaluation.
  //       Answer: What is the purpose of staging in Scala 3?
  sealed trait Staged[+A]
  // TODO: Define case classes Now, Later
  def exercise6_run[A](s: Staged[A]): A = ???
  def exercise6_stagingPurpose: String = ???
  // TODO: "Staging separates compile-time and runtime computation for optimized code generation"

  // Exercise 7: Macro-like assertion (modeling compiletime.error with source info)
  // Scala 3 macros can capture source location for better error messages.
  // TODO: Implement `myAssert` that, on failure, includes:
  //       - The expression as a string (passed as a parameter)
  //       - File and line info (simulated as parameters)
  //       Returns Right(()) on success, Left(error message) on failure.
  //       Also implement `sourceLocation` that returns a formatted location string.
  case class SourceLocation(file: String, line: Int)
  def exercise7_myAssert(condition: Boolean, expr: String, loc: SourceLocation): Either[String, Unit] = ???
  def exercise7_sourceLocation(file: String, line: Int): String = ???

  // Exercise 8: Summary of Scala 3 metaprogramming
  // TODO: For each Scala 3 metaprogramming feature, describe its purpose.
  def exercise8_features: Map[String, String] = ???
  // Expected:
  // "quotes" -> "Capture code as AST (Expr[T]) using '{ }"
  // "splices" -> "Insert Expr[T] into code using ${ }"
  // "inline" -> "Guaranteed inlining, enables compile-time evaluation"
  // "Mirror" -> "Compile-time reflection for product and sum types"
  // "staging" -> "Multi-stage programming separating compile and runtime"
  // "Expr.summon" -> "Summon implicit/given values inside macros"
  // "Type[T]" -> "Represent types as values inside macros"
  // "MacroAnnotations" -> "Annotations that trigger macro expansion on definitions"

  def main(args: Array[String]): Unit = {
    // Exercise 1
    // (Uncomment after defining QExpr case classes)
    // val expr = Plus(Literal(3), Times(Literal(2), Literal(4)))
    // assert(exercise1_eval(expr) == 11, "Exercise 1 failed")
    assert(exercise1_quoteSpliceAnswer ==
      "'{ } quotes code into an AST (Expr[T]); ${ } splices an Expr[T] back into code",
      "Exercise 1 answer failed")
    println("Exercise 1: Define QExpr case classes and uncomment assertions")

    // Exercise 2
    assert(exercise2_interpolate("Hello ${name}, age ${age}!", Map("name" -> "Alice", "age" -> "30"))
      == "Hello Alice, age 30!", "Exercise 2 interpolate failed")
    assert(exercise2_validateFormat("Name: %s, Age: %d").isRight, "Exercise 2 validate failed")
    assert(exercise2_validateFormat("Name: %s, Age: %d").map(_.length) == Right(2), "Exercise 2 specifiers failed")

    // Exercise 3
    val parsed = exercise3_sql("SELECT * FROM users WHERE active = true")
    assert(parsed.isRight, "Exercise 3 should parse valid SQL")
    assert(parsed.map(_.operation) == Right("SELECT"), "Exercise 3 operation failed")
    assert(parsed.map(_.table) == Right("users"), "Exercise 3 table failed")
    assert(exercise3_sql("INVALID query").isLeft, "Exercise 3 should reject invalid SQL")

    // Exercise 4
    case class TestPerson(name: String, age: Int)
    val person = TestPerson("Alice", 30)
    assert(exercise4_fieldValues(person) == List("Alice", 30), "Exercise 4 values failed")
    assert(exercise4_toMap(person).values.toSet == Set("Alice", 30), "Exercise 4 toMap failed")

    // Exercise 5
    val eqCode = exercise5_generateEquals("Point", List(("x", "Int"), ("y", "Int")))
    assert(eqCode.contains("x") && eqCode.contains("y"), "Exercise 5 equals failed")
    val tsCode = exercise5_generateToString("Point", List("x", "y"))
    assert(tsCode.contains("Point") && tsCode.contains("x"), "Exercise 5 toString failed")

    // Exercise 6
    // (Uncomment after defining Staged case classes)
    // assert(exercise6_run(Now(42)) == 42, "Exercise 6 Now failed")
    // assert(exercise6_run(Later(() => 1 + 2)) == 3, "Exercise 6 Later failed")
    assert(exercise6_stagingPurpose ==
      "Staging separates compile-time and runtime computation for optimized code generation",
      "Exercise 6 answer failed")
    println("Exercise 6: Define Staged case classes and uncomment assertions")

    // Exercise 7
    assert(exercise7_myAssert(true, "1 + 1 == 2", SourceLocation("test.scala", 10)) == Right(()), "Exercise 7 true failed")
    val failure = exercise7_myAssert(false, "1 + 1 == 3", SourceLocation("test.scala", 11))
    assert(failure.isLeft, "Exercise 7 false should fail")
    assert(failure.left.getOrElse("").contains("test.scala"), "Exercise 7 should contain file")
    assert(exercise7_sourceLocation("Main.scala", 42) == "Main.scala:42", "Exercise 7 location failed")

    // Exercise 8
    val features = exercise8_features
    assert(features.size == 8, "Exercise 8 should have 8 features")
    assert(features("quotes").contains("AST"), "Exercise 8 quotes failed")
    assert(features("Mirror").contains("reflection"), "Exercise 8 Mirror failed")

    println("All Sc3_011_Metaprogramming exercises passed!")
  }
}
