package org.shev4ik.interview.grpc.level2_intermediate

/**
 * Error handling
 */
object Grpc007_ErrorHandling {

    // Exercise 1: status
    // TODO: Demonstrate status concept for grpc.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_status(): String = TODO()

    // Exercise 2: statusException
    // TODO: Demonstrate statusException concept for grpc.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_statusException(): String = TODO()

    // Exercise 3: metadata
    // TODO: Demonstrate metadata concept for grpc.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_metadata(): String = TODO()

    // Exercise 4: retry
    // TODO: Demonstrate retry concept for grpc.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_retry(): String = TODO()

    // Exercise 5: deadline
    // TODO: Demonstrate deadline concept for grpc.
    // TODO: Topic: Error handling.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_deadline(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_status().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_statusException().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_metadata().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_retry().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_deadline().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc007_ErrorHandling exercises passed!")
    }
}
