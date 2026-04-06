package org.shev4ik.interview.coroutines.level4_expert

/**
 * Production patterns
 */
object Coro126_ProductionPatterns {

    // Exercise 1: healthCheck
    // TODO: Implement a coroutine exercise demonstrating healthCheck.
    // TODO: Use runBlocking to make it testable. Topic: Production patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_healthCheck(): Boolean = TODO()

    // Exercise 2: gracefulShutdown
    // TODO: Implement a coroutine exercise demonstrating gracefulShutdown.
    // TODO: Use runBlocking to make it testable. Topic: Production patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_gracefulShutdown(): String = TODO()

    // Exercise 3: metricsCollection
    // TODO: Implement a coroutine exercise demonstrating metricsCollection.
    // TODO: Use runBlocking to make it testable. Topic: Production patterns.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_metricsCollection(): List<Int> = TODO()

    // Exercise 4: distributedTracing
    // TODO: Implement a coroutine exercise demonstrating distributedTracing.
    // TODO: Use runBlocking to make it testable. Topic: Production patterns.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_distributedTracing(): Boolean = TODO()

    // Exercise 5: errorReporting
    // TODO: Implement a coroutine exercise demonstrating errorReporting.
    // TODO: Use runBlocking to make it testable. Topic: Production patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_errorReporting(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_healthCheck() == true) { "Exercise 1 failed" }
        assert(exercise2_gracefulShutdown().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_metricsCollection().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_distributedTracing() == true) { "Exercise 4 failed" }
        assert(exercise5_errorReporting().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro126_ProductionPatterns exercises passed!")
    }
}
