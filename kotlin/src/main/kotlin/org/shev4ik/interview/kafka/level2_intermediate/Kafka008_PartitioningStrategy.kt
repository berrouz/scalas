package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Partitioning strategy
 */
object Kafka008_PartitioningStrategy {

    // Exercise 1: defaultPartitioner
    // TODO: Demonstrate defaultPartitioner concept for kafka.
    // TODO: Topic: Partitioning strategy.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_defaultPartitioner(): Pair<Int, Int> = TODO()

    // Exercise 2: customPartitioner
    // TODO: Demonstrate customPartitioner concept for kafka.
    // TODO: Topic: Partitioning strategy.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_customPartitioner(): Pair<Int, Int> = TODO()

    // Exercise 3: keyBased
    // TODO: Demonstrate keyBased concept for kafka.
    // TODO: Topic: Partitioning strategy.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_keyBased(): String = TODO()

    // Exercise 4: roundRobin
    // TODO: Demonstrate roundRobin concept for kafka.
    // TODO: Topic: Partitioning strategy.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_roundRobin(): String = TODO()

    // Exercise 5: stickyPartitioner
    // TODO: Demonstrate stickyPartitioner concept for kafka.
    // TODO: Topic: Partitioning strategy.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_stickyPartitioner(): Pair<Int, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_defaultPartitioner()
        exercise2_customPartitioner()
        assert(exercise3_keyBased().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_roundRobin().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_stickyPartitioner()
        println("All Kafka008_PartitioningStrategy exercises passed!")
    }
}
