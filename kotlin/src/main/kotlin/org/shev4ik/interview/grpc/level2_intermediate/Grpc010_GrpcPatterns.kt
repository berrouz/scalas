package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC patterns
 */
object Grpc010_GrpcPatterns {

    // Exercise 1: coroutineStub
    // TODO: Demonstrate coroutineStub concept for grpc.
    // TODO: Topic: gRPC patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_coroutineStub(): String = TODO()

    // Exercise 2: flowIntegration
    // TODO: Demonstrate flowIntegration concept for grpc.
    // TODO: Topic: gRPC patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_flowIntegration(): String = TODO()

    // Exercise 3: healthCheck
    // TODO: Demonstrate healthCheck concept for grpc.
    // TODO: Topic: gRPC patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_healthCheck(): Boolean = TODO()

    // Exercise 4: reflection
    // TODO: Demonstrate reflection concept for grpc.
    // TODO: Topic: gRPC patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_reflection(): String = TODO()

    // Exercise 5: loadBalancing
    // TODO: Demonstrate loadBalancing concept for grpc.
    // TODO: Topic: gRPC patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_loadBalancing(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_coroutineStub().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flowIntegration().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_healthCheck() == true) { "Exercise 3 failed" }
        assert(exercise4_reflection().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_loadBalancing().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc010_GrpcPatterns exercises passed!")
    }
}
