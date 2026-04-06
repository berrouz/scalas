package org.shev4ik.interview.akka.level1_basics

/**
 * Akka 008 - Dispatchers
 *
 * Dispatchers are the execution engine for actors, controlling thread assignment:
 *   - Default dispatcher: shared fork-join pool for most actors
 *   - Pinned dispatcher: dedicated thread per actor
 *   - Calling thread dispatcher: runs on caller's thread (testing)
 *   - Dispatcher config: throughput, thread pool sizes, etc.
 *   - Blocking in actors: must use a dedicated dispatcher
 *   - Dedicated dispatcher: isolate blocking operations
 *   - Dispatcher selection: choosing the right dispatcher per use case
 *   - Throughput config: messages processed before yielding thread
 *
 * In real Akka: configured in application.conf, referenced by .withDispatcher("my-dispatcher")
 */
object Akka008_Dispatchers {

  // --- Domain models ---

  sealed trait DispatcherType
  case object DefaultDispatcher extends DispatcherType
  case object PinnedDispatcher extends DispatcherType
  case object CallingThreadDispatcher extends DispatcherType
  case class CustomDispatcher(name: String) extends DispatcherType

  case class DispatcherConfig(
    dispatcherType: DispatcherType,
    throughput: Int,           // messages processed before yielding
    minThreads: Int,
    maxThreads: Int,
    threadPoolType: String     // "fork-join" or "thread-pool-executor"
  )

  sealed trait TaskType
  case object CpuBound extends TaskType
  case object IoBound extends TaskType
  case object Blocking extends TaskType
  case object LightWeight extends TaskType

  case class ActorDeployment(actorName: String, dispatcher: DispatcherConfig, taskType: TaskType)

  case class ThreadAllocation(actorName: String, threadId: String, messagesProcessed: Int)

  // Exercise 1: Create default dispatcher config
  // TODO: Create a DispatcherConfig for the default fork-join dispatcher:
  //   dispatcherType = DefaultDispatcher
  //   throughput = 5 (process 5 messages before yielding)
  //   minThreads = 2
  //   maxThreads = available processors (use the provided cpuCount)
  //   threadPoolType = "fork-join"
  def exercise1_defaultDispatcher(cpuCount: Int): DispatcherConfig = ???

  // Exercise 2: Create pinned dispatcher config
  // TODO: Create a DispatcherConfig for a pinned dispatcher:
  //   dispatcherType = PinnedDispatcher
  //   throughput = 1 (one message at a time since dedicated thread)
  //   minThreads = 1, maxThreads = 1
  //   threadPoolType = "thread-pool-executor"
  def exercise2_pinnedDispatcher: DispatcherConfig = ???

  // Exercise 3: Create calling thread dispatcher config
  // TODO: Create a DispatcherConfig for the calling thread dispatcher (used in tests):
  //   dispatcherType = CallingThreadDispatcher
  //   throughput = Int.MaxValue (no yielding needed, runs on caller thread)
  //   minThreads = 0, maxThreads = 0 (no dedicated threads)
  //   threadPoolType = "calling-thread"
  def exercise3_callingThreadDispatcher: DispatcherConfig = ???

  // Exercise 4: Generate dispatcher config string
  // TODO: Given a DispatcherConfig, generate a config-like string representation:
  //   "{type}.throughput = {throughput}\n{type}.min-threads = {min}\n{type}.max-threads = {max}"
  //   where {type} is "fork-join-executor" for fork-join, "thread-pool-executor" otherwise.
  def exercise4_dispatcherConfigString(config: DispatcherConfig): String = ???

  // Exercise 5: Detect blocking in actors
  // TODO: Given a list of ActorDeployments, find actors that have Blocking taskType
  //   but are using DefaultDispatcher. These are problematic because blocking operations
  //   on the default dispatcher can starve other actors.
  //   Return the list of actor names that need a dedicated dispatcher.
  def exercise5_detectBlocking(deployments: List[ActorDeployment]): List[String] = ???

  // Exercise 6: Assign dedicated dispatcher for blocking ops
  // TODO: Given a list of ActorDeployments, reassign any actor with Blocking taskType
  //   to use a CustomDispatcher("blocking-io-dispatcher") with:
  //   throughput=1, minThreads=2, maxThreads=16, threadPoolType="thread-pool-executor"
  //   Leave non-blocking actors unchanged. Return the updated list.
  def exercise6_dedicatedBlockingDispatcher(deployments: List[ActorDeployment]): List[ActorDeployment] = ???

