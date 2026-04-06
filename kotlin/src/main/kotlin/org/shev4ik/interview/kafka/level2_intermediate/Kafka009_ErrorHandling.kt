package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Error handling
 */
object Kafka009_ErrorHandling {

    // Exercise 1: deadLetterQueue
    // TODO: Demonstrate deadLetterQueue concept for kafka.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_deadLetterQueue(): String = TODO()

    // Exercise 2: retryTopic
    // TODO: Demonstrate retryTopic concept for kafka.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_retryTopic(): String = TODO()

    // Exercise 3: errorHandler
    // TODO: Demonstrate errorHandler concept for kafka.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_errorHandler(): String = TODO()

    // Exercise 4: deserialization
    // TODO: Demonstrate deserialization concept for kafka.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_deserialization(): String = TODO()

    // Exercise 5: poisonPill
    // TODO: Demonstrate poisonPill concept for kafka.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_poisonPill(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_deadLetterQueue().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_retryTopic().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_errorHandler().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_deserialization().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_poisonPill() == true) { "Exercise 5 failed" }
        println("All Kafka009_ErrorHandling exercises passed!")
    }
}
