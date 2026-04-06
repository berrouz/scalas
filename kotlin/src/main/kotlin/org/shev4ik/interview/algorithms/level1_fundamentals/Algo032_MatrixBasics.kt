package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Matrix Operations
 */
object Algo032_MatrixBasics {

    // Exercise 1: transpose
    // TODO: Transpose matrix [[1,2,3],[4,5,6]]. Return [[1,4],[2,5],[3,6]].
    fun exercise1_transpose(): List<List<Int>> = TODO()

    // Exercise 2: rotate90
    // TODO: Rotate [[1,2],[3,4]] clockwise 90°. Return [[3,1],[4,2]].
    fun exercise2_rotate90(): List<List<Int>> = TODO()

    // Exercise 3: spiralOrder
    // TODO: Return spiral order of [[1,2,3],[4,5,6],[7,8,9]].
    // TODO: Expected: [1,2,3,6,9,8,7,4,5].
    fun exercise3_spiralOrder(): List<Int> = TODO()

    // Exercise 4: searchMatrix
    // TODO: Search for 8 in row-sorted matrix [[1,3,5],[7,8,10],[11,13,15]].
    fun exercise4_searchMatrix(): Boolean = TODO()

    // Exercise 5: setZeros
    // TODO: If any element is 0, set entire row and column to 0.
    // TODO: Input: [[1,1,1],[1,0,1],[1,1,1]]. Expected: [[1,0,1],[0,0,0],[1,0,1]].
    fun exercise5_setZeros(): List<List<Int>> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_transpose() == listOf(listOf(1,4),listOf(2,5),listOf(3,6))) { "Exercise 1 failed" }
        assert(exercise2_rotate90() == listOf(listOf(3,1),listOf(4,2))) { "Exercise 2 failed" }
        assert(exercise3_spiralOrder() == listOf(1,2,3,6,9,8,7,4,5)) { "Exercise 3 failed" }
        assert(exercise4_searchMatrix() == true) { "Exercise 4 failed" }
        assert(exercise5_setZeros() == listOf(listOf(1,0,1),listOf(0,0,0),listOf(1,0,1))) { "Exercise 5 failed" }
        println("All Algo032_MatrixBasics exercises passed!")
    }
}
