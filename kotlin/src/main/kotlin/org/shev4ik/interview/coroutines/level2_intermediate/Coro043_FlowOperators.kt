package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow operators
 */
object Coro043_FlowOperators {

    // Exercise 1: map
    // TODO: Implement a coroutine exercise demonstrating map.
    // TODO: Use runBlocking to make it testable. Topic: Flow operators.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise1_map(): Map<String, Int> = TODO()

    // Exercise 2: filter
    // TODO: Implement a coroutine exercise demonstrating filter.
    // TODO: Use runBlocking to make it testable. Topic: Flow operators.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_filter(): List<Int> = TODO()

    // Exercise 3: transform
    // TODO: Implement a coroutine exercise demonstrating transform.
    // TODO: Use runBlocking to make it testable. Topic: Flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise3_transform(): String = TODO()

    // Exercise 4: take
    // TODO: Implement a coroutine exercise demonstrating take.
    // TODO: Use runBlocking to make it testable. Topic: Flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise4_take(): String = TODO()

    // Exercise 5: zip
    // TODO: Implement a coroutine exercise demonstrating zip.
    // TODO: Use runBlocking to make it testable. Topic: Flow operators.
    // TODO: Return a verifiable result of type String.
    fun exercise5_zip(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_map().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_filter().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_transform().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_take().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_zip().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro043_FlowOperators exercises passed!")
    }
}
