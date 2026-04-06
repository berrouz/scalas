package org.shev4ik.interview.algorithms.level1_fundamentals

import scala.collection.mutable

object Algo008_HashMapBasics {

  // TODO: Given an array and a target, return indices of two numbers that add up to target
  // Use a HashMap for O(n) solution
  // Example: Array(2,7,11,15), target=9 => (0,1) because 2+7=9
  def twoSum(nums: Array[Int], target: Int): (Int, Int) = {
    val map = mutable.Map[Int, Int]()
    for(i <- nums.indices){
      val value = target - nums(i)
      if (map.contains(value)){
        return (map(value), i)
      }
      map += (nums(i)-> i)
    }
    (0,0)
  }

  // TODO: Count the frequency of each element and return as a Map
  // Example: Array(1,2,2,3,3,3) => Map(1->1, 2->2, 3->3)
  def frequencyCount(arr: Array[Int]): Map[Int, Int] = {
    arr.foldLeft(Map[Int, Int]()){
      case (map, elem) => map + (elem -> (map.getOrElse(elem, 0) + 1))
    }
  }

  // TODO: Find the first non-repeating element in the array
  // Return Option[Int]
  // Example: Array(2,3,4,2,3,5,4) => Some(5)
  def firstNonRepeating(arr: Array[Int]): Option[Int] = ???

  // TODO: Group strings that are anagrams of each other
  // Example: Array("eat","tea","tan","ate","nat","bat") =>
  //   List(List("eat","tea","ate"), List("tan","nat"), List("bat"))
  // Order within groups and order of groups doesn't matter
  def groupAnagrams(strs: Array[String]): List[List[String]] = ???

  // TODO: Determine if a 9x9 Sudoku board is valid (only filled cells need validation)
  // Each row, column, and 3x3 box must contain digits 1-9 without repetition
  // '.' represents empty cells. Board is represented as Array[Array[Char]]
  def validSudoku(board: Array[Array[Char]]): Boolean = ???

  // TODO: Check if the array contains two distinct indices i and j such that
  // nums(i) == nums(j) and abs(i - j) <= k
  // Example: Array(1,2,3,1), k=3 => true
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = ???

  // TODO: Check if two strings are isomorphic
  // Two strings are isomorphic if characters in s can be replaced to get t
  // with a consistent one-to-one mapping
  // Example: "egg", "add" => true, "foo", "bar" => false
  def isomorphicStrings(s: String, t: String): Boolean = ???

  // TODO: Check if a string follows the given pattern
  // Example: pattern="abba", s="dog cat cat dog" => true
  // Example: pattern="abba", s="dog cat cat fish" => false
  def wordPattern(pattern: String, s: String): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: twoSum
    val ts = twoSum(Array(2, 7, 11, 15), 9)
    assert(ts == (0, 1) || ts == (1, 0))
    println("Exercise 1 passed: twoSum")

    // Exercise 2: frequencyCount
    assert(frequencyCount(Array(1, 2, 2, 3, 3, 3)) == Map(1 -> 1, 2 -> 2, 3 -> 3))
    assert(frequencyCount(Array.empty[Int]) == Map.empty)
    println("Exercise 2 passed: frequencyCount")

    // Exercise 3: firstNonRepeating
    assert(firstNonRepeating(Array(2, 3, 4, 2, 3, 5, 4)) == Some(5))
    assert(firstNonRepeating(Array(1, 1, 2, 2)) == None)
    println("Exercise 3 passed: firstNonRepeating")

    // Exercise 4: groupAnagrams
    val ga = groupAnagrams(Array("eat", "tea", "tan", "ate", "nat", "bat"))
    assert(ga.map(_.sorted).toSet == Set(List("ate", "eat", "tea"), List("nat", "tan"), List("bat")))
    println("Exercise 4 passed: groupAnagrams")

    // Exercise 5: validSudoku
    val validBoard = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','.'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )
    assert(validSudoku(validBoard) == true)
    println("Exercise 5 passed: validSudoku")

    // Exercise 6: containsNearbyDuplicate
    assert(containsNearbyDuplicate(Array(1, 2, 3, 1), 3) == true)
    assert(containsNearbyDuplicate(Array(1, 2, 3, 1, 2, 3), 2) == false)
    println("Exercise 6 passed: containsNearbyDuplicate")

    // Exercise 7: isomorphicStrings
    assert(isomorphicStrings("egg", "add") == true)
    assert(isomorphicStrings("foo", "bar") == false)
    assert(isomorphicStrings("paper", "title") == true)
    println("Exercise 7 passed: isomorphicStrings")

    // Exercise 8: wordPattern
    assert(wordPattern("abba", "dog cat cat dog") == true)
    assert(wordPattern("abba", "dog cat cat fish") == false)
    assert(wordPattern("aaaa", "dog cat cat dog") == false)
    println("Exercise 8 passed: wordPattern")

    println("All Algo008_HashMapBasics exercises passed!")
  }
}
