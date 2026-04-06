package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 063 - Advanced FP Patterns
 *
 * Advanced patterns used in production Scala FP: classy lenses with MonadError,
 * MTL-style type classes, capability traits, effect rotation, Kleisli composition,
 * indexed monads, and graded monads concepts.
 */
object Cats063_AdvancedPatterns {

  // Exercise 1: Classy lenses with MonadError - use MonadError for typed error handling
  // TODO: Demonstrate "classy optics" pattern using MonadError to handle specific errors.
  sealed trait AppError
  case class NotFound(id: String) extends AppError
  case class Unauthorized(msg: String) extends AppError
  case class ValidationError(field: String, msg: String) extends AppError

  type AppResult[A] = Either[AppError, A]

  def exercise1_classyLenses(): (AppResult[String], AppResult[String]) = {
    // Use MonadError to raise specific error subtypes
    def findUser(id: String): AppResult[String] = {
      if (id == "1") Right("Alice")
      else Left(NotFound(id))
    }

    def requireAuth(token: String): AppResult[Unit] = {
      if (token == "valid") Right(())
      else Left(Unauthorized("invalid token"))
    }

    // Compose: authenticate then find user
    val success: AppResult[String] = ???  // requireAuth("valid") >> findUser("1")
    val failure: AppResult[String] = ???  // requireAuth("bad") >> findUser("1")

    (success, failure)
  }

  // Exercise 2: MTL-style type classes - abstract over monad transformer stacks
  // TODO: Use type class constraints instead of concrete transformer stacks.
  trait HasConfig[F[_]] {
    def getConfig(key: String): F[Option[String]]
  }

  trait HasLogger[F[_]] {
    def log(msg: String): F[Unit]
  }

  // MTL-style: program is generic in F[_] with constraints
  def exercise2_mtlStyle[F[_]: Monad](
    implicit config: HasConfig[F], logger: HasLogger[F]
  ): F[String] = {
    // Get a config value, log it, return it with a default
    ???
  }

  // Exercise 3: Capability traits - fine-grained effect constraints
  // TODO: Define and use capability traits for fine-grained effect control.
  trait CanRead[F[_]] {
    def read(key: String): F[Option[String]]
  }

  trait CanWrite[F[_]] {
    def write(key: String, value: String): F[Unit]
  }

  // Read-only function: can only read, not write
  def exercise3_readOnly[F[_]: Monad](implicit R: CanRead[F]): F[Option[String]] = {
    // Read "username" key
    ???
  }

  // Read-write function: can do both
  def exercise3_readWrite[F[_]: Monad](implicit R: CanRead[F], W: CanWrite[F]): F[Option[String]] = {
    // Write "status" -> "active", then read "username"
    ???
  }

  // Exercise 4: Effect rotation - transform between different effect stacks
  // TODO: Demonstrate rotating effects in a transformer stack.
  def exercise4_effectRotation(): (List[String], Either[String, Int]) = {
    // Stack 1: EitherT[Writer[List[String], ?], String, Int]
    // Stack 2: WriterT[Either[String, ?], List[String], Int]
    // These are "rotated" versions of the same logical computation

    // Computation in Stack 1 style (using EitherT over Writer)
    type WriterLog[A] = Writer[List[String], A]
    type Stack1[A] = EitherT[WriterLog, String, A]

    val computation: Writer[List[String], Either[String, Int]] = for {
      _ <- Writer.tell(List("step 1"))
      _ <- Writer.tell(List("step 2"))
    } yield Right(42): Either[String, Int]

    // Extract the log and result
    ???
  }

  // Exercise 5: Kleisli composition patterns - advanced Kleisli usage
  // TODO: Build a pipeline using Kleisli composition.
  def exercise5_kleisliComposition(): Either[String, String] = {
    type Result[A] = Either[String, A]

    val parseInt: Kleisli[Result, String, Int] =
      Kleisli[Result, String, Int]((s: String) => scala.util.Try(s.toInt).toOption.toRight(s"'$s' is not a number"))

    val validate: Kleisli[Result, Int, Int] =
      Kleisli(n => if (n > 0) Right(n) else Left("must be positive"))

    val format: Kleisli[Result, Int, String] =
      Kleisli[Result, Int, String]((n: Int) => Right(s"Valid number: $n"): Either[String, String])

    // Compose the pipeline: parse -> validate -> format
    ???
  }

  // Exercise 6: Indexed monad concept - state transitions with type-level tracking
  // TODO: Model indexed monad concept for type-safe state machines.
  sealed trait DoorState
  case object Open extends DoorState
  case object Closed extends DoorState
  case object Locked extends DoorState

  // IndexedStateT[F, SA, SB, A] models transition from state SA to state SB
  // Simplified model using regular functions
  case class Transition[From, To, A](run: From => (To, A))

