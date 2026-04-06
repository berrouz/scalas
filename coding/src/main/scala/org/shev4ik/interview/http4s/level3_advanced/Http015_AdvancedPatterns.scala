package org.shev4ik.interview.http4s.level3_advanced

/**
 * Http4s 015 - Advanced Patterns
 *
 * Advanced HTTP service patterns. Key concepts:
 *   - Service composition (combining multiple services)
 *   - Resource management (bracket pattern for cleanup)
 *   - Graceful shutdown (draining connections)
 *   - Health-aware routing (load balancing)
 *   - Request/response pipeline
 *   - Service registry and discovery patterns
 */
object Http015_AdvancedPatterns {

  // --- Domain models ---

  case class Status(code: Int, reason: String)
  object Status {
    val Ok: Status = Status(200, "OK")
    val BadRequest: Status = Status(400, "Bad Request")
    val NotFound: Status = Status(404, "Not Found")
    val ServiceUnavailable: Status = Status(503, "Service Unavailable")
  }

  case class Header(name: String, value: String)
  case class Request(method: String, path: String, headers: List[Header], body: Option[String])
  case class Response(status: Status, headers: List[Header], body: Option[String])

  type Service = Request => Response

  // Resource with acquire/release lifecycle
  case class Resource[A](acquire: () => A, release: A => Unit) {
    def use[B](f: A => B): B = {
      val a = acquire()
      try f(a) finally release(a)
    }

    def map[B](f: A => B): Resource[B] = Resource(
      acquire = () => f(acquire()),
      release = _ => release(acquire())
    )
  }

  // Service endpoint for routing/load balancing
  case class ServiceEndpoint(
    name: String,
    baseUrl: String,
    healthy: Boolean,
    weight: Int,             // for weighted load balancing
    activeRequests: Int,
    maxRequests: Int
  ) {
    def isAvailable: Boolean = healthy && activeRequests < maxRequests
  }

  // Service registry
  case class ServiceRegistry(
    services: Map[String, List[ServiceEndpoint]]
  )

  // Shutdown state
  case class ShutdownState(
    initiated: Boolean,
    drainingConnections: Int,
    shutdownCallbacks: List[String]    // names of completed callbacks
  )

  // Pipeline step
  case class PipelineStep[A, B](name: String, transform: A => B)

  // Exercise 1: Compose services by path prefix routing
  // TODO: Given a Map[String, Service] where keys are path prefixes,
  //   return a Service that routes to the correct service based on path prefix.
  //   Strip the prefix before passing to the sub-service.
  //   Example: Map("/api/users" -> usersService, "/api/orders" -> ordersService)
  //   Request to "/api/users/123" routes to usersService with path "/123"
  //   If no prefix matches, return Response(Status.NotFound, ..., Some("No service for path"))
  def exercise1_prefixRouter(services: Map[String, Service]): Service = ???

  // Exercise 2: Implement a weighted round-robin selector
  // TODO: Given a list of ServiceEndpoints with weights, and a counter (call count),
  //   select the endpoint using weighted round-robin.
  //   Expand each endpoint by its weight, then use counter % total to select.
  //   Only consider available endpoints (healthy and under max requests).
  //   Return None if no endpoints are available.
  def exercise2_weightedSelect(
    endpoints: List[ServiceEndpoint],
    counter: Int
  ): Option[ServiceEndpoint] = ???

  // Exercise 3: Create a resource-managed service
  // TODO: Given an acquire function (returns a Service) and a release function,
  //   return a Resource[Service] that manages the lifecycle.
  //   This models how http4s manages server/client resources with bracket.
  def exercise3_managedService(
    acquire: () => Service,
    release: Service => Unit
  ): Resource[Service] = ???

  // Exercise 4: Implement graceful shutdown logic
  // TODO: Given a ShutdownState and an event, return the updated state:
  //   "initiate" -> set initiated=true
  //   "connection_drained" -> decrement drainingConnections (min 0)
  //   "callback:<name>" -> add name to shutdownCallbacks
  //   "new_connection" -> if initiated, don't increment (reject). If not initiated, increment drainingConnections
  //   Return updated ShutdownState.
  def exercise4_processShutdownEvent(
    state: ShutdownState,
    event: String
  ): ShutdownState = ???

