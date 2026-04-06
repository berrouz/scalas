package org.shev4ik.interview.kafka.level2_intermediate

/**
 * Consumer offsets
 */
object Kafka007_ConsumerOffsets {

    // Exercise 1: manualCommit
    // TODO: Demonstrate manualCommit concept for kafka.
    // TODO: Topic: Consumer offsets.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_manualCommit(): String = TODO()

    // Exercise 2: autoCommit
    // TODO: Demonstrate autoCommit concept for kafka.
    // TODO: Topic: Consumer offsets.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_autoCommit(): String = TODO()

    // Exercise 3: seek
    // TODO: Demonstrate seek concept for kafka.
    // TODO: Topic: Consumer offsets.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_seek(): String = TODO()

    // Exercise 4: seekToBeginning
    // TODO: Demonstrate seekToBeginning concept for kafka.
    // TODO: Topic: Consumer offsets.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_seekToBeginning(): String = TODO()

    // Exercise 5: offsetMetadata
    // TODO: Demonstrate offsetMetadata concept for kafka.
    // TODO: Topic: Consumer offsets.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_offsetMetadata(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_manualCommit().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_autoCommit().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_seek().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_seekToBeginning().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_offsetMetadata().isNotEmpty()) { "Exercise 5 failed" }
        println("All Kafka007_ConsumerOffsets exercises passed!")
    }
}
