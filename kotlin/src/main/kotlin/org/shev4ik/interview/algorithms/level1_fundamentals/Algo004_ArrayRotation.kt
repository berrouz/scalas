package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Array Rotation
 */
object Algo004_ArrayRotation {

    // Exercise 1: rotateLeftByOne
    // TODO: Rotate intArrayOf(1, 2, 3, 4, 5) left by 1. Return as list.
    // TODO: Expected: [2, 3, 4, 5, 1].
    fun exercise1_rotateLeftByOne(): List<Int> = TODO()

    // Exercise 2: rotateLeftByK
    // TODO: Rotate intArrayOf(1, 2, 3, 4, 5) left by 3. Return as list.
    // TODO: Expected: [4, 5, 1, 2, 3].
    fun exercise2_rotateLeftByK(): List<Int> = TODO()

    // Exercise 3: rotateRightByK
    // TODO: Rotate intArrayOf(1, 2, 3, 4, 5) right by 2. Return as list.
    // TODO: Expected: [4, 5, 1, 2, 3].
    fun exercise3_rotateRightByK(): List<Int> = TODO()

    // Exercise 4: isRotation
    // TODO: Check if intArrayOf(3, 4, 5, 1, 2) is a rotation of intArrayOf(1, 2, 3, 4, 5).
    fun exercise4_isRotation(): Boolean = TODO()

    // Exercise 5: minInRotatedSorted
    // TODO: Find minimum in rotated sorted array intArrayOf(4, 5, 6, 7, 1, 2, 3).
    fun exercise5_minInRotatedSorted(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_rotateLeftByOne() == listOf(2, 3, 4, 5, 1)) { "Exercise 1 failed" }
        assert(exercise2_rotateLeftByK() == listOf(4, 5, 1, 2, 3)) { "Exercise 2 failed" }
        assert(exercise3_rotateRightByK() == listOf(4, 5, 1, 2, 3)) { "Exercise 3 failed" }
        assert(exercise4_isRotation() == true) { "Exercise 4 failed" }
        assert(exercise5_minInRotatedSorted() == 1) { "Exercise 5 failed" }
        println("All Algo004_ArrayRotation exercises passed!")
    }
}
