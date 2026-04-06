package org.shev4ik.algorithms.leetcode_classic

/**
 * 198. House Robber
 * https://leetcode.com/problems/house-robber/
 *
 * Given an array representing money in each house, return the maximum amount
 * you can rob without robbing adjacent houses.
 *
 * Pattern: Dynamic Programming
 * Time: O(n)
 * Space: O(1)
 */
object L198_HouseRobber {

  def rob(nums: Array[Int]): Int = {
    // TODO: Implement DP
    // dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    // Can optimize to O(1) space with two variables
    ???
  }

  // Recursive with memoization
  def robMemo(nums: Array[Int]): Int = {
    // TODO: Implement with memoization
    ???
  }

  // Functional solution with foldLeft
  def robFunctional(nums: Array[Int]): Int = {
    // State: (prevMax, currMax)
    nums.foldLeft((0, 0)) { case ((prev, curr), num) =>
      (curr, math.max(curr, prev + num))
    }._2
  }

  def main(args: Array[String]): Unit = {
    println(rob(Array(1, 2, 3, 1)))       // Expected: 4 (1 + 3)
    println(rob(Array(2, 7, 9, 3, 1)))    // Expected: 12 (2 + 9 + 1)
    println(rob(Array(2, 1, 1, 2)))       // Expected: 4 (2 + 2)
  }
}
