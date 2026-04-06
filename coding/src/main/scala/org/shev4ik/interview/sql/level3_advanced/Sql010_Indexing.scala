package org.shev4ik.interview.sql.level3_advanced

object Sql010_Indexing {

  // Schema:
  // CREATE TABLE products (
  //   id SERIAL PRIMARY KEY,
  //   name TEXT NOT NULL,
  //   category TEXT NOT NULL,
  //   price DECIMAL(10,2),
  //   tags TEXT[],              -- PostgreSQL array
  //   metadata JSONB,           -- PostgreSQL JSONB
  //   created_at TIMESTAMPTZ DEFAULT NOW(),
  //   is_active BOOLEAN DEFAULT TRUE,
  //   location POINT            -- PostgreSQL geometric type
  // );
  //
  // CREATE TABLE price_ranges (
  //   id SERIAL PRIMARY KEY,
  //   product_id INT REFERENCES products(id),
  //   valid_range DATERANGE      -- PostgreSQL range type
  // );
  //
  // Sample data - products (assume millions of rows in production):
  // | id | name       | category    | price  | tags              | metadata                        | is_active |
  // |----|------------|-------------|--------|-------------------|---------------------------------|-----------|
  // | 1  | Laptop Pro | Electronics | 1299.99| {tech,portable}   | {"brand":"Dell","ram":16}       | true      |
  // | 2  | Desk Chair | Furniture   | 349.99 | {office,ergonomic}| {"brand":"Herman","color":"black"}| true    |
  // | 3  | Old Phone  | Electronics | 199.99 | {tech,refurbished}| {"brand":"Samsung","year":2019} | false     |
  // | ...| ...        | ...         | ...    | ...               | ...                             | ...       |

  // Exercise 1: B-tree index (default)
  // TODO: Write SQL to create a B-tree index on products(category) and then a query
  //       that benefits from it. Also create a composite B-tree index on (category, price).
  //       Return both CREATE INDEX and the SELECT statements as a multi-statement string.
  // Hint: B-tree is best for equality and range comparisons (=, <, >, BETWEEN, ORDER BY)
  // Expected: CREATE INDEX idx_products_category ON products(category);
  //           CREATE INDEX idx_products_cat_price ON products(category, price);
  //           SELECT * FROM products WHERE category = 'Electronics' AND price < 500 ORDER BY price;
  val exercise1: String = ???

  // Exercise 2: Hash index concept
  // TODO: Write SQL to create a hash index on products(name) and explain when to use it.
  //       Hash indexes only support equality (=) comparisons, not range queries.
  //       Return the CREATE INDEX statement and a query that uses it.
  // Hint: Hash indexes are smaller than B-tree for equality-only lookups (PG 10+, WAL-logged)
  // Expected: CREATE INDEX idx_products_name_hash ON products USING hash(name);
  //           SELECT * FROM products WHERE name = 'Laptop Pro';
  val exercise2: String = ???

  // Exercise 3: GIN index (arrays and JSONB)
  // TODO: Write SQL to create GIN indexes for:
  //       a) The tags array column (to support @> containment)
  //       b) The metadata JSONB column (to support @>, ?, ?| operators)
  //       Then write queries that benefit from each.
  // Expected: Two CREATE INDEX statements + two SELECT statements
  val exercise3: String = ???

  // Exercise 4: GiST index (range and geometric types)
  // TODO: Write SQL to create GiST indexes for:
  //       a) The valid_range column in price_ranges (to support && overlap, @> containment)
  //       b) The location POINT column in products (to support distance/nearest queries)
  //       Then write queries using each.
  // Hint: GiST supports overlaps, containment, nearest-neighbor for ranges and geometric types
  // Expected: Two CREATE INDEX statements + two SELECT statements
  val exercise4: String = ???

  // Exercise 5: Partial index
  // TODO: Write SQL to create a partial index that only indexes active products.
  //       This is useful when queries predominantly filter for is_active = true.
  //       Return the CREATE INDEX and a query that benefits from it.
  // Hint: Partial indexes are smaller and faster because they skip rows not matching the predicate.
  // Expected: CREATE INDEX idx_active_products ON products(category, price) WHERE is_active = true;
  val exercise5: String = ???

  // Exercise 6: Expression index (functional index)
  // TODO: Write SQL to create an index on an expression: LOWER(name).
  //       This supports case-insensitive searches efficiently.
  //       Also create an index on EXTRACT(YEAR FROM created_at) for year-based queries.
  //       Return both CREATE INDEX and SELECT statements.
  // Expected: CREATE INDEX idx_products_lower_name ON products(LOWER(name));
  //           SELECT * FROM products WHERE LOWER(name) = 'laptop pro';
  val exercise6: String = ???

  // Exercise 7: Covering index (INCLUDE - PostgreSQL 11+)
  // TODO: Write SQL to create a covering index that includes additional columns
  //       to enable index-only scans. The index key is (category) but INCLUDE (name, price)
  //       so queries selecting name and price filtered by category never touch the heap.
  //       Return the CREATE INDEX and a query demonstrating index-only scan.
  // Hint: INCLUDE columns are stored in the index but not used for searching/ordering.
  // Expected: CREATE INDEX idx_products_covering ON products(category) INCLUDE (name, price);
  val exercise7: String = ???

  // Exercise 8: EXPLAIN ANALYZE reading
  // TODO: Write a SQL query using EXPLAIN (ANALYZE, BUFFERS, FORMAT TEXT) on a query
  //       that joins products with price_ranges. Include comments explaining what to look for:
  //       - Seq Scan vs Index Scan vs Bitmap Index Scan
  //       - Nested Loop vs Hash Join vs Merge Join
  //       - actual time vs planning time
  //       - Buffers: shared hit vs read
  //       Return the EXPLAIN ANALYZE statement.
  // Hint: In interviews, knowing how to read EXPLAIN output is critical.
  //   Key metrics: rows (estimated vs actual), loops, startup cost, total cost
  // Expected: EXPLAIN (ANALYZE, BUFFERS) SELECT ... FROM products p JOIN price_ranges pr ON ...
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (B-tree index):       $exercise1")
    println(s"Exercise 2 (Hash index):         $exercise2")
    println(s"Exercise 3 (GIN index):          $exercise3")
    println(s"Exercise 4 (GiST index):         $exercise4")
    println(s"Exercise 5 (Partial index):      $exercise5")
    println(s"Exercise 6 (Expression index):   $exercise6")
    println(s"Exercise 7 (Covering index):     $exercise7")
    println(s"Exercise 8 (EXPLAIN ANALYZE):    $exercise8")
    println("All Sql010_Indexing exercises defined!")
  }
}
