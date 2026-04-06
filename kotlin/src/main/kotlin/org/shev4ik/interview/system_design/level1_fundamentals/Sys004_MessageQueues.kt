package org.shev4ik.interview.system_design.level1_fundamentals

/**
 * Message queues
 */
object Sys004_MessageQueues {

    // Exercise 1: pubSub
    // TODO: Model the pubSub concept.
    // TODO: Topic: Message queues.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_pubSub(): String = TODO()

    // Exercise 2: pointToPoint
    // TODO: Model the pointToPoint concept.
    // TODO: Topic: Message queues.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_pointToPoint(): String = TODO()

    // Exercise 3: ordering
    // TODO: Model the ordering concept.
    // TODO: Topic: Message queues.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_ordering(): List<Int> = TODO()

    // Exercise 4: backpressure
    // TODO: Model the backpressure concept.
    // TODO: Topic: Message queues.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_backpressure(): String = TODO()

    // Exercise 5: dlq
    // TODO: Model the dlq concept.
    // TODO: Topic: Message queues.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_dlq(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_pubSub().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_pointToPoint().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_ordering().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_backpressure().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_dlq().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sys004_MessageQueues exercises passed!")
    }
}
