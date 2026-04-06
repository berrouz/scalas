package org.shev4ik.interview.serialization.level1_basics

/**
 * Nullable fields
 */
object Ser004_NullableFields {

    // Exercise 1: nullable
    // TODO: Demonstrate nullable for kotlinx.serialization.
    // TODO: Topic: Nullable fields.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_nullable(): String = TODO()

    // Exercise 2: absent
    // TODO: Demonstrate absent for kotlinx.serialization.
    // TODO: Topic: Nullable fields.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_absent(): String = TODO()

    // Exercise 3: explicitNull
    // TODO: Demonstrate explicitNull for kotlinx.serialization.
    // TODO: Topic: Nullable fields.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_explicitNull(): String = TODO()

    // Exercise 4: coerceToNull
    // TODO: Demonstrate coerceToNull for kotlinx.serialization.
    // TODO: Topic: Nullable fields.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_coerceToNull(): String = TODO()

    // Exercise 5: defaultNull
    // TODO: Demonstrate defaultNull for kotlinx.serialization.
    // TODO: Topic: Nullable fields.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_defaultNull(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nullable().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_absent().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_explicitNull().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_coerceToNull().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_defaultNull().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser004_NullableFields exercises passed!")
    }
}
