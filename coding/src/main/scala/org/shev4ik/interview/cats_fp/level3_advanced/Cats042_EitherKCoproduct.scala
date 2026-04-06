package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._
import cats.data._
import cats.free.Free

/**
 * Cats 042 - EitherK (Coproduct of Functors)
 *
 * EitherK[F, G, A] represents a coproduct (sum) of two functors F and G.
 * It holds either an F[A] or a G[A]. This is useful for composing
 * multiple DSLs (algebras) when working with Free monads.
 */
object Cats042_EitherKCoproduct {

  // Define two simple DSL algebras
  sealed trait ConsoleOp[A]
  case class PrintLine(msg: String) extends ConsoleOp[Unit]
  case object ReadLine extends ConsoleOp[String]

  sealed trait LogOp[A]
  case class Info(msg: String) extends LogOp[Unit]
  case class Error(msg: String) extends LogOp[Unit]

  // Exercise 1: EitherK creation - create EitherK values from left and right functors
  // TODO: Create EitherK values wrapping ConsoleOp and LogOp.
  def exercise1_createEitherK(): (EitherK[ConsoleOp, LogOp, Unit], EitherK[ConsoleOp, LogOp, Unit]) = {
    // Create a left EitherK wrapping a ConsoleOp
    val consoleOp: EitherK[ConsoleOp, LogOp, Unit] = ???  // EitherK.leftc(PrintLine("hello"))
    // Create a right EitherK wrapping a LogOp
    val logOp: EitherK[ConsoleOp, LogOp, Unit] = ???      // EitherK.rightc(Info("info"))
    (consoleOp, logOp)
  }

  // Exercise 2: Inject - use InjectK to lift operations into a coproduct
  // TODO: Use InjectK to lift algebra operations into EitherK.
  type CombinedOp[A] = EitherK[ConsoleOp, LogOp, A]

  class Console[F[_]](implicit I: InjectK[ConsoleOp, F]) {
    def printLine(msg: String): Free[F, Unit] = ???  // Free.inject[ConsoleOp, F](PrintLine(msg))
    def readLine: Free[F, String] = ???              // Free.inject[ConsoleOp, F](ReadLine)
  }

  object Console {
    implicit def console[F[_]](implicit I: InjectK[ConsoleOp, F]): Console[F] = new Console[F]
  }

  def exercise2_inject(): Free[CombinedOp, Unit] = {
    val console = Console.console[CombinedOp]
    // Use console.printLine to create a Free program
    ???
  }

  // Exercise 3: Natural transformation on EitherK - interpret each side independently
  // TODO: Create natural transformations (FunctionK) for each algebra.
  def exercise3_naturalTransformation(): cats.arrow.FunctionK[ConsoleOp, Id] = {
    // Create a FunctionK that interprets ConsoleOp to Id
    ???
  }

  // Exercise 4: Free monad with EitherK - build a program using combined DSL
  // TODO: Write a Free program that uses both ConsoleOp and LogOp.
  class Log[F[_]](implicit I: InjectK[LogOp, F]) {
    def info(msg: String): Free[F, Unit] = Free.inject[LogOp, F](Info(msg))
    def error(msg: String): Free[F, Unit] = Free.inject[LogOp, F](Error(msg))
  }

  object Log {
    implicit def log[F[_]](implicit I: InjectK[LogOp, F]): Log[F] = new Log[F]
  }

  def exercise4_freeWithEitherK(): Free[CombinedOp, Unit] = {
    val console = Console.console[CombinedOp]
    val log = Log.log[CombinedOp]

    // Build a program: log info, then print line, then log info
    ???
  }

  // Exercise 5: Composing DSLs - demonstrate how EitherK enables DSL composition
  // TODO: Show how two independent DSLs are composed into one.
  def exercise5_composingDSLs(): Free[CombinedOp, String] = {
    val console = Console.console[CombinedOp]
    val log = Log.log[CombinedOp]

    // Compose: log "starting" -> print "Enter name:" -> return "done"
    ???
  }

  // Exercise 6: EitherK pattern matching - fold over EitherK to handle both sides
  // TODO: Use fold on EitherK to handle both left and right cases.
  def exercise6_foldEitherK(): String = {
    val op: EitherK[ConsoleOp, LogOp, Unit] = EitherK.leftc(PrintLine("hello"))

    // Fold over the EitherK to produce a description string
    // Left (ConsoleOp) => "console: <msg>", Right (LogOp) => "log: <msg>"
    ???
  }

  // Exercise 7: Multi-algebra Free programs - programs using more than two algebras
  // TODO: Show the pattern for composing three or more algebras.
  sealed trait MetricsOp[A]
  case class Increment(counter: String) extends MetricsOp[Unit]

  // For 3+ algebras, nest EitherK: EitherK[ConsoleOp, EitherK[LogOp, MetricsOp, ?], ?]
  type LogMetricsOp[A] = EitherK[LogOp, MetricsOp, A]
  type TripleOp[A] = EitherK[ConsoleOp, LogMetricsOp, A]

  def exercise7_multiAlgebra(): Free[TripleOp, Unit] = {
    // Lift a ConsoleOp into the triple coproduct
    ???
  }

  // Exercise 8: Interpreting EitherK - create a combined interpreter
  // TODO: Combine two interpreters into one that handles EitherK.
  def exercise8_interpretEitherK(): String = {
    val consoleInterpreter: cats.arrow.FunctionK[ConsoleOp, Id] = new cats.arrow.FunctionK[ConsoleOp, Id] {
      def apply[A](fa: ConsoleOp[A]): Id[A] = fa match {
        case PrintLine(msg) => ()
        case ReadLine => "test-input"
      }
    }

    val logInterpreter: cats.arrow.FunctionK[LogOp, Id] = new cats.arrow.FunctionK[LogOp, Id] {
      def apply[A](fa: LogOp[A]): Id[A] = fa match {
        case Info(msg) => ()
        case Error(msg) => ()
      }
    }

    // Combine the two interpreters using or (FunctionK#or)
    val combined: cats.arrow.FunctionK[CombinedOp, Id] = ???

    // Interpret a simple program
    val program: Free[CombinedOp, String] = {
      val console = Console.console[CombinedOp]
      console.readLine
    }
    program.foldMap(combined)
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val (r1a, r1b) = exercise1_createEitherK()
    assert(r1a.isLeft, s"Exercise 1 failed: left should be left")
    assert(r1b.isRight, s"Exercise 1 failed: right should be right")
    println(s"Exercise 1 passed: EitherK creation => left=${r1a.isLeft}, right=${r1b.isRight}")

    // Exercise 2
    val r2 = exercise2_inject()
    println(s"Exercise 2 passed: Inject => created Free program")

    // Exercise 3
    val r3 = exercise3_naturalTransformation()
    println(s"Exercise 3 passed: natural transformation created")

    // Exercise 4
    val r4 = exercise4_freeWithEitherK()
    println(s"Exercise 4 passed: Free with EitherK => created combined program")

    // Exercise 5
    val r5 = exercise5_composingDSLs()
    println(s"Exercise 5 passed: composing DSLs => created composed program")

    // Exercise 6
    val r6 = exercise6_foldEitherK()
    assert(r6.contains("console") || r6.contains("hello"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: fold EitherK => $r6")

    // Exercise 7
    val r7 = exercise7_multiAlgebra()
    println(s"Exercise 7 passed: multi-algebra => created triple program")

    // Exercise 8
    val r8 = exercise8_interpretEitherK()
    assert(r8 == "test-input", s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: interpret EitherK => $r8")

    println("\nAll Cats042_EitherKCoproduct exercises passed!")
  }
}
