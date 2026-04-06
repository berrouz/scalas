package org.shev4ik.interview.arrow.level1_basics

/**
 * Validated basics
 */
object Arrow005_ValidatedBasics {

    // Exercise 1: valid
    // TODO: Using Arrow library, implement valid.
    // TODO: Topic: Validated basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_valid(): Boolean = TODO()

    // Exercise 2: invalid
    // TODO: Using Arrow library, implement invalid.
    // TODO: Topic: Validated basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_invalid(): Boolean = TODO()

    // Exercise 3: mapLeft
    // TODO: Using Arrow library, implement mapLeft.
    // TODO: Topic: Validated basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_mapLeft(): Map<String, Int> = TODO()

    // Exercise 4: map
    // TODO: Using Arrow library, implement map.
    // TODO: Topic: Validated basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_map(): Map<String, Int> = TODO()

    // Exercise 5: toEither
    // TODO: Using Arrow library, implement toEither.
    // TODO: Topic: Validated basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_toEither(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_valid() == true) { "Exercise 1 failed" }
        assert(exercise2_invalid() == true) { "Exercise 2 failed" }
        assert(exercise3_mapLeft().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_map().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_toEither().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow005_ValidatedBasics exercises passed!")
    }
}
