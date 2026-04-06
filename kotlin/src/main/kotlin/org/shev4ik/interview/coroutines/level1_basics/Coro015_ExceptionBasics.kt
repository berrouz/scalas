package org.shev4ik.interview.coroutines.level1_basics

/**
 * Exception handling basics
 */
object Coro015_ExceptionBasics {

    // Exercise 1: tryCatch
    // TODO: Implement a coroutine exercise demonstrating tryCatch.
    // TODO: Use runBlocking to make it testable. Topic: Exception handling basics.
    // TODO: Return a verifiable result of type String.
    fun exercise1_tryCatch(): String = TODO()

    // Exercise 2: exceptionPropagation
    // TODO: Implement a coroutine exercise demonstrating exceptionPropagation.
    // TODO: Use runBlocking to make it testable. Topic: Exception handling basics.
    // TODO: Return a verifiable result of type String.
    fun exercise2_exceptionPropagation(): String = TODO()

    // Exercise 3: launchException
    // TODO: Implement a coroutine exercise demonstrating launchException.
    // TODO: Use runBlocking to make it testable. Topic: Exception handling basics.
    // TODO: Return a verifiable result of type String.
    fun exercise3_launchException(): String = TODO()

    // Exercise 4: asyncException
    // TODO: Implement a coroutine exercise demonstrating asyncException.
    // TODO: Use runBlocking to make it testable. Topic: Exception handling basics.
    // TODO: Return a verifiable result of type String.
    fun exercise4_asyncException(): String = TODO()

    // Exercise 5: failureHandling
    // TODO: Implement a coroutine exercise demonstrating failureHandling.
    // TODO: Use runBlocking to make it testable. Topic: Exception handling basics.
    // TODO: Return a verifiable result of type String.
    fun exercise5_failureHandling(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tryCatch().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_exceptionPropagation().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_launchException().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_asyncException().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_failureHandling().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro015_ExceptionBasics exercises passed!")
    }
}
