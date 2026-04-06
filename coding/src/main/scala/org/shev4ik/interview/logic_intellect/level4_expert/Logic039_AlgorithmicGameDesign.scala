package org.shev4ik.interview.logic_intellect.level4_expert

/**
 * =Algorithmic Game Design and Combinatorial Games (Алгоритмічний дизайн ігор)=
 *
 * ==Theory: Combinatorial Game Theory and Game Complexity==
 *
 * Combinatorial game theory (CGT) studies two-player, perfect-information,
 * deterministic games with no chance element. Unlike classical game theory
 * (Nash equilibria, mixed strategies), CGT focuses on who wins with optimal
 * play and by how much. This field connects deeply to algebra (surreal
 * numbers), complexity theory, and algorithm design.
 *
 * '''Hex Game:''' Played on an n×n rhombus-shaped board. Two players alternately
 * place stones; one connects top-bottom, the other left-right. Key properties:
 * (1) The game cannot end in a draw (topological fact: exactly one player
 * connects). (2) First player wins by strategy-stealing: if second player had
 * a winning strategy, first player could "steal" it by making an arbitrary
 * first move (an extra stone never hurts in Hex). This is a pure existence
 * proof — no explicit strategy is known for large n.
 *
 * '''Chomp:''' An m×n chocolate bar where the bottom-left cell is poisoned.
 * Players take turns eating a cell and all cells above and to the right.
 * The player forced to eat the poison loses. First player wins for all
 * m*n > 1 (by strategy-stealing), but explicit strategies are unknown
 * except for special cases (1×n, n×n with small n).
 *
 * '''Sprague-Grundy Theory:''' Every impartial game position has a Grundy
 * number (nimber). A position is losing (P-position) iff its Grundy number
 * is 0. For compound games, the Grundy number is the XOR of components.
 *
 * '''Surreal Numbers:''' Invented by John Conway. Every combinatorial game
 * position {L | R} defines a surreal number. Examples: {|} = 0, {0|} = 1,
 * {|0} = -1, {0|1} = 1/2. Surreal numbers form the largest ordered field,
 * containing all reals and all ordinals.
 *
 * '''Game Complexity:''' Games are classified by computational complexity:
 *   - Nim: P (polynomial) — XOR trick gives O(n) solution
 *   - Hex: PSPACE-complete (determining winner is PSPACE-complete)
 *   - Chess: EXPTIME-complete (with generalized board)
 *   - Go: EXPTIME-complete (with generalized board)
 *   - Checkers: solved (2007, Schaeffer et al.) — it is a draw
 *
 * '''Sprouts:''' A pencil-and-paper game. Start with n dots. Each move draws
 * a curve between two dots (or a loop) and adds a new dot on the curve.
 * No dot may have more than 3 edges. The game lasts at most 3n - 1 moves.
 *
 * ==Comparison: Combinatorial Games==
 *
 * | Game       | Type       | First Player Wins?  | Complexity Class    |
 * |------------|------------|---------------------|---------------------|
 * | Nim        | Impartial  | If XOR ≠ 0          | P                   |
 * | Hex        | Partisan   | Always (strategy-stealing) | PSPACE-complete|
 * | Chomp      | Impartial  | Always (m*n > 1)    | Unknown (not in P?) |
 * | Chess      | Partisan   | Unknown             | EXPTIME-complete    |
 * | Go         | Partisan   | Unknown (with komi) | EXPTIME-complete    |
 * | Sprouts    | Impartial  | Depends on n        | Open                |
 *
 * ==Interview Tips==
 *
 *  - '''Strategy-stealing''' is a beautiful proof technique — understand the argument.
 *  - '''Grundy numbers''' and '''XOR''' are the bread and butter of game theory interviews.
 *  - Know the '''complexity hierarchy''': P ⊂ NP ⊂ PSPACE ⊂ EXPTIME.
 *  - '''Surreal numbers''' are rarely asked but show deep mathematical maturity.
 *  - For Hex, the key fact is that '''draws are impossible''' (topological connectivity).
 *  - Sprouts is a great example of a game with '''bounded game length'''.
 *  - '''Partisan games''' (like Hex, Chess) have different moves for each player.
 *
 * ==Complexity Note==
 *
 * Computing Grundy numbers for a general game tree is O(states * branching_factor).
 * Strategy-stealing proofs are non-constructive. Solving Hex optimally on an
 * n×n board is PSPACE-complete.
 */
