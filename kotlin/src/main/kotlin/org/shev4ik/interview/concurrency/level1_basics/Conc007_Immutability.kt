package org.shev4ik.interview.concurrency.level1_basics

/**
 * Thread-safe immutability
 */
object Conc007_Immutability {

    // Exercise 1: immutableData
    // TODO: Implement immutableData for concurrency/streaming.
    // TODO: Topic: Thread-safe immutability.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_immutableData(): String = TODO()

    // Exercise 2: defensiveCopy
    // TODO: Implement defensiveCopy for concurrency/streaming.
    // TODO: Topic: Thread-safe immutability.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_defensiveCopy(): String = TODO()

    // Exercise 3: frozenState
    // TODO: Implement frozenState for concurrency/streaming.
    // TODO: Topic: Thread-safe immutability.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_frozenState(): String = TODO()

    // Exercise 4: effectivelyFinal
    // TODO: Implement effectivelyFinal for concurrency/streaming.
    // TODO: Topic: Thread-safe immutability.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_effectivelyFinal(): String = TODO()

    // Exercise 5: publishSafely
    // TODO: Implement publishSafely for concurrency/streaming.
    // TODO: Topic: Thread-safe immutability.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_publishSafely(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_immutableData().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_defensiveCopy().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_frozenState().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_effectivelyFinal().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_publishSafely() == true) { "Exercise 5 failed" }
        println("All Conc007_Immutability exercises passed!")
    }
}