  // Exercise 5: Check if shutdown is complete
  // TODO: Shutdown is complete when:
  //   - initiated is true
  //   - drainingConnections is 0
  //   - all requiredCallbacks have been completed (present in shutdownCallbacks)
  def exercise5_isShutdownComplete(
    state: ShutdownState,
    requiredCallbacks: List[String]
  ): Boolean = ???

  // Exercise 6: Build a request processing pipeline
  // TODO: Given a list of PipelineSteps for request transformation
  //   (each takes a Request and returns a Request), compose them into
  //   a single function Request => Request that applies all steps in order.
  //   Also return the list of step names that were applied.
  def exercise6_buildPipeline(
    steps: List[PipelineStep[Request, Request]]
  ): Request => (Request, List[String]) = ???

  // Exercise 7: Implement a service registry lookup with fallback
  // TODO: Given a ServiceRegistry and a service name:
  //   - Find all endpoints for that service
  //   - Filter to only available endpoints
  //   - Return the endpoint with the least active requests (least connections)
  //   - If no available endpoints, return None
  def exercise7_discoverService(
    registry: ServiceRegistry,
    serviceName: String
  ): Option[ServiceEndpoint] = ???

  // Exercise 8: Implement a fan-out pattern
  // TODO: Given a list of Services and a Request, send the request to ALL services
  //   and collect the responses. Return a list of (serviceName, Either[Throwable, Response])
  //   where serviceName is s"service-$index" (0-based).
  //   Catch any exceptions thrown by individual services.
  def exercise8_fanOut(
    services: List[Service],
    request: Request
  ): List[(String, Either[Throwable, Response])] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val usersService: Service = req => Response(Status.Ok, List.empty, Some(s"users:${req.path}"))
    val ordersService: Service = req => Response(Status.Ok, List.empty, Some(s"orders:${req.path}"))
    val router = exercise1_prefixRouter(Map("/api/users" -> usersService, "/api/orders" -> ordersService))
    val usersResp = router(Request("GET", "/api/users/123", List.empty, None))
    assert(usersResp.body.contains("users:/123"), s"Exercise 1 failed: got ${usersResp.body}")
    val ordersResp = router(Request("GET", "/api/orders/456", List.empty, None))
    assert(ordersResp.body.contains("orders:/456"), s"Exercise 1 failed: got ${ordersResp.body}")
    val notFound = router(Request("GET", "/api/products", List.empty, None))
    assert(notFound.status == Status.NotFound, "Exercise 1 failed: should return 404")
    println("Exercise 1 passed: prefix router works")

    // Exercise 2
    val endpoints = List(
      ServiceEndpoint("ep1", "http://host1", true, 2, 0, 10),
      ServiceEndpoint("ep2", "http://host2", true, 1, 0, 10),
      ServiceEndpoint("ep3", "http://host3", false, 1, 0, 10)  // unhealthy
    )
    val sel0 = exercise2_weightedSelect(endpoints, 0)
    assert(sel0.isDefined, "Exercise 2 failed: should select an endpoint")
    val sel1 = exercise2_weightedSelect(endpoints, 1)
    assert(sel1.isDefined, "Exercise 2 failed: should select an endpoint")
    // ep1 has weight 2, ep2 has weight 1, ep3 is unhealthy -> expanded: [ep1, ep1, ep2]
    val sel2 = exercise2_weightedSelect(endpoints, 2)
    assert(sel2.exists(_.name == "ep2"), s"Exercise 2 failed: counter 2 should select ep2, got ${sel2.map(_.name)}")
    assert(exercise2_weightedSelect(List.empty, 0).isEmpty, "Exercise 2 failed: empty should return None")
    println("Exercise 2 passed: weighted selection works")

    // Exercise 3
    var acquired = false
    var released = false
    val resource = exercise3_managedService(
      () => { acquired = true; (req: Request) => Response(Status.Ok, List.empty, Some("managed")) },
      _ => released = true
    )
    val result = resource.use { svc =>
      svc(Request("GET", "/", List.empty, None)).body
    }
    assert(acquired, "Exercise 3 failed: should have acquired")
    assert(released, "Exercise 3 failed: should have released")
    assert(result.contains("managed"), "Exercise 3 failed: wrong result")
    println("Exercise 3 passed: resource management works")

