package org.shev4ik.algorithms.leetcode_classic

import _root_.scala.annotation.tailrec

/**
 * 70. Climbing Stairs
 * https://leetcode.com/problems/climbing-stairs/
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. How many distinct ways can you climb to the top?
 *
 * Pattern: Dynamic Programming (Fibonacci)
 * Time: O(n)
 * Space: O(1)
 */
object L070_ClimbingStairs {

  // Iterative DP
  def climbStairs(n: Int): Int = {
    // TODO: Implement
    // dp[i] = dp[i-1] + dp[i-2] (Fibonacci)
    // Can optimize to O(1) space
    ???
  }

  // Recursive with memoization
  def climbStairsMemo(n: Int): Int = {
    // TODO: Implement with memoization
    ???
  }

  // Tail-recursive solution
  def climbStairsTailRec(n: Int, prev: Int = 1, curr: Int = 1): Int = {
    // TODO: Implement tail-recursive Fibonacci
    ???
  }

  // Functional using LazyList
  def climbStairsFunctional(n: Int): Int = {
    //lazy val fibs: LazyList[Int] = 1 #:: 1 #:: fibs.zip(fibs.tail).map { case (a, b) => a + b }
    //fibs(n)
    ???
  }

  def main(args: Array[String]): Unit = {
    println(climbStairs(2))  // Expected: 2 (1+1 or 2)
    println(climbStairs(3))  // Expected: 3 (1+1+1, 1+2, 2+1)
    println(climbStairs(5))  // Expected: 8
    println(climbStairs(45)) // Expected: 1836311903
  }
}
