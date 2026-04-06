package org.shev4ik.interview.algorithms.level1_fundamentals

import cats.implicits.catsSyntaxOptionId

/**
 * Array Search Algorithms -- Linear Search vs Binary Search
 *
 * =Theory=
 *
 * '''Linear Search''' scans every element sequentially. It works on any array (sorted or unsorted)
 * and is the simplest search approach. Use it when the array is small, unsorted, or when you
 * only need to search once.
 *   - Time: O(n), Space: O(1)
 *
 * '''Binary Search''' repeatedly halves the search space by comparing the middle element with the
 * target. It requires the array to be '''sorted'''. Use it when the array is sorted and you need
 * efficient repeated lookups.
 *   - Time: O(log n), Space: O(1) iterative / O(log n) recursive (call stack)
 *
 * =When to use which?=
 *   - '''Unsorted array''' -> linear search is your only option (or sort first + binary search if
 *     you will search multiple times: O(n log n) sort amortized over many O(log n) searches).
 *   - '''Sorted array, single lookup''' -> binary search.
 *   - '''Sorted array with duplicates''' -> modified binary search (find first/last occurrence).
 *   - '''2D sorted matrix''' -> staircase search (O(m+n)) or binary search on flattened view.
 *
 * =Interview Tips=
 *   - Always ask: "Is the array sorted?" -- this determines your search strategy.
 *   - Binary search has many subtle edge cases (off-by-one with lo/hi bounds). Practice the
 *     "lo <= hi" loop invariant and "lo + (hi - lo) / 2" to avoid integer overflow.
 *   - For "first/last occurrence" variants, do NOT return immediately when you find the target;
 *     instead, record the answer and keep searching in the appropriate half.
 *   - Related LeetCode: #704 (Binary Search), #35 (Search Insert Position), #34 (First and Last
 *     Position), #74 (Search a 2D Matrix).
 */
object Algo002_ArraySearch {

  // ---------------------------------------------------------------------------
  // Exercise 1: Linear Search
  // Time: O(n) | Space: O(1)
  // Approach: iterate with index, return index when found, -1 at end.
  // ---------------------------------------------------------------------------
  // TODO: Perform linear search -- return the index of target, or -1 if not found
  // Example: Array(4,2,7,1,9), target=7 => 2
  def linearSearch(arr: Array[Int], target: Int): Int =
    arr.zipWithIndex.find{ case (x, _) => x == target}.map(_._2).getOrElse(-1)

  // ---------------------------------------------------------------------------
  // Exercise 2: Find Index (Option-based)
  // Time: O(n) | Space: O(1)
  // Approach: same scan as linear search but wrap result in Option.
  // Hint: arr.indexOf returns -1 if missing -- convert to Option.
  // ---------------------------------------------------------------------------
  // TODO: Find the index of the first occurrence of target using indexOf logic
  // Return Option[Int] -- None if not found
  // Example: Array(1,3,5,3,7), target=3 => Some(1)
  def findIndex(arr: Array[Int], target: Int): Option[Int] =
    arr.indexOf(target) match {
      case -1 => None
      case x => Some(x)
    }

  // ---------------------------------------------------------------------------
  // Exercise 3: Count Occurrences
  // Time: O(n) | Space: O(1)
  // Approach: fold or count filter matching elements.
  // ---------------------------------------------------------------------------
  // TODO: Count how many times target appears in the array
  // Example: Array(1,3,5,3,7,3), target=3 => 3
  def countOccurrences(arr: Array[Int], target: Int): Int =
    arr.count(p => p == target)

  // ---------------------------------------------------------------------------
  // Exercise 4: Find All Indices
  // Time: O(n) | Space: O(k) where k = number of matches
  // Approach: zipWithIndex + collect/filter.
  // ---------------------------------------------------------------------------
  // TODO: Find all indices where target appears, return as a List
  // Example: Array(1,3,5,3,7,3), target=3 => List(1,3,5)
  def findAllIndices(arr: Array[Int], target: Int): List[Int] =
    arr.zipWithIndex.collect { case (x, index)  if (x == target) => index}.toList

  // ---------------------------------------------------------------------------
  // Exercise 5: Binary Search (iterative)
  // Time: O(log n) | Space: O(1)
  // Approach: maintain lo/hi pointers. Compute mid = lo + (hi - lo) / 2.
  //   If arr(mid) == target, return mid.
  //   If arr(mid) < target, lo = mid + 1.
  //   Else hi = mid - 1.
  // ---------------------------------------------------------------------------
  // TODO: Implement binary search on a sorted array, return index or -1
  // The array is guaranteed to be sorted in ascending order
  // Example: Array(1,3,5,7,9,11), target=7 => 3
  def binarySearchSimple(sortedArr: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = sortedArr.length - 1
    while (lo <= hi){
      val mid = lo + (hi - lo)/2
      if (sortedArr(mid) == target){
        return mid
      } else if (sortedArr(mid) < target){
        lo = mid + 1
      } else {
        hi = mid - 1
      }
    }
    -1
  }

