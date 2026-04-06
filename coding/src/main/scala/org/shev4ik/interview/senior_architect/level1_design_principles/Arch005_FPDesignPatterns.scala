package org.shev4ik.interview.senior_architect.level1_design_principles

/**
 * FP Design Patterns
 *
 * Senior/Architect focus:
 * - Classic FP patterns and when to apply them
 * - Interpreter, tagless final, free monad
 * - Pattern trade-offs and composition strategies
 */
object Arch005_FPDesignPatterns {

  // ============================================================
  // Exercise 1: Interpreter Pattern
  // ============================================================
  // TODO: Implement the interpreter pattern. Define an AST (algebra)
  //  for a key-value store, then provide different interpreters:
  //  in-memory, logging, combined.

  // The algebra (AST) - describes WHAT to do, not HOW
  sealed trait KVStoreOp[A]
  case class Put(key: String, value: String) extends KVStoreOp[Unit]
  case class Get(key: String) extends KVStoreOp[Option[String]]
  case class Delete(key: String) extends KVStoreOp[Boolean]
  case class Keys(prefix: String) extends KVStoreOp[List[String]]

  // The interpreter - describes HOW to execute operations
  trait KVStoreInterpreter {
    def execute[A](op: KVStoreOp[A]): A
  }

  // TODO: Implement in-memory interpreter
  class InMemoryKVStore extends KVStoreInterpreter {
    private val store = scala.collection.mutable.Map.empty[String, String]
    def execute[A](op: KVStoreOp[A]): A = ???
  }

  // TODO: Implement logging interpreter (decorator)
  class LoggingKVStore(underlying: KVStoreInterpreter) extends KVStoreInterpreter {
    def execute[A](op: KVStoreOp[A]): A = ???
  }

  // ============================================================
  // Exercise 2: Smart Constructor Pattern
  // ============================================================
  // TODO: Implement smart constructors for domain types that
  //  validate invariants at construction. The key insight: once
  //  constructed, the value is GUARANTEED to be valid.

  sealed abstract case class EmailAddress private (value: String)
  object EmailAddress {
    def apply(raw: String): Either[String, EmailAddress] = ???
    // Unsafe version for testing only
    def unsafeFrom(raw: String): EmailAddress = ???
  }

  sealed abstract case class NonNegativeBalance private (amount: BigDecimal)
  object NonNegativeBalance {
    def apply(amount: BigDecimal): Either[String, NonNegativeBalance] = ???
    def zero: NonNegativeBalance = ???

    // TODO: Implement safe arithmetic that maintains the invariant
    def add(a: NonNegativeBalance, b: NonNegativeBalance): NonNegativeBalance = ???
    def subtract(a: NonNegativeBalance, b: NonNegativeBalance): Either[String, NonNegativeBalance] = ???
  }

  sealed abstract case class Bounded private (value: Int, min: Int, max: Int)
  object Bounded {
    def apply(value: Int, min: Int, max: Int): Either[String, Bounded] = ???
  }

  // ============================================================
  // Exercise 3: Type Class Pattern
  // ============================================================
  // TODO: Implement a type class for JSON serialization. Type classes
  //  provide ad-hoc polymorphism - adding behavior to types without
  //  modifying them. Include automatic derivation for case classes.

  trait JsonEncoder[A] {
    def encode(a: A): JsonValue
  }

  trait JsonDecoder[A] {
    def decode(json: JsonValue): Either[String, A]
  }

  sealed trait JsonValue
  case class JsonString(value: String) extends JsonValue
  case class JsonNumber(value: BigDecimal) extends JsonValue
  case class JsonBool(value: Boolean) extends JsonValue
  case class JsonArray(values: List[JsonValue]) extends JsonValue
  case class JsonObject(fields: Map[String, JsonValue]) extends JsonValue
  case object JsonNull extends JsonValue

  object JsonEncoder {
    def apply[A](implicit enc: JsonEncoder[A]): JsonEncoder[A] = enc

    // TODO: Provide instances for primitives
    implicit val stringEncoder: JsonEncoder[String] = ???
    implicit val intEncoder: JsonEncoder[Int] = ???
    implicit val boolEncoder: JsonEncoder[Boolean] = ???
    implicit def listEncoder[A: JsonEncoder]: JsonEncoder[List[A]] = ???
    implicit def optionEncoder[A: JsonEncoder]: JsonEncoder[Option[A]] = ???
  }

  // TODO: Implement encoder for a domain type using the type class
  case class Product(name: String, price: Int, inStock: Boolean)
  implicit val productEncoder: JsonEncoder[Product] = ???

  // Syntax extension
  implicit class JsonEncoderOps[A](val a: A) extends AnyVal {
    def toJson(implicit enc: JsonEncoder[A]): JsonValue = ???
  }

  // ============================================================
  // Exercise 4: Newtype Pattern (FP-style)
  // ============================================================
  // TODO: Implement a zero-cost newtype wrapper that prevents
  //  accidental value mixing while having no runtime overhead.

  // Newtype base
  trait NewtypeBase {
    type Base
    trait Tag
    type Type = Base with Tag

    def wrap(base: Base): Type = base.asInstanceOf[Type]
    def unwrap(typed: Type): Base = typed.asInstanceOf[Base]
  }

  // TODO: Define newtypes for domain concepts
  object UsernameNT extends NewtypeBase { type Base = String }
  object PasswordHash extends NewtypeBase { type Base = String }
  object SessionToken extends NewtypeBase { type Base = String }

