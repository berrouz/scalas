package org.shev4ik.interview.algorithms.level2_intermediate

object Algo047_DP2D {

  // Exercise 1: Unique Paths — count paths from top-left to bottom-right (only right/down moves)
  // TODO: dp(i)(j) = dp(i-1)(j) + dp(i)(j-1). First row and column are all 1.
  def uniquePaths(m: Int, n: Int): Int = ???

  // Exercise 2: Unique Paths with Obstacles — same but some cells are blocked (1 = obstacle)
  // TODO: If obstacle, dp = 0. Otherwise same recurrence.
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = ???

  // Exercise 3: Minimum Path Sum — find path from top-left to bottom-right minimizing sum
  // TODO: dp(i)(j) = grid(i)(j) + min(dp(i-1)(j), dp(i)(j-1)).
  def minPathSum(grid: Array[Array[Int]]): Int = ???

  // Exercise 4: Triangle — minimum path sum from top to bottom
  // TODO: Bottom-up: dp(i)(j) = triangle(i)(j) + min(dp(i+1)(j), dp(i+1)(j+1)).
  def minimumTotal(triangle: List[List[Int]]): Int = ???

  // Exercise 5: Maximal Square — largest square of 1's in a binary matrix, return area
  // TODO: dp(i)(j) = min(dp(i-1)(j), dp(i)(j-1), dp(i-1)(j-1)) + 1 if cell is '1'. Track max side.
  def maximalSquare(matrix: Array[Array[Char]]): Int = ???

  // Exercise 6: Dungeon Game — minimum initial health for knight to reach bottom-right
  // TODO: Work backwards. dp(i)(j) = max(1, min(dp(i+1)(j), dp(i)(j+1)) - dungeon(i)(j)).
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = ???

  // Exercise 7: Interleaving String — is s3 formed by interleaving s1 and s2?
  // TODO: dp(i)(j) = true if s3[0..i+j-1] can be formed by s1[0..i-1] and s2[0..j-1].
  def isInterleave(s1: String, s2: String, s3: String): Boolean = ???

  // Exercise 8: Edit Distance — minimum operations (insert, delete, replace) to convert word1 to word2
  // TODO: dp(i)(j) = if chars equal: dp(i-1)(j-1); else 1 + min(dp(i-1)(j), dp(i)(j-1), dp(i-1)(j-1)).
  def minDistance(word1: String, word2: String): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(uniquePaths(3, 7) == 28, "3x7 grid: 28 paths")
    assert(uniquePaths(3, 3) == 6, "3x3 grid: 6 paths")

    // Exercise 2
    val obs = Array(Array(0, 0, 0), Array(0, 1, 0), Array(0, 0, 0))
    assert(uniquePathsWithObstacles(obs) == 2, "2 paths avoiding obstacle")

    // Exercise 3
    val grid = Array(Array(1, 3, 1), Array(1, 5, 1), Array(4, 2, 1))
    assert(minPathSum(grid) == 7, "Min path sum: 1+3+1+1+1=7")

    // Exercise 4
    assert(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))) == 11,
      "Triangle min path: 2+3+5+1=11")

    // Exercise 5
    val matrix = Array(
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0')
    )
    assert(maximalSquare(matrix) == 4, "Maximal square area 4 (2x2)")

    // Exercise 6
    val dungeon = Array(Array(-2, -3, 3), Array(-5, -10, 1), Array(10, 30, -5))
    assert(calculateMinimumHP(dungeon) == 7, "Min HP is 7")

    // Exercise 7
    assert(isInterleave("aabcc", "dbbca", "aadbbcbcac"), "Valid interleaving")
    assert(!isInterleave("aabcc", "dbbca", "aadbbbaccc"), "Invalid interleaving")

    // Exercise 8
    assert(minDistance("horse", "ros") == 3, "Edit distance 3")
    assert(minDistance("intention", "execution") == 5, "Edit distance 5")

    println("All Algo047_DP2D exercises passed!")
  }
}
