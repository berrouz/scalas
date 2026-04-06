package org.shev4ik.interview.arrow.level1_basics

/**
 * Raise DSL basics
 */
object Arrow008_RaiseBasics {

    // Exercise 1: raise
    // TODO: Using Arrow library, implement raise.
    // TODO: Topic: Raise DSL basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_raise(): Boolean = TODO()

    // Exercise 2: ensure
    // TODO: Using Arrow library, implement ensure.
    // TODO: Topic: Raise DSL basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_ensure(): String = TODO()

    // Exercise 3: ensureNotNull
    // TODO: Using Arrow library, implement ensureNotNull.
    // TODO: Topic: Raise DSL basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_ensureNotNull(): String = TODO()

    // Exercise 4: bind
    // TODO: Using Arrow library, implement bind.
    // TODO: Topic: Raise DSL basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_bind(): String = TODO()

    // Exercise 5: recover
    // TODO: Using Arrow library, implement recover.
    // TODO: Topic: Raise DSL basics.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_recover(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_raise() == true) { "Exercise 1 failed" }
        assert(exercise2_ensure().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_ensureNotNull().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_bind().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_recover().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow008_RaiseBasics exercises passed!")
    }
}