  // TODO: Use newtypes to make function signatures self-documenting
  def authenticate(
    username: UsernameNT.Type,
    passwordHash: PasswordHash.Type
  ): Either[String, SessionToken.Type] = ???

  // ============================================================
  // Exercise 5: Phantom Type Pattern
  // ============================================================
  // TODO: Use phantom types to encode protocols and state machines
  //  in the type system. A database connection that must be opened
  //  before queries, and closed after use.

  sealed trait ConnectionState
  sealed trait Disconnected extends ConnectionState
  sealed trait Connected extends ConnectionState
  sealed trait InTransaction extends ConnectionState

  case class DBConnection[S <: ConnectionState] private (url: String)

  object DBConnection {
    def create(url: String): DBConnection[Disconnected] = ???
    def connect(conn: DBConnection[Disconnected]): Either[String, DBConnection[Connected]] = ???
    def beginTransaction(conn: DBConnection[Connected]): DBConnection[InTransaction] = ???
    def commitTransaction(conn: DBConnection[InTransaction]): DBConnection[Connected] = ???
    def rollbackTransaction(conn: DBConnection[InTransaction]): DBConnection[Connected] = ???
    def disconnect(conn: DBConnection[Connected]): DBConnection[Disconnected] = ???

    // TODO: query is only available on Connected or InTransaction
    def query[S <: ConnectionState](conn: DBConnection[S], sql: String)(
      implicit ev: S <:< Connected
    ): Either[String, List[Map[String, String]]] = ???
  }

  // ============================================================
  // Exercise 6: Tagless Final Pattern
  // ============================================================
  // TODO: Implement the tagless final pattern for a logging DSL.
  //  The program is polymorphic in the effect type F[_].
  //  Different interpreters choose different F (Id, Either, Future, ZIO).

  // The algebra expressed as a trait parameterized by F[_]
  trait LoggingAlgebra[F[_]] {
    def info(message: String): F[Unit]
    def warn(message: String): F[Unit]
    def error(message: String, cause: Option[Throwable]): F[Unit]
    def withContext(key: String, value: String): F[Unit]
  }

  // TODO: Implement interpreter for simple Id effect (synchronous)
  type Id[A] = A

  class ConsoleLogger extends LoggingAlgebra[Id] {
    def info(message: String): Id[Unit] = ???
    def warn(message: String): Id[Unit] = ???
    def error(message: String, cause: Option[Throwable]): Id[Unit] = ???
    def withContext(key: String, value: String): Id[Unit] = ???
  }

  // TODO: Write a program that is polymorphic in F
  def program[F[_]](logger: LoggingAlgebra[F]): F[Unit] = ???

  // ============================================================
  // Exercise 7: Free Monad Pattern (Simplified)
  // ============================================================
  // TODO: Implement a simplified free monad to separate program
  //  description from interpretation. This enables testing,
  //  optimization, and different execution strategies.

  // Simplified Free monad
  sealed trait Free[F[_], A] {
    def flatMap[B](f: A => Free[F, B]): Free[F, B] = FlatMap(this, f)
    def map[B](f: A => B): Free[F, B] = flatMap(a => Pure(f(a)))
  }

  case class Pure[F[_], A](a: A) extends Free[F, A]
  case class Suspend[F[_], A](fa: F[A]) extends Free[F, A]
  case class FlatMap[F[_], A, B](sub: Free[F, A], f: A => Free[F, B]) extends Free[F, B]

  // TODO: Define a DSL using Free
  sealed trait ConsoleOp[A]
  case class PrintLine(msg: String) extends ConsoleOp[Unit]
  case object ReadLine extends ConsoleOp[String]

  type Console[A] = Free[ConsoleOp, A]

  def printLine(msg: String): Console[Unit] = ???
  def readLine: Console[String] = ???

  // TODO: Write a program using the Free DSL
  val consoleProgram: Console[String] = ???

  // TODO: Implement an interpreter
  trait NaturalTransformation[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // ============================================================
  // Exercise 8: MTL Pattern (Monad Transformer Library)
  // ============================================================
  // TODO: Implement the MTL pattern - define capabilities as
  //  type classes rather than stacking monad transformers.

  // Capability type classes
  trait MonadError[F[_], E] {
    def raiseError[A](e: E): F[A]
    def handleError[A](fa: F[A])(f: E => F[A]): F[A]
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
  }

  trait HasLogger[F[_]] {
    def log(level: String, message: String): F[Unit]
  }

  trait HasConfig[F[_]] {
    def getConfig(key: String): F[Option[String]]
  }

  // TODO: Write a program using MTL-style constraints
  // The program requests capabilities via implicit evidence
  def mtlProgram[F[_]](implicit
    ME: MonadError[F, String],
    L: HasLogger[F],
    C: HasConfig[F]
  ): F[String] = ???

  def main(args: Array[String]): Unit = {
    println("=== Arch005: FP Design Patterns ===")
    println()
    println("Exercise 1: Interpreter Pattern")
    println("Exercise 2: Smart Constructor Pattern")
    println("Exercise 3: Type Class Pattern")
    println("Exercise 4: Newtype Pattern")
    println("Exercise 5: Phantom Type Pattern")
    println("Exercise 6: Tagless Final Pattern")
    println("Exercise 7: Free Monad Pattern")
    println("Exercise 8: MTL Pattern")
  }
}
