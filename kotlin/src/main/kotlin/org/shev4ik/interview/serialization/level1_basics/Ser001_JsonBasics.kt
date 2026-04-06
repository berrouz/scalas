package org.shev4ik.interview.serialization.level1_basics

/**
 * JSON serialization
 */
object Ser001_JsonBasics {

    // Exercise 1: encode
    // TODO: Demonstrate encode for kotlinx.serialization.
    // TODO: Topic: JSON serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_encode(): String = TODO()

    // Exercise 2: decode
    // TODO: Demonstrate decode for kotlinx.serialization.
    // TODO: Topic: JSON serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_decode(): String = TODO()

    // Exercise 3: dataClass
    // TODO: Demonstrate dataClass for kotlinx.serialization.
    // TODO: Topic: JSON serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_dataClass(): String = TODO()

    // Exercise 4: nested
    // TODO: Demonstrate nested for kotlinx.serialization.
    // TODO: Topic: JSON serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_nested(): String = TODO()

    // Exercise 5: collections
    // TODO: Demonstrate collections for kotlinx.serialization.
    // TODO: Topic: JSON serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_collections(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_encode().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_decode().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_dataClass().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_nested().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_collections().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser001_JsonBasics exercises passed!")
    }
}
