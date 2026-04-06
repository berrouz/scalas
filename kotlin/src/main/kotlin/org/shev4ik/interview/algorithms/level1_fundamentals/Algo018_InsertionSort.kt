package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Insertion Sort
 */
object Algo018_InsertionSort {

    // Exercise 1: basicInsertion
    // TODO: Sort intArrayOf(12, 11, 13, 5, 6) using insertion sort. Return as list.
    fun exercise1_basicInsertion(): List<Int> = TODO()

    // Exercise 2: nearlySorted
    // TODO: Sort nearly-sorted intArrayOf(1, 2, 4, 3, 5) using insertion sort (efficient for this).
    // TODO: Return as list.
    fun exercise2_nearlySorted(): List<Int> = TODO()

    // Exercise 3: countShifts
    // TODO: Count total shifts during insertion sort of intArrayOf(4, 3, 2, 1).
    fun exercise3_countShifts(): Int = TODO()

    // Exercise 4: insertIntoSorted
    // TODO: Insert value 4 into sorted list [1, 2, 3, 5, 6] maintaining order. Return result.
    fun exercise4_insertIntoSorted(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicInsertion() == listOf(5, 6, 11, 12, 13)) { "Exercise 1 failed" }
        assert(exercise2_nearlySorted() == listOf(1, 2, 3, 4, 5)) { "Exercise 2 failed" }
        assert(exercise3_countShifts() == 6) { "Exercise 3 failed" }
        assert(exercise4_insertIntoSorted() == listOf(1, 2, 3, 4, 5, 6)) { "Exercise 4 failed" }
        println("All Algo018_InsertionSort exercises passed!")
    }
}
