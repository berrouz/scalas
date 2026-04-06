package org.shev4ik.interview.testing.level1_basics

/**
 * Assertion basics
 */
object Test001_AssertBasics {

    // Exercise 1: assertBasic
    // TODO: Demonstrate the testing concept: assertBasic.
    // TODO: Topic: Assertion basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_assertBasic(): String = TODO()

    // Exercise 2: assertEquals
    // TODO: Demonstrate the testing concept: assertEquals.
    // TODO: Topic: Assertion basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_assertEquals(): Boolean = TODO()

    // Exercise 3: assertTrue
    // TODO: Demonstrate the testing concept: assertTrue.
    // TODO: Topic: Assertion basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_assertTrue(): String = TODO()

    // Exercise 4: assertNotNull
    // TODO: Demonstrate the testing concept: assertNotNull.
    // TODO: Topic: Assertion basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_assertNotNull(): String = TODO()

    // Exercise 5: assertThrows
    // TODO: Demonstrate the testing concept: assertThrows.
    // TODO: Topic: Assertion basics.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_assertThrows(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_assertBasic().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_assertEquals() == true) { "Exercise 2 failed" }
        assert(exercise3_assertTrue().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_assertNotNull().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_assertThrows().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test001_AssertBasics exercises passed!")
    }
}
