package org.shev4ik.interview.system_design.level1_fundamentals

object SysDes004_ServiceDiscovery {

  // ---- Domain types ----

  case class ServiceInstance(
    serviceId: String,
    instanceId: String,
    host: String,
    port: Int,
    healthy: Boolean = true,
    lastHeartbeat: Long = 0L,
    metadata: Map[String, String] = Map.empty
  )

  // ---- Exercise 1 ----
  // TODO: Implement a service registry.
  // - `register(instance)`: add instance to registry
  // - `deregister(serviceId, instanceId)`: remove specific instance
  // - `lookup(serviceId)`: return all instances for a service
  // - `allServices`: return all distinct service IDs
  // Backed by a Map[String, List[ServiceInstance]] (serviceId -> instances)
  trait ServiceRegistry {
    def register(instance: ServiceInstance): ServiceRegistry
    def deregister(serviceId: String, instanceId: String): ServiceRegistry
    def lookup(serviceId: String): List[ServiceInstance]
    def allServices: Set[String]
  }

  def createRegistry(): ServiceRegistry = ???

  // ---- Exercise 2 ----
  // TODO: Implement a health check mechanism.
  // Given a registry and a health check function (instanceId => Boolean),
  // update all instances in the registry: set `healthy` based on the check result.
  // Return the updated registry.
  def performHealthChecks(
    registry: ServiceRegistry,
    check: String => Boolean
  ): ServiceRegistry = ???

  // ---- Exercise 3 ----
  // TODO: Implement client-side service discovery.
  // The client fetches the full list of healthy instances for a service,
  // then picks one using round-robin (given a request index).
  // Return the chosen instance or None if no healthy instances available.
  // `requestIndex` is the nth request (0-based) used for round-robin.
  def clientSideDiscovery(
    registry: ServiceRegistry,
    serviceId: String,
    requestIndex: Int
  ): Option[ServiceInstance] = ???

  // ---- Exercise 4 ----
  // TODO: Implement server-side service discovery.
  // A load balancer sits between client and services. The client sends to the LB,
  // which picks a healthy instance using least-connections (fewest active connections).
  // Given a map of instanceId -> activeConnections, pick the instance with fewest.
  // Break ties by instanceId alphabetical order.
  // Return the chosen instance or None if no healthy instances.
  def serverSideDiscovery(
    registry: ServiceRegistry,
    serviceId: String,
    activeConnections: Map[String, Int]
  ): Option[ServiceInstance] = ???

  // ---- Exercise 5 ----
  // TODO: Implement a simple DNS-based discovery simulation.
  // Maintain a DNS table: Map[String, List[(String, Int)]] mapping
  // service name to list of (host, port) tuples.
  // `resolve(serviceName)` returns the list of addresses.
  // `register(serviceName, host, port)` adds an entry.
  // `deregister(serviceName, host, port)` removes an entry.
  trait DnsDiscovery {
    def register(serviceName: String, host: String, port: Int): DnsDiscovery
    def deregister(serviceName: String, host: String, port: Int): DnsDiscovery
    def resolve(serviceName: String): List[(String, Int)]
  }

  def createDnsDiscovery(): DnsDiscovery = ???

  // ---- Exercise 6 ----
  // TODO: Implement a heartbeat mechanism.
  // Each instance periodically sends a heartbeat (timestamp).
  // `receiveHeartbeat(instanceId, timestamp)`: update the last heartbeat time.
  // `detectFailures(currentTime, timeoutMs)`: return list of instanceIds whose
  //   last heartbeat is older than (currentTime - timeoutMs). These are considered failed.
  // State: Map[String, Long] (instanceId -> lastHeartbeatTime)
  trait HeartbeatMonitor {
    def receiveHeartbeat(instanceId: String, timestamp: Long): HeartbeatMonitor
    def detectFailures(currentTime: Long, timeoutMs: Long): List[String]
    def lastHeartbeats: Map[String, Long]
  }

  def createHeartbeatMonitor(): HeartbeatMonitor = ???

  def main(args: Array[String]): Unit = {
    val inst1 = ServiceInstance("auth", "auth-1", "10.0.0.1", 8080)
    val inst2 = ServiceInstance("auth", "auth-2", "10.0.0.2", 8080)
    val inst3 = ServiceInstance("payment", "pay-1", "10.0.0.3", 9090)

    // Exercise 1: Service Registry
    val reg0 = createRegistry()
    val reg1 = reg0.register(inst1).register(inst2).register(inst3)
    assert(reg1.lookup("auth").length == 2)
    assert(reg1.lookup("payment").length == 1)
    assert(reg1.allServices == Set("auth", "payment"))
    val reg2 = reg1.deregister("auth", "auth-1")
    assert(reg2.lookup("auth").length == 1)
    println("Exercise 1 passed: Service Registry")

    // Exercise 2: Health Checks
    val reg3 = reg1
    val reg4 = performHealthChecks(reg3, id => id != "auth-2")
    assert(reg4.lookup("auth").find(_.instanceId == "auth-1").get.healthy)
    assert(!reg4.lookup("auth").find(_.instanceId == "auth-2").get.healthy)
    assert(reg4.lookup("payment").find(_.instanceId == "pay-1").get.healthy)
    println("Exercise 2 passed: Health Checks")

    // Exercise 3: Client-side discovery
    val healthyReg = reg1 // all healthy
    val picked0 = clientSideDiscovery(healthyReg, "auth", 0)
    val picked1 = clientSideDiscovery(healthyReg, "auth", 1)
    assert(picked0.isDefined && picked1.isDefined)
    assert(picked0.get.instanceId != picked1.get.instanceId) // round-robin
    assert(clientSideDiscovery(healthyReg, "unknown", 0).isEmpty)
    println("Exercise 3 passed: Client-side discovery")

    // Exercise 4: Server-side discovery
    val conns = Map("auth-1" -> 5, "auth-2" -> 3)
    val ssResult = serverSideDiscovery(reg1, "auth", conns)
    assert(ssResult.get.instanceId == "auth-2") // fewer connections
    assert(serverSideDiscovery(reg1, "unknown", Map.empty).isEmpty)
    println("Exercise 4 passed: Server-side discovery")

    // Exercise 5: DNS-based discovery
    val dns0 = createDnsDiscovery()
    val dns1 = dns0.register("auth-svc", "10.0.0.1", 8080).register("auth-svc", "10.0.0.2", 8080)
    assert(dns1.resolve("auth-svc").length == 2)
    val dns2 = dns1.deregister("auth-svc", "10.0.0.1", 8080)
    assert(dns2.resolve("auth-svc").length == 1)
    assert(dns2.resolve("unknown").isEmpty)
    println("Exercise 5 passed: DNS-based discovery")

    // Exercise 6: Heartbeat mechanism
    val hb0 = createHeartbeatMonitor()
    val hb1 = hb0.receiveHeartbeat("inst-1", 1000).receiveHeartbeat("inst-2", 1000)
    val hb2 = hb1.receiveHeartbeat("inst-1", 3000) // inst-1 updates, inst-2 does not
    val failed = hb2.detectFailures(currentTime = 4000, timeoutMs = 2000)
    assert(failed.contains("inst-2"))
    assert(!failed.contains("inst-1"))
    println("Exercise 6 passed: Heartbeat mechanism")

    println("All SysDes004_ServiceDiscovery exercises passed!")
  }
}
