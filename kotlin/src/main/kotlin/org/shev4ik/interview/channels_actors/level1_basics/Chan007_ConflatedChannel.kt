package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Conflated channel
 */
object Chan007_ConflatedChannel {

    // Exercise 1: conflated
    // TODO: Implement conflated for concurrency/streaming.
    // TODO: Topic: Conflated channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_conflated(): String = TODO()

    // Exercise 2: latestOnly
    // TODO: Implement latestOnly for concurrency/streaming.
    // TODO: Topic: Conflated channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_latestOnly(): Boolean = TODO()

    // Exercise 3: overwrite
    // TODO: Implement overwrite for concurrency/streaming.
    // TODO: Topic: Conflated channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_overwrite(): String = TODO()

    // Exercise 4: noBackpressure
    // TODO: Implement noBackpressure for concurrency/streaming.
    // TODO: Topic: Conflated channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_noBackpressure(): String = TODO()

    // Exercise 5: stateChannel
    // TODO: Implement stateChannel for concurrency/streaming.
    // TODO: Topic: Conflated channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_stateChannel(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_conflated().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_latestOnly() == true) { "Exercise 2 failed" }
        assert(exercise3_overwrite().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_noBackpressure().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_stateChannel().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan007_ConflatedChannel exercises passed!")
    }
}
