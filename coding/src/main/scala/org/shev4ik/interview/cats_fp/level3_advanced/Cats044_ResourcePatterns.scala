package org.shev4ik.interview.cats_fp.level3_advanced

import cats._
import cats.implicits._

/**
 * Cats 044 - Resource Patterns
 *
 * Common patterns for resource management using the Resource concept.
 * These patterns ensure safe acquisition and release of system resources
 * like connections, file handles, HTTP clients, etc.
 */
object Cats044_ResourcePatterns {

  // Reuse simplified Resource model
  case class ManagedResource[A](acquire: () => A, release: A => Unit) {
    def use[B](f: A => B): B = {
      val resource = acquire()
      try f(resource)
      finally release(resource)
    }

    def flatMap[B](f: A => ManagedResource[B]): ManagedResource[B] =
      ManagedResource[B](
        acquire = () => {
          val a = acquire()
          val inner = f(a)
          inner.acquire()
        },
        release = b => ()  // simplified - real impl tracks both
      )

    def map[B](f: A => B): ManagedResource[B] =
      ManagedResource[B](
        acquire = () => f(acquire()),
        release = _ => ()
      )
  }

  var eventLog: List[String] = Nil
  def resetLog(): Unit = { eventLog = Nil }
  def log(msg: String): Unit = { eventLog = eventLog :+ msg }

  // Exercise 1: Connection pool as Resource - model a connection pool lifecycle
  // TODO: Create a resource that represents a connection pool.
  case class ConnectionPool(name: String, size: Int)

  def exercise1_connectionPool(): ManagedResource[ConnectionPool] = {
    // Create a resource that:
    // - acquire: logs "pool-created", returns ConnectionPool("main-pool", 10)
    // - release: logs "pool-shutdown"
    ???
  }

  // Exercise 2: File handle resource - model file open/close lifecycle
  // TODO: Create a resource for a file handle.
  case class FileHandle(path: String, var content: String = "")

  def exercise2_fileHandle(path: String): ManagedResource[FileHandle] = {
    // Create a resource that:
    // - acquire: logs "file-opened:<path>", returns FileHandle(path)
    // - release: logs "file-closed:<path>"
    ???
  }

  // Exercise 3: HTTP client resource - model HTTP client lifecycle
  // TODO: Create a resource for an HTTP client.
  case class HttpClient(baseUrl: String) {
    def get(path: String): String = s"GET $baseUrl$path => 200 OK"
  }

  def exercise3_httpClient(baseUrl: String): ManagedResource[HttpClient] = {
    // Create a resource that:
    // - acquire: logs "http-client-created", returns HttpClient(baseUrl)
    // - release: logs "http-client-shutdown"
    ???
  }

  // Exercise 4: Resource finalization order - verify LIFO release order
  // TODO: Demonstrate that nested resources release in reverse order.
  def exercise4_finalizationOrder(): List[String] = {
    resetLog()

    val r1 = ManagedResource[String](
      acquire = () => { log("acquire-1"); "r1" },
      release = _ => log("release-1")
    )

    val r2 = ManagedResource[String](
      acquire = () => { log("acquire-2"); "r2" },
      release = _ => log("release-2")
    )

    val r3 = ManagedResource[String](
      acquire = () => { log("acquire-3"); "r3" },
      release = _ => log("release-3")
    )

    // Use all three resources nested, return the event log
    // Acquire order: 1, 2, 3. Release order: 3, 2, 1 (LIFO)
    ???
  }

  // Exercise 5: Resource error handling - ensure release happens even on error
  // TODO: Show that resources are released even when use throws an exception.
  def exercise5_errorHandling(): (String, List[String]) = {
    resetLog()

    val resource = ManagedResource[String](
      acquire = () => { log("acquired"); "resource" },
      release = _ => log("released")
    )

    // Use the resource, catch any exception, and verify release happened
    val result: String = ???  // try to use, if error return "error caught"

    (result, eventLog)
  }

  // Exercise 6: Resource timeout pattern - model a resource with timeout concept
  // TODO: Create a resource that represents a timed operation.
  case class TimedResource(name: String, timeoutMs: Long)

