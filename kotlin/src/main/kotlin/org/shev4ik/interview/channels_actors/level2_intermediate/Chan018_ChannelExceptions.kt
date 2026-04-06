package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Channel exceptions
 */
object Chan018_ChannelExceptions {

    // Exercise 1: sendException
    // TODO: Implement sendException for concurrency/streaming.
    // TODO: Topic: Channel exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_sendException(): String = TODO()

    // Exercise 2: receiveException
    // TODO: Implement receiveException for concurrency/streaming.
    // TODO: Topic: Channel exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_receiveException(): String = TODO()

    // Exercise 3: closedChannel
    // TODO: Implement closedChannel for concurrency/streaming.
    // TODO: Topic: Channel exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_closedChannel(): String = TODO()

    // Exercise 4: cancelChannel
    // TODO: Implement cancelChannel for concurrency/streaming.
    // TODO: Topic: Channel exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_cancelChannel(): String = TODO()

    // Exercise 5: errorPropagation
    // TODO: Implement errorPropagation for concurrency/streaming.
    // TODO: Topic: Channel exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_errorPropagation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sendException().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_receiveException().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_closedChannel().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cancelChannel().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_errorPropagation().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan018_ChannelExceptions exercises passed!")
    }
}
