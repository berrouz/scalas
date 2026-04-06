package org.shev4ik.interview.serialization.level2_intermediate

/**
 * JSON configuration
 */
object Ser008_JsonConfig {

    // Exercise 1: prettyPrint
    // TODO: Demonstrate prettyPrint for kotlinx.serialization.
    // TODO: Topic: JSON configuration.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_prettyPrint(): String = TODO()

    // Exercise 2: lenient
    // TODO: Demonstrate lenient for kotlinx.serialization.
    // TODO: Topic: JSON configuration.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_lenient(): String = TODO()

    // Exercise 3: ignoreUnknown
    // TODO: Demonstrate ignoreUnknown for kotlinx.serialization.
    // TODO: Topic: JSON configuration.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_ignoreUnknown(): String = TODO()

    // Exercise 4: coerceValues
    // TODO: Demonstrate coerceValues for kotlinx.serialization.
    // TODO: Topic: JSON configuration.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_coerceValues(): String = TODO()

    // Exercise 5: classDiscriminator
    // TODO: Demonstrate classDiscriminator for kotlinx.serialization.
    // TODO: Topic: JSON configuration.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_classDiscriminator(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_prettyPrint().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_lenient().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_ignoreUnknown().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_coerceValues().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_classDiscriminator() == true) { "Exercise 5 failed" }
        println("All Ser008_JsonConfig exercises passed!")
    }
}
