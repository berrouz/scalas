package org.shev4ik.interview.coroutines.level1_basics

/**
 * CoroutineExceptionHandler
 */
object Coro016_ExceptionHandler {

    // Exercise 1: installHandler
    // TODO: Implement a coroutine exercise demonstrating installHandler.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineExceptionHandler.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_installHandler(): List<Int> = TODO()

    // Exercise 2: uncaughtHandler
    // TODO: Implement a coroutine exercise demonstrating uncaughtHandler.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineExceptionHandler.
    // TODO: Return a verifiable result of type String.
    fun exercise2_uncaughtHandler(): String = TODO()

    // Exercise 3: rootHandler
    // TODO: Implement a coroutine exercise demonstrating rootHandler.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineExceptionHandler.
    // TODO: Return a verifiable result of type String.
    fun exercise3_rootHandler(): String = TODO()

    // Exercise 4: handlerScope
    // TODO: Implement a coroutine exercise demonstrating handlerScope.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineExceptionHandler.
    // TODO: Return a verifiable result of type String.
    fun exercise4_handlerScope(): String = TODO()

    // Exercise 5: handlerPattern
    // TODO: Implement a coroutine exercise demonstrating handlerPattern.
    // TODO: Use runBlocking to make it testable. Topic: CoroutineExceptionHandler.
    // TODO: Return a verifiable result of type String.
    fun exercise5_handlerPattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_installHandler().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_uncaughtHandler().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rootHandler().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_handlerScope().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_handlerPattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro016_ExceptionHandler exercises passed!")
    }
}
