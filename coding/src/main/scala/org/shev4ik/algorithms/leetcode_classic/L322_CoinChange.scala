package org.shev4ik.algorithms.leetcode_classic

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 *
 * Given coins of different denominations and a total amount,
 * return the fewest number of coins needed to make up that amount.
 *
 * Pattern: Dynamic Programming (Unbounded Knapsack)
 * Time: O(amount * coins.length)
 * Space: O(amount)
 */
object L322_CoinChange {

  // Bottom-up DP
  def coinChange(coins: Array[Int], amount: Int): Int = {
    // TODO: Implement bottom-up DP
    // dp[i] = minimum coins needed to make amount i
    // dp[i] = min(dp[i], dp[i - coin] + 1) for each coin
    ???
  }

  // Top-down DP with memoization
  def coinChangeMemo(coins: Array[Int], amount: Int): Int = {
    // TODO: Implement with memoization
    ???
  }

  def main(args: Array[String]): Unit = {
    println(coinChange(Array(1, 2, 5), 11))  // Expected: 3 (5+5+1)
    println(coinChange(Array(2), 3))          // Expected: -1
    println(coinChange(Array(1), 0))          // Expected: 0
    println(coinChange(Array(1, 2, 5), 100)) // Expected: 20
  }
}
