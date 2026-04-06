package org.shev4ik.interview.kotlin_core.level2_intermediate

/**
 * Tailrec Functions
 */
object Core046_TailrecFunctions {

    // Exercise 1: tailrecFactorial
    // TODO: Write tailrec fun factorial(n: Int, acc: Long = 1): Long.
    // TODO: Return factorial(10).
    fun exercise1_tailrecFactorial(): Long = TODO()

    // Exercise 2: tailrecFibonacci
    // TODO: Write tailrec fun fib(n: Int, a: Long = 0, b: Long = 1): Long.
    // TODO: Return fib(10).
    fun exercise2_tailrecFibonacci(): Long = TODO()

    // Exercise 3: tailrecSum
    // TODO: Write tailrec fun sumTo(n: Int, acc: Int = 0): Int.
    // TODO: Return sumTo(100).
    fun exercise3_tailrecSum(): Int = TODO()

    // Exercise 4: tailrecGCD
    // TODO: Write tailrec fun gcd(a: Int, b: Int): Int using Euclidean algorithm.
    // TODO: Return gcd(48, 18).
    fun exercise4_tailrecGCD(): Int = TODO()

    // Exercise 5: tailrecBinarySearch
    // TODO: Write tailrec fun binSearch(arr: IntArray, target: Int, lo: Int, hi: Int): Int.
    // TODO: Search for 7 in intArrayOf(1,3,5,7,9,11). Return index.
    fun exercise5_tailrecBinarySearch(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tailrecFactorial() == 3628800L) { "Exercise 1 failed" }
        assert(exercise2_tailrecFibonacci() == 55L) { "Exercise 2 failed" }
        assert(exercise3_tailrecSum() == 5050) { "Exercise 3 failed" }
        assert(exercise4_tailrecGCD() == 6) { "Exercise 4 failed" }
        assert(exercise5_tailrecBinarySearch() == 3) { "Exercise 5 failed" }
        println("All Core046_TailrecFunctions exercises passed!")
    }
}
