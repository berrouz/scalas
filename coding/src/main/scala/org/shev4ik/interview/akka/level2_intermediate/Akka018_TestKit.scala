package org.shev4ik.interview.akka.level2_intermediate

/**
 * Akka 018 - TestKit Concepts
 *
 * Akka TestKit provides tools for testing actor behavior:
 *   - TestProbe: a mock actor that can receive and assert on messages
 *   - expectMsg: assert that a specific message is received
 *   - expectNoMessage: assert that no message is received within timeout
 *   - fishForMessage: scan incoming messages for one matching a predicate
 *   - within: assert that operations complete within a time bound
 *   - TestActorRef: synchronous actor reference for unit testing
 *   - ImplicitSender: auto-sets testActor as sender
 *   - EventFilter: assert that certain log events occur
 *
 * We simulate these using pure Scala message queues.
 */
object Akka018_TestKit {

  // --- Domain models ---

  case class TestProbe(name: String, inbox: List[Any]) {
    def ref: String = s"TestProbe($name)"
    def receiveMessage: (Any, TestProbe) =
      if (inbox.nonEmpty) (inbox.head, TestProbe(name, inbox.tail))
      else throw new AssertionError(s"$name: no messages in inbox")
  }

  sealed trait TestResult
  case class Passed(description: String) extends TestResult
  case class Failed(description: String, reason: String) extends TestResult

  case class LogEvent(level: String, message: String, source: String)

  case class TimedExecution[A](result: A, durationMs: Long)

  // Exercise 1: TestProbe — expectMsg
  // TODO: Given a TestProbe and an expected message, check if the first message
  //   in the inbox matches. Return (TestResult, updatedProbe).
  //   Passed if message matches, Failed otherwise (or if inbox is empty).
  //   Remove the checked message from the inbox.
  def exercise1_expectMsg(probe: TestProbe, expected: Any): (TestResult, TestProbe) = ???

  // Exercise 2: TestProbe — expectNoMessage
  // TODO: Given a TestProbe, assert that the inbox is empty.
  //   Return Passed("No messages") if empty, Failed if any messages present.
  def exercise2_expectNoMessage(probe: TestProbe): TestResult = ???

  // Exercise 3: fishForMessage
  // TODO: Given a TestProbe and a predicate (Any => Boolean),
  //   scan through the inbox to find the first message matching the predicate.
  //   Return (Some(matchedMessage), updatedProbe) if found,
  //   (None, originalProbe) if not found.
  //   The matched message and all messages before it are removed from the inbox.
  def exercise3_fishForMessage(probe: TestProbe, predicate: Any => Boolean): (Option[Any], TestProbe) = ???

  // Exercise 4: within — time-bounded assertion
  // TODO: Simulate a time-bounded operation. Given a maxDurationMs and an operation
  //   that returns (result, actualDurationMs), check if it completed within the bound.
  //   Return Passed if within time, Failed if exceeded.
  def exercise4_within[A](maxDurationMs: Long, result: A, actualDurationMs: Long): (TestResult, A) = ???

  // Exercise 5: TestActorRef — synchronous testing
  // TODO: Simulate synchronous actor testing. Given an initial state (Int),
  //   a receive function (state, message) => newState, and a list of messages,
  //   process each message synchronously and return all intermediate states
  //   (including initial state).
  //   In real Akka: TestActorRef allows direct access to actor's internal state.
  def exercise5_testActorRef(
    initialState: Int,
    receive: (Int, String) => Int,
    messages: List[String]
  ): List[Int] = ???

  // Exercise 6: ImplicitSender — verify replies
  // TODO: Simulate ImplicitSender. Given a list of request-response pairs
  //   where each request produces a response, verify that each response matches
  //   the expected value. Return a list of TestResults.
  //   In real Akka: with ImplicitSender, replies go to testActor automatically.
  def exercise6_implicitSender(
    interactions: List[(String, String, String)] // (request, actualResponse, expectedResponse)
  ): List[TestResult] = ???

  // Exercise 7: EventFilter — assert log events
  // TODO: Given a list of LogEvents and filter criteria (level, messageContains),
  //   count how many log events match. If the count matches expectedCount, return Passed.
  //   Otherwise return Failed.
  //   In real Akka: EventFilter.error(occurrences = 2).intercept { ... }
  def exercise7_eventFilter(
    logs: List[LogEvent],
    level: String,
    messageContains: String,
    expectedCount: Int
  ): TestResult = ???

