package org.shev4ik.interview.docker_k8s.level1_basics

/**
 * Docker/K8s 002 - Docker Container Configuration
 *
 * =Overview=
 * Docker containers package an application with its dependencies into a standardized unit
 * for deployment. Configuration involves defining the image build process (Dockerfile),
 * runtime settings (environment variables, ports, volumes), resource limits, health checks,
 * and networking. Understanding these concepts is essential for deploying Scala applications
 * in production.
 *
 * =Dockerfile Layers and Image Building=
 * Each Dockerfile instruction (FROM, RUN, COPY, ADD) creates a '''layer''' in the image.
 * Layers are cached -- if a layer hasn't changed, Docker reuses the cached version:
 * {{{
 *   FROM eclipse-temurin:17-jre-alpine    # Base layer (cached unless base image changes)
 *   WORKDIR /app                          # Metadata layer
 *   COPY target/assembly.jar app.jar      # Changes when JAR changes
 *   EXPOSE 8080                           # Metadata only
 *   ENTRYPOINT ["java", "-jar", "app.jar"]
 * }}}
 * '''Best practice:''' Put frequently changing layers (COPY app code) last to maximize
 * cache hits on earlier layers.
 *
 * =Multi-Stage Builds (Critical for Scala/JVM)=
 * Multi-stage builds use multiple FROM instructions to separate build from runtime:
 * {{{
 *   # Stage 1: Build (large image with sbt, JDK, source code)
 *   FROM eclipse-temurin:17-jdk AS builder
 *   WORKDIR /build
 *   COPY project/ project/
 *   COPY build.sbt .
 *   RUN sbt update                    # Cache dependencies layer
 *   COPY src/ src/
 *   RUN sbt assembly                  # Build fat JAR
 *
 *   # Stage 2: Runtime (small image with only JRE + JAR)
 *   FROM eclipse-temurin:17-jre-alpine
 *   COPY --from=builder /build/target/scala-2.13/app-assembly.jar /app/app.jar
 *   ENTRYPOINT ["java", "-jar", "/app/app.jar"]
 * }}}
 * This produces a final image of ~200MB instead of ~1GB (no sbt, JDK, source code, or
 * build caches in the runtime image).
 *
 * =Environment Variables=
 * Environment variables configure application behavior without rebuilding the image:
 *  - Database URLs, API keys, feature flags, log levels
 *  - Set via `docker run -e KEY=VALUE` or Docker Compose `environment:` section
 *  - In Kubernetes: `ConfigMap` (non-sensitive) and `Secret` (sensitive)
 *  - '''Never bake secrets into images''' -- use runtime injection
 *
 * =Resource Limits=
 *  - '''Memory''': `--memory=512m` limits container RAM. JVM needs `-XX:MaxRAMPercentage=75`
 *    to respect container limits (otherwise JVM may see host memory and OOM)
 *  - '''CPU''': `--cpus=1.5` limits CPU usage. Maps to Kubernetes `resources.limits.cpu`
 *  - In Kubernetes: `requests` (scheduling guarantee) vs `limits` (hard cap)
 *
 * =Health Checks=
 *  - '''HTTP''': `HEALTHCHECK CMD curl -f http://localhost:8080/health` -- most common
 *  - '''TCP''': Check if a port is accepting connections
 *  - '''Command''': Run an arbitrary command; exit code 0 = healthy
 *  - Kubernetes uses `livenessProbe` (restart if unhealthy) and `readinessProbe`
 *    (remove from load balancer if not ready)
 *
 * =Networking=
 *  - '''Bridge''' (default): Isolated network, containers communicate via port mapping
 *  - '''Host''': Container shares host network stack (no isolation, but no NAT overhead)
 *  - '''Custom networks''': User-defined bridge networks with DNS-based service discovery
 *
 * =Interview Tip=
 * ''"How would you containerize a Scala/sbt application?"''
 *
 * '''Good answer:''' "I use a '''multi-stage Docker build'''. The first stage uses a JDK image
 * with sbt to compile and produce a fat JAR (via sbt-assembly) or native-image (via GraalVM).
 * The second stage copies just the JAR into a slim JRE image (eclipse-temurin:17-jre-alpine),
 * resulting in a ~200MB image. I separate dependency resolution (sbt update) from compilation
 * to cache dependency downloads. For configuration, I inject environment variables at runtime
 * and never bake secrets into the image. I set JVM flags like `-XX:MaxRAMPercentage=75` so
 * the JVM respects container memory limits. For sbt-native-packager users, `sbt Docker/publishLocal`
 * generates optimized Docker images automatically."
 */
object DK002_ContainerConfig {

  // ---- Domain types ----

  case class EnvVar(name: String, value: String)
  case class VolumeMount(hostPath: String, containerPath: String, readOnly: Boolean = false)
  case class PortMapping(hostPort: Int, containerPort: Int, protocol: String = "tcp")

  sealed trait HealthCheckType
  case class HttpHealthCheck(path: String, port: Int, intervalSeconds: Int = 30) extends HealthCheckType
  case class CmdHealthCheck(command: String, intervalSeconds: Int = 30) extends HealthCheckType
  case class TcpHealthCheck(port: Int, intervalSeconds: Int = 30) extends HealthCheckType

