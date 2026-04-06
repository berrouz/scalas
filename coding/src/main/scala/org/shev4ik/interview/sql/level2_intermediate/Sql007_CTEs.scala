package org.shev4ik.interview.sql.level2_intermediate

object Sql007_CTEs {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   manager_id INT REFERENCES employees(id),
  //   dept_id INT,
  //   salary DECIMAL(10,2),
  //   hire_date DATE
  // );
  //
  // CREATE TABLE departments (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL
  // );
  //
  // Sample data - employees:
  // | id | name          | manager_id | dept_id | salary   | hire_date  |
  // |----|---------------|------------|---------|----------|------------|
  // | 1  | CEO Alice     | NULL       | 1       | 150000.00| 2015-01-01 |
  // | 2  | VP Bob        | 1          | 1       | 120000.00| 2016-03-15 |
  // | 3  | VP Carol      | 1          | 2       | 115000.00| 2016-06-01 |
  // | 4  | Mgr Dave      | 2          | 1       | 95000.00 | 2018-02-10 |
  // | 5  | Mgr Eve       | 2          | 1       | 92000.00 | 2018-07-22 |
  // | 6  | Dev Frank     | 4          | 1       | 82000.00 | 2020-01-15 |
  // | 7  | Dev Grace     | 4          | 1       | 78000.00 | 2020-04-01 |
  // | 8  | Mkt Henry     | 3          | 2       | 75000.00 | 2019-09-01 |
  // | 9  | Mkt Iris      | 3          | 2       | 72000.00 | 2021-01-10 |
  // | 10 | Dev Jack      | 5          | 1       | 80000.00 | 2022-03-01 |
  //
  // Sample data - departments:
  // | id | name        |
  // |----|-------------|
  // | 1  | Engineering |
  // | 2  | Marketing   |

  // Exercise 1: Basic CTE
  // TODO: Write a SQL query using a CTE that first calculates the average salary per department,
  //       then selects employees who earn more than their department's average.
  //       Return employee name, salary, dept_id, dept_avg_salary.
  // Expected: CEO Alice, VP Bob, Mgr Dave, Dev Jack (above Engineering avg),
  //           VP Carol, Mkt Henry (above Marketing avg)
  val exercise1: String = ???

  // Exercise 2: Multiple CTEs
  // TODO: Write a SQL query with two CTEs:
  //       1) dept_stats: avg salary and employee count per department
  //       2) top_earners: employees earning above overall average
  //       Then join them to show top earners with their department stats.
  //       Return name, salary, dept_name, dept_avg, dept_count.
  // Expected: Employees with salary > overall avg (~95900), joined with dept stats
  val exercise2: String = ???

  // Exercise 3: Recursive CTE - hierarchy
  // TODO: Write a recursive CTE that builds the full org chart starting from the CEO (manager_id IS NULL).
  //       Include a 'level' column indicating depth (CEO=0, VPs=1, Mgrs=2, etc.)
  //       Return name, manager_id, level. Order by level, then name.
  // Expected: Alice(0), Bob(1), Carol(1), Dave(2), Eve(2), Henry(2), Iris(2), Frank(3), Grace(3), Jack(3)
  val exercise3: String = ???

  // Exercise 4: Recursive CTE - generate series
  // TODO: Write a recursive CTE that generates a series of dates from '2024-01-01' to '2024-01-10'.
  //       Return each date as a row.
  // Expected: 10 rows, one per date from Jan 1 to Jan 10
  val exercise4: String = ???

  // Exercise 5: CTE with aggregation
  // TODO: Write a CTE that calculates each manager's total team salary (sum of direct reports' salaries),
  //       then return managers whose team salary exceeds 150000.
  //       Return manager name, team_salary, team_size.
  // Expected: VP Bob (team: Dave 95000 + Eve 92000 + Frank 82000 + Grace 78000 + Jack 80000)
  //           Note: only direct reports, not transitive
  val exercise5: String = ???

  // Exercise 6: CTE with window function
  // TODO: Write a CTE that ranks employees within each department by salary DESC,
  //       then select only the top 2 earners per department from the CTE.
  //       Return name, dept_id, salary, rank.
  // Expected: Engineering: Alice(1), Bob(2); Marketing: Carol(1), Henry(2)
  val exercise6: String = ???

  // Exercise 7: CTE for deduplication
  // TODO: Assume the employees table may have duplicate rows (same name, dept_id, salary).
  //       Write a CTE using ROW_NUMBER() OVER (PARTITION BY name, dept_id ORDER BY id)
  //       to identify duplicates, then select only the first occurrence of each.
  //       Return all columns of the deduplicated employees.
  // Expected: All unique employees (in this sample, all are unique, but the pattern matters)
  val exercise7: String = ???

  // Exercise 8: MATERIALIZED CTE hint (PostgreSQL 12+)
  // TODO: Write a query with a CTE using the MATERIALIZED keyword.
  //       The CTE should compute expensive aggregation (avg salary per dept),
  //       and it should be referenced multiple times in the main query.
  //       Use: WITH dept_avg AS MATERIALIZED (...)
  //       Compare employees to their dept avg and the overall avg from the same CTE.
  // Expected: Each employee with dept_avg and overall_avg columns
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (Basic CTE):          $exercise1")
    println(s"Exercise 2 (Multiple CTEs):      $exercise2")
    println(s"Exercise 3 (Recursive hierarchy): $exercise3")
    println(s"Exercise 4 (Recursive series):   $exercise4")
    println(s"Exercise 5 (CTE + aggregation):  $exercise5")
    println(s"Exercise 6 (CTE + window):       $exercise6")
    println(s"Exercise 7 (CTE dedup):          $exercise7")
    println(s"Exercise 8 (MATERIALIZED CTE):   $exercise8")
    println("All Sql007_CTEs exercises defined!")
  }
}
