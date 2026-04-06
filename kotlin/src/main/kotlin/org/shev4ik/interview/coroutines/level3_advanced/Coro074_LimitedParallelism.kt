package org.shev4ik.interview.coroutines.level3_advanced

/**
 * Limited parallelism
 */
object Coro074_LimitedParallelism {

    // Exercise 1: ioLimited
    // TODO: Implement a coroutine exercise demonstrating ioLimited.
    // TODO: Use runBlocking to make it testable. Topic: Limited parallelism.
    // TODO: Return a verifiable result of type String.
    fun exercise1_ioLimited(): String = TODO()

    // Exercise 2: cpuLimited
    // TODO: Implement a coroutine exercise demonstrating cpuLimited.
    // TODO: Use runBlocking to make it testable. Topic: Limited parallelism.
    // TODO: Return a verifiable result of type String.
    fun exercise2_cpuLimited(): String = TODO()

    // Exercise 3: customLimited
    // TODO: Implement a coroutine exercise demonstrating customLimited.
    // TODO: Use runBlocking to make it testable. Topic: Limited parallelism.
    // TODO: Return a verifiable result of type String.
    fun exercise3_customLimited(): String = TODO()

    // Exercise 4: viewLimited
    // TODO: Implement a coroutine exercise demonstrating viewLimited.
    // TODO: Use runBlocking to make it testable. Topic: Limited parallelism.
    // TODO: Return a verifiable result of type String.
    fun exercise4_viewLimited(): String = TODO()

    // Exercise 5: sharedPool
    // TODO: Implement a coroutine exercise demonstrating sharedPool.
    // TODO: Use runBlocking to make it testable. Topic: Limited parallelism.
    // TODO: Return a verifiable result of type String.
    fun exercise5_sharedPool(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_ioLimited().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_cpuLimited().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_customLimited().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_viewLimited().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_sharedPool().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro074_LimitedParallelism exercises passed!")
    }
}
