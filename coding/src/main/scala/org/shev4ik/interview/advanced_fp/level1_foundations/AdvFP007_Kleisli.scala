package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * AdvFP007 - Kleisli Arrows
 *
 * A Kleisli arrow A => F[B] is a morphism in the Kleisli category for monad F.
 * Kleisli composition chains effectful functions. Kleisli[F, A, B] is equivalent
 * to ReaderT[F, A, B] and is used for dependency injection and effect composition.
 */
object AdvFP007_Kleisli {

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]
    def map[A, B](fa: F[A])(f: A => B): F[B] = flatMap(fa)(a => pure(f(a)))
  }

  implicit val optionMonad: Monad[Option] = new Monad[Option] {
    def pure[A](a: A): Option[A] = Some(a)
    def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
  }

  implicit val listMonad: Monad[List] = new Monad[List] {
    def pure[A](a: A): List[A] = List(a)
    def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f)
  }

  // ============================================================
  // Exercise 1: Implement the Kleisli wrapper
  // Kleisli[F, A, B] wraps A => F[B]
  // ============================================================
  case class Kleisli[F[_], A, B](run: A => F[B])

  // TODO: Implement Kleisli composition (andThen / >==>)
  // Given Kleisli[F, A, B] and Kleisli[F, B, C], produce Kleisli[F, A, C]
  def composeKleisli[F[_]: Monad, A, B, C](
    first: Kleisli[F, A, B],
    second: Kleisli[F, B, C]
  ): Kleisli[F, A, C] = ???

  // ============================================================
  // Exercise 2: Implement 'ask' for Kleisli
  // ask returns the input environment unchanged: Kleisli[F, A, A]
  // ============================================================
  // TODO: Implement ask
  def ask[F[_]: Monad, A]: Kleisli[F, A, A] = ???

  // ============================================================
  // Exercise 3: Implement 'local' for Kleisli
  // local modifies the environment before passing it to the Kleisli arrow.
  // local(f)(kleisli) transforms the input with f before running kleisli.
  // ============================================================
  // TODO: Implement local
  def local[F[_], A, B, C](f: A => B)(kleisli: Kleisli[F, B, C]): Kleisli[F, A, C] = ???

  // ============================================================
  // Exercise 4: Implement 'lift' to lift F[B] into Kleisli[F, A, B]
  // The resulting Kleisli ignores its input and returns the given F[B].
  // ============================================================
  // TODO: Implement lift
  def lift[F[_], A, B](fb: F[B]): Kleisli[F, A, B] = ???

  // ============================================================
  // Exercise 5: Implement map for Kleisli
  // Transform the output of a Kleisli arrow.
  // ============================================================
  // TODO: Implement map for Kleisli
  def mapKleisli[F[_]: Monad, A, B, C](k: Kleisli[F, A, B])(f: B => C): Kleisli[F, A, C] = ???

  // ============================================================
  // Exercise 6: Implement flatMap for Kleisli
  // Chain a Kleisli arrow with a function that produces another Kleisli.
  // ============================================================
  // TODO: Implement flatMap for Kleisli
  def flatMapKleisli[F[_]: Monad, A, B, C](
    k: Kleisli[F, A, B]
  )(f: B => Kleisli[F, A, C]): Kleisli[F, A, C] = ???

  // ============================================================
  // Exercise 7: Dependency injection with Kleisli
  // Model a simple service: given Config, produce a result.
  // Config has a database URL and a port.
  // Implement two services and compose them.
  // ============================================================
  case class Config(dbUrl: String, port: Int)

  // TODO: Implement a Kleisli that extracts the database URL
  val getDbUrl: Kleisli[Option, Config, String] = ???

  // TODO: Implement a Kleisli that creates a connection string from dbUrl
  val makeConnectionString: Kleisli[Option, String, String] = ???

  // TODO: Compose them to go from Config to connection string
  val getConnection: Kleisli[Option, Config, String] = ???

  // ============================================================
  // Exercise 8: Verify Kleisli laws
  // Left identity: composeKleisli(pure, f) == f
  // Right identity: composeKleisli(f, pure) == f
  // Associativity: composeKleisli(composeKleisli(f, g), h) == composeKleisli(f, composeKleisli(g, h))
  // Return true if left identity holds for the given Kleisli and input.
  // ============================================================
  // TODO: Verify left identity law
  def verifyLeftIdentity[F[_]: Monad, A, B](f: Kleisli[F, A, B], a: A): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1: Kleisli composition
    val parse: Kleisli[Option, String, Int] = Kleisli(s => scala.util.Try(s.toInt).toOption)
    val half: Kleisli[Option, Int, Int] = Kleisli(n => if (n % 2 == 0) Some(n / 2) else None)
    val parseAndHalf = composeKleisli(parse, half)
    assert(parseAndHalf.run("10") == Some(5))
    assert(parseAndHalf.run("abc") == None)
    assert(parseAndHalf.run("3") == None)
    println("Exercise 1 passed: Kleisli composition")

    // Exercise 2: ask
    val a = ask[Option, Int]
    assert(a.run(42) == Some(42))
    println("Exercise 2 passed: ask")

    // Exercise 3: local
    val intToString: Kleisli[Option, Int, String] = Kleisli(n => Some(n.toString))
    val stringLen = local[Option, String, Int, String](_.length)(intToString)
    assert(stringLen.run("hello") == Some("5"))
    println("Exercise 3 passed: local")

    // Exercise 4: lift
    val lifted = lift[Option, String, Int](Some(42))
    assert(lifted.run("ignored") == Some(42))
    println("Exercise 4 passed: lift")

    // Exercise 5: map
    val mapped = mapKleisli(parse)(_ * 10)
    assert(mapped.run("5") == Some(50))
    println("Exercise 5 passed: Kleisli map")

    // Exercise 6: flatMap
    val fm = flatMapKleisli(parse)(n => Kleisli(_ => if (n > 0) Some(n.toString) else None))
    assert(fm.run("42") == Some("42"))
    println("Exercise 6 passed: Kleisli flatMap")

    // Exercise 7: Dependency injection
    val config = Config("jdbc:postgresql://localhost/db", 5432)
    val conn = getConnection.run(config)
    assert(conn == Some("jdbc:postgresql://localhost/db:5432"))
    println("Exercise 7 passed: Dependency injection with Kleisli")

    // Exercise 8: Left identity
    val f: Kleisli[Option, Int, String] = Kleisli(n => Some(n.toString))
    assert(verifyLeftIdentity(f, 42), "Left identity should hold")
    println("Exercise 8 passed: Kleisli left identity law")

    println("\nAll exercises passed!")
  }
}
