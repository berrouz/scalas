package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Advanced (Quant-Level) Probability (Просунута ймовірність)=
 *
 * ==Theory: Probabilistic Reasoning for Quantitative Interviews==
 *
 * These topics frequently appear in quantitative finance interviews at firms
 * like Jane Street, Two Sigma, Citadel, DE Shaw, and Jump Trading. Mastery
 * of these concepts demonstrates deep probabilistic reasoning.
 *
 * '''Random Walks:''' A 1D symmetric random walk starts at the origin and takes
 * steps of +1 or -1 with equal probability. Key results:
 * {{{
 *   P(return to origin at step 2n) = C(2n, n) / 4^n
 *   P(ever return to origin) = 1 (recurrence in 1D and 2D)
 *   Expected distance after n steps in 2D ≈ sqrt(2n / π)
 * }}}
 *
 * '''Ballot Problem:''' If candidate A gets `a` votes and B gets `b` votes with
 * a > b, the probability that A is strictly ahead throughout the entire count is:
 * {{{
 *   P = (a - b) / (a + b)
 * }}}
 * This elegant result follows from the reflection principle.
 *
 * '''Gambler's Ruin:''' A gambler starts with k dollars, wins $1 with probability p
 * and loses $1 with probability q = 1-p per round. The probability of reaching N
 * before going broke:
 * {{{
 *   If p ≠ q:  P(k) = (1 - (q/p)^k) / (1 - (q/p)^N)
 *   If p = q = 0.5:  P(k) = k / N
 * }}}
 *
 * '''Stirling's Approximation:''' For large n:
 * {{{
 *   n! ≈ sqrt(2πn) * (n/e)^n
 * }}}
 * Essential for approximating binomial coefficients and probabilities.
 *
 * '''Reflection Principle:''' Used to count lattice paths that cross or touch a
 * boundary. A path from (0,0) to (n,n) that does not cross the diagonal is counted
 * by the Catalan number: C(n) = C(2n,n) / (n+1).
 *
 * '''Coupon Collector Problem:''' To collect all n distinct coupons:
 * {{{
 *   E[T] = n * H(n) = n * (1 + 1/2 + 1/3 + ... + 1/n)
 *   Var[T] = n^2 * sum_{i=1}^{n} 1/i^2 - n * H(n)  (approximately n^2 * π^2/6)
 * }}}
 *
 * ==Comparison: Probability Tools==
 *
 * | Concept              | Key Formula                       | Interview Context               |
 * |----------------------|-----------------------------------|---------------------------------|
 * | Random Walk Return   | C(2n,n)/4^n                       | "What is P(return at step 2n)?" |
 * | Ballot Problem       | (a-b)/(a+b)                       | Voting / lead probability       |
 * | Gambler's Ruin       | (1-(q/p)^k) / (1-(q/p)^N)        | Stopping time / ruin probs      |
 * | Stirling's Approx    | sqrt(2πn)*(n/e)^n                 | Approximating factorials        |
 * | Catalan / Reflection | C(2n,n)/(n+1)                     | Lattice paths, Dyck paths       |
 * | Coupon Collector     | n*H(n)                            | Expected time to see all types  |
 *
 * ==Interview Tips==
 *
 *  - '''Ballot problem''' is a one-liner once you know the formula — but interviewers
 *    expect you to derive it using the reflection principle.
 *  - '''Gambler's ruin''' is a favorite at quant firms. Know both the fair (p=0.5)
 *    and unfair cases. The unfair case uses geometric series.
 *  - '''Random walk''' questions often lead to: "Is the walk recurrent or transient?"
 *    Answer: recurrent in 1D and 2D, transient in 3D+.
 *  - '''Coupon collector''' variance is trickier than the expectation — know both.
 *  - '''Fixed points in permutations''' always have expected value 1, regardless of n.
 *    This is a classic linearity-of-expectation argument.
 *  - Use '''Stirling's approximation''' to simplify asymptotic analysis of binomial terms.
 *
 * ==Complexity Note==
 *
 * Most exercises here involve direct formula evaluation (O(1) or O(n)).
 * The Catalan number computation uses BigInt arithmetic for exact results.
 */
object Logic022_AdvancedProbability {

