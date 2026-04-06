package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Game Theory (Теорія ігор)=
 *
 * ==Theory: Combinatorial Game Theory and Strategic Decision Making==
 *
 * Game theory studies mathematical models of strategic interaction between
 * rational decision-makers. In coding interviews (especially quant firms like
 * Jane Street, Citadel, Two Sigma) and FAANG, game theory questions test
 * your ability to reason about optimal play and recursive structure.
 *
 * '''Nim Game:''' The classic combinatorial game with piles of stones. Players
 * alternate removing any positive number of stones from a single pile. The
 * player who takes the last stone wins. The key insight is:
 * {{{
 *   First player wins ⟺ XOR of all pile sizes ≠ 0
 * }}}
 *
 * '''Sprague-Grundy Theorem:''' Every impartial game (same moves available to
 * both players) is equivalent to a Nim heap of some size. The Grundy number
 * (nimber) of a position is:
 * {{{
 *   G(position) = mex({G(p') | p' is a position reachable in one move})
 *   mex(S) = minimum excludant = smallest non-negative integer not in S
 * }}}
 * For a game that is a sum of independent subgames: G(total) = XOR of all G(subgame_i).
 *
 * '''Wythoff's Game:''' Two piles; a player can take any amount from one pile,
 * OR take the same amount from both piles. Losing positions (cold positions)
 * are (⌊k*φ⌋, ⌊k*φ²⌋) and their reversal, where φ = (1+√5)/2 is the golden ratio.
 *
 * '''Nash Equilibrium:''' A strategy profile where no player can improve their
 * payoff by unilaterally changing their strategy. In pure strategy, we look for
 * cells in the payoff matrix that are simultaneously row-maxima and column-minima.
 *
 * '''Minimax:''' In zero-sum games, the maximizing player picks the move that
 * maximizes the minimum payoff, while the minimizing player picks the move that
 * minimizes the maximum payoff. Alpha-beta pruning optimizes this search.
 *
 * '''Zero-Sum Games:''' Games where one player's gain equals the other's loss.
 * The value of the game exists when maximin = minimax (by the minimax theorem,
 * this always holds for mixed strategies).
 *
 * ==Comparison: Game Theory Concepts==
 *
 * | Concept            | Key Idea                              | When to Use                     |
 * |--------------------|---------------------------------------|---------------------------------|
 * | Nim / XOR          | XOR of piles determines winner        | Stone-pile removal games        |
 * | Sprague-Grundy     | Reduce any game to Nim via mex        | Any impartial combinatorial game|
 * | Wythoff's Game     | Golden ratio determines losing pos    | Two-pile with symmetric moves   |
 * | Nash Equilibrium   | No unilateral deviation is profitable | Strategic form games            |
 * | Minimax            | Max of mins = optimal play            | Two-player zero-sum trees       |
 * | Alpha-Beta Pruning | Skip provably suboptimal branches     | Optimizing minimax search       |
 *
 * ==Interview Tips==
 *
 *  - '''Nim XOR trick''' is the single most important game theory fact for interviews.
 *  - For Sprague-Grundy, practice computing mex — it is the core operation.
 *  - '''Wythoff''' comes up in quant interviews as a "two-pile" variant question.
 *  - When asked about Nash equilibrium, clarify: pure or mixed strategies?
 *  - '''Minimax''' connects directly to game-tree AI (chess, tic-tac-toe).
 *  - Always check: is the game impartial (same moves for both) or partisan?
 *
 * ==Complexity Note==
 *
 * Grundy number computation is O(n * |moves|) for single-pile games.
 * Minimax on a game tree is O(b^d) where b = branching factor, d = depth.
 * Alpha-beta pruning reduces this to O(b^(d/2)) in the best case.
 */
object Logic021_GameTheory {

  /**
   * Exercise 1: Nim Game — Determine Winner
   *
   * Given a list of pile sizes in a standard Nim game, determine if the first
   * player has a winning strategy. First player wins if and only if the XOR
   * (Nim-sum) of all pile sizes is non-zero.
   *
   * @param piles list of pile sizes (non-negative integers)
   * @return true if the first player wins with optimal play
   */
  def exercise1_nimWinner(piles: List[Int]): Boolean = ???

  /**
   * Exercise 2: Grundy Number for Single-Pile Game
   *
   * Compute the Grundy number (nimber) for a position with n stones and a
   * given set of allowed moves. The Grundy number is the mex (minimum excludant)
   * of the Grundy numbers of all reachable positions.
   *
   * @param n     pile size (number of stones)
   * @param moves set of allowed move sizes (e.g., Set(1, 2, 3))
   * @return Grundy number for position n
   */
  def exercise2_grundyNumber(n: Int, moves: Set[Int]): Int = ???

  /**
   * Exercise 3: Nim-Sum (XOR of Piles)
   *
   * Compute the Nim-sum, which is the bitwise XOR of all pile sizes.
   * This is the fundamental operation in Nim game analysis.
   *
   * @param piles list of pile sizes
   * @return XOR of all pile sizes
   */
  def exercise3_nimSum(piles: List[Int]): Int = ???

  /**
   * Exercise 4: Wythoff's Game — Determine Winner
   *
   * In Wythoff's game, two piles of sizes a and b are given. A player can
   * take any number of stones from one pile, or the same number from both.
   * The losing positions (for the player to move) are (⌊k*φ⌋, ⌊k*φ²⌋)
   * for k = 0, 1, 2, ... where φ = (1+√5)/2.
   * If (min(a,b), max(a,b)) is NOT a losing position, the first player wins.
   *
   * @param a size of first pile
   * @param b size of second pile
   * @return true if the first player wins with optimal play
   */
  def exercise4_wythoffWinner(a: Int, b: Int): Boolean = ???

  /**
   * Exercise 5: Nash Equilibrium in 2x2 Game (Pure Strategy)
   *
   * Given a 2x2 payoff matrix for the row player, find a pure-strategy
   * Nash equilibrium. A cell (i, j) is a Nash equilibrium if:
   * - payoff(i, j) >= payoff(i', j) for all i' (best response for row player)
   * - payoff(i, j) <= payoff(i, j') for all j' (best response for column player,
   *   since column player minimizes in zero-sum interpretation)
   *
   * For a general 2-player game, (i,j) is Nash if row i is best response to
   * column j AND column j is best response to row i. Here we use two matrices:
   * rowPayoffs and colPayoffs.
   *
   * @param rowPayoffs 2x2 payoff matrix for row player
   * @param colPayoffs 2x2 payoff matrix for column player
   * @return Some((row, col)) if a pure-strategy Nash equilibrium exists, None otherwise
   */
  def exercise5_nashEquilibrium(rowPayoffs: Array[Array[Int]], colPayoffs: Array[Array[Int]]): Option[(Int, Int)] = ???

  /**
   * Exercise 6: Minimax Evaluation of Game Tree
   *
   * Evaluate a game tree using the minimax algorithm. The tree is represented
   * as a flat list of leaf values and a depth. At even depths the maximizing
   * player plays; at odd depths the minimizing player plays. The tree is a
   * complete binary tree of given depth.
   *
   * @param leaves list of leaf values (length must be 2^depth)
   * @param depth  depth of the game tree
   * @return the minimax value of the root
   */
  def exercise6_minimax(leaves: List[Int], depth: Int): Int = ???

  /**
   * Exercise 7: Multi-Pile Game with Custom Moves (Sprague-Grundy)
   *
   * Given multiple piles, each with the same set of allowed moves,
   * compute the overall Grundy number. By the Sprague-Grundy theorem,
   * the Grundy number of a sum of games is the XOR of individual Grundy numbers.
   *
   * @param piles list of pile sizes
   * @param moves set of allowed move sizes
   * @return XOR of Grundy numbers of all piles
   */
  def exercise7_sprague(piles: List[Int], moves: Set[Int]): Int = ???

  /**
   * Exercise 8: Value of a Zero-Sum Game
   *
   * For a two-player zero-sum game with a payoff matrix (from row player's
   * perspective), find the value of the game in pure strategies.
   * The value exists in pure strategies when maximin = minimax:
   * - maximin = max over rows of (min of that row)
   * - minimax = min over columns of (max of that column)
   * If they are equal, that is the saddle point value.
   *
   * @param payoff the payoff matrix for the row player
   * @return Some(value) if a saddle point exists, None otherwise
   */
  def exercise8_zeroSumValue(payoff: Array[Array[Int]]): Option[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Nim Winner
    assert(exercise1_nimWinner(List(1, 2, 3)) == false)  // 1 XOR 2 XOR 3 = 0
    assert(exercise1_nimWinner(List(1, 2, 4)) == true)   // 1 XOR 2 XOR 4 = 7
    assert(exercise1_nimWinner(List(3, 4, 5)) == true)   // 3 XOR 4 XOR 5 = 2
    assert(exercise1_nimWinner(List(0)) == false)         // empty pile, first player loses
    println("Exercise 1 passed: nimWinner")

    // Exercise 2: Grundy Number
    assert(exercise2_grundyNumber(0, Set(1, 2, 3)) == 0) // no moves from 0
    assert(exercise2_grundyNumber(1, Set(1, 2, 3)) == 1)
    assert(exercise2_grundyNumber(2, Set(1, 2, 3)) == 2)
    assert(exercise2_grundyNumber(3, Set(1, 2, 3)) == 3)
    assert(exercise2_grundyNumber(4, Set(1, 2, 3)) == 0) // mex({3,2,1}) = 0
    assert(exercise2_grundyNumber(5, Set(1, 2, 3)) == 1)
    println("Exercise 2 passed: grundyNumber")

    // Exercise 3: Nim-Sum
    assert(exercise3_nimSum(List(3, 4, 5)) == 2)
    assert(exercise3_nimSum(List(1, 2, 3)) == 0)
    assert(exercise3_nimSum(List(7)) == 7)
    assert(exercise3_nimSum(List.empty) == 0)
    println("Exercise 3 passed: nimSum")

    // Exercise 4: Wythoff Winner
    assert(exercise4_wythoffWinner(0, 0) == false) // (0,0) is a losing position (k=0)
    assert(exercise4_wythoffWinner(1, 2) == false) // (1,2) is a cold position (k=1)
    assert(exercise4_wythoffWinner(2, 1) == false) // symmetric
    assert(exercise4_wythoffWinner(1, 1) == true)  // not a cold position
    assert(exercise4_wythoffWinner(3, 5) == false) // (3,5) is a cold position (k=2)
    assert(exercise4_wythoffWinner(4, 6) == true)  // not a cold position
    println("Exercise 4 passed: wythoffWinner")

    // Exercise 5: Nash Equilibrium
    // Prisoner's dilemma style: (C,C)=(-1,-1), (C,D)=(-3,0), (D,C)=(0,-3), (D,D)=(-2,-2)
    // Nash equilibrium at (1,1) = (D,D)
    val rp1 = Array(Array(-1, -3), Array(0, -2))
    val cp1 = Array(Array(-1, 0), Array(-3, -2))
    assert(exercise5_nashEquilibrium(rp1, cp1) == Some((1, 1)))
    // Game with no pure Nash: matching pennies
    val rp2 = Array(Array(1, -1), Array(-1, 1))
    val cp2 = Array(Array(-1, 1), Array(1, -1))
    assert(exercise5_nashEquilibrium(rp2, cp2) == None)
    println("Exercise 5 passed: nashEquilibrium")

    // Exercise 6: Minimax
    // Depth 2, 4 leaves: max layer, then min layer
    // Tree: max(min(3,5), min(2,9)) = max(3, 2) = 3
    assert(exercise6_minimax(List(3, 5, 2, 9), 2) == 3)
    // Depth 1, 2 leaves: max(1, 4) = 4
    assert(exercise6_minimax(List(1, 4), 1) == 4)
    // Depth 3, 8 leaves: max(min(max(3,5),max(6,9)), min(max(1,2),max(0,-1))) = max(min(5,9), min(2,0)) = max(5,0) = 5
    assert(exercise6_minimax(List(3, 5, 6, 9, 1, 2, 0, -1), 3) == 5)
    println("Exercise 6 passed: minimax")

    // Exercise 7: Sprague-Grundy for multi-pile
    // moves = {1,2,3}, Grundy for pile 4 = 0, pile 5 = 1, pile 6 = 2 → XOR = 3
    assert(exercise7_sprague(List(4, 5, 6), Set(1, 2, 3)) == 3)
    assert(exercise7_sprague(List(1, 1), Set(1, 2, 3)) == 0) // 1 XOR 1 = 0
    assert(exercise7_sprague(List(3), Set(1, 2, 3)) == 3)
    println("Exercise 7 passed: sprague")

    // Exercise 8: Zero-Sum Game Value
    // Saddle point at (0,1) with value 3
    val payoff1 = Array(Array(3, 3), Array(2, 4))
    assert(exercise8_zeroSumValue(payoff1) == Some(3))
    // No saddle point
    val payoff2 = Array(Array(1, 4), Array(3, 2))
    assert(exercise8_zeroSumValue(payoff2) == None)
    println("Exercise 8 passed: zeroSumValue")

    println("\nAll exercises passed!")
  }
}
