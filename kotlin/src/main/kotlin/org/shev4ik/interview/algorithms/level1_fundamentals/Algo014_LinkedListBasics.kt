package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Singly Linked List
 */
object Algo014_LinkedListBasics {

    // Exercise 1: createFromArray
    // TODO: Create a singly linked list from intArrayOf(1,2,3,4,5). Traverse and return as List.
    fun exercise1_createFromArray(): List<Int> = TODO()

    // Exercise 2: insertAtHead
    // TODO: Insert 0 at head of list [1,2,3]. Return traversal.
    fun exercise2_insertAtHead(): List<Int> = TODO()

    // Exercise 3: insertAtTail
    // TODO: Insert 4 at tail of list [1,2,3]. Return traversal.
    fun exercise3_insertAtTail(): List<Int> = TODO()

    // Exercise 4: deleteByValue
    // TODO: Delete node with value 3 from list [1,2,3,4,5]. Return traversal.
    fun exercise4_deleteByValue(): List<Int> = TODO()

    // Exercise 5: length
    // TODO: Return the length of linked list created from intArrayOf(10,20,30,40).
    fun exercise5_length(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createFromArray() == listOf(1,2,3,4,5)) { "Exercise 1 failed" }
        assert(exercise2_insertAtHead() == listOf(0,1,2,3)) { "Exercise 2 failed" }
        assert(exercise3_insertAtTail() == listOf(1,2,3,4)) { "Exercise 3 failed" }
        assert(exercise4_deleteByValue() == listOf(1,2,4,5)) { "Exercise 4 failed" }
        assert(exercise5_length() == 4) { "Exercise 5 failed" }
        println("All Algo014_LinkedListBasics exercises passed!")
    }
}
