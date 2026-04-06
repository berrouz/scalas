package org.shev4ik.interview.sql.level3_advanced

/**
 * Table partitioning
 */
object Sql011_Partitioning {

    // Exercise 1: rangePartition
    // TODO: Model the rangePartition concept.
    // TODO: Topic: Table partitioning.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_rangePartition(): Pair<Int, Int> = TODO()

    // Exercise 2: listPartition
    // TODO: Model the listPartition concept.
    // TODO: Topic: Table partitioning.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_listPartition(): Boolean = TODO()

    // Exercise 3: hashPartition
    // TODO: Model the hashPartition concept.
    // TODO: Topic: Table partitioning.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_hashPartition(): Boolean = TODO()

    // Exercise 4: subPartition
    // TODO: Model the subPartition concept.
    // TODO: Topic: Table partitioning.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_subPartition(): Pair<Int, Int> = TODO()

    // Exercise 5: pruning
    // TODO: Model the pruning concept.
    // TODO: Topic: Table partitioning.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_pruning(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_rangePartition()
        assert(exercise2_listPartition() == true) { "Exercise 2 failed" }
        assert(exercise3_hashPartition() == true) { "Exercise 3 failed" }
        exercise4_subPartition()
        assert(exercise5_pruning().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sql011_Partitioning exercises passed!")
    }
}
