package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 023 - Typed Actors (Akka Typed)
 *
 * Akka Typed provides a type-safe actor API:
 *   - Behavior[T]: defines how an actor processes messages of type T
 *   - Behaviors.receive: create behavior from (context, message) => Behavior
 *   - Behaviors.receiveMessage: create behavior from message => Behavior (no context)
 *   - Behaviors.setup: create behavior that needs ActorContext during initialization
 *   - ActorContext: provides access to self, spawn, log, etc.
 *   - spawn: create a child actor
 *   - Behaviors.same: keep current behavior
 *   - Behaviors.stopped: stop the actor
 *
 * We model these concepts using pure Scala function types.
 */
object Akka023_TypedActors {

  // --- Domain models ---

  /** Behavior is a function from message to next behavior (or terminal) */
  sealed trait Behavior[T]
  case class Receive[T](handler: T => (List[String], Behavior[T])) extends Behavior[T]
  case class Same[T]() extends Behavior[T]
  case class Stopped[T]() extends Behavior[T]

  /** Simulated ActorContext */
  case class ActorContext[T](
    selfName: String,
    children: Map[String, String], // childName -> childType
    log: List[String]
  )

  sealed trait GreeterCommand
  case class Greet(name: String) extends GreeterCommand
  case class ChangeGreeting(newGreeting: String) extends GreeterCommand
  case object StopGreeter extends GreeterCommand
  case class GetState(replyTo: (String, Int) => Unit) extends GreeterCommand

  case class GreeterState(greeting: String, greetCount: Int)

  /** Typed child actor concept */
  case class SpawnedActor(name: String, behaviorDescription: String)

  // Exercise 1: Behaviors.receiveMessage — simple typed behavior
  // TODO: Create a Receive behavior for GreeterCommand that:
  //   - Greet(name): returns (List("$greeting, $name!"), Same)
  //     using the provided greeting string
  //   - ChangeGreeting: returns (List("Greeting changed"), new behavior with new greeting)
  //   - StopGreeter: returns (List("Stopping"), Stopped)
  //   - GetState: call replyTo with (greeting, 0), return (Nil, Same)
  //   In real Akka: Behaviors.receiveMessage[GreeterCommand] { case Greet(name) => ... }
  def exercise1_receiveMessage(greeting: String): Behavior[GreeterCommand] = ???

  // Exercise 2: Behaviors.receive with context — setup and logging
  // TODO: Simulate a behavior that uses ActorContext for logging.
  //   Given a context and a message, return (logEntries, nextBehavior):
  //   - Greet(name): log "[selfName] Greeting $name", return Same
  //   - StopGreeter: log "[selfName] Shutting down", return Stopped
  //   - Other: log "[selfName] Unknown message", return Same
  def exercise2_receiveWithContext(ctx: ActorContext[GreeterCommand], msg: GreeterCommand): (List[String], Behavior[GreeterCommand]) = ???

  // Exercise 3: Behaviors.setup — initialization behavior
  // TODO: Simulate Behaviors.setup which runs initialization code.
  //   Given an actor name, create a "setup" that:
  //   1. Produces initial log: "Actor $name starting up"
  //   2. Spawns children: creates SpawnedActor entries for "worker-1" and "worker-2"
  //   3. Returns (setupLog, spawnedChildren, initialBehavior)
  //   The initial behavior should handle Greet by returning the name in a list.
  def exercise3_setup(actorName: String): (List[String], List[SpawnedActor], Behavior[GreeterCommand]) = ???

  // Exercise 4: ActorContext — spawn child actors
  // TODO: Given an ActorContext, simulate spawning a child actor:
  //   Add childName -> childType to the context's children map.
  //   If a child with the same name already exists, return the context unchanged.
  //   Return the updated ActorContext.
  def exercise4_spawn[T](ctx: ActorContext[T], childName: String, childType: String): ActorContext[T] = ???

  // Exercise 5: Process message sequence with behavior evolution
  // TODO: Given an initial Behavior[GreeterCommand] and a list of messages,
  //   process each message. Track the behavior changes:
  //   - Same: keep using current behavior
  //   - Receive: switch to new behavior
  //   - Stopped: stop processing
  //   Return all collected log entries from processing.
  def exercise5_processMessages(
    initial: Behavior[GreeterCommand],
    messages: List[GreeterCommand]
  ): List[String] = ???

  // Exercise 6: Behaviors.same — behavior preservation
  // TODO: Create a counter behavior that tracks state:
  //   Receives Int messages.
  //   - Positive number: add to total, return Same (conceptually)
  //   - Zero: return (List(total.toString), Same) — report current total
  //   - Negative number: return (List("Stopped"), Stopped)
  //   Process a list of Ints and return all outputs.
  def exercise6_behaviorsSame(messages: List[Int]): List[String] = ???

