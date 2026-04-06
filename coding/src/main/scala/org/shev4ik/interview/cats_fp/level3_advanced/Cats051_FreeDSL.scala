package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.free.Free

/**
 * Cats 051 - Free DSL
 *
 * Free monads enable defining domain-specific languages (DSLs) as data.
 * You define operations as a sealed trait, lift them into Free, build programs
 * using for-comprehensions, and interpret them with different interpreters.
 */
object Cats051_FreeDSL {

  // Exercise 1: Define DSL with sealed trait - create a logging DSL
  // TODO: The sealed trait is provided. Create smart constructors using Free.liftF.
  sealed trait LogAlgebra[A]
  case class LogInfo(msg: String) extends LogAlgebra[Unit]
  case class LogWarn(msg: String) extends LogAlgebra[Unit]
  case class LogError(msg: String) extends LogAlgebra[Unit]
  case object GetLogLevel extends LogAlgebra[String]

  type LogProgram[A] = Free[LogAlgebra, A]

  def logInfo(msg: String): LogProgram[Unit] = ???
  def logWarn(msg: String): LogProgram[Unit] = ???
  def logError(msg: String): LogProgram[Unit] = ???
  def getLogLevel: LogProgram[String] = ???

  // Exercise 2: Lift operations - create smart constructors for a CRUD DSL
  // TODO: Define a CRUD DSL and lift operations into Free.
  sealed trait CrudAlgebra[A]
  case class Create(id: String, data: String) extends CrudAlgebra[Unit]
  case class Read(id: String) extends CrudAlgebra[Option[String]]
  case class Update(id: String, data: String) extends CrudAlgebra[Unit]
  case class CrudDelete(id: String) extends CrudAlgebra[Boolean]

  type CrudProgram[A] = Free[CrudAlgebra, A]

  def create(id: String, data: String): CrudProgram[Unit] = ???
  def read(id: String): CrudProgram[Option[String]] = ???
  def update(id: String, data: String): CrudProgram[Unit] = ???
  def crudDelete(id: String): CrudProgram[Boolean] = ???

  // Exercise 3: Build programs - write a program using the DSL
  // TODO: Build a logging program using for-comprehension.
  def exercise3_buildProgram(): LogProgram[String] = {
    // Program: log info "starting", get log level, log info "done", return level
    ???
  }

  // Exercise 4: Interpret to Id (testing) - create an Id interpreter for testing
  // TODO: Create a FunctionK that interprets LogAlgebra to Id.
  def exercise4_idInterpreter(): cats.arrow.FunctionK[LogAlgebra, Id] = {
    // Interpret to Id:
    // LogInfo/LogWarn/LogError => () (no-op)
    // GetLogLevel => "INFO"
    ???
  }

  // Exercise 5: Interpret with state - create an interpreter that collects log messages
  // TODO: Create an interpreter that accumulates log messages in a list.
  type LogState[A] = cats.data.State[List[String], A]

  def exercise5_stateInterpreter(): cats.arrow.FunctionK[LogAlgebra, LogState] = {
    // Interpret to State[List[String], A]:
    // LogInfo(msg) => append "[INFO] msg" to state
    // LogWarn(msg) => append "[WARN] msg" to state
    // LogError(msg) => append "[ERROR] msg" to state
    // GetLogLevel => return "DEBUG" without modifying state
    ???
  }

  // Exercise 6: Compose DSLs - show pattern for combining two Free DSLs
  // TODO: Demonstrate DSL composition using EitherK/Coproduct concept.
  def exercise6_composeDSLs(): CrudProgram[(Option[String], Boolean)] = {
    // Build a CRUD program: create, read, delete, return (readResult, deleteResult)
    ???
  }

