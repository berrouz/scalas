package org.shev4ik.interview.sql.level2_intermediate

/**
 * Window functions
 */
object Sql007_WindowFunctions {

    // Exercise 1: rowNumber
    // TODO: Model the rowNumber concept.
    // TODO: Topic: Window functions.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_rowNumber(): Int = TODO()

    // Exercise 2: rank
    // TODO: Model the rank concept.
    // TODO: Topic: Window functions.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_rank(): String = TODO()

    // Exercise 3: denseRank
    // TODO: Model the denseRank concept.
    // TODO: Topic: Window functions.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_denseRank(): String = TODO()

    // Exercise 4: lead
    // TODO: Model the lead concept.
    // TODO: Topic: Window functions.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_lead(): String = TODO()

    // Exercise 5: lag
    // TODO: Model the lag concept.
    // TODO: Topic: Window functions.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_lag(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_rowNumber()
        assert(exercise2_rank().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_denseRank().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_lead().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_lag().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql007_WindowFunctions exercises passed!")
    }
}
