package org.shev4ik.interview.testing.level2_intermediate

/**
 * Test012 - Advanced Mocking
 *
 * Partial mocks, argument captors, ordered verification,
 * and sophisticated mocking patterns.
 */
object Test012_MockingAdvanced {

  // ==========================================================================
  // Exercise 1: Implement an argument captor
  // ==========================================================================
  // TODO: Implement `ArgumentCaptor[A]` that captures arguments passed to a function:
  //       - capture(value: A): Unit  (records the value)
  //       - allValues: List[A]  (all captured values in order)
  //       - lastValue: Option[A]  (most recent)
  //       - getValue(index: Int): Option[A]  (by index)
  //       - clear(): Unit  (reset captured values)
  //       Implement `captorFunction[A, B](captor: ArgumentCaptor[A], result: B): A => B`
  //       that creates a function which captures args and returns result.
  class ArgumentCaptor[A] {
    def capture(value: A): Unit = ???
    def allValues: List[A] = ???
    def lastValue: Option[A] = ???
    def getValue(index: Int): Option[A] = ???
    def clear(): Unit = ???
  }

  def captorFunction[A, B](captor: ArgumentCaptor[A], result: B): A => B = ???

  // ==========================================================================
  // Exercise 2: Implement ordered verification
  // ==========================================================================
  // TODO: Implement `InOrder` that verifies a sequence of method calls happened
  //       in the correct order across multiple mocks.
  //       - add(mockName: String, methodName: String): Unit  (record a call)
  //       - verifyInOrder(expected: List[(String, String)]): Either[String, Boolean]
  //         (checks calls happened in the specified order)
  //       - verifyNoMoreInteractions(): Boolean  (no unverified calls remain)
  //       Left should contain descriptive error: "Expected (mock,method) at position N but got (actual)"
  class InOrder {
    def add(mockName: String, methodName: String): Unit = ???
    def verifyInOrder(expected: List[(String, String)]): Either[String, Boolean] = ???
    def verifyNoMoreInteractions(): Boolean = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a partial mock (spy with selective overrides)
  // ==========================================================================
  // TODO: Implement `PartialMock` that wraps a Map[String, Any => Any] of method impls.
  //       - override_(method: String)(impl: Any => Any): PartialMock  (override specific method)
  //       - call(method: String, arg: Any): Any  (uses override if present, else default)
  //       - resetOverride(method: String): PartialMock
  //       - isOverridden(method: String): Boolean
  //       Constructor takes a defaultImpl: (String, Any) => Any for non-overridden methods.
  class PartialMock(defaultImpl: (String, Any) => Any) {
    def override_(method: String)(impl: Any => Any): PartialMock = ???
    def call(method: String, arg: Any): Any = ???
    def resetOverride(method: String): PartialMock = ???
    def isOverridden(method: String): Boolean = ???
  }

  // ==========================================================================
  // Exercise 4: Implement answer delegation (dynamic mock responses)
  // ==========================================================================
  // TODO: Implement `DynamicMock[A, B]` where responses depend on the input:
  //       - answering(f: A => B): DynamicMock[A, B]  (sets answer function)
  //       - answeringWithIndex(f: (A, Int) => B): DynamicMock[A, B]
  //         (answer function receives the call index, starting from 0)
  //       - thenThrowOnNthCall(n: Int, ex: Throwable): DynamicMock[A, B]
  //       - apply(arg: A): B
  //       - callHistory: List[(A, Either[Throwable, B])]  (arg and result/error)
  class DynamicMock[A, B] {
    def answering(f: A => B): DynamicMock[A, B] = ???
    def answeringWithIndex(f: (A, Int) => B): DynamicMock[A, B] = ???
    def thenThrowOnNthCall(n: Int, ex: Throwable): DynamicMock[A, B] = ???
    def apply(arg: A): B = ???
    def callHistory: List[(A, Either[Throwable, B])] = ???
  }

  // ==========================================================================
  // Exercise 5: Implement a verification mode system
  // ==========================================================================
  // TODO: Implement different verification modes for mock interactions:
  //       - Times(n: Int)  - exact number of calls
  //       - AtLeast(n: Int)  - minimum calls
  //       - AtMost(n: Int)  - maximum calls
  //       - Between(min: Int, max: Int)  - range
  //       - Never  - zero calls
  //       Implement `verifyWith(calls: List[Any], mode: VerificationMode): Either[String, Boolean]`
  //       Left contains descriptive error if verification fails.
  sealed trait VerificationMode
  case class Times(n: Int) extends VerificationMode
  case class AtLeast(n: Int) extends VerificationMode
  case class AtMost(n: Int) extends VerificationMode
  case class Between(min: Int, max: Int) extends VerificationMode
  case object Never extends VerificationMode

  def verifyWith(calls: List[Any], mode: VerificationMode): Either[String, Boolean] = ???

  // ==========================================================================
  // Exercise 6: Implement a mock chain (sequential return values)
  // ==========================================================================
  // TODO: Implement `ChainedMock[A, B]` that returns different values on
  //       successive calls:
  //       - thenReturn(value: B): ChainedMock[A, B]  (adds to return queue)
  //       - thenThrow(ex: Throwable): ChainedMock[A, B]
  //       - apply(arg: A): B  (returns next value in chain)
  //       After all values are consumed, repeat the last one.
  //       Track the total number of invocations.
  class ChainedMock[A, B] {
    def thenReturn(value: B): ChainedMock[A, B] = ???
    def thenThrow(ex: Throwable): ChainedMock[A, B] = ???
    def apply(arg: A): B = ???
    def invocationCount: Int = ???
  }

