package org.shev4ik.interview.testing.level3_advanced

/**
 * Integration testing
 */
object Test016_IntegrationTesting {

    // Exercise 1: testContainers
    // TODO: Demonstrate the testing concept: testContainers.
    // TODO: Topic: Integration testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_testContainers(): Boolean = TODO()

    // Exercise 2: database
    // TODO: Demonstrate the testing concept: database.
    // TODO: Topic: Integration testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_database(): String = TODO()

    // Exercise 3: httpClient
    // TODO: Demonstrate the testing concept: httpClient.
    // TODO: Topic: Integration testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_httpClient(): String = TODO()

    // Exercise 4: messageQueue
    // TODO: Demonstrate the testing concept: messageQueue.
    // TODO: Topic: Integration testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_messageQueue(): String = TODO()

    // Exercise 5: endToEnd
    // TODO: Demonstrate the testing concept: endToEnd.
    // TODO: Topic: Integration testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_endToEnd(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_testContainers() == true) { "Exercise 1 failed" }
        assert(exercise2_database().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_httpClient().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_messageQueue().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_endToEnd().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test016_IntegrationTesting exercises passed!")
    }
}
