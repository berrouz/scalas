package org.shev4ik.interview.testing.level1_basics

/**
 * Test005 - Test Fixtures
 *
 * Shared fixtures, before/after lifecycle hooks, test data builders,
 * and resource management patterns for tests.
 */
object Test005_TestFixtures {

  // ==========================================================================
  // Exercise 1: Implement a fixture lifecycle manager
  // ==========================================================================
  // TODO: Implement `FixtureManager[A]` that manages a fixture's lifecycle:
  //       - beforeAll: () => A  (called once before all tests)
  //       - beforeEach: A => A  (called before each test, can transform fixture)
  //       - afterEach: A => Unit  (called after each test)
  //       - afterAll: A => Unit  (called once after all tests)
  //       Implement `runWithFixture(tests: List[A => Unit]): List[Boolean]`
  //       that runs each test with proper lifecycle, returning pass/fail per test.
  class FixtureManager[A](
    beforeAll: () => A,
    beforeEach: A => A,
    afterEach: A => Unit,
    afterAll: A => Unit
  ) {
    def runWithFixture(tests: List[A => Unit]): List[Boolean] = ???
  }

  // ==========================================================================
  // Exercise 2: Implement a test data builder
  // ==========================================================================
  // TODO: Implement a builder for a User case class:
  //       case class User(name: String, email: String, age: Int, active: Boolean)
  //       The UserBuilder should:
  //       - Have sensible defaults (name="John", email="john@test.com", age=25, active=true)
  //       - Provide withName, withEmail, withAge, withActive methods
  //       - Provide a build() method returning User
  //       - Be immutable (each with* returns a new builder)
  case class User(name: String, email: String, age: Int, active: Boolean)

