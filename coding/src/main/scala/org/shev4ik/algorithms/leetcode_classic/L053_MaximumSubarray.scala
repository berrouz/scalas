package org.shev4ik.algorithms.leetcode_classic

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums, find the subarray with the largest sum,
 * and return its sum.
 *
 * Pattern: Kadane's Algorithm (Dynamic Programming)
 * Time: O(n)
 * Space: O(1)
 */
object L053_MaximumSubarray {

  def maxSubArray(nums: Array[Int]): Int = {
    // TODO: Implement Kadane's Algorithm
    // Hint: currentSum = max(num, currentSum + num)
    //       maxSum = max(maxSum, currentSum)
    ???
  }

  // Functional solution with foldLeft
  def maxSubArrayFunctional(nums: Array[Int]): Int = {
    // TODO: Implement using foldLeft
    // State: (currentSum, maxSum)
    ???
  }

  def main(args: Array[String]): Unit = {
    println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4))) // Expected: 6 ([4,-1,2,1])
    println(maxSubArray(Array(1)))                              // Expected: 1
    println(maxSubArray(Array(5, 4, -1, 7, 8)))                 // Expected: 23
  }
}
