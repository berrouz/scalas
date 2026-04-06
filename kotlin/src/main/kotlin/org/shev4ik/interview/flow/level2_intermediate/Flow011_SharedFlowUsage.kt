package org.shev4ik.interview.flow.level2_intermediate

/**
 * SharedFlow usage
 */
object Flow011_SharedFlowUsage {

    // Exercise 1: mutableSharedFlow
    // TODO: Implement mutableSharedFlow for concurrency/streaming.
    // TODO: Topic: SharedFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_mutableSharedFlow(): String = TODO()

    // Exercise 2: shareIn
    // TODO: Implement shareIn for concurrency/streaming.
    // TODO: Topic: SharedFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_shareIn(): String = TODO()

    // Exercise 3: replay
    // TODO: Implement replay for concurrency/streaming.
    // TODO: Topic: SharedFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_replay(): String = TODO()

    // Exercise 4: buffer
    // TODO: Implement buffer for concurrency/streaming.
    // TODO: Topic: SharedFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_buffer(): String = TODO()

    // Exercise 5: subscriptionCount
    // TODO: Implement subscriptionCount for concurrency/streaming.
    // TODO: Topic: SharedFlow usage.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_subscriptionCount(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mutableSharedFlow().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_shareIn().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_replay().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_buffer().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_subscriptionCount()
        println("All Flow011_SharedFlowUsage exercises passed!")
    }
}
