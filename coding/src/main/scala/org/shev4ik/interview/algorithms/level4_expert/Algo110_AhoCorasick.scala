package org.shev4ik.interview.algorithms.level4_expert

import scala.collection.mutable

/**
 * Aho-Corasick - multi-pattern string matching automaton.
 *
 * Key concepts:
 * - Trie construction from multiple patterns
 * - Failure links (similar to KMP failure function, across patterns)
 * - Output links for efficient reporting of all matches
 * - O(n + m + z) where n = text length, m = total pattern length, z = matches
 */
object Algo110_AhoCorasick {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Build trie from patterns
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a trie from a list of pattern strings.
   *       Each node has a map of children and optionally stores
   *       which patterns end at that node.
   *       Return the total number of nodes in the trie (including root).
   *
   * @param patterns list of pattern strings
   * @return number of nodes in the trie
   */
  def buildTrie(patterns: List[String]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Build failure links
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: After building the trie, compute failure links using BFS.
   *       A failure link for node u points to the longest proper suffix
   *       of the string represented by u that is also a prefix of some pattern.
   *       Return a map from node id to its failure link node id.
   *       Root and depth-1 nodes have failure links to root (node 0).
   *
   * @param patterns list of pattern strings
   * @return map of (nodeId -> failureLinkNodeId)
   */
  def buildFailureLinks(patterns: List[String]): Map[Int, Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Build output links
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build output (dictionary suffix) links.
   *       An output link for node u points to the nearest ancestor
   *       via failure links that is also an end of a pattern.
   *       This enables reporting all matching patterns at each state.
   *       Return a map from nodeId to list of pattern indices that end there.
   *
   * @param patterns list of pattern strings
   * @return map of (nodeId -> list of pattern indices matching at that node)
   */
  def buildOutputLinks(patterns: List[String]): Map[Int, List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Search text using Aho-Corasick
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Search for all pattern occurrences in the text using the
   *       Aho-Corasick automaton. Return a list of (position, patternIndex)
   *       where position is the starting index of the match in text.
   *
   * @param text     the text to search in
   * @param patterns list of pattern strings
   * @return list of (startPosition, patternIndex) sorted by position
   */
  def searchText(text: String, patterns: List[String]): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Multi-pattern matching - find all patterns present
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a text and patterns, return the set of pattern indices
   *       that appear at least once in the text.
   *
   * @param text     the text to search in
   * @param patterns list of pattern strings
   * @return set of pattern indices that were found
   */
  def multiPatternMatch(text: String, patterns: List[String]): Set[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Count occurrences of each pattern
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count how many times each pattern occurs in the text.
   *       Return a map from pattern index to count.
   *
   * @param text     the text to search in
   * @param patterns list of pattern strings
   * @return map of (patternIndex -> occurrenceCount)
   */
  def countOccurrences(text: String, patterns: List[String]): Map[Int, Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: DNA pattern matching
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a DNA sequence (only A, C, G, T) and a list of gene patterns,
   *       find all occurrences. Optimize the trie for the 4-character alphabet.
   *       Return list of (position, patternIndex).
   *
   * @param dna      DNA sequence string
   * @param patterns list of gene pattern strings
   * @return list of (startPosition, patternIndex)
   */
  def dnaPatternMatch(dna: String, patterns: List[String]): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Streaming search - process text character by character
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a streaming Aho-Corasick matcher.
   *       Build the automaton from patterns, then process a stream of
   *       characters one at a time. Return all matches found after
   *       processing the entire stream.
   *       Simulate streaming by processing an iterator of characters.
   *
   * @param stream   iterator of characters (simulating a stream)
   * @param patterns list of pattern strings
   * @return list of (endPosition, patternIndex)
   */
  def streamingSearch(stream: Iterator[Char], patterns: List[String]): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val patterns = List("he", "she", "his", "hers")

    // Exercise 1
    val trieSize = buildTrie(patterns)
    assert(trieSize > 1, s"Expected > 1 nodes, got $trieSize")
    println("Exercise 1 (Build trie) passed.")

    // Exercise 2
    val failLinks = buildFailureLinks(patterns)
    assert(failLinks.nonEmpty, "Expected non-empty failure links")
    assert(failLinks.getOrElse(0, -1) == 0, "Root failure link should point to root")
    println("Exercise 2 (Failure links) passed.")

    // Exercise 3
    val outLinks = buildOutputLinks(patterns)
    assert(outLinks.nonEmpty, "Expected non-empty output links")
    println("Exercise 3 (Output links) passed.")

    // Exercise 4
    val text = "ahishers"
    val matches = searchText(text, patterns)
    assert(matches.nonEmpty, "Expected matches in 'ahishers'")
    // "his" at 1, "he" at 4, "she" at 3, "hers" at 4
    println(s"Exercise 4 (Search text) passed. Found ${matches.size} matches.")

    // Exercise 5
    val found = multiPatternMatch(text, patterns)
    assert(found == Set(0, 1, 2, 3), s"Expected all patterns found, got $found")
    println("Exercise 5 (Multi-pattern match) passed.")

    // Exercise 6
    val counts = countOccurrences("hehehehe", List("he", "hehe"))
    assert(counts(0) == 4, s"Expected 4 occurrences of 'he', got ${counts(0)}")
    assert(counts(1) == 3, s"Expected 3 occurrences of 'hehe', got ${counts(1)}")
    println("Exercise 6 (Count occurrences) passed.")

    // Exercise 7
    val dna = "ACGTACGTACG"
    val dnaPatterns = List("ACG", "CGT", "TACG")
    val dnaMatches = dnaPatternMatch(dna, dnaPatterns)
    assert(dnaMatches.nonEmpty, "Expected DNA matches")
    println(s"Exercise 7 (DNA pattern matching) passed. Found ${dnaMatches.size} matches.")

    // Exercise 8
    val streamMatches = streamingSearch("ahishers".iterator, patterns)
    assert(streamMatches.nonEmpty, "Expected streaming matches")
    println(s"Exercise 8 (Streaming search) passed. Found ${streamMatches.size} matches.")

    println("All Algo110_AhoCorasick exercises passed!")
  }
}
