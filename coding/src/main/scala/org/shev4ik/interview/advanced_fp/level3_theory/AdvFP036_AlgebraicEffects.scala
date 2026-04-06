package org.shev4ik.interview.advanced_fp.level3_theory

/**
 * AdvFP036 - Algebraic Effects
 *
 * Algebraic effects separate effect declaration from interpretation.
 * Effects are operations; handlers define their semantics.
 * This is related to Free monads but more general (supports multi-shot continuations).
 */
object AdvFP036_AlgebraicEffects {

  // ============================================================
  // Exercise 1: Model algebraic effects as a sealed trait
  // An effect has operations; a handler provides implementations.
  // ============================================================
  sealed trait Effect[+A]
  case class Pure[A](value: A) extends Effect[A]
  case class FlatMap[A, B](eff: Effect[A], f: A => Effect[B]) extends Effect[B]

  // Operations
  case class Print(msg: String) extends Effect[Unit]
  case class Read() extends Effect[String]
  case class Raise(error: String) extends Effect[Nothing]

  // TODO: Implement Monad-like operations for Effect
  def pure[A](a: A): Effect[A] = ???
  def flatMap[A, B](eff: Effect[A])(f: A => Effect[B]): Effect[B] = ???
  def map[A, B](eff: Effect[A])(f: A => B): Effect[B] = ???

  // ============================================================
  // Exercise 2: Implement an effect handler for IO effects
  // The handler interprets Print and Read using provided inputs/outputs.
  // ============================================================
  case class IOState(inputs: List[String], outputs: List[String])

  // TODO: Implement the IO handler that returns (A, IOState)
  def handleIO[A](eff: Effect[A], state: IOState): Either[String, (A, IOState)] = ???

  // ============================================================
  // Exercise 3: Write a program using algebraic effects
  // Read a name, print a greeting, return the name.
  // ============================================================
  // TODO: Write the greeting program using Effect
  def greetProgram: Effect[String] = ???

  // ============================================================
  // Exercise 4: Implement an error effect handler
  // Handle Raise by returning Left(error).
  // ============================================================
  // TODO: Implement the error handler
  def handleError[A](eff: Effect[A]): Either[String, A] = ???

  // ============================================================
  // Exercise 5: Implement effect composition
  // Show how to compose two effect handlers.
  // First handle IO, then handle errors.
  // ============================================================
  // TODO: Compose IO and error handling
  def handleAll[A](eff: Effect[A], state: IOState): Either[String, (A, IOState)] = ???

  // ============================================================
  // Exercise 6: Model resumptions (one-shot continuations)
  // A resumption captures "the rest of the computation" after an effect.
  // ============================================================
  sealed trait Resumption[+A]
  case class Done[A](value: A) extends Resumption[A]
  case class Suspended[A](effect: Effect[_], continue: Any => Resumption[A]) extends Resumption[A]

  // TODO: Convert Effect to Resumption (step-by-step execution)
  def toResumption[A](eff: Effect[A]): Resumption[A] = ???

  // TODO: Run a resumption step-by-step
  def runResumption[A](res: Resumption[A], state: IOState): Either[String, (A, IOState)] = ???

  // ============================================================
  // Exercise 7: Show relation to Free monad
  // Algebraic effects ≈ Free monad + handlers.
  // Implement a conversion between our Effect type and a Free-like structure.
  // ============================================================
  sealed trait Free[F[_], A]
  case class FPure[F[_], A](a: A) extends Free[F, A]
  case class FSuspend[F[_], A](fa: F[Free[F, A]]) extends Free[F, A]

  sealed trait EffOp[+A]
  case class PrintOp[A](msg: String, next: A) extends EffOp[A]
  case class ReadOp[A](next: String => A) extends EffOp[A]

  // TODO: Convert Effect[A] to Free[EffOp, A] (for the IO subset)
  // This is conceptual - implement for a simple case
  def effectToFree(eff: Effect[String]): Free[EffOp, String] = ???

  // ============================================================
  // Exercise 8: Show relation to ZIO
  // ZIO[-R, +E, +A] models effects with environment, error, and success.
  // Implement a minimal ZIO-like type and show it handles effects.
  // ============================================================
  case class MiniZIO[-R, +E, +A](run: R => Either[E, A]) {
    def map[B](f: A => B): MiniZIO[R, E, B] =
      MiniZIO(r => run(r).map(f))

    def flatMap[R1 <: R, E1 >: E, B](f: A => MiniZIO[R1, E1, B]): MiniZIO[R1, E1, B] =
      MiniZIO(r => run(r).flatMap(a => f(a).run(r)))
  }

  trait HasConsole {
    def print(msg: String): Unit
    def read(): String
  }

  // TODO: Implement console operations as MiniZIO
  def zPrint(msg: String): MiniZIO[HasConsole, Nothing, Unit] = ???
  def zRead: MiniZIO[HasConsole, Nothing, String] = ???
  def zFail[R](error: String): MiniZIO[R, String, Nothing] = ???

  // TODO: Write the greeting program using MiniZIO
  def zGreet: MiniZIO[HasConsole, String, String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Effect monad
    val e = flatMap(pure(42))(n => pure(n.toString))
    println("Exercise 1 passed: Effect monad operations")

    // Exercise 2: IO handler
    val prog = greetProgram
    val state = IOState(List("Alice"), Nil)
    val result = handleIO(prog, state)
    assert(result.isRight)
    val (name, finalState) = result.toOption.get
    assert(name == "Alice")
    assert(finalState.outputs == List("Hello, Alice!"))
    println("Exercise 2-3 passed: IO handler and greeting program")

    // Exercise 4: Error handler
    val errProg = flatMap(pure(42))(n =>
      if (n > 100) Raise("too big") else pure(n.toString)
    )
    assert(handleError(errProg) == Right("42"))
    val errProg2 = flatMap(pure(200))(n =>
      if (n > 100) Raise("too big") else pure(n.toString)
    )
    assert(handleError(errProg2) == Left("too big"))
    println("Exercise 4 passed: Error handler")

    // Exercise 5: Composed handlers
    val composedResult = handleAll(greetProgram, state)
    assert(composedResult.isRight)
    println("Exercise 5 passed: Composed handlers")

    // Exercise 6: Resumptions
    val res = toResumption(pure(42))
    val resResult = runResumption(res, state)
    assert(resResult == Right((42, state)))
    println("Exercise 6 passed: Resumptions")

    // Exercise 7: Effect to Free
    println("Exercise 7 passed: Effect to Free relation")

    // Exercise 8: MiniZIO
    val mockConsole = new HasConsole {
      var printed = List.empty[String]
      val inputs = List("Bob")
      var inputIdx = 0
      def print(msg: String): Unit = { printed = printed :+ msg }
      def read(): String = { val r = inputs(inputIdx); inputIdx += 1; r }
    }
    val zResult = zGreet.run(mockConsole)
    assert(zResult == Right("Bob"))
    println("Exercise 8 passed: MiniZIO")

    println("\nAll exercises passed!")
  }
}
