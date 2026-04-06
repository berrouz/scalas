package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Concurrency patterns
 */
object Coro090_ConcurrencyPatterns {

    // Exercise 1: producerConsumer
    // TODO: Implement a coroutine exercise demonstrating producerConsumer.
    // TODO: Use runBlocking to make it testable. Topic: Concurrency patterns.
    // TODO: Return a verifiable result of type Int.
    fun exercise1_producerConsumer(): Int = TODO()

    // Exercise 2: pubSub
    // TODO: Implement a coroutine exercise demonstrating pubSub.
    // TODO: Use runBlocking to make it testable. Topic: Concurrency patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise2_pubSub(): String = TODO()

    // Exercise 3: workPool
    // TODO: Implement a coroutine exercise demonstrating workPool.
    // TODO: Use runBlocking to make it testable. Topic: Concurrency patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise3_workPool(): String = TODO()

    // Exercise 4: pipeline
    // TODO: Implement a coroutine exercise demonstrating pipeline.
    // TODO: Use runBlocking to make it testable. Topic: Concurrency patterns.
    // TODO: Return a verifiable result of type String.
    fun exercise4_pipeline(): String = TODO()

    // Exercise 5: mapReduce
    // TODO: Implement a coroutine exercise demonstrating mapReduce.
    // TODO: Use runBlocking to make it testable. Topic: Concurrency patterns.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise5_mapReduce(): Map<String, Int> = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        exercise1_producerConsumer()
        assert(exercise2_pubSub().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_workPool().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_pipeline().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_mapReduce().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro090_ConcurrencyPatterns exercises passed!")
    }
}
