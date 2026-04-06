package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Channel basics
 */
object Coro036_ChannelBasics {

    // Exercise 1: createChannel
    // TODO: Implement a coroutine exercise demonstrating createChannel.
    // TODO: Use runBlocking to make it testable. Topic: Channel basics.
    // TODO: Return a verifiable result of type String.
    fun exercise1_createChannel(): String = TODO()

    // Exercise 2: sendReceive
    // TODO: Implement a coroutine exercise demonstrating sendReceive.
    // TODO: Use runBlocking to make it testable. Topic: Channel basics.
    // TODO: Return a verifiable result of type String.
    fun exercise2_sendReceive(): String = TODO()

    // Exercise 3: closedChannel
    // TODO: Implement a coroutine exercise demonstrating closedChannel.
    // TODO: Use runBlocking to make it testable. Topic: Channel basics.
    // TODO: Return a verifiable result of type String.
    fun exercise3_closedChannel(): String = TODO()

    // Exercise 4: forChannel
    // TODO: Implement a coroutine exercise demonstrating forChannel.
    // TODO: Use runBlocking to make it testable. Topic: Channel basics.
    // TODO: Return a verifiable result of type String.
    fun exercise4_forChannel(): String = TODO()

    // Exercise 5: channelCapacity
    // TODO: Implement a coroutine exercise demonstrating channelCapacity.
    // TODO: Use runBlocking to make it testable. Topic: Channel basics.
    // TODO: Return a verifiable result of type Int.
    fun exercise5_channelCapacity(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createChannel().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_sendReceive().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_closedChannel().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_forChannel().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_channelCapacity()
        println("All Coro036_ChannelBasics exercises passed!")
    }
}