  def exercise6_resourceTimeout(): ManagedResource[TimedResource] = {
    // Create a resource that:
    // - acquire: logs "timed-resource-start", returns TimedResource("query", 5000)
    // - release: logs "timed-resource-end"
    ???
  }

  // Exercise 7: Resource retry pattern - model retry logic for resource acquisition
  // TODO: Create a resource with retry on acquisition failure.
  def exercise7_resourceRetry(): String = {
    resetLog()
    var attempts = 0

    val resource = ManagedResource[String](
      acquire = () => {
        attempts += 1
        log(s"attempt-$attempts")
        if (attempts < 3) throw new RuntimeException(s"attempt $attempts failed")
        "finally-acquired"
      },
      release = _ => log("released")
    )

    // Implement retry logic: try to acquire up to 3 times
    // Return the resource value on success, or "failed" after all retries
    ???
  }

  // Exercise 8: Resource composition pattern - compose multiple resources into one
  // TODO: Compose multiple resources into a single combined resource.
  case class AppResources(pool: ConnectionPool, client: HttpClient)

  def exercise8_composition(): String = {
    resetLog()

    val poolResource = ManagedResource[ConnectionPool](
      acquire = () => { log("pool-up"); ConnectionPool("pool", 5) },
      release = _ => log("pool-down")
    )

    val clientResource = ManagedResource[HttpClient](
      acquire = () => { log("client-up"); HttpClient("http://api.example.com") },
      release = _ => log("client-down")
    )

    // Compose both resources and use the combined AppResources
    // Return "pool=pool,client=http://api.example.com"
    ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    resetLog()
    val r1 = exercise1_connectionPool()
    val pool = r1.use(identity)
    assert(pool.name == "main-pool" && pool.size == 10, s"Exercise 1 failed: $pool")
    assert(eventLog.contains("pool-created") && eventLog.contains("pool-shutdown"), s"Exercise 1 log failed: $eventLog")
    println(s"Exercise 1 passed: connection pool => $pool, log=$eventLog")

    // Exercise 2
    resetLog()
    val r2 = exercise2_fileHandle("/tmp/test.txt")
    val fh = r2.use(identity)
    assert(fh.path == "/tmp/test.txt", s"Exercise 2 failed: $fh")
    assert(eventLog.exists(_.contains("file-opened")), s"Exercise 2 log failed: $eventLog")
    println(s"Exercise 2 passed: file handle => $fh, log=$eventLog")

    // Exercise 3
    resetLog()
    val r3 = exercise3_httpClient("http://example.com")
    val response = r3.use(_.get("/api"))
    assert(response.contains("200 OK"), s"Exercise 3 failed: $response")
    println(s"Exercise 3 passed: HTTP client => $response, log=$eventLog")

    // Exercise 4
    val r4 = exercise4_finalizationOrder()
    println(s"Exercise 4 passed: finalization order => $r4")

    // Exercise 5
    val (r5result, r5log) = exercise5_errorHandling()
    assert(r5log.contains("released"), s"Exercise 5 failed: resource not released")
    println(s"Exercise 5 passed: error handling => result=$r5result, log=$r5log")

    // Exercise 6
    resetLog()
    val r6 = exercise6_resourceTimeout()
    val timed = r6.use(identity)
    assert(timed.timeoutMs == 5000, s"Exercise 6 failed: $timed")
    println(s"Exercise 6 passed: timeout => $timed, log=$eventLog")

    // Exercise 7
    val r7 = exercise7_resourceRetry()
    assert(r7 == "finally-acquired", s"Exercise 7 failed: $r7")
    println(s"Exercise 7 passed: retry => $r7, log=$eventLog")

    // Exercise 8
    val r8 = exercise8_composition()
    assert(r8.contains("pool") && r8.contains("http://api.example.com"), s"Exercise 8 failed: $r8")
    println(s"Exercise 8 passed: composition => $r8, log=$eventLog")

    println("\nAll Cats044_ResourcePatterns exercises passed!")
  }
}
