package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Advanced Game Theory (Просунута теорія ігор)=
 *
 * ==Theory: Nash Equilibria, Cooperative Games, and Mechanism Design==
 *
 * Advanced game theory goes beyond simple combinatorial games into the realm
 * of strategic interaction with mixed strategies, cooperative coalitions, and
 * mechanism design. These concepts appear in quant finance interviews, system
 * design (auction mechanisms), and algorithmic game theory roles.
 *
 * '''Mixed Nash Equilibrium (2x2 Games):''' In a 2-player 2-strategy game,
 * a mixed Nash equilibrium (MNE) specifies probabilities for each player such
 * that the opponent is indifferent between their strategies. For player 1 mixing
 * with probability p on row 1, player 2's expected payoff from each column must
 * be equal (and vice versa). This yields a system of linear equations.
 * {{{
 *   Player 1 mixes to make Player 2 indifferent:
 *     p * a21 + (1-p) * a22 = p * b21 + (1-p) * b22  (for P2's columns)
 *   Player 2 mixes to make Player 1 indifferent (analogous).
 * }}}
 *
 * '''Shapley Value:''' In cooperative game theory, the Shapley value assigns
 * each player their average marginal contribution across all possible orderings
 * of the grand coalition. For player i:
 * {{{
 *   phi_i = sum over coalitions S not containing i of:
 *     |S|! * (n - |S| - 1)! / n! * [v(S union {i}) - v(S)]
 * }}}
 * The Shapley value is the unique allocation satisfying efficiency, symmetry,
 * dummy player, and additivity axioms.
 *
 * '''Colonel Blotto:''' Two players distribute N troops across k battlefields.
 * Each battlefield is won by the player deploying more troops. The goal is to
 * win more battlefields. This game has no pure-strategy equilibrium for k >= 3;
 * optimal play involves mixed strategies and is related to copula theory.
 *
 * '''Iterated Elimination of Dominated Strategies (IEDS):''' A strategy s_i is
 * strictly dominated if there exists another strategy s_i' that yields strictly
 * higher payoff regardless of opponents' play. IEDS removes dominated strategies
 * iteratively until no more can be removed.
 *
 * '''Core of a Cooperative Game:''' An allocation x is in the core if no coalition
 * S can "block" it — i.e., for every coalition S, sum of x_i for i in S >= v(S).
 * The core may be empty (e.g., in some majority voting games).
 *
 * '''Banzhaf Power Index:''' Measures voting power. For each player, count the
 * number of winning coalitions where that player is critical (removing them
 * changes the coalition from winning to losing). Normalize by total critical counts.
 *
 * '''Matching Pennies:''' A classic 2x2 zero-sum game with no pure Nash equilibrium.
 * The unique MNE is (0.5, 0.5) for both players. Value of the game is 0.
 *
 * '''Repeated Games:''' In infinitely repeated prisoner's dilemma, cooperation
 * can be sustained as a Nash equilibrium (folk theorem). Tit-for-tat: cooperate
 * first, then copy opponent's last move. It is simple, retaliatory, and forgiving.
 *
 * ==Comparison: Game Theory Frameworks==
 *
 * | Framework             | Key Concept                         | Application                       |
 * |-----------------------|-------------------------------------|-----------------------------------|
 * | Mixed Nash            | Indifference principle              | Any finite strategic-form game    |
 * | Shapley Value         | Fair division of surplus             | Cost sharing, voting, ML features |
 * | Colonel Blotto        | Resource allocation under conflict  | Military, political campaigns     |
 * | IEDS                  | Rationalizability                   | Simplifying complex games         |
 * | Core                  | Stability of grand coalition        | Market design, coalitional games  |
 * | Banzhaf Index         | Voting power measurement            | Weighted voting systems           |
 * | Tit-for-Tat           | Reciprocity in repeated interaction | Evolutionary game theory          |
 *
 * ==Interview Tips==
 *
 *  - '''Mixed Nash:''' Practice the indifference method for 2x2 games until it
 *    is automatic. Interviewers expect speed.
 *  - '''Shapley value:''' Know the formula and be able to compute for 3-4 players
 *    by hand. It appears in ML feature attribution (SHAP values).
 *  - '''Dominated strategies:''' Always check for dominated strategies first —
 *    it simplifies the game before computing equilibria.
 *  - '''Colonel Blotto:''' Understand the intuition even if you cannot solve it
 *    fully. It tests strategic creativity.
 *  - '''Repeated games:''' Folk theorem is the key — cooperation emerges from
 *    the shadow of the future (sufficiently high discount factor).
 *
 * @see [[https://en.wikipedia.org/wiki/Nash_equilibrium Nash Equilibrium]]
 * @see [[https://en.wikipedia.org/wiki/Shapley_value Shapley Value]]
 * @see [[https://en.wikipedia.org/wiki/Blotto_game Colonel Blotto Game]]
 */
object Logic033_AdvancedGameTheory {

  /** Exercise 1: Mixed Nash Equilibrium for 2x2 Game
   *
   * Given a 2x2 game with payoff matrices for players 1 and 2:
   *   Player 1: ((a11, a12), (a21, a22))
   *   Player 2: ((b11, b12), (b21, b22))
   *
   * Find the mixed strategy Nash equilibrium.
   * Player 1 plays row 1 with probability p, Player 2 plays col 1 with probability q.
   *
   * @param a payoff matrix for Player 1 as ((a11, a12), (a21, a22))
   * @param b payoff matrix for Player 2 as ((b11, b12), (b21, b22))
   * @return ((p, 1-p), (q, 1-q)) — mixed strategies for both players
   */
  def exercise1_mixedNash(
    a: ((Double, Double), (Double, Double)),
    b: ((Double, Double), (Double, Double))
  ): ((Double, Double), (Double, Double)) = ???

  /** Exercise 2: Shapley Value
   *
   * Compute the Shapley value for each player in an n-player cooperative game.
   * The characteristic function v maps each subset (represented as Set[Int])
   * to its value.
   *
   * @param n number of players (labeled 0 to n-1)
   * @param v characteristic function: Set[Int] => Double
   * @return list of Shapley values, one per player
   */
  def exercise2_shapleyValue(n: Int, v: Set[Int] => Double): List[Double] = ???

  /** Exercise 3: Colonel Blotto — Best Response
   *
   * Given totalTroops and numFields=3, and an opponent who distributes troops
   * uniformly (totalTroops/3 per field, remainder to first fields), find the
   * best deterministic response allocation that wins the most fields.
   *
   * @param totalTroops total troops to distribute
   * @param opponentAllocation opponent's allocation across 3 fields
   * @return your optimal allocation as List[Int] (length 3, sums to totalTroops)
   */
  def exercise3_blottoSimple(totalTroops: Int, opponentAllocation: List[Int]): List[Int] = ???

  /** Exercise 4: Iterated Elimination of Dominated Strategies
   *
   * Given a game matrix for player 1 (rows x cols), iteratively remove
   * strictly dominated rows and columns. Return the size of the reduced game.
   *
   * A row i is strictly dominated if there exists another row i' such that
   * for every column j, payoff(i', j) > payoff(i, j). Analogous for columns
   * (using player 2's payoffs, assumed to be the negation for zero-sum games).
   *
   * @param payoff1 Player 1's payoff matrix (list of rows)
   * @param payoff2 Player 2's payoff matrix (list of rows)
   * @return (remaining rows, remaining cols) — dimensions of reduced game
   */
  def exercise4_dominantStrategy(payoff1: List[List[Double]], payoff2: List[List[Double]]): (Int, Int) = ???

  /** Exercise 5: Core of a Cooperative Game
   *
   * Check whether an allocation is in the core. An allocation x = (x_0, ..., x_{n-1})
   * is in the core if:
   *   1. sum(x_i) = v(N) (efficiency)
   *   2. For every coalition S, sum of x_i for i in S >= v(S) (coalitional rationality)
   *
   * @param n number of players
   * @param v characteristic function
   * @param allocation proposed allocation
   * @return true if the allocation is in the core
   */
  def exercise5_cooperativeCore(n: Int, v: Set[Int] => Double, allocation: List[Double]): Boolean = ???

  /** Exercise 6: Banzhaf Power Index
   *
   * In a weighted voting game with weights w and quota q, a coalition wins
   * if sum of weights >= q. A player is critical in a winning coalition if
   * removing them makes it losing. The Banzhaf index is the fraction of
   * critical memberships for each player.
   *
   * @param weights voting weights for each player
   * @param quota threshold to win
   * @return normalized Banzhaf power index for each player
   */
  def exercise6_votingPower(weights: List[Int], quota: Int): List[Double] = ???

  /** Exercise 7: Matching Pennies — Optimal Mixed Strategy
   *
   * Matching pennies: Player 1 wins if both choose the same side,
   * Player 2 wins if they differ. Payoff matrix for P1:
   *   H   T
   * H [1, -1]
   * T [-1, 1]
   *
   * The unique Nash equilibrium is (0.5, 0.5) for both players.
   *
   * @return (p_H, p_T) — Player 1's optimal mixed strategy
   */
  def exercise7_matchingPennies: (Double, Double) = ???

  /** Exercise 8: Tit-for-Tat in Repeated Prisoner's Dilemma
   *
   * Simulate n rounds of repeated prisoner's dilemma. Tit-for-tat starts
   * by cooperating, then copies the opponent's last move.
   * Payoffs: both cooperate = (3,3), both defect = (1,1),
   * one cooperates other defects = (0,5) for cooperator/defector.
   *
   * @param opponentMoves sequence of opponent's moves (true = cooperate, false = defect)
   * @return average per-round payoff for the tit-for-tat player
   */
  def exercise8_repeatedPrisoners(opponentMoves: List[Boolean]): Double = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Mixed Nash Equilibrium
    // Battle of the Sexes variant: P1 prefers (A,A), P2 prefers (B,B)
    val a1 = ((3.0, 0.0), (0.0, 2.0))
    val b1 = ((2.0, 0.0), (0.0, 3.0))
    val r1 = exercise1_mixedNash(a1, b1)
    println(s"Exercise 1 - Mixed Nash: P1 strategy = (${r1._1._1}, ${r1._1._2}), P2 strategy = (${r1._2._1}, ${r1._2._2})")
    assert(math.abs(r1._1._1 + r1._1._2 - 1.0) < 1e-9, "Exercise 1 failed: P1 probabilities must sum to 1")
    assert(math.abs(r1._2._1 + r1._2._2 - 1.0) < 1e-9, "Exercise 1 failed: P2 probabilities must sum to 1")

    // Exercise 2: Shapley Value
    // 3-player majority game: v(S) = 1 if |S| >= 2, else 0
    val v2: Set[Int] => Double = s => if (s.size >= 2) 1.0 else 0.0
    val r2 = exercise2_shapleyValue(3, v2)
    assert(r2.length == 3, "Exercise 2 failed: should have 3 Shapley values")
    assert(math.abs(r2.sum - 1.0) < 1e-9, s"Exercise 2 failed: Shapley values should sum to v(N)=1, got ${r2.sum}")
    assert(r2.forall(v => math.abs(v - 1.0 / 3) < 1e-9), s"Exercise 2 failed: symmetric game, all values should be 1/3")
    println(s"Exercise 2 - Shapley Value: ${r2.map(v => f"$v%.4f").mkString(", ")}")

    // Exercise 3: Colonel Blotto
    val r3 = exercise3_blottoSimple(12, List(4, 4, 4))
    assert(r3.sum == 12, s"Exercise 3 failed: troops must sum to 12, got ${r3.sum}")
    assert(r3.length == 3, "Exercise 3 failed: must allocate across 3 fields")
    println(s"Exercise 3 - Blotto best response to (4,4,4): $r3")

    // Exercise 4: Dominated Strategy Elimination
    // P1 payoffs: row 0 is dominated by row 1
    val pay1 = List(List(1.0, 2.0), List(3.0, 4.0), List(2.0, 3.0))
    val pay2 = List(List(3.0, 1.0), List(2.0, 0.0), List(1.0, 2.0))
    val r4 = exercise4_dominantStrategy(pay1, pay2)
    assert(r4._1 <= 3 && r4._2 <= 2, s"Exercise 4 failed: reduced game too large: $r4")
    println(s"Exercise 4 - IEDS reduced game size: ${r4._1} x ${r4._2}")

    // Exercise 5: Core check
    // v(N)=12, v({0,1})=6, v({0,2})=5, v({1,2})=4, v({i})=0
    // Core: x0+x1>=6, x0+x2>=5, x1+x2>=4, x0+x1+x2=12
    // (5,4,3): pairs = 9>=6, 8>=5, 7>=4 ✓ — in the core
    val v5: Set[Int] => Double = {
      case s if s == Set(0, 1, 2) => 12.0
      case s if s == Set(0, 1) => 6.0
      case s if s == Set(0, 2) => 5.0
      case s if s == Set(1, 2) => 4.0
      case s if s.size == 1 => 0.0
      case _ => 0.0
    }
    val r5a = exercise5_cooperativeCore(3, v5, List(5.0, 4.0, 3.0))
    assert(r5a, s"Exercise 5 failed: (5,4,3) should be in the core")
    // (10,1,1): pairs = 11>=6, 11>=5, 2<4 ✗ — NOT in the core
    val r5b = exercise5_cooperativeCore(3, v5, List(10.0, 1.0, 1.0))
    assert(!r5b, s"Exercise 5 failed: (10,1,1) should NOT be in the core")
    println(s"Exercise 5 - Core: (5,4,3) in core = $r5a, (10,1,1) in core = $r5b")

    // Exercise 6: Banzhaf Power Index
    val r6 = exercise6_votingPower(List(3, 2, 1), 4)
    assert(r6.length == 3, "Exercise 6 failed: should have 3 power indices")
    assert(math.abs(r6.sum - 1.0) < 1e-9, s"Exercise 6 failed: indices should sum to 1")
    println(s"Exercise 6 - Banzhaf Power Index: ${r6.map(v => f"$v%.4f").mkString(", ")}")

    // Exercise 7: Matching Pennies
    val r7 = exercise7_matchingPennies
    assert(math.abs(r7._1 - 0.5) < 1e-9 && math.abs(r7._2 - 0.5) < 1e-9,
      s"Exercise 7 failed: expected (0.5, 0.5), got $r7")
    println(s"Exercise 7 - Matching Pennies: optimal strategy = $r7")

    // Exercise 8: Repeated Prisoner's Dilemma
    // Opponent always cooperates -> TfT always cooperates -> payoff = 3 per round
    val r8a = exercise8_repeatedPrisoners(List(true, true, true, true, true))
    assert(math.abs(r8a - 3.0) < 1e-9, s"Exercise 8 failed: expected 3.0, got $r8a")
    // Opponent always defects -> TfT: C then D,D,D,D -> payoffs: 0,1,1,1,1 -> avg = 0.8
    val r8b = exercise8_repeatedPrisoners(List(false, false, false, false, false))
    assert(math.abs(r8b - 0.8) < 1e-9, s"Exercise 8 failed: expected 0.8, got $r8b")
    println(s"Exercise 8 - TfT vs always cooperate: $r8a, vs always defect: $r8b")

    println("\nAll Advanced Game Theory exercises passed!")
  }
}
