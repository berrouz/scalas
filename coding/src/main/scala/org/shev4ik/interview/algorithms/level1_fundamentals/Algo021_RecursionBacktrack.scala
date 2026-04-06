package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo021_RecursionBacktrack {

  // TODO: Generate all permutations of a list of distinct integers
  // Example: List(1,2,3) => List(List(1,2,3), List(1,3,2), List(2,1,3), ...)
  def generatePermutations(nums: List[Int]): List[List[Int]] = ???

  // TODO: Generate all subsets (power set) of a list of distinct integers
  // Example: List(1,2,3) => List(List(), List(1), List(2), List(3), List(1,2), ...)
  def generateSubsets(nums: List[Int]): List[List[Int]] = ???

  // TODO: Find all unique combinations that sum to target
  // Each number in candidates may be used unlimited times
  // Example: candidates=List(2,3,6,7), target=7 => List(List(2,2,3), List(7))
  def combinationSum(candidates: List[Int], target: Int): List[List[Int]] = ???

  // TODO: Given digit string, return all possible letter combinations (phone keypad)
  // 2=abc, 3=def, 4=ghi, 5=jkl, 6=mno, 7=pqrs, 8=tuv, 9=wxyz
  // Example: "23" => List("ad","ae","af","bd","be","bf","cd","ce","cf")
  def letterCombinations(digits: String): List[String] = ???

  // TODO: Generate all valid combinations of n pairs of parentheses
  // Example: n=3 => List("((()))","(()())","(())()","()(())","()()()")
  def generateParentheses(n: Int): List[String] = ???

  // TODO: Count the number of solutions to the N-Queens problem
  // Place n queens on an n x n board so no two queens attack each other
  // Example: n=4 => 2, n=8 => 92
  def nQueensCount(n: Int): Int = ???

  // TODO: Search for a word in a 2D grid of characters
  // Word can be constructed from adjacent (horizontal/vertical) cells
  // Each cell may only be used once per word
  // Example: board=[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word="ABCCED" => true
  def wordSearchGrid(board: Array[Array[Char]], word: String): Boolean = ???

  // TODO: Solve a Sudoku puzzle (basic backtracking approach)
  // Fill '.' cells with digits 1-9 following Sudoku rules
  // Modify the board in place
  def sudokuSolverBasic(board: Array[Array[Char]]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: generatePermutations
    val perms = generatePermutations(List(1, 2, 3))
    assert(perms.length == 6)
    assert(perms.toSet == Set(
      List(1,2,3), List(1,3,2), List(2,1,3),
      List(2,3,1), List(3,1,2), List(3,2,1)
    ))
    println("Exercise 1 passed: generatePermutations")

    // Exercise 2: generateSubsets
    val subsets = generateSubsets(List(1, 2, 3))
    assert(subsets.length == 8)
    assert(subsets.toSet.contains(List()))
    assert(subsets.toSet.contains(List(1, 2, 3)))
    println("Exercise 2 passed: generateSubsets")

    // Exercise 3: combinationSum
    val cs = combinationSum(List(2, 3, 6, 7), 7)
    assert(cs.map(_.sorted).toSet == Set(List(2, 2, 3), List(7)))
    println("Exercise 3 passed: combinationSum")

    // Exercise 4: letterCombinations
    val lc = letterCombinations("23")
    assert(lc.toSet == Set("ad","ae","af","bd","be","bf","cd","ce","cf"))
    assert(letterCombinations("") == List())
    println("Exercise 4 passed: letterCombinations")

    // Exercise 5: generateParentheses
    val gp = generateParentheses(3)
    assert(gp.toSet == Set("((()))","(()())","(())()","()(())","()()()"))
    println("Exercise 5 passed: generateParentheses")

    // Exercise 6: nQueensCount
    assert(nQueensCount(4) == 2)
    assert(nQueensCount(1) == 1)
    assert(nQueensCount(8) == 92)
    println("Exercise 6 passed: nQueensCount")

    // Exercise 7: wordSearchGrid
    val board7 = Array(
      Array('A','B','C','E'),
      Array('S','F','C','S'),
      Array('A','D','E','E')
    )
    assert(wordSearchGrid(board7, "ABCCED") == true)
    assert(wordSearchGrid(board7, "SEE") == true)
    assert(wordSearchGrid(board7, "ABCB") == false)
    println("Exercise 7 passed: wordSearchGrid")

    // Exercise 8: sudokuSolverBasic
    val sudoku = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','.'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )
    assert(sudokuSolverBasic(sudoku) == true)
    assert(sudoku(0)(2) == '4') // known solution value
    println("Exercise 8 passed: sudokuSolverBasic")

    println("All Algo021_RecursionBacktrack exercises passed!")
  }
}
