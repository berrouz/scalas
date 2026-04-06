package org.shev4ik.interview.sql.level1_basics

/**
 * Aggregations
 */
object Sql003_Aggregations {

    // Exercise 1: groupBy
    // TODO: Model the groupBy concept.
    // TODO: Topic: Aggregations.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_groupBy(): Map<String, Int> = TODO()

    // Exercise 2: having
    // TODO: Model the having concept.
    // TODO: Topic: Aggregations.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_having(): String = TODO()

    // Exercise 3: count
    // TODO: Model the count concept.
    // TODO: Topic: Aggregations.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_count(): Int = TODO()

    // Exercise 4: sum
    // TODO: Model the sum concept.
    // TODO: Topic: Aggregations.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_sum(): Int = TODO()

    // Exercise 5: avg
    // TODO: Model the avg concept.
    // TODO: Topic: Aggregations.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_avg(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_groupBy().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_having().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_count()
        exercise4_sum()
        assert(exercise5_avg().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql003_Aggregations exercises passed!")
    }
}
