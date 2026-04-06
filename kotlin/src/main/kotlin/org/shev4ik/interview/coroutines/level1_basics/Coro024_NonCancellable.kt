package org.shev4ik.interview.coroutines.level1_basics

/**
 * NonCancellable context
 */
object Coro024_NonCancellable {

    // Exercise 1: cleanupFinally
    // TODO: Implement a coroutine exercise demonstrating cleanupFinally.
    // TODO: Use runBlocking to make it testable. Topic: NonCancellable context.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_cleanupFinally(): List<Int> = TODO()

    // Exercise 2: nonCancellable
    // TODO: Implement a coroutine exercise demonstrating nonCancellable.
    // TODO: Use runBlocking to make it testable. Topic: NonCancellable context.
    // TODO: Return a verifiable result of type String.
    fun exercise2_nonCancellable(): String = TODO()

    // Exercise 3: resourceRelease
    // TODO: Implement a coroutine exercise demonstrating resourceRelease.
    // TODO: Use runBlocking to make it testable. Topic: NonCancellable context.
    // TODO: Return a verifiable result of type String.
    fun exercise3_resourceRelease(): String = TODO()

    // Exercise 4: logOnCancel
    // TODO: Implement a coroutine exercise demonstrating logOnCancel.
    // TODO: Use runBlocking to make it testable. Topic: NonCancellable context.
    // TODO: Return a verifiable result of type String.
    fun exercise4_logOnCancel(): String = TODO()

    // Exercise 5: closeResources
    // TODO: Implement a coroutine exercise demonstrating closeResources.
    // TODO: Use runBlocking to make it testable. Topic: NonCancellable context.
    // TODO: Return a verifiable result of type String.
    fun exercise5_closeResources(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cleanupFinally().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_nonCancellable().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_resourceRelease().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_logOnCancel().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_closeResources().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro024_NonCancellable exercises passed!")
    }
}
