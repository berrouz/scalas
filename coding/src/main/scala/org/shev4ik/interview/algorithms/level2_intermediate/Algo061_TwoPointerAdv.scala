package org.shev4ik.interview.algorithms.level2_intermediate

object Algo061_TwoPointerAdv {

  // Exercise 1: Three Sum — find all unique triplets summing to zero
  // TODO: Sort. Fix first element, use two pointers for remaining two. Skip duplicates.
  def threeSum(nums: Array[Int]): List[List[Int]] = ???

  // Exercise 2: Three Sum Closest — find triplet with sum closest to target
  // TODO: Sort. Fix first, two pointers for rest. Track closest sum.
  def threeSumClosest(nums: Array[Int], target: Int): Int = ???

  // Exercise 3: Four Sum — find all unique quadruplets summing to target
  // TODO: Sort. Fix first two elements, two pointers for remaining two. Skip duplicates at each level.
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = ???

  // Exercise 4: Remove Duplicates from Sorted Array II — allow at most 2 duplicates
  // TODO: Use slow pointer. Copy element if it differs from nums(slow-2).
  def removeDuplicates(nums: Array[Int]): Int = ???

  // Exercise 5: Trapping Rain Water using two pointers
  // TODO: Left and right pointers. Track leftMax and rightMax. Water at position = max - height.
  def trap(height: Array[Int]): Int = ???

  // Exercise 6: Sort Colors — Dutch National Flag (sort array of 0s, 1s, 2s in-place)
  // TODO: Three pointers: low, mid, high. Swap 0s to low, 2s to high, advance mid.
  def sortColors(nums: Array[Int]): Array[Int] = ???

  // Exercise 7: Partition Labels — partition string so each letter appears in at most one part
  // TODO: Record last occurrence of each char. Extend partition end to max last occurrence. Cut at end.
  def partitionLabels(s: String): List[Int] = ???

  // Exercise 8: Boats to Save People — min boats (each holds 2 people, weight limit)
  // TODO: Sort. Pair lightest with heaviest if they fit. Otherwise heaviest alone.
  def numRescueBoats(people: Array[Int], limit: Int): Int = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val triples = threeSum(Array(-1, 0, 1, 2, -1, -4))
    assert(triples.toSet == Set(List(-1, -1, 2), List(-1, 0, 1)), "Three sum")

    // Exercise 2
    assert(threeSumClosest(Array(-1, 2, 1, -4), 1) == 2, "Closest sum to 1 is 2")

    // Exercise 3
    val quads = fourSum(Array(1, 0, -1, 0, -2, 2), 0)
    assert(quads.contains(List(-2, -1, 1, 2)), "Four sum includes [-2,-1,1,2]")

    // Exercise 4
    val arr = Array(1, 1, 1, 2, 2, 3)
    val len = removeDuplicates(arr)
    assert(len == 5, "5 elements after removing excess duplicates")
    assert(arr.take(len).toList == List(1, 1, 2, 2, 3), "Correct elements")

    // Exercise 5
    assert(trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6, "Trap 6 units")

    // Exercise 6
    assert(sortColors(Array(2, 0, 2, 1, 1, 0)).toList == List(0, 0, 1, 1, 2, 2), "Sort colors")

    // Exercise 7
    assert(partitionLabels("ababcbacadefegdehijhklij") == List(9, 7, 8), "Partition labels")

    // Exercise 8
    assert(numRescueBoats(Array(3, 2, 2, 1), 3) == 3, "3 boats needed")
    assert(numRescueBoats(Array(1, 2), 3) == 1, "1 boat for pair")

    println("All Algo061_TwoPointerAdv exercises passed!")
  }
}