  // ---------------------------------------------------------------------------
  // Exercise 6: Search in Sorted (Boolean result)
  // Time: O(log n) | Space: O(1)
  // Approach: reuse binary search, convert result to Boolean.
  // ---------------------------------------------------------------------------
  // TODO: Search in a sorted array and return true/false
  // Use binary search for O(log n) performance
  // Example: Array(2,4,6,8,10), target=6 => true
  def searchInSorted(sortedArr: Array[Int], target: Int): Boolean = {
    var lo = 0
    var hi = sortedArr.length - 1
    while (lo <= hi){
      val mid = lo + (hi - lo)/2
      if (sortedArr(mid) == target){
        return true
      } else if (sortedArr(mid) < target){
        lo = mid + 1
      } else {
        hi = mid - 1
      }
    }
    false
  }

  // ---------------------------------------------------------------------------
  // Exercise 7: First Occurrence in Sorted Array with Duplicates
  // Time: O(log n) | Space: O(1)
  // Approach: modified binary search -- when arr(mid) == target, record mid
  //   as candidate and continue searching LEFT (hi = mid - 1) to find earlier
  //   occurrence. Return candidate at end.
  // ---------------------------------------------------------------------------
  // TODO: Find the index of the first occurrence of target in a sorted array
  // Return -1 if not found. Array may contain duplicates.
  // Example: Array(1,2,2,2,3,4), target=2 => 1
  def firstOccurrence(sortedArr: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = sortedArr.length - 1
    var result = -1
    while (lo <= hi){
      val mid = lo + (hi - lo)/2
      if (sortedArr(mid) == target){
        result = mid
        hi = mid - 1
      } else if (sortedArr(mid) < target){
        lo = mid + 1
      } else {
        hi = mid - 1
      }
    }
    result
  }

  // ---------------------------------------------------------------------------
  // Exercise 8: 2D Array Search (brute force)
  // Time: O(m * n) where m = rows, n = cols | Space: O(1)
  // Approach: nested iteration over rows and columns.
  // Note: If the matrix is row-sorted and column-sorted, use the staircase
  //   search (start top-right, go left if too big, down if too small) for O(m+n).
  // ---------------------------------------------------------------------------
  // TODO: Search for target in a 2D array (array of arrays)
  // Return Some((row, col)) if found, None otherwise
  // Example: Array(Array(1,2,3), Array(4,5,6)), target=5 => Some((1,1))
  def search2DBasic(matrix: Array[Array[Int]], target: Int): Option[(Int, Int)] = {
    for (i <- matrix.indices){
      for (j <- matrix(i).indices){
        if (matrix(i)(j) == target){
          return Some((i,j))
        }
      }
    }
    None
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: linearSearch
    assert(linearSearch(Array(4, 2, 7, 1, 9), 7) == 2)
    assert(linearSearch(Array(4, 2, 7, 1, 9), 10) == -1)
    println("Exercise 1 passed: linearSearch")

    // Exercise 2: findIndex
    assert(findIndex(Array(1, 3, 5, 3, 7), 3) == Some(1))
    assert(findIndex(Array(1, 3, 5), 10) == None)
    println("Exercise 2 passed: findIndex")

    // Exercise 3: countOccurrences
    assert(countOccurrences(Array(1, 3, 5, 3, 7, 3), 3) == 3)
    assert(countOccurrences(Array(1, 2, 3), 5) == 0)
    println("Exercise 3 passed: countOccurrences")

    // Exercise 4: findAllIndices
    assert(findAllIndices(Array(1, 3, 5, 3, 7, 3), 3) == List(1, 3, 5))
    assert(findAllIndices(Array(1, 2, 3), 5) == List())
    println("Exercise 4 passed: findAllIndices")

    // Exercise 5: binarySearchSimple
    assert(binarySearchSimple(Array(1, 3, 5, 7, 9, 11), 7) == 3)
    assert(binarySearchSimple(Array(1, 3, 5, 7, 9, 11), 4) == -1)
    println("Exercise 5 passed: binarySearchSimple")

    // Exercise 6: searchInSorted
    assert(searchInSorted(Array(2, 4, 6, 8, 10), 6) == true)
    assert(searchInSorted(Array(2, 4, 6, 8, 10), 5) == false)
    println("Exercise 6 passed: searchInSorted")

    // Exercise 7: firstOccurrence
    assert(firstOccurrence(Array(1, 2, 2, 2, 3, 4), 2) == 1)
    assert(firstOccurrence(Array(1, 2, 3, 4), 5) == -1)
    println("Exercise 7 passed: firstOccurrence")

    // Exercise 8: search2DBasic
    assert(search2DBasic(Array(Array(1, 2, 3), Array(4, 5, 6)), 5) == Some((1, 1)))
    assert(search2DBasic(Array(Array(1, 2, 3), Array(4, 5, 6)), 7) == None)
    println("Exercise 8 passed: search2DBasic")

    println("All Algo002_ArraySearch exercises passed!")
  }
}
