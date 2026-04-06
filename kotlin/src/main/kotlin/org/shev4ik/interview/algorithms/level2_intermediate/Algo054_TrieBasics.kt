package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Trie data structure
 */
object Algo054_TrieBasics {

    // Exercise 1: insert
    // TODO: Insert "apple" into Trie, then search for it. Return true.
    fun exercise1_insert(): Boolean = TODO()

    // Exercise 2: search
    // TODO: Insert "apple" into Trie, search for "app". Return false (prefix only).
    fun exercise2_search(): Boolean = TODO()

    // Exercise 3: startsWith
    // TODO: Insert "apple" into Trie, check startsWith "app". Return true.
    fun exercise3_startsWith(): Boolean = TODO()

    // Exercise 4: wordDictionary
    // TODO: Implement wordDictionary.
    // TODO: Topic: Trie data structure.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise4_wordDictionary(): Map<String, Int> = TODO()

    // Exercise 5: replacePrefixes
    // TODO: Implement replacePrefixes.
    // TODO: Topic: Trie data structure.
    // TODO: Return a verifiable result of type String.
    fun exercise5_replacePrefixes(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_insert() == true) { "Exercise 1 failed" }
        assert(exercise2_search() == false) { "Exercise 2 failed" }
        assert(exercise3_startsWith() == true) { "Exercise 3 failed" }
        assert(exercise4_wordDictionary().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_replacePrefixes().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo054_TrieBasics exercises passed!")
    }
}
