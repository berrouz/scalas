package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 048 - Deferred (Modeled as concept)
 *
 * Deferred[F, A] is a purely functional synchronization primitive.
 * It represents a value that may not yet be available. Once completed,
 * the value cannot be changed. Think of it as a single-assignment variable.
 * This models cats-effect Deferred concepts.
 */
object Cats048_Deferred {

  // Simplified Deferred model
  // In real code, use cats.effect.concurrent.Deferred
  class SimpleDeferred[A] {
    private var value: Option[A] = None
    private var waiters: List[A => Unit] = Nil

    def complete(a: A): Boolean = synchronized {
      if (value.isDefined) false
      else {
        value = Some(a)
        waiters.foreach(_(a))
        waiters = Nil
        true
      }
    }

    def get: A = synchronized {
      value.getOrElse(throw new IllegalStateException("Deferred not yet completed"))
    }

    def tryGet: Option[A] = synchronized(value)
  }

  object SimpleDeferred {
    def apply[A](): SimpleDeferred[A] = new SimpleDeferred[A]
  }

  // Exercise 1: Deferred creation - create an empty Deferred
  // TODO: Create a new empty SimpleDeferred.
  def exercise1_create(): SimpleDeferred[Int] = {
    // Create an empty Deferred that will hold an Int
    ???
  }

  // Exercise 2: complete - complete a Deferred with a value
  // TODO: Complete a Deferred and observe it can only be completed once.
  def exercise2_complete(): (Boolean, Boolean) = {
    val deferred = SimpleDeferred[String]()

    // Complete with "hello" - should return true
    val first: Boolean = ???
    // Try to complete again with "world" - should return false
    val second: Boolean = ???

    (first, second)
  }

  // Exercise 3: get (semantic blocking) - get blocks until value is available
  // TODO: Complete a Deferred then get its value.
  def exercise3_get(): String = {
    val deferred = SimpleDeferred[String]()

    // Complete the deferred, then get the value
    deferred.complete("result")
    ???
  }

  // Exercise 4: Deferred for coordination - use Deferred to coordinate computations
  // TODO: Use Deferred as a coordination mechanism between producer and consumer.
  def exercise4_coordination(): String = {
    val signal = SimpleDeferred[String]()
    var result = ""

    // Producer: complete the signal with "data-ready"
    // Consumer: get the signal value and set result
    ???

    result
  }

  // Exercise 5: Deferred as a latch - use Deferred as a one-shot latch
  // TODO: Model a latch pattern where multiple consumers wait for a signal.
  def exercise5_latch(): List[String] = {
    val latch = SimpleDeferred[Unit]()
    var results: List[String] = Nil

    // Complete the latch (signal that work can proceed)
    latch.complete(())

    // Multiple "consumers" check the latch and proceed
    if (latch.tryGet.isDefined) results = results :+ "consumer-1-proceeded"
    if (latch.tryGet.isDefined) results = results :+ "consumer-2-proceeded"
    if (latch.tryGet.isDefined) results = results :+ "consumer-3-proceeded"

    // Return the list of consumers that proceeded
    ???
  }

  // Exercise 6: tryGet - non-blocking check if Deferred is completed
  // TODO: Use tryGet to check completion status without blocking.
  def exercise6_tryGet(): (Option[Int], Option[Int]) = {
    val deferred = SimpleDeferred[Int]()

    // Before completing: tryGet should return None
    val before: Option[Int] = ???

    deferred.complete(42)

    // After completing: tryGet should return Some(42)
    val after: Option[Int] = ???

    (before, after)
  }

  // Exercise 7: Deferred + Ref pattern - combine Deferred with Ref for state machine
  // TODO: Use Deferred and SimpleRef together for a state machine pattern.
  def exercise7_deferredPlusRef(): (Int, String) = {
    // SimpleRef from Cats047
    class SimpleRef[A](private var value: A) {
      def get: A = synchronized(value)
      def update(f: A => A): Unit = synchronized { value = f(value) }
    }

    val stateRef = new SimpleRef[Int](0)
    val completion = SimpleDeferred[String]()

    // Process: update state 3 times, then signal completion
    // Each update adds 10
    ???

    (stateRef.get, completion.get)
  }

  // Exercise 8: Producer-consumer with Deferred - full producer-consumer pattern
  // TODO: Implement a simple producer-consumer using Deferred for synchronization.
  def exercise8_producerConsumer(): List[String] = {
    val mailbox = SimpleDeferred[String]()
    var log: List[String] = Nil

    // Producer: produce a message and put it in the mailbox
    def produce(msg: String): Unit = {
      log = log :+ s"producing: $msg"
      mailbox.complete(msg)
      log = log :+ "produced"
    }

    // Consumer: wait for and consume the message
    def consume(): String = {
      log = log :+ "consuming"
      val msg = mailbox.get
      log = log :+ s"consumed: $msg"
      msg
    }

    // Run producer then consumer
    ???

    log
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_create()
    assert(r1.tryGet.isEmpty, s"Exercise 1 failed: should be empty")
    println(s"Exercise 1 passed: Deferred created, empty=${r1.tryGet.isEmpty}")

    // Exercise 2
    val (r2a, r2b) = exercise2_complete()
    assert(r2a && !r2b, s"Exercise 2 failed: first=$r2a, second=$r2b")
    println(s"Exercise 2 passed: complete => first=$r2a, second=$r2b")

    // Exercise 3
    val r3 = exercise3_get()
    assert(r3 == "result", s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: get => $r3")

    // Exercise 4
    val r4 = exercise4_coordination()
    assert(r4 == "data-ready", s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: coordination => $r4")

    // Exercise 5
    val r5 = exercise5_latch()
    assert(r5.size == 3, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: latch => $r5")

    // Exercise 6
    val (r6a, r6b) = exercise6_tryGet()
    assert(r6a.isEmpty && r6b.contains(42), s"Exercise 6 failed: before=$r6a, after=$r6b")
    println(s"Exercise 6 passed: tryGet => before=$r6a, after=$r6b")

    // Exercise 7
    val (r7state, r7signal) = exercise7_deferredPlusRef()
    assert(r7state == 30, s"Exercise 7 failed: state=$r7state")
    println(s"Exercise 7 passed: Deferred+Ref => state=$r7state, signal=$r7signal")

    // Exercise 8
    val r8 = exercise8_producerConsumer()
    assert(r8.size == 4, s"Exercise 8 failed: $r8")
    assert(r8.exists(_.contains("consumed")), s"Exercise 8 failed: no consumed entry")
    println(s"Exercise 8 passed: producer-consumer => $r8")

    println("\nAll Cats048_Deferred exercises passed!")
  }
}
