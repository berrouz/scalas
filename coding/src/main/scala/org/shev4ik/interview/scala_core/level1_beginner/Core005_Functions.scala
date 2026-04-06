package org.shev4ik.interview.scala_core.level1_beginner

/**
 * =Scala Functions, Methods, and Higher-Order Functions=
 *
 * ==Theory: Methods vs Functions==
 *
 * In Scala, a '''method''' is defined with `def` and belongs to a class/object. A '''function'''
 * (or function value) is an instance of one of the `FunctionN` traits (`Function0` through `Function22`).
 *
 * {{{
 * // This is a METHOD:
 * def add(a: Int, b: Int): Int = a + b
 *
 * // This is a FUNCTION VALUE (an instance of Function2[Int, Int, Int]):
 * val addFn: (Int, Int) => Int = (a, b) => a + b
 * }}}
 *
 * Key differences:
 *  - Methods can have type parameters, multiple parameter lists, implicit parameters, and default args.
 *  - Function values are objects that can be stored in variables, passed as arguments, and returned.
 *  - Methods are converted to functions automatically when needed ('''eta expansion''').
 *
 * ==Theory: Function Traits==
 *
 * Scala defines traits `Function0[+R]`, `Function1[-T1, +R]`, `Function2[-T1, -T2, +R]`, etc.
 * The shorthand `(A, B) => C` is syntactic sugar for `Function2[A, B, C]`.
 * Each trait has an `apply` method, which is why functions can be "called" with parentheses.
 *
 * ==Theory: Eta Expansion==
 *
 * Eta expansion is the process of converting a method into a function value:
 * {{{
 * def multiply(a: Int, b: Int): Int = a * b
 * val mulFn: (Int, Int) => Int = multiply   // eta expansion (automatic in Scala 2.13+)
 * val mulFn2 = multiply _                   // explicit eta expansion (older Scala)
 * }}}
 *
 * ==Theory: Partial Functions vs Partially Applied Functions==
 *
 * These are two DIFFERENT concepts that are often confused:
 *
 *  - '''Partially Applied Function:''' A function where some arguments are fixed.
 *    {{{
 *    def add(a: Int, b: Int): Int = a + b
 *    val add5: Int => Int = add(5, _)    // partially applied: `a` is fixed to 5
 *    }}}
 *
 *  - '''PartialFunction:''' A function defined only for certain inputs. It extends
 *    `PartialFunction[A, B]` and has an `isDefinedAt` method.
 *    {{{
 *    val divide: PartialFunction[Int, Int] = {
 *      case n if n != 0 => 42 / n
 *    }
 *    divide.isDefinedAt(0)  // false
 *    divide.isDefinedAt(7)  // true
 *    }}}
 *
 * ==Theory: Currying and Multiple Parameter Lists==
 *
 * Multiple parameter lists enable currying, better type inference, and implicit parameters:
 * {{{
 * def fold[A, B](list: List[A])(zero: B)(combine: (B, A) => B): B = list.foldLeft(zero)(combine)
 * // The compiler can infer types of `combine` from `list` and `zero`.
 * }}}
 *
 * ==Interview Tips==
 *
 *  - '''Common question: "Explain the difference between a method and a function in Scala."'''
 *    Answer: A method is defined with `def` and is part of a class/object definition.
 *    A function is a value -- an instance of `FunctionN` -- that can be assigned to a variable,
 *    passed as an argument, or returned from another function. Methods are converted to functions
 *    via eta expansion when the compiler expects a function type.
 *
 *  - '''Follow-up: "What is eta expansion?"'''
 *    Answer: Eta expansion is the automatic (or explicit with `_`) conversion of a method
 *    reference into a function value. In Scala 2.13+, this happens automatically when
 *    a method is used where a function type is expected.
 *
 *  - '''Follow-up: "What is the difference between a PartialFunction and a partially applied function?"'''
 *    Answer: A partially applied function has some arguments pre-filled (e.g., `add(5, _)`).
 *    A PartialFunction is a function that is only defined for a subset of its input domain
 *    and extends `PartialFunction[A, B]` with an `isDefinedAt` method.
 *
 * ==Approach Hints==
 *
 *  - For Exercise 2 (multiple param lists), just return `a * b` -- the curried syntax is in the signature.
 *  - For Exercise 6 (nested functions), define a local `def square` inside the outer function body.
 *  - For Exercise 8 (function value), assign the method using `exercise1_add` or `exercise1_add _`.
 */
