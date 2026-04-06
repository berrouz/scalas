package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.config._
import zio.config.ConfigDescriptor._

/**
 * ZIO 065 - ConfigSource: different sources for configuration.
 *
 * ConfigSource.fromMap, fromSystemEnv, fromSystemProperties.
 * Sources can be composed with orElse and <>.
 */
object Zio065_ConfigSource {

  case class ServerConfig(host: String, port: Int)

  val serverDescriptor: ConfigDescriptor[ServerConfig] =
    (string("HOST") |@| int("PORT"))(ServerConfig.apply, ServerConfig.unapply)

  // Exercise 1: Create a ConfigSource from a Map
  // TODO: ConfigSource.fromMap(Map("HOST" -> "localhost", "PORT" -> "9090"))
  val exercise1: ConfigSource = ???

  // Exercise 2: Read config using the map source
  // TODO: read(serverDescriptor from exercise1)
  val exercise2: IO[ReadError[String], ServerConfig] = ???

  // Exercise 3: Create a ConfigSource from system environment (concept)
  // TODO: ConfigSource.fromSystemEnv — reads from system environment variables
  // Just demonstrate the creation, don't actually read from it
  val exercise3: UIO[String] = ???

  // Exercise 4: Compose two config sources with orElse (<>)
  // TODO: primarySource <> fallbackSource — tries primary first, then fallback
  val exercise4: ConfigSource = ???

  // Exercise 5: Create a constant ConfigSource
  // TODO: ConfigSource.fromMap(Map("KEY" -> "constant-value"), pathDelimiter = ".")
  val exercise5: ConfigSource = ???

  // Exercise 6: Read from composed sources with fallback
  // TODO: Create source with missing keys, fallback to source with all keys
  val exercise6: IO[ReadError[String], ServerConfig] = ???

  // Exercise 7: Create a ConfigSource with nested paths (dot-delimited)
  // TODO: ConfigSource.fromMap(Map("server.host" -> "example.com", "server.port" -> "443"), ".")
  val exercise7: ConfigSource = ???

  // Exercise 8: Create a custom ConfigSource from an effect
  // TODO: Build a config source that reads from a simulated external store
  val exercise8: IO[ReadError[String], String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    println(s"Exercise 1 passed: config source from map created")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.host == "localhost", s"Exercise 2 failed: got ${r2.host}")
    assert(r2.port == 9090, s"Exercise 2 failed: got ${r2.port}")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, s"Exercise 3 failed")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4
    println(s"Exercise 4 passed: composed source created")

    // Exercise 5
    println(s"Exercise 5 passed: constant source created")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    assert(r6.host.nonEmpty, s"Exercise 6 failed")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    println(s"Exercise 7 passed: nested path source created")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8)
    assert(r8.nonEmpty, s"Exercise 8 failed")
    println(s"Exercise 8 passed: $r8")

    println("All Zio065_ConfigSource exercises passed!")
  }
}
