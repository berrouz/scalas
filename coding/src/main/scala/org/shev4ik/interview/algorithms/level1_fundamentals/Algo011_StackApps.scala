package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo011_StackApps {

  // TODO: Implement a queue using two stacks
  // Provide enqueue and dequeue operations with amortized O(1)
  class QueueUsingStacks[A] {
    private var inStack: List[A] = Nil
    private var outStack: List[A] = Nil

    def enqueue(a: A): Unit = ???
    def dequeue(): A = ???
    def peek(): A = ???
    def isEmpty: Boolean = ???
  }

  // TODO: Decode an encoded string
  // Example: "3[a]2[bc]" => "aaabcbc"
  // Example: "3[a2[c]]" => "accaccacc"
  def decodeString(s: String): String = ???

  // TODO: Implement a basic calculator that evaluates a string expression
  // The expression contains +, -, (, ), digits, and spaces
  // Example: "(1+(4+5+2)-3)+(6+8)" => 23
  def basicCalculator(s: String): Int = ???

  // TODO: Find the largest rectangle area in a histogram
  // heights(i) is the height of the i-th bar, each bar has width 1
  // Example: Array(2,1,5,6,2,3) => 10
  def largestRectangleHistogram(heights: Array[Int]): Int = ???

  // TODO: Calculate how much water can be trapped after raining
  // Example: Array(0,1,0,2,1,0,1,3,2,1,2,1) => 6
  def trappingRainWater(height: Array[Int]): Int = ???

  // TODO: Simplify an absolute Unix file path
  // Example: "/home/" => "/home"
  // Example: "/a/./b/../../c/" => "/c"
  // Example: "/../" => "/"
  def simplifyPath(path: String): String = ???

  // TODO: Remove all adjacent duplicates in a string repeatedly until no more can be removed
  // Example: "abbaca" => "ca" (remove bb -> aaca, remove aa -> ca)
  def removeAllAdjacentDuplicates(s: String): String = ???

  // TODO: Compute the score of a string of balanced parentheses
  // () has score 1, AB has score A+B, (A) has score 2*A
  // Example: "(())" => 2, "(()(()))" => 6
  def scoreOfParentheses(s: String): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: QueueUsingStacks
    val q = new QueueUsingStacks[Int]()
    q.enqueue(1)
    q.enqueue(2)
    q.enqueue(3)
    assert(q.dequeue() == 1)
    assert(q.dequeue() == 2)
    q.enqueue(4)
    assert(q.dequeue() == 3)
    assert(q.dequeue() == 4)
    println("Exercise 1 passed: QueueUsingStacks")

    // Exercise 2: decodeString
    assert(decodeString("3[a]2[bc]") == "aaabcbc")
    assert(decodeString("3[a2[c]]") == "accaccacc")
    assert(decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
    println("Exercise 2 passed: decodeString")

    // Exercise 3: basicCalculator
    assert(basicCalculator("1 + 1") == 2)
    assert(basicCalculator("(1+(4+5+2)-3)+(6+8)") == 23)
    println("Exercise 3 passed: basicCalculator")

    // Exercise 4: largestRectangleHistogram
    assert(largestRectangleHistogram(Array(2, 1, 5, 6, 2, 3)) == 10)
    assert(largestRectangleHistogram(Array(2, 4)) == 4)
    println("Exercise 4 passed: largestRectangleHistogram")

    // Exercise 5: trappingRainWater
    assert(trappingRainWater(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
    assert(trappingRainWater(Array(4, 2, 0, 3, 2, 5)) == 9)
    println("Exercise 5 passed: trappingRainWater")

    // Exercise 6: simplifyPath
    assert(simplifyPath("/home/") == "/home")
    assert(simplifyPath("/a/./b/../../c/") == "/c")
    assert(simplifyPath("/../") == "/")
    println("Exercise 6 passed: simplifyPath")

    // Exercise 7: removeAllAdjacentDuplicates
    assert(removeAllAdjacentDuplicates("abbaca") == "ca")
    assert(removeAllAdjacentDuplicates("azxxzy") == "ay")
    println("Exercise 7 passed: removeAllAdjacentDuplicates")

    // Exercise 8: scoreOfParentheses
    assert(scoreOfParentheses("()") == 1)
    assert(scoreOfParentheses("(())") == 2)
    assert(scoreOfParentheses("()()") == 2)
    assert(scoreOfParentheses("(()(()))") == 6)
    println("Exercise 8 passed: scoreOfParentheses")

    println("All Algo011_StackApps exercises passed!")
  }
}
