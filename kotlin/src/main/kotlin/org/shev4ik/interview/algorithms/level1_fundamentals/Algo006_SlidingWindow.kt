package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Sliding Window
 */
object Algo006_SlidingWindow {

    // Exercise 1: maxSumSubarrayK
    // TODO: Find maximum sum of subarray of size 3 in intArrayOf(2, 1, 5, 1, 3, 2).
    // TODO: Return max sum.
    fun exercise1_maxSumSubarrayK(): Int = TODO()

    // Exercise 2: smallestSubarrayWithSum
    // TODO: Find length of smallest contiguous subarray with sum >= 7
    // TODO: in intArrayOf(2, 3, 1, 2, 4, 3). Return length.
    fun exercise2_smallestSubarrayWithSum(): Int = TODO()

    // Exercise 3: longestSubstringNoRepeat
    // TODO: Find length of longest substring without repeating chars in "abcabcbb".
    fun exercise3_longestSubstringNoRepeat(): Int = TODO()

    // Exercise 4: averageOfSubarraysK
    // TODO: Return averages of all contiguous subarrays of size 3
    // TODO: in intArrayOf(1, 3, 2, 6, -1, 4, 1, 8, 2).
    fun exercise4_averageOfSubarraysK(): List<Double> = TODO()

    // Exercise 5: maxConsecutiveOnes
    // TODO: Find max consecutive 1s in intArrayOf(1,1,0,1,1,1) if you can flip at most 1 zero.
    // TODO: Return max length.
    fun exercise5_maxConsecutiveOnes(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_maxSumSubarrayK() == 9) { "Exercise 1 failed" }
        assert(exercise2_smallestSubarrayWithSum() == 2) { "Exercise 2 failed" }
        assert(exercise3_longestSubstringNoRepeat() == 3) { "Exercise 3 failed" }
        assert(exercise4_averageOfSubarraysK() == listOf(2.0, 11.0/3, 7.0/3, 3.0, 4.0/3, 13.0/3, 11.0/3)) { "Exercise 4 failed" }
        assert(exercise5_maxConsecutiveOnes() == 6) { "Exercise 5 failed" }
        println("All Algo006_SlidingWindow exercises passed!")
    }
}
