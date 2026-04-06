package org.shev4ik.interview.kafka.level1_basics

/**
 * Topics and partitions
 */
object Kafka003_TopicsPartitions {

    // Exercise 1: topic
    // TODO: Demonstrate topic concept for kafka.
    // TODO: Topic: Topics and partitions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_topic(): String = TODO()

    // Exercise 2: partition
    // TODO: Demonstrate partition concept for kafka.
    // TODO: Topic: Topics and partitions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_partition(): Pair<Int, Int> = TODO()

    // Exercise 3: offset
    // TODO: Demonstrate offset concept for kafka.
    // TODO: Topic: Topics and partitions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_offset(): String = TODO()

    // Exercise 4: replication
    // TODO: Demonstrate replication concept for kafka.
    // TODO: Topic: Topics and partitions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_replication(): String = TODO()

    // Exercise 5: keyPartitioning
    // TODO: Demonstrate keyPartitioning concept for kafka.
    // TODO: Topic: Topics and partitions.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_keyPartitioning(): Pair<Int, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_topic().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_partition()
        assert(exercise3_offset().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_replication().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_keyPartitioning()
        println("All Kafka003_TopicsPartitions exercises passed!")
    }
}