  sealed trait NetworkMode
  case object Bridge extends NetworkMode
  case object Host extends NetworkMode
  case class CustomNetwork(name: String) extends NetworkMode

  case class ContainerConfig(
    name: String,
    image: String,
    envVars: List[EnvVar] = Nil,
    volumes: List[VolumeMount] = Nil,
    ports: List[PortMapping] = Nil,
    healthCheck: Option[HealthCheckType] = None,
    networkMode: NetworkMode = Bridge,
    memoryLimitMb: Option[Int] = None,
    cpuLimit: Option[Double] = None
  )

  // ---- Exercise 1 ----
  // TODO: Resolve environment variable references within env var values.
  // A value like "${DB_HOST}:5432" should resolve DB_HOST from the same env var list.
  // Process in order; later vars can reference earlier ones.
  // If a referenced var is not found, leave the reference as-is.
  // Example: List(EnvVar("HOST","localhost"), EnvVar("URL","http://${HOST}:8080"))
  //       => List(EnvVar("HOST","localhost"), EnvVar("URL","http://localhost:8080"))
  def resolveEnvVars(envVars: List[EnvVar]): List[EnvVar] = ???

  // ---- Exercise 2 ----
  // TODO: Validate port mappings. Return a list of error strings.
  // Rules:
  // - Ports must be between 1 and 65535 (error: "Invalid port: <hostPort>:<containerPort>")
  // - No duplicate host ports (error: "Duplicate host port: <port>")
  // - Protocol must be "tcp" or "udp" (error: "Invalid protocol: <protocol>")
  // Return empty list if all valid.
  def validatePorts(ports: List[PortMapping]): List[String] = ???

  // ---- Exercise 3 ----
  // TODO: Check for volume mount conflicts.
  // Two volume mounts conflict if they have the same containerPath.
  // Return the list of conflicting container paths.
  // Example: List(VolumeMount("/data","/app/data"), VolumeMount("/logs","/app/data")) => List("/app/data")
  def findVolumeConflicts(volumes: List[VolumeMount]): List[String] = ???

  // ---- Exercise 4 ----
  // TODO: Validate the health check configuration. Return Option[String] with error, or None if valid.
  // Rules:
  // - HttpHealthCheck path must start with "/" (error: "Health check path must start with /")
  // - All health check ports must be 1-65535 (error: "Invalid health check port: <port>")
  // - Interval must be >= 5 seconds (error: "Interval too short: <interval>s")
  // - CmdHealthCheck command must not be empty (error: "Empty health check command")
  // Return the FIRST error found.
  def validateHealthCheck(hc: HealthCheckType): Option[String] = ???

  // ---- Exercise 5 ----
  // TODO: Calculate total resource allocation for a list of containers.
  // Sum up memoryLimitMb and cpuLimit across all containers.
  // Return (totalMemoryMb: Int, totalCpu: Double).
  // Containers without limits should not count (treat as 0).
  // Example: two containers with 512MB/1.0cpu and 256MB/0.5cpu => (768, 1.5)
  def totalResources(containers: List[ContainerConfig]): (Int, Double) = ???

  // ---- Exercise 6 ----
  // TODO: Generate a docker run command string from a ContainerConfig.
  // Format: "docker run --name <name> <env_flags> <port_flags> <volume_flags> <memory_flag> <cpu_flag> <network_flag> <image>"
  // Env: "-e KEY=VALUE" for each env var
  // Ports: "-p hostPort:containerPort" for each mapping
  // Volumes: "-v hostPath:containerPath" (append ":ro" if readOnly)
  // Memory: "--memory=<limit>m" if set
  // CPU: "--cpus=<limit>" if set
  // Network: "--network=<name>" for CustomNetwork, omit for Bridge, "--network=host" for Host
  // Parts with no values should be omitted entirely.
  def generateDockerRunCommand(config: ContainerConfig): String = ???

  // ---- Exercise 7 ----
  // TODO: Merge two ContainerConfig objects (base and override).
  // The override config's non-default values take precedence.
  // For lists (envVars, volumes, ports): concatenate override after base, but
  // for envVars, if both have the same name, the override wins.
  // For Options: override takes precedence if it's Some.
  // Name and image always come from override.
  def mergeConfigs(base: ContainerConfig, overrideConfig: ContainerConfig): ContainerConfig = ???

  // ---- Exercise 8 ----
  // TODO: Validate an entire ContainerConfig. Return all errors as a list of strings.
  // Checks to perform:
  // - name must not be empty (error: "Container name is required")
  // - image must not be empty (error: "Image is required")
  // - Validate ports using validatePorts
  // - Find volume conflicts (error: "Volume conflict at: <path>" for each)
  // - Validate health check if present (include error if any)
  // - memoryLimitMb if set must be > 0 (error: "Memory limit must be positive")
  // - cpuLimit if set must be > 0 (error: "CPU limit must be positive")
  def validateConfig(config: ContainerConfig): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: resolveEnvVars
    val envs = List(EnvVar("HOST", "localhost"), EnvVar("PORT", "8080"), EnvVar("URL", "http://${HOST}:${PORT}"))
    val resolved = resolveEnvVars(envs)
    assert(resolved.last.value == "http://localhost:8080")
    assert(resolveEnvVars(List(EnvVar("A", "${MISSING}"))).head.value == "${MISSING}")
    println("Exercise 1 passed: resolveEnvVars")

