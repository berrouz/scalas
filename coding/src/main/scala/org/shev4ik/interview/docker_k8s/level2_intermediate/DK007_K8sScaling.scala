package org.shev4ik.interview.docker_k8s.level2_intermediate

object DK007_K8sScaling {

  // ---- Domain types ----

  case class PodMetrics(name: String, cpuUsageMillicores: Int, memoryUsageMb: Int)

  case class HPASpec(
    name: String,
    targetDeployment: String,
    minReplicas: Int = 1,
    maxReplicas: Int = 10,
    targetCpuUtilizationPercent: Int = 80,   // target average CPU utilization
    targetMemoryUtilizationPercent: Option[Int] = None
  )

  case class VPARecommendation(
    containerName: String,
    lowerBoundCpuMillis: Int,
    upperBoundCpuMillis: Int,
    targetCpuMillis: Int,
    lowerBoundMemoryMb: Int,
    upperBoundMemoryMb: Int,
    targetMemoryMb: Int
  )

  case class NodeInfo(
    name: String,
    totalCpuMillis: Int,
    totalMemoryMb: Int,
    allocatableCpuMillis: Int,
    allocatableMemoryMb: Int,
    usedCpuMillis: Int = 0,
    usedMemoryMb: Int = 0
  )

  sealed trait ScalingDecision
  case class ScaleUp(currentReplicas: Int, desiredReplicas: Int, reason: String) extends ScalingDecision
  case class ScaleDown(currentReplicas: Int, desiredReplicas: Int, reason: String) extends ScalingDecision
  case class NoChange(currentReplicas: Int, reason: String) extends ScalingDecision

  // ---- Exercise 1 ----
  // TODO: Calculate the desired replica count based on HPA CPU metric.
  // Formula: desiredReplicas = ceil(currentReplicas * (currentCpuUtilization / targetCpuUtilization))
  // currentCpuUtilization = average CPU usage across pods / cpuRequestMillis * 100
  // Clamp result between minReplicas and maxReplicas.
  // Return the desired replica count.
  def calculateHPAReplicas(
    hpa: HPASpec,
    currentReplicas: Int,
    podMetrics: List[PodMetrics],
    cpuRequestMillis: Int
  ): Int = ???

  // ---- Exercise 2 ----
  // TODO: Make a scaling decision based on HPA evaluation.
  // Use calculateHPAReplicas to determine the desired count.
  // Return the appropriate ScalingDecision:
  // - ScaleUp if desired > current (reason: "CPU utilization at X%, target Y%")
  // - ScaleDown if desired < current (reason: "CPU utilization at X%, target Y%")
  // - NoChange if desired == current (reason: "Within target range")
  // X is the actual average CPU utilization percentage (rounded to Int).
  def makeScalingDecision(
    hpa: HPASpec,
    currentReplicas: Int,
    podMetrics: List[PodMetrics],
    cpuRequestMillis: Int
  ): ScalingDecision = ???

  // ---- Exercise 3 ----
  // TODO: Simulate HPA behavior over multiple time steps.
  // Given a list of (podMetrics at each time step), simulate the HPA scaling decisions.
  // Start with initialReplicas, apply each step's decision.
  // HPA has a cooldown: no scale-down within `scaleDownCooldownSteps` steps after last scale-up.
  // Return the list of replica counts at each step (including initial).
  def simulateHPA(
    hpa: HPASpec,
    initialReplicas: Int,
    metricsTimeSeries: List[List[PodMetrics]],
    cpuRequestMillis: Int,
    scaleDownCooldownSteps: Int = 2
  ): List[Int] = ???

  // ---- Exercise 4 ----
  // TODO: Generate VPA recommendations based on historical pod metrics.
  // Given a list of PodMetrics samples over time (for a single container):
  // - targetCpuMillis = p50 (median) of CPU usage
  // - lowerBoundCpuMillis = p10 of CPU usage (index = size * 10 / 100)
  // - upperBoundCpuMillis = p95 of CPU usage (index = size * 95 / 100)
  // Same for memory. If metrics is empty, all values are 0.
  // Sort the values to compute percentiles (use index-based approach).
  def generateVPARecommendation(containerName: String, historicalMetrics: List[PodMetrics]): VPARecommendation = ???

