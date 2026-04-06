package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Advanced Combinatorics (Продвинута комбінаторика)=
 *
 * ==Theory: Advanced Counting Techniques==
 *
 * Beyond basic permutations and combinations, many counting problems require
 * sophisticated techniques. This module covers the most important ones:
 *
 * '''Derangements (D(n)):''' A derangement is a permutation with no fixed points
 * (no element appears in its original position). The recurrence is:
 * {{{
 *   D(0) = 1, D(1) = 0
 *   D(n) = (n - 1) * (D(n-1) + D(n-2))
 * }}}
 * The closed-form involves inclusion-exclusion: D(n) = n! * sum_{i=0}^{n} (-1)^i / i!
 *
 * '''Inclusion-Exclusion Principle:''' For counting elements in the union of sets:
 * {{{
 *   |A1 ∪ A2 ∪ ... ∪ An| = Σ|Ai| - Σ|Ai ∩ Aj| + Σ|Ai ∩ Aj ∩ Ak| - ...
 * }}}
 * Crucial for counting surjections, derangements, and "at least one" problems.
 *
 * '''Stirling Numbers of the Second Kind S(n,k):''' The number of ways to partition
 * a set of n elements into exactly k non-empty subsets. Recurrence:
 * {{{
 *   S(n, k) = k * S(n-1, k) + S(n-1, k-1)
 *   S(n, 0) = 0 for n > 0, S(0, 0) = 1
 * }}}
 *
 * '''Burnside's Lemma (Cauchy-Frobenius):''' Counts distinct objects under group
 * symmetry. For necklaces with n beads and k colors under rotation:
 * {{{
 *   Number of distinct necklaces = (1/n) * Σ_{d|n} φ(n/d) * k^d
 * }}}
 * where φ is Euler's totient function.
 *
 * '''Catalan Numbers:''' C(n) = C(2n,n)/(n+1). Counts valid parenthesizations,
 * binary trees, Dyck paths, triangulations of polygons, and many more structures.
 *
 * '''Multinomial Coefficients:''' n! / (k1! * k2! * ... * km!) counts the number
 * of ways to divide n distinct objects into groups of sizes k1, k2, ..., km.
 *
 * ==Comparison: Counting Techniques==
 *
 * | Technique            | Use Case                                    | Key Idea            |
 * |----------------------|---------------------------------------------|---------------------|
 * | Inclusion-Exclusion  | Union of overlapping sets                   | Alternating sums    |
 * | Burnside's Lemma     | Counting under symmetry                     | Average fixed pts   |
 * | Stirling Numbers     | Set partitions into k parts                 | DP recurrence       |
 * | Catalan Numbers      | Recursive structures (trees, parens)        | C(2n,n)/(n+1)       |
 * | Multinomial          | Arrangements with repeated elements         | Generalized binomial|
 *
 * ==Interview Tips==
 *
 *  - '''Derangements''' appear in "secret Santa" and "hat problem" variants.
 *  - '''Inclusion-exclusion''' is the go-to for "divisible by at least one of" problems.
 *  - '''Stirling numbers''' connect to Bell numbers: B(n) = sum_{k=0}^{n} S(n,k).
 *  - '''Catalan''' is one of the most common sequences in interviews — know it by heart.
 *  - For necklace/bracelet counting, always ask: rotational symmetry only, or also reflections?
 *  - '''BigInt''' is essential in Scala for combinatorial computations to avoid overflow.
 *
 * ==Complexity Note==
 *
 * Most combinatorial computations here use dynamic programming or direct formulas.
 * Time complexity is typically O(n*k) for 2D DP tables (Stirling) or O(n) for
 * single-variable recurrences (derangements, Catalan).
 */
object Logic011_AdvancedCombinatorics {

  /**
   * Exercise 1: Derangements
   *
   * Count derangements (permutations with no fixed points) of n elements.
   * D(0) = 1, D(1) = 0, D(n) = (n-1) * (D(n-1) + D(n-2)) for n >= 2.
   *
   * @param n number of elements
   * @return the number of derangements D(n)
   */
  def exercise1_derangements(n: Int): BigInt = ???

  /**
   * Exercise 2: Inclusion-Exclusion for Divisibility
   *
   * Count integers from 1 to n (inclusive) that are divisible by at least one
   * of the given primes. Uses inclusion-exclusion over subsets of primes.
   *
   * @param n     upper bound of the range [1, n]
   * @param primes list of distinct prime numbers
   * @return count of integers in [1, n] divisible by at least one prime
   */
  def exercise2_inclusionExclusion(n: Int, primes: List[Int]): Int = ???

  /**
   * Exercise 3: Stirling Number of the Second Kind
   *
   * Compute S(n, k) — the number of ways to partition a set of n elements
   * into exactly k non-empty subsets.
   * S(n, k) = k * S(n-1, k) + S(n-1, k-1), S(0,0) = 1, S(n,0) = 0 for n > 0.
   *
   * @param n number of elements
   * @param k number of non-empty subsets
   * @return Stirling number S(n, k)
   */
  def exercise3_stirlingSecond(n: Int, k: Int): BigInt = ???

  /**
   * Exercise 4: Surjective Functions
   *
   * Count the number of surjective (onto) functions from an n-element set
   * to a k-element set using inclusion-exclusion:
   * surj(n, k) = sum_{i=0}^{k} (-1)^i * C(k, i) * (k - i)^n
   *
   * @param n size of the domain
   * @param k size of the codomain
   * @return number of surjective functions
   */
  def exercise4_surjections(n: Int, k: Int): BigInt = ???

