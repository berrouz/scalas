package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Testability Design
 *
 * Senior/Architect focus:
 * - Designing systems that are inherently testable
 * - FP-style dependency injection and test doubles
 * - Test architecture and strategies
 */
object Arch007_TestabilityDesign {

  // ============================================================
  // Exercise 1: Designing for Testability
  // ============================================================
  // TODO: Refactor this untestable service into a testable design.
  //  The original has hardcoded dependencies, side effects mixed
  //  with logic, and no seams for testing.

  // BAD: Untestable - hardcoded dependencies, mixed concerns
  // class UntestableService {
  //   def process(data: String): String = {
  //     val conn = DriverManager.getConnection("jdbc:postgresql://prod:5432/db")
  //     val result = conn.prepareStatement(s"INSERT INTO data VALUES ('$data')").execute()
  //     HttpClient.post("https://api.external.com/notify", data)
  //     s"Processed: $result"
  //   }
  // }

  // GOOD: Testable - dependencies injected, pure logic separated
  trait DataStore {
    def save(data: String): Either[String, Long]
  }

  trait ExternalNotifier {
    def notify(data: String): Either[String, Unit]
  }

  class TestableService(store: DataStore, notifier: ExternalNotifier) {
    // Pure validation logic - easily unit testable
    def validate(data: String): Either[String, String] = ???

    // Orchestration - testable with mocks
    def process(data: String): Either[String, Long] = ???
  }

  // TODO: Implement test doubles
  class InMemoryDataStore extends DataStore {
    val stored = scala.collection.mutable.ListBuffer.empty[String]
    def save(data: String): Either[String, Long] = ???
  }

