package org.shev4ik.interview.serialization.level2_intermediate

/**
 * Polymorphic serialization
 */
object Ser006_PolymorphicSer {

    // Exercise 1: sealed
    // TODO: Demonstrate sealed for kotlinx.serialization.
    // TODO: Topic: Polymorphic serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise1_sealed(): String = TODO()

    // Exercise 2: polymorphic
    // TODO: Demonstrate polymorphic for kotlinx.serialization.
    // TODO: Topic: Polymorphic serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise2_polymorphic(): String = TODO()

    // Exercise 3: discriminator
    // TODO: Demonstrate discriminator for kotlinx.serialization.
    // TODO: Topic: Polymorphic serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise3_discriminator(): Boolean = TODO()

    // Exercise 4: default
    // TODO: Demonstrate default for kotlinx.serialization.
    // TODO: Topic: Polymorphic serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise4_default(): String = TODO()

    // Exercise 5: custom
    // TODO: Demonstrate custom for kotlinx.serialization.
    // TODO: Topic: Polymorphic serialization.
    // TODO: Create serializable classes and demonstrate the concept.
    fun exercise5_custom(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_sealed().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_polymorphic().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_discriminator() == true) { "Exercise 3 failed" }
        assert(exercise4_default().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_custom().isNotEmpty()) { "Exercise 5 failed" }
        println("All Ser006_PolymorphicSer exercises passed!")
    }
}