  // ==========================================================================
  // Exercise 7: Implement deep stub / auto-mock
  // ==========================================================================
  // TODO: Implement `DeepStub` that creates a mock which returns mocks for
  //       any method call, allowing chained calls without explicit setup.
  //       - get(path: String): Any  (dot-separated path, e.g., "user.address.city")
  //       - set(path: String, value: Any): Unit  (set value at path)
  //       - paths: Set[String]  (all paths that have been set)
  //       Intermediate path segments create nested DeepStubs automatically.
  class DeepStub {
    def get(path: String): Any = ???
    def set(path: String, value: Any): Unit = ???
    def paths: Set[String] = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a mock reset and lifecycle manager
  // ==========================================================================
  // TODO: Implement `MockRegistry` that manages multiple mocks:
  //       - register(name: String, recorder: ArgumentCaptor[_]): Unit
  //       - resetAll(): Unit  (clears all captors)
  //       - verifyAll(expectations: Map[String, Int]): Map[String, Boolean]
  //         (verifies each named mock was called the expected number of times)
  //       - snapshot(): Map[String, List[_]]  (current state of all captors)
  //       - report(): String  (formatted report of all mock interactions)
  class MockRegistry {
    def register(name: String, recorder: ArgumentCaptor[_]): Unit = ???
    def resetAll(): Unit = ???
    def verifyAll(expectations: Map[String, Int]): Map[String, Boolean] = ???
    def snapshot(): Map[String, List[_]] = ???
    def report(): String = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val captor = new ArgumentCaptor[String]
    val fn = captorFunction(captor, 42)
    assert(fn("hello") == 42)
    assert(fn("world") == 42)
    assert(captor.allValues == List("hello", "world"))
    assert(captor.lastValue.contains("world"))
    assert(captor.getValue(0).contains("hello"))
    captor.clear()
    assert(captor.allValues.isEmpty)
    println("Exercise 1 passed: ArgumentCaptor works")

    // Exercise 2
    val inOrder = new InOrder
    inOrder.add("userService", "findUser")
    inOrder.add("emailService", "sendEmail")
    inOrder.add("logService", "log")
    assert(inOrder.verifyInOrder(List(
      ("userService", "findUser"),
      ("emailService", "sendEmail"),
      ("logService", "log")
    )).isRight)
    assert(inOrder.verifyInOrder(List(
      ("emailService", "sendEmail"),
      ("userService", "findUser")
    )).isLeft)
    println("Exercise 2 passed: ordered verification works")

    // Exercise 3
    val partial = new PartialMock((method, arg) => s"default:$method($arg)")
      .override_("greet")(arg => s"Hello, $arg!")
    assert(partial.call("greet", "Alice") == "Hello, Alice!")
    assert(partial.call("other", "x") == "default:other(x)")
    assert(partial.isOverridden("greet"))
    val reset = partial.resetOverride("greet")
    assert(!reset.isOverridden("greet"))
    println("Exercise 3 passed: partial mock works")

    // Exercise 4
    val dynamic = new DynamicMock[Int, String]
      .answeringWithIndex((n, idx) => s"call$idx:${n * 2}")
    assert(dynamic(5) == "call0:10")
    assert(dynamic(3) == "call1:6")
    assert(dynamic.callHistory.length == 2)
    println("Exercise 4 passed: dynamic mock works")

    // Exercise 5
    val calls3 = List("a", "b", "c")
    assert(verifyWith(calls3, Times(3)).isRight)
    assert(verifyWith(calls3, Times(2)).isLeft)
    assert(verifyWith(calls3, AtLeast(2)).isRight)
    assert(verifyWith(calls3, AtMost(5)).isRight)
    assert(verifyWith(calls3, Between(1, 4)).isRight)
    assert(verifyWith(Nil, Never).isRight)
    assert(verifyWith(calls3, Never).isLeft)
    println("Exercise 5 passed: verification modes work")

    // Exercise 6
    val chained = new ChainedMock[String, Int]
      .thenReturn(1)
      .thenReturn(2)
      .thenReturn(3)
    assert(chained("a") == 1)
    assert(chained("b") == 2)
    assert(chained("c") == 3)
    assert(chained("d") == 3) // repeats last
    assert(chained.invocationCount == 4)
    println("Exercise 6 passed: chained mock works")

    // Exercise 7
    val deep = new DeepStub
    deep.set("user.name", "Alice")
    deep.set("user.address.city", "NYC")
    assert(deep.get("user.name") == "Alice")
    assert(deep.get("user.address.city") == "NYC")
    assert(deep.paths.contains("user.name"))
    assert(deep.paths.contains("user.address.city"))
    println("Exercise 7 passed: deep stub works")

    // Exercise 8
    val registry = new MockRegistry
    val cap1 = new ArgumentCaptor[String]
    val cap2 = new ArgumentCaptor[Int]
    registry.register("service1", cap1)
    registry.register("service2", cap2)
    cap1.capture("call1")
    cap1.capture("call2")
    cap2.capture(42)
    val verifications = registry.verifyAll(Map("service1" -> 2, "service2" -> 1))
    assert(verifications("service1") && verifications("service2"))
    assert(registry.report().nonEmpty)
    registry.resetAll()
    assert(cap1.allValues.isEmpty && cap2.allValues.isEmpty)
    println("Exercise 8 passed: mock registry works")

    println("\nAll Test012 exercises passed!")
  }
}
