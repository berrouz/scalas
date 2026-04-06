package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow scan operators
 */
object Coro067_FlowScan {

    // Exercise 1: scan
    // TODO: Implement a coroutine exercise demonstrating scan.
    // TODO: Use runBlocking to make it testable. Topic: Flow scan operators.
    // TODO: Return a verifiable result of type String.
    fun exercise1_scan(): String = TODO()

    // Exercise 2: runningFold
    // TODO: Implement a coroutine exercise demonstrating runningFold.
    // TODO: Use runBlocking to make it testable. Topic: Flow scan operators.
    // TODO: Return a verifiable result of type String.
    fun exercise2_runningFold(): String = TODO()

    // Exercise 3: runningReduce
    // TODO: Implement a coroutine exercise demonstrating runningReduce.
    // TODO: Use runBlocking to make it testable. Topic: Flow scan operators.
    // TODO: Return a verifiable result of type String.
    fun exercise3_runningReduce(): String = TODO()

    // Exercise 4: accumulate
    // TODO: Implement a coroutine exercise demonstrating accumulate.
    // TODO: Use runBlocking to make it testable. Topic: Flow scan operators.
    // TODO: Return a verifiable result of type String.
    fun exercise4_accumulate(): String = TODO()

    // Exercise 5: stateAccumulation
    // TODO: Implement a coroutine exercise demonstrating stateAccumulation.
    // TODO: Use runBlocking to make it testable. Topic: Flow scan operators.
    // TODO: Return a verifiable result of type String.
    fun exercise5_stateAccumulation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_scan().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_runningFold().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_runningReduce().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_accumulate().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_stateAccumulation().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro067_FlowScan exercises passed!")
    }
}
