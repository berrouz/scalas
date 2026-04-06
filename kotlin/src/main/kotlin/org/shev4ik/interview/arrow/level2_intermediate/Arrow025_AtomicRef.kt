package org.shev4ik.interview.arrow.level2_intermediate

/**
 * Atomic references
 */
object Arrow025_AtomicRef {

    // Exercise 1: create
    // TODO: Using Arrow library, implement create.
    // TODO: Topic: Atomic references.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: update
    // TODO: Using Arrow library, implement update.
    // TODO: Topic: Atomic references.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_update(): String = TODO()

    // Exercise 3: modify
    // TODO: Using Arrow library, implement modify.
    // TODO: Topic: Atomic references.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_modify(): String = TODO()

    // Exercise 4: getAndSet
    // TODO: Using Arrow library, implement getAndSet.
    // TODO: Topic: Atomic references.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_getAndSet(): String = TODO()

    // Exercise 5: compareAndSet
    // TODO: Using Arrow library, implement compareAndSet.
    // TODO: Topic: Atomic references.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_compareAndSet(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_update().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_modify().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_getAndSet().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_compareAndSet() == true) { "Exercise 5 failed" }
        println("All Arrow025_AtomicRef exercises passed!")
    }
}
