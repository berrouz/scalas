package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Pipeline pattern
 */
object Chan012_PipelinePattern {

    // Exercise 1: stages
    // TODO: Implement stages for concurrency/streaming.
    // TODO: Topic: Pipeline pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_stages(): String = TODO()

    // Exercise 2: filtering
    // TODO: Implement filtering for concurrency/streaming.
    // TODO: Topic: Pipeline pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_filtering(): List<Int> = TODO()

    // Exercise 3: mapping
    // TODO: Implement mapping for concurrency/streaming.
    // TODO: Topic: Pipeline pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_mapping(): Map<String, Int> = TODO()

    // Exercise 4: reducing
    // TODO: Implement reducing for concurrency/streaming.
    // TODO: Topic: Pipeline pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_reducing(): String = TODO()

    // Exercise 5: errorHandling
    // TODO: Implement errorHandling for concurrency/streaming.
    // TODO: Topic: Pipeline pattern.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_errorHandling(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_stages().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_filtering().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_mapping().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_reducing().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_errorHandling().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan012_PipelinePattern exercises passed!")
    }
}
