package org.shev4ik.interview.arrow.level1_basics

/**
 * NonEmptyList
 */
object Arrow007_NonEmptyList {

    // Exercise 1: create
    // TODO: Using Arrow library, implement create.
    // TODO: Topic: NonEmptyList.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise1_create(): String = TODO()

    // Exercise 2: map
    // TODO: Using Arrow library, implement map.
    // TODO: Topic: NonEmptyList.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise2_map(): Map<String, Int> = TODO()

    // Exercise 3: flatMap
    // TODO: Using Arrow library, implement flatMap.
    // TODO: Topic: NonEmptyList.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise3_flatMap(): Map<String, Int> = TODO()

    // Exercise 4: head
    // TODO: Using Arrow library, implement head.
    // TODO: Topic: NonEmptyList.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise4_head(): String = TODO()

    // Exercise 5: tail
    // TODO: Using Arrow library, implement tail.
    // TODO: Topic: NonEmptyList.
    // TODO: Demonstrate the concept with a concrete example and return verifiable result.
    fun exercise5_tail(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_create().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_map().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_flatMap().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_head().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_tail().isNotEmpty()) { "Exercise 5 failed" }
        println("All Arrow007_NonEmptyList exercises passed!")
    }
}
