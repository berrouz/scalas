package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo015_LinkedListMerge {

  class ListNode(var value: Int, var next: ListNode = null)

  def fromArray(arr: Array[Int]): ListNode = {
    if (arr.isEmpty) return null
    val head = new ListNode(arr(0))
    var curr = head
    for (i <- 1 until arr.length) {
      curr.next = new ListNode(arr(i))
      curr = curr.next
    }
    head
  }

  def toArray(head: ListNode): Array[Int] = {
    val buf = scala.collection.mutable.ArrayBuffer[Int]()
    var curr = head
    while (curr != null) {
      buf += curr.value
      curr = curr.next
    }
    buf.toArray
  }

  // TODO: Sort a linked list using merge sort in O(n log n) time
  // Example: 4->2->1->3 => 1->2->3->4
  def sortLinkedList(head: ListNode): ListNode = ???

  // TODO: Reorder list: L0->L1->...->Ln => L0->Ln->L1->Ln-1->...
  // Example: 1->2->3->4 => 1->4->2->3
  // Example: 1->2->3->4->5 => 1->5->2->4->3
  def reorderList(head: ListNode): Unit = ???

  // TODO: Partition list around value x: all nodes < x come before nodes >= x
  // Preserve original relative order within each partition
  // Example: 1->4->3->2->5->2, x=3 => 1->2->2->4->3->5
  def partitionList(head: ListNode, x: Int): ListNode = ???

  // TODO: Add two numbers represented by linked lists (digits in reverse order)
  // Example: 2->4->3 + 5->6->4 => 7->0->8 (342 + 465 = 807)
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = ???

  // TODO: Swap every two adjacent nodes
  // Example: 1->2->3->4 => 2->1->4->3
  def swapPairs(head: ListNode): ListNode = ???

  // TODO: Remove duplicates from a sorted linked list (keep one of each)
  // Example: 1->1->2->3->3 => 1->2->3
  def removeDuplicatesSorted(head: ListNode): ListNode = ???

  // TODO: Remove all nodes that have duplicate numbers (keep none of them)
  // Example: 1->2->3->3->4->4->5 => 1->2->5
  def removeDuplicatesAll(head: ListNode): ListNode = ???

  // TODO: Reverse nodes in k-group
  // Example: 1->2->3->4->5, k=2 => 2->1->4->3->5
  // Example: 1->2->3->4->5, k=3 => 3->2->1->4->5
  def reverseKGroup(head: ListNode, k: Int): ListNode = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: sortLinkedList
    assert(toArray(sortLinkedList(fromArray(Array(4, 2, 1, 3)))).toSeq == Seq(1, 2, 3, 4))
    assert(toArray(sortLinkedList(fromArray(Array(-1, 5, 3, 4, 0)))).toSeq == Seq(-1, 0, 3, 4, 5))
    println("Exercise 1 passed: sortLinkedList")

    // Exercise 2: reorderList
    val rl = fromArray(Array(1, 2, 3, 4))
    reorderList(rl)
    assert(toArray(rl).toSeq == Seq(1, 4, 2, 3))
    val rl2 = fromArray(Array(1, 2, 3, 4, 5))
    reorderList(rl2)
    assert(toArray(rl2).toSeq == Seq(1, 5, 2, 4, 3))
    println("Exercise 2 passed: reorderList")

    // Exercise 3: partitionList
    assert(toArray(partitionList(fromArray(Array(1, 4, 3, 2, 5, 2)), 3)).toSeq == Seq(1, 2, 2, 4, 3, 5))
    println("Exercise 3 passed: partitionList")

    // Exercise 4: addTwoNumbers
    assert(toArray(addTwoNumbers(fromArray(Array(2, 4, 3)), fromArray(Array(5, 6, 4)))).toSeq == Seq(7, 0, 8))
    assert(toArray(addTwoNumbers(fromArray(Array(9, 9, 9)), fromArray(Array(1)))).toSeq == Seq(0, 0, 0, 1))
    println("Exercise 4 passed: addTwoNumbers")

    // Exercise 5: swapPairs
    assert(toArray(swapPairs(fromArray(Array(1, 2, 3, 4)))).toSeq == Seq(2, 1, 4, 3))
    assert(toArray(swapPairs(fromArray(Array(1, 2, 3)))).toSeq == Seq(2, 1, 3))
    println("Exercise 5 passed: swapPairs")

    // Exercise 6: removeDuplicatesSorted
    assert(toArray(removeDuplicatesSorted(fromArray(Array(1, 1, 2, 3, 3)))).toSeq == Seq(1, 2, 3))
    println("Exercise 6 passed: removeDuplicatesSorted")

    // Exercise 7: removeDuplicatesAll
    assert(toArray(removeDuplicatesAll(fromArray(Array(1, 2, 3, 3, 4, 4, 5)))).toSeq == Seq(1, 2, 5))
    assert(toArray(removeDuplicatesAll(fromArray(Array(1, 1, 1, 2, 3)))).toSeq == Seq(2, 3))
    println("Exercise 7 passed: removeDuplicatesAll")

    // Exercise 8: reverseKGroup
    assert(toArray(reverseKGroup(fromArray(Array(1, 2, 3, 4, 5)), 2)).toSeq == Seq(2, 1, 4, 3, 5))
    assert(toArray(reverseKGroup(fromArray(Array(1, 2, 3, 4, 5)), 3)).toSeq == Seq(3, 2, 1, 4, 5))
    println("Exercise 8 passed: reverseKGroup")

    println("All Algo015_LinkedListMerge exercises passed!")
  }
}
