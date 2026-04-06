package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo016_SortingBasic {

  // TODO: Implement bubble sort
  // Repeatedly swap adjacent elements if they are in wrong order
  // Example: Array(64,34,25,12,22,11,90) => Array(11,12,22,25,34,64,90)
  def bubbleSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement selection sort
  // Find minimum element and place it at the beginning, repeat
  // Example: Array(64,25,12,22,11) => Array(11,12,22,25,64)
  def selectionSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement insertion sort
  // Build sorted array one element at a time by inserting into correct position
  // Example: Array(12,11,13,5,6) => Array(5,6,11,12,13)
  def insertionSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Implement counting sort for non-negative integers
  // Count occurrences of each value and reconstruct sorted array
  // Example: Array(4,2,2,8,3,3,1) => Array(1,2,2,3,3,4,8)
  def countingSort(arr: Array[Int]): Array[Int] = ???

  // TODO: Merge two sorted arrays into a single sorted array
  // Example: Array(1,3,5), Array(2,4,6) => Array(1,2,3,4,5,6)
  def mergeTwoSortedArrays(a: Array[Int], b: Array[Int]): Array[Int] = ???

  // TODO: Check if an array is sorted in non-decreasing order
  // Example: Array(1,2,2,3,4) => true, Array(1,3,2) => false
  def isSorted(arr: Array[Int]): Boolean = ???

  // TODO: Sort array elements by their frequency (most frequent first)
  // If same frequency, sort by value (ascending)
  // Example: Array(1,1,2,2,2,3) => Array(2,2,2,1,1,3)
  def sortByFrequency(arr: Array[Int]): Array[Int] = ???

  // TODO: Sort array so that even numbers come before odd numbers
  // Maintain relative order within evens and odds
  // Example: Array(3,1,2,4) => Array(2,4,3,1)
  def sortByParity(arr: Array[Int]): Array[Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: bubbleSort
    assert(bubbleSort(Array(64, 34, 25, 12, 22, 11, 90)).toSeq == Seq(11, 12, 22, 25, 34, 64, 90))
    assert(bubbleSort(Array(1)).toSeq == Seq(1))
    println("Exercise 1 passed: bubbleSort")

    // Exercise 2: selectionSort
    assert(selectionSort(Array(64, 25, 12, 22, 11)).toSeq == Seq(11, 12, 22, 25, 64))
    println("Exercise 2 passed: selectionSort")

    // Exercise 3: insertionSort
    assert(insertionSort(Array(12, 11, 13, 5, 6)).toSeq == Seq(5, 6, 11, 12, 13))
    println("Exercise 3 passed: insertionSort")

    // Exercise 4: countingSort
    assert(countingSort(Array(4, 2, 2, 8, 3, 3, 1)).toSeq == Seq(1, 2, 2, 3, 3, 4, 8))
    println("Exercise 4 passed: countingSort")

    // Exercise 5: mergeTwoSortedArrays
    assert(mergeTwoSortedArrays(Array(1, 3, 5), Array(2, 4, 6)).toSeq == Seq(1, 2, 3, 4, 5, 6))
    assert(mergeTwoSortedArrays(Array.empty[Int], Array(1, 2)).toSeq == Seq(1, 2))
    println("Exercise 5 passed: mergeTwoSortedArrays")

    // Exercise 6: isSorted
    assert(isSorted(Array(1, 2, 2, 3, 4)) == true)
    assert(isSorted(Array(1, 3, 2)) == false)
    assert(isSorted(Array.empty[Int]) == true)
    println("Exercise 6 passed: isSorted")

    // Exercise 7: sortByFrequency
    assert(sortByFrequency(Array(1, 1, 2, 2, 2, 3)).toSeq == Seq(2, 2, 2, 1, 1, 3))
    println("Exercise 7 passed: sortByFrequency")

    // Exercise 8: sortByParity
    assert(sortByParity(Array(3, 1, 2, 4)).toSeq == Seq(2, 4, 3, 1))
    println("Exercise 8 passed: sortByParity")

    println("All Algo016_SortingBasic exercises passed!")
  }
}
