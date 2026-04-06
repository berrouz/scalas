package org.shev4ik.interview.scala_core.level2_intermediate

import java.util.concurrent.atomic.{AtomicInteger, AtomicReference}
import java.util.concurrent.ConcurrentHashMap
import scala.concurrent.{Await, Future, blocking}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Core050_Concurrency {

  // Exercise 1: synchronized
  // TODO: Implement a thread-safe counter using synchronized
  class SynchronizedCounter {
    private var count = 0
    def increment(): Unit = ???
    def get: Int = ???
  }

  // Exercise 2: @volatile
  // TODO: Create a class with a @volatile flag that can be read/written from multiple threads
  //       Implement a simple stop flag pattern
  class StoppableWorker {
    @volatile private var stopped = false
    def stop(): Unit = ???
    def isStopped: Boolean = ???
  }

  // Exercise 3: AtomicInteger
  // TODO: Implement a thread-safe counter using AtomicInteger
  //       with increment, decrement, and get methods
  class AtomicCounter {
    private val count = new AtomicInteger(0)
    def increment(): Int = ???
    def decrement(): Int = ???
    def get: Int = ???
  }

  // Exercise 4: AtomicReference
  // TODO: Implement a thread-safe "latest value" holder using AtomicReference
  //       with update and get methods
  class LatestValue[A](initial: A) {
    private val ref = new AtomicReference[A](initial)
    def update(value: A): Unit = ???
    def get: A = ???
    def getAndUpdate(f: A => A): A = ???
  }

  // Exercise 5: ConcurrentHashMap
  // TODO: Create a thread-safe word counter using ConcurrentHashMap
  //       with methods: addWord(word: String), getCount(word: String): Int
  class WordCounter {
    private val counts = new ConcurrentHashMap[String, Int]()
    def addWord(word: String): Unit = ???
    def getCount(word: String): Int = ???
  }

  // Exercise 6: blocking{}
  // TODO: Demonstrate the use of blocking{} to notify the ExecutionContext
  //       that a computation is blocking (e.g., Thread.sleep, IO)
  //       Return a Future that uses blocking{} for a simulated IO operation
  def blockingIO(): Future[String] = ???

  // Exercise 7: ExecutionContext
  // TODO: Create a custom ExecutionContext using a fixed thread pool
  //       Run a computation on it and return the thread name
  def runOnCustomEC(): Future[String] = ???

  // Exercise 8: Thread-safe collections
  // TODO: Demonstrate using scala.collection.concurrent.TrieMap
  //       as a thread-safe mutable map. Implement a simple cache.
  class SimpleCache[K, V] {
    private val cache = new scala.collection.concurrent.TrieMap[K, V]()
    def put(key: K, value: V): Unit = ???
    def get(key: K): Option[V] = ???
    def getOrElseUpdate(key: K, value: => V): V = ???
    def size: Int = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val syncCounter = new SynchronizedCounter
    val futures1 = (1 to 100).map(_ => Future(syncCounter.increment()))
    Await.result(Future.sequence(futures1), 5.seconds)
    assert(syncCounter.get == 100, s"SynchronizedCounter should be 100, got ${syncCounter.get}")

    // Exercise 2 assertions
    val worker = new StoppableWorker
    assert(!worker.isStopped, "Worker should start as not stopped")
    worker.stop()
    assert(worker.isStopped, "Worker should be stopped after stop()")

    // Exercise 3 assertions
    val atomicCounter = new AtomicCounter
    val futures3 = (1 to 100).map(_ => Future(atomicCounter.increment()))
    Await.result(Future.sequence(futures3), 5.seconds)
    assert(atomicCounter.get == 100, s"AtomicCounter should be 100, got ${atomicCounter.get}")

    // Exercise 4 assertions
    val latest = new LatestValue("initial")
    assert(latest.get == "initial", "initial value")
    latest.update("updated")
    assert(latest.get == "updated", "updated value")
    val old = latest.getAndUpdate(s => s.toUpperCase)
    assert(old == "updated", "getAndUpdate should return old value")
    assert(latest.get == "UPDATED", "getAndUpdate should apply function")

    // Exercise 5 assertions
    val wordCounter = new WordCounter
    wordCounter.addWord("hello")
    wordCounter.addWord("hello")
    wordCounter.addWord("world")
    assert(wordCounter.getCount("hello") == 2, "hello count should be 2")
    assert(wordCounter.getCount("world") == 1, "world count should be 1")
    assert(wordCounter.getCount("missing") == 0, "missing word count should be 0")

    // Exercise 6 assertions
    val blockingResult = Await.result(blockingIO(), 5.seconds)
    assert(blockingResult == "io-done", "blocking IO should complete")

    // Exercise 7 assertions
    val threadName = Await.result(runOnCustomEC(), 5.seconds)
    assert(threadName.nonEmpty, "should return a thread name")

    // Exercise 8 assertions
    val cache = new SimpleCache[String, Int]
    cache.put("a", 1)
    assert(cache.get("a") == Some(1), "cache get existing key")
    assert(cache.get("b") == None, "cache get missing key")
    val v = cache.getOrElseUpdate("b", 2)
    assert(v == 2, "getOrElseUpdate should return computed value")
    assert(cache.size == 2, "cache should have 2 entries")

    println("All Core050_Concurrency exercises passed!")
  }
}
