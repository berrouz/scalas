package org.shev4ik.interview.testing.level2_intermediate

/**
 * Property-based testing
 */
object Test013_KotestProperties {

    // Exercise 1: forAll
    // TODO: Demonstrate the testing concept: forAll.
    // TODO: Topic: Property-based testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise1_forAll(): List<Int> = TODO()

    // Exercise 2: checkAll
    // TODO: Demonstrate the testing concept: checkAll.
    // TODO: Topic: Property-based testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise2_checkAll(): Boolean = TODO()

    // Exercise 3: arbitrary
    // TODO: Demonstrate the testing concept: arbitrary.
    // TODO: Topic: Property-based testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise3_arbitrary(): String = TODO()

    // Exercise 4: shrinker
    // TODO: Demonstrate the testing concept: shrinker.
    // TODO: Topic: Property-based testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise4_shrinker(): String = TODO()

    // Exercise 5: edgeCases
    // TODO: Demonstrate the testing concept: edgeCases.
    // TODO: Topic: Property-based testing.
    // TODO: Create a testable function or pattern. Return a verifiable result.
    fun exercise5_edgeCases(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_forAll().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_checkAll() == true) { "Exercise 2 failed" }
        assert(exercise3_arbitrary().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_shrinker().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_edgeCases().isNotEmpty()) { "Exercise 5 failed" }
        println("All Test013_KotestProperties exercises passed!")
    }
}
