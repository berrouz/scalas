package org.shev4ik.interview.grpc.level1_basics

/**
 * Unary RPC
 */
object Grpc002_UnaryRPC {

    // Exercise 1: request
    // TODO: Demonstrate request concept for grpc.
    // TODO: Topic: Unary RPC.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_request(): String = TODO()

    // Exercise 2: response
    // TODO: Demonstrate response concept for grpc.
    // TODO: Topic: Unary RPC.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_response(): String = TODO()

    // Exercise 3: stub
    // TODO: Demonstrate stub concept for grpc.
    // TODO: Topic: Unary RPC.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_stub(): String = TODO()

    // Exercise 4: blocking
    // TODO: Demonstrate blocking concept for grpc.
    // TODO: Topic: Unary RPC.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_blocking(): String = TODO()

    // Exercise 5: async
    // TODO: Demonstrate async concept for grpc.
    // TODO: Topic: Unary RPC.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_async(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_request().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_response().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_stub().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_blocking().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_async().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc002_UnaryRPC exercises passed!")
    }
}
