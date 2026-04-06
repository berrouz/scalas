package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Coroutine synchronization
 */
object Coro060_CoroutineSync {

    // Exercise 1: threadSafe
    // TODO: Implement a coroutine exercise demonstrating threadSafe.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine synchronization.
    // TODO: Return a verifiable result of type String.
    fun exercise1_threadSafe(): String = TODO()

    // Exercise 2: confinement
    // TODO: Implement a coroutine exercise demonstrating confinement.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine synchronization.
    // TODO: Return a verifiable result of type String.
    fun exercise2_confinement(): String = TODO()

    // Exercise 3: mutexProtection
    // TODO: Implement a coroutine exercise demonstrating mutexProtection.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine synchronization.
    // TODO: Return a verifiable result of type String.
    fun exercise3_mutexProtection(): String = TODO()

    // Exercise 4: atomicCounter
    // TODO: Implement a coroutine exercise demonstrating atomicCounter.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine synchronization.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_atomicCounter(): Int = TODO()

    // Exercise 5: singleWriter
    // TODO: Implement a coroutine exercise demonstrating singleWriter.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine synchronization.
    // TODO: Return a verifiable result of type String.
    fun exercise5_singleWriter(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_threadSafe().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_confinement().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_mutexProtection().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_atomicCounter()
        assert(exercise5_singleWriter().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro060_CoroutineSync exercises passed!")
    }
}
