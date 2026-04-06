package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * Monad pattern
 */
object Fp010_Monad {

    // Exercise 1: flatMap
    // TODO: Implement the functional programming concept: flatMap.
    // TODO: Topic: Monad pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_flatMap(): Map<String, Int> = TODO()

    // Exercise 2: laws
    // TODO: Implement the functional programming concept: laws.
    // TODO: Topic: Monad pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_laws(): String = TODO()

    // Exercise 3: leftIdentity
    // TODO: Implement the functional programming concept: leftIdentity.
    // TODO: Topic: Monad pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_leftIdentity(): String = TODO()

    // Exercise 4: rightIdentity
    // TODO: Implement the functional programming concept: rightIdentity.
    // TODO: Topic: Monad pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_rightIdentity(): String = TODO()

    // Exercise 5: associativity
    // TODO: Implement the functional programming concept: associativity.
    // TODO: Topic: Monad pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_associativity(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flatMap().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_laws().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_leftIdentity().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_rightIdentity().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_associativity().isNotEmpty()) { "Exercise 5 failed" }
        println("All Fp010_Monad exercises passed!")
    }
}
