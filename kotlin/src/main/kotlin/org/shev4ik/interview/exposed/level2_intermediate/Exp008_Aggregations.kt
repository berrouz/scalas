package org.shev4ik.interview.exposed.level2_intermediate

/**
 * Aggregations
 */
object Exp008_Aggregations {

    // Exercise 1: count
    // TODO: Demonstrate count concept for exposed.
    // TODO: Topic: Aggregations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_count(): Int = TODO()

    // Exercise 2: sum
    // TODO: Demonstrate sum concept for exposed.
    // TODO: Topic: Aggregations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_sum(): Int = TODO()

    // Exercise 3: avg
    // TODO: Demonstrate avg concept for exposed.
    // TODO: Topic: Aggregations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_avg(): String = TODO()

    // Exercise 4: groupBy
    // TODO: Demonstrate groupBy concept for exposed.
    // TODO: Topic: Aggregations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_groupBy(): Map<String, Int> = TODO()

    // Exercise 5: having
    // TODO: Demonstrate having concept for exposed.
    // TODO: Topic: Aggregations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_having(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_count()
        exercise2_sum()
        assert(exercise3_avg().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_groupBy().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_having().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp008_Aggregations exercises passed!")
    }
}
