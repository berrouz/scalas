package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Arch047 - Incident Response
 * Level: Production Systems
 *
 * Design incident response systems, error budgets, SLO monitoring,
 * and post-mortem processes.
 *
 * Key concepts:
 * - SLI/SLO/SLA, error budgets, alerting, runbooks
 */
object Arch047_IncidentResponse {

  // Exercise 1: SLI/SLO Definition
  // TODO: Model SLIs (Service Level Indicators) and SLOs (Service Level Objectives).
  sealed trait SLIType
  case object Availability extends SLIType
  case object Latency extends SLIType
  case object Throughput extends SLIType
  case object ErrorRate extends SLIType

  case class SLI(name: String, sliType: SLIType, currentValue: Double, unit: String)
  case class SLO(sli: SLI, target: Double, window: String) {
    def isMet: Boolean = ???
    def margin: Double = ???
  }

  // Exercise 2: Error Budget Tracker
  // TODO: Implement error budget calculation and tracking.
  // Error budget = 1 - SLO target (e.g., 99.9% SLO -> 0.1% error budget)
  case class ErrorBudget(
    sloTarget: Double,        // e.g., 0.999
    windowMinutes: Long,      // e.g., 43200 (30 days)
    consumedMinutes: Double   // minutes of downtime/errors consumed
  ) {
    def totalBudgetMinutes: Double = ???
    def remainingMinutes: Double = ???
    def consumedPercent: Double = ???
    def isExhausted: Boolean = ???
    def burnRate: Double = ???  // consumption rate relative to window
  }

  // Exercise 3: Alert Rule Engine
  // TODO: Implement alerting rules with severity levels and conditions.
  sealed trait Severity
  case object Critical extends Severity
  case object Warning extends Severity
  case object Info extends Severity

  sealed trait AlertCondition
  case class ThresholdAbove(metric: String, threshold: Double) extends AlertCondition
  case class ThresholdBelow(metric: String, threshold: Double) extends AlertCondition
  case class RateOfChange(metric: String, changePercent: Double, windowMinutes: Int) extends AlertCondition

  case class AlertRule(name: String, condition: AlertCondition, severity: Severity, message: String) {
    def evaluate(metrics: Map[String, Double]): Option[Alert] = ???
  }

  case class Alert(rule: String, severity: Severity, message: String, timestamp: Long)

  // Exercise 4: Incident Classification
  // TODO: Implement incident severity classification based on impact.
  sealed trait IncidentSeverity { def level: Int }
  case object SEV1 extends IncidentSeverity { val level = 1 } // Critical: total outage
  case object SEV2 extends IncidentSeverity { val level = 2 } // Major: significant degradation
  case object SEV3 extends IncidentSeverity { val level = 3 } // Minor: partial impact
  case object SEV4 extends IncidentSeverity { val level = 4 } // Low: cosmetic/minor

  case class Incident(
    id: String,
    title: String,
    severity: IncidentSeverity,
    affectedUsers: Int,
    startTime: Long,
    resolvedTime: Option[Long]
  ) {
    def durationMinutes: Option[Long] = ???
    def isResolved: Boolean = ???
  }

  def classifyIncident(errorRate: Double, affectedUsers: Int, isDataLoss: Boolean): IncidentSeverity = ???

  // Exercise 5: Escalation Policy
  // TODO: Implement an escalation policy with time-based escalation.
  case class EscalationLevel(level: Int, notifyGroup: String, afterMinutes: Int)

  case class EscalationPolicy(levels: List[EscalationLevel]) {
    def currentLevel(incidentAgeMinutes: Int): EscalationLevel = ???
    def shouldEscalate(currentLevel: Int, incidentAgeMinutes: Int): Boolean = ???
  }

  // Exercise 6: Runbook Step Execution
  // TODO: Model a runbook as a series of steps that can be executed.
  sealed trait StepResult
  case object StepSuccess extends StepResult
  case class StepFailure(reason: String) extends StepResult
  case object StepSkipped extends StepResult

  case class RunbookStep(name: String, description: String, action: () => StepResult)

  case class Runbook(name: String, steps: List[RunbookStep]) {
    def execute: List[(String, StepResult)] = ???
    def executeUntilFailure: List[(String, StepResult)] = ???
  }

  // Exercise 7: Post-Mortem Report
  // TODO: Structure a post-mortem report with timeline, root cause, and action items.
  case class TimelineEntry(timestamp: Long, event: String, actor: String)
  case class ActionItem(description: String, owner: String, dueDate: String, priority: String)

  case class PostMortem(
    incidentId: String,
    title: String,
    summary: String,
    timeline: List[TimelineEntry],
    rootCause: String,
    contributing: List[String],
    actionItems: List[ActionItem],
    lessonsLearned: List[String]
  ) {
    def toMarkdown: String = ???
  }

  // Exercise 8: On-Call Rotation
  // TODO: Implement on-call rotation schedule.
  case class OnCallSchedule(team: List[String], rotationDays: Int, startDate: Long) {
    def currentOnCall(nowDate: Long): String = ???
    def nextOnCall(nowDate: Long): String = ???
    def scheduleForDays(fromDate: Long, days: Int): List[(Long, String)] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val sli = SLI("api_availability", Availability, 0.998, "ratio")
    val slo = SLO(sli, 0.999, "30d")
    assert(!slo.isMet)
    println("Exercise 1 passed: SLI/SLO Definition")

    // Exercise 2
    val budget = ErrorBudget(0.999, 43200, 30.0)
    assert(budget.totalBudgetMinutes > 0)
    assert(budget.remainingMinutes > 0)
    println("Exercise 2 passed: Error Budget")

    // Exercise 4
    assert(classifyIncident(0.5, 10000, isDataLoss = true) == SEV1)
    assert(classifyIncident(0.01, 100, isDataLoss = false) == SEV3 || classifyIncident(0.01, 100, isDataLoss = false) == SEV4)
    println("Exercise 4 passed: Incident Classification")

    // Exercise 5
    val policy = EscalationPolicy(List(
      EscalationLevel(1, "on-call-eng", 0),
      EscalationLevel(2, "eng-lead", 15),
      EscalationLevel(3, "vp-eng", 60)
    ))
    assert(policy.currentLevel(0).notifyGroup == "on-call-eng")
    assert(policy.currentLevel(20).notifyGroup == "eng-lead")
    assert(policy.currentLevel(90).notifyGroup == "vp-eng")
    println("Exercise 5 passed: Escalation Policy")

    println("\nAll Arch047 exercises passed!")
  }
}
