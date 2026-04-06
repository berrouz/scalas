package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Custom dispatchers
 */
object Coro073_CustomDispatcher {

    // Exercise 1: singleThread
    // TODO: Implement a coroutine exercise demonstrating singleThread.
    // TODO: Use runBlocking to make it testable. Topic: Custom dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise1_singleThread(): String = TODO()

    // Exercise 2: fixedPool
    // TODO: Implement a coroutine exercise demonstrating fixedPool.
    // TODO: Use runBlocking to make it testable. Topic: Custom dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise2_fixedPool(): String = TODO()

    // Exercise 3: limitedParallelism
    // TODO: Implement a coroutine exercise demonstrating limitedParallelism.
    // TODO: Use runBlocking to make it testable. Topic: Custom dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_limitedParallelism(): Boolean = TODO()

    // Exercise 4: customExecutor
    // TODO: Implement a coroutine exercise demonstrating customExecutor.
    // TODO: Use runBlocking to make it testable. Topic: Custom dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise4_customExecutor(): String = TODO()

    // Exercise 5: threadFactory
    // TODO: Implement a coroutine exercise demonstrating threadFactory.
    // TODO: Use runBlocking to make it testable. Topic: Custom dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise5_threadFactory(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_singleThread().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_fixedPool().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_limitedParallelism() == true) { "Exercise 3 failed" }
        assert(exercise4_customExecutor().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_threadFactory().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro073_CustomDispatcher exercises passed!")
    }
}
