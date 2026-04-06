package org.shev4ik.interview.algorithms.level1_fundamentals

/**
 * Math Fundamentals
 */
object Algo030_MathBasics {

    // Exercise 1: gcd
    // TODO: Compute GCD of 48 and 18 using Euclidean algorithm. Return 6.
    fun exercise1_gcd(): Int = TODO()

    // Exercise 2: lcm
    // TODO: Compute LCM of 12 and 18. Return 36.
    fun exercise2_lcm(): Int = TODO()

    // Exercise 3: isPrime
    // TODO: Check if 97 is prime. Return true.
    fun exercise3_isPrime(): Boolean = TODO()

    // Exercise 4: sieve
    // TODO: Return all primes up to 20 using Sieve of Eratosthenes.
    fun exercise4_sieve(): List<Int> = TODO()

    // Exercise 5: primeFactors
    // TODO: Return prime factorization of 60: [2, 2, 3, 5].
    fun exercise5_primeFactors(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_gcd() == 6) { "Exercise 1 failed" }
        assert(exercise2_lcm() == 36) { "Exercise 2 failed" }
        assert(exercise3_isPrime() == true) { "Exercise 3 failed" }
        assert(exercise4_sieve() == listOf(2,3,5,7,11,13,17,19)) { "Exercise 4 failed" }
        assert(exercise5_primeFactors() == listOf(2,2,3,5)) { "Exercise 5 failed" }
        println("All Algo030_MathBasics exercises passed!")
    }
}
