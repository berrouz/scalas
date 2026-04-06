package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Number Theory (Теорія чисел)=
 *
 * ==Theory: Fundamental Number Theory==
 *
 * '''GCD and Euclidean Algorithm:'''
 * The Greatest Common Divisor (GCD) of two integers a, b can be computed
 * efficiently using Euclid's algorithm: gcd(a, b) = gcd(b, a mod b), with
 * gcd(a, 0) = a. Time complexity: O(log(min(a, b))).
 *
 * '''Extended Euclidean Algorithm:'''
 * Finds integers x, y such that ax + by = gcd(a, b). This is the foundation
 * for computing modular inverses.
 * {{{
 *   If gcd(a, m) = 1, then a has a modular inverse modulo m.
 *   The inverse can be found via extended GCD: a*x + m*y = 1 => x = a^(-1) mod m
 * }}}
 *
 * '''Modular Exponentiation:'''
 * Computes base^exp mod m in O(log exp) time using binary exponentiation:
 * {{{
 *   base^exp mod m:
 *     if exp == 0: return 1
 *     if exp is even: return (base^(exp/2))^2 mod m
 *     if exp is odd:  return base * base^(exp-1) mod m
 * }}}
 *
 * '''Euler's Totient Function φ(n):'''
 * Counts integers in [1, n] coprime to n. For prime p: φ(p) = p - 1.
 * {{{
 *   φ(n) = n * Π(1 - 1/p) for each prime p dividing n
 * }}}
 * '''Euler's theorem:''' If gcd(a, n) = 1, then a^φ(n) ≡ 1 (mod n).
 *
 * '''Fermat's Little Theorem:'''
 * If p is prime and gcd(a, p) = 1, then a^(p-1) ≡ 1 (mod p).
 * Used for primality testing: if a^(p-1) ≢ 1 (mod p) for some a, then p is composite.
 * Caveat: Carmichael numbers fool this test for all coprime bases.
 *
 * '''Chinese Remainder Theorem (CRT):'''
 * If m1, m2 are coprime, the system x ≡ a1 (mod m1), x ≡ a2 (mod m2) has a unique
 * solution modulo m1*m2:
 * {{{
 *   x = a1 * M1 * y1 + a2 * M2 * y2  (mod m1*m2)
 *   where M1 = m2, M2 = m1, and y1 = M1^(-1) mod m1, y2 = M2^(-1) mod m2
 * }}}
 *
 * '''Sieve of Eratosthenes:'''
 * Generates all primes up to n in O(n log log n) time. Mark multiples of each
 * prime starting from p^2 as composite.
 *
 * ==Comparison: Primality Tests==
 *
 * | Method              | Complexity         | Deterministic? | Notes                    |
 * |---------------------|--------------------|----------------|--------------------------|
 * | Trial Division      | O(√n)              | Yes            | Simple but slow          |
 * | Fermat Test         | O(k log² n)        | No             | Fails on Carmichael nums |
 * | Miller-Rabin        | O(k log² n)        | No (usually)   | Much better in practice  |
 * | Sieve (Eratosthenes)| O(n log log n)     | Yes            | Generates all primes ≤ n |
 * | AKS                 | O(log^6 n)         | Yes            | Theoretical breakthrough |
 *
 * ==Interview Tips==
 *
 *  - '''GCD''' is one of the oldest algorithms — know Euclid's method by heart.
 *  - '''Modular exponentiation''' is essential for RSA, Diffie-Hellman, and any
 *    problem involving large powers modulo a number.
 *  - '''CRT''' appears in problems that decompose modular constraints.
 *  - '''Euler's totient''' connects to RSA: decryption uses φ(n) for key generation.
 *  - '''Sieve of Eratosthenes''' is the standard answer for "generate primes up to n."
 *  - Always use Long instead of Int for number theory to avoid overflow with multiplication.
 *  - When computing (a * b) mod m, use ((a % m) * (b % m)) % m to prevent overflow.
 *
 * ==Complexity Note==
 *
 * Euclidean GCD: O(log(min(a,b))). Modular exponentiation: O(log exp).
 * Euler's totient via factorization: O(√n). Sieve: O(n log log n).
 * CRT for two congruences: O(log m) (due to extended GCD).
 */
