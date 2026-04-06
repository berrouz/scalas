package org.shev4ik.interview.algorithms.level2_intermediate

object Algo059_BacktrackString {

  // Exercise 1: Generate Parentheses — all valid combinations of n pairs
  // TODO: Backtrack with open and close counts. Add '(' if open < n. Add ')' if close < open.
  def generateParenthesis(n: Int): List[String] = ???

  // Exercise 2: Palindrome Partitioning — all ways to partition string into palindromes
  // TODO: At each position, try all substrings from current position. If palindrome, recurse on rest.
  def partition(s: String): List[List[String]] = ???

  // Exercise 3: Restore IP Addresses — all valid IP addresses from digit string
  // TODO: Backtrack placing dots. Each segment 1-3 digits, value 0-255, no leading zeros.
  def restoreIpAddresses(s: String): List[String] = ???

  // Exercise 4: Word Break II — all possible sentences by segmenting string with dictionary words
  // TODO: Backtracking with memoization. At each position, try all dictionary words that match prefix.
  def wordBreak(s: String, wordDict: List[String]): List[String] = ???

  // Exercise 5: Expression Add Operators — insert +, -, * between digits to reach target
  // TODO: Backtrack with current value and last operand (for multiplication precedence).
  def addOperators(num: String, target: Long): List[String] = ???

  // Exercise 6: Letter Combinations of a Phone Number
  // TODO: Map digits to letters. Backtrack choosing one letter per digit.
  def letterCombinations(digits: String): List[String] = ???

  // Exercise 7: Word Search — does word exist in grid by adjacent cells?
  // TODO: DFS from each cell. Mark visited. Check all 4 directions. Backtrack.
  def exist(board: Array[Array[Char]], word: String): Boolean = ???

  // Exercise 8: Matchsticks to Square — can matchsticks form a square?
  // TODO: Total length must be divisible by 4. Backtrack assigning each matchstick to one of 4 sides.
  def makesquare(matchsticks: Array[Int]): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val parens = generateParenthesis(3)
    assert(parens.size == 5, "5 valid combinations for n=3")
    assert(parens.contains("((()))"), "Contains ((()))")

    // Exercise 2
    val parts = partition("aab")
    assert(parts.contains(List("a", "a", "b")), "Partition includes [a,a,b]")
    assert(parts.contains(List("aa", "b")), "Partition includes [aa,b]")

    // Exercise 3
    val ips = restoreIpAddresses("25525511135")
    assert(ips.contains("255.255.11.135"), "Valid IP found")
    assert(ips.contains("255.255.111.35"), "Valid IP found")

    // Exercise 4
    val sentences = wordBreak("catsanddog", List("cat", "cats", "and", "sand", "dog"))
    assert(sentences.toSet == Set("cats and dog", "cat sand dog"), "Word break II")

    // Exercise 5
    val exprs = addOperators("123", 6)
    assert(exprs.contains("1+2+3") || exprs.contains("1*2*3"), "Expression found")

    // Exercise 6
    val letters = letterCombinations("23")
    assert(letters.size == 9, "9 letter combinations for '23'")
    assert(letters.contains("ad"), "Contains 'ad'")

    // Exercise 7
    val board = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    assert(exist(board, "ABCCED"), "Word 'ABCCED' exists")
    assert(!exist(board, "ABCB"), "Word 'ABCB' does not exist")

    // Exercise 8
    assert(makesquare(Array(1, 1, 2, 2, 2)), "Can form square with perimeter 8")
    assert(!makesquare(Array(3, 3, 3, 3, 4)), "Cannot form square")

    println("All Algo059_BacktrackString exercises passed!")
  }
}
