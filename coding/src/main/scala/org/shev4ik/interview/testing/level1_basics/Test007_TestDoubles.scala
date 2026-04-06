package org.shev4ik.interview.testing.level1_basics

/**
 * Test007 - Test Doubles
 *
 * Understanding different types of test doubles: fakes, dummies,
 * stubs vs mocks distinction, and when to use each pattern.
 */
object Test007_TestDoubles {

  // Shared trait used across exercises
  trait EmailService {
    def send(to: String, subject: String, body: String): Boolean
    def sentCount: Int
  }

  trait Logger {
    def info(msg: String): Unit
    def error(msg: String): Unit
    def messages: List[String]
  }

  trait UserRepository {
    def findById(id: Int): Option[String]
    def save(id: Int, name: String): Unit
    def delete(id: Int): Boolean
    def all: List[(Int, String)]
  }

  // ==========================================================================
  // Exercise 1: Implement a Dummy (no-op implementation)
  // ==========================================================================
  // TODO: Implement `DummyLogger` that implements Logger but does nothing.
  //       All methods are no-ops, messages returns empty list.
  //       Dummies are used when a dependency is required but not relevant to the test.
  class DummyLogger extends Logger {
    def info(msg: String): Unit = ???
    def error(msg: String): Unit = ???
    def messages: List[String] = ???
  }

  // ==========================================================================
  // Exercise 2: Implement a Stub (pre-programmed responses)
  // ==========================================================================
  // TODO: Implement `StubUserRepository` that returns pre-configured data.
  //       Constructor takes a Map[Int, String] of id->name entries.
  //       findById looks up in the map. save/delete do nothing.
  //       all returns all entries as a list.
  //       Stubs provide canned answers to calls made during the test.
  class StubUserRepository(data: Map[Int, String]) extends UserRepository {
    def findById(id: Int): Option[String] = ???
    def save(id: Int, name: String): Unit = ???
    def delete(id: Int): Boolean = ???
    def all: List[(Int, String)] = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a Fake (working but simplified implementation)
  // ==========================================================================
  // TODO: Implement `FakeEmailService` that simulates sending emails.
  //       Instead of actually sending, store emails in a mutable buffer.
  //       - send returns true always
  //       - sentCount returns number of "sent" emails
  //       - sentEmails: List[(String, String, String)] returns all recorded emails
  //       Fakes have working implementations but are simplified (in-memory vs real).
  class FakeEmailService extends EmailService {
    def send(to: String, subject: String, body: String): Boolean = ???
    def sentCount: Int = ???
    def sentEmails: List[(String, String, String)] = ???
  }

  // ==========================================================================
  // Exercise 4: Implement a Spy (records interactions)
  // ==========================================================================
  // TODO: Implement `SpyUserRepository` that wraps a real UserRepository,
  //       delegates all calls to it, and records every method invocation.
  //       - methodCalls: List[(String, List[Any])] (method name + arguments)
  //       - wasMethodCalled(name: String): Boolean
  //       - callCountFor(name: String): Int
  //       Spies let you verify interactions while still using real behavior.
  class SpyUserRepository(delegate: UserRepository) extends UserRepository {
    def findById(id: Int): Option[String] = ???
    def save(id: Int, name: String): Unit = ???
    def delete(id: Int): Boolean = ???
    def all: List[(Int, String)] = ???
    def methodCalls: List[(String, List[Any])] = ???
    def wasMethodCalled(name: String): Boolean = ???
    def callCountFor(name: String): Int = ???
  }

  // ==========================================================================
  // Exercise 5: Implement a Mock (verifiable expectations)
  // ==========================================================================
  // TODO: Implement `MockEmailService` that can be programmed with expectations
  //       and verified after the test.
  //       - expectSend(to: String, subject: String): MockEmailService  (set expectation)
  //       - send actually checks if the call matches an expectation
  //       - verifyAllExpectationsMet(): Boolean  (all expected calls were made)
  //       - verifyNoUnexpectedCalls(): Boolean  (no calls beyond expectations)
  //       Mocks verify that certain interactions happened.
  class MockEmailService extends EmailService {
    def expectSend(to: String, subject: String): MockEmailService = ???
    def send(to: String, subject: String, body: String): Boolean = ???
    def sentCount: Int = ???
    def verifyAllExpectationsMet(): Boolean = ???
    def verifyNoUnexpectedCalls(): Boolean = ???
  }

  // ==========================================================================
  // Exercise 6: Implement a configurable test double
  // ==========================================================================
  // TODO: Implement `ConfigurableDouble[A]` that can behave as any type of double.
  //       It wraps a function Map and can be configured for different behaviors:
  //       - asStub(method: String, response: Any): ConfigurableDouble[A]
  //       - asSpy(): ConfigurableDouble[A]  (starts recording calls)
  //       - call(method: String, args: Any*): Any  (dispatches to configured behavior)
  //       - getCalls(method: String): List[List[Any]]  (spy data)
  //       - asFailing(method: String, error: Throwable): ConfigurableDouble[A]
  class ConfigurableDouble {
    def asStub(method: String, response: Any): ConfigurableDouble = ???
    def asSpy(): ConfigurableDouble = ???
    def asFailing(method: String, error: Throwable): ConfigurableDouble = ???
    def call(method: String, args: Any*): Any = ???
    def getCalls(method: String): List[List[Any]] = ???
  }

