package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow context
 */
object Coro045_FlowContext {

    // Exercise 1: flowOn
    // TODO: Implement a coroutine exercise demonstrating flowOn.
    // TODO: Use runBlocking to make it testable. Topic: Flow context.
    // TODO: Return a verifiable result of type String.
    fun exercise1_flowOn(): String = TODO()

    // Exercise 2: contextPreserve
    // TODO: Implement a coroutine exercise demonstrating contextPreserve.
    // TODO: Use runBlocking to make it testable. Topic: Flow context.
    // TODO: Return a verifiable result of type String.
    fun exercise2_contextPreserve(): String = TODO()

    // Exercise 3: launchIn
    // TODO: Implement a coroutine exercise demonstrating launchIn.
    // TODO: Use runBlocking to make it testable. Topic: Flow context.
    // TODO: Return a verifiable result of type String.
    fun exercise3_launchIn(): String = TODO()

    // Exercise 4: conflation
    // TODO: Implement a coroutine exercise demonstrating conflation.
    // TODO: Use runBlocking to make it testable. Topic: Flow context.
    // TODO: Return a verifiable result of type String.
    fun exercise4_conflation(): String = TODO()

    // Exercise 5: bufferContext
    // TODO: Implement a coroutine exercise demonstrating bufferContext.
    // TODO: Use runBlocking to make it testable. Topic: Flow context.
    // TODO: Return a verifiable result of type String.
    fun exercise5_bufferContext(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flowOn().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_contextPreserve().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_launchIn().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_conflation().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_bufferContext().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro045_FlowContext exercises passed!")
    }
}
