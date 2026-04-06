package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * Channel backpressure
 */
object Chan023_BackpressureChannels {

    // Exercise 1: suspendSend
    // TODO: Implement suspendSend for concurrency/streaming.
    // TODO: Topic: Channel backpressure.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_suspendSend(): String = TODO()

    // Exercise 2: bufferOverflow
    // TODO: Implement bufferOverflow for concurrency/streaming.
    // TODO: Topic: Channel backpressure.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_bufferOverflow(): String = TODO()

    // Exercise 3: dropping
    // TODO: Implement dropping for concurrency/streaming.
    // TODO: Topic: Channel backpressure.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_dropping(): String = TODO()

    // Exercise 4: conflating
    // TODO: Implement conflating for concurrency/streaming.
    // TODO: Topic: Channel backpressure.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_conflating(): String = TODO()

    // Exercise 5: rateLimiting
    // TODO: Implement rateLimiting for concurrency/streaming.
    // TODO: Topic: Channel backpressure.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_rateLimiting(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_suspendSend().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_bufferOverflow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_dropping().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_conflating().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_rateLimiting().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan023_BackpressureChannels exercises passed!")
    }
}
