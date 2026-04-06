package org.shev4ik.interview.logic_intellect.level3_advanced

/**
 * =Constraint Satisfaction Problems (Задачі задоволення обмежень)=
 *
 * ==Theory: CSP, Backtracking, and Constraint Propagation==
 *
 * Constraint satisfaction problems (CSPs) are a fundamental class of problems
 * in AI and combinatorial optimization. A CSP consists of variables, domains,
 * and constraints. The goal is to assign values to variables such that all
 * constraints are satisfied.
 *
 * '''N-Queens Problem:''' Place N queens on an N×N chessboard such that no two
 * queens threaten each other. A queen attacks along rows, columns, and diagonals.
 * The number of solutions grows rapidly:
 * {{{
 *   N:        1   2   3   4   5   6   7    8
 *   Solutions: 1   0   0   2  10   4  40   92
 * }}}
 * Solved via backtracking: place queens column by column, pruning invalid placements.
 *
 * '''Cryptarithmetic:''' Puzzles like SEND + MORE = MONEY where each letter
 * represents a unique digit. Constraints include:
 * - Each letter maps to a distinct digit (0-9)
 * - Leading letters cannot be 0
 * - The arithmetic equation must hold
 *
 * '''Sudoku as CSP:''' A 9×9 grid with constraints:
 * - Each row contains digits 1-9 exactly once
 * - Each column contains digits 1-9 exactly once
 * - Each 3×3 box contains digits 1-9 exactly once
 * Solved using constraint propagation (naked singles, hidden singles) + backtracking.
 *
 * '''Magic Squares:''' An n×n grid filled with distinct integers 1..n² such that
 * all rows, columns, and both diagonals sum to the same magic constant:
 * {{{
 *   M(n) = n * (n² + 1) / 2
 * }}}
 * For n=3, M=15. For n=4, M=34.
 *
 * '''Latin Squares:''' An n×n grid filled with n different symbols, each occurring
 * exactly once in each row and column. Sudoku is a special case with additional
 * box constraints.
 *
 * '''Backtracking with Pruning:''' The general strategy for CSPs:
 * 1. Choose an unassigned variable (use MRV heuristic for efficiency)
 * 2. Try values from its domain
 * 3. Check constraints — prune if violated
 * 4. Recurse; backtrack if no valid assignment found
 *
 * ==Comparison: Constraint Problems==
 *
 * | Problem          | Variables         | Constraints                    | Complexity        |
 * |------------------|-------------------|--------------------------------|-------------------|
 * | N-Queens         | N queen positions | No shared row/col/diagonal     | Exponential       |
 * | Sudoku           | 81 cells          | Row/col/box uniqueness         | NP-complete       |
 * | Cryptarithmetic  | Letter→digit map  | Distinct digits + arithmetic   | O(10!) worst case |
 * | Magic Square     | n² cell values    | Row/col/diag sum = M(n)        | Exponential       |
 * | Latin Square     | n² cell values    | Row/col uniqueness             | Exponential       |
 *
 * ==Interview Tips==
 *
 *  - '''N-Queens''' is the classic backtracking problem — know it cold.
 *  - For '''Sudoku''', constraint propagation alone solves most easy/medium puzzles.
 *  - '''Cryptarithmetic''' tests your ability to prune the search space.
 *  - '''Non-attacking rooks''' is much simpler than queens: P(n, k) = n!/(n-k)! * C(n,k)...
 *    Actually it's C(n,k)^2 * k! = P(n,k) * C(n,k). Simpler: choose k rows, k cols, permute.
 *  - Always discuss time complexity and pruning strategies in interviews.
 *  - For magic squares, knowing the magic constant formula is often sufficient.
 *
 * ==Complexity Note==
 *
 * N-Queens backtracking runs in O(N!) worst case but pruning makes it much faster
 * in practice. Sudoku solving is NP-complete in general but 9×9 instances are
 * tractable. Cryptarithmetic with k letters is O(10! / (10-k)!) in the worst case.
 */
object Logic023_CryptarithmeticAndConstraints {

  /**
   * Exercise 1: N-Queens — Count Solutions
   *
   * Count the number of distinct solutions to the N-Queens problem.
   * A solution places N non-attacking queens on an N×N board.
   *
   * @param n board size (and number of queens)
   * @return number of distinct solutions
   */
  def exercise1_nQueens(n: Int): Int = ???

