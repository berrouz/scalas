package org.shev4ik.interview.coroutines.level1_basics

/**
 * async and await
 */
object Coro002_AsyncAwait {

    // Exercise 1: basicAsync
    // TODO: Implement a coroutine exercise demonstrating basicAsync.
    // TODO: Use runBlocking to make it testable. Topic: async and await.
    // TODO: Return a verifiable result of type String.
    fun exercise1_basicAsync(): String = TODO()

    // Exercise 2: awaitResult
    // TODO: Implement a coroutine exercise demonstrating awaitResult.
    // TODO: Use runBlocking to make it testable. Topic: async and await.
    // TODO: Return a verifiable result of type String.
    fun exercise2_awaitResult(): String = TODO()

    // Exercise 3: parallelAsync
    // TODO: Implement a coroutine exercise demonstrating parallelAsync.
    // TODO: Use runBlocking to make it testable. Topic: async and await.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_parallelAsync(): List<Int> = TODO()

    // Exercise 4: deferredList
    // TODO: Implement a coroutine exercise demonstrating deferredList.
    // TODO: Use runBlocking to make it testable. Topic: async and await.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise4_deferredList(): Boolean = TODO()

    // Exercise 5: awaitAll
    // TODO: Implement a coroutine exercise demonstrating awaitAll.
    // TODO: Use runBlocking to make it testable. Topic: async and await.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise5_awaitAll(): List<Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_basicAsync().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_awaitResult().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parallelAsync().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_deferredList() == true) { "Exercise 4 failed" }
        assert(exercise5_awaitAll().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro002_AsyncAwait exercises passed!")
    }
}
