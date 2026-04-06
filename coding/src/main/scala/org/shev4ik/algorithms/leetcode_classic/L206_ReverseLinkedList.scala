package org.shev4ik.algorithms.leetcode_classic

import _root_.scala.annotation.tailrec

/**
 * 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Pattern: Linked List manipulation
 * Time: O(n)
 * Space: O(1) iterative, O(n) recursive
 */
object L206_ReverseLinkedList {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  // Iterative solution
  def reverseList(head: ListNode): ListNode = {
    // TODO: Implement iteratively
    // Hint: Use three pointers: prev, current, next
    // Reverse links one by one
    ???
  }

  // Recursive solution
  def reverseListRecursive(head: ListNode): ListNode = {
    // TODO: Implement recursively
    // Base case: empty or single node
    // Recursive case: reverse rest, then fix pointers
    ???
  }

  // Tail-recursive solution
  def reverseListTailRec(head: ListNode, prev: ListNode = null): ListNode = {
    // TODO: Implement with tail recursion
    ???
  }

  // Helper to create list from array
  def createList(arr: Array[Int]): ListNode = {
    if (arr.isEmpty) null
    else {
      val head = new ListNode(arr(0))
      var current = head
      for (i <- 1 until arr.length) {
        current.next = new ListNode(arr(i))
        current = current.next
      }
      head
    }
  }

  // Helper to print list
  def printList(head: ListNode): String = {
    val sb = new StringBuilder
    var current = head
    while (current != null) {
      sb.append(current.x)
      if (current.next != null) sb.append(" -> ")
      current = current.next
    }
    sb.toString
  }

  def main(args: Array[String]): Unit = {
    val list = createList(Array(1, 2, 3, 4, 5))
    println(printList(reverseList(list))) // Expected: 5 -> 4 -> 3 -> 2 -> 1
  }
}
