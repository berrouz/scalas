package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Tree DFS patterns
 */
object Algo052_TreeDFS {

    // Exercise 1: pathSum
    // TODO: Check if root-to-leaf path sums to 22 in tree 5(4(11(7,2)),8(13,4(nil,1))).
    fun exercise1_pathSum(): Boolean = TODO()

    // Exercise 2: maxDepth
    // TODO: Find max depth of tree 3(9,20(15,7)). Return 3.
    fun exercise2_maxDepth(): Int = TODO()

    // Exercise 3: invertTree
    // TODO: Invert tree 4(2(1,3),7(6,9)). Return inorder of inverted.
    fun exercise3_invertTree(): List<Int> = TODO()

    // Exercise 4: sameTrree
    // TODO: Implement sameTrree.
    // TODO: Topic: Tree DFS patterns.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_sameTrree(): Int = TODO()

    // Exercise 5: subtree
    // TODO: Implement subtree.
    // TODO: Topic: Tree DFS patterns.
    // TODO: Return a verifiable result of type Int.
    fun exercise5_subtree(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_pathSum() == true) { "Exercise 1 failed" }
        assert(exercise2_maxDepth() == 3) { "Exercise 2 failed" }
        assert(exercise3_invertTree() == listOf(9,7,6,4,3,2,1)) { "Exercise 3 failed" }
        exercise4_sameTrree()
        exercise5_subtree()
        println("All Algo052_TreeDFS exercises passed!")
    }
}
