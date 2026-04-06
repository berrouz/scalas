package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * TestScope
 */
object Coro063_TestScope {

    // Exercise 1: testScope
    // TODO: Implement a coroutine exercise demonstrating testScope.
    // TODO: Use runBlocking to make it testable. Topic: TestScope.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_testScope(): Boolean = TODO()

    // Exercise 2: currentTime
    // TODO: Implement a coroutine exercise demonstrating currentTime.
    // TODO: Use runBlocking to make it testable. Topic: TestScope.
    // TODO: Return a verifiable result of type String.
    fun exercise2_currentTime(): String = TODO()

    // Exercise 3: advanceUntilIdle
    // TODO: Implement a coroutine exercise demonstrating advanceUntilIdle.
    // TODO: Use runBlocking to make it testable. Topic: TestScope.
    // TODO: Return a verifiable result of type String.
    fun exercise3_advanceUntilIdle(): String = TODO()

    // Exercise 4: backgroundScope
    // TODO: Implement a coroutine exercise demonstrating backgroundScope.
    // TODO: Use runBlocking to make it testable. Topic: TestScope.
    // TODO: Return a verifiable result of type String.
    fun exercise4_backgroundScope(): String = TODO()

    // Exercise 5: testScheduler
    // TODO: Implement a coroutine exercise demonstrating testScheduler.
    // TODO: Use runBlocking to make it testable. Topic: TestScope.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_testScheduler(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_testScope() == true) { "Exercise 1 failed" }
        assert(exercise2_currentTime().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_advanceUntilIdle().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_backgroundScope().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_testScheduler() == true) { "Exercise 5 failed" }
        println("All Coro063_TestScope exercises passed!")
    }
}
