package org.shev4ik.interview.scala_core.level1_beginner

import scala.util.Try
import scala.util.control.NonFatal

object Core023_Exceptions {

  // Exercise 1: throw
  // TODO: Write a function that takes an Int and throws IllegalArgumentException
  //       if the value is negative, otherwise returns the value.
  def exercise1_throw(n: Int): Int = ???

  // Exercise 2: try/catch/finally
  // TODO: Wrap "abc".toInt in try/catch. Catch NumberFormatException and return -1.
  //       Return the result.
  def exercise2_tryCatch: Int = ???

  // Exercise 3: Catching specific exceptions
  // TODO: Write a function that divides a by b. Catch ArithmeticException (division by zero)
  //       and return 0 in that case. Also catch any other Exception and return -1.
  def exercise3_specificExceptions(a: Int, b: Int): Int = ???

  // Exercise 4: NonFatal
  // TODO: Use NonFatal to catch only non-fatal exceptions:
  //       try { "abc".toInt } catch { case NonFatal(e) => -1 }
  //       This is safer than catching Throwable. Return the result.
  def exercise4_nonFatal: Int = ???

  // Exercise 5: Try wrapping
  // TODO: Use scala.util.Try to safely wrap a computation:
  //       Try("42".toInt).getOrElse(-1) => 42
  //       Try("abc".toInt).getOrElse(-1) => -1
  //       Return (successResult, failureResult).
  def exercise5_tryWrapping: (Int, Int) = ???

  // Exercise 6: Custom exceptions
  // TODO: Define a custom exception class: class ValidationException(msg: String) extends Exception(msg)
  //       Write a function that throws ValidationException("too short") if a string has length < 3.
  //       Otherwise return the string. Wrap the call in Try and return the result's getMessage on failure.
  class ValidationException(msg: String) extends Exception(msg)

  def exercise6_customExceptions(s: String): Either[String, String] = ???

  // Exercise 7: scala.util.control
  // TODO: Use scala.util.control.Exception.catching to safely parse an Int:
  //       import scala.util.control.Exception._
  //       catching(classOf[NumberFormatException]).opt("42".toInt) => Some(42)
  //       catching(classOf[NumberFormatException]).opt("abc".toInt) => None
  //       Return (result1, result2).
  def exercise7_controlException: (Option[Int], Option[Int]) = ???

  // Exercise 8: Either from exceptions
  // TODO: Write a safe division function that returns Either[String, Int]:
  //       Right(a / b) if b != 0, Left("Division by zero") if b == 0.
  //       Use try/catch or if/else.
  def exercise8_eitherFromExceptions(a: Int, b: Int): Either[String, Int] = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_throw(5) == 5, "Exercise 1 failed: positive")
    var threw = false
    try { exercise1_throw(-1) } catch { case _: IllegalArgumentException => threw = true }
    assert(threw, "Exercise 1 failed: should throw")

    assert(exercise2_tryCatch == -1, "Exercise 2 failed")

    assert(exercise3_specificExceptions(10, 2) == 5, "Exercise 3 failed: normal")
    assert(exercise3_specificExceptions(10, 0) == 0, "Exercise 3 failed: div by zero")

    assert(exercise4_nonFatal == -1, "Exercise 4 failed")

    assert(exercise5_tryWrapping == (42, -1), "Exercise 5 failed")

    assert(exercise6_customExceptions("hi") == Left("too short"), "Exercise 6 failed: short")
    assert(exercise6_customExceptions("hello") == Right("hello"), "Exercise 6 failed: valid")

    val (r1, r2) = exercise7_controlException
    assert(r1 == Some(42), "Exercise 7 failed: valid")
    assert(r2 == None, "Exercise 7 failed: invalid")

    assert(exercise8_eitherFromExceptions(10, 2) == Right(5), "Exercise 8 failed: normal")
    assert(exercise8_eitherFromExceptions(10, 0) == Left("Division by zero"), "Exercise 8 failed: zero")

    println("All Core023_Exceptions exercises passed!")
  }
}
