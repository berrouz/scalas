package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Binary Search Variants
 */
object Algo022_BinarySearchVariants {

    // Exercise 1: peakElement
    // TODO: Find a peak element in intArrayOf(1, 3, 20, 4, 1). Return its value.
    fun exercise1_peakElement(): Int = TODO()

    // Exercise 2: searchRotated
    // TODO: Search for 4 in rotated sorted intArrayOf(4, 5, 6, 7, 0, 1, 2). Return index.
    fun exercise2_searchRotated(): Int = TODO()

    // Exercise 3: findMinRotated
    // TODO: Find minimum in rotated sorted intArrayOf(3, 4, 5, 1, 2). Return value.
    fun exercise3_findMinRotated(): Int = TODO()

    // Exercise 4: searchMatrix
    // TODO: Search for 8 in sorted matrix [[1,3,5],[7,8,10],[11,13,15]]. Return found.
    fun exercise4_searchMatrix(): Boolean = TODO()

    // Exercise 5: countOccurrences
    // TODO: Count occurrences of 5 in sorted intArrayOf(2,5,5,5,5,6,8) using binary search.
    fun exercise5_countOccurrences(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_peakElement() == 20) { "Exercise 1 failed" }
        assert(exercise2_searchRotated() == 0) { "Exercise 2 failed" }
        assert(exercise3_findMinRotated() == 1) { "Exercise 3 failed" }
        assert(exercise4_searchMatrix() == true) { "Exercise 4 failed" }
        assert(exercise5_countOccurrences() == 4) { "Exercise 5 failed" }
        println("All Algo022_BinarySearchVariants exercises passed!")
    }
}
