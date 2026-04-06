package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Selection Sort
 */
object Algo017_SelectionSort {

    // Exercise 1: basicSelection
    // TODO: Sort intArrayOf(64, 25, 12, 22, 11) using selection sort. Return as list.
    fun exercise1_basicSelection(): List<Int> = TODO()

    // Exercise 2: findMinIndex
    // TODO: Find index of minimum element in subarray of intArrayOf(5, 3, 8, 1, 4) from index 2.
    // TODO: Return index.
    fun exercise2_findMinIndex(): Int = TODO()

    // Exercise 3: sortDescending
    // TODO: Sort intArrayOf(3, 1, 4, 1, 5) in descending order using selection sort.
    fun exercise3_sortDescending(): List<Int> = TODO()

    // Exercise 4: countComparisons
    // TODO: Count comparisons made during selection sort of intArrayOf(4, 3, 2, 1).
    // TODO: Return count.
    fun exercise4_countComparisons(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicSelection() == listOf(11, 12, 22, 25, 64)) { "Exercise 1 failed" }
        assert(exercise2_findMinIndex() == 3) { "Exercise 2 failed" }
        assert(exercise3_sortDescending() == listOf(5, 4, 3, 1, 1)) { "Exercise 3 failed" }
        assert(exercise4_countComparisons() == 6) { "Exercise 4 failed" }
        println("All Algo017_SelectionSort exercises passed!")
    }
}
