package org.shev4ik.interview.system_design.level1_fundamentals

object SysDes001_LoadBalancing {

  // ---- Domain types ----

  case class Server(id: String, weight: Int = 1, healthy: Boolean = true, activeConnections: Int = 0)

  // ---- Exercise 1 ----
  // TODO: Implement round-robin load balancing.
  // Given a list of servers and a number of requests, return the sequence of server IDs
  // that each request is routed to. Cycle through servers in order.
  // Example: servers=[A,B,C], requests=5 => List(A,B,C,A,B)
  def roundRobin(servers: List[Server], numRequests: Int): List[String] = ???

  // ---- Exercise 2 ----
  // TODO: Implement weighted round-robin load balancing.
  // Each server has a weight. A server with weight 3 should receive 3x the traffic
  // of a server with weight 1. Expand servers by weight, then cycle.
  // Example: servers=[(A,w=2),(B,w=1)], requests=6 => List(A,A,B,A,A,B)
  def weightedRoundRobin(servers: List[Server], numRequests: Int): List[String] = ???

  // ---- Exercise 3 ----
  // TODO: Implement least-connections load balancing.
  // Given servers with current active connection counts, pick the server with
  // the fewest active connections. Break ties by server order.
  // Return the server ID that should handle the next request.
  // Example: servers=[(A,conn=3),(B,conn=1),(C,conn=2)] => "B"
  def leastConnections(servers: List[Server]): String = ???

  // ---- Exercise 4 ----
  // TODO: Implement a consistent hashing ring.
  // Place servers on a ring of size `ringSize` using (server.id.hashCode % ringSize).abs.
  // For a given key, find its position as (key.hashCode % ringSize).abs, then walk
  // clockwise to find the first server. Return the server ID.
  // If no servers exist, return "no-server".
  def consistentHashLookup(servers: List[Server], key: String, ringSize: Int = 360): String = ???

  // ---- Exercise 5 ----
  // TODO: Implement IP-hash load balancing.
  // Hash the client IP to deterministically pick a server index.
  // Formula: (ip.hashCode.abs) % servers.size  -> use that index
  // This ensures the same IP always goes to the same server.
  // Example: servers=[A,B,C], ip="192.168.1.1" => consistent server ID
  def ipHash(servers: List[Server], clientIp: String): String = ???

  // ---- Exercise 6 ----
  // TODO: Implement random server selection.
  // Given a seed for reproducibility, use scala.util.Random(seed) to pick a server
  // for each request. Return the list of chosen server IDs.
  // Example: servers=[A,B,C], numRequests=4, seed=42 => deterministic list
  def randomSelection(servers: List[Server], numRequests: Int, seed: Long): List[String] = ???

  // ---- Exercise 7 ----
  // TODO: Simulate periodic health checks.
  // Given servers and a health-check function (serverId => Boolean), return
  // a new list of servers with the `healthy` field updated based on the check result.
  // Example: check("A")=true, check("B")=false => A.healthy=true, B.healthy=false
  def healthCheck(servers: List[Server], check: String => Boolean): List[Server] = ???

  // ---- Exercise 8 ----
  // TODO: Build a load balancer that combines health checks with a strategy.
  // 1) Filter out unhealthy servers.
  // 2) Apply round-robin on the remaining healthy servers.
  // Return the list of server IDs for `numRequests` requests.
  // If no healthy servers, return a list of "no-server" repeated numRequests times.
  def loadBalancer(servers: List[Server], numRequests: Int): List[String] = ???

  def main(args: Array[String]): Unit = {
    val servers3 = List(Server("A"), Server("B"), Server("C"))

    // Exercise 1: roundRobin
    assert(roundRobin(servers3, 5) == List("A", "B", "C", "A", "B"))
    assert(roundRobin(servers3, 0) == Nil)
    assert(roundRobin(List(Server("X")), 3) == List("X", "X", "X"))
    println("Exercise 1 passed: roundRobin")

    // Exercise 2: weightedRoundRobin
    val wServers = List(Server("A", weight = 2), Server("B", weight = 1))
    assert(weightedRoundRobin(wServers, 6) == List("A", "A", "B", "A", "A", "B"))
    assert(weightedRoundRobin(wServers, 3) == List("A", "A", "B"))
    println("Exercise 2 passed: weightedRoundRobin")

    // Exercise 3: leastConnections
    val lcServers = List(
      Server("A", activeConnections = 3),
      Server("B", activeConnections = 1),
      Server("C", activeConnections = 2)
    )
    assert(leastConnections(lcServers) == "B")
    val tiedServers = List(
      Server("A", activeConnections = 1),
      Server("B", activeConnections = 1)
    )
    assert(leastConnections(tiedServers) == "A")
    println("Exercise 3 passed: leastConnections")

    // Exercise 4: consistentHashLookup
    val chResult = consistentHashLookup(servers3, "user123", 360)
    assert(servers3.map(_.id).contains(chResult))
    assert(consistentHashLookup(Nil, "user123") == "no-server")
    // Same key always maps to same server
    assert(consistentHashLookup(servers3, "test", 360) == consistentHashLookup(servers3, "test", 360))
    println("Exercise 4 passed: consistentHashLookup")

    // Exercise 5: ipHash
    val ip1 = ipHash(servers3, "192.168.1.1")
    assert(servers3.map(_.id).contains(ip1))
    // Same IP always maps to same server
    assert(ipHash(servers3, "10.0.0.1") == ipHash(servers3, "10.0.0.1"))
    println("Exercise 5 passed: ipHash")

    // Exercise 6: randomSelection
    val rand1 = randomSelection(servers3, 4, seed = 42)
    val rand2 = randomSelection(servers3, 4, seed = 42)
    assert(rand1 == rand2) // same seed => same result
    assert(rand1.length == 4)
    assert(rand1.forall(servers3.map(_.id).contains))
    println("Exercise 6 passed: randomSelection")

    // Exercise 7: healthCheck
    val hcResult = healthCheck(servers3, id => id != "B")
    assert(hcResult.find(_.id == "A").get.healthy)
    assert(!hcResult.find(_.id == "B").get.healthy)
    assert(hcResult.find(_.id == "C").get.healthy)
    println("Exercise 7 passed: healthCheck")

    // Exercise 8: loadBalancer
    val mixedServers = List(
      Server("A", healthy = true),
      Server("B", healthy = false),
      Server("C", healthy = true)
    )
    assert(loadBalancer(mixedServers, 4) == List("A", "C", "A", "C"))
    val allDown = List(Server("A", healthy = false), Server("B", healthy = false))
    assert(loadBalancer(allDown, 2) == List("no-server", "no-server"))
    println("Exercise 8 passed: loadBalancer")

    println("All SysDes001_LoadBalancing exercises passed!")
  }
}
