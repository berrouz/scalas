package org.shev4ik.algorithms.leetcode_classic

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a sorted list.
 *
 * Pattern: Two Pointers / Recursion
 * Time: O(n + m)
 * Space: O(1) iterative, O(n + m) recursive
 */
object L021_MergeTwoSortedLists {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  // Iterative solution
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    // TODO: Implement iteratively
    // Hint: Use dummy head, compare and link smaller node
    ???
  }

  // Recursive solution
  def mergeTwoListsRecursive(list1: ListNode, list2: ListNode): ListNode = {
    // TODO: Implement recursively
    // Hint: Compare heads, recursively merge rest
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
    val l1 = createList(Array(1, 2, 4))
    val l2 = createList(Array(1, 3, 4))
    println(printList(mergeTwoLists(l1, l2))) // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4
  }
}
