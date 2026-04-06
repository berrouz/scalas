package org.shev4ik.interview.sql.level2_intermediate

object Sql006_WindowAdvanced {

  // Schema:
  // CREATE TABLE daily_sales (
  //   id SERIAL PRIMARY KEY,
  //   store_id INT NOT NULL,
  //   sale_date DATE NOT NULL,
  //   revenue DECIMAL(10,2) NOT NULL,
  //   units_sold INT NOT NULL
  // );
  //
  // Sample data - daily_sales:
  // | id | store_id | sale_date  | revenue  | units_sold |
  // |----|----------|------------|----------|------------|
  // | 1  | 1        | 2024-01-01 | 1500.00  | 15         |
  // | 2  | 1        | 2024-01-02 | 2200.00  | 22         |
  // | 3  | 1        | 2024-01-03 | 1800.00  | 18         |
  // | 4  | 1        | 2024-01-04 | 2500.00  | 25         |
  // | 5  | 1        | 2024-01-05 | 1900.00  | 19         |
  // | 6  | 2        | 2024-01-01 | 3200.00  | 32         |
  // | 7  | 2        | 2024-01-02 | 2800.00  | 28         |
  // | 8  | 2        | 2024-01-03 | 3500.00  | 35         |
  // | 9  | 2        | 2024-01-04 | 3100.00  | 31         |
  // | 10 | 2        | 2024-01-05 | 2900.00  | 29         |

  // Exercise 1: PARTITION BY with window function
  // TODO: Write a SQL query that returns each row with the total revenue for its store
  //       as an additional column. Use SUM(...) OVER (PARTITION BY store_id).
  //       Return store_id, sale_date, revenue, store_total_revenue.
  // Expected: Store 1 total=9900, Store 2 total=15500 on each respective row
  val exercise1: String = ???

  // Exercise 2: Frame specification - ROWS
  // TODO: Write a SQL query that calculates a 3-day moving sum of revenue per store.
  //       Use ROWS BETWEEN 2 PRECEDING AND CURRENT ROW.
  //       Return store_id, sale_date, revenue, moving_sum_3day.
  // Expected: Store 1: Jan 1=1500, Jan 2=3700, Jan 3=5500, Jan 4=6500, Jan 5=6200
  val exercise2: String = ???

  // Exercise 3: Frame specification - RANGE
  // TODO: Write a SQL query that uses RANGE to sum revenue within a 2-day window
  //       (current date +/- 1 day) per store. Use:
  //       RANGE BETWEEN INTERVAL '1 day' PRECEDING AND INTERVAL '1 day' FOLLOWING
  //       Return store_id, sale_date, revenue, range_sum.
  // Expected: Store 1 Jan 1: sum of Jan 1 + Jan 2 = 3700 (no day before)
  val exercise3: String = ???

  // Exercise 4: Running total
  // TODO: Write a SQL query that calculates the running total of revenue per store
  //       ordered by sale_date. Use SUM(...) OVER (PARTITION BY ... ORDER BY ...).
  //       Return store_id, sale_date, revenue, running_total.
  // Expected: Store 1: 1500, 3700, 5500, 8000, 9900
  val exercise4: String = ???

  // Exercise 5: Moving average
  // TODO: Write a SQL query that calculates a 3-day moving average of revenue per store.
  //       Use AVG(...) OVER (... ROWS BETWEEN 2 PRECEDING AND CURRENT ROW).
  //       Return store_id, sale_date, revenue, moving_avg_3day (rounded to 2 decimals).
  // Expected: Store 1: Jan 1=1500.00, Jan 2=1850.00, Jan 3=1833.33, Jan 4=2166.67, Jan 5=2066.67
  val exercise5: String = ???

  // Exercise 6: PERCENT_RANK
  // TODO: Write a SQL query that calculates the percent rank of each day's revenue
  //       within its store. Use PERCENT_RANK() OVER (PARTITION BY store_id ORDER BY revenue).
  //       Return store_id, sale_date, revenue, pct_rank (rounded to 4 decimals).
  // Expected: Store 1: 1500(0.0), 1800(0.25), 1900(0.5), 2200(0.75), 2500(1.0)
  val exercise6: String = ???

  // Exercise 7: CUME_DIST (cumulative distribution)
  // TODO: Write a SQL query that calculates cumulative distribution of revenue within each store.
  //       Use CUME_DIST() OVER (PARTITION BY store_id ORDER BY revenue).
  //       Return store_id, sale_date, revenue, cumulative_dist (rounded to 4 decimals).
  // Expected: Store 1: 1500(0.2), 1800(0.4), 1900(0.6), 2200(0.8), 2500(1.0)
  val exercise7: String = ???

  // Exercise 8: Percentile (PERCENTILE_CONT)
  // TODO: Write a SQL query that calculates the median (50th percentile) revenue per store.
  //       Use PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY revenue) grouped by store_id.
  //       Return store_id and median_revenue.
  // Expected: Store 1: 1900.00, Store 2: 3100.00
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (PARTITION BY):       $exercise1")
    println(s"Exercise 2 (ROWS frame):         $exercise2")
    println(s"Exercise 3 (RANGE frame):        $exercise3")
    println(s"Exercise 4 (Running total):      $exercise4")
    println(s"Exercise 5 (Moving average):     $exercise5")
    println(s"Exercise 6 (PERCENT_RANK):       $exercise6")
    println(s"Exercise 7 (CUME_DIST):          $exercise7")
    println(s"Exercise 8 (PERCENTILE_CONT):    $exercise8")
    println("All Sql006_WindowAdvanced exercises defined!")
  }
}
