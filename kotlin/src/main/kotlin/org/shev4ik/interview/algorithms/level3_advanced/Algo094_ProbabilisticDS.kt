package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Probabilistic data structures
 */
object Algo094_ProbabilisticDS {

    // Exercise 1: bloomFilter
    // TODO: Implement bloomFilter.
    // TODO: Topic: Probabilistic data structures.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_bloomFilter(): List<Int> = TODO()

    // Exercise 2: countMinSketch
    // TODO: Implement countMinSketch.
    // TODO: Topic: Probabilistic data structures.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_countMinSketch(): Int = TODO()

    // Exercise 3: hyperLogLog
    // TODO: Implement hyperLogLog.
    // TODO: Topic: Probabilistic data structures.
    // TODO: Return a verifiable result of type String.
    fun exercise3_hyperLogLog(): String = TODO()

    // Exercise 4: skipList
    // TODO: Implement skipList.
    // TODO: Topic: Probabilistic data structures.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_skipList(): Boolean = TODO()

    // Exercise 5: minHash
    // TODO: Implement minHash.
    // TODO: Topic: Probabilistic data structures.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise5_minHash(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_bloomFilter().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_countMinSketch()
        assert(exercise3_hyperLogLog().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_skipList() == true) { "Exercise 4 failed" }
        assert(exercise5_minHash() == true) { "Exercise 5 failed" }
        println("All Algo094_ProbabilisticDS exercises passed!")
    }
}
