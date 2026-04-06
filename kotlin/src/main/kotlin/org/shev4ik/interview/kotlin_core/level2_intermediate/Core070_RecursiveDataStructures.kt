package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Recursive Data Structures
 */
object Core070_RecursiveDataStructures {

    // Exercise 1: sealedLinkedList
    // TODO: Create sealed class MyList { data class Cons(val head: Int, val tail: MyList) : MyList(); object Nil : MyList() }.
    // TODO: Create list 1->2->3->Nil. Write fun sum(list: MyList): Int. Return sum.
    fun exercise1_sealedLinkedList(): Int = TODO()

    // Exercise 2: binaryTree
    // TODO: Create sealed class Tree { data class Node(val v: Int, val l: Tree, val r: Tree) : Tree(); object Empty : Tree() }.
    // TODO: Create tree with nodes 1,2,3. Write fun size(t: Tree): Int. Return size.
    fun exercise2_binaryTree(): Int = TODO()

    // Exercise 3: expressionTree
    // TODO: Create sealed class Expr { data class Num(val v: Int) : Expr(); data class Add(val a: Expr, val b: Expr) : Expr() }.
    // TODO: Evaluate Add(Num(10), Add(Num(20), Num(12))). Return result.
    fun exercise3_expressionTree(): Int = TODO()

    // Exercise 4: treeDepth
    // TODO: Write fun depth(tree: Tree): Int for the binary tree above.
    // TODO: Create tree of depth 3. Return depth.
    fun exercise4_treeDepth(): Int = TODO()

    // Exercise 5: listLength
    // TODO: Write fun length(list: MyList): Int for the sealed linked list.
    // TODO: Create list with 5 elements. Return length.
    fun exercise5_listLength(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sealedLinkedList() == 6) { "Exercise 1 failed" }
        assert(exercise2_binaryTree() == 3) { "Exercise 2 failed" }
        assert(exercise3_expressionTree() == 42) { "Exercise 3 failed" }
        assert(exercise4_treeDepth() == 3) { "Exercise 4 failed" }
        assert(exercise5_listLength() == 5) { "Exercise 5 failed" }
        println("All Core070_RecursiveDataStructures exercises passed!")
    }
}
