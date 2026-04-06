package org.shev4ik.interview.docker_k8s.level1_basics

object DK003_DockerCompose {

  // ---- Domain types ----

  case class ServiceDependency(serviceName: String, condition: String = "service_started") // conditions: service_started, service_healthy, service_completed_successfully

  case class ComposeService(
    name: String,
    image: String,
    ports: List[(Int, Int)] = Nil,           // (host, container)
    environment: Map[String, String] = Map.empty,
    dependsOn: List[ServiceDependency] = Nil,
    networks: List[String] = List("default"),
    volumes: List[String] = Nil,             // "volume_name:/path" or "/host:/container"
    replicas: Int = 1,
    healthCheckCmd: Option[String] = None
  )

  case class ComposeNetwork(name: String, driver: String = "bridge", external: Boolean = false)
  case class ComposeVolume(name: String, driver: String = "local", external: Boolean = false)

  case class ComposeFile(
    services: List[ComposeService],
    networks: List[ComposeNetwork] = List(ComposeNetwork("default")),
    volumes: List[ComposeVolume] = Nil
  )

  // ---- Exercise 1 ----
  // TODO: Determine the startup order of services based on dependsOn.
  // Return a list of lists: each inner list contains services that can start in parallel.
  // Services with no dependencies come first.
  // Example: A depends on B, B depends on C, D has no deps => List(List("C","D"), List("B"), List("A"))
  // If there are circular dependencies, return empty list.
  def startupOrder(compose: ComposeFile): List[List[String]] = ???

  // ---- Exercise 2 ----
  // TODO: Detect circular dependencies between services.
  // Return the list of service names involved in cycles.
  // Example: A -> B -> C -> A => List("A","B","C") (sorted alphabetically)
  // If no cycles, return empty list.
  def detectCircularDeps(compose: ComposeFile): List[String] = ???

  // ---- Exercise 3 ----
  // TODO: Find all services that can communicate with each other (same network).
  // Return a Map[String, Set[String]] where key is network name and value is set of service names on that network.
  // Example: svc1 on ["web","default"], svc2 on ["web"], svc3 on ["default"]
  //       => Map("web" -> Set("svc1","svc2"), "default" -> Set("svc1","svc3"))
  def networkTopology(compose: ComposeFile): Map[String, Set[String]] = ???

  // ---- Exercise 4 ----
  // TODO: Check for port conflicts across services.
  // Two services conflict if they expose the same host port.
  // Return a list of conflicting host ports.
  // Example: svc1 ports [(8080,80)], svc2 ports [(8080,443)] => List(8080)
  def findPortConflicts(compose: ComposeFile): List[Int] = ???

  // ---- Exercise 5 ----
  // TODO: Validate that all service dependencies reference existing services.
  // Return list of errors: "Service '<name>' depends on unknown service '<dep>'"
  // Example: svc "app" depends on "db", but "db" is not defined => error
  def validateDependencies(compose: ComposeFile): List[String] = ???

  // ---- Exercise 6 ----
  // TODO: Validate that all networks referenced by services are declared.
  // Return list of errors: "Service '<name>' references undeclared network '<network>'"
  // Only check against compose.networks names.
  def validateNetworks(compose: ComposeFile): List[String] = ???

  // ---- Exercise 7 ----
  // TODO: Calculate total container count considering replicas.
  // Each service contributes `replicas` number of containers.
  // Return the total number of container instances.
  // Example: svc1(replicas=3), svc2(replicas=1), svc3(replicas=2) => 6
  def totalContainers(compose: ComposeFile): Int = ???

  // ---- Exercise 8 ----
  // TODO: Generate a simplified environment variable resolution map for inter-service communication.
  // For each service, generate variables that other services might need:
  // - "<SERVICE_NAME>_HOST" -> service name (as DNS name in Docker Compose)
  // - "<SERVICE_NAME>_PORT" -> first container port (if any)
  // Service name uppercased with hyphens replaced by underscores.
  // Return Map[String, String] with all generated variables.
  // Example: service "my-db" with port (5432,5432) => Map("MY_DB_HOST" -> "my-db", "MY_DB_PORT" -> "5432")
  def generateServiceDiscoveryEnv(compose: ComposeFile): Map[String, String] = ???

