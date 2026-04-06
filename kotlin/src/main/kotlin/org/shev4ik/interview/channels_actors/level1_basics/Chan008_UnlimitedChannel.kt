package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Unlimited channel
 */
object Chan008_UnlimitedChannel {

    // Exercise 1: unlimited
    // TODO: Implement unlimited for concurrency/streaming.
    // TODO: Topic: Unlimited channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_unlimited(): String = TODO()

    // Exercise 2: noSuspend
    // TODO: Implement noSuspend for concurrency/streaming.
    // TODO: Topic: Unlimited channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_noSuspend(): String = TODO()

    // Exercise 3: memory
    // TODO: Implement memory for concurrency/streaming.
    // TODO: Topic: Unlimited channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_memory(): String = TODO()

    // Exercise 4: backlog
    // TODO: Implement backlog for concurrency/streaming.
    // TODO: Topic: Unlimited channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_backlog(): String = TODO()

    // Exercise 5: drain
    // TODO: Implement drain for concurrency/streaming.
    // TODO: Topic: Unlimited channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_drain(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_unlimited().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_noSuspend().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_memory().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_backlog().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_drain().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan008_UnlimitedChannel exercises passed!")
    }
}
