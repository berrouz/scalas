package org.shev4ik.interview.scala_core.level2_intermediate

object Core036_ImplicitsBasic {

  // Exercise 1: Implicit parameter
  // TODO: Define a method `greet` that takes a name: String and an implicit greeting: String
  //       Returns "$greeting, $name!"
  def greet(name: String)(implicit greeting: String): String = ???

  // Exercise 2: Implicit val
  // TODO: Define an implicit val `defaultGreeting` of type String with value "Hello"
  //       Then call `greet("World")` without passing the implicit explicitly
  implicit val defaultGreeting: String = ???

  def greetWorld(): String = ???

  // Exercise 3: Implicit def conversion
  // TODO: Create an implicit conversion from Int to a RichDuration class
  //       that has a `seconds` method returning s"$n seconds"
  case class RichDuration(n: Int) {
    def seconds: String = ???
  }
  implicit def intToRichDuration(n: Int): RichDuration = ???

  // Exercise 4: Implicit class
  // TODO: Create an implicit class StringOps that adds a `repeat(n: Int): String`
  //       method to String, repeating the string n times separated by spaces
  implicit class StringOps(val s: String) extends AnyVal {
    def repeat(n: Int): String = ???
  }

  // Exercise 5: implicitly[]
  // TODO: Define a trait Show[A] with method `show(a: A): String`
  //       Create an implicit Show[Int] instance
  //       Implement `showValue` using implicitly[Show[A]] to access the instance
  trait Show[A] {
    def show(a: A): String
  }
  implicit val intShow: Show[Int] = ???

  def showValue[A: Show](a: A): String = ???

  // Exercise 6: Implicit scope
  // TODO: Create a case class Currency(amount: Double, code: String)
  //       Put an implicit Ordering[Currency] in the Currency companion object
  //       so it's found automatically (companion object is part of implicit scope)
  case class Currency(amount: Double, code: String)
  object Currency {
    implicit val ordering: Ordering[Currency] = ???
  }

  // Exercise 7: Import implicits
  // TODO: Create an object MathImplicits containing an implicit class
  //       that adds a `squared` method to Int
  //       In the test, we'll import MathImplicits._ to bring it into scope
  object MathImplicits {
    implicit class IntMathOps(val n: Int) extends AnyVal {
      def squared: Int = ???
    }
  }

  // Exercise 8: Implicit resolution order
  // TODO: Demonstrate implicit resolution priority.
  //       Create a trait Formatter[A] with format(a: A): String
  //       Provide a default instance in the Formatter companion object
  //       and a higher-priority one in local scope. The local one should win.
  trait Formatter[A] {
    def format(a: A): String
  }
  object Formatter {
    implicit val defaultIntFormatter: Formatter[Int] = ???
  }

  def formatValue[A](a: A)(implicit f: Formatter[A]): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(greet("Scala")("Hi") == "Hi, Scala!", "greet with explicit implicit")

    // Exercise 2 assertions
    assert(greetWorld() == "Hello, World!", "greetWorld should use implicit greeting")

    // Exercise 3 assertions
    assert(5.seconds == "5 seconds", "implicit conversion to RichDuration")
    assert(1.seconds == "1 seconds", "implicit conversion for 1")

    // Exercise 4 assertions
    assert("ha".repeat(3) == "ha ha ha", "repeat should repeat with spaces")
    assert("x".repeat(1) == "x", "repeat 1 should return original")

    // Exercise 5 assertions
    assert(showValue(42) == "42", "showValue should use implicit Show[Int]")

    // Exercise 6 assertions
    val currencies = List(Currency(100, "USD"), Currency(50, "USD"), Currency(200, "USD"))
    assert(currencies.sorted.head == Currency(50, "USD"), "Currency ordering by amount")

    // Exercise 7 assertions
    import MathImplicits._
    assert(5.squared == 25, "squared should return n*n")
    assert(3.squared == 9, "3 squared should be 9")

    // Exercise 8 assertions
    assert(formatValue(42)(Formatter.defaultIntFormatter).nonEmpty, "default formatter should work")
    // Local implicit should take priority
    implicit val localFormatter: Formatter[Int] = new Formatter[Int] {
      def format(a: Int): String = s"[[$a]]"
    }
    assert(formatValue(42) == "[[42]]", "local implicit should take priority")

    println("All Core036_ImplicitsBasic exercises passed!")
  }
}
