package org.shev4ik.interview.sql.level1_basics

/**
 * INSERT, UPDATE, DELETE
 */
object Sql004_InsertUpdateDelete {

    // Exercise 1: insert
    // TODO: Insert "apple" into Trie, then search for it. Return true.
    fun exercise1_insert(): Boolean = TODO()

    // Exercise 2: update
    // TODO: Model the update concept.
    // TODO: Topic: INSERT, UPDATE, DELETE.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_update(): String = TODO()

    // Exercise 3: delete
    // TODO: Model the delete concept.
    // TODO: Topic: INSERT, UPDATE, DELETE.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_delete(): String = TODO()

    // Exercise 4: upsert
    // TODO: Model the upsert concept.
    // TODO: Topic: INSERT, UPDATE, DELETE.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_upsert(): String = TODO()

    // Exercise 5: returning
    // TODO: Model the returning concept.
    // TODO: Topic: INSERT, UPDATE, DELETE.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_returning(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_insert() == true) { "Exercise 1 failed" }
        assert(exercise2_update().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_delete().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_upsert().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_returning().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql004_InsertUpdateDelete exercises passed!")
    }
}
