package org.shev4ik.interview.coroutines.level1_basics

/**
 * IO dispatcher details
 */
object Coro031_DispatcherIO {

    // Exercise 1: ioBasic
    // TODO: Implement a coroutine exercise demonstrating ioBasic.
    // TODO: Use runBlocking to make it testable. Topic: IO dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise1_ioBasic(): String = TODO()

    // Exercise 2: limitedParallelism
    // TODO: Implement a coroutine exercise demonstrating limitedParallelism.
    // TODO: Use runBlocking to make it testable. Topic: IO dispatcher details.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_limitedParallelism(): Boolean = TODO()

    // Exercise 3: ioThreadPool
    // TODO: Implement a coroutine exercise demonstrating ioThreadPool.
    // TODO: Use runBlocking to make it testable. Topic: IO dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise3_ioThreadPool(): String = TODO()

    // Exercise 4: blockingIO
    // TODO: Implement a coroutine exercise demonstrating blockingIO.
    // TODO: Use runBlocking to make it testable. Topic: IO dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise4_blockingIO(): String = TODO()

    // Exercise 5: ioVsDefault
    // TODO: Implement a coroutine exercise demonstrating ioVsDefault.
    // TODO: Use runBlocking to make it testable. Topic: IO dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise5_ioVsDefault(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_ioBasic().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_limitedParallelism() == true) { "Exercise 2 failed" }
        assert(exercise3_ioThreadPool().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_blockingIO().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_ioVsDefault().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro031_DispatcherIO exercises passed!")
    }
}