object Logic039_AlgorithmicGameDesign {

  /**
   * Exercise 1: Hex Winner
   *
   * By the strategy-stealing argument, the first player always has a winning
   * strategy in Hex on an n×n board (n >= 1). An extra stone never hurts the
   * first player, and draws are impossible, so if second player had a winning
   * strategy, first player could steal it. Return "first".
   *
   * @param n board dimension (n >= 1)
   * @return "first" — the first player always wins with optimal play
   */
  def exercise1_hexWinner(n: Int): String = ???

  /**
   * Exercise 2: Chomp Winner
   *
   * In Chomp on an m×n chocolate bar (bottom-left is poison), the first player
   * wins whenever m*n > 1. This follows from strategy-stealing: if the second
   * player had a winning response to (m-1, n-1) being eaten, first player
   * could eat just that cell first.
   *
   * @param m rows of the chocolate bar (m >= 1)
   * @param n columns of the chocolate bar (n >= 1)
   * @return true if first player wins (i.e., m*n > 1)
   */
  def exercise2_chompWinner(m: Int, n: Int): Boolean = ???

  /**
   * Exercise 3: Nim Value (Grundy Number)
   *
   * Compute the Grundy number (nim-value) for a simplified game position.
   * Given a single pile of n stones where a player can take 1, 2, or 3 stones,
   * the Grundy number is n mod 4. This is the Sprague-Grundy value.
   *
   * @param n pile size (n >= 0)
   * @return Grundy number (n mod 4)
   */
  def exercise3_nimValue(n: Int): Int = ???

  /**
   * Exercise 4: Surreal Number Arithmetic
   *
   * Represent simple surreal numbers as strings. Given two surreal number
   * representations, compute their sum using the rules:
   *   {|} = 0, {0|} = 1, {1|} = 2, {|0} = -1
   *   {0|1} = 1/2
   * For this exercise, given integer values a and b, return the surreal
   * representation of a + b as "{n|}" for positive n, "{|}" for 0, or
   * "{|n}" for negative values (simplified notation).
   *
   * @param a first integer
   * @param b second integer
   * @return surreal number string representation of a + b
   */
  def exercise4_surreal(a: Int, b: Int): String = ???

  /**
   * Exercise 5: Game Complexity Classification
   *
   * Return a map classifying well-known games by their computational
   * complexity class (for generalized versions of the games).
   *
   * @return Map of game name -> complexity class string
   */
  def exercise5_gameComplexity: Map[String, String] = ???

  /**
   * Exercise 6: Sprouts Maximum Moves
   *
   * In the game of Sprouts starting with n initial dots, the maximum number
   * of moves is 3n - 1. Each dot starts with 3 available connections, giving
   * 3n total connections. Each move uses 2 connections and creates 1 new dot
   * with 1 available connection (net: -2 + 1 = -1). The game ends when no
   * move is possible.
   *
   * @param n number of initial dots (n >= 1)
   * @return maximum possible number of moves
   */
  def exercise6_sproutsMaxMoves(n: Int): Int = ???

  /**
   * Exercise 7: Strategy-Stealing Argument
   *
   * Formulate the strategy-stealing proof structure for Hex. The argument
   * has three key steps:
   * (1) Hex cannot end in a draw.
   * (2) Therefore one player has a winning strategy.
   * (3) If it were the second player, the first player could make an arbitrary
   *     move and then follow the second player's strategy (an extra stone
   *     never hurts), contradicting the assumption.
   *
   * Return a string summarizing the argument.
   *
   * @return string explanation of the strategy-stealing proof
   */
  def exercise7_strategySteal: String = ???