object Logic014_NumberTheory {

  /**
   * Exercise 1: GCD using Euclidean Algorithm
   *
   * Compute the greatest common divisor of a and b using the Euclidean algorithm.
   * gcd(a, 0) = a, gcd(a, b) = gcd(b, a % b).
   *
   * @param a first integer (non-negative)
   * @param b second integer (non-negative)
   * @return gcd(a, b)
   */
  def exercise1_gcdEuclid(a: Long, b: Long): Long = ???

  /**
   * Exercise 2: Extended Euclidean Algorithm
   *
   * Find gcd(a, b) and integers x, y such that a*x + b*y = gcd(a, b).
   *
   * @param a first integer
   * @param b second integer
   * @return (gcd, x, y) such that a*x + b*y = gcd
   */
  def exercise2_extendedGcd(a: Long, b: Long): (Long, Long, Long) = ???

  /**
   * Exercise 3: Modular Exponentiation
   *
   * Compute (base^exp) mod m efficiently using binary exponentiation.
   *
   * @param base base value
   * @param exp  exponent (non-negative)
   * @param m    modulus (positive)
   * @return (base^exp) mod m
   */
  def exercise3_modularExponentiation(base: Long, exp: Long, m: Long): Long = ???

  /**
   * Exercise 4: Euler's Totient Function
   *
   * Compute φ(n), the count of integers in [1, n] coprime to n.
   * φ(n) = n * Π(1 - 1/p) for each prime factor p of n.
   *
   * @param n positive integer
   * @return φ(n)
   */
  def exercise4_eulerTotient(n: Int): Int = ???

  /**
   * Exercise 5: Chinese Remainder Theorem
   *
   * Solve the system of congruences: x ≡ a1 (mod m1), x ≡ a2 (mod m2),
   * where m1 and m2 are coprime. Returns the unique solution modulo m1*m2.
   *
   * @param a1 remainder modulo m1
   * @param m1 first modulus
   * @param a2 remainder modulo m2
   * @param m2 second modulus
   * @return x such that x ≡ a1 (mod m1) and x ≡ a2 (mod m2), in range [0, m1*m2)
   */
  def exercise5_chineseRemainder(a1: Long, m1: Long, a2: Long, m2: Long): Long = ???

  /**
   * Exercise 6: Modular Inverse
   *
   * Find the modular inverse of a modulo m, i.e., x such that a*x ≡ 1 (mod m).
   * Exists only when gcd(a, m) = 1. Uses extended Euclidean algorithm.
   *
   * @param a value to invert
   * @param m modulus
   * @return Some(x) if inverse exists, None otherwise
   */
  def exercise6_modularInverse(a: Long, m: Long): Option[Long] = ???

  /**
   * Exercise 7: Fermat Primality Test
   *
   * Test if n is likely prime using Fermat's little theorem. Check that
   * a^(n-1) ≡ 1 (mod n) for several bases a. If any base fails, n is composite.
   * Note: this can produce false positives for Carmichael numbers.
   *
   * @param n number to test (n > 1)
   * @return true if n passes Fermat test for bases 2, 3, 5, 7, 11 (where applicable)
   */
  def exercise7_isPrimeFermat(n: Long): Boolean = ???

