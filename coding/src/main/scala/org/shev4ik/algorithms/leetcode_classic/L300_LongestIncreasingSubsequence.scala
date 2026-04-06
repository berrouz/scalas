package org.shev4ik.algorithms.leetcode_classic

/**
 * 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * Pattern: Dynamic Programming / Binary Search
 * Time: O(n^2) for DP, O(n log n) for Binary Search
 * Space: O(n)
 */
object L300_LongestIncreasingSubsequence {

  // O(n^2) DP solution
  def lengthOfLIS(nums: Array[Int]): Int = {
    // TODO: Implement DP
    // dp[i] = length of LIS ending at index i
    // dp[i] = max(dp[j] + 1) for all j < i where nums[j] < nums[i]
    ???
  }

  // O(n log n) Binary Search solution
  def lengthOfLISOptimal(nums: Array[Int]): Int = {
    // TODO: Implement using Binary Search
    // Maintain a "tails" array where tails[i] = smallest tail element
    // for LIS of length i+1
    // Use binary search to find position to update
    ???
  }

  // Helper: binary search for position
  private def binarySearch(tails: Array[Int], len: Int, target: Int): Int = {
    // TODO: Find first position where tails[pos] >= target
    ???
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18))) // Expected: 4 ([2,3,7,101])
    println(lengthOfLIS(Array(0, 1, 0, 3, 2, 3)))           // Expected: 4
    println(lengthOfLIS(Array(7, 7, 7, 7, 7, 7, 7)))        // Expected: 1
  }
}