  // Exercise 8: Full test scenario — multi-probe interaction
  // TODO: Simulate a test with multiple probes. Given:
  //   - probe1 inbox and probe2 inbox (pre-filled with messages)
  //   - A list of assertions: ("probe1", expected) or ("probe2", expected)
  //   Process each assertion against the correct probe.
  //   Return (list of TestResults, final probe1, final probe2).
  def exercise8_multiProbeTest(
    probe1: TestProbe,
    probe2: TestProbe,
    assertions: List[(String, Any)]
  ): (List[TestResult], TestProbe, TestProbe) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val p1 = TestProbe("test", List("hello", "world"))
    val (r1, p1b) = exercise1_expectMsg(p1, "hello")
    assert(r1.isInstanceOf[Passed], s"Exercise 1 failed: $r1")
    assert(p1b.inbox == List("world"), s"Exercise 1 failed: inbox = ${p1b.inbox}")
    val (r1f, _) = exercise1_expectMsg(p1, "wrong")
    assert(r1f.isInstanceOf[Failed], s"Exercise 1 failed: should fail for wrong message")
    println("Exercise 1 passed: expectMsg works")

    // Exercise 2
    val r2a = exercise2_expectNoMessage(TestProbe("empty", Nil))
    assert(r2a.isInstanceOf[Passed], s"Exercise 2 failed: $r2a")
    val r2b = exercise2_expectNoMessage(TestProbe("full", List("msg")))
    assert(r2b.isInstanceOf[Failed], s"Exercise 2 failed: should fail when messages exist")
    println("Exercise 2 passed: expectNoMessage works")

    // Exercise 3
    val p3 = TestProbe("test", List(1, "hello", 2, "target", 3))
    val (found3, p3b) = exercise3_fishForMessage(p3, {
      case s: String if s == "target" => true
      case _ => false
    })
    assert(found3.contains("target"), s"Exercise 3 failed: $found3")
    assert(p3b.inbox == List(3), s"Exercise 3 failed: remaining = ${p3b.inbox}")
    println("Exercise 3 passed: fishForMessage works")

    // Exercise 4
    val (r4a, v4a) = exercise4_within(1000L, "ok", 500L)
    assert(r4a.isInstanceOf[Passed], s"Exercise 4 failed: $r4a")
    val (r4b, _) = exercise4_within(100L, "slow", 500L)
    assert(r4b.isInstanceOf[Failed], s"Exercise 4 failed: should fail when exceeded")
    println("Exercise 4 passed: within time bound works")

    // Exercise 5
    val states5 = exercise5_testActorRef(0, (s, m) => s + m.length, List("hi", "hey", "a"))
    assert(states5 == List(0, 2, 5, 6), s"Exercise 5 failed: $states5")
    println(s"Exercise 5 passed: $states5")

    // Exercise 6
    val r6 = exercise6_implicitSender(List(
      ("req1", "resp1", "resp1"),
      ("req2", "resp2", "wrong"),
      ("req3", "resp3", "resp3")
    ))
    assert(r6(0).isInstanceOf[Passed], "Exercise 6 failed: first should pass")
    assert(r6(1).isInstanceOf[Failed], "Exercise 6 failed: second should fail")
    assert(r6(2).isInstanceOf[Passed], "Exercise 6 failed: third should pass")
    println("Exercise 6 passed: implicit sender verification")

    // Exercise 7
    val logs = List(
      LogEvent("error", "NullPointerException in handler", "worker-1"),
      LogEvent("warn", "Slow response", "worker-2"),
      LogEvent("error", "NullPointerException in processor", "worker-3"),
      LogEvent("info", "Started", "system")
    )
    val r7 = exercise7_eventFilter(logs, "error", "NullPointerException", 2)
    assert(r7.isInstanceOf[Passed], s"Exercise 7 failed: $r7")
    val r7b = exercise7_eventFilter(logs, "error", "NullPointerException", 1)
    assert(r7b.isInstanceOf[Failed], s"Exercise 7 failed: count mismatch should fail")
    println("Exercise 7 passed: event filter works")

    // Exercise 8
    val pa = TestProbe("probe1", List("a", "b"))
    val pb = TestProbe("probe2", List(1, 2))
    val assertions8 = List(("probe1", "a"), ("probe2", 1), ("probe1", "b"), ("probe2", 2))
    val (results8, pa8, pb8) = exercise8_multiProbeTest(pa, pb, assertions8)
    assert(results8.forall(_.isInstanceOf[Passed]), s"Exercise 8 failed: $results8")
    assert(pa8.inbox.isEmpty, "Exercise 8 failed: probe1 should be drained")
    assert(pb8.inbox.isEmpty, "Exercise 8 failed: probe2 should be drained")
    println("Exercise 8 passed: multi-probe test works")

    println("\nAll Akka018_TestKit exercises passed!")
  }
}
