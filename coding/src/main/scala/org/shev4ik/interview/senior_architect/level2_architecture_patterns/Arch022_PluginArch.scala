package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Plugin Architecture
 *
 * Senior/Architect focus:
 * - Plugin interface design and lifecycle management
 * - Plugin registry, dependency resolution, and isolation
 */
object Arch022_PluginArch {

  // ============================================================
  // Exercise 1: Plugin Interface
  // ============================================================
  case class PluginInfo(id: String, name: String, version: String, author: String, description: String, dependencies: List[String])

  sealed trait PluginState
  case object Unloaded extends PluginState
  case object Loaded extends PluginState
  case object Started extends PluginState
  case object Stopped extends PluginState
  case object Failed extends PluginState

  trait Plugin {
    def info: PluginInfo
    def state: PluginState
    def onLoad(): Either[String, Unit]
    def onStart(): Either[String, Unit]
    def onStop(): Either[String, Unit]
    def onUnload(): Either[String, Unit]
  }

  // TODO: Implement a sample plugin
  class LoggingPlugin extends Plugin {
    val info: PluginInfo = ???
    var state: PluginState = Unloaded
    def onLoad(): Either[String, Unit] = ???
    def onStart(): Either[String, Unit] = ???
    def onStop(): Either[String, Unit] = ???
    def onUnload(): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 2: Plugin Registry
  // ============================================================
  trait PluginRegistry {
    def register(plugin: Plugin): Either[String, Unit]
    def unregister(pluginId: String): Either[String, Unit]
    def getPlugin(pluginId: String): Option[Plugin]
    def listPlugins(): List[Plugin]
    def listByState(state: PluginState): List[Plugin]
  }

  // TODO: Implement plugin registry
  class InMemoryPluginRegistry extends PluginRegistry {
    private val plugins = scala.collection.mutable.Map.empty[String, Plugin]
    def register(plugin: Plugin): Either[String, Unit] = ???
    def unregister(pluginId: String): Either[String, Unit] = ???
    def getPlugin(pluginId: String): Option[Plugin] = ???
    def listPlugins(): List[Plugin] = ???
    def listByState(state: PluginState): List[Plugin] = ???
  }

  // ============================================================
  // Exercise 3: Plugin Lifecycle
  // ============================================================
  trait PluginLifecycleManager {
    def loadPlugin(pluginId: String): Either[String, Unit]
    def startPlugin(pluginId: String): Either[String, Unit]
    def stopPlugin(pluginId: String): Either[String, Unit]
    def unloadPlugin(pluginId: String): Either[String, Unit]
    def restartPlugin(pluginId: String): Either[String, Unit]
  }

  // TODO: Implement lifecycle manager with state transitions
  class DefaultLifecycleManager(registry: PluginRegistry) extends PluginLifecycleManager {
    def loadPlugin(pluginId: String): Either[String, Unit] = ???
    def startPlugin(pluginId: String): Either[String, Unit] = ???
    def stopPlugin(pluginId: String): Either[String, Unit] = ???
    def unloadPlugin(pluginId: String): Either[String, Unit] = ???
    def restartPlugin(pluginId: String): Either[String, Unit] = ???
    private def validateTransition(current: PluginState, target: PluginState): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 4: Plugin Dependency
  // ============================================================
  trait PluginDependencyResolver {
    def resolveDependencies(pluginId: String): Either[String, List[String]]
    def getLoadOrder(pluginIds: List[String]): Either[String, List[String]]
    def detectCircularDependencies(pluginIds: List[String]): Either[String, Option[List[String]]]
  }

  // TODO: Implement topological sort for plugin loading order
  class DependencyResolver(registry: PluginRegistry) extends PluginDependencyResolver {
    def resolveDependencies(pluginId: String): Either[String, List[String]] = ???
    def getLoadOrder(pluginIds: List[String]): Either[String, List[String]] = ???
    def detectCircularDependencies(pluginIds: List[String]): Either[String, Option[List[String]]] = ???
  }

