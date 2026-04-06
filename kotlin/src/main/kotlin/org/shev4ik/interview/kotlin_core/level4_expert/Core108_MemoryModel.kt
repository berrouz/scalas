package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * JVM memory model from Kotlin
 */
object Core108_MemoryModel {

    // Exercise 1: volatileField
    // TODO: Implement volatileField.
    // TODO: Topic: JVM memory model from Kotlin.
    // TODO: Return a verifiable result of type String.
    fun exercise1_volatileField(): String = TODO()

    // Exercise 2: atomicUpdate
    // TODO: Implement atomicUpdate.
    // TODO: Topic: JVM memory model from Kotlin.
    // TODO: Return a verifiable result of type String.
    fun exercise2_atomicUpdate(): String = TODO()

    // Exercise 3: happensBefore
    // TODO: Implement happensBefore.
    // TODO: Topic: JVM memory model from Kotlin.
    // TODO: Return a verifiable result of type String.
    fun exercise3_happensBefore(): String = TODO()

    // Exercise 4: publicationSafety
    // TODO: Implement publicationSafety.
    // TODO: Topic: JVM memory model from Kotlin.
    // TODO: Return a verifiable result of type String.
    fun exercise4_publicationSafety(): String = TODO()

    // Exercise 5: safePublication
    // TODO: Implement safePublication.
    // TODO: Topic: JVM memory model from Kotlin.
    // TODO: Return a verifiable result of type String.
    fun exercise5_safePublication(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_volatileField().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_atomicUpdate().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_happensBefore().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_publicationSafety().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_safePublication().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core108_MemoryModel exercises passed!")
    }
}
