package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Channel buffer types
 */
object Coro037_ChannelTypes {

    // Exercise 1: rendezvous
    // TODO: Implement a coroutine exercise demonstrating rendezvous.
    // TODO: Use runBlocking to make it testable. Topic: Channel buffer types.
    // TODO: Return a verifiable result of type String.
    fun exercise1_rendezvous(): String = TODO()

    // Exercise 2: buffered
    // TODO: Implement a coroutine exercise demonstrating buffered.
    // TODO: Use runBlocking to make it testable. Topic: Channel buffer types.
    // TODO: Return a verifiable result of type String.
    fun exercise2_buffered(): String = TODO()

    // Exercise 3: conflated
    // TODO: Implement a coroutine exercise demonstrating conflated.
    // TODO: Use runBlocking to make it testable. Topic: Channel buffer types.
    // TODO: Return a verifiable result of type String.
    fun exercise3_conflated(): String = TODO()

    // Exercise 4: unlimited
    // TODO: Implement a coroutine exercise demonstrating unlimited.
    // TODO: Use runBlocking to make it testable. Topic: Channel buffer types.
    // TODO: Return a verifiable result of type String.
    fun exercise4_unlimited(): String = TODO()

    // Exercise 5: bufferOverflow
    // TODO: Implement a coroutine exercise demonstrating bufferOverflow.
    // TODO: Use runBlocking to make it testable. Topic: Channel buffer types.
    // TODO: Return a verifiable result of type String.
    fun exercise5_bufferOverflow(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_rendezvous().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_buffered().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_conflated().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_unlimited().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_bufferOverflow().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro037_ChannelTypes exercises passed!")
    }
}
