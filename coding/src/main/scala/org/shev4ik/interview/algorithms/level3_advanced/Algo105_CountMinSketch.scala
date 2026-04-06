package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Count-Min Sketch - probabilistic frequency estimation.
 *
 * Key concepts:
 * - Sublinear space frequency estimation
 * - Uses d hash functions mapping to w counters each
 * - Estimate = minimum across all d counters for an item
 * - Always overestimates (never underestimates true frequency)
 */
object Algo105_CountMinSketch {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: CMS insert (add)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Count-Min Sketch insertion.
   *       For each of d hash functions, increment the counter at hash position.
   *       Return (add, the internal table).
   *
   * @param w width (number of counters per row)
   * @param d depth (number of hash functions)
   * @return (add: String => Unit, table: Array[Array[Long]])
   */
  def createCMS(w: Int, d: Int): (String => Unit, Array[Array[Long]]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: CMS query (estimate)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement Count-Min Sketch query.
   *       Return the minimum counter value across all d hash functions.
   *       This is the estimated frequency (always >= true frequency).
   *
   * @param w width
   * @param d depth
   * @return (add, query) functions
   */
  def cmsWithQuery(w: Int, d: Int): (String => Unit, String => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Optimal dimensions
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute optimal CMS dimensions given error bounds.
   *       w = ceil(e / epsilon)  (where e = Euler's number ~2.718)
   *       d = ceil(ln(1 / delta))
   *       epsilon = error factor, delta = failure probability
   *
   * @param epsilon additive error factor (e.g., 0.01)
   * @param delta   probability of exceeding error (e.g., 0.01)
   * @return (w, d)
   */
  def optimalDimensions(epsilon: Double, delta: Double): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Heavy hitters
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Use CMS to find heavy hitters in a stream.
   *       A heavy hitter is an element with frequency >= threshold.
   *       Process stream, track candidates, verify with CMS.
   *       Return list of elements estimated to be heavy hitters.
   *
   * @param stream    list of elements
   * @param threshold minimum frequency to be a heavy hitter
   * @param w         CMS width
   * @param d         CMS depth
   * @return list of heavy hitter elements
   */
  def heavyHitters(stream: List[String], threshold: Int, w: Int, d: Int): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Frequency estimation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Process a stream and estimate frequencies of all distinct elements.
   *       Return a map of element -> estimated frequency.
   *       Use CMS for estimation and a set to track distinct elements.
   *
   * @param stream list of elements
   * @param w      CMS width
   * @param d      CMS depth
   * @return map of estimated frequencies
   */
  def estimateFrequencies(stream: List[String], w: Int, d: Int): Map[String, Long] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: CMS merge
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Merge two Count-Min Sketches with the same dimensions.
   *       Merge = element-wise addition of counter arrays.
   *       This is useful for distributed counting.
   *
   * @param table1 first CMS table
   * @param table2 second CMS table
   * @return merged table
   */
  def mergeCMS(table1: Array[Array[Long]], table2: Array[Array[Long]]): Array[Array[Long]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: CMS with conservative update
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement CMS with conservative update optimization.
   *       Instead of incrementing all d counters, only increment the minimum ones.
   *       This reduces overestimation.
   *       Return (add, query) functions.
   *
   * @param w width
   * @param d depth
   * @return (conservativeAdd, query) functions
   */
  def cmsConservativeUpdate(w: Int, d: Int): (String => Unit, String => Long) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Streaming top-k
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Find the approximate top-k most frequent elements in a stream.
   *       Use CMS for frequency estimation and a min-heap of size k.
   *       Return the top-k elements with their estimated frequencies.
   *
   * @param stream list of elements
   * @param k      number of top elements
   * @param w      CMS width
   * @param d      CMS depth
   * @return list of (element, estimated frequency) sorted by frequency desc
   */
  def streamingTopK(stream: List[String], k: Int, w: Int, d: Int): List[(String, Long)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (add1, table1) = createCMS(100, 3)
    add1("hello")
    add1("hello")
    add1("world")
    assert(table1.exists(_.exists(_ > 0)))
    println("Exercise 1 (CMS insert) passed.")

    // Exercise 2
    val (add2, query2) = cmsWithQuery(100, 5)
    for (_ <- 1 to 10) add2("apple")
    for (_ <- 1 to 5) add2("banana")
    assert(query2("apple") >= 10)
    assert(query2("banana") >= 5)
    assert(query2("cherry") >= 0) // might be 0 or small false positive
    println("Exercise 2 (CMS query) passed.")

    // Exercise 3
    val (w3, d3) = optimalDimensions(0.01, 0.01)
    assert(w3 > 0 && d3 > 0)
    assert(w3 > 200) // roughly e/0.01 = 272
    assert(d3 >= 4) // ln(100) ~= 4.6
    println("Exercise 3 (Optimal dimensions) passed.")

    // Exercise 4
    val stream4 = List.fill(100)("frequent") ++ List.fill(5)("rare") ++ List.fill(50)("medium")
    val hh = heavyHitters(stream4, 10, 200, 5)
    assert(hh.contains("frequent"))
    assert(hh.contains("medium"))
    println("Exercise 4 (Heavy hitters) passed.")

    // Exercise 5
    val stream5 = List("a", "a", "a", "b", "b", "c")
    val freqs = estimateFrequencies(stream5, 100, 3)
    assert(freqs("a") >= 3)
    assert(freqs("b") >= 2)
    assert(freqs("c") >= 1)
    println("Exercise 5 (Frequency estimation) passed.")

    // Exercise 6
    val (add6a, t6a) = createCMS(50, 3)
    val (add6b, t6b) = createCMS(50, 3)
    add6a("x"); add6a("x")
    add6b("x"); add6b("x"); add6b("x")
    val merged = mergeCMS(t6a, t6b)
    // merged should have counts >= 5 for "x" positions
    println("Exercise 6 (CMS merge) passed.")

    // Exercise 7
    val (cAdd, cQuery) = cmsConservativeUpdate(100, 5)
    for (_ <- 1 to 10) cAdd("test")
    assert(cQuery("test") >= 10)
    println("Exercise 7 (Conservative update) passed.")

    // Exercise 8
    val stream8 = List.fill(100)("top1") ++ List.fill(50)("top2") ++ List.fill(10)("top3") ++ List.fill(5)("rare")
    val topK = streamingTopK(stream8, 2, 200, 5)
    assert(topK.length == 2)
    assert(topK.head._1 == "top1")
    println("Exercise 8 (Streaming top-k) passed.")

    println("All Algo105_CountMinSketch exercises passed!")
  }
}
