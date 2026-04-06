package org.shev4ik.interview.doobie.level3_advanced

/**
 * Doobie 013 - Connection Pooling (HikariCP integration, pool config, health checks)
 *
 * In production, doobie uses HikariCP for connection pooling. The Transactor
 * is typically created via HikariTransactor which wraps a HikariCP pool.
 * Understanding pool configuration (min/max connections, timeouts, leak detection)
 * is essential for production database access.
 *
 * Here we model a simplified connection pool to understand pool semantics,
 * configuration, and health monitoring.
 */
object Doob013_ConnectionPooling {

  // Simplified Connection
  case class Connection(id: Int, createdAt: Long = System.currentTimeMillis()) {
    var inUse: Boolean = false
    var lastUsed: Long = createdAt
  }

  // Pool configuration (mirrors HikariCP config)
  case class PoolConfig(
    minimumIdle: Int = 2,
    maximumPoolSize: Int = 10,
    connectionTimeout: Long = 30000, // ms
    idleTimeout: Long = 600000,      // ms
    maxLifetime: Long = 1800000,     // ms
    leakDetectionThreshold: Long = 0 // 0 = disabled
  )

  // Pool statistics
  case class PoolStats(
    totalConnections: Int,
    activeConnections: Int,
    idleConnections: Int,
    waitingThreads: Int
  )

  // Health check result
  case class HealthCheck(
    isHealthy: Boolean,
    totalConnections: Int,
    activeConnections: Int,
    message: String
  )

  // Simplified Connection Pool
  class ConnectionPool(val config: PoolConfig) {
    private var connections: List[Connection] = List.empty
    private var nextId: Int = 0
    private var waitQueue: Int = 0

    def initialize(): Unit = {
      (0 until config.minimumIdle).foreach { _ =>
        nextId += 1
        connections = connections :+ Connection(nextId)
      }
    }

    def totalSize: Int = connections.size
    def activeSize: Int = connections.count(_.inUse)
    def idleSize: Int = connections.count(!_.inUse)

    def acquire(): Option[Connection] = {
      connections.find(!_.inUse) match {
        case Some(conn) =>
          conn.inUse = true
          conn.lastUsed = System.currentTimeMillis()
          Some(conn)
        case None if connections.size < config.maximumPoolSize =>
          nextId += 1
          val conn = Connection(nextId)
          conn.inUse = true
          connections = connections :+ conn
          Some(conn)
        case None => None
      }
    }

    def release(conn: Connection): Unit = {
      conn.inUse = false
      conn.lastUsed = System.currentTimeMillis()
    }

    def evictIdle(currentTime: Long): Int = {
      val (idle, rest) = connections.partition(c => !c.inUse && (currentTime - c.lastUsed) > config.idleTimeout)
      val toKeep = if (rest.size < config.minimumIdle) {
        val needed = config.minimumIdle - rest.size
        rest ++ idle.take(needed)
      } else rest
      val evicted = connections.size - toKeep.size
      connections = toKeep
      evicted
    }

    def stats: PoolStats = PoolStats(totalSize, activeSize, idleSize, waitQueue)

