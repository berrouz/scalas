package org.shev4ik.interview.testing.level1_basics

/**
 * Test006 - Parameterized Tests
 *
 * Data-driven testing, table-driven tests, generating test cases,
 * and parameterized test infrastructure.
 */
object Test006_ParameterizedTests {

  // ==========================================================================
  // Exercise 1: Implement a table-driven test runner
  // ==========================================================================
  // TODO: Implement `tableTest` that takes a test name, a list of test rows
  //       (input, expected output), and a function under test.
  //       Run each row, collecting results as List[(input, expected, actual, passed)].
  //       Return TableResult with the name, rows, and overall pass/fail.
  case class TableRow[A, B](input: A, expected: B)
  case class TableResult[A, B](
    name: String,
    results: List[(A, B, B, Boolean)],
    allPassed: Boolean
  )

  def tableTest[A, B](name: String, rows: List[TableRow[A, B]])(f: A => B): TableResult[A, B] = ???

  // ==========================================================================
  // Exercise 2: Implement parameterized test with multiple parameters
  // ==========================================================================
  // TODO: Implement `parameterizedTest2` for functions with 2 inputs:
  //       Takes a name, List of (A, B, C) triples (input1, input2, expected),
  //       and a function (A, B) => C.
  //       Returns List[(A, B, C, C, Boolean)] - (in1, in2, expected, actual, passed).
  def parameterizedTest2[A, B, C](
    name: String,
    cases: List[(A, B, C)]
  )(f: (A, B) => C): List[(A, B, C, C, Boolean)] = ???

  // ==========================================================================
  // Exercise 3: Implement a test case generator for ranges
  // ==========================================================================
  // TODO: Implement `generateRangeCases` that generates test cases for a function
  //       over a range of integer inputs.
  //       Parameters: start, end (inclusive), step, and expected function (Int => B).
  //       Returns List[TableRow[Int, B]].
  //       Also implement `generateBoundaryCases` that for a given range (min, max)
  //       generates boundary test values: min, min+1, max-1, max, and optionally
  //       min-1 and max+1 (for out-of-bounds testing).
  def generateRangeCases[B](start: Int, end: Int, step: Int)(expected: Int => B): List[TableRow[Int, B]] = ???
  def generateBoundaryCases(min: Int, max: Int, includeOutOfBounds: Boolean): List[Int] = ???

  // ==========================================================================
  // Exercise 4: Implement a combinatorial test case generator
  // ==========================================================================
  // TODO: Implement `combinatorial` that takes multiple parameter lists
  //       and generates all combinations (cartesian product).
  //       combinatorial2(as: List[A], bs: List[B]): List[(A, B)]
  //       combinatorial3(as: List[A], bs: List[B], cs: List[C]): List[(A, B, C)]
  //       Also implement `pairwise` that reduces combinations using pairwise
  //       coverage: every pair of parameter values appears at least once.
  //       For simplicity, pairwise2 can just return the full cartesian product.
  def combinatorial2[A, B](as: List[A], bs: List[B]): List[(A, B)] = ???
  def combinatorial3[A, B, C](as: List[A], bs: List[B], cs: List[C]): List[(A, B, C)] = ???

  // ==========================================================================
  // Exercise 5: Implement a data-driven test with custom formatting
  // ==========================================================================
  // TODO: Implement `dataDrivenTest` that takes:
  //       - name: String
  //       - data: List[Map[String, Any]] (each map is a row of named parameters)
  //       - test: Map[String, Any] => Boolean  (the test function)
  //       Returns a formatted report string showing each row and PASS/FAIL.
  //       Format: "[PASS/FAIL] name[rowIndex]: {key1=val1, key2=val2}"
  def dataDrivenTest(
    name: String,
    data: List[Map[String, Any]],
    test: Map[String, Any] => Boolean
  ): String = ???

  // ==========================================================================
  // Exercise 6: Implement test matrix generation
  // ==========================================================================
  // TODO: Implement `testMatrix` that takes a Map of parameterName -> List[values]
  //       and generates a full matrix (cartesian product) of all combinations
  //       as List[Map[String, Any]].
  //       Example: Map("os" -> List("linux","mac"), "jdk" -> List(8,11))
  //       => List(Map("os"->"linux","jdk"->8), Map("os"->"linux","jdk"->11), ...)
  def testMatrix(params: Map[String, List[Any]]): List[Map[String, Any]] = ???

