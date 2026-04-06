package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced callbackFlow
 */
object Coro087_AdvCallbackFlow {

    // Exercise 1: complexCallback
    // TODO: Implement a coroutine exercise demonstrating complexCallback.
    // TODO: Use runBlocking to make it testable. Topic: Advanced callbackFlow.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_complexCallback(): List<Int> = TODO()

    // Exercise 2: multipleCallbacks
    // TODO: Implement a coroutine exercise demonstrating multipleCallbacks.
    // TODO: Use runBlocking to make it testable. Topic: Advanced callbackFlow.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_multipleCallbacks(): List<Int> = TODO()

    // Exercise 3: errorHandling
    // TODO: Implement a coroutine exercise demonstrating errorHandling.
    // TODO: Use runBlocking to make it testable. Topic: Advanced callbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise3_errorHandling(): String = TODO()

    // Exercise 4: cleanup
    // TODO: Implement a coroutine exercise demonstrating cleanup.
    // TODO: Use runBlocking to make it testable. Topic: Advanced callbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise4_cleanup(): String = TODO()

    // Exercise 5: registration
    // TODO: Implement a coroutine exercise demonstrating registration.
    // TODO: Use runBlocking to make it testable. Topic: Advanced callbackFlow.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_registration(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_complexCallback().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_multipleCallbacks().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_errorHandling().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cleanup().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_registration() == true) { "Exercise 5 failed" }
        println("All Coro087_AdvCallbackFlow exercises passed!")
    }
}
