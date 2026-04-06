package org.shev4ik.interview.grpc.level2_intermediate

/**
 * Deadlines
 */
object Grpc009_Deadlines {

    // Exercise 1: deadline
    // TODO: Demonstrate deadline concept for grpc.
    // TODO: Topic: Deadlines.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_deadline(): String = TODO()

    // Exercise 2: timeout
    // TODO: Demonstrate timeout concept for grpc.
    // TODO: Topic: Deadlines.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_timeout(): String = TODO()

    // Exercise 3: cancellation
    // TODO: Demonstrate cancellation concept for grpc.
    // TODO: Topic: Deadlines.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_cancellation(): String = TODO()

    // Exercise 4: propagation
    // TODO: Demonstrate propagation concept for grpc.
    // TODO: Topic: Deadlines.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_propagation(): String = TODO()

    // Exercise 5: serverSide
    // TODO: Demonstrate serverSide concept for grpc.
    // TODO: Topic: Deadlines.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_serverSide(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_deadline().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_timeout().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_cancellation().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_propagation().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_serverSide().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc009_Deadlines exercises passed!")
    }
}
