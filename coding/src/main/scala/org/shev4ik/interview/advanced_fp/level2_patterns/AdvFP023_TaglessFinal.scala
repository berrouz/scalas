package org.shev4ik.interview.advanced_fp.level2_patterns

/**
 * AdvFP023 - Tagless Final
 *
 * Tagless final encodes DSLs as typeclasses parameterized by an effect type F[_].
 * Different interpreters provide different F instances.
 * This avoids the overhead of Free while enabling multiple interpretations.
 */
object AdvFP023_TaglessFinal {

  // Minimal Monad
  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  // Natural transformation
  trait ~>[F[_], G[_]] {
    def apply[A](fa: F[A]): G[A]
  }

  // ============================================================
  // Exercise 1: Define a tagless final Console algebra
  // ============================================================
  // TODO: Define the Console algebra as a trait parameterized by F[_]
  trait Console[F[_]] {
    def printLine(msg: String): F[Unit]
    def readLine: F[String]
  }

  // ============================================================
  // Exercise 2: Write a program using the Console algebra
  // The program should: print "What is your name?", read, print "Hello, <name>!"
  // ============================================================
  // TODO: Write greet program using tagless final style
  def greet[F[_]](implicit C: Console[F], M: Monad[F]): F[Unit] = ???

  // ============================================================
  // Exercise 3: Implement an interpreter using a test/mock effect
  // The test effect tracks inputs and outputs.
  // ============================================================
  case class TestIO[A](run: (List[String], List[String]) => (A, List[String], List[String]))

  implicit val testIOMonad: Monad[TestIO] = new Monad[TestIO] {
    def pure[A](a: A) = TestIO((ins, outs) => (a, ins, outs))
    def flatMap[A, B](fa: TestIO[A])(f: A => TestIO[B]) = TestIO { (ins, outs) =>
      val (a, ins2, outs2) = fa.run(ins, outs)
      f(a).run(ins2, outs2)
    }
  }

  // TODO: Implement Console[TestIO]
  implicit val testConsole: Console[TestIO] = ???

  // ============================================================
  // Exercise 4: Define a KV Store algebra (tagless final)
  // ============================================================
  // TODO: Define KvStore algebra
  trait KvStore[F[_]] {
    def get(key: String): F[Option[String]]
    def put(key: String, value: String): F[Unit]
    def delete(key: String): F[Unit]
  }

  // ============================================================
  // Exercise 5: Compose two algebras in a single program
  // Write a program that reads a name from Console and stores it in KvStore.
  // ============================================================
  // TODO: Write a program that uses both Console and KvStore
  def readAndStore[F[_]](implicit C: Console[F], K: KvStore[F], M: Monad[F]): F[Unit] = ???

  // ============================================================
  // Exercise 6: Implement a natural transformation between interpreters
  // Given a way to transform F ~> G, implement running a program in G
  // that was written for F.
  // ============================================================
  // TODO: Transform a Console[F] into Console[G] given F ~> G
  def mapConsole[F[_], G[_]](nt: F ~> G)(implicit cf: Console[F]): Console[G] = ???

  // ============================================================
  // Exercise 7: Implement testing with Id
  // Use Id (type Id[A] = A) as the simplest possible interpreter.
  // ============================================================
  type Id[A] = A

  implicit val idMonad: Monad[Id] = new Monad[Id] {
    def pure[A](a: A): A = a
    def flatMap[A, B](fa: A)(f: A => B): B = f(fa)
  }

  // A Console[Id] that uses fixed responses
  // TODO: Implement Console[Id] that always returns "TestUser" for readLine
  //       and ignores printLine
  def fixedConsole(response: String): Console[Id] = ???

  // ============================================================
  // Exercise 8: Higher-order tagless final
  // Define an algebra that takes another algebra as a parameter.
  // Logging wraps any operation with before/after log messages.
  // ============================================================
  trait Logging[F[_]] {
    def log(msg: String): F[Unit]
  }

  // TODO: Implement a "logged" version of KvStore that logs get/put/delete
  def loggedKvStore[F[_]](underlying: KvStore[F], logging: Logging[F])(implicit M: Monad[F]): KvStore[F] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1-2: Console algebra and greet program
    val result = greet[TestIO].run(List("Alice"), Nil)
    val (_, _, outputs) = result
    assert(outputs == List("What is your name?", "Hello, Alice!"))
    println("Exercise 1-2 passed: Tagless final Console")

    // Exercise 3: TestIO interpreter (tested above)
    println("Exercise 3 passed: TestIO interpreter")

    // Exercise 4-5: KvStore and composition
    case class State[A](run: (Map[String, String], List[String], List[String]) => (A, Map[String, String], List[String], List[String]))
    // Simplified test: just verify the program compiles and types check
    println("Exercise 4-5 passed: KvStore algebra and composition defined")

    // Exercise 6: Natural transformation
    val mappedConsole = mapConsole[TestIO, TestIO](new (TestIO ~> TestIO) {
      def apply[A](fa: TestIO[A]): TestIO[A] = fa
    })
    val r6 = mappedConsole.readLine.run(List("Bob"), Nil)
    assert(r6._1 == "Bob")
    println("Exercise 6 passed: mapConsole via natural transformation")

    // Exercise 7: Testing with Id
    val console = fixedConsole("TestUser")
    val name: Id[String] = console.readLine
    assert(name == "TestUser")
    println("Exercise 7 passed: Console[Id] for testing")

    // Exercise 8: Higher-order tagless final
    var logMessages = List.empty[String]
    type SimpleIO[A] = () => A
    implicit val simpleMonad: Monad[SimpleIO] = new Monad[SimpleIO] {
      def pure[A](a: A): SimpleIO[A] = () => a
      def flatMap[A, B](fa: SimpleIO[A])(f: A => SimpleIO[B]): SimpleIO[B] = () => f(fa())()
    }
    val baseKv: KvStore[SimpleIO] = new KvStore[SimpleIO] {
      var store = Map.empty[String, String]
      def get(key: String): SimpleIO[Option[String]] = () => store.get(key)
      def put(key: String, value: String): SimpleIO[Unit] = () => { store = store + (key -> value) }
      def delete(key: String): SimpleIO[Unit] = () => { store = store - key }
    }
    val logger: Logging[SimpleIO] = new Logging[SimpleIO] {
      def log(msg: String): SimpleIO[Unit] = () => { logMessages = logMessages :+ msg }
    }
    val logged = loggedKvStore[SimpleIO](baseKv, logger)
    logged.put("x", "1")()
    assert(logMessages.nonEmpty, "Logging should have recorded messages")
    println("Exercise 8 passed: Higher-order tagless final (logged KvStore)")

    println("\nAll exercises passed!")
  }
}
