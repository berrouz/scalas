package org.shev4ik.interview.flow.level1_basics

/**
 * Map and filter
 */
object Flow003_MapAndFilter {

    // Exercise 1: map
    // TODO: Implement map for concurrency/streaming.
    // TODO: Topic: Map and filter.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_map(): Map<String, Int> = TODO()

    // Exercise 2: filter
    // TODO: Implement filter for concurrency/streaming.
    // TODO: Topic: Map and filter.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_filter(): List<Int> = TODO()

    // Exercise 3: transform
    // TODO: Implement transform for concurrency/streaming.
    // TODO: Topic: Map and filter.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_transform(): String = TODO()

    // Exercise 4: filterNot
    // TODO: Implement filterNot for concurrency/streaming.
    // TODO: Topic: Map and filter.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_filterNot(): List<Int> = TODO()

    // Exercise 5: mapNotNull
    // TODO: Implement mapNotNull for concurrency/streaming.
    // TODO: Topic: Map and filter.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_mapNotNull(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_map().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_filter().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_transform().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_filterNot().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_mapNotNull().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow003_MapAndFilter exercises passed!")
    }
}
