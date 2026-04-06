package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Producer-consumer with channels
 */
object Coro038_ProducerConsumer {

    // Exercise 1: produce
    // TODO: Implement a coroutine exercise demonstrating produce.
    // TODO: Use runBlocking to make it testable. Topic: Producer-consumer with channels.
    // TODO: Return a verifiable result of type String.
    fun exercise1_produce(): String = TODO()

    // Exercise 2: consumeEach
    // TODO: Implement a coroutine exercise demonstrating consumeEach.
    // TODO: Use runBlocking to make it testable. Topic: Producer-consumer with channels.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_consumeEach(): Int = TODO()

    // Exercise 3: fanOut
    // TODO: Implement a coroutine exercise demonstrating fanOut.
    // TODO: Use runBlocking to make it testable. Topic: Producer-consumer with channels.
    // TODO: Return a verifiable result of type String.
    fun exercise3_fanOut(): String = TODO()

    // Exercise 4: fanIn
    // TODO: Implement a coroutine exercise demonstrating fanIn.
    // TODO: Use runBlocking to make it testable. Topic: Producer-consumer with channels.
    // TODO: Return a verifiable result of type String.
    fun exercise4_fanIn(): String = TODO()

    // Exercise 5: pipeline
    // TODO: Implement a coroutine exercise demonstrating pipeline.
    // TODO: Use runBlocking to make it testable. Topic: Producer-consumer with channels.
    // TODO: Return a verifiable result of type String.
    fun exercise5_pipeline(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_produce().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_consumeEach()
        assert(exercise3_fanOut().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fanIn().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_pipeline().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro038_ProducerConsumer exercises passed!")
    }
}
