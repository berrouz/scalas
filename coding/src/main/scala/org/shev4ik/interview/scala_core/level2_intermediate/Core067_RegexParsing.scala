package org.shev4ik.interview.scala_core.level2_intermediate

import scala.util.matching.Regex

object Core067_RegexParsing {

  // Exercise 1: Regex creation
  // TODO: Create regex patterns using:
  //       a) "pattern".r
  //       b) new Regex("pattern")
  //       Create a regex that matches email addresses (simplified)
  val emailRegex: Regex = ???

  // Exercise 2: findFirstIn
  // TODO: Use findFirstIn to find the first match in a string
  //       Find the first number in a text string
  val numberRegex: Regex = ???

  def findFirstNumber(text: String): Option[String] = ???

  // Exercise 3: findAllIn
  // TODO: Use findAllIn to find all matches in a string
  //       Find all words that start with a capital letter
  val capitalWordRegex: Regex = ???

  def findCapitalWords(text: String): List[String] = ???

  // Exercise 4: replaceAllIn
  // TODO: Use replaceAllIn to replace all matches
  //       Replace all digits with '#'
  def maskDigits(text: String): String = ???

  // TODO: Use replaceAllIn with a function to transform matches
  def doubleNumbers(text: String): String = ???

  // Exercise 5: Pattern matching with Regex
  // TODO: Use regex in pattern matching to extract parts
  //       Match and extract parts of a date string "YYYY-MM-DD"
  val dateRegex: Regex = ???

  def parseDate(text: String): Option[(Int, Int, Int)] = ???

  // Exercise 6: Capturing groups
  // TODO: Create a regex with named capturing groups
  //       Parse a URL into protocol, host, and optional port
  val urlRegex: Regex = ???

  def parseUrl(url: String): Option[(String, String, Option[Int])] = ???

  // Exercise 7: Regex extractors
  // TODO: Use regex as extractors in pattern matching
  //       Create extractors for different command formats:
  //       "GET /path", "POST /path body", "DELETE /path"
  val getRegex: Regex = ???
  val postRegex: Regex = ???
  val deleteRegex: Regex = ???

  def parseCommand(cmd: String): String = ???

  // Exercise 8: Combinator parsing intro
  // TODO: Implement a simple manual parser for arithmetic expressions
  //       using regex and basic parsing logic (not scala-parser-combinators)
  //       Parse and evaluate: "number + number" or "number * number"
  def evaluateSimpleExpr(expr: String): Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(emailRegex.findFirstIn("contact user@example.com today").isDefined, "should find email")
    assert(emailRegex.findFirstIn("no email here").isEmpty, "should not find email")

    // Exercise 2 assertions
    assert(findFirstNumber("abc 42 def") == Some("42"), "first number is 42")
    assert(findFirstNumber("no numbers") == None, "no numbers")

    // Exercise 3 assertions
    val capitals = findCapitalWords("Hello World from Scala Land")
    assert(capitals == List("Hello", "World", "Scala", "Land"), "capital words")

    // Exercise 4 assertions
    assert(maskDigits("Call 555-1234") == "Call ###-####", "mask digits")
    assert(doubleNumbers("I have 3 cats and 2 dogs") == "I have 6 cats and 4 dogs", "double numbers")

    // Exercise 5 assertions
    assert(parseDate("2024-01-15") == Some((2024, 1, 15)), "parse valid date")
    assert(parseDate("not a date") == None, "parse invalid date")

    // Exercise 6 assertions
    val url1 = parseUrl("https://example.com:8080")
    assert(url1 == Some(("https", "example.com", Some(8080))), "parse URL with port")
    val url2 = parseUrl("http://example.com")
    assert(url2 == Some(("http", "example.com", None)), "parse URL without port")

    // Exercise 7 assertions
    assert(parseCommand("GET /users") == "GET /users", "parse GET")
    assert(parseCommand("POST /users data") == "POST /users with body: data", "parse POST")
    assert(parseCommand("DELETE /users/1") == "DELETE /users/1", "parse DELETE")

    // Exercise 8 assertions
    assert(evaluateSimpleExpr("3 + 4") == Some(7), "3 + 4 = 7")
    assert(evaluateSimpleExpr("5 * 6") == Some(30), "5 * 6 = 30")
    assert(evaluateSimpleExpr("invalid") == None, "invalid expression")

    println("All Core067_RegexParsing exercises passed!")
  }
}
