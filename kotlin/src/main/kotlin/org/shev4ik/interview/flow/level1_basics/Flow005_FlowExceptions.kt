package org.shev4ik.interview.flow.level1_basics

/**
 * Flow exceptions
 */
object Flow005_FlowExceptions {

    // Exercise 1: catch
    // TODO: Implement catch for concurrency/streaming.
    // TODO: Topic: Flow exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_catch(): String = TODO()

    // Exercise 2: onCompletion
    // TODO: Implement onCompletion for concurrency/streaming.
    // TODO: Topic: Flow exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_onCompletion(): String = TODO()

    // Exercise 3: retry
    // TODO: Implement retry for concurrency/streaming.
    // TODO: Topic: Flow exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_retry(): String = TODO()

    // Exercise 4: retryWhen
    // TODO: Implement retryWhen for concurrency/streaming.
    // TODO: Topic: Flow exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_retryWhen(): String = TODO()

    // Exercise 5: transparency
    // TODO: Implement transparency for concurrency/streaming.
    // TODO: Topic: Flow exceptions.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_transparency(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_catch().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_onCompletion().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_retry().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_retryWhen().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_transparency().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow005_FlowExceptions exercises passed!")
    }
}
