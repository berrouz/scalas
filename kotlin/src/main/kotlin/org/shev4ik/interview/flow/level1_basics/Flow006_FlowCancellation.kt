package org.shev4ik.interview.flow.level1_basics

/**
 * Flow cancellation
 */
object Flow006_FlowCancellation {

    // Exercise 1: cancel
    // TODO: Implement cancel for concurrency/streaming.
    // TODO: Topic: Flow cancellation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_cancel(): String = TODO()

    // Exercise 2: ensureActive
    // TODO: Implement ensureActive for concurrency/streaming.
    // TODO: Topic: Flow cancellation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_ensureActive(): String = TODO()

    // Exercise 3: cancellable
    // TODO: Implement cancellable for concurrency/streaming.
    // TODO: Topic: Flow cancellation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_cancellable(): String = TODO()

    // Exercise 4: timeout
    // TODO: Implement timeout for concurrency/streaming.
    // TODO: Topic: Flow cancellation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_timeout(): String = TODO()

    // Exercise 5: cooperative
    // TODO: Implement cooperative for concurrency/streaming.
    // TODO: Topic: Flow cancellation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_cooperative(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cancel().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_ensureActive().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_cancellable().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_timeout().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_cooperative().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow006_FlowCancellation exercises passed!")
    }
}
