package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Rendezvous channel
 */
object Chan006_RendezvousChannel {

    // Exercise 1: rendezvous
    // TODO: Implement rendezvous for concurrency/streaming.
    // TODO: Topic: Rendezvous channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_rendezvous(): String = TODO()

    // Exercise 2: synchronous
    // TODO: Implement synchronous for concurrency/streaming.
    // TODO: Topic: Rendezvous channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_synchronous(): String = TODO()

    // Exercise 3: handoff
    // TODO: Implement handoff for concurrency/streaming.
    // TODO: Topic: Rendezvous channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_handoff(): String = TODO()

    // Exercise 4: blocking
    // TODO: Implement blocking for concurrency/streaming.
    // TODO: Topic: Rendezvous channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_blocking(): String = TODO()

    // Exercise 5: ordering
    // TODO: Implement ordering for concurrency/streaming.
    // TODO: Topic: Rendezvous channel.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_ordering(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_rendezvous().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_synchronous().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_handoff().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_blocking().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_ordering().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan006_RendezvousChannel exercises passed!")
    }
}
