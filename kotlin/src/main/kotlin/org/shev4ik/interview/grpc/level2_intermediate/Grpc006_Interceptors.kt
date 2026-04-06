package org.shev4ik.interview.grpc.level2_intermediate

/**
 * Interceptors
 */
object Grpc006_Interceptors {

    // Exercise 1: serverInterceptor
    // TODO: Demonstrate serverInterceptor concept for grpc.
    // TODO: Topic: Interceptors.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_serverInterceptor(): String = TODO()

    // Exercise 2: clientInterceptor
    // TODO: Demonstrate clientInterceptor concept for grpc.
    // TODO: Topic: Interceptors.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_clientInterceptor(): String = TODO()

    // Exercise 3: logging
    // TODO: Demonstrate logging concept for grpc.
    // TODO: Topic: Interceptors.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_logging(): String = TODO()

    // Exercise 4: auth
    // TODO: Demonstrate auth concept for grpc.
    // TODO: Topic: Interceptors.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_auth(): String = TODO()

    // Exercise 5: metrics
    // TODO: Demonstrate metrics concept for grpc.
    // TODO: Topic: Interceptors.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_metrics(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_serverInterceptor().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_clientInterceptor().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_logging().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_auth().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_metrics().isNotEmpty()) { "Exercise 5 failed" }
        println("All Grpc006_Interceptors exercises passed!")
    }
}
