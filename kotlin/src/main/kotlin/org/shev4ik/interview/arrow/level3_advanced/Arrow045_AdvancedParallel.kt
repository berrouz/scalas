package org.shev4ik.interview.arrow.level3_advanced

/**
 * Advanced parallel
 */
object Arrow045_AdvancedParallel {

    // Exercise 1: parTraverse
    // TODO: Using Arrow library, implement parTraverse.
    // TODO: Topic: Advanced parallel.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_parTraverse(): List<Int> = TODO()

    // Exercise 2: parSequence
    // TODO: Using Arrow library, implement parSequence.
    // TODO: Topic: Advanced parallel.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_parSequence(): List<Int> = TODO()

    // Exercise 3: raceN
    // TODO: Using Arrow library, implement raceN.
    // TODO: Topic: Advanced parallel.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_raceN(): String = TODO()

    // Exercise 4: raceTwo
    // TODO: Using Arrow library, implement raceTwo.
    // TODO: Topic: Advanced parallel.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_raceTwo(): Pair<Int, Int> = TODO()

    // Exercise 5: timeout
    // TODO: Using Arrow library, implement timeout.
    // TODO: Topic: Advanced parallel.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_timeout(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_parTraverse().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_parSequence().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_raceN().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_raceTwo()
        assert(exercise5_timeout().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow045_AdvancedParallel exercises passed!")
    }
}
