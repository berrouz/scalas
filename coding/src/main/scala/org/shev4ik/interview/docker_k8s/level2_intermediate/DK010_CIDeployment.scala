package org.shev4ik.interview.docker_k8s.level2_intermediate

object DK010_CIDeployment {

  // ---- Domain types ----

  sealed trait PipelineStageStatus
  case object Pending extends PipelineStageStatus
  case object Running extends PipelineStageStatus
  case object Passed extends PipelineStageStatus
  case object Failed extends PipelineStageStatus
  case object Skipped extends PipelineStageStatus

  case class PipelineStage(
    name: String,
    status: PipelineStageStatus = Pending,
    durationSeconds: Int = 0,
    dependsOn: List[String] = Nil
  )

  case class Pipeline(
    name: String,
    stages: List[PipelineStage],
    triggerBranch: String = "main"
  )

  sealed trait DeploymentStrategy
  case class RollingUpdate(maxSurge: Int, maxUnavailable: Int) extends DeploymentStrategy
  case class BlueGreen(activeColor: String) extends DeploymentStrategy  // "blue" or "green"
  case class Canary(canaryPercent: Int, steps: List[Int] = Nil) extends DeploymentStrategy  // steps: percentage progression

  case class DeploymentVersion(
    version: String,
    replicas: Int,
    healthy: Boolean = true
  )

  case class DeploymentState(
    name: String,
    strategy: DeploymentStrategy,
    currentVersion: DeploymentVersion,
    newVersion: Option[DeploymentVersion] = None,
    trafficSplit: Map[String, Int] = Map.empty // version -> percentage
  )

  case class HelmValue(key: String, value: String)
  case class HelmChart(
    name: String,
    version: String,
    appVersion: String,
    values: List[HelmValue] = Nil,
    dependencies: List[String] = Nil
  )

  // ---- Exercise 1 ----
  // TODO: Determine pipeline stage execution order.
  // Stages run in parallel when possible (no dependency between them).
  // Return List[List[String]] where each inner list is a batch of stages that can run in parallel.
  // Stages with no dependencies run first. A stage runs after all its dependsOn stages complete.
  // If circular dependencies exist, return empty list.
  def pipelineExecutionOrder(pipeline: Pipeline): List[List[String]] = ???

  // ---- Exercise 2 ----
  // TODO: Calculate total pipeline duration assuming parallel execution within batches.
  // Within each batch, stages run in parallel, so the batch duration = max(stage durations in batch).
  // Total duration = sum of all batch durations.
  // Use pipelineExecutionOrder to determine batches.
  // Return total duration in seconds.
  def pipelineDuration(pipeline: Pipeline): Int = ???

  // ---- Exercise 3 ----
  // TODO: Simulate rolling update deployment.
  // Given totalReplicas, maxSurge, and maxUnavailable:
  // At each step, you can have at most (totalReplicas + maxSurge) pods total,
  // and at least (totalReplicas - maxUnavailable) pods available.
  // Return a list of steps, where each step is (oldReplicas, newReplicas).
  // Start: (totalReplicas, 0). End: (0, totalReplicas).
  // At each step: scale up new by min(maxSurge, remaining), then scale down old by same amount.
  def simulateRollingUpdate(totalReplicas: Int, maxSurge: Int, maxUnavailable: Int): List[(Int, Int)] = ???

  // ---- Exercise 4 ----
  // TODO: Simulate blue-green deployment.
  // Return a list of deployment states as the deployment progresses:
  // Step 1: Deploy new version alongside old (both running, old gets 100% traffic)
  // Step 2: Run health checks on new version (if healthy, proceed; if not, return with rollback state)
  // Step 3: Switch traffic to new version (new gets 100%)
  // Step 4: Scale down old version
  // Return List[DeploymentState] showing each step.
  // `newHealthy` parameter simulates whether health check passes.
  def simulateBlueGreen(
    deployName: String,
    currentVersion: String,
    newVersion: String,
    replicas: Int,
    newHealthy: Boolean = true
  ): List[DeploymentState] = ???

  // ---- Exercise 5 ----
  // TODO: Simulate canary deployment with progressive traffic shifting.
  // Given canary steps (e.g., List(10, 25, 50, 100)) representing traffic percentages:
  // At each step, set the traffic split between old and new version.
  // If at any step the canary is unhealthy (determined by healthAtStep function), rollback.
  // Return the list of traffic splits at each step: List[Map[String, Int]]
  // where keys are version strings and values are traffic percentages.
  def simulateCanaryDeployment(
    currentVersion: String,
    newVersion: String,
    steps: List[Int],
    healthAtStep: Int => Boolean // step index => healthy?
  ): List[Map[String, Int]] = ???

  // ---- Exercise 6 ----
  // TODO: Validate Helm chart configuration. Return list of error strings.
  // Rules:
  // - name must not be empty (error: "Chart name is required")
  // - version must follow semver format X.Y.Z (error: "Invalid chart version: <version>")
  // - appVersion must not be empty (error: "App version is required")
  // - No duplicate value keys (error: "Duplicate Helm value key: <key>")
  // - Dependency names must not be empty (error: "Empty dependency name")
  def validateHelmChart(chart: HelmChart): List[String] = ???

  // ---- Exercise 7 ----
  // TODO: Merge Helm values with overrides.
  // Given base values and override values, produce the final list.
  // Override values replace base values with the same key.
  // New keys from overrides are appended.
  // Return the merged list sorted by key.
  def mergeHelmValues(base: List[HelmValue], overrides: List[HelmValue]): List[HelmValue] = ???

