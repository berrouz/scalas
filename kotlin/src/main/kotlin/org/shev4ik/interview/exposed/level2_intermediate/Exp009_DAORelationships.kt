package org.shev4ik.interview.exposed.level2_intermediate

/**
 * DAO relationships
 */
object Exp009_DAORelationships {

    // Exercise 1: oneToMany
    // TODO: Demonstrate oneToMany concept for exposed.
    // TODO: Topic: DAO relationships.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise1_oneToMany(): String = TODO()

    // Exercise 2: manyToMany
    // TODO: Demonstrate manyToMany concept for exposed.
    // TODO: Topic: DAO relationships.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise2_manyToMany(): String = TODO()

    // Exercise 3: references
    // TODO: Demonstrate references concept for exposed.
    // TODO: Topic: DAO relationships.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise3_references(): String = TODO()

    // Exercise 4: backReferences
    // TODO: Demonstrate backReferences concept for exposed.
    // TODO: Topic: DAO relationships.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise4_backReferences(): String = TODO()

    // Exercise 5: optional
    // TODO: Demonstrate optional concept for exposed.
    // TODO: Topic: DAO relationships.
    // TODO: Simulate the pattern (no actual server needed). Return a verifiable result.
    fun exercise5_optional(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_oneToMany().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_manyToMany().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_references().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_backReferences().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_optional().isNotEmpty()) { "Exercise 5 failed" }
        println("All Exp009_DAORelationships exercises passed!")
    }
}
