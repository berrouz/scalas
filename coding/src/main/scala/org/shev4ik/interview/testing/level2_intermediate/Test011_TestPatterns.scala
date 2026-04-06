package org.shev4ik.interview.testing.level2_intermediate

/**
 * Test011 - Test Patterns
 *
 * Common test patterns: Arrange-Act-Assert, Given-When-Then,
 * test pyramid concepts, and structured test design.
 */
object Test011_TestPatterns {

  // ==========================================================================
  // Exercise 1: Implement the Arrange-Act-Assert pattern framework
  // ==========================================================================
  // TODO: Implement `AAATest` that structures a test into three phases:
  //       - arrange: () => A  (sets up preconditions, returns test context)
  //       - act: A => B  (performs the action under test)
  //       - assertPhase: B => Boolean  (verifies outcome)
  //       Implement `run(): AAAResult` that executes all three phases and
  //       returns AAAResult(name, passed, arrangeTimeMs, actTimeMs, assertTimeMs).
  case class AAAResult(
    name: String,
    passed: Boolean,
    arrangeTimeMs: Long,
    actTimeMs: Long,
    assertTimeMs: Long
  )

  class AAATest[A, B](
    name: String,
    arrange: () => A,
    act: A => B,
    assertPhase: B => Boolean
  ) {
    def run(): AAAResult = ???
  }

  // ==========================================================================
  // Exercise 2: Implement the Given-When-Then pattern (BDD-style)
  // ==========================================================================
  // TODO: Implement a BDD-style test builder:
  //       - given_[A](description: String)(setup: => A): GivenStep[A]
  //       - GivenStep[A].when_[B](description: String)(action: A => B): WhenStep[A, B]
  //       - WhenStep[A,B].then_[C](description: String)(verify: B => Boolean): ThenStep
  //       - ThenStep.run(): BDDResult
  //       BDDResult contains: givenDesc, whenDesc, thenDesc, passed, error: Option[String]
  case class BDDResult(
    givenDesc: String,
    whenDesc: String,
    thenDesc: String,
    passed: Boolean,
    error: Option[String]
  )

  class GivenStep[A](desc: String, setup: () => A) {
    def when_[B](whenDesc: String)(action: A => B): WhenStep[A, B] = ???
  }

  class WhenStep[A, B](givenDesc: String, setup: () => A, whenDesc: String, action: A => B) {
    def then_(thenDesc: String)(verify: B => Boolean): ThenStep = ???
  }

  class ThenStep(givenDesc: String, whenDesc: String, thenDesc: String, execute: () => Boolean) {
    def run(): BDDResult = ???
  }

  def given_[A](description: String)(setup: => A): GivenStep[A] = ???

  // ==========================================================================
  // Exercise 3: Implement test categorization (test pyramid)
  // ==========================================================================
  // TODO: Implement `TestPyramid` that categorizes tests and ensures proper distribution:
  //       - addTest(name: String, category: TestCategory): Unit
  //       - distribution(): Map[TestCategory, Int]  (count per category)
  //       - isHealthy(): Boolean  (unit > integration > e2e in count)
  //       - report(): String  (visual pyramid representation)
  sealed trait TestCategory { def name: String }
  case object UnitTest extends TestCategory { val name = "unit" }
  case object IntegrationTest extends TestCategory { val name = "integration" }
  case object E2ETest extends TestCategory { val name = "e2e" }

  class TestPyramid {
    def addTest(name: String, category: TestCategory): Unit = ???
    def distribution(): Map[TestCategory, Int] = ???
    def isHealthy(): Boolean = ???
    def report(): String = ???
  }

  // ==========================================================================
  // Exercise 4: Implement the Object Mother pattern
  // ==========================================================================
  // TODO: Implement `ObjectMother` that creates pre-defined test objects:
  //       case class Order(id: Int, items: List[String], total: Double, status: String)
  //       - validOrder(): Order  (a standard valid order)
  //       - emptyOrder(): Order  (order with no items)
  //       - highValueOrder(): Order  (order over $1000)
  //       - cancelledOrder(): Order  (status = "cancelled")
  //       - customOrder(overrides: Map[String, Any]): Order  (apply specific overrides)
  case class Order(id: Int, items: List[String], total: Double, status: String)

