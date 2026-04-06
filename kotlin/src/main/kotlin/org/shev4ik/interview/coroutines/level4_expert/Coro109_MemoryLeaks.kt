package org.shev4ik.interview.coroutines.level4_expert

/**
 * Memory leak prevention
 */
object Coro109_MemoryLeaks {

    // Exercise 1: scopeLeak
    // TODO: Implement a coroutine exercise demonstrating scopeLeak.
    // TODO: Use runBlocking to make it testable. Topic: Memory leak prevention.
    // TODO: Return a verifiable result of type String.
    fun exercise1_scopeLeak(): String = TODO()

    // Exercise 2: globalLeak
    // TODO: Implement a coroutine exercise demonstrating globalLeak.
    // TODO: Use runBlocking to make it testable. Topic: Memory leak prevention.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_globalLeak(): List<Int> = TODO()

    // Exercise 3: flowLeak
    // TODO: Implement a coroutine exercise demonstrating flowLeak.
    // TODO: Use runBlocking to make it testable. Topic: Memory leak prevention.
    // TODO: Return a verifiable result of type String.
    fun exercise3_flowLeak(): String = TODO()

    // Exercise 4: channelLeak
    // TODO: Implement a coroutine exercise demonstrating channelLeak.
    // TODO: Use runBlocking to make it testable. Topic: Memory leak prevention.
    // TODO: Return a verifiable result of type String.
    fun exercise4_channelLeak(): String = TODO()

    // Exercise 5: callbackLeak
    // TODO: Implement a coroutine exercise demonstrating callbackLeak.
    // TODO: Use runBlocking to make it testable. Topic: Memory leak prevention.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_callbackLeak(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_scopeLeak().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_globalLeak().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_flowLeak().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_channelLeak().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_callbackLeak().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro109_MemoryLeaks exercises passed!")
    }
}
