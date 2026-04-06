package org.shev4ik.interview.flow.level2_intermediate

/**
 * Combining flows
 */
object Flow007_CombiningFlows {

    // Exercise 1: combine
    // TODO: Implement combine for concurrency/streaming.
    // TODO: Topic: Combining flows.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_combine(): List<Int> = TODO()

    // Exercise 2: merge
    // TODO: Implement merge for concurrency/streaming.
    // TODO: Topic: Combining flows.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_merge(): List<Int> = TODO()

    // Exercise 3: zip
    // TODO: Implement zip for concurrency/streaming.
    // TODO: Topic: Combining flows.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_zip(): String = TODO()

    // Exercise 4: flattenConcat
    // TODO: Implement flattenConcat for concurrency/streaming.
    // TODO: Topic: Combining flows.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_flattenConcat(): String = TODO()

    // Exercise 5: flattenMerge
    // TODO: Implement flattenMerge for concurrency/streaming.
    // TODO: Topic: Combining flows.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_flattenMerge(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_combine().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_merge().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_zip().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_flattenConcat().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_flattenMerge().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow007_CombiningFlows exercises passed!")
    }
}
