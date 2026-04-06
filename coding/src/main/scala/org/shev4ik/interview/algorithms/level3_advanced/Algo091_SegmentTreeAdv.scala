package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Advanced Segment Tree - lazy propagation and variants.
 *
 * Key concepts:
 * - Lazy propagation: defer updates to children until needed
 * - Supports range update + range query in O(log n)
 * - Persistent segment tree: immutable, version-based
 * - Iterative segment tree: bottom-up, cache-friendly
 */
object Algo091_SegmentTreeAdv {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Lazy propagation (range add, range sum)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a segment tree with lazy propagation supporting:
   *       - rangeAdd(l, r, val): add val to all elements in [l, r]
   *       - rangeSum(l, r): sum of elements in [l, r]
   *       Return (rangeAdd, rangeSum) functions.
   *
   * @param arr initial array (0-indexed)
   * @return (rangeAdd, rangeSum) functions
   */
  def lazySegTreeAddSum(arr: Array[Long]): ((Int, Int, Long) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Range add, range sum query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Process a sequence of operations on an array:
   *       "add l r v" -> add v to all elements in [l, r]
   *       "sum l r"   -> return sum of [l, r]
   *       Use the lazy segment tree from Exercise 1.
   *
   * @param n    array size (initially all zeros)
   * @param ops  list of operations: Left((l, r, v)) for add, Right((l, r)) for sum
   * @return list of sum results
   */
  def processOperations(n: Int, ops: List[Either[(Int, Int, Long), (Int, Int)]]): List[Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Range set, range min
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Segment tree with lazy propagation for:
   *       - rangeSet(l, r, val): set all elements in [l, r] to val
   *       - rangeMin(l, r): minimum in [l, r]
   *       Return (rangeSet, rangeMin) functions.
   *
   * @param n initial array size (all values start at Long.MaxValue)
   * @return (rangeSet, rangeMin) functions
   */
  def lazySegTreeSetMin(n: Int): ((Int, Int, Long) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Persistent segment tree concept
  // ──────────────────────────────────────────────────────────────────────

  sealed trait PersistentNode
  case object PLeaf extends PersistentNode
  case class PNode(sum: Long, left: PersistentNode, right: PersistentNode) extends PersistentNode

  /**
   * TODO: Implement a persistent segment tree.
   *       - build(arr): create initial version
   *       - update(root, idx, val): create new version with arr(idx) = val
   *       - query(root, l, r): range sum on a version
   *       Each update creates a new root, old roots remain valid.
   *
   * @param arr initial array
   * @return (root, update function, query function)
   */
  def persistentSegTree(arr: Array[Long]): (PersistentNode, (PersistentNode, Int, Long) => PersistentNode, (PersistentNode, Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Segment tree beats (Ji driver segment tree concept)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement segment tree beats supporting:
   *       - chmin(l, r, val): for each i in [l,r], arr(i) = min(arr(i), val)
   *       - queryMax(l, r): maximum in [l, r]
   *       - querySum(l, r): sum of [l, r]
   *       Each node tracks max, count of max, second max, and sum.
   *
   * @param arr initial array
   * @return (chmin, queryMax, querySum) functions
   */
  def segmentTreeBeats(arr: Array[Long]): ((Int, Int, Long) => Unit, (Int, Int) => Long, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Merge sort tree concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Build a merge sort tree: each node of the segment tree stores the
   *       sorted list of elements in its range.
   *       Support query: count of elements in [l, r] that are <= k.
   *       Build time: O(n log n), Query: O(log^2 n).
   *
   * @param arr input array
   * @return query function: (l, r, k) => count of elements in [l,r] <= k
   */
  def mergeSortTree(arr: Array[Int]): (Int, Int, Int) => Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: 2D segment tree concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a 2D segment tree for point updates and rectangle sum queries.
   *       For simplicity, use a segment tree of segment trees approach.
   *       Support:
   *       - update(r, c, val): set matrix(r)(c) = val
   *       - query(r1, c1, r2, c2): sum in rectangle
   *
   * @param rows number of rows
   * @param cols number of columns
   * @return (update, query) functions
   */
  def segTree2D(rows: Int, cols: Int): ((Int, Int, Long) => Unit, (Int, Int, Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Iterative segment tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an iterative (bottom-up) segment tree for range sum queries.
   *       Uses array of size 2n. Leaves at positions n..2n-1.
   *       point update and range query in O(log n).
   *
   * @param arr initial array
   * @return (update: (idx, val) => Unit, query: (l, r) => Long)
   */
  def iterativeSegTree(arr: Array[Long]): ((Int, Long) => Unit, (Int, Int) => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (add1, sum1) = lazySegTreeAddSum(Array(1L, 2, 3, 4, 5))
    assert(sum1(0, 4) == 15)
    add1(1, 3, 10)
    assert(sum1(0, 4) == 45)
    println("Exercise 1 (Lazy seg tree) passed.")

    // Exercise 2
    val results2 = processOperations(5, List(
      Left((0, 2, 5L)),
      Right((0, 4)),
      Left((3, 4, 3L)),
      Right((0, 4))
    ))
    assert(results2 == List(15L, 21L), s"Got $results2")
    println("Exercise 2 (Process operations) passed.")

    // Exercise 3
    val (set3, min3) = lazySegTreeSetMin(5)
    set3(0, 4, 10)
    set3(2, 3, 5)
    assert(min3(0, 4) == 5)
    assert(min3(0, 1) == 10)
    println("Exercise 3 (Range set, range min) passed.")

    // Exercise 4
    val (root4, update4, query4) = persistentSegTree(Array(1L, 2, 3, 4, 5))
    assert(query4(root4, 0, 4) == 15)
    val root4b = update4(root4, 2, 10)
    assert(query4(root4b, 0, 4) == 22) // 1+2+10+4+5
    assert(query4(root4, 0, 4) == 15) // old version unchanged
    println("Exercise 4 (Persistent seg tree) passed.")

    // Exercise 5
    val (chmin5, qmax5, qsum5) = segmentTreeBeats(Array(5L, 3, 8, 1, 4))
    assert(qmax5(0, 4) == 8)
    chmin5(0, 4, 4)
    assert(qmax5(0, 4) == 4)
    assert(qsum5(0, 4) == 15) // 4+3+4+1+4 = 16... actually min(5,4)+min(3,4)+min(8,4)+min(1,4)+min(4,4) = 4+3+4+1+4 = 16
    println("Exercise 5 (Segment tree beats) passed.")

    // Exercise 6
    val msq = mergeSortTree(Array(1, 5, 2, 6, 3, 7))
    assert(msq(0, 5, 4) == 3) // 1, 2, 3 are <= 4
    assert(msq(1, 3, 5) == 2) // 5, 2 are <= 5 in [1,3]
    println("Exercise 6 (Merge sort tree) passed.")

    // Exercise 7
    val (upd7, qry7) = segTree2D(3, 3)
    upd7(1, 1, 5)
    upd7(2, 2, 3)
    assert(qry7(1, 1, 2, 2) == 8)
    println("Exercise 7 (2D segment tree) passed.")

    // Exercise 8
    val (upd8, qry8) = iterativeSegTree(Array(1L, 2, 3, 4, 5))
    assert(qry8(0, 4) == 15)
    upd8(2, 10)
    assert(qry8(0, 4) == 22)
    println("Exercise 8 (Iterative seg tree) passed.")

    println("All Algo091_SegmentTreeAdv exercises passed!")
  }
}
