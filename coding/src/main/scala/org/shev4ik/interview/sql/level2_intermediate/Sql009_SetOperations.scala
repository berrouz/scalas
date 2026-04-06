package org.shev4ik.interview.sql.level2_intermediate

object Sql009_SetOperations {

  // Schema:
  // CREATE TABLE current_employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept TEXT NOT NULL,
  //   salary DECIMAL(10,2)
  // );
  //
  // CREATE TABLE former_employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept TEXT NOT NULL,
  //   salary DECIMAL(10,2),
  //   left_date DATE
  // );
  //
  // CREATE TABLE job_applicants (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   desired_dept TEXT NOT NULL,
  //   expected_salary DECIMAL(10,2)
  // );
  //
  // Sample data - current_employees:
  // | id | name          | dept        | salary   |
  // |----|---------------|-------------|----------|
  // | 1  | Alice Johnson | Engineering | 95000.00 |
  // | 2  | Bob Smith     | Engineering | 82000.00 |
  // | 3  | Carol White   | Marketing   | 88000.00 |
  // | 4  | Dave Brown    | Sales       | 72000.00 |
  //
  // Sample data - former_employees:
  // | id | name          | dept        | salary   | left_date  |
  // |----|---------------|-------------|----------|------------|
  // | 1  | Eve Davis     | Engineering | 78000.00 | 2023-06-15 |
  // | 2  | Alice Johnson | Marketing   | 75000.00 | 2019-01-10 |
  // | 3  | Frank Miller  | Sales       | 68000.00 | 2022-11-30 |
  // | 4  | Bob Smith     | Engineering | 70000.00 | 2018-03-01 |
  //
  // Sample data - job_applicants:
  // | id | name          | desired_dept | expected_salary |
  // |----|---------------|--------------|-----------------|
  // | 1  | Grace Lee     | Engineering  | 90000.00        |
  // | 2  | Alice Johnson | Engineering  | 100000.00       |
  // | 3  | Henry Wilson  | Marketing    | 80000.00        |
  // | 4  | Eve Davis     | Engineering  | 85000.00        |

  // Exercise 1: UNION (remove duplicates)
  // TODO: Write a SQL query that returns all unique person names who are either
  //       current employees or former employees. Use UNION to remove duplicates.
  //       Return just the name column.
  // Expected: Alice Johnson, Bob Smith, Carol White, Dave Brown, Eve Davis, Frank Miller
  val exercise1: String = ???

  // Exercise 2: UNION ALL (keep duplicates)
  // TODO: Write a SQL query that returns all person names from both current and former
  //       employees, keeping duplicates. Use UNION ALL.
  //       Return name and a source column ('current' or 'former').
  // Expected: 8 rows total (4 current + 4 former), including duplicates Alice, Bob
  val exercise2: String = ???

  // Exercise 3: INTERSECT
  // TODO: Write a SQL query that finds names that appear in both current_employees
  //       and former_employees (people who left and came back). Use INTERSECT.
  //       Return just the name column.
  // Expected: Alice Johnson, Bob Smith
  val exercise3: String = ???

  // Exercise 4: EXCEPT
  // TODO: Write a SQL query that finds names of current employees who were never
  //       former employees. Use EXCEPT.
  //       Return just the name column.
  // Expected: Carol White, Dave Brown
  val exercise4: String = ???

  // Exercise 5: Set operations with ORDER BY
  // TODO: Write a SQL query combining current employees and applicants using UNION,
  //       then ordering the combined result by name ASC.
  //       Return name and dept/desired_dept (aliased as 'department').
  //       Note: ORDER BY applies to the final result of UNION.
  // Expected: Sorted list of unique names from both tables
  val exercise5: String = ???

  // Exercise 6: UNION with CTE
  // TODO: Write a query using CTEs that:
  //       1) CTE all_people: UNION ALL of current, former, and applicant names with a 'source' label
  //       2) Main query: count how many times each name appears across all sources
  //       Return name and appearance_count, ordered by count DESC.
  // Expected: Alice Johnson(3), Bob Smith(2), Eve Davis(2), others(1)
  val exercise6: String = ???

  // Exercise 7: Set operations with aggregation
  // TODO: Write a SQL query that computes average salary per department from current employees,
  //       UNION ALL with average salary per department from former employees.
  //       Include a 'status' column ('current' or 'former').
  //       Return dept, status, avg_salary. Order by dept, status.
  // Expected: Engineering/current(88500), Engineering/former(74000),
  //           Marketing/current(88000), Marketing/former(75000),
  //           Sales/current(72000), Sales/former(68000)
  val exercise7: String = ???

  // Exercise 8: Set operations performance - EXISTS vs IN vs JOIN
  // TODO: Write THREE equivalent SQL queries that find current employees who are also applicants,
  //       concatenated as a single string separated by '---'.
  //       a) Using INTERSECT on names
  //       b) Using EXISTS with correlated subquery
  //       c) Using IN with subquery
  //       Discuss in comments which is typically most efficient for large datasets.
  // Expected: Alice Johnson (appears in both current_employees and job_applicants)
  // Note: In PostgreSQL, EXISTS is generally fastest for large datasets as it short-circuits.
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (UNION):              $exercise1")
    println(s"Exercise 2 (UNION ALL):          $exercise2")
    println(s"Exercise 3 (INTERSECT):          $exercise3")
    println(s"Exercise 4 (EXCEPT):             $exercise4")
    println(s"Exercise 5 (ORDER BY):           $exercise5")
    println(s"Exercise 6 (UNION + CTE):        $exercise6")
    println(s"Exercise 7 (Set + aggregation):  $exercise7")
    println(s"Exercise 8 (Performance):        $exercise8")
    println("All Sql009_SetOperations exercises defined!")
  }
}