    def reset(): Unit = { connections = List.empty; nextId = 0; waitQueue = 0 }
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Validate pool configuration.
  // TODO: Check that: minimumIdle <= maximumPoolSize,
  // maximumPoolSize > 0, connectionTimeout > 0.
  // Return Left with error message if invalid, Right(config) if valid.
  // -------------------------------------------------------------------------
  def exercise1_validateConfig(config: PoolConfig): Either[String, PoolConfig] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Initialize a pool and verify minimum idle connections.
  // TODO: Create a ConnectionPool with given config, initialize it,
  // return the number of idle connections.
  // -------------------------------------------------------------------------
  def exercise2_initializePool(config: PoolConfig): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement acquire-use-release pattern.
  // TODO: Acquire a connection from the pool, apply the function f,
  // release the connection, and return the result. If no connection
  // is available, return Left("No connection available").
  // -------------------------------------------------------------------------
  def exercise3_withConnection[A](pool: ConnectionPool)(f: Connection => A): Either[String, A] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement pool exhaustion detection.
  // TODO: Try to acquire more connections than maximumPoolSize.
  // Return the number of successful acquisitions.
  // -------------------------------------------------------------------------
  def exercise4_exhaustPool(pool: ConnectionPool, attempts: Int): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement connection leak detection.
  // TODO: Given a pool, return a list of connections that have been in use
  // longer than the leakDetectionThreshold. Return (connectionId, durationMs).
  // If leakDetectionThreshold is 0, return empty list (disabled).
  // -------------------------------------------------------------------------
  def exercise5_detectLeaks(pool: ConnectionPool, currentTime: Long): List[(Int, Long)] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Perform a health check on the pool.
  // TODO: Return a HealthCheck. Pool is healthy if:
  // - At least 1 idle connection OR pool is not at max capacity
  // - Active connections < 80% of maximum pool size
  // Message should indicate the status.
  // -------------------------------------------------------------------------
  def exercise6_healthCheck(pool: ConnectionPool): HealthCheck = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement connection max-lifetime eviction.
  // TODO: Given current time, evict connections whose lifetime
  // (currentTime - createdAt) exceeds maxLifetime. Don't evict connections
  // that are in use. Return the count of evicted connections.
  // -------------------------------------------------------------------------
  def exercise7_evictExpired(pool: ConnectionPool, currentTime: Long): Int = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement pool metrics aggregation over time.
  // TODO: Given a list of PoolStats snapshots taken over time, compute:
  // - peak active connections
  // - average utilization (active/total ratio)
  // - whether the pool was ever exhausted (active == total for any snapshot)
  // Return (peakActive, avgUtilization, wasExhausted).
  // -------------------------------------------------------------------------
  def exercise8_aggregateMetrics(snapshots: List[PoolStats]): (Int, Double, Boolean) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_validateConfig(PoolConfig()).isRight)
    assert(exercise1_validateConfig(PoolConfig(minimumIdle = 20, maximumPoolSize = 5)).isLeft)
    assert(exercise1_validateConfig(PoolConfig(maximumPoolSize = 0)).isLeft)
    println("Exercise 1 passed: validate pool config")

    // Exercise 2
    assert(exercise2_initializePool(PoolConfig(minimumIdle = 3, maximumPoolSize = 10)) == 3)
    assert(exercise2_initializePool(PoolConfig(minimumIdle = 5, maximumPoolSize = 10)) == 5)
    println("Exercise 2 passed: initialize pool")

    // Exercise 3
    val pool3 = new ConnectionPool(PoolConfig(minimumIdle = 2, maximumPoolSize = 5))
    pool3.initialize()
    val r3 = exercise3_withConnection(pool3)(c => c.id)
    assert(r3.isRight)
    assert(pool3.activeSize == 0) // connection released
    println("Exercise 3 passed: acquire-use-release")

    // Exercise 4
    val pool4 = new ConnectionPool(PoolConfig(minimumIdle = 1, maximumPoolSize = 3))
    pool4.initialize()
    assert(exercise4_exhaustPool(pool4, 5) == 3)
    println("Exercise 4 passed: pool exhaustion")

    // Exercise 5
    val pool5 = new ConnectionPool(PoolConfig(minimumIdle = 2, maximumPoolSize = 5, leakDetectionThreshold = 5000))
    pool5.initialize()
    val conn5 = pool5.acquire().get
    // Simulate time passing
    conn5.lastUsed = System.currentTimeMillis() - 10000
    val leaks = exercise5_detectLeaks(pool5, System.currentTimeMillis())
    assert(leaks.size == 1)
    pool5.release(conn5)
    println("Exercise 5 passed: leak detection")

    // Exercise 6
    val pool6 = new ConnectionPool(PoolConfig(minimumIdle = 2, maximumPoolSize = 5))
    pool6.initialize()
    val hc6 = exercise6_healthCheck(pool6)
    assert(hc6.isHealthy)
    println("Exercise 6 passed: health check")

    // Exercise 7
    val pool7 = new ConnectionPool(PoolConfig(minimumIdle = 0, maximumPoolSize = 5, maxLifetime = 1000))
    pool7.initialize()
    // Pool7 has minimumIdle=0 so no connections created. Let's add some manually via acquire
    val c7a = pool7.acquire().get
    val c7b = pool7.acquire().get
    pool7.release(c7a)
    pool7.release(c7b)
    val evicted = exercise7_evictExpired(pool7, System.currentTimeMillis() + 2000)
    assert(evicted == 2)
    println("Exercise 7 passed: max-lifetime eviction")

    // Exercise 8
    val snapshots = List(
      PoolStats(10, 3, 7, 0),
      PoolStats(10, 8, 2, 0),
      PoolStats(10, 10, 0, 2),
      PoolStats(10, 5, 5, 0)
    )
    val (peak, avgUtil, exhausted) = exercise8_aggregateMetrics(snapshots)
    assert(peak == 10)
    assert(math.abs(avgUtil - 0.65) < 0.01)
    assert(exhausted)
    println("Exercise 8 passed: metrics aggregation")

    println("\nAll Doob013_ConnectionPooling exercises passed!")
  }
}
