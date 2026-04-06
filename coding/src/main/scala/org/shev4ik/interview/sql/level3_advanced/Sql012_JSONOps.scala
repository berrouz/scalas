package org.shev4ik.interview.sql.level3_advanced

object Sql012_JSONOps {

  // Schema:
  // CREATE TABLE events (
  //   id SERIAL PRIMARY KEY,
  //   event_type TEXT NOT NULL,
  //   payload JSONB NOT NULL,
  //   created_at TIMESTAMPTZ DEFAULT NOW()
  // );
  //
  // CREATE TABLE user_profiles (
  //   id SERIAL PRIMARY KEY,
  //   username TEXT UNIQUE NOT NULL,
  //   settings JSONB DEFAULT '{}',
  //   tags JSONB DEFAULT '[]'
  // );
  //
  // Sample data - events:
  // | id | event_type  | payload                                                                  |
  // |----|-------------|--------------------------------------------------------------------------|
  // | 1  | page_view   | {"url":"/home","user_id":101,"duration":5.2,"metadata":{"browser":"Chrome"}} |
  // | 2  | click       | {"element":"buy_btn","user_id":101,"page":"/product/42"}                 |
  // | 3  | page_view   | {"url":"/about","user_id":102,"duration":3.1,"metadata":{"browser":"Firefox"}} |
  // | 4  | purchase    | {"user_id":101,"items":[{"sku":"A1","qty":2,"price":29.99},{"sku":"B2","qty":1,"price":49.99}],"total":109.97} |
  // | 5  | click       | {"element":"nav_menu","user_id":103,"page":"/home"}                      |
  //
  // Sample data - user_profiles:
  // | id | username | settings                                        | tags                        |
  // |----|----------|-------------------------------------------------|-----------------------------|
  // | 1  | alice    | {"theme":"dark","notifications":{"email":true,"sms":false},"lang":"en"} | ["admin","power_user"] |
  // | 2  | bob      | {"theme":"light","notifications":{"email":false,"sms":true},"lang":"fr"}| ["user"]              |
  // | 3  | carol    | {"theme":"dark","lang":"en"}                     | ["admin","user"]            |

  // Exercise 1: JSONB storage and basic access
  // TODO: Write a SQL query that selects all events and extracts the user_id from the payload.
  //       Use the -> operator (returns JSONB) and ->> operator (returns TEXT).
  //       Return id, event_type, payload->>'user_id' as user_id_text, payload->'user_id' as user_id_json.
  // Hint: -> returns JSONB type, ->> returns TEXT type. Use ->> for comparisons with text.
  // Expected: All 5 events with user_id extracted both ways
  val exercise1: String = ???

  // Exercise 2: Nested JSON access with -> and ->>
  // TODO: Write a SQL query that extracts nested values from user_profiles.settings:
  //       - The theme (text)
  //       - The email notification setting (boolean)
  //       Use chained -> for path traversal, then ->> for final text extraction.
  //       Also use the #>> operator for path-based extraction.
  //       Return username, theme, email_notifications (using both methods).
  // Hint: settings->'notifications'->>'email' OR settings#>>'{notifications,email}'
  // Expected: alice(dark, true), bob(light, false), carol(dark, NULL)
  val exercise2: String = ???

  // Exercise 3: jsonb_array_elements
  // TODO: Write a SQL query that extracts each item from the purchase event's items array.
  //       Use jsonb_array_elements to unnest the array.
  //       Return event id, item sku, qty, and price for the purchase event.
  // Hint: Use LATERAL jsonb_array_elements(payload->'items') or in FROM clause
  // Expected: 2 rows: (4, A1, 2, 29.99), (4, B2, 1, 49.99)
  val exercise3: String = ???

  // Exercise 4: jsonb_each / jsonb_each_text
  // TODO: Write a SQL query that expands the settings JSONB object into key-value pairs
  //       for each user. Use jsonb_each_text to get all top-level settings as rows.
  //       Return username, setting_key, setting_value.
  // Hint: FROM user_profiles, LATERAL jsonb_each_text(settings)
  // Expected: alice has 3 keys (theme, notifications, lang), bob has 3, carol has 2
  val exercise4: String = ???

  // Exercise 5: Containment operator @>
  // TODO: Write SQL queries demonstrating the @> containment operator:
  //       a) Find events where payload contains {"user_id": 101}
  //       b) Find user_profiles where tags contain '["admin"]'
  //       Return both queries as a single string separated by a semicolon.
  // Hint: @> checks if left JSONB contains right JSONB. Works with GIN index.
  // Expected: a) Events 1,2,4; b) alice, carol
  val exercise5: String = ???

  // Exercise 6: Existence operator ?
  // TODO: Write SQL queries demonstrating the ?, ?|, and ?& operators:
  //       a) Find user_profiles where settings has the key 'notifications' (? operator)
  //       b) Find user_profiles where tags contain any of 'admin' or 'moderator' (?| operator)
  //       c) Find user_profiles where tags contain both 'admin' and 'user' (?& operator)
  //       Return all three queries.
  // Hint: ? checks key existence, ?| checks any key exists, ?& checks all keys exist
  // Expected: a) alice, bob; b) alice, carol; c) carol
  val exercise6: String = ???

  // Exercise 7: jsonb_set and JSONB modification
  // TODO: Write SQL queries that modify JSONB data:
  //       a) Update alice's theme to 'system' using jsonb_set
  //       b) Add a new key 'timezone' to carol's settings using jsonb_set with create_if_missing
  //       c) Remove the 'sms' key from alice's notifications using the #- operator
  //       d) Concatenate (merge) new keys into settings using || operator
  //       Return all four UPDATE statements.
  // Hint: jsonb_set(target, path, new_value, create_if_missing)
  //       target #- '{path,to,key}' removes a key
  //       target || '{"key":"value"}' merges
  // Expected: Four UPDATE statements
  val exercise7: String = ???

  // Exercise 8: JSONB indexing strategies
  // TODO: Write SQL to create appropriate indexes for JSONB columns and queries:
  //       a) GIN index on payload for general containment queries (@>, ?, etc.)
  //       b) GIN index with jsonb_path_ops for containment-only (smaller, faster for @>)
  //       c) B-tree expression index on a specific extracted field (payload->>'user_id')
  //       d) GIN index on tags array for containment
  //       Include a comment comparing the index types and their trade-offs.
  // Hint: jsonb_ops (default) supports @>, ?, ?|, ?&
  //       jsonb_path_ops only supports @> but is 2-3x smaller and faster
  // Expected: Four CREATE INDEX statements with explanatory comments
  val exercise8: String = ???

  def main(args: Array[String]): Unit = {
    println(s"Exercise 1 (JSONB access):       $exercise1")
    println(s"Exercise 2 (Nested access):      $exercise2")
    println(s"Exercise 3 (array_elements):     $exercise3")
    println(s"Exercise 4 (jsonb_each):         $exercise4")
    println(s"Exercise 5 (Containment @>):     $exercise5")
    println(s"Exercise 6 (Existence ?):        $exercise6")
    println(s"Exercise 7 (jsonb_set):          $exercise7")
    println(s"Exercise 8 (JSONB indexes):      $exercise8")
    println("All Sql012_JSONOps exercises defined!")
  }
}
