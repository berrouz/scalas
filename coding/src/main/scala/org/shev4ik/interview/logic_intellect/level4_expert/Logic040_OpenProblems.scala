package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Famous Open Problems and Conjectures (Відомі відкриті проблеми)=
 *
 * ==Theory: The Frontier of Mathematics and Computer Science==
 *
 * Some of the most profound questions in mathematics remain unsolved. While
 * we cannot solve these problems, we can verify conjectures computationally
 * for specific cases and understand the structures behind them. These problems
 * appear in interviews to test depth of mathematical knowledge and curiosity.
 *
 * '''Goldbach's Conjecture (1742):''' Every even integer greater than 2 is the
 * sum of two primes. Verified computationally up to 4×10^18. Helfgott (2013)
 * proved the weak version: every odd number > 5 is the sum of three primes.
 * No proof for the strong (binary) conjecture is known.
 *
 * '''Twin Prime Conjecture:''' There are infinitely many primes p such that
 * p + 2 is also prime. Zhang (2013) proved there are infinitely many pairs
 * with gap at most 70,000,000. Maynard and Tao reduced this to 246. The
 * conjecture asserts gap 2 occurs infinitely often.
 *
 * '''Collatz Conjecture (3n+1 Problem):''' Start with any positive integer n.
 * If even, divide by 2; if odd, multiply by 3 and add 1. The conjecture
 * states this process always reaches 1. Verified for all n up to ~10^20.
 * Erdős said "Mathematics may not be ready for such problems." Tao (2019)
 * proved that the Collatz conjecture is true for "almost all" numbers in a
 * logarithmic density sense.
 *
 * '''Perfect Numbers:''' A number n is perfect if the sum of its proper
 * divisors equals n. Known examples: 6, 28, 496, 8128. All known perfect
 * numbers are even, of the form 2^(p-1)(2^p - 1) where 2^p - 1 is a
 * Mersenne prime. It is unknown whether odd perfect numbers exist.
 *
 * '''Amicable Numbers:''' Two numbers (a, b) where the sum of proper divisors
 * of a equals b and vice versa. The smallest pair is (220, 284). Over 1.2
 * billion pairs are known, but it is unknown if infinitely many exist.
 *
 * '''Riemann Hypothesis (1859):''' All non-trivial zeros of the Riemann zeta
 * function ζ(s) = Σ(1/k^s) have real part 1/2. This is arguably the most
 * important unsolved problem in mathematics, with deep implications for the
 * distribution of primes. The first 10^13 zeros have been verified.
 *
 * '''P vs NP:''' Can every problem whose solution can be verified in
 * polynomial time also be solved in polynomial time? One of the seven
 * Millennium Prize Problems ($1,000,000 bounty). Most experts believe P ≠ NP.
 *
 * ==Comparison: Open Problems Status==
 *
 * | Problem           | Year Posed | Verified Up To   | Best Partial Result           |
 * |-------------------|-----------|------------------|-------------------------------|
 * | Goldbach          | 1742      | 4×10^18          | Weak version proved (2013)    |
 * | Twin Primes       | ~1846     | 10^18            | Bounded gaps ≤ 246            |
 * | Collatz           | 1937      | ~10^20           | "Almost all" (Tao, 2019)      |
 * | Riemann           | 1859      | 10^13 zeros      | Many equivalent formulations  |
 * | P vs NP           | 1971      | N/A              | No proof either direction     |
 * | Odd Perfect Num   | ~300 BC   | 10^1500          | Must have ≥ 11 prime factors  |
 *
 * ==Interview Tips==
 *
 *  - '''Goldbach verification''' is a nice warm-up: iterate primes and check.
 *  - '''Collatz''' appears in interviews as a simulation/memoization problem.
 *  - '''Twin primes''' is good for sieve-based algorithms (Sieve of Eratosthenes).
 *  - '''Perfect numbers''' test understanding of divisor sums and number theory.
 *  - '''Amicable numbers''' combine divisor-sum computation with pair-finding.
 *  - '''Riemann zeta''' partial sums test floating-point computation skills.
 *  - '''Prime gaps''' combine sieve generation with tracking maximum differences.
 *  - Knowing these open problems demonstrates '''mathematical maturity''' in interviews.
 *
 * ==Complexity Note==
 *
 * Sieve of Eratosthenes is O(n log log n). Goldbach verification for a single
 * n is O(n) with a prime lookup set. Collatz sequence computation is O(steps)
 * per number. Divisor sum is O(√n) per number.
 */
