package org.shev4ik.interview.senior_architect.level4_production_systems

/**
 * Scalability
 */
object Arch043_Scalability {

    // Exercise 1: horizontal
    // TODO: Implement the design pattern/principle: horizontal.
    // TODO: Topic: Scalability.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise1_horizontal(): String = TODO()

    // Exercise 2: partitioning
    // TODO: Implement the design pattern/principle: partitioning.
    // TODO: Topic: Scalability.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise2_partitioning(): Pair<Int, Int> = TODO()

    // Exercise 3: sharding
    // TODO: Implement the design pattern/principle: sharding.
    // TODO: Topic: Scalability.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise3_sharding(): String = TODO()

    // Exercise 4: caching
    // TODO: Implement the design pattern/principle: caching.
    // TODO: Topic: Scalability.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise4_caching(): String = TODO()

    // Exercise 5: async
    // TODO: Implement the design pattern/principle: async.
    // TODO: Topic: Scalability.
    // TODO: Create classes/interfaces demonstrating this concept. Return a description or validation.
    fun exercise5_async(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_horizontal().isNotEmpty()) { "Exercise 1 failed" }
        exercise2_partitioning()
        assert(exercise3_sharding().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_caching().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_async().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arch043_Scalability exercises passed!")
    }
}
