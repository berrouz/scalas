package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 001 - Actor Basics
 *
 * Actors are the fundamental unit of computation in Akka. Key concepts:
 *   - Messages: defined as sealed trait hierarchies, sent to actors
 *   - Actor state: encapsulated in a case class, never shared
 *   - Receive: a partial function from message to next behavior
 *   - tell (!): fire-and-forget message send
 *   - ask (?): send message expecting a Future response
 *   - Lifecycle: actors are created, started, stopped, restarted
 *   - Props: configuration for creating an actor (factory)
 *   - ActorRef: an immutable, serializable handle to an actor
 */
object Akka001_ActorBasics {

  // --- Domain models ---

  /** In Akka, messages form a sealed trait protocol */
  sealed trait GreeterMessage
  case class Greet(name: String) extends GreeterMessage
  case class GetGreetCount(replyTo: String => Unit) extends GreeterMessage
  case object ResetCount extends GreeterMessage

  /** Actor state is modeled as an immutable case class */
  case class GreeterState(greetCount: Int, lastGreeted: Option[String])

  /** Props-like config for creating an actor */
  case class ActorProps[S](initialState: S, name: String)

  /** ActorRef is a handle — we model it as a wrapper around a message handler */
  case class ActorRef[M](name: String, send: M => Unit) {
    def !(msg: M): Unit = send(msg)
  }

  /** Lifecycle stage enumeration */
  sealed trait LifecycleStage
  object LifecycleStage {
    case object PreStart  extends LifecycleStage
    case object Started   extends LifecycleStage
    case object PreStop   extends LifecycleStage
    case object Stopped   extends LifecycleStage
    case object PreRestart extends LifecycleStage
    case object PostRestart extends LifecycleStage
  }

  // Exercise 1: Define an actor message protocol
  // TODO: Create a sealed trait `CounterMessage` with three cases:
  //   Increment(amount: Int), Decrement(amount: Int), GetValue(replyTo: Int => Unit)
  //   Return the string "CounterMessage" to confirm the protocol is defined.
  def exercise1_defineProtocol: String = ???

  // Exercise 2: Create initial actor state
  // TODO: Given a name, create a GreeterState with greetCount = 0
  //   and lastGreeted = None
  def exercise2_initialState(name: String): GreeterState = ???

  // Exercise 3: Implement a receive function for the greeter
  // TODO: Implement a function that takes a GreeterState and a GreeterMessage,
  //   and returns an updated GreeterState:
  //   - Greet(name): increment greetCount, set lastGreeted = Some(name)
  //   - GetGreetCount(replyTo): call replyTo with s"Count: ${state.greetCount}", return state unchanged
  //   - ResetCount: set greetCount = 0, keep lastGreeted
  def exercise3_receive(state: GreeterState, msg: GreeterMessage): GreeterState = ???

  // Exercise 4: Simulate the tell (!) pattern
  // TODO: Given an ActorRef[String] and a message string,
  //   use the ! method to send the message. Return the message that was sent.
  //   (The ActorRef.send function will be provided in the test.)
  def exercise4_tell(ref: ActorRef[String], message: String): String = ???

  // Exercise 5: Simulate the ask (?) pattern concept
  // TODO: Implement a function that sends a GetGreetCount message
  //   and captures the reply. Use a var to capture the callback result.
  //   Return the captured reply string.
  //   Hint: Create a GetGreetCount with a replyTo that stores the response,
  //   then call exercise3_receive with the given state and that message.
  def exercise5_askPattern(state: GreeterState): String = ???

  // Exercise 6: Model actor lifecycle stages
  // TODO: Given a list of lifecycle events as strings
  //   ("preStart", "started", "preStop", "stopped", "preRestart", "postRestart"),
  //   map them to LifecycleStage values. Unknown strings should be filtered out.
  //   Return the list of LifecycleStage values.
  def exercise6_lifecycleStages(events: List[String]): List[LifecycleStage] = ???

  // Exercise 7: Create Props-like configuration
  // TODO: Create an ActorProps[GreeterState] with
  //   initialState = GreeterState(0, None) and name = the given actorName.
  def exercise7_createProps(actorName: String): ActorProps[GreeterState] = ???

  // Exercise 8: Build an ActorRef that processes messages
  // TODO: Create an ActorRef[GreeterMessage] with the given name.
  //   The send function should apply exercise3_receive using a mutable state variable
  //   initialized from initialState. After all messages in `messages` are sent via !,
  //   return the final state.
  //   Hint: Use a var to track state, create an ActorRef whose send updates it.
  def exercise8_actorRefProcess(
    name: String,
    initialState: GreeterState,
    messages: List[GreeterMessage]
  ): GreeterState = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_defineProtocol
    assert(r1 == "CounterMessage", s"Exercise 1 failed: expected CounterMessage, got $r1")
    println(s"Exercise 1 passed: protocol defined")

    // Exercise 2
    val r2 = exercise2_initialState("greeter-1")
    assert(r2 == GreeterState(0, None), s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val s0 = GreeterState(0, None)
    val s1 = exercise3_receive(s0, Greet("Alice"))
    assert(s1 == GreeterState(1, Some("Alice")), s"Exercise 3 failed: got $s1")
    val s2 = exercise3_receive(s1, Greet("Bob"))
    assert(s2 == GreeterState(2, Some("Bob")), s"Exercise 3 failed: got $s2")
    var reply3 = ""
    val s3 = exercise3_receive(s2, GetGreetCount(r => reply3 = r))
    assert(reply3 == "Count: 2", s"Exercise 3 failed: reply was $reply3")
    assert(s3 == s2, "Exercise 3 failed: state should be unchanged after GetGreetCount")
    val s4 = exercise3_receive(s3, ResetCount)
    assert(s4 == GreeterState(0, Some("Bob")), s"Exercise 3 failed: got $s4")
    println("Exercise 3 passed: receive function works")

    // Exercise 4
    var sent = ""
    val ref4 = ActorRef[String]("test", msg => sent = msg)
    val r4 = exercise4_tell(ref4, "hello")
    assert(sent == "hello", s"Exercise 4 failed: sent was $sent")
    assert(r4 == "hello", s"Exercise 4 failed: returned $r4")
    println("Exercise 4 passed: tell pattern works")

    // Exercise 5
    val r5 = exercise5_askPattern(GreeterState(5, Some("Eve")))
    assert(r5 == "Count: 5", s"Exercise 5 failed: got $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val events = List("preStart", "started", "preStop", "stopped", "unknown", "preRestart", "postRestart")
    val r6 = exercise6_lifecycleStages(events)
    assert(r6.length == 6, s"Exercise 6 failed: expected 6 stages, got ${r6.length}")
    assert(r6.head == LifecycleStage.PreStart, s"Exercise 6 failed: first should be PreStart")
    println(s"Exercise 6 passed: ${r6.length} lifecycle stages mapped")

    // Exercise 7
    val r7 = exercise7_createProps("my-greeter")
    assert(r7.name == "my-greeter", s"Exercise 7 failed: wrong name")
    assert(r7.initialState == GreeterState(0, None), s"Exercise 7 failed: wrong state")
    println(s"Exercise 7 passed: Props created for ${r7.name}")

    // Exercise 8
    val msgs = List(Greet("A"), Greet("B"), Greet("C"), ResetCount, Greet("D"))
    val r8 = exercise8_actorRefProcess("greeter", GreeterState(0, None), msgs)
    assert(r8 == GreeterState(1, Some("D")), s"Exercise 8 failed: got $r8")
    println(s"Exercise 8 passed: final state = $r8")

    println("\nAll Akka001_ActorBasics exercises passed!")
  }
}
