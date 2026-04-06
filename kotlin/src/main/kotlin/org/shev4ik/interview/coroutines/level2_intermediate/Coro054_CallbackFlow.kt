package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * CallbackFlow
 */
object Coro054_CallbackFlow {

    // Exercise 1: callbackFlow
    // TODO: Implement a coroutine exercise demonstrating callbackFlow.
    // TODO: Use runBlocking to make it testable. Topic: CallbackFlow.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_callbackFlow(): List<Int> = TODO()

    // Exercise 2: awaitClose
    // TODO: Implement a coroutine exercise demonstrating awaitClose.
    // TODO: Use runBlocking to make it testable. Topic: CallbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise2_awaitClose(): String = TODO()

    // Exercise 3: trySend
    // TODO: Implement a coroutine exercise demonstrating trySend.
    // TODO: Use runBlocking to make it testable. Topic: CallbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise3_trySend(): String = TODO()

    // Exercise 4: channelResult
    // TODO: Implement a coroutine exercise demonstrating channelResult.
    // TODO: Use runBlocking to make it testable. Topic: CallbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise4_channelResult(): String = TODO()

    // Exercise 5: resourceCleanup
    // TODO: Implement a coroutine exercise demonstrating resourceCleanup.
    // TODO: Use runBlocking to make it testable. Topic: CallbackFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise5_resourceCleanup(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_callbackFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_awaitClose().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_trySend().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_channelResult().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_resourceCleanup().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro054_CallbackFlow exercises passed!")
    }
}