object Logic040_OpenProblems {

  /**
   * Exercise 1: Goldbach Conjecture Verification
   *
   * Given an even number n > 2, find two primes p and q such that p + q = n.
   * Return the pair (p, q) with p <= q. If n is odd or n <= 2, behavior is
   * undefined (assume valid input).
   *
   * @param n an even number greater than 2
   * @return a pair (p, q) of primes with p <= q and p + q = n
   */
  def exercise1_goldbachVerify(n: Int): (Int, Int) = ???

  /**
   * Exercise 2: Twin Primes
   *
   * Find all twin prime pairs (p, p+2) where both p and p+2 are prime and
   * p+2 <= n. Return as a list of pairs. The upper bound n applies to p+2
   * (i.e., we include the pair if both p and p+2 are prime and p+2 <= n).
   *
   * @param n upper bound (inclusive) — applies to the larger prime p+2
   * @return list of (p, p+2) twin prime pairs where p+2 <= n
   */
  def exercise2_twinPrimes(n: Int): List[(Int, Int)] = ???

  /**
   * Exercise 3: Collatz — Longest Sequence
   *
   * Find the starting number <= n that produces the longest Collatz sequence.
   * The Collatz sequence: if even, n/2; if odd, 3n+1; repeat until reaching 1.
   * Sequence length includes the starting number and the final 1.
   *
   * @param n upper bound for starting numbers (n >= 1)
   * @return (startingNumber, sequenceLength) for the longest sequence
   */
  def exercise3_collatzMaxSequence(n: Int): (Int, Int) = ???

  /**
   * Exercise 4: Perfect Numbers
   *
   * A perfect number equals the sum of its proper divisors. Find all perfect
   * numbers up to and including n. Known perfect numbers: 6, 28, 496, 8128, ...
   *
   * @param n upper bound (inclusive)
   * @return list of perfect numbers up to n, in ascending order
   */
  def exercise4_perfectNumbers(n: Int): List[Int] = ???

  /**
   * Exercise 5: Amicable Numbers (Friendly Pairs)
   *
   * Two distinct numbers a and b are amicable if the sum of proper divisors
   * of a equals b and the sum of proper divisors of b equals a. Find all
   * amicable pairs (a, b) with a < b and both <= n.
   *
   * @param n upper bound (inclusive)
   * @return list of amicable pairs (a, b) with a < b
   */
  def exercise5_friendlyNumbers(n: Int): List[(Int, Int)] = ???

  /**
   * Exercise 6: Riemann Zeta Function (Partial Sum)
   *
   * Compute an approximation of the Riemann zeta function for real s > 1:
   * ζ(s) = Σ_{k=1}^{terms} 1/k^s
   * This converges to the true value as terms → ∞.
   *
   * @param s     real value with s > 1
   * @param terms number of terms to sum (terms >= 1)
   * @return approximate value of ζ(s)
   */
  def exercise6_riemannZeta(s: Double, terms: Int): Double = ???

  /**
   * Exercise 7: Maximum Prime Gap
   *
   * Find the maximum gap between consecutive primes up to n. Return the two
   * primes bounding the largest gap and the gap size.
   *
   * @param n upper bound (n >= 3)
   * @return (prime1, prime2, gap) where gap = prime2 - prime1 is maximal
   */
  def exercise7_primeGaps(n: Int): (Int, Int, Int) = ???

  /**
   * Exercise 8: Collatz — Highest Value Reached
   *
   * Find the starting number <= n whose Collatz sequence reaches the highest
   * value. This tests for "record-breaking" hailstone numbers.
   *
   * @param n upper bound for starting numbers (n >= 1)
   * @return (startingNumber, maxValueReached) as (Int, Long)
   */
  def exercise8_hailstoneRecord(n: Int): (Int, Long) = ???

