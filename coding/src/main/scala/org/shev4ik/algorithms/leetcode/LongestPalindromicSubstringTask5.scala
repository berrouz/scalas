package org.shev4ik.algorithms.leetcode

object LongestPalindromicSubstringTask5 extends App {

  def longestPalindrome(s: String): String = {
    val last = s.length-1
    def longest(acc: String, left: Int, right: Int): String = {
      if (left < 0 || right > last || s.charAt(left) !=  s.charAt(right)){
        acc
      } else {
        longest( s.charAt(left) + acc + s.charAt(right), left -1 , right + 1)
      }
    }
    ""
  }
}