  def exercise6_indexedMonad(): (String, String) = {
    // Model door state transitions
    def closeDoor: Transition[Open.type, Closed.type, Unit] =
      Transition(_ => (Closed, ()))

    def lockDoor: Transition[Closed.type, Locked.type, Unit] =
      Transition(_ => (Locked, ()))

    def unlockDoor: Transition[Locked.type, Closed.type, Unit] =
      Transition(_ => (Closed, ()))

    def openDoor: Transition[Closed.type, Open.type, Unit] =
      Transition(_ => (Open, ()))

    // Compose: Open -> Closed -> Locked
    val (state1, _) = closeDoor.run(Open)
    val (state2, _) = lockDoor.run(state1)

    // Return the state names
    ???
  }

  // Exercise 7: Graded monad concept - monads indexed by a monoid
  // TODO: Model a graded monad concept for tracking effect levels.
  sealed trait AccessLevel
  case object Public extends AccessLevel
  case object Private extends AccessLevel
  case object Admin extends AccessLevel

  case class Graded[L <: AccessLevel, A](value: A, level: String)

  def exercise7_gradedMonad(): (Graded[Public.type, String], Graded[Admin.type, String]) = {
    // Public operations: no special access needed
    val publicOp: Graded[Public.type, String] = ???  // Graded("public data", "public")

    // Admin operations: require admin access
    val adminOp: Graded[Admin.type, String] = ???  // Graded("admin data", "admin")

    // The type system tracks the access level
    (publicOp, adminOp)
  }

  // Exercise 8: Combined advanced pattern - bring it all together
  // TODO: Build a small application using multiple advanced patterns.
  def exercise8_combinedPattern(): Either[AppError, String] = {
    // Pipeline using Kleisli + MonadError + capability pattern

    type App[A] = Either[AppError, A]

    def validateInput(input: String): App[String] =
      if (input.nonEmpty) Right(input)
      else Left(ValidationError("input", "must not be empty"))

    def authorize(user: String): App[String] =
      if (user == "admin") Right(user)
      else Left(Unauthorized(s"$user not authorized"))

    def processRequest(user: String): App[String] =
      Right(s"processed by $user")

    // Compose: validate -> authorize -> process
    val pipeline: Kleisli[App, String, String] = ???

    // Run the pipeline
    pipeline.run("admin")
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (r1a, r1b) = exercise1_classyLenses()
    assert(r1a == Right("Alice"), s"Exercise 1 failed: success=$r1a")
    assert(r1b.isLeft, s"Exercise 1 failed: failure=$r1b")
    println(s"Exercise 1 passed: classy lenses => success=$r1a, failure=$r1b")

    // Exercise 2
    type TestEffect[A] = Id[A]
    implicit val testConfig: HasConfig[Id] = new HasConfig[Id] {
      def getConfig(key: String): Id[Option[String]] = Some(s"value-of-$key")
    }
    implicit val testLogger: HasLogger[Id] = new HasLogger[Id] {
      def log(msg: String): Id[Unit] = ()
    }
    val r2 = exercise2_mtlStyle[Id]
    assert(r2.nonEmpty, s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: MTL-style => $r2")

    // Exercise 3
    implicit val testReader: CanRead[Id] = new CanRead[Id] {
      def read(key: String): Id[Option[String]] = Some(s"value-of-$key")
    }
    implicit val testWriter: CanWrite[Id] = new CanWrite[Id] {
      def write(key: String, value: String): Id[Unit] = ()
    }
    val r3a = exercise3_readOnly[Id]
    assert(r3a.isDefined, s"Exercise 3 readOnly failed: $r3a")
    val r3b = exercise3_readWrite[Id]
    assert(r3b.isDefined, s"Exercise 3 readWrite failed: $r3b")
    println(s"Exercise 3 passed: capability traits => readOnly=$r3a, readWrite=$r3b")

    // Exercise 4
    val (r4log, r4result) = exercise4_effectRotation()
    assert(r4log.size == 2, s"Exercise 4 failed: log=$r4log")
    assert(r4result == Right(42), s"Exercise 4 failed: result=$r4result")
    println(s"Exercise 4 passed: effect rotation => log=$r4log, result=$r4result")

    // Exercise 5
    val r5 = exercise5_kleisliComposition()
    assert(r5 == Right("Valid number: 42"), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: Kleisli composition => $r5")

    // Exercise 6
    val (r6a, r6b) = exercise6_indexedMonad()
    println(s"Exercise 6 passed: indexed monad => state1=$r6a, state2=$r6b")

    // Exercise 7
    val (r7a, r7b) = exercise7_gradedMonad()
    assert(r7a.level == "public", s"Exercise 7 failed: ${r7a.level}")
    assert(r7b.level == "admin", s"Exercise 7 failed: ${r7b.level}")
    println(s"Exercise 7 passed: graded monad => public=${r7a}, admin=${r7b}")

    // Exercise 8
    val r8 = exercise8_combinedPattern()
    assert(r8 == Right("processed by admin"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: combined pattern => $r8")

    println("\nAll Cats063_AdvancedPatterns exercises passed!")
  }
}
