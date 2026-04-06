package org.shev4ik.interview.concurrency.level1_basics

/**
 * Synchronized
 */
object Conc003_Synchronized {

    // Exercise 1: syncBlock
    // TODO: Implement syncBlock for concurrency/streaming.
    // TODO: Topic: Synchronized.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_syncBlock(): String = TODO()

    // Exercise 2: syncMethod
    // TODO: Implement syncMethod for concurrency/streaming.
    // TODO: Topic: Synchronized.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_syncMethod(): String = TODO()

    // Exercise 3: monitor
    // TODO: Implement monitor for concurrency/streaming.
    // TODO: Topic: Synchronized.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_monitor(): String = TODO()

    // Exercise 4: intrinsicLock
    // TODO: Implement intrinsicLock for concurrency/streaming.
    // TODO: Topic: Synchronized.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_intrinsicLock(): String = TODO()

    // Exercise 5: reentrant
    // TODO: Implement reentrant for concurrency/streaming.
    // TODO: Topic: Synchronized.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_reentrant(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_syncBlock().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_syncMethod().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_monitor().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_intrinsicLock().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_reentrant().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc003_Synchronized exercises passed!")
    }
}
