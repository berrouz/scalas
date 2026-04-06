package org.shev4ik.interview.testing.level1_basics

/**
 * Test004 - Mocking
 *
 * Building mock objects, stubs, spies, and call verification
 * mechanisms from scratch to understand testing fundamentals.
 */
object Test004_Mocking {

  // ==========================================================================
  // Exercise 1: Implement a simple stub
  // ==========================================================================
  // TODO: Implement `createStub` that takes a Map of (methodName -> returnValue)
  //       and returns a function String => Any that looks up the method name
  //       and returns the corresponding value.
  //       If the method is not in the map, throw NoSuchMethodException.
  def createStub(responses: Map[String, Any]): String => Any = ???

  // ==========================================================================
  // Exercise 2: Implement a call recorder (spy)
  // ==========================================================================
  // TODO: Implement `CallRecorder` that wraps any function A => B.
  //       It should record every call (the argument) and delegate to the wrapped function.
  //       Provide methods:
  //       - calls: List[A]  (all recorded arguments)
  //       - callCount: Int
  //       - wasCalledWith(arg: A): Boolean
  //       - lastCall: Option[A]
  class CallRecorder[A, B](f: A => B) {
    def apply(arg: A): B = ???
    def calls: List[A] = ???
    def callCount: Int = ???
    def wasCalledWith(arg: A): Boolean = ???
    def lastCall: Option[A] = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a mock with expectations
  // ==========================================================================
  // TODO: Implement `MockFunction` that records calls and can be programmed
  //       to return specific values for specific inputs.
  //       - whenCalledWith(arg: A): MockFunction[A,B]  (starts expectation)
  //       - thenReturn(value: B): MockFunction[A,B]    (sets return value)
  //       - apply(arg: A): B  (returns programmed value, or throws if not programmed)
  //       - verify(): Boolean (returns true if all programmed inputs were called)
  class MockFunction[A, B] {
    def whenCalledWith(arg: A): MockFunction[A, B] = ???
    def thenReturn(value: B): MockFunction[A, B] = ???
    def apply(arg: A): B = ???
    def verify(): Boolean = ???
  }

  // ==========================================================================
  // Exercise 4: Implement call order verification
  // ==========================================================================
  // TODO: Implement `OrderVerifier` that tracks the order of calls across
  //       multiple named operations.
  //       - record(operationName: String): Unit
  //       - verifyOrder(expected: List[String]): Boolean
  //         (checks that operations happened in the specified order; other ops
  //          may occur between them, but the relative order must match)
  //       - verifyExactOrder(expected: List[String]): Boolean
  //         (exact sequence match with no extras allowed)
  class OrderVerifier {
    def record(operationName: String): Unit = ???
    def verifyOrder(expected: List[String]): Boolean = ???
    def verifyExactOrder(expected: List[String]): Boolean = ???
    def recordings: List[String] = ???
  }

  // ==========================================================================
  // Exercise 5: Implement argument matchers
  // ==========================================================================
  // TODO: Implement an `ArgMatcher[A]` trait with:
  //       - def matches(value: A): Boolean
  //       Then implement factory methods:
  //       - ArgMatcher.any[A]: ArgMatcher[A]  (matches everything)
  //       - ArgMatcher.exact[A](value: A): ArgMatcher[A]
  //       - ArgMatcher.satisfying[A](pred: A => Boolean): ArgMatcher[A]
  //       Implement `matchArgs` that takes a MockFunction's recorded calls
  //       and an ArgMatcher, returning all matching calls.
  trait ArgMatcher[A] {
    def matches(value: A): Boolean
  }

  object ArgMatcher {
    def any[A]: ArgMatcher[A] = ???
    def exact[A](value: A): ArgMatcher[A] = ???
    def satisfying[A](pred: A => Boolean): ArgMatcher[A] = ???
  }

  def matchArgs[A](calls: List[A], matcher: ArgMatcher[A]): List[A] = ???

  // ==========================================================================
  // Exercise 6: Implement a fake implementation pattern
  // ==========================================================================
  // TODO: Implement `FakeKeyValueStore` that implements a trait:
  //       trait KeyValueStore { def get(key: String): Option[String]; def put(key: String, value: String): Unit; def delete(key: String): Unit; def keys: Set[String] }
  //       The fake uses a mutable Map internally and is fully functional (not stubbed).
  //       This demonstrates the Fake pattern vs Mocks/Stubs.
  trait KeyValueStore {
    def get(key: String): Option[String]
    def put(key: String, value: String): Unit
    def delete(key: String): Unit
    def keys: Set[String]
  }

  class FakeKeyValueStore extends KeyValueStore {
    def get(key: String): Option[String] = ???
    def put(key: String, value: String): Unit = ???
    def delete(key: String): Unit = ???
    def keys: Set[String] = ???
  }