  /**
   * Exercise 8: Sieve of Eratosthenes
   *
   * Generate all prime numbers up to and including n using the Sieve of Eratosthenes.
   *
   * @param n upper bound (inclusive)
   * @return sorted list of all primes <= n
   */
  def exercise8_sieveOfEratosthenes(n: Int): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: GCD
    assert(exercise1_gcdEuclid(48, 18) == 6)
    assert(exercise1_gcdEuclid(100, 75) == 25)
    assert(exercise1_gcdEuclid(17, 13) == 1)
    assert(exercise1_gcdEuclid(0, 5) == 5)
    assert(exercise1_gcdEuclid(12, 0) == 12)
    println("Exercise 1 passed: gcdEuclid")

    // Exercise 2: Extended GCD
    val (g1, x1, y1) = exercise2_extendedGcd(35, 15)
    assert(g1 == 5)
    assert(35 * x1 + 15 * y1 == 5)
    val (g2, x2, y2) = exercise2_extendedGcd(17, 13)
    assert(g2 == 1)
    assert(17 * x2 + 13 * y2 == 1)
    println("Exercise 2 passed: extendedGcd")

    // Exercise 3: Modular Exponentiation
    assert(exercise3_modularExponentiation(2, 10, 1000) == 1024)
    assert(exercise3_modularExponentiation(3, 13, 100) == 3L * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 % 100)
    assert(exercise3_modularExponentiation(2, 20, 1000000007) == 1048576)
    assert(exercise3_modularExponentiation(5, 0, 7) == 1)
    println("Exercise 3 passed: modularExponentiation")

    // Exercise 4: Euler's Totient
    assert(exercise4_eulerTotient(1) == 1)
    assert(exercise4_eulerTotient(7) == 6)   // prime: φ(p) = p - 1
    assert(exercise4_eulerTotient(10) == 4)  // 1, 3, 7, 9
    assert(exercise4_eulerTotient(12) == 4)  // 1, 5, 7, 11
    assert(exercise4_eulerTotient(36) == 12)
    println("Exercise 4 passed: eulerTotient")

    // Exercise 5: Chinese Remainder Theorem
    // x ≡ 2 (mod 3), x ≡ 3 (mod 5) => x = 8
    assert(exercise5_chineseRemainder(2, 3, 3, 5) == 8)
    // x ≡ 1 (mod 3), x ≡ 4 (mod 5) => x = 4
    assert(exercise5_chineseRemainder(1, 3, 4, 5) == 4)
    // x ≡ 3 (mod 7), x ≡ 2 (mod 11) => x = 24
    assert(exercise5_chineseRemainder(3, 7, 2, 11) == 24)
    println("Exercise 5 passed: chineseRemainder")

    // Exercise 6: Modular Inverse
    assert(exercise6_modularInverse(3, 7) == Some(5))   // 3*5 = 15 ≡ 1 (mod 7)
    assert(exercise6_modularInverse(2, 6) == None)       // gcd(2,6) = 2 ≠ 1
    assert(exercise6_modularInverse(7, 11) == Some(8))   // 7*8 = 56 ≡ 1 (mod 11)
    println("Exercise 6 passed: modularInverse")

    // Exercise 7: Fermat Primality Test
    assert(exercise7_isPrimeFermat(2) == true)
    assert(exercise7_isPrimeFermat(17) == true)
    assert(exercise7_isPrimeFermat(97) == true)
    assert(exercise7_isPrimeFermat(15) == false)
    assert(exercise7_isPrimeFermat(100) == false)
    println("Exercise 7 passed: isPrimeFermat")

    // Exercise 8: Sieve of Eratosthenes
    assert(exercise8_sieveOfEratosthenes(10) == List(2, 3, 5, 7))
    assert(exercise8_sieveOfEratosthenes(20) == List(2, 3, 5, 7, 11, 13, 17, 19))
    assert(exercise8_sieveOfEratosthenes(1) == List())
    assert(exercise8_sieveOfEratosthenes(2) == List(2))
    assert(exercise8_sieveOfEratosthenes(30) == List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
    println("Exercise 8 passed: sieveOfEratosthenes")

    println("\nAll exercises passed!")
  }
}
