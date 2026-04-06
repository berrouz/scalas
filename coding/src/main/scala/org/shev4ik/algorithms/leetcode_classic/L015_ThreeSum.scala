package org.shev4ik.algorithms.leetcode_classic

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Pattern: Two Pointers (after sorting)
 * Time: O(n^2)
 * Space: O(1) excluding output
 */
object L015_ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    // TODO: Implement
    // Hint:
    // 1. Sort the array
    // 2. For each i, use two pointers (left, right) to find pairs that sum to -nums[i]
    // 3. Skip duplicates to avoid duplicate triplets
    ???
  }

  def main(args: Array[String]): Unit = {
    println(threeSum(Array(-1, 0, 1, 2, -1, -4))) // Expected: [[-1,-1,2],[-1,0,1]]
    println(threeSum(Array(0, 1, 1)))              // Expected: []
    println(threeSum(Array(0, 0, 0)))              // Expected: [[0,0,0]]
  }
}
