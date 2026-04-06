package org.shev4ik.interview.concurrency.level1_basics

/**
 * ThreadLocal
 */
object Conc008_ThreadLocal {

    // Exercise 1: create
    // TODO: Implement create for concurrency/streaming.
    // TODO: Topic: ThreadLocal.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: initialValue
    // TODO: Implement initialValue for concurrency/streaming.
    // TODO: Topic: ThreadLocal.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_initialValue(): String = TODO()

    // Exercise 3: inheritance
    // TODO: Implement inheritance for concurrency/streaming.
    // TODO: Topic: ThreadLocal.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_inheritance(): String = TODO()

    // Exercise 4: remove
    // TODO: Implement remove for concurrency/streaming.
    // TODO: Topic: ThreadLocal.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_remove(): String = TODO()

    // Exercise 5: withThreadLocal
    // TODO: Implement withThreadLocal for concurrency/streaming.
    // TODO: Topic: ThreadLocal.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_withThreadLocal(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_initialValue().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_inheritance().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_remove().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_withThreadLocal().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc008_ThreadLocal exercises passed!")
    }
}
