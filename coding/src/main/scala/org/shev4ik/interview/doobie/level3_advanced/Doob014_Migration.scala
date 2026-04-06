package org.shev4ik.interview.doobie.level3_advanced

/**
 * Doobie 014 - Schema Migration (migration concepts, Flyway/Liquibase patterns)
 *
 * Schema migrations manage database evolution over time. Flyway uses versioned
 * SQL scripts (V1__create_users.sql, V2__add_email.sql); Liquibase uses XML/YAML
 * changesets. Both track applied migrations in a metadata table.
 *
 * Here we model a simplified migration system to understand versioning,
 * ordering, rollback, and migration state tracking.
 */
object Doob014_Migration {

  // Simplified database schema
  case class Column(name: String, colType: String, nullable: Boolean = false)
  case class TableSchema(name: String, columns: List[Column])

  // Migration definition
  case class Migration(
    version: Int,
    description: String,
    up: SchemaState => SchemaState,     // apply migration
    down: SchemaState => SchemaState    // rollback migration
  )

  // Current schema state
  case class SchemaState(
    tables: Map[String, TableSchema] = Map.empty,
    appliedMigrations: List[Int] = Nil
  ) {
    def addTable(schema: TableSchema): SchemaState =
      copy(tables = tables + (schema.name -> schema))

    def dropTable(name: String): SchemaState =
      copy(tables = tables - name)

    def addColumn(table: String, column: Column): SchemaState = {
      val updated = tables.get(table).map(t => t.copy(columns = t.columns :+ column))
      updated.map(t => copy(tables = tables + (table -> t))).getOrElse(this)
    }

    def dropColumn(table: String, columnName: String): SchemaState = {
      val updated = tables.get(table).map(t => t.copy(columns = t.columns.filterNot(_.name == columnName)))
      updated.map(t => copy(tables = tables + (table -> t))).getOrElse(this)
    }

    def renameTable(oldName: String, newName: String): SchemaState = {
      tables.get(oldName) match {
        case Some(schema) => copy(tables = (tables - oldName) + (newName -> schema.copy(name = newName)))
        case None => this
      }
    }

    def markApplied(version: Int): SchemaState = copy(appliedMigrations = appliedMigrations :+ version)
    def markRolledBack(version: Int): SchemaState = copy(appliedMigrations = appliedMigrations.filterNot(_ == version))
  }

  // Migration result
  case class MigrationResult(
    success: Boolean,
    appliedVersions: List[Int],
    errors: List[String],
    finalState: SchemaState
  )

  // -------------------------------------------------------------------------
  // Exercise 1: Create a migration that creates a "users" table.
  // TODO: V1 creates users(id INT, name VARCHAR, email VARCHAR).
  // Down drops the users table.
  // -------------------------------------------------------------------------
  def exercise1_createUsersTable: Migration = ???

  // -------------------------------------------------------------------------
  // Exercise 2: Create a migration that adds a column to an existing table.
  // TODO: V2 adds "age INT nullable" column to users table.
  // Down drops the age column.
  // -------------------------------------------------------------------------
  def exercise2_addAgeColumn: Migration = ???

  // -------------------------------------------------------------------------
  // Exercise 3: Apply a single migration to the schema state.
  // TODO: If already applied, return Left("Migration V{version} already applied").
  // Otherwise apply the up function and mark as applied.
  // -------------------------------------------------------------------------
  def exercise3_applyMigration(state: SchemaState, migration: Migration): Either[String, SchemaState] = ???

  // -------------------------------------------------------------------------
  // Exercise 4: Apply multiple migrations in version order.
  // TODO: Sort migrations by version, apply them sequentially.
  // Stop on first error and return what was applied so far.
  // Return a MigrationResult.
  // -------------------------------------------------------------------------
  def exercise4_applyAll(state: SchemaState, migrations: List[Migration]): MigrationResult = ???

  // -------------------------------------------------------------------------
  // Exercise 5: Rollback the last N applied migrations.
  // TODO: Take the last N applied versions, apply their down functions
  // in reverse order. Return the updated state.
  // -------------------------------------------------------------------------
  def exercise5_rollbackN(state: SchemaState, migrations: List[Migration], n: Int): SchemaState = ???

