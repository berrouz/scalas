package org.shev4ik.interview.http4s.level1_basics

/**
 * Http4s 005 - Basic Server
 *
 * Server configuration, binding, and lifecycle management concepts.
 * Key concepts:
 *   - Server binding to host:port
 *   - Server configuration (timeouts, thread pools)
 *   - Lifecycle: startup -> running -> shutdown
 *   - Graceful shutdown with resource cleanup
 *   - Health checks and readiness probes
 *   - Server as a resource (bracket pattern)
 */
object Http005_BasicServer {

  // --- Domain models ---

  case class ServerConfig(
    host: String,
    port: Int,
    idleTimeout: Long,        // milliseconds
    maxConnections: Int,
    shutdownTimeout: Long,    // milliseconds
    threadPoolSize: Int
  )

  sealed trait ServerState
  object ServerState {
    case object Starting   extends ServerState
    case object Running    extends ServerState
    case object ShuttingDown extends ServerState
    case object Stopped    extends ServerState
  }

  case class ServerInfo(
    config: ServerConfig,
    state: ServerState,
    activeConnections: Int,
    startTime: Long
  )

  sealed trait LifecycleEvent
  object LifecycleEvent {
    case class Started(host: String, port: Int)          extends LifecycleEvent
    case class ConnectionAccepted(id: String)            extends LifecycleEvent
    case class ConnectionClosed(id: String)              extends LifecycleEvent
    case class ShutdownInitiated(reason: String)         extends LifecycleEvent
    case object ShutdownComplete                         extends LifecycleEvent
  }

  // Resource bracket pattern (simplified)
  case class Resource[A](
    acquire: () => A,
    release: A => Unit
  ) {
    def use[B](f: A => B): B = {
      val a = acquire()
      try f(a)
      finally release(a)
    }
  }

  // Exercise 1: Create a default server configuration
  // TODO: Create a ServerConfig with:
  //   host = "0.0.0.0", port = 8080, idleTimeout = 60000,
  //   maxConnections = 1024, shutdownTimeout = 30000, threadPoolSize = available processors
  //   Use Runtime.getRuntime.availableProcessors() for threadPoolSize
  def exercise1_defaultConfig: ServerConfig = ???

  // Exercise 2: Validate a server configuration
  // TODO: Return a list of error messages for invalid config values:
  //   - port must be between 1 and 65535 -> "invalid port: <port>"
  //   - maxConnections must be > 0 -> "maxConnections must be positive"
  //   - threadPoolSize must be > 0 -> "threadPoolSize must be positive"
  //   - idleTimeout must be > 0 -> "idleTimeout must be positive"
  //   Return empty list if config is valid.
  def exercise2_validateConfig(config: ServerConfig): List[String] = ???

  // Exercise 3: Model server state transitions
  // TODO: Given a current ServerState and an event, return the new state.
  //   Starting + Started -> Running
  //   Running + ShutdownInitiated -> ShuttingDown
  //   ShuttingDown + ShutdownComplete -> Stopped
  //   Any other combination -> return current state unchanged
  def exercise3_transition(current: ServerState, event: LifecycleEvent): ServerState = ???

  // Exercise 4: Track active connections
  // TODO: Given a ServerInfo and a LifecycleEvent, return updated ServerInfo.
  //   ConnectionAccepted -> increment activeConnections (but don't exceed maxConnections)
  //   ConnectionClosed -> decrement activeConnections (but don't go below 0)
  //   Other events -> no change to connections
  def exercise4_trackConnections(info: ServerInfo, event: LifecycleEvent): ServerInfo = ???

  // Exercise 5: Create a server resource with acquire/release
  // TODO: Return a Resource[ServerInfo] where:
  //   acquire: creates ServerInfo with given config, state=Running, activeConnections=0,
  //            startTime = System.currentTimeMillis()
  //   release: logs shutdown by returning Unit (just a no-op for this exercise)
  //   The resource pattern ensures cleanup happens even if an exception occurs.
  def exercise5_serverResource(config: ServerConfig): Resource[ServerInfo] = ???

  // Exercise 6: Implement a health check
  // TODO: Given a ServerInfo, return a Map[String, String] with health status:
  //   "status" -> "healthy" if Running and activeConnections < maxConnections, else "unhealthy"
  //   "state" -> state.toString
  //   "connections" -> s"$activeConnections/$maxConnections"
  //   "uptime_ms" -> (System.currentTimeMillis() - startTime).toString
  def exercise6_healthCheck(info: ServerInfo): Map[String, String] = ???

  // Exercise 7: Determine if server should accept new connections
  // TODO: Return true if:
  //   - state is Running
  //   - activeConnections < maxConnections
  //   - Otherwise return false
  def exercise7_canAcceptConnection(info: ServerInfo): Boolean = ???

