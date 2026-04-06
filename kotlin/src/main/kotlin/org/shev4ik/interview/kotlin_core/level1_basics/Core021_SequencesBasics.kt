package org.shev4ik.interview.kotlin_core.level1_basics

/**
 * Sequences
 */
object Core021_SequencesBasics {

    // Exercise 1: basicSequence
    // TODO: Create sequenceOf(1,2,3,4,5).toList(). Return result.
    fun exercise1_basicSequence(): List<Int> = TODO()

    // Exercise 2: generateSequence
    // TODO: Use generateSequence(1) { it * 2 }.take(5).toList(). Return result.
    fun exercise2_generateSequence(): List<Int> = TODO()

    // Exercise 3: listToSequence
    // TODO: Convert listOf(1,2,3,4,5) to sequence, filter even, map to *10, toList.
    fun exercise3_listToSequence(): List<Int> = TODO()

    // Exercise 4: infiniteSequence
    // TODO: Generate infinite sequence of naturals (1,2,3,...). Take first 100, sum them.
    fun exercise4_infiniteSequence(): Int = TODO()

    // Exercise 5: fibonacciSequence
    // TODO: Generate fibonacci sequence using generateSequence(Pair(0,1)) { Pair(it.second, it.first+it.second) }.
    // TODO: Map to first element, take 8, toList.
    fun exercise5_fibonacciSequence(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicSequence() == listOf(1, 2, 3, 4, 5)) { "Ex1 failed" }
        assert(exercise2_generateSequence() == listOf(1, 2, 4, 8, 16)) { "Ex2 failed" }
        assert(exercise3_listToSequence() == listOf(20, 40)) { "Ex3 failed" }
        assert(exercise4_infiniteSequence() == 5050) { "Ex4 failed" }
        assert(exercise5_fibonacciSequence() == listOf(0, 1, 1, 2, 3, 5, 8, 13)) { "Ex5 failed" }
        println("All Core021_SequencesBasics exercises passed!")
    }
}
