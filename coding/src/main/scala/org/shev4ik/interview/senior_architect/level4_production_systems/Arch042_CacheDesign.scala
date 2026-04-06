package org.shev4ik.interview.senior_architect.level4_production_systems

object Arch042_CacheDesign {

  // Exercise 1: Cache-Aside Pattern
  // Application manages cache explicitly: check cache -> miss -> load from DB -> populate cache
  trait CacheAside[K, V] {
    def get(key: K): Either[String, Option[V]]
    def getOrLoad(key: K, loader: K => Either[String, V]): Either[String, V]
    def put(key: K, value: V, ttlMs: Long): Either[String, Unit]
    def invalidate(key: K): Either[String, Unit]
  }
  class CacheAsideImpl[K, V](cacheName: String) extends CacheAside[K, V] {
    private val cache = scala.collection.mutable.Map.empty[K, (V, Long)]
    def get(key: K): Either[String, Option[V]] = ???
    def getOrLoad(key: K, loader: K => Either[String, V]): Either[String, V] = ???
    def put(key: K, value: V, ttlMs: Long): Either[String, Unit] = ???
    def invalidate(key: K): Either[String, Unit] = ???
  }

  // Exercise 2: Read-Through Cache
  // Cache loads data automatically on miss. Application always reads from cache.
  trait ReadThroughCache[K, V] {
    def get(key: K): Either[String, V]  // always returns data (loads on miss)
    def refresh(key: K): Either[String, V]
    def loader: K => Either[String, V]
  }
  class ReadThroughImpl[K, V](val loader: K => Either[String, V], ttlMs: Long) extends ReadThroughCache[K, V] {
    def get(key: K): Either[String, V] = ???
    def refresh(key: K): Either[String, V] = ???
  }

  // Exercise 3: Write-Through Cache
  // Writes go to cache AND DB synchronously. Guarantees cache consistency.
  trait WriteThroughCache[K, V] {
    def write(key: K, value: V): Either[String, Unit]  // writes to both cache and DB
    def read(key: K): Either[String, Option[V]]
    def delete(key: K): Either[String, Unit]
  }
  class WriteThroughImpl[K, V](dbWriter: (K, V) => Either[String, Unit], dbReader: K => Either[String, Option[V]]) extends WriteThroughCache[K, V] {
    def write(key: K, value: V): Either[String, Unit] = ???
    def read(key: K): Either[String, Option[V]] = ???
    def delete(key: K): Either[String, Unit] = ???
  }

  // Exercise 4: Write-Behind Cache
  // Writes go to cache immediately, DB write is async/batched. Better write performance.
  trait WriteBehindCache[K, V] {
    def write(key: K, value: V): Either[String, Unit]  // writes to cache, queues DB write
    def read(key: K): Either[String, Option[V]]
    def flush(): Either[String, Int]  // flush pending writes to DB
    def pendingWrites: Int
  }
  class WriteBehindImpl[K, V](dbWriter: List[(K, V)] => Either[String, Unit], batchSize: Int, flushIntervalMs: Long) extends WriteBehindCache[K, V] {
    private val writeQueue = scala.collection.mutable.ListBuffer.empty[(K, V)]
    def write(key: K, value: V): Either[String, Unit] = ???
    def read(key: K): Either[String, Option[V]] = ???
    def flush(): Either[String, Int] = ???
    def pendingWrites: Int = ???
  }

  // Exercise 5: Cache Invalidation Strategies
  sealed trait InvalidationStrategy
  case class TTLInvalidation(defaultTtlMs: Long) extends InvalidationStrategy
  case object EventBasedInvalidation extends InvalidationStrategy
  case class VersionBasedInvalidation(versionField: String) extends InvalidationStrategy
  case object WriteInvalidation extends InvalidationStrategy  // invalidate on write
  trait CacheInvalidator[K] {
    def invalidate(key: K): Either[String, Unit]
    def invalidateByPattern(pattern: String): Either[String, Int]
    def invalidateByTag(tag: String): Either[String, Int]
    def strategy: InvalidationStrategy
  }
  class EventDrivenInvalidator[K] extends CacheInvalidator[K] {
    val strategy: InvalidationStrategy = EventBasedInvalidation
    def invalidate(key: K): Either[String, Unit] = ???
    def invalidateByPattern(pattern: String): Either[String, Int] = ???
    def invalidateByTag(tag: String): Either[String, Int] = ???
  }

  // Exercise 6: Distributed Cache
  case class CacheNode(id: String, host: String, port: Int, weight: Int)
  trait DistributedCache[K, V] {
    def get(key: K): Either[String, Option[V]]
    def put(key: K, value: V, ttlMs: Long): Either[String, Unit]
    def delete(key: K): Either[String, Unit]
    def getNode(key: K): CacheNode
    def addNode(node: CacheNode): Either[String, Unit]
    def removeNode(nodeId: String): Either[String, Unit]
  }
  class ConsistentHashCache[K, V](nodes: List[CacheNode]) extends DistributedCache[K, V] {
    def get(key: K): Either[String, Option[V]] = ???
    def put(key: K, value: V, ttlMs: Long): Either[String, Unit] = ???
    def delete(key: K): Either[String, Unit] = ???
    def getNode(key: K): CacheNode = ???
    def addNode(node: CacheNode): Either[String, Unit] = ???
    def removeNode(nodeId: String): Either[String, Unit] = ???
  }

  // Exercise 7: Cache Warming
  trait CacheWarmer[K, V] {
    def warmup(keys: List[K]): Either[String, Int]
    def warmupFromQuery(query: String): Either[String, Int]
    def warmupPopular(topN: Int): Either[String, Int]
    def isWarmed: Boolean
  }
  class PreloadCacheWarmer[K, V](cache: CacheAside[K, V], loader: K => Either[String, V]) extends CacheWarmer[K, V] {
    def warmup(keys: List[K]): Either[String, Int] = ???
    def warmupFromQuery(query: String): Either[String, Int] = ???
    def warmupPopular(topN: Int): Either[String, Int] = ???
    def isWarmed: Boolean = ???
  }

  // Exercise 8: Cache Stampede Prevention
  // When cache entry expires, many threads try to load simultaneously.
  trait StampedeProtection[K, V] {
    def getWithProtection(key: K, loader: K => Either[String, V]): Either[String, V]
  }
  // Strategy 1: Locking - only one thread loads, others wait
  class LockingStampedeProtection[K, V] extends StampedeProtection[K, V] {
    def getWithProtection(key: K, loader: K => Either[String, V]): Either[String, V] = ???
  }
  // Strategy 2: Probabilistic early expiry - refresh before actual expiry
  class ProbabilisticRefresh[K, V](baselineTtlMs: Long, earlyRefreshWindow: Long) extends StampedeProtection[K, V] {
    def getWithProtection(key: K, loader: K => Either[String, V]): Either[String, V] = ???
    def shouldRefreshEarly(timeToExpiry: Long): Boolean = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch042: Cache Design ===")
    (1 to 8).foreach(i => println(s"Exercise $i"))
  }
}
