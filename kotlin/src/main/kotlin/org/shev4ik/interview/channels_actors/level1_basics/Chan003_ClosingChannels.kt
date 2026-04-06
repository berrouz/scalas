package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Closing channels
 */
object Chan003_ClosingChannels {

    // Exercise 1: close
    // TODO: Implement close for concurrency/streaming.
    // TODO: Topic: Closing channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_close(): String = TODO()

    // Exercise 2: isClosedForSend
    // TODO: Implement isClosedForSend for concurrency/streaming.
    // TODO: Topic: Closing channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_isClosedForSend(): Boolean = TODO()

    // Exercise 3: isClosedForReceive
    // TODO: Implement isClosedForReceive for concurrency/streaming.
    // TODO: Topic: Closing channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_isClosedForReceive(): Boolean = TODO()

    // Exercise 4: closeCause
    // TODO: Implement closeCause for concurrency/streaming.
    // TODO: Topic: Closing channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_closeCause(): String = TODO()

    // Exercise 5: consumeFinish
    // TODO: Implement consumeFinish for concurrency/streaming.
    // TODO: Topic: Closing channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_consumeFinish(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_close().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_isClosedForSend() == true) { "Exercise 2 failed" }
        assert(exercise3_isClosedForReceive() == true) { "Exercise 3 failed" }
        assert(exercise4_closeCause().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_consumeFinish() == true) { "Exercise 5 failed" }
        println("All Chan003_ClosingChannels exercises passed!")
    }
}
