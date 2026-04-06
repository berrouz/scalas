package org.shev4ik.interview.senior_architect.level2_architecture_patterns

/**
 * Clean Architecture
 *
 * Senior/Architect focus:
 * - Dependency rule: dependencies point inward
 * - Layer separation: entity, use case, interface, framework
 * - Testing each layer independently
 */
object Arch014_CleanArch {

  // ============================================================
  // Exercise 1: Entity Layer (Innermost)
  // ============================================================
  // TODO: Design the entity layer with enterprise business rules.
  //  Entities are pure domain objects with no dependencies on
  //  any outer layer. They encapsulate critical business rules.

  object Entities {
    case class AccountId(value: String)
    case class Money(amount: BigDecimal, currency: String) {
      def +(other: Money): Either[String, Money] = ???
      def -(other: Money): Either[String, Money] = ???
      def isPositive: Boolean = ???
    }

    sealed trait AccountType
    case object Checking extends AccountType
    case object Savings extends AccountType

    case class Account(
      id: AccountId,
      owner: String,
      accountType: AccountType,
      balance: Money,
      isActive: Boolean
    ) {
      // Enterprise business rules - valid across all applications
      def canWithdraw(amount: Money): Boolean = ???
      def canTransfer(amount: Money): Boolean = ???
      def applyInterest(rate: BigDecimal): Account = ???
    }

    sealed trait TransactionType
    case object Deposit extends TransactionType
    case object Withdrawal extends TransactionType
    case object Transfer extends TransactionType

    case class Transaction(
      id: String,
      fromAccount: Option[AccountId],
      toAccount: AccountId,
      amount: Money,
      transactionType: TransactionType,
      timestamp: Long
    )
  }

  // ============================================================
  // Exercise 2: Use Case Layer
  // ============================================================
  // TODO: Design use cases (interactors) that orchestrate entity
  //  behavior. Use cases define APPLICATION-specific business rules.
  //  They depend only on entities and port interfaces.

  import Entities._

  // Use case input/output ports
  case class TransferRequest(fromAccountId: String, toAccountId: String, amount: BigDecimal, currency: String)
  case class TransferResponse(transactionId: String, fromBalance: Money, toBalance: Money)

  sealed trait UseCaseError
  case class AccountNotFoundError(accountId: String) extends UseCaseError
  case class InsufficientFundsError(accountId: String, available: Money, requested: Money) extends UseCaseError
  case class AccountInactiveError(accountId: String) extends UseCaseError
  case class SameAccountError(accountId: String) extends UseCaseError

  // Output port (driven): what the use case needs
  trait AccountGateway {
    def findById(id: AccountId): Either[UseCaseError, Option[Account]]
    def save(account: Account): Either[UseCaseError, Account]
  }

  trait TransactionGateway {
    def save(transaction: Transaction): Either[UseCaseError, Transaction]
  }

  // TODO: Implement the transfer use case
  class TransferUseCase(accountGateway: AccountGateway, transactionGateway: TransactionGateway) {
    def execute(request: TransferRequest): Either[UseCaseError, TransferResponse] = ???
  }

  // ============================================================
  // Exercise 3: Interface Adapters Layer
  // ============================================================
  // TODO: Design interface adapters that convert data between
  //  the use case layer and the external world (controllers,
  //  presenters, gateways).

  // Controller: converts external request to use case input
  object TransferController {
    case class HttpTransferRequest(
      from_account: String,
      to_account: String,
      amount: String,
      currency: String
    )

    case class HttpTransferResponse(
      transaction_id: String,
      from_balance: String,
      to_balance: String,
      status: String
    )

    // TODO: Convert HTTP request to use case request
    def toUseCaseRequest(httpReq: HttpTransferRequest): Either[String, TransferRequest] = ???

    // TODO: Convert use case response to HTTP response
    def toHttpResponse(useCaseResp: TransferResponse): HttpTransferResponse = ???

    // TODO: Convert use case error to HTTP error
    def toHttpError(error: UseCaseError): (Int, String) = ???
  }

  // Presenter: formats data for the view
  trait TransferPresenter {
    def presentSuccess(response: TransferResponse): Map[String, Any]
    def presentError(error: UseCaseError): Map[String, Any]
  }

  // TODO: Implement JSON presenter
  class JsonTransferPresenter extends TransferPresenter {
    def presentSuccess(response: TransferResponse): Map[String, Any] = ???
    def presentError(error: UseCaseError): Map[String, Any] = ???
  }

  // ============================================================
  // Exercise 4: Frameworks Layer (Outermost)
  // ============================================================
  // TODO: Design the frameworks/drivers layer. This is where
  //  concrete technologies live (database, web framework, etc.)

  // Database implementation of AccountGateway
  class PostgresAccountGateway(connectionString: String) extends AccountGateway {
    def findById(id: AccountId): Either[UseCaseError, Option[Account]] = ???
    def save(account: Account): Either[UseCaseError, Account] = ???
  }

  class PostgresTransactionGateway(connectionString: String) extends TransactionGateway {
    def save(transaction: Transaction): Either[UseCaseError, Transaction] = ???
  }

