package org.shev4ik.interview.logic_intellect.level2_intermediate

/**
 * =Strategy and Decision Puzzles=
 *
 * ==Theory: Optimal Stopping (Secretary Problem)==
 *
 * The '''Secretary Problem''' (or optimal stopping problem) asks: given n candidates
 * interviewed sequentially (with no recall), what is the optimal strategy to maximize
 * the probability of selecting the best one? The answer is the '''1/e rule''':
 * reject the first n/e candidates (approximately 37%), then select the next candidate
 * who is better than all previously seen. This yields a ~36.8% success probability
 * regardless of n.
 *
 * {{{
 *   Optimal threshold k* = floor(n / e) ≈ floor(n * 0.3679)
 *   P(best) → 1/e ≈ 0.3679 as n → ∞
 * }}}
 *
 * ==Theory: Kelly Criterion==
 *
 * The '''Kelly Criterion''' determines the optimal fraction of bankroll to wager on a
 * favorable bet to maximize long-term geometric growth rate:
 * {{{
 *   f* = (b * p - q) / b
 * }}}
 * where b = net odds (e.g., 2:1 means b=2), p = probability of winning, q = 1-p.
 * If f* <= 0, don't bet. Kelly is used in quantitative finance and gambling theory.
 *
 * ==Theory: Two-Envelope Paradox==
 *
 * Two envelopes contain amounts X and 2X. You pick one, see value V. Naive reasoning:
 * "the other is V/2 or 2V with equal probability, so EV of switching = 1.25V > V."
 * The paradox arises from improper conditioning — you cannot assume uniform probability
 * over the amount being X or 2X ''after'' observing V without a prior on X.
 *
 * ==Comparison: Decision Frameworks==
 *
 * | Framework          | Key Insight                               | Use Case            |
 * |--------------------|-------------------------------------------|---------------------|
 * | Optimal stopping   | Explore then exploit (1/e rule)           | Hiring, dating      |
 * | Kelly criterion    | Maximize geometric growth rate            | Betting, investing  |
 * | Nash equilibrium   | No player benefits from unilateral change | Game theory          |
 * | Minimax            | Minimize worst-case loss                  | Zero-sum games       |
 * | Dutch auction      | Price descends until first bid            | Auction theory       |
 *
 * ==Interview Tips==
 *
 *  - '''Secretary problem:''' Often asked as "how to hire the best candidate" or "optimal
 *    stopping." Know the 1/e rule and be able to derive it via calculus or approximation.
 *  - '''Game theory basics:''' Know dominant strategies, Nash equilibrium for 2x2 games,
 *    and the prisoner's dilemma. These appear in strategy and quant interviews.
 *  - '''Minimax:''' Foundation of adversarial search (chess, tic-tac-toe). Alpha-beta pruning
 *    is the optimization. Can you implement minimax for a simple game tree?
 *  - '''Kelly criterion:''' Popular in quant finance interviews. Know when f* is negative
 *    (don't bet) and that fractional Kelly (e.g., half Kelly) reduces variance.
 *  - '''Auction theory:''' Vickrey (second-price) auction incentivizes truthful bidding.
 *    Dutch auction is strategically equivalent to first-price sealed-bid.
 *  - '''Think about edge cases:''' What if all candidates are identical? What if odds are
 *    unfavorable? What if the game tree has ties?
 */
object Logic018_StrategyPuzzles {

  /**
   * Exercise 1: Secretary Problem — Optimal Threshold
   *
   * Given n candidates, compute the optimal number of candidates to reject before
   * starting to accept. The optimal threshold is floor(n / e).
   *
   * @param n total number of candidates
   * @return optimal number of candidates to reject (exploration phase size)
   */
  def exercise1_secretaryProblem(n: Int): Int = ???

  /**
   * Exercise 2: Kelly Criterion
   *
   * Compute the optimal Kelly fraction: f* = (b * p - q) / b, where b = net odds
   * received on the wager, p = probability of winning, q = 1 - p. If f* < 0, return 0.
   *
   * @param b net odds (e.g., 2.0 for 2:1 odds)
   * @param p probability of winning
   * @return optimal fraction of bankroll to wager (0 if bet is unfavorable)
   */
  def exercise2_kellyCriterion(b: Double, p: Double): Double = ???

