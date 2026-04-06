package org.shev4ik.interview.doobie.level2_intermediate

/**
 * Doobie 008 - Testing (query type checking, analysis, YOLO mode)
 *
 * Doobie provides powerful testing utilities:
 * - Type checking: verifies that SQL types align with Scala types at test time
 * - Analysis: inspects queries for potential issues (nullability, type mismatches)
 * - YOLO mode: a convenience Transactor for quick REPL/test exploration
 *
 * Here we model simplified versions of these concepts to understand how doobie
 * validates queries before they hit production.
 */
object Doob008_Testing {

  // Simplified SQL column metadata
  case class ColumnMeta(name: String, sqlType: String, nullable: Boolean)

  // Simplified Scala type info
  case class ScalaType(name: String, isOption: Boolean = false)

  // Query analysis result
  case class AnalysisResult(
    sql: String,
    columnAlignments: List[ColumnAlignment],
    paramAlignments: List[ParamAlignment]
  ) {
    def isValid: Boolean = columnAlignments.forall(_.isValid) && paramAlignments.forall(_.isValid)
    def errors: List[String] = columnAlignments.flatMap(_.error) ++ paramAlignments.flatMap(_.error)
  }

  case class ColumnAlignment(column: ColumnMeta, scalaType: ScalaType, isValid: Boolean, error: Option[String])
  case class ParamAlignment(paramIndex: Int, sqlType: String, scalaType: ScalaType, isValid: Boolean, error: Option[String])

  // Type mapping registry
  val typeMap: Map[String, Set[String]] = Map(
    "INTEGER" -> Set("Int", "Long", "Short"),
    "VARCHAR" -> Set("String"),
    "DOUBLE" -> Set("Double", "Float"),
    "BOOLEAN" -> Set("Boolean"),
    "TIMESTAMP" -> Set("Instant", "LocalDateTime"),
    "BIGINT" -> Set("Long")
  )