  case class UserBuilder(
    name: String = "John",
    email: String = "john@test.com",
    age: Int = 25,
    active: Boolean = true
  ) {
    def withName(n: String): UserBuilder = ???
    def withEmail(e: String): UserBuilder = ???
    def withAge(a: Int): UserBuilder = ???
    def withActive(a: Boolean): UserBuilder = ???
    def build(): User = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a resource pool for tests
  // ==========================================================================
  // TODO: Implement `ResourcePool[A]` that manages a pool of test resources.
  //       - acquire(): A  (gets a resource from pool, or creates new one if empty)
  //       - release(a: A): Unit  (returns resource to pool)
  //       - withResource[B](f: A => B): B  (acquires, uses, releases even on error)
  //       - size: Int  (number of available resources in pool)
  //       Constructor takes a factory: () => A and optional maxSize: Int.
  class ResourcePool[A](factory: () => A, maxSize: Int = 10) {
    def acquire(): A = ???
    def release(a: A): Unit = ???
    def withResource[B](f: A => B): B = ???
    def size: Int = ???
  }

  // ==========================================================================
  // Exercise 4: Implement a test context with automatic cleanup
  // ==========================================================================
  // TODO: Implement `TestContext` that collects cleanup actions during a test
  //       and runs them all in reverse order when the test ends.
  //       - registerCleanup(action: () => Unit): Unit
  //       - cleanup(): Unit  (runs all registered actions in reverse order)
  //       - cleanupCount: Int
  //       Implement `withTestContext(test: TestContext => Unit): Boolean`
  //       that creates a context, runs the test, ensures cleanup runs, returns pass/fail.
  class TestContext {
    def registerCleanup(action: () => Unit): Unit = ???
    def cleanup(): Unit = ???
    def cleanupCount: Int = ???
  }

  def withTestContext(test: TestContext => Unit): Boolean = ???

  // ==========================================================================
  // Exercise 5: Implement shared state fixture with isolation
  // ==========================================================================
  // TODO: Implement `IsolatedFixture[A]` that gives each test its own copy.
  //       Constructor takes a `create: () => A` factory.
  //       - runIsolated(tests: List[A => Unit]): List[Boolean]
  //         Each test gets a fresh instance from the factory, so mutations
  //         in one test don't affect others.
  //       Demonstrate this prevents cross-test contamination.
  class IsolatedFixture[A](create: () => A) {
    def runIsolated(tests: List[A => Unit]): List[Boolean] = ???
  }

  // ==========================================================================
  // Exercise 6: Implement a test data factory with sequences
  // ==========================================================================
  // TODO: Implement `TestDataFactory` that generates unique test data:
  //       - uniqueString(prefix: String): String  (returns "prefix_1", "prefix_2", etc.)
  //       - uniqueInt(): Int  (returns incrementing integers starting from 1)
  //       - uniqueEmail(): String  (returns "user1@test.com", "user2@test.com", etc.)
  //       - reset(): Unit  (resets all counters)
  //       The factory should be thread-safe (use AtomicInteger).
  class TestDataFactory {
    def uniqueString(prefix: String): String = ???
    def uniqueInt(): Int = ???
    def uniqueEmail(): String = ???
    def reset(): Unit = ???
  }

  // ==========================================================================
  // Exercise 7: Implement a fixture composition mechanism
  // ==========================================================================
  // TODO: Implement `Fixture[A]` with setup and teardown, and a way to compose:
  //       - map[B](f: A => B): Fixture[B]
  //       - flatMap[B](f: A => Fixture[B]): Fixture[B]
  //       - zip[B](other: Fixture[B]): Fixture[(A, B)]
  //       Each fixture has: setup: () => A, teardown: A => Unit
  //       Composed fixtures should properly chain setup/teardown.
  case class Fixture[A](setup: () => A, teardown: A => Unit) {
    def map[B](f: A => B): Fixture[B] = ???
    def flatMap[B](f: A => Fixture[B]): Fixture[B] = ???
    def zip[B](other: Fixture[B]): Fixture[(A, B)] = ???
    def use[B](test: A => B): B = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a snapshot-based fixture
  // ==========================================================================
  // TODO: Implement `SnapshotFixture[A]` that takes a snapshot of state before
  //       each test and can restore it after.
  //       - snapshot(state: A): Unit  (saves current state)
  //       - restore(): A  (returns the last snapshot)
  //       - withSnapshot(initialState: A)(test: A => A): A
  //         (snapshots initial, runs test which returns modified state,
  //          then restores to snapshot; returns the modified state for verification)
  //       Requires A to be copyable (use a clone function).
  class SnapshotFixture[A](clone: A => A) {
    def snapshot(state: A): Unit = ???
    def restore(): A = ???
    def withSnapshot(initialState: A)(test: A => A): A = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    var lifecycleLog = List.empty[String]
    val fm = new FixtureManager[StringBuilder](
      beforeAll = () => { lifecycleLog :+= "beforeAll"; new StringBuilder("init") },
      beforeEach = sb => { lifecycleLog :+= "beforeEach"; sb.clear(); sb.append("fresh"); sb },
      afterEach = _ => { lifecycleLog :+= "afterEach" },
      afterAll = _ => { lifecycleLog :+= "afterAll" }
    )
    val fmResults = fm.runWithFixture(List(
      sb => assert(sb.toString == "fresh"),
      sb => assert(sb.toString == "fresh")
    ))
    assert(fmResults == List(true, true))
    assert(lifecycleLog.count(_ == "beforeEach") == 2)
    assert(lifecycleLog.head == "beforeAll" && lifecycleLog.last == "afterAll")
    println("Exercise 1 passed: fixture lifecycle manager works")

    // Exercise 2
    val user = UserBuilder().withName("Alice").withAge(30).build()
    assert(user.name == "Alice" && user.age == 30 && user.email == "john@test.com")
    val defaultUser = UserBuilder().build()
    assert(defaultUser.name == "John" && defaultUser.active)
    println("Exercise 2 passed: test data builder works")

    // Exercise 3
    var created = 0
    val pool = new ResourcePool[String](() => { created += 1; s"resource_$created" })
    val r1 = pool.acquire()
    pool.release(r1)
    assert(pool.size == 1)
    val r2 = pool.acquire()
    assert(r2 == r1, "Should reuse released resource")
    assert(pool.size == 0)
    println("Exercise 3 passed: resource pool works")

    // Exercise 4
    var cleanupOrder = List.empty[Int]
    val passed = withTestContext { ctx =>
      ctx.registerCleanup(() => cleanupOrder :+= 1)
      ctx.registerCleanup(() => cleanupOrder :+= 2)
      ctx.registerCleanup(() => cleanupOrder :+= 3)
      assert(ctx.cleanupCount == 3)
    }
    assert(passed && cleanupOrder == List(3, 2, 1))
    println("Exercise 4 passed: test context with cleanup works")

    // Exercise 5
    val isolated = new IsolatedFixture[scala.collection.mutable.ListBuffer[Int]](
      () => scala.collection.mutable.ListBuffer.empty[Int]
    )
    val isoResults = isolated.runIsolated(List(
      buf => { buf += 1; assert(buf.size == 1) },
      buf => { assert(buf.isEmpty); buf += 2; buf += 3; assert(buf.size == 2) }
    ))
    assert(isoResults == List(true, true))
    println("Exercise 5 passed: isolated fixtures work")

    // Exercise 6
    val factory = new TestDataFactory
    assert(factory.uniqueString("item") == "item_1")
    assert(factory.uniqueString("item") == "item_2")
    assert(factory.uniqueInt() == 1)
    assert(factory.uniqueInt() == 2)
    assert(factory.uniqueEmail() == "user1@test.com")
    factory.reset()
    assert(factory.uniqueInt() == 1)
    println("Exercise 6 passed: test data factory works")

    // Exercise 7
    var tornDown = List.empty[String]
    val dbFixture = Fixture[String](
      () => "db-conn",
      s => { tornDown :+= s }
    )
    val mappedFixture = dbFixture.map(_.toUpperCase)
    val result = mappedFixture.use(conn => {
      assert(conn == "DB-CONN")
      "done"
    })
    assert(result == "done")
    println("Exercise 7 passed: fixture composition works")

    // Exercise 8
    val snap = new SnapshotFixture[Array[Int]](arr => arr.clone())
    val initial = Array(1, 2, 3)
    val modified = snap.withSnapshot(initial) { arr =>
      arr(0) = 99
      arr
    }
    assert(modified(0) == 99)
    val restored = snap.restore()
    assert(restored(0) == 1, "Snapshot should preserve original state")
    println("Exercise 8 passed: snapshot fixture works")

    println("\nAll Test005 exercises passed!")
  }
}
