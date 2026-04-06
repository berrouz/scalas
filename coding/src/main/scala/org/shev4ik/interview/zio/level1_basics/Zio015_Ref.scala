package org.shev4ik.interview.zio.level1_basics

import zio._

/**
 * ZIO 015 - Ref: Purely Functional Concurrent Mutable State
 *
 * == Core Concept: Ref[A] ==
 * `Ref[A]` is a purely functional, fiber-safe mutable reference that holds a value of type `A`.
 * It is the ZIO equivalent of `java.util.concurrent.atomic.AtomicReference`, but with two
 * critical advantages:
 *   1. All operations return `UIO` effects (they are described, not immediately executed),
 *      preserving referential transparency.
 *   2. Compound operations like `modify` are **atomic** — no other fiber can observe an
 *      intermediate state between the read and the write.
 *
 * Internally, `Ref` is backed by an `AtomicReference` and uses compare-and-swap (CAS) loops
 * to ensure lock-free, wait-free atomicity. This means updates may retry under high contention,
 * but they will never block or deadlock.
 *
 * == Key operations ==
 * | Operation        | Signature (simplified)                        | Behavior                                           |
 * |------------------|-----------------------------------------------|----------------------------------------------------|
 * | `Ref.make(a)`    | `A => UIO[Ref[A]]`                           | Create a new Ref with initial value `a`             |
 * | `ref.get`        | `UIO[A]`                                      | Read the current value                              |
 * | `ref.set(a)`     | `A => UIO[Unit]`                              | Write a new value                                   |
 * | `ref.update(f)`  | `(A => A) => UIO[Unit]`                       | Atomically apply `f` to the current value           |
 * | `ref.modify(f)`  | `(A => (B, A)) => UIO[B]`                    | Atomically compute a return value and update        |
 * | `ref.updateAndGet(f)` | `(A => A) => UIO[A]`                    | Update and return the new value                     |
 * | `ref.getAndUpdate(f)` | `(A => A) => UIO[A]`                    | Return the old value and then update                |
 * | `ref.getAndSet(a)` | `A => UIO[A]`                               | Atomically swap the value, returning the old one    |
 *
 * == modify: The most powerful operation ==
 * `modify` takes a function `A => (B, A)` where:
 *   - `B` is the value returned to the caller
 *   - `A` is the new state stored in the Ref
 * This is atomic — the read of the old state, computation of the new state, and the write all
 * happen as one indivisible operation. This is equivalent to `AtomicReference.getAndUpdate` but
 * more general because it also produces a return value.
 *
 * == Ref vs var vs AtomicReference ==
 * | Feature              | `var`            | `AtomicReference`     | `Ref[A]`               |
 * |----------------------|------------------|-----------------------|------------------------|
 * | Thread-safe          | No               | Yes (single ops)      | Yes (compound ops)     |
 * | Referentially transparent | No          | No                    | Yes                    |
 * | Atomic modify        | No               | CAS loop (manual)     | Built-in `modify`      |
 * | Composable           | No               | No                    | Yes (via flatMap)      |
 * | Testable             | Difficult        | Difficult             | Easy (pure effects)    |
 *
 * == Interview Tip ==
 * '''Q: Why is Ref preferred over var or AtomicReference in ZIO? What guarantees does it provide?'''
 *
 * Three reasons:
 *   1. '''Referential transparency:''' `ref.update(_ + 1)` is a description of an effect, not
 *      an immediate mutation. You can compose, retry, or test it without side effects.
 *   2. '''Atomic compound operations:''' With `AtomicReference`, you must manually write CAS
 *      loops for read-modify-write patterns. `Ref.modify` provides this atomically out of the box.
 *   3. '''Composability:''' Because all Ref operations return `UIO`, they compose naturally in
 *      for-comprehensions with other ZIO effects, error handling, and resource management.
 *
 * '''Follow-up:''' "When would you use `Ref.Synchronized` (formerly `RefM`) instead of `Ref`?"
 * Use `Ref.Synchronized` when the update function itself is effectful (returns a ZIO). Regular
 * `Ref.update` requires a pure function `A => A`. `Ref.Synchronized.updateZIO` accepts
 * `A => UIO[A]`, useful when the update needs to call a service or perform I/O.
 *
 * == Real-World Context ==
 * `Ref` is ubiquitous in ZIO applications:
 * - '''In-memory caches:''' `Ref[Map[Key, Value]]` for simple caches with atomic updates
 * - '''Counters and metrics:''' `Ref[Long]` for request counts, in-flight requests, etc.
 * - '''State machines:''' `Ref[State]` for managing connection states, circuit breakers, etc.
 * - '''Accumulating results:''' `Ref[List[A]]` for collecting results from concurrent fibers
 *
 * For more complex state management needs, consider `TRef` (STM transactional ref) when you
 * need to atomically update multiple refs, or `FiberRef` for fiber-local state.
 */
