package org.shev4ik.interview.kotlin_core.level3_advanced

/**
 * Advanced Inline Patterns
 */
object Core076_AdvancedInline {

    // Exercise 1: inlineClassComposition
    // TODO: Implement inlineClassComposition.
    // TODO: Topic: Advanced Inline Patterns.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_inlineClassComposition(): Int = TODO()

    // Exercise 2: inlineLambdaControl
    // TODO: Implement inlineLambdaControl.
    // TODO: Topic: Advanced Inline Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_inlineLambdaControl(): String = TODO()

    // Exercise 3: nonLocalReturn
    // TODO: Implement nonLocalReturn.
    // TODO: Topic: Advanced Inline Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_nonLocalReturn(): String = TODO()

    // Exercise 4: inlineReified
    // TODO: Implement inlineReified.
    // TODO: Topic: Advanced Inline Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_inlineReified(): String = TODO()

    // Exercise 5: crossinlinePattern
    // TODO: Implement crossinlinePattern.
    // TODO: Topic: Advanced Inline Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_crossinlinePattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_inlineClassComposition()
        assert(exercise2_inlineLambdaControl().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_nonLocalReturn().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_inlineReified().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_crossinlinePattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core076_AdvancedInline exercises passed!")
    }
}
