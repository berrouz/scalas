package org.shev4ik.interview.cats_fp.level4_expert

import cats._
import cats.implicits._
import cats.data._
import cats.free.Free

/**
 * Cats 060 - FreeT (Free Monad Transformer)
 *
 * FreeT[F, M, A] is the transformer version of Free. It allows interleaving
 * effects from the base monad M with the free operations from F.
 * This enables building DSLs that can perform effects between free steps.
 */
object Cats060_FreeT {

  // Simplified FreeT model for exercises
  // In real code, use cats.free.FreeT
  sealed trait SimpleFreeT[F[_], M[_], A]
  case class PureFT[F[_], M[_], A](a: A) extends SimpleFreeT[F, M, A]
  case class SuspendFT[F[_], M[_], A](fa: M[Either[F[SimpleFreeT[F, M, A]], A]]) extends SimpleFreeT[F, M, A]

  // A simple DSL for exercises
  sealed trait ConsoleOp[A]
  case class Println(msg: String) extends ConsoleOp[Unit]
  case object Readln extends ConsoleOp[String]

  // Exercise 1: FreeT concept - model lifting a free operation into FreeT
  // TODO: Show how to lift an F operation into a FreeT context.
  type ConsoleState[A] = State[List[String], A]
  type ConsoleProgram[A] = Free[ConsoleOp, A]

  def exercise1_liftF(): ConsoleProgram[Unit] = {
    // Lift a Println operation into Free (simulating FreeT.liftF)
    ???
  }

  // Exercise 2: FreeT + State - combine Free DSL with State monad
  // TODO: Model a program that uses console operations and tracks state.
  def exercise2_freeTState(): (List[String], String) = {
    // Simulate FreeT[ConsoleOp, State, A]:
    // Use State to track output, and ConsoleOp for the DSL
    val program: ConsoleState[String] = for {
      _ <- State.modify[List[String]](_ :+ "Hello")
      _ <- State.modify[List[String]](_ :+ "World")
      result <- State.pure[List[String], String]("done")
    } yield result

    // Run the program
    ???
  }

  // Exercise 3: Interpret FreeT - interpret with interleaved effects
  // TODO: Build an interpreter that handles free operations and base effects.
  def exercise3_interpret(): (List[String], Unit) = {
    // Model: interpret ConsoleOp into State[List[String], _]
    val interpreter: ConsoleOp ~> ConsoleState = new (ConsoleOp ~> ConsoleState) {
      def apply[A](fa: ConsoleOp[A]): ConsoleState[A] = fa match {
        case Println(msg) => State.modify[List[String]](_ :+ msg)
        case Readln => State.pure[List[String], String]("test-input").asInstanceOf[ConsoleState[A]]
      }
    }

    // Build and interpret a program
    val program: ConsoleProgram[Unit] = for {
      _ <- Free.liftF[ConsoleOp, Unit](Println("hello"))
      _ <- Free.liftF[ConsoleOp, Unit](Println("world"))
    } yield ()

    // Interpret using foldMap
    val stateResult: ConsoleState[Unit] = ???

    stateResult.run(Nil).value
  }

  // Exercise 4: FreeT + IO concept - model FreeT with IO-like base monad
  // TODO: Show how FreeT enables interleaving DSL steps with IO effects.
  sealed trait DbOp[A]
  case class Query(sql: String) extends DbOp[String]
  case class Execute(sql: String) extends DbOp[Int]

  def exercise4_freeTIO(): (List[String], List[String]) = {
    var ioLog: List[String] = Nil
    type IOLike[A] = State[List[String], A]

    val dbInterpreter: DbOp ~> IOLike = new (DbOp ~> IOLike) {
      def apply[A](fa: DbOp[A]): IOLike[A] = fa match {
        case Query(sql) =>
          State[List[String], String] { log =>
            ioLog = ioLog :+ s"querying: $sql"
            (log :+ s"query: $sql", s"result of $sql")
          }.asInstanceOf[IOLike[A]]
        case Execute(sql) =>
          State[List[String], Int] { log =>
            ioLog = ioLog :+ s"executing: $sql"
            (log :+ s"execute: $sql", 1)
          }.asInstanceOf[IOLike[A]]
      }
    }

    val program = for {
      _ <- Free.liftF[DbOp, Int](Execute("CREATE TABLE users"))
      result <- Free.liftF[DbOp, String](Query("SELECT * FROM users"))
    } yield result

    val (dbLog, _) = program.foldMap(dbInterpreter).run(Nil).value
    (dbLog, ioLog)
  }

  // Exercise 5: FreeT + State - interleave state updates with DSL steps
  // TODO: Build a program that updates state between free operations.
  def exercise5_interleaveState(): (Int, List[String]) = {
    type Counter[A] = State[Int, A]
    var log: List[String] = Nil

    sealed trait TaskOp[A]
    case class DoTask(name: String) extends TaskOp[String]

    val interpreter: TaskOp ~> Counter = new (TaskOp ~> Counter) {
      def apply[A](fa: TaskOp[A]): Counter[A] = fa match {
        case DoTask(name) => State[Int, String] { count =>
          log = log :+ s"task: $name (count=$count)"
          (count + 1, s"done-$name")
        }.asInstanceOf[Counter[A]]
      }
    }

    val program = for {
      _ <- Free.liftF[TaskOp, String](DoTask("task1"))
      _ <- Free.liftF[TaskOp, String](DoTask("task2"))
      _ <- Free.liftF[TaskOp, String](DoTask("task3"))
    } yield ()

    val (count, _) = program.foldMap(interpreter).run(0).value
    ???
  }

