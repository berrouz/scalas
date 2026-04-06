package org.shev4ik.interview.doobie.level3_advanced

/**
 * Doobie 012 - Advanced Queries (CTEs, window functions, JSON columns)
 *
 * Doobie supports any valid SQL, including CTEs (WITH clauses), window functions
 * (ROW_NUMBER, RANK, etc.), and JSON operations. These are passed through
 * the sql interpolator and mapped to Scala types.
 *
 * Here we model these SQL patterns in Scala to understand how complex queries
 * map to result types in doobie.
 */
object Doob012_AdvancedQueries {

  type Row = Map[String, Any]
  type Table = List[Row]

  // Sample data
  val employees: Table = List(
    Map("id" -> 1, "name" -> "Alice", "dept" -> "Engineering", "salary" -> 120000, "hire_date" -> "2020-01-15"),
    Map("id" -> 2, "name" -> "Bob", "dept" -> "Engineering", "salary" -> 110000, "hire_date" -> "2019-06-01"),
    Map("id" -> 3, "name" -> "Charlie", "dept" -> "Marketing", "salary" -> 95000, "hire_date" -> "2021-03-10"),
    Map("id" -> 4, "name" -> "Diana", "dept" -> "Marketing", "salary" -> 98000, "hire_date" -> "2020-09-20"),
    Map("id" -> 5, "name" -> "Eve", "dept" -> "Engineering", "salary" -> 130000, "hire_date" -> "2018-02-28"),
    Map("id" -> 6, "name" -> "Frank", "dept" -> "Sales", "salary" -> 85000, "hire_date" -> "2022-01-05")
  )

  val orders: Table = List(
    Map("id" -> 1, "customer" -> "Alice", "amount" -> 100.0, "date" -> "2023-01-01"),
    Map("id" -> 2, "customer" -> "Bob", "amount" -> 200.0, "date" -> "2023-01-02"),
    Map("id" -> 3, "customer" -> "Alice", "amount" -> 150.0, "date" -> "2023-01-03"),
    Map("id" -> 4, "customer" -> "Charlie", "amount" -> 300.0, "date" -> "2023-01-04"),
    Map("id" -> 5, "customer" -> "Alice", "amount" -> 50.0, "date" -> "2023-01-05"),
    Map("id" -> 6, "customer" -> "Bob", "amount" -> 175.0, "date" -> "2023-01-06")
  )

  case class RankedEmployee(name: String, dept: String, salary: Int, rankInDept: Int)
  case class RunningTotal(customer: String, amount: Double, runningSum: Double)
  case class DeptSummary(dept: String, avgSalary: Double, employeeCount: Int)
  case class JsonUser(id: Int, name: String, metadata: Map[String, String])

