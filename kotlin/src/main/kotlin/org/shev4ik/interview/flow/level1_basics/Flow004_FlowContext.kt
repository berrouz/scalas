package org.shev4ik.interview.flow.level1_basics

/**
 * Flow context
 */
object Flow004_FlowContext {

    // Exercise 1: flowOn
    // TODO: Implement flowOn for concurrency/streaming.
    // TODO: Topic: Flow context.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_flowOn(): String = TODO()

    // Exercise 2: contextPreserve
    // TODO: Implement contextPreserve for concurrency/streaming.
    // TODO: Topic: Flow context.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_contextPreserve(): String = TODO()

    // Exercise 3: dispatcherSwitch
    // TODO: Implement dispatcherSwitch for concurrency/streaming.
    // TODO: Topic: Flow context.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_dispatcherSwitch(): Boolean = TODO()

    // Exercise 4: launchIn
    // TODO: Implement launchIn for concurrency/streaming.
    // TODO: Topic: Flow context.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_launchIn(): String = TODO()

    // Exercise 5: scope
    // TODO: Implement scope for concurrency/streaming.
    // TODO: Topic: Flow context.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_scope(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flowOn().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_contextPreserve().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_dispatcherSwitch() == true) { "Exercise 3 failed" }
        assert(exercise4_launchIn().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_scope().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow004_FlowContext exercises passed!")
    }
}