    // Exercise 4
    var state = ShutdownState(false, 3, Nil)
    state = exercise4_processShutdownEvent(state, "initiate")
    assert(state.initiated, "Exercise 4 failed: should be initiated")
    state = exercise4_processShutdownEvent(state, "connection_drained")
    assert(state.drainingConnections == 2, "Exercise 4 failed: should decrement")
    state = exercise4_processShutdownEvent(state, "callback:db")
    assert(state.shutdownCallbacks == List("db"), "Exercise 4 failed: callback not recorded")
    state = exercise4_processShutdownEvent(state, "new_connection")
    assert(state.drainingConnections == 2, "Exercise 4 failed: should reject during shutdown")
    println("Exercise 4 passed: shutdown event processing works")

    // Exercise 5
    val completeState = ShutdownState(true, 0, List("db", "cache"))
    assert(exercise5_isShutdownComplete(completeState, List("db", "cache")), "Exercise 5 failed: should be complete")
    assert(!exercise5_isShutdownComplete(completeState, List("db", "cache", "queue")), "Exercise 5 failed: missing callback")
    assert(!exercise5_isShutdownComplete(completeState.copy(drainingConnections = 1), List("db")), "Exercise 5 failed: still draining")
    assert(!exercise5_isShutdownComplete(completeState.copy(initiated = false), List.empty), "Exercise 5 failed: not initiated")
    println("Exercise 5 passed: shutdown completeness check works")

    // Exercise 6
    val steps = List(
      PipelineStep[Request, Request]("add-trace", req => req.copy(headers = Header("X-Trace", "123") :: req.headers)),
      PipelineStep[Request, Request]("normalize", req => req.copy(path = req.path.toLowerCase))
    )
    val pipeline = exercise6_buildPipeline(steps)
    val (processed, appliedSteps) = pipeline(Request("GET", "/API/Users", List.empty, None))
    assert(processed.path == "/api/users", "Exercise 6 failed: path not normalized")
    assert(processed.headers.exists(_.name == "X-Trace"), "Exercise 6 failed: trace header not added")
    assert(appliedSteps == List("add-trace", "normalize"), "Exercise 6 failed: wrong step names")
    println("Exercise 6 passed: pipeline building works")

    // Exercise 7
    val registry = ServiceRegistry(Map(
      "user-service" -> List(
        ServiceEndpoint("us1", "http://us1", true, 1, 5, 10),
        ServiceEndpoint("us2", "http://us2", true, 1, 2, 10),
        ServiceEndpoint("us3", "http://us3", false, 1, 0, 10)
      )
    ))
    val discovered = exercise7_discoverService(registry, "user-service")
    assert(discovered.exists(_.name == "us2"), s"Exercise 7 failed: should select least loaded, got ${discovered.map(_.name)}")
    assert(exercise7_discoverService(registry, "missing-service").isEmpty, "Exercise 7 failed: missing service")
    println("Exercise 7 passed: service discovery works")

    // Exercise 8
    val services: List[Service] = List(
      _ => Response(Status.Ok, List.empty, Some("response-1")),
      _ => throw new RuntimeException("service-2 failed"),
      _ => Response(Status.Ok, List.empty, Some("response-3"))
    )
    val fanOutResults = exercise8_fanOut(services, Request("GET", "/", List.empty, None))
    assert(fanOutResults.length == 3, "Exercise 8 failed: should have 3 results")
    assert(fanOutResults(0)._1 == "service-0", "Exercise 8 failed: wrong name")
    assert(fanOutResults(0)._2.isRight, "Exercise 8 failed: first should succeed")
    assert(fanOutResults(1)._2.isLeft, "Exercise 8 failed: second should fail")
    assert(fanOutResults(2)._2.isRight, "Exercise 8 failed: third should succeed")
    println("Exercise 8 passed: fan-out works")

    println("\nAll Http015_AdvancedPatterns exercises passed!")
  }
}
