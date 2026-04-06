package org.shev4ik.interview.coroutines.level1_basics

/**
 * Coroutine states
 */
object Coro030_CoroutineLifecycle {

    // Exercise 1: newState
    // TODO: Implement a coroutine exercise demonstrating newState.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine states.
    // TODO: Return a verifiable result of type String.
    fun exercise1_newState(): String = TODO()

    // Exercise 2: activeState
    // TODO: Implement a coroutine exercise demonstrating activeState.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine states.
    // TODO: Return a verifiable result of type String.
    fun exercise2_activeState(): String = TODO()

    // Exercise 3: completingState
    // TODO: Implement a coroutine exercise demonstrating completingState.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine states.
    // TODO: Return a verifiable result of type String.
    fun exercise3_completingState(): String = TODO()

    // Exercise 4: completedState
    // TODO: Implement a coroutine exercise demonstrating completedState.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine states.
    // TODO: Return a verifiable result of type String.
    fun exercise4_completedState(): String = TODO()

    // Exercise 5: cancelledState
    // TODO: Implement a coroutine exercise demonstrating cancelledState.
    // TODO: Use runBlocking to make it testable. Topic: Coroutine states.
    // TODO: Return a verifiable result of type String.
    fun exercise5_cancelledState(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_newState().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_activeState().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_completingState().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_completedState().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_cancelledState().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro030_CoroutineLifecycle exercises passed!")
    }
}
