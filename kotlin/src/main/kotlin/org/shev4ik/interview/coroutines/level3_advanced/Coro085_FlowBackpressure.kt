package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Flow backpressure
 */
object Coro085_FlowBackpressure {

    // Exercise 1: bufferStrategy
    // TODO: Implement a coroutine exercise demonstrating bufferStrategy.
    // TODO: Use runBlocking to make it testable. Topic: Flow backpressure.
    // TODO: Return a verifiable result of type String.
    fun exercise1_bufferStrategy(): String = TODO()

    // Exercise 2: overflowStrategy
    // TODO: Implement a coroutine exercise demonstrating overflowStrategy.
    // TODO: Use runBlocking to make it testable. Topic: Flow backpressure.
    // TODO: Return a verifiable result of type String.
    fun exercise2_overflowStrategy(): String = TODO()

    // Exercise 3: conflation
    // TODO: Implement a coroutine exercise demonstrating conflation.
    // TODO: Use runBlocking to make it testable. Topic: Flow backpressure.
    // TODO: Return a verifiable result of type String.
    fun exercise3_conflation(): String = TODO()

    // Exercise 4: sampling
    // TODO: Implement a coroutine exercise demonstrating sampling.
    // TODO: Use runBlocking to make it testable. Topic: Flow backpressure.
    // TODO: Return a verifiable result of type String.
    fun exercise4_sampling(): String = TODO()

    // Exercise 5: windowing
    // TODO: Implement a coroutine exercise demonstrating windowing.
    // TODO: Use runBlocking to make it testable. Topic: Flow backpressure.
    // TODO: Return a verifiable result of type String.
    fun exercise5_windowing(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_bufferStrategy().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_overflowStrategy().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_conflation().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_sampling().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_windowing().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro085_FlowBackpressure exercises passed!")
    }
}
