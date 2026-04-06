package org.shev4ik.interview.scala_core.level2_intermediate

import scala.annotation.tailrec

object Core069_Annotations {

  // Exercise 1: @tailrec
  // TODO: Implement factorial using tail recursion with @tailrec annotation
  //       The annotation will cause a compile error if the method is not tail-recursive
  // @tailrec — will be added when implemented
  def factorial(n: Long, acc: Long = 1): Long = ???

  // TODO: Implement a tail-recursive fibonacci
  def fibonacci(n: Int): Long = {
    // @tailrec — will be added when implemented
    def loop(i: Int, a: Long, b: Long): Long = ???
    loop(n, 0, 1)
  }

  // Exercise 2: @deprecated
  // TODO: Create a deprecated method that suggests using a newer alternative
  @deprecated("Use newMethod instead", "1.0")
  def oldMethod(x: Int): Int = ???
  def newMethod(x: Int): Int = ???

  // Exercise 3: @inline
  // TODO: Create a method annotated with @inline suggesting the compiler inline it
  //       Note: @inline is a hint, not a guarantee
  @inline
  def square(x: Int): Int = ???

  @inline
  def cube(x: Int): Int = ???

  // Exercise 4: @specialized
  // TODO: Create a generic method/class with @specialized for primitive types
  //       This avoids boxing for specified primitive types
  class SpecializedBox[@specialized(Int, Long, Double) A](val value: A) {
    def map[@specialized(Int, Long, Double) B](f: A => B): SpecializedBox[B] = ???
  }

  // Exercise 5: @unchecked
  // TODO: Use @unchecked to suppress exhaustiveness warnings in pattern matching
  //       when you know the match is actually exhaustive due to runtime constraints
  sealed trait Color
  case object Red extends Color
  case object Green extends Color
  case object Blue extends Color

  def describeRGB(color: Color): String = ???

  // Match only Red and Green (knowing Blue won't appear), suppress warning
  def describeRG(color: Color): String = ???

  // Exercise 6: @transient
  // TODO: Use @transient to mark a field that should not be serialized
  @SerialVersionUID(1L)
  class UserSession(val username: String, @transient val tempData: String = "temp") extends Serializable {
    def describe: String = ???
  }

  // Exercise 7: @volatile
  // TODO: Use @volatile on a var to ensure visibility across threads
  //       Create a simple flag-based thread communication example
  class SharedState {
    @volatile var ready: Boolean = false
    @volatile var result: Int = 0

    def compute(): Unit = ???
    def waitForResult(): Int = ???
  }

  // Exercise 8: Custom annotation
  // TODO: Create a custom annotation and apply it to a method
  //       Note: custom annotations in Scala extend scala.annotation.StaticAnnotation
  //       They can be used with macros or reflection
  class documented(description: String) extends scala.annotation.StaticAnnotation

  @documented("Returns the absolute value of an integer")
  def absoluteValue(n: Int): Int = ???

  @documented("Returns the sign of an integer: -1, 0, or 1")
  def sign(n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    assert(factorial(5) == 120, "factorial(5) = 120")
    assert(factorial(0) == 1, "factorial(0) = 1")
    assert(factorial(10) == 3628800, "factorial(10)")
    assert(fibonacci(0) == 0, "fib(0) = 0")
    assert(fibonacci(1) == 1, "fib(1) = 1")
    assert(fibonacci(10) == 55, "fib(10) = 55")

    // Exercise 2 assertions
    assert(newMethod(5) == 10, "newMethod should double")
    // oldMethod still works but generates a deprecation warning
    assert(oldMethod(5) == 5, "oldMethod returns unchanged")

    // Exercise 3 assertions
    assert(square(5) == 25, "square(5) = 25")
    assert(cube(3) == 27, "cube(3) = 27")

    // Exercise 4 assertions
    val intBox = new SpecializedBox(42)
    assert(intBox.value == 42, "SpecializedBox[Int]")
    assert(intBox.map(_ * 2).value == 84, "SpecializedBox map")
    val doubleBox = new SpecializedBox(3.14)
    assert(doubleBox.value == 3.14, "SpecializedBox[Double]")

    // Exercise 5 assertions
    assert(describeRGB(Red) == "red", "describe Red")
    assert(describeRGB(Green) == "green", "describe Green")
    assert(describeRGB(Blue) == "blue", "describe Blue")
    assert(describeRG(Red) == "red", "describeRG Red")

    // Exercise 6 assertions
    val session = new UserSession("alice", "secret")
    assert(session.username == "alice", "session username")
    assert(session.describe.contains("alice"), "session describe")

    // Exercise 7 assertions
    val state = new SharedState
    state.compute()
    assert(state.waitForResult() == 42, "shared state result")

    // Exercise 8 assertions
    assert(absoluteValue(-5) == 5, "absoluteValue(-5) = 5")
    assert(absoluteValue(5) == 5, "absoluteValue(5) = 5")
    assert(sign(-10) == -1, "sign(-10) = -1")
    assert(sign(0) == 0, "sign(0) = 0")
    assert(sign(10) == 1, "sign(10) = 1")

    println("All Core069_Annotations exercises passed!")
  }
}
