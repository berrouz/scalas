package org.shev4ik.interview.scala_core.level1_beginner

object Core030_PatternMatchAdv {

  // Exercise 1: Extractor objects
  // TODO: Define an object Twice with an unapply method:
  //       def unapply(n: Int): Option[Int] = if (n % 2 == 0) Some(n / 2) else None
  //       Use it in pattern matching: 10 match { case Twice(x) => x } should give 5.
  //       Return the result for input 10.
  object Twice {
    def unapply(n: Int): Option[Int] = if (n % 2 == 0) Some(n / 2) else None
  }

  def exercise1_extractorObject(n: Int): Option[Int] = ???

  // Exercise 2: unapply with multiple values
  // TODO: Define an object FullName with unapply that splits "First Last" into (first, last).
  //       def unapply(s: String): Option[(String, String)]
  //       Split on space; if exactly 2 parts, return Some, else None.
  //       Match "John Doe" and return (first, last).
  object FullName {
    def unapply(s: String): Option[(String, String)] = {
      val parts = s.split(" ")
      if (parts.length == 2) Some((parts(0), parts(1))) else None
    }
  }

  def exercise2_unapplyMultiple(name: String): Option[(String, String)] = ???

  // Exercise 3: unapplySeq
  // TODO: Define an object Words with unapplySeq that splits a string into words.
  //       def unapplySeq(s: String): Option[Seq[String]] = Some(s.split("\\s+").toSeq)
  //       Match "hello world foo" to extract all words. Return as List.
  object Words {
    def unapplySeq(s: String): Option[Seq[String]] = Some(s.split("\\s+").toSeq)
  }

  def exercise3_unapplySeq(s: String): List[String] = ???

  // Exercise 4: Regex extractors
  // TODO: Use regex groups as extractors:
  //       val datePattern = """(\d{4})-(\d{2})-(\d{2})""".r
  //       "2024-01-15" match { case datePattern(year, month, day) => (year, month, day) }
  //       Return the extracted tuple for "2024-01-15".
  def exercise4_regexExtractor(dateStr: String): (String, String, String) = ???

  // Exercise 5: Stable identifiers in patterns
  // TODO: In pattern matching, lowercase names create new variable bindings.
  //       To match against an existing val, use backticks: `myVal`
  //       val target = 42
  //       x match { case `target` => "found" case _ => "not found" }
  //       Return the result for x=42 and x=0.
  def exercise5_stableIdentifiers(x: Int): String = ???

  // Exercise 6: Variable binding with @
  // TODO: Use @ to bind a variable to an entire pattern:
  //       List(1, 2, 3) match { case all @ List(1, _*) => all.length }
  //       Match a list that starts with 1 and bind the whole list.
  //       Also: Some(x @ (_: Int)) to bind the inner value.
  //       Given a List[Int], if it starts with 1, return Some(the whole list), else None.
  def exercise6_variableBinding(list: List[Int]): Option[List[Int]] = ???

  // Exercise 7: Alternative patterns (|)
  // TODO: Use | to match multiple patterns:
  //       n match { case 1 | 2 | 3 => "small" case 4 | 5 | 6 => "medium" case _ => "large" }
  //       Return the result for a given Int.
  def exercise7_alternativePatterns(n: Int): String = ???

  // Exercise 8: Interpolation patterns (Scala 2.13+)
  // TODO: Use string interpolation in patterns:
  //       s"Hello, $name" pattern matching — note: this is limited in Scala 2.13.
  //       Instead, use regex: val greeting = "Hello, (.+)!".r
  //       "Hello, World!" match { case greeting(name) => name }
  //       Return the extracted name from "Hello, Scala!".
  def exercise8_interpolationPatterns(s: String): String = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_extractorObject(10) == Some(5), "Exercise 1 failed: 10")
    assert(exercise1_extractorObject(7) == None, "Exercise 1 failed: 7")

    assert(exercise2_unapplyMultiple("John Doe") == Some(("John", "Doe")), "Exercise 2 failed")
    assert(exercise2_unapplyMultiple("OnlyName") == None, "Exercise 2 failed: single")

    assert(exercise3_unapplySeq("hello world foo") == List("hello", "world", "foo"), "Exercise 3 failed")

    assert(exercise4_regexExtractor("2024-01-15") == ("2024", "01", "15"), "Exercise 4 failed")

    assert(exercise5_stableIdentifiers(42) == "found", "Exercise 5 failed: found")
    assert(exercise5_stableIdentifiers(0) == "not found", "Exercise 5 failed: not found")

    assert(exercise6_variableBinding(List(1, 2, 3)) == Some(List(1, 2, 3)), "Exercise 6 failed: match")
    assert(exercise6_variableBinding(List(2, 3, 4)) == None, "Exercise 6 failed: no match")

    assert(exercise7_alternativePatterns(2) == "small", "Exercise 7 failed: small")
    assert(exercise7_alternativePatterns(5) == "medium", "Exercise 7 failed: medium")
    assert(exercise7_alternativePatterns(10) == "large", "Exercise 7 failed: large")

    assert(exercise8_interpolationPatterns("Hello, Scala!") == "Scala", "Exercise 8 failed")

    println("All Core030_PatternMatchAdv exercises passed!")
  }
}
