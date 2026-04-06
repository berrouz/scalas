package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Iterating channels
 */
object Chan004_IteratingChannels {

    // Exercise 1: forLoop
    // TODO: Implement forLoop for concurrency/streaming.
    // TODO: Topic: Iterating channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_forLoop(): String = TODO()

    // Exercise 2: consumeEach
    // TODO: Implement consumeEach for concurrency/streaming.
    // TODO: Topic: Iterating channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_consumeEach(): Int = TODO()

    // Exercise 3: receiveCatch
    // TODO: Implement receiveCatch for concurrency/streaming.
    // TODO: Topic: Iterating channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_receiveCatch(): String = TODO()

    // Exercise 4: iterableChannel
    // TODO: Implement iterableChannel for concurrency/streaming.
    // TODO: Topic: Iterating channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_iterableChannel(): String = TODO()

    // Exercise 5: breakIteration
    // TODO: Implement breakIteration for concurrency/streaming.
    // TODO: Topic: Iterating channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_breakIteration(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_forLoop().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_consumeEach()
        assert(exercise3_receiveCatch().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_iterableChannel().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_breakIteration().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan004_IteratingChannels exercises passed!")
    }
}
