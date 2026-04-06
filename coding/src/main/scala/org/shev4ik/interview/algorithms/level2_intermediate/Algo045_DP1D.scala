package org.shev4ik.interview.algorithms.level2_intermediate

object Algo045_DP1D {

  // Exercise 1: Climbing Stairs — how many distinct ways to climb n stairs (1 or 2 steps)
  // TODO: dp(i) = dp(i-1) + dp(i-2). Base: dp(0)=1, dp(1)=1.
  def climbStairs(n: Int): Int = ???

  // Exercise 2: House Robber — max money robbing non-adjacent houses
  // TODO: dp(i) = max(dp(i-1), dp(i-2) + nums(i)).
  def rob(nums: Array[Int]): Int = ???

  // Exercise 3: House Robber II — houses in a circle
  // TODO: Rob either houses [0..n-2] or [1..n-1]. Take max. Reuse linear robber.
  def robII(nums: Array[Int]): Int = ???

  // Exercise 4: Decode Ways — count ways to decode digit string to letters (1=A, ..., 26=Z)
  // TODO: dp(i) = (if single digit valid: dp(i-1)) + (if two digits valid: dp(i-2)).
  def numDecodings(s: String): Int = ???

  // Exercise 5: Coin Change — minimum coins to make amount (return -1 if impossible)
  // TODO: dp(i) = min over all coins c of dp(i - c) + 1. Initialize dp(0)=0, rest=infinity.
  def coinChange(coins: Array[Int], amount: Int): Int = ???

  // Exercise 6: Perfect Squares — minimum number of perfect squares summing to n
  // TODO: dp(i) = min over all j where j*j <= i of dp(i - j*j) + 1.
  def numSquares(n: Int): Int = ???

  // Exercise 7: Word Break — can string be segmented into dictionary words?
  // TODO: dp(i) = true if exists j < i such that dp(j) && s[j..i] in dict.
  def wordBreak(s: String, wordDict: List[String]): Boolean = ???

  // Exercise 8: Minimum Cost Climbing Stairs — each step has a cost, pay cost to climb 1 or 2 steps
  // TODO: dp(i) = cost(i) + min(dp(i-1), dp(i-2)). Answer is min(dp(n-1), dp(n-2)).
  def minCostClimbingStairs(cost: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(climbStairs(2) == 2, "2 stairs: 2 ways")
    assert(climbStairs(3) == 3, "3 stairs: 3 ways")
    assert(climbStairs(5) == 8, "5 stairs: 8 ways")

    // Exercise 2
    assert(rob(Array(1, 2, 3, 1)) == 4, "Rob 1+3=4")
    assert(rob(Array(2, 7, 9, 3, 1)) == 12, "Rob 2+9+1=12")

    // Exercise 3
    assert(robII(Array(2, 3, 2)) == 3, "Circle rob: 3")
    assert(robII(Array(1, 2, 3, 1)) == 4, "Circle rob: 4")

    // Exercise 4
    assert(numDecodings("12") == 2, "12 -> AB or L")
    assert(numDecodings("226") == 3, "226 -> 3 ways")
    assert(numDecodings("06") == 0, "06 -> 0 ways")

    // Exercise 5
    assert(coinChange(Array(1, 5, 10, 25), 30) == 2, "30 cents: 25+5")
    assert(coinChange(Array(2), 3) == -1, "Impossible")

    // Exercise 6
    assert(numSquares(12) == 3, "12 = 4+4+4")
    assert(numSquares(13) == 2, "13 = 4+9")

    // Exercise 7
    assert(wordBreak("leetcode", List("leet", "code")), "leetcode = leet + code")
    assert(!wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")), "Cannot segment")

    // Exercise 8
    assert(minCostClimbingStairs(Array(10, 15, 20)) == 15, "Pay 15 from step 1")
    assert(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)) == 6, "Min cost 6")

    println("All Algo045_DP1D exercises passed!")
  }
}
