package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * DistinctUntilChanged
 */
object Coro066_DistinctUntilChanged {

    // Exercise 1: basic
    // TODO: Implement a coroutine exercise demonstrating basic.
    // TODO: Use runBlocking to make it testable. Topic: DistinctUntilChanged.
    // TODO: Return a verifiable result of type String.
    fun exercise1_basic(): String = TODO()

    // Exercise 2: byKey
    // TODO: Implement a coroutine exercise demonstrating byKey.
    // TODO: Use runBlocking to make it testable. Topic: DistinctUntilChanged.
    // TODO: Return a verifiable result of type String.
    fun exercise2_byKey(): String = TODO()

    // Exercise 3: customCompare
    // TODO: Implement a coroutine exercise demonstrating customCompare.
    // TODO: Use runBlocking to make it testable. Topic: DistinctUntilChanged.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_customCompare(): Boolean = TODO()

    // Exercise 4: referenceEquality
    // TODO: Implement a coroutine exercise demonstrating referenceEquality.
    // TODO: Use runBlocking to make it testable. Topic: DistinctUntilChanged.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_referenceEquality(): Boolean = TODO()

    // Exercise 5: withTransform
    // TODO: Implement a coroutine exercise demonstrating withTransform.
    // TODO: Use runBlocking to make it testable. Topic: DistinctUntilChanged.
    // TODO: Return a verifiable result of type String.
    fun exercise5_withTransform(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basic().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_byKey().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_customCompare() == true) { "Exercise 3 failed" }
        assert(exercise4_referenceEquality() == true) { "Exercise 4 failed" }
        assert(exercise5_withTransform().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro066_DistinctUntilChanged exercises passed!")
    }
}
