package org.shev4ik.interview.exposed.level1_basics

/**
 * Insert operations
 */
object Exp002_InsertOps {

    // Exercise 1: insert
    // TODO: Insert "apple" into Trie, then search for it. Return true.
    fun exercise1_insert(): Boolean = TODO()

    // Exercise 2: insertAndGetId
    // TODO: Demonstrate insertAndGetId concept for exposed.
    // TODO: Topic: Insert operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_insertAndGetId(): String = TODO()

    // Exercise 3: batchInsert
    // TODO: Demonstrate batchInsert concept for exposed.
    // TODO: Topic: Insert operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_batchInsert(): String = TODO()

    // Exercise 4: insertIgnore
    // TODO: Demonstrate insertIgnore concept for exposed.
    // TODO: Topic: Insert operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_insertIgnore(): String = TODO()

    // Exercise 5: insertSelect
    // TODO: Demonstrate insertSelect concept for exposed.
    // TODO: Topic: Insert operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_insertSelect(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_insert() == true) { "Exercise 1 failed" }
        assert(exercise2_insertAndGetId().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_batchInsert().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_insertIgnore().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_insertSelect().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp002_InsertOps exercises passed!")
    }
}
