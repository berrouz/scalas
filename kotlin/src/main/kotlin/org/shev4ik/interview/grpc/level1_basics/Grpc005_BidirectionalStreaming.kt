package org.shev4ik.interview.grpc.level1_basics

/**
 * Bidirectional streaming
 */
object Grpc005_BidirectionalStreaming {

    // Exercise 1: biStream
    // TODO: Demonstrate biStream concept for grpc.
    // TODO: Topic: Bidirectional streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_biStream(): Boolean = TODO()

    // Exercise 2: fullDuplex
    // TODO: Demonstrate fullDuplex concept for grpc.
    // TODO: Topic: Bidirectional streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_fullDuplex(): String = TODO()

    // Exercise 3: halfDuplex
    // TODO: Demonstrate halfDuplex concept for grpc.
    // TODO: Topic: Bidirectional streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_halfDuplex(): String = TODO()

    // Exercise 4: flowControl
    // TODO: Demonstrate flowControl concept for grpc.
    // TODO: Topic: Bidirectional streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_flowControl(): String = TODO()

    // Exercise 5: ordering
    // TODO: Demonstrate ordering concept for grpc.
    // TODO: Topic: Bidirectional streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_ordering(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_biStream() == true) { "Exercise 1 failed" }
        assert(exercise2_fullDuplex().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_halfDuplex().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flowControl().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_ordering().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc005_BidirectionalStreaming exercises passed!")
    }
}
