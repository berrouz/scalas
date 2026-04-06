package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo031_SortingApps {

  // TODO: Sort an array containing only 0s, 1s, and 2s (Dutch National Flag problem)
  // One-pass algorithm using three pointers
  // Example: Array(2,0,2,1,1,0) => Array(0,0,1,1,2,2)
  def sortColors(nums: Array[Int]): Array[Int] = ???

  // TODO: Merge sorted array nums1 (with extra space) with nums2 in-place
  // nums1 has m elements followed by enough zeros, nums2 has n elements
  // Example: nums1=Array(1,2,3,0,0,0), m=3, nums2=Array(2,5,6), n=3
  //       => Array(1,2,2,3,5,6)
  def mergeSortedArray(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Array[Int] = ???

  // TODO: Sort a linked list in O(n log n) time using merge sort
  // Return sorted values as an Array for simplicity
  // Example: Array(4,2,1,3) => Array(1,2,3,4)
  def sortList(values: Array[Int]): Array[Int] = ???

  // TODO: Given a list of non-negative integers, arrange them to form the largest number
  // Return as a string
  // Example: Array(10,2) => "210", Array(3,30,34,5,9) => "9534330"
  def largestNumber(nums: Array[Int]): String = ???

  // TODO: Find the h-index: maximum value h such that h papers have at least h citations
  // Example: Array(3,0,6,1,5) => 3
  def hIndex(citations: Array[Int]): Int = ???

  // TODO: Sort array arr1 such that the relative order of items in arr1
  // matches the order in arr2. Elements not in arr2 go at the end in ascending order.
  // Example: arr1=Array(2,3,1,3,2,4,6,7,9,2,19), arr2=Array(2,1,4,3,9,6)
  //       => Array(2,2,2,1,4,3,3,9,6,7,19)
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: sortColors
    assert(sortColors(Array(2, 0, 2, 1, 1, 0)).toSeq == Seq(0, 0, 1, 1, 2, 2))
    assert(sortColors(Array(2, 0, 1)).toSeq == Seq(0, 1, 2))
    assert(sortColors(Array(0)).toSeq == Seq(0))
    println("Exercise 1 passed: sortColors")

    // Exercise 2: mergeSortedArray
    assert(mergeSortedArray(Array(1, 2, 3, 0, 0, 0), 3, Array(2, 5, 6), 3).toSeq == Seq(1, 2, 2, 3, 5, 6))
    assert(mergeSortedArray(Array(0), 0, Array(1), 1).toSeq == Seq(1))
    println("Exercise 2 passed: mergeSortedArray")

    // Exercise 3: sortList
    assert(sortList(Array(4, 2, 1, 3)).toSeq == Seq(1, 2, 3, 4))
    assert(sortList(Array(-1, 5, 3, 4, 0)).toSeq == Seq(-1, 0, 3, 4, 5))
    println("Exercise 3 passed: sortList")

    // Exercise 4: largestNumber
    assert(largestNumber(Array(10, 2)) == "210")
    assert(largestNumber(Array(3, 30, 34, 5, 9)) == "9534330")
    assert(largestNumber(Array(0, 0)) == "0")
    println("Exercise 4 passed: largestNumber")

    // Exercise 5: hIndex
    assert(hIndex(Array(3, 0, 6, 1, 5)) == 3)
    assert(hIndex(Array(1, 3, 1)) == 1)
    println("Exercise 5 passed: hIndex")

    // Exercise 6: relativeSortArray
    assert(relativeSortArray(
      Array(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
      Array(2, 1, 4, 3, 9, 6)
    ).toSeq == Seq(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19))
    println("Exercise 6 passed: relativeSortArray")

    println("All Algo031_SortingApps exercises passed!")
  }
}