  def main(args: Array[String]): Unit = {

    // Exercise 1: Goldbach Verification
    val gb10 = exercise1_goldbachVerify(10)
    assert(gb10._1 + gb10._2 == 10, s"Goldbach pair should sum to 10, got $gb10")
    assert(gb10._1 <= gb10._2, "First element should be <= second")
    println(s"Exercise 1 - Goldbach(10): $gb10")

    val gb28 = exercise1_goldbachVerify(28)
    assert(gb28._1 + gb28._2 == 28, s"Goldbach pair should sum to 28, got $gb28")
    println(s"Exercise 1 - Goldbach(28): $gb28")

    // Exercise 2: Twin Primes
    val twins31 = exercise2_twinPrimes(31)
    assert(twins31.contains((3, 5)), "Should contain (3,5)")
    assert(twins31.contains((5, 7)), "Should contain (5,7)")
    assert(twins31.contains((11, 13)), "Should contain (11,13)")
    assert(twins31.contains((17, 19)), "Should contain (17,19)")
    assert(twins31.contains((29, 31)), "Should contain (29,31)")
    println(s"Exercise 2 - Twin primes up to 31: $twins31")

    // Exercise 3: Collatz Longest Sequence
    val collatz10 = exercise3_collatzMaxSequence(10)
    // 9 has the longest sequence for n<=10: 9,28,14,7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1 = 20 steps
    assert(collatz10._1 == 9, s"Longest Collatz sequence for n<=10 starts at 9, got ${collatz10._1}")
    assert(collatz10._2 == 20, s"Collatz sequence length for 9 should be 20, got ${collatz10._2}")
    println(s"Exercise 3 - Collatz longest (n<=10): $collatz10")

    // Exercise 4: Perfect Numbers
    val perfect10000 = exercise4_perfectNumbers(10000)
    assert(perfect10000 == List(6, 28, 496, 8128), s"Perfect numbers up to 10000: expected [6,28,496,8128], got $perfect10000")
    println(s"Exercise 4 - Perfect numbers up to 10000: $perfect10000")

    // Exercise 5: Amicable Numbers
    val amicable300 = exercise5_friendlyNumbers(300)
    assert(amicable300.contains((220, 284)), "Should contain amicable pair (220, 284)")
    println(s"Exercise 5 - Amicable pairs up to 300: $amicable300")

    // Exercise 6: Riemann Zeta
    val zeta2 = exercise6_riemannZeta(2.0, 100000)
    // ζ(2) = π²/6 ≈ 1.6449340668
    assert(math.abs(zeta2 - math.Pi * math.Pi / 6.0) < 0.001,
      s"ζ(2) ≈ π²/6 ≈ 1.6449, got $zeta2")
    println(s"Exercise 6 - ζ(2) with 100000 terms: $zeta2 (exact: ${math.Pi * math.Pi / 6.0})")

    val zeta4 = exercise6_riemannZeta(4.0, 10000)
    // ζ(4) = π⁴/90 ≈ 1.08232
    assert(math.abs(zeta4 - math.pow(math.Pi, 4) / 90.0) < 0.001,
      s"ζ(4) ≈ π⁴/90 ≈ 1.08232, got $zeta4")
    println(s"Exercise 6 - ζ(4) with 10000 terms: $zeta4")

    // Exercise 7: Maximum Prime Gap
    val gap100 = exercise7_primeGaps(100)
    // Primes up to 100: largest gap is 8 (between 89 and 97)
    assert(gap100._3 == 8, s"Max prime gap up to 100 should be 8, got ${gap100._3}")
    assert(gap100._1 == 89 && gap100._2 == 97,
      s"Max gap should be between 89 and 97, got ${gap100._1} and ${gap100._2}")
    println(s"Exercise 7 - Max prime gap up to 100: $gap100")

    // Exercise 8: Hailstone Record
    val hail10 = exercise8_hailstoneRecord(10)
    // 9 reaches max value 52 in its Collatz sequence (7 also reaches 52, but we take the largest starting number)
    assert(hail10._2 == 52L, s"Max hailstone value for n<=10 should be 52, got ${hail10._2}")
    assert(hail10._1 == 9 || hail10._1 == 7, s"Hailstone record starter should be 7 or 9, got ${hail10._1}")
    println(s"Exercise 8 - Hailstone record (n<=10): $hail10")

    println("\nAll Logic040_OpenProblems exercises passed!")
  }
}
