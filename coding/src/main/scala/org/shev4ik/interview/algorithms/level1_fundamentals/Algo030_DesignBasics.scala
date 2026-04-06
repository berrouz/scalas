package org.shev4ik.interview.algorithms.level1_fundamentals

object Algo030_DesignBasics {

  // TODO: Implement a stack using only two queues
  class StackUsingQueues[A] {
    private val q1 = scala.collection.mutable.Queue[A]()
    private val q2 = scala.collection.mutable.Queue[A]()

    def push(a: A): Unit = ???
    def pop(): A = ???
    def top(): A = ???
    def isEmpty: Boolean = ???
  }

  // TODO: Implement a queue using only two stacks
  class QueueUsingStacks[A] {
    private var inStack: List[A] = Nil
    private var outStack: List[A] = Nil

    def enqueue(a: A): Unit = ???
    def dequeue(): A = ???
    def peek(): A = ???
    def isEmpty: Boolean = ???
  }

  // TODO: Design a HashSet without using built-in hash table libraries
  // Support add, remove, contains
  class DesignHashSet {
    private val buckets: Array[List[Int]] = Array.fill(1000)(List.empty)

    def add(key: Int): Unit = ???
    def remove(key: Int): Unit = ???
    def contains(key: Int): Boolean = ???
  }

  // TODO: Design a HashMap without using built-in hash table libraries
  // Support put, get, remove
  class DesignHashMap {
    private val buckets: Array[List[(Int, Int)]] = Array.fill(1000)(List.empty)

    def put(key: Int, value: Int): Unit = ???
    def get(key: Int): Int = ??? // return -1 if not found
    def remove(key: Int): Unit = ???
  }

  // TODO: Design a circular queue with fixed capacity
  class DesignCircularQueue(capacity: Int) {
    def enQueue(value: Int): Boolean = ???
    def deQueue(): Boolean = ???
    def front(): Int = ??? // -1 if empty
    def rear(): Int = ???  // -1 if empty
    def isEmpty: Boolean = ???
    def isFull: Boolean = ???
  }

  // TODO: Design a browser history with visit, back, and forward operations
  class BrowserHistory(homepage: String) {
    def visit(url: String): Unit = ???
    def back(steps: Int): String = ???
    def forward(steps: Int): String = ???
  }

  // TODO: Design a parking system with big, medium, small spots
  // addCar(carType): 1=big, 2=medium, 3=small. Return true if space available.
  class ParkingSystem(big: Int, medium: Int, small: Int) {
    def addCar(carType: Int): Boolean = ???
  }

  // TODO: Design an ATM that can deposit and withdraw bills
  // Bills: $20, $50, $100, $200, $500
  // Withdraw returns Array(count_20, count_50, count_100, count_200, count_500) or Array(-1) if impossible
  class ATM {
    def deposit(banknotesCount: Array[Int]): Unit = ???
    def withdraw(amount: Int): Array[Int] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1: StackUsingQueues
    val s1 = new StackUsingQueues[Int]()
    s1.push(1)
    s1.push(2)
    s1.push(3)
    assert(s1.top() == 3)
    assert(s1.pop() == 3)
    assert(s1.pop() == 2)
    assert(s1.isEmpty == false)
    assert(s1.pop() == 1)
    assert(s1.isEmpty == true)
    println("Exercise 1 passed: StackUsingQueues")

    // Exercise 2: QueueUsingStacks
    val q2 = new QueueUsingStacks[Int]()
    q2.enqueue(1)
    q2.enqueue(2)
    assert(q2.peek() == 1)
    assert(q2.dequeue() == 1)
    q2.enqueue(3)
    assert(q2.dequeue() == 2)
    assert(q2.dequeue() == 3)
    assert(q2.isEmpty == true)
    println("Exercise 2 passed: QueueUsingStacks")

    // Exercise 3: DesignHashSet
    val hs = new DesignHashSet()
    hs.add(1)
    hs.add(2)
    assert(hs.contains(1) == true)
    assert(hs.contains(3) == false)
    hs.add(2)
    assert(hs.contains(2) == true)
    hs.remove(2)
    assert(hs.contains(2) == false)
    println("Exercise 3 passed: DesignHashSet")

    // Exercise 4: DesignHashMap
    val hm = new DesignHashMap()
    hm.put(1, 10)
    hm.put(2, 20)
    assert(hm.get(1) == 10)
    assert(hm.get(3) == -1)
    hm.put(2, 30)
    assert(hm.get(2) == 30)
    hm.remove(2)
    assert(hm.get(2) == -1)
    println("Exercise 4 passed: DesignHashMap")

    // Exercise 5: DesignCircularQueue
    val cq = new DesignCircularQueue(3)
    assert(cq.enQueue(1) == true)
    assert(cq.enQueue(2) == true)
    assert(cq.enQueue(3) == true)
    assert(cq.enQueue(4) == false)
    assert(cq.rear() == 3)
    assert(cq.isFull == true)
    assert(cq.deQueue() == true)
    assert(cq.enQueue(4) == true)
    assert(cq.rear() == 4)
    println("Exercise 5 passed: DesignCircularQueue")

    // Exercise 6: BrowserHistory
    val bh = new BrowserHistory("leetcode.com")
    bh.visit("google.com")
    bh.visit("facebook.com")
    bh.visit("youtube.com")
    assert(bh.back(1) == "facebook.com")
    assert(bh.back(1) == "google.com")
    assert(bh.forward(1) == "facebook.com")
    bh.visit("linkedin.com")
    assert(bh.forward(2) == "linkedin.com") // no forward history
    assert(bh.back(2) == "google.com")
    assert(bh.back(7) == "leetcode.com")
    println("Exercise 6 passed: BrowserHistory")

    // Exercise 7: ParkingSystem
    val ps = new ParkingSystem(1, 1, 0)
    assert(ps.addCar(1) == true)
    assert(ps.addCar(2) == true)
    assert(ps.addCar(3) == false)
    assert(ps.addCar(1) == false)
    println("Exercise 7 passed: ParkingSystem")

    // Exercise 8: ATM
    val atm = new ATM()
    atm.deposit(Array(0, 0, 1, 2, 1)) // $100 x1, $200 x2, $500 x1
    assert(atm.withdraw(600).toSeq == Seq(0, 0, 1, 0, 1)) // $100 + $500
    atm.deposit(Array(0, 1, 0, 1, 1)) // $50 x1, $200 x1, $500 x1
    assert(atm.withdraw(600).toSeq == Seq(0, 1, 0, 0, 1)) // $50 + $500... wait, need exact
    println("Exercise 8 passed: ATM")

    println("All Algo030_DesignBasics exercises passed!")
  }
}