  def main(args: Array[String]): Unit = {
    val db = ComposeService("db", "postgres:15", ports = List((5432, 5432)), networks = List("backend"))
    val redis = ComposeService("redis", "redis:7", ports = List((6379, 6379)), networks = List("backend"))
    val app = ComposeService("app", "myapp:1.0", ports = List((8080, 80)),
      dependsOn = List(ServiceDependency("db"), ServiceDependency("redis")),
      networks = List("backend", "frontend"))
    val nginx = ComposeService("nginx", "nginx:latest", ports = List((80, 80)),
      dependsOn = List(ServiceDependency("app")),
      networks = List("frontend"))

    val compose = ComposeFile(
      services = List(db, redis, app, nginx),
      networks = List(ComposeNetwork("backend"), ComposeNetwork("frontend"))
    )

    // Exercise 1: startupOrder
    val order = startupOrder(compose)
    assert(order.nonEmpty)
    assert(order.head.toSet == Set("db", "redis"))
    assert(order(1) == List("app"))
    assert(order(2) == List("nginx"))
    println("Exercise 1 passed: startupOrder")

    // Exercise 2: detectCircularDeps
    assert(detectCircularDeps(compose).isEmpty)
    val circular = ComposeFile(services = List(
      ComposeService("a", "img", dependsOn = List(ServiceDependency("b"))),
      ComposeService("b", "img", dependsOn = List(ServiceDependency("c"))),
      ComposeService("c", "img", dependsOn = List(ServiceDependency("a")))
    ))
    assert(detectCircularDeps(circular).sorted == List("a", "b", "c"))
    println("Exercise 2 passed: detectCircularDeps")

    // Exercise 3: networkTopology
    val topo = networkTopology(compose)
    assert(topo("backend") == Set("db", "redis", "app"))
    assert(topo("frontend") == Set("app", "nginx"))
    println("Exercise 3 passed: networkTopology")

    // Exercise 4: findPortConflicts
    assert(findPortConflicts(compose).isEmpty)
    val conflicting = ComposeFile(services = List(
      ComposeService("svc1", "img", ports = List((8080, 80))),
      ComposeService("svc2", "img", ports = List((8080, 443)))
    ))
    assert(findPortConflicts(conflicting) == List(8080))
    println("Exercise 4 passed: findPortConflicts")

    // Exercise 5: validateDependencies
    assert(validateDependencies(compose).isEmpty)
    val badDep = ComposeFile(services = List(
      ComposeService("app", "img", dependsOn = List(ServiceDependency("missing")))
    ))
    assert(validateDependencies(badDep).contains("Service 'app' depends on unknown service 'missing'"))
    println("Exercise 5 passed: validateDependencies")

    // Exercise 6: validateNetworks
    assert(validateNetworks(compose).isEmpty)
    val badNet = ComposeFile(
      services = List(ComposeService("app", "img", networks = List("nonexistent"))),
      networks = List(ComposeNetwork("default"))
    )
    assert(validateNetworks(badNet).contains("Service 'app' references undeclared network 'nonexistent'"))
    println("Exercise 6 passed: validateNetworks")

    // Exercise 7: totalContainers
    val scaled = ComposeFile(services = List(
      ComposeService("web", "img", replicas = 3),
      ComposeService("worker", "img", replicas = 2),
      ComposeService("db", "img", replicas = 1)
    ))
    assert(totalContainers(scaled) == 6)
    assert(totalContainers(ComposeFile(services = Nil)) == 0)
    println("Exercise 7 passed: totalContainers")

    // Exercise 8: generateServiceDiscoveryEnv
    val discoverCompose = ComposeFile(services = List(
      ComposeService("my-db", "postgres", ports = List((5432, 5432))),
      ComposeService("cache", "redis", ports = List((6379, 6379)))
    ))
    val env = generateServiceDiscoveryEnv(discoverCompose)
    assert(env("MY_DB_HOST") == "my-db")
    assert(env("MY_DB_PORT") == "5432")
    assert(env("CACHE_HOST") == "cache")
    assert(env("CACHE_PORT") == "6379")
    println("Exercise 8 passed: generateServiceDiscoveryEnv")

    println("All DK003_DockerCompose exercises passed!")
  }
}
