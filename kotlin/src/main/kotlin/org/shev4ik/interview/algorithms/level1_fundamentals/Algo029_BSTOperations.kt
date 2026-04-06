package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * BST Operations
 */
object Algo029_BSTOperations {

    // Exercise 1: deleteBST
    // TODO: Delete 3 from BST 5(3(1,4),7). Return inorder: [1,4,5,7].
    fun exercise1_deleteBST(): List<Int> = TODO()

    // Exercise 2: inorderSuccessor
    // TODO: Find inorder successor of 4 in BST 5(3(1,4),7(6,8)). Return 5.
    fun exercise2_inorderSuccessor(): Int = TODO()

    // Exercise 3: kthSmallest
    // TODO: Find 3rd smallest in BST 5(3(1,4),7(6,8)). Return 4.
    fun exercise3_kthSmallest(): Int = TODO()

    // Exercise 4: rangeSearch
    // TODO: Find all values between 3 and 7 in BST 5(3(1,4),7(6,8)). Return sorted.
    fun exercise4_rangeSearch(): List<Int> = TODO()

    // Exercise 5: bstFromSorted
    // TODO: Create balanced BST from sorted array [1,2,3,4,5,6,7]. Validate it's BST.
    fun exercise5_bstFromSorted(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_deleteBST() == listOf(1,4,5,7)) { "Exercise 1 failed" }
        assert(exercise2_inorderSuccessor() == 5) { "Exercise 2 failed" }
        assert(exercise3_kthSmallest() == 4) { "Exercise 3 failed" }
        assert(exercise4_rangeSearch() == listOf(3,4,5,6,7)) { "Exercise 4 failed" }
        assert(exercise5_bstFromSorted() == true) { "Exercise 5 failed" }
        println("All Algo029_BSTOperations exercises passed!")
    }
}
