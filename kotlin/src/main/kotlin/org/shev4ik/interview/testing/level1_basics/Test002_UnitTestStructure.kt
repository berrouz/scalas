package org.shev4ik.interview.testing.level1_basics

/**
 * Unit test structure
 */
object Test002_UnitTestStructure {

    // Exercise 1: arrange
    // TODO: Demonstrate the testing concept: arrange.
    // TODO: Topic: Unit test structure.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_arrange(): String = TODO()

    // Exercise 2: act
    // TODO: Demonstrate the testing concept: act.
    // TODO: Topic: Unit test structure.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_act(): String = TODO()

    // Exercise 3: assert_step
    // TODO: Demonstrate the testing concept: assert step.
    // TODO: Topic: Unit test structure.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_assert_step(): String = TODO()

    // Exercise 4: givenWhenThen
    // TODO: Demonstrate the testing concept: givenWhenThen.
    // TODO: Topic: Unit test structure.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_givenWhenThen(): String = TODO()

    // Exercise 5: testNaming
    // TODO: Demonstrate the testing concept: testNaming.
    // TODO: Topic: Unit test structure.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_testNaming(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_arrange().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_act().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_assert_step().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_givenWhenThen().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_testNaming() == true) { "Exercise 5 failed" }
        println("All Test002_UnitTestStructure exercises passed!")
    }
}
