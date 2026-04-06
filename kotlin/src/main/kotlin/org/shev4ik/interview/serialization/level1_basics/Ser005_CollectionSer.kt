package org.shev4ik.interview.serialization.level1_basics

/**
 * Collection serialization
 */
object Ser005_CollectionSer {

    // Exercise 1: list
    // TODO: Demonstrate list for kotlinx.serialization.
    // TODO: Topic: Collection serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_list(): Boolean = TODO()

    // Exercise 2: set
    // TODO: Demonstrate set for kotlinx.serialization.
    // TODO: Topic: Collection serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_set(): String = TODO()

    // Exercise 3: map
    // TODO: Demonstrate map for kotlinx.serialization.
    // TODO: Topic: Collection serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_map(): Map<String, Int> = TODO()

    // Exercise 4: nested
    // TODO: Demonstrate nested for kotlinx.serialization.
    // TODO: Topic: Collection serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_nested(): String = TODO()

    // Exercise 5: generic
    // TODO: Demonstrate generic for kotlinx.serialization.
    // TODO: Topic: Collection serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_generic(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_list() == true) { "Exercise 1 failed" }
        assert(exercise2_set().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_map().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_nested().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_generic().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser005_CollectionSer exercises passed!")
    }
}
