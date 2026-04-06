package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo019_BinarySearchApps {

  // TODO: Search a 2D matrix where each row is sorted and first element of each row
  // is greater than last element of previous row
  // Example: matrix=[[1,3,5,7],[10,11,16,20],[23,30,34,60]], target=3 => true
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = ???

  // TODO: Find the starting and ending position of a target in a sorted array
  // Return (-1,-1) if not found
  // Example: Array(5,7,7,8,8,10), target=8 => (3,4)
  def findRange(nums: Array[Int], target: Int): (Int, Int) = ???

  // TODO: Koko eating bananas — given piles of bananas and h hours,
  // find minimum eating speed k (bananas/hour) to finish all piles within h hours
  // Example: piles=Array(3,6,7,11), h=8 => 4
  def kokoEatingBananas(piles: Array[Int], h: Int): Int = ???

  // TODO: Find the minimum capacity to ship all packages within d days
  // Packages must be shipped in order
  // Example: weights=Array(1,2,3,4,5,6,7,8,9,10), d=5 => 15
  def capacityToShip(weights: Array[Int], d: Int): Int = ???

  // TODO: Split array into m subarrays to minimize the largest subarray sum
  // Example: Array(7,2,5,10,8), m=2 => 18 (split [7,2,5] and [10,8])
  def splitArrayLargestSum(nums: Array[Int], m: Int): Int = ???

  // TODO: Find the median of two sorted arrays in O(log(min(m,n))) time
  // Example: Array(1,3), Array(2) => 2.0
  // Example: Array(1,2), Array(3,4) => 2.5
  def medianTwoSorted(nums1: Array[Int], nums2: Array[Int]): Double = ???

  // TODO: Count the number of negative numbers in a sorted matrix
  // Each row and column is sorted in non-increasing order
  // Example: [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]] => 8
  def countNegatives(grid: Array[Array[Int]]): Int = ???

  // TODO: Search in a rotated sorted array that may contain duplicates
  // Return true if target exists
  // Example: Array(2,5,6,0,0,1,2), target=0 => true
  def searchRotatedII(nums: Array[Int], target: Int): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: searchMatrix
    val matrix1 = Array(Array(1,3,5,7), Array(10,11,16,20), Array(23,30,34,60))
    assert(searchMatrix(matrix1, 3) == true)
    assert(searchMatrix(matrix1, 13) == false)
    println("Exercise 1 passed: searchMatrix")

    // Exercise 2: findRange
    assert(findRange(Array(5, 7, 7, 8, 8, 10), 8) == (3, 4))
    assert(findRange(Array(5, 7, 7, 8, 8, 10), 6) == (-1, -1))
    println("Exercise 2 passed: findRange")

    // Exercise 3: kokoEatingBananas
    assert(kokoEatingBananas(Array(3, 6, 7, 11), 8) == 4)
    assert(kokoEatingBananas(Array(30, 11, 23, 4, 20), 5) == 30)
    println("Exercise 3 passed: kokoEatingBananas")

    // Exercise 4: capacityToShip
    assert(capacityToShip(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5) == 15)
    println("Exercise 4 passed: capacityToShip")

    // Exercise 5: splitArrayLargestSum
    assert(splitArrayLargestSum(Array(7, 2, 5, 10, 8), 2) == 18)
    println("Exercise 5 passed: splitArrayLargestSum")

    // Exercise 6: medianTwoSorted
    assert(medianTwoSorted(Array(1, 3), Array(2)) == 2.0)
    assert(medianTwoSorted(Array(1, 2), Array(3, 4)) == 2.5)
    println("Exercise 6 passed: medianTwoSorted")

    // Exercise 7: countNegatives
    val grid7 = Array(Array(4,3,2,-1), Array(3,2,1,-1), Array(1,1,-1,-2), Array(-1,-1,-2,-3))
    assert(countNegatives(grid7) == 8)
    println("Exercise 7 passed: countNegatives")

    // Exercise 8: searchRotatedII
    assert(searchRotatedII(Array(2, 5, 6, 0, 0, 1, 2), 0) == true)
    assert(searchRotatedII(Array(2, 5, 6, 0, 0, 1, 2), 3) == false)
    println("Exercise 8 passed: searchRotatedII")

    println("All Algo019_BinarySearchApps exercises passed!")
  }
}
