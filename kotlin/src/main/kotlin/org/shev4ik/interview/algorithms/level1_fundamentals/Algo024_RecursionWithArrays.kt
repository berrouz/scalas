package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Recursion with Arrays
 */
object Algo024_RecursionWithArrays {

    // Exercise 1: recursiveSum
    // TODO: Compute sum of intArrayOf(1,2,3,4,5) recursively. Return 15.
    fun exercise1_recursiveSum(): Int = TODO()

    // Exercise 2: recursiveMax
    // TODO: Find max of intArrayOf(3,7,2,9,4) recursively. Return 9.
    fun exercise2_recursiveMax(): Int = TODO()

    // Exercise 3: recursiveBinarySearch
    // TODO: Binary search for 5 in sorted intArrayOf(1,3,5,7,9) recursively. Return index 2.
    fun exercise3_recursiveBinarySearch(): Int = TODO()

    // Exercise 4: isSortedRecursive
    // TODO: Check if intArrayOf(1,2,3,4,5) is sorted using recursion.
    fun exercise4_isSortedRecursive(): Boolean = TODO()

    // Exercise 5: generateSubsets
    // TODO: Generate all subsets of intArrayOf(1,2,3). Return count (should be 8 = 2^3).
    fun exercise5_generateSubsets(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_recursiveSum() == 15) { "Exercise 1 failed" }
        assert(exercise2_recursiveMax() == 9) { "Exercise 2 failed" }
        assert(exercise3_recursiveBinarySearch() == 2) { "Exercise 3 failed" }
        assert(exercise4_isSortedRecursive() == true) { "Exercise 4 failed" }
        assert(exercise5_generateSubsets() == 8) { "Exercise 5 failed" }
        println("All Algo024_RecursionWithArrays exercises passed!")
    }
}
