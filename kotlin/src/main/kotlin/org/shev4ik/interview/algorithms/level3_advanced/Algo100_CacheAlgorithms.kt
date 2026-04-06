package org.shev4ik.interview.algorithms.level3_advanced

/**
 * Cache replacement algorithms
 */
object Algo100_CacheAlgorithms {

    // Exercise 1: lruCache
    // TODO: Implement LRU cache (capacity=2). put(1,1), put(2,2), get(1)→1, put(3,3) evicts 2.
    // TODO: get(2)→-1. Return get(2).
    fun exercise1_lruCache(): Int = TODO()

    // Exercise 2: lfuCache
    // TODO: Implement LFU cache (capacity=2). put(1,1), put(2,2), get(1)→1, put(3,3) evicts 2.
    // TODO: get(2)→-1. Return get(2).
    fun exercise2_lfuCache(): Int = TODO()

    // Exercise 3: fifoCache
    // TODO: Implement fifoCache.
    // TODO: Topic: Cache replacement algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise3_fifoCache(): Int = TODO()

    // Exercise 4: lruApprox
    // TODO: Implement lruApprox.
    // TODO: Topic: Cache replacement algorithms.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_lruApprox(): Int = TODO()

    // Exercise 5: twoQCache
    // TODO: Implement twoQCache.
    // TODO: Topic: Cache replacement algorithms.
    // TODO: Return a verifiable result of type Pair<Int, Int>.
    fun exercise5_twoQCache(): Pair<Int, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_lruCache() == -1) { "Exercise 1 failed" }
        assert(exercise2_lfuCache() == -1) { "Exercise 2 failed" }
        exercise3_fifoCache()
        exercise4_lruApprox()
        exercise5_twoQCache()
        println("All Algo100_CacheAlgorithms exercises passed!")
    }
}
