package org.shev4ik.interview.flow.level3_advanced

/**
 * Backpressure strategies
 */
object Flow014_BackpressureStrategies {

    // Exercise 1: bufferStrategy
    // TODO: Implement bufferStrategy for concurrency/streaming.
    // TODO: Topic: Backpressure strategies.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_bufferStrategy(): String = TODO()

    // Exercise 2: dropStrategy
    // TODO: Implement dropStrategy for concurrency/streaming.
    // TODO: Topic: Backpressure strategies.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_dropStrategy(): String = TODO()

    // Exercise 3: conflateStrategy
    // TODO: Implement conflateStrategy for concurrency/streaming.
    // TODO: Topic: Backpressure strategies.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_conflateStrategy(): Boolean = TODO()

    // Exercise 4: latestStrategy
    // TODO: Implement latestStrategy for concurrency/streaming.
    // TODO: Topic: Backpressure strategies.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_latestStrategy(): Boolean = TODO()

    // Exercise 5: suspendStrategy
    // TODO: Implement suspendStrategy for concurrency/streaming.
    // TODO: Topic: Backpressure strategies.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_suspendStrategy(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_bufferStrategy().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_dropStrategy().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_conflateStrategy() == true) { "Exercise 3 failed" }
        assert(exercise4_latestStrategy() == true) { "Exercise 4 failed" }
        assert(exercise5_suspendStrategy().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow014_BackpressureStrategies exercises passed!")
    }
}
