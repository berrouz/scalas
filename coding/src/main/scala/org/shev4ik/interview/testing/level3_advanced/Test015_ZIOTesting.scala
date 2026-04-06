package org.shev4ik.interview.testing.level3_advanced

/**
 * Test015 - ZIO Testing Concepts
 *
 * Simulating ZIO test environment patterns: TestClock, TestConsole,
 * TestRandom, and test-friendly effect management -- without ZIO dependency.
 */
object Test015_ZIOTesting {

  // ==========================================================================
  // Exercise 1: Implement a TestClock
  // ==========================================================================
  // TODO: Implement `TestClock` that provides deterministic time control:
  //       - currentTimeMillis: Long  (returns virtual time)
  //       - advance(millis: Long): Unit  (moves time forward)
  //       - setTime(millis: Long): Unit  (sets absolute time)
  //       - sleep(millis: Long): Unit  (records a sleep, advances time by that amount)
  //       - sleepHistory: List[Long]  (all sleep durations recorded)
  //       - timers: List[(Long, () => Unit)]  (scheduled callbacks)
  //       - addTimer(atTime: Long)(callback: => Unit): Unit
  //       - fireTimers(): Int  (fires all timers whose time has passed, returns count)
  class TestClock {
    def currentTimeMillis: Long = ???
    def advance(millis: Long): Unit = ???
    def setTime(millis: Long): Unit = ???
    def sleep(millis: Long): Unit = ???
    def sleepHistory: List[Long] = ???
    def addTimer(atTime: Long)(callback: => Unit): Unit = ???
    def fireTimers(): Int = ???
  }

  // ==========================================================================
  // Exercise 2: Implement a TestConsole
  // ==========================================================================
  // TODO: Implement `TestConsole` that captures console I/O:
  //       - feedInput(lines: String*): Unit  (pre-load stdin lines)
  //       - readLine(): String  (reads next pre-loaded line, throws if empty)
  //       - printLine(s: String): Unit  (captures to output buffer)
  //       - printError(s: String): Unit  (captures to error buffer)
  //       - output: List[String]  (all printed lines)
  //       - errorOutput: List[String]  (all error lines)
  //       - clearOutput(): Unit
  //       - hasInput: Boolean  (any unread input remaining)
  class TestConsole {
    def feedInput(lines: String*): Unit = ???
    def readLine(): String = ???
    def printLine(s: String): Unit = ???
    def printError(s: String): Unit = ???
    def output: List[String] = ???
    def errorOutput: List[String] = ???
    def clearOutput(): Unit = ???
    def hasInput: Boolean = ???
  }

  // ==========================================================================
  // Exercise 3: Implement a TestRandom
  // ==========================================================================
  // TODO: Implement `TestRandom` that provides deterministic "random" values:
  //       - feedInts(values: Int*): Unit  (pre-load int values)
  //       - feedDoubles(values: Double*): Unit
  //       - feedBooleans(values: Boolean*): Unit
  //       - nextInt(): Int  (returns next pre-loaded int, cycles if exhausted)
  //       - nextDouble(): Double
  //       - nextBoolean(): Boolean
  //       - nextIntBetween(min: Int, max: Int): Int
  //         (returns next pre-loaded int clamped to range)
  //       - clearAll(): Unit
  class TestRandom {
    def feedInts(values: Int*): Unit = ???
    def feedDoubles(values: Double*): Unit = ???
    def feedBooleans(values: Boolean*): Unit = ???
    def nextInt(): Int = ???
    def nextDouble(): Double = ???
    def nextBoolean(): Boolean = ???
    def nextIntBetween(min: Int, max: Int): Int = ???
    def clearAll(): Unit = ???
  }

  // ==========================================================================
  // Exercise 4: Implement a TestEnvironment composing all test services
  // ==========================================================================
  // TODO: Implement `TestEnvironment` that bundles test services:
  //       - clock: TestClock
  //       - console: TestConsole
  //       - random: TestRandom
  //       Implement `withTestEnv[A](test: TestEnvironment => A): A`
  //       that creates a fresh environment for each test.
  //       Implement `runSpec(name: String)(test: TestEnvironment => Boolean): SpecResult`
  //       where SpecResult has name, passed, and environment state snapshot.
  case class EnvSnapshot(
    clockTime: Long,
    consoleOutput: List[String],
    sleepHistory: List[Long]
  )

  case class SpecResult(name: String, passed: Boolean, snapshot: EnvSnapshot)

