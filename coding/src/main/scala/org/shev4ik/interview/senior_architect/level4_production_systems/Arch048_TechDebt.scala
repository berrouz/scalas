package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Arch048 - Technical Debt Management
 * Level: Production Systems
 *
 * Strategies for classifying, tracking, and reducing technical debt.
 * Architecture fitness functions and evolutionary architecture.
 *
 * Key concepts:
 * - Tech debt classification and prioritization
 * - Refactoring strategies, migration planning
 * - Architecture fitness functions
 */
object Arch048_TechDebt {

  // Exercise 1: Tech Debt Classification
  // TODO: Implement a tech debt item classifier by type and severity.
  sealed trait DebtType
  case object CodeDebt extends DebtType        // duplicated, complex, untested code
  case object ArchitectureDebt extends DebtType // wrong patterns, coupling
  case object DependencyDebt extends DebtType   // outdated libs, security vulns
  case object TestDebt extends DebtType         // insufficient test coverage
  case object DocumentationDebt extends DebtType
  case object InfrastructureDebt extends DebtType

  sealed trait DebtSeverity { def score: Int }
  case object Critical extends DebtSeverity { val score = 4 }
  case object High extends DebtSeverity { val score = 3 }
  case object Medium extends DebtSeverity { val score = 2 }
  case object Low extends DebtSeverity { val score = 1 }

  case class TechDebtItem(
    id: String,
    description: String,
    debtType: DebtType,
    severity: DebtSeverity,
    effortDays: Int,
    impactScore: Int, // 1-10
    createdDate: String
  ) {
    def priorityScore: Double = ???  // higher = fix sooner
    def roi: Double = ???            // impact / effort
  }

  def prioritize(items: List[TechDebtItem]): List[TechDebtItem] = ???

  // Exercise 2: Dependency Analysis
  // TODO: Analyze project dependencies for outdated/vulnerable libraries.
  case class Dependency(group: String, artifact: String, currentVersion: String, latestVersion: String, hasVulnerability: Boolean) {
    def isOutdated: Boolean = ???
    def majorVersionsBehind: Int = ???
    def urgency: DebtSeverity = ???
  }

  def analyzeDependencies(deps: List[Dependency]): Map[DebtSeverity, List[Dependency]] = ???

  // Exercise 3: Code Quality Metrics
  // TODO: Implement code quality metric tracking and threshold checking.
  case class CodeMetrics(
    linesOfCode: Int,
    testCoverage: Double,     // 0.0 to 1.0
    cyclomaticComplexity: Double,
    duplicatePercent: Double,
    techDebtRatio: Double     // debt time / dev time
  ) {
    def qualityScore: Double = ???
    def failedThresholds(thresholds: CodeMetricThresholds): List[String] = ???
  }

  case class CodeMetricThresholds(
    minCoverage: Double,
    maxComplexity: Double,
    maxDuplication: Double,
    maxDebtRatio: Double
  )

  // Exercise 4: Migration Plan
  // TODO: Design a migration plan with phases, dependencies, and rollback.
  case class MigrationPhase(
    name: String,
    description: String,
    dependencies: List[String],  // names of prerequisite phases
    estimatedDays: Int,
    rollbackPlan: String,
    riskLevel: DebtSeverity
  )

  case class MigrationPlan(phases: List[MigrationPhase]) {
    def totalDays: Int = ???
    def criticalPath: List[String] = ???
    def canStart(phaseName: String, completedPhases: Set[String]): Boolean = ???
    def nextPhases(completedPhases: Set[String]): List[MigrationPhase] = ???
  }

  // Exercise 5: Architecture Fitness Functions
  // TODO: Implement fitness functions that validate architecture constraints.
  sealed trait FitnessResult
  case class Passed(name: String, score: Double) extends FitnessResult
  case class Failed(name: String, score: Double, threshold: Double, message: String) extends FitnessResult

  case class FitnessFunction(name: String, threshold: Double, evaluate: () => Double) {
    def run: FitnessResult = ???
  }

  case class FitnessSuite(functions: List[FitnessFunction]) {
    def runAll: List[FitnessResult] = ???
    def allPassed: Boolean = ???
    def report: String = ???
  }

  // Exercise 6: Strangler Fig Pattern
  // TODO: Model the strangler fig migration pattern for gradual replacement.
  sealed trait RouteTarget
  case object Legacy extends RouteTarget
  case object Modern extends RouteTarget
  case class Split(legacyPercent: Int) extends RouteTarget

  case class StranglerRouter(routes: Map[String, RouteTarget]) {
    def route(path: String): RouteTarget = ???
    def migrateToModern(path: String): StranglerRouter = ???
    def migrateWithCanary(path: String, percent: Int): StranglerRouter = ???
    def migrationProgress: Double = ???
  }

  // Exercise 7: Architecture Decision Record
  // TODO: Implement ADR (Architecture Decision Record) structure.
  sealed trait DecisionStatus
  case object Proposed extends DecisionStatus
  case object Accepted extends DecisionStatus
  case object Superseded extends DecisionStatus
  case object Deprecated extends DecisionStatus

  case class ADR(
    number: Int,
    title: String,
    status: DecisionStatus,
    context: String,
    decision: String,
    consequences: List[String],
    alternatives: List[String],
    date: String,
    supersededBy: Option[Int]
  ) {
    def toMarkdown: String = ???
  }

  // Exercise 8: Refactoring Impact Analysis
  // TODO: Analyze the impact of a proposed refactoring.
  case class RefactoringProposal(
    description: String,
    affectedFiles: Int,
    affectedTests: Int,
    estimatedHours: Int,
    riskLevel: DebtSeverity,
    benefitDescription: String
  ) {
    def impactScore: Double = ???
    def shouldProceed(maxRisk: DebtSeverity, maxHours: Int): Boolean = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val items = List(
      TechDebtItem("TD-1", "Replace deprecated API", DependencyDebt, High, 3, 8, "2024-01"),
      TechDebtItem("TD-2", "Add unit tests", TestDebt, Medium, 5, 5, "2024-02"),
      TechDebtItem("TD-3", "Fix security vuln", DependencyDebt, Critical, 1, 10, "2024-03")
    )
    val prioritized = prioritize(items)
    assert(prioritized.head.severity == Critical)
    println("Exercise 1 passed: Tech Debt Classification")

    // Exercise 2
    val deps = List(
      Dependency("com.typesafe.akka", "akka-actor", "2.5.22", "2.8.5", hasVulnerability = false),
      Dependency("log4j", "log4j", "1.2.17", "2.20.0", hasVulnerability = true)
    )
    val analysis = analyzeDependencies(deps)
    assert(analysis.nonEmpty)
    println("Exercise 2 passed: Dependency Analysis")

    // Exercise 5
    val fitness = FitnessFunction("test_coverage", 0.8, () => 0.85)
    assert(fitness.run.isInstanceOf[Passed])
    println("Exercise 5 passed: Architecture Fitness Functions")

    // Exercise 6
    val router = StranglerRouter(Map("/api/users" -> Legacy, "/api/orders" -> Legacy))
    val updated = router.migrateToModern("/api/users")
    assert(updated.route("/api/users") == Modern)
    assert(updated.migrationProgress == 0.5)
    println("Exercise 6 passed: Strangler Fig Pattern")

    println("\nAll Arch048 exercises passed!")
  }
}