  object ObjectMother {
    def validOrder(): Order = ???
    def emptyOrder(): Order = ???
    def highValueOrder(): Order = ???
    def cancelledOrder(): Order = ???
    def customOrder(overrides: Map[String, Any]): Order = ???
  }

  // ==========================================================================
  // Exercise 5: Implement the Specification pattern
  // ==========================================================================
  // TODO: Implement `Spec[A]` that represents a business rule that can be tested:
  //       - isSatisfiedBy(candidate: A): Boolean
  //       - and(other: Spec[A]): Spec[A]
  //       - or(other: Spec[A]): Spec[A]
  //       - not: Spec[A]
  //       - explain(candidate: A): String  (human-readable explanation)
  //       Use this to verify business logic in tests.
  trait Spec[A] {
    def isSatisfiedBy(candidate: A): Boolean
    def explain(candidate: A): String
    def and(other: Spec[A]): Spec[A] = ???
    def or(other: Spec[A]): Spec[A] = ???
    def not: Spec[A] = ???
  }

  // ==========================================================================
  // Exercise 6: Implement test scenario composition
  // ==========================================================================
  // TODO: Implement `Scenario` that chains multiple steps:
  //       - step(name: String)(action: Map[String, Any] => Map[String, Any]): Scenario
  //         Each step receives context and returns updated context.
  //       - verify(name: String)(check: Map[String, Any] => Boolean): Scenario
  //       - run(initialContext: Map[String, Any]): ScenarioResult
  //       ScenarioResult: List of (stepName, passed, error) plus overall pass/fail.
  case class StepResult(name: String, passed: Boolean, error: Option[String])
  case class ScenarioResult(steps: List[StepResult], allPassed: Boolean)

  class Scenario(name: String) {
    def step(stepName: String)(action: Map[String, Any] => Map[String, Any]): Scenario = ???
    def verify(checkName: String)(check: Map[String, Any] => Boolean): Scenario = ???
    def run(initialContext: Map[String, Any] = Map.empty): ScenarioResult = ???
  }

  // ==========================================================================
  // Exercise 7: Implement the Four-Phase Test pattern
  // ==========================================================================
  // TODO: Implement `FourPhaseTest` with explicit phases:
  //       1. Setup: create test fixtures
  //       2. Exercise: invoke the behavior under test
  //       3. Verify: check the expected outcome
  //       4. Teardown: clean up resources
  //       Each phase is logged with timing. Return FourPhaseResult.
  case class PhaseInfo(name: String, durationMs: Long, success: Boolean)
  case class FourPhaseResult(phases: List[PhaseInfo], passed: Boolean)

  class FourPhaseTest[A, B](name: String) {
    def setup(f: () => A): FourPhaseTest[A, B] = ???
    def exercise(f: A => B): FourPhaseTest[A, B] = ???
    def verifyPhase(f: B => Boolean): FourPhaseTest[A, B] = ???
    def teardown(f: A => Unit): FourPhaseTest[A, B] = ???
    def run(): FourPhaseResult = ???
  }

  // ==========================================================================
  // Exercise 8: Implement a test pattern detector
  // ==========================================================================
  // TODO: Implement `analyzeTestStructure` that takes a simplified test AST and
  //       detects which pattern it follows:
  //       TestAST: List of phases (strings like "arrange", "act", "assert",
  //       "given", "when", "then", "setup", "exercise", "verify", "teardown")
  //       Return the detected pattern name:
  //       - "AAA" for arrange-act-assert
  //       - "BDD" for given-when-then
  //       - "FourPhase" for setup-exercise-verify-teardown
  //       - "Unknown" if none match
  //       Also detect anti-patterns:
  //       - "MultipleActs" if there are multiple act/exercise phases
  //       - "MissingAssert" if there is no assert/verify/then phase
  case class TestAnalysis(pattern: String, antiPatterns: List[String])

  def analyzeTestStructure(phases: List[String]): TestAnalysis = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val aaa = new AAATest[List[Int], Int](
      "sum test",
      arrange = () => List(1, 2, 3),
      act = _.sum,
      assertPhase = _ == 6
    )
    val aaaResult = aaa.run()
    assert(aaaResult.passed && aaaResult.name == "sum test")
    println("Exercise 1 passed: AAA pattern works")