  // ---- Exercise 8 ----
  // TODO: Generate a deployment summary report.
  // Given a deployment state, return a Map[String, String] with:
  // - "name" -> deployment name
  // - "strategy" -> "RollingUpdate", "BlueGreen", or "Canary"
  // - "current_version" -> current version string
  // - "new_version" -> new version string or "none"
  // - "current_replicas" -> current version replicas as string
  // - "new_replicas" -> new version replicas as string or "0"
  // - "traffic_split" -> "v1:80%,v2:20%" format, sorted by version
  // - "status" -> "stable" if no new version, "in_progress" if new version exists and healthy,
  //               "degraded" if new version exists but unhealthy
  def deploymentReport(state: DeploymentState): Map[String, String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: pipelineExecutionOrder
    val pipeline = Pipeline("ci", List(
      PipelineStage("checkout", Passed, 5),
      PipelineStage("compile", Passed, 60, List("checkout")),
      PipelineStage("test", Passed, 120, List("compile")),
      PipelineStage("lint", Passed, 30, List("checkout")),
      PipelineStage("build-image", Passed, 45, List("test", "lint")),
      PipelineStage("deploy", Pending, 30, List("build-image"))
    ))
    val order = pipelineExecutionOrder(pipeline)
    assert(order.head == List("checkout"))
    assert(order(1).toSet == Set("compile", "lint"))
    assert(order(2) == List("test"))
    assert(order(3) == List("build-image"))
    assert(order(4) == List("deploy"))
    println("Exercise 1 passed: pipelineExecutionOrder")

    // Exercise 2: pipelineDuration
    // checkout(5) -> compile(60) | lint(30) -> test(120) -> build-image(45) -> deploy(30)
    // batches: [5] + [max(60,30)=60] + [120] + [45] + [30] = 260
    assert(pipelineDuration(pipeline) == 260)
    println("Exercise 2 passed: pipelineDuration")

    // Exercise 3: simulateRollingUpdate
    val steps = simulateRollingUpdate(4, 1, 1)
    assert(steps.head == (4, 0))
    assert(steps.last == (0, 4))
    // Total pods at any step should be <= 5 (4+1), available >= 3 (4-1)
    steps.foreach { case (old, nw) => assert(old + nw <= 5 && old + nw >= 3) }
    println("Exercise 3 passed: simulateRollingUpdate")

    // Exercise 4: simulateBlueGreen
    val bgSteps = simulateBlueGreen("web", "v1", "v2", 3, newHealthy = true)
    assert(bgSteps.length == 4)
    assert(bgSteps.head.trafficSplit("v1") == 100)
    assert(bgSteps.last.trafficSplit("v2") == 100)
    assert(bgSteps.last.currentVersion.version == "v2")

    val bgFail = simulateBlueGreen("web", "v1", "v2", 3, newHealthy = false)
    assert(bgFail.last.trafficSplit("v1") == 100) // rolled back
    println("Exercise 4 passed: simulateBlueGreen")

    // Exercise 5: simulateCanaryDeployment
    val canarySteps = simulateCanaryDeployment("v1", "v2", List(10, 25, 50, 100), _ => true)
    assert(canarySteps.length == 4)
    assert(canarySteps.head == Map("v1" -> 90, "v2" -> 10))
    assert(canarySteps.last == Map("v1" -> 0, "v2" -> 100))

    val canaryFail = simulateCanaryDeployment("v1", "v2", List(10, 25, 50, 100), step => step < 2)
    assert(canaryFail.length == 3) // stops at step 2 (index 2)
    assert(canaryFail.last == Map("v1" -> 100, "v2" -> 0)) // rollback
    println("Exercise 5 passed: simulateCanaryDeployment")

    // Exercise 6: validateHelmChart
    assert(validateHelmChart(HelmChart("myapp", "1.2.3", "1.0.0")).isEmpty)
    val badChart = HelmChart("", "abc", "", values = List(HelmValue("k", "v"), HelmValue("k", "v2")),
      dependencies = List("dep1", ""))
    val chartErrors = validateHelmChart(badChart)
    assert(chartErrors.contains("Chart name is required"))
    assert(chartErrors.exists(_.contains("Invalid chart version")))
    assert(chartErrors.contains("App version is required"))
    assert(chartErrors.contains("Duplicate Helm value key: k"))
    assert(chartErrors.contains("Empty dependency name"))
    println("Exercise 6 passed: validateHelmChart")

    // Exercise 7: mergeHelmValues
    val baseVals = List(HelmValue("replicas", "3"), HelmValue("image.tag", "v1"), HelmValue("port", "8080"))
    val overrides = List(HelmValue("image.tag", "v2"), HelmValue("env", "production"))
    val merged = mergeHelmValues(baseVals, overrides)
    assert(merged == List(HelmValue("env", "production"), HelmValue("image.tag", "v2"), HelmValue("port", "8080"), HelmValue("replicas", "3")))
    println("Exercise 7 passed: mergeHelmValues")

    // Exercise 8: deploymentReport
    val state = DeploymentState("web", Canary(25),
      DeploymentVersion("v1", 3),
      Some(DeploymentVersion("v2", 1, healthy = true)),
      Map("v1" -> 75, "v2" -> 25)
    )
    val report = deploymentReport(state)
    assert(report("name") == "web")
    assert(report("strategy") == "Canary")
    assert(report("current_version") == "v1")
    assert(report("new_version") == "v2")
    assert(report("status") == "in_progress")
    assert(report("traffic_split") == "v1:75%,v2:25%")

    val stableState = DeploymentState("api", RollingUpdate(1, 1), DeploymentVersion("v3", 5))
    assert(deploymentReport(stableState)("status") == "stable")
    println("Exercise 8 passed: deploymentReport")

    println("All DK010_CIDeployment exercises passed!")
  }
}
