package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced cancellation
 */
object Coro079_AdvancedCancellation {

    // Exercise 1: propagation
    // TODO: Implement a coroutine exercise demonstrating propagation.
    // TODO: Use runBlocking to make it testable. Topic: Advanced cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise1_propagation(): String = TODO()

    // Exercise 2: nonCancellableCleanup
    // TODO: Implement a coroutine exercise demonstrating nonCancellableCleanup.
    // TODO: Use runBlocking to make it testable. Topic: Advanced cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise2_nonCancellableCleanup(): String = TODO()

    // Exercise 3: timeout
    // TODO: Implement a coroutine exercise demonstrating timeout.
    // TODO: Use runBlocking to make it testable. Topic: Advanced cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise3_timeout(): String = TODO()

    // Exercise 4: cooperativeCancel
    // TODO: Implement a coroutine exercise demonstrating cooperativeCancel.
    // TODO: Use runBlocking to make it testable. Topic: Advanced cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cooperativeCancel(): String = TODO()

    // Exercise 5: cancelScope
    // TODO: Implement a coroutine exercise demonstrating cancelScope.
    // TODO: Use runBlocking to make it testable. Topic: Advanced cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise5_cancelScope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_propagation().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_nonCancellableCleanup().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_timeout().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cooperativeCancel().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_cancelScope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro079_AdvancedCancellation exercises passed!")
    }
}
