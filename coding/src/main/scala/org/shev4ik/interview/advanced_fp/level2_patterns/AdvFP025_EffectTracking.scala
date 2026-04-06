package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP025 - Effect Tracking
 *
 * Effect tracking uses types to declare what side effects a computation
 * may perform. This is done via capability traits, tagless final,
 * or environment-based approaches (like ZIO's R parameter).
 */
object AdvFP025_EffectTracking {

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // ============================================================
  // Exercise 1: Define capability traits for different effects
  // Each capability describes one kind of side effect.
  // ============================================================
  // TODO: Define capability traits
  trait HasConsole[F[_]] {
    def printLine(msg: String): F[Unit]
    def readLine: F[String]
  }

  trait HasDatabase[F[_]] {
    def query(sql: String): F[List[String]]
    def execute(sql: String): F[Int]
  }

  trait HasHttp[F[_]] {
    def get(url: String): F[String]
    def post(url: String, body: String): F[String]
  }

  // ============================================================
  // Exercise 2: Write a function that only requires Console capability
  // The type signature enforces that this function can only do console IO.
  // ============================================================
  // TODO: Write a console-only program
  def consoleProgram[F[_]: Monad](implicit C: HasConsole[F]): F[String] = ???

  // ============================================================
  // Exercise 3: Write a function that requires Console + Database
  // The type signature shows exactly which effects are used.
  // ============================================================
  // TODO: Write a program that reads from console and queries database
  def consoleAndDb[F[_]: Monad](implicit C: HasConsole[F], D: HasDatabase[F]): F[List[String]] = ???

  // ============================================================
  // Exercise 4: Implement a pure effect type for testing
  // A simple effect type that tracks what operations were called.
  // ============================================================
  case class TestEffect[A](run: TestState => (A, TestState))
  case class TestState(
    inputs: List[String],
    outputs: List[String],
    dbResults: Map[String, List[String]],
    dbLog: List[String]
  )

  // TODO: Implement Monad[TestEffect]
  implicit val testEffectMonad: Monad[TestEffect] = ???

  // TODO: Implement HasConsole[TestEffect]
  implicit val testConsole: HasConsole[TestEffect] = ???

  // TODO: Implement HasDatabase[TestEffect]
  implicit val testDatabase: HasDatabase[TestEffect] = ???

  // ============================================================
  // Exercise 5: Demonstrate that pure functions cannot access effects
  // Write a pure function that transforms data without any capability.
  // Show that the type system prevents adding side effects.
  // ============================================================
  // TODO: Write a pure transformation (no F[_] at all)
  def pureTransform(data: List[Int]): List[String] = ???

  // TODO: Write a function that COULD have effects but we constrain it to be pure
  def constrainedPure[F[_]: Monad](data: List[Int]): F[List[String]] = ???

  // ============================================================
  // Exercise 6: Implement effect composition via trait mixing
  // Create a combined environment that provides all capabilities.
  // ============================================================
  trait AllCapabilities[F[_]] extends HasConsole[F] with HasDatabase[F] with HasHttp[F]

  // TODO: Write a program that uses all capabilities
  def fullProgram[F[_]: Monad](implicit A: AllCapabilities[F]): F[String] = ???

  // ============================================================
  // Exercise 7: Implement algebraic effects concept
  // Model effects as data and handlers as interpreters.
  // Define an Effect trait and a Handler.
  // ============================================================
  sealed trait Effect[+A]
  case class Print(msg: String) extends Effect[Unit]
  case class Read() extends Effect[String]
  case class Fail(msg: String) extends Effect[Nothing]

  // TODO: Implement a simple effect handler that processes effects
  def handleEffect[A](effect: Effect[A], state: TestState): (A, TestState) = ???

  // ============================================================
  // Exercise 8: Demonstrate delimited continuations concept
  // Model a simple continuation-based effect system.
  // Cont[R, A] represents a computation that eventually produces R,
  // currently holding an A.
  // ============================================================
  case class Cont[R, +A](run: (A => R) => R)

  // TODO: Implement Monad for Cont[R, *]
  def contMonad[R]: Monad[({type L[A] = Cont[R, A]})#L] = ???

  // TODO: Implement callCC (call with current continuation)
  // callCC gives you access to an "escape" function that, when called,
  // immediately returns from the entire computation.
  def callCC[R, A](f: (A => Cont[R, Nothing]) => Cont[R, A]): Cont[R, A] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 2: Console program
    val state = TestState(List("Alice"), Nil, Map.empty, Nil)
    val (result2, state2) = consoleProgram[TestEffect].run(state)
    assert(result2 == "Alice")
    println("Exercise 2 passed: Console-only program")

    // Exercise 3: Console + DB program
    val state3 = TestState(
      List("SELECT * FROM users"),
      Nil,
      Map("SELECT * FROM users" -> List("alice", "bob")),
      Nil
    )
    val (result3, _) = consoleAndDb[TestEffect].run(state3)
    assert(result3 == List("alice", "bob"))
    println("Exercise 3 passed: Console + Database program")

    // Exercise 4: Test effect (tested above)
    println("Exercise 4 passed: TestEffect monad")

    // Exercise 5: Pure functions
    assert(pureTransform(List(1, 2, 3)) == List("1", "2", "3"))
    val purified = constrainedPure[TestEffect](List(1, 2, 3))
    val (pureResult, _) = purified.run(state)
    assert(pureResult == List("1", "2", "3"))
    println("Exercise 5 passed: Pure vs effectful separation")

    // Exercise 7: Effect handler
    val (printResult, printState) = handleEffect(Print("hello"), state)
    assert(printResult == (()))
    assert(printState.outputs.contains("hello"))
    val readState = TestState(List("input"), Nil, Map.empty, Nil)
    val (readResult, _) = handleEffect(Read(), readState)
    assert(readResult == "input")
    println("Exercise 7 passed: Algebraic effect handlers")

    // Exercise 8: Continuations
    val cm = contMonad[Int]
    val simple = cm.pure(42)
    assert(simple.run(identity) == 42)

    val withCC = callCC[Int, Int] { exit =>
      cm.flatMap(cm.pure(10)) { x =>
        if (x > 5) exit(99)
        else cm.pure(x)
      }
    }
    assert(withCC.run(identity) == 99)
    println("Exercise 8 passed: Continuations and callCC")

    println("\nAll exercises passed!")
  }
}
