package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Game Theory DP - optimal play in two-player games.
 *
 * Key concepts:
 * - Minimax: maximize your score while opponent minimizes it
 * - Sprague-Grundy theorem: every impartial game is equivalent to a Nim heap
 * - Grundy numbers: XOR of Grundy values determines winner
 */
object Algo082_DPGames {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Stone game
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Piles of stones in a row. Two players take turns picking from either end.
   *       Both play optimally. Return true if player 1 wins (gets more stones).
   *       dp(i,j) = max advantage (my score - opponent score) for piles[i..j].
   *
   * @param piles array of pile sizes
   * @return true if player 1 wins
   */
  def stoneGame(piles: Array[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Predict the winner
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Two players take turns picking from either end of array.
   *       Player 1 starts. Return true if player 1 can win or tie.
   *       dp(i,j) = max score difference (current player - other player) for nums[i..j].
   *
   * @param nums array of values
   * @return true if player 1 can win or tie
   */
  def predictTheWinner(nums: Array[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Stone game II
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Piles of stones. Player can take first 1..2M piles; M = max(M, x) after taking x piles.
   *       Initially M=1. Both play optimally. Return max stones player 1 can get.
   *       dp(i, m) = max stones current player gets from piles[i..] with parameter M=m.
   *
   * @param piles array of pile sizes
   * @return max stones for player 1
   */
  def stoneGameII(piles: Array[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Stone game III
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Players take 1, 2, or 3 stones from the front. Each plays optimally.
   *       Return "Alice", "Bob", or "Tie".
   *       dp(i) = max advantage for current player starting from index i.
   *
   * @param values stone values
   * @return "Alice", "Bob", or "Tie"
   */
  def stoneGameIII(values: Array[Int]): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Nim game
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Classic Nim: multiple heaps, players take any number from one heap.
   *       Player who takes last stone wins. Return true if first player wins.
   *       Hint: XOR of all heap sizes. If XOR != 0, first player wins.
   *
   * @param heaps array of heap sizes
   * @return true if first player wins
   */
  def nimGame(heaps: Array[Int]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Grundy numbers
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the Grundy number (nimber) for a single-pile game where
   *       valid moves are specified by `moves` set (e.g., {1, 2, 3}).
   *       Grundy(n) = mex({Grundy(n - m) : m in moves, m <= n}).
   *       mex = minimum excludant (smallest non-negative integer not in set).
   *
   * @param n     pile size
   * @param moves set of valid move sizes
   * @return Grundy number for pile of size n
   */
  def grundyNumber(n: Int, moves: Set[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Sprague-Grundy for multiple games
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given multiple independent sub-games, each with a pile size and move set,
   *       determine if the first player wins using the Sprague-Grundy theorem.
   *       XOR of all Grundy numbers. First player wins iff XOR != 0.
   *
   * @param games list of (pile size, valid moves)
   * @return true if first player wins
   */
  def spragueGrundy(games: List[(Int, Set[Int])]): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Minimax concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement minimax for a simple number-picking game.
   *       Array of numbers, players alternately pick from either end.
   *       Return the score for each player as (player1Score, player2Score)
   *       when both play optimally.
   *
   * @param nums array of values
   * @return (player1 score, player2 score)
   */
  def minimax(nums: Array[Int]): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(stoneGame(Array(5, 3, 4, 5)))
    println("Exercise 1 (Stone game) passed.")

    // Exercise 2
    assert(predictTheWinner(Array(1, 5, 2)))
    assert(!predictTheWinner(Array(1, 5, 233, 7)))
    println("Exercise 2 (Predict winner) passed.")

    // Exercise 3
    val sg2 = stoneGameII(Array(2, 7, 9, 4, 4))
    assert(sg2 == 10, s"Expected 10, got $sg2")
    println("Exercise 3 (Stone game II) passed.")

    // Exercise 4
    assert(stoneGameIII(Array(1, 2, 3, 7)) == "Bob")
    assert(stoneGameIII(Array(1, 2, 3, -9)) == "Alice")
    println("Exercise 4 (Stone game III) passed.")

    // Exercise 5
    assert(nimGame(Array(1, 2, 3)))
    assert(!nimGame(Array(1, 1)))
    println("Exercise 5 (Nim) passed.")

    // Exercise 6
    assert(grundyNumber(0, Set(1, 2, 3)) == 0)
    assert(grundyNumber(1, Set(1, 2, 3)) == 1)
    assert(grundyNumber(4, Set(1, 2, 3)) == 0)
    println("Exercise 6 (Grundy numbers) passed.")

    // Exercise 7
    assert(spragueGrundy(List((3, Set(1, 2)), (4, Set(1, 2)))))
    println("Exercise 7 (Sprague-Grundy) passed.")

    // Exercise 8
    val (s1, s2) = minimax(Array(1, 5, 2))
    assert(s1 + s2 == 8)
    assert(s1 >= s2)
    println("Exercise 8 (Minimax) passed.")

    println("All Algo082_DPGames exercises passed!")
  }
}
