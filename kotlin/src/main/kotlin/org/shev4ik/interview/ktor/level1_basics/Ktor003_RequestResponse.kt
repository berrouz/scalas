package org.shev4ik.interview.ktor.level1_basics

/**
 * Request and response
 */
object Ktor003_RequestResponse {

    // Exercise 1: receive
    // TODO: Demonstrate receive concept for ktor.
    // TODO: Topic: Request and response.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_receive(): String = TODO()

    // Exercise 2: respond
    // TODO: Demonstrate respond concept for ktor.
    // TODO: Topic: Request and response.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_respond(): String = TODO()

    // Exercise 3: parameters
    // TODO: Demonstrate parameters concept for ktor.
    // TODO: Topic: Request and response.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_parameters(): String = TODO()

    // Exercise 4: headers
    // TODO: Demonstrate headers concept for ktor.
    // TODO: Topic: Request and response.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_headers(): String = TODO()

    // Exercise 5: statusCode
    // TODO: Demonstrate statusCode concept for ktor.
    // TODO: Topic: Request and response.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_statusCode(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_receive().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_respond().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parameters().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_headers().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_statusCode().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor003_RequestResponse exercises passed!")
    }
}
