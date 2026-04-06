package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * Functor pattern
 */
object Fp008_Functor {

    // Exercise 1: map
    // TODO: Implement the functional programming concept: map.
    // TODO: Topic: Functor pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_map(): Map<String, Int> = TODO()

    // Exercise 2: laws
    // TODO: Implement the functional programming concept: laws.
    // TODO: Topic: Functor pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_laws(): String = TODO()

    // Exercise 3: identity
    // TODO: Implement the functional programming concept: identity.
    // TODO: Topic: Functor pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_identity(): String = TODO()

    // Exercise 4: composition
    // TODO: Implement the functional programming concept: composition.
    // TODO: Topic: Functor pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_composition(): Int = TODO()

    // Exercise 5: lifting
    // TODO: Implement the functional programming concept: lifting.
    // TODO: Topic: Functor pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_lifting(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_map().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_laws().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_identity().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_composition()
        assert(exercise5_lifting().isNotEmpty()) { "Exercise 5 failed" }
        println("All Fp008_Functor exercises passed!")
    }
}
