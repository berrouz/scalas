package org.shev4ik.interview.flow.level2_intermediate

/**
 * Buffering
 */
object Flow009_Buffering {

    // Exercise 1: buffer
    // TODO: Implement buffer for concurrency/streaming.
    // TODO: Topic: Buffering.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_buffer(): String = TODO()

    // Exercise 2: conflate
    // TODO: Implement conflate for concurrency/streaming.
    // TODO: Topic: Buffering.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_conflate(): String = TODO()

    // Exercise 3: collectLatest
    // TODO: Implement collectLatest for concurrency/streaming.
    // TODO: Topic: Buffering.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_collectLatest(): Boolean = TODO()

    // Exercise 4: overflow
    // TODO: Implement overflow for concurrency/streaming.
    // TODO: Topic: Buffering.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_overflow(): String = TODO()

    // Exercise 5: capacity
    // TODO: Implement capacity for concurrency/streaming.
    // TODO: Topic: Buffering.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_capacity(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_buffer().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_conflate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_collectLatest() == true) { "Exercise 3 failed" }
        assert(exercise4_overflow().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_capacity()
        println("All Flow009_Buffering exercises passed!")
    }
}
