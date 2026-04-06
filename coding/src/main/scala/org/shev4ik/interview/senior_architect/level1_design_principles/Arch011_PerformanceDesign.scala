package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Performance Design
 *
 * Senior/Architect focus:
 * - Caching strategies and connection pooling
 * - Batch processing and lazy loading
 * - Backpressure and async processing design
 */
object Arch011_PerformanceDesign {

  // ============================================================
  // Exercise 1: Caching Strategy (L1/L2)
  // ============================================================
  // TODO: Design a multi-level caching system.
  //  L1: in-process (local), fast but limited size
  //  L2: distributed (Redis), slower but shared across instances

  trait Cache[K, V] {
    def get(key: K): Either[String, Option[V]]
    def put(key: K, value: V, ttlSeconds: Int): Either[String, Unit]
    def invalidate(key: K): Either[String, Unit]
    def invalidateAll(): Either[String, Unit]
  }

  // L1: in-process cache with LRU eviction
  class L1Cache[K, V](maxSize: Int) extends Cache[K, V] {
    def get(key: K): Either[String, Option[V]] = ???
    def put(key: K, value: V, ttlSeconds: Int): Either[String, Unit] = ???
    def invalidate(key: K): Either[String, Unit] = ???
    def invalidateAll(): Either[String, Unit] = ???
  }

  // L2: distributed cache (Redis-like)
  class L2Cache[K, V](connectionString: String) extends Cache[K, V] {
    def get(key: K): Either[String, Option[V]] = ???
    def put(key: K, value: V, ttlSeconds: Int): Either[String, Unit] = ???
    def invalidate(key: K): Either[String, Unit] = ???
    def invalidateAll(): Either[String, Unit] = ???
  }

  // TODO: Implement multi-level cache that checks L1 first, then L2
  class MultiLevelCache[K, V](l1: L1Cache[K, V], l2: L2Cache[K, V]) extends Cache[K, V] {
    def get(key: K): Either[String, Option[V]] = ???  // L1 -> L2 -> miss
    def put(key: K, value: V, ttlSeconds: Int): Either[String, Unit] = ???  // write to both
    def invalidate(key: K): Either[String, Unit] = ???  // invalidate both
    def invalidateAll(): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 2: Connection Pool Design
  // ============================================================
  // TODO: Design a connection pool with configurable size, health
  //  checks, and connection lifecycle management.

  case class PoolConfig(
    minSize: Int,
    maxSize: Int,
    maxIdleTimeMs: Long,
    connectionTimeoutMs: Long,
    validationQuery: String,
    healthCheckIntervalMs: Long
  )

  trait Poolable[C] {
    def create(): Either[String, C]
    def validate(conn: C): Boolean
    def destroy(conn: C): Unit
  }

  trait ConnectionPool[C] {
    def acquire(): Either[String, C]
    def release(conn: C): Either[String, Unit]
    def withConnection[A](f: C => Either[String, A]): Either[String, A]
    def stats: PoolStats
  }

  case class PoolStats(
    totalConnections: Int,
    activeConnections: Int,
    idleConnections: Int,
    waitingRequests: Int,
    totalCreated: Long,
    totalDestroyed: Long
  )

  // TODO: Implement connection pool
  class SimpleConnectionPool[C](config: PoolConfig, factory: Poolable[C]) extends ConnectionPool[C] {
    def acquire(): Either[String, C] = ???
    def release(conn: C): Either[String, Unit] = ???
    def withConnection[A](f: C => Either[String, A]): Either[String, A] = ???
    def stats: PoolStats = ???
  }

  // ============================================================
  // Exercise 3: Batch Processing Design
  // ============================================================
  // TODO: Design a batch processing system that efficiently processes
  //  large datasets with windowing, checkpointing, and error handling.

  case class BatchConfig(
    batchSize: Int,
    maxConcurrency: Int,
    checkpointInterval: Int,
    errorThreshold: Double  // max error rate before stopping
  )

  case class BatchResult(
    totalProcessed: Long,
    successCount: Long,
    errorCount: Long,
    skippedCount: Long,
    durationMs: Long,
    lastCheckpoint: Option[String]
  )

