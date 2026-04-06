package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow debounce and sample
 */
object Coro065_FlowDebounce {

    // Exercise 1: debounce
    // TODO: Implement a coroutine exercise demonstrating debounce.
    // TODO: Use runBlocking to make it testable. Topic: Flow debounce and sample.
    // TODO: Return a verifiable result of type String.
    fun exercise1_debounce(): String = TODO()

    // Exercise 2: sample
    // TODO: Implement a coroutine exercise demonstrating sample.
    // TODO: Use runBlocking to make it testable. Topic: Flow debounce and sample.
    // TODO: Return a verifiable result of type String.
    fun exercise2_sample(): String = TODO()

    // Exercise 3: throttleFirst
    // TODO: Implement a coroutine exercise demonstrating throttleFirst.
    // TODO: Use runBlocking to make it testable. Topic: Flow debounce and sample.
    // TODO: Return a verifiable result of type String.
    fun exercise3_throttleFirst(): String = TODO()

    // Exercise 4: throttleLast
    // TODO: Implement a coroutine exercise demonstrating throttleLast.
    // TODO: Use runBlocking to make it testable. Topic: Flow debounce and sample.
    // TODO: Return a verifiable result of type String.
    fun exercise4_throttleLast(): String = TODO()

    // Exercise 5: windowedDebounce
    // TODO: Implement a coroutine exercise demonstrating windowedDebounce.
    // TODO: Use runBlocking to make it testable. Topic: Flow debounce and sample.
    // TODO: Return a verifiable result of type String.
    fun exercise5_windowedDebounce(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_debounce().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_sample().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_throttleFirst().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_throttleLast().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_windowedDebounce().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro065_FlowDebounce exercises passed!")
    }
}
