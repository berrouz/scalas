package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Amortized Analysis and Amortized Data Structures.
 *
 * Key concepts:
 * - Amortized cost: average cost per operation over worst-case sequence
 * - Banker's method: save credits during cheap ops, spend during expensive ops
 * - Physicist's method: define a potential function
 * - Real-time queues: worst-case O(1) per operation
 */
object Algo103_Amortized {

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 1: Amortized analysis concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a dynamic array (like ArrayList) that doubles in size
   *       when full. Demonstrate amortized O(1) insertion.
   *       Return (add function, get function, size function).
   *
   * @param initialCapacity initial capacity
   * @return (add, get, size) functions
   */
  def dynamicArray[A: scala.reflect.ClassTag](initialCapacity: Int): (A => Unit, Int => A, () => Int) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 2: Banker's queue
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a purely functional queue using the Banker's method.
   *       Two lists: front (for dequeue) and rear (for enqueue).
   *       Invariant: |front| >= |rear|. When violated, reverse rear onto front.
   *       This ensures amortized O(1) operations.
   */
  case class BankersQ[A](front: List[A], fLen: Int, rear: List[A], rLen: Int)

  def emptyBankersQ[A]: BankersQ[A] = BankersQ(Nil, 0, Nil, 0)

  def bankersEnqueue[A](q: BankersQ[A], elem: A): BankersQ[A] = {
    ???
  }

