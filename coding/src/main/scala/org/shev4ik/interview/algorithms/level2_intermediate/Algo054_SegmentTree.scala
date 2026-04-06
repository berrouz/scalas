package org.shev4ik.interview.algorithms.level2_intermediate

object Algo054_SegmentTree {

  // Exercise 1: Build a segment tree for range sum queries from an array
  // TODO: Build tree array of size 4*n. Recursively split [l,r] and store sum at each node.
  def buildSumTree(nums: Array[Int]): Array[Int] = ???

  // Exercise 2: Range sum query — query sum of elements in [queryL, queryR]
  // TODO: If range fully inside query, return node value. If no overlap, return 0. Else recurse both halves.
  def rangeSumQuery(tree: Array[Int], n: Int, queryL: Int, queryR: Int): Int = ???

  // Exercise 3: Point update — update a single element, propagate through tree
  // TODO: Find leaf for index, update value, propagate sum changes up to root.
  def pointUpdate(tree: Array[Int], n: Int, index: Int, newValue: Int): Unit = ???

  // Exercise 4: Range minimum query — build and query min segment tree
  // TODO: Same structure but store min instead of sum. Return min in [queryL, queryR].
  def buildMinTree(nums: Array[Int]): Array[Int] = ???
  def rangeMinQuery(tree: Array[Int], n: Int, queryL: Int, queryR: Int): Int = ???

  // Exercise 5: Lazy propagation basics — range update with lazy tags
  // TODO: Store pending updates in lazy array. Push down before querying children.
  // Update all elements in [l,r] by adding val. Build tree, update range, query range.
  class LazySegTree(n: Int) {
    val tree: Array[Long] = new Array[Long](4 * n)
    val lazy_ : Array[Long] = new Array[Long](4 * n)
    def build(nums: Array[Int]): Unit = ???
    def rangeUpdate(l: Int, r: Int, value: Long): Unit = ???
    def rangeQuery(l: Int, r: Int): Long = ???
  }

  // Exercise 6: Range update — add a value to all elements in [l, r] using lazy propagation
  // TODO: Use the LazySegTree class above. This exercise tests the update + query together.
  def rangeUpdateAndQuery(nums: Array[Int], updates: List[(Int, Int, Int)], queryL: Int, queryR: Int): Long = ???

  // Exercise 7: Count of smaller numbers after self — for each element, count elements to its right that are smaller
  // TODO: Use segment tree on value range. Process from right. Query count of values < current. Update current.
  def countSmaller(nums: Array[Int]): List[Int] = ???

  // Exercise 8: Interval sum — given a mutable array, support update and range sum
  // TODO: Combine build, update, and query into a simple interface.
  class NumArray(nums: Array[Int]) {
    def update(index: Int, value: Int): Unit = ???
    def sumRange(left: Int, right: Int): Int = ???
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 3, 5, 7, 9, 11)

    // Exercise 1 & 2
    val sumTree = buildSumTree(nums)
    assert(rangeSumQuery(sumTree, nums.length, 1, 3) == 15, "Sum of [1,3] = 3+5+7")

    // Exercise 3
    pointUpdate(sumTree, nums.length, 2, 6) // change 5 -> 6
    assert(rangeSumQuery(sumTree, nums.length, 1, 3) == 16, "Sum after update = 3+6+7")

    // Exercise 4
    val nums2 = Array(2, 5, 1, 4, 9, 3)
    val minTree = buildMinTree(nums2)
    assert(rangeMinQuery(minTree, nums2.length, 0, 3) == 1, "Min of [0,3] = 1")
    assert(rangeMinQuery(minTree, nums2.length, 3, 5) == 3, "Min of [3,5] = 3")

    // Exercise 5 & 6
    val arr = Array(1, 2, 3, 4, 5)
    val result = rangeUpdateAndQuery(arr, List((0, 2, 10)), 0, 4) // add 10 to [0,2]
    assert(result == 45, "Sum after adding 10 to [0,2]: 11+12+13+4+5=45")

    // Exercise 7
    assert(countSmaller(Array(5, 2, 6, 1)) == List(2, 1, 1, 0), "Count smaller after self")

    // Exercise 8
    val na = new NumArray(Array(1, 3, 5))
    assert(na.sumRange(0, 2) == 9, "Sum [0,2] = 9")
    na.update(1, 2)
    assert(na.sumRange(0, 2) == 8, "Sum after update = 8")

    println("All Algo054_SegmentTree exercises passed!")
  }
}
