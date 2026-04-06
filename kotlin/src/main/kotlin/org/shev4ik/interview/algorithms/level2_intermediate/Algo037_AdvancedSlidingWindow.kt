package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Variable-size sliding window
 */
object Algo037_AdvancedSlidingWindow {

    // Exercise 1: minWindow
    // TODO: Find minimum window in "ADOBECODEBANC" containing all chars of "ABC".
    // TODO: Return window length.
    fun exercise1_minWindow(): Int = TODO()

    // Exercise 2: longestKDistinct
    // TODO: Find longest substring with at most 2 distinct chars in "eceba".
    // TODO: Return length.
    fun exercise2_longestKDistinct(): Int = TODO()

    // Exercise 3: maxConsecutiveOnes
    // TODO: Implement maxConsecutiveOnes.
    // TODO: Topic: Variable-size sliding window.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_maxConsecutiveOnes(): Int = TODO()

    // Exercise 4: fruitBaskets
    // TODO: Implement fruitBaskets.
    // TODO: Topic: Variable-size sliding window.
    // TODO: Return a verifiable result of type String.
    fun exercise4_fruitBaskets(): String = TODO()

    // Exercise 5: permutationInString
    // TODO: Implement permutationInString.
    // TODO: Topic: Variable-size sliding window.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_permutationInString(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_minWindow() == 4) { "Exercise 1 failed" }
        assert(exercise2_longestKDistinct() == 3) { "Exercise 2 failed" }
        exercise3_maxConsecutiveOnes()
        assert(exercise4_fruitBaskets().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_permutationInString().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo037_AdvancedSlidingWindow exercises passed!")
    }
}
