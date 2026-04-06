package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Domain Modeling in Scala
 *
 * Senior/Architect focus:
 * - Making illegal states unrepresentable through types
 * - DDD tactical patterns expressed in Scala
 * - Smart constructors and refined types for domain integrity
 */
object Arch002_DomainModeling {

  // ============================================================
  // Exercise 1: Domain Types with Sealed Traits
  // ============================================================
  // TODO: Model an e-commerce order lifecycle using sealed traits.
  //  Each state should carry only the data relevant to that state.
  //  Transitions should be type-safe (you can't ship a cancelled order).

  sealed trait OrderStatus

  case class Draft(
    items: List[LineItem],
    createdAt: Long
  ) extends OrderStatus

  case class Submitted(
    items: List[LineItem],
    submittedAt: Long,
    customerId: Long
  ) extends OrderStatus

  case class Paid(
    items: List[LineItem],
    submittedAt: Long,
    paidAt: Long,
    paymentId: String,
    customerId: Long
  ) extends OrderStatus

  case class Shipped(
    items: List[LineItem],
    shippedAt: Long,
    trackingNumber: String,
    paymentId: String,
    customerId: Long
  ) extends OrderStatus

  case class Cancelled(
    reason: String,
    cancelledAt: Long,
    refundId: Option[String]
  ) extends OrderStatus

  case class LineItem(productId: Long, quantity: Int, unitPrice: BigDecimal)

  // TODO: Implement type-safe transitions
  def submitOrder(draft: Draft, customerId: Long): Either[String, Submitted] = ???
  def payOrder(submitted: Submitted, paymentId: String): Either[String, Paid] = ???
  def shipOrder(paid: Paid, trackingNumber: String): Either[String, Shipped] = ???
  def cancelOrder(status: OrderStatus): Either[String, Cancelled] = ???

  // ============================================================
  // Exercise 2: Smart Constructors
  // ============================================================
  // TODO: Implement smart constructors that validate invariants
  //  at construction time. Once created, the values are guaranteed valid.
  //  Use private constructors + companion object factory methods.

  final case class Email private (value: String) extends AnyVal
  object Email {
    def fromString(raw: String): Either[String, Email] = ???
  }

  final case class NonEmptyString private (value: String) extends AnyVal
  object NonEmptyString {
    def fromString(raw: String): Either[String, NonEmptyString] = ???
  }

  final case class PositiveAmount private (value: BigDecimal) extends AnyVal
  object PositiveAmount {
    def fromBigDecimal(raw: BigDecimal): Either[String, PositiveAmount] = ???
  }

  final case class Percentage private (value: Double) extends AnyVal
  object Percentage {
    def fromDouble(raw: Double): Either[String, Percentage] = ???
  }

  // TODO: Use smart constructors to build a validated domain object
  case class Invoice(
    recipient: Email,
    description: NonEmptyString,
    amount: PositiveAmount,
    taxRate: Percentage
  )

  def createInvoice(
    recipientEmail: String,
    description: String,
    amount: BigDecimal,
    taxRate: Double
  ): Either[List[String], Invoice] = ???

  // ============================================================
  // Exercise 3: Refined Types (Manual Implementation)
  // ============================================================
  // TODO: Implement a manual refinement type system that enforces
  //  constraints at compile time or construction time.
  //  This is the concept behind libraries like refined/iron.

  trait Predicate[A] {
    def validate(value: A): Boolean
    def errorMessage(value: A): String
  }

  case class Refined[A, P <: Predicate[A]] private (value: A)

  object Refined {
    def refine[A, P <: Predicate[A]](value: A)(implicit p: P): Either[String, Refined[A, P]] = ???
  }

  // TODO: Define predicates for common refinements
  implicit object PositiveInt extends Predicate[Int] {
    def validate(value: Int): Boolean = ???
    def errorMessage(value: Int): String = ???
  }

  implicit object NonEmptyStringPred extends Predicate[String] {
    def validate(value: String): Boolean = ???
    def errorMessage(value: String): String = ???
  }

  // ============================================================
  // Exercise 4: Making Illegal States Unrepresentable
  // ============================================================
  // TODO: Redesign this model so that invalid states are impossible
  //  to construct. The current model allows nonsensical combinations.

  // BAD: allows invalid states like Subscription(active=true, cancelledAt=Some(...))
  case class BadSubscription(
    plan: String,
    active: Boolean,
    cancelledAt: Option[Long],
    pausedUntil: Option[Long],
    trialEndsAt: Option[Long]
  )

  // GOOD: illegal states are unrepresentable
  sealed trait Subscription {
    def plan: String
  }

  // TODO: Define each subscription state with only valid fields
  case class TrialSubscription(plan: String, trialEndsAt: Long) extends Subscription
  case class ActiveSubscription(plan: String, startedAt: Long) extends Subscription
  case class PausedSubscription(plan: String, pausedAt: Long, resumeAt: Long) extends Subscription
  case class CancelledSubscription(plan: String, cancelledAt: Long, refundAmount: Option[BigDecimal]) extends Subscription

  // TODO: Implement state transitions that enforce business rules
  def activateTrial(trial: TrialSubscription): Either[String, ActiveSubscription] = ???
  def pauseSubscription(active: ActiveSubscription, resumeAt: Long): Either[String, PausedSubscription] = ???
  def cancelSubscription(sub: Subscription): Either[String, CancelledSubscription] = ???

  // ============================================================
  // Exercise 5: Value Objects
  // ============================================================
  // TODO: Implement proper value objects that are compared by value,
  //  are immutable, and encapsulate validation. Value objects have
  //  no identity - two Money(100, USD) are the same.

