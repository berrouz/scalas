package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * Profunctor concepts
 */
object Fp032_Profunctors {

    // Exercise 1: dimap
    // TODO: Implement the functional programming concept: dimap.
    // TODO: Topic: Profunctor concepts.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_dimap(): Map<String, Int> = TODO()

    // Exercise 2: lmap
    // TODO: Implement the functional programming concept: lmap.
    // TODO: Topic: Profunctor concepts.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_lmap(): Map<String, Int> = TODO()

    // Exercise 3: rmap
    // TODO: Implement the functional programming concept: rmap.
    // TODO: Topic: Profunctor concepts.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_rmap(): Map<String, Int> = TODO()

    // Exercise 4: star
    // TODO: Implement the functional programming concept: star.
    // TODO: Topic: Profunctor concepts.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_star(): String = TODO()

    // Exercise 5: costar
    // TODO: Implement the functional programming concept: costar.
    // TODO: Topic: Profunctor concepts.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_costar(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_dimap().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_lmap().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_rmap().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_star().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_costar()
        println("All Fp032_Profunctors exercises passed!")
    }
}
