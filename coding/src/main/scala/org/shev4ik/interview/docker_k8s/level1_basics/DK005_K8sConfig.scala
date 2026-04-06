package org.shev4ik.interview.docker_k8s.level1_basics

object DK005_K8sConfig {

  // ---- Domain types ----

  case class ConfigMap(name: String, namespace: String = "default", data: Map[String, String] = Map.empty)

  case class Secret(name: String, namespace: String = "default", data: Map[String, String] = Map.empty, secretType: String = "Opaque") {
    // In K8s, secret data is base64 encoded
    def decodedData: Map[String, String] = data.map { case (k, v) =>
      k -> new String(java.util.Base64.getDecoder.decode(v))
    }
  }

  object Secret {
    def withPlainData(name: String, namespace: String, data: Map[String, String], secretType: String = "Opaque"): Secret =
      Secret(name, namespace, data.map { case (k, v) =>
        k -> java.util.Base64.getEncoder.encodeToString(v.getBytes)
      }, secretType)
  }

  case class ResourceRequirements(
    cpuRequest: Option[String] = None,   // e.g., "100m", "0.5", "1"
    cpuLimit: Option[String] = None,
    memoryRequest: Option[String] = None, // e.g., "128Mi", "1Gi"
    memoryLimit: Option[String] = None
  )

  sealed trait ProbeType
  case class HttpGetProbe(path: String, port: Int, initialDelaySeconds: Int = 0, periodSeconds: Int = 10) extends ProbeType
  case class TcpSocketProbe(port: Int, initialDelaySeconds: Int = 0, periodSeconds: Int = 10) extends ProbeType
  case class ExecProbe(command: List[String], initialDelaySeconds: Int = 0, periodSeconds: Int = 10) extends ProbeType

  case class ContainerSpec(
    name: String,
    image: String,
    resources: ResourceRequirements = ResourceRequirements(),
    livenessProbe: Option[ProbeType] = None,
    readinessProbe: Option[ProbeType] = None,
    envFrom: List[String] = Nil,       // ConfigMap/Secret names to load env from
    envVars: Map[String, String] = Map.empty
  )

  // ---- Exercise 1 ----
  // TODO: Merge multiple ConfigMaps into a single environment variable map.
  // Later ConfigMaps override earlier ones for duplicate keys.
  // Return the merged Map[String, String].
  // Example: cm1=Map("A"->"1","B"->"2"), cm2=Map("B"->"3","C"->"4") => Map("A"->"1","B"->"3","C"->"4")
  def mergeConfigMaps(configMaps: List[ConfigMap]): Map[String, String] = ???

  // ---- Exercise 2 ----
  // TODO: Parse CPU resource strings to millicores (Int).
  // Formats: "100m" => 100, "0.5" => 500, "1" => 1000, "2.5" => 2500
  // If the string ends with "m", parse as millicores directly.
  // Otherwise, parse as cores and multiply by 1000.
  // Return None for invalid input.
  def parseCpuMillicores(cpu: String): Option[Int] = ???

  // ---- Exercise 3 ----
  // TODO: Parse memory resource strings to bytes (Long).
  // Formats: "128Mi" => 128 * 1024 * 1024, "1Gi" => 1024 * 1024 * 1024,
  //          "512Ki" => 512 * 1024, "100M" => 100 * 1000 * 1000,
  //          "1G" => 1000 * 1000 * 1000, "500K" => 500 * 1000
  // Note: "Mi","Gi","Ki" are binary (powers of 1024); "M","G","K" are decimal (powers of 1000).
  // Return None for invalid input.
  def parseMemoryBytes(memory: String): Option[Long] = ???

