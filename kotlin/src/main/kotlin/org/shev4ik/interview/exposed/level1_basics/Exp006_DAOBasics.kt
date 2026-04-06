package org.shev4ik.interview.exposed.level1_basics

/**
 * DAO basics
 */
object Exp006_DAOBasics {

    // Exercise 1: entity
    // TODO: Demonstrate entity concept for exposed.
    // TODO: Topic: DAO basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_entity(): String = TODO()

    // Exercise 2: intEntity
    // TODO: Demonstrate intEntity concept for exposed.
    // TODO: Topic: DAO basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_intEntity(): String = TODO()

    // Exercise 3: entityClass
    // TODO: Demonstrate entityClass concept for exposed.
    // TODO: Topic: DAO basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_entityClass(): String = TODO()

    // Exercise 4: findById
    // TODO: Demonstrate findById concept for exposed.
    // TODO: Topic: DAO basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_findById(): String = TODO()

    // Exercise 5: all
    // TODO: Demonstrate all concept for exposed.
    // TODO: Topic: DAO basics.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_all(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_entity().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_intEntity().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_entityClass().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_findById().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_all().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp006_DAOBasics exercises passed!")
    }
}
