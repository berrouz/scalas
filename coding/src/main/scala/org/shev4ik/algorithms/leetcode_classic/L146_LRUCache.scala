package org.shev4ik.algorithms.leetcode_classic

import org.shevchyk.leetcode.java

import scala.collection.mutable

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Pattern: Hash Map + Doubly Linked List
 * Time: O(1) for both get and put
 * Space: O(capacity)
 */
object L146_LRUCache {

  class LRUCache(capacity: Int) {

    // TODO: Implement using HashMap + Doubly Linked List
    // Or use LinkedHashMap for simpler solution

    // Doubly linked list node
    private class Node(var key: Int, var value: Int) {
      var prev: Node = null
      var next: Node = null
    }

    private val cache = mutable.HashMap[Int, Node]()
    private val head = new Node(0, 0) // dummy head
    private val tail = new Node(0, 0) // dummy tail
    head.next = tail
    tail.prev = head

    def get(key: Int): Int = {
      // TODO: If key exists, move to front and return value
      // Return -1 if not found
      ???
    }

    def put(key: Int, value: Int): Unit = {
      // TODO: If key exists, update and move to front
      // If new key, add to front
      // If over capacity, remove from back
      ???
    }

    // Helper: remove node from list
    private def remove(node: Node): Unit = {
      node.prev.next = node.next
      node.next.prev = node.prev
    }

    // Helper: add node right after head (most recent)
    private def addToFront(node: Node): Unit = {
      node.next = head.next
      node.prev = head
      head.next.prev = node
      head.next = node
    }
  }

  // Alternative: Using LinkedHashMap (simpler but less educational)
  /*class LRUCacheSimple(capacity: Int) {
    private val cache = new mutable.LinkedHashMap[Int, Int](capacity, 0.75f, true) {
      override def removeEldestEntry(eldest: Entry[Int, Int]): Boolean = {
        size() > capacity
      }
    }

    def get(key: Int): Int = cache.getOrDefault(key, -1)
    def put(key: Int, value: Int): Unit = cache.put(key, value)
  }*/

  def main(args: Array[String]): Unit = {
    val cache = new LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1))    // Expected: 1
    cache.put(3, 3)          // Evicts key 2
    println(cache.get(2))    // Expected: -1 (not found)
    cache.put(4, 4)          // Evicts key 1
    println(cache.get(1))    // Expected: -1 (not found)
    println(cache.get(3))    // Expected: 3
    println(cache.get(4))    // Expected: 4
  }
}