  /**
   * Exercise 1: Random Walk Return Probability
   *
   * Compute the probability that a 1D symmetric random walk returns to the
   * origin in exactly 2n steps. The formula is C(2n, n) / 4^n.
   *
   * @param n half the number of steps (total steps = 2n)
   * @return probability of being at origin at step 2n
   */
  def exercise1_randomWalkReturn(n: Int): Double = ???

  /**
   * Exercise 2: Ballot Problem
   *
   * Candidate A receives `a` votes and candidate B receives `b` votes,
   * with a > b. The probability that A is strictly ahead of B throughout
   * the entire counting process is (a - b) / (a + b).
   *
   * @param a number of votes for candidate A (a > b)
   * @param b number of votes for candidate B
   * @return probability that A is strictly ahead throughout
   */
  def exercise2_ballotProblem(a: Int, b: Int): Double = ???

  /**
   * Exercise 3: Gambler's Ruin
   *
   * A gambler starts with k dollars, and wants to reach N dollars. Each round
   * the gambler wins $1 with probability p and loses $1 with probability 1-p.
   * Compute the probability of reaching N before going broke.
   *
   * @param k starting amount (0 < k < N)
   * @param n target amount
   * @param p probability of winning each round (0 < p < 1)
   * @return probability of reaching N before 0
   */
  def exercise3_gamblersRuin(k: Int, n: Int, p: Double): Double = ???

  /**
   * Exercise 4: Stirling's Approximation
   *
   * Compute the Stirling approximation of n!:
   * n! ≈ sqrt(2 * π * n) * (n / e)^n
   *
   * @param n the number to approximate factorial for (n >= 1)
   * @return Stirling's approximation of n!
   */
  def exercise4_stirlingApprox(n: Int): Double = ???

  /**
   * Exercise 5: Expected Distance in 2D Random Walk
   *
   * For a 2D symmetric random walk on a grid (each step goes in one of 4
   * cardinal directions with equal probability), the expected Euclidean
   * distance from the origin after n steps is approximately sqrt(2n / π).
   *
   * @param n number of steps
   * @return expected distance from origin after n steps
   */
  def exercise5_expectedDistance(n: Int): Double = ???

  /**
   * Exercise 6: Catalan Number via Reflection Principle
   *
   * The number of lattice paths from (0,0) to (n,n) that never cross above
   * the diagonal is the n-th Catalan number. Using the reflection principle:
   * C(n) = C(2n, n) - C(2n, n+1) = C(2n, n) / (n + 1)
   *
   * @param n the index of the Catalan number
   * @return n-th Catalan number
   */
  def exercise6_catalan_ballot(n: Int): BigInt = ???

  /**
   * Exercise 7: Expected Fixed Points in Random Permutation
   *
   * The expected number of fixed points in a uniformly random permutation
   * of n elements is always exactly 1, regardless of n. This follows from
   * linearity of expectation: E[fixed points] = sum of P(i is fixed) = n * (1/n) = 1.
   *
   * @param n number of elements in the permutation
   * @return expected number of fixed points (always 1.0 for n >= 1)
   */
  def exercise7_randomPermutation(n: Int): Double = ???

  /**
   * Exercise 8: Coupon Collector Variance
   *
   * In the coupon collector problem with n distinct coupons, the variance of
   * the number of draws needed to collect all coupons is:
   * Var[T] = sum_{i=1}^{n} (n/i)^2 - sum_{i=1}^{n} (n/i)
   *        = n^2 * sum_{i=1}^{n} 1/i^2 - n * H(n)
   * where H(n) is the n-th harmonic number.
   *
   * Note: T = sum of geometric r.v.s Xi with parameter (n-i+1)/n.
   * Var[Xi] = (1-pi)/pi^2 where pi = (n-i+1)/n. So Var[T] = sum Var[Xi].
   *
   * @param n number of distinct coupons
   * @return variance of the number of draws to collect all coupons
   */
  def exercise8_couponVariance(n: Int): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Random Walk Return
    // P(return at step 0) = C(0,0)/1 = 1.0
    assert(math.abs(exercise1_randomWalkReturn(0) - 1.0) < 1e-9)
    // P(return at step 2) = C(2,1)/4 = 2/4 = 0.5
    assert(math.abs(exercise1_randomWalkReturn(1) - 0.5) < 1e-9)
    // P(return at step 4) = C(4,2)/16 = 6/16 = 0.375
    assert(math.abs(exercise1_randomWalkReturn(2) - 0.375) < 1e-9)
    println("Exercise 1 passed: randomWalkReturn")

