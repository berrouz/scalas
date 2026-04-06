package org.shev4ik.interview.algorithms.level2_intermediate

/**
 * Advanced two pointers
 */
object Algo036_AdvancedTwoPointers {

    // Exercise 1: threeSum
    // TODO: Find all unique triplets in intArrayOf(-1,0,1,2,-1,-4) that sum to 0.
    // TODO: Sort each triplet. Return sorted list of triplets.
    fun exercise1_threeSum(): List<List<Int>> = TODO()

    // Exercise 2: fourSum
    // TODO: Find all unique quadruplets in intArrayOf(1,0,-1,0,-2,2) that sum to 0.
    // TODO: Return sorted list of quadruplets.
    fun exercise2_fourSum(): List<List<Int>> = TODO()

    // Exercise 3: containerWater
    // TODO: Given heights intArrayOf(1,8,6,2,5,4,8,3,7), find max water area between two lines.
    // TODO: Use two pointers. Return max area.
    fun exercise3_containerWater(): Int = TODO()

    // Exercise 4: trapRainWater
    // TODO: Given heights intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1), compute trapped rain water.
    // TODO: Return total trapped water units.
    fun exercise4_trapRainWater(): Int = TODO()

    // Exercise 5: sortColors
    // TODO: Sort intArrayOf(2,0,2,1,1,0) in-place (Dutch National Flag). Return as list.
    fun exercise5_sortColors(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_threeSum().size == 2) { "Exercise 1 failed" }
        assert(exercise2_fourSum().size == 3) { "Exercise 2 failed" }
        assert(exercise3_containerWater() == 49) { "Exercise 3 failed" }
        assert(exercise4_trapRainWater() == 6) { "Exercise 4 failed" }
        assert(exercise5_sortColors() == listOf(0,0,1,1,2,2)) { "Exercise 5 failed" }
        println("All Algo036_AdvancedTwoPointers exercises passed!")
    }
}
