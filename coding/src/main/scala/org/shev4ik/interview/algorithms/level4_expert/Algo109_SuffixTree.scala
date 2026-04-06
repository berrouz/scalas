package org.shev4ik.interview.algorithms.level4_expert

/**
 * Suffix Tree - construction, search, and applications.
 *
 * Key concepts:
 * - Suffix tree: compressed trie of all suffixes of a string
 * - Ukkonen's algorithm: online O(n) construction
 * - Pattern matching, longest repeated substring, longest common substring
 * - Generalized suffix tree for multiple strings
 */
object Algo109_SuffixTree {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Suffix tree concept - build naive suffix trie
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a naive suffix trie (not compressed) for the given string.
   *       Insert all suffixes into a trie structure.
   *       Return the total number of nodes in the trie (including root).
   *
   * @param s input string (append '$' as terminal)
   * @return number of nodes in the suffix trie
   */
  def buildSuffixTrie(s: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Naive suffix tree construction (compressed trie)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a compressed suffix tree from the naive trie.
   *       Merge chains of single-child internal nodes into edges
   *       labeled with substrings.
   *       Return the number of internal nodes (non-leaf, including root).
   *
   * @param s input string (with terminal '$')
   * @return number of internal nodes in the compressed suffix tree
   */
  def buildNaiveSuffixTree(s: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Ukkonen's algorithm concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the core idea of Ukkonen's algorithm.
   *       Build the suffix tree incrementally (online) in O(n) time.
   *       Use suffix links, active point (node, edge, length), and
   *       the "rule 3" trick (do nothing if character already present).
   *       Return the number of leaves in the suffix tree (should equal |s|).
   *
   * @param s input string (with terminal '$')
   * @return number of leaves in the Ukkonen suffix tree
   */
  def ukkonenBuild(s: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Pattern search in suffix tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a text, build a suffix tree and then search for a pattern.
   *       Return all starting positions where the pattern occurs.
   *       Walk down the tree matching the pattern, then collect all
   *       leaf labels in the subtree.
   *
   * @param text    the text to index
   * @param pattern the pattern to search for
   * @return sorted list of starting positions (0-based)
   */
  def searchPattern(text: String, pattern: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Longest repeated substring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the longest repeated substring using a suffix tree.
   *       The longest repeated substring corresponds to the deepest
   *       internal node (by total edge-label length from root).
   *       Return the substring (empty string if no repetition).
   *
   * @param s input string
   * @return longest repeated substring
   */
  def longestRepeatedSubstring(s: String): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Longest common substring of two strings
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the longest common substring of two strings.
   *       Build a generalized suffix tree for s1#s2$ (with distinct
   *       terminators). The deepest internal node that has leaves from
   *       both strings gives the LCS.
   *
   * @param s1 first string
   * @param s2 second string
   * @return longest common substring
   */
  def longestCommonSubstring(s1: String, s2: String): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Suffix tree applications - count distinct substrings
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count the number of distinct substrings of a given string.
   *       In a suffix tree, each edge represents a unique substring path.
   *       The number of distinct substrings = sum of all edge lengths.
   *
   * @param s input string
   * @return number of distinct substrings (excluding empty string)
   */
  def countDistinctSubstrings(s: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Generalized suffix tree - check if pattern exists in any
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a generalized suffix tree for a collection of strings.
   *       Given a pattern, return the indices of all strings that
   *       contain the pattern as a substring.
   *
   * @param strings collection of strings
   * @param pattern the pattern to search for
   * @return sorted list of indices of strings containing the pattern
   */
  def generalizedSuffixTreeSearch(strings: List[String], pattern: String): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val triNodes = buildSuffixTrie("abc$")
    assert(triNodes > 0, s"Expected > 0 nodes, got $triNodes")
    println("Exercise 1 (Suffix trie concept) passed.")

    // Exercise 2
    val intNodes = buildNaiveSuffixTree("banana$")
    assert(intNodes > 0, s"Expected > 0 internal nodes, got $intNodes")
    println("Exercise 2 (Naive suffix tree) passed.")

    // Exercise 3
    val leaves = ukkonenBuild("banana$")
    assert(leaves == 7, s"Expected 7 leaves, got $leaves")
    println("Exercise 3 (Ukkonen's algorithm) passed.")

    // Exercise 4
    val positions = searchPattern("banana", "ana")
    assert(positions.sorted == List(1, 3), s"Expected List(1, 3), got $positions")
    println("Exercise 4 (Pattern search) passed.")

    // Exercise 5
    val lrs = longestRepeatedSubstring("banana")
    assert(lrs == "ana", s"Expected 'ana', got '$lrs'")
    println("Exercise 5 (Longest repeated substring) passed.")

    // Exercise 6
    val lcs = longestCommonSubstring("abcdef", "xbcdyz")
    assert(lcs == "bcd", s"Expected 'bcd', got '$lcs'")
    println("Exercise 6 (Longest common substring) passed.")

    // Exercise 7
    val distinct = countDistinctSubstrings("abc")
    assert(distinct == 6, s"Expected 6, got $distinct") // a,b,c,ab,bc,abc
    println("Exercise 7 (Count distinct substrings) passed.")

    // Exercise 8
    val result = generalizedSuffixTreeSearch(List("hello", "world", "help"), "hel")
    assert(result == List(0, 2), s"Expected List(0, 2), got $result")
    println("Exercise 8 (Generalized suffix tree) passed.")

    println("All Algo109_SuffixTree exercises passed!")
  }
}