  // -------------------------------------------------------------------------
  // Exercise 1: Implement ROW_NUMBER window function - rank employees by salary within dept.
  // TODO: For each department, assign a rank (1-based) by salary descending.
  // Return List[RankedEmployee] sorted by dept then rank.
  // -------------------------------------------------------------------------
  def exercise1_rowNumberByDept: List[RankedEmployee] = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Implement running total (cumulative sum) window function.
  // TODO: For each customer, compute a running sum of amounts ordered by date.
  // Return List[RunningTotal] in date order.
  // -------------------------------------------------------------------------
  def exercise2_runningTotal: List[RunningTotal] = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Implement a CTE (WITH clause) pattern.
  // TODO: Step 1 - compute average salary per department (like a CTE)
  // Step 2 - find employees earning above their department average
  // Return list of (name, salary, deptAvg) tuples.
  // -------------------------------------------------------------------------
  def exercise3_cteAboveAverage: List[(String, Int, Double)] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Implement DENSE_RANK window function.
  // TODO: Rank all employees by salary globally (descending). Same salary
  // gets same rank, next rank is not skipped. Return List[(String, Int, Int)]
  // as (name, salary, denseRank).
  // -------------------------------------------------------------------------
  def exercise4_denseRank: List[(String, Int, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Implement a recursive CTE pattern (e.g., hierarchy).
  // TODO: Given an adjacency list of (id, parentId, name), flatten the
  // hierarchy into (id, name, depth, path) tuples using recursive traversal.
  // -------------------------------------------------------------------------
  val hierarchy: List[(Int, Option[Int], String)] = List(
    (1, None, "CEO"),
    (2, Some(1), "VP Engineering"),
    (3, Some(1), "VP Marketing"),
    (4, Some(2), "Lead Dev"),
    (5, Some(2), "Senior Dev"),
    (6, Some(3), "Marketing Manager")
  )

  def exercise5_recursiveCte: List[(Int, String, Int, String)] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Simulate JSON column extraction.
  // TODO: Given rows with a "metadata" column containing key=value pairs
  // (semicolon-separated string like "role=admin;theme=dark"), parse into
  // Map[String, String] and return JsonUser objects.
  // -------------------------------------------------------------------------
  val jsonRows: Table = List(
    Map("id" -> 1, "name" -> "Alice", "metadata" -> "role=admin;theme=dark"),
    Map("id" -> 2, "name" -> "Bob", "metadata" -> "role=user;theme=light"),
    Map("id" -> 3, "name" -> "Charlie", "metadata" -> "role=user;theme=dark;lang=en")
  )

  def exercise6_parseJsonColumn: List[JsonUser] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Implement PARTITION BY with aggregate (department summary).
  // TODO: Compute DeptSummary for each department: avg salary and count.
  // Return sorted by department name.
  // -------------------------------------------------------------------------
  def exercise7_deptSummary: List[DeptSummary] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement LAG/LEAD window function concept.
  // TODO: For orders sorted by date, compute the difference in amount
  // from the previous order (LAG). First order has diff = 0.
  // Return List[(String, Double, Double)] as (customer, amount, diffFromPrev).
  // -------------------------------------------------------------------------
  def exercise8_lagDifference: List[(String, Double, Double)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val ranked = exercise1_rowNumberByDept
    assert(ranked.nonEmpty)
    val engRanks = ranked.filter(_.dept == "Engineering")
    assert(engRanks.head.rankInDept == 1)
    assert(engRanks.head.salary >= engRanks.last.salary)
    println("Exercise 1 passed: ROW_NUMBER by department")

    // Exercise 2
    val running = exercise2_runningTotal
    assert(running.size == orders.size)
    val aliceRunning = running.filter(_.customer == "Alice")
    assert(aliceRunning.last.runningSum == 300.0) // 100 + 150 + 50
    println("Exercise 2 passed: running total")

    // Exercise 3
    val aboveAvg = exercise3_cteAboveAverage
    assert(aboveAvg.nonEmpty)
    assert(aboveAvg.forall { case (_, salary, avg) => salary > avg })
    println("Exercise 3 passed: CTE above average")

    // Exercise 4
    val denseRanked = exercise4_denseRank
    assert(denseRanked.nonEmpty)
    assert(denseRanked.head._3 == 1)
    assert(denseRanked.head._2 >= denseRanked.last._2)
    println("Exercise 4 passed: DENSE_RANK")

    // Exercise 5
    val tree = exercise5_recursiveCte
    assert(tree.size == 6)
    val ceo = tree.find(_._2 == "CEO").get
    assert(ceo._3 == 0) // depth 0
    val leadDev = tree.find(_._2 == "Lead Dev").get
    assert(leadDev._3 == 2) // depth 2
    assert(leadDev._4.contains("CEO"))
    println("Exercise 5 passed: recursive CTE hierarchy")

    // Exercise 6
    val jsonUsers = exercise6_parseJsonColumn
    assert(jsonUsers.size == 3)
    assert(jsonUsers.head.metadata("role") == "admin")
    assert(jsonUsers(2).metadata.size == 3)
    println("Exercise 6 passed: JSON column parsing")

    // Exercise 7
    val summaries = exercise7_deptSummary
    assert(summaries.size == 3) // Engineering, Marketing, Sales
    val eng = summaries.find(_.dept == "Engineering").get
    assert(eng.employeeCount == 3)
    println("Exercise 7 passed: department summary")

    // Exercise 8
    val lags = exercise8_lagDifference
    assert(lags.size == orders.size)
    assert(lags.head._3 == 0.0) // first order has no previous
    assert(lags(1)._3 == 100.0) // 200 - 100
    println("Exercise 8 passed: LAG difference")

    println("\nAll Doob012_AdvancedQueries exercises passed!")
  }
}
