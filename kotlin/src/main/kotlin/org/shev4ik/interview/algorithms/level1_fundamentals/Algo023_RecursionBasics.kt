package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Recursion Basics
 */
object Algo023_RecursionBasics {

    // Exercise 1: factorial
    // TODO: Compute factorial of 10 recursively.
    fun exercise1_factorial(): Long = TODO()

    // Exercise 2: fibonacci
    // TODO: Compute 10th fibonacci number (0,1,1,2,3,5,8,13,21,34,...). Return 55.
    fun exercise2_fibonacci(): Int = TODO()

    // Exercise 3: power
    // TODO: Compute 2^10 recursively. Return 1024.
    fun exercise3_power(): Int = TODO()

    // Exercise 4: sumOfDigits
    // TODO: Compute sum of digits of 12345 recursively. Return 15.
    fun exercise4_sumOfDigits(): Int = TODO()

    // Exercise 5: countDigits
    // TODO: Count number of digits in 123456 recursively. Return 6.
    fun exercise5_countDigits(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_factorial() == 3628800L) { "Exercise 1 failed" }
        assert(exercise2_fibonacci() == 55) { "Exercise 2 failed" }
        assert(exercise3_power() == 1024) { "Exercise 3 failed" }
        assert(exercise4_sumOfDigits() == 15) { "Exercise 4 failed" }
        assert(exercise5_countDigits() == 6) { "Exercise 5 failed" }
        println("All Algo023_RecursionBasics exercises passed!")
    }
}
