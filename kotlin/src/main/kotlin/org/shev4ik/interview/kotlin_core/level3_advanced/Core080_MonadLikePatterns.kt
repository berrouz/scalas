package org.shev4ik.interview.kotlin_core.level3_advanced

/**
 * Monad-like Patterns
 */
object Core080_MonadLikePatterns {

    // Exercise 1: flatMapChain
    // TODO: Implement flatMapChain.
    // TODO: Topic: Monad-like Patterns.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise1_flatMapChain(): Map<String, Int> = TODO()

    // Exercise 2: resultComposition
    // TODO: Implement resultComposition.
    // TODO: Topic: Monad-like Patterns.
    // TODO: Return a verifiable result of type Int.
    fun exercise2_resultComposition(): Int = TODO()

    // Exercise 3: nullableMonad
    // TODO: Implement nullableMonad.
    // TODO: Topic: Monad-like Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_nullableMonad(): String = TODO()

    // Exercise 4: eitherPattern
    // TODO: Implement eitherPattern.
    // TODO: Topic: Monad-like Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_eitherPattern(): String = TODO()

    // Exercise 5: ioPattern
    // TODO: Implement ioPattern.
    // TODO: Topic: Monad-like Patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise5_ioPattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flatMapChain().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_resultComposition()
        assert(exercise3_nullableMonad().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_eitherPattern().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_ioPattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Core080_MonadLikePatterns exercises passed!")
    }
}
