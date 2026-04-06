package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Counting Sort
 */
object Algo034_CountingSort {

    // Exercise 1: countingSort
    // TODO: Sort intArrayOf(4, 2, 2, 8, 3, 3, 1) using counting sort (values 0-9).
    // TODO: Return sorted list.
    fun exercise1_countingSort(): List<Int> = TODO()

    // Exercise 2: sortColors
    // TODO: Sort intArrayOf(2,0,2,1,1,0) containing only 0,1,2 (Dutch Flag). Return sorted.
    fun exercise2_sortColors(): List<Int> = TODO()

    // Exercise 3: frequencySort
    // TODO: Sort by frequency (most frequent first): intArrayOf(1,1,2,2,2,3).
    // TODO: Return [2,2,2,1,1,3].
    fun exercise3_frequencySort(): List<Int> = TODO()

    // Exercise 4: sortByCharFreq
    // TODO: Sort "tree" by character frequency (most frequent first). Return "eert" or "eetr".
    fun exercise4_sortByCharFreq(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_countingSort() == listOf(1, 2, 2, 3, 3, 4, 8)) { "Exercise 1 failed" }
        assert(exercise2_sortColors() == listOf(0,0,1,1,2,2)) { "Exercise 2 failed" }
        assert(exercise3_frequencySort() == listOf(2,2,2,1,1,3)) { "Exercise 3 failed" }
        assert(exercise4_sortByCharFreq().startsWith("ee")) { "Exercise 4 failed" }
        println("All Algo034_CountingSort exercises passed!")
    }
}