object Core005_Functions {

  // Exercise 1: Basic def syntax
  // TODO: Define a function `add` that takes two Ints and returns their sum.
  def exercise1_add(a: Int, b: Int): Int = ???

  // Exercise 2: Multiple parameter lists
  // TODO: Define a function that takes two parameter lists: (a: Int)(b: Int)
  //       and returns a * b. This is called currying.
  def exercise2_multipleParams(a: Int)(b: Int): Int = ???

  // Exercise 3: Default arguments
  // TODO: Define a function `greet` that takes name: String and greeting: String = "Hello"
  //       and returns s"$greeting, $name!"
  def exercise3_defaultArgs(name: String, greeting: String = "Hello"): String = ???

  // Exercise 4: Named arguments
  // TODO: Call this function using named arguments in a helper function.
  //       The function `createUser` takes name, age, and city.
  //       Return createUser(city = "NYC", name = "Alice", age = 30).
  case class User(name: String, age: Int, city: String)
  def createUser(name: String, age: Int, city: String): User = User(name, age, city)
  def exercise4_namedArgs: User = ???

  // Exercise 5: Varargs
  // TODO: Define a function that accepts varargs of Int and returns their sum.
  //       Use ints.sum or ints.foldLeft(0)(_ + _).
  def exercise5_varargs(ints: Int*): Int = ???

  // Exercise 6: Nested functions
  // TODO: Define an outer function that returns the hypotenuse of a right triangle.
  //       Inside it, define a nested function `square(x: Double): Double = x * x`.
  //       Return math.sqrt(square(a) + square(b)).
  def exercise6_nestedFunctions(a: Double, b: Double): Double = ???

  // Exercise 7: Unit return type
  // TODO: Define a function that takes a mutable.ListBuffer[String] and a message,
  //       appends the message to the buffer, and returns Unit.
  //       The function signature is provided; implement the body.
  def exercise7_unitReturn(buffer: scala.collection.mutable.ListBuffer[String], msg: String): Unit = ???

  // Exercise 8: Function value vs method
  // TODO: Assign a method reference to a function value.
  //       val addFn: (Int, Int) => Int = exercise1_add
  //       Then use addFn to compute addFn(3, 4). Return the result.
  def exercise8_functionVsMethod: Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_add(3, 4) == 7, "Exercise 1 failed")
    assert(exercise1_add(-1, 1) == 0, "Exercise 1 failed: zero")

    assert(exercise2_multipleParams(3)(4) == 12, "Exercise 2 failed")
    assert(exercise2_multipleParams(0)(100) == 0, "Exercise 2 failed: zero")

    assert(exercise3_defaultArgs("World") == "Hello, World!", "Exercise 3 failed: default")
    assert(exercise3_defaultArgs("World", "Hi") == "Hi, World!", "Exercise 3 failed: custom")

    assert(exercise4_namedArgs == User("Alice", 30, "NYC"), "Exercise 4 failed")

    assert(exercise5_varargs(1, 2, 3, 4, 5) == 15, "Exercise 5 failed")
    assert(exercise5_varargs() == 0, "Exercise 5 failed: empty")

    assert(math.abs(exercise6_nestedFunctions(3.0, 4.0) - 5.0) < 1e-10, "Exercise 6 failed")

    val buf = scala.collection.mutable.ListBuffer[String]()
    exercise7_unitReturn(buf, "hello")
    assert(buf.toList == List("hello"), "Exercise 7 failed")

    assert(exercise8_functionVsMethod == 7, "Exercise 8 failed")

    println("All Core005_Functions exercises passed!")
  }
}
