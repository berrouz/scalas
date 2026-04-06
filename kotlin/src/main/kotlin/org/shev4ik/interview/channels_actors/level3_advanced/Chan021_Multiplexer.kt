package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * Multiplexer
 */
object Chan021_Multiplexer {

    // Exercise 1: merge
    // TODO: Implement merge for concurrency/streaming.
    // TODO: Topic: Multiplexer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_merge(): List<Int> = TODO()

    // Exercise 2: select
    // TODO: Implement select for concurrency/streaming.
    // TODO: Topic: Multiplexer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_select(): String = TODO()

    // Exercise 3: fanIn
    // TODO: Implement fanIn for concurrency/streaming.
    // TODO: Topic: Multiplexer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_fanIn(): String = TODO()

    // Exercise 4: prioritized
    // TODO: Implement prioritized for concurrency/streaming.
    // TODO: Topic: Multiplexer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_prioritized(): String = TODO()

    // Exercise 5: fairMerge
    // TODO: Implement fairMerge for concurrency/streaming.
    // TODO: Topic: Multiplexer.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_fairMerge(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_merge().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_select().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_fanIn().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_prioritized().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fairMerge().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan021_Multiplexer exercises passed!")
    }
}
