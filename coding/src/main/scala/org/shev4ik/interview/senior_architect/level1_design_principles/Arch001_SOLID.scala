package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * SOLID Principles in Scala / FP Context
 *
 * Senior/Architect focus:
 * - How SOLID maps to FP and Scala idioms
 * - Recognizing violations and designing principled solutions
 * - Real-world trade-offs when applying SOLID
 */
object Arch001_SOLID {

  // ============================================================
  // Exercise 1: Single Responsibility with Traits
  // ============================================================
  // TODO: Refactor the monolithic UserService into separate,
  //  single-responsibility traits. Each trait should handle exactly
  //  one concern: persistence, validation, notification.
  //  Compose them in a final service using mixin composition.

  // BAD: monolithic service violating SRP
  trait MonolithicUserService {
    def createUser(name: String, email: String): Unit
    def validateUser(name: String, email: String): Boolean
    def sendWelcomeEmail(email: String): Unit
    def saveToDatabase(name: String, email: String): Unit
    def logAudit(action: String): Unit
  }

  // GOOD: decomposed single-responsibility traits
  trait UserValidation {
    def validateUser(name: String, email: String): Either[String, (String, String)] = ???
  }

  trait UserPersistence {
    def saveUser(name: String, email: String): Either[String, Long] = ???
  }

  trait UserNotification {
    def sendWelcomeEmail(email: String): Either[String, Unit] = ???
  }

  trait AuditLogging {
    def logAudit(action: String, details: Map[String, String]): Unit = ???
  }

  // TODO: Compose these traits into a UserService that delegates to each concern
  trait UserService extends UserValidation with UserPersistence with UserNotification with AuditLogging {
    def createUser(name: String, email: String): Either[String, Long] = ???
  }

  // ============================================================
  // Exercise 2: Open-Closed Principle with Type Classes
  // ============================================================
  // TODO: Design a serialization system using type classes so that
  //  adding new formats (JSON, XML, CSV, Protobuf) does NOT require
  //  modifying existing code. Demonstrate OCP through extension.

  trait Serializer[A] {
    def serialize(value: A): String
    def deserialize(raw: String): Either[String, A]
  }

  object Serializer {
    def apply[A](implicit s: Serializer[A]): Serializer[A] = s
  }

  case class Order(id: Long, product: String, quantity: Int, price: BigDecimal)

  // TODO: Implement JSON serializer for Order (open for extension)
  implicit val orderJsonSerializer: Serializer[Order] = ???

  // TODO: Add CSV serializer WITHOUT modifying Order or Serializer trait
  // This demonstrates OCP - open for extension, closed for modification
  implicit val orderCsvSerializer: Serializer[Order] = ???

  def serializeOrder[A](value: A)(implicit s: Serializer[A]): String = ???

  // ============================================================
  // Exercise 3: Liskov Substitution with Variance
  // ============================================================
  // TODO: Design a repository hierarchy that properly respects LSP.
  //  Use covariance/contravariance annotations correctly.
  //  Demonstrate a violation and its fix.

  // Violation example: MutableStack[Dog] cannot safely substitute MutableStack[Animal]
  // because pushing a Cat into MutableStack[Animal] would break MutableStack[Dog]

  sealed trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  // Covariant read-only repository (safe for LSP)
  trait ReadRepository[+A] {
    def findById(id: Long): Option[A]
    def findAll: List[A]
  }

  // Contravariant write-only repository (safe for LSP)
  trait WriteRepository[-A] {
    def save(entity: A): Either[String, Long]
    def delete(entity: A): Either[String, Unit]
  }

  // TODO: Implement an invariant ReadWriteRepository that composes both
  //  Explain why it must be invariant
  trait ReadWriteRepository[A] extends ReadRepository[A] with WriteRepository[A] {
    override def findById(id: Long): Option[A] = ???
    override def findAll: List[A] = ???
    override def save(entity: A): Either[String, Long] = ???
    override def delete(entity: A): Either[String, Unit] = ???
  }

  // TODO: Show that ReadRepository[Dog] can substitute ReadRepository[Animal]
  def processAnimals(repo: ReadRepository[Animal]): List[Animal] = ???

  // ============================================================
  // Exercise 4: Interface Segregation with Fine-Grained Traits
  // ============================================================
  // TODO: Break down a fat interface into minimal, client-specific traits.
  //  Clients should not depend on methods they do not use.

  // BAD: Fat interface - forces implementors to handle everything
  trait FatCRUDRepository[A] {
    def create(entity: A): Long
    def read(id: Long): Option[A]
    def update(id: Long, entity: A): Unit
    def delete(id: Long): Unit
    def search(query: String): List[A]
    def bulkInsert(entities: List[A]): List[Long]
    def export(format: String): Array[Byte]
    def audit(id: Long): List[String]
  }

  // GOOD: Segregated interfaces - compose only what you need
  trait Creatable[A] {
    def create(entity: A): Either[String, Long] = ???
  }

  trait Readable[A] {
    def read(id: Long): Option[A] = ???
  }

  trait Updatable[A] {
    def update(id: Long, entity: A): Either[String, Unit] = ???
  }

  trait Deletable[A] {
    def delete(id: Long): Either[String, Unit] = ???
  }

  trait Searchable[A] {
    def search(query: String): List[A] = ???
  }

  trait BulkOperations[A] {
    def bulkInsert(entities: List[A]): Either[String, List[Long]] = ???
  }

  // TODO: Compose a ReadOnlyService that only uses Readable + Searchable
  class ReadOnlyService[A] {
    def getById(id: Long): Option[A] = ???
    def find(query: String): List[A] = ???
  }

  // ============================================================
  // Exercise 5: Dependency Inversion with Abstract Modules
  // ============================================================
  // TODO: Design a module system where high-level business logic
  //  depends on abstractions, not concrete implementations.
  //  Use Scala traits as module boundaries.

