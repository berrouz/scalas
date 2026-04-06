package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Sliding Window Technique
 *
 * =Theory=
 *
 * The sliding window pattern maintains a "window" (contiguous subarray/substring) that expands
 * or shrinks as you iterate, avoiding the need to recompute from scratch for every position.
 * It reduces O(n*k) or O(n^2^) brute force to O(n).
 *
 * '''Two types of sliding windows:'''
 *
 *  1. '''Fixed-size window''' -- the window always has exactly k elements. You slide it one
 *     position at a time: add the new element entering on the right, remove the element
 *     leaving on the left. Use for: max/min/average of all subarrays of size k.
 *
 *  2. '''Variable-size (dynamic) window''' -- the window grows (right pointer moves right)
 *     until a constraint is violated, then shrinks (left pointer moves right) until the
 *     constraint is satisfied again. Use for: smallest subarray with sum >= target, longest
 *     substring with at most k distinct characters.
 *
 * =When to expand vs shrink?=
 *   - '''Expand''' (move right pointer): when the current window does not yet satisfy the
 *     condition, or you are searching for a longer/larger valid window.
 *   - '''Shrink''' (move left pointer): when the current window violates the constraint
 *     (e.g., too many distinct chars, sum exceeds limit) or you want the smallest valid window.
 *
 * =Interview Tips=
 *   - "Sliding window is the go-to pattern for substring/subarray problems with constraints."
 *   - If the problem says "contiguous subarray" or "substring" with some min/max condition,
 *     think sliding window first.
 *   - Fixed-size windows are straightforward; variable-size requires careful handling of the
 *     shrink step (often a while loop inside the main for loop).
 *   - A common auxiliary data structure inside the window is a HashMap (frequency count of
 *     elements currently in the window).
 *   - Related LeetCode: #3 (Longest Substring Without Repeating), #76 (Minimum Window
 *     Substring), #209 (Minimum Size Subarray Sum), #340 (Longest Substring with At Most K
 *     Distinct Characters), #424 (Longest Repeating Character Replacement),
 *     #904 (Fruit Into Baskets), #918 (Maximum Sum Circular Subarray),
 *     #1004 (Max Consecutive Ones III).
 */
object Algo004_ArraySlidingWindow {

  // ---------------------------------------------------------------------------
  // Exercise 1: Max Sum Subarray of Size K (Fixed-size window)
  // Time: O(n) | Space: O(1)
  // Approach: compute sum of first k elements. Slide: add arr(i), subtract arr(i-k).
  //   Track the maximum sum seen.
  // ---------------------------------------------------------------------------
  // TODO: Find the maximum sum of any contiguous subarray of size k
  // Example: Array(2,1,5,1,3,2), k=3 => 9 (subarray [5,1,3])
  def maxSumSubarrayOfSizeK(arr: Array[Int], k: Int): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 2: Smallest Subarray With Sum >= Target (Variable-size window)
  // Time: O(n) | Space: O(1)
  // Approach: expand right to grow sum. Once sum >= target, try shrinking from
  //   left to find minimum length. Track minimum length across all valid windows.
  // LeetCode #209
  // ---------------------------------------------------------------------------
  // TODO: Find the length of the smallest contiguous subarray whose sum >= target
  // Return 0 if no such subarray exists
  // Example: Array(2,1,5,2,3,2), target=7 => 2 (subarray [5,2])
  def smallestSubarrayWithSum(arr: Array[Int], target: Int): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 3: Longest Substring with K Distinct Characters (Variable-size window)
  // Time: O(n) | Space: O(k) for the frequency map
  // Approach: expand right, add char to frequency map. While map.size > k, shrink
  //   from left (decrement freq, remove if 0). Track max window length.
  // LeetCode #340
  // ---------------------------------------------------------------------------
  // TODO: Find the length of the longest substring with at most k distinct characters
  // Example: "araaci", k=2 => 4 ("araa")
  def longestSubstringKDistinct(s: String, k: Int): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 4: Max Consecutive Ones with K Flips (Variable-size window)
  // Time: O(n) | Space: O(1)
  // Approach: expand right; count zeroes in window. While zeroes > k, shrink left.
  //   Track max window length. The window always represents a valid segment.
  // LeetCode #1004
  // ---------------------------------------------------------------------------
  // TODO: Find the max number of consecutive 1s in a binary array
  // if you can flip at most k zeroes
  // Example: Array(1,1,0,0,1,1,1,0,1,1), k=2 => 8
  def maxConsecutiveOnes(arr: Array[Int], k: Int): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 5: Average of Subarrays of Size K (Fixed-size window)
  // Time: O(n) | Space: O(n-k+1) for the result array
  // Approach: same as maxSumSubarrayOfSizeK but store sum/k for each position.
  // ---------------------------------------------------------------------------
  // TODO: Find the averages of all contiguous subarrays of size k
  // Example: Array(1,3,2,6,1,4,5,8), k=3 => Array(2.0, 3.666..., 3.0, 3.666..., 3.333..., 5.666...)
  def averageOfSubarrays(arr: Array[Int], k: Int): Array[Double] = ???

