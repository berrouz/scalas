package org.shev4ik.interview.algorithms.level2_intermediate

object Algo049_DPSubsequence {

  // Exercise 1: LIS in O(n log n) using patience sorting / binary search
  // TODO: Maintain tails array. For each num, binary search for position. If >= all, append; else replace.
  def lisNLogN(nums: Array[Int]): Int = ???

  // Exercise 2: Russian Doll Envelopes — max envelopes you can nest (2D LIS)
  // TODO: Sort by width asc, height desc. LIS on heights gives the answer.
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = ???

  // Exercise 3: Maximum Length of Pair Chain — select max pairs where b_i < a_{i+1}
  // TODO: Sort by second element. Greedy: pick pair if it doesn't overlap previous.
  def findLongestChain(pairs: Array[Array[Int]]): Int = ???

  // Exercise 4: Number of Longest Increasing Subsequences
  // TODO: Track length and count arrays. Update count when equal length found.
  def findNumberOfLIS(nums: Array[Int]): Int = ???

  // Exercise 5: Increasing Triplet Subsequence — does array have i<j<k with nums(i)<nums(j)<nums(k)?
  // TODO: Track first and second smallest. If any element > second, return true.
  def increasingTriplet(nums: Array[Int]): Boolean = ???

  // Exercise 6: Best Team With No Conflicts — max score selecting players where older player has >= score
  // TODO: Sort by age then score. LIS-style DP on scores.
  def bestTeamScore(scores: Array[Int], ages: Array[Int]): Int = ???

  // Exercise 7: Longest String Chain — longest chain where each word adds one letter to previous
  // TODO: Sort by length. For each word, try removing each char and check if predecessor exists.
  def longestStrChain(words: Array[String]): Int = ???

  // Exercise 8: Delete and Earn — earn nums(i) points, but must delete nums(i)-1 and nums(i)+1
  // TODO: Reduce to house robber: count frequency of each value. dp on sorted values.
  def deleteAndEarn(nums: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(lisNLogN(Array(10, 9, 2, 5, 3, 7, 101, 18)) == 4, "LIS O(nlogn) = 4")
    assert(lisNLogN(Array(0, 1, 0, 3, 2, 3)) == 4, "LIS = 4")

    // Exercise 2
    assert(maxEnvelopes(Array(Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3))) == 3,
      "Max envelopes: (2,3)->(5,4)->(6,7)")

    // Exercise 3
    assert(findLongestChain(Array(Array(1, 2), Array(2, 3), Array(3, 4))) == 2, "Longest chain 2")

    // Exercise 4
    assert(findNumberOfLIS(Array(1, 3, 5, 4, 7)) == 2, "2 LIS of length 3")

    // Exercise 5
    assert(increasingTriplet(Array(1, 2, 3, 4, 5)), "Has increasing triplet")
    assert(!increasingTriplet(Array(5, 4, 3, 2, 1)), "No increasing triplet")
    assert(increasingTriplet(Array(2, 1, 5, 0, 4, 6)), "Has increasing triplet")

    // Exercise 6
    assert(bestTeamScore(Array(1, 3, 5, 10, 15), Array(1, 2, 3, 4, 5)) == 34, "Best team score 34")

    // Exercise 7
    assert(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")) == 4, "Longest chain 4")

    // Exercise 8
    assert(deleteAndEarn(Array(3, 4, 2)) == 6, "Delete and earn: 4+2=6")
    assert(deleteAndEarn(Array(2, 2, 3, 3, 3, 4)) == 9, "Delete and earn: 3*3=9")

    println("All Algo049_DPSubsequence exercises passed!")
  }
}
