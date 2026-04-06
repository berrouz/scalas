package org.shev4ik.interview.kafka.level3_advanced

/**
 * Performance tuning
 */
object Kafka012_PerformanceTuning {

    // Exercise 1: batchSize
    // TODO: Demonstrate batchSize concept for kafka.
    // TODO: Topic: Performance tuning.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_batchSize(): Int = TODO()

    // Exercise 2: linger
    // TODO: Demonstrate linger concept for kafka.
    // TODO: Topic: Performance tuning.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_linger(): String = TODO()

    // Exercise 3: compression
    // TODO: Demonstrate compression concept for kafka.
    // TODO: Topic: Performance tuning.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_compression(): String = TODO()

    // Exercise 4: fetchSize
    // TODO: Demonstrate fetchSize concept for kafka.
    // TODO: Topic: Performance tuning.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_fetchSize(): Int = TODO()

    // Exercise 5: bufferMemory
    // TODO: Demonstrate bufferMemory concept for kafka.
    // TODO: Topic: Performance tuning.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_bufferMemory(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_batchSize()
        assert(exercise2_linger().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_compression().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_fetchSize()
        assert(exercise5_bufferMemory().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka012_PerformanceTuning exercises passed!")
    }
}
