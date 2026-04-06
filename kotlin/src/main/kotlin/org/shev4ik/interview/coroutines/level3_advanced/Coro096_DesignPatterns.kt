package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Coroutine design patterns
 */
object Coro096_DesignPatterns {

    // Exercise 1: retry
    // TODO: Implement a coroutine exercise demonstrating retry.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_retry(): String = TODO()

    // Exercise 2: circuitBreaker
    // TODO: Implement a coroutine exercise demonstrating circuitBreaker.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_circuitBreaker(): String = TODO()

    // Exercise 3: bulkhead
    // TODO: Implement a coroutine exercise demonstrating bulkhead.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_bulkhead(): String = TODO()

    // Exercise 4: timeout
    // TODO: Implement a coroutine exercise demonstrating timeout.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_timeout(): String = TODO()

    // Exercise 5: saga
    // TODO: Implement a coroutine exercise demonstrating saga.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine design patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_saga(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_retry().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_circuitBreaker().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_bulkhead().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_timeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_saga().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro096_DesignPatterns exercises passed!")
    }
}
