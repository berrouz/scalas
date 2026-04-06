package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Array Search
 */
object Algo002_ArraySearch {

    // Exercise 1: linearSearch
    // TODO: Return index of value 7 in intArrayOf(3, 5, 7, 9, 11). Return -1 if not found.
    fun exercise1_linearSearch(): Int = TODO()

    // Exercise 2: findFirst
    // TODO: Return index of first occurrence of 3 in intArrayOf(1, 3, 5, 3, 7). Return -1 if not found.
    fun exercise2_findFirst(): Int = TODO()

    // Exercise 3: findLast
    // TODO: Return index of last occurrence of 3 in intArrayOf(1, 3, 5, 3, 7). Return -1 if not found.
    fun exercise3_findLast(): Int = TODO()

    // Exercise 4: containsValue
    // TODO: Check if intArrayOf(10, 20, 30, 40, 50) contains 30.
    fun exercise4_containsValue(): Boolean = TODO()

    // Exercise 5: countOccurrences
    // TODO: Count occurrences of 2 in intArrayOf(2, 5, 2, 8, 2, 1, 2). Return count.
    fun exercise5_countOccurrences(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_linearSearch() == 2) { "Exercise 1 failed" }
        assert(exercise2_findFirst() == 1) { "Exercise 2 failed" }
        assert(exercise3_findLast() == 3) { "Exercise 3 failed" }
        assert(exercise4_containsValue() == true) { "Exercise 4 failed" }
        assert(exercise5_countOccurrences() == 4) { "Exercise 5 failed" }
        println("All Algo002_ArraySearch exercises passed!")
    }
}
