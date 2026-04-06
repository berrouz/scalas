package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo009_HashMapPatterns {

  // TODO: Find the intersection of two arrays (common elements, no duplicates in result)
  // Example: Array(1,2,2,1), Array(2,2) => Array(2)
  def intersectionOfArrays(nums1: Array[Int], nums2: Array[Int]): Array[Int] = ???

  // TODO: Find the union of two arrays (all unique elements from both)
  // Example: Array(1,2,3), Array(2,3,4) => Array(1,2,3,4)
  def unionOfArrays(nums1: Array[Int], nums2: Array[Int]): Array[Int] = ???

  // TODO: Find all duplicate elements in the array
  // Return elements that appear more than once
  // Example: Array(4,3,2,7,8,2,3,1) => List(2,3)
  def findDuplicates(nums: Array[Int]): List[Int] = ???

  // TODO: Find the length of the longest consecutive elements sequence
  // Must run in O(n) time using a HashSet
  // Example: Array(100,4,200,1,3,2) => 4 (sequence: 1,2,3,4)
  def longestConsecutiveSequence(nums: Array[Int]): Int = ???

  // TODO: Find the total number of continuous subarrays whose sum equals k
  // Example: Array(1,1,1), k=2 => 2
  def subarraySumEqualsK(nums: Array[Int], k: Int): Int = ???

  // TODO: Return the k most frequent elements from the array
  // Example: Array(1,1,1,2,2,3), k=2 => List(1,2)
  def topKFrequentWords(nums: Array[Int], k: Int): List[Int] = ???

  // TODO: Implement a simple HashMap with put, get, and remove operations
  // Use an array of linked lists (chaining) for collision resolution
  // Return a class/object with methods: put(key, value), get(key): Option[Int], remove(key)
  class SimpleHashMap(capacity: Int = 16) {
    private val buckets: Array[List[(Int, Int)]] = Array.fill(capacity)(List.empty)

    def put(key: Int, value: Int): Unit = ???
    def get(key: Int): Option[Int] = ???
    def remove(key: Int): Unit = ???
  }

  // TODO: Implement a simple LRU Cache with get and put operations
  // get(key): return value if key exists, else -1
  // put(key, value): insert or update, evict least recently used if at capacity
  class LRUCacheSimple(capacity: Int) {
    def get(key: Int): Int = ???
    def put(key: Int, value: Int): Unit = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: intersectionOfArrays
    assert(intersectionOfArrays(Array(1, 2, 2, 1), Array(2, 2)).toSet == Set(2))
    assert(intersectionOfArrays(Array(4, 9, 5), Array(9, 4, 9, 8, 4)).toSet == Set(4, 9))
    println("Exercise 1 passed: intersectionOfArrays")

    // Exercise 2: unionOfArrays
    assert(unionOfArrays(Array(1, 2, 3), Array(2, 3, 4)).toSet == Set(1, 2, 3, 4))
    println("Exercise 2 passed: unionOfArrays")

    // Exercise 3: findDuplicates
    assert(findDuplicates(Array(4, 3, 2, 7, 8, 2, 3, 1)).sorted == List(2, 3))
    assert(findDuplicates(Array(1, 2, 3)) == List())
    println("Exercise 3 passed: findDuplicates")

    // Exercise 4: longestConsecutiveSequence
    assert(longestConsecutiveSequence(Array(100, 4, 200, 1, 3, 2)) == 4)
    assert(longestConsecutiveSequence(Array(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)) == 9)
    println("Exercise 4 passed: longestConsecutiveSequence")

    // Exercise 5: subarraySumEqualsK
    assert(subarraySumEqualsK(Array(1, 1, 1), 2) == 2)
    assert(subarraySumEqualsK(Array(1, 2, 3), 3) == 2)
    println("Exercise 5 passed: subarraySumEqualsK")

    // Exercise 6: topKFrequentWords
    assert(topKFrequentWords(Array(1, 1, 1, 2, 2, 3), 2).toSet == Set(1, 2))
    println("Exercise 6 passed: topKFrequentWords")

    // Exercise 7: SimpleHashMap
    val hm = new SimpleHashMap()
    hm.put(1, 10)
    hm.put(2, 20)
    assert(hm.get(1) == Some(10))
    assert(hm.get(2) == Some(20))
    assert(hm.get(3) == None)
    hm.put(1, 100)
    assert(hm.get(1) == Some(100))
    hm.remove(1)
    assert(hm.get(1) == None)
    println("Exercise 7 passed: SimpleHashMap")

    // Exercise 8: LRUCacheSimple
    val lru = new LRUCacheSimple(2)
    lru.put(1, 1)
    lru.put(2, 2)
    assert(lru.get(1) == 1)
    lru.put(3, 3) // evicts key 2
    assert(lru.get(2) == -1)
    lru.put(4, 4) // evicts key 1
    assert(lru.get(1) == -1)
    assert(lru.get(3) == 3)
    assert(lru.get(4) == 4)
    println("Exercise 8 passed: LRUCacheSimple")

    println("All Algo009_HashMapPatterns exercises passed!")
  }
}
