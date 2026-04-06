package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Worker pool
 */
object Coro100_WorkerPool {

    // Exercise 1: fixedPool
    // TODO: Implement a coroutine exercise demonstrating fixedPool.
    // TODO: Use runBlocking to make it testable. Topic: Worker pool.
    // TODO: Return a verifiable result of type String.
    fun exercise1_fixedPool(): String = TODO()

    // Exercise 2: dynamicPool
    // TODO: Implement a coroutine exercise demonstrating dynamicPool.
    // TODO: Use runBlocking to make it testable. Topic: Worker pool.
    // TODO: Return a verifiable result of type String.
    fun exercise2_dynamicPool(): String = TODO()

    // Exercise 3: priorityPool
    // TODO: Implement a coroutine exercise demonstrating priorityPool.
    // TODO: Use runBlocking to make it testable. Topic: Worker pool.
    // TODO: Return a verifiable result of type String.
    fun exercise3_priorityPool(): String = TODO()

    // Exercise 4: cancellablePool
    // TODO: Implement a coroutine exercise demonstrating cancellablePool.
    // TODO: Use runBlocking to make it testable. Topic: Worker pool.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cancellablePool(): String = TODO()

    // Exercise 5: monitoredPool
    // TODO: Implement a coroutine exercise demonstrating monitoredPool.
    // TODO: Use runBlocking to make it testable. Topic: Worker pool.
    // TODO: Return a verifiable result of type String.
    fun exercise5_monitoredPool(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_fixedPool().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_dynamicPool().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_priorityPool().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cancellablePool().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_monitoredPool().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro100_WorkerPool exercises passed!")
    }
}
