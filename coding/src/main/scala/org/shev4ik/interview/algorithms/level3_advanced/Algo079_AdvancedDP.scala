package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Advanced Dynamic Programming - bitmask DP and combinatorial optimization.
 *
 * Key concepts:
 * - Bitmask DP: state represented as bitmask of visited/selected elements
 * - Typically O(2^n * n) or O(2^n * n^2)
 * - Used for TSP, assignment, set partition problems
 */
object Algo079_AdvancedDP {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Bitmask DP - number of ways to assign
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given n people and n tasks, and a compatibility matrix where
   *       canDo(i)(j) = true means person i can do task j,
   *       count the number of ways to assign all tasks (one task per person).
   *       Use bitmask DP where mask represents the set of assigned tasks.
   *
   * @param canDo compatibility matrix
   * @return number of valid assignments
   */
  def countAssignments(canDo: Array[Array[Boolean]]): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Traveling Salesman Problem
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Solve TSP with bitmask DP.
   *       Find the minimum cost to visit all cities exactly once and return to start.
   *       dp(mask, i) = min cost to visit cities in `mask`, ending at city i.
   *
   * @param dist distance matrix (dist(i)(j) = cost from city i to j)
   * @return minimum tour cost
   */
  def tsp(dist: Array[Array[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Shortest superstring
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an array of strings, find the shortest superstring that contains
   *       each string as a substring. Use bitmask DP on overlaps.
   *       Hint: Precompute overlap(i, j) = max overlap when appending j after i.
   *
   * @param words array of strings (no string is substring of another)
   * @return shortest superstring
   */
  def shortestSuperstring(words: Array[String]): String = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Partition into k equal-sum subsets
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Determine if array can be partitioned into k subsets of equal sum.
   *       Use bitmask DP where mask = set of used elements.
   *
   * @param nums array of positive integers
   * @param k    number of subsets
   * @return true if partition is possible
   */
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Can I Win
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Two players take turns picking numbers from 1..maxChoosable (each used at most once).
   *       The first player to make the running total >= desiredTotal wins.
   *       Return true if the first player can force a win.
   *       Use bitmask DP to memoize game states.
   *
   * @param maxChoosable max number that can be chosen
   * @param desiredTotal target total
   * @return true if first player can win
   */
  def canIWin(maxChoosable: Int, desiredTotal: Int): Boolean = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Stickers to spell word
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given stickers (each a string of lowercase letters), find the minimum
   *       number of stickers to spell `target`. Each sticker can be used multiple times.
   *       Use bitmask DP where mask represents which characters of target are covered.
   *
   * @param stickers array of sticker strings
   * @param target   target string
   * @return minimum number of stickers, or -1 if impossible
   */
  def minStickers(stickers: Array[String], target: String): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Minimum XOR sum of two arrays
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given two integer arrays of the same length, rearrange nums2 to minimize
   *       the XOR sum: sum of nums1(i) XOR nums2(perm(i)).
   *       Use bitmask DP where mask represents which elements of nums2 are used.
   *
   * @param nums1 first array
   * @param nums2 second array
   * @return minimum XOR sum
   */
  def minimumXORSum(nums1: Array[Int], nums2: Array[Int]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Maximize score of assignments
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given n workers and n jobs with a score matrix (score(i)(j) = score
   *       if worker i does job j), find the assignment that maximizes total score.
   *       Use bitmask DP.
   *
   * @param score score matrix
   * @return maximum total score
   */
  def maxScoreAssignment(score: Array[Array[Int]]): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val canDo1 = Array(
      Array(true, true, false),
      Array(false, true, true),
      Array(true, false, true)
    )
    assert(countAssignments(canDo1) == 3, s"Expected 3")
    println("Exercise 1 (Count assignments) passed.")

    // Exercise 2
    val dist2 = Array(
      Array(0, 10, 15, 20),
      Array(10, 0, 35, 25),
      Array(15, 35, 0, 30),
      Array(20, 25, 30, 0)
    )
    assert(tsp(dist2) == 80)
    println("Exercise 2 (TSP) passed.")

    // Exercise 3
    val ss3 = shortestSuperstring(Array("abc", "bcd", "cde"))
    assert(ss3.length == 5, s"Expected length 5, got ${ss3.length}: $ss3")
    assert(ss3.contains("abc") && ss3.contains("bcd") && ss3.contains("cde"))
    println("Exercise 3 (Shortest superstring) passed.")

    // Exercise 4
    assert(canPartitionKSubsets(Array(4, 3, 2, 3, 5, 2, 1), 4))
    assert(!canPartitionKSubsets(Array(1, 2, 3, 4), 3))
    println("Exercise 4 (Partition k subsets) passed.")

    // Exercise 5
    assert(canIWin(10, 11))
    assert(!canIWin(10, 0) == false) // desiredTotal=0 means first player wins immediately
    println("Exercise 5 (Can I Win) passed.")

    // Exercise 6
    val ms6 = minStickers(Array("with", "example", "science"), "thehat")
    assert(ms6 == 3, s"Expected 3, got $ms6")
    println("Exercise 6 (Stickers) passed.")

    // Exercise 7
    val xor7 = minimumXORSum(Array(1, 2), Array(2, 3))
    assert(xor7 == 2, s"Expected 2, got $xor7") // 1^2 + 2^3 = 3+1=4 vs 1^3 + 2^2 = 2+0=2
    println("Exercise 7 (Min XOR sum) passed.")

    // Exercise 8
    val score8 = Array(
      Array(3, 5, 2),
      Array(7, 1, 4),
      Array(2, 8, 6)
    )
    val ms8 = maxScoreAssignment(score8)
    assert(ms8 == 18, s"Expected 18 (5+7+6), got $ms8")
    println("Exercise 8 (Max score assignment) passed.")

    println("All Algo079_AdvancedDP exercises passed!")
  }
}
