package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Batch processing
 */
object Coro099_BatchProcessing {

    // Exercise 1: batchCollect
    // TODO: Implement a coroutine exercise demonstrating batchCollect.
    // TODO: Use runBlocking to make it testable. Topic: Batch processing.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_batchCollect(): List<Int> = TODO()

    // Exercise 2: windowedBatch
    // TODO: Implement a coroutine exercise demonstrating windowedBatch.
    // TODO: Use runBlocking to make it testable. Topic: Batch processing.
    // TODO: Return a verifiable result of type String.
    fun exercise2_windowedBatch(): String = TODO()

    // Exercise 3: timedBatch
    // TODO: Implement a coroutine exercise demonstrating timedBatch.
    // TODO: Use runBlocking to make it testable. Topic: Batch processing.
    // TODO: Return a verifiable result of type String.
    fun exercise3_timedBatch(): String = TODO()

    // Exercise 4: sizeBatch
    // TODO: Implement a coroutine exercise demonstrating sizeBatch.
    // TODO: Use runBlocking to make it testable. Topic: Batch processing.
    // TODO: Return a verifiable result of type Int.
    fun exercise4_sizeBatch(): Int = TODO()

    // Exercise 5: errorBatch
    // TODO: Implement a coroutine exercise demonstrating errorBatch.
    // TODO: Use runBlocking to make it testable. Topic: Batch processing.
    // TODO: Return a verifiable result of type String.
    fun exercise5_errorBatch(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_batchCollect().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_windowedBatch().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_timedBatch().isNotEmpty()) { "Exercise 3 failed" }
        exercise4_sizeBatch()
        assert(exercise5_errorBatch().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro099_BatchProcessing exercises passed!")
    }
}