  /**
   * Exercise 3: Mastermind Scoring
   *
   * Given a secret code and a guess (each a sequence of 4 colors represented as ints
   * 0-5), compute the number of bulls (exact position match) and cows (right color,
   * wrong position).
   *
   * @param secret the secret code (4 integers, each 0-5)
   * @param guess  the guess (4 integers, each 0-5)
   * @return (bulls, cows)
   */
  def exercise3_mastermindScore(secret: List[Int], guess: List[Int]): (Int, Int) = ???

  /**
   * Exercise 4: Prisoner's Dilemma Nash Equilibrium
   *
   * In the classic prisoner's dilemma with payoff matrix:
   *   Both cooperate: (3,3), P1 defects: (5,0), P2 defects: (0,5), Both defect: (1,1)
   * Find the Nash equilibrium (dominant strategy for both players).
   *
   * @return (player1Strategy, player2Strategy) — each is "cooperate" or "defect"
   */
  def exercise4_prisonersDilemma(): (String, String) = ???

  /**
   * Exercise 5: Optimal Betting Simulation
   *
   * Given win probability p, starting bankroll, and number of rounds n, compute the
   * expected bankroll after n rounds using the Kelly fraction. Expected growth per round:
   * E[bankroll] = bankroll * (1 + f*b)^(n*p) * (1 - f)^(n*q) approximately, but for
   * expected value: after each round, E[B] = B * (1 + f*b*p - f*q).
   *
   * @param startBankroll initial bankroll
   * @param winProb       probability of winning each round
   * @param odds          net odds on the bet
   * @param rounds        number of rounds
   * @return expected bankroll after n rounds using Kelly fraction
   */
  def exercise5_optimalBetting(startBankroll: Double, winProb: Double,
                               odds: Double, rounds: Int): Double = ???

  /**
   * Exercise 6: Two-Envelope Expected Value
   *
   * Given that the two envelopes contain amounts (small, large) = (x, 2x), and you
   * opened the envelope containing 'observed' amount, compute the true expected value
   * of switching. If observed == x, switching gives 2x (gain x). If observed == 2x,
   * switching gives x (lose x). With equal probability: EV = 0.5*(2x) + 0.5*(x) but
   * we must condition properly. Return EV of the other envelope given the two amounts.
   *
   * @param smallAmount the smaller amount x
   * @param observed    the amount you observed in your envelope
   * @return expected value of the amount in the other envelope
   */
  def exercise6_twoEnvelopes(smallAmount: Double, observed: Double): Double = ???

  /**
   * Exercise 7: Dutch Auction Equilibrium
   *
   * In a Dutch auction with n bidders, each with a private valuation, the equilibrium
   * strategy (with uniformly distributed valuations) is for each bidder to bid
   * (n-1)/n * their_valuation. The winner pays their bid (first-price). With known
   * valuations, the item goes to the highest bidder at approximately the second-highest
   * valuation (revenue equivalence). Return the second-highest valuation.
   *
   * @param valuations list of bidder valuations
   * @return equilibrium price (second-highest valuation)
   */
  def exercise7_dutchAuction(valuations: List[Double]): Double = ???

