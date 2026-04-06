package org.shev4ik.interview.coroutines.level1_basics

/**
 * Cooperative cancellation
 */
object Coro008_CancellationCoop {

    // Exercise 1: ensureActive
    // TODO: Implement a coroutine exercise demonstrating ensureActive.
    // TODO: Use runBlocking to make it testable. Topic: Cooperative cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise1_ensureActive(): String = TODO()

    // Exercise 2: yieldCancel
    // TODO: Implement a coroutine exercise demonstrating yieldCancel.
    // TODO: Use runBlocking to make it testable. Topic: Cooperative cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise2_yieldCancel(): String = TODO()

    // Exercise 3: isActiveLoop
    // TODO: Implement a coroutine exercise demonstrating isActiveLoop.
    // TODO: Use runBlocking to make it testable. Topic: Cooperative cancellation.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_isActiveLoop(): Boolean = TODO()

    // Exercise 4: cancellableComputation
    // TODO: Implement a coroutine exercise demonstrating cancellableComputation.
    // TODO: Use runBlocking to make it testable. Topic: Cooperative cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cancellableComputation(): String = TODO()

    // Exercise 5: nonCancellable
    // TODO: Implement a coroutine exercise demonstrating nonCancellable.
    // TODO: Use runBlocking to make it testable. Topic: Cooperative cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise5_nonCancellable(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_ensureActive().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_yieldCancel().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_isActiveLoop() == true) { "Exercise 3 failed" }
        assert(exercise4_cancellableComputation().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_nonCancellable().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro008_CancellationCoop exercises passed!")
    }
}
