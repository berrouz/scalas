package org.shev4ik.interview.channels_actors.level1_basics

/**
 * Fan-out pattern
 */
object Chan010_FanOutBasics {

    // Exercise 1: multiConsumer
    // TODO: Implement multiConsumer for concurrency/streaming.
    // TODO: Topic: Fan-out pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_multiConsumer(): Int = TODO()

    // Exercise 2: fairDistribution
    // TODO: Implement fairDistribution for concurrency/streaming.
    // TODO: Topic: Fan-out pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_fairDistribution(): Boolean = TODO()

    // Exercise 3: loadBalance
    // TODO: Implement loadBalance for concurrency/streaming.
    // TODO: Topic: Fan-out pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_loadBalance(): String = TODO()

    // Exercise 4: partitioned
    // TODO: Implement partitioned for concurrency/streaming.
    // TODO: Topic: Fan-out pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_partitioned(): Pair<Int, Int> = TODO()

    // Exercise 5: ordered
    // TODO: Implement ordered for concurrency/streaming.
    // TODO: Topic: Fan-out pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_ordered(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_multiConsumer()
        assert(exercise2_fairDistribution() == true) { "Exercise 2 failed" }
        assert(exercise3_loadBalance().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_partitioned()
        assert(exercise5_ordered().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan010_FanOutBasics exercises passed!")
    }
}
