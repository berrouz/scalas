package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Pipeline processing
 */
object Coro098_PipelineProcessing {

    // Exercise 1: multiStage
    // TODO: Implement a coroutine exercise demonstrating multiStage.
    // TODO: Use runBlocking to make it testable. Topic: Pipeline processing.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise1_multiStage(): Boolean = TODO()

    // Exercise 2: parallelStage
    // TODO: Implement a coroutine exercise demonstrating parallelStage.
    // TODO: Use runBlocking to make it testable. Topic: Pipeline processing.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_parallelStage(): List<Int> = TODO()

    // Exercise 3: errorStage
    // TODO: Implement a coroutine exercise demonstrating errorStage.
    // TODO: Use runBlocking to make it testable. Topic: Pipeline processing.
    // TODO: Return a verifiable result of type String.
    fun exercise3_errorStage(): String = TODO()

    // Exercise 4: batchStage
    // TODO: Implement a coroutine exercise demonstrating batchStage.
    // TODO: Use runBlocking to make it testable. Topic: Pipeline processing.
    // TODO: Return a verifiable result of type String.
    fun exercise4_batchStage(): String = TODO()

    // Exercise 5: monitorStage
    // TODO: Implement a coroutine exercise demonstrating monitorStage.
    // TODO: Use runBlocking to make it testable. Topic: Pipeline processing.
    // TODO: Return a verifiable result of type String.
    fun exercise5_monitorStage(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_multiStage() == true) { "Exercise 1 failed" }
        assert(exercise2_parallelStage().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_errorStage().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_batchStage().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_monitorStage().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro098_PipelineProcessing exercises passed!")
    }
}