  /**
   * Exercise 5: Burnside's Lemma — Necklaces
   *
   * Count distinct necklaces of n beads with k colors, considering
   * rotational symmetry. Using Burnside's lemma:
   * count = (1/n) * sum_{d | n} euler_totient(n/d) * k^d
   *
   * @param n number of beads
   * @param k number of colors
   * @return number of distinct necklaces
   */
  def exercise5_burnside(n: Int, k: Int): BigInt = ???

  /**
   * Exercise 6: Multinomial Coefficient
   *
   * Compute n! / (k1! * k2! * ... * km!). The sum of all ki should equal n.
   *
   * @param n  total number of items
   * @param ks list of group sizes
   * @return the multinomial coefficient
   */
  def exercise6_multinomial(n: Int, ks: List[Int]): BigInt = ???

  /**
   * Exercise 7: Catalan Number — Valid Parenthesizations
   *
   * Count the number of valid parenthesizations of n pairs of parentheses.
   * This is the n-th Catalan number: C(n) = C(2n, n) / (n + 1).
   *
   * @param n number of pairs of parentheses
   * @return n-th Catalan number
   */
  def exercise7_catalanApplications(n: Int): BigInt = ???

  /**
   * Exercise 8: Balls in Bins (Stars and Bars)
   *
   * Count ways to put n identical balls into k distinct bins with each bin
   * having at least 1 ball. This is equivalent to C(n-1, k-1) by the
   * stars and bars theorem (after placing one ball in each bin, distribute
   * the remaining n-k balls into k bins).
   *
   * @param n number of identical balls (n >= k)
   * @param k number of distinct bins
   * @return number of ways, C(n-1, k-1)
   */
  def exercise8_ballsInBins(n: Int, k: Int): BigInt = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Derangements
    assert(exercise1_derangements(0) == BigInt(1))
    assert(exercise1_derangements(1) == BigInt(0))
    assert(exercise1_derangements(2) == BigInt(1))
    assert(exercise1_derangements(3) == BigInt(2))
    assert(exercise1_derangements(4) == BigInt(9))
    assert(exercise1_derangements(5) == BigInt(44))
    println("Exercise 1 passed: derangements")

    // Exercise 2: Inclusion-Exclusion
    assert(exercise2_inclusionExclusion(10, List(2, 3)) == 7) // divisible by 2 or 3: 2,3,4,6,8,9,10
    assert(exercise2_inclusionExclusion(30, List(2, 3, 5)) == 22)
    assert(exercise2_inclusionExclusion(100, List(7)) == 14)
    println("Exercise 2 passed: inclusionExclusion")

    // Exercise 3: Stirling Second Kind
    assert(exercise3_stirlingSecond(0, 0) == BigInt(1))
    assert(exercise3_stirlingSecond(3, 1) == BigInt(1))
    assert(exercise3_stirlingSecond(3, 2) == BigInt(3))
    assert(exercise3_stirlingSecond(3, 3) == BigInt(1))
    assert(exercise3_stirlingSecond(4, 2) == BigInt(7))
    assert(exercise3_stirlingSecond(5, 3) == BigInt(25))
    println("Exercise 3 passed: stirlingSecond")

    // Exercise 4: Surjections
    assert(exercise4_surjections(3, 2) == BigInt(6))  // 2^3 - 2 = 6
    assert(exercise4_surjections(3, 3) == BigInt(6))  // 3! = 6
    assert(exercise4_surjections(4, 2) == BigInt(14)) // 2^4 - 2 = 14
    assert(exercise4_surjections(4, 3) == BigInt(36))
    println("Exercise 4 passed: surjections")

    // Exercise 5: Burnside (Necklaces)
    assert(exercise5_burnside(3, 2) == BigInt(4))  // 2 all-same + 2 with 2-1 split
    assert(exercise5_burnside(4, 2) == BigInt(6))
    assert(exercise5_burnside(6, 2) == BigInt(14))
    println("Exercise 5 passed: burnside (necklaces)")

    // Exercise 6: Multinomial
    assert(exercise6_multinomial(4, List(2, 1, 1)) == BigInt(12))
    assert(exercise6_multinomial(6, List(2, 2, 2)) == BigInt(90))
    assert(exercise6_multinomial(3, List(3)) == BigInt(1))
    assert(exercise6_multinomial(5, List(5)) == BigInt(1))
    println("Exercise 6 passed: multinomial")

    // Exercise 7: Catalan
    assert(exercise7_catalanApplications(0) == BigInt(1))
    assert(exercise7_catalanApplications(1) == BigInt(1))
    assert(exercise7_catalanApplications(2) == BigInt(2))
    assert(exercise7_catalanApplications(3) == BigInt(5))
    assert(exercise7_catalanApplications(4) == BigInt(14))
    assert(exercise7_catalanApplications(5) == BigInt(42))
    println("Exercise 7 passed: catalanApplications")

    // Exercise 8: Balls in Bins
    assert(exercise8_ballsInBins(5, 3) == BigInt(6))   // C(4,2) = 6
    assert(exercise8_ballsInBins(10, 3) == BigInt(36))  // C(9,2) = 36
    assert(exercise8_ballsInBins(4, 4) == BigInt(1))    // C(3,3) = 1
    assert(exercise8_ballsInBins(7, 1) == BigInt(1))    // C(6,0) = 1
    println("Exercise 8 passed: ballsInBins")

    println("\nAll exercises passed!")
  }
}