  /**
   * Exercise 8: Minimax for Simple Game Tree
   *
   * Evaluate a simple game tree using minimax. The tree is represented as nested lists:
   * leaf values are Ints, internal nodes alternate between max (even depth) and min
   * (odd depth). Given leaf values grouped by parent nodes, compute the optimal value.
   *
   * The input is a list of list of ints representing a 2-level game tree:
   * maximizer at root picks among children, each child is a minimizer picking among leaves.
   *
   * @param leaves leaf values grouped by minimizer nodes: List[List[Int]]
   * @return optimal value for the maximizing root player
   */
  def exercise8_minimaxSimple(leaves: List[List[Int]]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Secretary Problem
    val threshold = exercise1_secretaryProblem(100)
    // floor(100 / e) = floor(36.79) = 36 or 37
    assert(threshold >= 36 && threshold <= 37, s"Exercise 1 failed: expected ~37, got $threshold")
    println(s"Exercise 1 - Optimal threshold for 100 candidates: $threshold")

    val threshold2 = exercise1_secretaryProblem(10)
    assert(threshold2 >= 3 && threshold2 <= 4, s"Exercise 1 failed: expected ~3-4 for n=10, got $threshold2")
    println(s"Exercise 1 - Optimal threshold for 10 candidates: $threshold2")

    // Exercise 2: Kelly Criterion
    val kelly = exercise2_kellyCriterion(2.0, 0.6)
    // f* = (2*0.6 - 0.4) / 2 = 0.8/2 = 0.4
    assert(Math.abs(kelly - 0.4) < 1e-9, s"Exercise 2 failed: expected 0.4, got $kelly")
    val kellyNeg = exercise2_kellyCriterion(1.0, 0.4)
    // f* = (1*0.4 - 0.6) / 1 = -0.2, should return 0
    assert(Math.abs(kellyNeg - 0.0) < 1e-9, s"Exercise 2 failed: expected 0.0, got $kellyNeg")
    println(s"Exercise 2 - Kelly fraction (2:1 odds, 60% win): $kelly")

    // Exercise 3: Mastermind Scoring
    val (bulls, cows) = exercise3_mastermindScore(List(1, 2, 3, 4), List(1, 3, 2, 5))
    assert(bulls == 1, s"Exercise 3 failed: expected 1 bull, got $bulls")
    assert(cows == 2, s"Exercise 3 failed: expected 2 cows, got $cows")
    val (b2, c2) = exercise3_mastermindScore(List(1, 1, 2, 2), List(1, 2, 1, 2))
    assert(b2 == 2, s"Exercise 3 failed: expected 2 bulls, got $b2")
    assert(c2 == 2, s"Exercise 3 failed: expected 2 cows, got $c2")
    println(s"Exercise 3 - Bulls: $bulls, Cows: $cows")

    // Exercise 4: Prisoner's Dilemma
    val (p1, p2) = exercise4_prisonersDilemma()
    assert(p1 == "defect" && p2 == "defect",
      s"Exercise 4 failed: expected (defect, defect), got ($p1, $p2)")
    println(s"Exercise 4 - Nash equilibrium: ($p1, $p2)")

    // Exercise 5: Optimal Betting
    val finalBankroll = exercise5_optimalBetting(1000.0, 0.6, 2.0, 10)
    assert(finalBankroll > 1000.0, s"Exercise 5 failed: expected growth, got $finalBankroll")
    println(s"Exercise 5 - Expected bankroll after 10 rounds: $finalBankroll")

    // Exercise 6: Two Envelopes
    // Envelopes contain 100 and 200. If we observed 100, other is 200.
    val ev1 = exercise6_twoEnvelopes(100.0, 100.0)
    assert(Math.abs(ev1 - 200.0) < 1e-9, s"Exercise 6 failed: expected 200.0, got $ev1")
    // If we observed 200, other is 100.
    val ev2 = exercise6_twoEnvelopes(100.0, 200.0)
    assert(Math.abs(ev2 - 100.0) < 1e-9, s"Exercise 6 failed: expected 100.0, got $ev2")
    println(s"Exercise 6 - EV of other envelope (observed 100): $ev1, (observed 200): $ev2")

    // Exercise 7: Dutch Auction
    val price = exercise7_dutchAuction(List(50.0, 80.0, 65.0, 90.0, 72.0))
    assert(Math.abs(price - 80.0) < 1e-9, s"Exercise 7 failed: expected 80.0, got $price")
    println(s"Exercise 7 - Dutch auction equilibrium price: $price")

    // Exercise 8: Minimax
    // Game tree: max picks among [min(3,5), min(2,9), min(1,6)] = max(3, 2, 1) = 3
    val optimal = exercise8_minimaxSimple(List(List(3, 5), List(2, 9), List(1, 6)))
    assert(optimal == 3, s"Exercise 8 failed: expected 3, got $optimal")
    // Another tree: max picks among [min(7,2), min(8,1)] = max(2, 1) = 2
    val optimal2 = exercise8_minimaxSimple(List(List(7, 2), List(8, 1)))
    assert(optimal2 == 2, s"Exercise 8 failed: expected 2, got $optimal2")
    println(s"Exercise 8 - Minimax optimal value: $optimal")

    println("\nAll strategy puzzle exercises completed!")
  }
}
