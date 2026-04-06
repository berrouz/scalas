package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo013_LinkedListBasics {

  // Shared mutable ListNode for linked list exercises
  class ListNode(var value: Int, var next: ListNode = null) {
    override def toString: String = {
      val sb = new StringBuilder
      var curr: ListNode = this
      while (curr != null) {
        sb.append(curr.value)
        if (curr.next != null) sb.append(" -> ")
        curr = curr.next
      }
      sb.toString
    }
  }

  // Helper to create a linked list from an array
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

  // Helper to convert linked list to array
  def toArray(head: ListNode): Array[Int] = {
    val buf = scala.collection.mutable.ArrayBuffer[Int]()
    var curr = head
    while (curr != null) {
      buf += curr.value
      curr = curr.next
    }
    buf.toArray
  }

  // TODO: Insert a new node with given value at the head of the list
  // Return the new head
  def insertAtHead(head: ListNode, value: Int): ListNode = ???

  // TODO: Insert a new node with given value at the tail of the list
  // Return the head (unchanged if list was non-empty)
  def insertAtTail(head: ListNode, value: Int): ListNode = ???

  // TODO: Delete the first occurrence of a node with the given value
  // Return the head of the modified list
  def deleteNode(head: ListNode, value: Int): ListNode = ???

  // TODO: Search for a value in the linked list
  // Return true if found, false otherwise
  def search(head: ListNode, value: Int): Boolean = ???

  // TODO: Get the length of the linked list
  def getLength(head: ListNode): Int = ???

  // TODO: Reverse the linked list iteratively
  // Return the new head
  def reverse(head: ListNode): ListNode = ???

  // TODO: Find the middle node of the linked list
  // If even number of nodes, return the second middle
  // Example: 1->2->3->4->5 => node with value 3
  // Example: 1->2->3->4 => node with value 3
  def getMiddle(head: ListNode): ListNode = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: insertAtHead
    val list1 = fromArray(Array(2, 3, 4))
    val newHead1 = insertAtHead(list1, 1)
    assert(toArray(newHead1).toSeq == Seq(1, 2, 3, 4))
    assert(toArray(insertAtHead(null, 5)).toSeq == Seq(5))
    println("Exercise 1 passed: insertAtHead")

    // Exercise 2: insertAtTail
    val list2 = fromArray(Array(1, 2, 3))
    val newHead2 = insertAtTail(list2, 4)
    assert(toArray(newHead2).toSeq == Seq(1, 2, 3, 4))
    assert(toArray(insertAtTail(null, 1)).toSeq == Seq(1))
    println("Exercise 2 passed: insertAtTail")

    // Exercise 3: deleteNode
    val list3 = fromArray(Array(1, 2, 3, 4))
    assert(toArray(deleteNode(list3, 3)).toSeq == Seq(1, 2, 4))
    val list3b = fromArray(Array(1, 2, 3))
    assert(toArray(deleteNode(list3b, 1)).toSeq == Seq(2, 3))
    println("Exercise 3 passed: deleteNode")

    // Exercise 4: search
    val list4 = fromArray(Array(1, 2, 3, 4, 5))
    assert(search(list4, 3) == true)
    assert(search(list4, 6) == false)
    assert(search(null, 1) == false)
    println("Exercise 4 passed: search")

    // Exercise 5: getLength
    assert(getLength(fromArray(Array(1, 2, 3, 4))) == 4)
    assert(getLength(null) == 0)
    println("Exercise 5 passed: getLength")

    // Exercise 6: reverse
    val list6 = fromArray(Array(1, 2, 3, 4, 5))
    assert(toArray(reverse(list6)).toSeq == Seq(5, 4, 3, 2, 1))
    assert(reverse(null) == null)
    println("Exercise 6 passed: reverse")

    // Exercise 7: getMiddle
    val list7a = fromArray(Array(1, 2, 3, 4, 5))
    assert(getMiddle(list7a).value == 3)
    val list7b = fromArray(Array(1, 2, 3, 4))
    assert(getMiddle(list7b).value == 3)
    println("Exercise 7 passed: getMiddle")

    println("All Algo013_LinkedListBasics exercises passed!")
  }
}
