package org.shev4ik.interview.flow.level2_intermediate

/**
 * Flat mapping
 */
object Flow008_FlatMapping {

    // Exercise 1: flatMapConcat
    // TODO: Implement flatMapConcat for concurrency/streaming.
    // TODO: Topic: Flat mapping.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_flatMapConcat(): Map<String, Int> = TODO()

    // Exercise 2: flatMapMerge
    // TODO: Implement flatMapMerge for concurrency/streaming.
    // TODO: Topic: Flat mapping.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_flatMapMerge(): List<Int> = TODO()

    // Exercise 3: flatMapLatest
    // TODO: Implement flatMapLatest for concurrency/streaming.
    // TODO: Topic: Flat mapping.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_flatMapLatest(): Boolean = TODO()

    // Exercise 4: concurrency
    // TODO: Implement concurrency for concurrency/streaming.
    // TODO: Topic: Flat mapping.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_concurrency(): String = TODO()

    // Exercise 5: ordering
    // TODO: Implement ordering for concurrency/streaming.
    // TODO: Topic: Flat mapping.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_ordering(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flatMapConcat().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flatMapMerge().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_flatMapLatest() == true) { "Exercise 3 failed" }
        assert(exercise4_concurrency().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_ordering().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow008_FlatMapping exercises passed!")
    }
}
