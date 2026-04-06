package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo018_BinarySearch {

  // TODO: Classic binary search — return index of target in sorted array, or -1
  // Example: Array(1,3,5,7,9,11), target=7 => 3
  def classicBinarySearch(arr: Array[Int], target: Int): Int = ???

  // TODO: Find the index where target should be inserted to keep array sorted
  // If target exists, return its index
  // Example: Array(1,3,5,6), target=5 => 2, target=2 => 1, target=7 => 4
  def searchInsertPosition(arr: Array[Int], target: Int): Int = ???

  // TODO: First bad version — given n versions (1..n) and isBadVersion API,
  // find the first bad version using binary search
  // isBadVersion is passed as a function parameter
  def firstBadVersion(n: Int, isBadVersion: Int => Boolean): Int = ???

  // TODO: Find a peak element (strictly greater than its neighbors)
  // Return the index of any peak element
  // Example: Array(1,2,3,1) => 2 (element 3 is a peak)
  def findPeakElement(arr: Array[Int]): Int = ???

  // TODO: Search in a rotated sorted array (no duplicates)
  // Example: Array(4,5,6,7,0,1,2), target=0 => 4
  def searchRotatedSorted(arr: Array[Int], target: Int): Int = ???

  // TODO: Find the minimum element in a rotated sorted array
  // Example: Array(3,4,5,1,2) => 1
  def findMinimumRotated(arr: Array[Int]): Int = ???

  // TODO: Compute integer square root of x (floor)
  // Example: sqrt(8) => 2, sqrt(16) => 4
  def mySqrt(x: Int): Int = ???

  // TODO: Guess number higher or lower
  // Given a pick between 1 and n, use the guess function:
  // guess(num) returns -1 if pick < num, 1 if pick > num, 0 if correct
  // Return the picked number
  def guessNumber(n: Int, guess: Int => Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: classicBinarySearch
    assert(classicBinarySearch(Array(1, 3, 5, 7, 9, 11), 7) == 3)
    assert(classicBinarySearch(Array(1, 3, 5, 7, 9, 11), 4) == -1)
    println("Exercise 1 passed: classicBinarySearch")

    // Exercise 2: searchInsertPosition
    assert(searchInsertPosition(Array(1, 3, 5, 6), 5) == 2)
    assert(searchInsertPosition(Array(1, 3, 5, 6), 2) == 1)
    assert(searchInsertPosition(Array(1, 3, 5, 6), 7) == 4)
    assert(searchInsertPosition(Array(1, 3, 5, 6), 0) == 0)
    println("Exercise 2 passed: searchInsertPosition")

    // Exercise 3: firstBadVersion
    assert(firstBadVersion(5, v => v >= 4) == 4)
    assert(firstBadVersion(1, _ => true) == 1)
    println("Exercise 3 passed: firstBadVersion")

    // Exercise 4: findPeakElement
    val peak1 = findPeakElement(Array(1, 2, 3, 1))
    assert(peak1 == 2)
    val peak2 = findPeakElement(Array(1, 2, 1, 3, 5, 6, 4))
    assert(peak2 == 1 || peak2 == 5) // either peak is valid
    println("Exercise 4 passed: findPeakElement")

    // Exercise 5: searchRotatedSorted
    assert(searchRotatedSorted(Array(4, 5, 6, 7, 0, 1, 2), 0) == 4)
    assert(searchRotatedSorted(Array(4, 5, 6, 7, 0, 1, 2), 3) == -1)
    println("Exercise 5 passed: searchRotatedSorted")

    // Exercise 6: findMinimumRotated
    assert(findMinimumRotated(Array(3, 4, 5, 1, 2)) == 1)
    assert(findMinimumRotated(Array(4, 5, 6, 7, 0, 1, 2)) == 0)
    assert(findMinimumRotated(Array(1, 2, 3)) == 1)
    println("Exercise 6 passed: findMinimumRotated")

    // Exercise 7: mySqrt
    assert(mySqrt(8) == 2)
    assert(mySqrt(16) == 4)
    assert(mySqrt(0) == 0)
    assert(mySqrt(1) == 1)
    println("Exercise 7 passed: mySqrt")

    // Exercise 8: guessNumber
    assert(guessNumber(10, num => if (6 < num) -1 else if (6 > num) 1 else 0) == 6)
    println("Exercise 8 passed: guessNumber")

    println("All Algo018_BinarySearch exercises passed!")
  }
}
