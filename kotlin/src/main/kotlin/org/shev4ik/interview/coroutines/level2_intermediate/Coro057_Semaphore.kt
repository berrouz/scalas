package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Semaphore
 */
object Coro057_Semaphore {

    // Exercise 1: createSemaphore
    // TODO: Implement a coroutine exercise demonstrating createSemaphore.
    // TODO: Use runBlocking to make it testable. Topic: Semaphore.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise1_createSemaphore(): Map<String, Int> = TODO()

    // Exercise 2: withPermit
    // TODO: Implement a coroutine exercise demonstrating withPermit.
    // TODO: Use runBlocking to make it testable. Topic: Semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise2_withPermit(): String = TODO()

    // Exercise 3: rateLimiting
    // TODO: Implement a coroutine exercise demonstrating rateLimiting.
    // TODO: Use runBlocking to make it testable. Topic: Semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise3_rateLimiting(): String = TODO()

    // Exercise 4: concurrencyLimit
    // TODO: Implement a coroutine exercise demonstrating concurrencyLimit.
    // TODO: Use runBlocking to make it testable. Topic: Semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise4_concurrencyLimit(): String = TODO()

    // Exercise 5: semaphorePattern
    // TODO: Implement a coroutine exercise demonstrating semaphorePattern.
    // TODO: Use runBlocking to make it testable. Topic: Semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise5_semaphorePattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createSemaphore().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_withPermit().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rateLimiting().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_concurrencyLimit().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_semaphorePattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro057_Semaphore exercises passed!")
    }
}
