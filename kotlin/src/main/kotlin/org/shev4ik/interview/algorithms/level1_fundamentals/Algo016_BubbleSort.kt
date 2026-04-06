package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Bubble Sort
 */
object Algo016_BubbleSort {

    // Exercise 1: basicBubble
    // TODO: Sort intArrayOf(5, 3, 8, 4, 2) using bubble sort. Return as list.
    fun exercise1_basicBubble(): List<Int> = TODO()

    // Exercise 2: optimizedBubble
    // TODO: Sort intArrayOf(1, 2, 3, 5, 4) with optimized bubble sort (early termination).
    // TODO: Return sorted list.
    fun exercise2_optimizedBubble(): List<Int> = TODO()

    // Exercise 3: countSwaps
    // TODO: Count number of swaps needed to bubble sort intArrayOf(4, 3, 2, 1).
    // TODO: Return swap count.
    fun exercise3_countSwaps(): Int = TODO()

    // Exercise 4: isSorted
    // TODO: Check if intArrayOf(1, 2, 3, 4, 5) is already sorted.
    fun exercise4_isSorted(): Boolean = TODO()

    // Exercise 5: sortStrings
    // TODO: Sort listOf("banana","apple","cherry") using bubble sort. Return result.
    fun exercise5_sortStrings(): List<String> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicBubble() == listOf(2, 3, 4, 5, 8)) { "Exercise 1 failed" }
        assert(exercise2_optimizedBubble() == listOf(1, 2, 3, 4, 5)) { "Exercise 2 failed" }
        assert(exercise3_countSwaps() == 6) { "Exercise 3 failed" }
        assert(exercise4_isSorted() == true) { "Exercise 4 failed" }
        assert(exercise5_sortStrings() == listOf("apple","banana","cherry")) { "Exercise 5 failed" }
        println("All Algo016_BubbleSort exercises passed!")
    }
}
