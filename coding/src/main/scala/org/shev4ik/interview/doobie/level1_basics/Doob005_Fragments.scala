package org.shev4ik.interview.doobie.level1_basics

/**
 * Doobie 005 - Fragments (Fragment composition, dynamic SQL, IN-clauses)
 *
 * In doobie, Fragment is a composable piece of SQL with parameters. Fragments
 * can be combined with ++ to build complex queries dynamically. The Fragments
 * helper provides utilities for IN clauses, WHERE/AND/OR composition, etc.
 *
 * Here we model a simplified Fragment to understand how doobie builds SQL
 * dynamically in a type-safe manner.
 */
object Doob005_Fragments {

  // Simplified Fragment: SQL string with parameters
  case class Fragment(sql: String, params: List[Any] = Nil) {
    def ++(other: Fragment): Fragment =
      Fragment(sql + " " + other.sql, params ++ other.params)

    def query: String = {
      var result = sql
      params.foreach { p =>
        result = result.replaceFirst("\\?", p.toString)
      }
      result
    }
  }

  object Fragment {
    val empty: Fragment = Fragment("", Nil)

    def const(sql: String): Fragment = Fragment(sql, Nil)
  }

  // Helper like doobie's Fragments object
  object Fragments {
    def whereAnd(frags: Fragment*): Fragment = {
      val nonEmpty = frags.filter(_.sql.nonEmpty)
      if (nonEmpty.isEmpty) Fragment.empty
      else Fragment("WHERE " + nonEmpty.map(_.sql).mkString(" AND "), nonEmpty.flatMap(_.params).toList)
    }

    def whereOr(frags: Fragment*): Fragment = {
      val nonEmpty = frags.filter(_.sql.nonEmpty)
      if (nonEmpty.isEmpty) Fragment.empty
      else Fragment("WHERE " + nonEmpty.map(_.sql).mkString(" OR "), nonEmpty.flatMap(_.params).toList)
    }

    def in[A](column: String, values: List[A]): Fragment = {
      if (values.isEmpty) Fragment("1 = 0", Nil) // always false
      else Fragment(s"$column IN (${values.map(_ => "?").mkString(", ")})", values.map(_.asInstanceOf[Any]))
    }

    def notIn[A](column: String, values: List[A]): Fragment = {
      if (values.isEmpty) Fragment("1 = 1", Nil) // always true
      else Fragment(s"$column NOT IN (${values.map(_ => "?").mkString(", ")})", values.map(_.asInstanceOf[Any]))
    }

    def set(assignments: Fragment*): Fragment = {
      val nonEmpty = assignments.filter(_.sql.nonEmpty)
      Fragment("SET " + nonEmpty.map(_.sql).mkString(", "), nonEmpty.flatMap(_.params).toList)
    }
  }

  // -------------------------------------------------------------------------
  // Exercise 1: Create a simple Fragment for "SELECT * FROM users".
  // TODO: Use Fragment.const to build a fragment with no parameters.
  // -------------------------------------------------------------------------
  def exercise1_selectAll: Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a parameterized Fragment for "age > ?".
  // TODO: Build a Fragment with "age > ?" and the minAge as parameter.
  // -------------------------------------------------------------------------
  def exercise2_ageFilter(minAge: Int): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Compose fragments using ++ to build a full query.
  // TODO: Combine "SELECT * FROM users" with "WHERE age > ?" using ++.
  // -------------------------------------------------------------------------
  def exercise3_composeFragments(minAge: Int): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Use Fragments.whereAnd to combine multiple conditions.
  // TODO: Build a WHERE clause with "age > ?" AND "name = ?" conditions.
  // -------------------------------------------------------------------------
  def exercise4_whereAnd(minAge: Int, name: String): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Use Fragments.in to build an IN clause.
  // TODO: Build a Fragment for "id IN (?, ?, ...)" given a list of ids.
  // -------------------------------------------------------------------------
  def exercise5_inClause(ids: List[Int]): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Build a dynamic query where conditions are optional.
  // TODO: Given optional name and optional minAge filters, compose a
  // SELECT query with only the present filters in the WHERE clause.
  // If both are None, return just "SELECT * FROM users".
  // Hint: Build a list of optional fragments, flatten, use whereAnd.
  // -------------------------------------------------------------------------
  def exercise6_dynamicQuery(name: Option[String], minAge: Option[Int]): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Build an UPDATE statement using Fragments.set.
  // TODO: Build "UPDATE users SET name = ?, age = ? WHERE id = ?"
  // using Fragment composition and Fragments.set.
  // -------------------------------------------------------------------------
  def exercise7_updateStatement(id: Int, name: String, age: Int): Fragment = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Implement a custom combinator that joins fragments with commas.
  // TODO: Given a list of Fragments, join them with ", " separator.
  // Example: List(Fragment("a"), Fragment("b")) => Fragment("a, b")
  // -------------------------------------------------------------------------
  def exercise8_commaJoin(fragments: List[Fragment]): Fragment = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    assert(exercise1_selectAll == Fragment("SELECT * FROM users", Nil))
    println("Exercise 1 passed: simple select fragment")

    // Exercise 2
    val ageFrag = exercise2_ageFilter(25)
    assert(ageFrag.sql == "age > ?")
    assert(ageFrag.params == List(25))
    println("Exercise 2 passed: parameterized fragment")

    // Exercise 3
    val composed = exercise3_composeFragments(25)
    assert(composed.sql == "SELECT * FROM users WHERE age > ?")
    assert(composed.params == List(25))
    println("Exercise 3 passed: composed fragments")

    // Exercise 4
    val whereClause = exercise4_whereAnd(25, "Alice")
    assert(whereClause.sql == "WHERE age > ? AND name = ?")
    assert(whereClause.params == List(25, "Alice"))
    println("Exercise 4 passed: whereAnd composition")

    // Exercise 5
    val inFrag = exercise5_inClause(List(1, 2, 3))
    assert(inFrag.sql == "id IN (?, ?, ?)")
    assert(inFrag.params == List(1, 2, 3))
    println("Exercise 5 passed: IN clause")

    // Exercise 6
    val q1 = exercise6_dynamicQuery(Some("Alice"), Some(20))
    assert(q1.sql.contains("WHERE"))
    assert(q1.sql.contains("name = ?"))
    assert(q1.sql.contains("age > ?"))
    val q2 = exercise6_dynamicQuery(None, None)
    assert(!q2.sql.contains("WHERE"))
    val q3 = exercise6_dynamicQuery(Some("Bob"), None)
    assert(q3.sql.contains("name = ?"))
    assert(!q3.sql.contains("age"))
    println("Exercise 6 passed: dynamic query building")

    // Exercise 7
    val upd = exercise7_updateStatement(1, "Alice Updated", 31)
    assert(upd.sql.contains("UPDATE users"))
    assert(upd.sql.contains("SET"))
    assert(upd.sql.contains("WHERE id = ?"))
    assert(upd.params.contains(1))
    assert(upd.params.contains("Alice Updated"))
    assert(upd.params.contains(31))
    println("Exercise 7 passed: UPDATE statement building")

    // Exercise 8
    val joined = exercise8_commaJoin(List(Fragment("a", Nil), Fragment("b", List(1)), Fragment("c", List(2))))
    assert(joined.sql == "a, b, c")
    assert(joined.params == List(1, 2))
    println("Exercise 8 passed: comma join combinator")

    println("\nAll Doob005_Fragments exercises passed!")
  }
}
