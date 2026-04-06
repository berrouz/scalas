package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * Type-Driven Design in Scala
 *
 * Senior/Architect focus:
 * - Using the type system to encode business rules
 * - Phantom types, tagged types, opaque types
 * - Making the compiler enforce domain invariants
 */
object Arch004_TypeDrivenDesign {

  // ============================================================
  // Exercise 1: Phantom Types for State Machine
  // ============================================================
  // TODO: Use phantom types to enforce a state machine at compile time.
  //  A Door can be Open or Closed. You can only close an open door
  //  and open a closed door. The compiler should reject invalid transitions.

  sealed trait DoorState
  sealed trait Open extends DoorState
  sealed trait Closed extends DoorState
  sealed trait Locked extends DoorState

  case class Door[S <: DoorState] private (id: String) {
    // These should only compile for the correct state
  }

  object Door {
    def create(id: String): Door[Closed] = ???

    // TODO: Implement type-safe transitions
    def open(door: Door[Closed]): Door[Open] = ???
    def close(door: Door[Open]): Door[Closed] = ???
    def lock(door: Door[Closed]): Door[Locked] = ???
    def unlock(door: Door[Locked]): Door[Closed] = ???

    // This should NOT compile: door.open(door: Door[Open])
    // This should NOT compile: door.lock(door: Door[Open])
  }

  // TODO: Apply phantom types to a more complex workflow
  sealed trait WorkflowState
  sealed trait Created extends WorkflowState
  sealed trait Reviewed extends WorkflowState
  sealed trait Approved extends WorkflowState
  sealed trait Published extends WorkflowState

  case class Document[S <: WorkflowState] private (title: String, content: String)

  object Document {
    def create(title: String, content: String): Document[Created] = ???
    def review(doc: Document[Created]): Document[Reviewed] = ???
    def approve(doc: Document[Reviewed]): Document[Approved] = ???
    def publish(doc: Document[Approved]): Document[Published] = ???
    // Cannot skip steps - enforced by types
  }

  // ============================================================
  // Exercise 2: Tagged Types for Type Safety
  // ============================================================
  // TODO: Use tagged types to prevent mixing up values of the same
  //  underlying type. UserId and OrderId are both Longs but should
  //  not be interchangeable.

  // Simple tag implementation
  trait Tag[+T]
  type @@[A, T] = A with Tag[T]

  object Tag {
    def apply[A, T](a: A): A @@ T = a.asInstanceOf[A @@ T]
  }

  // Define domain-specific tagged types
  sealed trait UserIdTag
  sealed trait OrderIdTag
  sealed trait ProductIdTag
  sealed trait AmountTag

  type UserId = Long @@ UserIdTag
  type OrderId = Long @@ OrderIdTag
  type ProductId = Long @@ ProductIdTag

  // TODO: Implement functions that accept only correctly tagged values
  def findUser(userId: UserId): Option[String] = ???
  def findOrder(orderId: OrderId): Option[String] = ???
  // findUser(orderId) should not compile!

  // TODO: Create tagged type constructors
  def userId(id: Long): UserId = ???
  def orderId(id: Long): OrderId = ???
  def productId(id: Long): ProductId = ???

  // ============================================================
  // Exercise 3: Type-Level Validation
  // ============================================================
  // TODO: Encode validation rules in the type system so that
  //  validated data carries proof of validation in its type.

  sealed trait Unvalidated
  sealed trait Validated

  case class FormData[V](
    name: String,
    email: String,
    age: Int
  )

  // TODO: Implement validation that transforms Unvalidated to Validated
  def validateForm(data: FormData[Unvalidated]): Either[List[String], FormData[Validated]] = ???

  // This function only accepts validated data
  def processForm(data: FormData[Validated]): String = ???

  // TODO: Apply this pattern to API request processing
  case class ApiRequest[V](
    body: String,
    headers: Map[String, String]
  )

  def validateRequest(req: ApiRequest[Unvalidated]): Either[List[String], ApiRequest[Validated]] = ???
  def handleRequest(req: ApiRequest[Validated]): String = ???

  // ============================================================
  // Exercise 4: Newtype Pattern
  // ============================================================
  // TODO: Implement the newtype pattern for zero-cost type safety.
  //  Newtypes wrap a single value but are distinct types at compile time,
  //  with zero runtime overhead.

  // Newtype implementation
  abstract class Newtype[A] {
    type Type
    def apply(a: A): Type
    def unwrap(t: Type): A

    // TODO: Implement map operation
    def map(t: Type)(f: A => A): Type = ???
  }

  // TODO: Create newtypes for domain concepts
  object Username extends Newtype[String] {
    type Type = String
    def apply(a: String): Type = ???
    def unwrap(t: Type): String = ???
  }

  object Port extends Newtype[Int] {
    type Type = Int
    def apply(a: Int): Type = ???
    def unwrap(t: Type): Int = ???
  }

  object Hostname extends Newtype[String] {
    type Type = String
    def apply(a: String): Type = ???
    def unwrap(t: Type): String = ???
  }

  // TODO: Use newtypes in a configuration case class
  case class ServerConfig(
    host: Hostname.Type,
    port: Port.Type,
    adminUser: Username.Type
  )

  // ============================================================
  // Exercise 5: Opaque Types Concept
  // ============================================================
  // TODO: Design opaque types (Scala 3 concept, simulate in Scala 2).
  //  Opaque types are invisible outside their definition scope,
  //  providing abstraction with zero runtime cost.

