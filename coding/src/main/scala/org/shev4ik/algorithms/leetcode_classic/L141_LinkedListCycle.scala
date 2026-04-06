package org.shev4ik.algorithms.leetcode_classic

import _root_.scala.annotation.tailrec

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * Pattern: Fast and Slow Pointers (Floyd's Algorithm)
 * Time: O(n)
 * Space: O(1)
 */
object L141_LinkedListCycle {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def hasCycle(head: ListNode): Boolean = {
    var slow = head
    var fast = head

    while(fast != null && fast.next != null && slow != null){
      slow = slow.next
      fast = fast.next.next
      if (fast == slow) return true
    }
    false
    // 1 -> 2
  }

  @tailrec
  def hasCycleTailRec(slow: ListNode, fast: ListNode): Boolean = {
    if (fast == null || fast.next ==null)
      false
    else if (slow == fast)
      true
    else
      hasCycleTailRec(slow.next, fast.next.next)
  }

  def main(args: Array[String]): Unit = {
    // Create list with cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
    val head = new ListNode(3)
    val node2 = new ListNode(2)
    val node0 = new ListNode(0)
    val node4 = new ListNode(-4)
    head.next = node2
    node2.next = node0
    node0.next = node4
    node4.next = node2 // cycle

    println(hasCycle(head)) // Expected: true
    println(hasCycleTailRec(head, head.next)) // Expected: true

    // List without cycle
    val head2 = new ListNode(1)
    head2.next = new ListNode(2)
    println(hasCycle(head2)) // Expected: false
    println(hasCycleTailRec(head2, head2.next)) // Expected: false
  }
}
