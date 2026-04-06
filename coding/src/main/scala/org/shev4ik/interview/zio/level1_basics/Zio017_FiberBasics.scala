package org.shev4ik.interview.zio.level1_basics

import zio._
import zio.clock.Clock
import zio.duration._

/**
 * ZIO 017 - Fiber Basics: Green Threads, Concurrency Primitives, and Fiber Lifecycle
 *
 * == Core Concept: What are Fibers? ==
 * Fibers are ZIO's **green threads** (also called virtual threads or lightweight threads).
 * They are not OS threads — instead, the ZIO runtime multiplexes potentially millions of fibers
 * onto a small, fixed-size pool of OS threads (typically equal to the number of CPU cores).
 *
 * A fiber is a data structure that represents a running (or suspended) ZIO effect. It has its
 * own stack, its own error handling, and can be independently forked, joined, and interrupted.
 * The key insight: fibers are **cooperative** — they yield control at effect boundaries (flatMap,
 * map, etc.), allowing the runtime to schedule other fibers without preemption overhead.
 *
 * == Fibers vs OS Threads ==
 * | Aspect            | OS Thread                        | ZIO Fiber                            |
 * |-------------------|----------------------------------|--------------------------------------|
 * | Memory overhead   | ~1 MB stack per thread           | ~200-400 bytes per fiber             |
 * | Creation cost     | Expensive (kernel syscall)       | Cheap (heap allocation)              |
 * | Max practical count | Thousands (OS limit)           | Millions (heap-limited)              |
 * | Scheduling        | Preemptive (OS kernel)           | Cooperative (ZIO runtime)            |
 * | Blocking behavior | Blocks OS thread                 | Suspends fiber, frees OS thread      |
 * | Interruption      | Unsafe (`Thread.interrupt`)      | Safe, structured (`fiber.interrupt`) |
 *
 * == Fiber Lifecycle ==
 * A fiber goes through the following states:
 *   1. '''Running:''' The fiber is actively executing its effect on an OS thread.
 *   2. '''Suspended:''' The fiber is waiting for something (e.g., async callback, sleep, join).
 *      It does not consume any OS thread while suspended.
 *   3. '''Done:''' The fiber has completed with a result (`Exit.Success`) or failure (`Exit.Failure`).
 *      Its result is cached and available to any fiber that calls `join` or `await`.
 *
 * == Key operations ==
 * | Operation         | Signature (simplified)                    | Behavior                                           |
 * |-------------------|-------------------------------------------|----------------------------------------------------|
 * | `effect.fork`     | `ZIO[R,E,A] => URIO[R, Fiber[E,A]]`     | Start effect on a new fiber, return handle          |
 * | `fiber.join`      | `Fiber[E,A] => IO[E,A]`                  | Wait for fiber to complete, re-raise its error      |
 * | `fiber.await`     | `Fiber[E,A] => UIO[Exit[E,A]]`           | Wait for fiber, return Exit (never fails)           |
 * | `fiber.interrupt` | `Fiber[E,A] => UIO[Exit[E,A]]`           | Send interrupt signal, wait for finalization         |
 * | `fiber.poll`      | `Fiber[E,A] => UIO[Option[Exit[E,A]]]`   | Check if done without blocking (non-blocking peek)  |
 * | `f1.zip(f2)`      | `Fiber[E,A] => Fiber[E,B] => Fiber[E,(A,B)]` | Combine two fibers into one                    |
 * | `fiber.map(f)`    | `Fiber[E,A] => (A => B) => Fiber[E,B]`   | Transform the fiber's eventual result               |
 *
 * == fork vs forkDaemon vs forkScoped ==
 * - `fork`: Creates a **child fiber** — if the parent fiber is interrupted, children are too.
 *   This is called **structured concurrency** and prevents fiber leaks.
 * - `forkDaemon`: Creates a fiber that outlives its parent — it is attached to the global scope.
 *   Use sparingly; needed for background tasks like metrics collection.
 * - `forkScoped` (ZIO 2.x): Creates a fiber whose lifetime is bound to a `Scope`.
 *
 * == Interruption model ==
 * ZIO uses **cooperative interruption**: when `fiber.interrupt` is called, the runtime sets an
 * interrupt flag. The fiber checks this flag at each effect boundary (flatMap). If set, the fiber
 * runs its finalizers (if any, via `ensuring`/`onInterrupt`) and then terminates with
 * `Exit.Failure(Cause.Interrupt)`. This means:
 * - Interruption is always safe (finalizers run, resources are released).
 * - A fiber doing pure CPU computation without effect boundaries cannot be interrupted until
 *   it yields. Use `ZIO.yieldNow` to insert explicit yield points in hot loops.
 *
 * == Interview Tip ==
 * '''Q: How many ZIO fibers can you create compared to OS threads? What are the practical limits?'''
 *
 * You can create **millions** of ZIO fibers on a single JVM. Each fiber costs only a few hundred
 * bytes of heap memory (vs ~1 MB for an OS thread stack). The practical limit is JVM heap size.
 * With 4 GB of heap, you can comfortably run 10+ million fibers. OS threads are limited to
 * thousands (typically 2,000-10,000 before the OS refuses to create more or performance degrades).
 *
 * '''Follow-up:''' "What happens if a fiber performs blocking I/O?"
 * If blocking code runs on the main fiber pool, it starves other fibers. Use `ZIO.blocking` or
 * `ZIO.attemptBlocking` to shift the work to the dedicated blocking thread pool. This keeps the
 * main compute pool responsive. In ZIO 2.x, you can also use `ZIO.attemptBlockingInterrupt` for
 * truly interruptible blocking calls (e.g., `Thread.sleep`).
 *
 * '''Follow-up:''' "What is structured concurrency and why does it matter?"
 * Structured concurrency means that child fibers are scoped to their parent's lifetime. When the
 * parent completes or is interrupted, all children are interrupted too. This prevents fiber leaks
 * (orphaned fibers running forever) and makes concurrent code easier to reason about — similar
 * to how structured programming eliminated `goto` by scoping control flow.
 *
 * == Real-World Context ==
 * Fibers are the foundation of ZIO's concurrency model. Real-world usage includes:
 * - '''HTTP servers:''' Each incoming request is handled by its own fiber (not a thread).
 *   This allows handling 100K+ concurrent connections on a few OS threads.
 * - '''Parallel data processing:''' `ZIO.foreachPar(items)(process)` forks one fiber per item.
 * - '''Background tasks:''' Health checks, metric flushing, cache invalidation run as daemon fibers.
 * - '''Timeouts:''' Implemented via a racing fiber: `effect.race(ZIO.sleep(5.seconds) *> ZIO.fail(Timeout))`.
 *   The loser is automatically interrupted.
 */