  trait BatchProcessor[A, B] {
    def process(items: Iterator[A]): Either[String, BatchResult]
    def processItem(item: A): Either[String, B]
    def checkpoint(position: String): Either[String, Unit]
    def resume(fromCheckpoint: String): Either[String, BatchResult]
  }

  // TODO: Implement batch processor with checkpointing
  class CheckpointedBatchProcessor[A, B](
    config: BatchConfig,
    processor: A => Either[String, B],
    positionExtractor: A => String
  ) extends BatchProcessor[A, B] {
    def process(items: Iterator[A]): Either[String, BatchResult] = ???
    def processItem(item: A): Either[String, B] = ???
    def checkpoint(position: String): Either[String, Unit] = ???
    def resume(fromCheckpoint: String): Either[String, BatchResult] = ???
  }

  // ============================================================
  // Exercise 4: Lazy Loading Strategy
  // ============================================================
  // TODO: Design lazy loading patterns for expensive computations
  //  and large data sets. Include caching and invalidation.

  // Lazy value with caching
  class LazyValue[A](compute: () => A) {
    @volatile private var cached: Option[A] = None

    def get: A = ???
    def invalidate(): Unit = ???
    def isLoaded: Boolean = ???
  }

  // Lazy collection that loads pages on demand
  trait LazyCollection[A] {
    def get(index: Int): Either[String, A]
    def size: Int
    def loadedCount: Int
    def prefetch(from: Int, count: Int): Either[String, Unit]
  }

