package org.shev4ik.interview.scala_core.level2_intermediate

object Core042_CakePattern {

  // Exercise 1: Component trait
  // TODO: Define a RepositoryComponent with an abstract `repository` val
  //       and an inner trait Repository with methods:
  //       findById(id: Int): Option[String], save(id: Int, value: String): Unit
  trait RepositoryComponent {
    def repository: Repository
    trait Repository {
      def findById(id: Int): Option[String]
      def save(id: Int, value: String): Unit
    }
  }

  // Exercise 2: Module trait (concrete implementation)
  // TODO: Create a concrete InMemoryRepositoryComponent that extends RepositoryComponent
  //       implementing Repository with a mutable Map
  trait InMemoryRepositoryComponent extends RepositoryComponent {
    class InMemoryRepository extends Repository {
      private val store = scala.collection.mutable.Map.empty[Int, String]
      def findById(id: Int): Option[String] = ???
      def save(id: Int, value: String): Unit = ???
    }
  }

  // Exercise 3: Wiring with self-types
  // TODO: Create a ServiceComponent that depends on RepositoryComponent via self-type
  //       with an inner trait Service having method process(id: Int): String
  trait ServiceComponent { self: RepositoryComponent =>
    def service: Service
    trait Service {
      def process(id: Int): String = ???
    }
  }

  // Exercise 4: Testing with mock components
  // TODO: Create a MockRepositoryComponent for testing
  //       that returns predictable values
  trait MockRepositoryComponent extends RepositoryComponent {
    class MockRepository extends Repository {
      def findById(id: Int): Option[String] = ???
      def save(id: Int, value: String): Unit = ???
    }
  }

  // Exercise 5: Real vs test wiring
  // TODO: Create two application objects:
  //       ProductionApp using InMemoryRepositoryComponent
  //       TestApp using MockRepositoryComponent
  object ProductionApp extends ServiceComponent with InMemoryRepositoryComponent {
    val repository: Repository = ???
    val service: Service = ???
  }

  object TestApp extends ServiceComponent with MockRepositoryComponent {
    val repository: Repository = ???
    val service: Service = ???
  }

  // Exercise 6: Cake pattern pros/cons
  // TODO: Create a LoggingComponent that depends on nothing
  //       Add it to the cake to demonstrate growing complexity
  //       Comment about pros and cons
  trait LoggingComponent {
    def logger: Logger
    trait Logger {
      def log(msg: String): String
    }
  }
  trait ConsoleLoggingComponent extends LoggingComponent {
    class ConsoleLogger extends Logger {
      def log(msg: String): String = ???
    }
  }

  // Exercise 7: Slim cake
  // TODO: Create a "slim" cake variant using class parameters instead of traits
  //       Define case class AppConfig(dbUrl: String, maxRetries: Int)
  //       Create a SlimService that takes AppConfig as a constructor parameter
  case class AppConfig(dbUrl: String, maxRetries: Int)

  class SlimService(config: AppConfig) {
    def getDbUrl: String = ???
    def getMaxRetries: Int = ???
  }

  // Exercise 8: Thin cake (just type aliases and wiring)
  // TODO: Create a thin cake using a simple Registry pattern
  //       trait Registry { val repo: SimpleRepo; val svc: SimpleService }
  trait SimpleRepo {
    def get(key: String): Option[String]
  }
  trait SimpleService {
    def lookup(key: String): String
  }

  trait Registry {
    val repo: SimpleRepo
    val svc: SimpleService
  }

  // TODO: Create a concrete registry
  def createRegistry(): Registry = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1 & 2 assertions
    val prodApp = ProductionApp
    prodApp.repository.save(1, "Alice")
    assert(prodApp.repository.findById(1) == Some("Alice"), "InMemory repo should store and retrieve")
    assert(prodApp.repository.findById(99) == None, "InMemory repo should return None for missing")

    // Exercise 3 assertions
    prodApp.repository.save(2, "Bob")
    assert(prodApp.service.process(2).contains("Bob"), "Service should process using repository")

    // Exercise 4 & 5 assertions
    val testApp = TestApp
    assert(testApp.repository.findById(1) == Some("mock_1"), "Mock repo should return predictable values")
    assert(testApp.service.process(1).contains("mock_1"), "Test service should use mock repo")

    // Exercise 6 assertions (just verify it compiles and works)
    object LoggingApp extends ConsoleLoggingComponent {
      val logger = new ConsoleLogger
    }
    assert(LoggingApp.logger.log("test").contains("test"), "Logger should log")
    // Pros: Compile-time DI, no reflection, type-safe
    // Cons: Verbose, complex trait hierarchies, hard to understand

    // Exercise 7 assertions
    val slimService = new SlimService(AppConfig("jdbc:h2:mem", 3))
    assert(slimService.getDbUrl == "jdbc:h2:mem", "SlimService should return db url")
    assert(slimService.getMaxRetries == 3, "SlimService should return max retries")

    // Exercise 8 assertions
    val registry = createRegistry()
    assert(registry.repo.get("key1").isDefined, "Registry repo should work")
    assert(registry.svc.lookup("key1").nonEmpty, "Registry service should work")

    println("All Core042_CakePattern exercises passed!")
  }
}