object Zio015_Ref {

  // Exercise 1: Create a Ref and get its value
  // TODO: Ref.make(42).flatMap(_.get) => 42
  val exercise1: UIO[Int] = ???

  // Exercise 2: Create a Ref, set a new value, and get it
  // TODO: for { ref <- Ref.make(0); _ <- ref.set(42); v <- ref.get } yield v
  val exercise2: UIO[Int] = ???

  // Exercise 3: Use update to modify the value
  // TODO: for { ref <- Ref.make(10); _ <- ref.update(_ + 5); v <- ref.get } yield v => 15
  val exercise3: UIO[Int] = ???

  // Exercise 4: Use modify to atomically read and update
  // TODO: ref.modify(old => ("was:" + old, old + 1))
  // modify returns the first element of the tuple and sets the ref to the second
  val exercise4: UIO[(String, Int)] = ???

  // Exercise 5: Use updateAndGet to update and return the new value
  // TODO: for { ref <- Ref.make(10); v <- ref.updateAndGet(_ * 2) } yield v => 20
  val exercise5: UIO[Int] = ???

  // Exercise 6: Use getAndUpdate to get old value and then update
  // TODO: for { ref <- Ref.make(10); old <- ref.getAndUpdate(_ * 2); cur <- ref.get } yield (old, cur)
  // => (10, 20)
  val exercise6: UIO[(Int, Int)] = ???

  // Exercise 7: Use getAndSet to atomically swap the value
  // TODO: for { ref <- Ref.make("hello"); old <- ref.getAndSet("world"); cur <- ref.get } yield (old, cur)
  val exercise7: UIO[(String, String)] = ???

  // Exercise 8: Use Ref as a concurrent counter — increment from multiple fibers
  // TODO: Create Ref(0), fork 100 fibers each doing ref.update(_ + 1), join all, get final value
  val exercise8: UIO[Int] = ???

  def main(args: Array[String]): Unit = {
    val runtime = Runtime.default

    val r1 = runtime.unsafeRun(exercise1)
    assert(r1 == 42, s"Exercise 1 failed: expected 42, got $r1")
    println(s"Exercise 1 passed: $r1")

    val r2 = runtime.unsafeRun(exercise2)
    assert(r2 == 42, s"Exercise 2 failed: expected 42, got $r2")
    println(s"Exercise 2 passed: $r2")

    val r3 = runtime.unsafeRun(exercise3)
    assert(r3 == 15, s"Exercise 3 failed: expected 15, got $r3")
    println(s"Exercise 3 passed: $r3")

    val r4 = runtime.unsafeRun(exercise4)
    assert(r4._1 == "was:10", s"Exercise 4 failed: expected 'was:10', got ${r4._1}")
    assert(r4._2 == 11, s"Exercise 4 failed: expected 11, got ${r4._2}")
    println(s"Exercise 4 passed: $r4")

    val r5 = runtime.unsafeRun(exercise5)
    assert(r5 == 20, s"Exercise 5 failed: expected 20, got $r5")
    println(s"Exercise 5 passed: $r5")

    val r6 = runtime.unsafeRun(exercise6)
    assert(r6 == (10, 20), s"Exercise 6 failed: expected (10,20), got $r6")
    println(s"Exercise 6 passed: $r6")

    val r7 = runtime.unsafeRun(exercise7)
    assert(r7 == ("hello", "world"), s"Exercise 7 failed: expected (hello,world), got $r7")
    println(s"Exercise 7 passed: $r7")

    val r8 = runtime.unsafeRun(exercise8)
    assert(r8 == 100, s"Exercise 8 failed: expected 100, got $r8")
    println(s"Exercise 8 passed: $r8")

    println("All Zio015_Ref exercises passed!")
  }
}