object Zio017_FiberBasics {

  // Exercise 1: Fork an effect and join to get the result
  // TODO: for { fiber <- ZIO.succeed(42).fork; result <- fiber.join } yield result
  val exercise1: UIO[Int] = ???

  // Exercise 2: Use await to get the Exit value from a fiber
  // TODO: for { fiber <- ZIO.succeed(42).fork; exit <- fiber.await } yield exit
  val exercise2: UIO[Exit[Nothing, Int]] = ???

  // Exercise 3: Interrupt a running fiber
  // TODO: for { fiber <- ZIO.never.fork; _ <- fiber.interrupt } yield "interrupted"
  val exercise3: UIO[String] = ???

  // Exercise 4: Use poll to check fiber status without blocking
  // TODO: for { fiber <- ZIO.succeed(42).fork; _ <- ZIO.yieldNow; result <- fiber.poll } yield result
  // poll returns Option[Exit[E, A]] — Some if done, None if still running
  val exercise4: UIO[Option[Exit[Nothing, Int]]] = ???

  // Exercise 5: Zip two fibers together
  // TODO: for {
  //   f1 <- ZIO.succeed(1).fork
  //   f2 <- ZIO.succeed(2).fork
  //   result <- (f1 zip f2).join
  // } yield result
  // Result should be (1, 2)
  val exercise5: UIO[(Int, Int)] = ???

  // Exercise 6: Map on a Fiber to transform its result
  // TODO: for {
  //   fiber <- ZIO.succeed(21).fork
  //   mapped = fiber.map(_ * 2)
  //   result <- mapped.join
  // } yield result
  val exercise6: UIO[Int] = ???

  // Exercise 7: Use inheritRefs to inherit fiber refs into the current fiber
  // TODO: for {
  //   ref <- FiberRef.make(0)
  //   fiber <- ref.set(42).fork
  //   _ <- fiber.join
  //   _ <- fiber.inheritRefs
  //   v <- ref.get
  // } yield v
  val exercise7: UIO[Int] = ???

  // Exercise 8: Fork multiple fibers and join all of them
  // TODO: for {
  //   fibers <- ZIO.foreach(List(1,2,3,4,5))(n => ZIO.succeed(n * 10).fork)
  //   results <- ZIO.foreach(fibers)(_.join)
  // } yield results
  val exercise8: UIO[List[Int]] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == Exit.succeed(42), s"Exercise 2 failed: expected Exit.Success(42), got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == "interrupted", s"Exercise 3 failed: expected 'interrupted', got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    println(s"Exercise 4 passed: poll result=$r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == (1, 2), s"Exercise 5 failed: expected (1,2), got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == 42, s"Exercise 6 failed: expected 42, got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == 42, s"Exercise 7 failed: expected 42, got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == List(10, 20, 30, 40, 50), s"Exercise 8 failed: expected List(10,20,30,40,50), got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio017_FiberBasics exercises passed!")
  }
}
