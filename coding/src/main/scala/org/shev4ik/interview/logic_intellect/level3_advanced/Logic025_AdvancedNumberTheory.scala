package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Advanced Number Theory (Просунута теорія чисел)=
 *
 * ==Theory: Primality Testing, Factorization, and Cryptographic Primitives==
 *
 * Advanced number theory forms the backbone of modern cryptography and appears
 * in competitive programming and quantitative interviews. These algorithms are
 * essential for RSA, Diffie-Hellman, and other cryptographic protocols.
 *
 * '''Miller-Rabin Primality Test:''' A probabilistic primality test. Write
 * n-1 = 2^s * d (d odd). For a witness a, n is composite if:
 * {{{
 *   a^d ≢ 1 (mod n)  AND  a^(2^r * d) ≢ -1 (mod n) for all r ∈ [0, s-1]
 * }}}
 * If n passes for witness a, it may still be composite (pseudoprime to base a).
 * Deterministic for n < 3,215,031,751 with witnesses {2, 3, 5, 7}.
 *
 * '''Pollard's Rho Algorithm:''' A probabilistic factorization algorithm.
 * Uses Floyd's cycle detection on the sequence x_{i+1} = x_i^2 + c (mod n).
 * Expected time: O(n^(1/4)) — much faster than trial division for large n.
 * {{{
 *   x = y = 2, c = 1
 *   repeat: x = f(x), y = f(f(y)), d = gcd(|x-y|, n)
 *   until d != 1
 * }}}
 *
 * '''Mobius Function μ(n):'''
 * {{{
 *   μ(1) = 1
 *   μ(n) = 0       if n has a squared prime factor
 *   μ(n) = (-1)^k   if n is a product of k distinct primes
 * }}}
 * Central to Mobius inversion and the inclusion-exclusion principle in
 * number theory. Used in computing Euler's totient via: φ(n) = Σ_{d|n} μ(d) * (n/d).
 *
 * '''Legendre Symbol (a/p):''' For odd prime p:
 * {{{
 *   (a/p) = 0   if p | a
 *   (a/p) = 1   if a is a quadratic residue mod p (∃x: x² ≡ a mod p)
 *   (a/p) = -1  if a is a quadratic non-residue mod p
 * }}}
 * Computed via Euler's criterion: (a/p) ≡ a^((p-1)/2) (mod p).
 *
 * '''Discrete Logarithm (Baby-Step Giant-Step):''' Find x such that g^x ≡ h (mod p).
 * {{{
 *   m = ceil(sqrt(p))
 *   Baby steps:  compute g^j mod p for j = 0, 1, ..., m-1
 *   Giant steps: compute h * g^(-im) mod p for i = 0, 1, ..., m-1
 *   Match: x = im + j
 * }}}
 * Time: O(sqrt(p)) with O(sqrt(p)) space.
 *
 * '''Primitive Root:''' An integer g is a primitive root modulo p if the
 * multiplicative order of g is p-1 (i.e., g generates all of Z/pZ*).
 * Every prime has a primitive root. To find the smallest one, check if
 * g^((p-1)/q) ≢ 1 (mod p) for all prime factors q of p-1.
 *
 * '''Sum of Two Squares (Fermat):''' A positive integer n can be expressed
 * as a sum of two squares iff in the prime factorization of n, every prime
 * of the form 4k+3 occurs to an even power.
 *
 * '''Continued Fractions:''' Every rational p/q has a finite continued
 * fraction representation [a0; a1, a2, ...] computed by the Euclidean algorithm:
 * {{{
 *   a0 = floor(p/q), then repeat with (q, p mod q)
 * }}}
 *
 * ==Comparison: Number-Theoretic Algorithms==
 *
 * | Algorithm          | Purpose                  | Time Complexity     | Space      |
 * |--------------------|--------------------------|---------------------|------------|
 * | Trial Division     | Primality / factorization| O(√n)               | O(1)       |
 * | Miller-Rabin       | Primality testing        | O(k * log²(n))      | O(1)       |
 * | Pollard's Rho      | Factorization            | O(n^(1/4))          | O(1)       |
 * | Baby-Step Giant-Step| Discrete logarithm      | O(√p)               | O(√p)      |
 * | Sieve of Eratosthenes| Find all primes ≤ n   | O(n log log n)      | O(n)       |
 *
 * ==Interview Tips==
 *
 *  - '''Miller-Rabin''' is the standard interview primality test for large numbers.
 *  - '''Pollard's Rho''' shows you understand sub-√n factorization — impressive in interviews.
 *  - '''Mobius function''' connects to inclusion-exclusion and sieve methods.
 *  - '''Legendre symbol''' and quadratic residues appear in crypto interviews.
 *  - '''Primitive roots''' are key to understanding Diffie-Hellman key exchange.
 *  - For '''sum of two squares''', Fermat's theorem gives a beautiful characterization.
 *  - '''Continued fractions''' connect to best rational approximations (Stern-Brocot tree).
 *  - Always use modular exponentiation (fast power) to avoid overflow: O(log n) multiplications.
 *
 * ==Complexity Note==
 *
 * All modular arithmetic operations should use fast modular exponentiation
 * (binary exponentiation) running in O(log exponent) multiplications.
 * Use Long arithmetic carefully to avoid overflow in intermediate computations.
 */
