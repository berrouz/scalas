package org.shev4ik.interview.scala_core.level4_expert

object Core122_EffectSystems {

  // Exercise 1: Effect tracking
  // TODO: Define a simple IO monad that tracks effects
  sealed trait IO[+A] {
    def map[B](f: A => B): IO[B] = FlatMap(this, (a: A) => Pure(f(a)))
    def flatMap[B](f: A => IO[B]): IO[B] = FlatMap(this, f)
  }

  case class Pure[A](value: A) extends IO[A]
  case class Delay[A](thunk: () => A) extends IO[A]
  case class FlatMap[A, B](fa: IO[A], f: A => IO[B]) extends IO[B]

  object IO {
    def pure[A](a: A): IO[A] = Pure(a)
    def delay[A](a: => A): IO[A] = Delay(() => a)
  }

  // TODO: Implement an unsafe runner
  def unsafeRun[A](io: IO[A]): A = ???

  // Exercise 2: Tagged IO
  // TODO: Define tagged IO types for different effect categories
  sealed trait Effect
  sealed trait Console extends Effect
  sealed trait FileIO extends Effect
  sealed trait Network extends Effect

  // TODO: Define a tagged IO that tracks which effects are used
  class TaggedIO[E <: Effect, A](val run: () => A) {
    def map[B](f: A => B): TaggedIO[E, B] = ???
    def flatMap[B](f: A => TaggedIO[E, B]): TaggedIO[E, B] = ???
  }

  def consoleIO[A](a: => A): TaggedIO[Console, A] = ???
  def fileIO[A](a: => A): TaggedIO[FileIO, A] = ???

  // Exercise 3: Effect constraint
  // TODO: Define a method that requires specific effects
  trait HasEffect[E <: Effect] {
    def runEffect[A](io: TaggedIO[E, A]): A
  }

  implicit val hasConsole: HasEffect[Console] = ???
  implicit val hasFileIO: HasEffect[FileIO] = ???

  def withConsole[A](io: TaggedIO[Console, A])(implicit h: HasEffect[Console]): A = ???

  // Exercise 4: Capability-based effects
  // TODO: Define capabilities as traits that must be provided
  trait ConsoleCapability {
    def printLine(s: String): Unit
    def readLine(): String
  }

  trait FileCapability {
    def readFile(path: String): String
    def writeFile(path: String, content: String): Unit
  }

  // TODO: Write a program that requires ConsoleCapability
  def greetUser(name: String)(implicit console: ConsoleCapability): String = ???

  // Exercise 5: Effect polymorphism
  // TODO: Define programs that are polymorphic over their effect type
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  trait ConsoleAlg[F[_]] {
    def putLine(s: String): F[Unit]
  }

  // TODO: Implement ConsoleAlg for IO
  implicit val ioConsole: ConsoleAlg[IO] = ???
  implicit val ioMonad: Monad[IO] = ???

  def program[F[_]: Monad: ConsoleAlg](name: String): F[Unit] = ???

  // Exercise 6: Effect composition
  // TODO: Compose multiple effects together
  trait Logger[F[_]] {
    def log(msg: String): F[Unit]
  }

  trait Store[F[_]] {
    def get(key: String): F[Option[String]]
    def put(key: String, value: String): F[Unit]
  }

  // TODO: Write a program using both Logger and Store
  def logAndStore[F[_]: Monad](key: String, value: String)(
    implicit L: Logger[F], S: Store[F]
  ): F[Unit] = ???

  // Exercise 7: Effect interpretation
  // TODO: Implement interpreters for the algebras
  type Id[A] = A
  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def pure[A](a: A): A = a
    def flatMap[A, B](fa: A)(f: A => B): B = f(fa)
  }

  def idLogger: Logger[Id] = ???
  def idStore(initial: Map[String, String]): Store[Id] = ???

  // Exercise 8: Effect safety
  // TODO: Show how the type system prevents running effectful code without proper capability
  //       Define a "safe" runner that requires all effects to be provided
  trait EffectRunner[F[_]] {
    def run[A](fa: F[A]): A
  }

  implicit val ioRunner: EffectRunner[IO] = ???

  def safeRun[F[_], A](fa: F[A])(implicit runner: EffectRunner[F]): A = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val io1 = IO.pure(42)
    assert(unsafeRun(io1) == 42)
    val io2 = IO.delay(21 * 2)
    assert(unsafeRun(io2) == 42)
    val io3 = io1.map(_ + 1)
    assert(unsafeRun(io3) == 43)
    val io4 = io1.flatMap(x => IO.pure(x.toString))
    assert(unsafeRun(io4) == "42")

    // Exercise 2
    val cio = consoleIO("hello from console")
    assert(cio.run() == "hello from console")

    // Exercise 3
    assert(withConsole(consoleIO(42)) == 42)

    // Exercise 4
    implicit val testConsole: ConsoleCapability = new ConsoleCapability {
      def printLine(s: String): Unit = ()
      def readLine(): String = "test"
    }
    assert(greetUser("Alice").contains("Alice"))

    // Exercise 5
    val prog = program[IO]("World")
    assert(prog != null) // Just verify it compiles and creates an IO

    // Exercise 6 & 7
    implicit val logger: Logger[Id] = idLogger
    implicit val store: Store[Id] = idStore(Map.empty)
    logAndStore[Id]("key", "value")
    assert(store.get("key") == Some("value"))

    // Exercise 8
    assert(safeRun(IO.pure(42)) == 42)

    println("All Core122_EffectSystems exercises passed!")
  }
}
