package org.shev4ik.interview.channels_actors.level3_advanced

/**
 * Advanced actor patterns
 */
object Chan025_AdvActorPatterns {

    // Exercise 1: hierarchy
    // TODO: Implement hierarchy for concurrency/streaming.
    // TODO: Topic: Advanced actor patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_hierarchy(): String = TODO()

    // Exercise 2: supervision
    // TODO: Implement supervision for concurrency/streaming.
    // TODO: Topic: Advanced actor patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_supervision(): Boolean = TODO()

    // Exercise 3: routing
    // TODO: Implement routing for concurrency/streaming.
    // TODO: Topic: Advanced actor patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_routing(): String = TODO()

    // Exercise 4: persistence
    // TODO: Implement persistence for concurrency/streaming.
    // TODO: Topic: Advanced actor patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_persistence(): Boolean = TODO()

    // Exercise 5: cluster
    // TODO: Implement cluster for concurrency/streaming.
    // TODO: Topic: Advanced actor patterns.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_cluster(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_hierarchy().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_supervision() == true) { "Exercise 2 failed" }
        assert(exercise3_routing().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_persistence() == true) { "Exercise 4 failed" }
        assert(exercise5_cluster().isNotEmpty()) { "Exercise 5 failed" }
        println("All Chan025_AdvActorPatterns exercises passed!")
    }
}