object Logic025_AdvancedNumberTheory {

  /**
   * Exercise 1: Miller-Rabin Primality Test
   *
   * Determine if n is (probably) prime using the Miller-Rabin test with the
   * given list of witnesses. Write n-1 = 2^s * d (d odd). For each witness a,
   * check if a^d ≡ 1 (mod n) or a^(2^r * d) ≡ -1 (mod n) for some r in [0, s-1].
   * If any witness reveals n as composite, return false.
   *
   * @param n         the number to test (n >= 2)
   * @param witnesses list of witness values to test against
   * @return true if n passes the Miller-Rabin test for all given witnesses
   */
  def exercise1_millerRabin(n: Long, witnesses: List[Long]): Boolean = ???

  /**
   * Exercise 2: Pollard's Rho Factorization
   *
   * Find a non-trivial factor of n using Pollard's rho algorithm.
   * Use the iteration x = (x*x + c) mod n with Floyd's cycle detection.
   * If n is prime, the behavior is undefined (may loop or return n).
   *
   * @param n a composite number (n > 1)
   * @return a non-trivial factor of n (1 < factor < n)
   */
  def exercise2_pollardRho(n: Long): Long = ???

  /**
   * Exercise 3: Mobius Function
   *
   * Compute the Mobius function μ(n):
   * - μ(1) = 1
   * - μ(n) = 0 if n has a squared prime factor
   * - μ(n) = (-1)^k if n is a product of k distinct primes
   *
   * @param n positive integer (n >= 1)
   * @return μ(n): one of -1, 0, or 1
   */
  def exercise3_mobiusFunction(n: Int): Int = ???

  /**
   * Exercise 4: Legendre Symbol
   *
   * Compute the Legendre symbol (a/p) for an odd prime p using Euler's criterion:
   * (a/p) ≡ a^((p-1)/2) (mod p).
   * Result is 0 if p divides a, 1 if a is a QR mod p, -1 if a is a QNR mod p.
   *
   * @param a an integer
   * @param p an odd prime
   * @return the Legendre symbol: -1, 0, or 1
   */
  def exercise4_legendreSymbol(a: Long, p: Long): Int = ???

  /**
   * Exercise 5: Discrete Logarithm (Baby-Step Giant-Step)
   *
   * Find x such that g^x ≡ h (mod p), using the baby-step giant-step algorithm.
   * Returns None if no solution exists in [0, p-2].
   *
   * @param g base (generator or any element)
   * @param h target value
   * @param p modulus (prime)
   * @return Some(x) where g^x ≡ h (mod p), or None if no solution
   */
  def exercise5_discreteLog(g: Long, h: Long, p: Long): Option[Long] = ???

  /**
   * Exercise 6: Smallest Primitive Root
   *
   * Find the smallest primitive root modulo a prime p. An integer g is a
   * primitive root if ord_p(g) = p-1, i.e., g generates all of (Z/pZ)*.
   * Check by verifying g^((p-1)/q) ≢ 1 (mod p) for all prime factors q of p-1.
   *
   * @param p a prime number (p >= 2)
   * @return the smallest primitive root modulo p
   */
  def exercise6_primitiveRoot(p: Long): Long = ???

  /**
   * Exercise 7: Sum of Two Squares
   *
   * Determine if n can be written as a sum of two squares (a² + b² = n),
   * and if so, return one such pair (a, b) with a <= b.
   * By Fermat's theorem, this is possible iff every prime factor of the form
   * 4k+3 appears to an even power.
   *
   * @param n a positive integer
   * @return Some((a, b)) where a² + b² = n and a <= b, or None if impossible
   */
  def exercise7_sumOfTwoSquares(n: Long): Option[(Long, Long)] = ???

  /**
   * Exercise 8: Continued Fraction Representation
   *
   * Compute the continued fraction representation of the rational number p/q.
   * The result is [a0; a1, a2, ..., ak] where:
   * p/q = a0 + 1/(a1 + 1/(a2 + ... + 1/ak))
   * Computed via the Euclidean algorithm.
   *
   * @param p numerator (non-negative)
   * @param q denominator (positive)
   * @return list of continued fraction coefficients
   */
  def exercise8_continuedFraction(p: Long, q: Long): List[Long] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Miller-Rabin
    assert(exercise1_millerRabin(2, List(2)) == true)
    assert(exercise1_millerRabin(3, List(2)) == true)
    assert(exercise1_millerRabin(17, List(2, 3)) == true)
    assert(exercise1_millerRabin(561, List(2)) == false)   // 561 = 3*11*17, Carmichael number
    assert(exercise1_millerRabin(997, List(2, 3, 5)) == true)
    assert(exercise1_millerRabin(15, List(2, 3)) == false)
    assert(exercise1_millerRabin(7919, List(2, 3, 5, 7)) == true)  // prime
    println("Exercise 1 passed: millerRabin")