  // TODO: Implement a lazy-loading repository
  class LazyLoadingRepository[A](
    pageSize: Int,
    loader: (Int, Int) => Either[String, (List[A], Int)]  // (offset, limit) => (items, total)
  ) extends LazyCollection[A] {
    def get(index: Int): Either[String, A] = ???
    def size: Int = ???
    def loadedCount: Int = ???
    def prefetch(from: Int, count: Int): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 5: Pagination Strategy
  // ============================================================
  // TODO: Design efficient pagination for different use cases.
  //  Compare offset, keyset, and cursor-based approaches.

  // Keyset pagination: efficient for large datasets
  case class KeysetPage[A](
    items: List[A],
    lastKey: Option[String],
    hasMore: Boolean,
    pageSize: Int
  )

  trait KeysetPaginator[A] {
    def firstPage(pageSize: Int): Either[String, KeysetPage[A]]
    def nextPage(afterKey: String, pageSize: Int): Either[String, KeysetPage[A]]
    def previousPage(beforeKey: String, pageSize: Int): Either[String, KeysetPage[A]]
  }

  // TODO: Implement keyset pagination
  class KeysetPaginatorImpl[A](
    fetchPage: (Option[String], Int, Boolean) => Either[String, (List[A], Boolean)],
    getKey: A => String
  ) extends KeysetPaginator[A] {
    def firstPage(pageSize: Int): Either[String, KeysetPage[A]] = ???
    def nextPage(afterKey: String, pageSize: Int): Either[String, KeysetPage[A]] = ???
    def previousPage(beforeKey: String, pageSize: Int): Either[String, KeysetPage[A]] = ???
  }

  // ============================================================
  // Exercise 6: Query Optimization Design
  // ============================================================
  // TODO: Design query optimization patterns: query planning,
  //  index hints, and N+1 prevention.

  // Query builder with optimization hints
  case class Query(
    table: String,
    conditions: List[Condition],
    joins: List[Join],
    orderBy: List[(String, String)],
    limit: Option[Int],
    offset: Option[Int],
    hints: List[QueryHint]
  )

  sealed trait Condition
  case class Equals(field: String, value: Any) extends Condition
  case class In(field: String, values: List[Any]) extends Condition
  case class Between(field: String, from: Any, to: Any) extends Condition

  case class Join(table: String, on: String, joinType: String)

  sealed trait QueryHint
  case class UseIndex(indexName: String) extends QueryHint
  case class ForceIndex(indexName: String) extends QueryHint
  case object NoCache extends QueryHint
  case class MaxExecutionTime(ms: Int) extends QueryHint

  // TODO: Implement N+1 query prevention with batch loading
  trait BatchLoader[K, V] {
    def loadBatch(keys: Set[K]): Either[String, Map[K, V]]
  }

  class DataLoader[K, V](batchLoader: BatchLoader[K, V], maxBatchSize: Int) {
    private val buffer = scala.collection.mutable.Set.empty[K]

    def load(key: K): Unit = ???
    def dispatch(): Either[String, Map[K, V]] = ???
  }

  // ============================================================
  // Exercise 7: Async Processing Design
  // ============================================================
  // TODO: Design async processing patterns for long-running operations.
  //  Include job queue, status tracking, and result retrieval.

  sealed trait JobStatus
  case object Queued extends JobStatus
  case object Processing extends JobStatus
  case class Completed(result: String) extends JobStatus
  case class JobFailed(error: String) extends JobStatus

  case class AsyncJob(
    id: String,
    jobType: String,
    payload: Map[String, String],
    status: JobStatus,
    createdAt: Long,
    startedAt: Option[Long],
    completedAt: Option[Long],
    progress: Option[Double]  // 0.0 to 1.0
  )

  trait AsyncJobProcessor {
    def submit(jobType: String, payload: Map[String, String]): Either[String, String]  // returns job ID
    def getStatus(jobId: String): Either[String, AsyncJob]
    def cancel(jobId: String): Either[String, Unit]
    def getResult(jobId: String): Either[String, Option[String]]
    def listJobs(status: Option[JobStatus], limit: Int): Either[String, List[AsyncJob]]
  }

  // TODO: Implement async job processor
  class InMemoryJobProcessor extends AsyncJobProcessor {
    def submit(jobType: String, payload: Map[String, String]): Either[String, String] = ???
    def getStatus(jobId: String): Either[String, AsyncJob] = ???
    def cancel(jobId: String): Either[String, Unit] = ???
    def getResult(jobId: String): Either[String, Option[String]] = ???
    def listJobs(status: Option[JobStatus], limit: Int): Either[String, List[AsyncJob]] = ???
  }

  // ============================================================
  // Exercise 8: Backpressure Design
  // ============================================================
  // TODO: Design backpressure mechanisms to prevent system overload.
  //  Include bounded queues, rate limiting, and load shedding.

  sealed trait BackpressureStrategy
  case class BoundedQueue(maxSize: Int) extends BackpressureStrategy
  case class DropOldest(maxSize: Int) extends BackpressureStrategy
  case class DropNewest(maxSize: Int) extends BackpressureStrategy
  case class ThrottleRate(maxPerSecond: Int) extends BackpressureStrategy

  sealed trait BackpressureSignal
  case object Accept extends BackpressureSignal
  case object Reject extends BackpressureSignal
  case class SlowDown(delayMs: Long) extends BackpressureSignal

  trait BackpressureController {
    def tryAccept(): BackpressureSignal
    def currentLoad: Double  // 0.0 to 1.0
    def configure(strategy: BackpressureStrategy): Unit
  }

  // TODO: Implement backpressure with load shedding
  class LoadSheddingController(
    maxConcurrent: Int,
    highWaterMark: Double,  // start shedding above this load
    lowWaterMark: Double    // stop shedding below this load
  ) extends BackpressureController {
    @volatile private var currentConcurrent = 0
    @volatile private var shedding = false

    def tryAccept(): BackpressureSignal = ???
    def currentLoad: Double = ???
    def configure(strategy: BackpressureStrategy): Unit = ???
    def complete(): Unit = ???  // signal that a request completed
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch011: Performance Design ===")
    println()
    println("Exercise 1: Caching Strategy (L1/L2)")
    println("Exercise 2: Connection Pool Design")
    println("Exercise 3: Batch Processing Design")
    println("Exercise 4: Lazy Loading Strategy")
    println("Exercise 5: Pagination Strategy")
    println("Exercise 6: Query Optimization Design")
    println("Exercise 7: Async Processing Design")
    println("Exercise 8: Backpressure Design")
  }
}
