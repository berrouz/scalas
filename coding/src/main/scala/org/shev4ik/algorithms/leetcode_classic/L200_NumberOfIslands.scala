package org.shev4ik.algorithms.leetcode_classic

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * Pattern: DFS / BFS on Grid
 * Time: O(m * n)
 * Space: O(m * n) worst case for recursion stack
 */
object L200_NumberOfIslands {

  def numIslands(grid: Array[Array[Char]]): Int = {
    // TODO: Implement using DFS
    // Hint:
    // 1. Iterate through each cell
    // 2. When '1' found, increment count and DFS to mark all connected '1's as visited
    ???
  }

  // DFS helper to mark all connected land
  private def dfs(grid: Array[Array[Char]], i: Int, j: Int): Unit = {
    // TODO: Implement DFS
    // Base case: out of bounds or water
    // Mark current as visited (change to '0')
    // Recursively visit 4 neighbors
    ???
  }

  // BFS solution
  def numIslandsBFS(grid: Array[Array[Char]]): Int = {
    // TODO: Implement using BFS with Queue
    ???
  }

  def main(args: Array[String]): Unit = {
    val grid1 = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )
    println(numIslands(grid1)) // Expected: 1

    val grid2 = Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '1', '0', '0'),
      Array('0', '0', '0', '1', '1')
    )
    println(numIslands(grid2)) // Expected: 3
  }
}
