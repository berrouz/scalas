package org.shev4ik.interview.coroutines.level1_basics

/**
 * Practical coroutine patterns
 */
object Coro034_PracticalPatterns {

    // Exercise 1: retryPattern
    // TODO: Implement a coroutine exercise demonstrating retryPattern.
    // TODO: Use runBlocking to make it testable. Topic: Practical coroutine patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_retryPattern(): String = TODO()

    // Exercise 2: timeoutPattern
    // TODO: Implement a coroutine exercise demonstrating timeoutPattern.
    // TODO: Use runBlocking to make it testable. Topic: Practical coroutine patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_timeoutPattern(): String = TODO()

    // Exercise 3: parallelPattern
    // TODO: Implement a coroutine exercise demonstrating parallelPattern.
    // TODO: Use runBlocking to make it testable. Topic: Practical coroutine patterns.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_parallelPattern(): List<Int> = TODO()

    // Exercise 4: sequentialPattern
    // TODO: Implement a coroutine exercise demonstrating sequentialPattern.
    // TODO: Use runBlocking to make it testable. Topic: Practical coroutine patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_sequentialPattern(): String = TODO()

    // Exercise 5: resourcePattern
    // TODO: Implement a coroutine exercise demonstrating resourcePattern.
    // TODO: Use runBlocking to make it testable. Topic: Practical coroutine patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_resourcePattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_retryPattern().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_timeoutPattern().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parallelPattern().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_sequentialPattern().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_resourcePattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro034_PracticalPatterns exercises passed!")
    }
}
