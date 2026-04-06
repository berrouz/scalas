package org.shev4ik.interview.fs2.level2_intermediate

/**
 * FS2 010 - Signal and Topic
 *
 * fs2 provides two key coordination types:
 * - Signal / SignallingRef: a mutable cell that notifies when its value changes.
 *   Useful for graceful shutdown, configuration changes, state sharing.
 * - Topic: a pub-sub primitive where one publisher sends to many subscribers.
 *   Useful for broadcasting events to multiple consumers.
 *
 * This exercise models these patterns with simplified synchronous types.
 *
 * Key concepts: SignallingRef get/set/update, Signal discrete/continuous,
 * Topic publish/subscribe, fan-out broadcasting, graceful shutdown.
 */
object Fs2_010_SignalAndTopic {

  // Simplified SignallingRef modeling fs2.concurrent.SignallingRef
  class SignallingRef[A](private var value: A) {
    private val listeners = scala.collection.mutable.ListBuffer.empty[A => Unit]

    def get: A = value
    def set(a: A): Unit = { value = a; listeners.foreach(_(a)) }
    def update(f: A => A): Unit = set(f(value))
    def modify[B](f: A => (A, B)): B = { val (newA, b) = f(value); set(newA); b }
    def onChange(listener: A => Unit): Unit = listeners += listener
  }

  object SignallingRef {
    def apply[A](initial: A): SignallingRef[A] = new SignallingRef[A](initial)
  }

  // Simplified Topic modeling fs2.concurrent.Topic
  class Topic[A] {
    private val subscribers = scala.collection.mutable.ListBuffer.empty[scala.collection.mutable.ListBuffer[A]]

    def subscribe: scala.collection.mutable.ListBuffer[A] = {
      val buf = scala.collection.mutable.ListBuffer.empty[A]
      subscribers += buf
      buf
    }

    def publish(a: A): Unit = subscribers.foreach(_ += a)
    def publishAll(as: List[A]): Unit = as.foreach(publish)
    def subscriberCount: Int = subscribers.size
  }

  object Topic {
    def apply[A]: Topic[A] = new Topic[A]
  }

  case class Stream[+O](toList: List[O])

  object Stream {
    def apply[O](os: O*): Stream[O] = Stream(os.toList)
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a SignallingRef and read its initial value.
  // TODO: Create a SignallingRef with the given initial value, return it.
  // Hint: In fs2, SignallingRef[IO].of(initial) creates it in IO.
  // -------------------------------------------------------------------------
  def exercise1_createSignal[A](initial: A): A = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Update a SignallingRef using a function.
  // TODO: Create a SignallingRef with initial value, apply the update function,
  //       return the new value.
  // Hint: In fs2, ref.update(f) modifies the value.
  // -------------------------------------------------------------------------
  def exercise2_updateSignal(initial: Int)(f: Int => Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Use modify to atomically update and extract a value.
  // TODO: Create a SignallingRef with initial value, use modify to increment
  //       by 1 and return the old value. Return (oldValue, newValue).
  // Hint: In fs2, ref.modify(a => (a + 1, a)) returns the old value.
  // -------------------------------------------------------------------------
  def exercise3_modifySignal(initial: Int): (Int, Int) = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use a SignallingRef as a shutdown signal.
  // TODO: Create a SignallingRef[Boolean] starting as false. Process items
  //       from the list, stopping when signal becomes true. After processing
  //       `stopAfter` items, set signal to true. Return processed items.
  // Hint: In fs2, stream.interruptWhen(signal) stops when signal is true.
  // -------------------------------------------------------------------------
  def exercise4_shutdownSignal(items: List[String], stopAfter: Int): List[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Track discrete changes to a SignallingRef.
  // TODO: Create a SignallingRef, register a listener that records all changes,
  //       then apply the given updates. Return the list of observed values
  //       (not including the initial value, only values after changes).
  // Hint: In fs2, ref.discrete gives a stream of each new value.
  // -------------------------------------------------------------------------
  def exercise5_discreteChanges(initial: Int, updates: List[Int => Int]): List[Int] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Create a Topic and broadcast messages to subscribers.
  // TODO: Create a topic, create `numSubscribers` subscribers, publish all
  //       messages. Return a list of each subscriber's received messages.
  // Hint: In fs2, topic.subscribe(maxQueued) returns a stream per subscriber.
  // -------------------------------------------------------------------------
  def exercise6_topicBroadcast[A](messages: List[A], numSubscribers: Int): List[List[A]] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Topic with late subscriber (misses early messages).
  // TODO: Create a topic, subscribe one early. Publish first half of messages.
  //       Then subscribe a late subscriber. Publish second half.
  //       Return (earlySubscriber messages, lateSubscriber messages).
  // Hint: In fs2, subscribers only see messages published after they subscribe.
  // -------------------------------------------------------------------------
  def exercise7_lateSubscriber[A](messages: List[A]): (List[A], List[A]) = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Combine Signal and Topic - use a signal to control topic publishing.
  // TODO: Create a SignallingRef[Boolean] (running=true) and a Topic.
  //       Publish messages while signal is true. When signal is set to false,
  //       stop publishing. Set signal to false after `publishCount` messages.
  //       Return messages received by a single subscriber.
  // Hint: Models the pattern of signal-controlled event broadcasting.
  // -------------------------------------------------------------------------
  def exercise8_signalControlledTopic(
    messages: List[String],
    publishCount: Int
  ): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_createSignal(42) == 42)
    assert(exercise1_createSignal("hello") == "hello")
    println("Exercise 1 passed: SignallingRef created with initial value")

    // Exercise 2
    assert(exercise2_updateSignal(10)(_ + 5) == 15)
    assert(exercise2_updateSignal(10)(_ * 3) == 30)
    println("Exercise 2 passed: SignallingRef updated with function")

    // Exercise 3
    val (old3, new3) = exercise3_modifySignal(10)
    assert(old3 == 10)
    assert(new3 == 11)
    println("Exercise 3 passed: modify returns old value, updates to new")

    // Exercise 4
    assert(exercise4_shutdownSignal(List("a", "b", "c", "d", "e"), 3) == List("a", "b", "c"))
    assert(exercise4_shutdownSignal(List("x"), 5) == List("x"))
    println("Exercise 4 passed: shutdown signal stops processing")

    // Exercise 5
    val changes = exercise5_discreteChanges(0, List(_ + 1, _ + 10, _ * 2))
    assert(changes == List(1, 11, 22))
    println("Exercise 5 passed: discrete changes tracked")

    // Exercise 6
    val broadcast = exercise6_topicBroadcast(List("a", "b", "c"), 3)
    assert(broadcast.size == 3)
    assert(broadcast.forall(_ == List("a", "b", "c")))
    println("Exercise 6 passed: topic broadcasts to all subscribers")

    // Exercise 7
    val msgs = List(1, 2, 3, 4, 5, 6)
    val (early, late) = exercise7_lateSubscriber(msgs)
    assert(early == List(1, 2, 3, 4, 5, 6))
    assert(late == List(4, 5, 6))
    println("Exercise 7 passed: late subscriber only sees later messages")

    // Exercise 8
    val result8 = exercise8_signalControlledTopic(List("m1", "m2", "m3", "m4", "m5"), 3)
    assert(result8 == List("m1", "m2", "m3"))
    println("Exercise 8 passed: signal controls topic publishing")

    println("\nAll Fs2_010_SignalAndTopic exercises passed!")
  }
}
