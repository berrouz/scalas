# Scala Interview Preparation Guide (USA)

Complete guide to preparing for Scala developer interviews in the United States.

## Table of Contents
1. [Interview Structure in USA](#-interview-structure-in-usa)
2. [Exercise Files Reference](#-exercise-files-reference) — 596 runnable exercises
3. [Scala Core Questions](#-scala-core-questions) — Option, case classes, implicits, Future vs IO
4. [Collections & Operations](#-collections--operations) — map/flatMap/fold, performance
5. [Functional Programming](#-functional-programming) — purity, HOFs, currying, pattern matching
6. [Error Handling Patterns](#%EF%B8%8F-error-handling-patterns) — Try/Either/Validated
7. [Type System](#-type-system) — variance, type bounds, type classes
8. [Monads & Applicatives](#-monads--applicatives) — laws, Either vs Validated
9. [Cats / Cats Effect](#-cats--cats-effect-questions) — Functor, IO, Resource, Fiber
10. [ZIO](#-zio-questions) — ZLayer, typed errors, concurrency, Schedule
11. [Streams & FS2](#-streams--fs2) — streaming, backpressure, comparison
12. [Database Access](#-database-access-patterns) — Doobie vs Slick, ConnectionIO
13. [Coding Tasks](#-coding-tasks) — implement map/flatMap/IO/traverse
14. [System Design](#-system-design) — framework, URL shortener example
15. [Behavioral Questions](#-behavioral-questions-star-format) — STAR method
16. [Testing](#-testing-in-scala) — ScalaTest, property-based, ZIO Test
17. [Resources](#-preparation-resources) — books, courses, practice
18. [Pre-Interview Checklist](#-pre-interview-checklist)
19. [Salary Negotiation](#-salary-negotiation-tips)

---

## 📋 Interview Structure in USA

### Round 1: Phone Screen (30-45 min)
- Background questions about your experience
- Basic Scala questions
- Why Scala? Why this company?
- Salary expectations (often asked early)

### Round 2: Technical Screen (60-90 min)
- Live coding (CoderPad, HackerRank, Codility)
- Medium-difficulty algorithms
- Scala/FP questions
- Sometimes a brief system design discussion

### Round 3-5: Onsite / Virtual Onsite (4-6 hours)
- **System Design** (45-60 min)
- **Coding Round 1** (45-60 min) — algorithms
- **Coding Round 2** (45-60 min) — practical/domain-specific
- **Behavioral** (45-60 min)
- **Team Fit / Culture** (30-45 min)
- Sometimes: **Deep Dive** into past projects

---

## 🗂 Exercise Files Reference

This guide is complemented by **596 runnable exercise files** in the `coding/` subproject, organized by topic and difficulty level. Each file contains 8 exercises with tests.

| Topic | Path | Files | Levels |
|-------|------|-------|--------|
| **Scala Core** | `interview/scala_core/` | 58 | beginner → expert |
| **Algorithms** | `interview/algorithms/` | 73 | fundamentals → expert |
| **ZIO** | `interview/zio/` | 127 | basics → expert |
| **Cats** | `interview/cats/` | 20+ | basics → expert |
| **Concurrency** | `interview/concurrency/` | 15+ | basics → advanced |
| **FS2** | `interview/fs2/` | 15+ | basics → advanced |
| **Http4s** | `interview/http4s/` | 15 | basics → advanced |
| **Doobie** | `interview/doobie/` | 15 | basics → advanced |
| **Kafka** | `interview/kafka/` | 15 | basics → advanced |
| **Akka** | `interview/akka/` | 18 | basics → advanced |
| **SQL** | `interview/sql/` | 13 | basics → advanced |
| **System Design** | `interview/system_design/` | 11 | fundamentals → advanced |
| **Docker/K8s** | `interview/docker_k8s/` | 10 | basics → intermediate |
| **gRPC** | `interview/grpc/` | 10+ | basics → intermediate |
| **Scala 3** | `interview/scala3/` | 10+ | basics → advanced |
| **Testing** | `interview/testing/` | 10+ | basics → advanced |
| **Advanced FP** | `interview/advanced_fp/` | 38 | foundations → theory |
| **LeetCode** | `leetcode/scala/` | 28 | Scala solutions to top problems |

Run any exercise: `sbt "coding/runMain org.shev4ik.interview.zio.level1_basics.Zio001_Succeed"`

---

## 🎯 Scala Core Questions

### Basic Questions (Junior/Mid)

#### Option vs null
```scala
// Why is Option better?
// 1. Compile-time safety — compiler forces you to handle absence
// 2. Explicitly shows that a value might be missing
// 3. Composable — you can chain operations

val maybeUser: Option[User] = findUser(id)

// Bad
val user = maybeUser.get  // can throw NoSuchElementException

// Good
maybeUser match {
  case Some(user) => process(user)
  case None => handleMissing()
}

// Even better
maybeUser
  .map(_.name)
  .getOrElse("Unknown")
```

#### Case Classes
```scala
// What does case class provide?
case class User(name: String, age: Int)

// 1. Automatic equals and hashCode (based on all fields)
// 2. Automatic toString
// 3. copy method for immutable updates
// 4. Pattern matching support
// 5. Companion object with apply/unapply
// 6. Serializable by default
// 7. Product trait (productArity, productElement)

val user = User("John", 30)
val older = user.copy(age = 31)

user match {
  case User(name, age) if age >= 18 => s"Adult: $name"
  case User(name, _) => s"Minor: $name"
}
```

#### Sealed Traits
```scala
// Why use sealed?
sealed trait PaymentStatus
case object Pending extends PaymentStatus
case object Completed extends PaymentStatus
case object Failed extends PaymentStatus

// 1. Exhaustive pattern matching — compiler warns if you miss a case
// 2. All subclasses must be defined in the same file
// 3. Enables ADT (Algebraic Data Types)

def process(status: PaymentStatus): String = status match {
  case Pending => "Waiting..."
  case Completed => "Done!"
  // Warning: match may not be exhaustive. Missing: Failed
}
```

#### val vs var vs def vs lazy val
```scala
val x = expensive()      // evaluated once, immediately
var y = 1                // mutable, evaluated once
def z = expensive()      // evaluated every time called
lazy val w = expensive() // evaluated once, on first access

// When to use lazy val?
// 1. Expensive initialization that might not be needed
// 2. Circular dependencies
// 3. Initialization order issues
```

#### Implicit Conversions vs Implicit Parameters
```scala
// Implicit conversion (extension methods) — Scala 2
implicit class RichInt(val n: Int) extends AnyVal {
  def times(f: => Unit): Unit = (1 to n).foreach(_ => f)
}
3.times(println("Hi"))

// Scala 3 extension methods
extension (n: Int)
  def times(f: => Unit): Unit = (1 to n).foreach(_ => f)

// Implicit parameters (dependency injection)
def greet(name: String)(implicit lang: Language): String =
  lang.greeting(name)

implicit val english: Language = English
greet("John")  // uses english implicitly

// Scala 3: using/given
def greet(name: String)(using lang: Language): String =
  lang.greeting(name)

given Language = English
```

#### Companion Objects
```scala
// Why do we need them?
private class User(val name: String, val age: Int)

object User {
  // 1. Factory methods
  def apply(name: String, age: Int): Option[User] =
    if (age >= 0) Some(new User(name, age)) else None

  // 2. Unapply for pattern matching
  def unapply(user: User): Option[(String, Int)] =
    Some((user.name, user.age))

  // 3. Static-like methods
  def defaultUser: User = new User("Anonymous", 0)

  // 4. Implicit instances
  implicit val ordering: Ordering[User] =
    Ordering.by(_.name)
}
```

#### Traits vs Abstract Classes
```scala
// When to use which?

// Trait — use by default
// 1. Can mix in multiple traits (multiple inheritance)
// 2. No constructor parameters (Scala 2); Scala 3 allows trait parameters
// 3. Preferred for defining interfaces and mixins

trait Loggable {
  def log(msg: String): Unit = println(s"[LOG] $msg")
}

trait Serializable {
  def serialize: String
}

class Service extends Loggable with Serializable {
  def serialize: String = "..."
}

// Abstract class — use when:
// 1. Need constructor parameters (Scala 2)
// 2. Need to be called from Java
// 3. Need to initialize state in constructor

abstract class Animal(val name: String) {
  def sound: String  // abstract
  def greet: String = s"I'm $name"  // concrete
}
```

#### Implicit Resolution Rules (Critical for Interviews)
```scala
// Scala compiler searches for implicits in this order:
// 1. Current scope — local/imported implicits
// 2. Associated types — companion objects of the types involved

// Step 1: Local scope (highest priority)
implicit val localOrdering: Ordering[Int] = Ordering.Int.reverse
List(3, 1, 2).sorted  // uses localOrdering → List(3, 2, 1)

// Step 2: Imported scope
import MyImplicits._

// Step 3: Companion objects of involved types
case class Money(amount: Double)
object Money {
  implicit val ordering: Ordering[Money] = Ordering.by(_.amount)
}
List(Money(3), Money(1)).sorted  // finds ordering in Money companion

// Common gotcha: ambiguous implicits
// If two implicits of the same type are in scope → compile error
// Fix: make one more specific (subtype wins over supertype)
```

#### For-Comprehension Desugaring (Frequently Asked)
```scala
// for-comprehension is syntactic sugar for flatMap/map/filter/foreach

// This:
for {
  x <- List(1, 2, 3)
  if x > 1
  y <- List("a", "b")
} yield s"$x$y"

// Desugars to:
List(1, 2, 3)
  .withFilter(_ > 1)          // not filter! withFilter is lazy
  .flatMap(x =>
    List("a", "b").map(y => s"$x$y")
  )
// Result: List("2a", "2b", "3a", "3b")

// Without yield → foreach:
for { x <- List(1, 2, 3) } println(x)
// Desugars to:
List(1, 2, 3).foreach(println)

// Key insight: for-comprehension works with ANY type that has
// flatMap/map/withFilter — not just collections!
// That's why it works with Option, Future, IO, ZIO, etc.
```

#### Future vs IO/ZIO (Very Common Question)
```scala
// Future — eager, memoized, impure
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val future = Future { println("side effect!") } // prints IMMEDIATELY
// future is already running — you can't control when it starts
// Referential transparency is broken:
val f1 = Future(42)
val f2 = Future(42)
// f1 and f2 are TWO independent computations, not the same value

// IO/ZIO — lazy, composable, pure DESCRIPTION of computation
import zio._
val zio = ZIO.attempt { println("side effect!") } // prints NOTHING
// zio is just a data structure describing what to do
// It only executes when you run it (unsafeRun/provide)
// Referential transparency preserved:
val z1 = ZIO.succeed(42)
val z2 = z1  // z2 IS z1 — same description, identical behavior

// Interview answer framework:
// Future: eager execution, error handling via recover/recoverWith,
//         requires ExecutionContext everywhere, hard to test
// IO/ZIO: lazy description, typed errors, structured concurrency,
//         resource safety, testable, composable
```

---

## 🔄 Collections & Operations

### map vs flatMap vs for-comprehension
```scala
val numbers = List(1, 2, 3)

// map: A => B (one value to one value)
numbers.map(_ * 2)  // List(2, 4, 6)

// flatMap: A => F[B] (one value to collection, then flatten)
numbers.flatMap(n => List(n, n * 10))  // List(1, 10, 2, 20, 3, 30)

// for-comprehension — syntactic sugar for flatMap/map
for {
  x <- List(1, 2)
  y <- List("a", "b")
} yield s"$x$y"
// Equivalent to:
List(1, 2).flatMap(x => List("a", "b").map(y => s"$x$y"))
// Result: List("1a", "1b", "2a", "2b")
```

### fold vs reduce vs aggregate
```scala
val nums = List(1, 2, 3, 4)

// reduce — requires non-empty collection, type cannot change
nums.reduce(_ + _)  // 10
// List().reduce(_ + _)  // Exception!

// fold — has initial value, can change type
nums.fold(0)(_ + _)  // 10
nums.fold("")(_ + _.toString)  // "1234"
List.empty[Int].fold(0)(_ + _)  // 0 (no exception)

// foldLeft vs foldRight
nums.foldLeft(0)(_ - _)   // ((((0-1)-2)-3)-4) = -10
nums.foldRight(0)(_ - _)  // (1-(2-(3-(4-0)))) = -2

// aggregate — for parallel collections
nums.par.aggregate(0)(
  (acc, n) => acc + n,    // seqop: combine within partition
  (acc1, acc2) => acc1 + acc2  // combop: combine partitions
)
```

### Collection Performance
```scala
// List — prepend O(1), append O(n), access O(n)
val list = 1 :: 2 :: 3 :: Nil
0 :: list  // O(1)
list :+ 4  // O(n) — avoid!

// Vector — effectively O(1) for all operations (log32)
val vec = Vector(1, 2, 3)
vec :+ 4   // O(~1)
vec(100)   // O(~1)

// Set — contains O(1) for HashSet, O(log n) for TreeSet
// Map — same as Set

// When to use which?
// List: small collections, pattern matching, prepend-heavy
// Vector: random access, append/prepend, large collections
// Set: uniqueness, membership testing
// Map: key-value lookup
```

---

## 🧮 Functional Programming

### Referential Transparency
```scala
// Expression is referentially transparent if it can be
// replaced with its value without changing program behavior

// RT example:
val x = 2 + 3
val y = x + x  // can replace with (2+3) + (2+3)

// NOT RT:
var counter = 0
def increment(): Int = { counter += 1; counter }
val a = increment()  // 1
val b = increment()  // 2 — different result!
// Cannot replace increment() with its "value"
```

### Pure Functions
```scala
// Pure function:
// 1. Deterministic — same input → same output
// 2. No side effects — no I/O, no mutation

// Pure:
def add(a: Int, b: Int): Int = a + b
def length(s: String): Int = s.length

// Impure:
def now(): Long = System.currentTimeMillis()  // not deterministic
def println(s: String): Unit = ???  // side effect (I/O)
def addToList(list: mutable.List[Int], x: Int): Unit = list += x  // mutation
```

### Higher-Order Functions
```scala
// Function that takes function as parameter or returns function

// Takes function:
def applyTwice[A](f: A => A)(x: A): A = f(f(x))
applyTwice((x: Int) => x + 1)(5)  // 7

// Returns function:
def multiplier(factor: Int): Int => Int =
  (x: Int) => x * factor

val double = multiplier(2)
double(5)  // 10

// Both:
def compose[A, B, C](f: B => C)(g: A => B): A => C =
  (a: A) => f(g(a))
```

### Currying vs Partial Application
```scala
// Currying — converting f(a, b) to f(a)(b)
def add(a: Int, b: Int): Int = a + b
def addCurried(a: Int)(b: Int): Int = a + b

val addCurriedManual: Int => Int => Int = a => b => a + b

// Partial Application — fixing some arguments
val add5 = add(5, _: Int)  // Int => Int
add5(3)  // 8

val add5Curried = addCurried(5)  // Int => Int
add5Curried(3)  // 8

// Use cases:
// - Dependency injection
// - Creating specialized functions
// - Working with higher-order functions
List(1, 2, 3).map(addCurried(10))  // List(11, 12, 13)
```

### Pattern Matching — Advanced
```scala
// Guards
list match {
  case x :: _ if x > 0 => "positive head"
  case _ => "other"
}

// Type patterns
def describe(x: Any): String = x match {
  case i: Int => s"int: $i"
  case s: String => s"string: $s"
  case list: List[_] => s"list of ${list.size}"  // type erasure!
  case _ => "unknown"
}

// Extractors (unapply)
object Email {
  def unapply(s: String): Option[(String, String)] = {
    val parts = s.split("@")
    if (parts.length == 2) Some((parts(0), parts(1))) else None
  }
}

"user@domain.com" match {
  case Email(user, domain) => s"User: $user, Domain: $domain"
}

// @ binding
list match {
  case head :: (tail @ _ :: _) => s"$head and tail with ${tail.size} elements"
  case _ => "short list"
}
```

---

## ⚠️ Error Handling Patterns

### The Scala Error Handling Spectrum
```scala
// From worst to best:

// 1. null — NEVER use in Scala
val user: User = null  // compiles, but NullPointerException waiting to happen

// 2. Exceptions — only for truly exceptional situations
throw new RuntimeException("bug!")  // breaks referential transparency

// 3. Try — wraps exceptions into values
import scala.util.{Try, Success, Failure}
val result: Try[Int] = Try(Integer.parseInt("abc"))
result match {
  case Success(n) => println(n)
  case Failure(e) => println(e.getMessage)
}
// Use when: interfacing with Java code that throws

// 4. Option — value present or absent (no error info)
val user: Option[User] = findById(id)
// Use when: absence is normal, not an error

// 5. Either — success or typed error
val result: Either[AppError, User] = validateAndCreate(input)
// Use when: you need error information, Scala 2.12+ (right-biased)

// 6. IO/ZIO with typed errors — the gold standard
val result: ZIO[Any, AppError, User] = validate(input)
// Use when: effectful code with typed error channel
```

### Either Chaining Pattern
```scala
// Either is right-biased since Scala 2.12 — works in for-comprehensions
sealed trait AppError
case class NotFound(id: String) extends AppError
case class InvalidInput(msg: String) extends AppError

def findUser(id: String): Either[AppError, User] = ???
def validateAge(user: User): Either[AppError, User] = ???

// Fail-fast composition
val result: Either[AppError, User] = for {
  user <- findUser("123")
  validated <- validateAge(user)
} yield validated

// Convert to HTTP response
result match {
  case Right(user) => Ok(user.toJson)
  case Left(NotFound(id)) => NotFound(s"User $id not found")
  case Left(InvalidInput(msg)) => BadRequest(msg)
}
```

---

## 🔷 Type System

### Variance
```scala
// Covariance (+A): if B <: A, then F[B] <: F[A]
// "Producer" — outputs A
trait Producer[+A] {
  def produce: A
}
// List[Dog] <: List[Animal] ✓

// Contravariance (-A): if B <: A, then F[A] <: F[B]
// "Consumer" — inputs A
trait Consumer[-A] {
  def consume(a: A): Unit
}
// Consumer[Animal] <: Consumer[Dog] ✓

// Invariance (A): no subtyping relationship
// Both produces and consumes
trait Processor[A] {
  def process(a: A): A
}

// Function variance: Function1[-A, +B]
// Contravariant in input, covariant in output
val f: Animal => String = (a: Animal) => a.name
val g: Dog => String = f  // ✓ contravariance in input
```

### Type Bounds
```scala
// Upper bound (<:) — must be subtype
def process[A <: Animal](a: A): String = a.name

// Lower bound (>:) — must be supertype
def add[A >: Dog](list: List[A], a: A): List[A] = a :: list

// View bound (<%:) — deprecated, use context bound
// Context bound — requires implicit evidence
def sort[A: Ordering](list: List[A]): List[A] = list.sorted

// Multiple bounds
def foo[A <: Animal with Serializable : Ordering](a: A) = ???
```

### Type Classes
```scala
// 1. Define type class
trait Show[A] {
  def show(a: A): String
}

// 2. Define instances
object Show {
  implicit val intShow: Show[Int] = (a: Int) => a.toString
  implicit val stringShow: Show[String] = (a: String) => s"'$a'"

  // Instance for any List
  implicit def listShow[A](implicit s: Show[A]): Show[List[A]] =
    (list: List[A]) => list.map(s.show).mkString("[", ", ", "]")
}

// 3. Use with context bound
def display[A: Show](a: A): String = implicitly[Show[A]].show(a)

// Or extension method
implicit class ShowOps[A: Show](a: A) {
  def show: String = implicitly[Show[A]].show(a)
}

42.show        // "42"
"hello".show   // "'hello'"
List(1, 2).show  // "[1, 2]"
```

---

## 🌊 Monads & Applicatives

### What is a Monad?
```scala
// Monad provides:
// 1. pure/unit: A => F[A]
// 2. flatMap: F[A] => (A => F[B]) => F[B]

// Must satisfy laws:
// Left identity:  pure(a).flatMap(f) == f(a)
// Right identity: m.flatMap(pure) == m
// Associativity:  m.flatMap(f).flatMap(g) == m.flatMap(a => f(a).flatMap(g))

trait Monad[F[_]] {
  def pure[A](a: A): F[A]
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  // map can be derived
  def map[A, B](fa: F[A])(f: A => B): F[B] =
    flatMap(fa)(a => pure(f(a)))
}

// Examples: Option, Either, List, IO, Future, ZIO
```

### Applicative vs Monad
```scala
// Applicative: independent computations, can parallelize
// Monad: sequential computations, results depend on previous

// Applicative
trait Applicative[F[_]] {
  def pure[A](a: A): F[A]
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
  // or: def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C]
}

// With Applicative, computations are independent:
(fetchUser, fetchOrders).mapN((user, orders) => combine(user, orders))
// Both can run in parallel!

// With Monad, computations are sequential:
for {
  user <- fetchUser
  orders <- fetchOrdersForUser(user.id)  // depends on user!
} yield combine(user, orders)
```

### Either vs Validated
```scala
// Either — fail fast (monadic)
def validateName(s: String): Either[String, String] =
  if (s.nonEmpty) Right(s) else Left("Name is empty")

def validateAge(n: Int): Either[String, Int] =
  if (n >= 0) Right(n) else Left("Age is negative")

// Fails on first error
for {
  name <- validateName("")
  age <- validateAge(-1)
} yield User(name, age)
// Result: Left("Name is empty") — age not checked!

// Validated — accumulate errors (applicative)
import cats.data.Validated
import cats.implicits._

def validateName(s: String): Validated[List[String], String] =
  if (s.nonEmpty) s.valid else List("Name is empty").invalid

def validateAge(n: Int): Validated[List[String], Int] =
  if (n >= 0) n.valid else List("Age is negative").invalid

(validateName(""), validateAge(-1)).mapN(User.apply)
// Result: Invalid(List("Name is empty", "Age is negative"))
```

---

## 😺 Cats / Cats Effect Questions

### Core Type Classes
```scala
import cats._
import cats.implicits._

// Functor — map
trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]
}
Option(1).map(_ + 1)  // Some(2)

// Applicative — pure + ap
trait Applicative[F[_]] extends Functor[F] {
  def pure[A](a: A): F[A]
  def ap[A, B](ff: F[A => B])(fa: F[A]): F[B]
}
(Option(1), Option(2)).mapN(_ + _)  // Some(3)

// Monad — flatMap
trait Monad[F[_]] extends Applicative[F] {
  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
}

// Traverse — sequence operations
trait Traverse[F[_]] {
  def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]]
}
List(1, 2, 3).traverse(n => Option(n * 2))  // Some(List(2, 4, 6))
List(Option(1), Option(2)).sequence  // Some(List(1, 2))

// Foldable — fold operations
List(1, 2, 3).foldMap(_.toString)  // "123" (using String Monoid)
```

### Cats Effect
```scala
import cats.effect._

// IO — describes a computation (lazy, referentially transparent)
val program: IO[Unit] = for {
  _ <- IO.println("Enter name:")
  name <- IO.readLine
  _ <- IO.println(s"Hello, $name!")
} yield ()

// Resource — safe resource management
def resource: Resource[IO, Connection] =
  Resource.make(
    IO(openConnection())   // acquire
  )(conn =>
    IO(conn.close())       // release (always runs)
  )

resource.use { conn =>
  // use connection
  IO(conn.query("SELECT ..."))
}  // connection automatically closed

// Fiber — lightweight thread
val fiber: IO[Fiber[IO, Throwable, Int]] =
  longComputation.start

for {
  fib <- longComputation.start
  result <- fib.join  // wait for completion
} yield result

// Ref — concurrent mutable reference
for {
  counter <- Ref.of[IO, Int](0)
  _ <- counter.update(_ + 1)
  value <- counter.get
} yield value

// Deferred — one-shot synchronization
for {
  deferred <- Deferred[IO, Int]
  _ <- (IO.sleep(1.second) *> deferred.complete(42)).start
  value <- deferred.get  // blocks until complete
} yield value
```

---

## ⚡ ZIO Questions

### ZIO[R, E, A] — What Each Parameter Means
```scala
// R = Environment (dependencies) — what the effect NEEDS
// E = Error type — how the effect can FAIL
// A = Success type — what the effect PRODUCES

// Examples:
val simple: ZIO[Any, Nothing, Int] = ZIO.succeed(42)
// Needs nothing, can't fail, produces Int

val risky: ZIO[Any, Throwable, Int] = ZIO.attempt(dangerousCode())
// Needs nothing, can fail with Throwable, produces Int

val withDeps: ZIO[Database, DbError, User] = ???
// Needs Database service, can fail with DbError, produces User

// Type aliases:
type UIO[A] = ZIO[Any, Nothing, A]      // can't fail
type Task[A] = ZIO[Any, Throwable, A]   // fails with Throwable
type IO[E, A] = ZIO[Any, E, A]          // no dependencies
type URIO[R, A] = ZIO[R, Nothing, A]    // can't fail, has deps
```

### ZLayer — Dependency Injection
```scala
// Define services
trait UserService {
  def getUser(id: UserId): IO[DbError, User]
}

// Implementation
case class UserServiceLive(db: Database) extends UserService {
  def getUser(id: UserId): IO[DbError, User] =
    db.query(s"SELECT * FROM users WHERE id = $id")
}

// Create layer
val userServiceLayer: ZLayer[Database, Nothing, UserService] =
  ZLayer.fromFunction(UserServiceLive.apply)

// Use in program
val program: ZIO[UserService, DbError, User] =
  ZIO.serviceWithZIO[UserService](_.getUser(UserId(1)))

// Provide dependencies
program.provide(
  userServiceLayer,
  databaseLayer
)
```

### Error Handling — Typed Errors vs Defects
```scala
// Typed errors (E) — expected, recoverable failures
sealed trait AppError
case class NotFound(id: String) extends AppError
case class ValidationError(msg: String) extends AppError

val program: ZIO[Any, AppError, User] = ???

// Handle typed errors
program.catchAll {
  case NotFound(id) => ZIO.succeed(defaultUser)
  case ValidationError(msg) => ZIO.fail(ValidationError(s"Invalid: $msg"))
}

// Defects — unexpected failures (bugs)
// Die, interrupt — not in error channel
val defect: ZIO[Any, Nothing, Int] = ZIO.die(new RuntimeException("bug!"))

// Catch defects
program.catchAllDefect { throwable =>
  ZIO.succeed(fallbackValue)
}

// Convert between them
ZIO.attempt(riskyCode)  // Throwable -> E
  .refineToOrDie[IOException]  // Keep only IOException, others become defects
```

### Concurrency Primitives
```scala
// Ref — concurrent mutable reference
for {
  ref <- Ref.make(0)
  _ <- ZIO.foreachPar(1 to 100)(_ => ref.update(_ + 1))
  value <- ref.get  // 100
} yield value

// Queue — concurrent queue
for {
  queue <- Queue.bounded[Int](10)
  _ <- queue.offer(1)
  item <- queue.take
} yield item

// Hub — broadcast to multiple subscribers
for {
  hub <- Hub.bounded[String](10)
  _ <- hub.subscribe.flatMap { sub1 =>
    hub.subscribe.flatMap { sub2 =>
      for {
        _ <- hub.publish("hello")
        msg1 <- sub1.take
        msg2 <- sub2.take
      } yield (msg1, msg2)  // both get "hello"
    }
  }
} yield ()

// Semaphore — limit concurrency
for {
  sem <- Semaphore.make(3)  // max 3 concurrent
  _ <- ZIO.foreachPar(1 to 100) { i =>
    sem.withPermit(expensiveOperation(i))
  }
} yield ()
```

### Schedule — Retry & Repeat
```scala
// Retry with exponential backoff
val policy = Schedule.exponential(100.millis) && Schedule.recurs(5)

ZIO.attempt(httpCall())
  .retry(policy)

// Repeat
val heartbeat = sendHeartbeat.repeat(Schedule.fixed(10.seconds))

// Complex schedules
val schedule =
  Schedule.exponential(1.second, 2.0) // 1s, 2s, 4s, 8s...
    .jittered                          // add randomness
    && Schedule.recurs(10)             // max 10 retries
    && Schedule.recurWhile[Throwable](_.isInstanceOf[RetryableError])
```

---

## 🌊 Streams & FS2

### Why Streams Matter in Scala Interviews
```
Streaming is a core topic for Scala positions, especially for:
- Data pipelines (ETL, event processing)
- HTTP request/response bodies
- Database result sets
- File processing
```

### FS2 Core Concepts
```scala
import fs2._
import cats.effect._

// Stream[F, O] — a stream that produces values of type O using effect F
// F = IO, Task, etc. Pure = no effects

// Creation
val s1 = Stream.emit(1)                    // single element
val s2 = Stream.emits(List(1, 2, 3))     // from collection
val s3 = Stream.eval(IO(42))             // from effect
val s4 = Stream.repeatEval(IO(random())) // infinite effectful stream

// Transformation (lazy, pull-based)
Stream(1, 2, 3, 4, 5)
  .filter(_ % 2 == 0)
  .map(_ * 10)
  .take(2)
  .compile.toList  // IO(List(20, 40))

// Key advantage: constant memory regardless of data size
// Process a 10GB file line by line:
io.file.Files[IO].readAll(path)
  .through(text.utf8.decode)
  .through(text.lines)
  .filter(_.nonEmpty)
  .evalMap(line => processLine(line))
  .compile.drain  // IO[Unit]
```

### FS2 vs Akka Streams vs ZIO Streams
```
| Feature          | FS2                | Akka Streams      | ZIO Streams        |
|-----------------|--------------------|--------------------|---------------------|
| Effect system   | Cats Effect (IO)   | Akka Actor system  | ZIO                 |
| Backpressure    | Pull-based         | Push + backpressure| Pull-based          |
| Resource safety | Resource/Bracket   | Kill switches      | ZManaged/Scope      |
| Concurrency     | merge/parJoin      | Graph DSL          | ZStream.mergeAll    |
| Learning curve  | Moderate           | High               | Moderate            |
| Use when        | Cats Effect stack  | Akka ecosystem     | ZIO ecosystem       |
```

---

## 🗄 Database Access Patterns

### Doobie vs Slick vs Quill
```
| Feature     | Doobie              | Slick               | Quill              |
|-------------|---------------------|----------------------|---------------------|
| Approach    | Pure JDBC wrapper   | FRM (query DSL)      | Compile-time SQL    |
| SQL control | You write SQL       | Generated SQL        | Compile-time macros |
| Type safety | Runtime checked     | Compile-time queries | Compile-time macros |
| Effect type | Cats Effect (IO)    | DBIO (custom monad)  | Any                 |
| Best for    | SQL experts         | Scala-centric teams  | Type-safe SQL       |
```

### Doobie Key Patterns (Interview Favorites)
```scala
import doobie._
import doobie.implicits._
import cats.effect.IO

// Basic query
sql"SELECT name, age FROM users WHERE id = $id"
  .query[(String, Int)]
  .option                  // ConnectionIO[Option[(String, Int)]]
  .transact(xa)           // IO[Option[(String, Int)]]

// Batch insert with traverse
def insertUsers(users: List[User]): ConnectionIO[Int] =
  users.traverse(u =>
    sql"INSERT INTO users (name, age) VALUES (${u.name}, ${u.age})".update.run
  ).map(_.sum)

// Transaction composition — this is the key insight:
// ConnectionIO programs compose monadically, and the ENTIRE
// for-comprehension runs in a SINGLE transaction
val transfer: ConnectionIO[Unit] = for {
  _ <- sql"UPDATE accounts SET balance = balance - 100 WHERE id = 1".update.run
  _ <- sql"UPDATE accounts SET balance = balance + 100 WHERE id = 2".update.run
} yield ()
// If either UPDATE fails, BOTH are rolled back
```

---

## 💻 Coding Tasks

> These are the most common "implement X from scratch" tasks in Scala interviews.
> They test your understanding of FP fundamentals, not just API knowledge.
> For each task, understand WHY foldRight is used and what the base case represents.

### Implement map using foldRight
```scala
// Why foldRight and not foldLeft?
// foldRight processes right-to-left, which means we can use :: (prepend)
// which is O(1) for List. foldLeft would build the list in reverse order.
//
// The pattern: foldRight(base)(combine) where:
//   base = what to return for empty list → List.empty[B]
//   combine = how to process each element → f(a) :: acc

def myMap[A, B](list: List[A])(f: A => B): List[B] =
  list.foldRight(List.empty[B])((a, acc) => f(a) :: acc)

// Test
myMap(List(1, 2, 3))(_ * 2)  // List(2, 4, 6)

// Follow-up question: Can you implement map using pattern matching + recursion?
def myMapRec[A, B](list: List[A])(f: A => B): List[B] = list match {
  case Nil => Nil
  case head :: tail => f(head) :: myMapRec(tail)(f)
}
// Note: this is NOT stack-safe for large lists! The fold version is better.
```

### Implement flatMap using fold
```scala
// flatMap = map + flatten
// Key insight: f returns a List, so we need to concatenate (:::) not prepend (::)

def myFlatMap[A, B](list: List[A])(f: A => List[B]): List[B] =
  list.foldRight(List.empty[B])((a, acc) => f(a) ::: acc)

// foldLeft version — builds result left-to-right
// Note: ::: on left is O(n) for the accumulator, making total O(n^2)
// The foldRight version above is O(n*m) where m = average inner list size
def myFlatMap2[A, B](list: List[A])(f: A => List[B]): List[B] =
  list.foldLeft(List.empty[B])((acc, a) => acc ::: f(a))

// Test
myFlatMap(List(1, 2, 3))(n => List(n, n * 10))  // List(1, 10, 2, 20, 3, 30)
```

### Implement Option
```scala
sealed trait MyOption[+A] {
  def map[B](f: A => B): MyOption[B] = this match {
    case MySome(a) => MySome(f(a))
    case MyNone => MyNone
  }

  def flatMap[B](f: A => MyOption[B]): MyOption[B] = this match {
    case MySome(a) => f(a)
    case MyNone => MyNone
  }

  def filter(p: A => Boolean): MyOption[A] = this match {
    case MySome(a) if p(a) => this
    case _ => MyNone
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case MySome(a) => a
    case MyNone => default
  }
}

case class MySome[+A](value: A) extends MyOption[A]
case object MyNone extends MyOption[Nothing]
```

### Implement traverse for List
```scala
import cats._
import cats.implicits._

def myTraverse[F[_]: Applicative, A, B](list: List[A])(f: A => F[B]): F[List[B]] =
  list.foldRight(Applicative[F].pure(List.empty[B])) { (a, acc) =>
    (f(a), acc).mapN(_ :: _)
  }

// Test
myTraverse(List(1, 2, 3))(n => Option(n * 2))  // Some(List(2, 4, 6))
myTraverse(List(1, 2, 3))(n => if (n > 2) None else Some(n))  // None
```

### Implement simple IO Monad
```scala
// This is THE most important FP interview task. It tests:
// 1. Understanding of referential transparency
// 2. ADT design (sealed trait + case classes)
// 3. Monadic composition (flatMap)
// 4. Lazy evaluation (thunks)
//
// The key insight: IO is a DATA STRUCTURE that DESCRIBES a computation.
// It does NOT execute anything until unsafeRun() is called.
// This is why it's referentially transparent — it's just a value.

sealed trait MyIO[A] {
  // flatMap doesn't EXECUTE anything — it builds a FlatMap data structure
  def flatMap[B](f: A => MyIO[B]): MyIO[B] = FlatMap(this, f)
  def map[B](f: A => B): MyIO[B] = flatMap(a => MyIO.pure(f(a)))

  // The ONLY place where side effects actually happen
  def unsafeRun(): A = this match {
    case Pure(a) => a
    case Suspend(thunk) => thunk()
    case FlatMap(io, f) => f(io.unsafeRun()).unsafeRun()
  }
  // Note: this unsafeRun is NOT stack-safe! Real IO uses a trampoline/fiber.
}

case class Pure[A](a: A) extends MyIO[A]              // wraps a pure value
case class Suspend[A](thunk: () => A) extends MyIO[A]  // wraps a lazy side effect
case class FlatMap[A, B](io: MyIO[A], f: A => MyIO[B]) extends MyIO[B]  // sequencing

object MyIO {
  def pure[A](a: A): MyIO[A] = Pure(a)
  def suspend[A](thunk: => A): MyIO[A] = Suspend(() => thunk)
  // Note: () => thunk is a function that will call thunk when invoked.
  // The by-name parameter (=> A) captures the expression without evaluating it.
}

// Usage — building a description, NOT executing
val program = for {
  _ <- MyIO.suspend(println("Enter name:"))  // builds FlatMap(Suspend(...), ...)
  name <- MyIO.suspend(scala.io.StdIn.readLine())
  _ <- MyIO.suspend(println(s"Hello, $name!"))
} yield ()
// At this point, NOTHING has been printed. program is just a data structure.

program.unsafeRun()  // NOW it executes
```

### Follow-up: Why is this better than Future?
```scala
// With MyIO:
val greet = MyIO.suspend(println("Hello!"))
val program = greet.flatMap(_ => greet)  // prints "Hello!" TWICE when run
// greet is a description — each execution is independent

// With Future:
val greet = Future(println("Hello!"))
val program = greet.flatMap(_ => greet)  // prints "Hello!" only ONCE
// greet already started running — flatMap just waits for the same result
```

### Rate Limiter using Ref (ZIO)
```scala
// Common interview task: implement token bucket rate limiter
// Tests: ZIO Ref, fibers, concurrent state management
// Pattern: Token Bucket — tokens are consumed per request, refilled over time
import zio._

case class RateLimiter(
  tokens: Ref[Int],
  maxTokens: Int,
  refillRate: Duration
) {
  def acquire: UIO[Unit] = for {
    available <- tokens.get
    _ <- if (available > 0)
           tokens.update(_ - 1)
         else
           ZIO.sleep(refillRate) *> acquire
  } yield ()
}

object RateLimiter {
  def make(maxTokens: Int, refillRate: Duration): UIO[RateLimiter] = for {
    tokens <- Ref.make(maxTokens)
    limiter = RateLimiter(tokens, maxTokens, refillRate)
    // Start background refill
    _ <- (ZIO.sleep(refillRate) *> tokens.update(t => math.min(t + 1, maxTokens)))
           .forever
           .fork
  } yield limiter
}
```

### Retry with Exponential Backoff
```scala
import scala.concurrent.duration._
import cats.effect._

def retryWithBackoff[A](
  io: IO[A],
  maxRetries: Int,
  initialDelay: FiniteDuration
): IO[A] = {
  io.handleErrorWith { error =>
    if (maxRetries > 0)
      IO.sleep(initialDelay) *> retryWithBackoff(io, maxRetries - 1, initialDelay * 2)
    else
      IO.raiseError(error)
  }
}

// Usage
retryWithBackoff(httpCall, maxRetries = 5, initialDelay = 100.millis)
```

---

## 🏗 System Design

### Common Interview Topics
1. **URL Shortener** — TinyURL design
2. **Twitter Feed** — timeline generation
3. **Rate Limiter** — API throttling
4. **Distributed Cache** — Redis-like system
5. **Payment System** — transaction processing
6. **Real-time Analytics** — event streaming
7. **Message Queue** — Kafka-like system
8. **Search Autocomplete** — typeahead suggestions

### Answer Framework (30-45 min)

#### 1. Clarify Requirements (5 min)
```
- Functional requirements — what should the system do?
- Non-functional requirements — scale, latency, availability?
- Constraints — budget, timeline, team size?
```

#### 2. Back-of-envelope Estimation (5 min)
```
- Traffic: requests/second
- Storage: data size, growth rate
- Bandwidth: read/write ratio
```

#### 3. High-Level Design (10 min)
```
- Core components
- Data flow
- APIs
```

#### 4. Deep Dive (15 min)
```
- Database choice & schema
- Caching strategy
- Scaling approach
- Failure handling
```

#### 5. Wrap Up (5 min)
```
- Trade-offs made
- Future improvements
- Monitoring & alerts
```

### Example: URL Shortener

#### Requirements
```
Functional:
- Shorten long URL → short URL
- Redirect short URL → original URL
- Custom short URLs (optional)
- Analytics (optional)

Non-functional:
- 100M URLs created/month
- 10B redirects/month
- 99.9% availability
- < 100ms latency for redirect
```

#### Estimation
```
Write: 100M / (30 * 24 * 3600) ≈ 40 URLs/sec
Read: 10B / (30 * 24 * 3600) ≈ 4000 redirects/sec
Read:Write ratio = 100:1

Storage (5 years):
- 100M * 12 * 5 = 6B URLs
- Each URL: ~500 bytes (short + long + metadata)
- Total: 6B * 500B = 3TB
```

#### High-Level Design
```
┌─────────┐     ┌──────────────┐     ┌──────────┐
│ Client  │────▶│ Load Balancer│────▶│ App Server│
└─────────┘     └──────────────┘     └────┬─────┘
                                          │
                    ┌─────────────────────┼─────────────────────┐
                    │                     │                     │
                    ▼                     ▼                     ▼
              ┌──────────┐         ┌──────────┐         ┌──────────┐
              │  Cache   │         │ Database │         │ Key Gen  │
              │ (Redis)  │         │(Postgres)│         │ Service  │
              └──────────┘         └──────────┘         └──────────┘
```

#### Database Schema
```sql
CREATE TABLE urls (
  short_code VARCHAR(7) PRIMARY KEY,
  original_url TEXT NOT NULL,
  user_id BIGINT,
  created_at TIMESTAMP DEFAULT NOW(),
  expires_at TIMESTAMP,
  click_count BIGINT DEFAULT 0
);

CREATE INDEX idx_user_urls ON urls(user_id, created_at);
```

#### Key Generation
```scala
// Option 1: Base62 encoding of auto-increment ID
def encode(id: Long): String = {
  val chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
  var n = id
  val sb = new StringBuilder
  while (n > 0) {
    sb.append(chars((n % 62).toInt))
    n /= 62
  }
  sb.reverse.toString
}

// Option 2: Pre-generated keys (Key Generation Service)
// - Generate keys in advance
// - Store in separate DB
// - App servers request batch of keys
```

#### Caching Strategy
```
- Cache hot URLs in Redis
- TTL based on access frequency
- Write-through for new URLs
- Cache aside for reads
```

---

## 🗣 Behavioral Questions (STAR Format)

### STAR Method
- **S**ituation — context
- **T**ask — your responsibility/role
- **A**ction — what you specifically did
- **R**esult — measurable outcome

### Example Answers

#### "Tell me about a challenging project"
```
S: At NetEnt, we needed to migrate the wallet service from Akka to Cats Effect
   under 24/7 load with zero downtime.

T: I was the lead developer responsible for architecture and coordinating
   a team of 4 engineers.

A: - Developed a gradual migration strategy using feature flags
   - Created an adapter layer for old and new code compatibility
   - Set up A/B testing for 1% of traffic
   - Organized code review process and pair programming sessions

R: - Migration completed in 3 months instead of expected 6
   - Zero downtime — no incidents during migration
   - Latency improved by 30%
   - Team gained Cats Effect experience
```

#### "Time when you disagreed with your manager"
```
S: Manager wanted to use MongoDB for financial transactions
   because of "faster development."

T: I needed to either agree or convince them with technical arguments
   for an alternative solution.

A: - Prepared a comparison document: MongoDB vs PostgreSQL for our use case
   - Showed examples of consistency issues in MongoDB during network partitions
   - Proposed a compromise: PostgreSQL for transactions, MongoDB for logs
   - Organized a meeting with the architect for a third opinion

R: - Manager agreed to PostgreSQL for core transactions
   - Avoided potential data consistency issues
   - Relationship with manager improved — he appreciated my approach
```

#### "Biggest failure and what you learned"
```
S: Deployed a change to production without sufficient testing,
   causing a 2-hour outage of the payment system.

T: Needed to quickly restore the service and prevent recurrence.

A: - Immediately rolled back changes (15 min)
   - Wrote post-mortem with root cause analysis
   - Proposed improvements: staging environment, canary deployments
   - Added integration tests for critical path

R: - Implemented mandatory staging testing
   - Created checklist for production deployments
   - Zero production incidents caused by me since then
   - Became more careful and systematic in my approach
```

---

## 🧪 Testing in Scala

### Testing Frameworks Comparison
```
| Framework      | Style          | Best For              |
|----------------|----------------|-----------------------|
| ScalaTest      | BDD/FlatSpec   | Most Scala projects   |
| MUnit          | Simple/Modern  | Typelevel projects    |
| ZIO Test       | Effect-native  | ZIO applications      |
| Specs2         | Specification  | Legacy projects       |
```

### Property-Based Testing (Frequently Asked)
```scala
import org.scalacheck.Prop.forAll

// Instead of testing specific examples, test PROPERTIES that must always hold

// Property: reversing a list twice gives the original list
forAll { (list: List[Int]) =>
  list.reverse.reverse == list
}

// Property: sorting is idempotent
forAll { (list: List[Int]) =>
  list.sorted.sorted == list.sorted
}

// Why interviewers ask about this:
// 1. Shows understanding of mathematical properties
// 2. Finds edge cases you wouldn't think of
// 3. Core FP concept — properties over examples
```

### Testing ZIO Applications
```scala
import zio.test._
import zio.test.Assertion._

object MySpec extends ZIOSpecDefault {
  def spec = suite("UserService")(
    test("creates a user") {
      for {
        service <- ZIO.service[UserService]
        user <- service.create("Alice", 30)
      } yield assertTrue(
        user.name == "Alice",
        user.age == 30
      )
    }
  ).provide(
    UserServiceLive.layer,  // real implementation
    TestDatabase.layer       // test database
  )
}

// Key interview point: ZIO Test allows you to:
// 1. Inject test dependencies via layers
// 2. Control time with TestClock
// 3. Test concurrent code deterministically
// 4. Use property-based testing with Gen
```

---

## 📖 Preparation Resources

### Scala / FP
- **"Functional Programming in Scala"** (Red Book) — must read
- **"Scala with Cats"** — free online book
- **"Essential Effects"** — Cats Effect deep dive
- **Rock the JVM** — video courses (Scala, Cats, ZIO)
- **Scala Exercises** — scalexercises.org

### ZIO
- **ZIO Documentation** — zio.dev
- **"Zionomicon"** — book by ZIO creators
- **ZIO Discord** — active community

### Algorithms
- **LeetCode** — Medium level is sufficient (150-200 problems)
- **"Cracking the Coding Interview"**
- **NeetCode.io** — structured roadmap

### System Design
- **"Designing Data-Intensive Applications"** (DDIA) — must read
- **System Design Primer** (GitHub)
- **Grokking System Design** — course
- **ByteByteGo** — YouTube channel

### Behavioral
- **STAR Method** — search for examples
- Prepare 5-7 stories, adapt to questions

---

## ✅ Pre-Interview Checklist

### One Week Before
- [ ] Research company, product, tech stack
- [ ] Solve 10-15 LeetCode Medium problems
- [ ] Review Scala basics, collections, implicits
- [ ] Prepare 5 STAR stories

### Day Before
- [ ] Get a good night's sleep!
- [ ] Set up workspace (camera, microphone, lighting)
- [ ] Open IDE, terminal
- [ ] Have water nearby

### During Coding Interview
- [ ] Clarify requirements before coding
- [ ] Think out loud — explain your thoughts
- [ ] Start with brute force, then optimize
- [ ] Test your code verbally
- [ ] Ask for hints if stuck (it's OK!)

### During System Design
- [ ] Clarify requirements (5 min)
- [ ] Make estimations
- [ ] Draw high-level design first
- [ ] Deep dive on 1-2 components
- [ ] Discuss trade-offs

---

## 💰 Salary Negotiation Tips

### Research
- Levels.fyi — accurate company data
- Glassdoor — general ranges
- Blind — anonymous discussions

### During Discussion
- Don't name a number first if possible
- If asked for expectations: "Based on my research and experience,
  I'm looking for total compensation in the range of $X-Y"
- Always negotiate — first offer is rarely final
- Consider total comp: base + bonus + equity + benefits

### Counter Offer
- "Thank you for the offer. I'm excited about the opportunity.
  Based on my experience and market data, I was hoping for
  closer to $X. Is there flexibility?"

---

**Last Updated**: March 17, 2026

Good luck! 🚀
