package org.shev4ik.interview.docker_k8s.level1_basics

object DK004_K8sBasics {

  // ---- Domain types ----

  case class Label(key: String, value: String)
  case class Container(name: String, image: String, ports: List[Int] = Nil)

  case class PodSpec(
    name: String,
    namespace: String = "default",
    labels: List[Label] = Nil,
    containers: List[Container] = Nil,
    status: String = "Pending" // Pending, Running, Succeeded, Failed, Unknown
  )

  sealed trait ServiceType
  case object ClusterIP extends ServiceType
  case object NodePort extends ServiceType
  case object LoadBalancer extends ServiceType

  case class K8sService(
    name: String,
    namespace: String = "default",
    serviceType: ServiceType = ClusterIP,
    selector: Map[String, String] = Map.empty,
    port: Int,
    targetPort: Int
  )

  case class Deployment(
    name: String,
    namespace: String = "default",
    replicas: Int = 1,
    labels: List[Label] = Nil,
    selector: Map[String, String] = Map.empty,
    podTemplate: PodSpec
  )

  case class Namespace(name: String, labels: List[Label] = Nil)

  // ---- Exercise 1 ----
  // TODO: Select pods matching a label selector.
  // A selector is a Map[String, String]. A pod matches if it has ALL key-value pairs from the selector.
  // Return the list of matching pod names.
  // Example: selector=Map("app"->"web"), pods with labels [app=web, env=prod] and [app=api] => List(first pod name)
  def selectPods(pods: List[PodSpec], selector: Map[String, String]): List[String] = ???

  // ---- Exercise 2 ----
  // TODO: Group pods by namespace.
  // Return a Map[String, List[String]] where key is namespace and value is sorted list of pod names.
  // Example: pods in "default" and "production" => Map("default" -> List(...), "production" -> List(...))
  def groupByNamespace(pods: List[PodSpec]): Map[String, List[String]] = ???

  // ---- Exercise 3 ----
  // TODO: Determine desired pod state for a Deployment.
  // Given a Deployment, generate the list of pod names that should exist.
  // Pod names follow the pattern: "<deployment-name>-<index>" where index goes from 0 to replicas-1.
  // Each pod should have the deployment's labels and the pod template's containers.
  // Return list of PodSpec objects.
  def desiredPods(deployment: Deployment): List[PodSpec] = ???

  // ---- Exercise 4 ----
  // TODO: Find pods that a K8s Service routes to.
  // A service routes to pods whose labels match the service's selector (all key-value pairs).
  // Return the list of matching pod names.
  def serviceEndpoints(service: K8sService, pods: List[PodSpec]): List[String] = ???

  // ---- Exercise 5 ----
  // TODO: Validate a Deployment configuration. Return list of error strings.
  // Rules:
  // - name must not be empty (error: "Deployment name is required")
  // - replicas must be >= 0 (error: "Replicas must be non-negative")
  // - selector must not be empty (error: "Selector is required")
  // - podTemplate must have at least one container (error: "At least one container is required")
  // - Each container image must not be empty (error: "Container '<name>' has no image")
  def validateDeployment(deployment: Deployment): List[String] = ???

  // ---- Exercise 6 ----
  // TODO: Calculate the deployment rollout status.
  // Given a Deployment and the list of current pods (with statuses), return a status summary:
  // (ready: Int, desired: Int, unavailable: Int)
  // - desired = deployment.replicas
  // - ready = count of pods matching the deployment's selector with status "Running"
  // - unavailable = desired - ready (min 0)
  def rolloutStatus(deployment: Deployment, currentPods: List[PodSpec]): (Int, Int, Int) = ???

  // ---- Exercise 7 ----
  // TODO: Find orphaned pods - pods that don't match any deployment's selector.
  // A pod is orphaned if no deployment's selector matches it.
  // Return list of orphaned pod names.
  def findOrphanedPods(pods: List[PodSpec], deployments: List[Deployment]): List[String] = ???

  // ---- Exercise 8 ----
  // TODO: Generate a summary of all resources in a namespace.
  // Return a Map[String, Int] with counts:
  // - "pods" -> number of pods in the namespace
  // - "deployments" -> number of deployments in the namespace
  // - "services" -> number of services in the namespace
  // - "running_pods" -> number of pods with status "Running"
  // - "total_containers" -> total number of containers across all pods
  def namespaceSummary(
    namespace: String,
    pods: List[PodSpec],
    deployments: List[Deployment],
    services: List[K8sService]
  ): Map[String, Int] = ???