  // Exercise 7: Select optimal dispatcher based on task type
  // TODO: Given a TaskType, return the recommended DispatcherConfig:
  //   CpuBound -> DefaultDispatcher, throughput=5, min=2, max=cpuCount, fork-join
  //   IoBound -> CustomDispatcher("io-dispatcher"), throughput=1, min=2, max=32, thread-pool-executor
  //   Blocking -> CustomDispatcher("blocking-dispatcher"), throughput=1, min=2, max=16, thread-pool-executor
  //   LightWeight -> DefaultDispatcher, throughput=20, min=2, max=cpuCount, fork-join
  def exercise7_selectDispatcher(taskType: TaskType, cpuCount: Int): DispatcherConfig = ???

  // Exercise 8: Throughput tuning simulation
  // TODO: Simulate throughput behavior. Given a list of actors with message counts,
  //   and a throughput setting, calculate how many "turns" each actor needs.
  //   A turn processes min(throughput, remaining messages) messages.
  //   Return a Map[String, Int] from actor name to number of turns needed.
  //   Example: throughput=5, actor with 12 messages needs 3 turns (5+5+2).
  def exercise8_throughputTuning(
    actors: List[(String, Int)], // (actorName, messageCount)
    throughput: Int
  ): Map[String, Int] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val r1 = exercise1_defaultDispatcher(8)
    assert(r1.dispatcherType == DefaultDispatcher, "Exercise 1 failed: wrong type")
    assert(r1.throughput == 5, "Exercise 1 failed: wrong throughput")
    assert(r1.maxThreads == 8, "Exercise 1 failed: maxThreads should equal cpuCount")
    assert(r1.threadPoolType == "fork-join", "Exercise 1 failed: wrong pool type")
    println("Exercise 1 passed: default dispatcher configured")

    // Exercise 2
    val r2 = exercise2_pinnedDispatcher
    assert(r2.dispatcherType == PinnedDispatcher, "Exercise 2 failed: wrong type")
    assert(r2.minThreads == 1 && r2.maxThreads == 1, "Exercise 2 failed: pinned should have 1 thread")
    println("Exercise 2 passed: pinned dispatcher configured")

    // Exercise 3
    val r3 = exercise3_callingThreadDispatcher
    assert(r3.dispatcherType == CallingThreadDispatcher, "Exercise 3 failed: wrong type")
    assert(r3.minThreads == 0 && r3.maxThreads == 0, "Exercise 3 failed: no dedicated threads")
    println("Exercise 3 passed: calling thread dispatcher configured")

    // Exercise 4
    val r4 = exercise4_dispatcherConfigString(r1)
    assert(r4.contains("fork-join-executor.throughput = 5"), s"Exercise 4 failed: got $r4")
    assert(r4.contains("fork-join-executor.min-threads = 2"), s"Exercise 4 failed: got $r4")
    println("Exercise 4 passed: config string generated")

    // Exercise 5
    val deployments = List(
      ActorDeployment("worker-1", r1, CpuBound),
      ActorDeployment("db-actor", r1, Blocking),
      ActorDeployment("http-actor", r1, Blocking),
      ActorDeployment("logger", r2, LightWeight)
    )
    val r5 = exercise5_detectBlocking(deployments)
    assert(r5 == List("db-actor", "http-actor"), s"Exercise 5 failed: $r5")
    println(s"Exercise 5 passed: blocking actors = $r5")

    // Exercise 6
    val r6 = exercise6_dedicatedBlockingDispatcher(deployments)
    val dbActor6 = r6.find(_.actorName == "db-actor").get
    assert(dbActor6.dispatcher.dispatcherType == CustomDispatcher("blocking-io-dispatcher"),
      s"Exercise 6 failed: ${dbActor6.dispatcher.dispatcherType}")
    assert(r6.find(_.actorName == "worker-1").get.dispatcher == r1, "Exercise 6 failed: non-blocking changed")
    println("Exercise 6 passed: dedicated dispatchers assigned")

    // Exercise 7
    val r7cpu = exercise7_selectDispatcher(CpuBound, 4)
    assert(r7cpu.dispatcherType == DefaultDispatcher, "Exercise 7 failed: CpuBound")
    assert(r7cpu.maxThreads == 4, "Exercise 7 failed: CpuBound maxThreads")
    val r7block = exercise7_selectDispatcher(Blocking, 4)
    assert(r7block.dispatcherType == CustomDispatcher("blocking-dispatcher"), "Exercise 7 failed: Blocking")
    println("Exercise 7 passed: dispatcher selection works")

    // Exercise 8
    val r8 = exercise8_throughputTuning(List(("a", 12), ("b", 5), ("c", 1), ("d", 0)), 5)
    assert(r8("a") == 3, s"Exercise 8 failed: a = ${r8("a")}")
    assert(r8("b") == 1, s"Exercise 8 failed: b = ${r8("b")}")
    assert(r8("c") == 1, s"Exercise 8 failed: c = ${r8("c")}")
    assert(r8("d") == 0, s"Exercise 8 failed: d = ${r8("d")}")
    println("Exercise 8 passed: throughput tuning calculated")

    println("\nAll Akka008_Dispatchers exercises passed!")
  }
}