  // Simulating opaque types in Scala 2 using abstract type members
  trait OpaqueCompanion[Underlying] {
    type T
    protected def wrap(u: Underlying): T
    protected def unwrap(t: T): Underlying

    // Public smart constructor
    def make(u: Underlying): Either[String, T]
    def value(t: T): Underlying
  }

  // TODO: Implement opaque Temperature type
  object Temperature extends OpaqueCompanion[Double] {
    type T = Double
    protected def wrap(u: Double): T = ???
    protected def unwrap(t: T): Double = ???

    def make(u: Double): Either[String, T] = ???  // Must be > absolute zero
    def value(t: T): Double = ???

    // Domain operations only available through the companion
    def celsiusToFahrenheit(t: T): T = ???
    def fahrenheitToCelsius(t: T): T = ???
  }

  // ============================================================
  // Exercise 6: Type-Safe Builder
  // ============================================================
  // TODO: Implement a type-safe builder pattern where the build()
  //  method is only available after all required fields are set.
  //  Use phantom types to track which fields have been set.

  sealed trait HasName
  sealed trait HasEmail
  sealed trait HasAge
  sealed trait Missing

  case class UserBuilder[N, E, A] private (
    name: Option[String],
    email: Option[String],
    age: Option[Int]
  ) {
    def withName(name: String): UserBuilder[HasName, E, A] = ???
    def withEmail(email: String): UserBuilder[N, HasEmail, A] = ???
    def withAge(age: Int): UserBuilder[N, E, HasAge] = ???
  }

  object UserBuilder {
    def apply(): UserBuilder[Missing, Missing, Missing] = ???

    // build() is only available when all fields are HasXxx
    implicit class BuildOps(builder: UserBuilder[HasName, HasEmail, HasAge]) {
      def build(): UserRecord = ???
    }
  }

  case class UserRecord(name: String, email: String, age: Int)

  // ============================================================
  // Exercise 7: Type-Safe ID System
  // ============================================================
  // TODO: Design a type-safe ID system that prevents mixing up IDs
  //  across different entity types, with support for different
  //  ID formats (UUID, Long, String).

  trait EntityId[E] {
    type IdType
    def value: IdType
    def asString: String
  }

  // TODO: Implement typed IDs for different entities
  case class TypedId[E, I](rawValue: I) extends EntityId[E] {
    type IdType = I
    def value: IdType = ???
    def asString: String = ???
  }

  // Entity type markers
  sealed trait UserEntity
  sealed trait OrderEntity
  sealed trait InvoiceEntity

  // TODO: Create ID factories
  object EntityId {
    def userId(id: Long): TypedId[UserEntity, Long] = ???
    def orderId(id: String): TypedId[OrderEntity, String] = ???
    def invoiceId(id: String): TypedId[InvoiceEntity, String] = ???
  }

  // TODO: Function that only accepts the correct entity ID type
  def lookupUser(id: TypedId[UserEntity, Long]): Option[String] = ???
  def lookupOrder(id: TypedId[OrderEntity, String]): Option[String] = ???

  // ============================================================
  // Exercise 8: Type-Safe Currency Operations
  // ============================================================
  // TODO: Design a type-safe currency system where operations
  //  between different currencies are caught at compile time.
  //  Currency conversion must be explicit.

  sealed trait CurrencyType
  sealed trait USD extends CurrencyType
  sealed trait EUR extends CurrencyType
  sealed trait GBP extends CurrencyType

  case class TypedMoney[C <: CurrencyType] private (cents: Long) {
    def +(other: TypedMoney[C]): TypedMoney[C] = ???
    def -(other: TypedMoney[C]): TypedMoney[C] = ???
    def *(factor: BigDecimal): TypedMoney[C] = ???
    def isPositive: Boolean = ???
    def formatted: String = ???
  }

  object TypedMoney {
    def usd(dollars: BigDecimal): TypedMoney[USD] = ???
    def eur(euros: BigDecimal): TypedMoney[EUR] = ???
    def gbp(pounds: BigDecimal): TypedMoney[GBP] = ???
  }

  // Explicit conversion with exchange rate
  trait ExchangeRate[From <: CurrencyType, To <: CurrencyType] {
    def rate: BigDecimal
    def convert(amount: TypedMoney[From]): TypedMoney[To] = ???
  }

  // TODO: Implement exchange rates
  implicit val usdToEur: ExchangeRate[USD, EUR] = ???
  implicit val eurToUsd: ExchangeRate[EUR, USD] = ???

  // This compiles: usd + usd
  // This does NOT compile: usd + eur (must convert first)
  def convertAndAdd[From <: CurrencyType, To <: CurrencyType](
    amount: TypedMoney[From],
    target: TypedMoney[To]
  )(implicit rate: ExchangeRate[From, To]): TypedMoney[To] = ???

  def main(args: Array[String]): Unit = {
    println("=== Arch004: Type-Driven Design ===")
    println()
    println("Exercise 1: Phantom Types for State Machine")
    println("Exercise 2: Tagged Types for Type Safety")
    println("Exercise 3: Type-Level Validation")
    println("Exercise 4: Newtype Pattern")
    println("Exercise 5: Opaque Types Concept")
    println("Exercise 6: Type-Safe Builder")
    println("Exercise 7: Type-Safe ID System")
    println("Exercise 8: Type-Safe Currency Operations")
  }
}
