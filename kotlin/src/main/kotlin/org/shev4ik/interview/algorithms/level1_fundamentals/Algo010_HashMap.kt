package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * HashMap Patterns
 */
object Algo010_HashMap {

    // Exercise 1: twoSum
    // TODO: Find indices of two numbers in intArrayOf(2, 7, 11, 15) that sum to 9.
    // TODO: Return Pair of indices.
    fun exercise1_twoSum(): Pair<Int, Int> = TODO()

    // Exercise 2: groupAnagrams
    // TODO: Group anagrams from listOf("eat","tea","tan","ate","nat","bat").
    // TODO: Return number of groups.
    fun exercise2_groupAnagrams(): Int = TODO()

    // Exercise 3: firstNonRepeating
    // TODO: Find first non-repeating character in "leetcode". Return it.
    fun exercise3_firstNonRepeating(): Char = TODO()

    // Exercise 4: sameFrequency
    // TODO: Check if intArrayOf(1,2,2,3,3,3) and intArrayOf(3,3,3,2,2,1) have same element frequencies.
    fun exercise4_sameFrequency(): Boolean = TODO()

    // Exercise 5: subarraySumK
    // TODO: Count number of contiguous subarrays that sum to 3 in intArrayOf(1,2,1,1,1). Return count.
    fun exercise5_subarraySumK(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_twoSum() == Pair(0, 1)) { "Exercise 1 failed" }
        assert(exercise2_groupAnagrams() == 3) { "Exercise 2 failed" }
        assert(exercise3_firstNonRepeating() == 'l') { "Exercise 3 failed" }
        assert(exercise4_sameFrequency() == true) { "Exercise 4 failed" }
        assert(exercise5_subarraySumK() == 4) { "Exercise 5 failed" }
        println("All Algo010_HashMap exercises passed!")
    }
}