  // ==========================================================================
  // Exercise 7: Implement a test double factory
  // ==========================================================================
  // TODO: Implement `TestDoubleFactory` with methods that create different doubles
  //       for a simple Calculator trait:
  //       trait Calculator { def add(a: Int, b: Int): Int; def divide(a: Int, b: Int): Int }
  //       - createDummy(): Calculator  (returns 0 for everything)
  //       - createStub(addResult: Int, divideResult: Int): Calculator
  //       - createFake(): Calculator  (actually computes correctly)
  //       - createFailingDouble(ex: Throwable): Calculator  (always throws)
  trait Calculator {
    def add(a: Int, b: Int): Int
    def divide(a: Int, b: Int): Int
  }

  object TestDoubleFactory {
    def createDummy(): Calculator = ???
    def createStub(addResult: Int, divideResult: Int): Calculator = ???
    def createFake(): Calculator = ???
    def createFailingDouble(ex: Throwable): Calculator = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a comparison showing when to use which double
  // ==========================================================================
  // TODO: Implement a `NotificationService` class that depends on EmailService,
  //       Logger, and UserRepository.
  //       - notifyUser(userId: Int, message: String): Boolean
  //         Looks up user, sends email to "userId@test.com", logs the action.
  //         Returns true if user found and email sent.
  //       Then implement four test helper functions that test notifyUser using
  //       different double types, returning true if the scenario passes:
  //       - testWithDummy(): Boolean  (test that logging doesn't break things)
  //       - testWithStub(): Boolean   (test behavior with known user data)
  //       - testWithFake(): Boolean   (test with realistic email capture)
  //       - testWithSpy(): Boolean    (test that correct methods were called)
  class NotificationService(
    emailService: EmailService,
    logger: Logger,
    userRepo: UserRepository
  ) {
    def notifyUser(userId: Int, message: String): Boolean = ???
  }

  def testWithDummy(): Boolean = ???
  def testWithStub(): Boolean = ???
  def testWithFake(): Boolean = ???
  def testWithSpy(): Boolean = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val dummy = new DummyLogger
    dummy.info("test")
    dummy.error("test")
    assert(dummy.messages.isEmpty)
    println("Exercise 1 passed: DummyLogger works (no-op)")

    // Exercise 2
    val stub = new StubUserRepository(Map(1 -> "Alice", 2 -> "Bob"))
    assert(stub.findById(1).contains("Alice"))
    assert(stub.findById(99).isEmpty)
    assert(stub.all.length == 2)
    println("Exercise 2 passed: StubUserRepository works (canned data)")

    // Exercise 3
    val fake = new FakeEmailService
    fake.send("alice@test.com", "Hello", "World")
    fake.send("bob@test.com", "Hi", "There")
    assert(fake.sentCount == 2)
    assert(fake.sentEmails.head._1 == "alice@test.com")
    println("Exercise 3 passed: FakeEmailService works (in-memory)")

    // Exercise 4
    val realRepo = new StubUserRepository(Map(1 -> "Alice"))
    val spy = new SpyUserRepository(realRepo)
    spy.findById(1)
    spy.findById(2)
    spy.save(3, "Charlie")
    assert(spy.wasMethodCalled("findById"))
    assert(spy.callCountFor("findById") == 2)
    assert(spy.wasMethodCalled("save"))
    println("Exercise 4 passed: SpyUserRepository works (records calls)")

    // Exercise 5
    val mock = new MockEmailService
    mock.expectSend("alice@test.com", "Hello")
    mock.send("alice@test.com", "Hello", "body")
    assert(mock.verifyAllExpectationsMet())
    assert(mock.verifyNoUnexpectedCalls())
    println("Exercise 5 passed: MockEmailService works (verifiable)")

    // Exercise 6
    val configurable = new ConfigurableDouble()
      .asStub("get", "value1")
      .asSpy()
    assert(configurable.call("get") == "value1")
    assert(configurable.getCalls("get").length == 1)
    println("Exercise 6 passed: ConfigurableDouble works")

    // Exercise 7
    val dummyCalc = TestDoubleFactory.createDummy()
    assert(dummyCalc.add(1, 2) == 0)
    val fakeCalc = TestDoubleFactory.createFake()
    assert(fakeCalc.add(3, 4) == 7)
    assert(fakeCalc.divide(10, 2) == 5)
    val stubCalc = TestDoubleFactory.createStub(99, 42)
    assert(stubCalc.add(0, 0) == 99)
    println("Exercise 7 passed: TestDoubleFactory works")

    // Exercise 8
    assert(testWithDummy())
    assert(testWithStub())
    assert(testWithFake())
    assert(testWithSpy())
    println("Exercise 8 passed: different doubles used appropriately")

    println("\nAll Test007 exercises passed!")
  }
}
