package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Heap operations
 */
object Algo041_HeapOperations {

    // Exercise 1: kthLargest
    // TODO: Find 2nd largest in intArrayOf(3,2,1,5,6,4) using heap. Return 5.
    fun exercise1_kthLargest(): Int = TODO()

    // Exercise 2: topKFrequent
    // TODO: Find top 2 frequent elements in intArrayOf(1,1,1,2,2,3). Return sorted.
    fun exercise2_topKFrequent(): List<Int> = TODO()

    // Exercise 3: mergeKSorted
    // TODO: Implement mergeKSorted.
    // TODO: Topic: Heap operations.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_mergeKSorted(): Boolean = TODO()

    // Exercise 4: medianStream
    // TODO: Implement medianStream.
    // TODO: Topic: Heap operations.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_medianStream(): Int = TODO()

    // Exercise 5: kClosest
    // TODO: Implement kClosest.
    // TODO: Topic: Heap operations.
    // TODO: Return a verifiable result of type String.
    fun exercise5_kClosest(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_kthLargest() == 5) { "Exercise 1 failed" }
        assert(exercise2_topKFrequent() == listOf(1,2)) { "Exercise 2 failed" }
        assert(exercise3_mergeKSorted() == true) { "Exercise 3 failed" }
        exercise4_medianStream()
        assert(exercise5_kClosest().isNotEmpty()) { "Exercise 5 failed" }
        println("All Algo041_HeapOperations exercises passed!")
    }
}