  // ---- Exercise 4 ----
  // TODO: Validate resource requirements. Return list of error strings.
  // Rules:
  // - If both request and limit are set for CPU, request must be <= limit
  //   (error: "CPU request exceeds limit")
  // - If both request and limit are set for memory, request must be <= limit
  //   (error: "Memory request exceeds limit")
  // - All resource strings must be parseable (error: "Invalid CPU request: <value>" etc.)
  // Use parseCpuMillicores and parseMemoryBytes for parsing.
  def validateResources(resources: ResourceRequirements): List[String] = ???

  // ---- Exercise 5 ----
  // TODO: Calculate total resource requests and limits for a list of containers.
  // Return (totalCpuRequestMillis: Int, totalCpuLimitMillis: Int, totalMemoryRequestBytes: Long, totalMemoryLimitBytes: Long)
  // Containers without a value contribute 0 for that field.
  def totalResourceUsage(containers: List[ContainerSpec]): (Int, Int, Long, Long) = ???

  // ---- Exercise 6 ----
  // TODO: Validate probe configuration. Return list of error strings.
  // Rules:
  // - HttpGetProbe path must start with "/" (error: "Probe path must start with /")
  // - Port must be 1-65535 (error: "Invalid probe port: <port>")
  // - initialDelaySeconds must be >= 0 (error: "Invalid initial delay: <value>")
  // - periodSeconds must be >= 1 (error: "Invalid period: <value>")
  // - ExecProbe command must not be empty (error: "Probe command is empty")
  def validateProbe(probe: ProbeType): List[String] = ???

  // ---- Exercise 7 ----
  // TODO: Resolve all environment variables for a container.
  // 1) Start with envFrom: load all ConfigMaps and Secrets (by name) in order.
  //    If a name matches a ConfigMap, load its data; if it matches a Secret, load its decodedData.
  // 2) Then overlay envVars from the container spec (these override envFrom values).
  // Return the final Map[String, String].
  def resolveContainerEnv(
    container: ContainerSpec,
    configMaps: List[ConfigMap],
    secrets: List[Secret]
  ): Map[String, String] = ???

  // ---- Exercise 8 ----
  // TODO: Check if a container has proper production-readiness configuration.
  // A container is production-ready if ALL of these are true:
  // - Has both livenessProbe and readinessProbe set
  // - Has both CPU and memory requests set
  // - Has both CPU and memory limits set
  // - Resource requirements are valid (validateResources returns empty)
  // Return a list of missing requirements (empty if production-ready).
  // Example errors: "Missing liveness probe", "Missing readiness probe",
  //   "Missing CPU request", "Missing memory request", "Missing CPU limit", "Missing memory limit"
  def checkProductionReadiness(container: ContainerSpec): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: mergeConfigMaps
    val cm1 = ConfigMap("cm1", data = Map("DB_HOST" -> "localhost", "DB_PORT" -> "5432"))
    val cm2 = ConfigMap("cm2", data = Map("DB_PORT" -> "5433", "DB_NAME" -> "mydb"))
    val merged = mergeConfigMaps(List(cm1, cm2))
    assert(merged == Map("DB_HOST" -> "localhost", "DB_PORT" -> "5433", "DB_NAME" -> "mydb"))
    assert(mergeConfigMaps(Nil) == Map.empty)
    println("Exercise 1 passed: mergeConfigMaps")

    // Exercise 2: parseCpuMillicores
    assert(parseCpuMillicores("100m").contains(100))
    assert(parseCpuMillicores("0.5").contains(500))
    assert(parseCpuMillicores("1").contains(1000))
    assert(parseCpuMillicores("2.5").contains(2500))
    assert(parseCpuMillicores("abc").isEmpty)
    println("Exercise 2 passed: parseCpuMillicores")

    // Exercise 3: parseMemoryBytes
    assert(parseMemoryBytes("128Mi").contains(128L * 1024 * 1024))
    assert(parseMemoryBytes("1Gi").contains(1024L * 1024 * 1024))
    assert(parseMemoryBytes("512Ki").contains(512L * 1024))
    assert(parseMemoryBytes("100M").contains(100L * 1000 * 1000))
    assert(parseMemoryBytes("1G").contains(1000L * 1000 * 1000))
    assert(parseMemoryBytes("xyz").isEmpty)
    println("Exercise 3 passed: parseMemoryBytes")

