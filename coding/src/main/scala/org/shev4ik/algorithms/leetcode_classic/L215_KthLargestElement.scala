package org.shev4ik.algorithms.leetcode_classic

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element.
 *
 * Pattern: QuickSelect / Heap
 * Time: O(n) average for QuickSelect, O(n log k) for Heap
 * Space: O(1) for QuickSelect, O(k) for Heap
 */
object L215_KthLargestElement {

  // Using Min Heap of size k
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    // TODO: Implement using Min Heap
    // Hint: Keep heap size = k, top will be kth largest
    ???
  }

  // QuickSelect algorithm (optimal)
  def findKthLargestQuickSelect(nums: Array[Int], k: Int): Int = {
    // TODO: Implement QuickSelect
    // Target index is nums.length - k (for kth largest)
    ???
  }

  // Partition helper for QuickSelect
  private def partition(nums: Array[Int], left: Int, right: Int): Int = {
    // TODO: Implement partition (Lomuto or Hoare)
    ???
  }

  // Simple solution: sort and return
  def findKthLargestSimple(nums: Array[Int], k: Int): Int = {
    nums.sorted.reverse(k - 1)
  }

  def main(args: Array[String]): Unit = {
    println(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2))    // Expected: 5
    println(findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 4)) // Expected: 4
  }
}
