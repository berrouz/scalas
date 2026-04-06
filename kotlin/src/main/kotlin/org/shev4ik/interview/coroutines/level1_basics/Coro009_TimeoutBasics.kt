package org.shev4ik.interview.coroutines.level1_basics

/**
 * Timeout operations
 */
object Coro009_TimeoutBasics {

    // Exercise 1: withTimeout
    // TODO: Implement a coroutine exercise demonstrating withTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Timeout operations.
    // TODO: Return a verifiable result of type String.
    fun exercise1_withTimeout(): String = TODO()

    // Exercise 2: withTimeoutOrNull
    // TODO: Implement a coroutine exercise demonstrating withTimeoutOrNull.
    // TODO: Use runBlocking to make it testable. Topic: Timeout operations.
    // TODO: Return a verifiable result of type String.
    fun exercise2_withTimeoutOrNull(): String = TODO()

    // Exercise 3: timeoutException
    // TODO: Implement a coroutine exercise demonstrating timeoutException.
    // TODO: Use runBlocking to make it testable. Topic: Timeout operations.
    // TODO: Return a verifiable result of type String.
    fun exercise3_timeoutException(): String = TODO()

    // Exercise 4: nestedTimeout
    // TODO: Implement a coroutine exercise demonstrating nestedTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Timeout operations.
    // TODO: Return a verifiable result of type String.
    fun exercise4_nestedTimeout(): String = TODO()

    // Exercise 5: resourceTimeout
    // TODO: Implement a coroutine exercise demonstrating resourceTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Timeout operations.
    // TODO: Return a verifiable result of type String.
    fun exercise5_resourceTimeout(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_withTimeout().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_withTimeoutOrNull().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_timeoutException().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_nestedTimeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_resourceTimeout().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro009_TimeoutBasics exercises passed!")
    }
}
