package org.shev4ik.interview.algorithms.level2_intermediate

object Algo056_MonotonicStack {

  // Exercise 1: Next Greater Element I — for each element in subset, find next greater in full array
  // TODO: Process array right to left with decreasing stack. Map each element to its next greater.
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = ???

  // Exercise 2: Next Greater Element II — circular array, find next greater for each element
  // TODO: Process 2*n elements (circular). Use decreasing stack. Store results for first n.
  def nextGreaterElements(nums: Array[Int]): Array[Int] = ???

  // Exercise 3: Daily Temperatures — days until a warmer temperature
  // TODO: Decreasing stack of indices. When popping, distance = current index - popped index.
  def dailyTemperatures(temperatures: Array[Int]): Array[Int] = ???

  // Exercise 4: Largest Rectangle in Histogram — max rectangle area
  // TODO: Increasing stack of indices. On pop, width = current - stack.top - 1. Compute area.
  def largestRectangleArea(heights: Array[Int]): Int = ???

  // Exercise 5: Maximal Rectangle in binary matrix — largest rectangle of '1's
  // TODO: Build histogram row by row. Apply largestRectangleArea to each row's histogram.
  def maximalRectangle(matrix: Array[Array[Char]]): Int = ???

  // Exercise 6: Trapping Rain Water using stack
  // TODO: Decreasing stack. On pop, water trapped = width * (min(left, right boundary) - popped height).
  def trapRainWater(height: Array[Int]): Int = ???

  // Exercise 7: Stock Span — for each day, count consecutive days with price <= today (including today)
  // TODO: Decreasing stack of indices. Span = current index - stack.top (or current index + 1 if stack empty).
  def stockSpan(prices: Array[Int]): Array[Int] = ???

  // Exercise 8: Sum of Subarray Minimums — sum of min of all subarrays
  // TODO: For each element, find how many subarrays it is the minimum of. Use previous less and next less element.
  def sumSubarrayMins(arr: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(nextGreaterElement(Array(4, 1, 2), Array(1, 3, 4, 2)).toList == List(-1, 3, -1),
      "Next greater element I")

    // Exercise 2
    assert(nextGreaterElements(Array(1, 2, 1)).toList == List(2, -1, 2), "Next greater circular")

    // Exercise 3
    assert(dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)).toList ==
      List(1, 1, 4, 2, 1, 1, 0, 0), "Daily temperatures")

    // Exercise 4
    assert(largestRectangleArea(Array(2, 1, 5, 6, 2, 3)) == 10, "Largest rectangle area 10")

    // Exercise 5
    val matrix = Array(
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0')
    )
    assert(maximalRectangle(matrix) == 6, "Maximal rectangle 6")

    // Exercise 6
    assert(trapRainWater(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6, "Trap rain water 6")

    // Exercise 7
    assert(stockSpan(Array(100, 80, 60, 70, 60, 75, 85)).toList == List(1, 1, 1, 2, 1, 4, 6),
      "Stock span")

    // Exercise 8
    val MOD = 1000000007
    assert(sumSubarrayMins(Array(3, 1, 2, 4)) == 17, "Sum of subarray mins = 17")

    println("All Algo056_MonotonicStack exercises passed!")
  }
}
