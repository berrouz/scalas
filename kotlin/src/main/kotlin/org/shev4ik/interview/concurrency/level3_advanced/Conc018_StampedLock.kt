package org.shev4ik.interview.concurrency.level3_advanced

/**
 * StampedLock
 */
object Conc018_StampedLock {

    // Exercise 1: readLock
    // TODO: Implement readLock for concurrency/streaming.
    // TODO: Topic: StampedLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_readLock(): String = TODO()

    // Exercise 2: writeLock
    // TODO: Implement writeLock for concurrency/streaming.
    // TODO: Topic: StampedLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_writeLock(): String = TODO()

    // Exercise 3: optimisticRead
    // TODO: Implement optimisticRead for concurrency/streaming.
    // TODO: Topic: StampedLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_optimisticRead(): Boolean = TODO()

    // Exercise 4: tryConvert
    // TODO: Implement tryConvert for concurrency/streaming.
    // TODO: Topic: StampedLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_tryConvert(): String = TODO()

    // Exercise 5: validate
    // TODO: Implement validate for concurrency/streaming.
    // TODO: Topic: StampedLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_validate(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readLock().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_writeLock().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_optimisticRead() == true) { "Exercise 3 failed" }
        assert(exercise4_tryConvert().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_validate() == true) { "Exercise 5 failed" }
        println("All Conc018_StampedLock exercises passed!")
    }
}
