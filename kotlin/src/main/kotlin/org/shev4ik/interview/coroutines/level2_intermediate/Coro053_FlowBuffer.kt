package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow buffering
 */
object Coro053_FlowBuffer {

    // Exercise 1: buffer
    // TODO: Implement a coroutine exercise demonstrating buffer.
    // TODO: Use runBlocking to make it testable. Topic: Flow buffering.
    // TODO: Return a verifiable result of type String.
    fun exercise1_buffer(): String = TODO()

    // Exercise 2: conflate
    // TODO: Implement a coroutine exercise demonstrating conflate.
    // TODO: Use runBlocking to make it testable. Topic: Flow buffering.
    // TODO: Return a verifiable result of type String.
    fun exercise2_conflate(): String = TODO()

    // Exercise 3: collectLatest
    // TODO: Implement a coroutine exercise demonstrating collectLatest.
    // TODO: Use runBlocking to make it testable. Topic: Flow buffering.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_collectLatest(): Boolean = TODO()

    // Exercise 4: bufferOverflow
    // TODO: Implement a coroutine exercise demonstrating bufferOverflow.
    // TODO: Use runBlocking to make it testable. Topic: Flow buffering.
    // TODO: Return a verifiable result of type String.
    fun exercise4_bufferOverflow(): String = TODO()

    // Exercise 5: conflateVsLatest
    // TODO: Implement a coroutine exercise demonstrating conflateVsLatest.
    // TODO: Use runBlocking to make it testable. Topic: Flow buffering.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_conflateVsLatest(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_buffer().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_conflate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_collectLatest() == true) { "Exercise 3 failed" }
        assert(exercise4_bufferOverflow().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_conflateVsLatest() == true) { "Exercise 5 failed" }
        println("All Coro053_FlowBuffer exercises passed!")
    }
}
