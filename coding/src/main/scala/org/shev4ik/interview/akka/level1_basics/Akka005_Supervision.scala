package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 005 - Supervision Strategies
 *
 * Supervision is the mechanism by which parent actors handle child failures:
 *   - OneForOneStrategy: only the failing child is affected
 *   - AllForOneStrategy: all children are affected when one fails
 *   - Directive.Resume: ignore the failure, keep processing
 *   - Directive.Restart: restart the child, clearing state
 *   - Directive.Stop: permanently stop the child
 *   - Directive.Escalate: propagate failure to parent's supervisor
 *   - Supervision hierarchy: each actor supervises its children
 *   - maxNrOfRetries/withinTimeRange: limits on restart frequency
 */
object Akka005_Supervision {

  // --- Domain models ---

  sealed trait Directive
  object Directive {
    case object Resume extends Directive
    case object Restart extends Directive
    case object Stop extends Directive
    case object Escalate extends Directive
  }

  sealed trait StrategyType
  case object OneForOne extends StrategyType
  case object AllForOne extends StrategyType

  case class SupervisionStrategy(
    strategyType: StrategyType,
    maxRetries: Int,
    withinMs: Long,
    decider: Throwable => Directive
  )

  case class ChildActor(
    name: String,
    isRunning: Boolean,
    restartCount: Int,
    failureLog: List[String]
  )

  case class SupervisorState(
    name: String,
    strategy: SupervisionStrategy,
    children: Map[String, ChildActor]
  )

  // Exercise 1: OneForOneStrategy — define a basic decider
  // TODO: Create a SupervisionStrategy with OneForOne, maxRetries=3, withinMs=1000,
  //   and a decider that:
  //   - ArithmeticException -> Resume
  //   - NullPointerException -> Restart
  //   - IllegalArgumentException -> Stop
  //   - Any other Throwable -> Escalate
  def exercise1_oneForOneStrategy: SupervisionStrategy = ???

  // Exercise 2: AllForOneStrategy — all children affected
  // TODO: Create a SupervisionStrategy with AllForOne, maxRetries=5, withinMs=5000,
  //   and a decider that:
  //   - RuntimeException -> Restart
  //   - Any other Throwable -> Escalate
  def exercise2_allForOneStrategy: SupervisionStrategy = ???

  // Exercise 3: Apply Resume directive
  // TODO: Given a SupervisorState and a child name that failed with an exception message,
  //   if the decider returns Resume, add the message to the child's failureLog
  //   but keep isRunning=true and do NOT increment restartCount.
  //   Return the updated SupervisorState. If child not found, return state unchanged.
  def exercise3_resumeDirective(state: SupervisorState, childName: String, error: Throwable): SupervisorState = ???

  // Exercise 4: Apply Restart directive
  // TODO: Given a SupervisorState and a child name that failed:
  //   If strategy is OneForOne: restart only that child (isRunning=true, restartCount+1, clear failureLog)
  //   If strategy is AllForOne: restart ALL children (same logic for each)
  //   Return updated SupervisorState.
  def exercise4_restartDirective(state: SupervisorState, childName: String): SupervisorState = ???

  // Exercise 5: Apply Stop directive
  // TODO: Given a SupervisorState and a child name:
  //   If strategy is OneForOne: stop only that child (isRunning=false)
  //   If strategy is AllForOne: stop ALL children
  //   Return updated SupervisorState.
  def exercise5_stopDirective(state: SupervisorState, childName: String): SupervisorState = ???

  // Exercise 6: Apply Escalate directive
  // TODO: Given a SupervisorState and an exception, return a tuple:
  //   (supervisorName, exceptionMessage) indicating escalation to the parent.
  //   The supervisor itself should be considered "failed".
  def exercise6_escalateDirective(state: SupervisorState, error: Throwable): (String, String) = ???

  // Exercise 7: Supervision hierarchy — process a series of child failures
  // TODO: Given a SupervisorState and a list of (childName, Throwable) failures,
  //   process each failure using the supervisor's decider and apply the appropriate directive:
  //   - Resume: exercise3 logic
  //   - Restart: exercise4 logic
  //   - Stop: exercise5 logic
  //   - Escalate: stop processing further failures, return current state
  //   Return the final SupervisorState.
  def exercise7_supervisionHierarchy(
    state: SupervisorState,
    failures: List[(String, Throwable)]
  ): SupervisorState = ???

  // Exercise 8: Max retries check
  // TODO: Given a SupervisorState and a child name, check if the child has exceeded
  //   the max retries limit. Return true if restartCount >= strategy.maxRetries, false otherwise.
  //   If child not found, return false.
  //   Also return the remaining retries: maxRetries - restartCount (min 0).
  def exercise8_maxRetriesCheck(state: SupervisorState, childName: String): (Boolean, Int) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val s1 = exercise1_oneForOneStrategy
    assert(s1.strategyType == OneForOne, "Exercise 1 failed: wrong strategy type")
    assert(s1.maxRetries == 3, "Exercise 1 failed: wrong maxRetries")
    assert(s1.decider(new ArithmeticException) == Directive.Resume, "Exercise 1 failed: ArithmeticException")
    assert(s1.decider(new NullPointerException) == Directive.Restart, "Exercise 1 failed: NullPointerException")
    assert(s1.decider(new IllegalArgumentException) == Directive.Stop, "Exercise 1 failed: IllegalArgumentException")
    assert(s1.decider(new Exception("other")) == Directive.Escalate, "Exercise 1 failed: other exception")
    println("Exercise 1 passed: OneForOneStrategy defined")

