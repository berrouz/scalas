package org.shev4ik.interview.coroutines.level1_basics

/**
 * Default dispatcher details
 */
object Coro032_DispatcherDefault {

    // Exercise 1: cpuBound
    // TODO: Implement a coroutine exercise demonstrating cpuBound.
    // TODO: Use runBlocking to make it testable. Topic: Default dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise1_cpuBound(): String = TODO()

    // Exercise 2: parallelism
    // TODO: Implement a coroutine exercise demonstrating parallelism.
    // TODO: Use runBlocking to make it testable. Topic: Default dispatcher details.
    // TODO: Return a verifiable result of type Boolean.
    fun exercise2_parallelism(): Boolean = TODO()

    // Exercise 3: sharedPool
    // TODO: Implement a coroutine exercise demonstrating sharedPool.
    // TODO: Use runBlocking to make it testable. Topic: Default dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise3_sharedPool(): String = TODO()

    // Exercise 4: defaultVsIO
    // TODO: Implement a coroutine exercise demonstrating defaultVsIO.
    // TODO: Use runBlocking to make it testable. Topic: Default dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise4_defaultVsIO(): String = TODO()

    // Exercise 5: heavyComputation
    // TODO: Implement a coroutine exercise demonstrating heavyComputation.
    // TODO: Use runBlocking to make it testable. Topic: Default dispatcher details.
    // TODO: Return a verifiable result of type String.
    fun exercise5_heavyComputation(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_cpuBound().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_parallelism() == true) { "Exercise 2 failed" }
        assert(exercise3_sharedPool().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_defaultVsIO().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_heavyComputation().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro032_DispatcherDefault exercises passed!")
    }
}
