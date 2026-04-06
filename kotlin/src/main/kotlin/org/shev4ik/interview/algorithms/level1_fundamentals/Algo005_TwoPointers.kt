package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Two Pointers Technique
 */
object Algo005_TwoPointers {

    // Exercise 1: twoSumSorted
    // TODO: In sorted array intArrayOf(1, 3, 5, 7, 9), find two indices whose values sum to 8.
    // TODO: Return Pair of indices (0-based).
    fun exercise1_twoSumSorted(): Pair<Int, Int> = TODO()

    // Exercise 2: removeDuplicatesSorted
    // TODO: Remove duplicates from sorted intArrayOf(1, 1, 2, 2, 3, 4, 4, 5) in place.
    // TODO: Return count of unique elements.
    fun exercise2_removeDuplicatesSorted(): Int = TODO()

    // Exercise 3: moveZeros
    // TODO: Move all zeros to end of intArrayOf(0, 1, 0, 3, 12) maintaining order of non-zeros.
    // TODO: Return as list.
    fun exercise3_moveZeros(): List<Int> = TODO()

    // Exercise 4: isPalindromeString
    // TODO: Check if "racecar" is a palindrome using two pointers.
    fun exercise4_isPalindromeString(): Boolean = TODO()

    // Exercise 5: containerWithMostWater
    // TODO: Given heights intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), find max water area
    // TODO: between two lines. Return max area.
    fun exercise5_containerWithMostWater(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_twoSumSorted() == Pair(0, 3)) { "Exercise 1 failed" }
        assert(exercise2_removeDuplicatesSorted() == 5) { "Exercise 2 failed" }
        assert(exercise3_moveZeros() == listOf(1, 3, 12, 0, 0)) { "Exercise 3 failed" }
        assert(exercise4_isPalindromeString() == true) { "Exercise 4 failed" }
        assert(exercise5_containerWithMostWater() == 49) { "Exercise 5 failed" }
        println("All Algo005_TwoPointers exercises passed!")
    }
}
