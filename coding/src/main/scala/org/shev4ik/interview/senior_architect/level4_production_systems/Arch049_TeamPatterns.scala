package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Arch049 - Team & Process Patterns
 * Level: Production Systems
 *
 * Engineering practices for effective team collaboration,
 * code review, documentation, and knowledge sharing.
 *
 * Key concepts:
 * - Code review, PR workflow, coding standards
 * - Documentation strategy, knowledge sharing
 * - ADRs, RFCs, onboarding
 */
object Arch049_TeamPatterns {

  // Exercise 1: Code Review Checklist
  // TODO: Implement an automated code review checklist system.
  sealed trait CheckResult
  case object Pass extends CheckResult
  case class Fail(reason: String) extends CheckResult
  case object Skip extends CheckResult

  case class ReviewCheck(name: String, category: String, check: PullRequest => CheckResult)

  case class PullRequest(
    title: String,
    description: String,
    filesChanged: Int,
    linesAdded: Int,
    linesRemoved: Int,
    hasTests: Boolean,
    hasMigration: Boolean,
    labels: Set[String]
  )

  def runReviewChecklist(pr: PullRequest, checks: List[ReviewCheck]): Map[String, CheckResult] = ???

  def defaultChecks: List[ReviewCheck] = ???

  // Exercise 2: PR Size Analysis
  // TODO: Analyze PR size and suggest splitting if too large.
  sealed trait PRSize
  case object Small extends PRSize    // < 100 lines
  case object Medium extends PRSize   // 100-400 lines
  case object Large extends PRSize    // 400-1000 lines
  case object TooLarge extends PRSize // > 1000 lines

  def analyzePRSize(linesChanged: Int): PRSize = ???
  def suggestSplit(pr: PullRequest): List[String] = ???

  // Exercise 3: Coding Standards Validator
  // TODO: Implement a coding standards validator.
  case class CodingStandard(name: String, description: String, validate: String => Boolean)

  case class StandardsReport(violations: List[(CodingStandard, String)]) {
    def hasViolations: Boolean = ???
    def violationCount: Int = ???
    def toMarkdown: String = ???
  }

  def validateCode(code: String, standards: List[CodingStandard]): StandardsReport = ???

  // Exercise 4: Knowledge Base Search
  // TODO: Implement a simple knowledge base with tagging and search.
  case class KBArticle(
    id: String,
    title: String,
    content: String,
    tags: Set[String],
    author: String,
    lastUpdated: String
  )

  case class KnowledgeBase(articles: List[KBArticle]) {
    def searchByTag(tag: String): List[KBArticle] = ???
    def searchByKeyword(keyword: String): List[KBArticle] = ???
    def findRelated(articleId: String): List[KBArticle] = ???
    def staleArticles(olderThan: String): List[KBArticle] = ???
  }

  // Exercise 5: Onboarding Checklist
  // TODO: Implement an onboarding progress tracker.
  sealed trait TaskStatus
  case object NotStarted extends TaskStatus
  case object InProgress extends TaskStatus
  case object Completed extends TaskStatus
  case object Blocked extends TaskStatus

  case class OnboardingTask(name: String, description: String, category: String, assignee: String, status: TaskStatus, dayTarget: Int)

  case class OnboardingPlan(tasks: List[OnboardingTask]) {
    def progressPercent: Double = ???
    def tasksByDay(day: Int): List[OnboardingTask] = ???
    def blockedTasks: List[OnboardingTask] = ???
    def complete(taskName: String): OnboardingPlan = ???
  }

  // Exercise 6: RFC (Request for Comments) Process
  // TODO: Model an RFC process for technical proposals.
  sealed trait RFCStatus
  case object Draft extends RFCStatus
  case object Review extends RFCStatus
  case object Approved extends RFCStatus
  case object Rejected extends RFCStatus
  case object Implemented extends RFCStatus

  case class Comment(author: String, text: String, timestamp: Long)

  case class RFC(
    id: String,
    title: String,
    author: String,
    status: RFCStatus,
    problem: String,
    proposal: String,
    alternatives: List[String],
    comments: List[Comment],
    reviewers: List[String],
    approvals: Set[String]
  ) {
    def canApprove(minApprovals: Int): Boolean = ???
    def addComment(comment: Comment): RFC = ???
    def approve(reviewer: String): RFC = ???
    def transitionTo(newStatus: RFCStatus): Either[String, RFC] = ???
  }

  // Exercise 7: Sprint Metrics
  // TODO: Track sprint velocity and predictability.
  case class SprintMetrics(
    sprintNumber: Int,
    plannedPoints: Int,
    completedPoints: Int,
    carryOverPoints: Int,
    addedPoints: Int
  ) {
    def velocity: Int = ???
    def commitmentRatio: Double = ???
    def scopeCreep: Double = ???
  }

  def averageVelocity(sprints: List[SprintMetrics]): Double = ???
  def velocityTrend(sprints: List[SprintMetrics]): String = ???

  // Exercise 8: Incident Retro Tracking
  // TODO: Track post-incident action items and completion.
  case class RetroAction(
    description: String,
    owner: String,
    dueDate: String,
    status: TaskStatus,
    incidentId: String
  )

  case class RetroTracker(actions: List[RetroAction]) {
    def overdueActions(currentDate: String): List[RetroAction] = ???
    def completionRate: Double = ???
    def byOwner: Map[String, List[RetroAction]] = ???
    def byIncident: Map[String, List[RetroAction]] = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val pr = PullRequest("Add feature", "Description here", 5, 100, 20, hasTests = true, hasMigration = false, Set("feature"))
    val checks = defaultChecks
    val results = runReviewChecklist(pr, checks)
    assert(results.nonEmpty)
    println("Exercise 1 passed: Code Review Checklist")

    // Exercise 2
    assert(analyzePRSize(50) == Small)
    assert(analyzePRSize(500) == Large)
    assert(analyzePRSize(1500) == TooLarge)
    println("Exercise 2 passed: PR Size Analysis")

    // Exercise 5
    val plan = OnboardingPlan(List(
      OnboardingTask("Setup env", "Install tools", "setup", "newbie", NotStarted, 1),
      OnboardingTask("Read docs", "Architecture docs", "learning", "newbie", NotStarted, 3)
    ))
    assert(plan.progressPercent == 0.0)
    val updated = plan.complete("Setup env")
    assert(updated.progressPercent == 50.0)
    println("Exercise 5 passed: Onboarding Checklist")

    // Exercise 7
    val sprints = List(
      SprintMetrics(1, 30, 25, 5, 3),
      SprintMetrics(2, 28, 28, 0, 2),
      SprintMetrics(3, 32, 30, 2, 5)
    )
    assert(averageVelocity(sprints) > 0)
    println("Exercise 7 passed: Sprint Metrics")

    println("\nAll Arch049 exercises passed!")
  }
}
