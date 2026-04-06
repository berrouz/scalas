package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Quant Brain Teasers (Кількісні головоломки)=
 *
 * ==Theory: Classic Probability Puzzles from Quant Finance Interviews==
 *
 * These puzzles are the bread-and-butter of quantitative finance interviews
 * at firms like Jane Street, Two Sigma, Citadel, DE Shaw, and Jump Trading.
 * They test your ability to reason about probability, expected value, and
 * symmetry under pressure.
 *
 * '''Ant on a Triangle / Polygon:''' n ants sit on the vertices of a regular
 * n-gon. Each independently picks a direction (clockwise or counterclockwise)
 * with equal probability. Two ants collide if they walk toward each other on
 * the same edge. The only way NO collision occurs is if ALL ants walk in the
 * same direction. There are 2^n total outcomes and exactly 2 all-same-direction
 * outcomes, so:
 * {{{
 *   P(no collision) = 2 / 2^n = 1 / 2^(n-1)
 * }}}
 * For a triangle (n=3): P = 2/8 = 0.25.
 *
 * '''Stick Breaking — Triangle Inequality:''' Break a stick at two points chosen
 * uniformly at random. The three pieces can form a triangle if and only if no
 * piece exceeds half the stick length. By geometric probability (area of the
 * valid region in the unit square), P = 1/4 = 0.25.
 *
 * '''Rope Burning (Non-Uniform):''' You have two ropes, each burns in exactly
 * 60 minutes, but non-uniformly (so half a rope is NOT 30 minutes). By lighting
 * rope A from both ends and rope B from one end simultaneously, rope A finishes
 * in 30 min; at that moment light the other end of rope B — it has 30 min left
 * but burns from both ends, so it finishes in 15 min. Total: 45 minutes.
 *
 * '''Von Neumann's Unfair Coin Trick:''' Given a coin with P(H) = p and P(T) = 1-p
 * (unknown p), flip it twice repeatedly. P(HT) = p(1-p) = P(TH), so map HT -> H
 * and TH -> T, discarding HH and TT. This produces a fair coin from any bias.
 *
 * '''Expected Value of Order Statistics:''' For n i.i.d. Uniform[0,1] random
 * variables, the expected value of the k-th order statistic is k/(n+1). Thus:
 * {{{
 *   E[max] = E[X_(n)] = n / (n+1)
 *   E[min] = E[X_(1)] = 1 / (n+1)
 * }}}
 *
 * '''Drunkard's Walk (Gambler's Ruin variant):''' A drunkard starts at position k
 * on the integer line [0, n]. At each step, they move left or right with equal
 * probability. The walk ends upon hitting 0 or n. The expected number of steps
 * to absorption is k * (n - k). This follows from solving the recurrence
 * E[k] = 1 + (E[k-1] + E[k+1]) / 2 with boundary E[0] = E[n] = 0.
 *
 * ==Comparison: Quant Puzzle Archetypes==
 *
 * | Puzzle Type         | Key Technique              | Common Trap                         |
 * |---------------------|----------------------------|-------------------------------------|
 * | Ant collision       | Symmetry / counting        | Forgetting to count ALL-same cases  |
 * | Stick breaking      | Geometric probability      | Using 1D instead of 2D argument     |
 * | Rope burning        | Simultaneous timing trick  | Assuming uniform burn rate          |
 * | Unfair to fair coin | Von Neumann extraction     | Forgetting to retry on HH/TT       |
 * | Order statistics    | CDF / expectation formulas | Confusing E[max] with max(E)        |
 * | Random walk hitting | Recurrence + boundaries    | Ignoring boundary conditions        |
 *
 * ==Interview Tips==
 *
 *  - '''Always start with small cases.''' For the ant problem, try n=2 first.
 *  - '''Symmetry is your best friend.''' Many quant puzzles collapse when you
 *    observe that certain events are equally likely.
 *  - '''State your assumptions clearly.''' Interviewers test whether you can
 *    articulate what "random" means (uniform? independent?).
 *  - '''Know order statistics cold.''' E[X_(k:n)] = k/(n+1) for Uniform[0,1].
 *  - '''For random walks,''' set up the recurrence, identify boundary conditions,
 *    and solve. Guess-and-check (quadratic ansatz) works surprisingly often.
 *  - '''Rope burning''' is a classic "aha" puzzle — practice the both-ends trick.
 *
 * @see [[https://en.wikipedia.org/wiki/Order_statistic Order Statistics]]
 * @see [[https://en.wikipedia.org/wiki/Random_walk Random Walk]]
 */
object Logic031_QuantBrainTeasers {

  /** Exercise 1: Ant on Triangle
   *
   * 3 ants sit on the vertices of an equilateral triangle. Each independently
   * chooses to walk clockwise or counterclockwise with equal probability.
   * What is the probability that no two ants collide?
   *
   * No collision occurs only if all ants walk in the same direction.
   * There are 2^3 = 8 total outcomes, and 2 favorable (all CW or all CCW).
   *
   * @return P(no collision) = 2/8 = 0.25
   */
  def exercise1_antOnTriangle: Double = ???

  /** Exercise 2: Ant on n-gon
   *
   * Generalization: n ants on vertices of a regular n-gon. Each picks a random
   * direction. P(no collision) = 2 / 2^n.
   *
   * @param n number of vertices (and ants), n >= 2
   * @return P(no collision) = 2 / 2^n
   */
  def exercise2_antOnPolygon(n: Int): Double = ???

  /** Exercise 3: Stick Breaking — Triangle Formation
   *
   * A stick of length 1 is broken at two uniformly random points.
   * What is the probability that the three resulting pieces can form a triangle?
   *
   * Triangle inequality requires no piece > 0.5. By geometric probability, P = 1/4.
   *
   * @return P(triangle can be formed) = 0.25
   */
  def exercise3_stickBreaking: Double = ???

  /** Exercise 4: Rope Burning — Measure 45 Minutes
   *
   * Two ropes each burn in exactly 60 minutes but non-uniformly.
   * Describe a strategy to measure exactly 45 minutes.
   *
   * @return String describing the strategy
   */
  def exercise4_ropeBurning: String = ???

  /** Exercise 5: Unfair Coin to Fair Coin (Von Neumann's Trick)
   *
   * Given a coin with P(H) = p (unknown, 0 < p < 1), produce a fair flip.
   * Flip twice: P(HT) = p(1-p) = P(TH), so HT->H, TH->T, else retry.
   *
   * @return String describing the Von Neumann extraction procedure
   */
  def exercise5_unfairToFair: String = ???

  /** Exercise 6: Expected Value of Maximum of n Uniform[0,1] Random Variables
   *
   * For X1, ..., Xn i.i.d. Uniform[0,1], E[max(X1,...,Xn)] = n/(n+1).
   *
   * Derivation: CDF of max is F(x) = x^n, so PDF is f(x) = n*x^(n-1),
   * and E[max] = integral from 0 to 1 of x * n * x^(n-1) dx = n/(n+1).
   *
   * @param n number of random variables, n >= 1
   * @return E[max] = n/(n+1)
   */
  def exercise6_expectedMaxUniform(n: Int): Double = ???

  /** Exercise 7: Expected Value of Minimum of n Uniform[0,1] Random Variables
   *
   * For X1, ..., Xn i.i.d. Uniform[0,1], E[min(X1,...,Xn)] = 1/(n+1).
   *
   * Derivation: CDF of min is F(x) = 1 - (1-x)^n, PDF is f(x) = n*(1-x)^(n-1),
   * and E[min] = integral from 0 to 1 of x * n * (1-x)^(n-1) dx = 1/(n+1).
   *
   * @param n number of random variables, n >= 1
   * @return E[min] = 1/(n+1)
   */
  def exercise7_expectedMinUniform(n: Int): Double = ???

  /** Exercise 8: Drunkard's Walk — Expected Steps to Boundary
   *
   * A drunkard starts at integer position k on [0, n]. At each step, moves
   * left or right with equal probability. Walk ends when reaching 0 or n.
   * Expected number of steps = k * (n - k).
   *
   * @param k starting position, 0 <= k <= n
   * @param n right boundary
   * @return expected steps to reach 0 or n
   */
  def exercise8_drunkardWalk(k: Int, n: Int): Long = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Ant on Triangle
    val r1 = exercise1_antOnTriangle
    assert(math.abs(r1 - 0.25) < 1e-9, s"Exercise 1 failed: expected 0.25, got $r1")
    println(s"Exercise 1 - Ant on Triangle: P(no collision) = $r1")

    // Exercise 2: Ant on n-gon
    val r2a = exercise2_antOnPolygon(3)
    assert(math.abs(r2a - 0.25) < 1e-9, s"Exercise 2 failed for n=3: expected 0.25, got $r2a")
    val r2b = exercise2_antOnPolygon(4)
    assert(math.abs(r2b - 0.125) < 1e-9, s"Exercise 2 failed for n=4: expected 0.125, got $r2b")
    val r2c = exercise2_antOnPolygon(6)
    assert(math.abs(r2c - 2.0 / 64) < 1e-9, s"Exercise 2 failed for n=6: expected ${2.0 / 64}, got $r2c")
    println(s"Exercise 2 - Ant on n-gon: P(no collision, n=3)=$r2a, P(n=4)=$r2b, P(n=6)=$r2c")

    // Exercise 3: Stick Breaking
    val r3 = exercise3_stickBreaking
    assert(math.abs(r3 - 0.25) < 1e-9, s"Exercise 3 failed: expected 0.25, got $r3")
    println(s"Exercise 3 - Stick Breaking: P(triangle) = $r3")

    // Exercise 4: Rope Burning
    val r4 = exercise4_ropeBurning
    assert(r4.nonEmpty, "Exercise 4 failed: strategy description should be non-empty")
    println(s"Exercise 4 - Rope Burning 45 min strategy: $r4")

    // Exercise 5: Unfair to Fair Coin
    val r5 = exercise5_unfairToFair
    assert(r5.contains("HT") && r5.contains("TH"), s"Exercise 5 failed: should mention HT and TH mappings")
    println(s"Exercise 5 - Von Neumann's trick: $r5")

    // Exercise 6: Expected Max
    val r6a = exercise6_expectedMaxUniform(1)
    assert(math.abs(r6a - 0.5) < 1e-9, s"Exercise 6 failed for n=1: expected 0.5, got $r6a")
    val r6b = exercise6_expectedMaxUniform(2)
    assert(math.abs(r6b - 2.0 / 3) < 1e-9, s"Exercise 6 failed for n=2: expected ${2.0 / 3}, got $r6b")
    val r6c = exercise6_expectedMaxUniform(10)
    assert(math.abs(r6c - 10.0 / 11) < 1e-9, s"Exercise 6 failed for n=10: expected ${10.0 / 11}, got $r6c")
    println(s"Exercise 6 - E[max]: n=1 -> $r6a, n=2 -> $r6b, n=10 -> $r6c")

    // Exercise 7: Expected Min
    val r7a = exercise7_expectedMinUniform(1)
    assert(math.abs(r7a - 0.5) < 1e-9, s"Exercise 7 failed for n=1: expected 0.5, got $r7a")
    val r7b = exercise7_expectedMinUniform(2)
    assert(math.abs(r7b - 1.0 / 3) < 1e-9, s"Exercise 7 failed for n=2: expected ${1.0 / 3}, got $r7b")
    val r7c = exercise7_expectedMinUniform(10)
    assert(math.abs(r7c - 1.0 / 11) < 1e-9, s"Exercise 7 failed for n=10: expected ${1.0 / 11}, got $r7c")
    println(s"Exercise 7 - E[min]: n=1 -> $r7a, n=2 -> $r7b, n=10 -> $r7c")

    // Exercise 8: Drunkard's Walk
    val r8a = exercise8_drunkardWalk(5, 10)
    assert(r8a == 25L, s"Exercise 8 failed for k=5, n=10: expected 25, got $r8a")
    val r8b = exercise8_drunkardWalk(3, 7)
    assert(r8b == 12L, s"Exercise 8 failed for k=3, n=7: expected 12, got $r8b")
    val r8c = exercise8_drunkardWalk(0, 10)
    assert(r8c == 0L, s"Exercise 8 failed for k=0, n=10: expected 0, got $r8c")
    println(s"Exercise 8 - Drunkard's Walk: k=5,n=10 -> $r8a steps, k=3,n=7 -> $r8b steps, k=0,n=10 -> $r8c steps")

    println("\nAll Quant Brain Teaser exercises passed!")
  }
}
