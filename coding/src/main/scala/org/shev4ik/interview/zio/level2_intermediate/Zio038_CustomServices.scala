package org.shev4ik.interview.zio.level2_intermediate

import zio._

/**
 * ZIO 038 - Custom Services: building real-world services with ZIO 1.x.
 *
 * Practice defining services like UserService, DatabaseService, etc.,
 * composing them with ZLayer, and testing with mock implementations.
 */
object Zio038_CustomServices {

  // Exercise 1: Define a UserService trait
  // TODO: trait with findUser(id: Int): IO[String, String]
  trait UserService {
    def findUser(id: Int): IO[String, String]
  }

  def findUser(id: Int): ZIO[Has[UserService], String, String] = ???

  // Exercise 2: Create a live UserService implementation
  // TODO: Return user name based on id (1 -> "Alice", 2 -> "Bob", else fail)
  val userServiceLive: ZLayer[Any, Nothing, Has[UserService]] = ???

  // Exercise 3: Define a DatabaseService trait
  // TODO: trait with execute(query: String): Task[String]
  trait DatabaseService {
    def execute(query: String): Task[String]
  }

  def dbExecute(query: String): ZIO[Has[DatabaseService], Throwable, String] = ???

  // Exercise 4: Define a LoggingService trait
  // TODO: trait with log(message: String): UIO[Unit]
  trait LoggingService {
    def log(message: String): UIO[Unit]
  }

  def logMsg(message: String): ZIO[Has[LoggingService], Nothing, Unit] = ???

  // Exercise 5: Create a LoggingService live layer
  // TODO: Implementation that prints to console with "[LOG] " prefix
  val loggingServiceLive: ZLayer[Any, Nothing, Has[LoggingService]] = ???

  // Exercise 6: Create a service with dependencies — HttpService that depends on LoggingService
  // TODO: Define HttpService with get(url: String): Task[String]
  // Live implementation should log before making the request
  trait HttpService {
    def get(url: String): Task[String]
  }

  val httpServiceLive: ZLayer[Has[LoggingService], Nothing, Has[HttpService]] = ???

  // Exercise 7: Create test implementations for all services
  // TODO: Create a test UserService layer that always returns "TestUser"
  val userServiceTest: ZLayer[Any, Nothing, Has[UserService]] = ???

  // Exercise 8: Compose all services into a full application layer
  // TODO: Combine userServiceLive ++ loggingServiceLive, then use loggingServiceLive >>> httpServiceLive
  // Final layer should provide Has[UserService] with Has[LoggingService] with Has[HttpService]
  val fullAppLayer: ZLayer[Any, Nothing, Has[UserService] with Has[LoggingService] with Has[HttpService]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    // Exercise 1 + 2
    val r1 = runtime.unsafeRun(findUser(1).provideLayer(userServiceLive))
    assert(r1 == "Alice", s"Exercise 1 failed: expected Alice, got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 3
    val r3 = runtime.unsafeRun(findUser(2).provideLayer(userServiceLive))
    assert(r3 == "Bob", s"Exercise 3 failed: expected Bob, got $r3")
    println(s"Exercise 3 passed: $r3")

    // Exercise 4 + 5
    val r5 = runtime.unsafeRun(logMsg("test message").provideLayer(loggingServiceLive))
    println(s"Exercise 5 passed: logged message")

    // Exercise 6
    val r6 = runtime.unsafeRun(
      ZIO.service[HttpService].provideLayer(loggingServiceLive >>> httpServiceLive)
    )
    assert(r6 != null, "Exercise 6 failed")
    println(s"Exercise 6 passed: HttpService created")

    // Exercise 7
    val r7 = runtime.unsafeRun(findUser(999).provideLayer(userServiceTest))
    assert(r7 == "TestUser", s"Exercise 7 failed: expected TestUser, got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val r8 = runtime.unsafeRun(findUser(1).provideLayer(fullAppLayer))
    assert(r8 == "Alice", s"Exercise 8 failed: expected Alice, got $r8")
    println(s"Exercise 8 passed: full app layer works")

    println("All Zio038_CustomServices exercises passed!")
  }
}
