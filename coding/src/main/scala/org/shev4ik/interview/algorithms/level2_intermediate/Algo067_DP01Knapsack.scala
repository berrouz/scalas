package org.shev4ik.interview.algorithms.level2_intermediate

object Algo067_DP01Knapsack {

  // Exercise 1: 0/1 Knapsack — max value with weight capacity W
  // TODO: dp(i)(w) = max(dp(i-1)(w), dp(i-1)(w - weight(i)) + value(i)). Optimize to 1D.
  def knapsack(weights: Array[Int], values: Array[Int], capacity: Int): Int = ???

  // Exercise 2: Partition Equal Subset Sum — can array be split into two subsets with equal sum?
  // TODO: If total is odd, false. Target = total/2. 0/1 knapsack to check if subset with target sum exists.
  def canPartition(nums: Array[Int]): Boolean = ???

  // Exercise 3: Target Sum — count ways to assign +/- to each number to reach target
  // TODO: sum(P) - sum(N) = target, sum(P) + sum(N) = total => sum(P) = (target + total) / 2. Count subsets.
  def findTargetSumWays(nums: Array[Int], target: Int): Int = ???

  // Exercise 4: Last Stone Weight II — smash stones, minimize final weight
  // TODO: Split into two groups to minimize |sum(A) - sum(B)|. Equivalent to knapsack with capacity = total/2.
  def lastStoneWeightII(stones: Array[Int]): Int = ???

  // Exercise 5: Count subsets with given sum
  // TODO: dp(w) = number of subsets summing to w. dp(0) = 1. For each num, dp(w) += dp(w - num).
  def countSubsetsWithSum(nums: Array[Int], sum: Int): Int = ???

  // Exercise 6: Minimum subset sum difference — split into two subsets minimizing |sum1 - sum2|
  // TODO: Find all achievable sums up to total/2. Answer = total - 2 * maxAchievable.
  def minimumSubsetSumDifference(nums: Array[Int]): Int = ???

  // Exercise 7: Count number of ways to partition into two equal sum subsets
  // TODO: If total is odd, 0. Otherwise count subsets summing to total/2. Divide by 2 for symmetry.
  def equalSumPartitionCount(nums: Array[Int]): Int = ???

  // Exercise 8: Coin Change 2 — count number of combinations (unbounded knapsack)
  // TODO: dp(i) = number of ways to make amount i. For each coin, dp(i) += dp(i - coin). Order: coins outer.
  def coinChange2(amount: Int, coins: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(knapsack(Array(1, 3, 4, 5), Array(1, 4, 5, 7), 7) == 9, "Knapsack max value 9")

    // Exercise 2
    assert(canPartition(Array(1, 5, 11, 5)), "Can partition [1,5,11,5]")
    assert(!canPartition(Array(1, 2, 3, 5)), "Cannot partition [1,2,3,5]")

    // Exercise 3
    assert(findTargetSumWays(Array(1, 1, 1, 1, 1), 3) == 5, "5 ways to reach target 3")

    // Exercise 4
    assert(lastStoneWeightII(Array(2, 7, 4, 1, 8, 1)) == 1, "Min final weight 1")

    // Exercise 5
    assert(countSubsetsWithSum(Array(1, 2, 3, 3), 6) == 3, "3 subsets summing to 6")

    // Exercise 6
    assert(minimumSubsetSumDifference(Array(1, 6, 11, 5)) == 1, "Min difference 1")

    // Exercise 7
    val partCount = equalSumPartitionCount(Array(1, 5, 11, 5))
    assert(partCount >= 1, "At least 1 way to partition equally")

    // Exercise 8
    assert(coinChange2(5, Array(1, 2, 5)) == 4, "4 ways to make 5")
    assert(coinChange2(3, Array(2)) == 0, "0 ways to make 3 with only coin 2")

    println("All Algo067_DP01Knapsack exercises passed!")
  }
}