  // ---- Exercise 5 ----
  // TODO: Determine if a node can accommodate additional pods.
  // Given a node and the resource requirements per pod (cpuMillis, memoryMb),
  // calculate how many more pods can fit on this node.
  // Available = allocatable - used. Each pod needs cpuMillis AND memoryMb.
  // Return the number of additional pods that fit.
  def nodeCapacity(node: NodeInfo, podCpuMillis: Int, podMemoryMb: Int): Int = ???

  // ---- Exercise 6 ----
  // TODO: Simulate cluster autoscaler decision.
  // Given a list of nodes, pending pods (needing scheduling), and pod resource requirements,
  // determine how many additional nodes are needed.
  // Each new node has the same specs as `nodeTemplate`.
  // First try to fit pending pods on existing nodes (use nodeCapacity for each).
  // Remaining pods need new nodes. Return the number of new nodes needed.
  def clusterAutoscalerDecision(
    existingNodes: List[NodeInfo],
    pendingPodCount: Int,
    podCpuMillis: Int,
    podMemoryMb: Int,
    nodeTemplate: NodeInfo
  ): Int = ???

  // ---- Exercise 7 ----
  // TODO: Calculate optimal resource requests based on VPA recommendations.
  // Given a VPA recommendation, apply a safety margin:
  // - CPU: target * (1 + safetyMarginPercent/100), clamped to [lowerBound, upperBound]
  // - Memory: target * (1 + safetyMarginPercent/100), clamped to [lowerBound, upperBound]
  // Return (recommendedCpuMillis: Int, recommendedMemoryMb: Int)
  def applyVPASafetyMargin(recommendation: VPARecommendation, safetyMarginPercent: Int = 15): (Int, Int) = ???

  // ---- Exercise 8 ----
  // TODO: Evaluate scaling efficiency.
  // Given the total CPU/memory allocated (across all replicas) and total used,
  // calculate efficiency as (used / allocated).
  // Return (cpuEfficiency: Double, memoryEfficiency: Double) as percentages (0-100).
  // If allocated is 0, efficiency is 0.0.
  // An efficient system should be 60-80%. Flag over/under provisioning:
  // Return (cpuEfficiency, memoryEfficiency, cpuStatus: String, memStatus: String)
  // where status is "under-provisioned" if >90%, "over-provisioned" if <40%, "optimal" otherwise.
  def scalingEfficiency(
    totalCpuAllocatedMillis: Int,
    totalCpuUsedMillis: Int,
    totalMemoryAllocatedMb: Int,
    totalMemoryUsedMb: Int
  ): (Double, Double, String, String) = ???

