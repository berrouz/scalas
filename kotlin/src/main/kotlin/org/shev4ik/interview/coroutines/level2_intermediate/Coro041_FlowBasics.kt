package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow fundamentals
 */
object Coro041_FlowBasics {

    // Exercise 1: createFlow
    // TODO: Implement a coroutine exercise demonstrating createFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow fundamentals.
    // TODO: Return a verifiable result of type String.
    fun exercise1_createFlow(): String = TODO()

    // Exercise 2: collect
    // TODO: Implement a coroutine exercise demonstrating collect.
    // TODO: Use runBlocking to make it testable. Topic: Flow fundamentals.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_collect(): List<Int> = TODO()

    // Exercise 3: coldStream
    // TODO: Implement a coroutine exercise demonstrating coldStream.
    // TODO: Use runBlocking to make it testable. Topic: Flow fundamentals.
    // TODO: Return a verifiable result of type String.
    fun exercise3_coldStream(): String = TODO()

    // Exercise 4: flowVsSequence
    // TODO: Implement a coroutine exercise demonstrating flowVsSequence.
    // TODO: Use runBlocking to make it testable. Topic: Flow fundamentals.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise4_flowVsSequence(): List<Int> = TODO()

    // Exercise 5: flowBuilder
    // TODO: Implement a coroutine exercise demonstrating flowBuilder.
    // TODO: Use runBlocking to make it testable. Topic: Flow fundamentals.
    // TODO: Return a verifiable result of type String.
    fun exercise5_flowBuilder(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_collect().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_coldStream().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flowVsSequence().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_flowBuilder().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro041_FlowBasics exercises passed!")
    }
}
