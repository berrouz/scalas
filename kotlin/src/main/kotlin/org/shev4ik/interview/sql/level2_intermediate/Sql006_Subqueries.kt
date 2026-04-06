package org.shev4ik.interview.sql.level2_intermediate

/**
 * Subqueries
 */
object Sql006_Subqueries {

    // Exercise 1: scalar
    // TODO: Model the scalar concept.
    // TODO: Topic: Subqueries.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_scalar(): String = TODO()

    // Exercise 2: correlated
    // TODO: Model the correlated concept.
    // TODO: Topic: Subqueries.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_correlated(): String = TODO()

    // Exercise 3: exists
    // TODO: Model the exists concept.
    // TODO: Topic: Subqueries.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_exists(): Boolean = TODO()

    // Exercise 4: in_query
    // TODO: Model the in query concept.
    // TODO: Topic: Subqueries.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_in_query(): String = TODO()

    // Exercise 5: withClause
    // TODO: Model the withClause concept.
    // TODO: Topic: Subqueries.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_withClause(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_scalar().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_correlated().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_exists() == true) { "Exercise 3 failed" }
        assert(exercise4_in_query().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_withClause().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql006_Subqueries exercises passed!")
    }
}
