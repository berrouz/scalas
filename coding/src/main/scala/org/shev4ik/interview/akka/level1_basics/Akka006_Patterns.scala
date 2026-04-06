package org.shev4ik.interview.akka.level1_basics

import scala.util.{Try, Success, Failure}

/**
 * Akka 006 - Common Actor Patterns
 *
 * Akka provides several built-in patterns for actor communication:
 *   - Ask pattern: sends a message and returns a Future for the response
 *   - Pipe pattern: pipes a Future result to an actor as a message
 *   - Stash/Unstash: temporarily buffers messages for later processing
 *   - Forward: forwards a message preserving the original sender
 *   - scheduleOnce: one-time delayed message delivery
 *   - scheduleWithFixedDelay: repeated message delivery at intervals
 *   - Graceful stop: cooperative shutdown with a timeout
 *   - Kill: causes ActorKilledException, handled by supervision
 */
object Akka006_Patterns {

  // --- Domain models ---

  sealed trait WorkerMessage
  case class DoWork(task: String, replyTo: String => Unit) extends WorkerMessage
  case class WorkResult(result: String) extends WorkerMessage
  case object Flush extends WorkerMessage
  case object GracefulShutdown extends WorkerMessage
  case object ForceKill extends WorkerMessage

  case class StashBuffer[M](buffer: List[M]) {
    def stash(msg: M): StashBuffer[M] = StashBuffer(buffer :+ msg)
    def unstashAll: (List[M], StashBuffer[M]) = (buffer, StashBuffer(Nil))
  }

  case class WorkerState(
    processed: List[String],
    isReady: Boolean,
    stash: StashBuffer[WorkerMessage],
    scheduledTasks: List[(Long, String)] // (delayMs, taskDescription)
  )

  case class ForwardEnvelope(originalSender: String, message: String, intermediary: String)

  // Exercise 1: Ask pattern simulation
  // TODO: Simulate the ask pattern. Given a task string, create a DoWork message
  //   with a replyTo callback that captures the result. Process it by calling the
  //   provided workFunction (String => String) and invoke replyTo with the result.
  //   Return the captured response string.
  //   In real Akka: (actorRef ? DoWork(task)).mapTo[String]
  def exercise1_askPattern(task: String, workFunction: String => String): String = ???

  // Exercise 2: Pipe pattern simulation
  // TODO: Simulate the pipe pattern. Given a Try[String] (representing a Future result),
  //   convert it to a WorkerMessage:
  //   - Success(value) -> WorkResult(value)
  //   - Failure(ex) -> WorkResult(s"Error: ${ex.getMessage}")
  //   In real Akka: future.pipeTo(actorRef)
  def exercise2_pipePattern(futureResult: Try[String]): WorkerMessage = ???

  // Exercise 3: Stash/Unstash pattern
  // TODO: Given a WorkerState where isReady=false, stash incoming DoWork messages.
  //   Process a list of WorkerMessages:
  //   - DoWork when !isReady: stash the message
  //   - Flush: set isReady=true, unstash all messages and process them
  //     (add each task to processed list)
  //   - DoWork when isReady: process immediately (add task to processed)
  //   Return the final WorkerState.
  def exercise3_stashUnstash(initial: WorkerState, messages: List[WorkerMessage]): WorkerState = ???

  // Exercise 4: Forward pattern
  // TODO: Simulate message forwarding through intermediaries.
  //   Given originalSender, a message, and a list of intermediary names,
  //   create a list of ForwardEnvelopes showing the forwarding chain.
  //   Each envelope has the originalSender (always the same), the message,
  //   and the intermediary at that step.
  //   In real Akka: target.forward(message) preserves the original sender.
  def exercise4_forwardPattern(
    originalSender: String,
    message: String,
    intermediaries: List[String]
  ): List[ForwardEnvelope] = ???

  // Exercise 5: scheduleOnce simulation
  // TODO: Given a WorkerState and a task with a delayMs,
  //   add the scheduled task to the scheduledTasks list.
  //   Then "execute" all scheduled tasks whose delay <= currentTimeMs
  //   by adding their descriptions to the processed list.
  //   Remove executed tasks from scheduledTasks.
  //   Return the updated WorkerState.
  def exercise5_scheduleOnce(state: WorkerState, task: String, delayMs: Long, currentTimeMs: Long): WorkerState = ???

  // Exercise 6: scheduleWithFixedDelay simulation
  // TODO: Given an interval and a total duration, calculate how many times
  //   a scheduled task would fire. The first execution happens after `initialDelayMs`,
  //   then every `intervalMs` after the previous execution completes.
  //   Return the list of execution timestamps (starting from initialDelayMs).
  //   Example: initialDelay=100, interval=200, duration=700 -> List(100, 300, 500, 700)
  def exercise6_scheduleWithFixedDelay(
    initialDelayMs: Long,
    intervalMs: Long,
    totalDurationMs: Long
  ): List[Long] = ???

