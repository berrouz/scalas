package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Mutex
 */
object Coro056_MutexBasics {

    // Exercise 1: createMutex
    // TODO: Implement a coroutine exercise demonstrating createMutex.
    // TODO: Use runBlocking to make it testable. Topic: Mutex.
    // TODO: Return a verifiable result of type String.
    fun exercise1_createMutex(): String = TODO()

    // Exercise 2: withLock
    // TODO: Implement a coroutine exercise demonstrating withLock.
    // TODO: Use runBlocking to make it testable. Topic: Mutex.
    // TODO: Return a verifiable result of type String.
    fun exercise2_withLock(): String = TODO()

    // Exercise 3: criticalSection
    // TODO: Implement a coroutine exercise demonstrating criticalSection.
    // TODO: Use runBlocking to make it testable. Topic: Mutex.
    // TODO: Return a verifiable result of type String.
    fun exercise3_criticalSection(): String = TODO()

    // Exercise 4: mutexVsSync
    // TODO: Implement a coroutine exercise demonstrating mutexVsSync.
    // TODO: Use runBlocking to make it testable. Topic: Mutex.
    // TODO: Return a verifiable result of type String.
    fun exercise4_mutexVsSync(): String = TODO()

    // Exercise 5: fairness
    // TODO: Implement a coroutine exercise demonstrating fairness.
    // TODO: Use runBlocking to make it testable. Topic: Mutex.
    // TODO: Return a verifiable result of type String.
    fun exercise5_fairness(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createMutex().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_withLock().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_criticalSection().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_mutexVsSync().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fairness().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro056_MutexBasics exercises passed!")
    }
}
