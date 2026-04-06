package org.shev4ik.interview.concurrency.level1_basics

/**
 * Atomic types
 */
object Conc005_AtomicTypes {

    // Exercise 1: atomicInt
    // TODO: Implement atomicInt for concurrency/streaming.
    // TODO: Topic: Atomic types.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_atomicInt(): String = TODO()

    // Exercise 2: atomicLong
    // TODO: Implement atomicLong for concurrency/streaming.
    // TODO: Topic: Atomic types.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_atomicLong(): String = TODO()

    // Exercise 3: atomicRef
    // TODO: Implement atomicRef for concurrency/streaming.
    // TODO: Topic: Atomic types.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_atomicRef(): String = TODO()

    // Exercise 4: compareAndSet
    // TODO: Implement compareAndSet for concurrency/streaming.
    // TODO: Topic: Atomic types.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_compareAndSet(): Boolean = TODO()

    // Exercise 5: getAndUpdate
    // TODO: Implement getAndUpdate for concurrency/streaming.
    // TODO: Topic: Atomic types.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_getAndUpdate(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_atomicInt().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_atomicLong().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_atomicRef().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_compareAndSet() == true) { "Exercise 4 failed" }
        assert(exercise5_getAndUpdate().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc005_AtomicTypes exercises passed!")
    }
}
