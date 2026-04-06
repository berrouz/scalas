package org.shev4ik.interview.exposed.level2_intermediate

/**
 * Schema management
 */
object Exp010_SchemaManagement {

    // Exercise 1: createTables
    // TODO: Demonstrate createTables concept for exposed.
    // TODO: Topic: Schema management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_createTables(): String = TODO()

    // Exercise 2: dropTables
    // TODO: Demonstrate dropTables concept for exposed.
    // TODO: Topic: Schema management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_dropTables(): String = TODO()

    // Exercise 3: addColumn
    // TODO: Demonstrate addColumn concept for exposed.
    // TODO: Topic: Schema management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_addColumn(): String = TODO()

    // Exercise 4: migration
    // TODO: Demonstrate migration concept for exposed.
    // TODO: Topic: Schema management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_migration(): String = TODO()

    // Exercise 5: version
    // TODO: Demonstrate version concept for exposed.
    // TODO: Topic: Schema management.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_version(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_createTables().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_dropTables().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_addColumn().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_migration().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_version().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp010_SchemaManagement exercises passed!")
    }
}
