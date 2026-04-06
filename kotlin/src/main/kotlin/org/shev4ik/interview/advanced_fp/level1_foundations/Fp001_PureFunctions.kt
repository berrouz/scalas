package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * Pure functions
 */
object Fp001_PureFunctions {

    // Exercise 1: referentialTransparency
    // TODO: Implement the functional programming concept: referentialTransparency.
    // TODO: Topic: Pure functions.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_referentialTransparency(): String = TODO()

    // Exercise 2: sideEffects
    // TODO: Implement the functional programming concept: sideEffects.
    // TODO: Topic: Pure functions.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_sideEffects(): String = TODO()

    // Exercise 3: substitution
    // TODO: Implement the functional programming concept: substitution.
    // TODO: Topic: Pure functions.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_substitution(): String = TODO()

    // Exercise 4: testability
    // TODO: Implement the functional programming concept: testability.
    // TODO: Topic: Pure functions.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_testability(): Boolean = TODO()

    // Exercise 5: composition
    // TODO: Implement the functional programming concept: composition.
    // TODO: Topic: Pure functions.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_composition(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_referentialTransparency().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_sideEffects().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_substitution().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_testability() == true) { "Exercise 4 failed" }
        exercise5_composition()
        println("All Fp001_PureFunctions exercises passed!")
    }
}
