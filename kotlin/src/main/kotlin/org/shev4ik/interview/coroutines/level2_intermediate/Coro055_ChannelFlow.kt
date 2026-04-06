package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * ChannelFlow
 */
object Coro055_ChannelFlow {

    // Exercise 1: channelFlow
    // TODO: Implement a coroutine exercise demonstrating channelFlow.
    // TODO: Use runBlocking to make it testable. Topic: ChannelFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise1_channelFlow(): String = TODO()

    // Exercise 2: concurrentEmit
    // TODO: Implement a coroutine exercise demonstrating concurrentEmit.
    // TODO: Use runBlocking to make it testable. Topic: ChannelFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise2_concurrentEmit(): String = TODO()

    // Exercise 3: sendInChannel
    // TODO: Implement a coroutine exercise demonstrating sendInChannel.
    // TODO: Use runBlocking to make it testable. Topic: ChannelFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise3_sendInChannel(): String = TODO()

    // Exercise 4: channelCapacity
    // TODO: Implement a coroutine exercise demonstrating channelCapacity.
    // TODO: Use runBlocking to make it testable. Topic: ChannelFlow.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_channelCapacity(): Int = TODO()

    // Exercise 5: backpressure
    // TODO: Implement a coroutine exercise demonstrating backpressure.
    // TODO: Use runBlocking to make it testable. Topic: ChannelFlow.
    // TODO: Return a verifiable result of type String.
    fun exercise5_backpressure(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_channelFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_concurrentEmit().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_sendInChannel().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_channelCapacity()
        assert(exercise5_backpressure().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro055_ChannelFlow exercises passed!")
    }
}
