package org.shev4ik.interview.algorithms.level1_fundamentals

import scala.collection.mutable

object Algo027_FrequencyCount {

  // TODO: Return the k most frequent elements from the array
  // Example: Array(1,1,1,2,2,3), k=2 => List(1,2)
  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    val freqMap = mutable.Map[Int, Int]()
    for (n <- nums) {
      freqMap(n) = freqMap.getOrElse(n, 0) + 1
    }
    val pq = new mutable.PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](_._2))
    for ((num, freq) <- freqMap) {
      pq.enqueue((num, freq))
    }
    (1 to k).map(_ => pq.dequeue()._1).toList
  }

  // TODO: Find the majority element (appears more than n/2 times)
  // Use Boyer-Moore voting algorithm
  // Example: Array(3,2,3) => 3
  def majorityElement(nums: Array[Int]): Int = {
    var count = 0
    var candidate = 0

    for (n <- nums) {
      if (count == 0) {
        candidate = n
        count = 1
      } else if (n == candidate) {
        count += 1
      } else {
        count -= 1
      }
    }

    candidate
  }

  // TODO: Find all elements that appear more than n/3 times
  // Example: Array(3,2,3) => List(3), Array(1,2) => List(1,2)
  def majorityElementII(nums: Array[Int]): List[Int] = {
    var candidate1: Option[Int] = None
    var candidate2: Option[Int] = None
    var count1 = 0
    var count2 = 0
    for (num <- nums){
      if (candidate1.contains(num)){
        count1 += 1
      } else if (candidate2.contains(num)){
        count2 += 1
      } else if (count1 == 0){
        candidate1 = Some(num)
        count1 = 1
      } else if (count2 == 0){
        candidate2 = Some(num)
        count2 = 1
      } else {
        count1 -= 1
        count2 -= 1

      }
    }
    val n = nums.length
    val result = scala.collection.mutable.ListBuffer[Int]()
    candidate1.foreach(c => if (nums.count(_ == c) > n/3) result += c)
    candidate2.foreach(c => if (nums.count(_ == c) > n/3) result += c)
    result.toList
  }

  // TODO: Sort characters in a string by their frequency (most frequent first)
  // Example: "tree" => "eert" or "eetr"
  def sortCharsByFrequency(s: String): String = {
    val map = mutable.Map[Char, Int]()
    for(c <- s){
      map(c) = map.getOrElse(c, 0) + 1
    }

    val q = mutable.PriorityQueue[(Char, Int)]()(Ordering.by[(Char, Int), Int](_._2))

    for((c, count) <- map){
      q.enqueue((c, count))
    }

    var buffer = mutable.ListBuffer[String]()
    for ((c,count) <- q.dequeueAll){
      buffer.append(c.toString*count)
    }
    buffer.mkString
  }

  // TODO: Find the first unique character in a string and return its index
  // Return -1 if no unique character exists
  // Example: "leetcode" => 0, "aabb" => -1
  def firstUniqueCharacter(s: String): Int = ???

  // TODO: Find the minimum window substring of s that contains all characters of t
  // Example: s="ADOBECODEBANC", t="ABC" => "BANC"
  def minimumWindowSubstring(s: String, t: String): String = ???

  // TODO: Find all start indices of anagrams of pattern p in string s
  // Example: s="cbaebabacd", p="abc" => List(0,6)
  def findAllAnagrams(s: String, p: String): List[Int] = ???

  // TODO: Return the k most frequent strings from the array
  // If two strings have the same frequency, sort lexicographically
  // Example: Array("i","love","leetcode","i","love","coding"), k=2 => List("i","love")
  def kMostFrequentStrings(words: Array[String], k: Int): List[String] = {
    val freqMap = mutable.Map[String, Int]()
    for (word <- words) {
      freqMap(word) = freqMap.getOrElse(word, 0) + 1
    }
    val q = mutable.PriorityQueue[(String, Int)]()(Ordering.by[(String, Int), (Int, String)]{
      case (word, freq) => (freq, word)
    }.reverse)

    for ((word, freq) <- freqMap) {
      q.enqueue((word, freq))
      if (q.size > k) q.dequeue()
    }
    q.dequeueAll.reverse.map(_._1).toList
  }


  def main(args: Array[String]): Unit = {
    // Exercise 1: topKFrequent
    assert(topKFrequent(Array(1, 1, 1, 2, 2, 3), 2).toSet == Set(1, 2))
    println("Exercise 1 passed: topKFrequent")

    // Exercise 2: majorityElement
    assert(majorityElement(Array(3, 2, 3)) == 3)
    assert(majorityElement(Array(2, 2, 1, 1, 1, 2, 2)) == 2)
    println("Exercise 2 passed: majorityElement")

    // Exercise 3: majorityElementII
    assert(majorityElementII(Array(3, 2, 3)).sorted == List(3))
    assert(majorityElementII(Array(1, 2)).sorted == List(1, 2))
    println("Exercise 3 passed: majorityElementII")

    // Exercise 4: sortCharsByFrequency
    val scf = sortCharsByFrequency("tree")
    assert(scf.startsWith("ee"))
    assert(scf.length == 4)
    println("Exercise 4 passed: sortCharsByFrequency")

    // Exercise 5: firstUniqueCharacter
    assert(firstUniqueCharacter("leetcode") == 0)
    assert(firstUniqueCharacter("aabb") == -1)
    println("Exercise 5 passed: firstUniqueCharacter")

    // Exercise 6: minimumWindowSubstring
    assert(minimumWindowSubstring("ADOBECODEBANC", "ABC") == "BANC")
    assert(minimumWindowSubstring("a", "aa") == "")
    println("Exercise 6 passed: minimumWindowSubstring")

    // Exercise 7: findAllAnagrams
    assert(findAllAnagrams("cbaebabacd", "abc") == List(0, 6))
    assert(findAllAnagrams("abab", "ab") == List(0, 1, 2))
    println("Exercise 7 passed: findAllAnagrams")

    // Exercise 8: kMostFrequentStrings
    assert(kMostFrequentStrings(Array("i","love","leetcode","i","love","coding"), 2) == List("i", "love"))
    println("Exercise 8 passed: kMostFrequentStrings")

    println("All Algo027_FrequencyCount exercises passed!")
  }
}
