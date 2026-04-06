package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Security patterns
 */
object Arch045_SecurityPatterns {

    // Exercise 1: authentication
    // TODO: Implement the design pattern/principle: authentication.
    // TODO: Topic: Security patterns.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise1_authentication(): String = TODO()

    // Exercise 2: authorization
    // TODO: Implement the design pattern/principle: authorization.
    // TODO: Topic: Security patterns.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise2_authorization(): String = TODO()

    // Exercise 3: encryption
    // TODO: Implement the design pattern/principle: encryption.
    // TODO: Topic: Security patterns.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise3_encryption(): String = TODO()

    // Exercise 4: inputValidation
    // TODO: Implement the design pattern/principle: inputValidation.
    // TODO: Topic: Security patterns.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise4_inputValidation(): Boolean = TODO()

    // Exercise 5: secretManagement
    // TODO: Implement the design pattern/principle: secretManagement.
    // TODO: Topic: Security patterns.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise5_secretManagement(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_authentication().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_authorization().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_encryption().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_inputValidation() == true) { "Exercise 4 failed" }
        assert(exercise5_secretManagement().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arch045_SecurityPatterns exercises passed!")
    }
}
