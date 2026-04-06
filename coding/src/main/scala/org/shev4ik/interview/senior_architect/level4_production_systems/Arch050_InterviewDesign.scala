package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Arch050 - System Design Interview
 * Level: Production Systems
 *
 * Practice the system design interview approach:
 * requirements gathering, capacity estimation, high-level design,
 * detailed design, and tradeoff analysis.
 *
 * Key concepts:
 * - Structured approach to system design
 * - Capacity estimation
 * - Tradeoff analysis
 */
object Arch050_InterviewDesign {

  // Exercise 1: Requirements Gathering Framework
  // TODO: Implement a structured requirements gathering framework
  // for system design interviews.
  sealed trait RequirementType
  case object Functional extends RequirementType
  case object NonFunctional extends RequirementType
  case object Constraint extends RequirementType

  case class Requirement(description: String, reqType: RequirementType, priority: Int)

  case class RequirementsDoc(requirements: List[Requirement]) {
    def functional: List[Requirement] = ???
    def nonFunctional: List[Requirement] = ???
    def constraints: List[Requirement] = ???
    def prioritized: List[Requirement] = ???
  }

  // Exercise 2: Capacity Estimation Calculator
  // TODO: Build a capacity estimation tool for system design.
  case class TrafficEstimate(
    dailyActiveUsers: Long,
    readWriteRatio: Double,        // reads per write
    avgRequestsPerUserPerDay: Int,
    avgPayloadBytes: Int
  ) {
    def totalDailyRequests: Long = ???
    def requestsPerSecond: Double = ???
    def peakRPS(peakMultiplier: Double = 3.0): Double = ???
    def dailyDataGB: Double = ???
    def monthlyDataGB: Double = ???
    def yearlyDataTB: Double = ???
    def dailyBandwidthGbps: Double = ???
  }

  // Exercise 3: Storage Estimation
  // TODO: Estimate storage requirements for a system.
  case class StorageEstimate(
    recordsPerDay: Long,
    avgRecordBytes: Int,
    retentionYears: Int,
    replicationFactor: Int,
    compressionRatio: Double  // 0.5 means 50% of original size
  ) {
    def dailyStorageGB: Double = ???
    def yearlyStorageTB: Double = ???
    def totalStorageTB: Double = ???
    def withReplication: Double = ???
    def withCompression: Double = ???
  }

  // Exercise 4: High-Level Design Components
  // TODO: Model the key components of a system design.
  sealed trait ComponentType
  case object WebServer extends ComponentType
  case object AppServer extends ComponentType
  case object Database extends ComponentType
  case object Cache extends ComponentType
  case object MessageQueue extends ComponentType
  case object LoadBalancer extends ComponentType
  case object CDN extends ComponentType
  case object ObjectStore extends ComponentType

  case class SystemComponent(name: String, componentType: ComponentType, description: String, dependencies: List[String])

  case class SystemDesign(components: List[SystemComponent]) {
    def topologicalOrder: List[String] = ???
    def findComponent(name: String): Option[SystemComponent] = ???
    def dependencyGraph: Map[String, List[String]] = ???
    def criticalPath: List[String] = ???
  }

  // Exercise 5: Database Schema Design
  // TODO: Model database tables and relationships for a system.
  sealed trait ColumnType
  case object IntType extends ColumnType
  case object BigIntType extends ColumnType
  case object VarcharType extends ColumnType
  case object TimestampType extends ColumnType
  case object JsonbType extends ColumnType
  case object BooleanType extends ColumnType

  case class Column(name: String, colType: ColumnType, nullable: Boolean, indexed: Boolean)
  case class Table(name: String, columns: List[Column], primaryKey: List[String])

  case class Schema(tables: List[Table]) {
    def estimateRowSize(tableName: String): Int = ???
    def indexedColumns(tableName: String): List[String] = ???
    def toSQL: String = ???
  }

  // Exercise 6: Tradeoff Analysis
  // TODO: Implement a structured tradeoff analysis framework.
  case class TradeoffOption(
    name: String,
    pros: List[String],
    cons: List[String],
    complexity: Int,  // 1-5
    scalability: Int, // 1-5
    cost: Int         // 1-5
  ) {
    def overallScore(weights: Map[String, Double] = Map("complexity" -> 0.3, "scalability" -> 0.5, "cost" -> 0.2)): Double = ???
  }

  def compareOptions(options: List[TradeoffOption]): TradeoffOption = ???

  // Exercise 7: API Design for System
  // TODO: Design REST API endpoints for a system.
  sealed trait HttpMethod
  case object GET extends HttpMethod
  case object POST extends HttpMethod
  case object PUT extends HttpMethod
  case object DELETE extends HttpMethod
  case object PATCH extends HttpMethod

  case class APIEndpoint(
    method: HttpMethod,
    path: String,
    description: String,
    requestBody: Option[String],
    responseBody: String,
    authRequired: Boolean
  )

  case class APIDesign(endpoints: List[APIEndpoint]) {
    def byResource: Map[String, List[APIEndpoint]] = ???
    def authenticatedEndpoints: List[APIEndpoint] = ???
    def toMarkdown: String = ???
  }

  // Exercise 8: Scaling Strategy
  // TODO: Design a scaling strategy based on bottleneck analysis.
  sealed trait ScalingAction
  case class HorizontalScale(component: String, instances: Int) extends ScalingAction
  case class VerticalScale(component: String, cpuCores: Int, memoryGB: Int) extends ScalingAction
  case class AddCache(layer: String, sizeMB: Int) extends ScalingAction
  case class AddIndex(table: String, columns: List[String]) extends ScalingAction
  case class Shard(table: String, shardKey: String, shards: Int) extends ScalingAction

  case class ScalingPlan(actions: List[ScalingAction]) {
    def estimatedImprovementPercent: Double = ???
    def estimatedCostIncrease: Double = ???
    def prioritized: List[ScalingAction] = ???
  }

  def analyzeBottleneck(cpuPercent: Double, memoryPercent: Double, diskIOPercent: Double, networkPercent: Double): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2
    val traffic = TrafficEstimate(
      dailyActiveUsers = 10000000,
      readWriteRatio = 10.0,
      avgRequestsPerUserPerDay = 20,
      avgPayloadBytes = 500
    )
    assert(traffic.totalDailyRequests == 200000000L)
    assert(traffic.requestsPerSecond > 2000)
    println("Exercise 2 passed: Capacity Estimation")

    // Exercise 3
    val storage = StorageEstimate(
      recordsPerDay = 1000000,
      avgRecordBytes = 1000,
      retentionYears = 5,
      replicationFactor = 3,
      compressionRatio = 0.5
    )
    assert(storage.dailyStorageGB > 0)
    assert(storage.totalStorageTB > 0)
    println("Exercise 3 passed: Storage Estimation")

    // Exercise 6
    val options = List(
      TradeoffOption("SQL", List("ACID", "Joins"), List("Scaling"), 2, 3, 3),
      TradeoffOption("NoSQL", List("Scale", "Flexible"), List("No joins"), 3, 5, 4)
    )
    val best = compareOptions(options)
    assert(best != null)
    println("Exercise 6 passed: Tradeoff Analysis")

    // Exercise 8
    assert(analyzeBottleneck(90, 50, 30, 20) == "CPU")
    assert(analyzeBottleneck(30, 90, 30, 20) == "Memory")
    println("Exercise 8 passed: Scaling Strategy")

    println("\nAll Arch050 exercises passed!")
  }
}
