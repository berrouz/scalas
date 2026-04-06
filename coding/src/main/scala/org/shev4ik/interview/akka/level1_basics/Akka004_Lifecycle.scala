package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 004 - Actor Lifecycle
 *
 * Every actor has a lifecycle managed by the ActorSystem:
 *   - preStart: called before the actor processes its first message
 *   - postStop: called after the actor is stopped
 *   - preRestart(reason, message): called before restart due to failure
 *   - postRestart(reason): called after restart, before resuming
 *   - DeathWatch: monitoring another actor's termination via context.watch
 *   - Terminated(ref): message received when a watched actor stops
 *   - Lifecycle hooks execute in a defined order
 */
object Akka004_Lifecycle {

  // --- Domain models ---

  sealed trait LifecycleHook
  case object PreStart extends LifecycleHook
  case object PostStop extends LifecycleHook
  case class PreRestart(reason: String, message: Option[String]) extends LifecycleHook
  case class PostRestart(reason: String) extends LifecycleHook

  case class ActorState(
    name: String,
    isStarted: Boolean,
    isStopped: Boolean,
    restartCount: Int,
    hookLog: List[LifecycleHook]
  )

  sealed trait ActorEvent
  case object Start extends ActorEvent
  case object Stop extends ActorEvent
  case class Restart(reason: String) extends ActorEvent
  case class ProcessMessage(msg: String) extends ActorEvent
  case class Watch(targetName: String) extends ActorEvent
  case class TargetStopped(targetName: String) extends ActorEvent

  case class Terminated(actorName: String)

  case class WatchState(
    watchedActors: Set[String],
    terminationLog: List[Terminated]
  )

  // Exercise 1: Simulate preStart hook
  // TODO: Given an ActorState with isStarted=false, simulate the preStart lifecycle.
  //   Set isStarted=true and append PreStart to hookLog.
  //   If already started, return the state unchanged.
  def exercise1_preStart(state: ActorState): ActorState = ???

  // Exercise 2: Simulate postStop hook
  // TODO: Given an ActorState, simulate the postStop lifecycle.
  //   Set isStopped=true, isStarted=false, and append PostStop to hookLog.
  //   If already stopped, return the state unchanged.
  def exercise2_postStop(state: ActorState): ActorState = ???

  // Exercise 3: Simulate preRestart hook
  // TODO: Given an ActorState, a failure reason string, and an optional message that caused the failure,
  //   append PreRestart(reason, message) to hookLog.
  //   Then call postStop logic (append PostStop, set isStopped=true, isStarted=false).
  //   Return the updated state.
  def exercise3_preRestart(state: ActorState, reason: String, message: Option[String]): ActorState = ???

  // Exercise 4: Simulate postRestart hook
  // TODO: Given an ActorState (after preRestart was called),
  //   append PostRestart(reason) to hookLog, increment restartCount,
  //   then call preStart logic (set isStarted=true, isStopped=false, append PreStart).
  //   Return the updated state.
  def exercise4_postRestart(state: ActorState, reason: String): ActorState = ???

  // Exercise 5: Full lifecycle hooks order
  // TODO: Process a list of ActorEvents and return the final ActorState.
  //   - Start: apply preStart logic (exercise1)
  //   - Stop: apply postStop logic (exercise2)
  //   - Restart(reason): apply preRestart then postRestart in sequence
  //   - ProcessMessage(msg): only if isStarted && !isStopped, append nothing; otherwise ignore
  //   Start from a fresh ActorState(name, false, false, 0, Nil).
  def exercise5_lifecycleOrder(name: String, events: List[ActorEvent]): ActorState = ???

  // Exercise 6: DeathWatch — watching other actors
  // TODO: Given a WatchState and a list of ActorEvents:
  //   - Watch(target): add target to watchedActors
  //   - TargetStopped(target): if target is in watchedActors, add Terminated(target) to terminationLog
  //     and remove from watchedActors. If not watched, ignore.
  //   - Other events: ignore.
  //   Return the final WatchState.
  def exercise6_deathWatch(initial: WatchState, events: List[ActorEvent]): WatchState = ???

  // Exercise 7: Terminated message handling
  // TODO: Given a list of Terminated messages and a mapping of actor names to "roles" (Map[String, String]),
  //   return a list of strings describing each termination:
  //   "Actor {name} with role {role} has terminated" if name is in the role map,
  //   "Unknown actor {name} has terminated" otherwise.
  def exercise7_terminatedMessages(
    terminated: List[Terminated],
    roles: Map[String, String]
  ): List[String] = ???

  // Exercise 8: Lifecycle monitoring — aggregate restart statistics
  // TODO: Given a list of ActorStates (one per actor), return a Map[String, (Int, Boolean)]
  //   where the key is actor name, and the value is (restartCount, isCurrentlyRunning).
  //   An actor is "currently running" if isStarted && !isStopped.
  def exercise8_lifecycleMonitoring(actors: List[ActorState]): Map[String, (Int, Boolean)] = ???

