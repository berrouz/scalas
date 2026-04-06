package org.shev4ik.interview.coroutines.level4_expert

/**
 * Advanced mutex patterns
 */
object Coro111_AdvancedMutex {

    // Exercise 1: reentrantMutex
    // TODO: Implement a coroutine exercise demonstrating reentrantMutex.
    // TODO: Use runBlocking to make it testable. Topic: Advanced mutex patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_reentrantMutex(): String = TODO()

    // Exercise 2: tryLock
    // TODO: Implement a coroutine exercise demonstrating tryLock.
    // TODO: Use runBlocking to make it testable. Topic: Advanced mutex patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_tryLock(): String = TODO()

    // Exercise 3: timedLock
    // TODO: Implement a coroutine exercise demonstrating timedLock.
    // TODO: Use runBlocking to make it testable. Topic: Advanced mutex patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_timedLock(): String = TODO()

    // Exercise 4: fairMutex
    // TODO: Implement a coroutine exercise demonstrating fairMutex.
    // TODO: Use runBlocking to make it testable. Topic: Advanced mutex patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_fairMutex(): String = TODO()

    // Exercise 5: readWriteMutex
    // TODO: Implement a coroutine exercise demonstrating readWriteMutex.
    // TODO: Use runBlocking to make it testable. Topic: Advanced mutex patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_readWriteMutex(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reentrantMutex().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_tryLock().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_timedLock().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fairMutex().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_readWriteMutex().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro111_AdvancedMutex exercises passed!")
    }
}
