package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo026_PrefixSum {

  // TODO: Implement range sum query — precompute prefix sums, then answer sumRange(i, j) in O(1)
  // Example: nums=Array(-2,0,3,-5,2,-1), sumRange(0,2)=1, sumRange(2,5)=-1
  class RangeSumQuery(nums: Array[Int]) {
    def sumRange(i: Int, j: Int): Int = ???
  }

  // TODO: Product of array except self — for each index, compute product of all other elements
  // Do not use division. O(n) time.
  // Example: Array(1,2,3,4) => Array(24,12,8,6)
  def productExceptSelf(nums: Array[Int]): Array[Int] = ???

  // TODO: Count subarrays whose sum is divisible by k
  // Example: Array(4,5,0,-2,-3,1), k=5 => 7
  def subarraySumDivisibleByK(nums: Array[Int], k: Int): Int = ???

  // TODO: Find the pivot index where sum of left == sum of right
  // Return -1 if no such index exists. The element at pivot is excluded from both sides.
  // Example: Array(1,7,3,6,5,6) => 3
  def findPivotIndex(nums: Array[Int]): Int = ???

  // TODO: Count subarrays with sum exactly equal to k
  // Example: Array(1,1,1), k=2 => 2
  def countSubarraysWithSum(nums: Array[Int], k: Int): Int = ???

  // TODO: Find minimum size subarray with sum >= target
  // Return 0 if impossible. All positive numbers.
  // Example: Array(2,3,1,2,4,3), target=7 => 2
  def minimumSizeSubarray(nums: Array[Int], target: Int): Int = ???

  // TODO: Check if there exists a continuous subarray of size >= 2 whose sum is a multiple of k
  // Example: Array(23,2,4,6,7), k=6 => true (subarray [2,4] sums to 6)
  def continuousSubarraySum(nums: Array[Int], k: Int): Boolean = ???

  // TODO: Find the maximum subarray sum in a circular array
  // The array is conceptually circular
  // Example: Array(5,-3,5) => 10
  def maxSubarraySumCircular(nums: Array[Int]): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: RangeSumQuery
    val rsq = new RangeSumQuery(Array(-2, 0, 3, -5, 2, -1))
    assert(rsq.sumRange(0, 2) == 1)
    assert(rsq.sumRange(2, 5) == -1)
    assert(rsq.sumRange(0, 5) == -3)
    println("Exercise 1 passed: RangeSumQuery")

    // Exercise 2: productExceptSelf
    assert(productExceptSelf(Array(1, 2, 3, 4)).toSeq == Seq(24, 12, 8, 6))
    assert(productExceptSelf(Array(-1, 1, 0, -3, 3)).toSeq == Seq(0, 0, 9, 0, 0))
    println("Exercise 2 passed: productExceptSelf")

    // Exercise 3: subarraySumDivisibleByK
    assert(subarraySumDivisibleByK(Array(4, 5, 0, -2, -3, 1), 5) == 7)
    println("Exercise 3 passed: subarraySumDivisibleByK")

    // Exercise 4: findPivotIndex
    assert(findPivotIndex(Array(1, 7, 3, 6, 5, 6)) == 3)
    assert(findPivotIndex(Array(1, 2, 3)) == -1)
    println("Exercise 4 passed: findPivotIndex")

    // Exercise 5: countSubarraysWithSum
    assert(countSubarraysWithSum(Array(1, 1, 1), 2) == 2)
    assert(countSubarraysWithSum(Array(1, 2, 3), 3) == 2)
    println("Exercise 5 passed: countSubarraysWithSum")

    // Exercise 6: minimumSizeSubarray
    assert(minimumSizeSubarray(Array(2, 3, 1, 2, 4, 3), 7) == 2)
    assert(minimumSizeSubarray(Array(1, 1, 1), 10) == 0)
    println("Exercise 6 passed: minimumSizeSubarray")

    // Exercise 7: continuousSubarraySum
    assert(continuousSubarraySum(Array(23, 2, 4, 6, 7), 6) == true)
    assert(continuousSubarraySum(Array(23, 2, 6, 4, 7), 13) == true)
    println("Exercise 7 passed: continuousSubarraySum")

    // Exercise 8: maxSubarraySumCircular
    assert(maxSubarraySumCircular(Array(5, -3, 5)) == 10)
    assert(maxSubarraySumCircular(Array(-3, -2, -1)) == -1)
    println("Exercise 8 passed: maxSubarraySumCircular")

    println("All Algo026_PrefixSum exercises passed!")
  }
}