    // Exercise 2
    val bddResult = given_("a list of numbers") {
      List(1, 2, 3, 4, 5)
    }.when_("we filter evens") { nums =>
      nums.filter(_ % 2 == 0)
    }.then_("only even numbers remain") { evens =>
      evens == List(2, 4)
    }.run()
    assert(bddResult.passed)
    assert(bddResult.givenDesc.contains("list"))
    println("Exercise 2 passed: BDD Given-When-Then works")

    // Exercise 3
    val pyramid = new TestPyramid
    (1 to 10).foreach(i => pyramid.addTest(s"unit$i", UnitTest))
    (1 to 5).foreach(i => pyramid.addTest(s"int$i", IntegrationTest))
    (1 to 2).foreach(i => pyramid.addTest(s"e2e$i", E2ETest))
    assert(pyramid.isHealthy())
    val dist = pyramid.distribution()
    assert(dist(UnitTest) == 10 && dist(IntegrationTest) == 5 && dist(E2ETest) == 2)
    println("Exercise 3 passed: test pyramid works")

    // Exercise 4
    val valid = ObjectMother.validOrder()
    assert(valid.items.nonEmpty && valid.total > 0 && valid.status == "active")
    val empty = ObjectMother.emptyOrder()
    assert(empty.items.isEmpty)
    val custom = ObjectMother.customOrder(Map("status" -> "shipped"))
    assert(custom.status == "shipped")
    println("Exercise 4 passed: Object Mother pattern works")

    // Exercise 5
    val isActive: Spec[Order] = new Spec[Order] {
      def isSatisfiedBy(o: Order): Boolean = o.status == "active"
      def explain(o: Order): String = s"Order status is ${o.status}, expected active"
    }
    val hasItems: Spec[Order] = new Spec[Order] {
      def isSatisfiedBy(o: Order): Boolean = o.items.nonEmpty
      def explain(o: Order): String = s"Order has ${o.items.size} items"
    }
    val validSpec = isActive.and(hasItems)
    assert(validSpec.isSatisfiedBy(ObjectMother.validOrder()))
    assert(!validSpec.isSatisfiedBy(ObjectMother.emptyOrder()))
    assert(!isActive.not.isSatisfiedBy(ObjectMother.validOrder()))
    println("Exercise 5 passed: Specification pattern works")

    // Exercise 6
    val scenario = new Scenario("user registration")
      .step("create user") { ctx =>
        ctx + ("userId" -> 1) + ("name" -> "Alice")
      }
      .verify("user created") { ctx =>
        ctx.contains("userId") && ctx("name") == "Alice"
      }
      .step("send welcome email") { ctx =>
        ctx + ("emailSent" -> true)
      }
      .verify("email was sent") { ctx =>
        ctx("emailSent") == true
      }
    val scenResult = scenario.run()
    assert(scenResult.allPassed)
    assert(scenResult.steps.length == 4)
    println("Exercise 6 passed: scenario composition works")

    // Exercise 7
    var teardownRan = false
    val fourPhase = new FourPhaseTest[StringBuilder, String]("four phase")
      .setup(() => new StringBuilder("hello"))
      .exercise(sb => { sb.append(" world"); sb.toString })
      .verifyPhase(_ == "hello world")
      .teardown(_ => { teardownRan = true })
    val fpResult = fourPhase.run()
    assert(fpResult.passed && teardownRan)
    assert(fpResult.phases.length == 4)
    println("Exercise 7 passed: Four-Phase Test works")

    // Exercise 8
    val aaaAnalysis = analyzeTestStructure(List("arrange", "act", "assert"))
    assert(aaaAnalysis.pattern == "AAA")
    val bddAnalysis = analyzeTestStructure(List("given", "when", "then"))
    assert(bddAnalysis.pattern == "BDD")
    val multiAct = analyzeTestStructure(List("arrange", "act", "act", "assert"))
    assert(multiAct.antiPatterns.contains("MultipleActs"))
    val noAssert = analyzeTestStructure(List("arrange", "act"))
    assert(noAssert.antiPatterns.contains("MissingAssert"))
    println("Exercise 8 passed: test pattern analysis works")

    println("\nAll Test011 exercises passed!")
  }
}
