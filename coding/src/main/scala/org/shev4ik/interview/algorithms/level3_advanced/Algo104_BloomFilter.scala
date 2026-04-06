package org.shev4ik.interview.algorithms.level3_advanced

import scala.collection.mutable

/**
 * Bloom Filter - probabilistic set membership testing.
 *
 * Key concepts:
 * - Space-efficient probabilistic data structure
 * - No false negatives: if "not present", definitely not present
 * - Possible false positives: if "present", might not actually be
 * - Uses k hash functions mapping to m-bit array
 */
object Algo104_BloomFilter {

  /** Simple Bloom Filter */
  class BloomFilter(val size: Int, val numHashes: Int) {
    val bits: mutable.BitSet = mutable.BitSet.empty

    private def hashes(item: String): Seq[Int] = {
      (0 until numHashes).map { i =>
        math.abs((item.hashCode * (i + 1) + i * 31) % size)
      }
    }

    def add(item: String): Unit = hashes(item).foreach(bits.add)
    def mightContain(item: String): Boolean = hashes(item).forall(bits.contains)
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Bloom filter insert
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a Bloom filter that supports insertion of string elements.
   *       Use k independent hash functions, each mapping to a position in an m-bit array.
   *       Set all k bit positions for each inserted element.
   *
   * @param m number of bits
   * @param k number of hash functions
   * @return (insert: String => Unit, the internal bit array)
   */
  def createBloomFilter(m: Int, k: Int): (String => Unit, () => mutable.BitSet) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Bloom filter query
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Query a Bloom filter for possible membership.
   *       Return true if all k hash positions are set (might be present).
   *       Return false if any position is not set (definitely not present).
   *
   * @param m    number of bits
   * @param k    number of hash functions
   * @return (insert, query) functions
   */
  def bloomFilterWithQuery(m: Int, k: Int): (String => Unit, String => Boolean) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Optimal parameters
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Given expected number of elements n and desired false positive rate p,
   *       compute optimal Bloom filter parameters.
   *       m = -(n * ln(p)) / (ln(2))^2
   *       k = (m / n) * ln(2)
   *
   * @param n expected number of elements
   * @param p desired false positive rate (e.g., 0.01 for 1%)
   * @return (m: number of bits, k: number of hash functions)
   */
  def optimalParameters(n: Int, p: Double): (Int, Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: False positive rate
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Estimate the false positive rate of a Bloom filter.
   *       Given m bits, k hashes, and n inserted elements:
   *       FPR = (1 - e^(-kn/m))^k
   *
   * @param m number of bits
   * @param k number of hash functions
   * @param n number of inserted elements
   * @return estimated false positive rate
   */
  def falsePositiveRate(m: Int, k: Int, n: Int): Double = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Counting Bloom filter
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a counting Bloom filter that supports deletion.
   *       Instead of bits, use counters. Increment on add, decrement on delete.
   *       Return (add, remove, query) functions.
   *
   * @param m number of counters
   * @param k number of hash functions
   * @return (add, remove, query) functions
   */
  def countingBloomFilter(m: Int, k: Int): (String => Unit, String => Unit, String => Boolean) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Scalable Bloom filter concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a scalable Bloom filter that grows as elements are added.
   *       When FPR exceeds threshold, add a new filter with tighter FPR.
   *       Query checks all filters (positive if any says positive).
   *       Return (add, query, numFilters) functions.
   *
   * @param initialSize initial filter size
   * @param maxFPR      maximum allowed FPR per filter
   * @return (add, query, numFilters) functions
   */
  def scalableBloomFilter(initialSize: Int, maxFPR: Double): (String => Unit, String => Boolean, () => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Bloom filter union
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute the union of two Bloom filters (same m and k).
   *       Union = bitwise OR of the two bit arrays.
   *       An element in either filter will be in the union.
   *
   * @param bits1 first filter's bit set
   * @param bits2 second filter's bit set
   * @param m     filter size
   * @return union bit set
   */
  def bloomFilterUnion(bits1: mutable.BitSet, bits2: mutable.BitSet, m: Int): mutable.BitSet = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Bloom filter applications
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Use a Bloom filter to efficiently find duplicates in a stream.
   *       Process elements one by one; if the Bloom filter says "might contain",
   *       flag as potential duplicate. Return list of potential duplicates.
   *       Note: may include false positives.
   *
   * @param stream  stream of elements
   * @param m       Bloom filter size
   * @param k       number of hash functions
   * @return list of elements flagged as potential duplicates
   */
  def findPotentialDuplicates(stream: List[String], m: Int, k: Int): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (ins1, getBits) = createBloomFilter(100, 3)
    ins1("hello")
    ins1("world")
    assert(getBits().nonEmpty)
    println("Exercise 1 (BF insert) passed.")

    // Exercise 2
    val (ins2, query2) = bloomFilterWithQuery(1000, 5)
    ins2("apple")
    ins2("banana")
    assert(query2("apple"))
    assert(query2("banana"))
    // "cherry" should probably not be found (no guarantee, but very likely with 1000 bits)
    println("Exercise 2 (BF query) passed.")

    // Exercise 3
    val (m3, k3) = optimalParameters(1000, 0.01)
    assert(m3 > 0 && k3 > 0)
    assert(m3 > 1000) // should be roughly 9585
    assert(k3 >= 6 && k3 <= 8) // should be ~7
    println("Exercise 3 (Optimal params) passed.")

    // Exercise 4
    val fpr = falsePositiveRate(10000, 7, 1000)
    assert(fpr < 0.01, s"FPR should be < 0.01, got $fpr")
    println("Exercise 4 (FPR) passed.")

    // Exercise 5
    val (cAdd, cRemove, cQuery) = countingBloomFilter(1000, 5)
    cAdd("test")
    assert(cQuery("test"))
    cRemove("test")
    assert(!cQuery("test"))
    println("Exercise 5 (Counting BF) passed.")

    // Exercise 6
    val (sAdd, sQuery, sNumFilters) = scalableBloomFilter(100, 0.1)
    for (i <- 1 to 200) sAdd(s"item$i")
    assert(sQuery("item1"))
    assert(sQuery("item200"))
    println("Exercise 6 (Scalable BF) passed.")

    // Exercise 7
    val bf1 = mutable.BitSet(1, 3, 5, 7)
    val bf2 = mutable.BitSet(2, 4, 6, 8)
    val union = bloomFilterUnion(bf1, bf2, 10)
    assert(union == mutable.BitSet(1, 2, 3, 4, 5, 6, 7, 8))
    println("Exercise 7 (BF union) passed.")

    // Exercise 8
    val stream = List("a", "b", "c", "a", "d", "b", "e")
    val dups = findPotentialDuplicates(stream, 100, 3)
    assert(dups.contains("a"))
    assert(dups.contains("b"))
    println("Exercise 8 (Find duplicates) passed.")

    println("All Algo104_BloomFilter exercises passed!")
  }
}