  // ==========================================================================
  // Exercise 7: Implement a parameterized test with expected exceptions
  // ==========================================================================
  // TODO: Implement `exceptionTableTest` that takes cases where some inputs
  //       should produce a value and others should throw.
  //       Case class: ExceptionTestCase[A, B](input: A, expected: Either[Class[_], B])
  //       Left means an exception of that class is expected.
  //       Right means a successful value is expected.
  //       Returns List[(A, Boolean)] with input and pass/fail.
  case class ExceptionTestCase[A, B](input: A, expected: Either[Class[_], B])

  def exceptionTableTest[A, B](cases: List[ExceptionTestCase[A, B]])(f: A => B): List[(A, Boolean)] = ???

  // ==========================================================================
  // Exercise 8: Implement a CSV-based test data loader
  // ==========================================================================
  // TODO: Implement `parseCsvTestData` that takes a CSV string (with header row)
  //       and returns List[Map[String, String]] where keys are column headers.
  //       Handle: quoted fields with commas, trimming whitespace, empty fields.
  //       Example: "name,age\nAlice,30\nBob,25" =>
  //       List(Map("name"->"Alice","age"->"30"), Map("name"->"Bob","age"->"25"))
  def parseCsvTestData(csv: String): List[Map[String, String]] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val result = tableTest("abs", List(
      TableRow(-1, 1), TableRow(0, 0), TableRow(5, 5), TableRow(-3, 3)
    ))(math.abs)
    assert(result.allPassed)
    assert(result.results.length == 4)
    println("Exercise 1 passed: table-driven tests work")

    // Exercise 2
    val addResults = parameterizedTest2("add", List(
      (1, 2, 3), (0, 0, 0), (-1, 1, 0), (10, 20, 30)
    ))((a: Int, b: Int) => a + b)
    assert(addResults.forall(_._5))
    println("Exercise 2 passed: multi-parameter tests work")

    // Exercise 3
    val rangeCases = generateRangeCases(0, 10, 2)(n => n * n)
    assert(rangeCases.length == 6) // 0, 2, 4, 6, 8, 10
    assert(rangeCases.head == TableRow(0, 0))
    assert(rangeCases(1) == TableRow(2, 4))
    val boundary = generateBoundaryCases(0, 100, includeOutOfBounds = true)
    assert(boundary.contains(-1) && boundary.contains(101))
    assert(boundary.contains(0) && boundary.contains(100))
    println("Exercise 3 passed: range and boundary generation works")

    // Exercise 4
    val pairs = combinatorial2(List(1, 2), List("a", "b"))
    assert(pairs.length == 4)
    assert(pairs.contains((1, "a")) && pairs.contains((2, "b")))
    val triples = combinatorial3(List(1), List("a", "b"), List(true, false))
    assert(triples.length == 4)
    println("Exercise 4 passed: combinatorial generation works")

    // Exercise 5
    val report = dataDrivenTest("validation", List(
      Map("input" -> "hello", "valid" -> true),
      Map("input" -> "", "valid" -> false)
    ), row => row("valid").asInstanceOf[Boolean])
    assert(report.contains("PASS") && report.contains("FAIL"))
    println("Exercise 5 passed: data-driven test reporting works")

    // Exercise 6
    val matrix = testMatrix(Map("os" -> List("linux", "mac"), "jdk" -> List(8, 11)))
    assert(matrix.length == 4)
    assert(matrix.exists(m => m("os") == "linux" && m("jdk") == 8))
    assert(matrix.exists(m => m("os") == "mac" && m("jdk") == 11))
    println("Exercise 6 passed: test matrix generation works")

    // Exercise 7
    val exResults = exceptionTableTest[Int, Int](List(
      ExceptionTestCase(4, Right(2)),
      ExceptionTestCase(0, Left(classOf[ArithmeticException])),
      ExceptionTestCase(9, Right(3))
    ))((n: Int) => 12 / n)
    assert(exResults.forall(_._2))
    println("Exercise 7 passed: exception table tests work")

    // Exercise 8
    val csv = "name,age,city\nAlice,30,NYC\nBob,25,LA"
    val data = parseCsvTestData(csv)
    assert(data.length == 2)
    assert(data.head("name") == "Alice" && data.head("age") == "30")
    assert(data(1)("city") == "LA")
    println("Exercise 8 passed: CSV test data parsing works")

    println("\nAll Test006 exercises passed!")
  }
}
