package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Buffered channels
 */
object Chan005_BufferedChannels {

    // Exercise 1: buffered
    // TODO: Implement buffered for concurrency/streaming.
    // TODO: Topic: Buffered channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_buffered(): String = TODO()

    // Exercise 2: bufferSize
    // TODO: Implement bufferSize for concurrency/streaming.
    // TODO: Topic: Buffered channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_bufferSize(): Int = TODO()

    // Exercise 3: bufferOverflow
    // TODO: Implement bufferOverflow for concurrency/streaming.
    // TODO: Topic: Buffered channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_bufferOverflow(): String = TODO()

    // Exercise 4: suspend
    // TODO: Implement suspend for concurrency/streaming.
    // TODO: Topic: Buffered channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_suspend(): String = TODO()

    // Exercise 5: drop
    // TODO: Implement drop for concurrency/streaming.
    // TODO: Topic: Buffered channels.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_drop(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_buffered().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_bufferSize()
        assert(exercise3_bufferOverflow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_suspend().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_drop().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan005_BufferedChannels exercises passed!")
    }
}
