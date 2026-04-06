package org.shev4ik.algorithms.leetcode_classic

import scala.collection.mutable

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Pattern: Hash Map
 * Time: O(n)
 * Space: O(n)
 */
object L001_TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = mutable.Map.empty[Int, Int]

    nums.zipWithIndex.foreach { case (elem, index) =>
      if (map.contains(target-elem)){
        return Array(map(target-elem), index)
      }
      map += (elem -> index)
    }
    Array()
  }

  def twoSumFunctional(nums: Array[Int], target: Int): Array[Int] = {
    nums.zipWithIndex
      .foldLeft(Map.empty[Int, Int]) { case (map, (num, i)) =>
        map.get(target-num) match {
          case Some(j) => return Array(j,i)
          case None => map + (num -> i)
        }
      }
    Array()
  }

  def main(args: Array[String]): Unit = {
    println(twoSumFunctional(Array(2, 7, 11, 15), 9).mkString(", ")) // Expected: 0, 1
    println(twoSumFunctional(Array(3, 2, 4), 6).mkString(", "))       // Expected: 1, 2
    println(twoSumFunctional(Array(3, 3), 6).mkString(", "))          // Expected: 0, 1
  }
}
