package org.shev4ik.interview.testing.level1_basics

/**
 * Exception testing
 */
object Test006_ExceptionTesting {

    // Exercise 1: assertThrows
    // TODO: Demonstrate the testing concept: assertThrows.
    // TODO: Topic: Exception testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_assertThrows(): String = TODO()

    // Exercise 2: expectedException
    // TODO: Demonstrate the testing concept: expectedException.
    // TODO: Topic: Exception testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_expectedException(): String = TODO()

    // Exercise 3: exceptionMessage
    // TODO: Demonstrate the testing concept: exceptionMessage.
    // TODO: Topic: Exception testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_exceptionMessage(): String = TODO()

    // Exercise 4: customException
    // TODO: Demonstrate the testing concept: customException.
    // TODO: Topic: Exception testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_customException(): String = TODO()

    // Exercise 5: exceptionType
    // TODO: Demonstrate the testing concept: exceptionType.
    // TODO: Topic: Exception testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_exceptionType(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_assertThrows().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_expectedException().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_exceptionMessage().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_customException().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_exceptionType().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test006_ExceptionTesting exercises passed!")
    }
}
