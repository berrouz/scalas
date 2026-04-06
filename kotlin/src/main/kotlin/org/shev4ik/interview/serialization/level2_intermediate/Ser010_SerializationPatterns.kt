package org.shev4ik.interview.serialization.level2_intermediate

/**
 * Serialization patterns
 */
object Ser010_SerializationPatterns {

    // Exercise 1: dto
    // TODO: Demonstrate dto for kotlinx.serialization.
    // TODO: Topic: Serialization patterns.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_dto(): String = TODO()

    // Exercise 2: versioning
    // TODO: Demonstrate versioning for kotlinx.serialization.
    // TODO: Topic: Serialization patterns.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_versioning(): String = TODO()

    // Exercise 3: migration
    // TODO: Demonstrate migration for kotlinx.serialization.
    // TODO: Topic: Serialization patterns.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_migration(): String = TODO()

    // Exercise 4: validation
    // TODO: Demonstrate validation for kotlinx.serialization.
    // TODO: Topic: Serialization patterns.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_validation(): Boolean = TODO()

    // Exercise 5: adapter
    // TODO: Demonstrate adapter for kotlinx.serialization.
    // TODO: Topic: Serialization patterns.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_adapter(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_dto().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_versioning().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_migration().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_validation() == true) { "Exercise 4 failed" }
        assert(exercise5_adapter().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser010_SerializationPatterns exercises passed!")
    }
}
