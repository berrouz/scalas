package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Monotonic stack patterns
 */
object Algo038_MonotonicStack {

    // Exercise 1: nextGreater
    // TODO: Find next greater element for each in intArrayOf(4,5,2,25).
    // TODO: Return list: [5,25,25,-1].
    fun exercise1_nextGreater(): List<Int> = TODO()

    // Exercise 2: nextSmaller
    // TODO: Find next smaller element for each in intArrayOf(4,5,2,25).
    // TODO: Return list: [2,2,-1,-1].
    fun exercise2_nextSmaller(): List<Int> = TODO()

    // Exercise 3: dailyTemps
    // TODO: Given temps intArrayOf(73,74,75,71,69,72,76,73), find days until warmer.
    // TODO: Return list.
    fun exercise3_dailyTemps(): List<Int> = TODO()

    // Exercise 4: largestRectangle
    // TODO: Find largest rectangle in histogram intArrayOf(2,1,5,6,2,3).
    // TODO: Return area.
    fun exercise4_largestRectangle(): Int = TODO()

    // Exercise 5: stockSpan
    // TODO: Find stock span for prices intArrayOf(100,80,60,70,60,75,85).
    // TODO: Return spans.
    fun exercise5_stockSpan(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nextGreater() == listOf(5,25,25,-1)) { "Exercise 1 failed" }
        assert(exercise2_nextSmaller() == listOf(2,2,-1,-1)) { "Exercise 2 failed" }
        assert(exercise3_dailyTemps() == listOf(1,1,4,2,1,1,0,0)) { "Exercise 3 failed" }
        assert(exercise4_largestRectangle() == 10) { "Exercise 4 failed" }
        assert(exercise5_stockSpan() == listOf(1,1,1,2,1,4,6)) { "Exercise 5 failed" }
        println("All Algo038_MonotonicStack exercises passed!")
    }
}
