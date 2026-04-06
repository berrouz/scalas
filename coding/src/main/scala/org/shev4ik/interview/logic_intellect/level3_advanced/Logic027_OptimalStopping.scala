package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Optimal Stopping Theory (Теорія оптимальної зупинки)=
 *
 * ==Theory: When to Stop Searching==
 *
 * Optimal stopping problems ask: given a sequence of options revealed one at a time,
 * when should you commit? These problems arise in hiring, house buying, dating,
 * auction bidding, and online algorithm design.
 *
 * '''Secretary Problem (Best Choice Problem):''' Interview n candidates sequentially.
 * After each interview, you must immediately accept or reject. The optimal strategy
 * is to reject the first n/e candidates (≈ 36.8%), then accept the next one who is
 * better than all previously seen. This yields a success probability of 1/e ≈ 36.8%.
 * {{{
 *   Optimal threshold: k* = floor(n / e)
 *   P(win) = (k/n) * sum_{i=k}^{n-1} 1/(i) → 1/e as n → ∞
 * }}}
 *
 * '''Prophet Inequality:''' A gambler sees values x1, x2, ..., xn drawn from known
 * distributions. An online algorithm setting threshold t = E[max]/2 guarantees at
 * least half the prophet's (offline optimal) expected reward.
 *
 * '''Ski Rental Problem:''' You can rent skis for $1/day or buy for $B. You don't
 * know how many days you'll ski. The optimal deterministic strategy is: rent for
 * B-1 days, then buy on day B. This gives a competitive ratio of 2 - 1/B.
 * {{{
 *   If you ski < B days: you pay the same as optimal (rent only).
 *   If you ski >= B days: you pay (B-1) + B = 2B - 1 vs optimal B. Ratio = (2B-1)/B.
 * }}}
 *
 * '''UCB1 (Upper Confidence Bound):''' For multi-armed bandits, select the arm
 * maximizing: x̄_i + sqrt(2 * ln(t) / n_i), balancing exploration and exploitation.
 *
 * '''Online Algorithms & Competitive Ratio:''' An online algorithm's competitive
 * ratio is the worst-case ratio of its cost to the optimal offline cost.
 * A c-competitive algorithm never pays more than c times the offline optimal.
 *
 * ==Comparison: Stopping Strategies==
 *
 * | Problem           | Optimal Strategy          | Key Result             |
 * |-------------------|---------------------------|------------------------|
 * | Secretary (n)     | Reject first n/e, then    | P(best) = 1/e ≈ 36.8% |
 * | Ski Rental        | Rent B-1 days, then buy   | CR = 2 - 1/B           |
 * | Prophet Inequality| Threshold = E[max]/2      | ≥ 50% of prophet       |
 * | Multi-Armed Bandit| UCB1                      | O(sqrt(n*ln(n))) regret|
 *
 * ==Interview Tips==
 *
 *  - The '''secretary problem''' is a classic Google/quant interview question.
 *    Know the 1/e threshold and the proof sketch (integral approximation).
 *  - '''Ski rental''' illustrates the rent-vs-buy tradeoff in cloud computing.
 *  - For '''competitive analysis''', always define what "offline optimal" means.
 *  - '''Prophet inequality''' connects to posted-price mechanisms in auction theory.
 *  - When asked about "optimal stopping," clarify: is the goal to maximize
 *    probability of best (secretary) or maximize expected value (prophet)?
 *  - Randomized strategies can sometimes beat deterministic competitive ratios
 *    (e.g., randomized ski rental achieves CR = e/(e-1) ≈ 1.58).
 *
 * ==Complexity Note==
 *
 * Secretary simulations are O(n * trials). Analytic computations are O(n).
 * The ski rental and prophet inequality computations are O(1) or O(n).
 */
object Logic027_OptimalStopping {

  /**
   * Exercise 1: Secretary Problem — Optimal Win Probability
   *
   * Compute the probability of selecting the best candidate using the optimal
   * threshold strategy. With n candidates and threshold k (reject first k,
   * then pick the next one better than all seen):
   * P(win) = (k/n) * sum_{i=k}^{n-1} 1/i
   *
   * Use k = floor(n / e) as the optimal threshold.
   *
   * @param n number of candidates
   * @return probability of selecting the best candidate
   */
  def exercise1_secretaryOptimal(n: Int): Double = ???

  /**
   * Exercise 2: Secretary Problem — Simulation
   *
   * Simulate the secretary problem over `trials` random permutations of n
   * candidates. Use threshold k: reject first k candidates, then accept the
   * next one who is the best seen so far. Return the fraction of trials
   * where the best candidate was selected.
   *
   * @param n      number of candidates
   * @param k      threshold (number to reject)
   * @param trials number of simulation trials
   * @return fraction of trials where the best was selected
   */
  def exercise2_secretarySimulate(n: Int, k: Int, trials: Int): Double = ???

  /**
   * Exercise 3: Ski Rental — Competitive Ratio
   *
   * Compute the competitive ratio of the optimal deterministic ski rental
   * strategy: rent for B-1 days, then buy on day B.
   * Competitive ratio = (2B - 1) / B = 2 - 1/B.
   *
   * @param buyPrice the purchase price B (renting costs 1 per day)
   * @return the competitive ratio
   */
  def exercise3_skiRental(buyPrice: Int): Double = ???

  /**
   * Exercise 4: Prophet Inequality — Threshold
   *
   * Given n values representing the maximum of each distribution (assume
   * uniform [0, max_i] for each), compute the prophet inequality threshold:
   * threshold = 0.5 * E[max of all draws].
   *
   * For uniform [0, max_i], E[max] can be approximated. For simplicity,
   * compute threshold = 0.5 * max(maxValues).
   *
   * @param maxValues the upper bounds of each uniform distribution
   * @return the prophet inequality threshold
   */
  def exercise4_prophetInequality(maxValues: List[Double]): Double = ???

