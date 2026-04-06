package org.shev4ik.interview.testing.level1_basics

/**
 * Test003 - Test Organization
 *
 * Structuring tests: suites, nesting, tagging, filtering,
 * and building organizational primitives for test frameworks.
 */
object Test003_TestOrganization {

  // ==========================================================================
  // Exercise 1: Implement a hierarchical test suite
  // ==========================================================================
  // TODO: Implement a `TestNode` sealed trait with two variants:
  //       - TestCase(name: String, body: () => Unit)
  //       - TestGroup(name: String, children: List[TestNode])
  //       Then implement `runAll(node: TestNode): List[(String, Boolean)]`
  //       that runs all tests and returns (fullPath, passed) pairs.
  //       Full path should be dot-separated, e.g., "group1.group2.testName".
  sealed trait TestNode
  case class TestCase(name: String, body: () => Unit) extends TestNode
  case class TestGroup(name: String, children: List[TestNode]) extends TestNode

  def runAll(node: TestNode, prefix: String = ""): List[(String, Boolean)] = ???

  // ==========================================================================
  // Exercise 2: Implement test tagging and filtering
  // ==========================================================================
  // TODO: Implement a `TaggedTest` case class with name, tags (Set[String]), and body.
  //       Implement `filterByTag` that takes a list of TaggedTests and a tag predicate
  //       (Set[String] => Boolean) and returns only matching tests.
  //       Implement `filterByName` that filters tests whose names match a regex pattern.
  case class TaggedTest(name: String, tags: Set[String], body: () => Unit)

  def filterByTag(tests: List[TaggedTest], predicate: Set[String] => Boolean): List[TaggedTest] = ???
  def filterByName(tests: List[TaggedTest], pattern: String): List[TaggedTest] = ???

  // ==========================================================================
  // Exercise 3: Implement test execution ordering
  // ==========================================================================
  // TODO: Implement three ordering strategies for a list of test names:
  //       - alphabetical(tests: List[String]): List[String]
  //       - reversed(tests: List[String]): List[String]
  //       - shuffled(tests: List[String], seed: Long): List[String]
  //         (use scala.util.Random with the given seed for deterministic shuffling)
  def alphabetical(tests: List[String]): List[String] = ???
  def reversed(tests: List[String]): List[String] = ???
  def shuffled(tests: List[String], seed: Long): List[String] = ???

  // ==========================================================================
  // Exercise 4: Implement a test report generator
  // ==========================================================================
  // TODO: Given a list of TestOutcome(name, passed, durationMs, error: Option[String]),
  //       implement `generateReport` that returns a formatted string report:
  //       - Header: "Test Report: [suiteName]"
  //       - Each test: "[PASS/FAIL] testName (Xms)" and on fail: "  Error: ..."
  //       - Footer: "X/Y passed, Z failed, total time: Nms"
  case class TestOutcome(name: String, passed: Boolean, durationMs: Long, error: Option[String])

  def generateReport(suiteName: String, outcomes: List[TestOutcome]): String = ???

  // ==========================================================================
  // Exercise 5: Implement test dependency management
  // ==========================================================================
  // TODO: Implement `orderByDependencies` that takes a map of
  //       testName -> Set[dependencyNames] and returns an execution order
  //       (List[String]) respecting dependencies (topological sort).
  //       If there's a cycle, return Left("Circular dependency detected").
  //       If valid, return Right(orderedList).
  def orderByDependencies(deps: Map[String, Set[String]]): Either[String, List[String]] = ???

  // ==========================================================================
  // Exercise 6: Implement test suite composition
  // ==========================================================================
  // TODO: Implement a `Suite` case class with name and tests (List[(String, () => Unit)]).
  //       Implement:
  //       - mergeSuites(suites: List[Suite]): Suite
  //         (merge all into one suite, prefixing test names with suite name)
  //       - partitionSuite(suite: Suite, predicate: String => Boolean): (Suite, Suite)
  //         (split into matching and non-matching)
  case class Suite(name: String, tests: List[(String, () => Unit)])

  def mergeSuites(suites: List[Suite]): Suite = ???
  def partitionSuite(suite: Suite, predicate: String => Boolean): (Suite, Suite) = ???

  // ==========================================================================
  // Exercise 7: Implement test focus and skip markers
  // ==========================================================================
  // TODO: Implement a `MarkedTest` with name, body, and marker (Focus, Skip, Normal).
  //       Implement `resolveMarkers` that takes a list of MarkedTests and returns
  //       only the tests that should run:
  //       - If ANY test is marked Focus, run ONLY focused tests
  //       - Skip tests are always excluded
  //       - If no Focus tests exist, run all Normal tests
  sealed trait Marker
  case object Focus extends Marker
  case object Skip extends Marker
  case object Normal extends Marker

