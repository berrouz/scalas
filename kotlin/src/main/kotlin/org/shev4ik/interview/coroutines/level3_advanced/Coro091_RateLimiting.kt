package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Rate limiting
 */
object Coro091_RateLimiting {

    // Exercise 1: tokenBucket
    // TODO: Implement a coroutine exercise demonstrating tokenBucket.
    // TODO: Use runBlocking to make it testable. Topic: Rate limiting.
    // TODO: Return a verifiable result of type String.
    fun exercise1_tokenBucket(): String = TODO()

    // Exercise 2: slidingWindow
    // TODO: Implement a coroutine exercise demonstrating slidingWindow.
    // TODO: Use runBlocking to make it testable. Topic: Rate limiting.
    // TODO: Return a verifiable result of type String.
    fun exercise2_slidingWindow(): String = TODO()

    // Exercise 3: semaphoreRate
    // TODO: Implement a coroutine exercise demonstrating semaphoreRate.
    // TODO: Use runBlocking to make it testable. Topic: Rate limiting.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise3_semaphoreRate(): Map<String, Int> = TODO()

    // Exercise 4: debouncedRate
    // TODO: Implement a coroutine exercise demonstrating debouncedRate.
    // TODO: Use runBlocking to make it testable. Topic: Rate limiting.
    // TODO: Return a verifiable result of type String.
    fun exercise4_debouncedRate(): String = TODO()

    // Exercise 5: throttledRate
    // TODO: Implement a coroutine exercise demonstrating throttledRate.
    // TODO: Use runBlocking to make it testable. Topic: Rate limiting.
    // TODO: Return a verifiable result of type String.
    fun exercise5_throttledRate(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tokenBucket().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_slidingWindow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_semaphoreRate().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_debouncedRate().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_throttledRate().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro091_RateLimiting exercises passed!")
    }
}
