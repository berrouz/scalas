package org.shev4ik.interview.coroutines.level4_expert

/**
 * Advanced semaphore
 */
object Coro113_AdvancedSemaphore {

    // Exercise 1: weightedSemaphore
    // TODO: Implement a coroutine exercise demonstrating weightedSemaphore.
    // TODO: Use runBlocking to make it testable. Topic: Advanced semaphore.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_weightedSemaphore(): Int = TODO()

    // Exercise 2: fairSemaphore
    // TODO: Implement a coroutine exercise demonstrating fairSemaphore.
    // TODO: Use runBlocking to make it testable. Topic: Advanced semaphore.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise2_fairSemaphore(): Map<String, Int> = TODO()

    // Exercise 3: boundedResource
    // TODO: Implement a coroutine exercise demonstrating boundedResource.
    // TODO: Use runBlocking to make it testable. Topic: Advanced semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise3_boundedResource(): String = TODO()

    // Exercise 4: poolManager
    // TODO: Implement a coroutine exercise demonstrating poolManager.
    // TODO: Use runBlocking to make it testable. Topic: Advanced semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise4_poolManager(): String = TODO()

    // Exercise 5: quotaManager
    // TODO: Implement a coroutine exercise demonstrating quotaManager.
    // TODO: Use runBlocking to make it testable. Topic: Advanced semaphore.
    // TODO: Return a verifiable result of type String.
    fun exercise5_quotaManager(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_weightedSemaphore()
        assert(exercise2_fairSemaphore().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_boundedResource().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_poolManager().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_quotaManager().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro113_AdvancedSemaphore exercises passed!")
    }
}