  // Exercise 7: Graceful stop simulation
  // TODO: Given a WorkerState and a list of pending messages,
  //   process messages until GracefulShutdown is encountered.
  //   After GracefulShutdown, process any remaining DoWork messages in the list
  //   (drain the mailbox) but ignore any further GracefulShutdown or ForceKill.
  //   Return the final processed list.
  def exercise7_gracefulStop(state: WorkerState, messages: List[WorkerMessage]): List[String] = ???

  // Exercise 8: Kill vs GracefulShutdown
  // TODO: Given a list of WorkerMessages, process them:
  //   - DoWork(task, _): add task to processed list
  //   - GracefulShutdown: finish processing current queue then stop (return processed so far)
  //   - ForceKill: immediately stop, do NOT process any further messages (return processed so far)
  //   - Flush: ignore
  //   Return (processed list, shutdownReason) where shutdownReason is "graceful", "killed", or "completed".
  def exercise8_killVsGraceful(messages: List[WorkerMessage]): (List[String], String) = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_askPattern("compute-42", task => s"Result of $task: 42")
    assert(r1 == "Result of compute-42: 42", s"Exercise 1 failed: got $r1")
    println(s"Exercise 1 passed: $r1")

    // Exercise 2
    val r2a = exercise2_pipePattern(Success("done"))
    assert(r2a == WorkResult("done"), s"Exercise 2 failed: got $r2a")
    val r2b = exercise2_pipePattern(Failure(new Exception("boom")))
    assert(r2b == WorkResult("Error: boom"), s"Exercise 2 failed: got $r2b")
    println("Exercise 2 passed: pipe pattern works")

    // Exercise 3
    val ws3 = WorkerState(Nil, isReady = false, StashBuffer(Nil), Nil)
    val msgs3 = List(
      DoWork("task1", _ => ()),
      DoWork("task2", _ => ()),
      Flush,
      DoWork("task3", _ => ())
    )
    val r3 = exercise3_stashUnstash(ws3, msgs3)
    assert(r3.processed == List("task1", "task2", "task3"), s"Exercise 3 failed: ${r3.processed}")
    assert(r3.isReady, "Exercise 3 failed: should be ready")
    println(s"Exercise 3 passed: ${r3.processed}")

    // Exercise 4
    val r4 = exercise4_forwardPattern("client", "hello", List("proxy", "router", "target"))
    assert(r4.length == 3, s"Exercise 4 failed: expected 3 envelopes, got ${r4.length}")
    assert(r4.head == ForwardEnvelope("client", "hello", "proxy"), s"Exercise 4 failed: ${r4.head}")
    assert(r4.last == ForwardEnvelope("client", "hello", "target"), s"Exercise 4 failed: ${r4.last}")
    println("Exercise 4 passed: forward chain created")

    // Exercise 5
    val ws5 = WorkerState(Nil, isReady = true, StashBuffer(Nil), List((50L, "old-task")))
    val r5 = exercise5_scheduleOnce(ws5, "new-task", 200L, 100L)
    assert(r5.processed == List("old-task"), s"Exercise 5 failed: processed = ${r5.processed}")
    assert(r5.scheduledTasks == List((200L, "new-task")), s"Exercise 5 failed: scheduled = ${r5.scheduledTasks}")
    println("Exercise 5 passed: scheduleOnce works")

    // Exercise 6
    val r6 = exercise6_scheduleWithFixedDelay(100L, 200L, 700L)
    assert(r6 == List(100L, 300L, 500L, 700L), s"Exercise 6 failed: got $r6")
    println(s"Exercise 6 passed: $r6")

    // Exercise 7
    val ws7 = WorkerState(Nil, isReady = true, StashBuffer(Nil), Nil)
    val msgs7 = List(
      DoWork("a", _ => ()),
      DoWork("b", _ => ()),
      GracefulShutdown,
      DoWork("c", _ => ()),
      ForceKill
    )
    val r7 = exercise7_gracefulStop(ws7, msgs7)
    assert(r7 == List("a", "b", "c"), s"Exercise 7 failed: got $r7")
    println(s"Exercise 7 passed: $r7")

    // Exercise 8
    val msgs8a = List(DoWork("x", _ => ()), DoWork("y", _ => ()), GracefulShutdown, DoWork("z", _ => ()))
    val (proc8a, reason8a) = exercise8_killVsGraceful(msgs8a)
    assert(proc8a == List("x", "y"), s"Exercise 8a failed: got $proc8a")
    assert(reason8a == "graceful", s"Exercise 8a failed: reason = $reason8a")
    val msgs8b = List(DoWork("x", _ => ()), ForceKill, DoWork("y", _ => ()))
    val (proc8b, reason8b) = exercise8_killVsGraceful(msgs8b)
    assert(proc8b == List("x"), s"Exercise 8b failed: got $proc8b")
    assert(reason8b == "killed", s"Exercise 8b failed: reason = $reason8b")
    println("Exercise 8 passed: kill vs graceful works")

    println("\nAll Akka006_Patterns exercises passed!")
  }
}
