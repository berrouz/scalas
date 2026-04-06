package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Ticker channel
 */
object Chan017_TickerChannel {

    // Exercise 1: ticker
    // TODO: Implement ticker for concurrency/streaming.
    // TODO: Topic: Ticker channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_ticker(): String = TODO()

    // Exercise 2: periodic
    // TODO: Implement periodic for concurrency/streaming.
    // TODO: Topic: Ticker channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_periodic(): String = TODO()

    // Exercise 3: fixedRate
    // TODO: Implement fixedRate for concurrency/streaming.
    // TODO: Topic: Ticker channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_fixedRate(): String = TODO()

    // Exercise 4: fixedDelay
    // TODO: Implement fixedDelay for concurrency/streaming.
    // TODO: Topic: Ticker channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_fixedDelay(): String = TODO()

    // Exercise 5: cancel
    // TODO: Implement cancel for concurrency/streaming.
    // TODO: Topic: Ticker channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_cancel(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_ticker().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_periodic().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_fixedRate().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_fixedDelay().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_cancel().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan017_TickerChannel exercises passed!")
    }
}
