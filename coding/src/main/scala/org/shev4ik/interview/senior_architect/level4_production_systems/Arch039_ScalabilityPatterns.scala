package org.shev4ik.interview.senior_architect.level4_production_systems

object Arch039_ScalabilityPatterns {

  // Exercise 1: Horizontal Scaling Design
  case class ServiceInstance(id: String, host: String, port: Int, weight: Int, zone: String)
  sealed trait ScalingStrategy; case object HorizontalScale extends ScalingStrategy; case object VerticalScale extends ScalingStrategy
  trait HorizontalScaler {
    def addInstance(zone: String): Either[String, ServiceInstance]
    def removeInstance(instanceId: String): Either[String, Unit]
    def currentInstances(): List[ServiceInstance]
    def rebalance(): Either[String, Unit]
  }
  class AutoScaler(minInstances: Int, maxInstances: Int, targetCpuPercent: Double) extends HorizontalScaler {
    def addInstance(zone: String): Either[String, ServiceInstance] = ???
    def removeInstance(instanceId: String): Either[String, Unit] = ???
    def currentInstances(): List[ServiceInstance] = ???
    def rebalance(): Either[String, Unit] = ???
    def evaluate(currentCpu: Double, currentInstances: Int): ScalingDecision = ???
  }
  sealed trait ScalingDecision; case class ScaleUp(count: Int) extends ScalingDecision; case class ScaleDown(count: Int) extends ScalingDecision; case object NoChange extends ScalingDecision

  // Exercise 2: Vertical Scaling Limits
  case class ResourceLimits(maxCpuCores: Int, maxMemoryGb: Int, maxDiskGb: Int, maxNetworkGbps: Int)
  case class ResourceUsage(cpuPercent: Double, memoryPercent: Double, diskPercent: Double, networkPercent: Double)
  def isVerticallyScalable(current: ResourceUsage, limits: ResourceLimits): Boolean = ???
  def recommendScalingStrategy(usage: ResourceUsage, limits: ResourceLimits): ScalingStrategy = ???

  // Exercise 3: Stateless Service Design
  trait StatelessService {
    def process(request: Map[String, String]): Either[String, Map[String, String]]
    // No instance state - all state externalized to DB/cache/queue
  }
  // TODO: Refactor stateful to stateless
  class StatelessOrderService(externalCache: ExternalCache, db: ExternalDB) extends StatelessService {
    def process(request: Map[String, String]): Either[String, Map[String, String]] = ???
  }
  trait ExternalCache { def get(key: String): Option[String]; def set(key: String, value: String, ttl: Int): Unit }
  trait ExternalDB { def query(sql: String): Either[String, List[Map[String, Any]]] }

  // Exercise 4: Shared Nothing Architecture
  case class Shard(id: Int, range: (String, String), primaryNode: String, replicaNodes: List[String])
  trait ShardManager {
    def getShard(key: String): Shard
    def addShard(shard: Shard): Either[String, Unit]
    def removeShard(shardId: Int): Either[String, Unit]
    def rebalanceShards(): Either[String, Unit]
    def shardCount: Int
  }
  class ConsistentHashShardManager(numShards: Int) extends ShardManager {
    def getShard(key: String): Shard = ???
    def addShard(shard: Shard): Either[String, Unit] = ???
    def removeShard(shardId: Int): Either[String, Unit] = ???
    def rebalanceShards(): Either[String, Unit] = ???
    def shardCount: Int = ???
  }

  // Exercise 5: Data Partitioning
  sealed trait PartitionStrategy; case class HashPartition(numPartitions: Int) extends PartitionStrategy
  case class RangePartition(ranges: List[(String, String)]) extends PartitionStrategy; case class ListPartition(mapping: Map[String, Int]) extends PartitionStrategy
  def partitionKey(key: String, strategy: PartitionStrategy): Int = ???
  // TODO: Implement consistent hashing for partition assignment
  class ConsistentHashRing(nodes: List[String], virtualNodes: Int) {
    def getNode(key: String): String = ???
    def addNode(node: String): Unit = ???
    def removeNode(node: String): Unit = ???
  }

  // Exercise 6: Cache Invalidation
  sealed trait InvalidationStrategy; case object TTLBased extends InvalidationStrategy
  case object EventBased extends InvalidationStrategy; case object WriteThroughInvalidation extends InvalidationStrategy
  trait CacheInvalidator {
    def invalidate(key: String): Either[String, Unit]
    def invalidatePattern(pattern: String): Either[String, Int]
    def invalidateAll(): Either[String, Unit]
    def onDataChange(entity: String, id: String): Either[String, Unit]
  }
  class EventDrivenInvalidator extends CacheInvalidator {
    def invalidate(key: String): Either[String, Unit] = ???
    def invalidatePattern(pattern: String): Either[String, Int] = ???
    def invalidateAll(): Either[String, Unit] = ???
    def onDataChange(entity: String, id: String): Either[String, Unit] = ???
  }

  // Exercise 7: Load Balancing Strategy
  sealed trait LBAlgorithm; case object RoundRobin extends LBAlgorithm; case object LeastConn extends LBAlgorithm
  case object WeightedRR extends LBAlgorithm; case object IPHash extends LBAlgorithm
  trait LoadBalancer {
    def nextInstance(instances: List[ServiceInstance]): ServiceInstance
    def algorithm: LBAlgorithm
    def healthCheck(instance: ServiceInstance): Boolean
  }
  class WeightedLoadBalancer extends LoadBalancer {
    val algorithm: LBAlgorithm = WeightedRR
    def nextInstance(instances: List[ServiceInstance]): ServiceInstance = ???
    def healthCheck(instance: ServiceInstance): Boolean = ???
  }

  // Exercise 8: Auto-Scaling Concept
  case class ScalingPolicy(scaleUpCooldown: Long, scaleDownCooldown: Long, targetMetric: String, targetValue: Double, minInstances: Int, maxInstances: Int)
  case class ScalingEvent(timestamp: Long, fromCount: Int, toCount: Int, reason: String)
  trait AutoScalingController {
    def evaluate(currentMetrics: Map[String, Double]): ScalingDecision
    def applyDecision(decision: ScalingDecision): Either[String, ScalingEvent]
    def history(): List[ScalingEvent]
    def inCooldown(): Boolean
  }
  class PolicyBasedScaler(policy: ScalingPolicy) extends AutoScalingController {
    def evaluate(currentMetrics: Map[String, Double]): ScalingDecision = ???
    def applyDecision(decision: ScalingDecision): Either[String, ScalingEvent] = ???
    def history(): List[ScalingEvent] = ???
    def inCooldown(): Boolean = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch039: Scalability Patterns ===")
    (1 to 8).foreach(i => println(s"Exercise $i"))
  }
}
