package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Testing suspend functions
 */
object Coro064_SuspendTesting {

    // Exercise 1: testSuspend
    // TODO: Implement a coroutine exercise demonstrating testSuspend.
    // TODO: Use runBlocking to make it testable. Topic: Testing suspend functions.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_testSuspend(): Boolean = TODO()

    // Exercise 2: runTestPattern
    // TODO: Implement a coroutine exercise demonstrating runTestPattern.
    // TODO: Use runBlocking to make it testable. Topic: Testing suspend functions.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_runTestPattern(): Boolean = TODO()

    // Exercise 3: delayTesting
    // TODO: Implement a coroutine exercise demonstrating delayTesting.
    // TODO: Use runBlocking to make it testable. Topic: Testing suspend functions.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_delayTesting(): Boolean = TODO()

    // Exercise 4: exceptionTesting
    // TODO: Implement a coroutine exercise demonstrating exceptionTesting.
    // TODO: Use runBlocking to make it testable. Topic: Testing suspend functions.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_exceptionTesting(): Boolean = TODO()

    // Exercise 5: timeoutTesting
    // TODO: Implement a coroutine exercise demonstrating timeoutTesting.
    // TODO: Use runBlocking to make it testable. Topic: Testing suspend functions.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_timeoutTesting(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_testSuspend() == true) { "Exercise 1 failed" }
        assert(exercise2_runTestPattern() == true) { "Exercise 2 failed" }
        assert(exercise3_delayTesting() == true) { "Exercise 3 failed" }
        assert(exercise4_exceptionTesting() == true) { "Exercise 4 failed" }
        assert(exercise5_timeoutTesting() == true) { "Exercise 5 failed" }
        println("All Coro064_SuspendTesting exercises passed!")
    }
}
