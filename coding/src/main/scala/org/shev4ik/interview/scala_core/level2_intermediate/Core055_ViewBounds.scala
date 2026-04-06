package org.shev4ik.interview.scala_core.level2_intermediate

object Core055_ViewBounds {

  // Exercise 1: View bound syntax (deprecated)
  // TODO: View bounds (A <% B) are DEPRECATED in Scala 2.13 and removed in Scala 3.
  //       The old syntax was: def method[A <% Ordered[A]](list: List[A]): A
  //       This meant: there must be an implicit conversion from A to Ordered[A]
  //       Show the modern equivalent using an implicit parameter.
  //       Implement `sortList` using implicit Ordering instead of view bound.
  def sortList[A](list: List[A])(implicit ord: Ordering[A]): List[A] = ???

  // Exercise 2: Replacement with implicit evidence
  // TODO: The old view bound `A <% B` desugars to `(implicit ev: A => B)`
  //       Write a method that takes a list and converts each element to String
  //       using an implicit conversion parameter
  def allToString[A](list: List[A])(implicit conv: A => String): List[String] = ???

  // Exercise 3: Ordered view bound
  // TODO: The most common view bound was `A <% Ordered[A]`
  //       Modern replacement: use Ordering type class instead
  //       Implement `findMax` using Ordering (not Ordered/view bound)
  def findMax[A: Ordering](list: List[A]): Option[A] = ???

  // Exercise 4: Migration to context bound
  // TODO: Demonstrate migrating from view bound to context bound
  //       Old: def sort[A <% Ordered[A]](list: List[A]): List[A]
  //       New: def sort[A: Ordering](list: List[A]): List[A]
  //       Implement a method `insertionSort` using context bound Ordering
  def insertionSort[A: Ordering](list: List[A]): List[A] = ???

  // Exercise 5: View bound vs context bound
  // TODO: Explain the conceptual difference:
  //       - View bound: "A can be VIEWED AS B" (implicit conversion exists)
  //       - Context bound: "A HAS A B" (type class instance exists)
  //       Implement `compare` using context bound Ordering to compare two values
  //       Return -1, 0, or 1
  def compare[A: Ordering](a: A, b: A): Int = ???

  // Exercise 6: Implicit conversion alternative
  // TODO: Instead of a view bound, use an implicit conversion parameter
  //       Create a method that works with any type that can be implicitly
  //       converted to HasLength (a custom trait)
  trait HasLength {
    def length: Int
  }

  // Provide implicit conversions from String and List to HasLength
  implicit def stringHasLength(s: String): HasLength = ???
  implicit def listHasLength[A](l: List[A]): HasLength = ???

  def getLength[A](a: A)(implicit conv: A => HasLength): Int = ???

  // Exercise 7: Backwards compatibility
  // TODO: When maintaining old code that used view bounds, the migration path is:
  //       1. Replace <% with implicit parameter
  //       2. Or replace with context bound where applicable
  //       Implement both styles for a `minMax` function
  //       Style 1: implicit parameter
  def minMax1[A](list: List[A])(implicit ord: Ordering[A]): Option[(A, A)] = ???
  //       Style 2: context bound
  def minMax2[A: Ordering](list: List[A]): Option[(A, A)] = ???

  // Exercise 8: Modern equivalents
  // TODO: Create a comprehensive example showing the modern way to handle
  //       what view bounds used to do. Define a Convertible type class
  //       and use context bounds.
  trait Convertible[A, B] {
    def convert(a: A): B
  }
  object Convertible {
    implicit val intToString: Convertible[Int, String] = ???
    implicit val doubleToString: Convertible[Double, String] = ???
    implicit val stringToInt: Convertible[String, Int] = ???
  }

  def convert[A, B](a: A)(implicit conv: Convertible[A, B]): B = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(sortList(List(3, 1, 2)) == List(1, 2, 3), "sortList ints")
    assert(sortList(List("c", "a", "b")) == List("a", "b", "c"), "sortList strings")

    // Exercise 2 assertions
    implicit val intToStr: Int => String = _.toString
    assert(allToString(List(1, 2, 3)) == List("1", "2", "3"), "allToString with implicit conv")

    // Exercise 3 assertions
    assert(findMax(List(3, 1, 5, 2)) == Some(5), "findMax should return 5")
    assert(findMax(List.empty[Int]) == None, "findMax of empty")

    // Exercise 4 assertions
    assert(insertionSort(List(5, 3, 1, 4, 2)) == List(1, 2, 3, 4, 5), "insertionSort")

    // Exercise 5 assertions
    assert(compare(1, 2) < 0, "1 < 2")
    assert(compare(2, 2) == 0, "2 == 2")
    assert(compare(3, 2) > 0, "3 > 2")

    // Exercise 6 assertions
    assert(getLength("hello") == 5, "string length")
    assert(getLength(List(1, 2, 3)) == 3, "list length")

    // Exercise 7 assertions
    assert(minMax1(List(3, 1, 5, 2)) == Some((1, 5)), "minMax1")
    assert(minMax2(List(3, 1, 5, 2)) == Some((1, 5)), "minMax2")
    assert(minMax1(List.empty[Int]) == None, "minMax1 empty")
    assert(minMax2(List.empty[Int]) == None, "minMax2 empty")

    // Exercise 8 assertions
    assert(convert[Int, String](42) == "42", "convert Int to String")
    assert(convert[Double, String](3.14) == "3.14", "convert Double to String")
    assert(convert[String, Int]("42") == 42, "convert String to Int")

    println("All Core055_ViewBounds exercises passed!")
  }
}
