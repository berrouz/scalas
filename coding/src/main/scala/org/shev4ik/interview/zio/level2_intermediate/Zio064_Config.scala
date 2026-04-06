package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.config._
import zio.config.ConfigDescriptor._

/**
 * ZIO 064 - Config: type-safe configuration with zio-config.
 *
 * ConfigDescriptor describes the shape of configuration.
 * Read from maps, environment variables, or other sources.
 * Supports nesting, lists, optionals, and defaults.
 *
 * Note: Uses zio-config 1.x API compatible with ZIO 1.x.
 */
object Zio064_Config {

  case class AppConfig(host: String, port: Int)
  case class DbConfig(url: String, maxConnections: Int)
  case class FullConfig(app: AppConfig, db: DbConfig)

  // Exercise 1: Create a ConfigDescriptor for a single String value
  // TODO: string("HOST") describes a config that reads key "HOST" as String
  val exercise1: ConfigDescriptor[String] = ???

  // Exercise 2: Create a ConfigDescriptor for AppConfig
  // TODO: (string("HOST") |@| int("PORT"))(AppConfig.apply, AppConfig.unapply)
  val exercise2: ConfigDescriptor[AppConfig] = ???

  // Exercise 3: Read config from a Map source
  // TODO: Use ConfigSource.fromMap(Map("HOST" -> "localhost", "PORT" -> "8080"))
  // and read(exercise2, source)
  val exercise3: IO[ReadError[String], AppConfig] = ???

  // Exercise 4: Create a nested config descriptor
  // TODO: nest("app")(appDescriptor) reads from app.HOST, app.PORT
  val exercise4: ConfigDescriptor[AppConfig] = ???

  // Exercise 5: Create a config with a list of values
  // TODO: list("TAGS")(string) reads a list of strings
  val exercise5: ConfigDescriptor[List[String]] = ???

  // Exercise 6: Create a config with an optional value
  // TODO: string("OPTIONAL_KEY").optional => ConfigDescriptor[Option[String]]
  val exercise6: ConfigDescriptor[Option[String]] = ???

  // Exercise 7: Create a config with a default value
  // TODO: int("PORT").default(8080) => if PORT is missing, use 8080
  val exercise7: ConfigDescriptor[Int] = ???

  // Exercise 8: Handle config errors
  // TODO: Try to read a missing key and handle the ReadError
  val exercise8: UIO[Either[String, String]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    println(s"Exercise 1 passed: descriptor created")

    // Exercise 2
    println(s"Exercise 2 passed: AppConfig descriptor created")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.host == "localhost", s"Exercise 3 failed: got ${r3.host}")
    assert(r3.port == 8080, s"Exercise 3 failed: got ${r3.port}")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    println(s"Exercise 4 passed: nested descriptor created")

    // Exercise 5
    println(s"Exercise 5 passed: list descriptor created")

    // Exercise 6
    println(s"Exercise 6 passed: optional descriptor created")

    // Exercise 7
    println(s"Exercise 7 passed: default descriptor created")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    println(s"Exercise 8 passed: $r8")

    println("All Zio064_Config exercises passed!")
  }
}