  // Exercise 6: FreeT for interleaving effects - complex effect interleaving
  // TODO: Show a pattern where effects are interleaved with DSL operations.
  def exercise6_interleaving(): List[String] = {
    type Log[A] = Writer[List[String], A]

    sealed trait MathOp[A]
    case class AddOp(a: Int, b: Int) extends MathOp[Int]
    case class MulOp(a: Int, b: Int) extends MathOp[Int]

    val interpreter: MathOp ~> Log = new (MathOp ~> Log) {
      def apply[A](fa: MathOp[A]): Log[A] = fa match {
        case AddOp(a, b) => Writer(List(s"add($a,$b)=${a + b}"), (a + b).asInstanceOf[A])
        case MulOp(a, b) => Writer(List(s"mul($a,$b)=${a * b}"), (a * b).asInstanceOf[A])
      }
    }

    val program = for {
      sum <- Free.liftF[MathOp, Int](AddOp(3, 4))
      product <- Free.liftF[MathOp, Int](MulOp(sum, 2))
    } yield product

    // Run and extract the log
    ???
  }

  // Exercise 7: FreeT vs Free + transformer - compare approaches
  // TODO: Show equivalence between FreeT and Free + monad transformer.
  def exercise7_comparison(): (String, String) = {
    // Approach 1: Free interpreted to a transformer stack
    val freeApproach = "Free[F, A] foldMap to StateT/WriterT/etc"

    // Approach 2: FreeT[F, M, A] with effects baked in
    val freeTApproach = "FreeT[F, M, A] interleaves M effects with F operations"

    // Return descriptions of trade-offs
    ???
  }

  // Exercise 8: FreeT patterns - practical patterns with FreeT
  // TODO: Demonstrate a practical FreeT pattern for a workflow.
  def exercise8_patterns(): (List[String], String) = {
    type Audit[A] = Writer[List[String], A]

    sealed trait WorkflowOp[A]
    case class Step(name: String) extends WorkflowOp[String]
    case class Decide(condition: Boolean) extends WorkflowOp[Boolean]

    val interpreter: WorkflowOp ~> Audit = new (WorkflowOp ~> Audit) {
      def apply[A](fa: WorkflowOp[A]): Audit[A] = fa match {
        case Step(name) =>
          Writer(List(s"step: $name"), s"completed-$name").asInstanceOf[Audit[A]]
        case Decide(cond) =>
          Writer(List(s"decide: $cond"), cond).asInstanceOf[Audit[A]]
      }
    }

    val workflow = for {
      _ <- Free.liftF[WorkflowOp, String](Step("validate"))
      approved <- Free.liftF[WorkflowOp, Boolean](Decide(true))
      result <- if (approved)
        Free.liftF[WorkflowOp, String](Step("process"))
      else
        Free.pure[WorkflowOp, String]("rejected")
    } yield result

    // Interpret and return (audit log, final result)
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_liftF()
    println(s"Exercise 1 passed: FreeT liftF created")

    // Exercise 2
    val (r2state, r2result) = exercise2_freeTState()
    assert(r2state == List("Hello", "World"), s"Exercise 2 failed: $r2state")
    assert(r2result == "done", s"Exercise 2 failed: $r2result")
    println(s"Exercise 2 passed: FreeT + State => state=$r2state, result=$r2result")

    // Exercise 3
    val (r3log, _) = exercise3_interpret()
    assert(r3log == List("hello", "world"), s"Exercise 3 failed: $r3log")
    println(s"Exercise 3 passed: interpret => $r3log")

    // Exercise 4
    val (r4db, r4io) = exercise4_freeTIO()
    assert(r4db.size == 2, s"Exercise 4 failed: $r4db")
    println(s"Exercise 4 passed: FreeT+IO => db=$r4db, io=$r4io")

    // Exercise 5
    val (r5count, r5log) = exercise5_interleaveState()
    assert(r5count == 3, s"Exercise 5 failed: count=$r5count")
    assert(r5log.size == 3, s"Exercise 5 failed: log=$r5log")
    println(s"Exercise 5 passed: interleave state => count=$r5count, log=$r5log")

    // Exercise 6
    val r6 = exercise6_interleaving()
    assert(r6.size == 2, s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: interleaving => $r6")

    // Exercise 7
    val (r7a, r7b) = exercise7_comparison()
    assert(r7a.nonEmpty && r7b.nonEmpty, s"Exercise 7 failed")
    println(s"Exercise 7 passed: comparison => free=$r7a, freeT=$r7b")

    // Exercise 8
    val (r8log, r8result) = exercise8_patterns()
    assert(r8log.nonEmpty, s"Exercise 8 failed: log=$r8log")
    assert(r8result.contains("completed"), s"Exercise 8 failed: result=$r8result")
    println(s"Exercise 8 passed: patterns => log=$r8log, result=$r8result")

    println("\nAll Cats060_FreeT exercises passed!")
  }
}
