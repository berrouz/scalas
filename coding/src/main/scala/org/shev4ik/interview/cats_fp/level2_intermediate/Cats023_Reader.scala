package org.shev4ik.interview.cats_fp.level2_intermediate

import cats._
import cats.implicits._
import cats.data._

/**
 * Cats 023 - Reader Monad
 *
 * Reader[A, B] is a type alias for Kleisli[Id, A, B].
 * It represents a computation that depends on some environment/configuration.
 * Commonly used for dependency injection in pure FP.
 */
object Cats023_Reader {

  // Exercise 1: Reader monad basics - create a Reader
  // TODO: Create a Reader that extracts a value from a config.
  case class Config(dbUrl: String, maxRetries: Int, logLevel: String)

  def exercise1_readerBasics(): Reader[Config, String] = {
    // Create a Reader that extracts the dbUrl from Config
    ???
  }

  // Exercise 2: Reader.apply - explicit construction
  // TODO: Create a Reader using Reader.apply (or Reader(...)).
  def exercise2_readerApply(): Reader[Config, Int] = {
    // Create a Reader that extracts maxRetries from Config
    ???
  }

  // Exercise 3: run - execute the Reader with an environment
  // TODO: Create a Reader and run it with a specific Config.
  def exercise3_run(): (String, Int) = {
    val config = Config("jdbc:postgresql://localhost/mydb", 3, "INFO")

    val getDbUrl: Reader[Config, String] = Reader(_.dbUrl)
    val getMaxRetries: Reader[Config, Int] = Reader(_.maxRetries)

    // Run both readers with config and return the results
    val url: String = ???
    val retries: Int = ???
    (url, retries)
  }

  // Exercise 4: map - transform the Reader's output
  // TODO: Map over a Reader to transform its result.
  def exercise4_map(): String = {
    val config = Config("jdbc:postgresql://localhost/mydb", 3, "INFO")

    val getLogLevel: Reader[Config, String] = Reader(_.logLevel)

    // Map to convert log level to uppercase
    val upperLogLevel: Reader[Config, String] = ???

    upperLogLevel.run(config)
  }

  // Exercise 5: flatMap - chain Readers that share the same environment
  // TODO: Use flatMap to compose Readers in a for-comprehension.
  def exercise5_flatMap(): String = {
    val config = Config("jdbc:postgresql://localhost/mydb", 3, "DEBUG")

    // Create a Reader that builds a connection summary using for-comprehension
    val summary: Reader[Config, String] = for {
      url <- Reader[Config, String](_.dbUrl)
      retries <- Reader[Config, Int](_.maxRetries)
      level <- Reader[Config, String](_.logLevel)
    } yield ???  // Combine into "url=$url, retries=$retries, level=$level"

    summary.run(config)
  }

  // Exercise 6: ask - access the full environment
  // TODO: Use Reader.ask to get the entire config in a for-comprehension.
  def exercise6_ask(): Config = {
    val config = Config("jdbc:h2:mem", 5, "WARN")

    val program: Reader[Config, Config] = for {
      cfg <- { val x: Reader[Config, Config] = ???; x } // Use Reader.ask[Config] or Kleisli.ask[Id, Config]
    } yield cfg

    program.run(config)
  }

  // Exercise 7: local - modify the environment for a sub-computation
  // TODO: Use local to temporarily modify the config for a Reader.
  def exercise7_local(): (Int, Int) = {
    val config = Config("jdbc:h2:mem", 3, "INFO")

    val getRetries: Reader[Config, Int] = Reader(_.maxRetries)

    // Use local to double the maxRetries before reading
    val doubledRetries: Reader[Config, Int] = ???

    // Run both with the same config to show the difference
    val normal: Int = getRetries.run(config)
    val doubled: Int = doubledRetries.run(config)
    (normal, doubled)
  }

  // Exercise 8: Reader for dependency injection - real-world pattern
  // TODO: Use Reader to inject dependencies into a service layer.
  case class UserRepo(users: Map[Int, String])
  case class EmailService(domain: String)
  case class AppEnv(userRepo: UserRepo, emailService: EmailService)

  def exercise8_dependencyInjection(): Option[String] = {
    val env = AppEnv(
      UserRepo(Map(1 -> "Alice", 2 -> "Bob")),
      EmailService("example.com")
    )

    // findUser: look up a user by ID
    def findUser(id: Int): Reader[AppEnv, Option[String]] =
      Reader(env => env.userRepo.users.get(id))

    // buildEmail: create an email address for a username
    def buildEmail(name: String): Reader[AppEnv, String] =
      Reader(env => s"${name.toLowerCase}@${env.emailService.domain}")

    // Combine: find user 1, then build their email
    val program: Reader[AppEnv, Option[String]] = ???

    program.run(env)
  }

  def main(args: Array[String]): Unit = {
    val config = Config("jdbc:postgresql://localhost/mydb", 3, "INFO")

    // Exercise 1
    val r1 = exercise1_readerBasics()
    assert(r1.run(config) == "jdbc:postgresql://localhost/mydb", s"Exercise 1 failed")
    println(s"Exercise 1 passed: Reader basics => ${r1.run(config)}")

    // Exercise 2
    val r2 = exercise2_readerApply()
    assert(r2.run(config) == 3, s"Exercise 2 failed")
    println(s"Exercise 2 passed: Reader.apply => ${r2.run(config)}")

    // Exercise 3
    val (url3, retries3) = exercise3_run()
    assert(url3 == "jdbc:postgresql://localhost/mydb" && retries3 == 3, s"Exercise 3 failed")
    println(s"Exercise 3 passed: run => url=$url3, retries=$retries3")

    // Exercise 4
    val r4 = exercise4_map()
    assert(r4 == "INFO", s"Exercise 4 failed: $r4")
    println(s"Exercise 4 passed: map => $r4")

    // Exercise 5
    val r5 = exercise5_flatMap()
    val expected5 = "url=jdbc:postgresql://localhost/mydb, retries=3, level=DEBUG"
    assert(r5 == expected5, s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: flatMap => $r5")

    // Exercise 6
    val r6 = exercise6_ask()
    assert(r6 == Config("jdbc:h2:mem", 5, "WARN"), s"Exercise 6 failed: $r6")
    println(s"Exercise 6 passed: ask => $r6")

    // Exercise 7
    val (n7, d7) = exercise7_local()
    assert(n7 == 3 && d7 == 6, s"Exercise 7 failed: ($n7, $d7)")
    println(s"Exercise 7 passed: local => normal=$n7, doubled=$d7")

    // Exercise 8
    val r8 = exercise8_dependencyInjection()
    assert(r8 == Some("alice@example.com"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: DI => $r8")

    println("\nAll Cats023_Reader exercises passed!")
  }
}
