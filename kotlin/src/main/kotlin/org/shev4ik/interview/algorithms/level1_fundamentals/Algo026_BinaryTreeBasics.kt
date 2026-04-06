package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Binary Tree Basics
 */
object Algo026_BinaryTreeBasics {

    // Exercise 1: inorder
    // TODO: Create tree: root=1, left=2, right=3, 2.left=4, 2.right=5.
    // TODO: Return inorder traversal.
    fun exercise1_inorder(): List<Int> = TODO()

    // Exercise 2: preorder
    // TODO: Same tree. Return preorder traversal.
    fun exercise2_preorder(): List<Int> = TODO()

    // Exercise 3: postorder
    // TODO: Same tree. Return postorder traversal.
    fun exercise3_postorder(): List<Int> = TODO()

    // Exercise 4: levelOrder
    // TODO: Same tree. Return level-order traversal.
    fun exercise4_levelOrder(): List<List<Int>> = TODO()

    // Exercise 5: nodeCount
    // TODO: Count nodes in the tree. Return 5.
    fun exercise5_nodeCount(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_inorder() == listOf(4,2,5,1,3)) { "Exercise 1 failed" }
        assert(exercise2_preorder() == listOf(1,2,4,5,3)) { "Exercise 2 failed" }
        assert(exercise3_postorder() == listOf(4,5,2,3,1)) { "Exercise 3 failed" }
        assert(exercise4_levelOrder() == listOf(listOf(1), listOf(2,3), listOf(4,5))) { "Exercise 4 failed" }
        assert(exercise5_nodeCount() == 5) { "Exercise 5 failed" }
        println("All Algo026_BinaryTreeBasics exercises passed!")
    }
}
