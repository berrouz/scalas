package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * SharedFlow
 */
object Coro049_SharedFlow {

    // Exercise 1: mutableSharedFlow
    // TODO: Implement a coroutine exercise demonstrating mutableSharedFlow.
    // TODO: Use runBlocking to make it testable. Topic: SharedFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise1_mutableSharedFlow(): String = TODO()

    // Exercise 2: replayCache
    // TODO: Implement a coroutine exercise demonstrating replayCache.
    // TODO: Use runBlocking to make it testable. Topic: SharedFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise2_replayCache(): String = TODO()

    // Exercise 3: bufferCapacity
    // TODO: Implement a coroutine exercise demonstrating bufferCapacity.
    // TODO: Use runBlocking to make it testable. Topic: SharedFlow.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_bufferCapacity(): Int = TODO()

    // Exercise 4: emitSuspend
    // TODO: Implement a coroutine exercise demonstrating emitSuspend.
    // TODO: Use runBlocking to make it testable. Topic: SharedFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise4_emitSuspend(): String = TODO()

    // Exercise 5: tryEmit
    // TODO: Implement a coroutine exercise demonstrating tryEmit.
    // TODO: Use runBlocking to make it testable. Topic: SharedFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise5_tryEmit(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mutableSharedFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_replayCache().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_bufferCapacity()
        assert(exercise4_emitSuspend().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_tryEmit().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro049_SharedFlow exercises passed!")
    }
}
