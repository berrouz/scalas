package org.shev4ik.interview.algorithms.level2_intermediate

object Algo053_TrieApps {

  class TrieNode(
    var children: Map[Char, TrieNode] = Map.empty,
    var isEnd: Boolean = false,
    var word: String = ""
  )

  // Exercise 1: Word Search II — find all words from dictionary that exist in a 2D board
  // TODO: Build trie from words. For each cell, DFS with trie. Collect words found.
  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = ???

  // Exercise 2: Add and Search Word — '.' matches any single character
  // TODO: Regular search but on '.', recurse into all children.
  def addAndSearch(dictionary: List[String], queries: List[String]): List[Boolean] = ???

  // Exercise 3: Replace Words — replace words in sentence with their shortest root from dictionary
  // TODO: Build trie from roots. For each word in sentence, find shortest prefix in trie.
  def replaceWords(dictionary: List[String], sentence: String): String = ???

  // Exercise 4: Longest Word in Dictionary — longest word that can be built one char at a time
  // TODO: Sort words. Build trie, only insert if prefix (word minus last char) exists. Track longest.
  def longestWord(words: Array[String]): String = ???

  // Exercise 5: Map Sum Pairs — insert key with value, sum values of all keys with given prefix
  // TODO: Trie where each node stores sum of values passing through it.
  class MapSum {
    def insert(key: String, value: Int): Unit = ???
    def sum(prefix: String): Int = ???
  }

  // Exercise 6: Palindrome Pairs concept — find pairs (i,j) where words(i)+words(j) is palindrome
  // TODO: Build trie of reversed words. For each word, check if complement exists in trie.
  def palindromePairs(words: Array[String]): List[(Int, Int)] = ???

  // Exercise 7: Stream of Characters — check if suffix of streamed chars matches any word
  // TODO: Build trie of reversed words. On each new char, check from end of stream in trie.
  class StreamChecker(words: Array[String]) {
    def query(letter: Char): Boolean = ???
  }

  // Exercise 8: Search Suggestions System — for each prefix of searchWord, return top 3 lexicographic matches
  // TODO: Build trie. For each prefix, DFS to find up to 3 words lexicographically.
  def suggestedProducts(products: Array[String], searchWord: String): List[List[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val board = Array(
      Array('o', 'a', 'a', 'n'),
      Array('e', 't', 'a', 'e'),
      Array('i', 'h', 'k', 'r'),
      Array('i', 'f', 'l', 'v')
    )
    val found = findWords(board, Array("oath", "pea", "eat", "rain"))
    assert(found.toSet.contains("oath"), "Found 'oath'")
    assert(found.toSet.contains("eat"), "Found 'eat'")

    // Exercise 2
    val results = addAndSearch(List("bad", "dad", "mad"), List("pad", "bad", ".ad", "b.."))
    assert(results == List(false, true, true, true), "Add and search")

    // Exercise 3
    assert(replaceWords(List("cat", "bat", "rat"), "the cattle was rattled by the battery") ==
      "the cat was rat by the bat", "Replace words")

    // Exercise 4
    assert(longestWord(Array("w", "wo", "wor", "worl", "world")) == "world", "Longest buildable word")

    // Exercise 5
    val ms = new MapSum()
    ms.insert("apple", 3)
    assert(ms.sum("ap") == 3, "Sum for 'ap'")
    ms.insert("app", 2)
    assert(ms.sum("ap") == 5, "Sum for 'ap' after adding 'app'")

    // Exercise 6
    val pairs = palindromePairs(Array("abcd", "dcba", "lls", "s", "sssll"))
    assert(pairs.nonEmpty, "Palindrome pairs found")

    // Exercise 7
    val sc = new StreamChecker(Array("cd", "f", "kl"))
    assert(!sc.query('a'), "Stream 'a' — no match")
    assert(!sc.query('b'), "Stream 'ab' — no match")
    assert(!sc.query('c'), "Stream 'abc' — no match")
    assert(sc.query('d'), "Stream 'abcd' — matches 'cd'")

    // Exercise 8
    val suggestions = suggestedProducts(Array("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse")
    assert(suggestions.head.length <= 3, "At most 3 suggestions per prefix")
    assert(suggestions.head.forall(_.startsWith("mo")), "All suggestions start with prefix")

    println("All Algo053_TrieApps exercises passed!")
  }
}
