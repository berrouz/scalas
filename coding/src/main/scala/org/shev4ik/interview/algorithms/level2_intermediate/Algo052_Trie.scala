package org.shev4ik.interview.algorithms.level2_intermediate

object Algo052_Trie {

  // Trie node: children map and end-of-word flag
  class TrieNode(
    var children: Map[Char, TrieNode] = Map.empty,
    var isEnd: Boolean = false,
    var count: Int = 0,       // words ending here
    var prefixCount: Int = 0  // words with this prefix
  )

  // Exercise 1: Insert a word into the trie
  // TODO: For each char, create child node if absent, move to child. Mark last node as end.
  def insert(root: TrieNode, word: String): Unit = ???

  // Exercise 2: Search for an exact word in the trie
  // TODO: Traverse char by char. If any char missing, false. At end, check isEnd.
  def search(root: TrieNode, word: String): Boolean = ???

  // Exercise 3: Check if any word starts with the given prefix
  // TODO: Traverse char by char. If all chars found, true (don't need isEnd).
  def startsWith(root: TrieNode, prefix: String): Boolean = ???

  // Exercise 4: Count words equal to a given word
  // TODO: Navigate to the end node. Return its count.
  def countWordsEqualTo(root: TrieNode, word: String): Int = ???

  // Exercise 5: Count words starting with a given prefix
  // TODO: Navigate to prefix end node. Return its prefixCount.
  def countWordsStartingWith(root: TrieNode, prefix: String): Int = ???

  // Exercise 6: Delete a word from the trie
  // TODO: Navigate to end, decrement count. Decrement prefixCount along the path.
  def delete(root: TrieNode, word: String): Unit = ???

  // Exercise 7: Autocomplete — return all words with given prefix
  // TODO: Navigate to prefix node. DFS to collect all words from there.
  def autocomplete(root: TrieNode, prefix: String): List[String] = ???

  // Exercise 8: Longest common prefix of all words in the trie
  // TODO: From root, follow the single-child path while prefixCount equals total word count.
  def longestCommonPrefix(root: TrieNode, totalWords: Int): String = ???

  def main(args: Array[String]): Unit = {
    val root = new TrieNode()
    val words = List("apple", "app", "application", "apply", "banana", "band")
    words.foreach(insert(root, _))

    // Exercise 1 & 2
    assert(search(root, "apple"), "Found 'apple'")
    assert(search(root, "app"), "Found 'app'")
    assert(!search(root, "ap"), "'ap' is not a word")

    // Exercise 3
    assert(startsWith(root, "app"), "Prefix 'app' exists")
    assert(!startsWith(root, "xyz"), "Prefix 'xyz' does not exist")

    // Exercise 4
    insert(root, "apple") // insert again
    assert(countWordsEqualTo(root, "apple") == 2, "Two 'apple' entries")

    // Exercise 5
    assert(countWordsStartingWith(root, "app") >= 4, "At least 4 words start with 'app'")

    // Exercise 6
    delete(root, "apple") // delete one instance
    assert(countWordsEqualTo(root, "apple") == 1, "One 'apple' after delete")

    // Exercise 7
    val suggestions = autocomplete(root, "app")
    assert(suggestions.contains("apple"), "Autocomplete includes 'apple'")
    assert(suggestions.contains("application"), "Autocomplete includes 'application'")

    // Exercise 8
    val root2 = new TrieNode()
    List("flower", "flow", "flight").foreach(insert(root2, _))
    assert(longestCommonPrefix(root2, 3) == "fl", "Longest common prefix is 'fl'")

    println("All Algo052_Trie exercises passed!")
  }
}