    // Exercise 4: validateResources
    assert(validateResources(ResourceRequirements(Some("100m"), Some("200m"), Some("128Mi"), Some("256Mi"))).isEmpty)
    assert(validateResources(ResourceRequirements(Some("500m"), Some("200m"))).contains("CPU request exceeds limit"))
    assert(validateResources(ResourceRequirements(memoryRequest = Some("1Gi"), memoryLimit = Some("512Mi"))).contains("Memory request exceeds limit"))
    assert(validateResources(ResourceRequirements(cpuRequest = Some("bad"))).exists(_.contains("Invalid CPU request")))
    println("Exercise 4 passed: validateResources")

    // Exercise 5: totalResourceUsage
    val containers = List(
      ContainerSpec("app", "img", ResourceRequirements(Some("100m"), Some("500m"), Some("128Mi"), Some("256Mi"))),
      ContainerSpec("sidecar", "img", ResourceRequirements(Some("50m"), Some("100m"), Some("64Mi"), Some("128Mi")))
    )
    val (cpuReq, cpuLim, memReq, memLim) = totalResourceUsage(containers)
    assert(cpuReq == 150)
    assert(cpuLim == 600)
    assert(memReq == 192L * 1024 * 1024)
    assert(memLim == 384L * 1024 * 1024)
    println("Exercise 5 passed: totalResourceUsage")

    // Exercise 6: validateProbe
    assert(validateProbe(HttpGetProbe("/health", 8080, 10, 5)).isEmpty)
    assert(validateProbe(HttpGetProbe("health", 8080)).exists(_.contains("Probe path must start with /")))
    assert(validateProbe(TcpSocketProbe(0)).exists(_.contains("Invalid probe port")))
    assert(validateProbe(ExecProbe(Nil)).exists(_.contains("Probe command is empty")))
    assert(validateProbe(HttpGetProbe("/health", 8080, -1, 5)).exists(_.contains("Invalid initial delay")))
    println("Exercise 6 passed: validateProbe")

    // Exercise 7: resolveContainerEnv
    val appCm = ConfigMap("app-config", data = Map("APP_ENV" -> "production", "LOG_LEVEL" -> "info"))
    val dbSecret = Secret.withPlainData("db-creds", "default", Map("DB_PASS" -> "secret123"))
    val container = ContainerSpec("app", "img",
      envFrom = List("app-config", "db-creds"),
      envVars = Map("LOG_LEVEL" -> "debug", "EXTRA" -> "val")
    )
    val env = resolveContainerEnv(container, List(appCm), List(dbSecret))
    assert(env("APP_ENV") == "production")
    assert(env("LOG_LEVEL") == "debug")  // overridden by envVars
    assert(env("DB_PASS") == "secret123")
    assert(env("EXTRA") == "val")
    println("Exercise 7 passed: resolveContainerEnv")

    // Exercise 8: checkProductionReadiness
    val prodReady = ContainerSpec("app", "img",
      resources = ResourceRequirements(Some("100m"), Some("500m"), Some("128Mi"), Some("256Mi")),
      livenessProbe = Some(HttpGetProbe("/health", 8080)),
      readinessProbe = Some(HttpGetProbe("/ready", 8080))
    )
    assert(checkProductionReadiness(prodReady).isEmpty)

    val notReady = ContainerSpec("app", "img")
    val issues = checkProductionReadiness(notReady)
    assert(issues.contains("Missing liveness probe"))
    assert(issues.contains("Missing readiness probe"))
    assert(issues.contains("Missing CPU request"))
    assert(issues.contains("Missing memory limit"))
    println("Exercise 8 passed: checkProductionReadiness")

    println("All DK005_K8sConfig exercises passed!")
  }
}
