package org.shev4ik.interview.senior_architect.level4_production_systems

object Arch040_DeploymentPatterns {

  // Exercise 1: Blue-Green Deployment
  sealed trait Environment; case object Blue extends Environment; case object Green extends Environment
  case class DeploymentState(activeEnv: Environment, blueVersion: String, greenVersion: String, trafficSplit: Map[Environment, Int])
  trait BlueGreenDeployer {
    def deploy(version: String, targetEnv: Environment): Either[String, DeploymentState]
    def switchTraffic(to: Environment): Either[String, DeploymentState]
    def rollback(): Either[String, DeploymentState]
    def currentState: DeploymentState
  }
  class BlueGreenController extends BlueGreenDeployer {
    def deploy(version: String, targetEnv: Environment): Either[String, DeploymentState] = ???
    def switchTraffic(to: Environment): Either[String, DeploymentState] = ???
    def rollback(): Either[String, DeploymentState] = ???
    def currentState: DeploymentState = ???
  }

  // Exercise 2: Canary Deployment
  case class CanaryConfig(initialPercent: Int, incrementPercent: Int, intervalMs: Long, successThreshold: Double, rollbackThreshold: Double)
  case class CanaryStatus(version: String, trafficPercent: Int, errorRate: Double, latencyP99: Long, phase: String)
  trait CanaryDeployer {
    def startCanary(version: String, config: CanaryConfig): Either[String, CanaryStatus]
    def promote(): Either[String, CanaryStatus]
    def rollback(): Either[String, Unit]
    def status(): CanaryStatus
    def shouldPromote(metrics: Map[String, Double]): Boolean
  }
  class CanaryController(config: CanaryConfig) extends CanaryDeployer {
    def startCanary(version: String, config: CanaryConfig): Either[String, CanaryStatus] = ???
    def promote(): Either[String, CanaryStatus] = ???
    def rollback(): Either[String, Unit] = ???
    def status(): CanaryStatus = ???
    def shouldPromote(metrics: Map[String, Double]): Boolean = ???
  }

  // Exercise 3: Feature Flags Implementation
  sealed trait FlagType; case object Boolean extends FlagType; case object Percentage extends FlagType; case object UserList extends FlagType
  case class FeatureFlag(name: String, flagType: FlagType, enabled: Boolean, percentage: Int, allowedUsers: Set[String], metadata: Map[String, String])
  trait FeatureFlagService {
    def isEnabled(flag: String, userId: Option[String] = None): Boolean
    def setFlag(name: String, enabled: Boolean): Either[String, Unit]
    def setPercentage(name: String, percentage: Int): Either[String, Unit]
    def allFlags(): List[FeatureFlag]
  }
  class InMemoryFeatureFlags extends FeatureFlagService {
    private val flags = scala.collection.mutable.Map.empty[String, FeatureFlag]
    def isEnabled(flag: String, userId: Option[String]): Boolean = ???
    def setFlag(name: String, enabled: Boolean): Either[String, Unit] = ???
    def setPercentage(name: String, percentage: Int): Either[String, Unit] = ???
    def allFlags(): List[FeatureFlag] = ???
  }

  // Exercise 4: Rolling Update
  case class RollingUpdateConfig(maxSurge: Int, maxUnavailable: Int, healthCheckInterval: Long, healthCheckTimeout: Long)
  trait RollingUpdater {
    def startUpdate(newVersion: String, config: RollingUpdateConfig): Either[String, Unit]
    def progress(): (Int, Int)  // (updated, total)
    def pause(): Either[String, Unit]
    def resume(): Either[String, Unit]
    def rollback(): Either[String, Unit]
  }
  class KubernetesStyleRollingUpdate(totalInstances: Int) extends RollingUpdater {
    def startUpdate(newVersion: String, config: RollingUpdateConfig): Either[String, Unit] = ???
    def progress(): (Int, Int) = ???
    def pause(): Either[String, Unit] = ???
    def resume(): Either[String, Unit] = ???
    def rollback(): Either[String, Unit] = ???
  }