  def bankersDequeue[A](q: BankersQ[A]): Option[(A, BankersQ[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 3: Physicist's queue
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a queue using the Physicist's method.
   *       Similar to Banker's but uses lazy evaluation for the reversal.
   *       working = prefix of front (evaluated), front = full front (lazy).
   *       Maintain invariant: |working| > 0 when queue non-empty.
   *       For simplicity, implement with strict lists and the same Banker's invariant.
   *
   * @return (enqueue, dequeue, isEmpty) functions operating on internal state
   */
  def physicistsQueue[A](): (
    (List[A], A) => List[A],              // simplified: add to list
    List[A] => Option[(A, List[A])],       // remove from list (front)
    List[A] => Boolean                     // isEmpty
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 4: Real-time queue
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a real-time queue with worst-case O(1) operations.
   *       Use incremental reversal: do a constant amount of reversal work per operation.
   *       Maintain a schedule of pending computations.
   *       For simplicity, use Stream for incremental reversal.
   */
  case class RTQueue[A](front: Stream[A], rear: List[A], schedule: Stream[A])

  def emptyRTQueue[A]: RTQueue[A] = RTQueue(Stream.empty, Nil, Stream.empty)

  def rtEnqueue[A](q: RTQueue[A], elem: A): RTQueue[A] = {
    ???
  }

  def rtDequeue[A](q: RTQueue[A]): Option[(A, RTQueue[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 5: Bootstrapped queue concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a bootstrapped queue that uses a queue of queues internally.
   *       For simplicity, implement a queue where enqueue and dequeue are both O(1) amortized.
   *       Use a Vector as the underlying structure (Scala's Vector has effectively O(1) operations).
   *
   * @return (enqueue, dequeue, isEmpty, size) functions
   */
  def bootstrappedQueue[A](): (
    (Vector[A], A) => Vector[A],          // enqueue
    Vector[A] => Option[(A, Vector[A])],  // dequeue
    Vector[A] => Boolean,                 // isEmpty
    Vector[A] => Int                      // size
  ) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 6: Implicit recursive slowdown concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a deque using the implicit recursive slowdown technique.
   *       The idea: maintain digits at each level; when a level overflows,
   *       push work to the next level.
   *       For simplicity, implement a deque backed by two lists with the
   *       invariant that both are non-empty when deque has >= 2 elements.
   */
  case class IRSDeque[A](front: List[A], rear: List[A])

  def irsEmpty[A]: IRSDeque[A] = IRSDeque(Nil, Nil)

  def irsPushFront[A](d: IRSDeque[A], elem: A): IRSDeque[A] = {
    ???
  }

  def irsPushBack[A](d: IRSDeque[A], elem: A): IRSDeque[A] = {
    ???
  }

  def irsPopFront[A](d: IRSDeque[A]): Option[(A, IRSDeque[A])] = {
    ???
  }

  def irsPopBack[A](d: IRSDeque[A]): Option[(A, IRSDeque[A])] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 7: Scheduling concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Implement a scheduled computation where expensive work is distributed
   *       across multiple cheap operations. Given a list of tasks with costs,
   *       schedule them so that no single step exceeds a given budget.
   *       Return the scheduling (list of task groups per step).
   *
   * @param tasks  list of (taskId, cost)
   * @param budget max cost per step
   * @return list of task groups (each group fits in budget)
   */
  def scheduleTasks(tasks: List[(Int, Int)], budget: Int): List[List[Int]] = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────
  // Exercise 8: Debit analysis concept
  // ──────────────────────────────────────────────────────────────────────
  /**
   * TODO: Simulate the Banker's method of amortized analysis.
   *       Given a sequence of operations with actual costs,
   *       compute the amortized cost per operation and verify
   *       that credits never go negative.
   *       Return (amortizedCost, creditAfterEachOp).
   *
   * @param actualCosts list of actual costs for each operation
   * @param amortizedRate proposed amortized cost per operation
   * @return (isValid: true if credits never go negative, creditHistory: list of credits)
   */
  def debitAnalysis(actualCosts: List[Int], amortizedRate: Int): (Boolean, List[Int]) = {
    ???
  }

  // ──────────────────────────────────────────────────────────────────────

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (add, get, size) = dynamicArray[Int](2)
    add(1); add(2); add(3); add(4); add(5)
    assert(size() == 5)
    assert(get(0) == 1)
    assert(get(4) == 5)
    println("Exercise 1 (Dynamic array) passed.")

    // Exercise 2
    var bq = emptyBankersQ[Int]
    bq = bankersEnqueue(bq, 1)
    bq = bankersEnqueue(bq, 2)
    bq = bankersEnqueue(bq, 3)
    val Some((v1, bq2)) = bankersDequeue(bq): @unchecked
    assert(v1 == 1)
    val Some((v2, _)) = bankersDequeue(bq2): @unchecked
    assert(v2 == 2)
    println("Exercise 2 (Banker's queue) passed.")

    // Exercise 3
    val (pEnq, pDeq, pEmpty) = physicistsQueue[Int]()
    var pl: List[Int] = Nil
    pl = pEnq(pl, 1)
    pl = pEnq(pl, 2)
    val Some((pv, pl2)) = pDeq(pl): @unchecked
    assert(pv == 1)
    println("Exercise 3 (Physicist's queue) passed.")

    // Exercise 4
    var rtq = emptyRTQueue[Int]
    rtq = rtEnqueue(rtq, 1)
    rtq = rtEnqueue(rtq, 2)
    rtq = rtEnqueue(rtq, 3)
    val Some((rv1, rtq2)) = rtDequeue(rtq): @unchecked
    assert(rv1 == 1)
    val Some((rv2, _)) = rtDequeue(rtq2): @unchecked
    assert(rv2 == 2)
    println("Exercise 4 (Real-time queue) passed.")

    // Exercise 5
    val (bsEnq, bsDeq, bsEmpty, bsSize) = bootstrappedQueue[Int]()
    var bsq = Vector.empty[Int]
    bsq = bsEnq(bsq, 10)
    bsq = bsEnq(bsq, 20)
    assert(bsSize(bsq) == 2)
    val Some((bv, bsq2)) = bsDeq(bsq): @unchecked
    assert(bv == 10)
    println("Exercise 5 (Bootstrapped queue) passed.")

    // Exercise 6
    var dq = irsEmpty[Int]
    dq = irsPushFront(dq, 1)
    dq = irsPushBack(dq, 2)
    dq = irsPushFront(dq, 0)
    val Some((dv1, dq2)) = irsPopFront(dq): @unchecked
    assert(dv1 == 0)
    val Some((dv2, _)) = irsPopBack(dq2): @unchecked
    assert(dv2 == 2)
    println("Exercise 6 (IRS Deque) passed.")

    // Exercise 7
    val schedule = scheduleTasks(List((1, 3), (2, 2), (3, 4), (4, 1)), 5)
    assert(schedule.nonEmpty)
    assert(schedule.forall(group => group.map(id => List((1,3),(2,2),(3,4),(4,1)).find(_._1 == id).get._2).sum <= 5))
    println("Exercise 7 (Scheduling) passed.")

    // Exercise 8
    // Dynamic array: n insertions, most cost 1, but doubling costs n/2, n/4, etc.
    // Amortized cost of 3 per operation should work
    val costs = List(1, 1, 3, 1, 5, 1, 1, 1, 9) // simulating array doubling
    val (valid, history) = debitAnalysis(costs, 3)
    assert(valid, s"Credits went negative: $history")
    println("Exercise 8 (Debit analysis) passed.")

    println("All Algo103_Amortized exercises passed!")
  }
}
