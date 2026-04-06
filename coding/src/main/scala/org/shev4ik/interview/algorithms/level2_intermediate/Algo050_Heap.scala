package org.shev4ik.interview.algorithms.level2_intermediate

object Algo050_Heap {

  // Exercise 1: Build a min-heap from an array (heapify all elements, return heap array)
  // TODO: Start from last non-leaf node, sift down each. Return array in min-heap order.
  def buildMinHeap(arr: Array[Int]): Array[Int] = ???

  // Exercise 2: Build a max-heap from an array
  // TODO: Same as min-heap but parent >= children.
  def buildMaxHeap(arr: Array[Int]): Array[Int] = ???

  // Exercise 3: Sift-down (heapify) operation for a min-heap at index i
  // TODO: Compare with children, swap with smallest child if needed, recurse. Mutates array in place.
  def siftDown(arr: Array[Int], i: Int, size: Int): Unit = ???

  // Exercise 4: Insert into a min-heap, return new heap array
  // TODO: Add element at end. Sift up: swap with parent while smaller than parent.
  def insertMinHeap(heap: Array[Int], heapSize: Int, value: Int): (Array[Int], Int) = ???

  // Exercise 5: Extract minimum from a min-heap, return (min, new heap array)
  // TODO: Swap root with last element. Reduce size. Sift down from root.
  def extractMin(heap: Array[Int], heapSize: Int): (Int, Array[Int], Int) = ???

  // Exercise 6: Heap sort — sort array in ascending order using a max-heap
  // TODO: Build max-heap. Repeatedly extract max (swap with end), reduce heap size, sift down.
  def heapSort(arr: Array[Int]): Array[Int] = ???

  // Exercise 7: Kth largest element in an unsorted array
  // TODO: Use a min-heap of size k. Process all elements; top of heap is kth largest.
  def findKthLargest(nums: Array[Int], k: Int): Int = ???

  // Exercise 8: Merge K sorted lists into one sorted list
  // TODO: Use a min-heap of (value, listIndex, elementIndex). Extract min, add next from same list.
  def mergeKSortedLists(lists: List[List[Int]]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val minHeap = buildMinHeap(Array(5, 3, 8, 1, 2))
    assert(minHeap(0) == 1, "Min-heap root is minimum")

    // Exercise 2
    val maxHeap = buildMaxHeap(Array(5, 3, 8, 1, 2))
    assert(maxHeap(0) == 8, "Max-heap root is maximum")

    // Exercise 3
    val arr = Array(10, 2, 3, 4, 5)
    siftDown(arr, 0, arr.length)
    assert(arr(0) == 2 || arr(0) == 3, "Sifted down correctly")

    // Exercise 4
    val heap = Array(1, 3, 5, 7, 0, 0) // extra space
    val (newHeap, newSize) = insertMinHeap(heap, 4, 2)
    assert(newHeap(0) == 1, "Min still at root after insert")
    assert(newSize == 5, "Size increased")

    // Exercise 5
    val h = buildMinHeap(Array(3, 1, 4, 1, 5))
    val (minVal, _, _) = extractMin(h, 5)
    assert(minVal == 1, "Extracted minimum is 1")

    // Exercise 6
    assert(heapSort(Array(5, 3, 8, 1, 2)).toList == List(1, 2, 3, 5, 8), "Heap sort")

    // Exercise 7
    assert(findKthLargest(Array(3, 2, 1, 5, 6, 4), 2) == 5, "2nd largest is 5")
    assert(findKthLargest(Array(3, 2, 3, 1, 2, 4, 5, 5, 6), 4) == 4, "4th largest is 4")

    // Exercise 8
    val merged = mergeKSortedLists(List(List(1, 4, 5), List(1, 3, 4), List(2, 6)))
    assert(merged == List(1, 1, 2, 3, 4, 4, 5, 6), "Merged k sorted lists")

    println("All Algo050_Heap exercises passed!")
  }
}
