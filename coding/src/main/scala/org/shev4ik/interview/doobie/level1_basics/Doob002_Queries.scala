package org.shev4ik.interview.doobie.level1_basics

/**
 * Doobie 002 - Query Construction and Execution
 *
 * =Overview=
 * Doobie is a pure functional JDBC layer for Scala built on Cats Effect and FS2.
 * It provides a type-safe, composable way to interact with relational databases
 * without the complexity of an ORM.
 *
 * =The sql String Interpolator=
 * The `sql"..."` interpolator is the primary way to build SQL in doobie. It produces
 * a `Fragment` which is compiled into a `Query0[A]` (for SELECTs) or `Update0` (for
 * INSERT/UPDATE/DELETE). Importantly, interpolated Scala values become '''parameterized
 * query placeholders''' (PreparedStatement parameters), NOT string concatenation:
 * {{{
 *   val id = 42
 *   sql"SELECT * FROM users WHERE id = $id"
 *   // Becomes: PreparedStatement("SELECT * FROM users WHERE id = ?", params=[42])
 * }}}
 *
 * =Query0[A] - Typed Query Results=
 *  - `.query[A]` compiles a Fragment into `Query0[A]`, where `A` is the Scala type
 *    that each result row maps to. Doobie uses `Read[A]` type class instances to
 *    automatically derive the mapping for case classes, tuples, and primitives.
 *  - `.unique` -- expects exactly one row; raises an error if 0 or 2+ rows returned
 *  - `.option` -- expects 0 or 1 row; returns `Option[A]`
 *  - `.to[List]` / `.to[Vector]` -- collects all rows into the specified collection
 *  - `.stream` -- returns an `fs2.Stream[ConnectionIO, A]` for lazy row-by-row processing
 *
 * =Parameterized Queries=
 * Every value interpolated into `sql"..."` is bound as a JDBC parameter via `Put[A]`
 * type class. This means:
 *  1. '''SQL injection is impossible''' -- values are never concatenated into SQL text
 *  2. '''Type safety''' -- the compiler checks that interpolated types have `Put` instances
 *  3. '''Performance''' -- PreparedStatement caching and query plan reuse
 *
 * =Execution with ConnectionIO=
 * Queries return `ConnectionIO[A]` which is a free monad describing database operations.
 * Nothing executes until you provide a `Transactor[F]` which maps ConnectionIO to your
 * effect type:
 * {{{
 *   val xa: Transactor[IO] = Transactor.fromDriverManager[IO](...)
 *   sql"SELECT name FROM users".query[String].to[List].transact(xa)  // IO[List[String]]
 * }}}
 *
 * =Real-World Usage=
 * In production, doobie is commonly used with `HikariTransactor` for connection pooling,
 * combined with `Fragments.in(...)` for IN clauses, `Fragment.const(...)` for trusted
 * dynamic SQL fragments (table names), and `Meta[A]`/`Put[A]`/`Get[A]` for custom type
 * mappings (e.g., enums, JSON columns, UUIDs).
 *
 * =Interview Tip=
 * ''"How does doobie prevent SQL injection?"''
 *
 * '''Answer:''' The `sql"..."` string interpolator uses parameterized queries
 * (JDBC `PreparedStatement`), NOT string concatenation. Every interpolated Scala value
 * is bound as a `?` parameter via the `Put[A]` type class. This makes SQL injection
 * structurally impossible -- the SQL text and the data values are always kept separate
 * at the JDBC level. For cases where you need dynamic SQL fragments (e.g., table names),
 * doobie provides `Fragment.const()` which should only be used with trusted input.
 *
 * Here we model a simplified version of these concepts to understand
 * how SQL strings are constructed, parameterized, and mapped to Scala types.
 */
object Doob002_Queries {

  // Simplified SQL fragment with parameter support
  case class SqlString(sql: String, params: List[Any] = Nil) {
    def ++(other: SqlString): SqlString =
      SqlString(sql + " " + other.sql, params ++ other.params)
  }

  // Simplified Query0: a SQL query that maps rows to type A
  case class Query0[A](sqlString: SqlString, mapper: Map[String, Any] => A) {
    def toList(rows: List[Map[String, Any]]): List[A] = rows.map(mapper)
    def unique(rows: List[Map[String, Any]]): A = {
      val results = rows.map(mapper)
      require(results.size == 1, s"Expected exactly 1 row, got ${results.size}")
      results.head
    }
    def option(rows: List[Map[String, Any]]): Option[A] = {
      val results = rows.map(mapper)
      require(results.size <= 1, s"Expected 0 or 1 row, got ${results.size}")
      results.headOption
    }
  }

