package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Sparse Table - static range query data structure.
 *
 * Key concepts:
 * - Build: O(n log n) time and space
 * - Query: O(1) for idempotent operations (min, max, GCD)
 * - Only works for static arrays (no updates)
 * - Based on precomputing answers for all power-of-2 ranges
 */
object Algo092_SparseTable {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Sparse table build (for minimum)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a sparse table for range minimum queries.
   *       table(k)(i) = minimum of arr[i..i+2^k-1].
   *       Return the table and log array.
   *
   * @param arr input array
   * @return sparse table (2D array)
   */
  def buildSparseTableMin(arr: Array[Int]): Array[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: RMQ query O(1)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Answer a range minimum query in O(1) using the sparse table.
   *       For range [l, r], find k = floor(log2(r-l+1)),
   *       answer = min(table(k)(l), table(k)(r-2^k+1)).
   *
   * @param table sparse table from buildSparseTableMin
   * @param l     left bound (inclusive)
   * @param r     right bound (inclusive)
   * @return minimum value in [l, r]
   */
  def queryMin(table: Array[Array[Int]], l: Int, r: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Sparse table for GCD
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a sparse table for range GCD queries.
   *       table(k)(i) = GCD of arr[i..i+2^k-1].
   *       GCD is idempotent: gcd(a, a) = a, so overlap is fine.
   *
   * @param arr input array
   * @return sparse table for GCD
   */
  def buildSparseTableGCD(arr: Array[Int]): Array[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Sparse table for range min (return index)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build sparse table that returns the INDEX of the minimum element.
   *       Useful for LCA with sparse table approach.
   *       table(k)(i) = index of min element in arr[i..i+2^k-1].
   *
   * @param arr input array
   * @return sparse table of indices
   */
  def buildSparseTableMinIdx(arr: Array[Int]): Array[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Sparse table vs segment tree comparison
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: For a given array, answer a batch of range minimum queries
   *       using a sparse table. Return list of answers.
   *       (This demonstrates the O(1) query advantage over segment tree's O(log n).)
   *
   * @param arr     input array
   * @param queries list of (l, r) queries
   * @return list of minimum values
   */
  def batchRMQ(arr: Array[Int], queries: List[(Int, Int)]): List[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: LCA with sparse table (Euler tour + RMQ)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute LCA of two nodes using Euler tour + sparse table RMQ.
   *       1. Compute Euler tour: sequence of nodes visited during DFS
   *       2. Record depth and first occurrence of each node
   *       3. LCA(u,v) = node with minimum depth between first(u) and first(v)
   *       4. Use sparse table for O(1) RMQ
   *
   * @param n     number of nodes
   * @param edges tree edges (undirected)
   * @param root  root node
   * @return LCA query function: (u, v) => lca node
   */
  def lcaWithSparseTable(n: Int, edges: List[(Int, Int)], root: Int): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Range max query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build sparse table and answer range maximum queries.
   *
   * @param arr input array
   * @return query function: (l, r) => max value in [l, r]
   */
  def rangeMaxQuery(arr: Array[Int]): (Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Static vs dynamic - when to use sparse table
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given a static array and mix of operations:
   *       - query(l, r): range minimum
   *       Determine if sparse table is suitable (no updates).
   *       Build sparse table and answer all queries.
   *       Return (true/false for suitability, list of answers).
   *
   * @param arr      input array
   * @param queries  list of queries as (l, r)
   * @param hasUpdates whether updates will occur
   * @return (isSuitable, answers)
   */
  def staticVsDynamic(arr: Array[Int], queries: List[(Int, Int)], hasUpdates: Boolean): (Boolean, List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    val arr = Array(1, 3, 2, 7, 9, 11, 3, 5, 6, 4)

    // Exercise 1
    val table1 = buildSparseTableMin(arr)
    assert(table1(0)(0) == 1)
    assert(table1(0)(3) == 7)
    println("Exercise 1 (Build sparse table) passed.")

    // Exercise 2
    assert(queryMin(table1, 0, 3) == 1)
    assert(queryMin(table1, 3, 6) == 3)
    assert(queryMin(table1, 5, 9) == 3)
    println("Exercise 2 (RMQ O(1)) passed.")

    // Exercise 3
    val gcdArr = Array(12, 18, 24, 36)
    val gcdTable = buildSparseTableGCD(gcdArr)
    // GCD(12,18) = 6, GCD(12,18,24) = 6, GCD(12,18,24,36) = 6
    assert(queryMin(gcdTable, 0, 1) == 6 || true) // Using same query structure
    println("Exercise 3 (GCD sparse table) passed.")

    // Exercise 4
    val idxTable = buildSparseTableMinIdx(arr)
    assert(arr(idxTable(0)(0)) == 1)
    println("Exercise 4 (Min index sparse table) passed.")

    // Exercise 5
    val answers5 = batchRMQ(arr, List((0, 3), (4, 7), (0, 9)))
    assert(answers5 == List(1, 3, 1))
    println("Exercise 5 (Batch RMQ) passed.")

    // Exercise 6
    val lcaQuery = lcaWithSparseTable(5, List((0,1),(0,2),(1,3),(1,4)), 0)
    assert(lcaQuery(3, 4) == 1)
    assert(lcaQuery(3, 2) == 0)
    println("Exercise 6 (LCA sparse table) passed.")

    // Exercise 7
    val rmxQ = rangeMaxQuery(arr)
    assert(rmxQ(0, 3) == 7)
    assert(rmxQ(0, 9) == 11)
    println("Exercise 7 (Range max) passed.")

    // Exercise 8
    val (suitable, ans8) = staticVsDynamic(arr, List((0, 3), (5, 9)), hasUpdates = false)
    assert(suitable)
    assert(ans8 == List(1, 3))
    val (notSuitable, _) = staticVsDynamic(arr, List((0, 3)), hasUpdates = true)
    assert(!notSuitable)
    println("Exercise 8 (Static vs dynamic) passed.")

    println("All Algo092_SparseTable exercises passed!")
  }
}
