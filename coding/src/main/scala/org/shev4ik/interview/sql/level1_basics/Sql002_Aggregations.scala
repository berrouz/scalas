package org.shev4ik.interview.sql.level1_basics

/**
 * SQL Aggregations -- GROUP BY, HAVING, and Aggregate Functions
 *
 * =Theory=
 *
 * '''Aggregate functions''' compute a single result from a set of rows:
 *   - `COUNT(*)` -- counts all rows (including NULLs).
 *   - `COUNT(column)` -- counts non-NULL values in that column.
 *   - `COUNT(DISTINCT column)` -- counts distinct non-NULL values.
 *   - `SUM(column)` -- total of numeric values (ignores NULLs).
 *   - `AVG(column)` -- average of numeric values (ignores NULLs in both sum and count).
 *   - `MIN(column)` / `MAX(column)` -- smallest/largest value (works on numbers, strings, dates).
 *
 * '''GROUP BY''' partitions rows into groups based on one or more columns. Each group produces
 * one output row. Every column in SELECT must either be in GROUP BY or wrapped in an aggregate.
 *
 * '''HAVING''' filters groups '''after''' aggregation (WHERE filters rows '''before''' aggregation).
 * Rule of thumb: use WHERE for row-level conditions, HAVING for aggregate conditions.
 *
 * =SQL execution order (logical)=
 * {{{
 *   FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT
 * }}}
 * This is why you cannot use column aliases from SELECT in WHERE or HAVING (in standard SQL).
 *
 * =NULL handling in aggregations=
 *   - All aggregate functions except `COUNT(*)` ignore NULL values.
 *   - `SUM` of all NULLs returns NULL (not 0). Use `COALESCE(SUM(col), 0)` to handle this.
 *   - `AVG` divides by count of non-NULL values, not total rows.
 *   - `GROUP BY` treats all NULLs as a single group.
 *
 * =Interview Tips=
 *   - "COUNT(*) vs COUNT(column) -- COUNT(*) counts all rows, COUNT(column) excludes NULLs."
 *     This is one of the most frequently asked SQL trivia questions.
 *   - Know the difference between WHERE and HAVING. A common mistake is using HAVING without
 *     GROUP BY (it still works but applies to the entire result as one group).
 *   - When asked about "top N per group", think of window functions (ROW_NUMBER, RANK)
 *     combined with GROUP BY -- this is a common follow-up.
 *   - `GROUP BY 1, 2` is shorthand for grouping by the first and second SELECT columns.
 *     It works in PostgreSQL and MySQL but is not standard SQL.
 *   - For performance: GROUP BY can be expensive on large tables. Indexes on the grouped
 *     columns help. Pre-aggregation (materialized views) is a common optimization.
 */
object Sql002_Aggregations {

  // Schema:
  // CREATE TABLE orders (
  //   id SERIAL PRIMARY KEY,
  //   customer_id INT NOT NULL,
  //   product TEXT NOT NULL,
  //   category TEXT NOT NULL,
  //   amount DECIMAL(10,2),
  //   quantity INT,
  //   order_date DATE
  // );
  //
  // Sample data - orders:
  // | id | customer_id | product      | category    | amount  | quantity | order_date |
  // |----|-------------|--------------|-------------|---------|----------|------------|
  // | 1  | 101         | Laptop       | Electronics | 1200.00 | 1        | 2024-01-15 |
  // | 2  | 102         | Phone        | Electronics | 800.00  | 2        | 2024-01-20 |
  // | 3  | 101         | Desk Chair   | Furniture   | 350.00  | 1        | 2024-02-10 |
  // | 4  | 103         | Monitor      | Electronics | 450.00  | 3        | 2024-02-15 |
  // | 5  | 102         | Bookshelf    | Furniture   | 200.00  | 2        | 2024-03-01 |
  // | 6  | 104         | Keyboard     | Electronics | 75.00   | 5        | 2024-03-10 |
  // | 7  | 103         | Standing Desk| Furniture   | 600.00  | 1        | 2024-03-15 |
  // | 8  | 101         | Headphones   | Electronics | 150.00  | 2        | 2024-03-20 |

  // Exercise 1: COUNT
  // TODO: Write a SQL query that returns the total number of orders
  // Expected: 8
  val exercise1: String = ???

  // Exercise 2: SUM
  // TODO: Write a SQL query that returns the total amount across all orders
  // Expected: 3825.00
  val exercise2: String = ???

  // Exercise 3: AVG
  // TODO: Write a SQL query that returns the average order amount
  // Expected: 478.125
  val exercise3: String = ???

  // Exercise 4: MIN and MAX
  // TODO: Write a SQL query that returns the minimum and maximum order amounts in a single query
  // Expected: min=75.00, max=1200.00
  val exercise4: String = ???

  // Exercise 5: GROUP BY
  // TODO: Write a SQL query that returns the total amount per category
  // Expected: Electronics=2675.00, Furniture=1150.00
  val exercise5: String = ???

  // Exercise 6: HAVING
  // TODO: Write a SQL query that returns categories where the total amount exceeds 1500
  // Expected: Electronics (2675.00)
  val exercise6: String = ???

  // Exercise 7: GROUP BY with COUNT
  // TODO: Write a SQL query that returns customers who placed more than 1 order,
  //       showing customer_id and order count, ordered by count DESC
  // Expected: customer_id=101 (3 orders), customer_id=102 (2 orders), customer_id=103 (2 orders)
  val exercise7: String = ???

  // Exercise 8: GROUP BY multiple columns
  // TODO: Write a SQL query that returns the total amount and order count
  //       grouped by both category and the month of order_date (use EXTRACT or DATE_TRUNC)
  //       Order by category, then month
  // Expected: Electronics/Jan=2000, Electronics/Feb=450, Electronics/Mar=225,
  //           Furniture/Feb=350, Furniture/Mar=800
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (COUNT):                $exercise1")
    println(s"Exercise 2 (SUM):                  $exercise2")
    println(s"Exercise 3 (AVG):                  $exercise3")
    println(s"Exercise 4 (MIN/MAX):              $exercise4")
    println(s"Exercise 5 (GROUP BY):             $exercise5")
    println(s"Exercise 6 (HAVING):               $exercise6")
    println(s"Exercise 7 (GROUP BY + COUNT):     $exercise7")
    println(s"Exercise 8 (GROUP BY multi):       $exercise8")
    println("All Sql002_Aggregations exercises defined!")
  }
}
