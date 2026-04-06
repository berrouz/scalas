package org.shev4ik.algorithms.leetcode_classic

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Find the maximum profit you can achieve from buying on one day
 * and selling on a later day.
 *
 * Pattern: Greedy / One Pass
 * Time: O(n)
 * Space: O(1)
 */
object L121_BestTimeToBuyAndSellStock {

  def maxProfit(prices: Array[Int]): Int = {
    // TODO: Implement
    // Hint: Track minimum price seen so far, calculate profit at each step
    ???
  }

  // Functional solution
  def maxProfitFunctional(prices: Array[Int]): Int = {
    // TODO: Implement using foldLeft
    // State: (minPrice, maxProfit)
    ???
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7, 1, 5, 3, 6, 4))) // Expected: 5 (buy at 1, sell at 6)
    println(maxProfit(Array(7, 6, 4, 3, 1)))    // Expected: 0 (no profit possible)
  }
}