  /**
   * Exercise 2: N-Queens — Find One Solution
   *
   * Find one valid arrangement for the N-Queens problem. The result is
   * a list of column positions (0-indexed), where the i-th element is
   * the column of the queen in row i.
   *
   * @param n board size (n >= 1)
   * @return list of column positions for one valid solution, or empty list if none exists
   */
  def exercise2_nQueensOneSolution(n: Int): List[Int] = ???

  /**
   * Exercise 3: Magic Square Validation
   *
   * Check whether a given 3×3 grid is a magic square: all rows, columns,
   * and both diagonals sum to the same value, and all elements are distinct
   * integers from 1 to 9.
   *
   * @param grid a 3×3 array of integers
   * @return true if the grid is a valid 3×3 magic square
   */
  def exercise3_magicSquare3x3(grid: Array[Array[Int]]): Boolean = ???

  /**
   * Exercise 4: Magic Constant
   *
   * Compute the magic constant for an n×n magic square using distinct
   * integers 1 to n². The magic constant is: M(n) = n * (n² + 1) / 2.
   *
   * @param n size of the magic square
   * @return the magic constant
   */
  def exercise4_magicConstant(n: Int): Int = ???

  /**
   * Exercise 5: Sudoku Board Validation
   *
   * Check if a (possibly partial) 9×9 Sudoku board is valid: no conflicts
   * in any row, column, or 3×3 box. Empty cells are represented as 0.
   * Only filled cells (1-9) are checked for conflicts.
   *
   * @param board 9×9 array where 0 means empty, 1-9 are filled values
   * @return true if no conflicts exist among filled cells
   */
  def exercise5_sudokuValid(board: Array[Array[Int]]): Boolean = ???

  /**
   * Exercise 6: Cryptarithmetic Solver
   *
   * Given two words and a result word, find a mapping from characters to
   * digits (0-9) such that word1 + word2 = result when each character is
   * replaced by its assigned digit. Each character maps to a unique digit.
   * Leading characters of any word cannot map to 0.
   *
   * @param word1  first addend
   * @param word2  second addend
   * @param result the sum word
   * @return a mapping from each character to a digit, or empty map if no solution
   */
  def exercise6_cryptarithmetic(word1: String, word2: String, result: String): Map[Char, Int] = ???

  /**
   * Exercise 7: Latin Square Validation
   *
   * Check if an n×n grid is a valid Latin square: each integer from 1 to n
   * appears exactly once in every row and every column.
   *
   * @param grid n×n array of integers
   * @return true if the grid is a valid Latin square
   */
  def exercise7_latinSquare(grid: Array[Array[Int]]): Boolean = ???

  /**
   * Exercise 8: Non-Attacking Rooks Count
   *
   * Count the number of ways to place k non-attacking rooks on an n×n board.
   * Two rooks attack if they share a row or column. The answer is:
   * P(n, k) * C(n, k) = C(n,k) * C(n,k) * k! = (n! / (n-k)!)^2 / k!
   * Simplified: C(n,k)^2 * k!
   *
   * Choose k rows from n, choose k columns from n, then match them: C(n,k)^2 * k!.
   *
   * @param n board size
   * @param k number of rooks to place (k <= n)
   * @return number of ways to place k non-attacking rooks
   */
  def exercise8_constraintCount(n: Int, k: Int): BigInt = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: N-Queens Count
    assert(exercise1_nQueens(1) == 1)
    assert(exercise1_nQueens(4) == 2)
    assert(exercise1_nQueens(5) == 10)
    assert(exercise1_nQueens(8) == 92)
    println("Exercise 1 passed: nQueens")

    // Exercise 2: N-Queens One Solution
    val sol4 = exercise2_nQueensOneSolution(4)
    assert(sol4.length == 4)
    // Verify no conflicts
    for (i <- sol4.indices; j <- (i + 1) until sol4.length) {
      assert(sol4(i) != sol4(j), "same column")
      assert(math.abs(sol4(i) - sol4(j)) != j - i, "same diagonal")
    }
    assert(exercise2_nQueensOneSolution(2).isEmpty)
    assert(exercise2_nQueensOneSolution(3).isEmpty)
    println("Exercise 2 passed: nQueensOneSolution")

