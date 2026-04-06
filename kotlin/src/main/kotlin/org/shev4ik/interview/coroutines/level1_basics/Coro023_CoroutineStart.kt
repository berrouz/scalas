package org.shev4ik.interview.coroutines.level1_basics

/**
 * CoroutineStart options
 */
object Coro023_CoroutineStart {

    // Exercise 1: defaultStart
    // TODO: Implement a coroutine exercise demonstrating defaultStart.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineStart options.
    // TODO: Return a verifiable result of type String.
    fun exercise1_defaultStart(): String = TODO()

    // Exercise 2: lazyStart
    // TODO: Implement a coroutine exercise demonstrating lazyStart.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineStart options.
    // TODO: Return a verifiable result of type String.
    fun exercise2_lazyStart(): String = TODO()

    // Exercise 3: atomicStart
    // TODO: Implement a coroutine exercise demonstrating atomicStart.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineStart options.
    // TODO: Return a verifiable result of type String.
    fun exercise3_atomicStart(): String = TODO()

    // Exercise 4: undispatchedStart
    // TODO: Implement a coroutine exercise demonstrating undispatchedStart.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineStart options.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_undispatchedStart(): Boolean = TODO()

    // Exercise 5: startComparison
    // TODO: Implement a coroutine exercise demonstrating startComparison.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineStart options.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_startComparison(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_defaultStart().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_lazyStart().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_atomicStart().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_undispatchedStart() == true) { "Exercise 4 failed" }
        assert(exercise5_startComparison() == true) { "Exercise 5 failed" }
        println("All Coro023_CoroutineStart exercises passed!")
    }
}
