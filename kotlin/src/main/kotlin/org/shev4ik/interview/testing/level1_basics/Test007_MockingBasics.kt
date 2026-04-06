package org.shev4ik.interview.testing.level1_basics

/**
 * Mocking basics
 */
object Test007_MockingBasics {

    // Exercise 1: createMock
    // TODO: Demonstrate the testing concept: createMock.
    // TODO: Topic: Mocking basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_createMock(): String = TODO()

    // Exercise 2: stubReturn
    // TODO: Demonstrate the testing concept: stubReturn.
    // TODO: Topic: Mocking basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_stubReturn(): String = TODO()

    // Exercise 3: verify
    // TODO: Demonstrate the testing concept: verify.
    // TODO: Topic: Mocking basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_verify(): Boolean = TODO()

    // Exercise 4: verifyOrder
    // TODO: Demonstrate the testing concept: verifyOrder.
    // TODO: Topic: Mocking basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_verifyOrder(): Boolean = TODO()

    // Exercise 5: argumentCapture
    // TODO: Demonstrate the testing concept: argumentCapture.
    // TODO: Topic: Mocking basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_argumentCapture(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createMock().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_stubReturn().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_verify() == true) { "Exercise 3 failed" }
        assert(exercise4_verifyOrder() == true) { "Exercise 4 failed" }
        assert(exercise5_argumentCapture().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test007_MockingBasics exercises passed!")
    }
}
