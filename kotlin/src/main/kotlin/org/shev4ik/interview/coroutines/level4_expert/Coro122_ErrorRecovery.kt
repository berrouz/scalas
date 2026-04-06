package org.shev4ik.interview.coroutines.level4_expert

/**
 * Advanced error recovery
 */
object Coro122_ErrorRecovery {

    // Exercise 1: sagaPattern
    // TODO: Implement a coroutine exercise demonstrating sagaPattern.
    // TODO: Use runBlocking to make it testable. Topic: Advanced error recovery.
    // TODO: Return a verifiable result of type String.
    fun exercise1_sagaPattern(): String = TODO()

    // Exercise 2: compensating
    // TODO: Implement a coroutine exercise demonstrating compensating.
    // TODO: Use runBlocking to make it testable. Topic: Advanced error recovery.
    // TODO: Return a verifiable result of type String.
    fun exercise2_compensating(): String = TODO()

    // Exercise 3: retryStrategies
    // TODO: Implement a coroutine exercise demonstrating retryStrategies.
    // TODO: Use runBlocking to make it testable. Topic: Advanced error recovery.
    // TODO: Return a verifiable result of type String.
    fun exercise3_retryStrategies(): String = TODO()

    // Exercise 4: fallback
    // TODO: Implement a coroutine exercise demonstrating fallback.
    // TODO: Use runBlocking to make it testable. Topic: Advanced error recovery.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_fallback(): List<Int> = TODO()

    // Exercise 5: circuitBreaker
    // TODO: Implement a coroutine exercise demonstrating circuitBreaker.
    // TODO: Use runBlocking to make it testable. Topic: Advanced error recovery.
    // TODO: Return a verifiable result of type String.
    fun exercise5_circuitBreaker(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sagaPattern().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_compensating().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_retryStrategies().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fallback().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_circuitBreaker().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro122_ErrorRecovery exercises passed!")
    }
}
