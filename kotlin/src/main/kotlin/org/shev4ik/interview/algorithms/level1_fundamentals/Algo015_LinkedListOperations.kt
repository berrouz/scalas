package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Linked List Operations
 */
object Algo015_LinkedListOperations {

    // Exercise 1: reverseList
    // TODO: Reverse linked list [1,2,3,4,5]. Return as list.
    fun exercise1_reverseList(): List<Int> = TODO()

    // Exercise 2: findMiddle
    // TODO: Find middle element of linked list [1,2,3,4,5]. Return 3.
    fun exercise2_findMiddle(): Int = TODO()

    // Exercise 3: hasCycle
    // TODO: Create a linked list with a cycle. Return true if cycle detected.
    fun exercise3_hasCycle(): Boolean = TODO()

    // Exercise 4: nthFromEnd
    // TODO: Find 2nd node from end in [1,2,3,4,5]. Return 4.
    fun exercise4_nthFromEnd(): Int = TODO()

    // Exercise 5: mergeSorted
    // TODO: Merge sorted lists [1,3,5] and [2,4,6]. Return merged [1,2,3,4,5,6].
    fun exercise5_mergeSorted(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reverseList() == listOf(5,4,3,2,1)) { "Exercise 1 failed" }
        assert(exercise2_findMiddle() == 3) { "Exercise 2 failed" }
        assert(exercise3_hasCycle() == true) { "Exercise 3 failed" }
        assert(exercise4_nthFromEnd() == 4) { "Exercise 4 failed" }
        assert(exercise5_mergeSorted() == listOf(1,2,3,4,5,6)) { "Exercise 5 failed" }
        println("All Algo015_LinkedListOperations exercises passed!")
    }
}
