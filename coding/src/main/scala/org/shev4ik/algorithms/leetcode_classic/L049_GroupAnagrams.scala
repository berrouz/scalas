package org.shev4ik.algorithms.leetcode_classic

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together.
 *
 * Pattern: Hash Map with sorted string as key
 * Time: O(n * k log k) where k is max string length
 * Space: O(n * k)
 */
object L049_GroupAnagrams {

  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    // TODO: Implement using HashMap
    // Key: sorted string, Value: list of anagrams
    ???
  }

  // Functional one-liner
  def groupAnagramsFunctional(strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.sorted).values.map(_.toList).toList
  }

  // Using character count as key (faster for long strings)
  def groupAnagramsCount(strs: Array[String]): List[List[String]] = {
    // TODO: Implement using character count array as key
    // Key: "a2b1c3" format or Array[Int] of counts
    ???
  }

  def main(args: Array[String]): Unit = {
    val result = groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))
    result.foreach(group => println(group.mkString(", ")))
    // Expected groups: [eat, tea, ate], [tan, nat], [bat]
  }
}
