package org.shev4ik.interview.algorithms.level2_intermediate

object Algo058_Backtracking {

  // Exercise 1: N-Queens — place N queens on NxN board so no two attack each other. Return all solutions.
  // TODO: Backtrack row by row. Track columns, diagonals, anti-diagonals in use. Return board configurations.
  def solveNQueens(n: Int): List[List[String]] = ???

  // Exercise 2: N-Queens II — count the number of solutions
  // TODO: Same as above but just count. More efficient since no need to build board strings.
  def totalNQueens(n: Int): Int = ???

  // Exercise 3: Sudoku Solver — fill a 9x9 sudoku board
  // TODO: Find empty cell. Try 1-9. Check row, col, 3x3 box. Backtrack on failure.
  def solveSudoku(board: Array[Array[Char]]): Boolean = ???

  // Exercise 4: Combination Sum — find all unique combinations summing to target (can reuse elements)
  // TODO: Sort candidates. For each candidate, include it (allow reuse) or skip. Avoid duplicates.
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = ???

  // Exercise 5: Combination Sum II — each number used at most once, no duplicate combinations
  // TODO: Sort. Skip duplicates at same level. Move to next index after choosing.
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = ???

  // Exercise 6: Permutations — all permutations of distinct integers
  // TODO: For each position, try each unused number. Track used set.
  def permute(nums: Array[Int]): List[List[Int]] = ???

  // Exercise 7: Permutations II — permutations with possible duplicates, no duplicate results
  // TODO: Sort. Use frequency map. At each position, try each distinct unused number.
  def permuteUnique(nums: Array[Int]): List[List[Int]] = ???

  // Exercise 8: Letter Case Permutation — toggle each letter's case, return all combinations
  // TODO: For each character, if letter, branch into upper and lower. If digit, keep as is.
  def letterCasePermutation(s: String): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val queens4 = solveNQueens(4)
    assert(queens4.size == 2, "4-Queens has 2 solutions")

    // Exercise 2
    assert(totalNQueens(4) == 2, "4-Queens count = 2")
    assert(totalNQueens(8) == 92, "8-Queens count = 92")

    // Exercise 3
    val board = Array(
      Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
      Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
      Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
      Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
      Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
      Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
      Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
      Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
      Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    assert(solveSudoku(board), "Sudoku solvable")
    assert(board(0)(2) != '.', "Cell filled")

    // Exercise 4
    val combos = combinationSum(Array(2, 3, 6, 7), 7)
    assert(combos.toSet == Set(List(2, 2, 3), List(7)), "Combination sum")

    // Exercise 5
    val combos2 = combinationSum2(Array(10, 1, 2, 7, 6, 1, 5), 8)
    assert(combos2.contains(List(1, 1, 6)), "Combination sum II includes [1,1,6]")
    assert(combos2.contains(List(1, 2, 5)), "Combination sum II includes [1,2,5]")

    // Exercise 6
    val perms = permute(Array(1, 2, 3))
    assert(perms.size == 6, "3! = 6 permutations")

    // Exercise 7
    val permsU = permuteUnique(Array(1, 1, 2))
    assert(permsU.size == 3, "3 unique permutations of [1,1,2]")

    // Exercise 8
    val cases = letterCasePermutation("a1b2")
    assert(cases.size == 4, "4 letter case permutations of 'a1b2'")
    assert(cases.toSet.contains("A1B2"), "Includes 'A1B2'")

    println("All Algo058_Backtracking exercises passed!")
  }
}
