package org.shev4ik.interview.coroutines.level1_basics

/**
 * Structured concurrency
 */
object Coro014_StructuredConcurrency {

    // Exercise 1: parentChild
    // TODO: Implement a coroutine exercise demonstrating parentChild.
    // TODO: Use runBlocking to make it testable. Topic: Structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise1_parentChild(): String = TODO()

    // Exercise 2: scopeCancellation
    // TODO: Implement a coroutine exercise demonstrating scopeCancellation.
    // TODO: Use runBlocking to make it testable. Topic: Structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise2_scopeCancellation(): String = TODO()

    // Exercise 3: childFailure
    // TODO: Implement a coroutine exercise demonstrating childFailure.
    // TODO: Use runBlocking to make it testable. Topic: Structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise3_childFailure(): String = TODO()

    // Exercise 4: waitForChildren
    // TODO: Implement a coroutine exercise demonstrating waitForChildren.
    // TODO: Use runBlocking to make it testable. Topic: Structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise4_waitForChildren(): String = TODO()

    // Exercise 5: scopeComplete
    // TODO: Implement a coroutine exercise demonstrating scopeComplete.
    // TODO: Use runBlocking to make it testable. Topic: Structured concurrency.
    // TODO: Return a verifiable result of type String.
    fun exercise5_scopeComplete(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_parentChild().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_scopeCancellation().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_childFailure().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_waitForChildren().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_scopeComplete().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro014_StructuredConcurrency exercises passed!")
    }
}
