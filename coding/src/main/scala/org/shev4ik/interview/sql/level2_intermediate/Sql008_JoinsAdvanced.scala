package org.shev4ik.interview.sql.level2_intermediate

object Sql008_JoinsAdvanced {

  // Schema:
  // CREATE TABLE employees (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   dept_id INT,
  //   salary DECIMAL(10,2),
  //   hire_date DATE,
  //   skills TEXT[]  -- PostgreSQL array type
  // );
  //
  // CREATE TABLE departments (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   location TEXT
  // );
  //
  // CREATE TABLE quarterly_sales (
  //   id SERIAL PRIMARY KEY,
  //   employee_id INT REFERENCES employees(id),
  //   quarter TEXT NOT NULL,   -- 'Q1', 'Q2', 'Q3', 'Q4'
  //   year INT NOT NULL,
  //   amount DECIMAL(10,2)
  // );
  //
  // Sample data - employees:
  // | id | name          | dept_id | salary   | hire_date  | skills                  |
  // |----|---------------|---------|----------|------------|-------------------------|
  // | 1  | Alice Johnson | 1       | 95000.00 | 2019-03-15 | {scala,java,sql}        |
  // | 2  | Bob Smith     | 1       | 82000.00 | 2020-07-22 | {python,sql}            |
  // | 3  | Carol White   | 2       | 88000.00 | 2018-01-10 | {marketing,analytics}   |
  // | 4  | Dave Brown    | 2       | 72000.00 | 2021-11-05 | {marketing,design}      |
  // | 5  | Eve Davis     | NULL    | 65000.00 | 2022-02-28 | {sales,sql}             |
  //
  // Sample data - departments:
  // | id | name        | location |
  // |----|-------------|----------|
  // | 1  | Engineering | NYC      |
  // | 2  | Marketing   | Chicago  |
  // | 3  | Sales       | LA       |
  //
  // Sample data - quarterly_sales:
  // | id | employee_id | quarter | year | amount   |
  // |----|-------------|---------|------|----------|
  // | 1  | 1           | Q1      | 2024 | 50000.00 |
  // | 2  | 1           | Q2      | 2024 | 65000.00 |
  // | 3  | 2           | Q1      | 2024 | 40000.00 |
  // | 4  | 3           | Q1      | 2024 | 55000.00 |
  // | 5  | 3           | Q2      | 2024 | 70000.00 |
  // | 6  | 3           | Q3      | 2024 | 45000.00 |

  // Exercise 1: LATERAL join
  // TODO: Write a SQL query using LATERAL join to get the top 2 highest quarterly sales
  //       for each employee. Return employee name, quarter, year, amount.
  //       Use: FROM employees e, LATERAL (SELECT ... FROM quarterly_sales WHERE employee_id = e.id
  //            ORDER BY amount DESC LIMIT 2) AS top_sales
  // Expected: Alice(Q2:65000, Q1:50000), Carol(Q2:70000, Q1:55000), Bob(Q1:40000)
  val exercise1: String = ???

  // Exercise 2: Self join pattern - find pairs
  // TODO: Write a SQL query that finds all pairs of employees in the same department
  //       where one earns more than the other. Return higher_earner, lower_earner, dept_id, salary_diff.
  //       Avoid duplicate pairs (e1.id < e2.id).
  // Expected: (Alice, Bob, dept 1, 13000), (Carol, Dave, dept 2, 16000)
  val exercise2: String = ???

  // Exercise 3: Anti join (LEFT JOIN WHERE NULL)
  // TODO: Write a SQL query that finds departments with no employees.
  //       Use LEFT JOIN ... WHERE e.id IS NULL pattern (anti join).
  // Expected: Sales (dept 3)
  val exercise3: String = ???

  // Exercise 4: Semi join (EXISTS-based)
  // TODO: Write a SQL query that returns departments that have at least one employee
  //       with salary > 80000. Use EXISTS (semi join pattern).
  //       Return department id and name.
  // Expected: Engineering (Alice 95000, Bob 82000), Marketing (Carol 88000)
  val exercise4: String = ???

  // Exercise 5: CROSS JOIN with generate_series
  // TODO: Write a SQL query that generates a report grid: every employee crossed with
  //       every month in 2024 (Jan-Dec). Use generate_series to create months.
  //       Return employee_name, month_date.
  //       Use: CROSS JOIN generate_series('2024-01-01'::date, '2024-12-01'::date, '1 month') AS m(month_date)
  // Expected: 60 rows (5 employees x 12 months)
  val exercise5: String = ???

  // Exercise 6: Hierarchical join with path
  // TODO: Write a recursive CTE + join query that builds a management path for each employee.
  //       Assume employees has a manager_id column (use dept_id as pseudo-manager for this exercise).
  //       Build a path string like 'CEO > VP > Manager > Employee'.
  //       Use: string_agg or || for path concatenation in the recursive CTE.
  //       Return employee name and full management path.
  // Note: For this exercise, assume manager_id column exists referencing employees(id).
  // Expected: Tree paths from root to leaf
  val exercise6: String = ???

  // Exercise 7: Pivot with CASE (crosstab)
  // TODO: Write a SQL query that pivots quarterly_sales into columns.
  //       Return one row per employee with columns: name, q1_amount, q2_amount, q3_amount, q4_amount.
  //       Use CASE WHEN quarter = 'Q1' THEN amount END inside aggregation.
  //       NULL for missing quarters.
  // Expected: Alice(50000, 65000, NULL, NULL), Bob(40000, NULL, NULL, NULL),
  //           Carol(55000, 70000, 45000, NULL)
  val exercise7: String = ???

  // Exercise 8: Unpivot (using LATERAL + VALUES)
  // TODO: Given a table with pivoted data, write a SQL query to unpivot it.
  //       Use LATERAL with a VALUES clause to turn columns into rows.
  //       Assume a table: CREATE TABLE summary (emp_name TEXT, q1 DECIMAL, q2 DECIMAL, q3 DECIMAL, q4 DECIMAL);
  //       Return emp_name, quarter, amount (excluding NULL amounts).
  //       Use: CROSS JOIN LATERAL (VALUES ('Q1', q1), ('Q2', q2), ('Q3', q3), ('Q4', q4)) AS u(quarter, amount)
  // Expected: One row per non-null quarter per employee
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (LATERAL join):       $exercise1")
    println(s"Exercise 2 (Self join pairs):    $exercise2")
    println(s"Exercise 3 (Anti join):          $exercise3")
    println(s"Exercise 4 (Semi join):          $exercise4")
    println(s"Exercise 5 (CROSS + series):     $exercise5")
    println(s"Exercise 6 (Hierarchical join):  $exercise6")
    println(s"Exercise 7 (Pivot CASE):         $exercise7")
    println(s"Exercise 8 (Unpivot LATERAL):    $exercise8")
    println("All Sql008_JoinsAdvanced exercises defined!")
  }
}