  // ---------------------------------------------------------------------------
  // Exercise 6: Fruits Into Baskets (Variable-size window, k=2 distinct)
  // Time: O(n) | Space: O(1) -- at most 3 entries in the map
  // Approach: this is longestSubstringKDistinct with k=2 on an integer array.
  // LeetCode #904
  // ---------------------------------------------------------------------------
  // TODO: Find the maximum number of fruits you can collect in two baskets
  // Each basket can hold only one type of fruit. You must pick contiguously.
  // This is equivalent to longest subarray with at most 2 distinct elements.
  // Example: Array(1,2,1,2,3) => 4 (fruits [1,2,1,2])
  def fruitsIntoBaskets(fruits: Array[Int]): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 7: Maximum Sum Circular Subarray (Kadane's + trick)
  // Time: O(n) | Space: O(1)
  // Approach: the max circular subarray is either (a) a normal max subarray (Kadane's)
  //   or (b) total sum minus the minimum subarray (the "wrap-around" case).
  //   Answer = max(maxKadane, totalSum - minKadane). Edge case: if all negative,
  //   minKadane == totalSum, so return maxKadane (can't take empty subarray).
  // LeetCode #918
  // ---------------------------------------------------------------------------
  // TODO: Find the maximum sum circular subarray
  // The array is conceptually circular (last connects to first)
  // Example: Array(5,-3,5) => 10 (wrap around: [5,5])
  def maxSumCircular(arr: Array[Int]): Int = ???

  // ---------------------------------------------------------------------------
  // Exercise 8: Longest Subarray with Sum <= K (Variable-size window)
  // Time: O(n) | Space: O(1)
  // Approach: expand right, add to sum. While sum > k, shrink left. Track max
  //   window length. Works because all elements are positive (shrinking always
  //   decreases the sum).
  // ---------------------------------------------------------------------------
  // TODO: Find the length of the longest subarray with sum <= k
  // All elements are positive
  // Example: Array(1,2,3,4,5), k=8 => 3 (subarray [1,2,3] or [2,3,4]... wait [1,2,3]=6<=8, length 3)
  def longestSubarraySumAtMostK(arr: Array[Int], k: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: maxSumSubarrayOfSizeK
    assert(maxSumSubarrayOfSizeK(Array(2, 1, 5, 1, 3, 2), 3) == 9)
    assert(maxSumSubarrayOfSizeK(Array(2, 3, 4, 1, 5), 2) == 7)
    println("Exercise 1 passed: maxSumSubarrayOfSizeK")

    // Exercise 2: smallestSubarrayWithSum
    assert(smallestSubarrayWithSum(Array(2, 1, 5, 2, 3, 2), 7) == 2)
    assert(smallestSubarrayWithSum(Array(1, 1, 1), 10) == 0)
    println("Exercise 2 passed: smallestSubarrayWithSum")

    // Exercise 3: longestSubstringKDistinct
    assert(longestSubstringKDistinct("araaci", 2) == 4)
    assert(longestSubstringKDistinct("cbbebi", 3) == 5)
    println("Exercise 3 passed: longestSubstringKDistinct")

    // Exercise 4: maxConsecutiveOnes
    assert(maxConsecutiveOnes(Array(1, 1, 0, 0, 1, 1, 1, 0, 1, 1), 2) == 8)
    assert(maxConsecutiveOnes(Array(0, 0, 0), 0) == 0)
    println("Exercise 4 passed: maxConsecutiveOnes")

    // Exercise 5: averageOfSubarrays
    val avgs = averageOfSubarrays(Array(1, 3, 2, 6, 1, 4, 5, 8), 3)
    assert(avgs.length == 6)
    assert(math.abs(avgs(0) - 2.0) < 0.01)
    println("Exercise 5 passed: averageOfSubarrays")

    // Exercise 6: fruitsIntoBaskets
    assert(fruitsIntoBaskets(Array(1, 2, 1, 2, 3)) == 4)
    assert(fruitsIntoBaskets(Array(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)) == 5)
    println("Exercise 6 passed: fruitsIntoBaskets")

    // Exercise 7: maxSumCircular
    assert(maxSumCircular(Array(5, -3, 5)) == 10)
    assert(maxSumCircular(Array(-3, -2, -1)) == -1)
    println("Exercise 7 passed: maxSumCircular")

    // Exercise 8: longestSubarraySumAtMostK
    assert(longestSubarraySumAtMostK(Array(1, 2, 3, 4, 5), 8) == 3)
    assert(longestSubarraySumAtMostK(Array(1, 1, 1, 1), 2) == 2)
    println("Exercise 8 passed: longestSubarraySumAtMostK")

    println("All Algo004_ArraySlidingWindow exercises passed!")
  }
}