  // Sample database rows
  val usersTable: List[Map[String, Any]] = List(
    Map("id" -> 1, "name" -> "Alice", "age" -> 30),
    Map("id" -> 2, "name" -> "Bob", "age" -> 25),
    Map("id" -> 3, "name" -> "Charlie", "age" -> 35)
  )

  val ordersTable: List[Map[String, Any]] = List(
    Map("id" -> 1, "user_id" -> 1, "amount" -> 100.0),
    Map("id" -> 2, "user_id" -> 2, "amount" -> 200.0),
    Map("id" -> 3, "user_id" -> 1, "amount" -> 50.0)
  )

  case class User(id: Int, name: String, age: Int)
  case class Order(id: Int, userId: Int, amount: Double)

  // -------------------------------------------------------------------------
  // Exercise 1: Create a SqlString representing "SELECT * FROM users".
  // TODO: Construct a SqlString with the given SQL and no params.
  // -------------------------------------------------------------------------
  def exercise1_simpleSql: SqlString = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a parameterized SqlString for "SELECT * FROM users WHERE id = ?"
  // TODO: Build a SqlString with the sql text and the id as a parameter.
  // -------------------------------------------------------------------------
  def exercise2_parameterizedSql(id: Int): SqlString = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Create a Query0[String] that extracts the "name" column.
  // TODO: Build a Query0 with appropriate sql and mapper that reads "name".
  // -------------------------------------------------------------------------
  def exercise3_queryForNames: Query0[String] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Create a Query0[User] that maps a row to a User case class.
  // TODO: The mapper should extract id, name, and age from the row map.
  // -------------------------------------------------------------------------
  def exercise4_queryForUsers: Query0[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use Query0.toList to get all users as a List[User].
  // TODO: Apply exercise4_queryForUsers.toList on usersTable.
  // -------------------------------------------------------------------------
  def exercise5_selectAllUsers: List[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Implement a "WHERE" filter on rows, then use Query0.unique.
  // TODO: Filter usersTable to rows where "id" == userId, then use
  // exercise4_queryForUsers.unique on the filtered rows.
  // -------------------------------------------------------------------------
  def exercise6_selectUserById(userId: Int): User = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Use Query0.option to safely select a user that may not exist.
  // TODO: Filter usersTable by id, then use exercise4_queryForUsers.option.
  // -------------------------------------------------------------------------
  def exercise7_selectUserOption(userId: Int): Option[User] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a multi-column query mapping rows to tuples.
  // TODO: Create a Query0[(String, Int)] that extracts (name, age) pairs
  // and use it to get all (name, age) tuples from usersTable.
  // -------------------------------------------------------------------------
  def exercise8_selectNameAgePairs: List[(String, Int)] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_simpleSql == SqlString("SELECT * FROM users", Nil))
    println("Exercise 1 passed: simple SQL string")

    // Exercise 2
    val paramSql = exercise2_parameterizedSql(1)
    assert(paramSql.sql == "SELECT * FROM users WHERE id = ?")
    assert(paramSql.params == List(1))
    println("Exercise 2 passed: parameterized SQL string")

    // Exercise 3
    val names = exercise3_queryForNames.toList(usersTable)
    assert(names == List("Alice", "Bob", "Charlie"))
    println("Exercise 3 passed: query for names")

    // Exercise 4
    val users = exercise4_queryForUsers.toList(usersTable)
    assert(users == List(User(1, "Alice", 30), User(2, "Bob", 25), User(3, "Charlie", 35)))
    println("Exercise 4 passed: query for users")

    // Exercise 5
    assert(exercise5_selectAllUsers == List(User(1, "Alice", 30), User(2, "Bob", 25), User(3, "Charlie", 35)))
    println("Exercise 5 passed: select all users")

    // Exercise 6
    assert(exercise6_selectUserById(2) == User(2, "Bob", 25))
    println("Exercise 6 passed: select user by id (unique)")

    // Exercise 7
    assert(exercise7_selectUserOption(2) == Some(User(2, "Bob", 25)))
    assert(exercise7_selectUserOption(999) == None)
    println("Exercise 7 passed: select user option")

    // Exercise 8
    assert(exercise8_selectNameAgePairs == List(("Alice", 30), ("Bob", 25), ("Charlie", 35)))
    println("Exercise 8 passed: select name-age pairs")

    println("\nAll Doob002_Queries exercises passed!")
  }
}
