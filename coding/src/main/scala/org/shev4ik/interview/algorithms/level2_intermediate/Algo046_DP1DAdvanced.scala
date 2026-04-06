package org.shev4ik.interview.algorithms.level2_intermediate

object Algo046_DP1DAdvanced {

  // Exercise 1: Longest Increasing Subsequence — length of LIS (O(n^2) DP)
  // TODO: dp(i) = length of LIS ending at index i. dp(i) = 1 + max(dp(j)) for j < i where nums(j) < nums(i).
  def lengthOfLIS(nums: Array[Int]): Int = ???

  // Exercise 2: Number of Longest Increasing Subsequences
  // TODO: Track both length and count. If dp(j)+1 == dp(i), add count(j) to count(i). If dp(j)+1 > dp(i), reset.
  def findNumberOfLIS(nums: Array[Int]): Int = ???

  // Exercise 3: Maximum Product Subarray
  // TODO: Track current max and min (since negative * negative = positive). Update at each step.
  def maxProduct(nums: Array[Int]): Int = ???

  // Exercise 4: Partition Equal Subset Sum — can array be split into two subsets with equal sum?
  // TODO: If total sum is odd, false. Otherwise, find subset with sum = total/2 using 1D boolean DP.
  def canPartition(nums: Array[Int]): Boolean = ???

  // Exercise 5: Target Sum — count ways to assign +/- to each element to reach target
  // TODO: Transform to subset sum: find count of subsets with sum = (total + target) / 2.
  def findTargetSumWays(nums: Array[Int], target: Int): Int = ???

  // Exercise 6: Combination Sum IV — count number of combinations that sum to target (order matters)
  // TODO: dp(i) = sum of dp(i - nums(j)) for all valid j. Like climbing stairs with variable steps.
  def combinationSum4(nums: Array[Int], target: Int): Int = ???

  // Exercise 7: Jump Game II — minimum jumps to reach last index
  // TODO: Greedy: track farthest reachable, current end of jump. When reaching current end, jump.
  def jump(nums: Array[Int]): Int = ???

  // Exercise 8: Ugly Number II — nth ugly number (prime factors only 2, 3, 5)
  // TODO: Maintain three pointers for multiplying by 2, 3, 5. Take minimum and advance pointer(s).
  def nthUglyNumber(n: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)) == 4, "LIS length 4")
    assert(lengthOfLIS(Array(0, 1, 0, 3, 2, 3)) == 4, "LIS length 4")

    // Exercise 2
    assert(findNumberOfLIS(Array(1, 3, 5, 4, 7)) == 2, "2 LIS of length 3")
    assert(findNumberOfLIS(Array(1, 1, 1, 1)) == 4, "4 LIS of length 1")

    // Exercise 3
    assert(maxProduct(Array(2, 3, -2, 4)) == 6, "Max product 2*3=6")
    assert(maxProduct(Array(-2, 0, -1)) == 0, "Max product is 0")

    // Exercise 4
    assert(canPartition(Array(1, 5, 11, 5)), "Can partition: {1,5,5} and {11}")
    assert(!canPartition(Array(1, 2, 3, 5)), "Cannot partition")

    // Exercise 5
    assert(findTargetSumWays(Array(1, 1, 1, 1, 1), 3) == 5, "5 ways to reach 3")

    // Exercise 6
    assert(combinationSum4(Array(1, 2, 3), 4) == 7, "7 combinations sum to 4")

    // Exercise 7
    assert(jump(Array(2, 3, 1, 1, 4)) == 2, "2 jumps: 0->1->4")
    assert(jump(Array(2, 3, 0, 1, 4)) == 2, "2 jumps")

    // Exercise 8
    assert(nthUglyNumber(10) == 12, "10th ugly number is 12")
    assert(nthUglyNumber(1) == 1, "1st ugly number is 1")

    println("All Algo046_DP1DAdvanced exercises passed!")
  }
}
