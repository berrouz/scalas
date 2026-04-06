package org.shev4ik.interview.grpc.level2_intermediate

/**
 * gRPC 010 - Advanced Patterns
 *
 * Advanced gRPC patterns for production systems.
 * Key concepts:
 *   - Load balancing: client-side (round-robin, weighted) vs proxy-based
 *   - Service discovery: static, DNS, consul, etcd, ZooKeeper
 *   - Health checking: gRPC Health Checking Protocol (SERVING, NOT_SERVING, UNKNOWN)
 *   - Server reflection: runtime service discovery for debugging tools
 *   - Deadline propagation: deadlines flow across service boundaries
 *   - Cancellation propagation: cancelled calls cascade to downstream services
 */
object Grpc010_AdvancedPatterns {

  // --- Domain models for exercises ---

  case class ServiceEndpoint(host: String, port: Int, weight: Int = 1)

  sealed trait HealthStatus
  object HealthStatus {
    case object Serving    extends HealthStatus
    case object NotServing extends HealthStatus
    case object Unknown    extends HealthStatus
  }

  case class ServiceHealth(
    serviceName: String,
    endpoint: ServiceEndpoint,
    status: HealthStatus
  )

  sealed trait LoadBalancingPolicy
  object LoadBalancingPolicy {
    case object RoundRobin       extends LoadBalancingPolicy
    case object WeightedRoundRobin extends LoadBalancingPolicy
    case object PickFirst        extends LoadBalancingPolicy
    case object Random           extends LoadBalancingPolicy
  }

  case class ServiceRegistry(
    services: Map[String, List[ServiceEndpoint]]
  )

  case class MethodDescriptor(
    serviceName: String,
    methodName: String,
    inputType: String,
    outputType: String,
    isClientStreaming: Boolean,
    isServerStreaming: Boolean
  )

  case class Deadline(remainingMs: Long) {
    def isExpired: Boolean = remainingMs <= 0
  }

  case class CallContext(
    deadline: Option[Deadline],
    cancelled: Boolean,
    metadata: Map[String, String]
  )

  // Exercise 1: Implement round-robin load balancing
  // TODO: Given a list of ServiceEndpoints and a call index (0-based),
  //   return the endpoint selected by round-robin (index % endpoints.size).
  //   If endpoints is empty, return None.
  def exercise1_roundRobin(endpoints: List[ServiceEndpoint], callIndex: Int): Option[ServiceEndpoint] = ???

  // Exercise 2: Implement weighted round-robin load balancing
  // TODO: Given a list of ServiceEndpoints with weights, expand the list
  //   by repeating each endpoint `weight` times, then apply round-robin.
  //   Example: [A(w=2), B(w=1)] -> [A, A, B] -> index % 3
  //   Return the selected endpoint, or None if endpoints is empty.
  def exercise2_weightedRoundRobin(endpoints: List[ServiceEndpoint], callIndex: Int): Option[ServiceEndpoint] = ???

  // Exercise 3: Service discovery - register and lookup
  // TODO: Implement two functions:
  //   register: add an endpoint to a service in the registry, return updated registry
  //   lookup: find all endpoints for a service name, return List (empty if not found)
  def exercise3_register(
    registry: ServiceRegistry,
    serviceName: String,
    endpoint: ServiceEndpoint
  ): ServiceRegistry = ???

  def exercise3_lookup(
    registry: ServiceRegistry,
    serviceName: String
  ): List[ServiceEndpoint] = ???

  // Exercise 4: Health check filtering
  // TODO: Given a list of ServiceHealth entries, return only the endpoints
  //   that have HealthStatus.Serving for the given serviceName.
  //   Return List[ServiceEndpoint].
  def exercise4_healthyEndpoints(
    healthChecks: List[ServiceHealth],
    serviceName: String
  ): List[ServiceEndpoint] = ???

  // Exercise 5: Deadline propagation across services
  // TODO: Given an incoming CallContext and a network overhead estimate (in ms),
  //   create a new CallContext for a downstream call:
  //   - If incoming deadline exists, reduce it by overheadMs. If result <= 0, set to 0
  //   - If no deadline, leave as None
  //   - cancelled should be same as incoming
  //   - Copy metadata, add "x-forwarded-for" -> "service-a"
  def exercise5_propagateDeadline(
    incoming: CallContext,
    overheadMs: Long
  ): CallContext = ???

  // Exercise 6: Cancellation propagation
  // TODO: Given a list of downstream CallContexts and an upstream cancellation event,
  //   return a new list where all contexts are marked as cancelled.
  //   Also set metadata key "x-cancellation-reason" -> the given reason string.
  def exercise6_propagateCancellation(
    downstreamContexts: List[CallContext],
    reason: String
  ): List[CallContext] = ???

  // Exercise 7: Implement server reflection - list all methods
  // TODO: Given a list of MethodDescriptors, return a Map[String, List[String]]
  //   where keys are service names and values are sorted lists of fully qualified
  //   method names in format "serviceName/methodName".
  def exercise7_reflectionListMethods(
    methods: List[MethodDescriptor]
  ): Map[String, List[String]] = ???

  // Exercise 8: Implement a simple service mesh routing table
  // TODO: Given a ServiceRegistry and health check data, build a routing table:
  //   Map[String, List[ServiceEndpoint]] where each service maps to its healthy
  //   endpoints (Serving only), sorted by (host, port).
  //   If a service has no healthy endpoints, it should still appear with empty list.
  def exercise8_buildRoutingTable(
    registry: ServiceRegistry,
    healthChecks: List[ServiceHealth]
  ): Map[String, List[ServiceEndpoint]] = ???

