package org.shev4ik.interview.channels_actors.level2_intermediate

/**
 * Stateful actors
 */
object Chan014_ActorState {

    // Exercise 1: state
    // TODO: Implement state for concurrency/streaming.
    // TODO: Topic: Stateful actors.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_state(): String = TODO()

    // Exercise 2: accumulate
    // TODO: Implement accumulate for concurrency/streaming.
    // TODO: Topic: Stateful actors.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_accumulate(): String = TODO()

    // Exercise 3: query
    // TODO: Implement query for concurrency/streaming.
    // TODO: Topic: Stateful actors.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_query(): String = TODO()

    // Exercise 4: reset
    // TODO: Implement reset for concurrency/streaming.
    // TODO: Topic: Stateful actors.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_reset(): String = TODO()

    // Exercise 5: snapshot
    // TODO: Implement snapshot for concurrency/streaming.
    // TODO: Topic: Stateful actors.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_snapshot(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_state().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_accumulate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_query().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_reset().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_snapshot().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan014_ActorState exercises passed!")
    }
}
