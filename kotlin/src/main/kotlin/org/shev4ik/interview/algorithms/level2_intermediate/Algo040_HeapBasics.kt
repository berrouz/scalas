package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Heap and priority queue
 */
object Algo040_HeapBasics {

    // Exercise 1: minHeap
    // TODO: Build min-heap from intArrayOf(5,3,8,1,4). Extract min 3 times. Return extracted values.
    fun exercise1_minHeap(): List<Int> = TODO()

    // Exercise 2: maxHeap
    // TODO: Build max-heap from intArrayOf(5,3,8,1,4). Extract max. Return it.
    fun exercise2_maxHeap(): Int = TODO()

    // Exercise 3: heapInsert
    // TODO: Implement heapInsert.
    // TODO: Topic: Heap and priority queue.
    // TODO: Return a verifiable result of type String.
    fun exercise3_heapInsert(): String = TODO()

    // Exercise 4: heapDelete
    // TODO: Implement heapDelete.
    // TODO: Topic: Heap and priority queue.
    // TODO: Return a verifiable result of type String.
    fun exercise4_heapDelete(): String = TODO()

    // Exercise 5: heapSort
    // TODO: Implement heapSort.
    // TODO: Topic: Heap and priority queue.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_heapSort(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_minHeap() == listOf(1,3,4)) { "Exercise 1 failed" }
        assert(exercise2_maxHeap() == 8) { "Exercise 2 failed" }
        assert(exercise3_heapInsert().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_heapDelete().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_heapSort().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo040_HeapBasics exercises passed!")
    }
}
