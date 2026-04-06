package org.shev4ik.interview.scala_core.level2_intermediate

object Core037_ImplicitClasses {

  // Exercise 1: Extension method
  // TODO: Create an implicit class that adds a `isEven` method to Int
  implicit class IntExtensions(val n: Int) extends AnyVal {
    def isEven: Boolean = ???
  }

  // Exercise 2: Rich wrapper
  // TODO: Create an implicit class RichString that adds:
  //       - `words: List[String]` (split by whitespace)
  //       - `isPalindrome: Boolean`
  implicit class RichString(val s: String) extends AnyVal {
    def words: List[String] = ???
    def isPalindrome: Boolean = ???
  }

  // Exercise 3: Adding operators
  // TODO: Create an implicit class that adds |> (pipe) operator to any type A
  //       `a |> f` should apply f to a, i.e., f(a)
  implicit class PipeOps[A](val a: A) extends AnyVal {
    def |>[B](f: A => B): B = ???
  }

  // Exercise 4: Chaining extensions
  // TODO: Create an implicit class for List[Int] that adds:
  //       - `average: Double`
  //       - `median: Double`
  implicit class ListIntOps(val list: List[Int]) extends AnyVal {
    def average: Double = ???
    def median: Double = ???
  }

  // Exercise 5: Generic extension
  // TODO: Create an implicit class for Option[A] that adds:
  //       - `orElseThrow(msg: String): A` - gets value or throws with message
  //       - `tap(f: A => Unit): Option[A]` - applies side effect if defined, returns self
  implicit class RichOption[A](val opt: Option[A]) extends AnyVal {
    def orElseThrow(msg: String): A = ???
    def tap(f: A => Unit): Option[A] = ???
  }

  // Exercise 6: Extension with constraint
  // TODO: Create an implicit class for List[A] that adds a `second: Option[A]` method
  //       Also add `penultimate: Option[A]` (second to last)
  implicit class ListOps[A](val list: List[A]) extends AnyVal {
    def second: Option[A] = ???
    def penultimate: Option[A] = ???
  }

  // Exercise 7: Value class extension
  // TODO: Create an implicit value class that adds `times(f: => Unit): Unit` to Int
  //       executing the function n times. Also add `clamp(min: Int, max: Int): Int`.
  implicit class IntOps(val n: Int) extends AnyVal {
    def times(f: => Unit): Unit = ???
    def clamp(min: Int, max: Int): Int = ???
  }

  // Exercise 8: Extension scope
  // TODO: Create extension methods in a separate object `SyntaxExtensions`
  //       Add `show` method to Any that returns toString wrapped in quotes
  //       Import and use in tests
  object SyntaxExtensions {
    implicit class ShowOps(val a: Any) {
      def show: String = ???
    }
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(4.isEven, "4 should be even")
    assert(!3.isEven, "3 should not be even")

    // Exercise 2 assertions
    assert("hello world foo".words == List("hello", "world", "foo"), "words should split by whitespace")
    assert("racecar".isPalindrome, "racecar is a palindrome")
    assert(!"hello".isPalindrome, "hello is not a palindrome")

    // Exercise 3 assertions
    assert((5 |> (_ * 2)) == 10, "pipe should apply function")
    assert(("hello" |> (_.length)) == 5, "pipe should work with strings")

    // Exercise 4 assertions
    assert(List(1, 2, 3, 4, 5).average == 3.0, "average of 1-5")
    assert(List(1, 2, 3, 4, 5).median == 3.0, "median of 1-5")
    assert(List(1, 2, 3, 4).median == 2.5, "median of 1-4")

    // Exercise 5 assertions
    assert(Some(42).orElseThrow("error") == 42, "orElseThrow on Some")
    try {
      None.orElseThrow("missing value")
      assert(false, "should have thrown")
    } catch {
      case e: RuntimeException => assert(e.getMessage == "missing value")
    }
    var sideEffect = 0
    Some(42).tap(_ => sideEffect += 1)
    assert(sideEffect == 1, "tap should execute side effect")

    // Exercise 6 assertions
    assert(List(1, 2, 3).second == Some(2), "second of 3-element list")
    assert(List(1).second == None, "second of 1-element list")
    assert(List(1, 2, 3).penultimate == Some(2), "penultimate of 3-element list")
    assert(List(1).penultimate == None, "penultimate of 1-element list")

    // Exercise 7 assertions
    var counter = 0
    3.times { counter += 1 }
    assert(counter == 3, "times should execute 3 times")
    assert(5.clamp(1, 10) == 5, "5 clamped to [1,10]")
    assert(0.clamp(1, 10) == 1, "0 clamped to [1,10]")
    assert(15.clamp(1, 10) == 10, "15 clamped to [1,10]")

    // Exercise 8 assertions
    import SyntaxExtensions._
    assert(42.show == "\"42\"", "show should wrap in quotes")
    assert("hello".show == "\"hello\"", "show should wrap string in quotes")

    println("All Core037_ImplicitClasses exercises passed!")
  }
}
