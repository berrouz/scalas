package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Backtracking
 */
object Algo025_Backtracking {

    // Exercise 1: permutations
    // TODO: Generate all permutations of listOf(1,2,3). Return count.
    fun exercise1_permutations(): Int = TODO()

    // Exercise 2: combinations
    // TODO: Generate all combinations of size 2 from listOf(1,2,3,4). Return count.
    fun exercise2_combinations(): Int = TODO()

    // Exercise 3: subsets
    // TODO: Generate all subsets of listOf(1,2,3). Return count (2^3 = 8).
    fun exercise3_subsets(): Int = TODO()

    // Exercise 4: nQueens4
    // TODO: Count solutions to 4-Queens problem. Return count.
    fun exercise4_nQueens4(): Int = TODO()

    // Exercise 5: validParentheses
    // TODO: Generate all valid parentheses for n=3. Return count.
    fun exercise5_validParentheses(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_permutations() == 6) { "Exercise 1 failed" }
        assert(exercise2_combinations() == 6) { "Exercise 2 failed" }
        assert(exercise3_subsets() == 8) { "Exercise 3 failed" }
        assert(exercise4_nQueens4() == 2) { "Exercise 4 failed" }
        assert(exercise5_validParentheses() == 5) { "Exercise 5 failed" }
        println("All Algo025_Backtracking exercises passed!")
    }
}
