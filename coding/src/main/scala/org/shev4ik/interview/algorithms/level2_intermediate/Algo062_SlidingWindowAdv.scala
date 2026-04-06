package org.shev4ik.interview.algorithms.level2_intermediate

object Algo062_SlidingWindowAdv {

  // Exercise 1: Minimum Window Substring — shortest substring of s containing all chars of t
  // TODO: Expand right to include all chars. Contract left to minimize. Track counts with maps.
  def minWindow(s: String, t: String): String = ???

  // Exercise 2: Longest Substring Without Repeating Characters
  // TODO: Sliding window with set/map. Move left when duplicate found.
  def lengthOfLongestSubstring(s: String): Int = ???

  // Exercise 3: Longest Substring with At Most K Distinct Characters
  // TODO: Sliding window with char frequency map. Shrink from left when distinct > k.
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = ???

  // Exercise 4: Find All Anagrams in a String — return start indices
  // TODO: Fixed-size sliding window. Compare frequency maps. Slide by removing left, adding right.
  def findAnagrams(s: String, p: String): List[Int] = ???

  // Exercise 5: Permutation in String — does s2 contain a permutation of s1?
  // TODO: Sliding window of size s1.length over s2. Check if frequencies match.
  def checkInclusion(s1: String, s2: String): Boolean = ???

  // Exercise 6: Max Consecutive Ones III — max consecutive 1s if you can flip at most k zeros
  // TODO: Sliding window. Count zeros in window. Shrink from left when zeros > k.
  def longestOnes(nums: Array[Int], k: Int): Int = ???

  // Exercise 7: Fruit Into Baskets — longest subarray with at most 2 distinct values
  // TODO: Sliding window with frequency map. Shrink when distinct > 2.
  def totalFruit(fruits: Array[Int]): Int = ???

  // Exercise 8: Subarrays with K Different Integers — count subarrays with exactly k distinct
  // TODO: atMost(k) - atMost(k-1). Where atMost(k) counts subarrays with at most k distinct.
  def subarraysWithKDistinct(nums: Array[Int], k: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(minWindow("ADOBECODEBANC", "ABC") == "BANC", "Min window substring")
    assert(minWindow("a", "aa") == "", "Impossible window")

    // Exercise 2
    assert(lengthOfLongestSubstring("abcabcbb") == 3, "Longest substring 3")
    assert(lengthOfLongestSubstring("bbbbb") == 1, "Longest substring 1")

    // Exercise 3
    assert(lengthOfLongestSubstringKDistinct("eceba", 2) == 3, "Longest with 2 distinct = 3")
    assert(lengthOfLongestSubstringKDistinct("aa", 1) == 2, "All same char")

    // Exercise 4
    assert(findAnagrams("cbaebabacd", "abc") == List(0, 6), "Anagram indices")

    // Exercise 5
    assert(checkInclusion("ab", "eidbaooo"), "Permutation found")
    assert(!checkInclusion("ab", "eidboaoo"), "No permutation")

    // Exercise 6
    assert(longestOnes(Array(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2) == 6, "Max ones with 2 flips")

    // Exercise 7
    assert(totalFruit(Array(1, 2, 1)) == 3, "All fruits")
    assert(totalFruit(Array(0, 1, 2, 2)) == 3, "Fruits: [1,2,2]")

    // Exercise 8
    assert(subarraysWithKDistinct(Array(1, 2, 1, 2, 3), 2) == 7, "7 subarrays with 2 distinct")
    assert(subarraysWithKDistinct(Array(1, 2, 1, 3, 4), 3) == 3, "3 subarrays with 3 distinct")

    println("All Algo062_SlidingWindowAdv exercises passed!")
  }
}
