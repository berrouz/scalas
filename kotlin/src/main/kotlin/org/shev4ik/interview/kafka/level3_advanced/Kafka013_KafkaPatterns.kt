package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka patterns
 */
object Kafka013_KafkaPatterns {

    // Exercise 1: saga
    // TODO: Demonstrate saga concept for kafka.
    // TODO: Topic: Kafka patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_saga(): String = TODO()

    // Exercise 2: outbox
    // TODO: Demonstrate outbox concept for kafka.
    // TODO: Topic: Kafka patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_outbox(): String = TODO()

    // Exercise 3: eventSourcing
    // TODO: Demonstrate eventSourcing concept for kafka.
    // TODO: Topic: Kafka patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_eventSourcing(): String = TODO()

    // Exercise 4: cqrs
    // TODO: Demonstrate cqrs concept for kafka.
    // TODO: Topic: Kafka patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_cqrs(): String = TODO()

    // Exercise 5: changeDC
    // TODO: Demonstrate changeDC concept for kafka.
    // TODO: Topic: Kafka patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_changeDC(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_saga().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_outbox().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_eventSourcing().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cqrs().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_changeDC().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka013_KafkaPatterns exercises passed!")
    }
}
