package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 043 - Resource (Modeled as concept)
 *
 * Resource[F, A] represents a resource that must be acquired and released.
 * It guarantees that the release action runs even if the use action fails.
 * This models cats-effect Resource concepts using simplified traits.
 */
object Cats043_Resource {

  // Simplified Resource model for Cats 2.1.0 exercises
  // In real code, use cats.effect.Resource
  sealed trait SimpleResource[+A] {
    def use[B](f: A => B): B
  }

  case class ManagedResource[A](acquire: () => A, release: A => Unit) extends SimpleResource[A] {
    def use[B](f: A => B): B = {
      val resource = acquire()
      try f(resource)
      finally release(resource)
    }
  }

  // Tracking for test verification
  var acquireLog: List[String] = Nil
  var releaseLog: List[String] = Nil

  def resetLogs(): Unit = {
    acquireLog = Nil
    releaseLog = Nil
  }

  // Exercise 1: Resource.make - create a resource with acquire and release
  // TODO: Create a ManagedResource that acquires and releases a "connection".
  def exercise1_make(): SimpleResource[String] = {
    // Create a resource that:
    // - acquire: adds "acquired connection" to acquireLog, returns "connection-1"
    // - release: adds "released connection" to releaseLog
    ???
  }

  // Exercise 2: use - use a resource and ensure it gets released
  // TODO: Use the resource and verify it gets properly released.
  def exercise2_use(): String = {
    resetLogs()
    val resource = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "acquired"; "my-resource" },
      release = _ => { releaseLog = releaseLog :+ "released" }
    )
    // Use the resource to return "used: " + resourceValue
    ???
  }

  // Exercise 3: Resource from AutoCloseable - create resource from a closeable
  // TODO: Model creating a resource from something that has a close method.
  trait MyCloseable {
    def read(): String
    def close(): Unit
  }

  def exercise3_fromAutoCloseable(): String = {
    resetLogs()
    val closeable = new MyCloseable {
      def read(): String = "data"
      def close(): Unit = { releaseLog = releaseLog :+ "closed" }
    }

    val resource = ManagedResource[MyCloseable](
      acquire = () => { acquireLog = acquireLog :+ "opened"; closeable },
      release = c => c.close()
    )

    // Use the resource to read data
    ???
  }

  // Exercise 4: Resource.liftF - lift a pure value into a Resource (no release needed)
  // TODO: Create a resource that wraps a pure value with no-op release.
  def exercise4_liftPure(): SimpleResource[Int] = {
    // Create a resource wrapping the value 42 with no-op release
    ???
  }

  // Exercise 5: flatMap for sequential resources - chain resources sequentially
  // TODO: Demonstrate sequential resource acquisition (acquire A then B, release B then A).
  def exercise5_sequentialResources(): String = {
    resetLogs()

    val resourceA = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "acquired-A"; "A" },
      release = _ => { releaseLog = releaseLog :+ "released-A" }
    )

    val resourceB = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "acquired-B"; "B" },
      release = _ => { releaseLog = releaseLog :+ "released-B" }
    )

    // Use both resources: acquire A, then B, combine their values
    // Release should happen in reverse order: B first, then A
    ???
  }

  // Exercise 6: parZip for parallel resources - acquire resources "in parallel"
  // TODO: Model parallel resource acquisition (both acquired, both released).
  def exercise6_parallelResources(): String = {
    resetLogs()

    val r1 = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "acquired-1"; "res1" },
      release = _ => { releaseLog = releaseLog :+ "released-1" }
    )

    val r2 = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "acquired-2"; "res2" },
      release = _ => { releaseLog = releaseLog :+ "released-2" }
    )

    // Acquire both resources, combine their values as "res1+res2"
    // Both should be released after use
    ???
  }

  // Exercise 7: Resource.eval - lift an effect into Resource (no finalization)
  // TODO: Model lifting a side-effect into a resource context.
  def exercise7_eval(): String = {
    resetLogs()
    // Model eval as a resource that runs a side-effect during acquisition, no-op release
    val evalResource = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "effect-ran"; "effect-result" },
      release = _ => () // no finalization needed
    )

    // Use the resource to get its value
    ???
  }

  // Exercise 8: Nested resources - resources that depend on other resources
  // TODO: Demonstrate nested resource pattern where inner resource depends on outer.
  def exercise8_nestedResources(): String = {
    resetLogs()

    // Outer resource: "database connection"
    // Inner resource: "query cursor" (depends on connection)
    // Both must be properly released

    val connection = ManagedResource[String](
      acquire = () => { acquireLog = acquireLog :+ "connect-db"; "db-conn" },
      release = _ => { releaseLog = releaseLog :+ "disconnect-db" }
    )

    // Use connection to create and use a cursor resource
    // Return "queried with <cursor> on <connection>"
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    resetLogs()
    val r1 = exercise1_make()
    val r1v = r1.use(identity)
    assert(r1v == "connection-1", s"Exercise 1 failed: $r1v")
    assert(acquireLog.contains("acquired connection"), s"Exercise 1 failed: no acquire log")
    assert(releaseLog.contains("released connection"), s"Exercise 1 failed: no release log")
    println(s"Exercise 1 passed: Resource.make => $r1v, acquired=${acquireLog}, released=${releaseLog}")

    // Exercise 2
    val r2 = exercise2_use()
    assert(r2 == "used: my-resource", s"Exercise 2 failed: $r2")
    assert(releaseLog.nonEmpty, s"Exercise 2 failed: resource not released")
    println(s"Exercise 2 passed: use => $r2, released=${releaseLog}")

    // Exercise 3
    val r3 = exercise3_fromAutoCloseable()
    assert(r3 == "data", s"Exercise 3 failed: $r3")
    assert(releaseLog.contains("closed"), s"Exercise 3 failed: not closed")
    println(s"Exercise 3 passed: AutoCloseable => $r3, released=${releaseLog}")

    // Exercise 4
    val r4 = exercise4_liftPure()
    assert(r4.use(identity) == 42, s"Exercise 4 failed")
    println(s"Exercise 4 passed: liftF => ${r4.use(identity)}")

    // Exercise 5
    val r5 = exercise5_sequentialResources()
    assert(r5 == "A+B", s"Exercise 5 failed: $r5")
    assert(acquireLog == List("acquired-A", "acquired-B"), s"Exercise 5 acquire order wrong: $acquireLog")
    println(s"Exercise 5 passed: sequential => $r5, acquire=$acquireLog, release=$releaseLog")

    // Exercise 6
    val r6 = exercise6_parallelResources()
    assert(r6 == "res1+res2", s"Exercise 6 failed: $r6")
    assert(releaseLog.size == 2, s"Exercise 6 failed: not all released")
    println(s"Exercise 6 passed: parallel => $r6, released=$releaseLog")

    // Exercise 7
    val r7 = exercise7_eval()
    assert(r7 == "effect-result", s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: eval => $r7")

    // Exercise 8
    val r8 = exercise8_nestedResources()
    assert(r8.contains("db-conn"), s"Exercise 8 failed: $r8")
    assert(releaseLog.contains("disconnect-db"), s"Exercise 8 failed: db not disconnected")
    println(s"Exercise 8 passed: nested => $r8, release=$releaseLog")

    println("\nAll Cats043_Resource exercises passed!")
  }
}
