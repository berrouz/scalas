package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * ReadWriteLock
 */
object Conc010_ReadWriteLock {

    // Exercise 1: readLock
    // TODO: Implement readLock for concurrency/streaming.
    // TODO: Topic: ReadWriteLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_readLock(): String = TODO()

    // Exercise 2: writeLock
    // TODO: Implement writeLock for concurrency/streaming.
    // TODO: Topic: ReadWriteLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_writeLock(): String = TODO()

    // Exercise 3: concurrentReaders
    // TODO: Implement concurrentReaders for concurrency/streaming.
    // TODO: Topic: ReadWriteLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_concurrentReaders(): String = TODO()

    // Exercise 4: exclusiveWriter
    // TODO: Implement exclusiveWriter for concurrency/streaming.
    // TODO: Topic: ReadWriteLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_exclusiveWriter(): String = TODO()

    // Exercise 5: upgrade
    // TODO: Implement upgrade for concurrency/streaming.
    // TODO: Topic: ReadWriteLock.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_upgrade(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_readLock().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_writeLock().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_concurrentReaders().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_exclusiveWriter().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_upgrade().isNotEmpty()) { "Exercise 5 failed" }
        println("All Conc010_ReadWriteLock exercises passed!")
    }
}
