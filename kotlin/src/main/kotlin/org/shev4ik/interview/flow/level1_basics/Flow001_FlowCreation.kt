package org.shev4ik.interview.flow.level1_basics

/**
 * Flow creation
 */
object Flow001_FlowCreation {

    // Exercise 1: flowBuilder
    // TODO: Implement flowBuilder for concurrency/streaming.
    // TODO: Topic: Flow creation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_flowBuilder(): String = TODO()

    // Exercise 2: flowOf
    // TODO: Implement flowOf for concurrency/streaming.
    // TODO: Topic: Flow creation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_flowOf(): String = TODO()

    // Exercise 3: asFlow
    // TODO: Implement asFlow for concurrency/streaming.
    // TODO: Topic: Flow creation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_asFlow(): String = TODO()

    // Exercise 4: emptyFlow
    // TODO: Implement emptyFlow for concurrency/streaming.
    // TODO: Topic: Flow creation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_emptyFlow(): String = TODO()

    // Exercise 5: channelFlow
    // TODO: Implement channelFlow for concurrency/streaming.
    // TODO: Topic: Flow creation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_channelFlow(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flowBuilder().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flowOf().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_asFlow().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_emptyFlow().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_channelFlow().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow001_FlowCreation exercises passed!")
    }
}