    // Exercise 2: Ballot Problem
    assert(math.abs(exercise2_ballotProblem(3, 1) - 0.5) < 1e-9)       // (3-1)/(3+1) = 0.5
    assert(math.abs(exercise2_ballotProblem(5, 3) - 0.25) < 1e-9)      // (5-3)/(5+3) = 0.25
    assert(math.abs(exercise2_ballotProblem(10, 1) - 9.0 / 11) < 1e-9) // (10-1)/(10+1)
    println("Exercise 2 passed: ballotProblem")

    // Exercise 3: Gambler's Ruin
    // Fair game: P(k) = k/N
    assert(math.abs(exercise3_gamblersRuin(5, 10, 0.5) - 0.5) < 1e-9)
    assert(math.abs(exercise3_gamblersRuin(3, 10, 0.5) - 0.3) < 1e-9)
    // Unfair game: P(k) = (1-(q/p)^k) / (1-(q/p)^N), p=0.4, q=0.6
    val p04 = exercise3_gamblersRuin(2, 5, 0.4)
    val expected04 = (1.0 - math.pow(1.5, 2)) / (1.0 - math.pow(1.5, 5))
    assert(math.abs(p04 - expected04) < 1e-9)
    println("Exercise 3 passed: gamblersRuin")

    // Exercise 4: Stirling's Approximation
    // 10! = 3628800, Stirling ≈ 3598695.6
    val s10 = exercise4_stirlingApprox(10)
    assert(math.abs(s10 - math.sqrt(2 * math.Pi * 10) * math.pow(10.0 / math.E, 10)) < 1e-3)
    val s5 = exercise4_stirlingApprox(5)
    assert(math.abs(s5 - math.sqrt(2 * math.Pi * 5) * math.pow(5.0 / math.E, 5)) < 1e-3)
    println("Exercise 4 passed: stirlingApprox")

    // Exercise 5: Expected Distance in 2D
    val ed100 = exercise5_expectedDistance(100)
    assert(math.abs(ed100 - math.sqrt(200.0 / math.Pi)) < 1e-9)
    val ed1 = exercise5_expectedDistance(1)
    assert(math.abs(ed1 - math.sqrt(2.0 / math.Pi)) < 1e-9)
    println("Exercise 5 passed: expectedDistance")

    // Exercise 6: Catalan via Reflection
    assert(exercise6_catalan_ballot(0) == BigInt(1))
    assert(exercise6_catalan_ballot(1) == BigInt(1))
    assert(exercise6_catalan_ballot(2) == BigInt(2))
    assert(exercise6_catalan_ballot(3) == BigInt(5))
    assert(exercise6_catalan_ballot(4) == BigInt(14))
    assert(exercise6_catalan_ballot(5) == BigInt(42))
    println("Exercise 6 passed: catalan_ballot")

    // Exercise 7: Random Permutation Fixed Points
    assert(exercise7_randomPermutation(1) == 1.0)
    assert(exercise7_randomPermutation(10) == 1.0)
    assert(exercise7_randomPermutation(1000) == 1.0)
    println("Exercise 7 passed: randomPermutation")

    // Exercise 8: Coupon Variance
    // For n=1: only one coupon, always collected in 1 draw. Var = 0
    assert(math.abs(exercise8_couponVariance(1) - 0.0) < 1e-9)
    // For n=2: T = 1 + Geom(1/2). Var = 0 + (1-0.5)/0.25 = 2.0
    assert(math.abs(exercise8_couponVariance(2) - 2.0) < 1e-9)
    // For n=3: Var = 0 + (1/3)/(2/3)^2 + (2/3)/(1/3)^2 = 0 + 0.75 + 6.0 = 6.75
    assert(math.abs(exercise8_couponVariance(3) - 6.75) < 1e-9)
    println("Exercise 8 passed: couponVariance")

    println("\nAll exercises passed!")
  }
}
