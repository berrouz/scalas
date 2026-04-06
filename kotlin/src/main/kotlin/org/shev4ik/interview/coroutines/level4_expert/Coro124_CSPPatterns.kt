package org.shev4ik.interview.coroutines.level4_expert

/**
 * CSP communicating processes
 */
object Coro124_CSPPatterns {

    // Exercise 1: cspChannel
    // TODO: Implement a coroutine exercise demonstrating cspChannel.
    // TODO: Use runBlocking to make it testable. Topic: CSP communicating processes.
    // TODO: Return a verifiable result of type String.
    fun exercise1_cspChannel(): String = TODO()

    // Exercise 2: processPipeline
    // TODO: Implement a coroutine exercise demonstrating processPipeline.
    // TODO: Use runBlocking to make it testable. Topic: CSP communicating processes.
    // TODO: Return a verifiable result of type String.
    fun exercise2_processPipeline(): String = TODO()

    // Exercise 3: selectiveReceive
    // TODO: Implement a coroutine exercise demonstrating selectiveReceive.
    // TODO: Use runBlocking to make it testable. Topic: CSP communicating processes.
    // TODO: Return a verifiable result of type String.
    fun exercise3_selectiveReceive(): String = TODO()

    // Exercise 4: guardedCommand
    // TODO: Implement a coroutine exercise demonstrating guardedCommand.
    // TODO: Use runBlocking to make it testable. Topic: CSP communicating processes.
    // TODO: Return a verifiable result of type String.
    fun exercise4_guardedCommand(): String = TODO()

    // Exercise 5: altPattern
    // TODO: Implement a coroutine exercise demonstrating altPattern.
    // TODO: Use runBlocking to make it testable. Topic: CSP communicating processes.
    // TODO: Return a verifiable result of type String.
    fun exercise5_altPattern(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cspChannel().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_processPipeline().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_selectiveReceive().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_guardedCommand().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_altPattern().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro124_CSPPatterns exercises passed!")
    }
}
