package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 013 - The R Parameter: Environment, Dependency Injection, and the Service Pattern
 *
 * == Core Concept: The R (Environment) Type Parameter ==
 * In `ZIO[R, E, A]`, the `R` parameter represents the **environment** — the set of services
 * and dependencies that the effect requires in order to run. A `ZIO[Database with Logger, AppError, User]`
 * declares at the type level that it needs a `Database` and a `Logger` to execute. The effect
 * cannot be run until these dependencies are provided via `.provide`, `.provideLayer`, etc.
 *
 * This is ZIO's built-in, compile-time-checked dependency injection mechanism. Unlike runtime
 * DI frameworks (Guice, Spring), the compiler guarantees that all dependencies are satisfied
 * before the program runs. A missing dependency is a compile error, not a runtime exception.
 *
 * == ZEnvironment and Has (ZIO 1.x) ==
 * In ZIO 1.x, `Has[A]` is a heterogeneous map that stores services keyed by their type.
 * Multiple `Has` types are combined with `with` (intersection types):
 * {{{
 *   type AppEnv = Has[Database] with Has[Logger] with Has[Config]
 * }}}
 * In ZIO 2.x, `Has` was removed and the environment uses Scala 3 intersection types directly.
 *
 * == Key environment operators ==
 * | Operator              | Purpose                                                          |
 * |-----------------------|------------------------------------------------------------------|
 * | `ZIO.environment[R]`  | Access the full environment as a value of type `R`               |
 * | `ZIO.access[R]`       | Access a derived value: `R => A` (pure)                          |
 * | `ZIO.accessM[R]`      | Access with an effectful function: `R => ZIO[R, E, A]`           |
 * | `ZIO.service[A]`      | Shorthand for `ZIO.access[Has[A]](_.get)` — the most common one |
 * | `.provide(r)`         | Supply the full environment, eliminating `R` from the type       |
 * | `.provideLayer(layer)`| Supply the environment via a `ZLayer`                            |
 *
 * == Why R is better than implicit parameters ==
 * - '''Type-safe composition:''' Multiple environment requirements compose automatically via
 *   intersection types (`Has[A] with Has[B]`). With implicits, you manually thread parameters.
 * - '''No ambient state:''' The environment is explicit in the type signature. Implicits are
 *   resolved at compile-time from lexical scope, which can be confusing and fragile.
 * - '''Testability:''' You can `.provide` a test environment without any test framework magic.
 *   With implicits, you often need DI frameworks or manual overriding.
 * - '''Composable layers:''' `ZLayer` lets you define, compose, and share dependency graphs
 *   declaratively. Implicit-based DI has no equivalent.
 *
 * == Interview Tip ==
 * '''Q: How does ZIO's environment type compare to Reader monad or DI frameworks like Guice?'''
 *
 * ZIO's R parameter is essentially the Reader monad pattern, but with three key advantages:
 *   1. '''Intersection types for composition:''' Reader monad requires manual merging of
 *      environment types (often via a mega-config case class). ZIO uses `with`/`&` to compose
 *      requirements automatically.
 *   2. '''ZLayer for construction:''' Guice builds the dependency graph at runtime using
 *      reflection, which can fail at startup. ZLayer builds it at compile time, and the
 *      compiler verifies completeness.
 *   3. '''Eliminatable at the edge:''' Once you `.provide` all dependencies, R becomes `Any`,
 *      and you have a fully self-contained effect. With Guice, the injector is a runtime concept
 *      that lives throughout the application.
 *
 * '''Follow-up:''' "What is the ZIO 2.x service pattern?"
 * Define a trait, implement it, create a `ZLayer` that constructs the implementation, and
 * access it via `ZIO.serviceWithZIO[MyService](_.doSomething)`. The trait is the interface,
 * the ZLayer is the wiring, and the accessor is the call site.
 *
 * == Real-World Context ==
 * In production ZIO applications, the R parameter is the backbone of the architecture:
 * - Service traits define the contract (e.g., `trait UserRepository`, `trait EmailService`)
 * - `ZLayer` values wire implementations together (e.g., `UserRepositoryLive` depends on `Database`)
 * - The main app composes all layers: `program.provideLayer(appLayer)`, turning
 *   `ZIO[FullAppEnv, AppError, Unit]` into `ZIO[Any, AppError, Unit]`
 * - Tests provide mock/stub layers: `program.provideLayer(testLayer)` — no framework needed
 */
object Zio013_Environment {

  // Exercise 1: Use ZIO.environment to access the entire environment
  // TODO: ZIO.environment[Int] — returns the Int environment
  val exercise1: URIO[Int, Int] = ???

  // Exercise 2: Use ZIO.access to derive a value from the environment
  // TODO: ZIO.access[Int](n => n * 2)
  val exercise2: URIO[Int, Int] = ???

  // Exercise 3: Use ZIO.accessM to derive an effect from the environment
  // TODO: ZIO.accessM[Int](n => ZIO.succeed(n.toString))
  val exercise3: URIO[Int, String] = ???

  // Exercise 4: Use Has to wrap a service in the environment
  // TODO: ZIO.access[Has[String]](_.get) — extracts the String service from Has
  val exercise4: URIO[Has[String], String] = ???

  // Exercise 5: Create a simple service pattern with Has
  // TODO: Define a trait Config { def url: String }
  // Access it: ZIO.access[Has[Config]](_.get.url)
  trait Config {
    def url: String
  }
  val exercise5: URIO[Has[Config], String] = ???

  // Exercise 6: Use provide to supply the environment
  // TODO: ZIO.access[Int](_ + 10).provide(32) — should return 42
  val exercise6: UIO[Int] = ???

  // Exercise 7: Use ZIO.service[A] shorthand for ZIO.access[Has[A]](_.get)
  // TODO: ZIO.service[String] — equivalent to ZIO.access[Has[String]](_.get)
  val exercise7: URIO[Has[String], String] = ???

  // Exercise 8: Combine multiple environment requirements
  // TODO: for {
  //   n <- ZIO.access[Has[Int]](_.get)
  //   s <- ZIO.access[Has[String]](_.get)
  // } yield s"$s=$n"
  // Provide with Has(42) ++ Has("answer")
  val exercise8: URIO[Has[Int] with Has[String], String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1.provide(42))
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2.provide(21))
    assert(r2 == 42, s"Exercise 2 failed: expected 42, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3.provide(42))
    assert(r3 == "42", s"Exercise 3 failed: expected '42', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4.provide(Has("hello")))
    assert(r4 == "hello", s"Exercise 4 failed: expected 'hello', got $r4")
    println(s"Exercise 4 passed: $r4")

    val testConfig = new Config { val url = "http://localhost" }
    val r5 = runtime.unsafeRun(exercise5.provide(Has(testConfig)))
    assert(r5 == "http://localhost", s"Exercise 5 failed: expected 'http://localhost', got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7.provide(Has("world")))
    assert(r7 == "world", s"Exercise 7 failed: expected 'world', got $r7")
    println(s"Exercise 7 passed: $r7")

    val env8 = Has(42) ++ Has("answer")
    val r8 = runtime.unsafeRun(exercise8.provide(env8))
    assert(r8 == "answer=42", s"Exercise 8 failed: expected 'answer=42', got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio013_Environment exercises passed!")
  }
}
