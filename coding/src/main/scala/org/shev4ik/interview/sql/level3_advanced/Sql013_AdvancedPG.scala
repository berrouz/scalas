package org.shev4ik.interview.sql.level3_advanced

object Sql013_AdvancedPG {

  // Schema:
  // CREATE TABLE orders (
  //   id SERIAL PRIMARY KEY,
  //   customer_id INT NOT NULL,
  //   amount DECIMAL(10,2),
  //   order_date DATE NOT NULL,
  //   region TEXT NOT NULL,
  //   status TEXT DEFAULT 'pending'
  // );
  //
  // CREATE TABLE audit_log (
  //   id SERIAL PRIMARY KEY,
  //   table_name TEXT,
  //   operation TEXT,
  //   old_data JSONB,
  //   new_data JSONB,
  //   changed_at TIMESTAMPTZ DEFAULT NOW(),
  //   changed_by TEXT
  // );
  //
  // Assume orders table has millions of rows spanning years 2020-2025,
  // regions: 'US-East', 'US-West', 'EU', 'APAC'

  // Exercise 1: Table partitioning - RANGE
  // TODO: Write SQL to create a range-partitioned orders table by order_date (yearly partitions).
  //       Include the parent table definition and partition definitions for 2023, 2024, 2025.
  //       Also show how to attach a new partition for 2026.
  // Hint: CREATE TABLE orders (...) PARTITION BY RANGE (order_date);
  //       CREATE TABLE orders_2024 PARTITION OF orders FOR VALUES FROM ('2024-01-01') TO ('2025-01-01');
  // Expected: Parent table + 3 partitions + ALTER TABLE ATTACH PARTITION
  val exercise1: String = ???

  // Exercise 2: Table partitioning - LIST and HASH
  // TODO: Write SQL to:
  //       a) Create a list-partitioned orders table by region
  //       b) Create a hash-partitioned orders table by customer_id (4 partitions)
  //       Include comments explaining when to use each partitioning strategy.
  // Hint: LIST for discrete values (region, status), HASH for even distribution (customer_id)
  //       RANGE for temporal data (dates), composite for multi-dimensional
  // Expected: Two CREATE TABLE sets (list and hash) with partition definitions
  val exercise2: String = ???

  // Exercise 3: Materialized views with refresh strategies
  // TODO: Write SQL to:
  //       a) Create a materialized view: monthly_revenue (month, region, total_amount, order_count)
  //       b) Create a unique index on it (for CONCURRENTLY refresh)
  //       c) Refresh concurrently
  //       d) Write a function that auto-refreshes when data changes (or use pg_cron hint)
  //       Include comments on refresh strategies: manual, trigger-based, pg_cron scheduled.
  // Expected: CREATE MATERIALIZED VIEW, CREATE UNIQUE INDEX, REFRESH, scheduling hint
  val exercise3: String = ???

  // Exercise 4: Triggers
  // TODO: Write SQL to create a trigger that:
  //       a) Logs all INSERT, UPDATE, DELETE operations on the orders table to audit_log
  //       b) The trigger function captures OLD and NEW row data as JSONB
  //       c) The trigger fires AFTER each row modification
  //       Include the trigger function and the trigger definition.
  // Hint: Use TG_OP to detect operation type, row_to_json()::jsonb for conversion
  // Expected: CREATE FUNCTION audit_trigger_fn(), CREATE TRIGGER audit_orders
  val exercise4: String = ???

  // Exercise 5: Stored functions (PL/pgSQL)
  // TODO: Write SQL to create a stored function that:
  //       a) Takes a customer_id and date range as parameters
  //       b) Returns a TABLE with monthly order summaries (month, total_amount, order_count)
  //       c) Uses proper error handling (EXCEPTION block)
  //       d) Includes input validation
  //       Return the CREATE FUNCTION statement.
  // Hint: CREATE FUNCTION get_customer_summary(p_customer_id INT, p_start DATE, p_end DATE)
  //       RETURNS TABLE (month DATE, total_amount DECIMAL, order_count BIGINT) AS $$
  // Expected: Complete PL/pgSQL function with RETURNS TABLE
  val exercise5: String = ???

  // Exercise 6: LISTEN / NOTIFY
  // TODO: Write SQL demonstrating PostgreSQL's pub/sub mechanism:
  //       a) LISTEN on a channel 'order_updates'
  //       b) NOTIFY the channel with a payload (JSON string)
  //       c) A trigger that automatically NOTIFYs when orders change
  //       d) Show how pg_notify() function works (allows dynamic channel names)
  //       Include comments on use cases: cache invalidation, real-time updates, microservices.
  // Hint: NOTIFY channel, 'payload'; or SELECT pg_notify('channel', '{"id":1}');
  // Expected: LISTEN, NOTIFY, trigger+function for auto-notify, pg_notify()
  val exercise6: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (Range partition):    $exercise1")
    println(s"Exercise 2 (List/Hash partition): $exercise2")
    println(s"Exercise 3 (Materialized views): $exercise3")
    println(s"Exercise 4 (Triggers):           $exercise4")
    println(s"Exercise 5 (Stored functions):   $exercise5")
    println(s"Exercise 6 (LISTEN/NOTIFY):      $exercise6")
    println("All Sql013_AdvancedPG exercises defined!")
  }
}
