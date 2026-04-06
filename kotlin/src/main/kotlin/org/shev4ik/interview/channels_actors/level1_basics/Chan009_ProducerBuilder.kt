package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Producer builder
 */
object Chan009_ProducerBuilder {

    // Exercise 1: produce
    // TODO: Implement produce for concurrency/streaming.
    // TODO: Topic: Producer builder.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_produce(): String = TODO()

    // Exercise 2: capacity
    // TODO: Implement capacity for concurrency/streaming.
    // TODO: Topic: Producer builder.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_capacity(): Int = TODO()

    // Exercise 3: cancel
    // TODO: Implement cancel for concurrency/streaming.
    // TODO: Topic: Producer builder.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_cancel(): String = TODO()

    // Exercise 4: close
    // TODO: Implement close for concurrency/streaming.
    // TODO: Topic: Producer builder.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_close(): String = TODO()

    // Exercise 5: scope
    // TODO: Implement scope for concurrency/streaming.
    // TODO: Topic: Producer builder.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_scope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_produce().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_capacity()
        assert(exercise3_cancel().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_close().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_scope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan009_ProducerBuilder exercises passed!")
    }
}