  /**
   * Exercise 5: Optimal Bidding — First-Price Auction
   *
   * In a first-price sealed-bid auction with n bidders whose values are
   * drawn uniformly from [0, 1], the symmetric Nash equilibrium bid for
   * a bidder with value v is: bid = v * (n-1) / n.
   *
   * @param value    the bidder's private value
   * @param nBidders number of bidders
   * @return the optimal bid
   */
  def exercise5_optimalBidding(value: Double, nBidders: Int): Double = ???

  /**
   * Exercise 6: Online Median
   *
   * Maintain a running median of a stream of numbers. After processing all
   * elements, return the final median. Use two sorted halves (or sort) to
   * find the median. For even count, return average of two middle elements.
   *
   * @param stream the sequence of numbers
   * @return the median of all elements
   */
  def exercise6_onlineMedian(stream: List[Double]): Double = ???

  /**
   * Exercise 7: Best Choice with Look-Back Window
   *
   * Variant of the secretary problem where you can go back up to w positions
   * to select a previously seen candidate. With this advantage, the optimal
   * threshold decreases. Compute the threshold as floor(n / (e * (w + 1)^(1.0/w))).
   * For w=0, this reduces to floor(n/e) (standard secretary problem).
   *
   * Simplified: return floor(n / (e * sqrt(w + 1))) as an approximation.
   *
   * @param n total candidates
   * @param w look-back window size (0 = standard secretary problem)
   * @return optimal threshold (number to reject before considering)
   */
  def exercise7_bestChoiceWindow(n: Int, w: Int): Int = ???

  /**
   * Exercise 8: Secretary Problem with k Choices
   *
   * You may select up to k candidates (not just 1). Compute the k optimal
   * thresholds. For the j-th choice (1-indexed), the threshold is approximately
   * floor(n * (1/e)^(k - j + 1)).
   *
   * For k=1: single threshold at floor(n/e).
   * For k=2: two thresholds at floor(n/e^2) and floor(n/e).
   *
   * @param n total candidates
   * @param k number of choices allowed
   * @return list of k thresholds in increasing order
   */
  def exercise8_multipleChoice(n: Int, k: Int): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Secretary Optimal
    val p100 = exercise1_secretaryOptimal(100)
    assert(math.abs(p100 - 1.0 / math.E) < 0.02, s"Expected ~0.368, got $p100")
    val p1000 = exercise1_secretaryOptimal(1000)
    assert(math.abs(p1000 - 1.0 / math.E) < 0.01, s"Expected ~0.368, got $p1000")
    println("Exercise 1 passed: secretaryOptimal")

    // Exercise 2: Secretary Simulate
    val simResult = exercise2_secretarySimulate(100, 37, 10000)
    assert(simResult > 0.25 && simResult < 0.50, s"Expected ~0.37, got $simResult")
    println("Exercise 2 passed: secretarySimulate")

    // Exercise 3: Ski Rental
    assert(math.abs(exercise3_skiRental(10) - 1.9) < 1e-9)
    assert(math.abs(exercise3_skiRental(100) - 1.99) < 1e-9)
    assert(math.abs(exercise3_skiRental(2) - 1.5) < 1e-9)
    println("Exercise 3 passed: skiRental")

    // Exercise 4: Prophet Inequality
    assert(math.abs(exercise4_prophetInequality(List(10.0, 20.0, 30.0)) - 15.0) < 1e-9)
    assert(math.abs(exercise4_prophetInequality(List(100.0)) - 50.0) < 1e-9)
    println("Exercise 4 passed: prophetInequality")

    // Exercise 5: Optimal Bidding
    assert(math.abs(exercise5_optimalBidding(0.8, 2) - 0.4) < 1e-9)
    assert(math.abs(exercise5_optimalBidding(0.9, 3) - 0.6) < 1e-9)
    assert(math.abs(exercise5_optimalBidding(1.0, 4) - 0.75) < 1e-9)
    println("Exercise 5 passed: optimalBidding")

    // Exercise 6: Online Median
    assert(math.abs(exercise6_onlineMedian(List(3.0, 1.0, 2.0)) - 2.0) < 1e-9)
    assert(math.abs(exercise6_onlineMedian(List(4.0, 1.0, 3.0, 2.0)) - 2.5) < 1e-9)
    assert(math.abs(exercise6_onlineMedian(List(5.0)) - 5.0) < 1e-9)
    println("Exercise 6 passed: onlineMedian")

    // Exercise 7: Best Choice Window
    val t0 = exercise7_bestChoiceWindow(100, 0)
    assert(t0 == 36 || t0 == 37, s"Expected 36 or 37 for w=0, got $t0") // floor(100/e) = 36
    val t1 = exercise7_bestChoiceWindow(100, 1)
    assert(t1 < t0, s"With look-back, threshold should decrease: w=1 got $t1 vs w=0 got $t0")
    println("Exercise 7 passed: bestChoiceWindow")

    // Exercise 8: Multiple Choice
    val thresholds1 = exercise8_multipleChoice(100, 1)
    assert(thresholds1.size == 1)
    assert(thresholds1.head == 36 || thresholds1.head == 37, s"Expected ~37, got ${thresholds1.head}")
    val thresholds2 = exercise8_multipleChoice(100, 2)
    assert(thresholds2.size == 2)
    assert(thresholds2(0) < thresholds2(1), s"Thresholds should be increasing: $thresholds2")
    println("Exercise 8 passed: multipleChoice")

    println("\nAll exercises passed!")
  }
}
