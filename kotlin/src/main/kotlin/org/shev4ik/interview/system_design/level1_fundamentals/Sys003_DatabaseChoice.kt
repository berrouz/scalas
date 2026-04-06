package org.shev4ik.interview.system_design.level1_fundamentals

/**
 * Database selection
 */
object Sys003_DatabaseChoice {

    // Exercise 1: sqlVsNoSQL
    // TODO: Model the sqlVsNoSQL concept.
    // TODO: Topic: Database selection.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_sqlVsNoSQL(): String = TODO()

    // Exercise 2: capTheorem
    // TODO: Model the capTheorem concept.
    // TODO: Topic: Database selection.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_capTheorem(): String = TODO()

    // Exercise 3: consistency
    // TODO: Model the consistency concept.
    // TODO: Topic: Database selection.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_consistency(): Boolean = TODO()

    // Exercise 4: availability
    // TODO: Model the availability concept.
    // TODO: Topic: Database selection.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_availability(): String = TODO()

    // Exercise 5: partition
    // TODO: Model the partition concept.
    // TODO: Topic: Database selection.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_partition(): Pair<Int, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sqlVsNoSQL().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_capTheorem().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_consistency() == true) { "Exercise 3 failed" }
        assert(exercise4_availability().isNotEmpty()) { "Exercise 4 failed" }
        exercise5_partition()
        println("All Sys003_DatabaseChoice exercises passed!")
    }
}