  def main(args: Array[String]): Unit = {
    val fresh = ActorState("test", isStarted = false, isStopped = false, restartCount = 0, hookLog = Nil)

    // Exercise 1
    val r1 = exercise1_preStart(fresh)
    assert(r1.isStarted, "Exercise 1 failed: should be started")
    assert(r1.hookLog == List(PreStart), s"Exercise 1 failed: hookLog = ${r1.hookLog}")
    val r1b = exercise1_preStart(r1)
    assert(r1b == r1, "Exercise 1 failed: already started should be unchanged")
    println("Exercise 1 passed: preStart works")

    // Exercise 2
    val r2 = exercise2_postStop(r1)
    assert(r2.isStopped, "Exercise 2 failed: should be stopped")
    assert(!r2.isStarted, "Exercise 2 failed: should not be started")
    assert(r2.hookLog == List(PreStart, PostStop), s"Exercise 2 failed: hookLog = ${r2.hookLog}")
    println("Exercise 2 passed: postStop works")

    // Exercise 3
    val r3 = exercise3_preRestart(r1, "NullPointerException", Some("bad-msg"))
    assert(r3.isStopped, "Exercise 3 failed: should be stopped after preRestart")
    assert(r3.hookLog.contains(PreRestart("NullPointerException", Some("bad-msg"))),
      s"Exercise 3 failed: hookLog = ${r3.hookLog}")
    assert(r3.hookLog.last == PostStop, s"Exercise 3 failed: last hook should be PostStop")
    println("Exercise 3 passed: preRestart works")

    // Exercise 4
    val r4 = exercise4_postRestart(r3, "NullPointerException")
    assert(r4.isStarted, "Exercise 4 failed: should be started after postRestart")
    assert(r4.restartCount == 1, s"Exercise 4 failed: restartCount = ${r4.restartCount}")
    assert(r4.hookLog.last == PreStart, s"Exercise 4 failed: last hook should be PreStart")
    println("Exercise 4 passed: postRestart works")

    // Exercise 5
    val events5 = List(Start, ProcessMessage("hello"), Restart("error"), ProcessMessage("world"), Stop)
    val r5 = exercise5_lifecycleOrder("actor-1", events5)
    assert(r5.isStopped, "Exercise 5 failed: should be stopped")
    assert(r5.restartCount == 1, s"Exercise 5 failed: restartCount = ${r5.restartCount}")
    assert(r5.hookLog.head == PreStart, "Exercise 5 failed: should start with PreStart")
    assert(r5.hookLog.last == PostStop, "Exercise 5 failed: should end with PostStop")
    println(s"Exercise 5 passed: lifecycle order = ${r5.hookLog}")

    // Exercise 6
    val ws0 = WatchState(Set.empty, Nil)
    val events6 = List(Watch("child-1"), Watch("child-2"), TargetStopped("child-1"), TargetStopped("child-3"))
    val r6 = exercise6_deathWatch(ws0, events6)
    assert(r6.watchedActors == Set("child-2"), s"Exercise 6 failed: watched = ${r6.watchedActors}")
    assert(r6.terminationLog == List(Terminated("child-1")), s"Exercise 6 failed: log = ${r6.terminationLog}")
    println("Exercise 6 passed: DeathWatch works")

    // Exercise 7
    val terms = List(Terminated("worker-1"), Terminated("worker-2"), Terminated("unknown-1"))
    val roles = Map("worker-1" -> "processor", "worker-2" -> "aggregator")
    val r7 = exercise7_terminatedMessages(terms, roles)
    assert(r7.head == "Actor worker-1 with role processor has terminated", s"Exercise 7 failed: ${r7.head}")
    assert(r7(2) == "Unknown actor unknown-1 has terminated", s"Exercise 7 failed: ${r7(2)}")
    println("Exercise 7 passed: Terminated messages handled")

    // Exercise 8
    val actors = List(
      ActorState("a1", isStarted = true, isStopped = false, restartCount = 2, hookLog = Nil),
      ActorState("a2", isStarted = false, isStopped = true, restartCount = 0, hookLog = Nil),
      ActorState("a3", isStarted = true, isStopped = false, restartCount = 1, hookLog = Nil)
    )
    val r8 = exercise8_lifecycleMonitoring(actors)
    assert(r8("a1") == (2, true), s"Exercise 8 failed: a1 = ${r8("a1")}")
    assert(r8("a2") == (0, false), s"Exercise 8 failed: a2 = ${r8("a2")}")
    println("Exercise 8 passed: lifecycle monitoring works")

    println("\nAll Akka004_Lifecycle exercises passed!")
  }
}
