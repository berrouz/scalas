package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo012_QueueBasics {

  // TODO: Implement a simple queue using two lists (front and back)
  // Provide enqueue, dequeue, peek, isEmpty
  class SimpleQueue[A] private (private val front: List[A], private val back: List[A]) {
    def enqueue(a: A): SimpleQueue[A] = ???
    def dequeue: (A, SimpleQueue[A]) = ???
    def peek: A = ???
    def isEmpty: Boolean = ???
  }
  object SimpleQueue {
    def empty[A]: SimpleQueue[A] = new SimpleQueue[A](Nil, Nil)
  }

  // TODO: Implement a circular queue with fixed capacity
  // Operations: enQueue, deQueue, front, rear, isEmpty, isFull
  class CircularQueue(capacity: Int) {
    def enQueue(value: Int): Boolean = ???
    def deQueue(): Boolean = ???
    def front(): Int = ???
    def rear(): Int = ???
    def isEmpty: Boolean = ???
    def isFull: Boolean = ???
  }

  // TODO: Implement a deque (double-ended queue) with addFirst, addLast, removeFirst, removeLast
  class SimpleDeque[A] {
    private var elements: List[A] = Nil

    def addFirst(a: A): Unit = ???
    def addLast(a: A): Unit = ???
    def removeFirst(): A = ???
    def removeLast(): A = ???
    def peekFirst(): A = ???
    def peekLast(): A = ???
    def isEmpty: Boolean = ???
  }

  // TODO: Perform BFS level order traversal of a binary tree
  // Represent tree as Option-based case class
  // Return List[List[Int]] where each inner list is a level
  sealed trait BTree
  case class BNode(value: Int, left: Option[BTree], right: Option[BTree]) extends BTree

  def bfsLevelOrder(root: Option[BTree]): List[List[Int]] = ???

  // TODO: Count the number of islands in a 2D grid using BFS
  // '1' = land, '0' = water. An island is surrounded by water and connected horizontally/vertically
  // Example: grid with cluster of 1s => count of connected components
  def numberOfIslandsBFS(grid: Array[Array[Char]]): Int = ???

  // TODO: Given a grid where 2=rotten orange, 1=fresh orange, 0=empty
  // Each minute, rotten oranges rot adjacent fresh oranges
  // Return minutes until no fresh orange remains, or -1 if impossible
  def rottingOranges(grid: Array[Array[Int]]): Int = ???

  // TODO: Fill all rooms (INF = Int.MaxValue) with distance to nearest gate (0)
  // -1 = wall, 0 = gate, INF = empty room
  // Modify grid in place
  def wallsAndGates(rooms: Array[Array[Int]]): Unit = ???

  // TODO: Design a hit counter that counts hits in the past 5 minutes (300 seconds)
  // hit(timestamp): record a hit
  // getHits(timestamp): return total hits in past 300 seconds
  class HitCounter {
    def hit(timestamp: Int): Unit = ???
    def getHits(timestamp: Int): Int = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: SimpleQueue
    val q0 = SimpleQueue.empty[Int]
    assert(q0.isEmpty)
    val q1 = q0.enqueue(1).enqueue(2).enqueue(3)
    val (v1, q2) = q1.dequeue
    assert(v1 == 1)
    val (v2, _) = q2.dequeue
    assert(v2 == 2)
    println("Exercise 1 passed: SimpleQueue")

    // Exercise 2: CircularQueue
    val cq = new CircularQueue(3)
    assert(cq.enQueue(1) == true)
    assert(cq.enQueue(2) == true)
    assert(cq.enQueue(3) == true)
    assert(cq.enQueue(4) == false)
    assert(cq.rear() == 3)
    assert(cq.isFull == true)
    assert(cq.deQueue() == true)
    assert(cq.enQueue(4) == true)
    assert(cq.rear() == 4)
    println("Exercise 2 passed: CircularQueue")

    // Exercise 3: SimpleDeque
    val dq = new SimpleDeque[Int]()
    dq.addFirst(1)
    dq.addLast(2)
    dq.addFirst(0)
    assert(dq.peekFirst() == 0)
    assert(dq.peekLast() == 2)
    assert(dq.removeFirst() == 0)
    assert(dq.removeLast() == 2)
    println("Exercise 3 passed: SimpleDeque")

    // Exercise 4: bfsLevelOrder
    val tree = Some(BNode(3,
      Some(BNode(9, None, None)),
      Some(BNode(20, Some(BNode(15, None, None)), Some(BNode(7, None, None))))
    ))
    assert(bfsLevelOrder(tree) == List(List(3), List(9, 20), List(15, 7)))
    assert(bfsLevelOrder(None) == List())
    println("Exercise 4 passed: bfsLevelOrder")

    // Exercise 5: numberOfIslandsBFS
    val grid5 = Array(
      Array('1','1','1','1','0'),
      Array('1','1','0','1','0'),
      Array('1','1','0','0','0'),
      Array('0','0','0','0','0')
    )
    assert(numberOfIslandsBFS(grid5) == 1)
    println("Exercise 5 passed: numberOfIslandsBFS")

    // Exercise 6: rottingOranges
    val grid6 = Array(Array(2,1,1), Array(1,1,0), Array(0,1,1))
    assert(rottingOranges(grid6) == 4)
    println("Exercise 6 passed: rottingOranges")

    // Exercise 7: wallsAndGates
    val INF = Int.MaxValue
    val rooms = Array(
      Array(INF, -1, 0, INF),
      Array(INF, INF, INF, -1),
      Array(INF, -1, INF, -1),
      Array(0, -1, INF, INF)
    )
    wallsAndGates(rooms)
    assert(rooms(0)(0) == 3)
    assert(rooms(1)(1) == 2)
    println("Exercise 7 passed: wallsAndGates")

    // Exercise 8: HitCounter
    val hc = new HitCounter()
    hc.hit(1)
    hc.hit(2)
    hc.hit(3)
    assert(hc.getHits(4) == 3)
    hc.hit(300)
    assert(hc.getHits(300) == 4)
    assert(hc.getHits(301) == 3)
    println("Exercise 8 passed: HitCounter")

    println("All Algo012_QueueBasics exercises passed!")
  }
}
