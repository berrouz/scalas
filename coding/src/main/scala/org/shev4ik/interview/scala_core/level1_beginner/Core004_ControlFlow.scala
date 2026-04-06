package org.shev4ik.interview.scala_core.level1_beginner

object Core004_ControlFlow {

  // Exercise 1: if/else as expression
  // TODO: Given a number n, return "positive" if n > 0, "negative" if n < 0, "zero" otherwise.
  //       Use if/else as an expression (assign result directly).
  def exercise1_ifElseExpression(n: Int): String = ???

  // Exercise 2: Nested if
  // TODO: Given age, return a category:
  //       age < 13 => "child", 13-17 => "teenager", 18-64 => "adult", >= 65 => "senior"
  def exercise2_nestedIf(age: Int): String = ???

  // Exercise 3: Match basics
  // TODO: Given a day number (1-7), return the day name.
  //       1 => "Monday", 2 => "Tuesday", ..., 7 => "Sunday", _ => "Invalid"
  def exercise3_matchBasics(day: Int): String = ???

  // Exercise 4: While loop
  // TODO: Using a while loop, compute the sum of integers from 1 to n (inclusive).
  //       Return the sum.
  def exercise4_whileLoop(n: Int): Int = ???

  // Exercise 5: Do-while loop
  // TODO: Using a do-while loop, find the smallest power of 2 that is >= n.
  //       Start with result = 1, keep doubling until result >= n. Return result.
  def exercise5_doWhile(n: Int): Int = ???

  // Exercise 6: For loop with yield
  // TODO: Using a for/yield expression, return a List of squares of numbers from 1 to n.
  //       e.g., n=4 => List(1, 4, 9, 16)
  def exercise6_forLoop(n: Int): List[Int] = ???

  // Exercise 7: Return value of if
  // TODO: Demonstrate that if/else returns a value. Given (a, b), return the maximum
  //       using a single if/else expression (no explicit return keyword).
  def exercise7_ifReturnValue(a: Int, b: Int): Int = ???

  // Exercise 8: Ternary equivalent
  // TODO: Scala has no ternary operator (?:). Instead, use if/else as an expression.
  //       Given a boolean flag, return "yes" if true, "no" if false.
  def exercise8_ternaryEquivalent(flag: Boolean): String = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_ifElseExpression(5) == "positive", "Exercise 1 failed: positive")
    assert(exercise1_ifElseExpression(-3) == "negative", "Exercise 1 failed: negative")
    assert(exercise1_ifElseExpression(0) == "zero", "Exercise 1 failed: zero")

    assert(exercise2_nestedIf(10) == "child", "Exercise 2 failed: child")
    assert(exercise2_nestedIf(15) == "teenager", "Exercise 2 failed: teenager")
    assert(exercise2_nestedIf(30) == "adult", "Exercise 2 failed: adult")
    assert(exercise2_nestedIf(70) == "senior", "Exercise 2 failed: senior")

    assert(exercise3_matchBasics(1) == "Monday", "Exercise 3 failed: Monday")
    assert(exercise3_matchBasics(5) == "Friday", "Exercise 3 failed: Friday")
    assert(exercise3_matchBasics(7) == "Sunday", "Exercise 3 failed: Sunday")
    assert(exercise3_matchBasics(0) == "Invalid", "Exercise 3 failed: Invalid")

    assert(exercise4_whileLoop(10) == 55, "Exercise 4 failed")
    assert(exercise4_whileLoop(1) == 1, "Exercise 4 failed: 1")

    assert(exercise5_doWhile(1) == 1, "Exercise 5 failed: 1")
    assert(exercise5_doWhile(5) == 8, "Exercise 5 failed: 5")
    assert(exercise5_doWhile(16) == 16, "Exercise 5 failed: 16")

    assert(exercise6_forLoop(4) == List(1, 4, 9, 16), "Exercise 6 failed")
    assert(exercise6_forLoop(1) == List(1), "Exercise 6 failed: 1")

    assert(exercise7_ifReturnValue(3, 7) == 7, "Exercise 7 failed")
    assert(exercise7_ifReturnValue(10, 2) == 10, "Exercise 7 failed")

    assert(exercise8_ternaryEquivalent(true) == "yes", "Exercise 8 failed: true")
    assert(exercise8_ternaryEquivalent(false) == "no", "Exercise 8 failed: false")

    println("All Core004_ControlFlow exercises passed!")
  }
}
