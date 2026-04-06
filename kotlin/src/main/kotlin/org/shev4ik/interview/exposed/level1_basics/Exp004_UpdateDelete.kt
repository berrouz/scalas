package org.shev4ik.interview.exposed.level1_basics

/**
 * Update and delete
 */
object Exp004_UpdateDelete {

    // Exercise 1: update
    // TODO: Demonstrate update concept for exposed.
    // TODO: Topic: Update and delete.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_update(): String = TODO()

    // Exercise 2: deleteWhere
    // TODO: Demonstrate deleteWhere concept for exposed.
    // TODO: Topic: Update and delete.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_deleteWhere(): String = TODO()

    // Exercise 3: deleteAll
    // TODO: Demonstrate deleteAll concept for exposed.
    // TODO: Topic: Update and delete.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_deleteAll(): List<Int> = TODO()

    // Exercise 4: updateReturning
    // TODO: Demonstrate updateReturning concept for exposed.
    // TODO: Topic: Update and delete.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_updateReturning(): String = TODO()

    // Exercise 5: conditionalUpdate
    // TODO: Demonstrate conditionalUpdate concept for exposed.
    // TODO: Topic: Update and delete.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_conditionalUpdate(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_update().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_deleteWhere().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_deleteAll().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_updateReturning().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_conditionalUpdate().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp004_UpdateDelete exercises passed!")
    }
}