  /**
   * Exercise 8: Partizan Game Value
   *
   * In a simple partizan game, Left and Right have different available moves.
   * Given Left's options (list of game values) and Right's options (list of
   * game values), compute the game value. For simple integer games:
   *   - If no Left options and no Right options: value is 0
   *   - If Left's max option is n and Right has no options: value is n + 1
   *   - If Right's min option is n and Left has no options: value is n - 1
   * Return the value as a string.
   *
   * @param leftOptions  game values available to Left
   * @param rightOptions game values available to Right
   * @return string representation of the game value
   */
  def exercise8_partizanGame(leftOptions: List[Int], rightOptions: List[Int]): String = ???

  def main(args: Array[String]): Unit = {

    // Exercise 1: Hex Winner
    assert(exercise1_hexWinner(5) == "first", "First player always wins Hex")
    assert(exercise1_hexWinner(11) == "first", "First player always wins Hex on 11×11")
    println(s"Exercise 1 - Hex winner (5×5): ${exercise1_hexWinner(5)}")

    // Exercise 2: Chomp Winner
    assert(exercise2_chompWinner(3, 4) == true, "First player wins 3×4 Chomp")
    assert(exercise2_chompWinner(1, 1) == false, "First player loses 1×1 Chomp (forced to eat poison)")
    assert(exercise2_chompWinner(1, 5) == true, "First player wins 1×5 Chomp")
    println(s"Exercise 2 - Chomp winner (3×4): ${exercise2_chompWinner(3, 4)}")
    println(s"Exercise 2 - Chomp winner (1×1): ${exercise2_chompWinner(1, 1)}")

    // Exercise 3: Nim Value
    assert(exercise3_nimValue(0) == 0, "Grundy(0) = 0")
    assert(exercise3_nimValue(1) == 1, "Grundy(1) = 1")
    assert(exercise3_nimValue(4) == 0, "Grundy(4) = 0")
    assert(exercise3_nimValue(7) == 3, "Grundy(7) = 3")
    println(s"Exercise 3 - Nim value (7): ${exercise3_nimValue(7)}")

    // Exercise 4: Surreal Number
    assert(exercise4_surreal(1, 1) == "{2|}", "1 + 1 = {2|}")
    assert(exercise4_surreal(0, 0) == "{|}", "0 + 0 = {|}")
    assert(exercise4_surreal(-1, -2) == "{|-3}", "-1 + -2 = {|-3}")
    println(s"Exercise 4 - Surreal (1+1): ${exercise4_surreal(1, 1)}")
    println(s"Exercise 4 - Surreal (0+0): ${exercise4_surreal(0, 0)}")

    // Exercise 5: Game Complexity
    val complexity = exercise5_gameComplexity
    assert(complexity("Nim") == "P", "Nim is in P")
    assert(complexity("Chess") == "EXPTIME-complete", "Chess is EXPTIME-complete")
    assert(complexity("Go") == "EXPTIME-complete", "Go is EXPTIME-complete")
    println(s"Exercise 5 - Game complexity: $complexity")

    // Exercise 6: Sprouts Max Moves
    assert(exercise6_sproutsMaxMoves(1) == 2, "Sprouts with 1 dot: max 2 moves")
    assert(exercise6_sproutsMaxMoves(3) == 8, "Sprouts with 3 dots: max 8 moves")
    assert(exercise6_sproutsMaxMoves(5) == 14, "Sprouts with 5 dots: max 14 moves")
    println(s"Exercise 6 - Sprouts max moves (n=3): ${exercise6_sproutsMaxMoves(3)}")

    // Exercise 7: Strategy-Stealing
    val proof = exercise7_strategySteal
    assert(proof.nonEmpty, "Strategy-stealing proof should be non-empty")
    assert(proof.toLowerCase.contains("first"), "Proof should mention first player")
    println(s"Exercise 7 - Strategy-stealing argument: $proof")

    // Exercise 8: Partizan Game
    // {|} = 0
    assert(exercise8_partizanGame(List(), List()) == "0", "No options = 0")
    // {0|} = 1
    assert(exercise8_partizanGame(List(0), List()) == "1", "{0|} = 1")
    // {|0} = -1
    assert(exercise8_partizanGame(List(), List(0)) == "-1", "{|0} = -1")
    println(s"Exercise 8 - Partizan game (Left=[0], Right=[]): ${exercise8_partizanGame(List(0), List())}")

    println("\nAll Logic039_AlgorithmicGameDesign exercises passed!")
  }
}
