package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Send and receive
 */
object Chan002_SendReceive {

    // Exercise 1: send
    // TODO: Implement send for concurrency/streaming.
    // TODO: Topic: Send and receive.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_send(): String = TODO()

    // Exercise 2: receive
    // TODO: Implement receive for concurrency/streaming.
    // TODO: Topic: Send and receive.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_receive(): String = TODO()

    // Exercise 3: trySend
    // TODO: Implement trySend for concurrency/streaming.
    // TODO: Topic: Send and receive.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_trySend(): String = TODO()

    // Exercise 4: tryReceive
    // TODO: Implement tryReceive for concurrency/streaming.
    // TODO: Topic: Send and receive.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_tryReceive(): String = TODO()

    // Exercise 5: result
    // TODO: Implement result for concurrency/streaming.
    // TODO: Topic: Send and receive.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_result(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_send().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_receive().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_trySend().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_tryReceive().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_result().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan002_SendReceive exercises passed!")
    }
}
