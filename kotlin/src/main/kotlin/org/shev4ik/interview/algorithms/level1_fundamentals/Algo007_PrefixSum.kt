package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Prefix Sum
 */
object Algo007_PrefixSum {

    // Exercise 1: buildPrefixSum
    // TODO: Build prefix sum array for intArrayOf(1, 2, 3, 4, 5).
    // TODO: Return list [0, 1, 3, 6, 10, 15] (size n+1, prefix[0]=0).
    fun exercise1_buildPrefixSum(): List<Int> = TODO()

    // Exercise 2: rangeSumQuery
    // TODO: Given intArrayOf(1, 2, 3, 4, 5), return sum of elements from index 1 to 3 (inclusive).
    // TODO: Use prefix sum. Expected: 2+3+4 = 9.
    fun exercise2_rangeSumQuery(): Int = TODO()

    // Exercise 3: equilibriumIndex
    // TODO: Find equilibrium index where left sum == right sum.
    // TODO: In intArrayOf(-7, 1, 5, 2, -4, 3, 0). Return index (3: left=-1, right=-1).
    fun exercise3_equilibriumIndex(): Int = TODO()

    // Exercise 4: subarraySumEqualsK
    // TODO: Count subarrays with sum = 3 in intArrayOf(1, 1, 1, 2, 1). Return count.
    fun exercise4_subarraySumEqualsK(): Int = TODO()

    // Exercise 5: productExceptSelf
    // TODO: Return array where each element is product of all others.
    // TODO: Input: intArrayOf(1, 2, 3, 4). Expected: [24, 12, 8, 6].
    fun exercise5_productExceptSelf(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_buildPrefixSum() == listOf(0, 1, 3, 6, 10, 15)) { "Exercise 1 failed" }
        assert(exercise2_rangeSumQuery() == 9) { "Exercise 2 failed" }
        assert(exercise3_equilibriumIndex() == 3) { "Exercise 3 failed" }
        assert(exercise4_subarraySumEqualsK() == 3) { "Exercise 4 failed" }
        assert(exercise5_productExceptSelf() == listOf(24, 12, 8, 6)) { "Exercise 5 failed" }
        println("All Algo007_PrefixSum exercises passed!")
    }
}
