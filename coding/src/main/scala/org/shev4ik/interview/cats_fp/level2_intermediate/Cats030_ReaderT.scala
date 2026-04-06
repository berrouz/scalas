package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 030 - ReaderT (= Kleisli)
 *
 * ReaderT[F, A, B] is a type alias for Kleisli[F, A, B].
 * It represents A => F[B], enabling dependency injection with effects.
 * When F = Id, ReaderT becomes Reader.
 */
object Cats030_ReaderT {

  case class Config(dbUrl: String, maxRetries: Int)

  // Using Option as our effect type
  type Eff[A] = Option[A]

  // Exercise 1: ReaderT creation (= Kleisli) - create a ReaderT
  // TODO: Create a ReaderT[Option, Config, String] that reads dbUrl.
  //       ReaderT is literally Kleisli.
  def exercise1_readerT(): ReaderT[Eff, Config, String] = {
    // ReaderT is Kleisli - create one that extracts dbUrl and wraps in Some
    ???
  }

  // Exercise 2: ask - access the full environment
  // TODO: Use ReaderT.ask (= Kleisli.ask) to get the entire Config.
  def exercise2_ask(): ReaderT[Eff, Config, Config] = {
    // Use Kleisli.ask[Eff, Config] or ReaderT.ask
    ???
  }

  // Exercise 3: local - modify the environment for a sub-computation
  // TODO: Use local to transform the Config before passing it to a ReaderT.
  def exercise3_local(): Eff[Int] = {
    val config = Config("jdbc:h2:mem", 3)

    val getRetries: ReaderT[Eff, Config, Int] =
      ReaderT(c => Some(c.maxRetries))

    // Use local to double maxRetries, then run
    val doubled: ReaderT[Eff, Config, Int] = ???

    doubled.run(config)
  }

  // Exercise 4: lift - lift a pure value into ReaderT
  // TODO: Use Kleisli.pure to lift a value into ReaderT (ignores input).
  def exercise4_lift(): Eff[Int] = {
    val config = Config("jdbc:h2:mem", 3)

    // Lift the value 42 into ReaderT[Eff, Config, Int]
    val lifted: ReaderT[Eff, Config, Int] = ???

    lifted.run(config)
  }

  // Exercise 5: liftF - lift an F[A] into ReaderT[F, ?, A]
  // TODO: Use Kleisli.liftF to lift an Option value into ReaderT.
  def exercise5_liftF(): Eff[Int] = {
    val config = Config("jdbc:h2:mem", 3)
    val optValue: Eff[Int] = Some(42)

    // Lift the Option into ReaderT
    val lifted: ReaderT[Eff, Config, Int] = ???

    lifted.run(config)
  }

  // Exercise 6: mapF - transform the effect
  // TODO: Use mapF to transform the F[A] inside ReaderT.
  def exercise6_mapF(): Eff[String] = {
    val config = Config("jdbc:h2:mem", 3)

    val getRetries: ReaderT[Eff, Config, Int] =
      ReaderT(c => Some(c.maxRetries))

    // Use mapF to transform Option[Int] to Option[String]
    val formatted: ReaderT[Eff, Config, String] = ???

    formatted.run(config)
  }

  // Exercise 7: run - execute the ReaderT with an environment
  // TODO: Build a program using ReaderT for-comprehension and run it.
  def exercise7_run(): Eff[String] = {
    val config = Config("jdbc:postgresql://localhost/db", 5)

    val program: ReaderT[Eff, Config, String] = for {
      url <- ReaderT[Eff, Config, String](c => Some(c.dbUrl))
      retries <- ReaderT[Eff, Config, Int](c => Some(c.maxRetries))
    } yield s"Connecting to $url with $retries retries"

    // Run the program with config
    ???
  }

  // Exercise 8: Combining ReaderT effects - compose multiple ReaderT computations
  // TODO: Build a multi-step program using ReaderT, combining several readers.
  case class AppConfig(db: String, cacheSize: Int, logLevel: String)

  def exercise8_combining(): Eff[(String, Int, String)] = {
    val config = AppConfig("postgres", 100, "DEBUG")

    def readDb: ReaderT[Eff, AppConfig, String] =
      ReaderT(c => Some(c.db))

    def readCacheSize: ReaderT[Eff, AppConfig, Int] =
      ReaderT(c => Some(c.cacheSize))

    def readLogLevel: ReaderT[Eff, AppConfig, String] =
      ReaderT(c => Some(c.logLevel))

    // Combine all three readers using mapN or for-comprehension
    val program: ReaderT[Eff, AppConfig, (String, Int, String)] = ???

    program.run(config)
  }

  def main(args: Array[String]): Unit = {
    val config = Config("jdbc:h2:mem", 3)

    // Exercise 1
    val r1 = exercise1_readerT().run(config)
    assert(r1 == Some("jdbc:h2:mem"), s"Exercise 1 failed: $r1")
    println(s"Exercise 1 passed: ReaderT creation => $r1")

    // Exercise 2
    val r2 = exercise2_ask().run(config)
    assert(r2 == Some(config), s"Exercise 2 failed: $r2")
    println(s"Exercise 2 passed: ask => $r2")

    // Exercise 3
    val r3 = exercise3_local()
    assert(r3 == Some(6), s"Exercise 3 failed: $r3")
    println(s"Exercise 3 passed: local => $r3")

    // Exercise 4
    val r4 = exercise4_lift()
    assert(r4 == Some(42), s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: lift => $r4")

    // Exercise 5
    val r5 = exercise5_liftF()
    assert(r5 == Some(42), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: liftF => $r5")

    // Exercise 6
    val r6 = exercise6_mapF()
    assert(r6 == Some("retries: 3"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: mapF => $r6")

    // Exercise 7
    val r7 = exercise7_run()
    assert(r7 == Some("Connecting to jdbc:postgresql://localhost/db with 5 retries"), s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: run => $r7")

    // Exercise 8
    val r8 = exercise8_combining()
    assert(r8 == Some(("postgres", 100, "DEBUG")), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: combining => $r8")

    println("\nAll Cats030_ReaderT exercises passed!")
  }
}
