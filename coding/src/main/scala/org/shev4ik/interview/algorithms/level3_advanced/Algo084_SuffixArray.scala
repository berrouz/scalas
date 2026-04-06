package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Suffix Array - a sorted array of all suffixes of a string.
 *
 * Key concepts:
 * - Suffix array: sorted indices of all suffixes
 * - LCP array: longest common prefix between consecutive suffixes in sorted order
 * - Applications: substring search, longest repeated substring, distinct substrings
 */
object Algo084_SuffixArray {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Naive suffix array construction
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a suffix array by sorting all suffixes lexicographically.
   *       Return array of starting indices of sorted suffixes.
   *       O(n^2 log n) with naive comparison sort.
   *
   * @param s input string
   * @return suffix array (array of starting indices)
   */
  def naiveSuffixArray(s: String): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: SA-IS concept (O(n) construction)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an efficient suffix array construction.
   *       Use the prefix-doubling approach: O(n log^2 n) or O(n log n).
   *       In each round, sort suffixes by their first 2^k characters.
   *
   * @param s input string
   * @return suffix array
   */
  def efficientSuffixArray(s: String): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: LCP array
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build the LCP (Longest Common Prefix) array from a suffix array.
   *       lcp(i) = length of longest common prefix between suffix sa(i) and sa(i-1).
   *       Use Kasai's algorithm: O(n).
   *
   * @param s  input string
   * @param sa suffix array
   * @return LCP array (length n, lcp(0) = 0)
   */
  def buildLCPArray(s: String, sa: Array[Int]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Longest repeated substring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the longest substring that appears at least twice in s.
   *       Use suffix array + LCP array: answer = max value in LCP array.
   *       Return the substring (empty string if none).
   *
   * @param s input string
   * @return longest repeated substring
   */
  def longestRepeatedSubstring(s: String): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Number of distinct substrings
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of distinct substrings of s.
   *       Total substrings = n*(n+1)/2. Subtract sum of LCP values.
   *
   * @param s input string
   * @return number of distinct substrings
   */
  def countDistinctSubstrings(s: String): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Longest common substring of two strings via SA
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the longest common substring of two strings s1 and s2.
   *       Concatenate s1 + "#" + s2, build suffix array and LCP array.
   *       Find max LCP where adjacent suffixes come from different strings.
   *
   * @param s1 first string
   * @param s2 second string
   * @return longest common substring
   */
  def longestCommonSubstring(s1: String, s2: String): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Pattern search via suffix array
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for pattern in text using suffix array with binary search.
   *       Return all starting positions where pattern occurs.
   *       O(m log n) where m = pattern length, n = text length.
   *
   * @param text    the text (suffix array built on this)
   * @param sa      precomputed suffix array
   * @param pattern pattern to search
   * @return list of starting positions
   */
  def searchWithSA(text: String, sa: Array[Int], pattern: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Suffix array applications - lexicographically smallest rotation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the lexicographically smallest rotation of string s.
   *       Hint: Concatenate s + s, build suffix array, find the smallest suffix
   *       of length >= n starting within first n characters.
   *
   * @param s input string
   * @return lexicographically smallest rotation
   */
  def smallestRotation(s: String): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val sa1 = naiveSuffixArray("banana")
    // Suffixes sorted: a, ana, anana, banana, na, nana
    // Indices:          5, 3,   1,     0,     4,  2
    assert(sa1.toList == List(5, 3, 1, 0, 4, 2), s"Got ${sa1.toList}")
    println("Exercise 1 (Naive SA) passed.")

    // Exercise 2
    val sa2 = efficientSuffixArray("banana")
    assert(sa2.toList == List(5, 3, 1, 0, 4, 2))
    println("Exercise 2 (Efficient SA) passed.")

    // Exercise 3
    val lcp3 = buildLCPArray("banana", sa1)
    // LCP: 0, 1, 3, 0, 0, 2
    assert(lcp3.toList == List(0, 1, 3, 0, 0, 2), s"Got ${lcp3.toList}")
    println("Exercise 3 (LCP array) passed.")

    // Exercise 4
    val lrs = longestRepeatedSubstring("banana")
    assert(lrs == "ana", s"Expected 'ana', got '$lrs'")
    println("Exercise 4 (Longest repeated substring) passed.")

    // Exercise 5
    val dsc = countDistinctSubstrings("abc")
    assert(dsc == 6, s"Expected 6, got $dsc") // a,b,c,ab,bc,abc
    println("Exercise 5 (Distinct substrings) passed.")

    // Exercise 6
    val lcs = longestCommonSubstring("abcde", "cdefg")
    assert(lcs == "cde", s"Expected 'cde', got '$lcs'")
    println("Exercise 6 (Longest common substring) passed.")

    // Exercise 7
    val text7 = "banana"
    val sa7 = naiveSuffixArray(text7)
    val found = searchWithSA(text7, sa7, "ana").sorted
    assert(found == List(1, 3), s"Expected List(1,3), got $found")
    println("Exercise 7 (Pattern search SA) passed.")

    // Exercise 8
    val sr = smallestRotation("cba")
    assert(sr == "acb", s"Expected 'acb', got '$sr'")
    println("Exercise 8 (Smallest rotation) passed.")

    println("All Algo084_SuffixArray exercises passed!")
  }
}
