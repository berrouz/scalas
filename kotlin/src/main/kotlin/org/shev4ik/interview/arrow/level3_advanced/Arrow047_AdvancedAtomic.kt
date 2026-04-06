package org.shev4ik.interview.arrow.level3_advanced

/**
 * Advanced atomic state
 */
object Arrow047_AdvancedAtomic {

    // Exercise 1: statePattern
    // TODO: Using Arrow library, implement statePattern.
    // TODO: Topic: Advanced atomic state.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_statePattern(): String = TODO()

    // Exercise 2: readModifyWrite
    // TODO: Using Arrow library, implement readModifyWrite.
    // TODO: Topic: Advanced atomic state.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_readModifyWrite(): String = TODO()

    // Exercise 3: consistent
    // TODO: Using Arrow library, implement consistent.
    // TODO: Topic: Advanced atomic state.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_consistent(): Boolean = TODO()

    // Exercise 4: snapshot
    // TODO: Using Arrow library, implement snapshot.
    // TODO: Topic: Advanced atomic state.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_snapshot(): String = TODO()

    // Exercise 5: multiAtomic
    // TODO: Using Arrow library, implement multiAtomic.
    // TODO: Topic: Advanced atomic state.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_multiAtomic(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_statePattern().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_readModifyWrite().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_consistent() == true) { "Exercise 3 failed" }
        assert(exercise4_snapshot().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_multiAtomic().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow047_AdvancedAtomic exercises passed!")
    }
}
