package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow testing
 */
object Coro061_FlowTesting {

    // Exercise 1: testFlow
    // TODO: Implement a coroutine exercise demonstrating testFlow.
    // TODO: Use runBlocking to make it testable. Topic: Flow testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_testFlow(): Boolean = TODO()

    // Exercise 2: testCollect
    // TODO: Implement a coroutine exercise demonstrating testCollect.
    // TODO: Use runBlocking to make it testable. Topic: Flow testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_testCollect(): Boolean = TODO()

    // Exercise 3: turbineConcept
    // TODO: Implement a coroutine exercise demonstrating turbineConcept.
    // TODO: Use runBlocking to make it testable. Topic: Flow testing.
    // TODO: Return a verifiable result of type String.
    fun exercise3_turbineConcept(): String = TODO()

    // Exercise 4: awaitItem
    // TODO: Implement a coroutine exercise demonstrating awaitItem.
    // TODO: Use runBlocking to make it testable. Topic: Flow testing.
    // TODO: Return a verifiable result of type String.
    fun exercise4_awaitItem(): String = TODO()

    // Exercise 5: testTimeout
    // TODO: Implement a coroutine exercise demonstrating testTimeout.
    // TODO: Use runBlocking to make it testable. Topic: Flow testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_testTimeout(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_testFlow() == true) { "Exercise 1 failed" }
        assert(exercise2_testCollect() == true) { "Exercise 2 failed" }
        assert(exercise3_turbineConcept().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_awaitItem().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_testTimeout() == true) { "Exercise 5 failed" }
        println("All Coro061_FlowTesting exercises passed!")
    }
}
