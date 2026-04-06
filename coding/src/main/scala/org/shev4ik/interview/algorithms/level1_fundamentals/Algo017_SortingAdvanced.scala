package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo017_SortingAdvanced {

  // TODO: Implement merge sort
  // Divide array in half, sort each half recursively, then merge
  // Example: Array(38,27,43,3,9,82,10) => Array(3,9,10,27,38,43,82)
  def mergeSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement quick sort
  // Pick a pivot, partition around it, recursively sort partitions
  // Example: Array(10,7,8,9,1,5) => Array(1,5,7,8,9,10)
  def quickSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement basic heap sort
  // Build a max-heap, then repeatedly extract the maximum
  // Example: Array(12,11,13,5,6,7) => Array(5,6,7,11,12,13)
  def heapSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement radix sort for non-negative integers
  // Sort by each digit from least significant to most significant
  // Example: Array(170,45,75,90,802,24,2,66) => Array(2,24,45,66,75,90,170,802)
  def radixSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement bucket sort for floating point numbers in [0, 1)
  // Distribute into buckets, sort each bucket, concatenate
  // Example: Array(0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68)
  def bucketSort(arr: Array[Double]): Array[Double] = ???

  // TODO: Find the kth largest element in an unsorted array
  // Use quickselect or partial sort
  // Example: Array(3,2,1,5,6,4), k=2 => 5
  def findKthLargest(arr: Array[Int], k: Int): Int = ???

  // TODO: Sort a nearly sorted (k-sorted) array where each element is at most k positions
  // away from its sorted position. Use a min-heap of size k+1.
  // Example: Array(6,5,3,2,8,10,9), k=3 => Array(2,3,5,6,8,9,10)
  def sortNearlySorted(arr: Array[Int], k: Int): Array[Int] = ???

  // TODO: Wiggle sort: nums[0] <= nums[1] >= nums[2] <= nums[3] ...
  // Example: Array(3,5,2,1,6,4) => one valid answer: Array(3,5,1,6,2,4)
  // Any valid wiggle arrangement is accepted
  def wiggleSort(arr: Array[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: mergeSort
    assert(mergeSort(Array(38, 27, 43, 3, 9, 82, 10)).toSeq == Seq(3, 9, 10, 27, 38, 43, 82))
    assert(mergeSort(Array(1)).toSeq == Seq(1))
    println("Exercise 1 passed: mergeSort")

    // Exercise 2: quickSort
    assert(quickSort(Array(10, 7, 8, 9, 1, 5)).toSeq == Seq(1, 5, 7, 8, 9, 10))
    assert(quickSort(Array(3, 2, 1)).toSeq == Seq(1, 2, 3))
    println("Exercise 2 passed: quickSort")

    // Exercise 3: heapSort
    assert(heapSort(Array(12, 11, 13, 5, 6, 7)).toSeq == Seq(5, 6, 7, 11, 12, 13))
    println("Exercise 3 passed: heapSort")

    // Exercise 4: radixSort
    assert(radixSort(Array(170, 45, 75, 90, 802, 24, 2, 66)).toSeq == Seq(2, 24, 45, 66, 75, 90, 170, 802))
    println("Exercise 4 passed: radixSort")

    // Exercise 5: bucketSort
    val bs = bucketSort(Array(0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68))
    assert(bs.toSeq == bs.sorted.toSeq)
    println("Exercise 5 passed: bucketSort")

    // Exercise 6: findKthLargest
    assert(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2) == 5)
    assert(findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 4) == 4)
    println("Exercise 6 passed: findKthLargest")

    // Exercise 7: sortNearlySorted
    assert(sortNearlySorted(Array(6, 5, 3, 2, 8, 10, 9), 3).toSeq == Seq(2, 3, 5, 6, 8, 9, 10))
    println("Exercise 7 passed: sortNearlySorted")

    // Exercise 8: wiggleSort — verify the wiggle property
    val ws = wiggleSort(Array(3, 5, 2, 1, 6, 4))
    for (i <- ws.indices) {
      if (i % 2 == 0 && i + 1 < ws.length) assert(ws(i) <= ws(i + 1), s"Failed wiggle at $i")
      if (i % 2 == 1 && i + 1 < ws.length) assert(ws(i) >= ws(i + 1), s"Failed wiggle at $i")
    }
    println("Exercise 8 passed: wiggleSort")

    println("All Algo017_SortingAdvanced exercises passed!")
  }
}
