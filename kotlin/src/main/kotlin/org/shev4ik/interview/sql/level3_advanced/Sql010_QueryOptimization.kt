package org.shev4ik.interview.sql.level3_advanced

/**
 * Query optimization
 */
object Sql010_QueryOptimization {

    // Exercise 1: explain
    // TODO: Model the explain concept.
    // TODO: Topic: Query optimization.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_explain(): String = TODO()

    // Exercise 2: executionPlan
    // TODO: Model the executionPlan concept.
    // TODO: Topic: Query optimization.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_executionPlan(): String = TODO()

    // Exercise 3: indexScan
    // TODO: Model the indexScan concept.
    // TODO: Topic: Query optimization.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_indexScan(): Int = TODO()

    // Exercise 4: seqScan
    // TODO: Model the seqScan concept.
    // TODO: Topic: Query optimization.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_seqScan(): String = TODO()

    // Exercise 5: joinStrategy
    // TODO: Model the joinStrategy concept.
    // TODO: Topic: Query optimization.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_joinStrategy(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_explain().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_executionPlan().isNotEmpty()) { "Exercise 2 failed" }
        exercise3_indexScan()
        assert(exercise4_seqScan().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_joinStrategy().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql010_QueryOptimization exercises passed!")
    }
}
