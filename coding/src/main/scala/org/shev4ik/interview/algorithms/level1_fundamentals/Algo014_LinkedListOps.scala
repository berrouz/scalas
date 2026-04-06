package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo014_LinkedListOps {

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

  // TODO: Detect if a linked list has a cycle
  // Use Floyd's tortoise and hare algorithm
  // Return true if cycle exists
  def detectCycle(head: ListNode): Boolean = ???

  // TODO: Find the node where the cycle begins
  // Return null if no cycle exists
  def findCycleStart(head: ListNode): ListNode = ???

  // TODO: Remove the nth node from the end of the list
  // Example: 1->2->3->4->5, n=2 => 1->2->3->5
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = ???

  // TODO: Merge two sorted linked lists into one sorted list
  // Example: 1->2->4 and 1->3->4 => 1->1->2->3->4->4
  def mergeTwoSorted(l1: ListNode, l2: ListNode): ListNode = ???

  // TODO: Find the intersection node of two linked lists
  // Return the node where the two lists merge, or null if they don't
  def intersectionPoint(headA: ListNode, headB: ListNode): ListNode = ???

  // TODO: Check if a linked list is a palindrome
  // Example: 1->2->2->1 => true, 1->2->3 => false
  def isPalindromeList(head: ListNode): Boolean = ???

  // TODO: Flatten a multilevel doubly linked list (simplified as nested lists)
  // Given a list where each node may have a "child" pointer to another list,
  // flatten everything into a single-level list
  // For simplicity, represent as nested List[Any] and flatten to List[Int]
  // Example: List(1, List(2, 3), 4) => List(1, 2, 3, 4)
  def flattenMultilevel(nested: List[Any]): List[Int] = ???

  // TODO: Copy a linked list where each node has a random pointer
  // Simplified: given a map of index -> randomIndex, and a list,
  // return a deep copy preserving the random pointer structure
  // Represent as (Array[Int], Array[Int]) => values and random indices (-1 for null)
  // Return the copied values in order (random pointers verified separately)
  class NodeWithRandom(var value: Int, var next: NodeWithRandom = null, var random: NodeWithRandom = null)

  def copyRandomList(head: NodeWithRandom): NodeWithRandom = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: detectCycle
    val cycleList = fromArray(Array(3, 2, 0, -4))
    // Create cycle: last node points to second node
    var curr = cycleList
    var second: ListNode = null
    var idx = 0
    while (curr.next != null) {
      if (idx == 1) second = curr
      curr = curr.next
      idx += 1
    }
    curr.next = second // cycle at node with value 2
    assert(detectCycle(cycleList) == true)
    assert(detectCycle(fromArray(Array(1, 2, 3))) == false)
    println("Exercise 1 passed: detectCycle")

    // Exercise 2: findCycleStart
    assert(findCycleStart(cycleList).value == 2)
    assert(findCycleStart(fromArray(Array(1, 2, 3))) == null)
    println("Exercise 2 passed: findCycleStart")

    // Exercise 3: removeNthFromEnd
    assert(toArray(removeNthFromEnd(fromArray(Array(1, 2, 3, 4, 5)), 2)).toSeq == Seq(1, 2, 3, 5))
    assert(toArray(removeNthFromEnd(fromArray(Array(1)), 1)).toSeq == Seq())
    println("Exercise 3 passed: removeNthFromEnd")

    // Exercise 4: mergeTwoSorted
    assert(toArray(mergeTwoSorted(fromArray(Array(1, 2, 4)), fromArray(Array(1, 3, 4)))).toSeq == Seq(1, 1, 2, 3, 4, 4))
    assert(toArray(mergeTwoSorted(null, fromArray(Array(1, 2)))).toSeq == Seq(1, 2))
    println("Exercise 4 passed: mergeTwoSorted")

    // Exercise 5: intersectionPoint
    val shared = fromArray(Array(8, 4, 5))
    val a5 = new ListNode(4, new ListNode(1, shared))
    val b5 = new ListNode(5, new ListNode(6, new ListNode(1, shared)))
    assert(intersectionPoint(a5, b5) == shared)
    assert(intersectionPoint(fromArray(Array(1, 2)), fromArray(Array(3, 4))) == null)
    println("Exercise 5 passed: intersectionPoint")

    // Exercise 6: isPalindromeList
    assert(isPalindromeList(fromArray(Array(1, 2, 2, 1))) == true)
    assert(isPalindromeList(fromArray(Array(1, 2, 3))) == false)
    println("Exercise 6 passed: isPalindromeList")

    // Exercise 7: flattenMultilevel
    assert(flattenMultilevel(List(1, List(2, 3), 4)) == List(1, 2, 3, 4))
    assert(flattenMultilevel(List(1, List(2, List(3, 4)), 5)) == List(1, 2, 3, 4, 5))
    println("Exercise 7 passed: flattenMultilevel")

    // Exercise 8: copyRandomList
    val n1 = new NodeWithRandom(1)
    val n2 = new NodeWithRandom(2)
    n1.next = n2
    n1.random = n2
    n2.random = n1
    val copy = copyRandomList(n1)
    assert(copy.value == 1)
    assert(copy.next.value == 2)
    assert(copy.random.value == 2)
    assert(copy.next.random.value == 1)
    assert(copy ne n1) // must be a deep copy
    println("Exercise 8 passed: copyRandomList")

    println("All Algo014_LinkedListOps exercises passed!")
  }
}
