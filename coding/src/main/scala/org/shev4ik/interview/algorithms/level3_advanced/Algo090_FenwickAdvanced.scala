package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Advanced Fenwick Tree (Binary Indexed Tree) - extensions of the basic BIT.
 *
 * Key concepts:
 * - 2D BIT for rectangle queries
 * - Range update + point query using difference BIT
 * - Range update + range query using two BITs
 * - Coordinate compression for large value ranges
 */
object Algo090_FenwickAdvanced {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: 2D BIT
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a 2D Binary Indexed Tree supporting:
   *       - update(r, c, delta): add delta to position (r, c)
   *       - query(r, c): sum of rectangle (1,1) to (r,c)
   *       Return (update function, query function).
   *
   * @param rows number of rows
   * @param cols number of columns
   * @return (update, query) functions
   */
  def create2DBIT(rows: Int, cols: Int): ((Int, Int, Int) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Range update, point query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Using a BIT on a difference array, support:
   *       - rangeUpdate(l, r, delta): add delta to all elements in [l, r]
   *       - pointQuery(i): get the current value at position i
   *       Return (rangeUpdate, pointQuery) functions.
   *
   * @param n size of array (1-indexed)
   * @return (rangeUpdate, pointQuery) functions
   */
  def rangeUpdatePointQuery(n: Int): ((Int, Int, Int) => Unit, Int => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Range update, range query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support range updates and range queries using two BITs.
   *       - rangeUpdate(l, r, delta): add delta to all in [l, r]
   *       - rangeQuery(l, r): sum of elements in [l, r]
   *       Uses the identity: prefix(i) = B1(i)*i - B2(i) + original prefix.
   *
   * @param n size of array (1-indexed)
   * @return (rangeUpdate, rangeQuery) functions
   */
  def rangeUpdateRangeQuery(n: Int): ((Int, Int, Long) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: BIT with coordinate compression
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given values that can be very large, compress coordinates first
   *       then use a BIT. Implement:
   *       - add(value): add value to the BIT
   *       - countLessOrEqual(value): count of added values <= value
   *       Values are known in advance for compression.
   *
   * @param allValues all values that will ever be queried/added (for compression)
   * @return (add, countLessOrEqual) functions
   */
  def compressedBIT(allValues: Array[Int]): (Int => Unit, Int => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Order statistics with BIT
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Support order-statistics operations using a BIT:
   *       - insert(x): add element x
   *       - kthSmallest(k): find the k-th smallest element (1-indexed)
   *       - rank(x): how many elements are < x
   *       Use BIT over value domain (with coordinate compression).
   *
   * @param maxVal maximum value (or use coordinate compression)
   * @return (insert, kthSmallest, rank) functions
   */
  def orderStatisticsBIT(maxVal: Int): (Int => Unit, Int => Int, Int => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: 2D inversion count
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Count inversions in an array using a BIT.
   *       Inversion: pair (i, j) where i < j but arr(i) > arr(j).
   *       Process from right to left, query BIT for count of smaller elements seen.
   *
   * @param arr input array
   * @return number of inversions
   */
  def inversionCount(arr: Array[Int]): Long = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Rectangle sum query with 2D BIT
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Using a 2D BIT, answer rectangle sum queries.
   *       Given a matrix, support:
   *       - update(r, c, val): set value at (r,c)
   *       - query(r1, c1, r2, c2): sum in rectangle from (r1,c1) to (r2,c2)
   *       Use inclusion-exclusion.
   *
   * @param matrix initial matrix values
   * @return (update, rectangleQuery) functions
   */
  def rectangleSumQuery(matrix: Array[Array[Int]]): ((Int, Int, Int) => Unit, (Int, Int, Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Dynamic rank queries
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Maintain a dynamic multiset supporting:
   *       - insert(x): add x
   *       - delete(x): remove one occurrence of x
   *       - rank(x): number of elements strictly less than x
   *       - kthSmallest(k): k-th smallest element (1-indexed)
   *       Use BIT over compressed coordinates.
   *
   * @param allValues all values that will be used (for compression)
   * @return (insert, delete, rank, kthSmallest) functions
   */
  def dynamicRank(allValues: Array[Int]): (Int => Unit, Int => Unit, Int => Int, Int => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (update2d, query2d) = create2DBIT(3, 3)
    update2d(1, 1, 1)
    update2d(2, 2, 2)
    update2d(3, 3, 3)
    assert(query2d(3, 3) == 6)
    assert(query2d(2, 2) == 3)
    println("Exercise 1 (2D BIT) passed.")

    // Exercise 2
    val (rangeUpd, pointQ) = rangeUpdatePointQuery(5)
    rangeUpd(2, 4, 3)
    assert(pointQ(1) == 0)
    assert(pointQ(2) == 3)
    assert(pointQ(4) == 3)
    assert(pointQ(5) == 0)
    println("Exercise 2 (Range update point query) passed.")

    // Exercise 3
    val (rUpd, rQry) = rangeUpdateRangeQuery(5)
    rUpd(1, 3, 2)
    rUpd(2, 5, 3)
    assert(rQry(1, 1) == 2)
    assert(rQry(2, 3) == 10) // [5, 5]
    println("Exercise 3 (Range update range query) passed.")

    // Exercise 4
    val (addC, countLE) = compressedBIT(Array(100, 200, 300, 150))
    addC(100)
    addC(300)
    addC(150)
    assert(countLE(200) == 2) // 100, 150
    println("Exercise 4 (Compressed BIT) passed.")

    // Exercise 5
    val (ins5, kth5, rank5) = orderStatisticsBIT(100)
    ins5(10); ins5(20); ins5(30); ins5(15)
    assert(kth5(2) == 15)
    assert(rank5(20) == 2) // 10, 15 are < 20
    println("Exercise 5 (Order statistics) passed.")

    // Exercise 6
    assert(inversionCount(Array(2, 4, 1, 3, 5)) == 3) // (2,1), (4,1), (4,3)
    println("Exercise 6 (Inversion count) passed.")

    // Exercise 7
    val mat = Array(Array(1, 2), Array(3, 4))
    val (upd7, rq7) = rectangleSumQuery(mat)
    assert(rq7(1, 1, 2, 2) == 10)
    println("Exercise 7 (Rectangle sum) passed.")

    // Exercise 8
    val (ins8, del8, rank8, kth8) = dynamicRank(Array(1, 2, 3, 4, 5))
    ins8(1); ins8(3); ins8(5); ins8(2)
    assert(rank8(3) == 2) // 1, 2 are < 3
    assert(kth8(3) == 3) // 1, 2, 3
    del8(2)
    assert(rank8(3) == 1) // only 1 is < 3
    println("Exercise 8 (Dynamic rank) passed.")

    println("All Algo090_FenwickAdvanced exercises passed!")
  }
}