  // Exercise 8: Compute server metrics
  // TODO: Given a list of LifecycleEvents, compute:
  //   "total_connections_accepted" -> count of ConnectionAccepted events
  //   "total_connections_closed" -> count of ConnectionClosed events
  //   "current_active" -> accepted - closed (min 0)
  //   "shutdowns_initiated" -> count of ShutdownInitiated events
  //   Return as Map[String, Int]
  def exercise8_computeMetrics(events: List[LifecycleEvent]): Map[String, Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val cfg = exercise1_defaultConfig
    assert(cfg.host == "0.0.0.0", "Exercise 1 failed: wrong host")
    assert(cfg.port == 8080, "Exercise 1 failed: wrong port")
    assert(cfg.maxConnections == 1024, "Exercise 1 failed: wrong maxConnections")
    assert(cfg.threadPoolSize > 0, "Exercise 1 failed: threadPoolSize should be > 0")
    println("Exercise 1 passed: default config created")

    // Exercise 2
    assert(exercise2_validateConfig(cfg).isEmpty, "Exercise 2 failed: default config should be valid")
    val badCfg = cfg.copy(port = -1, maxConnections = 0)
    val errors = exercise2_validateConfig(badCfg)
    assert(errors.exists(_.contains("port")), "Exercise 2 failed: should flag port")
    assert(errors.exists(_.contains("maxConnections")), "Exercise 2 failed: should flag maxConnections")
    println("Exercise 2 passed: config validation works")

    // Exercise 3
    import ServerState._, LifecycleEvent._
    assert(exercise3_transition(Starting, Started("0.0.0.0", 8080)) == Running, "Exercise 3 failed: Starting->Running")
    assert(exercise3_transition(Running, ShutdownInitiated("signal")) == ShuttingDown, "Exercise 3 failed: Running->ShuttingDown")
    assert(exercise3_transition(ShuttingDown, ShutdownComplete) == Stopped, "Exercise 3 failed: ShuttingDown->Stopped")
    assert(exercise3_transition(Stopped, Started("0.0.0.0", 8080)) == Stopped, "Exercise 3 failed: invalid transition")
    println("Exercise 3 passed: state transitions work")

    // Exercise 4
    val info = ServerInfo(cfg, Running, 5, System.currentTimeMillis())
    val accepted = exercise4_trackConnections(info, ConnectionAccepted("conn-1"))
    assert(accepted.activeConnections == 6, "Exercise 4 failed: should increment")
    val closed = exercise4_trackConnections(info, ConnectionClosed("conn-1"))
    assert(closed.activeConnections == 4, "Exercise 4 failed: should decrement")
    val zeroInfo = info.copy(activeConnections = 0)
    val notNeg = exercise4_trackConnections(zeroInfo, ConnectionClosed("conn-1"))
    assert(notNeg.activeConnections == 0, "Exercise 4 failed: should not go below 0")
    println("Exercise 4 passed: connection tracking works")

    // Exercise 5
    val resource = exercise5_serverResource(cfg)
    var released = false
    val result = resource.use { si =>
      assert(si.state == Running, "Exercise 5 failed: should be Running")
      assert(si.activeConnections == 0, "Exercise 5 failed: should have 0 connections")
      "done"
    }
    assert(result == "done", "Exercise 5 failed: use should return result")
    println("Exercise 5 passed: server resource works")

    // Exercise 6
    val healthInfo = ServerInfo(cfg, Running, 10, System.currentTimeMillis() - 5000)
    val health = exercise6_healthCheck(healthInfo)
    assert(health("status") == "healthy", "Exercise 6 failed: should be healthy")
    assert(health("connections") == "10/1024", "Exercise 6 failed: wrong connections")
    val unhealthy = exercise6_healthCheck(healthInfo.copy(state = ShuttingDown))
    assert(unhealthy("status") == "unhealthy", "Exercise 6 failed: shutting down should be unhealthy")
    println("Exercise 6 passed: health check works")

    // Exercise 7
    assert(exercise7_canAcceptConnection(info), "Exercise 7 failed: should accept")
    assert(!exercise7_canAcceptConnection(info.copy(state = ShuttingDown)), "Exercise 7 failed: shutting down")
    assert(!exercise7_canAcceptConnection(info.copy(activeConnections = cfg.maxConnections)), "Exercise 7 failed: at capacity")
    println("Exercise 7 passed: connection acceptance check works")

    // Exercise 8
    val events = List(
      ConnectionAccepted("1"), ConnectionAccepted("2"), ConnectionAccepted("3"),
      ConnectionClosed("1"), ConnectionClosed("2"),
      ShutdownInitiated("test")
    )
    val metrics = exercise8_computeMetrics(events)
    assert(metrics("total_connections_accepted") == 3, "Exercise 8 failed: accepted")
    assert(metrics("total_connections_closed") == 2, "Exercise 8 failed: closed")
    assert(metrics("current_active") == 1, "Exercise 8 failed: active")
    assert(metrics("shutdowns_initiated") == 1, "Exercise 8 failed: shutdowns")
    println("Exercise 8 passed: metrics computation works")

    println("\nAll Http005_BasicServer exercises passed!")
  }
}
