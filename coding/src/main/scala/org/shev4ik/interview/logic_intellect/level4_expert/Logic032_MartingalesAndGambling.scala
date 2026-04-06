package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Stochastic Processes and Gambling (Стохастичні процеси та азартні ігри)=
 *
 * ==Theory: Martingales, Gambler's Ruin, and Optimal Betting==
 *
 * Stochastic processes underpin quantitative finance, and gambling problems
 * are their most intuitive manifestation. These concepts appear in interviews
 * at Jane Street, Two Sigma, Citadel, and DE Shaw, as well as in algorithmic
 * trading strategy discussions.
 *
 * '''Gambler's Ruin (Fair Game):''' A gambler starts with k dollars and plays
 * a fair game (P(win) = P(loss) = 0.5), winning or losing $1 each round.
 * The game ends when they reach 0 (ruin) or n (target). In a fair game:
 * {{{
 *   P(ruin | start at k) = 1 - k/n
 *   P(reaching n | start at k) = k/n
 *   E[duration] = k * (n - k)
 * }}}
 *
 * '''Gambler's Ruin (Biased Game):''' When P(win) = p != 0.5, let q = 1-p
 * and r = q/p. Then:
 * {{{
 *   P(reaching n | start at k) = (1 - r^k) / (1 - r^n)    when p != 0.5
 *   P(ruin | start at k) = 1 - P(reaching n | start at k)
 * }}}
 *
 * '''Martingale:''' A stochastic process {X_n} is a martingale if
 * E[X_{n+1} | X_1, ..., X_n] = X_n. The symmetric random walk S_n = sum of
 * i.i.d. +/-1 is the prototypical martingale. Key property: E[X_n] = E[X_0]
 * for all n (by tower property of conditional expectation).
 *
 * '''Optional Stopping Theorem (OST):''' If T is a stopping time and certain
 * regularity conditions hold (e.g., T is bounded), then E[X_T] = E[X_0].
 * This is the rigorous basis for many gambler's ruin calculations.
 *
 * '''Branching Process:''' Each individual in generation n independently produces
 * a random number of offspring (e.g., Poisson(lambda)). If lambda <= 1, the
 * process dies out with probability 1. If lambda > 1, the extinction probability
 * is the unique fixed point in [0,1) of the probability generating function.
 * For Poisson(lambda): extinction prob is the solution to s = e^{lambda(s-1)}.
 *
 * '''Martingale Betting (Doubling Strategy):''' The strategy of doubling bets
 * after each loss guarantees a net gain of 1 on the first win. However, with
 * a finite bankroll of 2^n - 1, after n consecutive losses you are ruined.
 * The expected gain is always 0 in a fair game (consistent with martingale theory).
 *
 * '''Kelly Criterion:''' Maximize E[log(wealth)] over the fraction f of wealth
 * to bet. For a bet paying b-to-1 with win probability p:
 * {{{
 *   f* = p - q/b = p - (1-p)/b
 * }}}
 * Kelly is growth-optimal in the long run and avoids ruin (since f* < 1).
 *
 * ==Comparison: Gambling and Stochastic Concepts==
 *
 * | Concept              | Key Insight                         | Interview Context               |
 * |----------------------|-------------------------------------|---------------------------------|
 * | Gambler's Ruin       | Boundary hitting probabilities      | Classic quant probability        |
 * | Martingale           | E[X_{n+1}|past] = X_n               | Fair game formalization          |
 * | Optional Stopping    | E[X_T] = E[X_0] under conditions    | Proves gambler's ruin formulas   |
 * | Branching Process    | Extinction iff mean offspring <= 1   | Population / network modeling    |
 * | Doubling Strategy    | Finite bankroll => E[gain] = 0       | Shows limits of naive strategies |
 * | Kelly Criterion      | Maximize log-wealth growth rate     | Optimal bet sizing in trading    |
 *
 * ==Interview Tips==
 *
 *  - '''Gambler's ruin''' is the #1 most common stochastic process question.
 *    Know both the fair and biased formulas cold.
 *  - '''Always check:''' "Is this a martingale?" If yes, apply optional stopping.
 *  - '''Branching processes:''' The key question is always "what is the extinction
 *    probability?" and the answer involves the PGF fixed point.
 *  - '''Kelly criterion''' comes up in trading interviews. Know the derivation
 *    from maximizing E[log(1 + f*X)] where X is the bet outcome.
 *  - '''Doubling strategy''' is a trap question — interviewers want you to
 *    recognize that finite bankroll eliminates the "guaranteed profit."
 *
 * @see [[https://en.wikipedia.org/wiki/Gambler%27s_ruin Gambler's Ruin]]
 * @see [[https://en.wikipedia.org/wiki/Martingale_(probability_theory) Martingale]]
 * @see [[https://en.wikipedia.org/wiki/Kelly_criterion Kelly Criterion]]
 */
object Logic032_MartingalesAndGambling {

  /** Exercise 1: Gambler's Ruin — Fair Game
   *
   * In a fair game (p = 0.5), a gambler starts with k dollars and targets n dollars.
   * P(ruin) = 1 - k/n.
   *
   * @param k starting dollars, 0 <= k <= n
   * @param n target dollars
   * @return probability of ruin
   */
  def exercise1_gamblersRuin(k: Int, n: Int): Double = ???

  /** Exercise 2: Gambler's Ruin — Biased Game
   *
   * With P(win) = p != 0.5, the probability of reaching n starting from k is:
   * (1 - (q/p)^k) / (1 - (q/p)^n), where q = 1-p.
   * P(ruin) = 1 - P(reaching n).
   *
   * @param k starting dollars
   * @param n target dollars
   * @param p probability of winning each round
   * @return probability of ruin
   */
  def exercise2_gamblersRuinBiased(k: Int, n: Int, p: Double): Double = ???

  /** Exercise 3: Expected Duration of Gambler's Ruin (Fair Game)
   *
   * In a fair game, the expected number of steps before hitting 0 or n,
   * starting from k, is k * (n - k).
   *
   * @param k starting position
   * @param n right boundary
   * @return expected number of steps
   */
  def exercise3_expectedDuration(k: Int, n: Int): Long = ???

  /** Exercise 4: Verify Martingale Property
   *
   * Simulate a symmetric random walk and verify that the sample mean of
   * X_{n+1} conditioned on X_n = x is approximately x (martingale property).
   *
   * Run multiple trials of a single step from a given position and check
   * that the average next position is close to the starting position.
   *
   * @param startPosition the position X_n
   * @param numTrials number of simulated steps for verification
   * @param tolerance allowed deviation from exact martingale property
   * @return true if |mean(X_{n+1}) - startPosition| < tolerance
   */
  def exercise4_martingaleProperty(startPosition: Int, numTrials: Int, tolerance: Double): Boolean = ???

  /** Exercise 5: Branching Process Extinction Probability
   *
   * Each individual has Poisson(lambda) offspring. The extinction probability
   * is the smallest non-negative root of s = e^{lambda*(s-1)}.
   * If lambda <= 1, extinction probability = 1.
   * If lambda > 1, find the root numerically via fixed-point iteration.
   *
   * @param lambda mean number of offspring
   * @return extinction probability
   */
  def exercise5_branchingProcess(lambda: Double): Double = ???

  /** Exercise 6: Martingale Doubling Strategy
   *
   * Simulate the doubling (martingale) betting strategy on a fair game
   * with a finite bankroll. Start with initialBankroll, bet 1. On loss,
   * double the bet. On win, collect and reset bet to 1.
   * Stop after maxRounds. Return the average final profit over numTrials simulations.
   *
   * The expected profit should be approximately 0 for a fair game.
   *
   * @param initialBankroll starting money
   * @param maxRounds maximum number of betting rounds
   * @param numTrials number of simulations to average
   * @return average profit (should be near 0.0)
   */
  def exercise6_doublingStrategy(initialBankroll: Int, maxRounds: Int, numTrials: Int): Double = ???

  /** Exercise 7: Optional Stopping Theorem Verification
   *
   * Symmetric random walk with absorbing barriers at 0 and n.
   * Start at position k. Run many simulations until absorption.
   * Verify that the mean stopping value is approximately k
   * (which is NOT the position — it's the initial value, since
   * for the identity martingale X_n, E[X_T] = E[X_0] = k
   * but X_T is either 0 or n, so E[X_T] = n * P(reach n) = n * k/n = k).
   *
   * @param k starting position
   * @param n right barrier
   * @param numTrials number of simulations
   * @param tolerance allowed error
   * @return true if mean(X_T) is within tolerance of k
   */
  def exercise7_optionalStopping(k: Int, n: Int, numTrials: Int, tolerance: Double): Boolean = ???

  /** Exercise 8: Kelly Criterion
   *
   * Given a bet that pays b-to-1 with win probability p, the Kelly-optimal
   * fraction of wealth to bet is f* = p - q/b, where q = 1-p.
   *
   * @param p probability of winning
   * @param b net odds (win pays b times the bet)
   * @return optimal fraction of wealth to bet
   */
  def exercise8_kellyDerivation(p: Double, b: Double): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Gambler's Ruin (Fair)
    val r1a = exercise1_gamblersRuin(5, 10)
    assert(math.abs(r1a - 0.5) < 1e-9, s"Exercise 1 failed: expected 0.5, got $r1a")
    val r1b = exercise1_gamblersRuin(3, 12)
    assert(math.abs(r1b - 0.75) < 1e-9, s"Exercise 1 failed: expected 0.75, got $r1b")
    println(s"Exercise 1 - Gambler's Ruin (fair): P(ruin|k=5,n=10) = $r1a, P(ruin|k=3,n=12) = $r1b")

    // Exercise 2: Gambler's Ruin (Biased)
    val r2 = exercise2_gamblersRuinBiased(5, 10, 0.4)
    assert(r2 > 0.0 && r2 < 1.0, s"Exercise 2 failed: result out of range, got $r2")
    println(s"Exercise 2 - Gambler's Ruin (biased, p=0.4): P(ruin|k=5,n=10) = $r2")

    // Exercise 3: Expected Duration
    val r3a = exercise3_expectedDuration(5, 10)
    assert(r3a == 25L, s"Exercise 3 failed: expected 25, got $r3a")
    val r3b = exercise3_expectedDuration(3, 7)
    assert(r3b == 12L, s"Exercise 3 failed: expected 12, got $r3b")
    println(s"Exercise 3 - Expected Duration: k=5,n=10 -> $r3a, k=3,n=7 -> $r3b")

    // Exercise 4: Martingale Property
    val r4 = exercise4_martingaleProperty(10, 100000, 0.1)
    assert(r4, s"Exercise 4 failed: martingale property not verified")
    println(s"Exercise 4 - Martingale Property verified: $r4")

    // Exercise 5: Branching Process
    val r5a = exercise5_branchingProcess(0.8)
    assert(math.abs(r5a - 1.0) < 1e-6, s"Exercise 5 failed for lambda=0.8: expected 1.0, got $r5a")
    val r5b = exercise5_branchingProcess(2.0)
    assert(r5b > 0.0 && r5b < 1.0, s"Exercise 5 failed for lambda=2.0: expected value in (0,1), got $r5b")
    println(s"Exercise 5 - Branching Process: lambda=0.8 -> P(ext)=$r5a, lambda=2.0 -> P(ext)=$r5b")

    // Exercise 6: Doubling Strategy
    val r6 = exercise6_doublingStrategy(1023, 100, 10000)
    assert(math.abs(r6) < 5.0, s"Exercise 6 failed: expected near 0, got $r6")
    println(s"Exercise 6 - Doubling Strategy avg profit: $r6")

    // Exercise 7: Optional Stopping
    val r7 = exercise7_optionalStopping(4, 10, 10000, 0.5)
    assert(r7, s"Exercise 7 failed: optional stopping theorem not verified")
    println(s"Exercise 7 - Optional Stopping Theorem verified: $r7")

    // Exercise 8: Kelly Criterion
    val r8a = exercise8_kellyDerivation(0.6, 1.0)
    assert(math.abs(r8a - 0.2) < 1e-9, s"Exercise 8 failed: expected 0.2, got $r8a")
    val r8b = exercise8_kellyDerivation(0.5, 2.0)
    assert(math.abs(r8b - 0.25) < 1e-9, s"Exercise 8 failed: expected 0.25, got $r8b")
    println(s"Exercise 8 - Kelly Criterion: p=0.6,b=1 -> f*=$r8a, p=0.5,b=2 -> f*=$r8b")

    println("\nAll Martingales and Gambling exercises passed!")
  }
}