  // Exercise 7: Free program optimization concept - show how Free enables optimization
  // TODO: Demonstrate how Free programs can be analyzed/optimized before interpretation.
  def exercise7_optimization(): List[String] = {
    // Build a program and "analyze" it by collecting operation names
    val program: LogProgram[Unit] = for {
      _ <- logInfo("step 1")
      _ <- logWarn("step 2")
      _ <- logError("step 3")
    } yield ()

    // Create an interpreter that just collects operation types
    val collector: cats.arrow.FunctionK[LogAlgebra, LogState] = new (LogAlgebra ~> LogState) {
      def apply[A](fa: LogAlgebra[A]): LogState[A] = fa match {
        case LogInfo(_) => cats.data.State.modify[List[String]](_ :+ "INFO").asInstanceOf[LogState[A]]
        case LogWarn(_) => cats.data.State.modify[List[String]](_ :+ "WARN").asInstanceOf[LogState[A]]
        case LogError(_) => cats.data.State.modify[List[String]](_ :+ "ERROR").asInstanceOf[LogState[A]]
        case GetLogLevel => cats.data.State.pure[List[String], String]("INFO").asInstanceOf[LogState[A]]
      }
    }

    // Run the collector and return the collected operation types
    ???
  }

  // Exercise 8: Free vs Tagless Final - compare Free approach to tagless
  // TODO: Show the tagless equivalent and discuss trade-offs.
  trait LogAlgebraTF[F[_]] {
    def logInfo(msg: String): F[Unit]
    def logWarn(msg: String): F[Unit]
    def getLogLevel: F[String]
  }

  def exercise8_taglessComparison(): String = {
    // Create a tagless final interpreter for Id
    val tfInterpreter: LogAlgebraTF[Id] = new LogAlgebraTF[Id] {
      def logInfo(msg: String): Id[Unit] = ()
      def logWarn(msg: String): Id[Unit] = ()
      def getLogLevel: Id[String] = "INFO"
    }

    // Use the tagless interpreter directly
    // Return the log level
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1 - verify smart constructors
    val r1 = logInfo("test")
    println(s"Exercise 1 passed: DSL smart constructors created")

    // Exercise 2 - verify CRUD constructors
    val r2 = create("1", "data")
    println(s"Exercise 2 passed: CRUD smart constructors created")

    // Exercise 3
    val r3program = exercise3_buildProgram()
    val r3interp = exercise4_idInterpreter()
    val r3 = r3program.foldMap(r3interp)
    assert(r3 == "INFO", s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: build program => $r3")

    // Exercise 4
    val r4 = exercise4_idInterpreter()
    println(s"Exercise 4 passed: Id interpreter created")

    // Exercise 5
    val r5interp = exercise5_stateInterpreter()
    val r5program = for {
      _ <- logInfo("hello")
      _ <- logWarn("careful")
      _ <- logError("boom")
    } yield ()
    val (r5logs, _) = r5program.foldMap(r5interp).run(Nil).value
    assert(r5logs.size == 3, s"Exercise 5 failed: $r5logs")
    assert(r5logs.head.contains("INFO"), s"Exercise 5 failed: ${r5logs.head}")
    println(s"Exercise 5 passed: state interpreter => $r5logs")

    // Exercise 6
    val r6program = exercise6_composeDSLs()
    val crudInterp: cats.arrow.FunctionK[CrudAlgebra, Id] = new (CrudAlgebra ~> Id) {
      val store = scala.collection.mutable.Map.empty[String, String]
      def apply[A](fa: CrudAlgebra[A]): Id[A] = fa match {
        case Create(id, data) => store(id) = data; ()
        case Read(id) => store.get(id)
        case Update(id, data) => store(id) = data; ()
        case CrudDelete(id) => store.remove(id).isDefined
      }
    }
    val r6 = r6program.foldMap(crudInterp)
    println(s"Exercise 6 passed: compose DSLs => $r6")

    // Exercise 7
    val r7 = exercise7_optimization()
    assert(r7 == List("INFO", "WARN", "ERROR"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: optimization => $r7")

    // Exercise 8
    val r8 = exercise8_taglessComparison()
    assert(r8 == "INFO", s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: tagless comparison => $r8")

    println("\nAll Cats051_FreeDSL exercises passed!")
  }
}
