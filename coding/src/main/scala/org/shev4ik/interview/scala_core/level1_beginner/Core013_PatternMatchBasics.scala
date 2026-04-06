package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Pattern Matching=
 *
 * ==Theory: Pattern Matching Overview==
 *
 * Pattern matching in Scala is a powerful mechanism that generalizes Java's `switch` statement.
 * It can match on:
 *  - '''Literal patterns:''' exact values like `1`, `"hello"`, `true`.
 *  - '''Variable patterns:''' bind the matched value to a name.
 *  - '''Type patterns:''' match on the runtime type (`case x: String =>`).
 *  - '''Constructor/Extractor patterns:''' deconstruct case classes and objects.
 *  - '''Tuple patterns:''' match on tuple structure.
 *  - '''Sequence patterns:''' match on lists/sequences (`case x :: xs =>`).
 *  - '''Wildcard pattern:''' `_` matches anything (like a default case).
 *  - '''Guard conditions:''' add `if` clauses to refine matches.
 *  - '''Nested patterns:''' combine patterns recursively.
 *
 * ==Theory: Exhaustive Matching==
 *
 * When you match on a sealed trait (or sealed abstract class), the compiler knows all
 * possible subtypes and can warn you if your match is not exhaustive (i.e., you forgot a case).
 * This is one of the key benefits of using sealed hierarchies for ADTs.
 *
 * {{{
 * sealed trait Color
 * case object Red extends Color
 * case object Blue extends Color
 *
 * def name(c: Color): String = c match {
 *   case Red => "red"
 *   // Compiler warning: match may not be exhaustive -- missing case Blue
 * }
 * }}}
 *
 * ==Theory: Extractors (unapply)==
 *
 * Pattern matching on case classes works because the compiler generates an `unapply` method
 * in the companion object. You can define custom extractors for any type:
 *
 * {{{
 * object Even {
 *   def unapply(n: Int): Option[Int] = if (n % 2 == 0) Some(n) else None
 * }
 *
 * 42 match {
 *   case Even(n) => s"$n is even"   // "42 is even"
 *   case n       => s"$n is odd"
 * }
 * }}}
 *
 * `unapply` returns `Option[T]` (or `Boolean` for parameterless extractors).
 * For multi-value extraction, return `Option[(T1, T2, ...)]`.
 *
 * ==Theory: PartialFunction and Pattern Matching==
 *
 * A block of case clauses is syntactic sugar for a `PartialFunction`:
 * {{{
 * val pf: PartialFunction[Int, String] = {
 *   case 1 => "one"
 *   case 2 => "two"
 * }
 * pf.isDefinedAt(1)  // true
 * pf.isDefinedAt(3)  // false
 * }}}
 * This is used extensively by `collect`, `recover`, and Akka's `receive`.
 *
 * ==Theory: Type Erasure Caveat==
 *
 * On the JVM, generic type parameters are erased at runtime. This means you CANNOT
 * reliably match on generic types:
 * {{{
 * def check(x: Any): String = x match {
 *   case _: List[Int]    => "list of ints"    // WARNING: erased -- matches ANY List!
 *   case _: List[String] => "list of strings" // UNREACHABLE -- same erasure as above
 * }
 * check(List("hello"))  // "list of ints" -- WRONG!
 * }}}
 *
 * Workarounds: use `TypeTag` / `ClassTag`, or match on the element type after extracting it.
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "What is type erasure and how does it affect pattern matching on generic types?"'''
 *    Answer: Type erasure means the JVM discards generic type parameters at runtime.
 *    `List[Int]` and `List[String]` are both just `List` at runtime. So `case _: List[Int]`
 *    matches ANY `List`, not just `List[Int]`. The compiler warns about this with an
 *    "unchecked" warning. To work around it, use `ClassTag` or `TypeTag` from `scala.reflect`,
 *    or restructure the code to avoid matching on erased types.
 *
 *  - '''Follow-up: "What is an extractor and how do you define one?"'''
 *    Answer: An extractor is an object with an `unapply` method that enables pattern matching.
 *    Case classes get extractors for free; for custom types, define `unapply` returning
 *    `Option[T]` in a companion object.
 *
 *  - '''Follow-up: "How are pattern match blocks related to PartialFunction?"'''
 *    Answer: A `{ case ... }` block is a `PartialFunction` when the expected type is
 *    `PartialFunction[A, B]`. It has `isDefinedAt` and `apply` methods, and is used
 *    by `collect`, `recover`, `recoverWith`, and Akka's message handling.
 *
 * ==Approach Hints==
 *
 *  - Pattern matches are tried top-to-bottom; the first matching case wins.
 *  - Always include a wildcard `_` or ensure exhaustive coverage to avoid `MatchError`.
 *  - Guards (`case x if condition =>`) are evaluated after the pattern matches structurally.
 *  - For nested patterns (Exercise 7), you can nest constructors: `Some(List(x))`.
 */
object Core013_PatternMatchBasics {

  // Exercise 1: Literal patterns
  // TODO: Match an Int and return a String:
  //       1 => "one", 2 => "two", 3 => "three", _ => "other"
  def exercise1_literalPatterns(n: Int): String = ???

  // Exercise 2: Variable patterns
  // TODO: Match any value and bind it to a variable.
  //       Given Any, return s"Got: $x" where x is the matched value.
  def exercise2_variablePatterns(value: Any): String = ???

  // Exercise 3: Type patterns
  // TODO: Match on the runtime type of a value:
  //       Int => "integer: $x", String => "string: $x",
  //       Double => "double: $x", _ => "unknown"
  def exercise3_typePatterns(value: Any): String = ???

  // Exercise 4: Tuple patterns
  // TODO: Match a tuple (Any, Any) and return a descriptive string:
  //       (Int, Int) => "two ints: $a + $b = ${a+b}"
  //       (String, String) => "two strings: $a$b"
  //       _ => "other tuple"
  def exercise4_tuplePatterns(t: (Any, Any)): String = ???

  // Exercise 5: Wildcard pattern
  // TODO: Given a List[Int], match on its structure:
  //       Nil => "empty"
  //       List(single) => s"single: $single"
  //       List(first, second) => s"pair: $first, $second"
  //       _ => "many elements"
  def exercise5_wildcardPattern(list: List[Int]): String = ???

  // Exercise 6: Guard conditions
  // TODO: Match an Int with guards:
  //       n if n > 0 => "positive"
  //       n if n < 0 => "negative"
  //       _ => "zero"
  def exercise6_guardConditions(n: Int): String = ???

  // Exercise 7: Nested patterns
  // TODO: Match on Option[List[Int]]:
  //       Some(Nil) => "empty list"
  //       Some(List(x)) => s"single element: $x"
  //       Some(list) => s"list with ${list.length} elements"
  //       None => "nothing"
  def exercise7_nestedPatterns(opt: Option[List[Int]]): String = ???

  // Exercise 8: Sealed trait exhaustive match
  // TODO: Define a sealed trait Shape with case classes Circle(r: Double),
  //       Rectangle(w: Double, h: Double), and case object Point.
  //       Write a match that computes the area:
  //       Circle => math.Pi * r * r, Rectangle => w * h, Point => 0.0

  sealed trait Shape
  case class Circle(r: Double) extends Shape
  case class Rectangle(w: Double, h: Double) extends Shape
  case object Point extends Shape

  def exercise8_sealedMatch(shape: Shape): Double = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_literalPatterns(1) == "one", "Exercise 1 failed: one")
    assert(exercise1_literalPatterns(2) == "two", "Exercise 1 failed: two")
    assert(exercise1_literalPatterns(99) == "other", "Exercise 1 failed: other")

    assert(exercise2_variablePatterns(42) == "Got: 42", "Exercise 2 failed")
    assert(exercise2_variablePatterns("hi") == "Got: hi", "Exercise 2 failed: string")

    assert(exercise3_typePatterns(42) == "integer: 42", "Exercise 3 failed: int")
    assert(exercise3_typePatterns("hi") == "string: hi", "Exercise 3 failed: string")
    assert(exercise3_typePatterns(3.14) == "double: 3.14", "Exercise 3 failed: double")
    assert(exercise3_typePatterns(true) == "unknown", "Exercise 3 failed: unknown")

    assert(exercise4_tuplePatterns((1, 2)) == "two ints: 1 + 2 = 3", "Exercise 4 failed: ints")
    assert(exercise4_tuplePatterns(("a", "b")) == "two strings: ab", "Exercise 4 failed: strings")

    assert(exercise5_wildcardPattern(Nil) == "empty", "Exercise 5 failed: empty")
    assert(exercise5_wildcardPattern(List(1)) == "single: 1", "Exercise 5 failed: single")
    assert(exercise5_wildcardPattern(List(1, 2)) == "pair: 1, 2", "Exercise 5 failed: pair")
    assert(exercise5_wildcardPattern(List(1, 2, 3)) == "many elements", "Exercise 5 failed: many")

    assert(exercise6_guardConditions(5) == "positive", "Exercise 6 failed: positive")
    assert(exercise6_guardConditions(-3) == "negative", "Exercise 6 failed: negative")
    assert(exercise6_guardConditions(0) == "zero", "Exercise 6 failed: zero")

    assert(exercise7_nestedPatterns(Some(Nil)) == "empty list", "Exercise 7 failed: empty")
    assert(exercise7_nestedPatterns(Some(List(42))) == "single element: 42", "Exercise 7 failed: single")
    assert(exercise7_nestedPatterns(Some(List(1, 2, 3))) == "list with 3 elements", "Exercise 7 failed: multi")
    assert(exercise7_nestedPatterns(None) == "nothing", "Exercise 7 failed: none")

    assert(math.abs(exercise8_sealedMatch(Circle(1.0)) - math.Pi) < 1e-10, "Exercise 8 failed: circle")
    assert(exercise8_sealedMatch(Rectangle(3.0, 4.0)) == 12.0, "Exercise 8 failed: rectangle")
    assert(exercise8_sealedMatch(Point) == 0.0, "Exercise 8 failed: point")

    println("All Core013_PatternMatchBasics exercises passed!")
  }
}
