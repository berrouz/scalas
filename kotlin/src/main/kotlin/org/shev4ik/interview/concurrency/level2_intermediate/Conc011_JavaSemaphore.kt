package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * Java Semaphore
 */
object Conc011_JavaSemaphore {

    // Exercise 1: acquire
    // TODO: Implement acquire for concurrency/streaming.
    // TODO: Topic: Java Semaphore.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_acquire(): String = TODO()

    // Exercise 2: release
    // TODO: Implement release for concurrency/streaming.
    // TODO: Topic: Java Semaphore.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_release(): String = TODO()

    // Exercise 3: tryAcquire
    // TODO: Implement tryAcquire for concurrency/streaming.
    // TODO: Topic: Java Semaphore.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_tryAcquire(): String = TODO()

    // Exercise 4: permits
    // TODO: Implement permits for concurrency/streaming.
    // TODO: Topic: Java Semaphore.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_permits(): String = TODO()

    // Exercise 5: fairness
    // TODO: Implement fairness for concurrency/streaming.
    // TODO: Topic: Java Semaphore.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_fairness(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_acquire().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_release().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_tryAcquire().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_permits().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fairness().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc011_JavaSemaphore exercises passed!")
    }
}
