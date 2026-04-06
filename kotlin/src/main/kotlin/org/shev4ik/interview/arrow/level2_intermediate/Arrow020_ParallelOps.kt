package org.shev4ik.interview.arrow.level2_intermediate

/**
 * Parallel operations
 */
object Arrow020_ParallelOps {

    // Exercise 1: parZip
    // TODO: Using Arrow library, implement parZip.
    // TODO: Topic: Parallel operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_parZip(): String = TODO()

    // Exercise 2: parMap
    // TODO: Using Arrow library, implement parMap.
    // TODO: Topic: Parallel operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_parMap(): Map<String, Int> = TODO()

    // Exercise 3: parTraverse
    // TODO: Using Arrow library, implement parTraverse.
    // TODO: Topic: Parallel operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_parTraverse(): List<Int> = TODO()

    // Exercise 4: raceN
    // TODO: Using Arrow library, implement raceN.
    // TODO: Topic: Parallel operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_raceN(): String = TODO()

    // Exercise 5: parallelError
    // TODO: Using Arrow library, implement parallelError.
    // TODO: Topic: Parallel operations.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_parallelError(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_parZip().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_parMap().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parTraverse().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_raceN().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_parallelError().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow020_ParallelOps exercises passed!")
    }
}