  // Exercise 5: A/B Testing Infrastructure
  case class Experiment(id: String, name: String, variants: List[Variant], trafficAllocation: Map[String, Int], startDate: Long, endDate: Option[Long])
  case class Variant(id: String, name: String, config: Map[String, String])
  case class ExperimentResult(experimentId: String, variantResults: Map[String, VariantMetrics])
  case class VariantMetrics(sampleSize: Long, conversionRate: Double, avgRevenue: Double, pValue: Double)
  trait ABTestingService {
    def createExperiment(experiment: Experiment): Either[String, Unit]
    def assignVariant(experimentId: String, userId: String): Either[String, Variant]
    def recordConversion(experimentId: String, userId: String, value: Double): Either[String, Unit]
    def getResults(experimentId: String): Either[String, ExperimentResult]
  }
  class SimpleABTestService extends ABTestingService {
    def createExperiment(experiment: Experiment): Either[String, Unit] = ???
    def assignVariant(experimentId: String, userId: String): Either[String, Variant] = ???
    def recordConversion(experimentId: String, userId: String, value: Double): Either[String, Unit] = ???
    def getResults(experimentId: String): Either[String, ExperimentResult] = ???
  }

  // Exercise 6: Deployment Pipeline
  sealed trait PipelineStage; case object Build extends PipelineStage; case object Test extends PipelineStage
  case object SecurityScan extends PipelineStage; case object StagingDeploy extends PipelineStage; case object ProdDeploy extends PipelineStage
  case class PipelineRun(id: String, version: String, stages: List[(PipelineStage, String)], startedAt: Long, status: String)
  trait DeploymentPipeline {
    def trigger(version: String): Either[String, PipelineRun]
    def approve(runId: String, stage: PipelineStage): Either[String, Unit]
    def status(runId: String): Either[String, PipelineRun]
    def abort(runId: String): Either[String, Unit]
  }
  class CIPipeline extends DeploymentPipeline {
    def trigger(version: String): Either[String, PipelineRun] = ???
    def approve(runId: String, stage: PipelineStage): Either[String, Unit] = ???
    def status(runId: String): Either[String, PipelineRun] = ???
    def abort(runId: String): Either[String, Unit] = ???
  }

  // Exercise 7: Rollback Strategy
  sealed trait RollbackTrigger; case object ManualRollback extends RollbackTrigger
  case class ErrorRateRollback(threshold: Double) extends RollbackTrigger; case class LatencyRollback(thresholdMs: Long) extends RollbackTrigger
  trait RollbackManager {
    def canRollback(): Either[String, Boolean]
    def rollback(trigger: RollbackTrigger): Either[String, String]
    def rollbackHistory(): List[(Long, String, RollbackTrigger)]
    def autoRollbackEnabled: Boolean
  }
  class AutoRollbackManager(triggers: List[RollbackTrigger]) extends RollbackManager {
    def canRollback(): Either[String, Boolean] = ???
    def rollback(trigger: RollbackTrigger): Either[String, String] = ???
    def rollbackHistory(): List[(Long, String, RollbackTrigger)] = ???
    def autoRollbackEnabled: Boolean = ???
    def evaluateMetrics(metrics: Map[String, Double]): Option[RollbackTrigger] = ???
  }

  // Exercise 8: Database Migration in Deploy
  case class DbMigration(version: Int, sql: String, rollbackSql: String, description: String)
  trait DeploymentMigrator {
    def pendingMigrations(): Either[String, List[DbMigration]]
    def migrate(): Either[String, Int]
    def rollbackLast(): Either[String, Unit]
    def isCompatibleWithVersion(appVersion: String): Either[String, Boolean]
  }
  class ZeroDowntimeMigrator(migrations: List[DbMigration]) extends DeploymentMigrator {
    def pendingMigrations(): Either[String, List[DbMigration]] = ???
    def migrate(): Either[String, Int] = ???
    def rollbackLast(): Either[String, Unit] = ???
    def isCompatibleWithVersion(appVersion: String): Either[String, Boolean] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch040: Deployment Patterns ===")
    (1 to 8).foreach(i => println(s"Exercise $i"))
  }
}
