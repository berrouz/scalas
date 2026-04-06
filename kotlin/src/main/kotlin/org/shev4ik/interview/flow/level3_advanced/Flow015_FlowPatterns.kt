package org.shev4ik.interview.flow.level3_advanced

/**
 * Real-world Flow patterns
 */
object Flow015_FlowPatterns {

    // Exercise 1: pagination
    // TODO: Implement pagination for concurrency/streaming.
    // TODO: Topic: Real-world Flow patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_pagination(): String = TODO()

    // Exercise 2: polling
    // TODO: Implement polling for concurrency/streaming.
    // TODO: Topic: Real-world Flow patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_polling(): String = TODO()

    // Exercise 3: retry
    // TODO: Implement retry for concurrency/streaming.
    // TODO: Topic: Real-world Flow patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_retry(): String = TODO()

    // Exercise 4: cache
    // TODO: Implement cache for concurrency/streaming.
    // TODO: Topic: Real-world Flow patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_cache(): String = TODO()

    // Exercise 5: eventStream
    // TODO: Implement eventStream for concurrency/streaming.
    // TODO: Topic: Real-world Flow patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_eventStream(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_pagination().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_polling().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_retry().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_cache().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_eventStream().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow015_FlowPatterns exercises passed!")
    }
}