  // ============================================================
  // Exercise 5: Plugin Configuration
  // ============================================================
  trait PluginConfig {
    def get(key: String): Option[String]
    def getInt(key: String): Option[Int]
    def getBool(key: String): Option[Boolean]
    def getAll: Map[String, String]
  }

  trait ConfigurablePlugin extends Plugin {
    def configure(config: PluginConfig): Either[String, Unit]
    def requiredConfigKeys: List[String]
    def validateConfig(config: PluginConfig): Either[List[String], Unit]
  }

  // TODO: Implement plugin configuration
  class MapPluginConfig(values: Map[String, String]) extends PluginConfig {
    def get(key: String): Option[String] = ???
    def getInt(key: String): Option[Int] = ???
    def getBool(key: String): Option[Boolean] = ???
    def getAll: Map[String, String] = ???
  }

  // ============================================================
  // Exercise 6: Plugin Isolation
  // ============================================================
  // TODO: Design plugin isolation to prevent one plugin from
  //  affecting others. Use separate execution contexts.

  trait PluginSandbox {
    def execute[A](pluginId: String, action: => Either[String, A]): Either[String, A]
    def getResourceUsage(pluginId: String): PluginResourceUsage
    def setResourceLimits(pluginId: String, limits: ResourceLimits): Either[String, Unit]
  }

  case class PluginResourceUsage(memoryBytes: Long, cpuTimeMs: Long, threadCount: Int, openConnections: Int)
  case class ResourceLimits(maxMemoryBytes: Long, maxCpuTimeMs: Long, maxThreads: Int, maxConnections: Int)

  class DefaultPluginSandbox extends PluginSandbox {
    def execute[A](pluginId: String, action: => Either[String, A]): Either[String, A] = ???
    def getResourceUsage(pluginId: String): PluginResourceUsage = ???
    def setResourceLimits(pluginId: String, limits: ResourceLimits): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 7: Hot Reload Concept
  // ============================================================
  trait HotReloadManager {
    def canReload(pluginId: String): Either[String, Boolean]
    def reload(pluginId: String, newVersion: Plugin): Either[String, Unit]
    def rollback(pluginId: String): Either[String, Unit]
  }

  class DefaultHotReloadManager(registry: PluginRegistry, lifecycle: PluginLifecycleManager) extends HotReloadManager {
    def canReload(pluginId: String): Either[String, Boolean] = ???
    def reload(pluginId: String, newVersion: Plugin): Either[String, Unit] = ???
    def rollback(pluginId: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 8: Plugin Versioning
  // ============================================================
  case class SemanticVersion(major: Int, minor: Int, patch: Int) {
    def isCompatibleWith(other: SemanticVersion): Boolean = ???
    def isNewerThan(other: SemanticVersion): Boolean = ???
  }

  trait PluginVersionManager {
    def checkCompatibility(pluginId: String, version: SemanticVersion): Either[String, Boolean]
    def getAvailableVersions(pluginId: String): Either[String, List[SemanticVersion]]
    def upgrade(pluginId: String, targetVersion: SemanticVersion): Either[String, Unit]
    def downgrade(pluginId: String, targetVersion: SemanticVersion): Either[String, Unit]
  }

  class DefaultVersionManager(registry: PluginRegistry) extends PluginVersionManager {
    def checkCompatibility(pluginId: String, version: SemanticVersion): Either[String, Boolean] = ???
    def getAvailableVersions(pluginId: String): Either[String, List[SemanticVersion]] = ???
    def upgrade(pluginId: String, targetVersion: SemanticVersion): Either[String, Unit] = ???
    def downgrade(pluginId: String, targetVersion: SemanticVersion): Either[String, Unit] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch022: Plugin Architecture ===")
    println()
    println("Exercise 1: Plugin Interface")
    println("Exercise 2: Plugin Registry")
    println("Exercise 3: Plugin Lifecycle")
    println("Exercise 4: Plugin Dependency")
    println("Exercise 5: Plugin Configuration")
    println("Exercise 6: Plugin Isolation")
    println("Exercise 7: Hot Reload Concept")
    println("Exercise 8: Plugin Versioning")
  }
}
