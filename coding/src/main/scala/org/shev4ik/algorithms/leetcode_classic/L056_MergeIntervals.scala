package org.shev4ik.algorithms.leetcode_classic

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals.
 *
 * Pattern: Sorting + Greedy
 * Time: O(n log n)
 * Space: O(n)
 */
object L056_MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    // TODO: Implement
    // Hint:
    // 1. Sort by start time
    // 2. Iterate and merge if current.start <= prev.end
    ???
  }

  // Functional solution with foldLeft
  def mergeFunctional(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    // TODO: Implement using foldLeft
    ???
  }

  def main(args: Array[String]): Unit = {
    val result1 = merge(Array(Array(1, 3), Array(2, 6), Array(8, 10), Array(15, 18)))
    println(result1.map(_.mkString("[", ",", "]")).mkString(", ")) // Expected: [1,6], [8,10], [15,18]

    val result2 = merge(Array(Array(1, 4), Array(4, 5)))
    println(result2.map(_.mkString("[", ",", "]")).mkString(", ")) // Expected: [1,5]
  }
}