  // Exercise 7: Behaviors.stopped — graceful termination
  // TODO: Given a list of GreeterCommands, process until StopGreeter.
  //   Before stopping, produce a "cleanup" log entry: "Cleaning up N greetings"
  //   where N is the number of Greet messages processed.
  //   Return all log entries including the cleanup.
  def exercise7_behaviorsStopped(messages: List[GreeterCommand]): List[String] = ???

  // Exercise 8: Typed actor hierarchy — parent-child communication
  // TODO: Simulate a parent actor that manages child workers.
  //   Parent receives tasks (strings). It distributes them round-robin to children.
  //   Given N children names and a list of tasks, return Map[String, List[String]]
  //   (childName -> tasks assigned to it).
  def exercise8_typedHierarchy(childNames: List[String], tasks: List[String]): Map[String, List[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val b1 = exercise1_receiveMessage("Hello")
    b1 match {
      case Receive(handler) =>
        val (out1, next1) = handler(Greet("Alice"))
        assert(out1 == List("Hello, Alice!"), s"Exercise 1 failed: $out1")
        assert(next1.isInstanceOf[Same[_]], "Exercise 1 failed: should be Same")
        val (out1b, next1b) = handler(StopGreeter)
        assert(next1b.isInstanceOf[Stopped[_]], "Exercise 1 failed: should be Stopped")
      case _ => assert(false, "Exercise 1 failed: should be Receive")
    }
    println("Exercise 1 passed: receiveMessage behavior")

    // Exercise 2
    val ctx2 = ActorContext[GreeterCommand]("greeter-1", Map.empty, Nil)
    val (log2a, beh2a) = exercise2_receiveWithContext(ctx2, Greet("Bob"))
    assert(log2a == List("[greeter-1] Greeting Bob"), s"Exercise 2 failed: $log2a")
    assert(beh2a.isInstanceOf[Same[_]], "Exercise 2 failed: should be Same")
    val (log2b, beh2b) = exercise2_receiveWithContext(ctx2, StopGreeter)
    assert(beh2b.isInstanceOf[Stopped[_]], "Exercise 2 failed: should be Stopped")
    println("Exercise 2 passed: receive with context")

    // Exercise 3
    val (setupLog, children3, beh3) = exercise3_setup("my-actor")
    assert(setupLog.contains("Actor my-actor starting up"), s"Exercise 3 failed: $setupLog")
    assert(children3.size == 2, s"Exercise 3 failed: ${children3.size} children")
    assert(beh3.isInstanceOf[Receive[_]], "Exercise 3 failed: should return Receive behavior")
    println(s"Exercise 3 passed: setup with ${children3.size} children")

    // Exercise 4
    val ctx4 = ActorContext[String]("parent", Map.empty, Nil)
    val ctx4b = exercise4_spawn(ctx4, "child-1", "worker")
    assert(ctx4b.children.contains("child-1"), "Exercise 4 failed: child not spawned")
    val ctx4c = exercise4_spawn(ctx4b, "child-1", "worker")
    assert(ctx4c.children.size == 1, "Exercise 4 failed: duplicate should not add")
    println("Exercise 4 passed: spawn child actors")

    // Exercise 5
    val b5 = exercise1_receiveMessage("Hi")
    val logs5 = exercise5_processMessages(b5, List(Greet("A"), Greet("B"), StopGreeter, Greet("C")))
    assert(logs5 == List("Hi, A!", "Hi, B!", "Stopping"), s"Exercise 5 failed: $logs5")
    println(s"Exercise 5 passed: $logs5")

    // Exercise 6
    val r6 = exercise6_behaviorsSame(List(5, 3, 0, 2, 0, -1, 10))
    assert(r6 == List("8", "10", "Stopped"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = exercise7_behaviorsStopped(List(Greet("A"), Greet("B"), Greet("C"), StopGreeter, Greet("D")))
    assert(r7.last == "Cleaning up 3 greetings", s"Exercise 7 failed: ${r7.last}")
    println(s"Exercise 7 passed: ${r7.last}")

    // Exercise 8
    val r8 = exercise8_typedHierarchy(List("w1", "w2", "w3"), List("t1", "t2", "t3", "t4", "t5"))
    assert(r8("w1") == List("t1", "t4"), s"Exercise 8 failed: w1 = ${r8("w1")}")
    assert(r8("w2") == List("t2", "t5"), s"Exercise 8 failed: w2 = ${r8("w2")}")
    assert(r8("w3") == List("t3"), s"Exercise 8 failed: w3 = ${r8("w3")}")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka023_TypedActors exercises passed!")
  }
}
