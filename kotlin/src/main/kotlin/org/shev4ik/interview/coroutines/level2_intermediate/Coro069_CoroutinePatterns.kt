package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Coroutine design patterns
 */
object Coro069_CoroutinePatterns {

    // Exercise 1: retryWithBackoff
    // TODO: Implement a coroutine exercise demonstrating retryWithBackoff.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_retryWithBackoff(): String = TODO()

    // Exercise 2: exponentialBackoff
    // TODO: Implement a coroutine exercise demonstrating exponentialBackoff.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_exponentialBackoff(): String = TODO()

    // Exercise 3: circuitBreaker
    // TODO: Implement a coroutine exercise demonstrating circuitBreaker.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_circuitBreaker(): String = TODO()

    // Exercise 4: bulkhead
    // TODO: Implement a coroutine exercise demonstrating bulkhead.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_bulkhead(): String = TODO()

    // Exercise 5: rateLimit
    // TODO: Implement a coroutine exercise demonstrating rateLimit.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_rateLimit(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_retryWithBackoff().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_exponentialBackoff().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_circuitBreaker().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_bulkhead().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_rateLimit().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro069_CoroutinePatterns exercises passed!")
    }
}
