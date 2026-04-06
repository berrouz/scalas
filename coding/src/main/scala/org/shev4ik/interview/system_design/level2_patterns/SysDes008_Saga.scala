package org.shev4ik.interview.system_design.level2_patterns

object SysDes008_Saga {

  // ---- Domain types ----

  sealed trait SagaStepStatus
  case object Pending extends SagaStepStatus
  case object Completed extends SagaStepStatus
  case object Failed extends SagaStepStatus
  case object Compensated extends SagaStepStatus

  case class SagaStep(
    name: String,
    status: SagaStepStatus = Pending,
    execute: () => Boolean,      // returns true if successful
    compensate: () => Boolean     // compensation action
  )

  sealed trait SagaState
  case object SagaRunning extends SagaState
  case object SagaCompleted extends SagaState
  case object SagaCompensating extends SagaState
  case object SagaFailed extends SagaState

  case class SagaLogEntry(stepName: String, action: String, success: Boolean, timestamp: Long)

  // ---- Exercise 1 ----
  // TODO: Implement a choreography-based saga.
  // Each step knows the next step. Execute steps in order.
  // If a step fails, compensate all previously completed steps in reverse order.
  // Return (finalSteps: List[(String, SagaStepStatus)], success: Boolean)
  // The steps are provided as a list; execute them sequentially.
  def choreographySaga(steps: List[SagaStep]): (List[(String, SagaStepStatus)], Boolean) = ???

  // ---- Exercise 2 ----
  // TODO: Implement an orchestration-based saga.
  // A central orchestrator manages the saga execution.
  // Same logic as choreography but the orchestrator explicitly controls flow.
  // Additionally, return a log of actions taken: List[(stepName, action="execute"|"compensate", success)]
  def orchestrationSaga(steps: List[SagaStep]): (List[(String, SagaStepStatus)], List[(String, String, Boolean)]) = ???

  // ---- Exercise 3 ----
  // TODO: Implement compensating transactions.
  // Given a list of completed step names and their compensate functions,
  // execute compensations in reverse order.
  // Return List[(stepName, compensationSuccess: Boolean)]
  def compensate(completedSteps: List[(String, () => Boolean)]): List[(String, Boolean)] = ???

  // ---- Exercise 4 ----
  // TODO: Implement a saga coordinator.
  // The coordinator manages the overall saga lifecycle:
  // - `startSaga(steps)`: begin execution
  // - Returns the final SagaState and the step statuses
  // If all steps complete, state=SagaCompleted.
  // If any step fails and all compensations succeed, state=SagaCompensating (then done).
  // If a compensation fails, state=SagaFailed.
  trait SagaCoordinator {
    def executeSaga(steps: List[SagaStep]): (SagaState, List[(String, SagaStepStatus)])
  }

  def createSagaCoordinator(): SagaCoordinator = ???

  // ---- Exercise 5 ----
  // TODO: Implement a saga state machine.
  // States: Running, Compensating, Completed, Failed
  // Transitions:
  //   Running + StepSuccess (with more steps) => Running
  //   Running + StepSuccess (no more steps) => Completed
  //   Running + StepFailure => Compensating
  //   Compensating + CompensationSuccess (more to compensate) => Compensating
  //   Compensating + CompensationSuccess (none left) => Completed
  //   Compensating + CompensationFailure => Failed
  // Implement `transition(currentState, event)` returning the new state.
  sealed trait SagaEvent
  case object StepSuccess extends SagaEvent
  case object StepFailure extends SagaEvent
  case object CompensationSuccess extends SagaEvent
  case object CompensationFailure extends SagaEvent

  def transition(
    currentState: SagaState,
    event: SagaEvent,
    remainingSteps: Int,
    remainingCompensations: Int
  ): SagaState = ???

  // ---- Exercise 6 ----
  // TODO: Implement a saga log.
  // Record every action (execute/compensate) with its result and timestamp.
  // - `logAction(log, stepName, action, success, timestamp)`: append entry
  // - `getLogForStep(log, stepName)`: get all entries for a step
  // - `fullLog(log)`: return all entries in order
  def logAction(
    log: List[SagaLogEntry],
    stepName: String,
    action: String,
    success: Boolean,
    timestamp: Long
  ): List[SagaLogEntry] = ???

  def getLogForStep(log: List[SagaLogEntry], stepName: String): List[SagaLogEntry] = ???

  // ---- Exercise 7 ----
  // TODO: Implement saga failure handling with retry.
  // Execute a step up to `maxRetries` times before declaring failure.
  // If all retries fail, trigger compensation.
  // Return (success: Boolean, attempts: Int)
  def executeWithRetry(step: SagaStep, maxRetries: Int): (Boolean, Int) = ???

  // Full saga with retry per step:
  def sagaWithRetry(steps: List[SagaStep], maxRetries: Int): (List[(String, SagaStepStatus)], Boolean) = ???

