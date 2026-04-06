package org.shev4ik.interview.algorithms.level3_advanced

/**
 * String Matching Algorithms - efficient pattern searching.
 *
 * Key concepts:
 * - KMP: O(n + m) with failure function preprocessing
 * - Rabin-Karp: rolling hash, O(n + m) average
 * - Z-algorithm: Z-array for all occurrences, O(n + m)
 */
object Algo083_StringMatching {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: KMP algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement KMP string matching algorithm.
   *       Return the index of the first occurrence of pattern in text,
   *       or -1 if not found.
   *
   * @param text    text to search in
   * @param pattern pattern to search for
   * @return index of first match or -1
   */
  def kmpSearch(text: String, pattern: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: KMP failure function (partial match table)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build the KMP failure function (also called partial match table or pi array).
   *       failure(i) = length of longest proper prefix of pattern[0..i]
   *       that is also a suffix.
   *
   * @param pattern the pattern string
   * @return failure function array
   */
  def kmpFailureFunction(pattern: String): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Rabin-Karp algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Rabin-Karp string matching using rolling hash.
   *       Return all starting indices where pattern occurs in text.
   *       Use a prime modulus to reduce collisions.
   *
   * @param text    text to search
   * @param pattern pattern to find
   * @return list of starting indices of all occurrences
   */
  def rabinKarp(text: String, pattern: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Z-algorithm
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the Z-algorithm.
   *       Z(i) = length of longest substring starting at i that matches a prefix of s.
   *       Z(0) is defined as 0 (or len(s) by convention).
   *       Use the Z-box optimization for O(n) time.
   *
   * @param s input string
   * @return Z-array
   */
  def zAlgorithm(s: String): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Z-function based string matching
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Use the Z-algorithm for pattern matching.
   *       Concatenate pattern + "$" + text, compute Z-array,
   *       find positions where Z(i) == pattern.length.
   *       Return all starting positions in the original text.
   *
   * @param text    text to search
   * @param pattern pattern to find
   * @return list of starting indices
   */
  def zSearch(text: String, pattern: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Count pattern occurrences
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of (possibly overlapping) occurrences of pattern in text.
   *       Use KMP or Z-algorithm for efficiency.
   *
   * @param text    text to search
   * @param pattern pattern to count
   * @return number of occurrences
   */
  def countOccurrences(text: String, pattern: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Multiple pattern search intro (Aho-Corasick concept)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a text and multiple patterns, find which patterns appear in the text.
   *       For simplicity, use any approach (KMP for each, or build a basic trie).
   *       Return the set of pattern indices that are found in the text.
   *
   * @param text     text to search
   * @param patterns array of patterns
   * @return set of indices of patterns found
   */
  def multiPatternSearch(text: String, patterns: Array[String]): Set[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Repeated substring pattern
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Check if string s can be formed by repeating a substring.
   *       Example: "abab" = "ab" repeated. Use KMP failure function.
   *       Hint: If n % (n - failure(n-1)) == 0 and failure(n-1) > 0, it's periodic.
   *
   * @param s input string
   * @return true if s is a repeated pattern
   */
  def repeatedSubstringPattern(s: String): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(kmpSearch("hello world", "world") == 6)
    assert(kmpSearch("aaaa", "bbb") == -1)
    assert(kmpSearch("AABAACAADAABAABA", "AABA") == 0)
    println("Exercise 1 (KMP search) passed.")

    // Exercise 2
    val ff = kmpFailureFunction("AABAACAABAA")
    assert(ff(0) == 0)
    assert(ff(1) == 1) // "AA" -> prefix "A"
    assert(ff.last == 2)
    println("Exercise 2 (KMP failure function) passed.")

    // Exercise 3
    val rk = rabinKarp("AABAACAADAABAABA", "AABA")
    assert(rk.contains(0))
    assert(rk.contains(9))
    assert(rk.contains(12))
    println("Exercise 3 (Rabin-Karp) passed.")

    // Exercise 4
    val z4 = zAlgorithm("aabxaab")
    assert(z4(4) == 3, s"Expected Z(4)=3, got ${z4(4)}")
    println("Exercise 4 (Z-algorithm) passed.")

    // Exercise 5
    val zs = zSearch("AABAACAADAABAABA", "AABA")
    assert(zs.contains(0) && zs.contains(9) && zs.contains(12))
    println("Exercise 5 (Z-search) passed.")

    // Exercise 6
    assert(countOccurrences("aaa", "aa") == 2)
    assert(countOccurrences("abcabc", "abc") == 2)
    println("Exercise 6 (Count occurrences) passed.")

    // Exercise 7
    val found = multiPatternSearch("abcdef", Array("abc", "xyz", "def", "gh"))
    assert(found == Set(0, 2), s"Expected Set(0,2), got $found")
    println("Exercise 7 (Multi-pattern search) passed.")

    // Exercise 8
    assert(repeatedSubstringPattern("abab"))
    assert(repeatedSubstringPattern("abcabcabc"))
    assert(!repeatedSubstringPattern("abc"))
    assert(!repeatedSubstringPattern("a"))
    println("Exercise 8 (Repeated substring) passed.")

    println("All Algo083_StringMatching exercises passed!")
  }
}
