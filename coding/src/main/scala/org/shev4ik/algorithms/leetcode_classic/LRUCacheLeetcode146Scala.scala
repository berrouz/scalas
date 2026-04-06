package org.shev4ik.algorithms.leetcode_classic

object LRUCacheLeetcode146Scala extends App {

  val cache = new LRUCache(2)

  cache.put(1, 1)
  cache.put(2, 2)
  cache.put(3, 3)
  cache.get(1)

}

class LRUCache(val capacity: Int) {

  private val head: Node = Node(-1, -1)
  private val tail: Node = Node(-1, -1)
  head.next = tail
  tail.prev = head

  private val map = scala.collection.mutable.Map[Int, Node]()

  def put(key: Int, value: Int): Unit = {
    map.get(key) match {
      case Some(node) =>
        remove(node)
        node.value = value
        addToFront(node)
      case None =>
        if (map.size >= capacity) {
          val lru = tail.prev
          remove(lru)
          map -= lru.key
        }
        val node = Node(key, value)
        addToFront(node)
        map(key) = node

    }
  }

  def get(key: Int): Int = {
    map.get(key) match {
      case Some(node) =>
        remove(node)
        addToFront(node)
        node.value
      case None => -1
    }
  }

  private def addToFront(node: Node): Unit = {
    node.next = head.next
    node.prev = head
    head.next.prev = node
    head.next = node
  }

  private def remove(node: Node): Unit = {
    node.prev.next = node.next
    node.next.prev = node.prev
  }

}
case class Node(key: Int, var value: Int, var next: Node = null, var prev: Node = null)
