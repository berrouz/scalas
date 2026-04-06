package org.shev4ik.interview.coroutines.level2_intermediate

/**
 * Channel pipeline pattern
 */
object Coro039_ChannelPipelines {

    // Exercise 1: simplePipeline
    // TODO: Implement a coroutine exercise demonstrating simplePipeline.
    // TODO: Use runBlocking to make it testable. Topic: Channel pipeline pattern.
    // TODO: Return a verifiable result of type String.
    fun exercise1_simplePipeline(): String = TODO()

    // Exercise 2: filterPipeline
    // TODO: Implement a coroutine exercise demonstrating filterPipeline.
    // TODO: Use runBlocking to make it testable. Topic: Channel pipeline pattern.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_filterPipeline(): List<Int> = TODO()

    // Exercise 3: mapPipeline
    // TODO: Implement a coroutine exercise demonstrating mapPipeline.
    // TODO: Use runBlocking to make it testable. Topic: Channel pipeline pattern.
    // TODO: Return a verifiable result of type Map<String, Int>.
    fun exercise3_mapPipeline(): Map<String, Int> = TODO()

    // Exercise 4: stagePipeline
    // TODO: Implement a coroutine exercise demonstrating stagePipeline.
    // TODO: Use runBlocking to make it testable. Topic: Channel pipeline pattern.
    // TODO: Return a verifiable result of type String.
    fun exercise4_stagePipeline(): String = TODO()

    // Exercise 5: backpressure
    // TODO: Implement a coroutine exercise demonstrating backpressure.
    // TODO: Use runBlocking to make it testable. Topic: Channel pipeline pattern.
    // TODO: Return a verifiable result of type String.
    fun exercise5_backpressure(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_simplePipeline().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_filterPipeline().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_mapPipeline().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_stagePipeline().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_backpressure().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro039_ChannelPipelines exercises passed!")
    }
}