    // Exercise 2: Pollard's Rho
    val factor91 = exercise2_pollardRho(91)   // 91 = 7 * 13
    assert(factor91 == 7 || factor91 == 13, s"Expected 7 or 13, got $factor91")
    val factor15 = exercise2_pollardRho(15)   // 15 = 3 * 5
    assert(factor15 == 3 || factor15 == 5, s"Expected 3 or 5, got $factor15")
    val factor8051 = exercise2_pollardRho(8051)  // 8051 = 83 * 97
    assert(8051 % factor8051 == 0 && factor8051 > 1 && factor8051 < 8051)
    println("Exercise 2 passed: pollardRho")

    // Exercise 3: Mobius Function
    assert(exercise3_mobiusFunction(1) == 1)
    assert(exercise3_mobiusFunction(2) == -1)   // one prime factor
    assert(exercise3_mobiusFunction(6) == 1)    // 2*3, two distinct primes
    assert(exercise3_mobiusFunction(4) == 0)    // 2^2, squared factor
    assert(exercise3_mobiusFunction(30) == -1)  // 2*3*5, three distinct primes
    assert(exercise3_mobiusFunction(12) == 0)   // 2^2*3, squared factor
    println("Exercise 3 passed: mobiusFunction")

    // Exercise 4: Legendre Symbol
    assert(exercise4_legendreSymbol(0, 5) == 0)    // 5 | 0
    assert(exercise4_legendreSymbol(1, 5) == 1)    // 1 is always QR
    assert(exercise4_legendreSymbol(2, 7) == 1)    // 3^2 = 9 ≡ 2 mod 7
    assert(exercise4_legendreSymbol(3, 7) == -1)   // 3 is QNR mod 7
    assert(exercise4_legendreSymbol(4, 7) == 1)    // 2^2 = 4
    assert(exercise4_legendreSymbol(5, 7) == -1)   // 5 is QNR mod 7
    println("Exercise 4 passed: legendreSymbol")

    // Exercise 5: Discrete Logarithm
    // 2^x ≡ 8 (mod 13) → x = 3 (since 2^3 = 8)
    assert(exercise5_discreteLog(2, 8, 13) == Some(3L))
    // 2^x ≡ 1 (mod 13) → x = 12 (since ord_13(2) = 12) or x = 0
    val dl1 = exercise5_discreteLog(2, 1, 13)
    assert(dl1.isDefined)
    assert(BigInt(2).modPow(BigInt(dl1.get), BigInt(13)) == BigInt(1))
    // 3^x ≡ 5 (mod 7) → 3^5 = 243 ≡ 243 - 34*7 = 243-238 = 5, so x = 5
    assert(exercise5_discreteLog(3, 5, 7) == Some(5L))
    println("Exercise 5 passed: discreteLog")

    // Exercise 6: Primitive Root
    assert(exercise6_primitiveRoot(2) == 1L)
    assert(exercise6_primitiveRoot(3) == 2L)
    assert(exercise6_primitiveRoot(5) == 2L)
    assert(exercise6_primitiveRoot(7) == 3L)
    assert(exercise6_primitiveRoot(11) == 2L)
    assert(exercise6_primitiveRoot(13) == 2L)
    assert(exercise6_primitiveRoot(23) == 5L)
    println("Exercise 6 passed: primitiveRoot")

    // Exercise 7: Sum of Two Squares
    // 5 = 1 + 4 = 1² + 2²
    val s5 = exercise7_sumOfTwoSquares(5)
    assert(s5.isDefined)
    assert(s5.get._1 * s5.get._1 + s5.get._2 * s5.get._2 == 5)
    assert(s5.get._1 <= s5.get._2)
    // 25 = 0 + 25 = 0² + 5² or 9 + 16 = 3² + 4²
    val s25 = exercise7_sumOfTwoSquares(25)
    assert(s25.isDefined)
    assert(s25.get._1 * s25.get._1 + s25.get._2 * s25.get._2 == 25)
    // 3 cannot be written as sum of two squares
    assert(exercise7_sumOfTwoSquares(3) == None)
    // 7 cannot either (7 ≡ 3 mod 4 and appears to odd power)
    assert(exercise7_sumOfTwoSquares(7) == None)
    println("Exercise 7 passed: sumOfTwoSquares")

    // Exercise 8: Continued Fraction
    // 7/3 = 2 + 1/3 → [2, 3]
    assert(exercise8_continuedFraction(7, 3) == List(2L, 3L))
    // 13/4 = 3 + 1/4 → [3, 4]
    assert(exercise8_continuedFraction(13, 4) == List(3L, 4L))
    // 355/113 = [3; 7, 16] since 355/113 = 3 + 16/113, 113/16 = 7 + 1/16
    assert(exercise8_continuedFraction(355, 113) == List(3L, 7L, 16L))
    // 1/1 = [1]
    assert(exercise8_continuedFraction(1, 1) == List(1L))
    // 0/1 = [0]
    assert(exercise8_continuedFraction(0, 1) == List(0L))
    println("Exercise 8 passed: continuedFraction")

    println("\nAll exercises passed!")
  }
}
