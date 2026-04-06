package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Array Traversal
 */
object Algo001_ArrayTraversal {

    // Exercise 1: sumArray
    // TODO: Return the sum of intArrayOf(1, 2, 3, 4, 5).
    fun exercise1_sumArray(): Int = TODO()

    // Exercise 2: findMax
    // TODO: Return the maximum element of intArrayOf(3, 7, 2, 9, 4).
    fun exercise2_findMax(): Int = TODO()

    // Exercise 3: findMin
    // TODO: Return the minimum element of intArrayOf(5, 1, 8, 3, 7).
    fun exercise3_findMin(): Int = TODO()

    // Exercise 4: countGreaterThan
    // TODO: Count elements greater than 5 in intArrayOf(1, 7, 3, 9, 4, 6, 2, 8). Return count.
    fun exercise4_countGreaterThan(): Int = TODO()

    // Exercise 5: average
    // TODO: Return the average of intArrayOf(10, 20, 30, 40, 50) as Double.
    fun exercise5_average(): Double = TODO()

    // Exercise 6: secondLargest
    // TODO: Return the second largest element of intArrayOf(5, 2, 8, 1, 9, 3).
    fun exercise6_secondLargest(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sumArray() == 15) { "Exercise 1 failed" }
        assert(exercise2_findMax() == 9) { "Exercise 2 failed" }
        assert(exercise3_findMin() == 1) { "Exercise 3 failed" }
        assert(exercise4_countGreaterThan() == 4) { "Exercise 4 failed" }
        assert(exercise5_average() == 30.0) { "Exercise 5 failed" }
        assert(exercise6_secondLargest() == 8) { "Exercise 6 failed" }
        println("All Algo001_ArrayTraversal exercises passed!")
    }
}