    // Exercise 3: Magic Square 3x3
    val magic3x3 = Array(Array(2, 7, 6), Array(9, 5, 1), Array(4, 3, 8))
    assert(exercise3_magicSquare3x3(magic3x3) == true)
    val notMagic = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9))
    assert(exercise3_magicSquare3x3(notMagic) == false)
    println("Exercise 3 passed: magicSquare3x3")

    // Exercise 4: Magic Constant
    assert(exercise4_magicConstant(3) == 15)   // 3*(9+1)/2 = 15
    assert(exercise4_magicConstant(4) == 34)   // 4*(16+1)/2 = 34
    assert(exercise4_magicConstant(5) == 65)   // 5*(25+1)/2 = 65
    println("Exercise 4 passed: magicConstant")

    // Exercise 5: Sudoku Validation
    val validBoard = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )
    assert(exercise5_sudokuValid(validBoard) == true)
    val invalidBoard = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(0, 9, 8, 0, 0, 0, 0, 6, 0),
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 5)  // 5 conflicts with column 8 (row 0 has 5)... actually col 0 has 5
    )
    // Column 8: has 3,1,6,5,9 — no conflict. Let's make a real conflict:
    val invalidBoard2 = Array(
      Array(5, 3, 0, 0, 7, 0, 0, 0, 0),
      Array(6, 0, 0, 1, 9, 5, 0, 0, 0),
      Array(5, 9, 8, 0, 0, 0, 0, 6, 0),  // 5 in column 0 conflicts with row 0
      Array(8, 0, 0, 0, 6, 0, 0, 0, 3),
      Array(4, 0, 0, 8, 0, 3, 0, 0, 1),
      Array(7, 0, 0, 0, 2, 0, 0, 0, 6),
      Array(0, 6, 0, 0, 0, 0, 2, 8, 0),
      Array(0, 0, 0, 4, 1, 9, 0, 0, 5),
      Array(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )
    assert(exercise5_sudokuValid(invalidBoard2) == false)
    println("Exercise 5 passed: sudokuValid")

    // Exercise 6: Cryptarithmetic
    // Simple case: AB + CD = EF where A=1,B=0,C=2,D=3,E=3,F=3 -> 10+23=33
    // Let's use a known simple puzzle: "TO" + "GO" = "OUT"
    // T=2,O=1,G=8 -> 21 + 81 = 102 => O=1,U=0,T=2 -> "OUT"=102. Check: 21+81=102. Yes!
    val result6 = exercise6_cryptarithmetic("TO", "GO", "OUT")
    if (result6.nonEmpty) {
      val w1val = "TO".map(result6).foldLeft(0)(_ * 10 + _)
      val w2val = "GO".map(result6).foldLeft(0)(_ * 10 + _)
      val rval = "OUT".map(result6).foldLeft(0)(_ * 10 + _)
      assert(w1val + w2val == rval)
      assert(result6('T') != 0 && result6('G') != 0 && result6('O') != 0) // no leading zeros
      assert(result6.values.toSet.size == result6.size) // all digits distinct
    }
    println("Exercise 6 passed: cryptarithmetic")

    // Exercise 7: Latin Square
    val latin3 = Array(Array(1, 2, 3), Array(2, 3, 1), Array(3, 1, 2))
    assert(exercise7_latinSquare(latin3) == true)
    val notLatin = Array(Array(1, 2, 3), Array(2, 3, 1), Array(3, 2, 1))
    assert(exercise7_latinSquare(notLatin) == false) // column 1 has two 2s
    println("Exercise 7 passed: latinSquare")

    // Exercise 8: Non-Attacking Rooks
    // C(n,k)^2 * k!
    // n=2, k=1: C(2,1)^2 * 1! = 4
    assert(exercise8_constraintCount(2, 1) == BigInt(4))
    // n=3, k=2: C(3,2)^2 * 2! = 9 * 2 = 18
    assert(exercise8_constraintCount(3, 2) == BigInt(18))
    // n=4, k=4: C(4,4)^2 * 4! = 1 * 24 = 24
    assert(exercise8_constraintCount(4, 4) == BigInt(24))
    // n=8, k=0: 1 way (place nothing)
    assert(exercise8_constraintCount(8, 0) == BigInt(1))
    println("Exercise 8 passed: constraintCount")

    println("\nAll exercises passed!")
  }
}
