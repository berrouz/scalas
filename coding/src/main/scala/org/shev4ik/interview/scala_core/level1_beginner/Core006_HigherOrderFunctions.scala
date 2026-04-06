package org.shev4ik.interview.scala_core.level1_beginner

object Core006_HigherOrderFunctions {

  // Exercise 1: Passing functions as arguments
  // TODO: Define a function `applyTwice` that takes a function f: Int => Int and a value x: Int.
  //       It should return f(f(x)).
  def exercise1_applyTwice(f: Int => Int, x: Int): Int = ???

  // Exercise 2: Returning functions
  // TODO: Define a function `multiplier` that takes a factor: Int and returns a function Int => Int
  //       that multiplies its argument by the factor.
  def exercise2_multiplier(factor: Int): Int => Int = ???

  // Exercise 3: map
  // TODO: Given List(1, 2, 3, 4, 5), use map to return a list where each element is doubled.
  def exercise3_map: List[Int] = ???

  // Exercise 4: filter
  // TODO: Given List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), use filter to return only even numbers.
  def exercise4_filter: List[Int] = ???

  // Exercise 5: reduce
  // TODO: Given List(1, 2, 3, 4, 5), use reduce to compute the sum of all elements.
  //       Also use reduce to find the maximum. Return (sum, max).
  def exercise5_reduce: (Int, Int) = ???

  // Exercise 6: Anonymous functions (lambdas)
  // TODO: Use an anonymous function (lambda) with map to convert List("hello", "world", "scala")
  //       to their lengths. Return the resulting list.
  def exercise6_anonymousFunctions: List[Int] = ???

  // Exercise 7: Underscore syntax
  // TODO: Use underscore shorthand to:
  //       1. Double each element in List(1, 2, 3) using map(_ * 2)
  //       2. Filter elements > 3 from List(1, 2, 3, 4, 5) using filter(_ > 3)
  //       Return (doubled, filtered).
  def exercise7_underscoreSyntax: (List[Int], List[Int]) = ???

  // Exercise 8: compose and andThen
  // TODO: Given f: Int => Int = _ + 1 and g: Int => Int = _ * 2
  //       Compute composed = f.compose(g) — applies g first, then f => (x*2)+1
  //       Compute piped = f.andThen(g) — applies f first, then g => (x+1)*2
  //       Return (composed(5), piped(5)).
  def exercise8_composeAndThen: (Int, Int) = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_applyTwice(_ + 1, 5) == 7, "Exercise 1 failed: +1 twice")
    assert(exercise1_applyTwice(_ * 2, 3) == 12, "Exercise 1 failed: *2 twice")

    val triple = exercise2_multiplier(3)
    assert(triple(5) == 15, "Exercise 2 failed: triple")
    assert(exercise2_multiplier(0)(100) == 0, "Exercise 2 failed: zero")

    assert(exercise3_map == List(2, 4, 6, 8, 10), "Exercise 3 failed")

    assert(exercise4_filter == List(2, 4, 6, 8, 10), "Exercise 4 failed")

    assert(exercise5_reduce == (15, 5), "Exercise 5 failed")

    assert(exercise6_anonymousFunctions == List(5, 5, 5), "Exercise 6 failed")

    val (doubled, filtered) = exercise7_underscoreSyntax
    assert(doubled == List(2, 4, 6), "Exercise 7 failed: doubled")
    assert(filtered == List(4, 5), "Exercise 7 failed: filtered")

    assert(exercise8_composeAndThen == (11, 12), "Exercise 8 failed")

    println("All Core006_HigherOrderFunctions exercises passed!")
  }
}
