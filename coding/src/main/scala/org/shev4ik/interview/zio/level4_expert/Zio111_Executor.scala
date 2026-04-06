package org.shev4ik.interview.zio.level4_expert

import zio._
import zio.console._
import zio.clock.Clock
import zio.duration._
import zio.internal.Executor

/**
 * ZIO111 - Executor
 *
 * Learn about executor configuration for different workload types.
 */
object Zio111_Executor extends App {

  // ============================================================
  // Exercise 1: Default executor
  // TODO: Inspect the default executor properties.
  //       Print the current thread name inside a ZIO effect to show
  //       which executor/pool is being used.
  // ============================================================
  val exercise1: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 2: Blocking executor
  // TODO: Run an effect on the blocking executor using zio.blocking.effectBlocking.
  //       Print the thread name to show it's on the blocking pool.
  //       Compare with the default executor thread name.
  // ============================================================
  val exercise2: ZIO[Console with zio.blocking.Blocking, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 3: Custom executor
  // TODO: Create a custom Executor from a java.util.concurrent.ExecutorService
  //       with a fixed thread pool of size 2.
  //       Run effects on it using .lock(executor).
  //       Print thread names. Clean up the executor.
  // ============================================================
  val exercise3: ZIO[Console, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 4: Executor for CPU-bound work
  // TODO: Create an executor optimized for CPU-bound work
  //       (thread count = number of CPUs). Run a compute-heavy task on it.
  //       Print thread info and result.
  // ============================================================
  val exercise4: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 5: Executor for IO-bound work
  // TODO: Create an executor optimized for IO-bound work
  //       (larger thread pool, e.g., 4x CPU count). Run simulated IO tasks.
  //       Print thread info for each task.
  // ============================================================
  val exercise5: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 6: Executor sizing
  // TODO: Demonstrate the impact of executor sizing:
  //       Run the same parallel workload (8 tasks) on executors with
  //       1, 2, 4, and 8 threads. Measure completion time for each.
  //       Print timing comparison.
  // ============================================================
  val exercise6: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 7: Executor monitoring
  // TODO: Create a monitored executor wrapper that tracks:
  //       - Tasks submitted
  //       - Tasks completed
  //       - Current active tasks
  //       Use Refs for counters. Print metrics after workload.
  // ============================================================
  val exercise7: ZIO[Console with Clock, Any, Unit] = {
    ???
  }

  // ============================================================
  // Exercise 8: Executor switching
  // TODO: Demonstrate switching between executors within a single effect:
  //       1. Start on default executor (print thread)
  //       2. Switch to blocking for IO (print thread)
  //       3. Switch back to default (print thread)
  //       Show the thread changes.
  // ============================================================
  val exercise8: ZIO[Console with zio.blocking.Blocking, Any, Unit] = {
    ???
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] =
    (exercise1 *> exercise2 *> exercise3 *> exercise4 *>
      exercise5 *> exercise6 *> exercise7 *> exercise8)
      .exitCode
}
