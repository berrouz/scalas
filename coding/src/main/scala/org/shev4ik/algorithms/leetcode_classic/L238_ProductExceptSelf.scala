package org.shev4ik.algorithms.leetcode_classic

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 * You must solve it in O(n) time without using division.
 *
 * Pattern: Prefix/Suffix Products
 * Time: O(n)
 * Space: O(1) excluding output
 */
object L238_ProductExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    // TODO: Implement using prefix and suffix products
    // Hint:
    // 1. First pass: calculate prefix products (left to right)
    // 2. Second pass: multiply by suffix products (right to left)
    ???
  }

  // Two-array solution (more intuitive)
  def productExceptSelfTwoArrays(nums: Array[Int]): Array[Int] = {
    // TODO: Implement using separate prefix and suffix arrays
    ???
  }

  def main(args: Array[String]): Unit = {
    println(productExceptSelf(Array(1, 2, 3, 4)).mkString(", ")) // Expected: 24, 12, 8, 6
    println(productExceptSelf(Array(-1, 1, 0, -3, 3)).mkString(", ")) // Expected: 0, 0, 9, 0, 0
  }
}
