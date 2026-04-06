package org.shev4ik.interview.sql.level1_basics

/**
 * SELECT basics
 */
object Sql001_SelectBasics {

    // Exercise 1: simpleSelect
    // TODO: Model the simpleSelect concept.
    // TODO: Topic: SELECT basics.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_simpleSelect(): String = TODO()

    // Exercise 2: whereClause
    // TODO: Model the whereClause concept.
    // TODO: Topic: SELECT basics.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_whereClause(): String = TODO()

    // Exercise 3: orderBy
    // TODO: Model the orderBy concept.
    // TODO: Topic: SELECT basics.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_orderBy(): List<Int> = TODO()

    // Exercise 4: limit
    // TODO: Model the limit concept.
    // TODO: Topic: SELECT basics.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_limit(): String = TODO()

    // Exercise 5: distinct
    // TODO: Model the distinct concept.
    // TODO: Topic: SELECT basics.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_distinct(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_simpleSelect().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_whereClause().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_orderBy().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_limit().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_distinct() == true) { "Exercise 5 failed" }
        println("All Sql001_SelectBasics exercises passed!")
    }
}
