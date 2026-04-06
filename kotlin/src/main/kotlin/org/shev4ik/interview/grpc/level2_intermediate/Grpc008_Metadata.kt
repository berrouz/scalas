package org.shev4ik.interview.grpc.level2_intermediate

/**
 * Metadata
 */
object Grpc008_Metadata {

    // Exercise 1: headers
    // TODO: Demonstrate headers concept for grpc.
    // TODO: Topic: Metadata.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_headers(): String = TODO()

    // Exercise 2: trailers
    // TODO: Demonstrate trailers concept for grpc.
    // TODO: Topic: Metadata.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_trailers(): String = TODO()

    // Exercise 3: custom
    // TODO: Demonstrate custom concept for grpc.
    // TODO: Topic: Metadata.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_custom(): String = TODO()

    // Exercise 4: propagation
    // TODO: Demonstrate propagation concept for grpc.
    // TODO: Topic: Metadata.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_propagation(): String = TODO()

    // Exercise 5: binary
    // TODO: Demonstrate binary concept for grpc.
    // TODO: Topic: Metadata.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_binary(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_headers().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_trailers().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_custom().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_propagation().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_binary().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc008_Metadata exercises passed!")
    }
}
