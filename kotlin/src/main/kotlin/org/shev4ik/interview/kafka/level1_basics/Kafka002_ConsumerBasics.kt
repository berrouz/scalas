package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka consumer
 */
object Kafka002_ConsumerBasics {

    // Exercise 1: create
    // TODO: Demonstrate create concept for kafka.
    // TODO: Topic: Kafka consumer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: subscribe
    // TODO: Demonstrate subscribe concept for kafka.
    // TODO: Topic: Kafka consumer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_subscribe(): String = TODO()

    // Exercise 3: poll
    // TODO: Demonstrate poll concept for kafka.
    // TODO: Topic: Kafka consumer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_poll(): String = TODO()

    // Exercise 4: commitSync
    // TODO: Demonstrate commitSync concept for kafka.
    // TODO: Topic: Kafka consumer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_commitSync(): String = TODO()

    // Exercise 5: commitAsync
    // TODO: Demonstrate commitAsync concept for kafka.
    // TODO: Topic: Kafka consumer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_commitAsync(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_subscribe().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_poll().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_commitSync().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_commitAsync().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka002_ConsumerBasics exercises passed!")
    }
}
