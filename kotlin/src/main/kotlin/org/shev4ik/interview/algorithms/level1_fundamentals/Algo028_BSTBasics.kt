package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * BST Fundamentals
 */
object Algo028_BSTBasics {

    // Exercise 1: searchBST
    // TODO: Search for 4 in BST: 5(3(1,4),7(6,8)). Return true.
    fun exercise1_searchBST(): Boolean = TODO()

    // Exercise 2: insertBST
    // TODO: Insert 4 into BST with nodes [5,3,7,1]. Return inorder traversal.
    fun exercise2_insertBST(): List<Int> = TODO()

    // Exercise 3: validateBST
    // TODO: Validate that tree 5(3(1,4),7(6,8)) is a valid BST.
    fun exercise3_validateBST(): Boolean = TODO()

    // Exercise 4: findMinBST
    // TODO: Find minimum value in BST 5(3(1,4),7(6,8)). Return 1.
    fun exercise4_findMinBST(): Int = TODO()

    // Exercise 5: findMaxBST
    // TODO: Find maximum value in BST 5(3(1,4),7(6,8)). Return 8.
    fun exercise5_findMaxBST(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_searchBST() == true) { "Exercise 1 failed" }
        assert(exercise2_insertBST() == listOf(1,3,4,5,7)) { "Exercise 2 failed" }
        assert(exercise3_validateBST() == true) { "Exercise 3 failed" }
        assert(exercise4_findMinBST() == 1) { "Exercise 4 failed" }
        assert(exercise5_findMaxBST() == 8) { "Exercise 5 failed" }
        println("All Algo028_BSTBasics exercises passed!")
    }
}
