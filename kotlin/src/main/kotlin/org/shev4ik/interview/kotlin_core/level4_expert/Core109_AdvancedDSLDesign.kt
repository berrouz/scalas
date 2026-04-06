package org.shev4ik.interview.kotlin_core.level4_expert

/**
 * Complex DSL with multiple receivers
 */
object Core109_AdvancedDSLDesign {

    // Exercise 1: nestedReceivers
    // TODO: Implement nestedReceivers.
    // TODO: Topic: Complex DSL with multiple receivers.
    // TODO: Return a verifiable result of type String.
    fun exercise1_nestedReceivers(): String = TODO()

    // Exercise 2: scopeControl
    // TODO: Implement scopeControl.
    // TODO: Topic: Complex DSL with multiple receivers.
    // TODO: Return a verifiable result of type String.
    fun exercise2_scopeControl(): String = TODO()

    // Exercise 3: builderInference
    // TODO: Implement builderInference.
    // TODO: Topic: Complex DSL with multiple receivers.
    // TODO: Return a verifiable result of type String.
    fun exercise3_builderInference(): String = TODO()

    // Exercise 4: dslValidation
    // TODO: Implement dslValidation.
    // TODO: Topic: Complex DSL with multiple receivers.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_dslValidation(): Boolean = TODO()

    // Exercise 5: dslComposition
    // TODO: Implement dslComposition.
    // TODO: Topic: Complex DSL with multiple receivers.
    // TODO: Return a verifiable result of type Int.
    fun exercise5_dslComposition(): Int = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_nestedReceivers().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_scopeControl().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_builderInference().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_dslValidation() == true) { "Exercise 4 failed" }
        exercise5_dslComposition()
        println("All Core109_AdvancedDSLDesign exercises passed!")
    }
}
