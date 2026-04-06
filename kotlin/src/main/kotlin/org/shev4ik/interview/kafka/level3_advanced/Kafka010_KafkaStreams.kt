package org.shev4ik.interview.kafka.level3_advanced

/**
 * Kafka Streams
 */
object Kafka010_KafkaStreams {

    // Exercise 1: kstream
    // TODO: Demonstrate kstream concept for kafka.
    // TODO: Topic: Kafka Streams.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_kstream(): String = TODO()

    // Exercise 2: ktable
    // TODO: Demonstrate ktable concept for kafka.
    // TODO: Topic: Kafka Streams.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_ktable(): String = TODO()

    // Exercise 3: join
    // TODO: Demonstrate join concept for kafka.
    // TODO: Topic: Kafka Streams.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_join(): String = TODO()

    // Exercise 4: aggregate
    // TODO: Demonstrate aggregate concept for kafka.
    // TODO: Topic: Kafka Streams.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_aggregate(): String = TODO()

    // Exercise 5: window
    // TODO: Demonstrate window concept for kafka.
    // TODO: Topic: Kafka Streams.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_window(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_kstream().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_ktable().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_join().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_aggregate().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_window().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka010_KafkaStreams exercises passed!")
    }
}
