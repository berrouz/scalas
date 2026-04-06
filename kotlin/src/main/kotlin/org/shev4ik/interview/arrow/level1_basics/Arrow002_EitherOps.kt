package org.shev4ik.interview.arrow.level1_basics

/**
 * Either operations
 */
object Arrow002_EitherOps {

    // Exercise 1: flatMap
    // TODO: Using Arrow library, implement flatMap.
    // TODO: Topic: Either operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_flatMap(): Map<String, Int> = TODO()

    // Exercise 2: mapLeft
    // TODO: Using Arrow library, implement mapLeft.
    // TODO: Topic: Either operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_mapLeft(): Map<String, Int> = TODO()

    // Exercise 3: orElse
    // TODO: Using Arrow library, implement orElse.
    // TODO: Topic: Either operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_orElse(): String = TODO()

    // Exercise 4: swap
    // TODO: Using Arrow library, implement swap.
    // TODO: Topic: Either operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_swap(): String = TODO()

    // Exercise 5: bimap
    // TODO: Using Arrow library, implement bimap.
    // TODO: Topic: Either operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_bimap(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flatMap().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_mapLeft().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_orElse().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_swap().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_bimap().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow002_EitherOps exercises passed!")
    }
}
