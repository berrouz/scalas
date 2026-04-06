package org.shev4ik.interview.exposed.level1_basics

/**
 * Transactions
 */
object Exp005_Transactions {

    // Exercise 1: transaction
    // TODO: Demonstrate transaction concept for exposed.
    // TODO: Topic: Transactions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_transaction(): String = TODO()

    // Exercise 2: commit
    // TODO: Demonstrate commit concept for exposed.
    // TODO: Topic: Transactions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_commit(): String = TODO()

    // Exercise 3: rollback
    // TODO: Demonstrate rollback concept for exposed.
    // TODO: Topic: Transactions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_rollback(): String = TODO()

    // Exercise 4: nested
    // TODO: Demonstrate nested concept for exposed.
    // TODO: Topic: Transactions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_nested(): String = TODO()

    // Exercise 5: isolation
    // TODO: Demonstrate isolation concept for exposed.
    // TODO: Topic: Transactions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_isolation(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_transaction().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_commit().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rollback().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_nested().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_isolation() == true) { "Exercise 5 failed" }
        println("All Exp005_Transactions exercises passed!")
    }
}
