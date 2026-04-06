package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow builder functions
 */
object Coro042_FlowBuilders {

    // Exercise 1: flowOf
    // TODO: Implement a coroutine exercise demonstrating flowOf.
    // TODO: Use runBlocking to make it testable. Topic: Flow builder functions.
    // TODO: Return a verifiable result of type String.
    fun exercise1_flowOf(): String = TODO()

    // Exercise 2: asFlow
    // TODO: Implement a coroutine exercise demonstrating asFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow builder functions.
    // TODO: Return a verifiable result of type String.
    fun exercise2_asFlow(): String = TODO()

    // Exercise 3: channelFlow
    // TODO: Implement a coroutine exercise demonstrating channelFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow builder functions.
    // TODO: Return a verifiable result of type String.
    fun exercise3_channelFlow(): String = TODO()

    // Exercise 4: callbackFlow
    // TODO: Implement a coroutine exercise demonstrating callbackFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow builder functions.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_callbackFlow(): List<Int> = TODO()

    // Exercise 5: emptyFlow
    // TODO: Implement a coroutine exercise demonstrating emptyFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow builder functions.
    // TODO: Return a verifiable result of type String.
    fun exercise5_emptyFlow(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flowOf().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_asFlow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_channelFlow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_callbackFlow().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_emptyFlow().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro042_FlowBuilders exercises passed!")
    }
}
