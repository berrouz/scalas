package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * HashSet Patterns
 */
object Algo011_HashSet {

    // Exercise 1: findDuplicate
    // TODO: Check if intArrayOf(1, 2, 3, 4, 2) contains duplicates.
    fun exercise1_findDuplicate(): Boolean = TODO()

    // Exercise 2: intersection
    // TODO: Find intersection of intArrayOf(1,2,3,4) and intArrayOf(3,4,5,6). Return as Set.
    fun exercise2_intersection(): Set<Int> = TODO()

    // Exercise 3: union
    // TODO: Find union of intArrayOf(1,2,3) and intArrayOf(3,4,5). Return as Set.
    fun exercise3_union(): Set<Int> = TODO()

    // Exercise 4: longestConsecutive
    // TODO: Find length of longest consecutive sequence in intArrayOf(100, 4, 200, 1, 3, 2).
    // TODO: Expected: 4 (sequence: 1,2,3,4).
    fun exercise4_longestConsecutive(): Int = TODO()

    // Exercise 5: hasPairWithSum
    // TODO: Check if intArrayOf(1, 4, 7, 2, 9) has a pair summing to 11. Return true.
    fun exercise5_hasPairWithSum(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_findDuplicate() == true) { "Exercise 1 failed" }
        assert(exercise2_intersection() == setOf(3, 4)) { "Exercise 2 failed" }
        assert(exercise3_union() == setOf(1,2,3,4,5)) { "Exercise 3 failed" }
        assert(exercise4_longestConsecutive() == 4) { "Exercise 4 failed" }
        assert(exercise5_hasPairWithSum() == true) { "Exercise 5 failed" }
        println("All Algo011_HashSet exercises passed!")
    }
}
