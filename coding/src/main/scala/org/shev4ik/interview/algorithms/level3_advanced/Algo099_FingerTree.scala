package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Finger Tree - a versatile functional data structure.
 *
 * Key concepts:
 * - 2-3 finger tree: amortized O(1) access to both ends
 * - O(log n) split and concatenation
 * - Measured: annotate with monoidal measures for search
 * - Can implement deque, priority queue, sequence, interval tree
 */
object Algo099_FingerTree {

  /** Simplified Digit: 1-4 elements at each end */
  sealed trait Digit[+A]
  case class One[A](a: A) extends Digit[A]
  case class Two[A](a: A, b: A) extends Digit[A]
  case class Three[A](a: A, b: A, c: A) extends Digit[A]

  /** Node in internal representation (2-3 node) */
  sealed trait FTNode[+A]
  case class Node2[A](a: A, b: A) extends FTNode[A]
  case class Node3[A](a: A, b: A, c: A) extends FTNode[A]

  /** Simplified Finger Tree */
  sealed trait FingerTree[+A]
  case object FTEmpty extends FingerTree[Nothing]
  case class FTSingle[A](a: A) extends FingerTree[A]
  case class FTDeep[A](prefix: Digit[A], middle: FingerTree[FTNode[A]], suffix: Digit[A]) extends FingerTree[A]

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: 2-3 finger tree concept - pushLeft (cons)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Push an element to the left (front) of a finger tree.
   *       Handle cases: Empty -> Single, Single -> Deep(One, Empty, One),
   *       Deep with prefix not full -> extend prefix,
   *       Deep with full prefix -> push node into middle.
   *
   * @param tree finger tree
   * @param elem element to push
   * @return new finger tree with elem at front
   */
  def pushLeft[A](tree: FingerTree[A], elem: A): FingerTree[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Deque operations (pushRight, popLeft, popRight)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement pushRight (snoc) to add an element at the back.
   *       Similar logic to pushLeft but on the suffix side.
   *
   * @param tree finger tree
   * @param elem element to push
   * @return new finger tree with elem at back
   */
  def pushRight[A](tree: FingerTree[A], elem: A): FingerTree[A] = {
    ???
  }

  /**
   * TODO: Implement popLeft - remove and return the leftmost element.
   *       Return None if empty.
   */
  def popLeft[A](tree: FingerTree[A]): Option[(A, FingerTree[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Split operation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Split a finger tree into (left, element, right) at a given position.
   *       For simplicity, implement split on a list-backed finger tree.
   *       splitAt(n) returns (first n elements as FT, n-th element, rest as FT).
   *
   * @param tree finger tree
   * @param n    split position
   * @return (left tree, element at n, right tree)
   */
  def splitAt[A](tree: FingerTree[A], n: Int): Option[(FingerTree[A], A, FingerTree[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Concatenation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Concatenate two finger trees.
   *       This is the key operation that makes finger trees powerful.
   *       O(log(min(n, m))) amortized time.
   *       For simplicity, implement using toList + fromList approach.
   *
   * @param t1 first tree
   * @param t2 second tree
   * @return concatenated tree
   */
  def concat[A](t1: FingerTree[A], t2: FingerTree[A]): FingerTree[A] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Measured finger tree (size-measured)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a finger tree with size measure.
   *       Each node carries the total size of its subtree.
   *       Support O(log n) indexed access using the measure to guide navigation.
   *       Return (fromList, get, size) functions.
   *
   * @return (fromList: List[A] => MeasuredFT, get: (MeasuredFT, Int) => A, size: MeasuredFT => Int)
   */
  def measuredFingerTree[A](): (
    List[A] => FingerTree[A],  // fromList
    (FingerTree[A], Int) => Option[A], // get by index
    FingerTree[A] => Int       // size
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Priority queue via finger tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a priority queue using a finger tree measured by priority.
   *       Measure = minimum priority in subtree.
   *       extractMin: split at the minimum, return it, concatenate the rest.
   *       For simplicity, use a sorted approach.
   *       Return (insert, extractMin, isEmpty).
   *
   * @return (insert: (PQ, Int) => PQ, extractMin: PQ => Option[(Int, PQ)], isEmpty: PQ => Boolean)
   */
  type PQ = List[Int] // simplified representation

  def fingerTreePQ(): (
    (PQ, Int) => PQ,           // insert
    PQ => Option[(Int, PQ)],   // extractMin
    PQ => Boolean              // isEmpty
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Sequence via finger tree
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an indexed sequence using finger tree.
   *       Support: append, prepend, get(i), set(i, v), size.
   *       Use the finger tree with size measure.
   *       For simplicity, back with a Vector and provide the interface.
   *
   * @return sequence operations
   */
  def fingerTreeSequence[A](): (
    (Vector[A], A) => Vector[A],        // append
    (A, Vector[A]) => Vector[A],        // prepend
    (Vector[A], Int) => Option[A],      // get
    (Vector[A], Int, A) => Vector[A],   // set
    Vector[A] => Int                    // size
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Interval tree via finger tree concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement an interval tree concept using a measured structure.
   *       Store intervals (lo, hi). Measure = max hi in subtree.
   *       Query: find all intervals overlapping with a given interval.
   *       For simplicity, use a sorted list of intervals.
   *
   * @param intervals list of (lo, hi) intervals
   * @param queryLo   query interval lo
   * @param queryHi   query interval hi
   * @return list of overlapping intervals
   */
  def intervalQuery(intervals: List[(Int, Int)], queryLo: Int, queryHi: Int): List[(Int, Int)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Helper: convert finger tree to list
  def ftToList[A](tree: FingerTree[A]): List[A] = {
    popLeft(tree) match {
      case None => Nil
      case Some((a, rest)) => a :: ftToList(rest)
    }
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    var ft: FingerTree[Int] = FTEmpty
    ft = pushLeft(ft, 3)
    ft = pushLeft(ft, 2)
    ft = pushLeft(ft, 1)
    assert(ftToList(ft) == List(1, 2, 3))
    println("Exercise 1 (pushLeft) passed.")

    // Exercise 2
    ft = pushRight(ft, 4)
    ft = pushRight(ft, 5)
    assert(ftToList(ft) == List(1, 2, 3, 4, 5))
    val Some((h, rest)) = popLeft(ft): @unchecked
    assert(h == 1)
    assert(ftToList(rest) == List(2, 3, 4, 5))
    println("Exercise 2 (Deque ops) passed.")

    // Exercise 3
    val sp = splitAt(ft, 2)
    assert(sp.isDefined)
    val (left, mid, right) = sp.get
    assert(mid == 3)
    println("Exercise 3 (Split) passed.")

    // Exercise 4
    val cat = concat(left, pushLeft(right, mid))
    assert(ftToList(cat) == List(1, 2, 3, 4, 5))
    println("Exercise 4 (Concat) passed.")

    // Exercise 5
    val (fromList, getIdx, ftSize) = measuredFingerTree[Int]()
    val mft = fromList(List(10, 20, 30, 40, 50))
    assert(ftSize(mft) == 5)
    assert(getIdx(mft, 2).contains(30))
    println("Exercise 5 (Measured FT) passed.")

    // Exercise 6
    val (pqInsert, pqExtract, pqEmpty) = fingerTreePQ()
    var pq: PQ = Nil
    pq = pqInsert(pq, 3)
    pq = pqInsert(pq, 1)
    pq = pqInsert(pq, 2)
    val Some((min1, pq2)) = pqExtract(pq): @unchecked
    assert(min1 == 1)
    println("Exercise 6 (PQ via FT) passed.")

    // Exercise 7
    val (seqAppend, seqPrepend, seqGet, seqSet, seqSize) = fingerTreeSequence[Int]()
    var seq = Vector.empty[Int]
    seq = seqAppend(seq, 1)
    seq = seqAppend(seq, 2)
    seq = seqPrepend(0, seq)
    assert(seqGet(seq, 1).contains(1))
    seq = seqSet(seq, 1, 99)
    assert(seqGet(seq, 1).contains(99))
    assert(seqSize(seq) == 3)
    println("Exercise 7 (Sequence via FT) passed.")

    // Exercise 8
    val intervals = List((1, 5), (3, 8), (10, 15), (12, 20))
    val overlapping = intervalQuery(intervals, 4, 11)
    assert(overlapping.contains((1, 5)))
    assert(overlapping.contains((3, 8)))
    assert(overlapping.contains((10, 15)))
    println("Exercise 8 (Interval tree) passed.")

    println("All Algo099_FingerTree exercises passed!")
  }
}
