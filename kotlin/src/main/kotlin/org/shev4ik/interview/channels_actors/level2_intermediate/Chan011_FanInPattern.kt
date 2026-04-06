package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Fan-in pattern
 */
object Chan011_FanInPattern {

    // Exercise 1: multiProducer
    // TODO: Implement multiProducer for concurrency/streaming.
    // TODO: Topic: Fan-in pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_multiProducer(): String = TODO()

    // Exercise 2: merge
    // TODO: Implement merge for concurrency/streaming.
    // TODO: Topic: Fan-in pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_merge(): List<Int> = TODO()

    // Exercise 3: priority
    // TODO: Implement priority for concurrency/streaming.
    // TODO: Topic: Fan-in pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_priority(): String = TODO()

    // Exercise 4: ordered
    // TODO: Implement ordered for concurrency/streaming.
    // TODO: Topic: Fan-in pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_ordered(): List<Int> = TODO()

    // Exercise 5: buffered
    // TODO: Implement buffered for concurrency/streaming.
    // TODO: Topic: Fan-in pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_buffered(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_multiProducer().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_merge().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_priority().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_ordered().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_buffered().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan011_FanInPattern exercises passed!")
    }
}
