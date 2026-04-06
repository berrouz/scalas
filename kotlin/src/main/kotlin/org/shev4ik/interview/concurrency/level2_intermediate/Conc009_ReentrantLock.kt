package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * ReentrantLock
 */
object Conc009_ReentrantLock {

    // Exercise 1: lock
    // TODO: Implement lock for concurrency/streaming.
    // TODO: Topic: ReentrantLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_lock(): String = TODO()

    // Exercise 2: tryLock
    // TODO: Implement tryLock for concurrency/streaming.
    // TODO: Topic: ReentrantLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_tryLock(): String = TODO()

    // Exercise 3: lockInterruptibly
    // TODO: Implement lockInterruptibly for concurrency/streaming.
    // TODO: Topic: ReentrantLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_lockInterruptibly(): String = TODO()

    // Exercise 4: condition
    // TODO: Implement condition for concurrency/streaming.
    // TODO: Topic: ReentrantLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_condition(): String = TODO()

    // Exercise 5: fairness
    // TODO: Implement fairness for concurrency/streaming.
    // TODO: Topic: ReentrantLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_fairness(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_lock().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_tryLock().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_lockInterruptibly().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_condition().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_fairness().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc009_ReentrantLock exercises passed!")
    }
}
