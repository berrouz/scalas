package org.shev4ik.interview.akka.level3_advanced

/**
 * Akka 024 - Typed Actor Patterns
 *
 * Advanced patterns in Akka Typed:
 *   - Typed Ask: type-safe request-response with Future
 *   - Typed Receptionist: service discovery for typed actors
 *   - Typed Stash: buffer messages during initialization
 *   - Typed Timer: schedule messages to self
 *   - Typed Supervision: typed supervision strategies
 *   - Typed Cluster: cluster features for typed actors
 *   - Service Discovery: find actors by service key
 *   - Interaction Patterns: fire-and-forget, request-response, adapted response
 *
 * We model these concepts using pure Scala.
 */
object Akka024_TypedPatterns {

  // --- Domain models ---

  sealed trait ServiceKey
  case class TypedServiceKey(name: String, protocol: String) extends ServiceKey

  case class ServiceRegistration(key: ServiceKey, actorName: String)

  case class Receptionist(
    registrations: Map[ServiceKey, Set[String]] // key -> set of actor names
  )

  case class TimerSchedule(
    timerKey: String,
    message: String,
    intervalMs: Long,
    isRepeating: Boolean
  )

  sealed trait SupervisionStrategy
  case object TypedResume extends SupervisionStrategy
  case object TypedRestart extends SupervisionStrategy
  case object TypedStop extends SupervisionStrategy
  case class TypedBackoff(minMs: Long, maxMs: Long, randomFactor: Double) extends SupervisionStrategy

  sealed trait InteractionPattern
  case class FireAndForget(target: String, message: String) extends InteractionPattern
  case class RequestResponse(target: String, request: String, expectedResponse: String) extends InteractionPattern
  case class AdaptedResponse(target: String, request: String, adaptor: String => String) extends InteractionPattern

  case class StashState[A](buffer: List[A], maxCapacity: Int, isReady: Boolean)

  // Exercise 1: Typed Ask pattern
  // TODO: Simulate a typed ask. Given a request message and a response handler function,
  //   create a "response adapter" that converts the response to the caller's protocol.
  //   Given request, responseGenerator (simulates the target actor), and adaptor function,
  //   return the adapted response.
  //   In real Akka: context.ask(target, ref => Request(data, ref)) { case Success(resp) => Adapted(resp) }
  def exercise1_typedAsk[Req, Resp, Adapted](
    request: Req,
    responseGenerator: Req => Resp,
    adaptor: Resp => Adapted
  ): Adapted = ???

  // Exercise 2: Typed Receptionist — service registration and discovery
  // TODO: Process a list of operations on a Receptionist:
  //   ("register", keyName, actorName): register actor under the service key
  //   ("deregister", keyName, actorName): remove actor from service key
  //   ("find", keyName, _): return actors registered under that key
  //   All keys use protocol="default".
  //   Return (finalReceptionist, findResults) where findResults is a list of Set[String]
  //   for each "find" operation.
  def exercise2_typedReceptionist(
    initial: Receptionist,
    operations: List[(String, String, String)]
  ): (Receptionist, List[Set[String]]) = ???

  // Exercise 3: Typed Stash — buffer during initialization
  // TODO: Simulate stash behavior. Given a StashState and messages:
  //   - When !isReady: stash messages up to maxCapacity (drop oldest if overflow)
  //   - "READY" message: set isReady=true, unstash all buffered messages
  //   - When isReady: process immediately (add to result list)
  //   Return (processedMessages, finalStashState).
  def exercise3_typedStash(
    initial: StashState[String],
    messages: List[String]
  ): (List[String], StashState[String]) = ???

  // Exercise 4: Typed Timer — schedule messages
  // TODO: Given a list of TimerSchedules and a duration (totalMs),
  //   calculate all messages that would fire within the duration.
  //   Non-repeating: fires once at intervalMs.
  //   Repeating: fires at intervalMs, 2*intervalMs, 3*intervalMs, etc.
  //   Return List[(Long, String)] sorted by timestamp (timestamp, message).
  def exercise4_typedTimer(schedules: List[TimerSchedule], totalMs: Long): List[(Long, String)] = ???

  // Exercise 5: Typed Supervision — strategy selection
  // TODO: Given a list of (exceptionClass: String, SupervisionStrategy) mappings,
  //   and a list of exceptions (as class name strings), determine what action to take:
  //   Match by exception class name. If no match, default to TypedStop.
  //   Return the list of strategies applied.
  def exercise5_typedSupervision(
    strategies: List[(String, SupervisionStrategy)],
    exceptions: List[String]
  ): List[SupervisionStrategy] = ???

  // Exercise 6: Typed Cluster — node role assignment
  // TODO: Given a list of (nodeName, roles) and a service to deploy (serviceName, requiredRole),
  //   return the list of nodes that can host the service (have the required role).
  //   If requiredRole is empty, all nodes are eligible.
  def exercise6_typedCluster(
    nodes: List[(String, Set[String])],
    requiredRole: String
  ): List[String] = ???

