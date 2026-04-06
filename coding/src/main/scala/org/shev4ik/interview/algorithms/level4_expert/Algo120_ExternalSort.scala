package org.shev4ik.interview.algorithms.level4_expert

import scala.collection.mutable

/**
 * External Sorting and Memory-Efficient Algorithms.
 *
 * Key concepts:
 * - External merge sort: sort data that doesn't fit in memory
 * - K-way merge using min-heap
 * - Replacement selection for longer initial runs
 * - B+ tree for external index, sort-merge join
 */
object Algo120_ExternalSort {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: External merge sort (simulated)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate external merge sort.
   *       Phase 1: Split input into chunks of `memorySize`, sort each chunk.
   *       Phase 2: Merge sorted chunks using k-way merge.
   *       Simulate by working with Array[Int] but pretending only
   *       `memorySize` elements fit in memory at a time.
   *       Return the sorted array.
   *
   * @param data       input data
   * @param memorySize simulated memory size (max elements in memory)
   * @return sorted array
   */
  def externalMergeSort(data: Array[Int], memorySize: Int): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: K-way merge
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Merge k sorted arrays into one sorted array using a min-heap.
   *       The heap contains (value, arrayIndex, elementIndex) entries.
   *       Extract min, add next element from same array.
   *       Return the merged sorted array.
   *
   * @param sortedArrays list of sorted arrays
   * @return single merged sorted array
   */
  def kWayMerge(sortedArrays: List[Array[Int]]): Array[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Replacement selection
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement the replacement selection algorithm for creating
   *       longer initial sorted runs. Use a min-heap of size `heapSize`.
   *       - Extract min from heap, add to current run
   *       - Read next element; if >= last output, add to heap
   *       - Otherwise, mark as "next run" (dead space)
   *       - When heap is empty of current-run elements, start new run
   *       Return the list of sorted runs (each run is a sorted array).
   *
   * @param data     input data stream
   * @param heapSize size of the in-memory heap
   * @return list of sorted runs
   */
  def replacementSelection(data: Array[Int], heapSize: Int): List[Array[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: B+ tree for external storage simulation
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate a B+ tree index for range queries on external data.
   *       Build a B+ tree with given order (max keys per node).
   *       Support insert and range query [lo, hi].
   *       Return all values in the range.
   *
   * @param data  key-value pairs to insert
   * @param order maximum number of keys per node
   * @param lo    range query lower bound (inclusive)
   * @param hi    range query upper bound (inclusive)
   * @return sorted list of values with keys in [lo, hi]
   */
  def bPlusTreeRangeQuery(data: List[(Int, String)], order: Int, lo: Int, hi: Int): List[String] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: External hash join concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate an external hash join of two relations.
   *       Phase 1: Partition both relations by hash(joinKey) into buckets.
   *       Phase 2: For matching buckets, perform in-memory join.
   *       Return the joined tuples.
   *
   * @param relation1  list of (key, value1) tuples
   * @param relation2  list of (key, value2) tuples
   * @param numBuckets number of hash buckets
   * @return list of (key, value1, value2) joined tuples
   */
  def externalHashJoin(
    relation1: List[(Int, String)],
    relation2: List[(Int, String)],
    numBuckets: Int
  ): List[(Int, String, String)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Memory-efficient processing (streaming median)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Compute approximate median of a data stream using limited memory.
   *       Use the "median of medians of chunks" approach:
   *       - Process data in chunks of `chunkSize`
   *       - Find median of each chunk
   *       - Return median of medians as approximate overall median.
   *
   * @param data      data stream as array
   * @param chunkSize size of each chunk (simulated memory limit)
   * @return approximate median
   */
  def streamingApproxMedian(data: Array[Int], chunkSize: Int): Int = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Streaming sort (external sort with streaming output)
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a streaming sort that processes input in chunks
   *       and produces sorted output incrementally.
   *       Phase 1: Read chunks, sort, write to "disk" (list of arrays).
   *       Phase 2: Initialize k-way merge, yield elements one at a time.
   *       Return an iterator that produces sorted elements lazily.
   *       For testing, collect all elements from the iterator.
   *
   * @param data       input data
   * @param chunkSize  size of each sorted chunk
   * @return iterator producing sorted elements
   */
  def streamingSort(data: Array[Int], chunkSize: Int): Iterator[Int] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Sort-merge join
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement sort-merge join for two relations.
   *       1. Sort both relations by join key (using external sort if needed)
   *       2. Merge the sorted relations, matching on join key
   *       Return the joined tuples sorted by key.
   *
   * @param relation1 list of (key, value1)
   * @param relation2 list of (key, value2)
   * @return sorted list of (key, value1, value2) joined tuples
   */
  def sortMergeJoin(
    relation1: List[(Int, String)],
    relation2: List[(Int, String)]
  ): List[(Int, String, String)] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val data1 = Array(9, 3, 7, 1, 8, 2, 6, 4, 5)
    val sorted1 = externalMergeSort(data1, memorySize = 3)
    assert(sorted1.toList == (1 to 9).toList, s"Got ${sorted1.toList}")
    println("Exercise 1 (External merge sort) passed.")

    // Exercise 2
    val merged = kWayMerge(List(Array(1, 4, 7), Array(2, 5, 8), Array(3, 6, 9)))
    assert(merged.toList == (1 to 9).toList, s"Got ${merged.toList}")
    println("Exercise 2 (K-way merge) passed.")

    // Exercise 3
    val runs = replacementSelection(Array(5, 3, 8, 1, 9, 2, 7, 4, 6), heapSize = 3)
    assert(runs.nonEmpty, "Expected at least one run")
    assert(runs.forall(r => r.toList == r.sorted.toList), "Each run must be sorted")
    assert(runs.flatMap(_.toList).sorted == (1 to 9).toList, "All elements must be present")
    println(s"Exercise 3 (Replacement selection) passed. ${runs.size} runs created.")

    // Exercise 4
    val kvData = List((5, "e"), (3, "c"), (7, "g"), (1, "a"), (9, "i"), (2, "b"), (8, "h"))
    val rangeResult = bPlusTreeRangeQuery(kvData, order = 3, lo = 3, hi = 7)
    assert(rangeResult.sorted == List("c", "e", "g"), s"Got $rangeResult")
    println("Exercise 4 (B+ tree range query) passed.")

    // Exercise 5
    val r1 = List((1, "a1"), (2, "a2"), (3, "a3"), (1, "a4"))
    val r2 = List((1, "b1"), (3, "b3"), (4, "b4"))
    val joined = externalHashJoin(r1, r2, numBuckets = 4)
    assert(joined.exists(_._1 == 1), "Expected join on key 1")
    assert(joined.exists(_._1 == 3), "Expected join on key 3")
    assert(!joined.exists(_._1 == 2), "No join on key 2")
    println(s"Exercise 5 (External hash join) passed. ${joined.size} tuples.")

    // Exercise 6
    val median = streamingApproxMedian((1 to 100).toArray.reverse, chunkSize = 10)
    assert(median >= 30 && median <= 70, s"Expected approx median near 50, got $median")
    println(s"Exercise 6 (Streaming median) passed. Approx median=$median")

    // Exercise 7
    val streamSorted = streamingSort(Array(9, 3, 7, 1, 8, 2, 6, 4, 5), chunkSize = 3).toList
    assert(streamSorted == (1 to 9).toList, s"Got $streamSorted")
    println("Exercise 7 (Streaming sort) passed.")

    // Exercise 8
    val smj = sortMergeJoin(
      List((3, "x"), (1, "y"), (2, "z")),
      List((2, "a"), (1, "b"), (3, "c"))
    )
    assert(smj.map(_._1) == List(1, 2, 3), s"Expected sorted keys, got ${smj.map(_._1)}")
    println("Exercise 8 (Sort-merge join) passed.")

    println("All Algo120_ExternalSort exercises passed!")
  }
}
