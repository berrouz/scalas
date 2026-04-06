package org.shev4ik.interview.scala_core.level1_beginner

object Core007_Tuples {

  // Exercise 1: Tuple creation
  // TODO: Create a tuple of (Int, String, Double) with values (1, "hello", 3.14).
  //       Return it.
  def exercise1_tupleCreation: (Int, String, Double) = ???

  // Exercise 2: Accessing elements
  // TODO: Given the tuple (10, "scala", true), return its second element using ._2
  //       and its third element using ._3. Return (second, third).
  def exercise2_accessingElements: (String, Boolean) = ???

  // Exercise 3: Pattern matching tuples
  // TODO: Given a tuple (String, Int), pattern match to return a formatted string.
  //       ("Alice", 30) => "Alice is 30 years old"
  def exercise3_patternMatchTuple(person: (String, Int)): String = ???

  // Exercise 4: Tuple swap
  // TODO: Given a tuple (Int, String), use .swap to return (String, Int).
  //       e.g., (1, "one") => ("one", 1)
  def exercise4_tupleSwap(t: (Int, String)): (String, Int) = ???

  // Exercise 5: Zipping lists to tuples
  // TODO: Given List("a", "b", "c") and List(1, 2, 3), use .zip to create
  //       a List of tuples: List(("a", 1), ("b", 2), ("c", 3)).
  def exercise5_zipping: List[(String, Int)] = ???

  // Exercise 6: Unzipping
  // TODO: Given List(("a", 1), ("b", 2), ("c", 3)), use .unzip to separate into
  //       two lists. Return (List("a", "b", "c"), List(1, 2, 3)).
  def exercise6_unzipping: (List[String], List[Int]) = ???

  // Exercise 7: Tuples in Maps
  // TODO: Create a Map from a list of tuples: List(("one", 1), ("two", 2), ("three", 3)).
  //       Then convert it back to a list of tuples using .toList.sorted (sorted by key).
  //       Return the sorted list of tuples.
  def exercise7_tuplesInMaps: List[(String, Int)] = ???

  // Exercise 8: productIterator
  // TODO: Given the tuple (1, "two", 3.0), use .productIterator.toList to convert
  //       it to a List[Any]. Return the list.
  def exercise8_productIterator: List[Any] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_tupleCreation == (1, "hello", 3.14), "Exercise 1 failed")

    assert(exercise2_accessingElements == ("scala", true), "Exercise 2 failed")

    assert(exercise3_patternMatchTuple(("Alice", 30)) == "Alice is 30 years old", "Exercise 3 failed")
    assert(exercise3_patternMatchTuple(("Bob", 25)) == "Bob is 25 years old", "Exercise 3 failed: Bob")

    assert(exercise4_tupleSwap((1, "one")) == ("one", 1), "Exercise 4 failed")

    assert(exercise5_zipping == List(("a", 1), ("b", 2), ("c", 3)), "Exercise 5 failed")

    assert(exercise6_unzipping == (List("a", "b", "c"), List(1, 2, 3)), "Exercise 6 failed")

    assert(exercise7_tuplesInMaps == List(("one", 1), ("three", 3), ("two", 2)), "Exercise 7 failed")

    assert(exercise8_productIterator == List(1, "two", 3.0), "Exercise 8 failed")

    println("All Core007_Tuples exercises passed!")
  }
}
