package org.shev4ik.interview.scala_core.level2_intermediate

object Core058_ExistentialTypes {

  // Exercise 1: forSome syntax
  // TODO: Note: forSome is deprecated in Scala 2.13 and removed in Scala 3
  //       The old syntax: List[T] forSome { type T }  is equivalent to List[_]
  //       Implement a method that takes a List of any type and returns its length
  def anyListLength(list: List[_]): Int = ???

  // Exercise 2: Wildcard types _
  // TODO: The wildcard _ is the recommended way to express existential types in 2.13
  //       Implement a method that takes a Map with any key and value types
  //       and returns the number of entries
  def mapSize(map: Map[_, _]): Int = ???

  // Exercise 3: Existential in Java interop
  // TODO: Java's raw types (e.g., java.util.List) map to existential types in Scala
  //       Create a method that accepts a Java-style raw collection
  //       and converts it to a Scala List[Any]
  def fromJavaList(jlist: java.util.List[_]): List[Any] = ???

  // Exercise 4: Existential vs universal
  // TODO: Universal: for ALL types A, the method works -> def method[A](list: List[A]): Int
  //       Existential: there EXISTS some type -> List[_]
  //       Universal is more precise. Show both and the difference.
  //       Universal version: returns the first element (typed)
  def headUniversal[A](list: List[A]): Option[A] = ???
  //       Existential version: returns first element (untyped)
  def headExistential(list: List[_]): Option[Any] = ???

  // Exercise 5: Type erasure and existential
  // TODO: Due to type erasure, you can't pattern match on generic types at runtime
  //       Demonstrate this by creating a method that tries to check if
  //       a value is a List[Int] vs List[String] (both erase to List)
  def isListOfInt(x: Any): String = ???

  // Exercise 6: Existential and pattern match
  // TODO: Show how to work with existential types in pattern matching
  //       Match on the structure, not the type parameter
  def describeCollection(x: Any): String = ???

  // Exercise 7: Existential elimination
  // TODO: Convert code using existential types to use universal quantification
  //       Old: def process(items: List[_ <: Number]): Double
  //       New: def process[A <: Number](items: List[A]): Double
  //       Implement: sum of a list of Numbers
  def sumNumbers[A <: Number](items: List[A]): Double = ???

  // Exercise 8: Existential in collections
  // TODO: Create a heterogeneous list using existential types
  //       A list of Wrappers where each can hold a different type
  case class Wrapper[A](value: A, show: A => String) {
    def display: String = show(value)
  }

  // TODO: Create a list of different Wrappers and display them all
  def createMixedList(): List[Wrapper[_]] = ???
  def displayAll(wrappers: List[Wrapper[_]]): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(anyListLength(List(1, 2, 3)) == 3, "list length of ints")
    assert(anyListLength(List("a", "b")) == 2, "list length of strings")

    // Exercise 2 assertions
    assert(mapSize(Map("a" -> 1, "b" -> 2)) == 2, "map size")
    assert(mapSize(Map.empty[String, Int]) == 0, "empty map size")

    // Exercise 3 assertions
    val jlist = new java.util.ArrayList[String]()
    jlist.add("hello")
    jlist.add("world")
    assert(fromJavaList(jlist) == List("hello", "world"), "fromJavaList")

    // Exercise 4 assertions
    assert(headUniversal(List(1, 2, 3)) == Some(1), "headUniversal")
    assert(headExistential(List(1, 2, 3)) == Some(1), "headExistential")
    assert(headUniversal(List.empty[Int]) == None, "headUniversal empty")

    // Exercise 5 assertions
    val result5 = isListOfInt(List(1, 2, 3))
    // Due to erasure, we can only know it's a List, not List[Int] specifically
    assert(result5.contains("List"), "should mention List")

    // Exercise 6 assertions
    assert(describeCollection(List(1, 2)) == "List of 2 elements", "describe List")
    assert(describeCollection(Map("a" -> 1)) == "Map of 1 entries", "describe Map")
    assert(describeCollection("hello") == "not a collection", "describe non-collection")

    // Exercise 7 assertions
    val numbers: List[java.lang.Integer] = List(1, 2, 3).map(Integer.valueOf)
    assert(sumNumbers(numbers) == 6.0, "sumNumbers")

    // Exercise 8 assertions
    val mixed = createMixedList()
    assert(mixed.nonEmpty, "mixed list should not be empty")
    val displayed = displayAll(mixed)
    assert(displayed.nonEmpty, "displayAll should produce strings")
    assert(displayed.forall(_.nonEmpty), "all displays should be non-empty")

    println("All Core058_ExistentialTypes exercises passed!")
  }
}