  // Abstract module boundary (the abstraction)
  trait PaymentGateway {
    def charge(amount: BigDecimal, currency: String, token: String): Either[PaymentError, PaymentResult]
  }

  sealed trait PaymentError
  case class PaymentDeclined(reason: String) extends PaymentError
  case class PaymentTimeout(ms: Long) extends PaymentError
  case class PaymentSystemError(cause: String) extends PaymentError

  case class PaymentResult(transactionId: String, amount: BigDecimal)

  // High-level module depends on abstraction (DIP)
  class OrderProcessor(paymentGateway: PaymentGateway) {
    def processOrder(orderId: Long, amount: BigDecimal, currency: String, token: String): Either[PaymentError, PaymentResult] = ???
  }

  // TODO: Implement StripeGateway and PayPalGateway as low-level modules
  class StripeGateway extends PaymentGateway {
    override def charge(amount: BigDecimal, currency: String, token: String): Either[PaymentError, PaymentResult] = ???
  }

  class PayPalGateway extends PaymentGateway {
    override def charge(amount: BigDecimal, currency: String, token: String): Either[PaymentError, PaymentResult] = ???
  }

  // ============================================================
  // Exercise 6: SOLID in FP Context
  // ============================================================
  // TODO: Demonstrate how FP naturally enforces SOLID principles.
  //  Show how pure functions, immutability, and composition
  //  align with each SOLID principle.

  // SRP via pure functions: each function does one thing
  def validate(input: String): Either[String, String] = ???
  def transform(validated: String): String = ???
  def persist(transformed: String): Either[String, Long] = ???

  // OCP via higher-order functions: extend behavior without modification
  type Middleware[A] = A => A

  def withLogging[A](label: String): Middleware[A] = ???
  def withValidation[A](predicate: A => Boolean, error: String): Middleware[Either[String, A]] = ???

  // TODO: Compose a processing pipeline using these FP SOLID principles
  def processingPipeline(input: String): Either[String, Long] = ???

  // ============================================================
  // Exercise 7: Identifying and Fixing SOLID Violations
  // ============================================================
  // TODO: Identify all SOLID violations in this code and fix them.
  //  Document each violation and explain the fix.

  // VIOLATION 1 (SRP): ReportService does formatting AND data access AND email
  // VIOLATION 2 (OCP): Adding a new format requires modifying generateReport
  // VIOLATION 3 (DIP): Direct dependency on concrete SmtpClient
  // TODO: Refactor this code to fix all violations

  trait ReportData {
    def fetchData(reportId: String): Map[String, Any] = ???
  }

  trait ReportFormatter {
    def format(data: Map[String, Any]): String = ???
  }

  trait ReportSender {
    def send(report: String, recipient: String): Either[String, Unit] = ???
  }

  // TODO: Implement a clean ReportService that composes these concerns
  class CleanReportService(
    dataSource: ReportData,
    formatter: ReportFormatter,
    sender: ReportSender
  ) {
    def generateAndSendReport(reportId: String, recipient: String): Either[String, Unit] = ???
  }

  // ============================================================
  // Exercise 8: Real-World SOLID Application
  // ============================================================
  // TODO: Design a notification system for a production application.
  //  Apply all SOLID principles. Support multiple channels (email,
  //  SMS, push, Slack) with different formatting per channel.
  //  Make it extensible without modification.

  sealed trait NotificationChannel
  case object Email extends NotificationChannel
  case object SMS extends NotificationChannel
  case object Push extends NotificationChannel
  case object Slack extends NotificationChannel

  case class Notification(
    recipient: String,
    subject: String,
    body: String,
    channel: NotificationChannel,
    metadata: Map[String, String] = Map.empty
  )

  // SRP: separate formatting per channel
  trait NotificationFormatter[C <: NotificationChannel] {
    def format(notification: Notification): String = ???
  }

  // OCP: new channels added via new type class instances
  trait NotificationSenderTC[C <: NotificationChannel] {
    def send(formatted: String, recipient: String): Either[String, Unit] = ???
  }

  // DIP: NotificationService depends on abstractions
  // ISP: each channel only implements what it needs
  // LSP: any NotificationSender substitutes correctly
  class NotificationService {
    def sendNotification(notification: Notification): Either[String, Unit] = ???
  }

  def main(args: Array[String]): Unit = {
    println("=== Arch001: SOLID Principles ===")
    println()

    // Exercise 1: SRP
    println("Exercise 1: Single Responsibility with Traits")
    println("  Implement UserService with composed single-responsibility traits")
    println()

    // Exercise 2: OCP
    println("Exercise 2: Open-Closed Principle with Type Classes")
    println("  Add new serialization formats without modifying existing code")
    println()

    // Exercise 3: LSP
    println("Exercise 3: Liskov Substitution with Variance")
    println("  Design variance-correct repository hierarchy")
    println()

    // Exercise 4: ISP
    println("Exercise 4: Interface Segregation")
    println("  Break fat interface into composable fine-grained traits")
    println()

    // Exercise 5: DIP
    println("Exercise 5: Dependency Inversion with Abstract Modules")
    println("  High-level modules depend on abstractions")
    println()

    // Exercise 6: SOLID in FP
    println("Exercise 6: SOLID in FP Context")
    println("  Show how FP naturally enforces SOLID")
    println()

    // Exercise 7: Fix Violations
    println("Exercise 7: Identify and Fix SOLID Violations")
    println("  Refactor code to eliminate all SOLID violations")
    println()

    // Exercise 8: Real-World Application
    println("Exercise 8: Real-World Notification System with SOLID")
    println("  Design extensible multi-channel notification system")
  }
}
