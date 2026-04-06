package org.shev4ik.interview.doobie.level1_basics

/**
 * Doobie 003 - Updates (Update0, insert/update/delete, batch updates)
 *
 * In doobie, Update0 represents a SQL statement that modifies data (INSERT,
 * UPDATE, DELETE). It returns the number of affected rows. For batch operations,
 * Update[A] takes a parameter type A and can be applied to many values at once.
 *
 * Here we model these concepts with a mutable in-memory table to understand
 * how doobie handles data modification statements.
 */
object Doob003_Updates {

  case class Row(data: Map[String, Any])

  // Mutable table model for simulating DB updates
  class Table(initialRows: List[Row]) {
    private var rows: List[Row] = initialRows

    def allRows: List[Row] = rows
    def size: Int = rows.size

    def insert(row: Row): Int = { rows = rows :+ row; 1 }

    def insertMany(newRows: List[Row]): Int = {
      rows = rows ++ newRows
      newRows.size
    }

    def update(predicate: Row => Boolean, transform: Row => Row): Int = {
      val (matching, rest) = rows.partition(predicate)
      rows = rest ++ matching.map(transform)
      matching.size
    }

    def delete(predicate: Row => Boolean): Int = {
      val (matching, rest) = rows.partition(predicate)
      rows = rest
      matching.size
    }

    def reset(newRows: List[Row]): Unit = { rows = newRows }
  }

  // Simplified Update0: returns affected row count
  case class Update0(execute: Table => Int)

  // Simplified Update[A]: parameterized update
  case class Update[A](buildUpdate: A => Table => Int) {
    def run(a: A): Update0 = Update0(table => buildUpdate(a)(table))
    def updateMany(values: List[A]): Update0 = Update0(table => values.map(a => buildUpdate(a)(table)).sum)
  }

  val initialUsers: List[Row] = List(
    Row(Map("id" -> 1, "name" -> "Alice", "age" -> 30)),
    Row(Map("id" -> 2, "name" -> "Bob", "age" -> 25)),
    Row(Map("id" -> 3, "name" -> "Charlie", "age" -> 35))
  )

  // -------------------------------------------------------------------------
  // Exercise 1: Create an Update0 that inserts a single row into the table.
  // TODO: Return an Update0 that inserts a row with the given id, name, age.
  // -------------------------------------------------------------------------
  def exercise1_insertRow(id: Int, name: String, age: Int): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create an Update0 that deletes rows matching a predicate.
  // TODO: Delete all rows where "name" equals the given name. Return Update0.
  // -------------------------------------------------------------------------
  def exercise2_deleteByName(name: String): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create an Update0 that updates the age for a given user id.
  // TODO: Find rows where "id" matches, update their "age" to newAge.
  // -------------------------------------------------------------------------
  def exercise3_updateAge(id: Int, newAge: Int): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create an Update[(Int, String, Int)] for parameterized inserts.
  // TODO: The Update should insert a row from (id, name, age) tuple.
  // -------------------------------------------------------------------------
  def exercise4_parameterizedInsert: Update[(Int, String, Int)] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use Update.updateMany to batch-insert multiple rows.
  // TODO: Given a list of (id, name, age) tuples, use exercise4's Update
  // to insert all of them. Return the Update0.
  // -------------------------------------------------------------------------
  def exercise5_batchInsert(rows: List[(Int, String, Int)]): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Create an Update0 that returns the count of deleted rows.
  // TODO: Delete all rows where "age" > threshold. Return Update0.
  // -------------------------------------------------------------------------
  def exercise6_deleteByAgeThreshold(threshold: Int): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Compose two Update0 programs sequentially.
  // TODO: Execute first, then second, return the sum of affected rows.
  // -------------------------------------------------------------------------
  def exercise7_composeUpdates(first: Update0, second: Update0): Update0 = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement "upsert" logic: insert if not exists, update if exists.
  // TODO: If a row with the given id exists, update its name and age.
  // If not, insert a new row. Return an Update0 with affected count = 1.
  // -------------------------------------------------------------------------
  def exercise8_upsert(id: Int, name: String, age: Int): Update0 = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val table1 = new Table(initialUsers)
    assert(exercise1_insertRow(4, "Diana", 28).execute(table1) == 1)
    assert(table1.size == 4)
    println("Exercise 1 passed: insert single row")

    // Exercise 2
    val table2 = new Table(initialUsers)
    assert(exercise2_deleteByName("Bob").execute(table2) == 1)
    assert(table2.size == 2)
    println("Exercise 2 passed: delete by name")

    // Exercise 3
    val table3 = new Table(initialUsers)
    assert(exercise3_updateAge(1, 31).execute(table3) == 1)
    assert(table3.allRows.find(_.data("id") == 1).get.data("age") == 31)
    println("Exercise 3 passed: update age")

    // Exercise 4
    val table4 = new Table(initialUsers)
    val insert = exercise4_parameterizedInsert
    assert(insert.run((4, "Diana", 28)).execute(table4) == 1)
    assert(table4.size == 4)
    println("Exercise 4 passed: parameterized insert")

    // Exercise 5
    val table5 = new Table(initialUsers)
    val batch = exercise5_batchInsert(List((4, "Diana", 28), (5, "Eve", 22)))
    assert(batch.execute(table5) == 2)
    assert(table5.size == 5)
    println("Exercise 5 passed: batch insert")

    // Exercise 6
    val table6 = new Table(initialUsers)
    assert(exercise6_deleteByAgeThreshold(29).execute(table6) == 2) // Alice(30) and Charlie(35)
    assert(table6.size == 1)
    println("Exercise 6 passed: delete by age threshold")

    // Exercise 7
    val table7 = new Table(initialUsers)
    val composed = exercise7_composeUpdates(
      exercise1_insertRow(4, "Diana", 28),
      exercise1_insertRow(5, "Eve", 22)
    )
    assert(composed.execute(table7) == 2)
    assert(table7.size == 5)
    println("Exercise 7 passed: compose updates")

    // Exercise 8
    val table8 = new Table(initialUsers)
    assert(exercise8_upsert(1, "Alice Updated", 31).execute(table8) == 1)
    assert(table8.allRows.exists(_.data("name") == "Alice Updated"))
    val table8b = new Table(initialUsers)
    assert(exercise8_upsert(99, "NewUser", 20).execute(table8b) == 1)
    assert(table8b.size == 4)
    println("Exercise 8 passed: upsert logic")

    println("\nAll Doob003_Updates exercises passed!")
  }
}
