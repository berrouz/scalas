package org.shev4ik.interview.sql.level3_advanced

/**
 * Concurrency control
 */
object Sql012_ConcurrencyControl {

    // Exercise 1: mvcc
    // TODO: Model the mvcc concept.
    // TODO: Topic: Concurrency control.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_mvcc(): String = TODO()

    // Exercise 2: locking
    // TODO: Model the locking concept.
    // TODO: Topic: Concurrency control.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_locking(): String = TODO()

    // Exercise 3: deadlock
    // TODO: Model the deadlock concept.
    // TODO: Topic: Concurrency control.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_deadlock(): String = TODO()

    // Exercise 4: optimistic
    // TODO: Model the optimistic concept.
    // TODO: Topic: Concurrency control.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_optimistic(): Boolean = TODO()

    // Exercise 5: pessimistic
    // TODO: Model the pessimistic concept.
    // TODO: Topic: Concurrency control.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_pessimistic(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mvcc().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_locking().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_deadlock().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_optimistic() == true) { "Exercise 4 failed" }
        assert(exercise5_pessimistic() == true) { "Exercise 5 failed" }
        println("All Sql012_ConcurrencyControl exercises passed!")
    }
}
