package org.shev4ik.interview.concurrency.level2_intermediate

/**
 * Concurrent collections
 */
object Conc014_ConcurrentCollections {

    // Exercise 1: concurrentHashMap
    // TODO: Implement concurrentHashMap for concurrency/streaming.
    // TODO: Topic: Concurrent collections.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_concurrentHashMap(): Boolean = TODO()

    // Exercise 2: copyOnWriteList
    // TODO: Implement copyOnWriteList for concurrency/streaming.
    // TODO: Topic: Concurrent collections.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_copyOnWriteList(): Boolean = TODO()

    // Exercise 3: blockingQueue
    // TODO: Implement blockingQueue for concurrency/streaming.
    // TODO: Topic: Concurrent collections.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_blockingQueue(): String = TODO()

    // Exercise 4: concurrentLinkedQueue
    // TODO: Implement concurrentLinkedQueue for concurrency/streaming.
    // TODO: Topic: Concurrent collections.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_concurrentLinkedQueue(): String = TODO()

    // Exercise 5: skipList
    // TODO: Implement skipList for concurrency/streaming.
    // TODO: Topic: Concurrent collections.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_skipList(): Boolean = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_concurrentHashMap() == true) { "Exercise 1 failed" }
        assert(exercise2_copyOnWriteList() == true) { "Exercise 2 failed" }
        assert(exercise3_blockingQueue().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_concurrentLinkedQueue().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_skipList() == true) { "Exercise 5 failed" }
        println("All Conc014_ConcurrentCollections exercises passed!")
    }
}
