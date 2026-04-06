package org.shev4ik.interview.advanced_fp.level1_foundations

/**
 * MonadError pattern
 */
object Fp011_MonadError {

    // Exercise 1: raiseError
    // TODO: Implement the functional programming concept: raiseError.
    // TODO: Topic: MonadError pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise1_raiseError(): Boolean = TODO()

    // Exercise 2: handleError
    // TODO: Implement the functional programming concept: handleError.
    // TODO: Topic: MonadError pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise2_handleError(): String = TODO()

    // Exercise 3: attempt
    // TODO: Implement the functional programming concept: attempt.
    // TODO: Topic: MonadError pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise3_attempt(): String = TODO()

    // Exercise 4: ensure
    // TODO: Implement the functional programming concept: ensure.
    // TODO: Topic: MonadError pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise4_ensure(): String = TODO()

    // Exercise 5: adaptError
    // TODO: Implement the functional programming concept: adaptError.
    // TODO: Topic: MonadError pattern.
    // TODO: Create a practical demonstration that returns a verifiable result.
    fun exercise5_adaptError(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_raiseError() == true) { "Exercise 1 failed" }
        assert(exercise2_handleError().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_attempt().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_ensure().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_adaptError().isNotEmpty()) { "Exercise 5 failed" }
        println("All Fp011_MonadError exercises passed!")
    }
}
