package org.shev4ik.interview.arrow.level1_basics

/**
 * Error accumulation
 */
object Arrow006_ValidatedAccumulation {

    // Exercise 1: zip
    // TODO: Using Arrow library, implement zip.
    // TODO: Topic: Error accumulation.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_zip(): String = TODO()

    // Exercise 2: zipNel
    // TODO: Using Arrow library, implement zipNel.
    // TODO: Topic: Error accumulation.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_zipNel(): String = TODO()

    // Exercise 3: accumulate
    // TODO: Using Arrow library, implement accumulate.
    // TODO: Topic: Error accumulation.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_accumulate(): String = TODO()

    // Exercise 4: mapN
    // TODO: Using Arrow library, implement mapN.
    // TODO: Topic: Error accumulation.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_mapN(): Map<String, Int> = TODO()

    // Exercise 5: traverse
    // TODO: Using Arrow library, implement traverse.
    // TODO: Topic: Error accumulation.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_traverse(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_zip().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_zipNel().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_accumulate().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_mapN().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_traverse().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow006_ValidatedAccumulation exercises passed!")
    }
}
