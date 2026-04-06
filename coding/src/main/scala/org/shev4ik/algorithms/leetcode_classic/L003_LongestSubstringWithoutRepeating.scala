package org.shev4ik.algorithms.leetcode_classic

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring
 * without repeating characters.
 *
 * Pattern: Sliding Window
 * Time: O(n)
 * Space: O(min(m, n)) where m is charset size
 */
object L003_LongestSubstringWithoutRepeating {

  def lengthOfLongestSubstring(s: String): Int = {
    // TODO: Implement using Sliding Window with Set or Map
    // Hint: Use two pointers (left, right) and a Set to track characters
    ???
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb")) // Expected: 3 ("abc")
    println(lengthOfLongestSubstring("bbbbb"))    // Expected: 1 ("b")
    println(lengthOfLongestSubstring("pwwkew"))   // Expected: 3 ("wke")
    println(lengthOfLongestSubstring(""))         // Expected: 0
  }
}
