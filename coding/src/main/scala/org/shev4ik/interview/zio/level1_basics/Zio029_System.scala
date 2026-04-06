package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.system._

/**
 * ZIO 029 - System service: environment variables, system properties.
 *
 * In ZIO 1.x, use zio.system._ functions.
 * System is part of the default ZEnv environment.
 */
object Zio029_System {

  // Exercise 1: Get an environment variable
  // TODO: system.env("PATH") — returns Option[String]
  def exercise1: ZIO[System, SecurityException, Option[String]] = ???

  // Exercise 2: Get a system property
  // TODO: system.property("java.version") — returns Option[String]
  def exercise2: ZIO[System, Throwable, Option[String]] = ???

  // Exercise 3: Get the line separator
  // TODO: system.lineSeparator — returns the platform line separator
  def exercise3: ZIO[System, Nothing, String] = ???

  // Exercise 4: Get all environment variables
  // TODO: system.envs — returns Map[String, String]
  def exercise4: ZIO[System, SecurityException, Map[String, String]] = ???

  // Exercise 5: Get all system properties
  // TODO: system.properties — returns Map[String, String]
  def exercise5: ZIO[System, Throwable, Map[String, String]] = ???

  // Exercise 6: Use envOrElse to get env variable with a default
  // TODO: system.envOrElse("NONEXISTENT_VAR_12345", "default_value")
  def exercise6: ZIO[System, SecurityException, String] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1.isDefined, s"Exercise 1 failed: PATH should be defined, got $r1")
    println(s"Exercise 1 passed: PATH exists = ${r1.isDefined}")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.isDefined, s"Exercise 2 failed: java.version should be defined")
    println(s"Exercise 2 passed: java.version = ${r2.get}")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3.nonEmpty, "Exercise 3 failed: line separator should be non-empty")
    println(s"Exercise 3 passed: lineSeparator length = ${r3.length}")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4.nonEmpty, "Exercise 4 failed: envs should not be empty")
    println(s"Exercise 4 passed: ${r4.size} env vars")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5.nonEmpty, "Exercise 5 failed: properties should not be empty")
    println(s"Exercise 5 passed: ${r5.size} properties")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == "default_value", s"Exercise 6 failed: expected 'default_value', got $r6")
    println(s"Exercise 6 passed: $r6")

    println("All Zio029_System exercises passed!")
  }
}
