package org.shev4ik.interview.system_design.level2_patterns

/**
 * Distributed cache
 */
object Sys009_DistributedCache {

    // Exercise 1: redis
    // TODO: Model the redis concept.
    // TODO: Topic: Distributed cache.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise1_redis(): Boolean = TODO()

    // Exercise 2: memcached
    // TODO: Model the memcached concept.
    // TODO: Topic: Distributed cache.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise2_memcached(): String = TODO()

    // Exercise 3: cacheAside
    // TODO: Model the cacheAside concept.
    // TODO: Topic: Distributed cache.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise3_cacheAside(): String = TODO()

    // Exercise 4: consistency
    // TODO: Model the consistency concept.
    // TODO: Topic: Distributed cache.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise4_consistency(): Boolean = TODO()

    // Exercise 5: eviction
    // TODO: Model the eviction concept.
    // TODO: Topic: Distributed cache.
    // TODO: Create a Kotlin implementation or simulation. Return a verifiable result.
    fun exercise5_eviction(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_redis() == true) { "Exercise 1 failed" }
        assert(exercise2_memcached().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_cacheAside().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_consistency() == true) { "Exercise 4 failed" }
        assert(exercise5_eviction().isNotEmpty()) { "Exercise 5 failed" }
        println("All Sys009_DistributedCache exercises passed!")
    }
}
