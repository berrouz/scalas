package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP021 - Free Monad
 *
 * The Free monad turns any Functor F into a Monad, allowing you to build
 * a DSL as data and then interpret it separately. Free[F, A] is either
 * Pure(a) or Suspend(F[Free[F, A]]).
 */
object AdvFP021_FreeMonad {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // ============================================================
  // Exercise 1: Define the Free monad
  // Free[F, A] = Pure(A) | Suspend(F[Free[F, A]])
  // ============================================================
  sealed trait Free[F[_], A] {
    def flatMap[B](f: A => Free[F, B])(implicit F: Functor[F]): Free[F, B]
    def map[B](f: A => B)(implicit F: Functor[F]): Free[F, B]
  }

  // TODO: Implement Pure and Suspend cases with flatMap and map
  case class Pure[F[_], A](a: A) extends Free[F, A] {
    def flatMap[B](f: A => Free[F, B])(implicit F: Functor[F]): Free[F, B] = ???
    def map[B](f: A => B)(implicit F: Functor[F]): Free[F, B] = ???
  }

  case class Suspend[F[_], A](fa: F[Free[F, A]]) extends Free[F, A] {
    def flatMap[B](f: A => Free[F, B])(implicit F: Functor[F]): Free[F, B] = ???
    def map[B](f: A => B)(implicit F: Functor[F]): Free[F, B] = ???
  }

  // ============================================================
  // Exercise 2: Implement liftF
  // Lift a single F[A] into Free[F, A].
  // ============================================================
  // TODO: Implement liftF
  def liftF[F[_]: Functor, A](fa: F[A]): Free[F, A] = ???

  // ============================================================
  // Exercise 3: Implement foldMap (the interpreter)
  // foldMap transforms Free[F, A] into G[A] given F ~> G and Monad[G].
  // ============================================================
  trait Monad[G[_]] {
    def pure[A](a: A): G[A]
    def flatMap[A, B](ga: G[A])(f: A => G[B]): G[B]
  }

  // TODO: Implement foldMap
  def foldMap[F[_]: Functor, G[_], A](free: Free[F, A])(nt: F ~> G)(implicit M: Monad[G]): G[A] = ???

  // ============================================================
  // Exercise 4: Define a simple Console DSL using Free
  // Operations: PrintLine(msg) and ReadLine
  // ============================================================
  sealed trait ConsoleOp[A]
  case class PrintLine(msg: String) extends ConsoleOp[Unit]
  case object ReadLine extends ConsoleOp[String]

  // TODO: Implement Functor for ConsoleOp
  // Note: ConsoleOp is not a functor in the traditional sense because
  // the type parameter is in return position. We'll use a different encoding.
  // Use FreeA with a next continuation instead.
  sealed trait ConsoleF[+A]
  case class PrintLineF[A](msg: String, next: A) extends ConsoleF[A]
  case class ReadLineF[A](next: String => A) extends ConsoleF[A]

  implicit val consoleFunctor: Functor[ConsoleF] = ???

  type Console[A] = Free[ConsoleF, A]

  // TODO: Smart constructors
  def printLine(msg: String): Console[Unit] = ???
  def readLine: Console[String] = ???

  // ============================================================
  // Exercise 5: Write a Console program using the DSL
  // The program should: print "What is your name?", read a line,
  // print "Hello, <name>!"
  // ============================================================
  // TODO: Write a greeting program
  def greetingProgram: Console[Unit] = ???

  // ============================================================
  // Exercise 6: Write an interpreter for Console that uses a mock
  // (list of inputs) and collects outputs.
  // ============================================================
  case class MockIO[A](run: (List[String], List[String]) => (A, List[String], List[String]))

  implicit val mockIOMonad: Monad[MockIO] = new Monad[MockIO] {
    def pure[A](a: A) = MockIO((inputs, outputs) => (a, inputs, outputs))
    def flatMap[A, B](ga: MockIO[A])(f: A => MockIO[B]) = MockIO { (inputs, outputs) =>
      val (a, remainingInputs, newOutputs) = ga.run(inputs, outputs)
      f(a).run(remainingInputs, newOutputs)
    }
  }

  // TODO: Implement the mock interpreter (ConsoleF ~> MockIO)
  val mockInterpreter: ConsoleF ~> MockIO = ???

  // ============================================================
  // Exercise 7: Compose two Free programs
  // Implement a program that runs the greeting twice.
  // Show that Free programs compose via flatMap.
  // ============================================================
  // TODO: Compose the greeting program to run twice
  def greetTwice: Console[Unit] = ???

  // ============================================================
  // Exercise 8: Implement a simple Key-Value store DSL
  // Operations: Get(key), Put(key, value), Delete(key)
  // ============================================================
  sealed trait KvStoreF[+A]
  case class Get[A](key: String, next: Option[String] => A) extends KvStoreF[A]
  case class Put[A](key: String, value: String, next: A) extends KvStoreF[A]
  case class Delete[A](key: String, next: A) extends KvStoreF[A]

  // TODO: Implement Functor for KvStoreF
  implicit val kvStoreFunctor: Functor[KvStoreF] = ???

  type KvStore[A] = Free[KvStoreF, A]

  // TODO: Smart constructors
  def get(key: String): KvStore[Option[String]] = ???
  def put(key: String, value: String): KvStore[Unit] = ???
  def delete(key: String): KvStore[Unit] = ???

  // TODO: Write a program that puts "name" -> "Alice", gets "name", returns the result
  def kvProgram: KvStore[Option[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1-2: Free monad basics
    val p: Free[ConsoleF, Int] = Pure[ConsoleF, Int](42)
    println("Exercise 1-2 passed: Free monad defined")

    // Exercise 3: foldMap (tested via Exercise 6)

    // Exercise 4: Console DSL
    val prog = printLine("hello")
    println("Exercise 4 passed: Console DSL defined")

    // Exercise 5: Greeting program
    val gp = greetingProgram
    println("Exercise 5 passed: Greeting program defined")

    // Exercise 6: Mock interpreter
    val result = foldMap(greetingProgram)(mockInterpreter).run(List("Alice"), Nil)
    val (_, _, outputs) = result
    assert(outputs == List("What is your name?", "Hello, Alice!"))
    println("Exercise 6 passed: Mock interpreter works")

    // Exercise 7: Compose programs
    val result7 = foldMap(greetTwice)(mockInterpreter).run(List("Alice", "Bob"), Nil)
    val (_, _, outputs7) = result7
    assert(outputs7 == List("What is your name?", "Hello, Alice!", "What is your name?", "Hello, Bob!"))
    println("Exercise 7 passed: Program composition works")

    // Exercise 8: KV Store
    type MapState[A] = Map[String, String] => (A, Map[String, String])
    implicit val mapStateMonad: Monad[MapState] = new Monad[MapState] {
      def pure[A](a: A): MapState[A] = m => (a, m)
      def flatMap[A, B](ga: MapState[A])(f: A => MapState[B]): MapState[B] =
        m => { val (a, m2) = ga(m); f(a)(m2) }
    }

    val kvInterp: KvStoreF ~> MapState = new (KvStoreF ~> MapState) {
      def apply[A](fa: KvStoreF[A]): MapState[A] = fa match {
        case Get(k, next) => m => (next(m.get(k)), m)
        case Put(k, v, next) => m => (next, m + (k -> v))
        case Delete(k, next) => m => (next, m - k)
      }
    }
    val (kvResult, _) = foldMap(kvProgram)(kvInterp).apply(Map.empty)
    assert(kvResult == Some("Alice"))
    println("Exercise 8 passed: KV Store DSL works")

    println("\nAll exercises passed!")
  }
}