  // ---- Exercise 8 ----
  // TODO: Implement saga timeout handling.
  // Each step has a simulated duration. If the total saga duration exceeds
  // the timeout, abort remaining steps and compensate completed ones.
  // `stepDurations`: Map[stepName, durationMs]
  // `timeoutMs`: max allowed total duration
  // Return (completedSteps, timedOut: Boolean)
  def sagaWithTimeout(
    steps: List[SagaStep],
    stepDurations: Map[String, Long],
    timeoutMs: Long
  ): (List[(String, SagaStepStatus)], Boolean) = ???

  def main(args: Array[String]): Unit = {
    // Helper to create steps
    def okStep(name: String) = SagaStep(name, execute = () => true, compensate = () => true)
    def failStep(name: String) = SagaStep(name, execute = () => false, compensate = () => true)

    // Exercise 1: Choreography Saga
    val (cSteps1, cSuccess1) = choreographySaga(List(okStep("s1"), okStep("s2"), okStep("s3")))
    assert(cSuccess1)
    assert(cSteps1.forall(_._2 == Completed))
    val (cSteps2, cSuccess2) = choreographySaga(List(okStep("s1"), failStep("s2"), okStep("s3")))
    assert(!cSuccess2)
    assert(cSteps2.find(_._1 == "s1").get._2 == Compensated)
    assert(cSteps2.find(_._1 == "s2").get._2 == Failed)
    println("Exercise 1 passed: Choreography Saga")

    // Exercise 2: Orchestration Saga
    val (oSteps, oLog) = orchestrationSaga(List(okStep("s1"), failStep("s2")))
    assert(oLog.exists(e => e._1 == "s1" && e._2 == "execute" && e._3))
    assert(oLog.exists(e => e._1 == "s2" && e._2 == "execute" && !e._3))
    assert(oLog.exists(e => e._1 == "s1" && e._2 == "compensate"))
    println("Exercise 2 passed: Orchestration Saga")

    // Exercise 3: Compensating Transactions
    val compResults = compensate(List(("s1", () => true), ("s2", () => true), ("s3", () => false)))
    assert(compResults == List(("s3", false), ("s2", true), ("s1", true)))
    println("Exercise 3 passed: Compensating Transactions")

    // Exercise 4: Saga Coordinator
    val coord = createSagaCoordinator()
    val (state1, steps1) = coord.executeSaga(List(okStep("s1"), okStep("s2")))
    assert(state1 == SagaCompleted)
    val (state2, _) = coord.executeSaga(List(okStep("s1"), failStep("s2")))
    assert(state2 == SagaCompensating || state2 == SagaCompleted)
    println("Exercise 4 passed: Saga Coordinator")

    // Exercise 5: Saga State Machine
    assert(transition(SagaRunning, StepSuccess, remainingSteps = 2, remainingCompensations = 0) == SagaRunning)
    assert(transition(SagaRunning, StepSuccess, remainingSteps = 0, remainingCompensations = 0) == SagaCompleted)
    assert(transition(SagaRunning, StepFailure, remainingSteps = 1, remainingCompensations = 2) == SagaCompensating)
    assert(transition(SagaCompensating, CompensationSuccess, remainingSteps = 0, remainingCompensations = 0) == SagaCompleted)
    assert(transition(SagaCompensating, CompensationFailure, remainingSteps = 0, remainingCompensations = 1) == SagaFailed)
    println("Exercise 5 passed: Saga State Machine")

    // Exercise 6: Saga Log
    val log0 = List.empty[SagaLogEntry]
    val log1 = logAction(log0, "s1", "execute", success = true, 100)
    val log2 = logAction(log1, "s2", "execute", success = false, 200)
    val log3 = logAction(log2, "s1", "compensate", success = true, 300)
    assert(log3.length == 3)
    assert(getLogForStep(log3, "s1").length == 2)
    println("Exercise 6 passed: Saga Log")

    // Exercise 7: Failure handling with retry
    var retryCount = 0
    val retryStep = SagaStep("retry", execute = () => { retryCount += 1; retryCount >= 3 }, compensate = () => true)
    val (rSuccess, rAttempts) = executeWithRetry(retryStep, maxRetries = 5)
    assert(rSuccess)
    assert(rAttempts == 3)

    retryCount = 0
    val (srSteps, srSuccess) = sagaWithRetry(List(okStep("s1"), retryStep), maxRetries = 5)
    assert(srSuccess)
    println("Exercise 7 passed: Failure handling with retry")

    // Exercise 8: Timeout handling
    val durations = Map("s1" -> 100L, "s2" -> 200L, "s3" -> 300L)
    val (toSteps1, timedOut1) = sagaWithTimeout(
      List(okStep("s1"), okStep("s2"), okStep("s3")),
      durations,
      timeoutMs = 500
    )
    assert(timedOut1) // 100+200+300=600 > 500
    val (toSteps2, timedOut2) = sagaWithTimeout(
      List(okStep("s1"), okStep("s2"), okStep("s3")),
      durations,
      timeoutMs = 700
    )
    assert(!timedOut2)
    println("Exercise 8 passed: Timeout handling")

    println("All SysDes008_Saga exercises passed!")
  }
}
