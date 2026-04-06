package org.shev4ik.interview.algorithms.level1_fundamentals

import java.util
import scala.collection.mutable.ArrayBuffer

/**
 * Array Basics - fundamental operations on arrays.
 *
 * Key array concepts:
 * - Contiguous memory layout: elements are stored in adjacent memory locations,
 *   enabling O(1) random access by index.
 * - Access by index: O(1). Search by value (unsorted): O(n). Insertion/deletion at
 *   arbitrary position: O(n) due to shifting.
 * - Arrays in Scala (Array[T]) are backed by JVM arrays - they are mutable and fixed-size.
 *
 * When to use Array vs List vs Vector in Scala:
 * - Array[T]: best for indexed access O(1), interop with Java, and performance-critical
 *   numeric work. Mutable. Fixed size (no append/prepend without copying).
 * - List[T]: immutable singly-linked list. O(1) prepend, O(n) append, O(n) indexed access.
 *   Preferred for recursive/pattern-matching-heavy functional code.
 * - Vector[T]: immutable indexed sequence. Effectively O(1) for access, append, prepend,
 *   and update (via structural sharing). Best general-purpose immutable collection.
 */
object Algo001_ArrayBasics {

  // TODO: Reverse the given array and return a new array
  // Example: Array(1,2,3,4,5) => Array(5,4,3,2,1)
  // Time: O(n), Space: O(n). Hint: use .reverse or manual swap with indices
  def reverseArray(arr: Array[Int]): Array[Int] = {
    ((arr.length-1) to 0).by(-1)
      .foldLeft(List[Int]()){ case (acc, i) => acc :+ arr(i) }.toArray
  }

  // TODO: Rotate the array to the right by k positions
  // Example: Array(1,2,3,4,5), k=2 => Array(4,5,1,2,3)
  // Time: O(n), Space: O(n). Hint: use splitAt(n - k % n) then concatenate, or reverse three times in-place
  def rotateArray(arr: Array[Int], k: Int): Array[Int] = {
    val n = arr.length
    val (head, tail) = arr.splitAt(n - k%n)
    tail ++ head
  }

  // TODO: Find the maximum element in the array
  // Example: Array(3,1,4,1,5,9) => 9
  // Time: O(n), Space: O(1). Hint: use .max or fold/reduce through the array
  def findMax(arr: Array[Int]): Int = {
    arr.reduce((a,b) => if (a > b) a else b )
  }

  // TODO: Find the minimum element in the array
  // Example: Array(3,1,4,1,5,9) => 1
  // Time: O(n), Space: O(1). Hint: use .min or fold/reduce through the array
  def findMin(arr: Array[Int]): Int =
    arr.fold(Int.MaxValue)((a,b) => if (a < b ) a else b)

  // TODO: Calculate the sum of all elements in the array
  // Example: Array(1,2,3,4,5) => 15
  // Time: O(n), Space: O(1). Hint: use .sum or .foldLeft(0)(_ + _)
  def sumArray(arr: Array[Int]): Int =
    arr.fold(0)((a,b) => a + b)

  // TODO: Calculate the average of all elements (return as Double)
  // Example: Array(1,2,3,4,5) => 3.0
  // Time: O(n), Space: O(1). Hint: compute sum then divide by length; watch for integer division
  def average(arr: Array[Int]): Double =
    arr.foldLeft(0.0d){ case(a,b) => a+b}/arr.length

  // TODO: Check if the array contains any duplicate elements
  // Example: Array(1,2,3,1) => true, Array(1,2,3) => false
  // Time: O(n), Space: O(n). Hint: use a Set - if set size < array length, duplicates exist. Or use .distinct.length
  def containsDuplicate(arr: Array[Int]): Boolean =
    arr.toSet.size != arr.size

  // TODO: Find the second largest element in the array
  // Assume array has at least 2 distinct elements
  // Example: Array(3,1,4,1,5,9) => 5
  // Time: O(n), Space: O(1). Hint: track two variables (max, secondMax) in a single pass, or use .distinct.sorted and take second from end
  def secondLargest(arr: Array[Int]): Int = {
    val (_, max2) = arr.foldLeft((Int.MinValue,Int.MinValue)){ case ((first, second), value) =>
      if (value > first) (value, first)
      else if (value > second && value != first) (first, value)
      else (first, second)
    }
    max2
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: reverseArray
    assert(reverseArray(Array(1, 2, 3, 4, 5)).toSeq == Seq(5, 4, 3, 2, 1))
    assert(reverseArray(Array(1)).toSeq == Seq(1))
    assert(reverseArray(Array.empty[Int]).toSeq == Seq.empty)
    println("Exercise 1 passed: reverseArray")

    // Exercise 2: rotateArray
    assert(rotateArray(Array(1, 2, 3, 4, 5), 2).toSeq == Seq(4, 5, 1, 2, 3))
    assert(rotateArray(Array(1, 2, 3), 0).toSeq == Seq(1, 2, 3))
    assert(rotateArray(Array(1, 2, 3), 3).toSeq == Seq(1, 2, 3))
    println("Exercise 2 passed: rotateArray")

    // Exercise 3: findMax
    assert(findMax(Array(3, 1, 4, 1, 5, 9)) == 9)
    assert(findMax(Array(-1, -5, -3)) == -1)
    println("Exercise 3 passed: findMax")

    // Exercise 4: findMin
    assert(findMin(Array(3, 1, 4, 1, 5, 9)) == 1)
    assert(findMin(Array(-1, -5, -3)) == -5)
    println("Exercise 4 passed: findMin")

    // Exercise 5: sumArray
    assert(sumArray(Array(1, 2, 3, 4, 5)) == 15)
    assert(sumArray(Array.empty[Int]) == 0)
    println("Exercise 5 passed: sumArray")

    // Exercise 6: average
    assert(average(Array(1, 2, 3, 4, 5)) == 3.0)
    assert(average(Array(10, 20)) == 15.0)
    println("Exercise 6 passed: average")

    // Exercise 7: containsDuplicate
    assert(containsDuplicate(Array(1, 2, 3, 1)) == true)
    assert(containsDuplicate(Array(1, 2, 3)) == false)
    assert(containsDuplicate(Array.empty[Int]) == false)
    println("Exercise 7 passed: containsDuplicate")

    // Exercise 8: secondLargest
    assert(secondLargest(Array(3, 1, 4, 1, 5, 9)) == 5)
    assert(secondLargest(Array(10, 20)) == 10)
    println("Exercise 8 passed: secondLargest")

    println("All Algo001_ArrayBasics exercises passed!")
  }
}
