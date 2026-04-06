package org.shev4ik.interview.algorithms.level3_advanced

/**
 * B-tree concepts
 */
object Algo083_BTree {

    // Exercise 1: structure
    // TODO: Implement structure.
    // TODO: Topic: B-tree concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_structure(): Int = TODO()

    // Exercise 2: insert
    // TODO: Insert "apple" into Trie, then search for it. Return true.
    fun exercise2_insert(): Boolean = TODO()

    // Exercise 3: search
    // TODO: Insert "apple" into Trie, search for "app". Return false (prefix only).
    fun exercise3_search(): Boolean = TODO()

    // Exercise 4: delete
    // TODO: Implement delete.
    // TODO: Topic: B-tree concepts.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_delete(): Int = TODO()

    // Exercise 5: splitMerge
    // TODO: Implement splitMerge.
    // TODO: Topic: B-tree concepts.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_splitMerge(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_structure()
        assert(exercise2_insert() == true) { "Exercise 2 failed" }
        assert(exercise3_search() == false) { "Exercise 3 failed" }
        exercise4_delete()
        assert(exercise5_splitMerge().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo083_BTree exercises passed!")
    }
}
