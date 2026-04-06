package org.shev4ik.algorithms.leetcode_classic

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 *
 * Pattern: Hash Map + Heap / Bucket Sort
 * Time: O(n log k) for Heap, O(n) for Bucket Sort
 * Space: O(n)
 */
object L347_TopKFrequent {

  // Using Min Heap
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    // TODO: Implement using frequency map + min heap of size k
    ???
  }

  def topKFrequentBucket(nums: Array[Int], k: Int): Array[Int] = {
    val freq: Map[Int, Int] = nums.groupBy(identity).mapValues(_.length)

    val buckets = Array.fill[List[Int]](nums.length + 1)(Nil)
    // 1 -> 2
    // 2 -> 3
    // 3 -> 2
    freq.foreach { case (num, count) => {
      buckets(count) = num :: buckets(count)
    }
    }
    // 2 -> [1,3]
    // 3 -> [2]
    buckets.reverse.flatten.take(k)
  }

  def topKFrequentSimple(nums: Array[Int], k: Int): Array[Int] = {
      nums.groupBy(identity)
      .mapValues(_.length)
      .toSeq
      .sortBy(-_._2)
      .take(k)
      .map(_._1)
      .toArray
  }

  def main(args: Array[String]): Unit = {
    println(topKFrequentSimple(Array(1, 1, 1, 2, 2, 3), 2).mkString(", ")) // Expected: 1, 2
    println(topKFrequentSimple(Array(1), 1).mkString(", "))                 // Expected: 1
  }
}
