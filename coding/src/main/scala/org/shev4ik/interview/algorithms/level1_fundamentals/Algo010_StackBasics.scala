package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo010_StackBasics {

  // TODO: Implement a stack using a List (immutable)
  // Provide push, pop, peek, isEmpty operations
  class FunctionalStack[A] private (private val elements: List[A]) {
    def push(a: A): FunctionalStack[A] = ???
    def pop: (A, FunctionalStack[A]) = ???
    def peek: A = ???
    def isEmpty: Boolean = ???
  }
  object FunctionalStack {
    def empty[A]: FunctionalStack[A] = new FunctionalStack[A](Nil)
  }

  // TODO: Check if a string of brackets is valid
  // Valid pairs: (), [], {}
  // Example: "()[]{}" => true, "(]" => false, "([)]" => false
  def validParentheses(s: String): Boolean = ???

  // TODO: Design a stack that supports push, pop, top, and retrieving the minimum element in O(1)
  class MinStack {
    def push(x: Int): Unit = ???
    def pop(): Int = ???
    def top(): Int = ???
    def getMin(): Int = ???
  }

  // TODO: Reverse a string using a stack
  // Example: "hello" => "olleh"
  def reverseStringUsingStack(s: String): String = ???

  // TODO: For each element, find the next greater element to its right
  // Return -1 if no greater element exists
  // Example: Array(4,5,2,25) => Array(5,25,25,-1)
  def nextGreaterElement(arr: Array[Int]): Array[Int] = ???

  // TODO: Evaluate an expression in Reverse Polish Notation
  // Valid operators: +, -, *, /
  // Example: Array("2","1","+","3","*") => 9 ((2+1)*3)
  def evalRPN(tokens: Array[String]): Int = ???

  // TODO: Given daily temperatures, return how many days until a warmer temperature
  // If no warmer day, return 0
  // Example: Array(73,74,75,71,69,72,76,73) => Array(1,1,4,2,1,1,0,0)
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = ???

  // TODO: Simulate asteroid collisions
  // Positive = moving right, negative = moving left
  // When two collide, smaller one explodes. Equal = both explode.
  // Example: Array(5,10,-5) => Array(5,10), Array(8,-8) => Array()
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: FunctionalStack
    val s0 = FunctionalStack.empty[Int]
    assert(s0.isEmpty)
    val s1 = s0.push(1).push(2).push(3)
    assert(s1.peek == 3)
    val (v, s2) = s1.pop
    assert(v == 3)
    assert(s2.peek == 2)
    println("Exercise 1 passed: FunctionalStack")

    // Exercise 2: validParentheses
    assert(validParentheses("()[]{}") == true)
    assert(validParentheses("(]") == false)
    assert(validParentheses("([)]") == false)
    assert(validParentheses("{[]}") == true)
    println("Exercise 2 passed: validParentheses")

    // Exercise 3: MinStack
    val ms = new MinStack()
    ms.push(-2)
    ms.push(0)
    ms.push(-3)
    assert(ms.getMin() == -3)
    ms.pop()
    assert(ms.top() == 0)
    assert(ms.getMin() == -2)
    println("Exercise 3 passed: MinStack")

    // Exercise 4: reverseStringUsingStack
    assert(reverseStringUsingStack("hello") == "olleh")
    assert(reverseStringUsingStack("") == "")
    println("Exercise 4 passed: reverseStringUsingStack")

    // Exercise 5: nextGreaterElement
    assert(nextGreaterElement(Array(4, 5, 2, 25)).toSeq == Seq(5, 25, 25, -1))
    assert(nextGreaterElement(Array(3, 2, 1)).toSeq == Seq(-1, -1, -1))
    println("Exercise 5 passed: nextGreaterElement")

    // Exercise 6: evalRPN
    assert(evalRPN(Array("2", "1", "+", "3", "*")) == 9)
    assert(evalRPN(Array("4", "13", "5", "/", "+")) == 6)
    println("Exercise 6 passed: evalRPN")

    // Exercise 7: dailyTemperatures
    assert(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).toSeq == Seq(1, 1, 4, 2, 1, 1, 0, 0))
    println("Exercise 7 passed: dailyTemperatures")

    // Exercise 8: asteroidCollision
    assert(asteroidCollision(Array(5, 10, -5)).toSeq == Seq(5, 10))
    assert(asteroidCollision(Array(8, -8)).toSeq == Seq())
    assert(asteroidCollision(Array(10, 2, -5)).toSeq == Seq(10))
    println("Exercise 8 passed: asteroidCollision")

    println("All Algo010_StackBasics exercises passed!")
  }
}
