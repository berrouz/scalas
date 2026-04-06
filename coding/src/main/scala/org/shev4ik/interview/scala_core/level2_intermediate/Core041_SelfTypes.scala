package org.shev4ik.interview.scala_core.level2_intermediate

object Core041_SelfTypes {

  // Exercise 1: Self-type annotation
  // TODO: Create a trait Greeter that requires a trait Named (with `name: String`)
  //       via self-type. Greeter should have `greet: String` returning "Hello, $name"
  trait Named {
    def name: String
  }
  trait Greeter { self: Named =>
    def greet: String = ???
  }

  // TODO: Create a class Person that mixes in both
  class Person(val name: String) extends Named with Greeter

  // Exercise 2: Self-type for DI
  // TODO: Create a simple DI setup:
  //       trait Logger { def log(msg: String): String }
  //       trait Database { self: Logger => def query(q: String): String }
  //       Database uses Logger.log in query
  trait Logger {
    def log(msg: String): String
  }
  trait Database { self: Logger =>
    def query(q: String): String = ???
  }

  // TODO: Create a concrete class that mixes both
  class AppDatabase extends Database with Logger {
    def log(msg: String): String = ???
  }

  // Exercise 3: Self-type vs extends
  // TODO: Demonstrate the difference:
  //       - With extends: class A extends B (A IS-A B)
  //       - With self-type: trait A { self: B => } (A REQUIRES B but is not a B)
  //       Create trait Auditable { self: Logger => def audit(action: String): String }
  trait Auditable { self: Logger =>
    def audit(action: String): String = ???
  }

  class AuditService extends Auditable with Logger {
    def log(msg: String): String = ???
  }

  // Exercise 4: Self-type with multiple traits
  // TODO: Create a trait that requires multiple other traits via self-type
  //       trait Security { self: Logger with Database => def authenticate(user: String): String }
  trait Security { self: Logger with Database =>
    def authenticate(user: String): String = ???
  }

  class SecureApp extends Security with Logger with Database {
    def log(msg: String): String = ???
  }

  // Exercise 5: this aliasing
  // TODO: Create a trait where the self-type uses an alias other than `self`
  //       trait Builder { outer => class Step { def owner: String = outer.builderName } }
  //       with a `builderName: String` method
  trait Builder { outer =>
    def builderName: String
    class Step(val stepName: String) {
      def describe: String = ???
    }
  }

  class ConcreteBuilder(val builderName: String) extends Builder

  // Exercise 6: Structural self-type
  // TODO: Create a trait that requires a structural type via self-type
  //       trait HasClose { self: { def close(): Unit } => def safeClose(): String }
  trait HasClose { self: { def close(): Unit } =>
    def safeClose(): String = ???
  }

  class Resource extends HasClose {
    var closed = false
    def close(): Unit = ???
    // safeClose is inherited from HasClose
  }

  // Exercise 7: Self-type for module pattern
  // TODO: Define a module pattern with self-types:
  //       trait ConfigModule { def config: Map[String, String] }
  //       trait ServiceModule { self: ConfigModule => def getConfigValue(key: String): Option[String] }
  trait ConfigModule {
    def config: Map[String, String]
  }
  trait ServiceModule { self: ConfigModule =>
    def getConfigValue(key: String): Option[String] = ???
  }

  class AppModule extends ServiceModule with ConfigModule {
    val config: Map[String, String] = ???
  }

  // Exercise 8: Cake pattern intro
  // TODO: Create a simple cake pattern:
  //       trait UserRepositoryComponent { def userRepo: UserRepository; trait UserRepository { def find(id: Int): String } }
  //       trait UserServiceComponent { self: UserRepositoryComponent => def userService: UserService; trait UserService { def getUser(id: Int): String } }
  trait UserRepositoryComponent {
    def userRepo: UserRepository
    trait UserRepository {
      def find(id: Int): String
    }
  }
  trait UserServiceComponent { self: UserRepositoryComponent =>
    def userService: UserService
    trait UserService {
      def getUser(id: Int): String = ???
    }
  }

  // TODO: Wire it all together
  class Application extends UserServiceComponent with UserRepositoryComponent {
    val userRepo: UserRepository = ???
    val userService: UserService = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 assertions
    val person = new Person("Alice")
    assert(person.greet == "Hello, Alice", "Greeter should use Named.name")

    // Exercise 2 assertions
    val db = new AppDatabase
    assert(db.log("test").contains("test"), "Logger should log")
    assert(db.query("SELECT 1").nonEmpty, "Database should query")

    // Exercise 3 assertions
    val auditService = new AuditService
    assert(auditService.audit("login").contains("login"), "Auditable should audit")
    // Note: auditService is NOT a Logger from the Auditable trait's perspective externally
    // but it IS a Logger because it mixes in Logger

    // Exercise 4 assertions
    val secureApp = new SecureApp
    assert(secureApp.authenticate("admin").contains("admin"), "Security should authenticate")

    // Exercise 5 assertions
    val builder = new ConcreteBuilder("MyBuilder")
    val step = new builder.Step("step1")
    assert(step.describe.contains("MyBuilder"), "Step should reference outer builder")
    assert(step.describe.contains("step1"), "Step should include step name")

    // Exercise 6 assertions
    val resource = new Resource
    assert(!resource.closed, "Resource should start open")
    val result = resource.safeClose()
    assert(resource.closed, "Resource should be closed after safeClose")
    assert(result.nonEmpty, "safeClose should return a message")

    // Exercise 7 assertions
    val app = new AppModule
    assert(app.getConfigValue("db.url").isDefined, "Should find config value")
    assert(app.getConfigValue("missing") == None, "Missing key should be None")

    // Exercise 8 assertions
    val application = new Application
    assert(application.userService.getUser(1).nonEmpty, "Cake pattern should work")

    println("All Core041_SelfTypes exercises passed!")
  }
}
