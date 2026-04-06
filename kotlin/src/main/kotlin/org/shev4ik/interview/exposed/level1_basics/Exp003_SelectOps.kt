package org.shev4ik.interview.exposed.level1_basics

/**
 * Select operations
 */
object Exp003_SelectOps {

    // Exercise 1: selectAll
    // TODO: Demonstrate selectAll concept for exposed.
    // TODO: Topic: Select operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_selectAll(): List<Int> = TODO()

    // Exercise 2: selectWhere
    // TODO: Demonstrate selectWhere concept for exposed.
    // TODO: Topic: Select operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_selectWhere(): String = TODO()

    // Exercise 3: andWhere
    // TODO: Demonstrate andWhere concept for exposed.
    // TODO: Topic: Select operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_andWhere(): String = TODO()

    // Exercise 4: orderBy
    // TODO: Demonstrate orderBy concept for exposed.
    // TODO: Topic: Select operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_orderBy(): List<Int> = TODO()

    // Exercise 5: limit
    // TODO: Demonstrate limit concept for exposed.
    // TODO: Topic: Select operations.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_limit(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_selectAll().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_selectWhere().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_andWhere().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_orderBy().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_limit().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp003_SelectOps exercises passed!")
    }
}