    // Exercise 2
    val s2 = exercise2_allForOneStrategy
    assert(s2.strategyType == AllForOne, "Exercise 2 failed: wrong strategy type")
    assert(s2.decider(new RuntimeException) == Directive.Restart, "Exercise 2 failed: RuntimeException")
    assert(s2.decider(new Error("fatal")) == Directive.Escalate, "Exercise 2 failed: Error")
    println("Exercise 2 passed: AllForOneStrategy defined")

    // Exercise 3
    val child1 = ChildActor("worker-1", isRunning = true, restartCount = 0, failureLog = Nil)
    val child2 = ChildActor("worker-2", isRunning = true, restartCount = 0, failureLog = Nil)
    val sup3 = SupervisorState("sup", s1, Map("worker-1" -> child1, "worker-2" -> child2))
    val r3 = exercise3_resumeDirective(sup3, "worker-1", new ArithmeticException("div by zero"))
    val c3 = r3.children("worker-1")
    assert(c3.isRunning, "Exercise 3 failed: should still be running")
    assert(c3.restartCount == 0, "Exercise 3 failed: should not restart")
    assert(c3.failureLog == List("div by zero"), s"Exercise 3 failed: failureLog = ${c3.failureLog}")
    println("Exercise 3 passed: Resume directive applied")

    // Exercise 4 - OneForOne
    val sup4 = SupervisorState("sup", s1, Map("worker-1" -> child1.copy(failureLog = List("err")), "worker-2" -> child2))
    val r4 = exercise4_restartDirective(sup4, "worker-1")
    assert(r4.children("worker-1").restartCount == 1, "Exercise 4 failed: restartCount should be 1")
    assert(r4.children("worker-1").failureLog.isEmpty, "Exercise 4 failed: failureLog should be cleared")
    assert(r4.children("worker-2").restartCount == 0, "Exercise 4 failed: worker-2 should be unaffected")
    // AllForOne
    val sup4b = SupervisorState("sup", s2, Map("worker-1" -> child1, "worker-2" -> child2))
    val r4b = exercise4_restartDirective(sup4b, "worker-1")
    assert(r4b.children("worker-2").restartCount == 1, "Exercise 4 failed: AllForOne should restart all")
    println("Exercise 4 passed: Restart directive applied")

    // Exercise 5
    val sup5 = SupervisorState("sup", s1, Map("worker-1" -> child1, "worker-2" -> child2))
    val r5 = exercise5_stopDirective(sup5, "worker-1")
    assert(!r5.children("worker-1").isRunning, "Exercise 5 failed: worker-1 should be stopped")
    assert(r5.children("worker-2").isRunning, "Exercise 5 failed: worker-2 should be running")
    println("Exercise 5 passed: Stop directive applied")

    // Exercise 6
    val (name6, msg6) = exercise6_escalateDirective(sup5, new Exception("fatal error"))
    assert(name6 == "sup", s"Exercise 6 failed: name = $name6")
    assert(msg6 == "fatal error", s"Exercise 6 failed: msg = $msg6")
    println("Exercise 6 passed: Escalate directive applied")

    // Exercise 7
    val failures = List(
      ("worker-1", new ArithmeticException("div/0")),      // Resume
      ("worker-2", new NullPointerException("null")),       // Restart
      ("worker-1", new IllegalArgumentException("bad arg")) // Stop
    )
    val r7 = exercise7_supervisionHierarchy(sup3, failures)
    assert(!r7.children("worker-1").isRunning, "Exercise 7 failed: worker-1 should be stopped")
    assert(r7.children("worker-2").restartCount == 1, "Exercise 7 failed: worker-2 should have restarted")
    println("Exercise 7 passed: supervision hierarchy processed")

    // Exercise 8
    val child8 = ChildActor("w", isRunning = true, restartCount = 2, failureLog = Nil)
    val sup8 = SupervisorState("s", s1, Map("w" -> child8)) // maxRetries=3
    val (exceeded8a, remaining8a) = exercise8_maxRetriesCheck(sup8, "w")
    assert(!exceeded8a, "Exercise 8 failed: should not be exceeded at 2/3")
    assert(remaining8a == 1, s"Exercise 8 failed: remaining should be 1, got $remaining8a")
    val child8b = child8.copy(restartCount = 3)
    val sup8b = sup8.copy(children = Map("w" -> child8b))
    val (exceeded8b, remaining8b) = exercise8_maxRetriesCheck(sup8b, "w")
    assert(exceeded8b, "Exercise 8 failed: should be exceeded at 3/3")
    assert(remaining8b == 0, s"Exercise 8 failed: remaining should be 0, got $remaining8b")
    println("Exercise 8 passed: max retries check works")

    println("\nAll Akka005_Supervision exercises passed!")
  }
}
