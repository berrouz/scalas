package org.shev4ik.interview.algorithms.level2_intermediate

object Algo068_StringDP {

  // Exercise 1: Regular Expression Matching — '.' matches any char, '*' matches zero or more of preceding
  // TODO: dp(i)(j) = match of s[0..i-1] with p[0..j-1].
  // If p(j-1) == '*': dp(i)(j) = dp(i)(j-2) [zero match] || (match(s(i-1),p(j-2)) && dp(i-1)(j)) [one+ match].
  def isMatchRegex(s: String, p: String): Boolean = ???

  // Exercise 2: Wildcard Matching — '?' matches one char, '*' matches any sequence
  // TODO: dp(i)(j). If p(j-1)=='*': dp(i-1)(j) || dp(i)(j-1). If '?' or match: dp(i-1)(j-1).
  def isMatchWildcard(s: String, p: String): Boolean = ???

  // Exercise 3: Edit Distance — min operations (insert, delete, replace) to transform word1 to word2
  // TODO: dp(i)(j) = if match: dp(i-1)(j-1); else 1 + min(dp(i-1)(j), dp(i)(j-1), dp(i-1)(j-1)).
  def minDistance(word1: String, word2: String): Int = ???

  // Exercise 4: Distinct Subsequences — count subsequences of s that equal t
  // TODO: dp(i)(j) = dp(i-1)(j) + (if s(i-1)==t(j-1): dp(i-1)(j-1) else 0).
  def numDistinct(s: String, t: String): Int = ???

  // Exercise 5: Scramble String — is s2 a scramble of s1?
  // TODO: dp(i)(j)(len) = true if s1[i..i+len-1] and s2[j..j+len-1] are scrambles.
  // For each split k: (match left-left && right-right) || (match left-right && right-left).
  def isScramble(s1: String, s2: String): Boolean = ???

  // Exercise 6: Minimum ASCII Delete Sum for Two Strings
  // TODO: dp(i)(j) = min ASCII sum of deleted chars to make s1[0..i-1] and s2[0..j-1] equal.
  // If match: dp(i-1)(j-1). Else: min(dp(i-1)(j) + s1(i-1), dp(i)(j-1) + s2(j-1)).
  def minimumDeleteSum(s1: String, s2: String): Int = ???

  // Exercise 7: Longest Palindromic Subsequence
  // TODO: dp(i)(j) = length of longest palindromic subsequence in s[i..j].
  // If s(i)==s(j): dp(i+1)(j-1)+2. Else: max(dp(i+1)(j), dp(i)(j-1)).
  def longestPalindromeSubseq(s: String): Int = ???

  // Exercise 8: Count Palindromic Substrings — total number of palindromic substrings
  // TODO: Expand from center for each position (odd and even length palindromes). Count all.
  def countSubstrings(s: String): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(isMatchRegex("aa", "a*"), "a* matches aa")
    assert(isMatchRegex("ab", ".*"), ".* matches ab")
    assert(!isMatchRegex("mississippi", "mis*is*p*."), "No match")

    // Exercise 2
    assert(isMatchWildcard("aa", "*"), "* matches everything")
    assert(!isMatchWildcard("cb", "?a"), "?a doesn't match cb")
    assert(isMatchWildcard("adceb", "*a*b"), "Wildcard match")

    // Exercise 3
    assert(minDistance("horse", "ros") == 3, "Edit distance 3")
    assert(minDistance("intention", "execution") == 5, "Edit distance 5")

    // Exercise 4
    assert(numDistinct("rabbbit", "rabbit") == 3, "3 distinct subsequences")

    // Exercise 5
    assert(isScramble("great", "rgeat"), "great is scramble of rgeat")
    assert(!isScramble("abcde", "caebd"), "Not a scramble")

    // Exercise 6
    assert(minimumDeleteSum("sea", "eat") == 231, "Delete s(115) + t(116) = 231")

    // Exercise 7
    assert(longestPalindromeSubseq("bbbab") == 4, "LPS = bbbb length 4")
    assert(longestPalindromeSubseq("cbbd") == 2, "LPS = bb length 2")

    // Exercise 8
    assert(countSubstrings("abc") == 3, "3 palindromic substrings: a, b, c")
    assert(countSubstrings("aaa") == 6, "6 palindromic substrings")

    println("All Algo068_StringDP exercises passed!")
  }
}
