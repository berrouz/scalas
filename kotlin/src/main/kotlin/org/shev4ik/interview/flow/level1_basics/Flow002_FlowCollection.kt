package org.shev4ik.interview.flow.level1_basics

/**
 * Flow collection
 */
object Flow002_FlowCollection {

    // Exercise 1: collect
    // TODO: Implement collect for concurrency/streaming.
    // TODO: Topic: Flow collection.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise1_collect(): List<Int> = TODO()

    // Exercise 2: toList
    // TODO: Implement toList for concurrency/streaming.
    // TODO: Topic: Flow collection.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise2_toList(): Boolean = TODO()

    // Exercise 3: toSet
    // TODO: Implement toSet for concurrency/streaming.
    // TODO: Topic: Flow collection.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise3_toSet(): String = TODO()

    // Exercise 4: first
    // TODO: Implement first for concurrency/streaming.
    // TODO: Topic: Flow collection.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise4_first(): String = TODO()

    // Exercise 5: single
    // TODO: Implement single for concurrency/streaming.
    // TODO: Topic: Flow collection.
    // TODO: Use appropriate Kotlin concurrency primitives. Return a verifiable result.
    fun exercise5_single(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_collect().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_toList() == true) { "Exercise 2 failed" }
        assert(exercise3_toSet().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_first().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_single().isNotEmpty()) { "Exercise 5 failed" }
        println("All Flow002_FlowCollection exercises passed!")
    }
}