  def main(args: Array[String]): Unit = {
    val ep1 = ServiceEndpoint("host1", 8080)
    val ep2 = ServiceEndpoint("host2", 8080)
    val ep3 = ServiceEndpoint("host3", 8080)
    val endpoints = List(ep1, ep2, ep3)

    // Exercise 1
    assert(exercise1_roundRobin(endpoints, 0).contains(ep1), "Exercise 1 failed: index 0")
    assert(exercise1_roundRobin(endpoints, 1).contains(ep2), "Exercise 1 failed: index 1")
    assert(exercise1_roundRobin(endpoints, 3).contains(ep1), "Exercise 1 failed: index 3 wrap")
    assert(exercise1_roundRobin(List.empty, 0).isEmpty, "Exercise 1 failed: empty list")
    println("Exercise 1 passed: round-robin load balancing works")

    // Exercise 2
    val weighted = List(
      ServiceEndpoint("a", 80, weight = 2),
      ServiceEndpoint("b", 80, weight = 1)
    )
    assert(exercise2_weightedRoundRobin(weighted, 0).exists(_.host == "a"), "Exercise 2 failed: idx 0")
    assert(exercise2_weightedRoundRobin(weighted, 1).exists(_.host == "a"), "Exercise 2 failed: idx 1")
    assert(exercise2_weightedRoundRobin(weighted, 2).exists(_.host == "b"), "Exercise 2 failed: idx 2")
    assert(exercise2_weightedRoundRobin(weighted, 3).exists(_.host == "a"), "Exercise 2 failed: idx 3 wrap")
    println("Exercise 2 passed: weighted round-robin works")

    // Exercise 3
    val emptyRegistry = ServiceRegistry(Map.empty)
    val reg1 = exercise3_register(emptyRegistry, "userService", ep1)
    val reg2 = exercise3_register(reg1, "userService", ep2)
    assert(exercise3_lookup(reg2, "userService") == List(ep1, ep2), "Exercise 3 failed: lookup")
    assert(exercise3_lookup(reg2, "unknown").isEmpty, "Exercise 3 failed: unknown service")
    println("Exercise 3 passed: service registry works")

    // Exercise 4
    val healthChecks = List(
      ServiceHealth("svc", ep1, HealthStatus.Serving),
      ServiceHealth("svc", ep2, HealthStatus.NotServing),
      ServiceHealth("svc", ep3, HealthStatus.Serving),
      ServiceHealth("other", ep1, HealthStatus.Serving)
    )
    val healthy = exercise4_healthyEndpoints(healthChecks, "svc")
    assert(healthy == List(ep1, ep3), "Exercise 4 failed: expected ep1 and ep3")
    println("Exercise 4 passed: health check filtering works")

    // Exercise 5
    val ctx = CallContext(Some(Deadline(1000)), cancelled = false, Map("key" -> "val"))
    val propagated = exercise5_propagateDeadline(ctx, 200)
    assert(propagated.deadline.exists(_.remainingMs == 800), "Exercise 5 failed: deadline not reduced")
    assert(propagated.metadata("x-forwarded-for") == "service-a", "Exercise 5 failed: missing header")
    assert(propagated.metadata("key") == "val", "Exercise 5 failed: original metadata lost")
    val noDeadline = exercise5_propagateDeadline(CallContext(None, false, Map.empty), 100)
    assert(noDeadline.deadline.isEmpty, "Exercise 5 failed: should be None")
    println("Exercise 5 passed: deadline propagation works")

    // Exercise 6
    val contexts = List(
      CallContext(Some(Deadline(500)), cancelled = false, Map.empty),
      CallContext(Some(Deadline(300)), cancelled = false, Map.empty)
    )
    val cancelled = exercise6_propagateCancellation(contexts, "client disconnect")
    assert(cancelled.forall(_.cancelled), "Exercise 6 failed: not all cancelled")
    assert(cancelled.forall(_.metadata("x-cancellation-reason") == "client disconnect"),
      "Exercise 6 failed: missing reason")
    println("Exercise 6 passed: cancellation propagation works")

    // Exercise 7
    val methods = List(
      MethodDescriptor("UserService", "GetUser", "Req", "Resp", false, false),
      MethodDescriptor("UserService", "ListUsers", "Req", "Resp", false, true),
      MethodDescriptor("OrderService", "CreateOrder", "Req", "Resp", false, false)
    )
    val reflection = exercise7_reflectionListMethods(methods)
    assert(reflection("UserService") == List("UserService/GetUser", "UserService/ListUsers"),
      "Exercise 7 failed: wrong UserService methods")
    assert(reflection("OrderService") == List("OrderService/CreateOrder"),
      "Exercise 7 failed: wrong OrderService methods")
    println("Exercise 7 passed: server reflection works")

    // Exercise 8
    val registry = ServiceRegistry(Map(
      "svc1" -> List(ep1, ep2),
      "svc2" -> List(ep3)
    ))
    val allHealth = List(
      ServiceHealth("svc1", ep1, HealthStatus.Serving),
      ServiceHealth("svc1", ep2, HealthStatus.NotServing),
      ServiceHealth("svc2", ep3, HealthStatus.Serving)
    )
    val routingTable = exercise8_buildRoutingTable(registry, allHealth)
    assert(routingTable("svc1") == List(ep1), "Exercise 8 failed: svc1")
    assert(routingTable("svc2") == List(ep3), "Exercise 8 failed: svc2")
    assert(routingTable.contains("svc1") && routingTable.contains("svc2"),
      "Exercise 8 failed: missing services")
    println("Exercise 8 passed: routing table built")

    println("\nAll Grpc010_AdvancedPatterns exercises passed!")
  }
}
