package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 022 - Kleisli Patterns
 *
 * Practical patterns using Kleisli: validation pipelines,
 * configuration readers, and ReaderT-style dependency injection.
 */
object Cats022_KleisliPatterns {

  // Exercise 1: Kleisli for validation - chain validation steps
  // TODO: Create a validation pipeline using Kleisli composition.
  //       Validate: non-empty string -> parse to int -> check positive
  def exercise1_validation(): Option[Int] = {
    val nonEmpty: Kleisli[Option, String, String] =
      Kleisli(s => if (s.nonEmpty) Some(s) else None)

    val parseInt: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    val positive: Kleisli[Option, Int, Int] =
      Kleisli(n => if (n > 0) Some(n) else None)

    // Chain: nonEmpty >>> parseInt >>> positive, then run with "42"
    ???
  }

  // Exercise 2: Kleisli for configuration - read from a config map
  // TODO: Use Kleisli to read values from a configuration Map.
  case class AppConfig(host: String, port: Int, debug: Boolean)

  def exercise2_configuration(): Option[AppConfig] = {
    type Config = Map[String, String]

    val readHost: Kleisli[Option, Config, String] =
      Kleisli(_.get("host"))

    val readPort: Kleisli[Option, Config, Int] =
      Kleisli(_.get("port").flatMap(s => scala.util.Try(s.toInt).toOption))

    val readDebug: Kleisli[Option, Config, Boolean] =
      Kleisli(_.get("debug").map(_ == "true"))

    val config: Config = Map("host" -> "localhost", "port" -> "8080", "debug" -> "true")

    // Combine readHost, readPort, readDebug using mapN (Kleisli has Apply)
    // then run with config
    ???
  }

  // Exercise 3: Kleisli as ReaderT - Kleisli[Id, A, B] is equivalent to Reader[A, B]
  // TODO: Show that Kleisli[Id, A, B] behaves as a simple Reader.
  def exercise3_readerT(): Int = {
    // ReaderT[Id, Int, Int] is the same as Kleisli[Id, Int, Int]
    val double: Kleisli[Id, Int, Int] = Kleisli((n: Int) => (n * 2): Id[Int])
    val addTen: Kleisli[Id, Int, Int] = Kleisli((n: Int) => (n + 10): Id[Int])

    // Compose double >>> addTen, then run with 5
    // Expected: (5 * 2) + 10 = 20
    ???
  }

  // Exercise 4: ask - get the entire input/environment
  // TODO: Use Kleisli.ask to access the full environment within a for-comprehension.
  def exercise4_ask(): Option[(String, Int)] = {
    type Env = Map[String, String]

    val program: Kleisli[Option, Env, (String, Int)] = for {
      env <- Kleisli.ask[Option, Env]
      name <- Kleisli.liftF[Option, Env, String](env.get("name"))
      age <- Kleisli.liftF[Option, Env, Int](env.get("age").flatMap(s => scala.util.Try(s.toInt).toOption))
    } yield (name, age)

    // Run the program with a config map - fill in the map
    val env: Env = ???
    program.run(env)
  }

  // Exercise 5: lift - lift a pure function into Kleisli
  // TODO: Use Kleisli.pure and Kleisli.liftF to create Kleisli values.
  def exercise5_lift(): Option[Int] = {
    // Kleisli.pure lifts a value into Kleisli (ignores input)
    val alwaysFive: Kleisli[Option, String, Int] = ???

    // Run with any input
    alwaysFive.run("anything")
  }

  // Exercise 6: liftF - lift an F[A] into Kleisli[F, ?, A]
  // TODO: Use Kleisli.liftF to lift an Option value into a Kleisli.
  def exercise6_liftF(): Option[Int] = {
    val optionValue: Option[Int] = Some(42)

    // Lift optionValue into Kleisli[Option, String, Int]
    val lifted: Kleisli[Option, String, Int] = ???

    lifted.run("ignored")
  }

  // Exercise 7: mapF - transform the effect of a Kleisli
  // TODO: Use mapF to transform the inner effect.
  //       mapF takes F[B] => G[C], changing both the effect and value type.
  def exercise7_mapF(): Option[String] = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    // Use mapF to transform Option[Int] to Option[String]
    val parseToString: Kleisli[Option, String, String] = ???

    parseToString.run("42")
  }

  // Exercise 8: tapWith - inspect the input and output without changing the Kleisli
  // TODO: Use tapWith to combine input and output.
  //       tapWith: (A, B) => C transforms Kleisli[F, A, B] to Kleisli[F, A, C]
  def exercise8_tapWith(): Option[String] = {
    val parse: Kleisli[Option, String, Int] =
      Kleisli(s => scala.util.Try(s.toInt).toOption)

    // Use tapWith to produce a message combining input string and parsed int
    val withMessage: Kleisli[Option, String, String] = ???

    withMessage.run("42")
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_validation()
    assert(r1 == Some(42), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: validation pipeline => $r1")

    // Exercise 2
    val r2 = exercise2_configuration()
    assert(r2 == Some(AppConfig("localhost", 8080, true)), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: configuration => $r2")

    // Exercise 3
    val r3 = exercise3_readerT()
    assert(r3 == 20, s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: Kleisli as ReaderT => $r3")

    // Exercise 4
    val r4 = exercise4_ask()
    assert(r4 == Some(("Alice", 30)), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: ask => $r4")

    // Exercise 5
    val r5 = exercise5_lift()
    assert(r5 == Some(5), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: lift/pure => $r5")

    // Exercise 6
    val r6 = exercise6_liftF()
    assert(r6 == Some(42), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: liftF => $r6")

    // Exercise 7
    val r7 = exercise7_mapF()
    assert(r7 == Some("42"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: mapF => $r7")

    // Exercise 8
    val r8 = exercise8_tapWith()
    assert(r8 == Some("Parsed '42' to 42"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: tapWith => $r8")

    println("\nAll Cats022_KleisliPatterns exercises passed!")
  }
}
