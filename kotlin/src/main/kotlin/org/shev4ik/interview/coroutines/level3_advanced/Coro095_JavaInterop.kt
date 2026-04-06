package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Java interop
 */
object Coro095_JavaInterop {

    // Exercise 1: completableFuture
    // TODO: Implement a coroutine exercise demonstrating completableFuture.
    // TODO: Use runBlocking to make it testable. Topic: Java interop.
    // TODO: Return a verifiable result of type String.
    fun exercise1_completableFuture(): String = TODO()

    // Exercise 2: rxJava
    // TODO: Implement a coroutine exercise demonstrating rxJava.
    // TODO: Use runBlocking to make it testable. Topic: Java interop.
    // TODO: Return a verifiable result of type String.
    fun exercise2_rxJava(): String = TODO()

    // Exercise 3: callbackToSuspend
    // TODO: Implement a coroutine exercise demonstrating callbackToSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Java interop.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_callbackToSuspend(): List<Int> = TODO()

    // Exercise 4: executorToDispatcher
    // TODO: Implement a coroutine exercise demonstrating executorToDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Java interop.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_executorToDispatcher(): Boolean = TODO()

    // Exercise 5: futureToDeferred
    // TODO: Implement a coroutine exercise demonstrating futureToDeferred.
    // TODO: Use runBlocking to make it testable. Topic: Java interop.
    // TODO: Return a verifiable result of type String.
    fun exercise5_futureToDeferred(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_completableFuture().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_rxJava().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_callbackToSuspend().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_executorToDispatcher() == true) { "Exercise 4 failed" }
        assert(exercise5_futureToDeferred().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro095_JavaInterop exercises passed!")
    }
}
