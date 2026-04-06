package org.shev4ik.interview.concurrency.level1_basics

/**
 * Volatile annotation
 */
object Conc004_Volatile {

    // Exercise 1: volatile
    // TODO: Implement volatile for concurrency/streaming.
    // TODO: Topic: Volatile annotation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_volatile(): String = TODO()

    // Exercise 2: visibility
    // TODO: Implement visibility for concurrency/streaming.
    // TODO: Topic: Volatile annotation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_visibility(): Boolean = TODO()

    // Exercise 3: ordering
    // TODO: Implement ordering for concurrency/streaming.
    // TODO: Topic: Volatile annotation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_ordering(): List<Int> = TODO()

    // Exercise 4: atomicVsVolatile
    // TODO: Implement atomicVsVolatile for concurrency/streaming.
    // TODO: Topic: Volatile annotation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_atomicVsVolatile(): String = TODO()

    // Exercise 5: doubleCheckLock
    // TODO: Implement doubleCheckLock for concurrency/streaming.
    // TODO: Topic: Volatile annotation.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_doubleCheckLock(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_volatile().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_visibility() == true) { "Exercise 2 failed" }
        assert(exercise3_ordering().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_atomicVsVolatile().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_doubleCheckLock() == true) { "Exercise 5 failed" }
        println("All Conc004_Volatile exercises passed!")
    }
}