  class FakeNotifier extends ExternalNotifier {
    val notifications = scala.collection.mutable.ListBuffer.empty[String]
    def notify(data: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 2: Dependency Injection FP-Style
  // ============================================================
  // TODO: Implement DI using the Reader pattern (functions that
  //  take dependencies as parameters). No framework needed.

  // Environment / dependency bundle
  case class AppEnv(
    userRepo: UserRepository,
    emailService: EmailService,
    config: AppConfig
  )

  trait UserRepository {
    def findById(id: Long): Either[String, Option[UserData]]
    def save(user: UserData): Either[String, Long]
  }

  trait EmailService {
    def send(to: String, subject: String, body: String): Either[String, Unit]
  }

  case class AppConfig(maxRetries: Int, baseUrl: String)
  case class UserData(id: Long, name: String, email: String)

  // Reader-style DI: functions take environment
  type Reader[A] = AppEnv => Either[String, A]

  // TODO: Implement operations using Reader pattern
  def getUser(id: Long): Reader[Option[UserData]] = ???
  def createUser(name: String, email: String): Reader[Long] = ???
  def notifyUser(userId: Long, message: String): Reader[Unit] = ???

  // TODO: Compose readers
  def createAndNotifyUser(name: String, email: String): Reader[Unit] = ???

  // ============================================================
  // Exercise 3: Test Doubles in FP
  // ============================================================
  // TODO: Implement different types of test doubles in FP style:
  //  Stub (returns canned data), Spy (records calls), Fake (working impl)

  // Stub: returns predefined responses
  class StubUserRepository(users: Map[Long, UserData]) extends UserRepository {
    def findById(id: Long): Either[String, Option[UserData]] = ???
    def save(user: UserData): Either[String, Long] = ???
  }

  // Spy: records interactions for verification
  class SpyEmailService extends EmailService {
    var sentEmails: List[(String, String, String)] = List.empty
    def send(to: String, subject: String, body: String): Either[String, Unit] = ???

    // Verification methods
    def wasCalled: Boolean = ???
    def callCount: Int = ???
    def wasCalledWith(to: String): Boolean = ???
  }

  // Fake: simplified but working implementation
  class FakeUserRepository extends UserRepository {
    private val store = scala.collection.mutable.Map.empty[Long, UserData]
    private var nextId = 1L

    def findById(id: Long): Either[String, Option[UserData]] = ???
    def save(user: UserData): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 4: Property-Based Testing Design
  // ============================================================
  // TODO: Design domain types and functions that are amenable to
  //  property-based testing. Identify properties that should hold.

  // Domain with clear properties
  case class ShoppingCart(items: Map[String, Int]) {
    def addItem(productId: String, quantity: Int): ShoppingCart = ???
    def removeItem(productId: String): ShoppingCart = ???
    def updateQuantity(productId: String, quantity: Int): ShoppingCart = ???
    def totalItems: Int = ???
    def isEmpty: Boolean = ???
  }

  // TODO: Define properties that should hold for ShoppingCart
  // Property 1: Adding then removing an item returns original cart
  def prop_addRemoveIdentity(cart: ShoppingCart, productId: String, qty: Int): Boolean = ???

  // Property 2: Adding items is commutative (order doesn't matter)
  def prop_addCommutative(cart: ShoppingCart, p1: String, q1: Int, p2: String, q2: Int): Boolean = ???

  // Property 3: totalItems is always >= 0
  def prop_totalItemsNonNegative(cart: ShoppingCart): Boolean = ???

  // Property 4: empty cart has 0 total items
  def prop_emptyCartZeroItems: Boolean = ???

  // ============================================================
  // Exercise 5: Integration Test Architecture
  // ============================================================
  // TODO: Design an integration testing architecture with proper
  //  setup/teardown, test isolation, and external dependency management.

  trait TestFixture {
    def setup(): Either[String, Unit]
    def teardown(): Either[String, Unit]
  }

  // TODO: Implement a database test fixture
  class DatabaseFixture(connectionString: String) extends TestFixture {
    def setup(): Either[String, Unit] = ???
    def teardown(): Either[String, Unit] = ???

    // Helper: run test in a transaction that rolls back
    def withRollback[A](test: => Either[String, A]): Either[String, A] = ???
  }

  // TODO: Design a test container manager for integration tests
  trait TestContainerManager {
    def startContainer(image: String, ports: Map[Int, Int]): Either[String, ContainerInfo]
    def stopContainer(containerId: String): Either[String, Unit]
    def stopAll(): Either[String, Unit]
  }

  case class ContainerInfo(containerId: String, host: String, portMappings: Map[Int, Int])

  // TODO: Implement integration test base class
  trait IntegrationTestBase {
    def containers: TestContainerManager
    def fixtures: List[TestFixture]

    def beforeAll(): Either[String, Unit] = ???
    def afterAll(): Either[String, Unit] = ???
    def beforeEach(): Either[String, Unit] = ???
    def afterEach(): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 6: Test Pyramid
  // ============================================================
  // TODO: Design test structure following the test pyramid.
  //  Many unit tests (fast, isolated), fewer integration tests,
  //  minimal end-to-end tests.

  // Unit test: tests pure logic in isolation
  object UnitTestExample {
    def validateEmail(email: String): Either[String, String] = ???

    // Tests (conceptual - would use ScalaTest/MUnit in practice)
    def test_validEmail(): Boolean = ???
    def test_invalidEmail_noAt(): Boolean = ???
    def test_invalidEmail_empty(): Boolean = ???
  }

  // Integration test: tests module interactions
  object IntegrationTestExample {
    // Tests service with real (but test) database
    def test_createAndRetrieveUser(fixture: DatabaseFixture): Either[String, Boolean] = ???
  }

  // E2E test: tests full flow
  object E2ETestExample {
    // Tests complete user registration flow
    def test_userRegistrationFlow(baseUrl: String): Either[String, Boolean] = ???
  }

  // ============================================================
  // Exercise 7: Contract Testing Concept
  // ============================================================
  // TODO: Design contract tests for service boundaries.
  //  Contracts define expected behavior between producer and consumer.

  // Contract definition
  case class ServiceContract(
    serviceName: String,
    endpoint: String,
    method: String,
    requestSchema: Map[String, String],
    responseSchema: Map[String, String],
    statusCodes: List[Int]
  )

  // TODO: Implement contract verification
  trait ContractVerifier {
    def verifyProducer(contract: ServiceContract): Either[String, Boolean] = ???
    def verifyConsumer(contract: ServiceContract): Either[String, Boolean] = ???
  }

  // TODO: Define contracts for a user service API
  val userServiceContracts: List[ServiceContract] = ???

  // ============================================================
  // Exercise 8: Golden File Testing
  // ============================================================
  // TODO: Design a golden file testing system where expected outputs
  //  are stored in files and compared against actual outputs.
  //  Support updating goldens when behavior intentionally changes.

  trait GoldenFileTest {
    def goldenDir: String

    def compareWithGolden(testName: String, actual: String): Either[String, Boolean] = ???
    def updateGolden(testName: String, content: String): Either[String, Unit] = ???

    // TODO: Implement diff reporting for golden file mismatches
    def generateDiff(expected: String, actual: String): String = ???
  }

  // TODO: Implement golden file test for JSON API responses
  class ApiResponseGoldenTest(override val goldenDir: String) extends GoldenFileTest {
    def testEndpoint(endpoint: String, response: String): Either[String, Boolean] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch007: Testability Design ===")
    println()
    println("Exercise 1: Designing for Testability")
    println("Exercise 2: Dependency Injection FP-Style")
    println("Exercise 3: Test Doubles in FP")
    println("Exercise 4: Property-Based Testing Design")
    println("Exercise 5: Integration Test Architecture")
    println("Exercise 6: Test Pyramid")
    println("Exercise 7: Contract Testing Concept")
    println("Exercise 8: Golden File Testing")
  }
}
