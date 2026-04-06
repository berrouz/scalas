package org.shev4ik.interview.algorithms.level2_intermediate

object Algo048_DPStrings {

  // Exercise 1: Longest Common Subsequence — length of LCS of two strings
  // TODO: dp(i)(j) = if s1(i-1)==s2(j-1): dp(i-1)(j-1)+1; else max(dp(i-1)(j), dp(i)(j-1)).
  def longestCommonSubsequence(text1: String, text2: String): Int = ???

  // Exercise 2: Longest Common Substring — length of longest contiguous common substring
  // TODO: dp(i)(j) = if s1(i-1)==s2(j-1): dp(i-1)(j-1)+1; else 0. Track max.
  def longestCommonSubstring(text1: String, text2: String): Int = ???

  // Exercise 3: Longest Palindromic Subsequence
  // TODO: dp(i)(j) = length of longest palindromic subsequence of s[i..j].
  // If s(i)==s(j): dp(i+1)(j-1)+2. Else max(dp(i+1)(j), dp(i)(j-1)).
  def longestPalindromeSubseq(s: String): Int = ???

  // Exercise 4: Longest Palindromic Substring using DP
  // TODO: dp(i)(j) = true if s[i..j] is palindrome. dp(i)(i)=true. dp(i)(i+1) = s(i)==s(i+1).
  // dp(i)(j) = s(i)==s(j) && dp(i+1)(j-1). Track longest.
  def longestPalindrome(s: String): String = ???

  // Exercise 5: Distinct Subsequences — count subsequences of s that equal t
  // TODO: dp(i)(j) = dp(i-1)(j) + (if s(i-1)==t(j-1): dp(i-1)(j-1) else 0).
  def numDistinct(s: String, t: String): Int = ???

  // Exercise 6: Shortest Common Supersequence — shortest string that has both s1 and s2 as subsequences
  // TODO: Find LCS, then build supersequence by merging both strings along LCS.
  def shortestCommonSupersequence(str1: String, str2: String): String = ???

  // Exercise 7: Minimum insertions to make a string palindrome
  // TODO: Answer = s.length - longestPalindromicSubsequence(s).
  def minInsertions(s: String): Int = ???

  // Exercise 8: Wildcard Matching — '?' matches one char, '*' matches any sequence
  // TODO: dp(i)(j) = match of s[0..i-1] with p[0..j-1].
  // If p(j-1)=='*': dp(i-1)(j) || dp(i)(j-1). If p(j-1)=='?' or match: dp(i-1)(j-1).
  def isMatch(s: String, p: String): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(longestCommonSubsequence("abcde", "ace") == 3, "LCS of abcde, ace is 3")
    assert(longestCommonSubsequence("abc", "def") == 0, "No common subsequence")

    // Exercise 2
    assert(longestCommonSubstring("abcdef", "zbcdf") == 3, "Longest common substring 'bcd' length 3")

    // Exercise 3
    assert(longestPalindromeSubseq("bbbab") == 4, "Palindrome subsequence 'bbbb' length 4")
    assert(longestPalindromeSubseq("cbbd") == 2, "Palindrome subsequence 'bb' length 2")

    // Exercise 4
    assert(longestPalindrome("babad").length == 3, "Longest palindromic substring length 3")
    assert(longestPalindrome("cbbd") == "bb", "Longest palindromic substring 'bb'")

    // Exercise 5
    assert(numDistinct("rabbbit", "rabbit") == 3, "3 distinct subsequences")
    assert(numDistinct("babgbag", "bag") == 5, "5 distinct subsequences")

    // Exercise 6
    assert(shortestCommonSupersequence("abac", "cab").length == 5, "SCS length 5")

    // Exercise 7
    assert(minInsertions("zzazz") == 0, "Already palindrome")
    assert(minInsertions("mbadm") == 2, "2 insertions needed")

    // Exercise 8
    assert(isMatch("aa", "*"), "'*' matches everything")
    assert(!isMatch("cb", "?a"), "'?a' doesn't match 'cb'")
    assert(isMatch("adceb", "*a*b"), "Wildcard match")

    println("All Algo048_DPStrings exercises passed!")
  }
}
