package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Advanced channel patterns
 */
object Coro080_AdvancedChannel {

    // Exercise 1: tickerChannel
    // TODO: Implement a coroutine exercise demonstrating tickerChannel.
    // TODO: Use runBlocking to make it testable. Topic: Advanced channel patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise1_tickerChannel(): String = TODO()

    // Exercise 2: broadcastChannel
    // TODO: Implement a coroutine exercise demonstrating broadcastChannel.
    // TODO: Use runBlocking to make it testable. Topic: Advanced channel patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_broadcastChannel(): String = TODO()

    // Exercise 3: conflatedBroadcast
    // TODO: Implement a coroutine exercise demonstrating conflatedBroadcast.
    // TODO: Use runBlocking to make it testable. Topic: Advanced channel patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_conflatedBroadcast(): String = TODO()

    // Exercise 4: channelIterator
    // TODO: Implement a coroutine exercise demonstrating channelIterator.
    // TODO: Use runBlocking to make it testable. Topic: Advanced channel patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_channelIterator(): String = TODO()

    // Exercise 5: channelProduce
    // TODO: Implement a coroutine exercise demonstrating channelProduce.
    // TODO: Use runBlocking to make it testable. Topic: Advanced channel patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_channelProduce(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tickerChannel().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_broadcastChannel().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_conflatedBroadcast().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_channelIterator().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_channelProduce().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro080_AdvancedChannel exercises passed!")
    }
}
