package org.shev4ik.interview.scala_core.level2_intermediate

object Core043_AdvancedPM {

  // Exercise 1: Custom extractor (unapply)
  // TODO: Create an object Email with an unapply method that extracts
  //       (user, domain) from an email string like "user@domain.com"
  //       Return None if the string doesn't contain exactly one '@'
  object Email {
    def unapply(email: String): Option[(String, String)] = ???
  }

  // Exercise 2: unapplySeq
  // TODO: Create an object Words with unapplySeq that splits a string into words
  //       so you can pattern match like: str match { case Words(a, b, c) => ... }
  object Words {
    def unapplySeq(str: String): Option[Seq[String]] = ???
  }

  // Exercise 3: Boolean extractors
  // TODO: Create an object EvenNumber with a boolean unapply (returns Boolean)
  //       that matches if the integer is even
  object EvenNumber {
    def unapply(n: Int): Boolean = ???
  }

  // Exercise 4: Parameterized extractors
  // TODO: Create a class DivisibleBy(d: Int) with unapply that checks
  //       if a given number is divisible by d. Return the quotient if true.
  class DivisibleBy(d: Int) {
    def unapply(n: Int): Option[Int] = ???
  }

  // Exercise 5: Regex extractors
  // TODO: Create a regex that extracts date components from "YYYY-MM-DD" format
  //       Use Scala's Regex with capturing groups for pattern matching
  val DatePattern: scala.util.matching.Regex = ???

  def parseDate(s: String): Option[(Int, Int, Int)] = ???

  // Exercise 6: Destructuring assignment
  // TODO: Implement a method that returns a tuple and demonstrate destructuring
  //       Also demonstrate nested destructuring with case classes
  case class Address(street: String, city: String)
  case class Contact(name: String, address: Address)

  def getContact(): Contact = ???

  def extractCity(contact: Contact): String = ???

  // Exercise 7: Pattern in for-comprehension
  // TODO: Given a list of (String, Int) pairs, use pattern matching in
  //       for-comprehension to filter and transform:
  //       - Extract only pairs where the Int > 0
  //       - Return formatted strings like "name: value"
  def positiveEntries(entries: List[(String, Int)]): List[String] = ???

  // Exercise 8: Active patterns (simulated)
  // TODO: Create extractor objects that classify integers:
  //       Positive, Negative, Zero - each with unapply returning Boolean
  //       Use them in a classify method
  object Positive {
    def unapply(n: Int): Boolean = ???
  }
  object Negative {
    def unapply(n: Int): Boolean = ???
  }
  object Zero {
    def unapply(n: Int): Boolean = ???
  }

  def classify(n: Int): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(("user@domain.com" match {
      case Email(u, d) => s"$u at $d"
      case _ => "no match"
    }) == "user at domain.com", "Email extractor should match")
    assert(("invalid" match {
      case Email(_, _) => true
      case _ => false
    }) == false, "Email extractor should not match invalid")

    // Exercise 2 assertions
    assert(("hello world foo" match {
      case Words(a, b, c) => s"$a-$b-$c"
      case _ => "no match"
    }) == "hello-world-foo", "Words extractor should match 3 words")
    assert(("one two" match {
      case Words(a, b) => true
      case _ => false
    }) == true, "Words should match 2 words")

    // Exercise 3 assertions
    assert((4 match { case EvenNumber() => true; case _ => false }), "4 is even")
    assert(!(3 match { case EvenNumber() => true; case _ => false }), "3 is not even")

    // Exercise 4 assertions
    val div3 = new DivisibleBy(3)
    assert((9 match { case div3(q) => q; case _ => -1 }) == 3, "9 / 3 = 3")
    assert((10 match { case div3(q) => q; case _ => -1 }) == -1, "10 not divisible by 3")

    // Exercise 5 assertions
    assert(parseDate("2024-01-15") == Some((2024, 1, 15)), "parseDate valid date")
    assert(parseDate("invalid") == None, "parseDate invalid string")

    // Exercise 6 assertions
    val contact = getContact()
    assert(extractCity(contact).nonEmpty, "extractCity should return a city")

    // Exercise 7 assertions
    val entries = List(("a", 1), ("b", -2), ("c", 3), ("d", 0))
    val result = positiveEntries(entries)
    assert(result == List("a: 1", "c: 3"), "positiveEntries should filter positive values")

    // Exercise 8 assertions
    assert(classify(5) == "positive", "5 is positive")
    assert(classify(-3) == "negative", "-3 is negative")
    assert(classify(0) == "zero", "0 is zero")

    println("All Core043_AdvancedPM exercises passed!")
  }
}
