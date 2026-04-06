package org.shev4ik.interview.coroutines.level1_basics

/**
 * Parallel decomposition
 */
object Coro029_ParallelDecomp {

    // Exercise 1: parallelTasks
    // TODO: Implement a coroutine exercise demonstrating parallelTasks.
    // TODO: Use runBlocking to make it testable. Topic: Parallel decomposition.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise1_parallelTasks(): List<Int> = TODO()

    // Exercise 2: awaitAll
    // TODO: Implement a coroutine exercise demonstrating awaitAll.
    // TODO: Use runBlocking to make it testable. Topic: Parallel decomposition.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise2_awaitAll(): List<Int> = TODO()

    // Exercise 3: parallelMap
    // TODO: Implement a coroutine exercise demonstrating parallelMap.
    // TODO: Use runBlocking to make it testable. Topic: Parallel decomposition.
    // TODO: Return a verifiable result of type List<Int>.
    fun exercise3_parallelMap(): List<Int> = TODO()

    // Exercise 4: race
    // TODO: Implement a coroutine exercise demonstrating race.
    // TODO: Use runBlocking to make it testable. Topic: Parallel decomposition.
    // TODO: Return a verifiable result of type String.
    fun exercise4_race(): String = TODO()

    // Exercise 5: firstCompleted
    // TODO: Implement a coroutine exercise demonstrating firstCompleted.
    // TODO: Use runBlocking to make it testable. Topic: Parallel decomposition.
    // TODO: Return a verifiable result of type String.
    fun exercise5_firstCompleted(): String = TODO()

    @JvmStatic
    fun main(args: Array<String>) {
        assert(exercise1_parallelTasks().isNotEmpty()) { "Exercise 1 failed" }
        assert(exercise2_awaitAll().isNotEmpty()) { "Exercise 2 failed" }
        assert(exercise3_parallelMap().isNotEmpty()) { "Exercise 3 failed" }
        assert(exercise4_race().isNotEmpty()) { "Exercise 4 failed" }
        assert(exercise5_firstCompleted().isNotEmpty()) { "Exercise 5 failed" }
        println("All Coro029_ParallelDecomp exercises passed!")
    }
}