  case class Currency(code: String, symbol: String, decimals: Int)

  case class Money private (amount: BigDecimal, currency: Currency) {
    def add(other: Money): Either[String, Money] = ???
    def subtract(other: Money): Either[String, Money] = ???
    def multiply(factor: BigDecimal): Money = ???
    def isPositive: Boolean = ???
    def isZero: Boolean = ???
    def formatted: String = ???
  }

  object Money {
    def of(amount: BigDecimal, currency: Currency): Either[String, Money] = ???
    def zero(currency: Currency): Money = ???
  }

  // TODO: Implement DateRange as a value object with validation
  case class DateRange private (start: Long, end: Long) {
    def contains(timestamp: Long): Boolean = ???
    def overlaps(other: DateRange): Boolean = ???
    def durationMillis: Long = ???
  }

  object DateRange {
    def of(start: Long, end: Long): Either[String, DateRange] = ???
  }

  // ============================================================
  // Exercise 6: Entity vs Value Object
  // ============================================================
  // TODO: Design a system that clearly distinguishes entities
  //  (identity-based) from value objects (value-based).
  //  Entities have IDs and lifecycle; value objects are interchangeable.

  // Entity: has identity, mutable lifecycle
  trait Entity[Id] {
    def id: Id
    // Two entities are equal if they have the same ID regardless of other fields
  }

  case class UserId(value: Long) extends AnyVal
  case class User(id: UserId, name: String, email: String) extends Entity[UserId]

  // Value Object: no identity, compared by all fields
  case class Address(
    street: String,
    city: String,
    state: String,
    zipCode: String,
    country: String
  )

  // TODO: Implement an entity equality check that ignores non-ID fields
  def entitiesEqual[Id](e1: Entity[Id], e2: Entity[Id]): Boolean = ???

  // TODO: Design a UserProfile that composes entity + value objects
  case class UserProfile(
    user: User,           // Entity
    homeAddress: Address, // Value Object
    billingAddress: Address // Value Object
  )

  // ============================================================
  // Exercise 7: Aggregate Root Concept
  // ============================================================
  // TODO: Design an aggregate root for an Order that enforces
  //  all invariants. External code can only modify the aggregate
  //  through the root's methods, ensuring consistency.

  case class OrderId(value: Long) extends AnyVal
  case class ProductId(value: Long) extends AnyVal
  case class CustomerId(value: Long) extends AnyVal

  case class OrderLine(productId: ProductId, quantity: Int, unitPrice: BigDecimal) {
    def lineTotal: BigDecimal = ???
  }

  // Aggregate Root: all modifications go through this
  case class OrderAggregate private (
    id: OrderId,
    customerId: CustomerId,
    lines: List[OrderLine],
    status: String,
    createdAt: Long
  ) {
    def addLine(productId: ProductId, quantity: Int, unitPrice: BigDecimal): Either[String, OrderAggregate] = ???
    def removeLine(productId: ProductId): Either[String, OrderAggregate] = ???
    def updateQuantity(productId: ProductId, newQuantity: Int): Either[String, OrderAggregate] = ???
    def submit(): Either[String, OrderAggregate] = ???
    def totalAmount: BigDecimal = ???
  }

  object OrderAggregate {
    def create(id: OrderId, customerId: CustomerId): OrderAggregate = ???
  }

  // ============================================================
  // Exercise 8: Ubiquitous Language in Types
  // ============================================================
  // TODO: Model a banking domain using ubiquitous language.
  //  Types should read like domain expert language.
  //  Non-domain developers should understand the business rules from types alone.

  // Domain vocabulary as types
  sealed trait AccountType
  case object Checking extends AccountType
  case object Savings extends AccountType
  case object Investment extends AccountType

  sealed trait TransactionType
  case object Deposit extends TransactionType
  case object Withdrawal extends TransactionType
  case object Transfer extends TransactionType

  case class AccountNumber private (value: String)
  case class AccountHolder(firstName: String, lastName: String, taxId: String)

  case class BankAccount(
    number: AccountNumber,
    holder: AccountHolder,
    accountType: AccountType,
    balance: Money,
    isActive: Boolean
  )

  sealed trait TransactionResult
  case class TransactionApproved(transactionId: String, newBalance: Money) extends TransactionResult
  case class TransactionDenied(reason: String) extends TransactionResult

  // TODO: Implement domain operations using ubiquitous language
  def openAccount(holder: AccountHolder, accountType: AccountType, initialDeposit: Money): Either[String, BankAccount] = ???
  def deposit(account: BankAccount, amount: Money): Either[String, TransactionResult] = ???
  def withdraw(account: BankAccount, amount: Money): Either[String, TransactionResult] = ???
  def transfer(from: BankAccount, to: BankAccount, amount: Money): Either[String, (TransactionResult, TransactionResult)] = ???

  def main(args: Array[String]): Unit = {
    println("=== Arch002: Domain Modeling ===")
    println()
    println("Exercise 1: Domain Types with Sealed Traits - Order lifecycle")
    println("Exercise 2: Smart Constructors - Validated domain objects")
    println("Exercise 3: Refined Types - Manual refinement system")
    println("Exercise 4: Making Illegal States Unrepresentable - Subscription model")
    println("Exercise 5: Value Objects - Money and DateRange")
    println("Exercise 6: Entity vs Value Object - Identity-based vs value-based")
    println("Exercise 7: Aggregate Root - Order aggregate with invariants")
    println("Exercise 8: Ubiquitous Language - Banking domain types")
  }
}
