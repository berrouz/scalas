package org.shev4ik.interview.arrow.level2_intermediate

/**
 * Software transactional memory
 */
object Arrow026_STM {

    // Exercise 1: tvar
    // TODO: Using Arrow library, implement tvar.
    // TODO: Topic: Software transactional memory.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_tvar(): String = TODO()

    // Exercise 2: stm
    // TODO: Using Arrow library, implement stm.
    // TODO: Topic: Software transactional memory.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_stm(): String = TODO()

    // Exercise 3: retry
    // TODO: Using Arrow library, implement retry.
    // TODO: Topic: Software transactional memory.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_retry(): String = TODO()

    // Exercise 4: orElse
    // TODO: Using Arrow library, implement orElse.
    // TODO: Topic: Software transactional memory.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_orElse(): String = TODO()

    // Exercise 5: atomically
    // TODO: Using Arrow library, implement atomically.
    // TODO: Topic: Software transactional memory.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_atomically(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_tvar().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_stm().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_retry().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_orElse().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_atomically().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow026_STM exercises passed!")
    }
}
