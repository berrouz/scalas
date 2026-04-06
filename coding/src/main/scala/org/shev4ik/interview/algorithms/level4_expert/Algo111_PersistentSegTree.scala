package org.shev4ik.interview.algorithms.level4_expert

/**
 * Persistent Segment Tree - immutable versioned segment trees.
 *
 * Key concepts:
 * - Path copying: only O(log n) nodes change per update
 * - Each version is a full segment tree accessible by its root
 * - Supports historical queries across versions
 * - Applications: kth smallest in range, offline queries
 */
object Algo111_PersistentSegTree {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Persistent segment tree concept - build from array
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a persistent segment tree (version 0) from an array.
   *       Use an immutable node structure: each node stores a value,
   *       left child, and right child (or is a leaf).
   *       Return the root node representing version 0.
   *       For simplicity, return the sum stored at the root.
   *
   * @param arr input array of integers
   * @return sum stored at the root of the persistent segment tree
   */
  def buildPersistent(arr: Array[Int]): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Create a new version by point update
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an array, build version 0, then create version 1
   *       by updating index `idx` to `newVal`. Only O(log n) nodes
   *       are newly created; the rest are shared with version 0.
   *       Return (rootSumV0, rootSumV1).
   *
   * @param arr    input array
   * @param idx    index to update
   * @param newVal new value at idx
   * @return (sum of version 0, sum of version 1)
   */
  def createVersion(arr: Array[Int], idx: Int, newVal: Int): (Long, Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Query a specific version (range sum)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support range sum queries on any version.
   *       Build version 0 from arr, create version 1 by setting arr(idx)=newVal.
   *       Return the range sum [l, r] on the specified version.
   *
   * @param arr     input array
   * @param idx     index updated in version 1
   * @param newVal  new value for version 1
   * @param version which version to query (0 or 1)
   * @param l       range left (inclusive)
   * @param r       range right (inclusive)
   * @return range sum on the given version
   */
  def queryVersion(arr: Array[Int], idx: Int, newVal: Int, version: Int, l: Int, r: Int): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Multiple updates creating multiple versions
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build version 0, then apply a sequence of updates.
   *       Each update (idx, val) creates a new version from the latest.
   *       Return the root sum for each version (including version 0).
   *
   * @param arr     input array
   * @param updates list of (index, newValue) updates
   * @return list of root sums for versions 0, 1, 2, ...
   */
  def multipleVersions(arr: Array[Int], updates: List[(Int, Int)]): List[Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Kth smallest element in a range
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Use persistent segment tree on sorted values to answer
   *       "kth smallest in arr[l..r]" queries.
   *       Build a persistent segment tree over value-frequency,
   *       inserting elements one by one (version i has elements 0..i-1).
   *       Query = difference between version r+1 and version l.
   *
   * @param arr input array
   * @param l   range left (inclusive, 0-based)
   * @param r   range right (inclusive, 0-based)
   * @param k   1-based rank (1 = smallest)
   * @return kth smallest value in arr[l..r]
   */
  def kthSmallestInRange(arr: Array[Int], l: Int, r: Int, k: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Count elements in range across versions
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a persistent segment tree with multiple versions,
   *       count how many elements in a value range [lo, hi] exist
   *       in a specific version.
   *
   * @param arr     input array
   * @param updates list of (index, newValue) updates creating versions
   * @param version which version to query
   * @param lo      lower bound of value range
   * @param hi      upper bound of value range
   * @return count of elements with value in [lo, hi] in given version
   */
  def countInRange(arr: Array[Int], updates: List[(Int, Int)], version: Int, lo: Int, hi: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Merge sorted lists concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given k sorted lists, use a persistent segment tree approach
   *       to find the kth smallest element across all lists combined.
   *       Build prefix versions by merging lists one by one.
   *       Return the overall kth smallest.
   *
   * @param lists list of sorted arrays
   * @param k     1-based rank
   * @return kth smallest element across all lists
   */
  def kthSmallestMergedLists(lists: List[Array[Int]], k: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Offline queries with persistent segment tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given an array and a list of offline queries (l, r, k) meaning
   *       "find kth smallest in arr[l..r]", answer all queries.
   *       Use persistent segment tree built by inserting elements
   *       in index order.
   *       Return list of answers in query order.
   *
   * @param arr     input array
   * @param queries list of (l, r, k) queries
   * @return list of answers
   */
  def offlineQueries(arr: Array[Int], queries: List[(Int, Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val sum0 = buildPersistent(Array(1, 2, 3, 4, 5))
    assert(sum0 == 15, s"Expected 15, got $sum0")
    println("Exercise 1 (Build persistent) passed.")

    // Exercise 2
    val (s0, s1) = createVersion(Array(1, 2, 3, 4, 5), 2, 10)
    assert(s0 == 15, s"Expected v0 sum 15, got $s0")
    assert(s1 == 22, s"Expected v1 sum 22, got $s1") // 1+2+10+4+5
    println("Exercise 2 (Create version) passed.")

    // Exercise 3
    val qv0 = queryVersion(Array(1, 2, 3, 4, 5), 2, 10, 0, 1, 3)
    assert(qv0 == 9, s"Expected 9 (2+3+4), got $qv0")
    val qv1 = queryVersion(Array(1, 2, 3, 4, 5), 2, 10, 1, 1, 3)
    assert(qv1 == 16, s"Expected 16 (2+10+4), got $qv1")
    println("Exercise 3 (Query version) passed.")

    // Exercise 4
    val versions = multipleVersions(Array(1, 1, 1), List((0, 5), (1, 5), (2, 5)))
    assert(versions == List(3, 7, 11, 15), s"Expected List(3,7,11,15), got $versions")
    println("Exercise 4 (Multiple versions) passed.")

    // Exercise 5
    val kth = kthSmallestInRange(Array(3, 1, 4, 1, 5, 9, 2), 1, 5, 3)
    // arr[1..5] = [1,4,1,5,9], sorted = [1,1,4,5,9], 3rd = 4
    assert(kth == 4, s"Expected 4, got $kth")
    println("Exercise 5 (Kth smallest in range) passed.")

    // Exercise 6
    val cnt = countInRange(Array(1, 2, 3, 4, 5), List((2, 10)), 0, 2, 4)
    assert(cnt == 3, s"Expected 3, got $cnt") // values 2,3,4 in version 0
    println("Exercise 6 (Count in range) passed.")

    // Exercise 7
    val merged = kthSmallestMergedLists(List(Array(1, 5, 9), Array(2, 6), Array(3, 7, 10)), 5)
    // all: 1,2,3,5,6,7,9,10 -> 5th = 6
    assert(merged == 6, s"Expected 6, got $merged")
    println("Exercise 7 (Merge sorted lists) passed.")

    // Exercise 8
    val answers = offlineQueries(
      Array(3, 1, 4, 1, 5),
      List((0, 4, 3), (1, 3, 2))
    )
    // [3,1,4,1,5] sorted = [1,1,3,4,5], 3rd = 3
    // [1,4,1] sorted = [1,1,4], 2nd = 1
    assert(answers == List(3, 1), s"Expected List(3,1), got $answers")
    println("Exercise 8 (Offline queries) passed.")

    println("All Algo111_PersistentSegTree exercises passed!")
  }
}
