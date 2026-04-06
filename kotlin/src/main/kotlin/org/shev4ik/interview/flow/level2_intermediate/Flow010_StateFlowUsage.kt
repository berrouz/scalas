package org.shev4ik.interview.flow.level2_intermediate

/**
 * StateFlow usage
 */
object Flow010_StateFlowUsage {

    // Exercise 1: mutableStateFlow
    // TODO: Implement mutableStateFlow for concurrency/streaming.
    // TODO: Topic: StateFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_mutableStateFlow(): String = TODO()

    // Exercise 2: stateIn
    // TODO: Implement stateIn for concurrency/streaming.
    // TODO: Topic: StateFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_stateIn(): String = TODO()

    // Exercise 3: value
    // TODO: Implement value for concurrency/streaming.
    // TODO: Topic: StateFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_value(): String = TODO()

    // Exercise 4: update
    // TODO: Implement update for concurrency/streaming.
    // TODO: Topic: StateFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_update(): String = TODO()

    // Exercise 5: compareAndSet
    // TODO: Implement compareAndSet for concurrency/streaming.
    // TODO: Topic: StateFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_compareAndSet(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mutableStateFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_stateIn().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_value().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_update().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_compareAndSet() == true) { "Exercise 5 failed" }
        println("All Flow010_StateFlowUsage exercises passed!")
    }
}
