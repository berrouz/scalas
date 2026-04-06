package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * Broadcast pattern
 */
object Chan022_BroadcastPattern {

    // Exercise 1: broadcastChannel
    // TODO: Implement broadcastChannel for concurrency/streaming.
    // TODO: Topic: Broadcast pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_broadcastChannel(): String = TODO()

    // Exercise 2: sharedFlow
    // TODO: Implement sharedFlow for concurrency/streaming.
    // TODO: Topic: Broadcast pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_sharedFlow(): String = TODO()

    // Exercise 3: multiSubscriber
    // TODO: Implement multiSubscriber for concurrency/streaming.
    // TODO: Topic: Broadcast pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_multiSubscriber(): Boolean = TODO()

    // Exercise 4: replay
    // TODO: Implement replay for concurrency/streaming.
    // TODO: Topic: Broadcast pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_replay(): String = TODO()

    // Exercise 5: conflated
    // TODO: Implement conflated for concurrency/streaming.
    // TODO: Topic: Broadcast pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_conflated(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_broadcastChannel().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_sharedFlow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_multiSubscriber() == true) { "Exercise 3 failed" }
        assert(exercise4_replay().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_conflated().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan022_BroadcastPattern exercises passed!")
    }
}