  // -------------------------------------------------------------------------
  // Exercise 6: Detect pending (unapplied) migrations.
  // TODO: Given current state and all available migrations, return the
  // list of migrations that haven't been applied yet, sorted by version.
  // -------------------------------------------------------------------------
  def exercise6_pendingMigrations(state: SchemaState, migrations: List[Migration]): List[Migration] = ???

  // -------------------------------------------------------------------------
  // Exercise 7: Validate migration ordering - detect gaps and duplicates.
  // TODO: Check that migration versions are sequential starting from 1
  // with no gaps or duplicates. Return Left with error or Right(migrations).
  // Error: "Gap in versions: missing V{n}" or "Duplicate version: V{n}"
  // -------------------------------------------------------------------------
  def exercise7_validateOrder(migrations: List[Migration]): Either[String, List[Migration]] = ???

  // -------------------------------------------------------------------------
  // Exercise 8: Generate a migration diff between two schema states.
  // TODO: Compare two SchemaStates and return a human-readable list of
  // changes: "Added table: X", "Dropped table: X", "Added column: X.Y",
  // "Dropped column: X.Y".
  // -------------------------------------------------------------------------
  def exercise8_schemaDiff(before: SchemaState, after: SchemaState): List[String] = ???

  def main(args: Array[String]): Unit = {
    // Exercise 1
    val m1 = exercise1_createUsersTable
    assert(m1.version == 1)
    val s1 = m1.up(SchemaState())
    assert(s1.tables.contains("users"))
    assert(s1.tables("users").columns.size == 3)
    val s1d = m1.down(s1)
    assert(!s1d.tables.contains("users"))
    println("Exercise 1 passed: create users migration")

    // Exercise 2
    val m2 = exercise2_addAgeColumn
    assert(m2.version == 2)
    val s2 = m2.up(s1)
    assert(s2.tables("users").columns.size == 4)
    assert(s2.tables("users").columns.exists(_.name == "age"))
    val s2d = m2.down(s2)
    assert(s2d.tables("users").columns.size == 3)
    println("Exercise 2 passed: add age column migration")

    // Exercise 3
    val init = SchemaState()
    val applied = exercise3_applyMigration(init, m1)
    assert(applied.isRight)
    assert(applied.exists(_.appliedMigrations.contains(1)))
    val duplicate = exercise3_applyMigration(applied.getOrElse(init), m1)
    assert(duplicate.isLeft)
    println("Exercise 3 passed: apply single migration")

    // Exercise 4
    val result4 = exercise4_applyAll(SchemaState(), List(m2, m1)) // out of order
    assert(result4.success)
    assert(result4.appliedVersions == List(1, 2))
    assert(result4.finalState.tables("users").columns.size == 4)
    println("Exercise 4 passed: apply all migrations")

    // Exercise 5
    val fullState = result4.finalState
    val rolledBack = exercise5_rollbackN(fullState, List(m1, m2), 1)
    assert(!rolledBack.appliedMigrations.contains(2))
    assert(rolledBack.tables("users").columns.size == 3) // age column removed
    println("Exercise 5 passed: rollback N migrations")

    // Exercise 6
    val partial = SchemaState(appliedMigrations = List(1))
    val pending = exercise6_pendingMigrations(partial, List(m1, m2))
    assert(pending.size == 1)
    assert(pending.head.version == 2)
    println("Exercise 6 passed: pending migrations")

    // Exercise 7
    assert(exercise7_validateOrder(List(m1, m2)).isRight)
    val m3Gap = Migration(4, "gap", identity, identity)
    assert(exercise7_validateOrder(List(m1, m2, m3Gap)).isLeft)
    val m1dup = Migration(1, "dup", identity, identity)
    assert(exercise7_validateOrder(List(m1, m1dup)).isLeft)
    println("Exercise 7 passed: validate migration order")

    // Exercise 8
    val before = SchemaState()
    val after = result4.finalState
    val diff = exercise8_schemaDiff(before, after)
    assert(diff.exists(_.contains("Added table")))
    println("Exercise 8 passed: schema diff")

    println("\nAll Doob014_Migration exercises passed!")
  }
}
