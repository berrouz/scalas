package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow cancellation
 */
object Coro047_FlowCancellation {

    // Exercise 1: cancelFlow
    // TODO: Implement a coroutine exercise demonstrating cancelFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise1_cancelFlow(): String = TODO()

    // Exercise 2: ensureActive
    // TODO: Implement a coroutine exercise demonstrating ensureActive.
    // TODO: Use runBlocking to make it testable. Topic: Flow cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise2_ensureActive(): String = TODO()

    // Exercise 3: cancellable
    // TODO: Implement a coroutine exercise demonstrating cancellable.
    // TODO: Use runBlocking to make it testable. Topic: Flow cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise3_cancellable(): String = TODO()

    // Exercise 4: timeoutFlow
    // TODO: Implement a coroutine exercise demonstrating timeoutFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise4_timeoutFlow(): String = TODO()

    // Exercise 5: cooperativeCancel
    // TODO: Implement a coroutine exercise demonstrating cooperativeCancel.
    // TODO: Use runBlocking to make it testable. Topic: Flow cancellation.
    // TODO: Return a verifiable result of type String.
    fun exercise5_cooperativeCancel(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cancelFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_ensureActive().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_cancellable().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_timeoutFlow().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_cooperativeCancel().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro047_FlowCancellation exercises passed!")
    }
}
