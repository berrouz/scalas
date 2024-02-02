package org.shev4ik.algorithms.leetcode

object MinCostClimbingStairs extends App {

  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val hash = scala.collection.mutable.HashMap[Int, Int]()
    def hoop(index: Int, c: Int): Int = {
      if (hash.contains(index)) return hash(index)
      if (index >= cost.length) {
        c
      } else {
        hash(index) = hoop(index + 2, c + cost(index))
        hash(index)
      }
    }
    // Math.min(hoop(0, 0),  hoop(1, 0))
    hoop(1, 0)
  }

  minCostClimbingStairs(Array(10, 15, 20))
}