  case class MarkedTest(name: String, body: () => Unit, marker: Marker)

  def resolveMarkers(tests: List[MarkedTest]): List[MarkedTest] = ???

  // ==========================================================================
  // Exercise 8: Implement parallel test group detection
  // ==========================================================================
  // TODO: Implement `findParallelGroups` that analyzes test dependencies
  //       and groups tests that can run in parallel.
  //       Input: Map[String, Set[String]] (test -> dependencies)
  //       Output: List[Set[String]] where each Set is a group of tests
  //       that can run concurrently (all their dependencies are in previous groups).
  //       This is essentially computing layers of a DAG.
  def findParallelGroups(deps: Map[String, Set[String]]): List[Set[String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val tree = TestGroup("math", List(
      TestCase("add", () => assert(1 + 1 == 2)),
      TestGroup("multiply", List(
        TestCase("by2", () => assert(2 * 3 == 6)),
        TestCase("by0", () => assert(5 * 0 == 0))
      ))
    ))
    val results = runAll(tree)
    assert(results.length == 3)
    assert(results.forall(_._2))
    assert(results.exists(_._1 == "math.multiply.by2"))
    println("Exercise 1 passed: hierarchical test suite works")

    // Exercise 2
    val tagged = List(
      TaggedTest("fast1", Set("fast", "unit"), () => ()),
      TaggedTest("slow1", Set("slow", "integration"), () => ()),
      TaggedTest("fast2", Set("fast", "smoke"), () => ())
    )
    assert(filterByTag(tagged, _.contains("fast")).length == 2)
    assert(filterByName(tagged, ".*1$").length == 2)
    println("Exercise 2 passed: tagging and filtering works")

    // Exercise 3
    val names = List("charlie", "alpha", "bravo")
    assert(alphabetical(names) == List("alpha", "bravo", "charlie"))
    assert(reversed(names) == List("bravo", "alpha", "charlie"))
    val s1 = shuffled(names, 42L)
    val s2 = shuffled(names, 42L)
    assert(s1 == s2, "Same seed should produce same order")
    println("Exercise 3 passed: test ordering works")

    // Exercise 4
    val outcomes = List(
      TestOutcome("test1", passed = true, 10, None),
      TestOutcome("test2", passed = false, 25, Some("NPE")),
      TestOutcome("test3", passed = true, 5, None)
    )
    val report = generateReport("MySuite", outcomes)
    assert(report.contains("PASS") && report.contains("FAIL"))
    assert(report.contains("2/3 passed"))
    println("Exercise 4 passed: report generation works")

    // Exercise 5
    val deps = Map(
      "c" -> Set("a", "b"),
      "b" -> Set("a"),
      "a" -> Set.empty[String]
    )
    val order = orderByDependencies(deps)
    assert(order.isRight)
    val ordered = order.toOption.get
    assert(ordered.indexOf("a") < ordered.indexOf("b"))
    assert(ordered.indexOf("b") < ordered.indexOf("c"))
    val cyclic = Map("a" -> Set("b"), "b" -> Set("a"))
    assert(orderByDependencies(cyclic).isLeft)
    println("Exercise 5 passed: dependency ordering works")

    // Exercise 6
    val s1Suite = Suite("math", List(("add", () => ()), ("sub", () => ())))
    val s2Suite = Suite("string", List(("len", () => ())))
    val merged = mergeSuites(List(s1Suite, s2Suite))
    assert(merged.tests.length == 3)
    assert(merged.tests.exists(_._1.startsWith("math.")))
    val (matching, rest) = partitionSuite(merged, _.contains("math"))
    assert(matching.tests.length == 2 && rest.tests.length == 1)
    println("Exercise 6 passed: suite composition works")

    // Exercise 7
    val marked = List(
      MarkedTest("t1", () => (), Normal),
      MarkedTest("t2", () => (), Focus),
      MarkedTest("t3", () => (), Skip),
      MarkedTest("t4", () => (), Normal)
    )
    val resolved = resolveMarkers(marked)
    assert(resolved.length == 1 && resolved.head.name == "t2")
    val noFocus = List(
      MarkedTest("t1", () => (), Normal),
      MarkedTest("t2", () => (), Skip)
    )
    assert(resolveMarkers(noFocus).length == 1)
    println("Exercise 7 passed: focus/skip markers work")

    // Exercise 8
    val parDeps = Map(
      "a" -> Set.empty[String],
      "b" -> Set.empty[String],
      "c" -> Set("a"),
      "d" -> Set("a", "b"),
      "e" -> Set("c", "d")
    )
    val groups = findParallelGroups(parDeps)
    assert(groups.head == Set("a", "b"))
    assert(groups.last.contains("e"))
    println("Exercise 8 passed: parallel group detection works")

    println("\nAll Test003 exercises passed!")
  }
}
