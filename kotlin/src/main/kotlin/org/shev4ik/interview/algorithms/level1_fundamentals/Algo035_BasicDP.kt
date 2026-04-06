package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Dynamic Programming Basics
 */
object Algo035_BasicDP {

    // Exercise 1: fibDP
    // TODO: Compute fibonacci(10) using bottom-up DP. Return 55.
    fun exercise1_fibDP(): Int = TODO()

    // Exercise 2: climbingStairs
    // TODO: Count ways to climb n=5 stairs taking 1 or 2 steps at a time. Return 8.
    fun exercise2_climbingStairs(): Int = TODO()

    // Exercise 3: minCostStairs
    // TODO: Given costs intArrayOf(10, 15, 20), find min cost to reach top.
    // TODO: You can start from step 0 or 1. Return min cost.
    fun exercise3_minCostStairs(): Int = TODO()

    // Exercise 4: coinChange
    // TODO: Find minimum coins for amount 11 using denominations [1, 5, 6]. Return 2 (5+6).
    fun exercise4_coinChange(): Int = TODO()

    // Exercise 5: maxSubarray
    // TODO: Find maximum subarray sum in intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) using Kadane's.
    // TODO: Return 6.
    fun exercise5_maxSubarray(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_fibDP() == 55) { "Exercise 1 failed" }
        assert(exercise2_climbingStairs() == 8) { "Exercise 2 failed" }
        assert(exercise3_minCostStairs() == 15) { "Exercise 3 failed" }
        assert(exercise4_coinChange() == 2) { "Exercise 4 failed" }
        assert(exercise5_maxSubarray() == 6) { "Exercise 5 failed" }
        println("All Algo035_BasicDP exercises passed!")
    }
}