  class TestEnvironment(val clock: TestClock, val console: TestConsole, val random: TestRandom)

  def withTestEnv[A](test: TestEnvironment => A): A = ???
  def runSpec(name: String)(test: TestEnvironment => Boolean): SpecResult = ???

  // ==========================================================================
  // Exercise 5: Implement a test aspect system
  // ==========================================================================
  // TODO: Implement `TestAspect` that transforms tests (like ZIO test aspects):
  //       - timeout(ms: Long): TestAspect  (fail test if it takes too long)
  //       - retry(n: Int): TestAspect  (retry up to n times)
  //       - ignore: TestAspect  (skip the test, always pass)
  //       - flaky(maxRetries: Int): TestAspect  (like retry but expected to fail sometimes)
  //       - nonFlaky(n: Int): TestAspect  (run n times, all must pass)
  //       - apply(test: () => Boolean): TestAspectResult
  //       TestAspectResult: passed, skipped, attempts, errors
  case class TestAspectResult(passed: Boolean, skipped: Boolean, attempts: Int, errors: List[String])

  trait TestAspect {
    def apply(test: () => Boolean): TestAspectResult
    def andThen(other: TestAspect): TestAspect = ???
  }

  object TestAspect {
    def timeout(ms: Long): TestAspect = ???
    def retry(n: Int): TestAspect = ???
    def ignore: TestAspect = ???
    def flaky(maxRetries: Int): TestAspect = ???
    def nonFlaky(n: Int): TestAspect = ???
  }

  // ==========================================================================
  // Exercise 6: Implement a test layer system (dependency injection for tests)
  // ==========================================================================
  // TODO: Implement `TestLayer[A]` representing a managed test dependency:
  //       - map[B](f: A => B): TestLayer[B]
  //       - flatMap[B](f: A => TestLayer[B]): TestLayer[B]
  //       - zip[B](other: TestLayer[B]): TestLayer[(A, B)]
  //       - build(): A  (creates the resource)
  //       - release(a: A): Unit  (cleans up)
  //       Implement `provide[A, B](layer: TestLayer[A])(test: A => B): B`
  //       that builds the layer, runs the test, then releases.
  case class TestLayer[A](buildFn: () => A, releaseFn: A => Unit) {
    def map[B](f: A => B): TestLayer[B] = ???
    def flatMap[B](f: A => TestLayer[B]): TestLayer[B] = ???
    def zip[B](other: TestLayer[B]): TestLayer[(A, B)] = ???
    def build(): A = ???
    def release(a: A): Unit = ???
  }

  def provide[A, B](layer: TestLayer[A])(test: A => B): B = ???

  // ==========================================================================
  // Exercise 7: Implement test assertions for effects (simulated)
  // ==========================================================================
  // TODO: Implement assertion helpers for effect-like computations.
  //       Model an effect as () => Either[Throwable, A].
  //       - assertSucceeds[A](effect: () => Either[Throwable, A]): A
  //       - assertFails(effect: () => Either[Throwable, Any]): Throwable
  //       - assertFailsWith[E <: Throwable : ClassTag](effect: () => Either[Throwable, Any]): E
  //       - assertDies(effect: () => Either[Throwable, Any]): Throwable
  //         (same as assertFails but for unchecked exceptions only: RuntimeException, Error)
  //       - assertCompletes(effect: () => Either[Throwable, Any]): Boolean
  //         (just checks it doesn't fail)
  import scala.reflect.ClassTag

  def assertSucceeds[A](effect: () => Either[Throwable, A]): A = ???
  def assertFails(effect: () => Either[Throwable, Any]): Throwable = ???
  def assertFailsWith[E <: Throwable : ClassTag](effect: () => Either[Throwable, Any]): E = ???
  def assertDies(effect: () => Either[Throwable, Any]): Throwable = ???
  def assertCompletes(effect: () => Either[Throwable, Any]): Boolean = ???

  // ==========================================================================
  // Exercise 8: Implement a test suite runner with ZIO-style output
  // ==========================================================================
  // TODO: Implement `ZTestRunner` that runs a suite of specs and produces
  //       ZIO-test-style colored output:
  //       - addSpec(name: String, test: TestEnvironment => Boolean): Unit
  //       - addSuite(name: String, specs: List[(String, TestEnvironment => Boolean)]): Unit
  //       - run(): ZTestReport
  //       ZTestReport: total, passed, failed, ignored, duration, formattedOutput (String)
  //       Formatted output should look like:
  //       "  + suiteName - specName (Xms)"  for passing
  //       "  - suiteName - specName (Xms)"  for failing
  case class ZTestReport(
    total: Int,
    passed: Int,
    failed: Int,
    ignored: Int,
    durationMs: Long,
    formattedOutput: String
  )

