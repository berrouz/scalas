package org.shev4ik.interview.grpc.level1_basics

/**
 * Server streaming
 */
object Grpc003_ServerStreaming {

    // Exercise 1: responseStream
    // TODO: Demonstrate responseStream concept for grpc.
    // TODO: Topic: Server streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_responseStream(): String = TODO()

    // Exercise 2: onNext
    // TODO: Demonstrate onNext concept for grpc.
    // TODO: Topic: Server streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_onNext(): String = TODO()

    // Exercise 3: onCompleted
    // TODO: Demonstrate onCompleted concept for grpc.
    // TODO: Topic: Server streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_onCompleted(): String = TODO()

    // Exercise 4: onError
    // TODO: Demonstrate onError concept for grpc.
    // TODO: Topic: Server streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_onError(): String = TODO()

    // Exercise 5: backpressure
    // TODO: Demonstrate backpressure concept for grpc.
    // TODO: Topic: Server streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_backpressure(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_responseStream().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_onNext().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_onCompleted().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_onError().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_backpressure().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc003_ServerStreaming exercises passed!")
    }
}
