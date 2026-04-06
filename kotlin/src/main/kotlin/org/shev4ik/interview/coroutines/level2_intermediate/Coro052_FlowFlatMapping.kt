package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Flow flat mapping
 */
object Coro052_FlowFlatMapping {

    // Exercise 1: flatMapConcat
    // TODO: Implement a coroutine exercise demonstrating flatMapConcat.
    // TODO: Use runBlocking to make it testable. Topic: Flow flat mapping.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise1_flatMapConcat(): Map<String, Int> = TODO()

    // Exercise 2: flatMapMerge
    // TODO: Implement a coroutine exercise demonstrating flatMapMerge.
    // TODO: Use runBlocking to make it testable. Topic: Flow flat mapping.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_flatMapMerge(): List<Int> = TODO()

    // Exercise 3: flatMapLatest
    // TODO: Implement a coroutine exercise demonstrating flatMapLatest.
    // TODO: Use runBlocking to make it testable. Topic: Flow flat mapping.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise3_flatMapLatest(): Boolean = TODO()

    // Exercise 4: concurrency
    // TODO: Implement a coroutine exercise demonstrating concurrency.
    // TODO: Use runBlocking to make it testable. Topic: Flow flat mapping.
    // TODO: Return a verifiable result of type String.
    fun exercise4_concurrency(): String = TODO()

    // Exercise 5: switching
    // TODO: Implement a coroutine exercise demonstrating switching.
    // TODO: Use runBlocking to make it testable. Topic: Flow flat mapping.
    // TODO: Return a verifiable result of type String.
    fun exercise5_switching(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_flatMapConcat().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_flatMapMerge().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_flatMapLatest() == true) { "Exercise 3 failed" }
        assert(exercise4_concurrency().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_switching().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro052_FlowFlatMapping exercises passed!")
    }
}
