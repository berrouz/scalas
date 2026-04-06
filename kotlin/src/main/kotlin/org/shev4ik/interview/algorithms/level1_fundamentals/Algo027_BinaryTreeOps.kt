package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Binary Tree Operations
 */
object Algo027_BinaryTreeOps {

    // Exercise 1: height
    // TODO: Compute height of tree: 1(2(4,5),3). Height = 2 (0-indexed) or 3 (1-indexed). Return 3.
    fun exercise1_height(): Int = TODO()

    // Exercise 2: isBalanced
    // TODO: Check if tree 1(2(4,5),3) is balanced (heights differ by at most 1).
    fun exercise2_isBalanced(): Boolean = TODO()

    // Exercise 3: diameter
    // TODO: Find diameter (longest path) of tree 1(2(4,5),3). Return 3 (4->2->1->3).
    fun exercise3_diameter(): Int = TODO()

    // Exercise 4: mirror
    // TODO: Mirror/invert tree 1(2(4,5),3). Return inorder of mirrored: [3,1,5,2,4].
    fun exercise4_mirror(): List<Int> = TODO()

    // Exercise 5: isSymmetric
    // TODO: Check if tree 1(2(3,4),2(4,3)) is symmetric. Return true.
    fun exercise5_isSymmetric(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_height() == 3) { "Exercise 1 failed" }
        assert(exercise2_isBalanced() == true) { "Exercise 2 failed" }
        assert(exercise3_diameter() == 3) { "Exercise 3 failed" }
        assert(exercise4_mirror() == listOf(3,1,5,2,4)) { "Exercise 4 failed" }
        assert(exercise5_isSymmetric() == true) { "Exercise 5 failed" }
        println("All Algo027_BinaryTreeOps exercises passed!")
    }
}