    // Exercise 2: validatePorts
    assert(validatePorts(List(PortMapping(8080, 80))).isEmpty)
    assert(validatePorts(List(PortMapping(0, 80))).contains("Invalid port: 0:80"))
    assert(validatePorts(List(PortMapping(8080, 80), PortMapping(8080, 443))).contains("Duplicate host port: 8080"))
    assert(validatePorts(List(PortMapping(8080, 80, "ftp"))).contains("Invalid protocol: ftp"))
    println("Exercise 2 passed: validatePorts")

    // Exercise 3: findVolumeConflicts
    val vols = List(VolumeMount("/data", "/app/data"), VolumeMount("/logs", "/app/logs"), VolumeMount("/backup", "/app/data"))
    assert(findVolumeConflicts(vols) == List("/app/data"))
    assert(findVolumeConflicts(List(VolumeMount("/a", "/x"), VolumeMount("/b", "/y"))).isEmpty)
    println("Exercise 3 passed: findVolumeConflicts")

    // Exercise 4: validateHealthCheck
    assert(validateHealthCheck(HttpHealthCheck("/health", 8080)).isEmpty)
    assert(validateHealthCheck(HttpHealthCheck("health", 8080)).contains("Health check path must start with /"))
    assert(validateHealthCheck(HttpHealthCheck("/health", 0)).contains("Invalid health check port: 0"))
    assert(validateHealthCheck(CmdHealthCheck("curl localhost", intervalSeconds = 3)).contains("Interval too short: 3s"))
    assert(validateHealthCheck(CmdHealthCheck("")).contains("Empty health check command"))
    println("Exercise 4 passed: validateHealthCheck")

    // Exercise 5: totalResources
    val containers = List(
      ContainerConfig("app1", "img1", memoryLimitMb = Some(512), cpuLimit = Some(1.0)),
      ContainerConfig("app2", "img2", memoryLimitMb = Some(256), cpuLimit = Some(0.5)),
      ContainerConfig("app3", "img3")
    )
    assert(totalResources(containers) == (768, 1.5))
    assert(totalResources(Nil) == (0, 0.0))
    println("Exercise 5 passed: totalResources")

    // Exercise 6: generateDockerRunCommand
    val cfg = ContainerConfig("myapp", "openjdk:11",
      envVars = List(EnvVar("APP_ENV", "prod")),
      ports = List(PortMapping(8080, 80)),
      volumes = List(VolumeMount("/host/data", "/app/data", readOnly = true)),
      memoryLimitMb = Some(512),
      cpuLimit = Some(1.5),
      networkMode = CustomNetwork("my-net")
    )
    val cmd = generateDockerRunCommand(cfg)
    assert(cmd.contains("--name myapp"))
    assert(cmd.contains("-e APP_ENV=prod"))
    assert(cmd.contains("-p 8080:80"))
    assert(cmd.contains("-v /host/data:/app/data:ro"))
    assert(cmd.contains("--memory=512m"))
    assert(cmd.contains("--cpus=1.5"))
    assert(cmd.contains("--network=my-net"))
    assert(cmd.endsWith("openjdk:11"))
    println("Exercise 6 passed: generateDockerRunCommand")

    // Exercise 7: mergeConfigs
    val base = ContainerConfig("base", "img:1", envVars = List(EnvVar("A", "1"), EnvVar("B", "2")), memoryLimitMb = Some(256))
    val over = ContainerConfig("override", "img:2", envVars = List(EnvVar("B", "3"), EnvVar("C", "4")), cpuLimit = Some(1.0))
    val merged = mergeConfigs(base, over)
    assert(merged.name == "override")
    assert(merged.image == "img:2")
    assert(merged.envVars.find(_.name == "B").get.value == "3")
    assert(merged.envVars.find(_.name == "A").get.value == "1")
    assert(merged.envVars.find(_.name == "C").get.value == "4")
    assert(merged.memoryLimitMb.contains(256))
    assert(merged.cpuLimit.contains(1.0))
    println("Exercise 7 passed: mergeConfigs")

    // Exercise 8: validateConfig
    assert(validateConfig(ContainerConfig("app", "img:1")).isEmpty)
    val badConfig = ContainerConfig("", "", ports = List(PortMapping(0, 80)), memoryLimitMb = Some(-1))
    val errors = validateConfig(badConfig)
    assert(errors.contains("Container name is required"))
    assert(errors.contains("Image is required"))
    assert(errors.exists(_.contains("Invalid port")))
    assert(errors.contains("Memory limit must be positive"))
    println("Exercise 8 passed: validateConfig")

    println("All DK002_ContainerConfig exercises passed!")
  }
}
