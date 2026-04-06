package org.shev4ik.interview.algorithms.level2_intermediate

object Algo057_MonotonicQueue {

  // Exercise 1: Sliding Window Maximum — return max in each window of size k
  // TODO: Use decreasing deque of indices. Remove front if out of window. Remove back if smaller than current.
  def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = ???

  // Exercise 2: Shortest Subarray with Sum at Least K (may contain negatives)
  // TODO: Use prefix sums and monotonic deque. For each prefix, remove from front if sum difference >= k.
  def shortestSubarray(nums: Array[Int], k: Int): Int = ???

  // Exercise 3: Constrained Subsequence Sum — max sum subsequence where adjacent elements differ by at most k indices
  // TODO: dp(i) = nums(i) + max(0, max(dp(j)) for j in [i-k, i-1]). Use decreasing deque for window max.
  def constrainedSubsetSum(nums: Array[Int], k: Int): Int = ???

  // Exercise 4: Longest Continuous Subarray With Absolute Diff <= limit
  // TODO: Use two deques: one for max (decreasing), one for min (increasing). Shrink window from left if diff > limit.
  def longestSubarray(nums: Array[Int], limit: Int): Int = ???

  // Exercise 5: Max Value of Equation — max yi + yj + |xi - xj| where xi < xj, xj - xi <= k
  // TODO: Simplify to (yj + xj) + max(yi - xi) for valid i. Use decreasing deque on (yi - xi).
  def findMaxValueOfEquation(points: Array[Array[Int]], k: Int): Int = ???

  // Exercise 6: Jump Game VI — max score reaching last index, can jump at most k steps
  // TODO: dp(i) = nums(i) + max(dp(j)) for j in [i-k, i-1]. Use decreasing deque.
  def maxResult(nums: Array[Int], k: Int): Int = ???

  // Exercise 7: Minimum Window Subsequence — find shortest substring of s1 containing s2 as subsequence
  // TODO: Two pointer / DP approach. Find each occurrence of s2 as subsequence, track minimum window.
  def minWindowSubsequence(s1: String, s2: String): String = ???

  // Exercise 8: Find Building Where Alice and Bob Can Meet — find leftmost building taller than both starting buildings
  // TODO: Process queries with monotonic stack. For each query (a,b), find min index >= max(a,b) where height > max(h[a],h[b]).
  def findBuilding(heights: Array[Int], queries: Array[Array[Int]]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(maxSlidingWindow(Array(1, 3, -1, -3, 5, 3, 6, 7), 3).toList == List(3, 3, 5, 5, 6, 7),
      "Sliding window maximum")

    // Exercise 2
    assert(shortestSubarray(Array(2, -1, 2), 3) == 3, "Shortest subarray with sum >= 3")
    assert(shortestSubarray(Array(1), 1) == 1, "Single element")

    // Exercise 3
    assert(constrainedSubsetSum(Array(10, 2, -10, 5, 20), 2) == 37, "Constrained subset sum")

    // Exercise 4
    assert(longestSubarray(Array(8, 2, 4, 7), 4) == 2, "Longest subarray with diff <= 4")
    assert(longestSubarray(Array(10, 1, 2, 4, 7, 2), 5) == 4, "Longest subarray")

    // Exercise 5
    val points = Array(Array(1, 3), Array(2, 0), Array(5, 10), Array(6, -10))
    assert(findMaxValueOfEquation(points, 1) == 4, "Max value of equation")

    // Exercise 6
    assert(maxResult(Array(1, -1, -2, 4, -7, 3), 2) == 7, "Jump game VI: 1 + -1 + 4 + 3 = 7")

    // Exercise 7
    assert(minWindowSubsequence("abcdebdde", "bde") == "bcde", "Minimum window subsequence")

    // Exercise 8
    val bHeights = Array(6, 4, 8, 5, 2, 7)
    val bQueries = Array(Array(0, 1)) // Alice at 0, Bob at 1, need building taller than both
    val result = findBuilding(bHeights, bQueries)
    assert(result(0) == 2, "Meet at building 2 (height 8)")

    println("All Algo057_MonotonicQueue exercises passed!")
  }
}