  def main(args: Array[String]): Unit = {
    val hpa = HPASpec("web-hpa", "web", minReplicas = 2, maxReplicas = 10, targetCpuUtilizationPercent = 50)

    // Exercise 1: calculateHPAReplicas
    val metrics = List(PodMetrics("web-0", 400, 256), PodMetrics("web-1", 600, 256))
    // avg CPU = 500, request = 1000, utilization = 50%, target = 50% => ratio = 1.0 => 2 replicas
    assert(calculateHPAReplicas(hpa, 2, metrics, 1000) == 2)
    val highMetrics = List(PodMetrics("web-0", 900, 256), PodMetrics("web-1", 900, 256))
    // avg CPU = 900, request = 1000, utilization = 90%, target = 50% => ratio = 1.8 => ceil(2*1.8) = 4
    assert(calculateHPAReplicas(hpa, 2, highMetrics, 1000) == 4)
    println("Exercise 1 passed: calculateHPAReplicas")

    // Exercise 2: makeScalingDecision
    val decision = makeScalingDecision(hpa, 2, highMetrics, 1000)
    assert(decision.isInstanceOf[ScaleUp])
    assert(decision.asInstanceOf[ScaleUp].desiredReplicas == 4)
    val stableDecision = makeScalingDecision(hpa, 2, metrics, 1000)
    assert(stableDecision.isInstanceOf[NoChange])
    println("Exercise 2 passed: makeScalingDecision")

    // Exercise 3: simulateHPA
    val timeSeries = List(
      List(PodMetrics("p0", 900, 256), PodMetrics("p1", 900, 256)),   // high load -> scale up
      List(PodMetrics("p0", 200, 256), PodMetrics("p1", 200, 256), PodMetrics("p2", 200, 256), PodMetrics("p3", 200, 256)),   // low load, but cooldown
      List(PodMetrics("p0", 200, 256), PodMetrics("p1", 200, 256), PodMetrics("p2", 200, 256), PodMetrics("p3", 200, 256)),   // low load, but cooldown
      List(PodMetrics("p0", 200, 256), PodMetrics("p1", 200, 256), PodMetrics("p2", 200, 256), PodMetrics("p3", 200, 256))    // low load, can scale down
    )
    val history = simulateHPA(hpa, 2, timeSeries, 1000, scaleDownCooldownSteps = 2)
    assert(history.head == 2)  // initial
    assert(history(1) == 4)    // scaled up
    assert(history(2) == 4)    // cooldown, no scale down
    assert(history(3) == 4)    // cooldown, no scale down
    assert(history(4) == 2)    // cooldown expired, scale down
    println("Exercise 3 passed: simulateHPA")

    // Exercise 4: generateVPARecommendation
    val vpaSamples = (1 to 100).map(i => PodMetrics(s"pod-$i", i * 10, i * 2)).toList
    val vpaRec = generateVPARecommendation("app", vpaSamples)
    assert(vpaRec.targetCpuMillis == 500)     // p50: index 50 => 500
    assert(vpaRec.lowerBoundCpuMillis == 100)  // p10: index 10 => 100
    assert(vpaRec.upperBoundCpuMillis == 950)  // p95: index 95 => 950
    println("Exercise 4 passed: generateVPARecommendation")

    // Exercise 5: nodeCapacity
    val node = NodeInfo("node-1", 4000, 8192, 3800, 7680, 2000, 4096)
    // available: 1800 cpu, 3584 mem. Pod needs 500 cpu, 1024 mem.
    // cpu: 1800/500=3, mem: 3584/1024=3 => min(3,3) = 3
    assert(nodeCapacity(node, 500, 1024) == 3)
    println("Exercise 5 passed: nodeCapacity")

    // Exercise 6: clusterAutoscalerDecision
    val nodes = List(
      NodeInfo("n1", 4000, 8192, 3800, 7680, 3500, 7000), // little room
      NodeInfo("n2", 4000, 8192, 3800, 7680, 1000, 2048)  // some room
    )
    val nodeTemplate = NodeInfo("new", 4000, 8192, 3800, 7680)
    // n1 capacity: min((3800-3500)/500, (7680-7000)/1024) = min(0,0) = 0
    // n2 capacity: min((3800-1000)/500, (7680-2048)/1024) = min(5,5) = 5
    // need 8 pods, existing can fit 5, remaining 3, new node fits min(3800/500, 7680/1024)=7 => 1 new node
    assert(clusterAutoscalerDecision(nodes, 8, 500, 1024, nodeTemplate) == 1)
    println("Exercise 6 passed: clusterAutoscalerDecision")

    // Exercise 7: applyVPASafetyMargin
    val rec = VPARecommendation("app", 100, 1000, 500, 64, 512, 256)
    val (cpu, mem) = applyVPASafetyMargin(rec, 15)
    assert(cpu == 575)  // 500 * 1.15 = 575, within [100, 1000]
    assert(mem == 294)  // 256 * 1.15 = 294.4 => 294, within [64, 512]
    println("Exercise 7 passed: applyVPASafetyMargin")

    // Exercise 8: scalingEfficiency
    val (cpuEff, memEff, cpuSt, memSt) = scalingEfficiency(4000, 2800, 8192, 2000)
    assert(math.abs(cpuEff - 70.0) < 0.1) // 2800/4000 = 70%
    assert(math.abs(memEff - 24.41) < 0.1) // 2000/8192 ~= 24.41%
    assert(cpuSt == "optimal")
    assert(memSt == "over-provisioned")
    println("Exercise 8 passed: scalingEfficiency")

    println("All DK007_K8sScaling exercises passed!")
  }
}
