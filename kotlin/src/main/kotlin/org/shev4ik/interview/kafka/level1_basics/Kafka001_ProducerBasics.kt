package org.shev4ik.interview.kafka.level1_basics

/**
 * Kafka producer
 */
object Kafka001_ProducerBasics {

    // Exercise 1: create
    // TODO: Demonstrate create concept for kafka.
    // TODO: Topic: Kafka producer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: send
    // TODO: Demonstrate send concept for kafka.
    // TODO: Topic: Kafka producer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_send(): String = TODO()

    // Exercise 3: record
    // TODO: Demonstrate record concept for kafka.
    // TODO: Topic: Kafka producer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_record(): String = TODO()

    // Exercise 4: callback
    // TODO: Demonstrate callback concept for kafka.
    // TODO: Topic: Kafka producer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_callback(): List<Int> = TODO()

    // Exercise 5: flush
    // TODO: Demonstrate flush concept for kafka.
    // TODO: Topic: Kafka producer.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_flush(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_send().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_record().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_callback().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_flush().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka001_ProducerBasics exercises passed!")
    }
}