  class ZTestRunner {
    def addSpec(name: String, test: TestEnvironment => Boolean): Unit = ???
    def addSuite(name: String, specs: List[(String, TestEnvironment => Boolean)]): Unit = ???
    def run(): ZTestReport = ???
  }

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val clock = new TestClock
    assert(clock.currentTimeMillis == 0)
    clock.advance(1000)
    assert(clock.currentTimeMillis == 1000)
    clock.sleep(500)
    assert(clock.currentTimeMillis == 1500)
    assert(clock.sleepHistory == List(500))
    var timerFired = false
    clock.addTimer(2000) { timerFired = true }
    clock.advance(600)
    clock.fireTimers()
    assert(timerFired)
    println("Exercise 1 passed: TestClock works")

    // Exercise 2
    val console = new TestConsole
    console.feedInput("Alice", "30")
    console.printLine("What is your name?")
    val name = console.readLine()
    assert(name == "Alice")
    console.printLine(s"Hello, $name!")
    assert(console.output == List("What is your name?", "Hello, Alice!"))
    assert(console.readLine() == "30")
    assert(!console.hasInput)
    println("Exercise 2 passed: TestConsole works")

    // Exercise 3
    val random = new TestRandom
    random.feedInts(1, 2, 3)
    assert(random.nextInt() == 1)
    assert(random.nextInt() == 2)
    assert(random.nextInt() == 3)
    assert(random.nextInt() == 1) // cycles
    random.feedBooleans(true, false)
    assert(random.nextBoolean() == true)
    assert(random.nextBoolean() == false)
    println("Exercise 3 passed: TestRandom works")

    // Exercise 4
    val specResult = runSpec("basic test") { env =>
      env.clock.advance(100)
      env.console.printLine("hello")
      env.clock.currentTimeMillis == 100 && env.console.output.contains("hello")
    }
    assert(specResult.passed)
    assert(specResult.snapshot.clockTime == 100)
    println("Exercise 4 passed: TestEnvironment works")

    // Exercise 5
    val retryAspect = TestAspect.retry(3)
    var attempt = 0
    val aspectResult = retryAspect { () => attempt += 1; attempt >= 3 }
    assert(aspectResult.passed && aspectResult.attempts == 3)
    val ignoreResult = TestAspect.ignore { () => throw new RuntimeException("ignored") }
    assert(ignoreResult.skipped)
    val nonFlakyResult = TestAspect.nonFlaky(5) { () => true }
    assert(nonFlakyResult.passed && nonFlakyResult.attempts == 5)
    println("Exercise 5 passed: TestAspects work")

    // Exercise 6
    var released = false
    val dbLayer = TestLayer(() => "db-connection", (_: String) => { released = true })
    val result = provide(dbLayer) { conn =>
      assert(conn == "db-connection")
      42
    }
    assert(result == 42 && released)
    val composedLayer = dbLayer.zip(TestLayer(() => "cache", (_: String) => ()))
    val composed = provide(composedLayer) { case (db, cache) => s"$db+$cache" }
    assert(composed == "db-connection+cache")
    println("Exercise 6 passed: TestLayers work")

    // Exercise 7
    val v = assertSucceeds(() => Right(42))
    assert(v == 42)
    val e = assertFails(() => Left(new RuntimeException("err")))
    assert(e.getMessage == "err")
    val specific = assertFailsWith[IllegalArgumentException](
      () => Left(new IllegalArgumentException("bad arg"))
    )
    assert(specific.getMessage == "bad arg")
    assert(assertCompletes(() => Right("ok")))
    println("Exercise 7 passed: effect assertions work")

    // Exercise 8
    val runner = new ZTestRunner
    runner.addSuite("math", List(
      ("1+1=2", _ => 1 + 1 == 2),
      ("2*3=6", _ => 2 * 3 == 6),
      ("failing", _ => false)
    ))
    val report = runner.run()
    assert(report.total == 3 && report.passed == 2 && report.failed == 1)
    assert(report.formattedOutput.contains("+") && report.formattedOutput.contains("-"))
    println("Exercise 8 passed: ZTestRunner works")

    println("\nAll Test015 exercises passed!")
  }
}
