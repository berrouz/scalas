package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Exactly-once semantics
 */
object Kafka006_ExactlyOnce {

    // Exercise 1: idempotent
    // TODO: Demonstrate idempotent concept for kafka.
    // TODO: Topic: Exactly-once semantics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_idempotent(): String = TODO()

    // Exercise 2: transactional
    // TODO: Demonstrate transactional concept for kafka.
    // TODO: Topic: Exactly-once semantics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_transactional(): String = TODO()

    // Exercise 3: eos
    // TODO: Demonstrate eos concept for kafka.
    // TODO: Topic: Exactly-once semantics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_eos(): String = TODO()

    // Exercise 4: initTransactions
    // TODO: Demonstrate initTransactions concept for kafka.
    // TODO: Topic: Exactly-once semantics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_initTransactions(): String = TODO()

    // Exercise 5: commitTransaction
    // TODO: Demonstrate commitTransaction concept for kafka.
    // TODO: Topic: Exactly-once semantics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_commitTransaction(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_idempotent().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_transactional().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_eos().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_initTransactions().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_commitTransaction().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka006_ExactlyOnce exercises passed!")
    }
}
