package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * CSP patterns
 */
object Chan019_CSPPatterns {

    // Exercise 1: communicating
    // TODO: Implement communicating for concurrency/streaming.
    // TODO: Topic: CSP patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_communicating(): String = TODO()

    // Exercise 2: sequential
    // TODO: Implement sequential for concurrency/streaming.
    // TODO: Topic: CSP patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_sequential(): String = TODO()

    // Exercise 3: guarded
    // TODO: Implement guarded for concurrency/streaming.
    // TODO: Topic: CSP patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_guarded(): String = TODO()

    // Exercise 4: alternative
    // TODO: Implement alternative for concurrency/streaming.
    // TODO: Topic: CSP patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_alternative(): String = TODO()

    // Exercise 5: parallel
    // TODO: Implement parallel for concurrency/streaming.
    // TODO: Topic: CSP patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_parallel(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_communicating().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_sequential().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_guarded().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_alternative().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_parallel().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan019_CSPPatterns exercises passed!")
    }
}
