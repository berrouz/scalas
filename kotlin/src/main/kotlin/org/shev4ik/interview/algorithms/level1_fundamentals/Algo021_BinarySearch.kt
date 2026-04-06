package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Binary Search
 */
object Algo021_BinarySearch {

    // Exercise 1: basicBinarySearch
    // TODO: Binary search for 7 in sorted intArrayOf(1, 3, 5, 7, 9, 11). Return index.
    fun exercise1_basicBinarySearch(): Int = TODO()

    // Exercise 2: firstOccurrence
    // TODO: Find first occurrence of 5 in intArrayOf(1, 3, 5, 5, 5, 7, 9). Return index.
    fun exercise2_firstOccurrence(): Int = TODO()

    // Exercise 3: lastOccurrence
    // TODO: Find last occurrence of 5 in intArrayOf(1, 3, 5, 5, 5, 7, 9). Return index.
    fun exercise3_lastOccurrence(): Int = TODO()

    // Exercise 4: searchInsert
    // TODO: Find insert position for 6 in sorted intArrayOf(1, 3, 5, 7, 9). Return index.
    fun exercise4_searchInsert(): Int = TODO()

    // Exercise 5: sqrtBinarySearch
    // TODO: Find integer square root of 26 using binary search. Return 5.
    fun exercise5_sqrtBinarySearch(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicBinarySearch() == 3) { "Exercise 1 failed" }
        assert(exercise2_firstOccurrence() == 2) { "Exercise 2 failed" }
        assert(exercise3_lastOccurrence() == 4) { "Exercise 3 failed" }
        assert(exercise4_searchInsert() == 3) { "Exercise 4 failed" }
        assert(exercise5_sqrtBinarySearch() == 5) { "Exercise 5 failed" }
        println("All Algo021_BinarySearch exercises passed!")
    }
}
