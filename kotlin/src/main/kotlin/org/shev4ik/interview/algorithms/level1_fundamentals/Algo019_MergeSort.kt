package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Merge Sort
 */
object Algo019_MergeSort {

    // Exercise 1: mergeTwoSorted
    // TODO: Merge sorted arrays intArrayOf(1, 3, 5) and intArrayOf(2, 4, 6) into one sorted list.
    fun exercise1_mergeTwoSorted(): List<Int> = TODO()

    // Exercise 2: mergeSort
    // TODO: Sort intArrayOf(38, 27, 43, 3, 9, 82, 10) using merge sort. Return as list.
    fun exercise2_mergeSort(): List<Int> = TODO()

    // Exercise 3: countInversions
    // TODO: Count inversions in intArrayOf(2, 4, 1, 3, 5). An inversion is pair (i,j) where i<j and a[i]>a[j].
    // TODO: Expected: 3 inversions: (2,1), (4,1), (4,3).
    fun exercise3_countInversions(): Int = TODO()

    // Exercise 4: mergeSortStable
    // TODO: Verify merge sort is stable: sort pairs by first element, check that equal elements maintain order.
    // TODO: Return true.
    fun exercise4_mergeSortStable(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_mergeTwoSorted() == listOf(1, 2, 3, 4, 5, 6)) { "Exercise 1 failed" }
        assert(exercise2_mergeSort() == listOf(3, 9, 10, 27, 38, 43, 82)) { "Exercise 2 failed" }
        assert(exercise3_countInversions() == 3) { "Exercise 3 failed" }
        assert(exercise4_mergeSortStable() == true) { "Exercise 4 failed" }
        println("All Algo019_MergeSort exercises passed!")
    }
}