  // Exercise 7: Service Discovery — find and select
  // TODO: Given a Receptionist with registrations, implement service discovery:
  //   Find all actors registered under a key, then select one using
  //   the provided strategy: "first", "random" (use index), or "round-robin" (use callCount).
  //   Return the selected actor name, or None if no actors registered.
  def exercise7_serviceDiscovery(
    receptionist: Receptionist,
    keyName: String,
    strategy: String,
    callCount: Int // used for round-robin index
  ): Option[String] = ???

  // Exercise 8: Interaction Patterns — process a list of interactions
  // TODO: Given a list of InteractionPatterns, simulate each:
  //   - FireAndForget: return "Sent {message} to {target}"
  //   - RequestResponse: return "Response from {target}: {expectedResponse}"
  //   - AdaptedResponse: apply adaptor to "{target}:{request}" and return result
  //   Return the list of result strings.
  def exercise8_interactionPatterns(patterns: List[InteractionPattern]): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_typedAsk[String, Int, String](
      "compute",
      _.length,
      n => s"Length is $n"
    )
    assert(r1 == "Length is 7", s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val rec0 = Receptionist(Map.empty)
    val ops2 = List(
      ("register", "service-A", "actor-1"),
      ("register", "service-A", "actor-2"),
      ("find", "service-A", ""),
      ("deregister", "service-A", "actor-1"),
      ("find", "service-A", "")
    )
    val (rec2, finds2) = exercise2_typedReceptionist(rec0, ops2)
    assert(finds2(0) == Set("actor-1", "actor-2"), s"Exercise 2 failed: first find = ${finds2(0)}")
    assert(finds2(1) == Set("actor-2"), s"Exercise 2 failed: second find = ${finds2(1)}")
    println("Exercise 2 passed: typed receptionist")

    // Exercise 3
    val stash3 = StashState[String](Nil, 3, isReady = false)
    val (processed3, final3) = exercise3_typedStash(stash3, List("a", "b", "READY", "c", "d"))
    assert(processed3 == List("a", "b", "c", "d"), s"Exercise 3 failed: $processed3")
    assert(final3.isReady, "Exercise 3 failed: should be ready")
    println(s"Exercise 3 passed: $processed3")

    // Exercise 4
    val schedules = List(
      TimerSchedule("t1", "tick", 100L, isRepeating = true),
      TimerSchedule("t2", "once", 250L, isRepeating = false)
    )
    val r4 = exercise4_typedTimer(schedules, 350L)
    // tick at 100, 200, 300; once at 250
    assert(r4.map(_._1) == List(100L, 200L, 250L, 300L), s"Exercise 4 failed: ${r4.map(_._1)}")
    println(s"Exercise 4 passed: ${r4.size} timer events")

    // Exercise 5
    val strats = List(
      ("ArithmeticException", TypedResume),
      ("NullPointerException", TypedRestart),
      ("IllegalArgumentException", TypedStop)
    )
    val r5 = exercise5_typedSupervision(strats, List("ArithmeticException", "UnknownException", "NullPointerException"))
    assert(r5 == List(TypedResume, TypedStop, TypedRestart), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: $r5")

    // Exercise 6
    val nodes6 = List(
      ("node-1", Set("frontend", "backend")),
      ("node-2", Set("backend")),
      ("node-3", Set("frontend")),
      ("node-4", Set("worker"))
    )
    val r6 = exercise6_typedCluster(nodes6, "backend")
    assert(r6 == List("node-1", "node-2"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val rec7 = Receptionist(Map(
      TypedServiceKey("svc", "default") -> Set("actor-A", "actor-B", "actor-C")
    ))
    val r7a = exercise7_serviceDiscovery(rec7, "svc", "first", 0)
    assert(r7a.isDefined, "Exercise 7 failed: should find an actor")
    val r7b = exercise7_serviceDiscovery(rec7, "svc", "round-robin", 1)
    val r7c = exercise7_serviceDiscovery(rec7, "svc", "round-robin", 2)
    assert(r7b != r7c || rec7.registrations(TypedServiceKey("svc", "default")).size == 1,
      "Exercise 7 failed: round-robin should give different actors")
    val r7d = exercise7_serviceDiscovery(rec7, "unknown", "first", 0)
    assert(r7d.isEmpty, "Exercise 7 failed: should be None for unknown key")
    println("Exercise 7 passed: service discovery")

    // Exercise 8
    val patterns = List(
      FireAndForget("actor-1", "ping"),
      RequestResponse("actor-2", "status", "healthy"),
      AdaptedResponse("actor-3", "query", s => s"Adapted: $s")
    )
    val r8 = exercise8_interactionPatterns(patterns)
    assert(r8(0) == "Sent ping to actor-1", s"Exercise 8 failed: ${r8(0)}")
    assert(r8(1) == "Response from actor-2: healthy", s"Exercise 8 failed: ${r8(1)}")
    assert(r8(2) == "Adapted: actor-3:query", s"Exercise 8 failed: ${r8(2)}")
    println(s"Exercise 8 passed: $r8")

    println("\nAll Akka024_TypedPatterns exercises passed!")
  }
}
