package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Unconfined dispatcher
 */
object Coro075_UnconfinedDispatcher {

    // Exercise 1: unconfinedBehavior
    // TODO: Implement a coroutine exercise demonstrating unconfinedBehavior.
    // TODO: Use runBlocking to make it testable. Topic: Unconfined dispatcher.
    // TODO: Return a verifiable result of type String.
    fun exercise1_unconfinedBehavior(): String = TODO()

    // Exercise 2: resumeThread
    // TODO: Implement a coroutine exercise demonstrating resumeThread.
    // TODO: Use runBlocking to make it testable. Topic: Unconfined dispatcher.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_resumeThread(): Int = TODO()

    // Exercise 3: eventLoop
    // TODO: Implement a coroutine exercise demonstrating eventLoop.
    // TODO: Use runBlocking to make it testable. Topic: Unconfined dispatcher.
    // TODO: Return a verifiable result of type String.
    fun exercise3_eventLoop(): String = TODO()

    // Exercise 4: useCases
    // TODO: Implement a coroutine exercise demonstrating useCases.
    // TODO: Use runBlocking to make it testable. Topic: Unconfined dispatcher.
    // TODO: Return a verifiable result of type String.
    fun exercise4_useCases(): String = TODO()

    // Exercise 5: dangers
    // TODO: Implement a coroutine exercise demonstrating dangers.
    // TODO: Use runBlocking to make it testable. Topic: Unconfined dispatcher.
    // TODO: Return a verifiable result of type String.
    fun exercise5_dangers(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_unconfinedBehavior().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_resumeThread()
        assert(exercise3_eventLoop().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_useCases().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_dangers().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro075_UnconfinedDispatcher exercises passed!")
    }
}