  // -------------------------------------------------------------------------
  // Exercise 1: Check if a SQL type is compatible with a Scala type.
  // TODO: Using typeMap, return true if the sqlType supports the given
  // scalaType name. Return false if the sqlType is unknown or incompatible.
  // -------------------------------------------------------------------------
  def exercise1_isTypeCompatible(sqlType: String, scalaTypeName: String): Boolean = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Validate column nullability.
  // TODO: If a column is nullable but the Scala type is NOT Option,
  // return an error message. If the column is non-nullable but Scala type
  // IS Option, return a warning. Otherwise return None.
  // Error: "Column X is nullable but mapped to non-optional Y"
  // Warning: "Column X is non-nullable but mapped to optional Y"
  // -------------------------------------------------------------------------
  def exercise2_checkNullability(column: ColumnMeta, scalaType: ScalaType): Option[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Build a ColumnAlignment from column metadata and Scala type.
  // TODO: Check both type compatibility and nullability. If the type is
  // incompatible, set isValid=false with error about type mismatch.
  // If nullable and non-Option, set isValid=false with nullability error.
  // Otherwise isValid=true.
  // -------------------------------------------------------------------------
  def exercise3_analyzeColumn(column: ColumnMeta, scalaType: ScalaType): ColumnAlignment = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Analyze a full query against its column mappings.
  // TODO: Given SQL string, list of ColumnMetas, and list of ScalaTypes,
  // produce an AnalysisResult by analyzing each column-type pair.
  // -------------------------------------------------------------------------
  def exercise4_analyzeQuery(
    sql: String,
    columns: List[ColumnMeta],
    scalaTypes: List[ScalaType]
  ): AnalysisResult = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Check for column count mismatch.
  // TODO: If columns.size != scalaTypes.size, return Left with error message.
  // Otherwise return Right with the paired list.
  // Error: "Column count mismatch: N columns but M Scala types"
  // -------------------------------------------------------------------------
  def exercise5_checkColumnCount(
    columns: List[ColumnMeta],
    scalaTypes: List[ScalaType]
  ): Either[String, List[(ColumnMeta, ScalaType)]] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Simulate YOLO mode - execute query and print results.
  // TODO: Given a query string and sample data (list of maps), format
  // the results as a string table. Return a list of formatted row strings.
  // Format each row as "col1=val1, col2=val2, ...".
  // -------------------------------------------------------------------------
  def exercise6_yoloQuery(query: String, data: List[Map[String, Any]]): List[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement a query checker that validates parameter types.
  // TODO: Given a list of (paramIndex, sqlType) and a list of ScalaType
  // for params, produce ParamAlignment for each. Check type compatibility.
  // Error: "Param N: cannot map ScalaType to SqlType"
  // -------------------------------------------------------------------------
  def exercise7_checkParams(
    paramTypes: List[(Int, String)],
    scalaTypes: List[ScalaType]
  ): List[ParamAlignment] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Combine all checks into a comprehensive analysis report.
  // TODO: Given an AnalysisResult, format a human-readable report string.
  // Include: SQL, each column check (OK/FAIL), each param check (OK/FAIL),
  // and a summary line "Analysis: N errors found" or "Analysis: all checks passed".
  // -------------------------------------------------------------------------
  def exercise8_formatReport(analysis: AnalysisResult): String = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_isTypeCompatible("INTEGER", "Int") == true)
    assert(exercise1_isTypeCompatible("VARCHAR", "String") == true)
    assert(exercise1_isTypeCompatible("INTEGER", "String") == false)
    assert(exercise1_isTypeCompatible("UNKNOWN", "Int") == false)
    println("Exercise 1 passed: type compatibility check")

    // Exercise 2
    val nullCol = ColumnMeta("email", "VARCHAR", nullable = true)
    val nonNullCol = ColumnMeta("id", "INTEGER", nullable = false)
    assert(exercise2_checkNullability(nullCol, ScalaType("String")).isDefined)
    assert(exercise2_checkNullability(nullCol, ScalaType("String", isOption = true)).isEmpty)
    assert(exercise2_checkNullability(nonNullCol, ScalaType("Int")).isEmpty)
    assert(exercise2_checkNullability(nonNullCol, ScalaType("Int", isOption = true)).isDefined)
    println("Exercise 2 passed: nullability check")

    // Exercise 3
    val goodAlign = exercise3_analyzeColumn(ColumnMeta("id", "INTEGER", false), ScalaType("Int"))
    assert(goodAlign.isValid)
    val badAlign = exercise3_analyzeColumn(ColumnMeta("id", "INTEGER", false), ScalaType("String"))
    assert(!badAlign.isValid)
    val nullBad = exercise3_analyzeColumn(ColumnMeta("email", "VARCHAR", true), ScalaType("String"))
    assert(!nullBad.isValid)
    println("Exercise 3 passed: column analysis")

    // Exercise 4
    val analysis = exercise4_analyzeQuery(
      "SELECT id, name FROM users",
      List(ColumnMeta("id", "INTEGER", false), ColumnMeta("name", "VARCHAR", false)),
      List(ScalaType("Int"), ScalaType("String"))
    )
    assert(analysis.isValid)
    println("Exercise 4 passed: query analysis")

    // Exercise 5
    val cols = List(ColumnMeta("id", "INTEGER", false), ColumnMeta("name", "VARCHAR", false))
    val types2 = List(ScalaType("Int"), ScalaType("String"))
    assert(exercise5_checkColumnCount(cols, types2).isRight)
    assert(exercise5_checkColumnCount(cols, List(ScalaType("Int"))).isLeft)
    println("Exercise 5 passed: column count check")

    // Exercise 6
    val data = List(Map[String, Any]("id" -> 1, "name" -> "Alice"), Map[String, Any]("id" -> 2, "name" -> "Bob"))
    val rows = exercise6_yoloQuery("SELECT * FROM users", data)
    assert(rows.size == 2)
    assert(rows.head.contains("id=1"))
    assert(rows.head.contains("name=Alice"))
    println("Exercise 6 passed: YOLO mode query")

    // Exercise 7
    val paramChecks = exercise7_checkParams(
      List((0, "INTEGER"), (1, "VARCHAR")),
      List(ScalaType("Int"), ScalaType("String"))
    )
    assert(paramChecks.forall(_.isValid))
    val badParams = exercise7_checkParams(
      List((0, "INTEGER")),
      List(ScalaType("String"))
    )
    assert(!badParams.head.isValid)
    println("Exercise 7 passed: parameter type checking")

    // Exercise 8
    val goodAnalysis = AnalysisResult("SELECT id FROM t", List(ColumnAlignment(ColumnMeta("id", "INTEGER", false), ScalaType("Int"), true, None)), Nil)
    val report = exercise8_formatReport(goodAnalysis)
    assert(report.contains("all checks passed"))
    val badAnalysis = AnalysisResult("SELECT id FROM t",
      List(ColumnAlignment(ColumnMeta("id", "INTEGER", false), ScalaType("String"), false, Some("type mismatch"))), Nil)
    val badReport = exercise8_formatReport(badAnalysis)
    assert(badReport.contains("1 errors found"))
    println("Exercise 8 passed: format analysis report")

    println("\nAll Doob008_Testing exercises passed!")
  }
}
