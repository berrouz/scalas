package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo007_StringSearch {

  // TODO: Naive pattern search — find first index where pattern occurs in text
  // Return -1 if pattern not found
  // Example: "hello world", "world" => 6
  def naivePatternSearch(text: String, pattern: String): Int = ???

  // TODO: Implement indexOf from scratch — return first index of pattern in text
  // Return -1 if not found. Do not use built-in indexOf.
  // Example: "abcdef", "cde" => 2
  def indexOfImpl(text: String, pattern: String): Int = ???

  // TODO: Count how many times pattern occurs in text (non-overlapping)
  // Example: "ababab", "ab" => 3
  def countPatternOccurrences(text: String, pattern: String): Int = ???

  // TODO: Find all starting positions where pattern occurs in text
  // Return as a List of indices
  // Example: "abababab", "aba" => List(0, 2, 4) (overlapping matches)
  def findAllPatternPositions(text: String, pattern: String): List[Int] = ???

  // TODO: Find the longest repeated substring in the string
  // Example: "banana" => "ana" (appears at index 1 and 3)
  // If no repeated substring exists, return ""
  def longestRepeatedSubstring(s: String): String = ???

  // TODO: Check if s2 is a rotation of s1
  // Example: "waterbottle", "erbottlewat" => true
  // Hint: s2 is a rotation of s1 if s2 is a substring of s1+s1
  def isRotation(s1: String, s2: String): Boolean = ???

  // TODO: Check if s is a subsequence of t
  // A subsequence maintains relative order but not necessarily contiguous
  // Example: "ace", "abcde" => true
  def isSubsequence(s: String, t: String): Boolean = ???

  // TODO: Find the longest palindromic substring
  // Example: "babad" => "bab" or "aba" (either is valid)
  // Example: "cbbd" => "bb"
  def longestPalindromicSubstring(s: String): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: naivePatternSearch
    assert(naivePatternSearch("hello world", "world") == 6)
    assert(naivePatternSearch("hello", "xyz") == -1)
    println("Exercise 1 passed: naivePatternSearch")

    // Exercise 2: indexOfImpl
    assert(indexOfImpl("abcdef", "cde") == 2)
    assert(indexOfImpl("abcdef", "xyz") == -1)
    assert(indexOfImpl("aaa", "a") == 0)
    println("Exercise 2 passed: indexOfImpl")

    // Exercise 3: countPatternOccurrences
    assert(countPatternOccurrences("ababab", "ab") == 3)
    assert(countPatternOccurrences("hello", "ll") == 1)
    println("Exercise 3 passed: countPatternOccurrences")

    // Exercise 4: findAllPatternPositions
    assert(findAllPatternPositions("abababab", "aba") == List(0, 2, 4))
    assert(findAllPatternPositions("hello", "xyz") == List())
    println("Exercise 4 passed: findAllPatternPositions")

    // Exercise 5: longestRepeatedSubstring
    assert(longestRepeatedSubstring("banana") == "ana")
    assert(longestRepeatedSubstring("abc") == "")
    println("Exercise 5 passed: longestRepeatedSubstring")

    // Exercise 6: isRotation
    assert(isRotation("waterbottle", "erbottlewat") == true)
    assert(isRotation("hello", "llohe") == true)
    assert(isRotation("hello", "world") == false)
    println("Exercise 6 passed: isRotation")

    // Exercise 7: isSubsequence
    assert(isSubsequence("ace", "abcde") == true)
    assert(isSubsequence("aec", "abcde") == false)
    println("Exercise 7 passed: isSubsequence")

    // Exercise 8: longestPalindromicSubstring
    val lps1 = longestPalindromicSubstring("babad")
    assert(lps1 == "bab" || lps1 == "aba")
    assert(longestPalindromicSubstring("cbbd") == "bb")
    println("Exercise 8 passed: longestPalindromicSubstring")

    println("All Algo007_StringSearch exercises passed!")
  }
}
