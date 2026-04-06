package org.shev4ik.interview.arrow.level1_basics

/**
 * Typeclass patterns
 */
object Arrow013_TypeclassPatterns {

    // Exercise 1: monoid
    // TODO: Using Arrow library, implement monoid.
    // TODO: Topic: Typeclass patterns.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_monoid(): String = TODO()

    // Exercise 2: semigroup
    // TODO: Using Arrow library, implement semigroup.
    // TODO: Topic: Typeclass patterns.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_semigroup(): Map<String, Int> = TODO()

    // Exercise 3: combine
    // TODO: Using Arrow library, implement combine.
    // TODO: Topic: Typeclass patterns.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_combine(): List<Int> = TODO()

    // Exercise 4: empty
    // TODO: Using Arrow library, implement empty.
    // TODO: Topic: Typeclass patterns.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_empty(): String = TODO()

    // Exercise 5: foldMap
    // TODO: Using Arrow library, implement foldMap.
    // TODO: Topic: Typeclass patterns.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_foldMap(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_monoid().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_semigroup().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_combine().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_empty().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_foldMap().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow013_TypeclassPatterns exercises passed!")
    }
}
