package org.shev4ik.interview.sql.level3_advanced

object Sql011_Optimization {

  // Schema:
  // CREATE TABLE orders (
  //   id SERIAL PRIMARY KEY,
  //   customer_id INT NOT NULL,
  //   product_id INT NOT NULL,
  //   amount DECIMAL(10,2),
  //   order_date TIMESTAMPTZ,
  //   status TEXT DEFAULT 'pending'
  // );
  //
  // CREATE TABLE customers (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   email TEXT UNIQUE,
  //   region TEXT,
  //   created_at TIMESTAMPTZ
  // );
  //
  // CREATE TABLE products (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   category TEXT,
  //   price DECIMAL(10,2)
  // );
  //
  // Assume large tables: orders (~10M rows), customers (~1M rows), products (~100K rows)
  // Existing indexes: PKs on all id columns, unique on customers(email)

  // Exercise 1: Query plan reading
  // TODO: Write SQL using EXPLAIN (ANALYZE, COSTS, BUFFERS, TIMING) to analyze a query
  //       that finds the top 10 customers by total order amount.
  //       Include comments about what each part of the plan means.
  // Key things to look for in output:
  //   - "Sort" node with "Sort Method: top-N heapsort" (good for LIMIT)
  //   - "HashAggregate" for GROUP BY
  //   - Planning Time vs Execution Time
  //   - "Rows Removed by Filter" (indicates inefficiency if high)
  val exercise1: String = ???

  // Exercise 2: Sequential scan vs index scan
  // TODO: Write TWO queries and explain when PostgreSQL chooses each:
  //       a) A query that will likely use a sequential scan (selecting most rows)
  //       b) A query that will likely use an index scan (selecting few rows)
  //       Include the EXPLAIN for both. Add comments explaining the cost threshold.
  // Hint: PostgreSQL uses seq scan when >5-10% of table is selected (random_page_cost factor)
  // Expected: Two EXPLAIN + SELECT pairs with comments
  val exercise2: String = ???

  // Exercise 3: Nested loop vs hash join
  // TODO: Write TWO queries that demonstrate different join strategies:
  //       a) A query likely to use Nested Loop (small driving table, indexed lookup)
  //       b) A query likely to use Hash Join (larger tables, no useful index)
  //       Wrap each in EXPLAIN ANALYZE. Add comments on when the optimizer picks each.
  // Hint: Nested Loop: O(n*m) but fast with index; Hash Join: O(n+m) build+probe
  // Expected: Two EXPLAIN ANALYZE + SELECT pairs
  val exercise3: String = ???

  // Exercise 4: Merge join
  // TODO: Write a SQL query that is likely to produce a Merge Join plan.
  //       Merge joins work on pre-sorted input (both sides ordered by join key).
  //       Include EXPLAIN ANALYZE. Add comments explaining when merge join is chosen.
  // Hint: Merge Join chosen when both inputs are already sorted (e.g., index scan on join column)
  //       or when sort cost is low relative to hash table build cost.
  // Expected: EXPLAIN ANALYZE for a join that uses Merge Join
  val exercise4: String = ???

  // Exercise 5: Bitmap scan
  // TODO: Write a SQL query that is likely to produce a Bitmap Index Scan + Bitmap Heap Scan.
  //       This happens when multiple index conditions are ORed, or when selectivity
  //       is too low for an index scan but too high for a seq scan.
  //       Include EXPLAIN ANALYZE. Add comments on how bitmap scans work.
  // Hint: Bitmap scan: index -> bitmap of pages -> heap fetch in page order (reduces random I/O)
  // Expected: EXPLAIN ANALYZE for a query using bitmap scan
  val exercise5: String = ???

  // Exercise 6: Query rewriting for performance
  // TODO: Write a "slow" query and then rewrite it for better performance. Show both versions.
  //       Example transformations:
  //       - Replace correlated subquery with JOIN
  //       - Replace NOT IN with NOT EXISTS (NULL-safe and often faster)
  //       - Push predicates into subqueries
  //       Return both the slow and fast versions as a single string.
  // Expected: -- SLOW: ... -- FAST: ...
  val exercise6: String = ???

  // Exercise 7: Materialized view
  // TODO: Write SQL to:
  //       a) Create a materialized view for a complex aggregation (monthly sales by region)
  //       b) Create a unique index on it (required for CONCURRENTLY refresh)
  //       c) Refresh it concurrently (non-blocking)
  //       d) Query it
  //       Return all four statements.
  // Hint: REFRESH MATERIALIZED VIEW CONCURRENTLY requires a unique index
  // Expected: CREATE MATERIALIZED VIEW, CREATE UNIQUE INDEX, REFRESH, SELECT
  val exercise7: String = ???

  // Exercise 8: Statistics and ANALYZE
  // TODO: Write SQL to:
  //       a) Run ANALYZE on the orders table to update statistics
  //       b) Check current statistics for a column using pg_stats
  //       c) Increase statistics target for a specific column (for better estimates)
  //       d) Check estimated row counts vs actual with EXPLAIN ANALYZE
  //       Include comments about why accurate statistics matter for query planning.
  // Hint: Default statistics target is 100; increase for columns with many distinct values
  //       or skewed distribution. Bad estimates lead to wrong join strategies and sort methods.
  // Expected: ANALYZE, pg_stats query, ALTER TABLE SET STATISTICS, EXPLAIN ANALYZE
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (Query plan):         $exercise1")
    println(s"Exercise 2 (Seq vs Index scan):  $exercise2")
    println(s"Exercise 3 (NL vs Hash join):    $exercise3")
    println(s"Exercise 4 (Merge join):         $exercise4")
    println(s"Exercise 5 (Bitmap scan):        $exercise5")
    println(s"Exercise 6 (Query rewriting):    $exercise6")
    println(s"Exercise 7 (Materialized view):  $exercise7")
    println(s"Exercise 8 (Statistics):         $exercise8")
    println("All Sql011_Optimization exercises defined!")
  }
}
