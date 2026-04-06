package org.shev4ik.interview.ktor.level3_advanced

/**
 * Production patterns
 */
object Ktor015_KtorPatterns {

    // Exercise 1: middleware
    // TODO: Demonstrate middleware concept for ktor.
    // TODO: Topic: Production patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_middleware(): String = TODO()

    // Exercise 2: authentication
    // TODO: Demonstrate authentication concept for ktor.
    // TODO: Topic: Production patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_authentication(): String = TODO()

    // Exercise 3: errorHandling
    // TODO: Demonstrate errorHandling concept for ktor.
    // TODO: Topic: Production patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_errorHandling(): String = TODO()

    // Exercise 4: logging
    // TODO: Demonstrate logging concept for ktor.
    // TODO: Topic: Production patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_logging(): String = TODO()

    // Exercise 5: metrics
    // TODO: Demonstrate metrics concept for ktor.
    // TODO: Topic: Production patterns.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_metrics(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_middleware().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_authentication().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_errorHandling().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_logging().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_metrics().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ktor015_KtorPatterns exercises passed!")
    }
}
