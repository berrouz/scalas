package org.shev4ik.interview.ktor.level2_intermediate

/**
 * CORS configuration
 */
object Ktor010_CORS {

    // Exercise 1: configure
    // TODO: Demonstrate configure concept for ktor.
    // TODO: Topic: CORS configuration.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_configure(): String = TODO()

    // Exercise 2: allowedOrigins
    // TODO: Demonstrate allowedOrigins concept for ktor.
    // TODO: Topic: CORS configuration.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_allowedOrigins(): List<Int> = TODO()

    // Exercise 3: methods
    // TODO: Demonstrate methods concept for ktor.
    // TODO: Topic: CORS configuration.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_methods(): String = TODO()

    // Exercise 4: headers
    // TODO: Demonstrate headers concept for ktor.
    // TODO: Topic: CORS configuration.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_headers(): String = TODO()

    // Exercise 5: credentials
    // TODO: Demonstrate credentials concept for ktor.
    // TODO: Topic: CORS configuration.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_credentials(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_configure().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_allowedOrigins().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_methods().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_headers().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_credentials().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor010_CORS exercises passed!")
    }
}