  def main(args: Array[String]): Unit = {
    val pods = List(
      PodSpec("web-0", "default", List(Label("app", "web"), Label("env", "prod")), List(Container("nginx", "nginx:1.21", List(80))), "Running"),
      PodSpec("web-1", "default", List(Label("app", "web"), Label("env", "prod")), List(Container("nginx", "nginx:1.21", List(80))), "Running"),
      PodSpec("api-0", "default", List(Label("app", "api"), Label("env", "prod")), List(Container("api", "myapi:1.0", List(8080))), "Running"),
      PodSpec("db-0", "production", List(Label("app", "db")), List(Container("postgres", "postgres:15", List(5432))), "Running"),
      PodSpec("orphan-0", "default", List(Label("app", "unknown")), List(Container("c", "img")), "Pending")
    )

    // Exercise 1: selectPods
    assert(selectPods(pods, Map("app" -> "web")).toSet == Set("web-0", "web-1"))
    assert(selectPods(pods, Map("app" -> "web", "env" -> "prod")).toSet == Set("web-0", "web-1"))
    assert(selectPods(pods, Map("app" -> "missing")).isEmpty)
    println("Exercise 1 passed: selectPods")

    // Exercise 2: groupByNamespace
    val grouped = groupByNamespace(pods)
    assert(grouped("default").sorted == List("api-0", "orphan-0", "web-0", "web-1"))
    assert(grouped("production") == List("db-0"))
    println("Exercise 2 passed: groupByNamespace")

    // Exercise 3: desiredPods
    val deploy = Deployment("web", "default", replicas = 3,
      labels = List(Label("app", "web")),
      selector = Map("app" -> "web"),
      podTemplate = PodSpec("", "default", List(Label("app", "web")), List(Container("nginx", "nginx:1.21")))
    )
    val desired = desiredPods(deploy)
    assert(desired.length == 3)
    assert(desired.map(_.name) == List("web-0", "web-1", "web-2"))
    assert(desired.head.labels == List(Label("app", "web")))
    println("Exercise 3 passed: desiredPods")

    // Exercise 4: serviceEndpoints
    val svc = K8sService("web-svc", "default", ClusterIP, Map("app" -> "web"), 80, 80)
    assert(serviceEndpoints(svc, pods).toSet == Set("web-0", "web-1"))
    println("Exercise 4 passed: serviceEndpoints")

    // Exercise 5: validateDeployment
    assert(validateDeployment(deploy).isEmpty)
    val badDeploy = Deployment("", "default", -1, Nil, Map.empty,
      PodSpec("", "default", Nil, List(Container("c", "")))
    )
    val errs = validateDeployment(badDeploy)
    assert(errs.contains("Deployment name is required"))
    assert(errs.contains("Replicas must be non-negative"))
    assert(errs.contains("Selector is required"))
    assert(errs.contains("Container 'c' has no image"))
    println("Exercise 5 passed: validateDeployment")

    // Exercise 6: rolloutStatus
    val status = rolloutStatus(deploy, pods)
    assert(status == (2, 3, 1)) // 2 running web pods, 3 desired, 1 unavailable
    println("Exercise 6 passed: rolloutStatus")

    // Exercise 7: findOrphanedPods
    val deployments = List(
      Deployment("web", selector = Map("app" -> "web"), podTemplate = PodSpec("", containers = List(Container("c", "img")))),
      Deployment("api", selector = Map("app" -> "api"), podTemplate = PodSpec("", containers = List(Container("c", "img"))))
    )
    assert(findOrphanedPods(pods, deployments).toSet == Set("db-0", "orphan-0"))
    println("Exercise 7 passed: findOrphanedPods")

    // Exercise 8: namespaceSummary
    val svcs = List(svc, K8sService("api-svc", "default", ClusterIP, Map("app" -> "api"), 8080, 8080))
    val summary = namespaceSummary("default", pods, deployments, svcs)
    assert(summary("pods") == 4)          // web-0, web-1, api-0, orphan-0
    assert(summary("deployments") == 2)
    assert(summary("services") == 2)
    assert(summary("running_pods") == 3)  // web-0, web-1, api-0
    assert(summary("total_containers") == 4)
    println("Exercise 8 passed: namespaceSummary")

    println("All DK004_K8sBasics exercises passed!")
  }
}
