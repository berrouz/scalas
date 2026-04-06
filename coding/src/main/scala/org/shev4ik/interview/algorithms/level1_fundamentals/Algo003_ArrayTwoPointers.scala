package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Two-Pointer Technique
 *
 * =Theory=
 *
 * The two-pointer technique uses two index variables that move through the data structure
 * (usually an array or string) to solve problems in O(n) time instead of O(n^2^) brute force.
 *
 * '''Two main variants:'''
 *
 *  1. '''Left/Right (opposite-direction) pointers''' -- start at both ends and move inward.
 *     Use for: sorted-array pair problems, palindrome checks, container/area problems.
 *
 *  2. '''Slow/Fast (same-direction) pointers''' -- both start at the beginning; fast moves
 *     ahead while slow tracks a position. Use for: removing duplicates, partitioning,
 *     cycle detection (Floyd's algorithm).
 *
 * =When to use two pointers?=
 *   - The array is '''sorted''' and you need to find pairs/triplets with a target sum.
 *   - You need to '''partition''' elements (move zeroes, Dutch national flag).
 *   - You need to check '''symmetry''' (palindrome).
 *   - You need to find an '''optimal pair''' (container with most water).
 *
 * =Key insight=
 * Two pointers work because at each step you can '''eliminate''' one possibility without
 * missing the answer. For sorted arrays: if sum < target, move left pointer right (need
 * larger value); if sum > target, move right pointer left (need smaller value).
 *
 * =Interview Tips=
 *   - Two pointers often turns an O(n^2^) brute force into O(n). Mention this trade-off.
 *   - For unsorted arrays, you can either sort first (O(n log n) + O(n)) or use a HashSet
 *     for O(n) with O(n) space. Discuss both options with the interviewer.
 *   - Dutch National Flag (3-way partition) is a classic follow-up to quicksort discussions.
 *   - Related LeetCode: #1 (Two Sum), #11 (Container With Most Water), #15 (3Sum),
 *     #26 (Remove Duplicates), #75 (Sort Colors), #125 (Valid Palindrome),
 *     #167 (Two Sum II - Sorted), #283 (Move Zeroes).
 */
object Algo003_ArrayTwoPointers {

  // ---------------------------------------------------------------------------
  // Exercise 1: Two Sum on Sorted Array (Left/Right pointers)
  // Time: O(n) | Space: O(1)
  // Approach: left=0, right=n-1. If sum < target, left++. If sum > target, right--.
  // LeetCode #167 - Two Sum II
  // ---------------------------------------------------------------------------
  // TODO: Given a sorted array, find two numbers that add up to target
  // Return their indices as a tuple, or None if no pair exists
  // Use two-pointer technique for O(n) time
  // Example: Array(1,2,3,4,6), target=6 => Some((1,3)) because 2+4=6
  def twoSumSorted(sortedArr: Array[Int], target: Int): Option[(Int, Int)] = {
    var left = 0
    var right = sortedArr.length - 1

    while (left < right){
      val sum = sortedArr(left) + sortedArr(right)
      if (sum == target) {
        return Some((left, right))
      }
      if (sum < target){
        left +=1
      } else {
        right -=1
      }
    }
    None
  }

  // ---------------------------------------------------------------------------
  // Exercise 2: Remove Duplicates from Sorted Array (Slow/Fast pointers)
  // Time: O(n) | Space: O(1) in-place (O(n) here since we return new array)
  // Approach: slow pointer tracks write position; fast scans ahead. Write when
  //   arr(fast) != arr(slow).
  // LeetCode #26
  // ---------------------------------------------------------------------------
  // TODO: Remove duplicates from a sorted array in-place
  // Return a new array with duplicates removed (simulating in-place with functional style)
  // Example: Array(1,1,2,2,3) => Array(1,2,3)
  def removeDuplicatesInPlace(sortedArr: Array[Int]): Array[Int] = {
    if (sortedArr.isEmpty) return Array.empty
    var slow = 0
    for (fast <- 1 until sortedArr.length){
      if (sortedArr(fast) != sortedArr(slow)){
        slow += 1
        sortedArr(slow) = sortedArr(fast)
      }
    }
    sortedArr.take(slow + 1)

  }

  // ---------------------------------------------------------------------------
  // Exercise 3: Move Zeroes (Slow/Fast pointers)
  // Time: O(n) | Space: O(1) in-place (O(n) here for functional result)
  // Approach: slow points to next write position for non-zero; fast scans all.
  //   Swap arr(slow) and arr(fast) when arr(fast) != 0, then slow++.
  // LeetCode #283
  // ---------------------------------------------------------------------------
  // TODO: Move all zeroes to the end while maintaining relative order of non-zero elements
  // Example: Array(0,1,0,3,12) => Array(1,3,12,0,0)
  def moveZeroes(arr: Array[Int]): Array[Int] = {
    if (arr.isEmpty) return arr
    var slow = 0
    for (fast <- arr.indices){
      if (arr(fast) != 0){
        if (slow != fast){
          val temp = arr(slow)
          arr(slow) = arr(fast)
          arr(fast) = temp
        }
        slow += 1
      }
    }
    arr
  }

  // ---------------------------------------------------------------------------
  // Exercise 4: Reverse Array In-Place (Left/Right pointers)
  // Time: O(n) | Space: O(1)
  // Approach: swap arr(left) and arr(right), then left++, right--.
  // ---------------------------------------------------------------------------
  // TODO: Reverse the array in-place (mutating the input array)
  // Use two-pointer technique swapping from both ends
  // Example: Array(1,2,3,4,5) => Array(5,4,3,2,1)
  def reverseArrayInPlace(arr: Array[Int]): Unit = {
    var slow = 0
    var fast = arr.length - 1
    while (slow < fast){
      val temp = arr(slow)
      arr(slow) = arr(fast)
      arr(fast) = temp
      slow += 1
      fast -= 1
    }
  }

  // ---------------------------------------------------------------------------
  // Exercise 5: Pair With Sum (unsorted)
  // Time: O(n) with HashSet | O(n log n) with sort + two pointers
  // Space: O(n) with HashSet | O(1) extra with sort (if in-place sort)
  // Approach (HashSet): for each element x, check if (target - x) is in the set.
  // LeetCode #1 (Two Sum)
  // ---------------------------------------------------------------------------
  // TODO: Find if there exists a pair in the array whose sum equals target
  // Array is NOT sorted -- use a Set or sort+two-pointers approach
  // Example: Array(8,7,2,5,3,1), target=10 => true (7+3=10)
  def pairWithSum(arr: Array[Int], target: Int): Boolean = {
    val set = scala.collection.mutable.Set[Int]()
    for(num <- arr){
      if (set.contains(target - num)){
        return true
      }
      set += num
    }
    false
  }

  // ---------------------------------------------------------------------------
  // Exercise 6: Palindrome Array Check (Left/Right pointers)
  // Time: O(n) | Space: O(1)
  // Approach: compare arr(left) and arr(right); if mismatch, return false.
  // LeetCode #125 (Valid Palindrome -- string variant)
  // ---------------------------------------------------------------------------
  // TODO: Check if an array reads the same forwards and backwards
  // Example: Array(1,2,3,2,1) => true, Array(1,2,3) => false
  def isPalindromeArray(arr: Array[Int]): Boolean = {
    var slow = 0
    var fast = arr.length - 1
    while(slow < fast){
      if (arr(slow) != arr(fast)){
        return false
      }

      slow += 1
      fast -= 1
    }

    true
  }

  // ---------------------------------------------------------------------------
  // Exercise 7: Container With Most Water (Left/Right pointers)
  // Time: O(n) | Space: O(1)
  // Approach: start with widest container (left=0, right=n-1). Move the pointer
  //   with the shorter height inward (greedy: keeping the taller line gives a
  //   better chance of finding more water).
  // LeetCode #11
  // ---------------------------------------------------------------------------
  // TODO: Container with most water -- given array of heights, find two lines that together
  // with the x-axis form a container that holds the most water
  // Water = min(height[i], height[j]) * (j - i)
  // Example: Array(1,8,6,2,5,4,8,3,7) => 49
  def containerWithMostWater(heights: Array[Int]): Int = {
    var left = 0
    var right = heights.length - 1
    var max = Int.MinValue
    while(left < right){
      val currArea = (right - left) * Math.min(heights(left), heights(right))
      max = Math.max(max, currArea)
      if (heights(left) < heights(right)){
        left += 1
      } else {
        right -= 1
      }
    }
    max
  }

  // ---------------------------------------------------------------------------
  // Exercise 8: Sort Colors / Dutch National Flag (Three pointers)
  // Time: O(n) | Space: O(1)
  // Approach: maintain three pointers -- lo (boundary of 0s), mid (current), hi
  //   (boundary of 2s). If arr(mid)==0, swap with lo, advance both. If arr(mid)==2,
  //   swap with hi, decrement hi (don't advance mid -- swapped value unknown).
  //   If arr(mid)==1, just advance mid.
  // LeetCode #75
  // ---------------------------------------------------------------------------
  // TODO: Sort an array containing only 0s, 1s, and 2s (Dutch National Flag)
  // Example: Array(2,0,2,1,1,0) => Array(0,0,1,1,2,2)
  def sortColors(arr: Array[Int]): Array[Int] = {
    var lo = 0
    var mid = 0
    var hi = arr.length - 1

    while (mid <= hi){
      arr(mid) match {
        case 0 =>
          val temp = arr(lo)
          arr(lo) = arr(mid)
          arr(mid) = temp
          lo += 1
          mid += 1
        case 1 =>
          mid += 1
        case 2 =>
          val temp = arr(hi)
          arr(hi) = arr(mid)
          arr(mid) = temp
          hi -=1
      }
    }

    arr
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: twoSumSorted
    assert(twoSumSorted(Array(1, 2, 3, 4, 6), 6) == Some((1, 3)))
    assert(twoSumSorted(Array(1, 2, 3), 10) == None)
    println("Exercise 1 passed: twoSumSorted")

    // Exercise 2: removeDuplicatesInPlace
    assert(removeDuplicatesInPlace(Array(1, 1, 2, 2, 3)).toSeq == Seq(1, 2, 3))
    assert(removeDuplicatesInPlace(Array(1, 1, 1)).toSeq == Seq(1))
    println("Exercise 2 passed: removeDuplicatesInPlace")

    // Exercise 3: moveZeroes
    assert(moveZeroes(Array(0, 1, 0, 3, 12)).toSeq == Seq(1, 3, 12, 0, 0))
    assert(moveZeroes(Array(0, 0, 0)).toSeq == Seq(0, 0, 0))
    println("Exercise 3 passed: moveZeroes")

    // Exercise 4: reverseArrayInPlace
    val arr4 = Array(1, 2, 3, 4, 5)
    reverseArrayInPlace(arr4)
    assert(arr4.toSeq == Seq(5, 4, 3, 2, 1))
    println("Exercise 4 passed: reverseArrayInPlace")

    // Exercise 5: pairWithSum
    assert(pairWithSum(Array(8, 7, 2, 5, 3, 1), 10) == true)
    assert(pairWithSum(Array(1, 2, 3), 10) == false)
    println("Exercise 5 passed: pairWithSum")

    // Exercise 6: isPalindromeArray
    assert(isPalindromeArray(Array(1, 2, 3, 2, 1)) == true)
    assert(isPalindromeArray(Array(1, 2, 3)) == false)
    println("Exercise 6 passed: isPalindromeArray")

    // Exercise 7: containerWithMostWater
    assert(containerWithMostWater(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
    assert(containerWithMostWater(Array(1, 1)) == 1)
    println("Exercise 7 passed: containerWithMostWater")

    // Exercise 8: sortColors
    assert(sortColors(Array(2, 0, 2, 1, 1, 0)).toSeq == Seq(0, 0, 1, 1, 2, 2))
    assert(sortColors(Array(2, 0, 1)).toSeq == Seq(0, 1, 2))
    println("Exercise 8 passed: sortColors")

    println("All Algo003_ArrayTwoPointers exercises passed!")
  }
}
