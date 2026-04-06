package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Quick Sort
 */
object Algo020_QuickSort {

    // Exercise 1: partition
    // TODO: Partition intArrayOf(3, 6, 8, 10, 1, 2, 1) with pivot at last element (1).
    // TODO: Return pivot's final index.
    fun exercise1_partition(): Int = TODO()

    // Exercise 2: quickSort
    // TODO: Sort intArrayOf(10, 7, 8, 9, 1, 5) using quicksort. Return as list.
    fun exercise2_quickSort(): List<Int> = TODO()

    // Exercise 3: dutchFlag
    // TODO: Sort intArrayOf(2, 0, 2, 1, 1, 0) containing only 0,1,2 (Dutch National Flag).
    // TODO: Return as list.
    fun exercise3_dutchFlag(): List<Int> = TODO()

    // Exercise 4: kthSmallest
    // TODO: Find 3rd smallest element in intArrayOf(7, 10, 4, 3, 20, 15) using partition.
    // TODO: Return it.
    fun exercise4_kthSmallest(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_partition() == 1) { "Exercise 1 failed" }
        assert(exercise2_quickSort() == listOf(1, 5, 7, 8, 9, 10)) { "Exercise 2 failed" }
        assert(exercise3_dutchFlag() == listOf(0, 0, 1, 1, 2, 2)) { "Exercise 3 failed" }
        assert(exercise4_kthSmallest() == 7) { "Exercise 4 failed" }
        println("All Algo020_QuickSort exercises passed!")
    }
}
