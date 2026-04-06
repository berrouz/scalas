package org.shev4ik.interview.coroutines.level1_basics

/**
 * Dispatchers
 */
object Coro010_DispatcherBasics {

    // Exercise 1: defaultDispatcher
    // TODO: Implement a coroutine exercise demonstrating defaultDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_defaultDispatcher(): Boolean = TODO()

    // Exercise 2: ioDispatcher
    // TODO: Implement a coroutine exercise demonstrating ioDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_ioDispatcher(): Boolean = TODO()

    // Exercise 3: unconfinedDispatcher
    // TODO: Implement a coroutine exercise demonstrating unconfinedDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_unconfinedDispatcher(): Boolean = TODO()

    // Exercise 4: mainDispatcher
    // TODO: Implement a coroutine exercise demonstrating mainDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_mainDispatcher(): Boolean = TODO()

    // Exercise 5: customDispatcher
    // TODO: Implement a coroutine exercise demonstrating customDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_customDispatcher(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_defaultDispatcher() == true) { "Exercise 1 failed" }
        assert(exercise2_ioDispatcher() == true) { "Exercise 2 failed" }
        assert(exercise3_unconfinedDispatcher() == true) { "Exercise 3 failed" }
        assert(exercise4_mainDispatcher() == true) { "Exercise 4 failed" }
        assert(exercise5_customDispatcher() == true) { "Exercise 5 failed" }
        println("All Coro010_DispatcherBasics exercises passed!")
    }
}
