package org.shev4ik.interview.coroutines.level1_basics

/**
 * Async exception handling
 */
object Coro018_AsyncExceptions {

    // Exercise 1: asyncFails
    // TODO: Implement a coroutine exercise demonstrating asyncFails.
    // TODO: Use runBlocking to make it testable. Topic: Async exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise1_asyncFails(): String = TODO()

    // Exercise 2: awaitException
    // TODO: Implement a coroutine exercise demonstrating awaitException.
    // TODO: Use runBlocking to make it testable. Topic: Async exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise2_awaitException(): String = TODO()

    // Exercise 3: deferredHandle
    // TODO: Implement a coroutine exercise demonstrating deferredHandle.
    // TODO: Use runBlocking to make it testable. Topic: Async exception handling.
    // TODO: Return a verifiable result of type String.
    fun exercise3_deferredHandle(): String = TODO()

    // Exercise 4: supervisorAsync
    // TODO: Implement a coroutine exercise demonstrating supervisorAsync.
    // TODO: Use runBlocking to make it testable. Topic: Async exception handling.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_supervisorAsync(): Boolean = TODO()

    // Exercise 5: exceptionInMap
    // TODO: Implement a coroutine exercise demonstrating exceptionInMap.
    // TODO: Use runBlocking to make it testable. Topic: Async exception handling.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise5_exceptionInMap(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_asyncFails().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_awaitException().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_deferredHandle().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_supervisorAsync() == true) { "Exercise 4 failed" }
        assert(exercise5_exceptionInMap().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro018_AsyncExceptions exercises passed!")
    }
}
