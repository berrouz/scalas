package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Test dispatchers
 */
object Coro062_TestDispatchers {

    // Exercise 1: testDispatcher
    // TODO: Implement a coroutine exercise demonstrating testDispatcher.
    // TODO: Use runBlocking to make it testable. Topic: Test dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_testDispatcher(): Boolean = TODO()

    // Exercise 2: advanceTime
    // TODO: Implement a coroutine exercise demonstrating advanceTime.
    // TODO: Use runBlocking to make it testable. Topic: Test dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise2_advanceTime(): String = TODO()

    // Exercise 3: runTest
    // TODO: Implement a coroutine exercise demonstrating runTest.
    // TODO: Use runBlocking to make it testable. Topic: Test dispatchers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_runTest(): Boolean = TODO()

    // Exercise 4: virtualTime
    // TODO: Implement a coroutine exercise demonstrating virtualTime.
    // TODO: Use runBlocking to make it testable. Topic: Test dispatchers.
    // TODO: Return a verifiable result of type String.
    fun exercise4_virtualTime(): String = TODO()

    // Exercise 5: pauseResume
    // TODO: Implement a coroutine exercise demonstrating pauseResume.
    // TODO: Use runBlocking to make it testable. Topic: Test dispatchers.
    // TODO: Return a verifiable result of type Int.
    fun exercise5_pauseResume(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_testDispatcher() == true) { "Exercise 1 failed" }
        assert(exercise2_advanceTime().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_runTest() == true) { "Exercise 3 failed" }
        assert(exercise4_virtualTime().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_pauseResume()
        println("All Coro062_TestDispatchers exercises passed!")
    }
}
