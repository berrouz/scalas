package org.shev4ik.interview.algorithms.level2_intermediate

object Algo055_BIT {

  // Exercise 1: Build a Binary Indexed Tree (Fenwick Tree) from an array
  // TODO: Initialize BIT of size n+1. For each element, call update to add value.
  def buildBIT(nums: Array[Int]): Array[Int] = ???

  // Exercise 2: Point update — add delta to element at index
  // TODO: Starting at index+1, add delta, move to parent: i += i & (-i).
  def update(bit: Array[Int], index: Int, delta: Int): Unit = ???

  // Exercise 3: Prefix sum query — sum of elements [0, index]
  // TODO: Starting at index+1, accumulate sum, move to parent: i -= i & (-i).
  def prefixSum(bit: Array[Int], index: Int): Int = ???

  // Exercise 4: Range sum query — sum of elements [left, right]
  // TODO: prefixSum(right) - prefixSum(left - 1). Handle left = 0 edge case.
  def rangeSum(bit: Array[Int], left: Int, right: Int): Int = ???

  // Exercise 5: Count inversions in an array (pairs where i < j but nums(i) > nums(j))
  // TODO: Process from right. For each element, query BIT for count of elements < current. Update BIT.
  def countInversions(nums: Array[Int]): Long = ???

  // Exercise 6: Range update with BIT — add value to all elements in [l, r], then point query
  // TODO: Use difference array concept with BIT. update(l, val), update(r+1, -val). Point query = prefixSum.
  class RangeUpdateBIT(n: Int) {
    val bit: Array[Int] = new Array[Int](n + 2)
    def rangeUpdate(l: Int, r: Int, value: Int): Unit = ???
    def pointQuery(index: Int): Int = ???
  }

  // Exercise 7: 2D BIT concept — support point update and rectangle sum query
  // TODO: Extend BIT to 2D. Update and query use nested loops over both dimensions.
  class BIT2D(rows: Int, cols: Int) {
    val bit: Array[Array[Int]] = Array.fill(rows + 1)(new Array[Int](cols + 1))
    def update(row: Int, col: Int, delta: Int): Unit = ???
    def query(row: Int, col: Int): Int = ???
    def rangeQuery(r1: Int, c1: Int, r2: Int, c2: Int): Int = ???
  }

  // Exercise 8: Count of Smaller Numbers After Self using BIT
  // TODO: Coordinate compress values. Process from right. Query BIT for count of smaller values. Update BIT.
  def countSmaller(nums: Array[Int]): List[Int] = ???

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 3, 5, 7, 9)

    // Exercise 1 & 2 & 3
    val bit = buildBIT(nums)
    assert(prefixSum(bit, 2) == 9, "Prefix sum [0,2] = 1+3+5")
    assert(prefixSum(bit, 4) == 25, "Prefix sum [0,4] = 25")

    // Exercise 2 - update
    update(bit, 2, 1) // 5 -> 6
    assert(prefixSum(bit, 2) == 10, "Prefix sum after update = 1+3+6")

    // Exercise 4
    assert(rangeSum(bit, 1, 3) == 16, "Range sum [1,3] = 3+6+7")

    // Exercise 5
    assert(countInversions(Array(2, 4, 1, 3, 5)) == 3, "3 inversions: (2,1),(4,1),(4,3)")
    assert(countInversions(Array(5, 4, 3, 2, 1)) == 10, "10 inversions in reverse sorted")

    // Exercise 6
    val rub = new RangeUpdateBIT(5)
    rub.rangeUpdate(1, 3, 10)
    assert(rub.pointQuery(2) == 10, "Point query after range update")
    assert(rub.pointQuery(0) == 0, "Outside range")

    // Exercise 7
    val bit2d = new BIT2D(3, 3)
    bit2d.update(0, 0, 1)
    bit2d.update(1, 1, 2)
    bit2d.update(2, 2, 3)
    assert(bit2d.rangeQuery(0, 0, 2, 2) == 6, "2D range query sum = 6")

    // Exercise 8
    assert(countSmaller(Array(5, 2, 6, 1)) == List(2, 1, 1, 0), "Count smaller after self")

    println("All Algo055_BIT exercises passed!")
  }
}