  // Web framework handler
  class TransferHandler(
    transferUseCase: TransferUseCase,
    presenter: TransferPresenter
  ) {
    def handleTransfer(requestBody: String): (Int, Map[String, Any]) = ???
  }

  // ============================================================
  // Exercise 5: Dependency Rule
  // ============================================================
  // TODO: Demonstrate the dependency rule. Dependencies must point
  //  INWARD. Inner layers never know about outer layers.

  // CORRECT dependency direction:
  // Framework -> Interface Adapters -> Use Cases -> Entities
  //
  // Each layer only imports from layers further inside:
  // - Entity: imports nothing
  // - Use Case: imports Entity
  // - Interface Adapter: imports Use Case, Entity
  // - Framework: imports all inner layers

  // TODO: Show dependency rule violation and fix
  // VIOLATION: Entity depending on a framework class
  // case class BadEntity(id: String, data: SomeFrameworkClass)  // WRONG!

  // FIX: Entity uses domain types; adapter converts
  // case class GoodEntity(id: String, data: DomainData)  // RIGHT!

  // TODO: Design the dependency inversion at each boundary
  trait DependencyRuleDemo {
    // Use case defines the port (interface)
    trait EmailNotifier {
      def sendTransferNotification(from: AccountId, to: AccountId, amount: Money): Either[UseCaseError, Unit]
    }

    // Framework implements the port
    class SmtpEmailNotifier(smtpHost: String) extends EmailNotifier {
      def sendTransferNotification(from: AccountId, to: AccountId, amount: Money): Either[UseCaseError, Unit] = ???
    }
  }

  // ============================================================
  // Exercise 6: Clean Architecture in Scala
  // ============================================================
  // TODO: Map clean architecture concepts to Scala idioms.
  //  Use traits for ports, case classes for entities, objects for services.

  // Scala-idiomatic clean architecture
  object ScalaCleanArch {
    // Entities as case classes + companion objects with business logic
    case class Product(id: String, name: String, price: BigDecimal, stock: Int) {
      def isAvailable: Boolean = ???
      def decrementStock(qty: Int): Either[String, Product] = ???
    }

    // Use cases as classes with injected dependencies (trait-based ports)
    trait ProductRepository {
      def find(id: String): Either[String, Option[Product]]
      def save(product: Product): Either[String, Product]
    }

    class PurchaseProductUseCase(repo: ProductRepository) {
      def execute(productId: String, quantity: Int): Either[String, Product] = ???
    }

    // Interface adapter as function
    def httpToDomain(json: Map[String, String]): Either[String, (String, Int)] = ???
    def domainToHttp(product: Product): Map[String, String] = ???
  }

  // ============================================================
  // Exercise 7: Clean Architecture with ZIO Concepts
  // ============================================================
  // TODO: Show how clean architecture maps to ZIO patterns.
  //  Use cases become ZIO effects, ports become ZIO services.

  // Simulated ZIO-style clean architecture
  object ZIOCleanArch {
    // Port as ZIO service trait
    trait AccountService {
      def getAccount(id: String): Either[UseCaseError, Account]
      def transfer(from: String, to: String, amount: BigDecimal): Either[UseCaseError, TransferResponse]
    }

    // "ZLayer" factory for service implementation
    object AccountService {
      def live(accountGw: AccountGateway, txGw: TransactionGateway): AccountService = ???
      def test(accounts: Map[String, Account]): AccountService = ???
    }

    // Compose layers
    def buildApp(dbUrl: String): AccountService = ???
  }

  // ============================================================
  // Exercise 8: Clean Architecture Testing
  // ============================================================
  // TODO: Design test strategy for each clean architecture layer.
  //  Inner layers tested with unit tests, outer layers with integration.

  object CleanArchTesting {
    // Entity tests: pure unit tests, no mocks needed
    def testEntityCanWithdraw(): Boolean = ???
    def testEntityInterestCalculation(): Boolean = ???

    // Use case tests: mock the ports
    class MockAccountGateway(accounts: Map[AccountId, Account]) extends AccountGateway {
      def findById(id: AccountId): Either[UseCaseError, Option[Account]] = ???
      def save(account: Account): Either[UseCaseError, Account] = ???
    }

    class MockTransactionGateway extends TransactionGateway {
      val savedTransactions = scala.collection.mutable.ListBuffer.empty[Transaction]
      def save(transaction: Transaction): Either[UseCaseError, Transaction] = ???
    }

    // TODO: Write test for transfer use case
    def testTransferSuccess(): Either[String, Boolean] = ???
    def testTransferInsufficientFunds(): Either[String, Boolean] = ???

    // Interface adapter tests: test conversion logic
    def testControllerRequestConversion(): Boolean = ???
    def testPresenterFormatting(): Boolean = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch014: Clean Architecture ===")
    println()
    println("Exercise 1: Entity Layer")
    println("Exercise 2: Use Case Layer")
    println("Exercise 3: Interface Adapters Layer")
    println("Exercise 4: Frameworks Layer")
    println("Exercise 5: Dependency Rule")
    println("Exercise 6: Clean Architecture in Scala")
    println("Exercise 7: Clean Architecture with ZIO")
    println("Exercise 8: Clean Architecture Testing")
  }
}
