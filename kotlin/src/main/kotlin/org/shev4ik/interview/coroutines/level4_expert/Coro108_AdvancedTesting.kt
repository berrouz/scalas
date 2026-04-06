package org.shev4ik.interview.coroutines.level4_expert

/**
 * Advanced testing
 */
object Coro108_AdvancedTesting {

    // Exercise 1: complexScenarios
    // TODO: Implement a coroutine exercise demonstrating complexScenarios.
    // TODO: Use runBlocking to make it testable. Topic: Advanced testing.
    // TODO: Return a verifiable result of type String.
    fun exercise1_complexScenarios(): String = TODO()

    // Exercise 2: timeoutTest
    // TODO: Implement a coroutine exercise demonstrating timeoutTest.
    // TODO: Use runBlocking to make it testable. Topic: Advanced testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_timeoutTest(): Boolean = TODO()

    // Exercise 3: exceptionTest
    // TODO: Implement a coroutine exercise demonstrating exceptionTest.
    // TODO: Use runBlocking to make it testable. Topic: Advanced testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_exceptionTest(): Boolean = TODO()

    // Exercise 4: concurrencyTest
    // TODO: Implement a coroutine exercise demonstrating concurrencyTest.
    // TODO: Use runBlocking to make it testable. Topic: Advanced testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_concurrencyTest(): Boolean = TODO()

    // Exercise 5: integrationTest
    // TODO: Implement a coroutine exercise demonstrating integrationTest.
    // TODO: Use runBlocking to make it testable. Topic: Advanced testing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_integrationTest(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_complexScenarios().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_timeoutTest() == true) { "Exercise 2 failed" }
        assert(exercise3_exceptionTest() == true) { "Exercise 3 failed" }
        assert(exercise4_concurrencyTest() == true) { "Exercise 4 failed" }
        assert(exercise5_integrationTest() == true) { "Exercise 5 failed" }
        println("All Coro108_AdvancedTesting exercises passed!")
    }
}
