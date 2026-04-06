package org.shev4ik.interview.grpc.level1_basics

/**
 * Client streaming
 */
object Grpc004_ClientStreaming {

    // Exercise 1: requestStream
    // TODO: Demonstrate requestStream concept for grpc.
    // TODO: Topic: Client streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_requestStream(): String = TODO()

    // Exercise 2: streamObserver
    // TODO: Demonstrate streamObserver concept for grpc.
    // TODO: Topic: Client streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_streamObserver(): String = TODO()

    // Exercise 3: onNext
    // TODO: Demonstrate onNext concept for grpc.
    // TODO: Topic: Client streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_onNext(): String = TODO()

    // Exercise 4: onCompleted
    // TODO: Demonstrate onCompleted concept for grpc.
    // TODO: Topic: Client streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_onCompleted(): String = TODO()

    // Exercise 5: halfClose
    // TODO: Demonstrate halfClose concept for grpc.
    // TODO: Topic: Client streaming.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_halfClose(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_requestStream().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_streamObserver().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_onNext().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_onCompleted().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_halfClose().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc004_ClientStreaming exercises passed!")
    }
}
