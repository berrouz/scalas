package org.shev4ik.interview.concurrency.level3_advanced

import java.util.concurrent._
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

object Conc019_ActorModel {

  // Exercise 1: Simple message passing with a blocking queue
  // TODO: Create a "mailbox" using LinkedBlockingQueue[Any].
  //       Launch an "actor" thread that reads from the mailbox and processes messages:
  //       - If it receives an Int, add it to an AtomicInteger sum.
  //       - If it receives "stop", the actor terminates.
  //       Send messages: 10, 20, 30, "stop". Join the actor thread.
  //       Return sum.get() (should be 60).
  def exercise1_simpleMessagePassing(): Int = ???

  // Exercise 2: Actor with state
  // TODO: Implement a stateful actor thread with a mailbox (LinkedBlockingQueue[Any]).
  //       The actor maintains a var count = 0.
  //       - "increment" message: count += 1
  //       - "get" message: put count into a result AtomicInteger
  //       - "stop" message: put count into result and terminate
  //       Send 5 "increment" messages, then "stop". Return the count (should be 5).
  def exercise2_statefulActor(): Int = ???

  // Exercise 3: Request-reply pattern
  // TODO: Implement request-reply using two queues: requestQueue and replyQueue.
  //       Actor thread reads from requestQueue. If it receives ("add", a: Int, b: Int),
  //       it puts (a + b) into replyQueue.
  //       Send ("add", 15, 27). Read from replyQueue. Send "stop". Return result (should be 42).
  def exercise3_requestReply(): Int = ???

  // Exercise 4: Multiple actors communicating
  // TODO: Create two actor threads: Doubler and Adder.
  //       Doubler reads an Int from its mailbox, doubles it, sends to Adder's mailbox.
  //       Adder reads an Int, adds 10, puts result in a result queue.
  //       Send 5 to Doubler. Final result: (5 * 2) + 10 = 20.
  //       Send "stop" to both. Return result.
  def exercise4_actorChain(): Int = ???

  // Exercise 5: Actor with multiple message types using sealed trait
  // TODO: Define a sealed trait Message with cases:
  //       - Increment, Decrement, GetCount(replyQueue: LinkedBlockingQueue[Int])
  //       Create an actor that processes these messages maintaining a counter.
  //       Send Increment 3 times, Decrement once, then GetCount.
  //       Return the count (should be 2).
  def exercise5_typedMessages(): Int = ???

  // Exercise 6: Fan-out pattern
  // TODO: Create 3 worker actors, each with their own mailbox.
  //       A dispatcher sends numbers 1-9 round-robin to the workers (1->W1, 2->W2, 3->W3, 4->W1...).
  //       Each worker sums its received numbers and stores in a shared AtomicInteger.
  //       Send "stop" to each worker. Return total sum (should be 1+2+...+9 = 45).
  def exercise6_fanOut(): Int = ???

  // Exercise 7: Actor supervision concept
  // TODO: Create an actor that processes Int messages by adding to a sum.
  //       If it receives -1, it throws an exception (simulated failure).
  //       The supervisor catches the exception and restarts the actor (creates a new thread).
  //       Send: 10, 20, -1 (crash), 30, "stop".
  //       The restarted actor should process 30. Return the sum from the final actor (should be 30).
  //       Note: the sum from before the crash (30) is lost.
  def exercise7_supervision(): Int = ???

  // Exercise 8: Batch processing actor
  // TODO: Create an actor that collects Int messages into a batch (List).
  //       When it receives "flush", it sums the batch, clears it, and adds sum to AtomicInteger result.
  //       Send: 1, 2, 3, "flush", 4, 5, "flush", "stop".
  //       Return result.get() (should be 6 + 9 = 15).
  def exercise8_batchActor(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_simpleMessagePassing() == 60, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_statefulActor() == 5, "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_requestReply() == 42, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_actorChain() == 20, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_typedMessages() == 2, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_fanOut() == 45, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_supervision() == 30, "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_batchActor() == 15, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc019_ActorModel exercises passed!")
  }
}
