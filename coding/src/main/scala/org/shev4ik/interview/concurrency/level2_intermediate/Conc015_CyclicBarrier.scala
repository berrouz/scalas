package org.shev4ik.interview.concurrency.level2_intermediate

import java.util.concurrent._
import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}

object Conc015_CyclicBarrier {

  // Exercise 1: Basic CyclicBarrier
  // TODO: Create a CyclicBarrier for 3 parties. Launch 3 threads, each incrementing
  //       an AtomicInteger counter then awaiting the barrier. After all 3 arrive,
  //       the barrier trips. Join all threads. Return counter.get() (should be 3).
  def exercise1_basicBarrier(): Int = ???

  // Exercise 2: CyclicBarrier with barrier action
  // TODO: Create a CyclicBarrier(3, () => result.set("barrier-tripped")).
  //       Launch 3 threads that each await the barrier. After the barrier trips,
  //       the action runs. Join all threads. Return result.get().
  def exercise2_barrierAction(): String = ???

  // Exercise 3: CyclicBarrier is reusable
  // TODO: Create a CyclicBarrier(2). Use it twice (two rounds).
  //       Round 1: 2 threads await, incrementing counter.
  //       Round 2: 2 threads await again, incrementing counter again.
  //       Return counter.get() (should be 4, two rounds of 2 threads each).
  def exercise3_reusable(): Int = ???

  // Exercise 4: getParties and getNumberWaiting
  // TODO: Create a CyclicBarrier(3). Return getParties() (should be 3).
  def exercise4_getParties(): Int = ???

  // Exercise 5: Phaser basics
  // TODO: Create a Phaser with 1 registered party (main thread).
  //       Register 2 more parties. Launch 2 threads, each arriving at phase 0.
  //       Main thread also arrives (arriveAndAwaitAdvance). All advance to phase 1.
  //       Return phaser.getPhase() after the advance (should be 1).
  def exercise5_phaserBasics(): Int = ???

  // Exercise 6: Phaser multiple phases
  // TODO: Create a Phaser(3). Launch 3 threads, each doing 3 phases:
  //       In each phase, increment an AtomicInteger and call arriveAndAwaitAdvance().
  //       After all threads complete all phases, return counter.get() (should be 9 = 3 threads * 3 phases).
  def exercise6_phaserMultiPhase(): Int = ???

  // Exercise 7: Exchanger
  // TODO: Create an Exchanger[String]. Launch two threads:
  //       Thread A exchanges "from-A", Thread B exchanges "from-B".
  //       Each thread stores what it received in an AtomicReference.
  //       Join both. Return (receivedByA, receivedByB) — should be ("from-B", "from-A").
  def exercise7_exchanger(): (String, String) = ???

  // Exercise 8: Phaser with deregistration
  // TODO: Create a Phaser(3). Launch 3 threads. In phase 0, all 3 participate.
  //       After phase 0, thread 0 calls arriveAndDeregister(). Threads 1 and 2 continue
  //       to phase 1. Return the number of registered parties after deregistration (should be 2).
  //       Use an AtomicInteger to store the registered parties count.
  def exercise8_phaserDeregister(): Int = ???

  def main(args: Array[String]): Unit = {
    assert(exercise1_basicBarrier() == 3, "Exercise 1 failed")
    println("Exercise 1 passed")

    assert(exercise2_barrierAction() == "barrier-tripped", "Exercise 2 failed")
    println("Exercise 2 passed")

    assert(exercise3_reusable() == 4, "Exercise 3 failed")
    println("Exercise 3 passed")

    assert(exercise4_getParties() == 3, "Exercise 4 failed")
    println("Exercise 4 passed")

    assert(exercise5_phaserBasics() == 1, "Exercise 5 failed")
    println("Exercise 5 passed")

    assert(exercise6_phaserMultiPhase() == 9, "Exercise 6 failed")
    println("Exercise 6 passed")

    assert(exercise7_exchanger() == ("from-B", "from-A"), "Exercise 7 failed")
    println("Exercise 7 passed")

    assert(exercise8_phaserDeregister() == 2, "Exercise 8 failed")
    println("Exercise 8 passed")

    println("\nAll Conc015_CyclicBarrier exercises passed!")
  }
}
