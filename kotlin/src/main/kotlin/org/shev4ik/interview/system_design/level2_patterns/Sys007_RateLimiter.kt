package org.shev4ik.interview.system_design.level2_patterns

/**
 * Rate limiter design
 */
object Sys007_RateLimiter {

    // Exercise 1: tokenBucket
    // TODO: Model the tokenBucket concept.
    // TODO: Topic: Rate limiter design.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_tokenBucket(): String = TODO()

    // Exercise 2: slidingWindow
    // TODO: Model the slidingWindow concept.
    // TODO: Topic: Rate limiter design.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_slidingWindow(): String = TODO()

    // Exercise 3: fixedWindow
    // TODO: Model the fixedWindow concept.
    // TODO: Topic: Rate limiter design.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_fixedWindow(): String = TODO()

    // Exercise 4: leakyBucket
    // TODO: Model the leakyBucket concept.
    // TODO: Topic: Rate limiter design.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_leakyBucket(): String = TODO()

    // Exercise 5: distributed
    // TODO: Model the distributed concept.
    // TODO: Topic: Rate limiter design.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_distributed(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tokenBucket().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_slidingWindow().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_fixedWindow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_leakyBucket().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_distributed() == true) { "Exercise 5 failed" }
        println("All Sys007_RateLimiter exercises passed!")
    }
}
