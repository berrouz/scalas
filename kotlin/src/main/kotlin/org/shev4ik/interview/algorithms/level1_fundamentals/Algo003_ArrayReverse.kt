package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Array Reverse
 */
object Algo003_ArrayReverse {

    // Exercise 1: reverseInPlace
    // TODO: Reverse intArrayOf(1, 2, 3, 4, 5) in place. Return as list.
    fun exercise1_reverseInPlace(): List<Int> = TODO()

    // Exercise 2: reverseCopy
    // TODO: Return a reversed copy of intArrayOf(10, 20, 30) without modifying original.
    fun exercise2_reverseCopy(): List<Int> = TODO()

    // Exercise 3: isPalindrome
    // TODO: Check if intArrayOf(1, 2, 3, 2, 1) is a palindrome.
    fun exercise3_isPalindrome(): Boolean = TODO()

    // Exercise 4: reverseSubarray
    // TODO: Reverse elements from index 1 to 3 in intArrayOf(1, 2, 3, 4, 5). Return as list.
    // TODO: Expected: [1, 4, 3, 2, 5].
    fun exercise4_reverseSubarray(): List<Int> = TODO()

    // Exercise 5: rotateUsingReverse
    // TODO: Rotate intArrayOf(1,2,3,4,5) left by 2 using the reverse algorithm.
    // TODO: Expected: [3, 4, 5, 1, 2].
    fun exercise5_rotateUsingReverse(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_reverseInPlace() == listOf(5, 4, 3, 2, 1)) { "Exercise 1 failed" }
        assert(exercise2_reverseCopy() == listOf(30, 20, 10)) { "Exercise 2 failed" }
        assert(exercise3_isPalindrome() == true) { "Exercise 3 failed" }
        assert(exercise4_reverseSubarray() == listOf(1, 4, 3, 2, 5)) { "Exercise 4 failed" }
        assert(exercise5_rotateUsingReverse() == listOf(3, 4, 5, 1, 2)) { "Exercise 5 failed" }
        println("All Algo003_ArrayReverse exercises passed!")
    }
}