  // ==========================================================================
  // Exercise 7: Implement call count verification
  // ==========================================================================
  // TODO: Implement `CallCountVerifier[A]` that wraps a function and provides:
  //       - verifyCalledTimes(n: Int): Boolean (exactly n times)
  //       - verifyCalledAtLeast(n: Int): Boolean
  //       - verifyCalledAtMost(n: Int): Boolean
  //       - verifyNeverCalled: Boolean
  //       - verifyCalledBetween(min: Int, max: Int): Boolean
  //       Each returns true if the condition holds.
  class CallCountVerifier[A, B](f: A => B) {
    def apply(arg: A): B = ???
    def verifyCalledTimes(n: Int): Boolean = ???
    def verifyCalledAtLeast(n: Int): Boolean = ???
    def verifyCalledAtMost(n: Int): Boolean = ???
    def verifyNeverCalled: Boolean = ???
    def verifyCalledBetween(min: Int, max: Int): Boolean = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a mock builder with fluent API
  // ==========================================================================
  // TODO: Implement `MockBuilder[A, B]` that provides a fluent API:
  //       - on(input: A): MockBuilder[A, B]       (specifies which input to program)
  //       - returns(output: B): MockBuilder[A, B]  (specifies what to return)
  //       - throws(ex: Throwable): MockBuilder[A, B] (specifies exception to throw)
  //       - build(): A => B                        (creates the mock function)
  //       The built function should use the programmed behaviors.
  //       Unprogrammed inputs should throw IllegalArgumentException.
  class MockBuilder[A, B] {
    def on(input: A): MockBuilder[A, B] = ???
    def returns(output: B): MockBuilder[A, B] = ???
    def throws(ex: Throwable): MockBuilder[A, B] = ???
    def build(): A => B = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val stub = createStub(Map("getName" -> "Alice", "getAge" -> 30))
    assert(stub("getName") == "Alice")
    assert(stub("getAge") == 30)
    var noMethod = false
    try { stub("unknown") } catch { case _: NoSuchMethodException => noMethod = true }
    assert(noMethod)
    println("Exercise 1 passed: stub creation works")

    // Exercise 2
    val recorder = new CallRecorder[Int, Int](_ * 2)
    assert(recorder(5) == 10)
    assert(recorder(3) == 6)
    assert(recorder.callCount == 2)
    assert(recorder.wasCalledWith(5))
    assert(recorder.lastCall.contains(3))
    println("Exercise 2 passed: call recorder works")

    // Exercise 3
    val mock = new MockFunction[String, Int]
    mock.whenCalledWith("hello").thenReturn(5)
    mock.whenCalledWith("world").thenReturn(5)
    assert(mock("hello") == 5)
    assert(mock("world") == 5)
    assert(mock.verify())
    println("Exercise 3 passed: mock with expectations works")

    // Exercise 4
    val verifier = new OrderVerifier
    verifier.record("init")
    verifier.record("process")
    verifier.record("cleanup")
    assert(verifier.verifyOrder(List("init", "cleanup")))
    assert(verifier.verifyExactOrder(List("init", "process", "cleanup")))
    assert(!verifier.verifyOrder(List("cleanup", "init")))
    println("Exercise 4 passed: order verification works")

    // Exercise 5
    val anyMatcher = ArgMatcher.any[Int]
    assert(anyMatcher.matches(42))
    val exactMatcher = ArgMatcher.exact(10)
    assert(exactMatcher.matches(10) && !exactMatcher.matches(11))
    val predMatcher = ArgMatcher.satisfying[Int](_ > 5)
    assert(matchArgs(List(1, 6, 3, 8), predMatcher) == List(6, 8))
    println("Exercise 5 passed: argument matchers work")

    // Exercise 6
    val store = new FakeKeyValueStore
    store.put("a", "1")
    store.put("b", "2")
    assert(store.get("a").contains("1"))
    store.delete("a")
    assert(store.get("a").isEmpty)
    assert(store.keys == Set("b"))
    println("Exercise 6 passed: fake key-value store works")

    // Exercise 7
    val ccv = new CallCountVerifier[Int, Int](_ + 1)
    ccv(1); ccv(2); ccv(3)
    assert(ccv.verifyCalledTimes(3))
    assert(ccv.verifyCalledAtLeast(2))
    assert(ccv.verifyCalledAtMost(5))
    assert(!ccv.verifyNeverCalled)
    assert(ccv.verifyCalledBetween(1, 4))
    println("Exercise 7 passed: call count verification works")

    // Exercise 8
    val built = new MockBuilder[String, Int]()
      .on("a").returns(1)
      .on("b").returns(2)
      .on("error").throws(new RuntimeException("fail"))
      .build()
    assert(built("a") == 1)
    assert(built("b") == 2)
    var threwEx = false
    try { built("error") } catch { case _: RuntimeException => threwEx = true }
    assert(threwEx)
    println("Exercise 8 passed: mock builder works")

    println("\nAll Test004 exercises passed!")
  }
}
