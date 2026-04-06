package org.shev4ik.interview.zio.level2_intermediate

import zio._
import zio.config._
import zio.config.ConfigDescriptor._
import zio.config.magnolia.DeriveConfigDescriptor._

/**
 * ZIO 066 - Config Magnolia: automatic config derivation.
 *
 * zio-config-magnolia provides automatic derivation of ConfigDescriptor
 * from case classes using Magnolia. Supports nested types, sealed traits,
 * custom field names, and documentation.
 *
 * Note: Uses zio-config-magnolia 1.x API.
 */
object Zio066_ConfigMagnolia {

  // Exercise 1: Auto-derive a ConfigDescriptor for a simple case class
  // TODO: case class SimpleConfig(name: String, count: Int)
  // Use descriptor[SimpleConfig] from magnolia
  case class SimpleConfig(name: String, count: Int)
  val exercise1: ConfigDescriptor[SimpleConfig] = ???

  // Exercise 2: Read auto-derived config from a Map source
  // TODO: read(descriptor[SimpleConfig] from ConfigSource.fromMap(Map(...)))
  val exercise2: IO[ReadError[String], SimpleConfig] = ???

  // Exercise 3: Auto-derive for nested case classes
  // TODO: case class Outer(inner: Inner, label: String)
  //       case class Inner(value: Int)
  case class Inner(value: Int)
  case class Outer(inner: Inner, label: String)
  val exercise3: ConfigDescriptor[Outer] = ???

  // Exercise 4: Auto-derive for sealed trait (ADT)
  // TODO: sealed trait Shape; case class Circle(r: Double); case class Rect(w: Double, h: Double)
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rect(width: Double, height: Double) extends Shape
  val exercise4: ConfigDescriptor[Shape] = ???

  // Exercise 5: Add documentation to auto-derived descriptor
  // TODO: descriptor[SimpleConfig] ?? "Application configuration"
  val exercise5: ConfigDescriptor[SimpleConfig] = ???

  // Exercise 6: Custom field names in auto-derived config
  // TODO: Rename fields using ConfigDescriptor operations
  val exercise6: IO[ReadError[String], SimpleConfig] = ???

  // Exercise 7: Generate a config report from a descriptor
  // TODO: generateDocs(descriptor[SimpleConfig]) to produce documentation
  val exercise7: UIO[String] = ???

  // Exercise 8: Validate auto-derived config
  // TODO: Read config and validate that count > 0
  val exercise8: IO[ReadError[String], SimpleConfig] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1
    assert(exercise1 != null, "Exercise 1 failed: descriptor is null")
    println(s"Exercise 1 passed: auto-derived descriptor created")

    // Exercise 2
    val r2 = runtime.unsafeRun(exercise2)
    assert(r2.name.nonEmpty, s"Exercise 2 failed: got $r2")
    println(s"Exercise 2 passed: $r2")

    // Exercise 3
    assert(exercise3 != null, "Exercise 3 failed")
    println(s"Exercise 3 passed: nested descriptor created")

    // Exercise 4
    assert(exercise4 != null, "Exercise 4 failed")
    println(s"Exercise 4 passed: sealed trait descriptor created")

    // Exercise 5
    assert(exercise5 != null, "Exercise 5 failed")
    println(s"Exercise 5 passed: documented descriptor created")

    // Exercise 6
    val r6 = runtime.unsafeRun(exercise6)
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val r7 = runtime.unsafeRun(exercise7)
    assert(r7.nonEmpty, s"Exercise 7 failed")
    println(s"Exercise 7 passed: report generated")

    // Exercise 8
    val r8 = runtime.unsafeRun(exercise8.either)
    println(s"Exercise 8 passed: $r8")

    println("All Zio066_ConfigMagnolia exercises passed!")
  }
}
