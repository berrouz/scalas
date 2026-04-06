package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Select on send
 */
object Chan016_SelectOnSend {

    // Exercise 1: onSend
    // TODO: Implement onSend for concurrency/streaming.
    // TODO: Topic: Select on send.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_onSend(): String = TODO()

    // Exercise 2: tryOffers
    // TODO: Implement tryOffers for concurrency/streaming.
    // TODO: Topic: Select on send.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_tryOffers(): String = TODO()

    // Exercise 3: alternative
    // TODO: Implement alternative for concurrency/streaming.
    // TODO: Topic: Select on send.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_alternative(): String = TODO()

    // Exercise 4: capacity
    // TODO: Implement capacity for concurrency/streaming.
    // TODO: Topic: Select on send.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_capacity(): Int = TODO()

    // Exercise 5: backpressure
    // TODO: Implement backpressure for concurrency/streaming.
    // TODO: Topic: Select on send.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_backpressure(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_onSend().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_tryOffers().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_alternative().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_capacity()
        assert(exercise5_backpressure().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan016_SelectOnSend exercises passed!")
    }
}
